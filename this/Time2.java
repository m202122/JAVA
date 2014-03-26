// Exemplo this: construtor sobrecarregado

// Construtor sobrecarregado: para sobrecarregar construtores basta fornecer múltiplas declarações de construtor
// com assinaturas diferentes. Compilador diferencia a assinatura dos métodos pelo número de parâmetros, por
// tipos dos parâmetros, e pela ordem dos tipos de parâmetro.

public class Time2
{
	private int hora, minuto, segundo;

	public Time2()
	{
		this(0,0,0); // primeiro construtor chama o quarto construtor
	}

	public Time2(int h)
	{
		this(h,0,0);
	}

	public Time2(int h, int m)
	{
		this(h,m,0);
	}

	public Time2(int h, int m, int s)
	{
		this(h,m,s);
	}

	public Time2(Time2 time)
	{
		this( time.getHora(), time.getMinuto(), time.getSegundo());
	}

	/*
		Implementação dos métodos getHora(), getMinuto(), getSegundo(), setHora(), setMinuto(), setSegundo()
	*/
}