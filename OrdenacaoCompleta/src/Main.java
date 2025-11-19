
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o tamanho do vetor: ");
        int tamanho = sc.nextInt();
        sc.close();

        int limite = Math.max(tamanho, 11);
        List<Integer> numeros = new ArrayList<>();
        for (int i = 0; i < limite; i++) {
            numeros.add(i);
        }

        Collections.shuffle(numeros);
        int[] vetorOriginal = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            vetorOriginal[i] = numeros.get(i % numeros.size());
        }

        System.out.println("==== Comparação de Algoritimo de ordenação ====");
        System.out.println("Tamanho Do Vetor: " + tamanho);
        System.out.println("------------------------------------------------------------------------------");

        System.out.println("Vetor gerado com Sucesso!");
        // -----------------Bubble Sort----------------------
        int[] vetorBubble = vetorOriginal.clone();
        System.out.println("Excutando Bubble Sort....");
        long inicio = System.nanoTime();
        OrdenacaoCompleta.bubbleSort(vetorBubble);
        long fim = System.nanoTime();
        System.out.printf("Tempo: %.6f ms%n", (fim - inicio) / 1_000_000.0);

        imprimirVetorCompleto(vetorBubble);

        // ------------------ Selection Sort------------------------
        int[] vetorSelection = vetorOriginal.clone();
        System.out.println("Excutando Selection Sort....");
        inicio = System.nanoTime();
        OrdenacaoCompleta.selectionSort(vetorSelection);
        fim = System.nanoTime();
        System.out.printf("Tempo: %.6f ms%n", (fim - inicio) / 1_000_000.0);

        imprimirVetorCompleto(vetorSelection);

        int[] vetorInsercion = vetorOriginal.clone();
        System.out.println("Excutando Incersion Sort....");
        inicio = System.nanoTime();
        OrdenacaoCompleta.insercionSort(vetorInsercion);
        fim = System.nanoTime();
        System.out.printf("Tempo: %.6f ms%n", (fim - inicio) / 1_000_000.0);
        imprimirVetorCompleto(vetorInsercion);

        int[] vetorMarge = vetorOriginal.clone();
        System.out.println("Excutando Marge Sort....");
        inicio = System.nanoTime();
        OrdenacaoCompleta.mergeSort(vetorMarge, 0, vetorMarge.length - 1);
        fim = System.nanoTime();
        System.out.printf("Tempo: %.6f ms%n", (fim - inicio) / 1_000_000.0);
        imprimirVetorCompleto(vetorMarge);

        int[] vetorQuick = vetorOriginal.clone();
        System.out.println("Excutando Quick Sort....");
        inicio = System.nanoTime();
        OrdenacaoCompleta.quickSort(vetorQuick, 0, vetorQuick.length - 1);
        fim = System.nanoTime();
        System.out.printf("Tempo: %.6f ms%n", (fim - inicio) / 1_000_000.0);
        imprimirVetorCompleto(vetorQuick);

        System.out.println("-----------------------");
        System.out.println("Todos os algoritmos  foram excutados com sucesso");
        sc.close();

    }

    private static void imprimirVetorCompleto(int[] vetor) {
        System.out.println("Vetor Ordendado: ");
        for (int i = 0; i < vetor.length; i++) {
            System.out.print(vetor[i]);
        }
        System.out.println("\n");
    }
}
