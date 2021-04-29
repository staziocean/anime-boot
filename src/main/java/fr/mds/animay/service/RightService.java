package fr.mds.animay.service;

import fr.mds.animay.model.Right;
import fr.mds.animay.repository.RightRepository;
import org.springframework.stereotype.Service;

@Service
public class RightService extends GenericService<Right, Long, RightRepository> {

    public RightService(RightRepository repository) {
        super(repository);
    }
}
