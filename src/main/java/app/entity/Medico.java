package app.entity;

import java.io.*;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFilter;
import cronapi.rest.security.CronappSecurity;
import cronapi.CronapiSearchable;


/**
 * Classe que representa a tabela MEDICO
 * @generated
 */
@Entity
@Table(name = "\"MEDICO\"")
@XmlRootElement
@CronappSecurity
@JsonFilter("app.entity.Medico")
public class Medico implements Serializable {

  /**
   * UID da classe, necessário na serialização
   * @generated
   */
  private static final long serialVersionUID = 1L;

  /**
   * @generated
   */
  @Id
  @Column(name = "cd_codigo_med", nullable = false, insertable=true, updatable=true)
  private java.lang.String cd_codigo_med = UUID.randomUUID().toString().toUpperCase();

  /**
  * @generated
  */
  @Column(name = "nr_cpf_med", nullable = false, unique = false, length=15, insertable=true, updatable=true)
  @CronapiSearchable
  
  private java.lang.String nr_cpf_med;

  /**
  * @generated
  */
  @Column(name = "nr_crm_med", nullable = false, unique = false, length=50, insertable=true, updatable=true)
  @CronapiSearchable
  
  private java.lang.String nr_crm_med;

  /**
  * @generated
  */
  @Column(name = "qt_hrsupervisao_med", nullable = false, unique = false, insertable=true, updatable=true)
  @CronapiSearchable
  
  private java.lang.Integer qt_hrsupervisao_med;

  /**
  * @generated
  */
  @Column(name = "qt_hrfinanceiro_med", nullable = false, unique = false, insertable=true, updatable=true)
  @CronapiSearchable
  
  private java.lang.Integer qt_hrfinanceiro_med;

  /**
  * @generated
  */
  @Column(name = "cd_status_med", nullable = false, unique = false, insertable=true, updatable=true)
  @CronapiSearchable
  
  private java.lang.Integer cd_status_med;

  /**
  * @generated
  */
  @ManyToOne
  @JoinColumn(name="fk_user", nullable = true, referencedColumnName = "id", insertable=true, updatable=true)
  
  private User user;

  /**
   * Construtor
   * @generated
   */
  public Medico(){
  }


  /**
   * Obtém cd_codigo_med
   * return cd_codigo_med
   * @generated
   */
  
  public java.lang.String getCd_codigo_med(){
    return this.cd_codigo_med;
  }

  /**
   * Define cd_codigo_med
   * @param cd_codigo_med cd_codigo_med
   * @generated
   */
  public Medico setCd_codigo_med(java.lang.String cd_codigo_med){
    this.cd_codigo_med = cd_codigo_med;
    return this;
  }

  /**
   * Obtém nr_cpf_med
   * return nr_cpf_med
   * @generated
   */
  
  public java.lang.String getNr_cpf_med(){
    return this.nr_cpf_med;
  }

  /**
   * Define nr_cpf_med
   * @param nr_cpf_med nr_cpf_med
   * @generated
   */
  public Medico setNr_cpf_med(java.lang.String nr_cpf_med){
    this.nr_cpf_med = nr_cpf_med;
    return this;
  }

  /**
   * Obtém nr_crm_med
   * return nr_crm_med
   * @generated
   */
  
  public java.lang.String getNr_crm_med(){
    return this.nr_crm_med;
  }

  /**
   * Define nr_crm_med
   * @param nr_crm_med nr_crm_med
   * @generated
   */
  public Medico setNr_crm_med(java.lang.String nr_crm_med){
    this.nr_crm_med = nr_crm_med;
    return this;
  }

  /**
   * Obtém qt_hrsupervisao_med
   * return qt_hrsupervisao_med
   * @generated
   */
  
  public java.lang.Integer getQt_hrsupervisao_med(){
    return this.qt_hrsupervisao_med;
  }

  /**
   * Define qt_hrsupervisao_med
   * @param qt_hrsupervisao_med qt_hrsupervisao_med
   * @generated
   */
  public Medico setQt_hrsupervisao_med(java.lang.Integer qt_hrsupervisao_med){
    this.qt_hrsupervisao_med = qt_hrsupervisao_med;
    return this;
  }

  /**
   * Obtém qt_hrfinanceiro_med
   * return qt_hrfinanceiro_med
   * @generated
   */
  
  public java.lang.Integer getQt_hrfinanceiro_med(){
    return this.qt_hrfinanceiro_med;
  }

  /**
   * Define qt_hrfinanceiro_med
   * @param qt_hrfinanceiro_med qt_hrfinanceiro_med
   * @generated
   */
  public Medico setQt_hrfinanceiro_med(java.lang.Integer qt_hrfinanceiro_med){
    this.qt_hrfinanceiro_med = qt_hrfinanceiro_med;
    return this;
  }

  /**
   * Obtém cd_status_med
   * return cd_status_med
   * @generated
   */
  
  public java.lang.Integer getCd_status_med(){
    return this.cd_status_med;
  }

  /**
   * Define cd_status_med
   * @param cd_status_med cd_status_med
   * @generated
   */
  public Medico setCd_status_med(java.lang.Integer cd_status_med){
    this.cd_status_med = cd_status_med;
    return this;
  }

  /**
   * Obtém user
   * return user
   * @generated
   */
  
  public User getUser(){
    return this.user;
  }

  /**
   * Define user
   * @param user user
   * @generated
   */
  public Medico setUser(User user){
    this.user = user;
    return this;
  }

  /**
   * @generated
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Medico object = (Medico)obj;
    if (cd_codigo_med != null ? !cd_codigo_med.equals(object.cd_codigo_med) : object.cd_codigo_med != null) return false;
    return true;
  }

  /**
   * @generated
   */
  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + ((cd_codigo_med == null) ? 0 : cd_codigo_med.hashCode());
    return result;
  }

}
