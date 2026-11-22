package stage.ifm.entities;

import java.util.ArrayList;
import java.util.List;

public class Agent implements Observer,Observable{
    private String nom;
    private List<Transaction> transactions;
    private List<Observer> observers = new ArrayList<>();

    public Agent(String nom, List<Transaction> transactions) {
        this.nom = nom;
        this.transactions = transactions;
    }
    public Agent(){}
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    @Override
    public void subscribe(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unsubscribe(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String nom, Transaction transaction) {
        for (Observer observer : observers) {
            observer.update(nom,transaction);
        }
    }

    @Override
    public void update(String nom, Transaction transaction) {

    }

    public void AjouterTransaction(Transaction transaction){
        transactions.add(transaction);
        this.notifyObservers(this.nom,transaction);
    }
}
