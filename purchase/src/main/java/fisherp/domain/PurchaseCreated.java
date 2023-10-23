package fisherp.domain;

import fisherp.domain.*;
import fisherp.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class PurchaseCreated extends AbstractEvent {

    private String purchaseType;
    private String supplierCode;
    private LocalDate purchaseDate;
    private LocalDate warehouseArrivalDate;
    private LocalDate storageFeePaymentDate;
    private Boolean storageFeePaymentStatus;
    private String mainShipName;
    private String productName;
    private String supplierCode;
    private LocalDate purchaseDate;
    private LocalDate warehouseArrivalDate;
    private LocalDate storageFeePaymentDate;
    private Boolean storageFeePaymentStatus;
    private String mainShipName;
    private String productName;

    public PurchaseCreated(Purchase aggregate) {
        super(aggregate);
    }

    public PurchaseCreated() {
        super();
    }
}
//>>> DDD / Domain Event
