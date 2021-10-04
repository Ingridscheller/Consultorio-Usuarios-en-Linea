package TO;

public class TOCitas {
    private int idCitas;
    private int idPacientesCitas;
    private int idAgendaMedico;

    public TOCitas() {
    }

    public TOCitas(int idCitas, int idPacientesCitas, int idAgendaMedico) {
        this.idCitas = idCitas;
        this.idPacientesCitas = idPacientesCitas;
        this.idAgendaMedico = idAgendaMedico;
    }

    public int getIdCitas() {
        return idCitas;
    }

    public void setIdCitas(int idCitas) {
        this.idCitas = idCitas;
    }

    public int getIdPacientesCitas() {
        return idPacientesCitas;
    }

    public void setIdPacientesCitas(int idPacientesCitas) {
        this.idPacientesCitas = idPacientesCitas;
    }

    public int getIdAgendaMedico() {
        return idAgendaMedico;
    }

    public void setIdAgendaMedico(int idAgendaMedico) {
        this.idAgendaMedico = idAgendaMedico;
    }
    
    
}
