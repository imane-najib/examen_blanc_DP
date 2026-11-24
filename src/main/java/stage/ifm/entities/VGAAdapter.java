package stage.ifm.entities;

import org.springframework.stereotype.Component;


public class VGAAdapter implements HDMIAfficheur {
    private VGAAfficheur vgaAfficheur;

    public VGAAdapter(VGAAfficheur vgaAfficheur) {
        this.vgaAfficheur = vgaAfficheur;
    }


    @Override
    public void AfficherAgents(Container container) {
        vgaAfficheur.VGAAfficheur(container);
    }
}
