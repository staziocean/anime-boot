package fr.mds.animay.service;

import fr.mds.animay.exception.NotFoundException;
import fr.mds.animay.model.User;
import fr.mds.animay.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService extends GenericService<User, Long, UserRepository> {

    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository repository, PasswordEncoder passwordEncoder) {
        super(repository);
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User create(User user) {
        String clearPassword = user.getPassword();
        String encodedPassword = passwordEncoder.encode(clearPassword);
        user.setPassword(encodedPassword);

        return super.create(user);
    }

    @Override
    public User update(Long id, User user) {
        User persistedUser = repository.findById(id).orElseThrow(() -> new NotFoundException());

        user.setId(id);
        user.setPassword(persistedUser.getPassword());
        user.setRoles(persistedUser.getRoles());

        return repository.save(user);
    }
}
