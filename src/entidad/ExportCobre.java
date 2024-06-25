package entidad;

public class ExportCobre {
    //atributos
    private int nroExportacion; //123455
    private String paisDestino; //
    private String nombreCliente; //Luis Saa Cancino
    private int[] toneladasExportadas; //{100,1232,456,432,888,100,1232,456,432,888,432,1324}

    //Getters & Setters
    public String getPaisDestino() {
        return paisDestino;
    }

    public void setPaisDestino(String paisDestino) {
        this.paisDestino = paisDestino;
    }

    public int getNroExportacion() {
        return nroExportacion;
    }

    public void setNroExportacion(int nroExportacion) {
        this.nroExportacion = nroExportacion;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public int[] getToneladasExportadas() {
        return toneladasExportadas;
    }

    public void setToneladasExportadas(int[] toneladasExportadas) {
        this.toneladasExportadas = toneladasExportadas;
    }

    //Al crear el constructor, java ya no lo crea por nosotros
    public ExportCobre(int nroExportacion, String paisDestino, String nombreCliente) {
        this.nroExportacion = nroExportacion;
        this.paisDestino = paisDestino;
        this.nombreCliente = nombreCliente;
        this.toneladasExportadas = new int[12];

        //generar toneladas aleatorias
        for (int i=0; i< this.toneladasExportadas.length;i++){
            toneladasExportadas[i] =(int) (Math.random()*(1501-0));
        }
    }

    public ExportCobre(){
        //Crea los objetos sin valores iniciales
    }


    /*
    * a.	correo: Devolverá el correo del cliente. El correo estará compuesto por
    * las 5 primeras letras del nombre, un guion bajo, las cuatro últimas letras del
    *  apellido paterno, la segunda letra del país destino, más @exportcobre.cl
    * (todo en minúscula). Si el nombre o el apellido tiene menos letras de las que
    *   se necesitan, se les asignará a las letras faltantes el carácter x.
    Ejemplo: Si el cliente es Luis Saa Cancino y país destino Grecia devolverá:
    *
    * luisx_saaxr@exportcobre.cl */
    public String correo(){//chile
        String mail = ""; //domingo saavedra saavedra (domin_edrah@exportcobre.cl)
                            //0        1        2
        String[] arregloNombreCliente = nombreCliente.split(" ");

        if(arregloNombreCliente[0].length()>5){
            mail = arregloNombreCliente[0].substring(0,5);
        }else{
            mail = arregloNombreCliente[0]; //Lee
            int dif = 5 - arregloNombreCliente[0].length(); //
            for(int i=1;i<=dif;i++){
                mail = mail.concat("x");
            }
        }
        mail = mail.concat("_");

        if(arregloNombreCliente[1].length()>4){ //Saavedra
            //el apellido tiene un largo mayor a 4
            mail = mail + arregloNombreCliente[1].substring(arregloNombreCliente[1].length()-4);
        }else{
            mail = mail + arregloNombreCliente[1];
            int dif = 4 - arregloNombreCliente[1].length(); //
            for(int i=1;i<=dif;i++){
                mail = mail.concat("x");
            }
        }

        mail = mail + paisDestino.substring(1,2) + "@exportcobre.cl";

        return mail.toLowerCase();
    }

    //b.	mesMayorExportación: devolverá el número del mes que hubo mayor exportación.
    public int mesMayorExportacion(){
        int max=0, mes =0;
        for(int i=0;i<toneladasExportadas.length;i++){
            if(toneladasExportadas[i]>max){
                max = toneladasExportadas[i];
                mes = (i+1);
            }
        }
        return mes;
    }

    //c.	totalOtoñoInvierno: devolverá el total de exportaciones realizada
    // en el periodo Otoño-Invierno (considerar los meses de abril a septiembre).
    public int totalOtonnoInvierno(){
        int suma=0;
        for(int i=3;i<9;i++){
            suma= suma+toneladasExportadas[i];
        }
        return suma;
    }

    //d.	cantidadExportada: devolverá la cantidad que se exportó en un mes X.
    public int cantidadExportada(int mes){ //enero (1)
        return toneladasExportadas[mes-1];
    }

}
