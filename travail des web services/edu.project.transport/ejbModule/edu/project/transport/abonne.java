package edu.project.transport;

public class abonne extends utili {
private String mail;
private String password;
public String getMail() {
	return mail;
}
public void setMail(String mail) {
	this.mail = mail;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public abonne(String mail, String password) {
	super();
	this.mail = mail;
	this.password = password;
}
public abonne() {
	super();
}

}