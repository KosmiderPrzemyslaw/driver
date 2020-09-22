package pl.coderslab.service;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;
import pl.coderslab.dto.UserLocationDTO;
import pl.coderslab.model.User;
import pl.coderslab.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MapService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public MapService(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    public List<UserLocationDTO> getAllUsersLocation(){
        return userRepository.findAll()
                .stream()
                .map(this::convertToUserLocationDTO)
                .collect(Collectors.toList());
    }

    private UserLocationDTO convertToUserLocationDTO(User user) {

        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        UserLocationDTO userLocationDTO = modelMapper
                .map(user, UserLocationDTO.class);
//        UserLocationDTO userLocationDTO = new UserLocationDTO();
//        userLocationDTO.setUserId(user.getId());
//        userLocationDTO.setUsername(user.getUsername());
//        Location location = user.getLocation();
//        userLocationDTO.setLat(location.getLat());
//        userLocationDTO.setLng(location.getLng());
//        userLocationDTO.setPlace(location.getPlace());
        return userLocationDTO;
    }
}
