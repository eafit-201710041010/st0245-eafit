
public class CreadorDeArchivos
{
    Archivo[] jerarquias;

    public CreadorDeArchivos(){
        jerarquias = new Archivo[100];
    }

    public Archivo leerLinea(String linea){
        int size = 0;
        String nombre = "";
        int distancia = 0;

        String[] info = linea.split(" ");
        for(int i = 0; i < info.length; i++){
            if(info[i].contains("]") && i != info.length-1){
                String tam = info[i];
                String numero = tam.substring(0, tam.length()-1);
                if(numero.contains("M") || numero.contains("K") || numero.contains("G")){
                    int u;
                    char unidad = numero.charAt(numero.length()-1);
                    if(unidad == 'K'){
                        u = 1000;
                    } else if(unidad == 'M'){
                        u = 1000000;
                    } else {
                        u = 1000000000;
                    }
                    numero = numero.substring(0, numero.length()-1);
                    double ize = Double.parseDouble(numero) * u;
                    size = (int)ize;
                } else {
                    double ize = Double.parseDouble(numero);
                    size = (int)ize;
                }
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
        jerarquias[0] = new Archivo(0, linea);
    }
}
