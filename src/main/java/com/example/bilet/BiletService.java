package com.example.bilet;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BiletService {
    ModelMapper modelMapper=new ModelMapper();
    private final BiletRepository biletRepository;
    public BiletResponseDTO create(CreateBiletDTO createBiletDTO) {
        Ticket bilet = modelMapper.map(createBiletDTO, Ticket.class);
        biletRepository.save(bilet);
        return modelMapper.map(bilet, BiletResponseDTO.class);
    }

    public List<BiletResponseDTO> getAll() {
        List<Ticket> all = biletRepository.findAll();
        return all.stream().map(ticket -> modelMapper.map(ticket,BiletResponseDTO.class)).toList();
    }
//    public BiletResponseDTO createBilet(BiletDTO biletDTO) {
//        Bilet bilet = modelMapper.map(biletDTO, Bilet.class);
//        biletRepository.save(bilet);
//        return modelMapper.map(bilet,BiletResponseDTO.class);
//    }

}
