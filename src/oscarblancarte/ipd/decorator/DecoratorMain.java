package oscarblancarte.ipd.decorator;

import oscarblancarte.ipd.decorator.impl.decorators.SOAPEnvelopMessage;
import oscarblancarte.ipd.decorator.impl.message.IMessage;
import oscarblancarte.ipd.decorator.impl.decorators.EncryptMessage;
import oscarblancarte.ipd.decorator.impl.decorators.FirmaEmpresa;
import oscarblancarte.ipd.decorator.impl.message.CustomerMessage;
import oscarblancarte.ipd.decorator.impl.decorators.XMLFormatterDecorate;

/**
 *
 * @author Oscar Javier Blancarte Iturralde
 * @see http://www.oscarblancarteblog.com
 */
public class DecoratorMain {

    public static void main(String[] args) {
        
        CustomerMessage customerMessage = new CustomerMessage(
                "Oscar Blancarte", "oscarblancarte3@gmail.com", "554433445566");
        System.out.println("Original Message ==> " + customerMessage);
        
        IMessage message1 = new EncryptMessage("user", "HG58YZ3CR9123456", 
                new SOAPEnvelopMessage(
                    new XMLFormatterDecorate(customerMessage))).processMessage();
        System.out.println("message1 =====================================>\n" 
                + message1.getContent() + "\n\n");
        
        IMessage message2 = new SOAPEnvelopMessage(
                new EncryptMessage("user", "HG58YZ3CR9123456",
                    new XMLFormatterDecorate(customerMessage))).processMessage();
        System.out.println("message2 =====================================>\n" 
                + message2.getContent() + "\n\n");        

        IMessage message3 = new FirmaEmpresa("INTERAGUA S.A.",
                                             "Urdesa Norte - Parque Empresarial Colón 2022",
                                             "3704900",
                                             "interagua@hotmail.com",
                                             new XMLFormatterDecorate(customerMessage)).processMessage();
        System.out.println("mensaje3, con datos de la empresa ====================>\n" 
                + message3.getContent()
        );
    }
    
}