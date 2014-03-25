// ------------- Criando array

int[] c; // Declara a variável de array. 'c' é a variável que referencia um array do tipo int
c = new int[12]; 
	// cria o array; atribui à variável de array. 
	// A variável 'c' recebe a referência para um novo array de 12 elementos.

// ------------- Percorrendo o array e somando os elementos

int total = 0;
for(int counter = 0; counter < c.length; counter++) 
{
	total+= c[counter];
}

	// OU

for(int valor : c) 
{
	total+= valor;
}

// ------------- Passando array para métodos

void passaArray(int[] array) 
{
	// realiza instruções
}

passaArray(c);

// ------------- Arrays bidimensionais

int[][] b = {{1,2}, {3,4,5}}; // cria array de inteiros b com dois elementos
int[][] b = new int[2][]; // cria 2 linhas
b[0] = new int[5]; // cria 5 colunas para a linha 0
b[1] = new int[3]; // cria 3 colunas para a linha 1

// ------------- Percorrendo arrays bidimensionais. Exemplo com array bidimensional b anterior

for(int linha = 0; linha < b.length; linha++)
{
	for(int coluna = 0; coluna < b[linha].length; coluna++)
	{
		System.out.printf("%d ", b[linha][coluna]);
	}
}

// ------------- A classe Arrays

// Exemplo 1
double[] doubleArray = {8.4, 9.3, 0.2, 7.9, 3.4}; // declaração de array para usá-lo como exemplo
Arrays.sort(doubleArray); // Método sort da classe Arrays ordena o array de exemplo doubleArray

// Exemplo 2
int[] filledIntArray = new int[10];
Arrays.fill(filledIntArray, 7); // Preenche o array de 10 elementos com 7s

// Exemplo 3
int[] intArray = {1, 2, 3, 4, 5, 6};
int[] intArrayCopy = new int[intArray.length];
System.arraycopy(intArray, 0, intArrayCopy, 0, intArray.length); // copia array intArray em array intArrayCopy
displayArray(intArray, "intArray");
displayArray(intArrayCopy, "intArrayCopy");

// Exemplo 4
int local = Arrays.binarySearch(intArray, 5); // pesquisa em intArray o valor 5

// ------------- Lista de argumentos de um método com tamanho variável:

 	// cria métodos que recebem um número não especificado de elementos. 
	// Como fazer? Declaração: um tipo seguido de reticências (...) na lista de parâmetros. Essa utilização
	// só pode ocorrer uma única vez em uma lista de parâmetros, e as reticências, juntamente com seu tipo,
	// devem ser colocadas no fim da lista de parâmetros.

	// OBS: o java trata a lista de argumentos de comprimento variável como um array cujos elementos são
	// todos do mesmo tipo. Oberve isso no exemplo abaixo, no laço for.

// Exemplo:

public static double media(double... numeros)
{
	double total = 0;
	for(double d : numeros)
		total += d;
	return total / numeros.length;
}

/*---------------------------------------------------------------------------------------------------------*/
// ------------- CLASSE ArrayList (altera dinamicamente seu tamanho em tempo de execução, vantagem sobre array)

// Declaração:

ArrayList<T> list; // Onde T corresponde ao tipo de elementos que o ArrayList terá.

ArrayList<String> listStrings;
listStrings = new ArrayList<String>();

// adicionando elemento:
listStrings.add("red"); // acrescenta a string red ao arraylist
listStrings.add(0, "yellow"); // acrescenta a string yellow na posicção 0 do ArrayList

// remover elemento:
listStrings.remove("yellow"); // remove o primeiro yellow do arraylist
listStrings.remove(1); // remove o elemento da posição 1 do arraylist

// Outros métodos: clear, contains, get, indexOf, size, trimToSize, ...