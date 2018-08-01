package com.bringto.data.model;

import java.io.Serializable;

public class MqResult implements Serializable {

	private static final long serialVersionUID = 1L;
	private String id;
	private String sistema;
	private String horarioColeta;
	private Integer status;
	private String statusDescription;
	private String conjuntoRobo;
	private String stepFalha;
	private Integer tipoFalha;
	private String tipoFalhaDescription;
	private Integer duracaoInspecao;
	private String urlEvidencia;

	public MqResult() {
		super();
	}

	public MqResult(String[] string, Integer id) {

		this.id = id.toString() + string[1];
		this.sistema = string[0];
		this.horarioColeta = string[1];
		if (null != string[2] && !"".equals(string[2]) && !"null".equals(string[2])) {
			this.status = Integer.valueOf((string[2]));
		}
		this.statusDescription = string[3];
		this.conjuntoRobo = string[4];
		this.stepFalha = string[5];
		if (null != string[6] && !"".equals(string[6]) && !"null".equals(string[6])) {
			this.tipoFalha = Integer.valueOf(string[6]);
		}
		this.tipoFalhaDescription = string[7];
		if (null != string[8] && !"".equals(string[8]) && !"null".equals(string[8])) {
			this.duracaoInspecao = Integer.valueOf(string[8]);
		}
		this.urlEvidencia = string[9];

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSistema() {
		return sistema;
	}

	public void setSistema(String sistema) {
		this.sistema = sistema;
	}

	public String getHorarioColeta() {
		return horarioColeta;
	}

	public void setHorarioColeta(String horarioColeta) {
		this.horarioColeta = horarioColeta;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getStatusDescription() {
		return statusDescription;
	}

	public void setStatusDescription(String statusDescription) {
		this.statusDescription = statusDescription;
	}

	public String getConjuntoRobo() {
		return conjuntoRobo;
	}

	public void setConjuntoRobo(String conjuntoRobo) {
		this.conjuntoRobo = conjuntoRobo;
	}

	public String getStepFalha() {
		return stepFalha;
	}

	public void setStepFalha(String stepFalha) {
		this.stepFalha = stepFalha;
	}

	public Integer getTipoFalha() {
		return tipoFalha;
	}

	public void setTipoFalha(Integer tipoFalha) {
		this.tipoFalha = tipoFalha;
	}

	public String getTipoFalhaDescription() {
		return tipoFalhaDescription;
	}

	public void setTipoFalhaDescription(String tipoFalhaDescription) {
		this.tipoFalhaDescription = tipoFalhaDescription;
	}

	public Integer getDuracaoInspecao() {
		return duracaoInspecao;
	}

	public void setDuracaoInspecao(Integer duracaoInspecao) {
		this.duracaoInspecao = duracaoInspecao;
	}

	public String getUrlEvidencia() {
		return urlEvidencia;
	}

	public void setUrlEvidencia(String urlEvidencia) {
		this.urlEvidencia = urlEvidencia;
	}

	@Override
	public String toString() {
		return "[id:" + id + ", sistema:" + sistema + ", horarioColeta:" + horarioColeta + ", status:" + status
				+ ", statusDescription:" + statusDescription + ", conjuntoRobo:" + conjuntoRobo + ", stepFalha:"
				+ stepFalha + ", tipoFalha:" + tipoFalha + ", tipoFalhaDescription:" + tipoFalhaDescription
				+ ", duracaoInspecao:" + duracaoInspecao + ", urlEvidencia:" + urlEvidencia + "]";
	}

}
