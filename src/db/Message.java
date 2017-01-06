package db;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sb_message")
public class Message {
	@Id
	String receiver;
	String sender,message;
	public void setReciever(String email)
	{
		this.receiver=receiver;
	}
	public String getReceiver()
	{
		return receiver;
	}
	public void setSender(String sender)
	{
		this.sender=sender;
	}
	public String getAddress()
	{
		return sender;
	}
	public void setMessage(String message)
	{
		this.message=message;
	}
	public String getMessage()
	{
		return message;
	}
}