public class Laboratorio5 {

    public static void dibujarArbol(BinaryTree a)
    {
        System.out.println("/* arbolito para http://www.webgraphviz.com/ */"); 
        System.out.println("digraph arbolito {");
        System.out.println("size=\"6,6\";");
        System.out.println("node [color=aquamarine, style=filled];");
        dibujarArbolAux(a.root);
        System.out.println("}");
    }

    public static void dibujarArbolAux(Node nodo)
    {
        if (nodo != null)
        //"x_\n__" -> "xo\n__";
            for(Node n: new Node[] {nodo.left, nodo.right} ){
                if (n != null)
                    System.out.println("\"" + nodo.data + "\" -> \"" + n.data + "\";");
                dibujarArbolAux(n);
            }
    }

    public static void main(String[] args) {
        //Crea el árbol familiar
        BinaryTree tree = new BinaryTree();
        tree.insertar(40);
        tree.insertar(20);
        tree.insertar(30);
        tree.insertar(10);
        tree.insertar(60);
        tree.insertar(50);
        tree.insertar(70);
        tree.insertar(80);
        tree.insertar(00);
        tree.insertar(05);
        tree.insertar(15);
        tree.insertar(25);
        tree.insertar(35);
        tree.insertar(45);
        tree.insertar(55);
        tree.insertar(65);

        System.out.println(tree.buscar(3));
        System.out.println(tree.buscar(99));
        //Imprime el árbol familiar
        tree.recursivePrint();

        //Dibuja el árbol familiar
        dibujarArbol(tree);
    }
}