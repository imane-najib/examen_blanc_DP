package stage.ifm;

import stage.ifm.entities.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Transaction transaction = TransactionDirector.TransactionBuilder()
                .id("1")
                .montant(1000.)
                .date(new Date())
                .typeTransaction(TypeTransaction.ACHAT)
                .build();
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(transaction);
        Agent agent = new Agent("agent1",transactions);
        Container container = Container.getInstance();
        container.AjouterAgent(agent);
        HDMIAfficheur hdmiAfficheur = new HDMIAfficheurImpl();

        container.setHDMIAfficheur(hdmiAfficheur);
        container.getHDMIAfficheur().AfficherAgents(container);

        VGAAdapter vgaAdapter = new VGAAdapter(new VGAAfficheurImpl());
        container.setHDMIAfficheur(vgaAdapter);
        container.getHDMIAfficheur().AfficherAgents(container);

    }
}