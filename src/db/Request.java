package db;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import db.Keys;

@Entity
@Table(name="sb_request")
public class Request {
	@EmbeddedId
	Keys key=new Keys();
	int state;
	public void setReceiver(String receiver)
	{
		key.receiver = receiver;
	}
	public String getReceiver()
	{
		return key.receiver;
	}
	public void setSender(String sender)
	{
		key.sender=sender;
	}
	public String getSender()
	{
		return key.sender;
	}
	public void setState(int state)
	{
		this.state=state;
	}
	public int getState()
	{
		return state;
	}
}











