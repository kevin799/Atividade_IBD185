package br.gov.sp.fatec.view;

public class View {
	
	public static class ServidorIpNome{
		//TRAZER APENAS IP E NOME NO SERVIDOR
	}
	
	public static class ServidorHardware{
		//TRAZER PROCESSADOR, MEMORIA E ESPAÇO
	}
	
	public static class ServidorCompleto{
		//TRAZER TODOS OS ATRIBUTOS DO SERVIDOR
	}
	
	public static class BancoNomeTipo{
		//TRAZER TIPO DO BANCO
	}
	
	public static class BancoCompleto extends BancoNomeTipo{
		//TRAZER TODOS OS ATRIBUTOS DE BANCO
	}
	public static class UsuarioResumo {
	}
	
	/**
	 * Visualizacao com todos os atributos
	 * Inclui tudos os atributos marcados com Main
	 */
	public static class UsuarioCompleto extends UsuarioResumo {
	}
	
	/**
	 * Visualizacao alternativa
	 */
	public static class UsuarioResumoAlternativo {
	}
	
	public static class Anotacao {
	}
	
	public static class Autorizacao {
	}


}
