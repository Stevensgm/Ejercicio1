public class Cuenta {

    protected float saldo;
    protected int numeroConsignaciones = 0;
    protected int numeroRetiros = 0;
    protected float tasaAnual;
    protected float comisionMensual = 0;

    public Cuenta(float saldo, float tasaAnual) {
        this.saldo = saldo;
        this.tasaAnual = tasaAnual;
    }

    // Getters
    public float getSaldo() {
        return saldo;
    }

    public int getNumeroConsignaciones() {
        return numeroConsignaciones;
    }

    public int getNumeroRetiros() {
        return numeroRetiros;
    }

    public float getTasaAnual() {
        return tasaAnual;
    }

    public float getComisionMensual() {
        return comisionMensual;
    }

    // Setters (se agregan solo si es necesario modificar el valor desde fuera)
    public void setComisionMensual(float comisionMensual) {
        this.comisionMensual = comisionMensual;
    }

    // Métodos de negocio existentes...
    public void consignar(float cantidad) {
        saldo = saldo + cantidad;
        numeroConsignaciones++;
    }

    public void retirar(float cantidad) {
        if (cantidad > saldo) {
            System.out.println("No se puede retirar más de lo que hay en el saldo.");
        } else {
            saldo = saldo - cantidad;
            numeroRetiros++;
        }
    }

    public void calcularInteres() {
        float interesMensual = saldo * (tasaAnual / 12) / 100;
        saldo = saldo + interesMensual;
    }

    public void extractoMensual() {
        saldo = saldo - comisionMensual;
        calcularInteres();
    }

    public void imprimir() {
        System.out.println("Saldo: $" + saldo);
        System.out.println("Comisión mensual: $" + comisionMensual);
        System.out.println("Número de transacciones realizadas: " + (numeroConsignaciones + numeroRetiros));
    }
}