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