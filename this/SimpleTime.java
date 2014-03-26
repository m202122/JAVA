// Exemplo do uso de this no construtor da classe.

class SimpleTime 
{
	private int hora, minuto, segundo;

	public SimpleTime(int hora, int minuto, int segundo)
	{
		this.hora = hora; 
			// 'this.hora' refere-se à variável de instância hora declarado na classe e 'hora' refere-se à 
			// variável passada como parâmetro.
		this.minuto = minuto;
		this.segundo = segundo;
	}
}