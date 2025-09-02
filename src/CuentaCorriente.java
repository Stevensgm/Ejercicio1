public class CuentaCorriente extends Cuenta {

    protected float sobregiro = 0;

    public CuentaCorriente(float saldo, float tasaAnual) {
        super(saldo, tasaAnual);
    }

    // Getter para el atributo 'sobregiro'
    public float getSobregiro() {
        return sobregiro;
    }

    @Override
    public void consignar(float cantidad) {
        if (sobregiro > 0) {
            if (cantidad > sobregiro) {
                cantidad -= sobregiro;
                sobregiro = 0;
                super.consignar(cantidad);
            } else {
                sobregiro -= cantidad;
            }
        } else {
            super.consignar(cantidad);
        }
    }

    @Override
    public void retirar(float cantidad) {
        if (cantidad > saldo) {
            sobregiro += (cantidad - saldo);
            saldo = 0;
        } else {
            super.retirar(cantidad);
        }
    }

    @Override
    public void extractoMensual() {
        super.extractoMensual();
        if (sobregiro > 0) {
            comisionMensual += 0;
        } else {
            numeroConsignaciones = 0;
            numeroRetiros = 0;
        }
    }

    @Override
    public void imprimir() {
        super.imprimir();
        System.out.println("Valor del sobregiro: $" + sobregiro);
    }
}