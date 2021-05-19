package br.com.mercado.estoque.config.validation;

public class ErrorFormDto {

	private String campo;
	private String error;

	public ErrorFormDto(String campo, String error) {
		this.campo = campo;
		this.error = error;
	}

	public String getCampo() {
		return campo;
	}

	public void setCampo(String campo) {
		this.campo = campo;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

}
