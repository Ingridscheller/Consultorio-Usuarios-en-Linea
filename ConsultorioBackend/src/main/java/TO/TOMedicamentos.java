package TO;

public class TOMedicamentos {
  private int idMedicamentos ;
  private String nombreMedicamento;
  private String presentacion;

    public TOMedicamentos() {
    }

    public TOMedicamentos(String nombreMedicamento, String presentacion) {
        this.nombreMedicamento = nombreMedicamento;
        this.presentacion = presentacion;
    }

    public int getIdMedicamentos() {
        return idMedicamentos;
    }

    public void setIdMedicamentos(int idMedicamentos) {
        this.idMedicamentos = idMedicamentos;
    }

    public String getNombreMedicamento() {
        return nombreMedicamento;
    }

    public void setNombreMedicamento(String nombreMedicamento) {
        this.nombreMedicamento = nombreMedicamento;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

  
}
