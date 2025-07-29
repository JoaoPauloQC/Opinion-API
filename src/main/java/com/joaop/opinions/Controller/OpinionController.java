package com.joaop.opinions.Controller;

import com.joaop.opinions.Models.Opinion;
import com.joaop.opinions.Repository.OpinionRepository;
import com.joaop.opinions.Requests.OpinionRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/opinion")
public class OpinionController {

    OpinionRepository opinionRepository;

    public OpinionController (OpinionRepository opinionRepository){
        this.opinionRepository = opinionRepository;
    }

    @GetMapping("/getbyid")
    public List<Opinion> getById (){
        List<Opinion> opinions = opinionRepository.findAll();

        return opinions;
    }

    @GetMapping ("/newOpinion")
    public ResponseEntity<Void> newOpinion (@RequestBody OpinionRequest opinionRequest){
        Opinion opinion = new Opinion();
        opinion.setName(opinionRequest.getName());
        opinion.setComment(opinionRequest.getComment());
        opinion.setImg(opinionRequest.getImg());
        opinion.setRate(opinionRequest.getRate());
        opinionRepository.save(opinion);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<Void> deletebyid (@PathVariable Long id){
        opinionRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
