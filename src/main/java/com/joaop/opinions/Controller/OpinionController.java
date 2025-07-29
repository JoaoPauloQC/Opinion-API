package com.joaop.opinions.Controller;

import com.joaop.opinions.Models.Opinion;
import com.joaop.opinions.Repository.OpinionRepository;
import com.joaop.opinions.Requests.OpinionRequest;
import com.joaop.opinions.Services.OpinionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/opinion")
public class OpinionController {

    OpinionService opinionService;

    public OpinionController (OpinionService opinionService){
        this.opinionService = opinionService;
    }

    @GetMapping("/getall")
    public List<Opinion> getById (){
        List<Opinion> opinions = opinionService.gettingall();

        return opinions;
    }



    @PostMapping ("/newOpinion")
    public ResponseEntity<Void> newOpinion (@RequestBody OpinionRequest opinionRequest){
        opinionService.newOpinion(opinionRequest);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletebyid (@PathVariable Long id){
        opinionService.deletingbyid(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/last")
    public List<Opinion> gettingMaximum (@RequestParam Optional<Long> num ){
        if (num.isPresent()){
            return opinionService.getMaximum(num.get());
        }
        return opinionService.getMaximum(5L);
    }

}
