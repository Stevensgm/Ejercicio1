public class main {

    public static void main(String[] args) {
        
        System.out.println("=== PRUEBAS DE CUENTA DE AHORROS ===");
        
        // Creamos una nueva cuenta de ahorros con un saldo inicial y una tasa anual
        // El constructor de CuentaAhorros llama internamente al de la clase padre (Cuenta)
        CuentaAhorros cuentaAhorros = new CuentaAhorros(15000, 1.2f);
        
        // Probamos consignar dinero
        System.out.println("Consignando $5000...");
        cuentaAhorros.consignar(50000);
        
        // Probamos retirar dinero
        System.out.println("Retirando $10000...");
        cuentaAhorros.retirar(10000);
        
        // Realizamos retiros adicionales para probar la comisión
        System.out.println("Retirando $500, $500, $500, $500, $500...");
        cuentaAhorros.retirar(500);
        cuentaAhorros.retirar(500);
        cuentaAhorros.retirar(500);
        cuentaAhorros.retirar(500);
        cuentaAhorros.retirar(500);
        
        // Ejecutamos el extracto mensual y mostramos el resultado
        System.out.println("Calculando extracto mensual...");
        cuentaAhorros.extractoMensual();
        
        // Imprimimos el estado final de la cuenta de ahorros
        cuentaAhorros.imprimir();
        
        System.out.println("\n=== PRUEBAS DE CUENTA CORRIENTE ===");
        
        // Creamos una nueva cuenta corriente
        CuentaCorriente cuentaCorriente = new CuentaCorriente(5000, 1.2f);
        
        // Probamos un retiro que genera sobregiro
        System.out.println("Retirando $8000 (causará sobregiro)...");
        cuentaCorriente.retirar(8000);
        
        // Probamos una consignación que cubre el sobregiro
        System.out.println("Consignando $3000 (para cubrir sobregiro)...");
        cuentaCorriente.consignar(3000);
        
        // Probamos una consignación normal después de haber cubierto el sobregiro
        System.out.println("Consignando $2000...");
        cuentaCorriente.consignar(2000);
        
        // Ejecutamos el extracto mensual y mostramos el resultado
        System.out.println("Calculando extracto mensual...");
        cuentaCorriente.extractoMensual();
        
        // Imprimimos el estado final de la cuenta corriente
        cuentaCorriente.imprimir();
    }
}