package fr.adaming.model;

public class Client {

	private String nom;
	private String prenom;
	private int age;
	private String mail;

	public Client() {
	}

	public Client(String nom, String prenom, int age, String mail) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.mail = mail;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

}
