import javax.swing.*;

//import com.sun.tools.javac.jvm.Gen;

import java.awt.*;
import java.awt.event.*;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Scanner;


public class practica07_c extends JFrame {
    static String[] desc=new String[100], nf=new String[100], ci=new String[100], fecha=new String[100];
    static int[] ct=new int[100], dd=new int[100], mm=new int[100], aaaa=new int[100];
    static float[] mu=new float[100];
    static  Scanner sc = new Scanner(System.in);
    static Scanner sc2 = new Scanner(System.in);
    static int contador_equipo=-1;
    static int  equipos=0;
    static float total_bs=0;

    private static JTextField ci_resField = new JTextField();
    private static JTextField DescripcionField = new JTextField();
    private static JTextField CantidadField = new JTextField();
    private static JTextField CostoUniField = new JTextField();
    private static JTextField FechaAdquField = new JTextField();
    private static JTextField numFacturaField = new JTextField();
    private static JTextField ci_responsableField = new JTextField();

    public static JFrame ICentro = new JFrame("Registro y Control de Equipos en Centro de Investigacion");
    //public static JFrame IReporte = new JFrame("Reporte del Inventario del Centro de Investigacion");
    
    public static JRadioButton Individual = new JRadioButton("Individual", false);
    public static JRadioButton General = new JRadioButton("General",false);
    
    public static JPanel tipo_reporte = new JPanel();
    public static JPanel tipo_data = new JPanel();
    
    public static JLabel ciLabel = new JLabel("C.I. del Responsable de equipos: ");
    public static JLabel DescripcionLabel = new JLabel("Descripcion: ");
    public static JLabel CantidadLabel = new JLabel("Cantidad: ");
    public static JLabel CostoUniLabel = new JLabel("Costo Unitario (Bs.): ");
    public static JLabel FechaAdquiLabel = new JLabel("Fecha de adquisicion: dd/mm/aaaa");
    public static JLabel numFacturaLabel = new JLabel("Nro. de Factura: ");
    public static JLabel ci_responsableLabel = new JLabel("C.I. del Responsable de equipo: ");
    
    public static JButton botonTotalizar= new JButton("Totalizar");
    public static JButton botonContinuar= new JButton("Continuar");
    public static JButton botonGenerarReporte = new JButton("Generar Reporte");
    public static JButton botonRegistrarData = new JButton("Registrar Data");
    public static JButton botonSalir = new JButton("Salir");

    public static void AgregarData(PrintWriter file){
        desc[contador_equipo]= DescripcionField.getText();
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
        PrintWriter file= new PrintWriter("practica07_c.txt");
        ICentro.setSize(660,420);
        ICentro.setVisible(true);
        ICentro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ICentro.setLayout(null);
        ICentro.getContentPane().add(botonGenerarReporte);

        Container contenedor_ICentro = ICentro.getContentPane();
        JLabel headerLabel= new JLabel("Ingrese Data del equipo");
        ICentro.getContentPane().add(headerLabel);
        headerLabel.setBounds(10, 10, 200, 25);
        
        contenedor_ICentro.add(DescripcionLabel);
        contenedor_ICentro.add(DescripcionField);
        DescripcionField.setBounds(100, 50, 525, 25);
        DescripcionLabel.setBounds(10, 50, 200, 25);

        contenedor_ICentro.add(CantidadLabel);
        contenedor_ICentro.add(CantidadField);
        CantidadLabel.setBounds(10, 90, 100, 25);
        CantidadField.setBounds(100, 90, 50, 25);

        contenedor_ICentro.add(CostoUniLabel);
        contenedor_ICentro.add(CostoUniField);
        CostoUniLabel.setBounds(300, 90, 200, 25);
        CostoUniField.setBounds(425, 90, 200, 25);

        contenedor_ICentro.add(FechaAdquiLabel);
        contenedor_ICentro.add(FechaAdquField);
        FechaAdquiLabel.setBounds(10, 130, 200, 25);
        FechaAdquField.setBounds(150, 130, 120, 25);

        contenedor_ICentro.add(numFacturaLabel);
        contenedor_ICentro.add(numFacturaField);
        numFacturaLabel.setBounds(330, 130, 200, 25);
        numFacturaField.setBounds(435, 130, 190, 25);

        contenedor_ICentro.add(ci_responsableLabel);
        contenedor_ICentro.add(ci_responsableField);
        ci_responsableLabel.setBounds(10, 170, 400, 25);
        ci_responsableField.setBounds(200, 170, 120, 25);
        
        contenedor_ICentro.add(botonRegistrarData);
        botonRegistrarData.setBounds(335, 345, 100, 25);
        contenedor_ICentro.add(botonGenerarReporte);
        botonGenerarReporte.setBounds(445, 345, 108, 25);
        contenedor_ICentro.add(botonSalir);
        botonSalir.setBounds(565, 345, 60, 25);
        contenedor_ICentro.setLayout(new FlowLayout());
        //AgregarData(file);

        botonGenerarReporte.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                buttonClickGenerarReporte(e);
            }
        });
        botonSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                buttonClickSalir(e);
            }
        });
        
        botonTotalizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                buttonClickTotalizar(e);
            }
        });

        }
        public static void buttonClickTotalizar(ActionEvent e){
            String ci_ventana= ci_resField.getText();
            
            for(int i=0 ; i<=contador_equipo ; i++){
                if(ci_ventana.equals(ci[i])){
                    total_bs=total_bs+mu[i];
                    equipos++;
                }
            }

        }
    public static void buttonClickSalir(ActionEvent e){
        //IReporte.setDefaultCloseOperation(JFrame.ABORT);
        System.exit(0);
    }
    public static void buttonClickGenerarReporte(ActionEvent e){
        JFrame IReporte = new JFrame("Reporte del Inventario del Centro de Investigacion");
        IReporte.setSize(660,450);
        IReporte.setVisible(true);
        JLabel tipo_reportLabel = new JLabel("Tipo reporte: ");
        tipo_reportLabel.setBounds(10, 10, 200, 25);
        IReporte.add(tipo_reportLabel);

        JLabel totalizacion= new JLabel("   Totalizacion");
        
        JLabel equipos= new JLabel("   equipos");
        
        JLabel Bs= new JLabel("   Bs");
       
        
        IReporte.getContentPane().add(General);
        IReporte.getContentPane().add(Individual);
        
        IReporte.setLayout(null); 

        JPanel individualReport = new JPanel();
       // individualReport.setBounds(50, 100, 200, 25);
        individualReport.setLayout(null);
        IReporte.getContentPane().add(individualReport);
        //IReporte.add(individualReport);
        

        JPanel generalReport = new JPanel();
        IReporte.add(generalReport);
        //generalReport.setBounds(150,100,200,25);
        
        IReporte.getContentPane().add(generalReport);
        

        ButtonGroup grupo = new ButtonGroup();
        Individual.setBounds(10, 30, 100, 25);
        grupo.add(Individual);
        
        General.setBounds(120, 30, 100, 25);
        grupo.add(General);
        
        //faltan los add
        Individual.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                if(e.getSource() == Individual){
                    individualReport.setVisible(true);
                    generalReport.setVisible(false);
                    Individual.add(ci_responsableLabel);
                    Individual.add(ci_responsableField);
                    ci_responsableLabel.setBounds(10,50,100,25);
                    ci_responsableField.setBounds(100,50,100,25);
                    
                    
                    individualReport.add(totalizacion);
                    totalizacion.setBounds(10, 70, 100, 25);
                    individualReport.add(equipos);
                    equipos.setBounds(10, 90, 100, 25);
                    individualReport.add(Bs);
                    Bs.setBounds(10, 110, 100, 25);
                    individualReport.add(botonTotalizar);
                    individualReport.add(botonContinuar);
                    botonContinuar.setBounds(200, 400, 100, 25);
                    botonTotalizar.setBounds(450, 400, 100, 25);
                }
                
            }
        });
         General.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                if(e.getSource()== General){
                    individualReport.setVisible(false);
                    generalReport.setVisible(true);
                    generalReport.add(new JLabel("probemos"));

                    General.add(botonContinuar);
                    General.add(botonTotalizar);
                    botonContinuar.setBounds(200, 400, 100, 35);
                    botonTotalizar.setBounds(450, 400, 100, 35);
                }
            }
        });
        botonContinuar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                buttonClickContinuar(e,IReporte);
            }
        });

        IReporte.pack();
        IReporte.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    public static void buttonClickContinuar(ActionEvent e, JFrame IReporte){
        //IReporte.setDefaultCloseOperation(JFrame.ABORT);
        IReporte.setVisible(false);
    }
    

}
