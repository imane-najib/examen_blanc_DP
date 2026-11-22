package stage.ifm.entities;

import java.util.ArrayList;
import java.util.List;

public class Agent {
    private String nom;
    private List<Transaction> transactions;

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
}
