public class Basic extends Conta //<- inclusao
{
	

	Basic(int contid)
	{
		this.saldo = 0;
		this.id = contid;
	}

	public String toString()
	{
		return "Basic: "+getId() + "\n"+getSaldo();
	}


	public int getId()
	{
		return this.id;
	}

	public double getSaldo()
	{
		return this.saldo;
	}

	public void credito(double valor)
	{
		this.saldo += valor;
	}

	public void debito(double valor)
	{
		if (this.saldo<valor)//Teste para saber se existe saldo suficiente para fazer o debito
		{
			System.out.println("Impossivel, valor de debito maior do que o disponivel");

		}
		else
		{
			this.saldo -= valor;
		}

	}

}
