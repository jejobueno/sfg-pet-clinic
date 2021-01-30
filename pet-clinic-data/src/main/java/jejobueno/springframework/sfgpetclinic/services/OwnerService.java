package jejobueno.springframework.sfgpetclinic.services;

import jejobueno.springframework.sfgpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

}
