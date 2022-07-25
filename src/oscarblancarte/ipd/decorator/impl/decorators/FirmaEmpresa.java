package oscarblancarte.ipd.decorator.impl.decorators;

import oscarblancarte.ipd.decorator.impl.message.IMessage;

/**
 *
 * @author ronny
 */
public class FirmaEmpresa extends MessageDecorator {
    
    private String empresa;
    private String direccion;
    private String telefono;
    private String correo;
    
    public FirmaEmpresa(String empresa, String direccion, String telefono, String correo, IMessage message) {
        super(message);
        this.empresa = empresa;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;       
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    @Override
    public IMessage processMessage() {
        message.processMessage();
        message = firmaEmpresa();
        return message;    }
    
    private IMessage firmaEmpresa() {
        String soap = message.getContent()
                + "\n\n\n"
                + "Empresa{" + "name=" + empresa + "\ndirección=" + direccion + "\ntelefono=" + telefono + "\ncorreo=" + correo + "}";
        message.setContent(soap);
        return message;
    }
    
}
