package chxx_project.repository;

import chxx_project.dto.CoffeeDTO;
import chxx_project.dto.DessertDTO;
import chxx_project.dto.TeaDTO;

import java.util.ArrayList;
import java.util.List;

public class KioskRepository {
    List<CoffeeDTO> coffeeDTOList = new ArrayList<>();
    List<TeaDTO> teaDTOList = new ArrayList<>();
    List<DessertDTO> dessertDTOList = new ArrayList<>();

    public List<CoffeeDTO> findAllCoffee() {
        return coffeeDTOList;
    }

    public List<TeaDTO> findAllTea() {
        return teaDTOList;
    }

    public List<DessertDTO> findAllDessert() {
        return dessertDTOList;
    }
}
