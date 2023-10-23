package fisherp.domain;

import fisherp.PurchaseApplication;
import fisherp.domain.PurchaseCreated;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Purchase_table")
@Data
//<<< DDD / Aggregate Root
public class Purchase {

    @Id
    private String purchaseType;

    private LocalDate purchaseDate;

    private LocalDate warehouseArrivalDate;

    private LocalDate storageFeePaymentDate;

    private Boolean storageFeePaymentStatus;

    private String mainShipName;

    private String productName;

    @Embedded
    private AccountId accountId;

    @ElementCollection
    private List<PurchaseDetail> purchaseDetails;

    @PostPersist
    public void onPostPersist() {
        PurchaseCreated purchaseCreated = new PurchaseCreated(this);
        purchaseCreated.publishAfterCommit();
    }

    @PrePersist
    public void onPrePersist() {}

    public static PurchaseRepository repository() {
        PurchaseRepository purchaseRepository = PurchaseApplication.applicationContext.getBean(
            PurchaseRepository.class
        );
        return purchaseRepository;
    }
}
//>>> DDD / Aggregate Root