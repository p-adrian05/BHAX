import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BinaryTreeTest {
	BinaryTree tree= new BinaryTree();
	String testInput= "01111001001001000111";
	@Test
	void test() {
		for(int i=0;i<testInput.length();i++) {
			tree.addItem(testInput.charAt(i));
		}
		
		assertEquals(2.75, tree.getAtlag(),0.01);
		assertEquals(4, tree.getMelyseg(),0.001);
		assertEquals(0.957427, tree.getSzoras(),0.00001);
	}

}
