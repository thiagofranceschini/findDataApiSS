package com.bringto.data.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "inspections")
public class Inspection implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "NUMERIC(19,0)")
	private Long id;
	private Integer version;
	private String name;
	private String description;
	private Integer id_inspection_type;
	@Column(name = "id_schedule")
	private Long idSchedule;
	private Integer id_location;
	private Integer id_agent_pool;
	private Integer id_swift_agent_pool;
	private Integer timeout;
	private Boolean recurring;
	private Boolean enabled;
	private Boolean inspect_downtime;
	private Integer debounce;
	private Integer id_inspection_scope;
	private Integer id_result_threshold;
	private Integer id_base_inspection;
	private Integer delete_time;
	private Integer id_ts_credential;

	public Inspection() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getId_inspection_type() {
		return id_inspection_type;
	}

	public void setId_inspection_type(Integer id_inspection_type) {
		this.id_inspection_type = id_inspection_type;
	}

	public Long getIdSchedule() {
		return idSchedule;
	}

	public void setIdSchedule(Long idSchedule) {
		this.idSchedule = idSchedule;
	}

	public Integer getId_location() {
		return id_location;
	}

	public void setId_location(Integer id_location) {
		this.id_location = id_location;
	}

	public Integer getId_agent_pool() {
		return id_agent_pool;
	}

	public void setId_agent_pool(Integer id_agent_pool) {
		this.id_agent_pool = id_agent_pool;
	}

	public Integer getId_swift_agent_pool() {
		return id_swift_agent_pool;
	}

	public void setId_swift_agent_pool(Integer id_swift_agent_pool) {
		this.id_swift_agent_pool = id_swift_agent_pool;
	}

	public Integer getTimeout() {
		return timeout;
	}

	public void setTimeout(Integer timeout) {
		this.timeout = timeout;
	}

	public Boolean getRecurring() {
		return recurring;
	}

	public void setRecurring(Boolean recurring) {
		this.recurring = recurring;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Boolean getInspect_downtime() {
		return inspect_downtime;
	}

	public void setInspect_downtime(Boolean inspect_downtime) {
		this.inspect_downtime = inspect_downtime;
	}

	public Integer getDebounce() {
		return debounce;
	}

	public void setDebounce(Integer debounce) {
		this.debounce = debounce;
	}

	public Integer getId_inspection_scope() {
		return id_inspection_scope;
	}

	public void setId_inspection_scope(Integer id_inspection_scope) {
		this.id_inspection_scope = id_inspection_scope;
	}

	public Integer getId_result_threshold() {
		return id_result_threshold;
	}

	public void setId_result_threshold(Integer id_result_threshold) {
		this.id_result_threshold = id_result_threshold;
	}

	public Integer getId_base_inspection() {
		return id_base_inspection;
	}

	public void setId_base_inspection(Integer id_base_inspection) {
		this.id_base_inspection = id_base_inspection;
	}

	public Integer getDelete_time() {
		return delete_time;
	}

	public void setDelete_time(Integer delete_time) {
		this.delete_time = delete_time;
	}

	public Integer getId_ts_credential() {
		return id_ts_credential;
	}

	public void setId_ts_credential(Integer id_ts_credential) {
		this.id_ts_credential = id_ts_credential;
	}

}
