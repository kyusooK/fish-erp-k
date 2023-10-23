package fisherp.infra;

import fisherp.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class PurchaseHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Purchase>> {

    @Override
    public EntityModel<Purchase> process(EntityModel<Purchase> model) {
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/sale")
                .withRel("sale")
        );

        return model;
    }
}
