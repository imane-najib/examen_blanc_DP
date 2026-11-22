package stage.ifm.entities;

public interface Observable {
    void subscribe(Observer observer);

    void unsubscribe(Observer observer);

    void notifyObservers(String nom,Transaction transaction);
}
