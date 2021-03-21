package jejobueno.springframework.sfgpetclinic.services.map;

import jejobueno.springframework.sfgpetclinic.model.Speciality;
import jejobueno.springframework.sfgpetclinic.model.Vet;
import jejobueno.springframework.sfgpetclinic.services.SpecialitiesService;
import jejobueno.springframework.sfgpetclinic.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

    private SpecialitiesService specialitiesService;

    public VetServiceMap(SpecialitiesService specialitiesService) {
        this.specialitiesService = specialitiesService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet findByID(Long id) {
        return super.findByID(id);
    }

    @Override
    public Vet save(Vet object) {
        if (object != null){
            if (object.getSpecialities().size() > 0){
                object.getSpecialities().forEach(speciality -> {
                    if (speciality.getId() == null){
                        Speciality savedSpeciality = specialitiesService.save(speciality);
                        speciality.setId(savedSpeciality.getId());
                    }
                });
            }

            return super.save(object);
        }

        return null;
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }


}
