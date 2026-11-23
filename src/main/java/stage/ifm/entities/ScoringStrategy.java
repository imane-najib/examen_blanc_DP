package stage.ifm.entities;

public class ScoringStrategy implements IStrategy {
    @Override
    public void notifTraitement(String nom, Transaction transaction) {
        System.out.println("ScoringStrategy notifTraitement pour agent "+nom);
        double solde = 0;
        if (Math.random() > 0.5) {
            solde+=transaction.getMontant();
        }else {
            solde-=transaction.getMontant();
        }
        System.out.println("ScoringStrategy solde = "+solde);

    }
}
