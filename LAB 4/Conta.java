public abstract class Conta
{	
	int id;
	double saldo;

	public abstract void credito(double valor);
	
	public abstract void debito(double valor);
	
	public double consultarSaldo()
	{
		return this.saldo;
	}


}