package com.company;

import java.io.*;

public class BinaryTree {
    private final Node root;
    private Node current;
    private int treeHeight;
    private int melyseg, maxMelyseg, atlagosszeg, atlagdb, elemszam, egyes;
    private double atlag, szorasosszeg, szoras;

    public BinaryTree() {
        this.root = new Node('#');
        this.current = root;

    }

    public Node getRoot() {
        return this.root;
    }

    private void setCurrent(Node current) {
        this.current = current;
    }

    public void addItem(char newItem) {
        if (newItem == '0') {
            if (current.left() == null) {
                current.setLeft(new Node('0'));
                setCurrent(root);
            } else {
                setCurrent(current.left());
            }
        }

        if (newItem == '1') {
            if (current.right() == null) {
                current.setRight(new Node('1'));
                setCurrent(root);
            } else {
                setCurrent(current.right());
            }
        }

    }

    public int getMelyseg() {
        melyseg = maxMelyseg = 0;
        rMelyseg(getRoot());
        return --maxMelyseg;
    }

    private void rMelyseg(Node item) {
        if (item != null) {
            ++melyseg;
            if (melyseg > maxMelyseg)
                maxMelyseg = melyseg;

            rMelyseg(item.left());
            rMelyseg(item.right());

            --melyseg;
        }
    }

    public double getAtlag() {
        atlagdb = atlagosszeg = melyseg = 0;
        rAtlag(getRoot());
        atlag = (double) atlagosszeg / atlagdb;

        return atlag;
    }

    private void rAtlag(Node item) {
        if (item != null) {
            melyseg++;
            rAtlag(item.left());
            rAtlag(item.right());
            melyseg--;

            if (item.left() == null && item.right() == null) {
                atlagdb++;
                atlagosszeg += melyseg;
            }

        }
    }

    public double getSzoras() {
        atlag = getAtlag();

        szorasosszeg = 0.0;
        atlagdb = melyseg = 0;

        rSzoras(getRoot());

        if (atlagdb - 1 > 0)
            szoras = Math.sqrt(szorasosszeg / (atlagdb - 1));
        else
            szoras = Math.sqrt(szorasosszeg);

        return szoras;
    }

    private void rSzoras(Node item) {
        if (item != null) {
            ++melyseg;
            rSzoras(item.left());
            rSzoras(item.right());
            --melyseg;

            if (item.left() == null && item.right() == null) {
                atlagdb++;
                szorasosszeg += Math.pow((melyseg - atlag), 2);
            }
        }
    }

    public double getElemszamAtlag() {
        egyes = 0;
        elemszam = 0;
        relemszam(getRoot());
        return (double) egyes / elemszam;
    }

    private void relemszam(Node item) {
        if (item != null) {

            relemszam(item.right());
            relemszam(item.left());

            if (item.right() != null) {
                ++elemszam;
                ++egyes;
            }
            if (item.left() != null) {
                ++elemszam;

            }
        }
    }

    public void traverse(Node root) {
        if (root != null) {
            traverse(root.left());
            System.out.print(root.getValue());
            traverse(root.right());

        }
    }

    public void writeOut(Node n, PrintWriter out) {
        if (n != null) {
            ++treeHeight;

            writeOut(n.left(), out);

            for (int i = 0; i < treeHeight; i++) {
                out.print(" ");
            }

            out.println(n.getValue() + " (" + (treeHeight - 1) + ")");
            writeOut(n.right(), out);
            --treeHeight;
        }
    }

    private class Node {

        Node rightLink = null;
        Node leftLink = null;
        char value;

        Node(char value) {
            this.value = value;
        }

        char getValue() {
            return value;
        }

        Node right() {
            return this.rightLink;
        }

        void setRight(Node item) {
            this.rightLink = item;

        }

        Node left() {
            return this.leftLink;
        }

        void setLeft(Node item) {
            this.leftLink = item;

        }

    }

}
