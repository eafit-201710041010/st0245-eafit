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
                    System.out.println("\"" + nodo.nombre + "\" -> \"" + n.nombre + "\";");
                dibujarArbolAux(n);
            }
    }

    public static void main(String[] args) {
        //Crea el árbol familiar
        BinaryTree tree = new BinaryTree();
        Node jj = new Node("yo", true);
        Node le = new Node("mom", false, jj);
        Node dp = new Node("dad", true, jj);
        
        Node ld = new Node("mom's mom", false, le);
        Node jm = new Node("mom's dad", true, le);
        
        Node sh = new Node("dad's mom", false, dp);
        Node nn = new Node("dad's dad", true, dp);
        
        Node b1 = new Node("dad's mom's mom", false, sh);
        Node b2 = new Node("dad's mom's dad", true, sh);
        Node b3 = new Node("dad's dad's mom", false, nn);
        Node b4 = new Node("dad's dad's dad", true, nn);
        
        Node b5 = new Node("mom's mom's mom", false, ld);
        Node b6 = new Node("mom's mom's dad", true, ld);
        Node b7 = new Node("mom's dad's mom", false, jm);
        Node b8 = new Node("mom's dad's dad", true, jm);
        
        tree.insertar(jj);
        tree.insertar(dp);
        tree.insertar(le);
        tree.insertar(ld);
        tree.insertar(jm);
        tree.insertar(sh);
        tree.insertar(nn);
        tree.insertar(b1);
        tree.insertar(b2);
        tree.insertar(b3);
        tree.insertar(b4);
        tree.insertar(b5);
        tree.insertar(b6);
        tree.insertar(b7);
        tree.insertar(b8);
        
        //Imprime el árbol familiar
        tree.recursivePrint();

        //Dibuja el árbol familiar
        dibujarArbol(tree);
        
        
        //Busca un nombre
        System.out.println("Buscar miembro de nombre \"yo\"");
        if(tree.buscar("yo") == null){
            System.out.println("No se encontró");
        } else {
            System.out.println("Se encontró");
        }
        System.out.println("Buscar miembro de nombre \"No existo\"");
        if(tree.buscar("No existo") == null){
            System.out.println("No se encontró");
        } else {
            System.out.println("Se encontró");
        }
        
        //Tamaño del arbol
        System.out.println("El número de miembros en el árbol debería ser 15. Hay: " + tree.getTam());
        //Altura del árbol
        System.out.println("La altura del árbol debería ser 4. Es " + tree.maxheight());
        
    }
}