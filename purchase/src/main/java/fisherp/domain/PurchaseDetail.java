package fisherp.domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

//<<< DDD / Value Object
@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseDetail {

    @Embedded
    private ItemId itemId;

    private BigDecimal unitPrice;

    private Integer qty;
}
//>>> DDD / Value Object
