package XBeeSX;
import com.rapplogic.xbee.api.IXBee;
//import com.rapplogic.xbee.api.XBee;
import com.rapplogic.xbee.api.XBeeException;


public class XBee {

	public static void main(String[] args) throws XBeeException {
		// TODO Auto-generated method stub
		
		XBee xbee=new XBee();
		((IXBee) xbee).open("COM7", 115200);
		if (((IXBee) xbee).isConnected() == true) {
			System.out.println ("connect");
		}
		((IXBee) xbee).close();

	}

}
