package com.laridosos.rest.user;

import com.laridosos.exception.ResourceNotFoundException;
import com.laridosos.rest.user.dto.UserGetDTO;
import com.laridosos.rest.user.filter.UserFilter;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import static com.laridosos.rest.role.RoleEnum.RESPONSIBLE;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/responsibles")
    public ResponseEntity getAllResponsibles(UserFilter userFilter) {
        Page<UserApp> userPages = userRepository.findAllByNameIgnoreCaseContainingAndRolesEquals(userFilter.getName(),
                userFilter.toPageable(), RESPONSIBLE);
        return ResponseEntity.ok(userPages.map(UserMapper.INSTANCE::toUserGetDTO));
    }

    @GetMapping("/responsibles/{id}")
    public ResponseEntity getResponsibleById(@PathVariable Long id, HttpServletRequest request) {
        Optional<UserApp> user = userRepository.findByIdAndRolesNameEquals(id, RESPONSIBLE);

        if (user.isEmpty())
            throw new ResourceNotFoundException(request.getRequestURL().toString());

        return ResponseEntity.ok(UserMapper.INSTANCE.toUserGetDTO(user.get()));
    }
}
