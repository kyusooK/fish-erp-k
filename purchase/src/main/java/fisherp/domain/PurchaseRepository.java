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
        "where (:accountId is null or purchase.accountId.id like %:accountId%) and (:mainShipName is null or purchase.mainShipName like %:mainShipName%) and (:purchaseDateFrom is null or purchase.purchaseDate > TO_DATE(:purchaseDateFrom, 'YYYY-MM-DD')) and (:purchaseDateTo is null or purchase.purchaseDate < TO_DATE(:purchaseDateTo, 'YYYY-MM-DD'))"
    )
    List<Purchase> findByQueryPurchase(
        AccountId accountId,
        String mainShipName,
        String purchaseDateFrom,
        String purchaseDateTo,
        Pageable pageable
    );
}
