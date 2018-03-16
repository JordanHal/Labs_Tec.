//Jordan Ferreira da Silva-384360
//João Vitor Pinheiro do Nascimento-388837
//Italo Cavalcante de Abreu-397135
// 11/03/2018

import java.util.Arrays;
public class Main_C
{
	public static void main(String args[])
	{	
		int cont = 0;
	
		//Instanciando os conjuntos
		Conjunto naturais = new Conjunto(10);
		Conjunto pares = new Conjunto(5);
		Conjunto impares = new Conjunto(5);
		Conjunto primos = new Conjunto(10);
		Conjunto universo = new Conjunto(50);

		/*Povoando os conjuntos com os N primeiros elementos 
		dos conjuntos básicos*/
		naturais.naturais(10);
		pares.pares(5);
		impares.impares(5);
		primos.primos(10);

		//50 primeiros numeros inteiros positivos = 50 primeiross numeros naturais.
		universo.naturais(50);

		//Testes

		//a.Se o conjunto 4 é subconjunto de si mesmo;
		if(primos.subconjunto(primos))
		{
			System.out.println("\nO conjunto 4 (primos) é subconjunto de si mesmo\n\n");
		}
		else
		{
			System.out.println("\nO conjunto 4 (primos) não é subconjunto de si mesmo\n\n");
		}

		//b.A pertinência dos numeros 2, 3 e 4 no conjunto 1
		if(naturais.pertence(2) && naturais.pertence(3) && naturais.pertence(4))
		{
			System.out.println("O elementos 2, 3 e 4 pertencem ao conjunto dos naturais\n\n");
		}
		else
		{
			System.out.println("O elementos 2, 3 e 4 não pertencem ao conjunto dos naturais\n\n");
		}

		//c.Se aunião de 2 e 3 é igual ao conjunto 1
		//Primeiro testar se tem a mesma quantidade de elementos
		if(pares.uniao(impares).getTamanho()== naturais.getTamanho())
		{	
			//se forem do mesmo tamanho e um for  subconjunto do outro, eles são iguais. 
			if(pares.uniao(impares).subconjunto(naturais))
			{
				System.out.println("A união dos conjuntos impares e pares é igual ao conjunto naturais\n\n");
			}
		}
		else
		{
			System.out.println("A união dos conjuntos impares e pares não é igual ao conjunto naturais\n\n");
		}

		//d.Se a intersecção dos conjuntos 1 e 2 é vazia;
		if(naturais.interseccao(pares).getTamanho()==0)
		{
			System.out.println("A intersecção dos conjuntos naturais e pares é vazia\n\n");
		}
		else
		{
			System.out.println("A intersecção dos conjuntos naturais e pares não é vazia\n\n");

		}

		//e.Qual diferença entre osconjuntos 1 e 2
		System.out.println("A diferença entre os conjuntos naturais e pares è:\n");
		for(int i=0;i<impares.getTamanho();i++)
		{
			System.out.println(naturais.diferenca(pares).getElemento(i)+"\n\n");
		}

		//Teste do Metodos de produtos cartesianos entre 2 conjuntos
		//pares.produto(impares);

		//Teste do metodo de conjunto potencia
		//pares.potencia();

		//Lei de Morgan
		Object negacao_A_interseccao_negacao_B []= universo.diferenca(pares).interseccao(universo.diferenca(impares)).getConjunto();////¬A inter ¬B
		Object negacao_A_uniao_B[]= universo.diferenca(pares.uniao(impares)).getConjunto();// ¬( A u B)

		Object negacao_A_uniao_negacao_B []= universo.diferenca(pares).uniao(universo.diferenca(impares)).getConjunto();//¬A u ¬B
		Object negacao_A_interseccao_B[] = universo.diferenca(pares.interseccao(impares)).getConjunto();//¬(A inter B)


		Arrays.sort(negacao_A_uniao_negacao_B);

		if(Arrays.toString(negacao_A_uniao_B).equals(Arrays.toString(negacao_A_interseccao_negacao_B)))
		{
			if(Arrays.toString(negacao_A_interseccao_B).equals(Arrays.toString(negacao_A_uniao_negacao_B)))
			{
					System.out.println("As lei de Morgan sao válidas");
			}
		}
		else
		{
				System.out.println(" As Leis de Morgan não são válidas\n");
		}

	}

	

}



