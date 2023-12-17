
import java.io.PrintWriter;
import java.util.Scanner;


public class practica07_b{
    static String[] desc=new String[100], nf=new String[100], ci=new String[100], fecha=new String[100];
    static int[] ct=new int[100], dd=new int[100], mm=new int[100], aaaa=new int[100];
    static float[] mu=new float[100];
    static  Scanner sc = new Scanner(System.in);
    static Scanner sc2 = new Scanner(System.in);
    static int contador_equipo=-1;

    public static void GenerarReporte(){
        Scanner reporte= new Scanner(System.in);
        String ci_consola;
        int  equipos=0;
        float total_bs=0;
        System.out.println("Indique su C.I.: ");
        ci_consola=reporte.nextLine();

        for(int i=0 ; i<=contador_equipo ; i++){
            if(ci_consola.equals(ci[i])){
                total_bs=total_bs+mu[i];
                equipos++;
            }
        }
        System.out.println("Total de equipos: " + equipos);
        System.out.println("Monto total: " + total_bs);
        reporte.close();
    }
    public static void AgregarData(PrintWriter file){
    
        System.out.println("Ingrese data del equipo");
        System.out.print("Descripcion: ");
        desc[contador_equipo]= sc2.nextLine();
        file.println(desc[contador_equipo]);

        System.out.print("Cantidad: ");
        ct[contador_equipo]=sc.nextInt();
        file.println(ct[contador_equipo]);

        System.out.print("Costo Unitario (Bs): ");
        mu[contador_equipo]=sc.nextFloat();
        file.println(mu[contador_equipo]);

        System.out.print("Fecha de adquisicion: ");
        fecha[contador_equipo]= sc2.nextLine();
        file.println(fecha[contador_equipo]);

        String dia=fecha[contador_equipo].substring(0, 2);
        String mes=fecha[contador_equipo].substring(3, 5);
        String anio=fecha[contador_equipo].substring(6, 10);
        dd[contador_equipo]=Integer.parseInt(dia);
        while(dd[contador_equipo]<0 || dd[contador_equipo]>31){
            System.out.println("Error al ingresar el dia, ingrese de nuevo: ");
            dd[contador_equipo]=sc.nextInt();
        }
        mm[contador_equipo]=Integer.parseInt(mes);
        while(mm[contador_equipo]<0 || mm[contador_equipo]>12){
            System.out.println("Error al ingresar el mes, ingrese de nuevo: ");
            mm[contador_equipo]=sc.nextInt();
        }
        aaaa[contador_equipo]=Integer.parseInt(anio);
        while(aaaa[contador_equipo]<1968 || aaaa[contador_equipo]>2024){
            System.out.println("Error al ingresar el anio, ingrese de nuevo: ");
            aaaa[contador_equipo]=sc.nextInt();
        }
        
        System.out.print("Nro. de Factura: ");
        nf[contador_equipo]= sc2.nextLine();
        file.println(nf[contador_equipo]);

        System.out.print("C.I. del Responsable del Equipo: ");
        ci[contador_equipo]=sc2.nextLine();
        file.println(ci[contador_equipo]);
        

    }
    public static void main(String[] args) throws Exception{
        PrintWriter file= new PrintWriter("practica07_b.txt");
        Boolean agregar=true, reporte=true;
        Scanner lector = new Scanner(System.in);
        while(agregar){
            String s="s", opcion;
            contador_equipo++;
            AgregarData(file);
            System.out.println(" ");
            System.out.print("Desea agregar nueva data (s/n): ");
            opcion=lector.nextLine();
            if(!opcion.equals(s)){
                agregar=false;
            }
            System.out.println(" ");
        }

        while(reporte){
            String s="s", opcion;
            System.out.println(" ");
            System.out.print("Desea generar reporte (s/n): ");
            opcion=lector.nextLine();
            if(!opcion.equals(s)){
                reporte=false;
            }else{
                GenerarReporte();
            }
            System.out.println(" ");
        }

        file.close();
        lector.close();
    }

}

    