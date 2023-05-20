package principal;

import entity.ProfissionalEntity;

public class Profissional {

		private Integer codigo;
		
		private String nome;
		
		private Especializacao especializacao;
		
		private int telefone;
		
		private String endereco;

		private String email;
		
		public Profissional(ProfissionalEntity profissional) {
			this.nome = profissional.getNome();
			this.especializacao = profissional.getEspecializacao();
			this.telefone = profissional.getTelefone();
			this.endereco = profissional.getEndereco();
			this.email = profissional.getEmail();
		}
		
		public Profissional() {}
		
		public Profissional(String nome, Especializacao especializacao, int telefone, String endereco, String email) {
			this.nome = nome;
			this.especializacao = especializacao;
			this.telefone = telefone;
			this.endereco = endereco;
			this.email = email;
		}

		public String getEmail() {
			return email;
		}
		
		public void setEmail(String email) {
			this.email = email;
		}

		public Integer getCodigo() {
			return codigo;
		}

		public void setCodigo(Integer codigo) {
			this.codigo = codigo;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public Especializacao getEspecializacao() {
			return especializacao;
		}

		public void setEspecializacao(Especializacao especializacao) {
			this.especializacao = especializacao;
		}

		public int getTelefone() {
			return telefone;
		}

		public void setTelefone(int telefone) {
			this.telefone = telefone;
		}

		public String getEndereco() {
			return endereco;
		}

		public void setEndereco(String endereco) {
			this.endereco = endereco;
		}
}
