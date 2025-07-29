package com.joaop.opinions.Services;

import com.joaop.opinions.Models.Opinion;
import com.joaop.opinions.Repository.OpinionRepository;
import com.joaop.opinions.Requests.OpinionRequest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;


import java.util.List;

@Service
public class OpinionService {

    OpinionRepository opinionRepository;

    public OpinionService (OpinionRepository opinionRepository){
        this.opinionRepository = opinionRepository;
    }

    public List<Opinion> gettingall (){
        return opinionRepository.findAll();
    }

    public void deletingbyid (long id){
        opinionRepository.deleteById(id);
    }

    public void newOpinion (OpinionRequest opinionRequest){
        Opinion opinion = new Opinion();
        opinion.setName(opinionRequest.getName());
        opinion.setComment(opinionRequest.getComment());
        opinion.setImg(opinionRequest.getImg());
        opinion.setRate(opinionRequest.getRate());
        opinionRepository.save(opinion);

    }

    public List<Opinion> getMaximum(Long num){
        Pageable pageable = PageRequest.of(0,num.intValue());
        return opinionRepository.findMaximumOpinions(pageable);

    }

}
