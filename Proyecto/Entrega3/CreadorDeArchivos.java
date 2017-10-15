
public class CreadorDeArchivos
{
    Archivo[] jerarquias;

    public CreadorDeArchivos(){
        jerarquias = new Archivo[100];
    }

    public Archivo leerLinea(String linea){
        String size = "";
        String nombre = "";
        int distancia = 0;

        String[] info = linea.split(" ");
        for(int i = 0; i < info.length; i++){
            if(info[i].contains("]") && i != info.length-1){
                String tam = info[i];
                size = tam.substring(0, tam.length()-1);
            }
            try{
                while(linea.charAt(distancia) != '['){
                    distancia++;
                }
                distancia /= 4;
            } catch (Exception e){
                return null;
            }
        }
        for (int i = 0; i < linea.length(); i++){
            if(linea.charAt(i) == ']' &&  i != linea.length()-1){
                nombre = linea.substring(i+3);
            }
        }
        Archivo a;
        a = new Archivo(size, nombre, jerarquias[distancia-1]);
        jerarquias[distancia] = a;
        return a;
    }

    public void leerEncabezado(String linea){
        jerarquias[0] = new Archivo("", linea);
    }
}
