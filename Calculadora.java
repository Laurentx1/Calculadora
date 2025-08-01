import java.util.Scanner;
import java.text.DecimalFormat;

/**
 * Calculadora Java Completa
 * Operações básicas, científicas e conversões
 */
public class Calculadora {
    
    private static final Scanner scanner = new Scanner(System.in);
    private static final DecimalFormat df = new DecimalFormat("#.####");
    private static double memoria = 0.0;
    
    public static void main(String[] args) {
        System.out.println("🧮 CALCULADORA JAVA AVANÇADA");
        System.out.println("============================");
        
        boolean continuar = true;
        
        while (continuar) {
            exibirMenu();
            int opcao = lerOpcao();
            
            switch (opcao) {
                case 1 -> operacoesBasicas();
                case 2 -> operacoesCientificas();
                case 3 -> conversoes();
                case 4 -> gerenciarMemoria();
                case 5 -> calculadoraInterativa();
                case 6 -> sobre();
                case 0 -> {
                    System.out.println("👋 Obrigado por usar a calculadora!");
                    continuar = false;
                }
                default -> System.out.println("❌ Opção inválida! Tente novamente.");
            }
            
            if (continuar) {
                System.out.println("\nPressione Enter para continuar...");
                scanner.nextLine();
            }
        }
        
        scanner.close();
    }
    
    private static void exibirMenu() {
        System.out.println("\n" + "=".repeat(40));
        System.out.println("📊 MENU PRINCIPAL");
        System.out.println("=".repeat(40));
        System.out.println("1. 🔢 Operações Básicas");
        System.out.println("2. 🔬 Operações Científicas");
        System.out.println("3. 🔄 Conversões");
        System.out.println("4. 💾 Gerenciar Memória (M = " + df.format(memoria) + ")");
        System.out.println("5. 🎯 Calculadora Interativa");
        System.out.println("6. ℹ️  Sobre");
        System.out.println("0. 🚪 Sair");
        System.out.println("=".repeat(40));
        System.out.print("Escolha uma opção: ");
    }
    
    private static int lerOpcao() {
        try {
            return scanner.nextInt();
        } catch (Exception e) {
            scanner.nextLine(); // Limpa buffer
            return -1;
        }
    }
    
    private static void operacoesBasicas() {
        System.out.println("\n🔢 OPERAÇÕES BÁSICAS");
        System.out.println("-".repeat(25));
        
        double num1 = lerNumero("Digite o primeiro número: ");
        double num2 = lerNumero("Digite o segundo número: ");
        
        System.out.println("\n📊 RESULTADOS:");
        System.out.println("➕ Soma: " + df.format(num1) + " + " + df.format(num2) + " = " + df.format(num1 + num2));
        System.out.println("➖ Subtração: " + df.format(num1) + " - " + df.format(num2) + " = " + df.format(num1 - num2));
        System.out.println("✖️  Multiplicação: " + df.format(num1) + " × " + df.format(num2) + " = " + df.format(num1 * num2));
        
        if (num2 != 0) {
            System.out.println("➗ Divisão: " + df.format(num1) + " ÷ " + df.format(num2) + " = " + df.format(num1 / num2));
            System.out.println("📊 Resto: " + df.format(num1) + " % " + df.format(num2) + " = " + df.format(num1 % num2));
        } else {
            System.out.println("❌ Divisão por zero não é possível!");
        }
        
        System.out.println("🔺 Potência: " + df.format(num1) + "^" + df.format(num2) + " = " + df.format(Math.pow(num1, num2)));
    }
    
    private static void operacoesCientificas() {
        System.out.println("\n🔬 OPERAÇÕES CIENTÍFICAS");
        System.out.println("-".repeat(30));
        System.out.println("1. Raiz Quadrada");
        System.out.println("2. Logaritmo Natural (ln)");
        System.out.println("3. Logaritmo Base 10");
        System.out.println("4. Seno");
        System.out.println("5. Cosseno");
        System.out.println("6. Tangente");
        System.out.println("7. Fatorial");
        System.out.println("8. Valor Absoluto");
        System.out.print("Escolha a operação: ");
        
        int opcao = lerOpcao();
        double numero = lerNumero("Digite o número: ");
        double resultado = 0;
        String operacao = "";
        
        try {
            switch (opcao) {
                case 1 -> {
                    if (numero >= 0) {
                        resultado = Math.sqrt(numero);
                        operacao = "√" + df.format(numero);
                    } else {
                        System.out.println("❌ Raiz quadrada de número negativo!");
                        return;
                    }
                }
                case 2 -> {
                    if (numero > 0) {
                        resultado = Math.log(numero);
                        operacao = "ln(" + df.format(numero) + ")";
                    } else {
                        System.out.println("❌ Logaritmo de número não positivo!");
                        return;
                    }
                }
                case 3 -> {
                    if (numero > 0) {
                        resultado = Math.log10(numero);
                        operacao = "log₁₀(" + df.format(numero) + ")";
                    } else {
                        System.out.println("❌ Logaritmo de número não positivo!");
                        return;
                    }
                }
                case 4 -> {
                    resultado = Math.sin(Math.toRadians(numero));
                    operacao = "sin(" + df.format(numero) + "°)";
                }
                case 5 -> {
                    resultado = Math.cos(Math.toRadians(numero));
                    operacao = "cos(" + df.format(numero) + "°)";
                }
                case 6 -> {
                    resultado = Math.tan(Math.toRadians(numero));
                    operacao = "tan(" + df.format(numero) + "°)";
                }
                case 7 -> {
                    if (numero >= 0 && numero == (int)numero && numero <= 20) {
                        resultado = fatorial((int)numero);
                        operacao = (int)numero + "!";
                    } else {
                        System.out.println("❌ Fatorial apenas para números inteiros entre 0 e 20!");
                        return;
                    }
                }
                case 8 -> {
                    resultado = Math.abs(numero);
                    operacao = "|" + df.format(numero) + "|";
                }
                default -> {
                    System.out.println("❌ Operação inválida!");
                    return;
                }
            }
            
            System.out.println("📊 Resultado: " + operacao + " = " + df.format(resultado));
            
        } catch (Exception e) {
            System.out.println("❌ Erro no cálculo: " + e.getMessage());
        }
    }
    
    private static void conversoes() {
        System.out.println("\n🔄 CONVERSÕES");
        System.out.println("-".repeat(20));
        System.out.println("1. Celsius ↔ Fahrenheit");
        System.out.println("2. Metros ↔ Pés");
        System.out.println("3. Quilômetros ↔ Milhas");
        System.out.println("4. Decimal ↔ Binário");
        System.out.println("5. Decimal ↔ Hexadecimal");
        System.out.print("Escolha a conversão: ");
        
        int opcao = lerOpcao();
        
        switch (opcao) {
            case 1 -> conversaoTemperatura();
            case 2 -> conversaoDistancia("metros", "pés", 3.28084);
            case 3 -> conversaoDistancia("km", "milhas", 0.621371);
            case 4 -> conversaoBinario();
            case 5 -> conversaoHexadecimal();
            default -> System.out.println("❌ Conversão inválida!");
        }
    }
    
    private static void conversaoTemperatura() {
        System.out.println("\n🌡️ CONVERSÃO DE TEMPERATURA");
        System.out.println("1. Celsius → Fahrenheit");
        System.out.println("2. Fahrenheit → Celsius");
        System.out.print("Escolha: ");
        
        int tipo = lerOpcao();
        double temp = lerNumero("Digite a temperatura: ");
        
        if (tipo == 1) {
            double fahrenheit = (temp * 9/5) + 32;
            System.out.println("🔥 " + df.format(temp) + "°C = " + df.format(fahrenheit) + "°F");
        } else if (tipo == 2) {
            double celsius = (temp - 32) * 5/9;
            System.out.println("🧊 " + df.format(temp) + "°F = " + df.format(celsius) + "°C");
        } else {
            System.out.println("❌ Opção inválida!");
        }
    }
    
    private static void conversaoDistancia(String unidade1, String unidade2, double fator) {
        System.out.println("\n📏 CONVERSÃO DE DISTÂNCIA");
        System.out.println("1. " + unidade1 + " → " + unidade2);
        System.out.println("2. " + unidade2 + " → " + unidade1);
        System.out.print("Escolha: ");
        
        int tipo = lerOpcao();
        double valor = lerNumero("Digite o valor: ");
        
        if (tipo == 1) {
            double convertido = valor * fator;
            System.out.println("📐 " + df.format(valor) + " " + unidade1 + " = " + df.format(convertido) + " " + unidade2);
        } else if (tipo == 2) {
            double convertido = valor / fator;
            System.out.println("📐 " + df.format(valor) + " " + unidade2 + " = " + df.format(convertido) + " " + unidade1);
        } else {
            System.out.println("❌ Opção inválida!");
        }
    }
    
    private static void conversaoBinario() {
        System.out.println("\n💻 CONVERSÃO BINÁRIA");
        System.out.println("1. Decimal → Binário");
        System.out.println("2. Binário → Decimal");
        System.out.print("Escolha: ");
        
        int tipo = lerOpcao();
        scanner.nextLine(); // Limpa buffer
        
        if (tipo == 1) {
            int decimal = (int)lerNumero("Digite o número decimal: ");
            String binario = Integer.toBinaryString(decimal);
            System.out.println("🔢 " + decimal + " (decimal) = " + binario + " (binário)");
        } else if (tipo == 2) {
            System.out.print("Digite o número binário: ");
            String binario = scanner.nextLine();
            try {
                int decimal = Integer.parseInt(binario, 2);
                System.out.println("🔢 " + binario + " (binário) = " + decimal + " (decimal)");
            } catch (NumberFormatException e) {
                System.out.println("❌ Número binário inválido!");
            }
        } else {
            System.out.println("❌ Opção inválida!");
        }
    }
    
    private static void conversaoHexadecimal() {
        System.out.println("\n🔡 CONVERSÃO HEXADECIMAL");
        System.out.println("1. Decimal → Hexadecimal");
        System.out.println("2. Hexadecimal → Decimal");
        System.out.print("Escolha: ");
        
        int tipo = lerOpcao();
        scanner.nextLine(); // Limpa buffer
        
        if (tipo == 1) {
            int decimal = (int)lerNumero("Digite o número decimal: ");
            String hex = Integer.toHexString(decimal).toUpperCase();
            System.out.println("🔢 " + decimal + " (decimal) = " + hex + " (hexadecimal)");
        } else if (tipo == 2) {
            System.out.print("Digite o número hexadecimal: ");
            String hex = scanner.nextLine();
            try {
                int decimal = Integer.parseInt(hex, 16);
                System.out.println("🔢 " + hex + " (hexadecimal) = " + decimal + " (decimal)");
            } catch (NumberFormatException e) {
                System.out.println("❌ Número hexadecimal inválido!");
            }
        } else {
            System.out.println("❌ Opção inválida!");
        }
    }
    
    private static void gerenciarMemoria() {
        System.out.println("\n💾 GERENCIAR MEMÓRIA");
        System.out.println("Valor atual na memória: " + df.format(memoria));
        System.out.println("-".repeat(25));
        System.out.println("1. Armazenar valor (MS)");
        System.out.println("2. Recuperar valor (MR)");
        System.out.println("3. Somar à memória (M+)");
        System.out.println("4. Subtrair da memória (M-)");
        System.out.println("5. Limpar memória (MC)");
        System.out.print("Escolha a operação: ");
        
        int opcao = lerOpcao();
        
        switch (opcao) {
            case 1 -> {
                double valor = lerNumero("Digite o valor para armazenar: ");
                memoria = valor;
                System.out.println("✅ Valor " + df.format(valor) + " armazenado na memória");
            }
            case 2 -> System.out.println("📤 Valor da memória: " + df.format(memoria));
            case 3 -> {
                double valor = lerNumero("Digite o valor para somar: ");
                memoria += valor;
                System.out.println("➕ " + df.format(valor) + " somado à memória. Novo valor: " + df.format(memoria));
            }
            case 4 -> {
                double valor = lerNumero("Digite o valor para subtrair: ");
                memoria -= valor;
                System.out.println("➖ " + df.format(valor) + " subtraído da memória. Novo valor: " + df.format(memoria));
            }
            case 5 -> {
                memoria = 0.0;
                System.out.println("🗑️ Memória limpa!");
            }
            default -> System.out.println("❌ Operação inválida!");
        }
    }
    
    private static void calculadoraInterativa() {
        System.out.println("\n🎯 CALCULADORA INTERATIVA");
        System.out.println("Digite expressões como: 2 + 3, 10 - 5, etc.");
        System.out.println("Digite 'sair' para voltar ao menu principal");
        System.out.println("-".repeat(40));
        
        scanner.nextLine(); // Limpa buffer
        
        while (true) {
            System.out.print(">>> ");
            String expressao = scanner.nextLine().trim();
            
            if (expressao.equalsIgnoreCase("sair")) {
                break;
            }
            
            try {
                double resultado = avaliarExpressao(expressao);
                System.out.println("📊 = " + df.format(resultado));
            } catch (Exception e) {
                System.out.println("❌ Erro na expressão: " + e.getMessage());
            }
        }
    }
    
    private static double avaliarExpressao(String expressao) throws Exception {
        // Remove espaços
        expressao = expressao.replaceAll("\\s+", "");
        
        // Operações simples: número operador número
        String[] partes;
        
        if (expressao.contains("+")) {
            partes = expressao.split("\\+", 2);
            return Double.parseDouble(partes[0]) + Double.parseDouble(partes[1]);
        } else if (expressao.contains("-") && !expressao.startsWith("-")) {
            partes = expressao.split("-", 2);
            return Double.parseDouble(partes[0]) - Double.parseDouble(partes[1]);
        } else if (expressao.contains("*")) {
            partes = expressao.split("\\*", 2);
            return Double.parseDouble(partes[0]) * Double.parseDouble(partes[1]);
        } else if (expressao.contains("/")) {
            partes = expressao.split("/", 2);
            double divisor = Double.parseDouble(partes[1]);
            if (divisor == 0) throw new Exception("Divisão por zero!");
            return Double.parseDouble(partes[0]) / divisor;
        } else if (expressao.contains("^")) {
            partes = expressao.split("\\^", 2);
            return Math.pow(Double.parseDouble(partes[0]), Double.parseDouble(partes[1]));
        } else {
            // Apenas um número
            return Double.parseDouble(expressao);
        }
    }
    
    private static void sobre() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("ℹ️  SOBRE A CALCULADORA JAVA AVANÇADA");
        System.out.println("=".repeat(50));
        System.out.println("📝 Versão: 2.0");
        System.out.println("👨‍💻 Desenvolvido em Java");
        System.out.println("📅 Criado: " + java.time.LocalDate.now());
        System.out.println();
        System.out.println("🎯 FUNCIONALIDADES:");
        System.out.println("   • Operações básicas (+, -, ×, ÷, ^, %)");
        System.out.println("   • Funções científicas (√, ln, log, sin, cos, tan)");
        System.out.println("   • Conversões de unidades");
        System.out.println("   • Sistema de memória (MS, MR, M+, M-, MC)");
        System.out.println("   • Calculadora interativa");
        System.out.println("   • Conversões numéricas (binário, hexadecimal)");
        System.out.println();
        System.out.println("🔧 RECURSOS TÉCNICOS:");
        System.out.println("   • Tratamento de erros");
        System.out.println("   • Formatação de números");
        System.out.println("   • Interface amigável");
        System.out.println("   • Código modular e organizado");
        System.out.println("=".repeat(50));
    }
    
    private static double lerNumero(String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                return scanner.nextDouble();
            } catch (Exception e) {
                System.out.println("❌ Por favor, digite um número válido!");
                scanner.nextLine(); // Limpa buffer
            }
        }
    }
    
    private static long fatorial(int n) {
        if (n <= 1) return 1;
        long resultado = 1;
        for (int i = 2; i <= n; i++) {
            resultado *= i;
        }
        return resultado;
    }
}
