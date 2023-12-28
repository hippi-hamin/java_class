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
            System.out.println(coffeeDTO.getCoffeeName());
        }
        System.out.println("차");
        List<TeaDTO> teaDTOList = kioskRepository.findAllTea();
        for (TeaDTO teaDTO : teaDTOList) {
            System.out.println(teaDTO);
        }
        System.out.println("디저트");
        List<DessertDTO> dessertDTOList = kioskRepository.findAllDessert();
        for (DessertDTO dessertDTO : dessertDTOList) {
            System.out.println(dessertDTO);
        }
    }
}
