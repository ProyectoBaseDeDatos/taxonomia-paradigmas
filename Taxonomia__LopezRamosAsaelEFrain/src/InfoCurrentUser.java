public class InfoCurrentUser {
    //clase para guaradar informacion del usuario que inicio sesion
    private int idPersona;
    private String correo;

    public InfoCurrentUser(int idPersona, String correo) {
        this.idPersona = idPersona;
        this.correo = correo;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }   
}
