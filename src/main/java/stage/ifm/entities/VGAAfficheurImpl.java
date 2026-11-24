package stage.ifm.entities;

import org.springframework.stereotype.Component;
import stage.ifm.aspects.Log;

import java.util.HashMap;
import java.util.Map;


public class VGAAfficheurImpl implements VGAAfficheur {
    @Override
    public void VGAAfficheur(Container container) {
        System.out.println("VGAAfficheurImpl");
        HashMap<String,Agent> agents = container.getAgents();
        for (Map.Entry<String,Agent> entry : agents.entrySet()){
            System.out.println("Clé : " + entry.getKey());
            for (Transaction transaction : entry.getValue().getTransactions()){
                System.out.println(transaction.toString());
            }
        }
    }
}
