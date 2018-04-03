	/*Italo Cavalcante de Abreu:397135- Classe abstrata Conta, Sistema
	João Vitor Pinheiro Nascimento:388837- main e questao 5 
	Jordan Ferreira:384360- Classes Basic,Extreme,Plus,*/

public class Main{
	public static void main(String args[]){	
		Sistema s = new Sistema();
		s.criarContaB(1);
		s.criarContaP(2);
		s.criarContaX(3);

		for(int i=1; i<=3; i++){
			s.credito(i,1000);
		}

		for(int i=1; i<=3; i++){
			s.debito(i,10);
		}
		
		/*teste para printar os valors das contas
		System.out.println(s.contas[1].consultarSaldo()+"\n"+s.contas[2].consultarSaldo()+"\n"+s.contas[3].consultarSaldo());*/
		

		if (s.contas[1].consultarSaldo() == 990 && s.contas[2].consultarSaldo() == 995 && s.contas[3].consultarSaldo() == 992.02){
			System.out.println("Certo");
		}
		else System.out.println("errado");

	}
}
