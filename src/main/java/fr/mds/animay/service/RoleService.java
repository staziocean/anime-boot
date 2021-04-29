package fr.mds.animay.service;

import fr.mds.animay.model.Role;
import fr.mds.animay.repository.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleService extends GenericService<Role, Long, RoleRepository> {

    public RoleService(RoleRepository repository) {
        super(repository);
    }
}
