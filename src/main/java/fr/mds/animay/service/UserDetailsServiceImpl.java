package fr.mds.animay.service;

import fr.mds.animay.model.Right;
import fr.mds.animay.model.Role;
import fr.mds.animay.model.User;
import fr.mds.animay.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(login);

        if (user != null) {
            return new org.springframework.security.core.userdetails.User(user.getUsername(),
                    user.getPassword(),
                    computeRights(user));
        }

        return null;
    }

    private List<GrantedAuthority> computeRights(User user) {
        List<GrantedAuthority> authorities = new ArrayList<>();

        for (Role role : user.getRoles()) {
            // Rôle : donner "ROLE_xxx" à manger à Spring
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));

            for (Right right : role.getRights()) {
                // Droit : donner "yyy" à Spring
                authorities.add(new SimpleGrantedAuthority(right.getName()));
            }
        }

        return authorities;
    }
}
