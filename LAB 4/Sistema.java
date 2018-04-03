public class Sistema
{	
	private static final int MAX = 9999;
	Conta[] contas = new Conta[MAX];
	protected int n_contas;
	// cada um dos criar conta tem uma versao onde se coloca o credito diretamente, isso é sobrecarga
	void criarContaB(int id,double cred)//caso passado dois inteiros havera coercao
		{
			if(acharConta(id) == false)//testando para saber se ja existe conta com esse id
			{
				n_contas++;
				contas[id] = new Basic( id );
				contas[id].credito(cred);

			}
			else
			{
				System.out.println("Erro, já existe conta com o id "+ id);
			}

		}

	void criarContaB(int id)
	{
		if(acharConta(id) == false)//testando para saber se ja existe conta com esse id
		{
			n_contas++;
			contas[id] = new Basic( id );
		}
		else
		{
			System.out.println("Erro, já existe conta com o id "+ id);
		}

	}

	void criarContaP(int id,double cred)//caso passado dois inteiros havera coercao
	{
		if(acharConta(id) == false)//testando para saber se ja existe conta com esse id
		{
			contas[id] = new Plus( id);
			n_contas++;
			contas[id].credito(cred);
		}
		else
		{
			System.out.println("Erro, já existe conta com o id "+ id);
		}
	}

	void criarContaP(int id)
	{
		if(acharConta(id) == false)//testando para saber se ja existe conta com esse id
		{
			contas[id] = new Plus( id);
			n_contas++;
		}
		else
		{
			System.out.println("Erro, já existe conta com o id "+ id);
		}
	}
	void criarContaX(int id)
	{
		if(acharConta(id) == false)//testando para saber se ja existe conta com esse id
		{
			contas[id] = new Extreme( id);
			n_contas++;
		}
		else
		{
			System.out.println("Erro, já existe conta com o id "+ id);
		}
	}

	void criarContaX(int id,double cred)//caso passado dois inteiros havera coercao
	{
		if(acharConta(id) == false)//testando para saber se ja existe conta com esse id
		{
			contas[id] = new Extreme( id);
			n_contas++;
			contas[id].credito(cred);
		}
		else
		{
			System.out.println("Erro, já existe conta com o id "+ id);
		}
	}
	boolean acharConta(int x)//Teste para saber se a conta existe
	{	
		if(contas[x]!= null){	
					return true;
			}
		return false;
	}

	

	void credito(int id, double valor){

		if (acharConta(id)) {
			contas[id].credito(valor);
			
		}
		else{
			System.out.println("Conta a ser creditada não existe\n");

		}
	}
	

	void debito(int id, double valor){
		if (acharConta(id))
		{
			contas[id].debito(valor);
		}
		else
		{
			System.out.println("Conta a ser debitada não existe\n");
		}
	}

	
	void consultarSaldo(int id){
		if (acharConta(id))
		{
			contas[id].consultarSaldo();
		}
		else
		{
			System.out.println("Conta consultada não existe\n");
		}		



	}
}
