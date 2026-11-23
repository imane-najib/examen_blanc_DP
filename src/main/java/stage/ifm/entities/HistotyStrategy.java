package stage.ifm.entities;

import java.util.ArrayList;
import java.util.List;

public class HistotyStrategy implements IStrategy{
    @Override
    public void notifTraitement(String nom, Transaction transaction) {
        List<Transaction> transactionHistory = new ArrayList<Transaction>();
        System.out.println("HistotyStrategy notifTraitement pour argent "+nom);
        transactionHistory.add(transaction);
        System.out.println("TransationHistory Id "+transaction.getId()+" enregistré avec succes");
    }
}
