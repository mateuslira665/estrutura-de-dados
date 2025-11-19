
//Arquivio:Ordenação completa
//DESCRIÇÃO: Desmontra Varios tipos de ordenação 
import java.util.Random;
import java.util.Scanner;

public class OrdenacaoCompleta {


    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("digite o tamanho do vetor");
        int tamanho = sc.nextInt();
        sc.close();
        int[] vetorOriginal = gerarVetorAleatorio(tamanho);
        // Clonamos o vetor original para não alterar
        int[] vetorBubble = vetorOriginal.clone();
        int[] vetorSeletion = vetorOriginal.clone();
        int[] vetorInsersion = vetorOriginal.clone();
        int[] vetorMerge = vetorOriginal.clone();
        int[] vetorQuick = vetorOriginal.clone();

        System.out.println("=== COMPARAÇÃO DE ALGORITIMOS DE ORDENAÇÃO ===");
        System.out.println("Tamanho do vetor: " + tamanho);
        medirTempo("Bubble Sort", () -> bubbleSort(vetorBubble));
        medirTempo("Selection Sort", () -> selectionSort(vetorSeletion));
        medirTempo("Insersion Sort", () -> insercionSort(vetorInsersion));
        medirTempo("Merge Sort", () -> mergeSort(vetorMerge, 0, vetorMerge.length - 1));
        medirTempo("quick Sort", () -> quickSort(vetorQuick, 0, vetorQuick.length - 1));

        System.out.println("Todos os algoritmos foram executados com Sucesso!");
    }

    // gera um vetor com valores aleatórios
    public static int[] gerarVetorAleatorio(int tamanho) {
        Random rand = new Random();
        int[] vetor = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            vetor[i] = rand.nextInt(10000);
        }
        return vetor;
    }

    // Mede o tempo de execução//
    public static void medirTempo(String nome, Runnable algoritmo) {
        long inicio = System.currentTimeMillis();
        algoritmo.run();
        long fim = System.currentTimeMillis();
        System.out.println(nome + "- Tempo: " + (fim - inicio) + "ms");

    }

    // Bubble Sort - compara pares adjacentes e os trocas se necessário
    public static void bubbleSort(int[] vetor) {
        int n = vetor.length;
        boolean trocou;

        // Percorre o vetor várias vezes
        for (int i = 0; i < n - 1; i++) {
            trocou = false;

            // Em cada passagem, compara pares de elementos adjacentes
            // O "- i - 1" evita comparar as posições já ordenadas no final
            for (int j = 0; j < n - i - 1; j++) {
                if (vetor[j] > vetor[j + 1]) {
                    // Troca os elementos de lugar
                    int temp = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = temp;
                    trocou = true;
                }
            }
            // Se nenhuma troca foi feita, o vetor já está ordenado
            if (!trocou) {
                break;
            }
        }
    }

    public static void selectionSort(int[] vetor) {
        int n = vetor.length;
        for (int i = 0; i < n - 1; i++) {
            int indiceMenor = i;
            for (int j = i + 1; j < n; j++) {
                if (vetor[j] < vetor[indiceMenor]) {
                    indiceMenor = j;
                }
            }
            int temp = vetor[indiceMenor];
            vetor[indiceMenor] = vetor[i];
            vetor[i] = temp;
        }

    }

    public static void insercionSort(int[] vetor) {
        for (int i = 1; i < vetor.length; i++) {
            int chave = vetor[i];
            int j = i - 1;

            while (j >= 0 && vetor[j] > chave) {
                vetor[j + 1] = vetor[j];
                j--;

            }
            vetor[j + 1] = chave;
        }
    }

    public static void mergeSort(int[] vetor, int inicio, int fim) {
        if (inicio < fim) {
            int meio = (inicio + fim) / 2;
            mergeSort(vetor, inicio, meio);
            mergeSort(vetor, meio + 1, fim);
            merge(vetor, inicio, meio, fim);
        }

    }

    private static void merge(int[] vetor, int inicio, int meio, int fim) {
        int n1 = meio - inicio + 1;
        int n2 = fim - meio;

        int[] esquerda = new int[n1];
        int[] direita = new int[n2];

        for (int i = 0; i < n1; i++) {
            esquerda[i] = vetor[inicio + i];
        }
        for (int j = 0; j < n2; j++) {
            direita[j] = vetor[meio + 1 + j];
        }
        int i = 0, j = 0, k = inicio;

        while (i < n1 && j < n2) {
            if (esquerda[i] <= direita[j]) {
                vetor[k] = esquerda[i];
            } else {
                vetor[k] = direita[j];
            }
            j++;
        }
        k++;

    }

    public static void quickSort(int[] vetor, int inicio, int fim) {
        if (inicio < fim) {
            // Chama o método de partição que retorna o índice do pivô
            int indicePivo = particionar(vetor, inicio, fim);

            // Ordena a parte à esquerda do pivô
            quickSort(vetor, inicio, indicePivo - 1);

            // Ordena a parte à direita do pivô
            quickSort(vetor, indicePivo + 1, fim);
        }
    }

    private static int particionar(int[] vetor, int inicio, int fim) {
        int pivo = vetor[fim]; // Escolhe o último elemento como pivô
        int i = inicio - 1; // Marca a fronteira dos menores que o pivô

        for (int j = inicio; j < fim; j++) {
            if (vetor[j] <= pivo) {
                i++;
                int temp = vetor[i];
                vetor[i] = vetor[j];
                vetor[j] = temp;
            }
        }

        // Coloca o pivô na posição correta
        int temp = vetor[i + 1];
        vetor[i + 1] = vetor[fim];
        vetor[fim] = temp;

        return i + 1; // Retorna o índice do pivô


    }

}
