package com.example.avtobus;

import com.example.avtobus.dto.CreateBusDTO;
import com.example.avtobus.dto.ResponseDTO;
import com.example.avtobus.entity.Avtobus;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@Controller
@RequiredArgsConstructor
@RequestMapping("buss")
public class BusController {
    private final BusService busService;
    Random random = new Random();
    @PreAuthorize(value = "hasRole('ADMIN')")
    @GetMapping("/admin")
    public String Admin(Model model){
        List<ResponseDTO> bussList=busService.getALL();
        model.addAttribute("bussList", bussList);
        return "user/admin";
    }
    @GetMapping("user")
    public String User(Model model){
        List<ResponseDTO> avtoList=busService.getALL();
        model.addAttribute("avtoList", avtoList);
        return "user/user";
    }



    @GetMapping("/addBuss")
    public String addBuss(){
        return "buss/create-buss";
    }

    @GetMapping("searchBuss")
    public String searchBuss(){
        return "buss/search";
    }
    @GetMapping("basketBuss")
    public String basketBuss(){
        return "buss/basket";
    }
    @PostMapping("AddBuss")
    public String create(@ModelAttribute CreateBusDTO createBusDTO,Model model){
        ResponseDTO responseDTO = busService.create(createBusDTO);
        model.addAttribute(responseDTO);
//        for (Integer i = 0; i < responseDTO.getPlacesNumber(); i++) {
//            Ticket bilet = new Ticket();
//            biletList.add(new Bilet(i, responseDTO.getStartAddress() + responseDTO.getEndAddress(), i, responseDTO.getPrice()));
//        }
        return "/user/admin";
    }
    @GetMapping("/search/{id}")
    public String Search(@PathVariable("id") Integer id){

        return "user/check";
    }


    @GetMapping("updateBuss/{id}")
    public String update(@PathVariable("id") Integer id,Model model){
        Avtobus avtobus=busService.findByNumber(id);
        model.addAttribute("bussUpdate",avtobus);
        return "/buss/update-buss";
    }
    @PostMapping("/updateBussId/{id}")
    public String updateCourse (@ModelAttribute Avtobus avtobus){
        busService.update(avtobus);
        return "redirect:/buss/admin";
    }
    @GetMapping("/deleteBuss/{id}")
    public String delete(@PathVariable("id") Integer id){
        this.busService.delete(id);
        return "redirect:/buss/admin";
    }
}
