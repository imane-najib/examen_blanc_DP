package stage.ifm.entities;

import java.util.Date;

public class Transaction {
    private String id;
    private Date date;
    private Double montant;
    private TypeTransaction typeTransaction;

    public Transaction(){}
    public Transaction(String id, TypeTransaction typeTransaction, Double montant, Date date) {
        this.id = id;
        this.typeTransaction = typeTransaction;
        this.montant = montant;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public TypeTransaction getTypeTransaction() {
        return typeTransaction;
    }

    public void setTypeTransaction(TypeTransaction typeTransaction) {
        this.typeTransaction = typeTransaction;
    }

    public static class TransactionBuilder {
        private Transaction transaction = new Transaction();

        public TransactionBuilder id(String id) {
            this.transaction.id = id;
            return this;
        }
        public TransactionBuilder date(Date date) {
            this.transaction.date = date;
            return this;
        }
        public TransactionBuilder montant(Double montant) {
            this.transaction.montant = montant;
            return this;
        }
        public TransactionBuilder typeTransaction(TypeTransaction typeTransaction) {
            this.transaction.typeTransaction = typeTransaction;
            return this;
        }
        public Transaction build() {
            return this.transaction;
        }
    }


}
