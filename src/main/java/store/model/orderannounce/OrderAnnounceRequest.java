package store.model.orderannounce;

public class OrderAnnounceRequest {

    private AnnounceCode code;
    private String name;
    private int amount;

    public OrderAnnounceRequest(AnnounceCode code, String name, int amount) {
        this.code = code;
        this.name = name;
        this.amount = amount;
    }

    public AnnounceCode getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }
}
