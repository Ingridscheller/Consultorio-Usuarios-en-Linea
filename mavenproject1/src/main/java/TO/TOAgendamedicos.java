package TO;

import java.util.Date;

public class TOAgendamedicos {

    private int idAgendaMedicos;
    private int idMedicoAgenda;
    private Date fecha;
    private String hora;
    private String estado;

    public TOAgendamedicos() {
    }

    public TOAgendamedicos(Date fecha, String hora, String estado) {
        this.fecha = fecha;
        this.hora = hora;
        this.estado = estado;
    }

    public int getIdAgendaMedicos() {
        return idAgendaMedicos;
    }

    public void setIdAgendaMedicos(int idAgendaMedicos) {
        this.idAgendaMedicos = idAgendaMedicos;
    }

    public int getIdMedicoAgenda() {
        return idMedicoAgenda;
    }

    public void setIdMedicoAgenda(int idMedicoAgenda) {
        this.idMedicoAgenda = idMedicoAgenda;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

   
    }


