package stage.ifm.entities;

import org.springframework.stereotype.Component;
import stage.ifm.aspects.Cachable;

import java.util.ArrayList;
import java.util.List;
@Component
public class Agent implements Observer,Observable{
    private String nom;
    private List<Transaction> transactions;
    private List<Observer> observers = new ArrayList<>();
    private IStrategy strategy = new ScoringStrategy();


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
        strategy.notifTraitement(nom,transaction);
    }

    public void AjouterTransaction(Transaction transaction){
        transactions.add(transaction);
        this.notifyObservers(this.nom,transaction);
    }

    @Override
    public String toString() {
        return "Agent{" +
                "nom='" + nom + '\'' +
                ", transactions=" + transactions +
                '}';
    }

    @Cachable
    public Transaction transactionGrandMon(){
        System.out.println("PREMIER");
        Transaction max = transactions.get(0);
        for (Transaction transaction : transactions) {

            if(transaction.getMontant() > max.getMontant()){
                max = transaction;
            }
        }
        return max;
    }
}
