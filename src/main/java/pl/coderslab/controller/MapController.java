package pl.coderslab.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pl.coderslab.dto.UserLocationDTO;
import pl.coderslab.service.MapService;

import java.util.List;

@RestController
public class MapController {
    private final MapService mapService;

    public MapController(MapService mapService) {
        this.mapService = mapService;
    }

    @GetMapping("/map")
    @ResponseBody
    public List<UserLocationDTO> getAllUsersLocation(){
        return mapService.getAllUsersLocation();
    }
}
