package interfaz;

import entidad.ExportCobre;

public class App {
    public static void main(String[] args) {
        //Controlar el flujo de la app
        ExportCobre exportacion = null;
        int opcion;
        do{
            opcion = menu();

            switch (opcion){
                case 1:
                    //ingreso
                    exportacion = crearExportacion();
                    System.out.println("------Exportacion de cobre------");
                    System.out.println("Nro. Exportación: "+exportacion.getNroExportacion());
                    System.out.println("Nombre cliente: "+exportacion.getNombreCliente());
                    System.out.println("Pais Destino: "+exportacion.getPaisDestino());

                    for(int i=0;i<exportacion.getToneladasExportadas().length;i++){
                        System.out.println("Toneladas exportadas mes "+ (i+1) + ": "+exportacion.getToneladasExportadas()[i]);
                    }
                    break;
                case 2:
                    if(exportacion==null){
                        //NO hay registros
                        System.out.println("Favor ingresar exportación para continuar...");
                    }else{
                        System.out.println("Correo: "+exportacion.correo());
                    }
                    break;
                case 3:
                    //mes mayor exportacion
                    if(exportacion==null){
                        //NO hay registros
                        System.out.println("Favor ingresar exportación para continuar...");
                    }else{
                        System.out.println("Mes mayor exportación = Mes nro: "+exportacion.mesMayorExportacion() +
                                " Cantidad exportada: "+exportacion.getToneladasExportadas()[exportacion.mesMayorExportacion()-1]);
                    }
                    break;
                case 4:
                    //TOTAL otoño invierno
                    if(exportacion==null){
                        //NO hay registros
                        System.out.println("Favor ingresar exportación para continuar...");
                    }else{
                        System.out.println("Total Otoño-Invierno: "+exportacion.totalOtonnoInvierno());
                    }
                    break;
                case 5:
                    //Cantidad exportada en el mes de junio
                    if(exportacion==null){
                        //NO hay registros
                        System.out.println("Favor ingresar exportación para continuar...");
                    }else{
                        System.out.println("Total exportado Junio: "+exportacion.cantidadExportada(6));
                    }
                    break;

            }
        }while(opcion!=6);
    }

    public static int menu(){
        System.out.println("-------Registro de exportaciones de Cobre---");
        System.out.println("--------------------------------------------");
        System.out.println("1.\tIngresar exportación.");
        System.out.println("2.\tCorreo");
        System.out.println("3.\tMes con mayor exportación y su cantidad");
        System.out.println("4.\tTotal, exportado en otoño-invierno");
        System.out.println("5.\tCantidad exportada en el mes de junio");
        System.out.println("6.\tSalir");
        System.out.println("---------------------------------------------");
        System.out.println("Favor ingrese una opción para continuar...");
        return Leer.datoInt();
    }

    public static ExportCobre crearExportacion(){
        System.out.println("Favor ingrese nro de exportacion...");
        int nroExportacion = Leer.datoInt();

        String nombreCliente; //Domingo Saavedra Saavedra
        String[] aux = null; //{domingo,saavedra,saavedra}
        do{
            System.out.println("Ingrese nombre de cliente (Nombre y apellidos)");
            nombreCliente = Leer.dato(); //Juan Perez Galdamez
            aux = nombreCliente.split(" ");

        }while(aux.length!=3); //false == termina la iteración

        String paisDestino;
        do{
            System.out.println("Favor ingrese pais de destino (EJ: Chile)");
            paisDestino= Leer.dato(); //Chile = 5
        }while(paisDestino.length()<4); //false

        return new ExportCobre(nroExportacion,paisDestino,nombreCliente); //logica de ingreso de las exportaciones
    }
}
