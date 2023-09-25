package com.listatelefonica.listatelefonica.repository;


import com.listatelefonica.listatelefonica.model.ContatoModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContatoRepository extends JpaRepository<ContatoModel, Long>{
    
}
