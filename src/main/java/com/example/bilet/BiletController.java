package com.example.bilet;

import com.example.avtobus.BusService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/xarid")
public class BiletController {
    private final BiletService biletService;
    private final BusService busService;
   public static Integer ID;
   public static String sana;

    @GetMapping("/bilet/{id}")
    public String BiletSave(@PathVariable("id") Integer id, Model model){
         model.addAttribute("id",id);
         model.addAttribute("price",busService.findById(id).getPrice());
//        model.addAttribute("createBiletdto", new CreateBiletDTO("",busService.findById(id).getWalkTime(),0,busService.findById(id).getPrice()));
        return "buss/search";
    }

    @GetMapping("/bask")
    public String Savat(){
        return "buss/basket";
    }
    @PostMapping("/ticket")
    public String createBilet(@ModelAttribute("createBiletdto") CreateBiletDTO createBiletDTO, Model model){
        BiletResponseDTO biletResponseDTO = biletService.create(createBiletDTO);
        model.addAttribute(biletResponseDTO);
        return "redirect:/xarid/getTicket";
    }

    @GetMapping("/getTicket")
    public String GetIdTicket(Model model){
        List<BiletResponseDTO> ticketList = biletService.getAll();
        model.addAttribute("ticketList", ticketList.get(ticketList.size()-1));
        return "buss/ticket";

    }


    @GetMapping("/save")
    public String GetAllTicket(Model model){
        List<BiletResponseDTO> ticketList = biletService.getAll();
        model.addAttribute("ticketList", ticketList );
        return "buss/basket";

    }
}
