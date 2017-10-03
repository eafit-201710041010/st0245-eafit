import java.lang.Math;
/**
 * Esta clase sigue en construcción, funciona mas no hace las rotaciones
 * La estructura está ya realizada pero aun no se ha implementado en código
 * Se entrega sección de código adelantada hasta el momento
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AVL
{
    Nodo raiz;
    
    public AVL(){
    }
    
    public int diferenciaAltura(Nodo n){
        return altura(n.der) - altura(n.izq);
    }
    private int altura(Nodo n){
        if (n == null){
            return -1;
        }
        else{
            return Math.max(altura(n.der), altura(n.izq)) + 1;
        }
    }
    
    public void insertar(Nodo nuevo) { 
        if(raiz == null){
            raiz = nuevo;
        } else {
            try{
                insertar(nuevo, raiz);
            } catch (Exception e){}
        }
    }
    private void insertar(Nodo nuevo, Nodo padre) throws Exception {
        if(nuevo.tam > padre.tam){
            try{
                insertar(nuevo, padre.der);
            } catch (Exception e){
                padre.der = nuevo;
                nuevo.pad = padre;
            }
        } else {
            try{
                insertar(nuevo, padre.izq);
            } catch (Exception e){
                nuevo.pad = padre;
                padre.izq = nuevo;
            }
        }
        Nodo base = revisarPadre(nuevo);
        if (base == null){
            return;
        }
        if (ll(nuevo)){
            rotarll(nuevo);
        } else if(rr(nuevo)){
            rotarrr(nuevo);
        } else if(lr(nuevo)){
            rotarlr(nuevo);
        } else if(rl(nuevo)){
            rotarrl(nuevo);
        }
    }
    
    boolean ll(Nodo n){
        if(n.der == null && n.izq.der == null) return true;
        return false;
    }
    boolean rr(Nodo n){
        if(n.izq == null && n.der.izq == null) return true;
        return false;
    }
    boolean lr(Nodo n){
        if(n.der == null && n.izq.izq == null) return true;
        return false;
    }
    boolean rl(Nodo n){
        if(n.izq == null && n.der.der == null) return true;
        return false;
    }
    
    void rotarll(Nodo n){
        if (n.pad.izq == n){
            n.pad.izq = n.izq;
            n.izq.pad = n.pad;
            n.pad = n.izq;
            n.pad.der = n;
        } else {
            n.pad.der = n.izq;
            n.izq.pad = n.pad;
            n.pad = n.izq;
            n.pad.der = n;
        }
    }
    void rotarrr(Nodo n){
        //Rotación derecha derecha
    }
    void rotarlr(Nodo n){
        //Rotación izquierda derecha
    }
    void rotarrl(Nodo n){
        //Rotación derecha izquierda}
    }
    
    Nodo revisarPadre(Nodo n){
        if(n == null){
            return null;
        }
        if (diferenciaAltura(n) < -1 || diferenciaAltura(n) > 1){
            return n;
        } else {
            return revisarPadre(n.pad);
        }
    }
    
    
    public static void main(String [] args) {
        Nodo n17 = new Nodo(17, "");
        Nodo n13 = new Nodo(13, "");
        Nodo n10 = new Nodo(10, "");
        Nodo n6 = new Nodo(6, "");
        Nodo n5 = new Nodo(5, "");
        Nodo n4 = new Nodo(4, "");
        Nodo n3 = new Nodo(3, "");
        Nodo n2 = new Nodo(2, "");
        AVL avl = new AVL();
        
        avl.insertar(n10);
        avl.insertar(n13);
        avl.insertar(n17);
        avl.insertar(n5);
        avl.insertar(n4);
        avl.insertar(n3);
        avl.insertar(n6);
        avl.insertar(n2);
        
        System.out.println(avl.diferenciaAltura(n2));
        System.out.println(avl.diferenciaAltura(n3));
        System.out.println(avl.diferenciaAltura(n4));
        System.out.println(avl.diferenciaAltura(n5));
        System.out.println(avl.diferenciaAltura(n6));
        System.out.println(avl.diferenciaAltura(n10));
    }
}
