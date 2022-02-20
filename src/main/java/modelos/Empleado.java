package modelos;

import java.util.Objects;

public class Empleado extends Persona {

    private String numTelefono;
    private Empresa empresa;
    private Contrato contrato;

    public Empleado() {
    }

    public Empleado(Empleado e) {
        super(e.getIdentificador(), e.getDni(), e.getNombre(), e.getApellidos(), e.getDireccion());
        this.numTelefono = e.getNumTelefono();
        this.empresa = e.getEmpresa();
        this.contrato = e.getContrato();
    }

    public Empleado(int identificador, String dni, String nombre, String apellidos, String direccion, String numTelefono, Empresa empresa, Contrato contrato) {
        super(identificador, dni, nombre, apellidos, direccion);
        this.numTelefono = numTelefono;
        this.empresa = empresa;
        this.contrato = contrato;
    }

    public String getNumTelefono() {
        return numTelefono;
    }

    public void setNumTelefono(String numTelefono) {
        this.numTelefono = numTelefono;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "identificador=" + super.getIdentificador() +
                ", dni='" + super.getDni() + '\'' +
                ", nombre='" + super.getNombre() + '\'' +
                ", apellidos='" + super.getApellidos() + '\'' +
                ", direccion='" + super.getDireccion() + '\'' +
                ", numTelefono='" + numTelefono + '\'' +
                ", empresa=" + empresa +
                ", contrato=" + contrato +
                '}';
    }

}
