package app.dao;

import app.entity.*;
import java.util.*;
import org.springframework.stereotype.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.domain.*;
import org.springframework.data.repository.query.*;
import org.springframework.transaction.annotation.*; 


/**
 * Realiza operação de Create, Read, Update e Delete no banco de dados.
 * Os métodos de create, edit, delete e outros estão abstraídos no JpaRepository
 * 
 * @see org.springframework.data.jpa.repository.JpaRepository
 * 
 * @generated
 */
@Repository("MedicoDAO")
@Transactional(transactionManager="app-TransactionManager")
public interface MedicoDAO extends JpaRepository<Medico, java.lang.String> {

  /**
   * Obtém a instância de Medico utilizando os identificadores
   * 
   * @param cd_codigo_med
   *          Identificador 
   * @return Instância relacionada com o filtro indicado
   * @generated
   */    
  @Query("SELECT entity FROM Medico entity WHERE entity.cd_codigo_med = :cd_codigo_med")
  public Medico findOne(@Param(value="cd_codigo_med") java.lang.String cd_codigo_med);

  /**
   * Remove a instância de Medico utilizando os identificadores
   * 
   * @param cd_codigo_med
   *          Identificador 
   * @return Quantidade de modificações efetuadas
   * @generated
   */    
  @Modifying
  @Query("DELETE FROM Medico entity WHERE entity.cd_codigo_med = :cd_codigo_med")
  public void delete(@Param(value="cd_codigo_med") java.lang.String cd_codigo_med);


      
  /**
   * OneToMany Relation - Searchable fields - General search (Only strings fields)
   * @generated
   */
  @Query("SELECT entity FROM Agenda entity WHERE entity.medico.cd_codigo_med = :cd_codigo_med AND (:search = :search)")
  public Page<Agenda> findAgendaGeneralSearch(@Param(value="search") java.lang.String search, @Param(value="cd_codigo_med") java.lang.String cd_codigo_med, Pageable pageable);

  /** 
   * OneToMany Relation - Searchable fields - Specific search
   * @generated
   */
  @Query("SELECT entity FROM Agenda entity WHERE entity.medico.cd_codigo_med = :cd_codigo_med AND (:dt_agenda_age is null OR entity.dt_agenda_age = :dt_agenda_age) AND (:cd_status_age is null OR entity.cd_status_age = :cd_status_age)")
  public Page<Agenda> findAgendaSpecificSearch(@Param(value="cd_codigo_med") java.lang.String cd_codigo_med, @Param(value="dt_agenda_age") java.util.Date dt_agenda_age, @Param(value="cd_status_age") java.lang.Integer cd_status_age, Pageable pageable);

  /**
   * OneToMany Relation
   * @generated
   */
  @Query("SELECT entity FROM Agenda entity WHERE entity.medico.cd_codigo_med = :cd_codigo_med")
  public Page<Agenda> findAgenda(@Param(value="cd_codigo_med") java.lang.String cd_codigo_med, Pageable pageable);

  
  /**
   * Searchable fields - General search (Only strings fields)
   * @generated
   */
  @Query("SELECT entity FROM Medico entity WHERE entity.nr_cpf_med like concat('%',coalesce(:search,''),'%') OR entity.nr_crm_med like concat('%',coalesce(:search,''),'%')")
  public Page<Medico> generalSearch(@Param(value="search") java.lang.String search, Pageable pageable);

  /**
   * Searchable fields - Specific search
   * @generated
   */
  @Query("SELECT entity FROM Medico entity WHERE (:nr_cpf_med is null OR entity.nr_cpf_med like concat('%',:nr_cpf_med,'%')) AND (:nr_crm_med is null OR entity.nr_crm_med like concat('%',:nr_crm_med,'%')) AND (:qt_hrsupervisao_med is null OR entity.qt_hrsupervisao_med = :qt_hrsupervisao_med) AND (:qt_hrfinanceiro_med is null OR entity.qt_hrfinanceiro_med = :qt_hrfinanceiro_med) AND (:cd_status_med is null OR entity.cd_status_med = :cd_status_med)")
  public Page<Medico> specificSearch(@Param(value="nr_cpf_med") java.lang.String nr_cpf_med, @Param(value="nr_crm_med") java.lang.String nr_crm_med, @Param(value="qt_hrsupervisao_med") java.lang.Integer qt_hrsupervisao_med, @Param(value="qt_hrfinanceiro_med") java.lang.Integer qt_hrfinanceiro_med, @Param(value="cd_status_med") java.lang.Integer cd_status_med, Pageable pageable);
  
  /**
   * Foreign Key user
   * @generated
   */
  @Query("SELECT entity FROM Medico entity WHERE entity.user.id = :id")
  public Page<Medico> findMedicosByUser(@Param(value="id") java.lang.String id, Pageable pageable);

}
