package sn.esmt.CV.ws;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sn.esmt.CV.dao.AppCvRepository;
import sn.esmt.CV.entities.AppCvEntity;

import java.util.List;

@RestController
@RequestMapping(value = "/CVs")
@AllArgsConstructor
public class AppCvController {
    private AppCvRepository appCvRepository;
    @PostMapping(path = "/save")
    public AppCvEntity save(@RequestBody AppCvEntity appCvEntity){
        return appCvRepository.save(appCvEntity);
    }

    @GetMapping(path = "/all")
    public List<AppCvEntity> getAll(){
        return appCvRepository.findAll();
    }
}
