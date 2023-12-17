import java.util.Scanner;

public class practica07_a {
    public static Boolean isElementOf(String[] array,int num, String z){
        for(int i=0 ; i<num ; i++){
            if(array[i].equals(z)){
                return true;
            }
        }
        return false;
    }
    public static void RellenarArreglo(String[] array, int num, Boolean relleno){
        Scanner sc= new Scanner(System.in);
        for(int j=0 ; j<num ; j++){
            if(relleno){
                System.out.println("Introduzca el numero para la posicion "+(j+1));
                array[j]=sc.nextLine();
            }else{
                array[j]=null;
            }
            
        }
        sc.close();
    }

    public static void main(String[] args) throws Exception {
        Scanner sc= new Scanner(System.in);
        Scanner rellenar=new Scanner(System.in);
        Scanner z=new Scanner(System.in);
        System.out.println("Ingrese el tamanio del arreglo");
        
        int num= sc.nextInt();
        String[] array = new String[num];
        
        System.out.println("Desea rellenar el arreglo (s/n)");
        String rellena= rellenar.next();
        Boolean relleno=false;
        String s="s";

        if(rellena.equals(s)){
            relleno=true;
        }

        RellenarArreglo(array, num, relleno);

        System.out.println("Ingrese el numero que desea buscar");
        
        String Numz =z.next();
        Boolean estaZ=false;
        
        if(relleno){
            estaZ = isElementOf(array, num, Numz);
        }

        if(!estaZ){
            System.out.println("El numero NO se encuentra en el arreglo");
        }else{
            System.out.println("El numero SI esta en el arreglo");
        }
        
        sc.close();
        rellenar.close();
        z.close();
    }

}