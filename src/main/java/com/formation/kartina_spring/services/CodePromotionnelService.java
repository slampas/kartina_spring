package com.formation.kartina_spring.services;

import com.formation.kartina_spring.models.Cadre;
import com.formation.kartina_spring.models.CodePromotionnel;
import com.formation.kartina_spring.repositories.CodePromotionnelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CodePromotionnelService {
    private CodePromotionnelRepository codePromotionnelRepository;

    @Autowired
    public CodePromotionnelService(CodePromotionnelRepository codePromotionnelRepository) {
        this.codePromotionnelRepository = codePromotionnelRepository;
    }

    public void save(CodePromotionnel codePromotionnel) {
        codePromotionnelRepository.save(codePromotionnel);
    }

    public List<CodePromotionnel> findAll(){
        return codePromotionnelRepository.findAll();
    }
}
