public class Cuenta {

    protected Float saldo ;
    protected int numeroConsignacion = 0;
    protected int numeroRetiros = 0;
    protected Float comisionMensual ;
    protected float TASA_ANUAL = 12;
   
    

    public Cuenta(Float saldo,Float TASA_ANUAL) {
        this.saldo = saldo;
        this.TASA_ANUAL = TASA_ANUAL;
        
    }

    public void consignar(Float cantidad){

        saldo = saldo + cantidad;
        numeroConsignacion++;
    }

    public void retirar(Float cantidad){

        if (cantidad > saldo){
            System.out.println("Fondos Insuficientes");
        } else {
            saldo = saldo - cantidad;
            numeroRetiros++;

    }

    public void calcularInteres(){ 
        Float tasaMensual = TASA_ANUAL / 12;
        Float interesMensual = saldo * tasaMensual;
        saldo = saldo + interesMensual;


    }

    public void extractoMensual(){
        saldo = saldo - comisionMensual;
        calcularInteres();
    
    }

    public void imprimir(){
        System.out.println("Saldo: " + saldo);
        System.out.println("Numero de Consignaciones: " + numeroConsignacion);
        System.out.println("Numero de Retiros: " + numeroRetiros);
        System.out.println("Comision Mensual: " + comisionMensual);
    }

    
}