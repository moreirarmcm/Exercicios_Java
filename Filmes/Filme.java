package calculandoDias;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * Problema proposto: Fulano tem uma lista L de filmes para assistir e gostaria
 * de saber quantos dias ele levará para assistir todos os filmes, considerando
 * que ele possui t horas por dia, e vai terminar de assistir cada filme no
 * mesmo dia que começou. A lista L de filmes é composta pelo nome e tempo de cada
 * filme, em float. O tamanho de L é definido pelo próprio Fulano.
 * 
 * Resolução fornecida: ordenar a lista L pelo método Bubble Sort e depois somar
 * valores da extremidade do list até 'soma > t'.
 * 
 * @author Renan Moreira
 * 
 */

public class Filme {
	String nome_filme;
	float duracao_filme;
	static int dias = 0;
	static List<Filme> filmes;

	public Filme(String nome, float duracao) {
		this.nome_filme = nome;
		this.duracao_filme = duracao;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		filmes = new ArrayList<Filme>();
		int novo_filme = 0;
		//Recebe os filmes
		/*
		do {
			System.out.println("Digite o nome do próximo filme: ");
			String name = sc.nextLine();
			System.out.println("Qual a duração do filme '" + name + "'?");
			float duration = 0;
			try {
				duration = Float.parseFloat(sc.nextLine());
				filmes.add(new Filme(name, duration));
			} catch (Exception e) {
				System.out.println("Náo foi possível reconhecer o valor de duração para o filme '" + name + "'.");
			}
			System.out.println("Deseja inserir um novo filme?\n <1 para 'SIM'    0 para 'NÃO'> ");
			novo_filme = Integer.parseInt(sc.nextLine());
		} while (novo_filme == 1);
		*/
		filmes.add(new Filme("Alien vs. Predador", 2.3f));
		filmes.add(new Filme("Batman: The Dark Knight", 1.5f));
		filmes.add(new Filme("Winx", 2.6f));
		filmes.add(new Filme("Vingadores", 2.1f));
		filmes.add(new Filme("Beleza Oculta", 1.7f));
		filmes.add(new Filme("Top Gun: Maverick", 2.8f));
		filmes.add(new Filme("O Curioso caso de Benjamin Button", 3.1f));
		filmes.add(new Filme("O Ilusionista", 1.7f));
		filmes.add(new Filme("Pantera Negra", 2.4f));
		filmes.add(new Filme("Avatar", 3.15f));
		
		filmes.sort(Comparator.comparing(f -> f.getDuracao()));
		System.out.println("Quantas horas diárias você tem disponível para assistir filmes?");
		float tempo_diario = sc.nextFloat();
		System.out.println("Você conseguirá assistir todos os filmes em " + QuantosDias(tempo_diario) + " dias.");
	}

	public static int QuantosDias(float tempo_diario) {
		float total_horas = 0;
		int posicao_soma = filmes.size() - 1;
		do {
			int posicao_final = filmes.size() - 1;
			posicao_soma--;
			if (filmes.get(posicao_final).getDuracao() + filmes.get(posicao_soma).getDuracao() <= tempo_diario) {
				total_horas += filmes.get(posicao_final).getDuracao() + filmes.get(posicao_soma).getDuracao();
				filmes.get(posicao_soma).setDuracao(total_horas);
				filmes.remove(posicao_final);
			}
		} while (posicao_soma > 0);
		Filme.dias++;
		filmes.remove(filmes.size() - 1);

		if (filmes.size() > 1) {
			QuantosDias(tempo_diario);
		} else if (filmes.size() <= 1) {
			Filme.dias++;
		}
		return Filme.dias;
	}

	public String getNome() {
		return this.nome_filme;
	}

	public float getDuracao() {
		return this.duracao_filme;
	}

	public void setDuracao(float nova_duracao) {
		this.duracao_filme = nova_duracao;
	}

	@Override
	public String toString() {
		return "{" + this.getNome() + " - " + this.getDuracao() + "}";
	}
}
