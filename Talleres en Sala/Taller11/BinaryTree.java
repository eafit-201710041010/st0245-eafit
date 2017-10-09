public class BinaryTree {
    public Node root;

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
            System.out.println(node.data);
        }

    }

    public void recursivePrint()
    {
        recursivePrintAUX(root);
    }

    public void insertar(int n){
        if(root == null){
            root = new Node(n);;
        } else {
            insertarAux(n, root);
        }
    }

    private void insertarAux(int n, Node nodo){
        if(n > nodo.data){
            if(nodo.right == null){
                nodo.right = new Node(n);
            } else {
                insertarAux(n, nodo.right);
            }
        } else {
            if(nodo.left == null){
                nodo.left = new Node(n);
            } else {
                insertarAux(n, nodo.left);
            }
        }
    }

    public boolean buscar(int n){
        return buscarAux(n, root);
    }

    private boolean buscarAux(int n, Node nodo){
        if(nodo == null){
            return false;
        }
        if(nodo.data == n){
            return true;
        } else {
            return buscarAux(n, nodo.right) || buscarAux(n, nodo.left);
        }
    }

    public void borrar(int n){
        if(root.data == n){
            Node newRoot = root.right;
            Node hola = root.right;
            while(hola.left != null){
                hola = hola.left;
            }
            hola.left = root.left;
            root = newRoot;
        } else {
            borrarAux(n, root);
        }
    }

    private void borrarAux(int n, Node nodo){
        if((nodo.left == null && nodo.right == null)|| nodo == null){
            return;
        }
        if(nodo.right != null && nodo.right.data == n){
            Node chao = nodo.right;
            if(chao.left == null && chao.right == null){
                nodo.right = null;
            } else if (chao.left == null && chao.right != null){
                nodo.right = chao.right;
            } else if (chao.left != null && chao.right == null){
                nodo.right = chao.left;
            } else if (chao.left != null && chao.right != null){
                nodo.right = chao.left;
                Node hola = nodo.right;
                while(hola.right != null){
                    hola = hola.right;
                }
                hola.right = chao.right;
            }
            return;
        } else if (nodo.left != null && nodo.left.data == n){
            Node chao = nodo.left;
            if(chao.left == null && chao.right == null){
                nodo.left = null;
            } else if (chao.left == null && chao.right != null){
                nodo.left = chao.right;
            } else if (chao.left != null && chao.right == null){
                nodo.left = chao.left;
            } else if (chao.left != null && chao.right != null){
                nodo.left = chao.right;
                Node hola = nodo.left;
                while(hola.left != null){
                    hola = hola.left;
                }
                hola.left = chao.left;
            }
            return;
        } else if (nodo.left != null || nodo.right != null){
            borrarAux(n, nodo.left);
            borrarAux(n, nodo.right);
        }
    }
}