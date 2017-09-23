import java.util.*;
public class Laboratory2 {
    /**
     * Returns the product of the numbers in the list. 
     * @param list - List of integers.
     * @return An integer.
     */
    public static int multiply(List<Integer> list) {
        if(list.size() == 0){
            return 1;
        } else {
            return list.get(0) * multiply(list.subList(1, list.size()));
        }
    }
    
    /**Smart Insert, agrega elementos solamente si no existen ya en la lista */
    public static void SmartInsert(List<Integer> list, int data){
        if(!(list.contains(data))){
            list.add(data);
            System.out.println("Se insertó");
        } else {
            System.out.println("Ya está");
        }
    }
    
    /**Pivote, Elige cual es el punto óptimo para balancear una serie de pesos */
    public static int pivote(List<Integer> list){
        int pos = 0;
        int minDif = 0;
        for(int i = 0; i < list.size(); i++){
            int izq = 0;
            int der = 0;
            for(int j = 0; j <= i; j++){
                izq += list.get(j);
            }
            for(int j = i; j < list.size(); j++){
                der += list.get(j);
            }
            int dif = (der - izq) * (der - izq);
            if(i == 0 || dif < minDif) {
                minDif = dif;
                pos = i;
            }
        }
        return pos;
    }
    /**
     * Ejercicio4, Recibe inventario de neveras y orden de solicitudes, y con ellos realiza
     * pedidos e imprime cuantos elementos fueron entregados a cada quien 
     */
    public static void ejercicio4(List<Nevera> neveras, List<Solicitud> solicitudes){
        for(int i = 0; i < solicitudes.size(); i++){
            int pedidos = solicitudes.get(i).cantidad;
            Entrega entrega = new Entrega(solicitudes.get(i));
            for(int j = pedidos; j > 0; j--){
                try{
                    entrega.add(neveras.remove(neveras.size()-1));
                } catch (Exception e){
                    System.out.println("No hay inventario para completar la siguiente entrega: " + solicitudes.get(i).nombre);
                }
            }
            System.out.println(entrega);
        }
    }

    /**
     * Tests the methods
     * @param args
     */
    public static void main(String[] args) {
        LinkedList<Integer> linked = new LinkedList<>();
        linked.addAll(Arrays.asList(new Integer[] {1, 3, 5, 7}));

        ArrayList<Integer> array = new ArrayList<>();
        array.addAll(Arrays.asList(new Integer[] {2, 4, 6, 8}));

        //Multiply
        System.out.println(multiply(linked));
        System.out.println(multiply(array));

        //SmartInsert
        SmartInsert(linked, 1);
        SmartInsert(array, 1);

        SmartInsert(linked, 2);
        SmartInsert(array, 2);

        //Pivote
        System.out.println(pivote(linked));
        System.out.println(pivote(array));

        //Neveras
        Nevera n1 = new Nevera(1, "haceb");
        Nevera n2 = new Nevera(2, "lg");
        Nevera n3 = new Nevera(3, "ibm");
        Nevera n4 = new Nevera(4, "haceb");
        Nevera n5 = new Nevera(5, "lg");
        Nevera n6 = new Nevera(6, "ibm");
        Nevera n7 = new Nevera(7, "haceb");
        Nevera n8 = new Nevera(8, "lg");
        Nevera n9 = new Nevera(9, "ibm");
        Nevera n10 = new Nevera(10, "haceb");
        Nevera n11= new Nevera(11, "lg");
        Nevera n12 = new Nevera(12, "ibm");
        Nevera n13 = new Nevera(13, "haceb");
        Nevera n14 = new Nevera(14, "lg");
        Nevera n15 = new Nevera(15, "ibm");
        
        Solicitud s1 = new Solicitud(4, "exito");
        Solicitud s2 = new Solicitud(4, "jumbo");
        Solicitud s3 = new Solicitud(6, "olimpica");
        Solicitud s4 = new Solicitud(2, "carulla");

        LinkedList<Nevera> neveras = new LinkedList<>();
        neveras.addAll(Arrays.asList(new Nevera[] {n1, n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, n12, n13, n14, n15}));

        LinkedList<Solicitud> solicitudes = new LinkedList<>();
        solicitudes.addAll(Arrays.asList(new Solicitud[] {s1, s2, s3, s4}));
        
        ejercicio4(neveras, solicitudes);
    }

}