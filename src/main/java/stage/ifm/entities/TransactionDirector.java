package stage.ifm.entities;

public class TransactionDirector {
    public static Transaction.TransactionBuilder TransactionBuilder() {
        return new Transaction.TransactionBuilder();
    }
}
