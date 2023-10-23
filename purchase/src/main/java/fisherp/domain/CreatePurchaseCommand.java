package fisherp.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class CreatePurchaseCommand {

    private String purchaseType;
    private String supplierCode;
    private LocalDate purchaseDate;
    private LocalDate warehouseArrivalDate;
    private LocalDate storageFeePaymentDate;
    private Boolean storageFeePaymentStatus;
    private String mainShipName;
    private String productName;
}
