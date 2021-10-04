package TO;

import java.util.Date;

public class TOHistoriaclinica {
  private int idhistoriaClinica;
  private String antecedentes;
  private String motivoConsulta;
  private String signosVitales;
  private String diagnostico;
  private String tratamiento;
  private String ordenesMedicas;
  private Date proximoControl;
  private String ordenLaboratorios;
  private String ordenImagenesDiagnosticas;
  private int idHistoriaCita;

    public TOHistoriaclinica() {
    }

    public TOHistoriaclinica( String antecedentes, String motivoConsulta, String signosVitales, String diagnostico, String tratamiento, String ordenesMedicas, Date proximoControl, String ordenLaboratorios, String ordenImagenesDiagnosticas, int idHistoriaCita) {
        
        this.antecedentes = antecedentes;
        this.motivoConsulta = motivoConsulta;
        this.signosVitales = signosVitales;
        this.diagnostico = diagnostico;
        this.tratamiento = tratamiento;
        this.ordenesMedicas = ordenesMedicas;
        this.proximoControl = proximoControl;
        this.ordenLaboratorios = ordenLaboratorios;
        this.ordenImagenesDiagnosticas = ordenImagenesDiagnosticas;
        this.idHistoriaCita = idHistoriaCita;
    }

    public int getIdhistoriaClinica() {
        return idhistoriaClinica;
    }

    public void setIdhistoriaClinica(int idhistoriaClinica) {
        this.idhistoriaClinica = idhistoriaClinica;
    }

    public String getAntecedentes() {
        return antecedentes;
    }

    public void setAntecedentes(String antecedentes) {
        this.antecedentes = antecedentes;
    }

    public String getMotivoConsulta() {
        return motivoConsulta;
    }

    public void setMotivoConsulta(String motivoConsulta) {
        this.motivoConsulta = motivoConsulta;
    }

    public String getSignosVitales() {
        return signosVitales;
    }

    public void setSignosVitales(String signosVitales) {
        this.signosVitales = signosVitales;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public String getOrdenesMedicas() {
        return ordenesMedicas;
    }

    public void setOrdenesMedicas(String ordenesMedicas) {
        this.ordenesMedicas = ordenesMedicas;
    }

    public Date getProximoControl() {
        return proximoControl;
    }

    public void setProximoControl(Date proximoControl) {
        this.proximoControl = proximoControl;
    }

    public String getOrdenLaboratorios() {
        return ordenLaboratorios;
    }

    public void setOrdenLaboratorios(String ordenLaboratorios) {
        this.ordenLaboratorios = ordenLaboratorios;
    }

    public String getOrdenImagenesDiagnosticas() {
        return ordenImagenesDiagnosticas;
    }

    public void setOrdenImagenesDiagnosticas(String ordenImagenesDiagnosticas) {
        this.ordenImagenesDiagnosticas = ordenImagenesDiagnosticas;
    }

    public int getIdHistoriaCita() {
        return idHistoriaCita;
    }

    public void setIdHistoriaCita(int idHistoriaCita) {
        this.idHistoriaCita = idHistoriaCita;
    }
  
  
}
