package com.example.bilet;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BiletRepository extends JpaRepository<Ticket,Integer> {

}
