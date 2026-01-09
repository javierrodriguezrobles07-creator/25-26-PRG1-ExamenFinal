import java.util.Scanner;

public class MaquinaExpendedora {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
               // Constantes
        final double SALDO_MAX = 5.0;
        final double[] MONEDAS = {0.05, 0.10, 0.20, 0.50, 1.0, 2.0};
        
        // Datos de productos
        String[] PRODUCTOS = {"Coca-Cola", "Chips", "Chocolate", "Agua"};
        double[] PRECIOS = {1.50, 1.00, 1.25, 0.75};
        int[] stock = {10, 8, 12, 15};
        
        double saldo = 0.0;
        
        System.out.println("Maquina Expendedora v1.0");

        while (true) {
            System.out.println(); // Separador
            System.out.println("Productos Disponibles");
            for (int i = 0; i < PRODUCTOS.length; i++) {
                     System.out.println((i + 1) + ". " + PRODUCTOS[i] + " | Precio: " + PRECIOS[i] + "€ | Stock: " + stock[i]);
            }
            System.out.println(); // Separador
            
            System.out.println("Saldo actual: " + ((int) saldo * 100) / 100 + " euros (Max. " + SALDO_MAX + "eur)");
            System.out.print("[1] Insertar moneda (Validas: ");
            for(int i = 0; i < MONEDAS.length; i++) {
                System.out.print(mon_val[i] + " ");
            }
            System.out.println(")");
            System.out.println("[2] Seleccionar producto");
            System.out.println("[3] Salir y recuperar cambio");
            System.out.print("Opcion: ");
            int opt = sc.nextInt();
            
            if (opt == 1) {
                 saldo = insertarMoneda(sc, saldo, MONEDAS, SALDO_MAX);
            } 
            else if (opt == 2) {
                 saldo = comprarProducto(sc, saldo, PRODUCTOS, PRECIOS, stock);
                     System.out.print("Introduce moneda: ");
                       double m = sc.nextDouble();
    
             boolean valida = false;
            for (double moneda : monedas) {
            if (Math.abs(moneda - m) < 0.001) {
            valida = true;
            break;
        }
    }
    
             if (!valida) {
                  System.out.printf("Moneda no válida. Se devuelve %.2f€\n", m);
           return saldo;
    }
    
    if (saldo + m > saldoMax) {
        System.out.printf("Límite de %.2f€ excedido. Se devuelve %.2f€\n", saldoMax, m);
        return saldo;
    }
    
    saldo += m;
    System.out.println("Moneda aceptada.");
    return saldo;
}
            } else if (opt == 2) {
                saldo = comprarProducto(sc, saldo, PRODUCTOS, PRECIOS, stock);
            private static double comprarProducto(Scanner sc, double saldo, 
                                     String[] productos, double[] precios, int[] stock) {
    System.out.print("Seleccione producto (1-" + productos.length + "): ");
    int opcion = sc.nextInt() - 1;
    
    if (opcion < 0 || opcion >= PRODUCTOS.length) {
        System.out.println("Producto no válido.");
        return saldo;
    }
    
    if (stock[opcion] <= 0) {
        System.out.println("Producto agotado.");
        return saldo;
    }
    
    if (saldo < precios[opcion]) {
        System.out.printf("Saldo insuficiente. Necesitas %.2f€\n", precios[opcion]);
        return saldo;
    }
    
    stock[opcion]--;
    saldo -= precios[opcion];
    System.out.println("¡Disfruta tu " + productos[opcion] + "!");
    return saldo;
}

} else if (opt == 3) {
                if (saldo > 0) {
                    System.out.println("No olvides recoger tu cambio: " + ((int) saldo * 100) / 100 + " euros.");
                }
                System.out.println("Gracias por tu visita. ¡Hasta pronto!");
                break;
            } else {
                System.out.println("Opcion no valida.");
            }
        }
        sc.close();
    }
}
