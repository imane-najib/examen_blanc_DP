package stage.ifm;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import stage.ifm.entities.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
@ComponentScan(basePackages = {"stage.ifm"})

@EnableAspectJAutoProxy(proxyTargetClass = true)
public class Main {
    public static void main(String[] args) {
        SecurityContext.authenticate("root","1234",new String[]{"USER"});
        /*Transaction transaction = TransactionDirector.TransactionBuilder()
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
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Main.class);

        HDMIAfficheur hdmiAfficheur = applicationContext.getBean(HDMIAfficheur.class);


        container.setHDMIAfficheur(hdmiAfficheur);
        container.getHDMIAfficheur().AfficherAgents(container);

        VGAAdapter vgaAdapter = new VGAAdapter(new VGAAfficheurImpl());
        container.setHDMIAfficheur(vgaAdapter);
        container.getHDMIAfficheur().AfficherAgents(container);*/
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Main.class);

        Agent agent = applicationContext.getBean(Agent.class);
        agent.setNom("agent");

        Transaction transaction = TransactionDirector.TransactionBuilder()
                .id("1")
                .montant(1000.)
                .date(new Date())
                .typeTransaction(TypeTransaction.ACHAT)
                .build();
        Transaction transaction1 = TransactionDirector.TransactionBuilder()
                .id("2")
                .montant(2000.)
                .date(new Date())
                .typeTransaction(TypeTransaction.VENTE)
                .build();
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(transaction);

        agent.setTransactions(transactions);

        System.out.println(agent.transactionGrandMon());
        System.out.println(agent.transactionGrandMon());
        transactions.add(transaction1);
        System.out.println(agent.transactionGrandMon());


    }
}