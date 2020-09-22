//package pl.coderslab.mapper;
//
//import org.mapstruct.Mapper;
//import org.mapstruct.Mapping;
//import org.mapstruct.factory.Mappers;
//import pl.coderslab.dto.UserLocationDTO;
//import pl.coderslab.model.Location;
//import pl.coderslab.model.User;
//
//@Mapper
//public interface UserLocationMapper {
//    UserLocationMapper INSTANCE = Mappers.getMapper(UserLocationMapper.class);
//
//    @Mapping(source = "user.id", target = "userId")
//    UserLocationDTO toDto(User user, Location location);
//}
