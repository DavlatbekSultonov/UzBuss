package com.example.avtobus;

import com.example.avtobus.dto.CreateBusDTO;
import com.example.avtobus.dto.ResponseDTO;
import com.example.avtobus.entity.Avtobus;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BusService {
    ModelMapper modelMapper=new ModelMapper();
    private final BusRepository busRepository;
    public ResponseDTO create(CreateBusDTO createBusDTO) {
        Avtobus avtobus = modelMapper.map(createBusDTO, Avtobus.class);
        busRepository.save(avtobus);
        return modelMapper.map(avtobus, ResponseDTO.class);
    }
     public List<ResponseDTO> getALL(){
        List<Avtobus> avtobuses=busRepository.findAll();
        return avtobuses.stream().map(buss->modelMapper.map(buss, ResponseDTO.class)).toList();
     }

    public Avtobus findByNumber(Integer id){
        Avtobus buss = busRepository.findById(id).get();
        return buss;
    }

    public Avtobus update(Avtobus avtobus){
        return busRepository.save(avtobus);
    }
    public void delete( Integer id){
        busRepository.deleteById(id);
    }

    public Avtobus findById(Integer id) {
        Avtobus avtobus = busRepository.findById(id).get();
        return avtobus;
    }


//
//        public Course update(Course course) {
//            return courseRepository.save(course);
//        }
//
//        public void delete(UUID courseId) {
//
//            courseRepository.deleteById(courseId);
//        }



    }
