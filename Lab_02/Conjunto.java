//Jordan Ferreira da Silva-384360
//João Vitor Pinheiro do Nascimento-388837
//Italo Cavalcante de Abreu-397135
// 11/03/2018

class Conjunto
{
	Object conj[];
	int numElementos;
	int cont;
	int tam;
	int aux;
	int aux_2;
	int aux_primo;

	Conjunto()
	{
		this.conj = null;
	}

	Conjunto(int quant)
	{
		this.conj= new Object[quant];
		numElementos = quant;
	}

	void setConjunto( Object x)
	{		
			if (cont>=numElementos)
			{
				System.out.println("Erro, tamanho máximo obtido");
			}
			else
			{
				this.conj[cont] = x;
				cont ++;
			}
	}

	Object[] getConjunto()
	{
		return this.conj;
	}




	Object getElemento(int x)
	{
		return this.conj[x];
	}

	int getCont()
	{
		return this.cont;
	}

	boolean pertence(Object x)
	{
		for(int i = 0;i < this.cont;i ++)
		{
			if(this.conj[i].equals(x))
			{
				
				return true;
			}
		}

		return false;
	}
	//a.subconjunto(b)
	boolean subconjunto(Conjunto x )
	{
		if (this.cont>x.cont)
		{
			return false;
		}
		else
		{
			for(int i=0;i<this.cont;i++)
			{
				if (this.pertence(x.getElemento(i))==false) {
					return false;				
				}
			}
		}
		return true;
	}

	int getTamanho()
	{
		return this.cont;
	}
	
	Conjunto uniao(Conjunto x)
	{		
		Conjunto uni = new Conjunto(this.cont+x.getTamanho()-this.interseccao(x).getCont());
		for(int i=0;i<this.cont;i++)
		{
			
			uni.setConjunto(this.getElemento(i));
		}
		for(int i=0;i<x.cont;i++)
		{	
			if(!(uni.pertence(x.getElemento(i))))
				uni.setConjunto(x.getElemento(i));
		}
		return uni;
	}

	Conjunto interseccao(Conjunto x)
	{	
		tam=0;
		for(int i=0;i<this.cont;i++)
		{
			if(x.pertence(this.getElemento(i)))
			{
				tam ++;
			}
		}
		Conjunto inter = new Conjunto(tam);
		for(int i=0;i<this.cont;i++)
		{
			if(x.pertence(this.getElemento(i)))
			{
				inter.setConjunto(this.getElemento(i));
			}
		}	
		return inter;
	}

	Conjunto diferenca(Conjunto x)
	{
		tam = 0;
		for(int i=0;i<this.cont;i++)
		{
			if(!(x.pertence(this.getElemento(i))))
			{
				tam ++;
			}
		}
		Conjunto dif = new Conjunto(tam);
		
		for(int i=0; i<this.cont;i++)
		{
			if(!(x.pertence(this.getElemento(i))))
			{
				dif.setConjunto(this.getElemento(i));
			}
		}
		return dif;


	}
	
	/*Metodos para povoar conjuntos com os N primeiros elementos
	 de conjuntos comuns de números*/
	Conjunto naturais(int n)
	{	
		aux = 0;
		aux_2 = 0;
		//Teste para evitar overflow
		if(this.cont+n <= this.numElementos)
		{
			for (int i=this.cont ; i<n ; i++)
			{
				this.setConjunto(aux);
				aux++;
			}
		}
		else
		{
			System.out.println("Erro ao adicionar elemenos no Conjunto naturais : overflow\nSerão adicionados apenas "+(this.numElementos-this.cont)+" elementos");
			
			for (int i=this.cont ; i<this.numElementos ; i++ ) 
			{
				this.setConjunto(aux);
				aux++;
			}

		}
		return this;
	}
	
	Conjunto pares(int n)
	{
		aux = 0;
		aux_2 = 0;
		//Teste para evitar overflow
		if(this.cont+n <= this.numElementos)
		{
			while (aux_2<n)
			{
				if(aux%2 == 0)
				{	
					this.setConjunto(aux);
					aux_2++;
				}
				aux++;
			}
		}
		else
		{
			while (aux_2<this.numElementos)
			{
				if(aux%2 == 0)
				{	
					this.setConjunto(aux);
					aux_2++;
				}
				aux++;
			}

		}
		return this;
	}

	Conjunto impares(int n)
	{
		aux = 0;
		aux_2 = 0;
		//Teste para evitar overflow
		if(this.cont+n <= this.numElementos)
		{
			while (aux_2<n)
			{
				if(aux%2 != 0)
				{	
					this.setConjunto(aux);
					aux_2++;
				}
				aux++;
			}
		}
		else
		{
			while (aux_2<this.numElementos)
			{
				if(aux%2 != 0)
				{	
					this.setConjunto(aux);
					aux_2++;
				}
				aux++;
			}

		}
		return this;
	}

	Conjunto primos(int n)
	{
		aux = 2;
		aux_2 = 1;
		//Teste para evitar overflow
		if(this.cont+n <= this.numElementos)
		{	
			//testar quantidade de divisores de um numero
			while(aux_2<=n)
			{	
				aux_primo=0;

				for(int j=1;j<=aux;j++)
					if(aux%j== 0)
					{	
						aux_primo++;					
					}
				//se forem apenas 2, ele é primo.
				if(aux_primo == 2)
				{
					this.setConjunto(aux);
					aux_2++;				
				}
				aux++;
			}			
		}
		else
		{
			while (aux_2<this.numElementos)
			{	
				aux_primo=0;

				for(int j=1;j<=aux;j++)
					if(aux%j== 0)
					{	
						aux_primo++;					
					}
				if(aux_primo== 2)
				{
					this.setConjunto(aux);	
					aux_2++;			
				}
				aux++;
			}
		}
		return this;
	}

	void produto( Conjunto x)
	{	
		int comprimento=0;
		int limite = this.cont*x.getCont();

		Object produto [][]= new Object[limite][2];

		while(comprimento<limite)
		{
			for(int i=0;i<this.cont;i++)
			{
				for(int j = 0; j<x.getTamanho();j++)
				{
					produto[comprimento][0] = this.conj[i];
					produto[comprimento][1] = x.getElemento(j);
					comprimento++;
				}
			}
		}

		System.out.println("\nProduto Cartesiano:\n");
		for( int j=0;j<comprimento;j++)
		{
			System.out.println("("+produto[j][0]+","+produto[j][1]+")");
		}
	}

	void potencia()
		{

			int combinacoes = (int) Math.pow(2,this.cont);
			Object potencia[][] = new Object[combinacoes][this.cont];

			System.out.print("\nConjunto Potencia:\n{vazio} \n");
			for(int i=1; i<combinacoes; i++)
				{
					String num_binario = binario(i);
					int cont=0;
					System.out.print("{");
		
					for(int j=0; j<num_binario.length();j++)
					{

						if(num_binario.charAt(j)=='1')
						{
							potencia[i][cont] = this.conj[j];
							System.out.print(potencia[i][cont]+" ");
							cont++;[]
						}
					}
					System.out.print("}\n");
				}
		}
	
	 String binario(int numero)
	 {
		int d = numero;
		int b;
		String bin = ""; 
		while (d > 0) 
		{
			b = d % 2;
			bin+=b;
			d = d/2;
		}
		return bin;
	}



}

















