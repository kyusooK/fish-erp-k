package fisherp.domain;

import fisherp.PurchaseApplication;
import fisherp.domain.PurchaseCreated;
import java.time.LocalDate;
import java.util.ArrayList;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long purchaseNo;

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

    //<<< Clean Arch / Port Method
    public void sale(SaleCommand saleCommand) {
        //implement business logic here:
        List<PurchaseDetail> changed = new ArrayList<>();
        getPurchaseDetails().forEach(purchaseDetail -> {
            if(purchaseDetail.getItemId().getId().equals(saleCommand.getItemId())){
                purchaseDetail.setQty(purchaseDetail.getQty() - saleCommand.getQty());    
                changed.add(purchaseDetail);            
            }
        });

        if(changed.size()>0){
            repository().save(this);

            FishSold fishSold = new FishSold();
            fishSold.setItemId(saleCommand.getItemId());
            fishSold.setStock(changed.get(0).getQty());
            fishSold.publishAfterCommit();

        }else{
            throw new RuntimeException("해당 id 의 품목이 존재하지 않습니다");
        }
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
