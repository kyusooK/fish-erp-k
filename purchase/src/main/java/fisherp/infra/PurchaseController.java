package fisherp.infra;

import fisherp.domain.*;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//<<< Clean Arch / Inbound Adaptor

@RestController
// @RequestMapping(value="/purchases")
@Transactional
public class PurchaseController {

    @Autowired
    PurchaseRepository purchaseRepository;

    @RequestMapping(
        value = "purchases/{id}/sale",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Purchase sale(
        @PathVariable(value = "id") Long id,
        @RequestBody SaleCommand saleCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /purchase/sale  called #####");
        Optional<Purchase> optionalPurchase = purchaseRepository.findById(id);

        optionalPurchase.orElseThrow(() -> new Exception("No Entity Found"));
        Purchase purchase = optionalPurchase.get();
        purchase.sale(saleCommand);

        purchaseRepository.save(purchase);
        return purchase;
    }
}
//>>> Clean Arch / Inbound Adaptor
