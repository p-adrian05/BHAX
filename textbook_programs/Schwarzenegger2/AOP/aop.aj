

public aspect aop
{
	int treeHeight = 0;
	
	pointcut traverse(BinaryTree.Node node): call(* BinaryTree.writeOut(BinaryTree.Node)) && args(node);
	
	
	after(BinaryTree.Node node):traverse(node){
		writeOutPre(node);
		writeOutPost(node);
	}

	 public void writeOutPre(BinaryTree.Node node){
        if(node != null)
        {
            ++treeHeight;

          
            for(int i = 0; i < treeHeight; i++){
                System.out.print(" ");
            }

            System.out.println(node.getValue() + " (" + (treeHeight-1) + ")"+"\n");
            writeOutPre(node.left());
            writeOutPre(node.right());
            --treeHeight;
        }
    }
	 public void writeOutPost(BinaryTree.Node node){
        if(node != null)
        {
            ++treeHeight;

            writeOutPost(node.left());
            writeOutPost(node.right());
            for(int i = 0; i < treeHeight; i++){
                System.out.print(" ");
            }

            System.out.println(node.getValue() + " (" + (treeHeight-1) + ")"+"\n");
          
            --treeHeight;
        }
    }
}
