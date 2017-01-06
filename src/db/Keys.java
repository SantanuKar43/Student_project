package db;
import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class Keys implements Serializable {
	public  String receiver,sender;
	
	public Keys(){
		receiver="";
		sender="";
	}
	public Keys(String receiver,String sender)
	{
		this.receiver=receiver;
		this.sender=sender;
	}
	

}
