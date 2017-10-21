public class BinaryTree {
    public Node root;
    private int tam;
    public BinaryTree(){
        root = null;
    }

    private int max2(int i, int j)
    {
        if (i > j)
            return i;
        return j;
    }

    private int maxheightAUX(Node node)
    {
        if (node == null)
            return 0;
        else 
            return max2(maxheightAUX(node.left), maxheightAUX(node.right))+1;
    }

    public int maxheight()
    {
        return maxheightAUX(root);
    }

    private void recursivePrintAUX(Node node)
    {
        if (node != null)
        {
            recursivePrintAUX(node.left);
            recursivePrintAUX(node.right);
            System.out.println(node.nombre);
        }

    }

    public void recursivePrint()
    {
        recursivePrintAUX(root);
    }
    /** Inserta un nuevo miembro al árbil genealógico*/
    public void insertar(String nombre, boolean esHombre){
        Node n = new Node(nombre, esHombre);
        if(root == null){
            root = n;
            tam++;
        } else {
            insertarAux(n, root);
        }
    }

    public void insertar(Node n){
        if(root == null){
            root = n;
            tam++;
        } else {
            if(n.hijo == null){
                insertarAux(n, root);
            } else {
                Node h = buscar(n.hijo.nombre);
                insertarAux(n, h);
            }
        }
    }

    private void insertarAux(Node n, Node nodo){
        if(n.hombre){
            nodo.right = n;
            tam++;
        } else {
            nodo.left = n;
            tam++;
        }
    }
    /** Retorna el nnumero de elementos en el árbol*/
    public int getTam(){
        return tam;
    }
    /** Busca y retorna un elemento*/
    public Node buscar(String n){
        return buscarAux(n, root);
    }

    private Node buscarAux(String n, Node nodo){
        if(nodo == null){
            return nodo;
        }
        if(nodo.nombre.equals(n)){
            return nodo;
        } else {
            Node der = buscarAux(n, nodo.right);
            Node izq = buscarAux(n, nodo.left);
            if(der != null && izq == null){
                return der;
            } else if (der == null && izq != null){
                return izq;
            } else {
                return null;
            }
        }
    }
    /**Busca y retorna nombre de abuela materna */
    public String getGrandMothersName(String s){
        Node n = buscar(s);
        if(n != null && n.left != null && n.left.left != null){
            return ("La abuela de " + s + " es " + n.left.left.nombre);
        } else {
            return "";
        }
    }
}
