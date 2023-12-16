import java.util.Scanner;

public class practica07_a {
    public static Boolean isElementOf(int[] array,int num, int z){
        for(int i=0 ; i<num ; i++){
            if(array[i]==z){
                System.out.println("Se encontro "+z+" en la posicion "+(i+1));
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        Scanner sc= new Scanner(System.in);
        System.out.println("Ingrese el tamanio del arreglo");
        int num= sc.nextInt();
        int[] array = new int[num];
        int j=0;
        while(j<num){
            System.out.println("Introduzca el numero para la posicion "+(j+1));
            array[j]=sc.nextInt();
            j++;
        }
        System.out.println("Ingrese el numero que desea buscar");
        int z=sc.nextInt();

        Boolean estaZ = isElementOf(array, num, z);
    
        if(estaZ==false){
            System.out.println("El numero NO se encuentra en el arreglo");
        }else{
            System.out.println("El numero SI esta en el arreglo");
        }
        

    }

}