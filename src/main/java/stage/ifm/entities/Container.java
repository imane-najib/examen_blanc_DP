package stage.ifm.entities;

import java.util.HashMap;

public class Container {
    private HashMap<String,Agent> agents = new HashMap<>();
    private static final Container container;
    private HDMIAfficheur HDMIAfficheur;
    static {
        container = new Container();
    }

    public void AjouterAgent(Agent agent) {
        agents.put(agent.getNom(),agent);
    }
    public void SupprimerAgent(Agent agent) {
        agents.remove(agent.getNom());
    }

    public Agent RechercherAgent(String nom) {
        Agent agent = agents.get(nom);
        return agent;
    }
    public static Container getInstance() {
        return container;
    }

    public HashMap<String, Agent> getAgents() {
        return agents;
    }

    public void setAgents(HashMap<String, Agent> agents) {
        this.agents = agents;
    }

    public HDMIAfficheur getHDMIAfficheur() {
        return HDMIAfficheur;
    }

    public void setHDMIAfficheur(HDMIAfficheur HDMIAfficheur) {
        this.HDMIAfficheur = HDMIAfficheur;
    }
}
