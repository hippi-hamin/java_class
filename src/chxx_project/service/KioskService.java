package chxx_project.service;

import chxx_project.dto.CoffeeDTO;
import chxx_project.dto.DessertDTO;
import chxx_project.dto.TeaDTO;
import chxx_project.repository.KioskRepository;
import chxx_project.repository.MenuRepository;

import java.util.List;

public class KioskService {
    KioskRepository kioskRepository = new KioskRepository();

    public void findAll() {
        System.out.println("커피");
        List<CoffeeDTO> coffeeDTOList = kioskRepository.findAllCoffee();
        for (CoffeeDTO coffeeDTO : coffeeDTOList) {
            System.out.println(coffeeDTO);
        }
    }
}
