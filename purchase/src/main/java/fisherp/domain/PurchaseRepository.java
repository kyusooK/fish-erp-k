package fisherp.domain;

import fisherp.domain.*;
import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(collectionResourceRel = "purchases", path = "purchases")
public interface PurchaseRepository
    extends PagingAndSortingRepository<Purchase, Long> {
    @Query(
        value = "select purchase " +
        "from Purchase purchase " +
        "where(:accountId is null or purchase.accountId like %:accountId%) and (:mainShipName is null or purchase.mainShipName like %:mainShipName%) and (:purchaseDate is null or purchase.purchaseDate like %:purchaseDate%)"
    )
    List<Purchase> findByQueryPurchase(
        String accountId,
        String mainShipName,
        Date purchaseDate,
        Pageable pageable
    );
}
