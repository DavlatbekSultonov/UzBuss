package com.example.avtobus;

import com.example.avtobus.entity.Avtobus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusRepository extends JpaRepository<Avtobus,Integer>{

}
