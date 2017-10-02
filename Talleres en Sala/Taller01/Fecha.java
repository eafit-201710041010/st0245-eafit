
/**
 * Write a description of class Fecha here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fecha
{
    private int año;
    private int mes;
    private int dia;
    
    public Fecha(int year, int month, int day){
        año = year;
        mes = month;
        dia = day;
    }
    
    public int año(){
        return año;
    }
    
    public int mes(){
        return mes;
    }
    
    public int dia(){
        return dia;
    }
    
    public String toString(){
        return "Hoy es " + dia + " de " + mes + " de " + año;
    }
    
    public boolean equals(Fecha f){
        if (f.año == año && f.mes == mes && f.dia == dia){
            return true;
        }
        return false;
    }
    
    public String compareTo(Fecha f){
        if(f.año == año){
            if(f.mes == mes){
                if(f.dia == dia){
                    return "Igual";
                } else if (dia > f.dia) {
                    return "Después";
                }
            } else if (mes > f.mes){
                return "Después";
            }
        } else if (año > f.año){
            return "Después";
        }
        return "Antes";
    }
}
