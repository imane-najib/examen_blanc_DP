package stage.ifm.entities;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HDMIAfficheurImpl implements HDMIAfficheur {
    @Override
    public void AfficherAgents(Container container) {
        System.out.println("HDMIAfficheurImpl");
        HashMap<String,Agent> agents = container.getAgents();
        for (Map.Entry<String,Agent> entry : agents.entrySet()){
            System.out.println("Clé : " + entry.getKey());
            for (Transaction transaction : entry.getValue().getTransactions()){
                System.out.println(transaction.toString());
            }
        }
    }
}
