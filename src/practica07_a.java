import java.util.Scanner;

public class practica07_a {

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
        int z=sc.nextInt(), i=0;

        while(i<num){
            if(array[i]==z){
                System.out.println("Se encontro "+z+" en la posicion "+i);
                return;
            }
            i++;
            if(i+1==num){
                System.out.println("El numero no se encuentra en el arreglo");
            }
        }

    }

}