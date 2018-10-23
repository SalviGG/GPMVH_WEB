package portafolio.gpvh.objetos;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

public class ValidacionLogin {

    @NotEmpty
    @Length(min = 7, max = 8)
    private int rut;

    @NotEmpty
    @Length(min = 4, max = 16)
    private String password;

    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
        this.rut = rut;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
