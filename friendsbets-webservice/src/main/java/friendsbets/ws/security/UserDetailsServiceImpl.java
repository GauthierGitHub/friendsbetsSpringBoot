package friendsbets.ws.security;


import static java.util.Collections.emptyList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import friendsbets.core.services.UserService;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	UserService us;

    @Override
    public UserDetails loadUserByUsername(String nickname) throws UsernameNotFoundException {
        friendsbets.core.models.User user = us.findByNickname(nickname);
        if (user == null) {
            throw new UsernameNotFoundException(nickname);
        }
        return new User(user.getNickname(), user.getPassword(), emptyList());
    }
}