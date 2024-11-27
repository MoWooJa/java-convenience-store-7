package store;

import java.util.ArrayList;
import java.util.List;

public class Receipt {
    List<OrderRecord> orderRecords;

    public Receipt() {
        orderRecords = new ArrayList<>();
    }

    public void addRecord(OrderRecord record) {
        orderRecords.add(record);
    }
}
