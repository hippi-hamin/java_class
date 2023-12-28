package chxx_project.repository;

import chxx_project.dto.CoffeeDTO;
import chxx_project.dto.DessertDTO;
import chxx_project.dto.TeaDTO;

import java.util.ArrayList;
import java.util.List;

public class MenuRepository {
    private static List<CoffeeDTO> coffeeDTOList = new ArrayList<>();
    private static List<TeaDTO> teaDTOList = new ArrayList<>();
    private static List<DessertDTO> dessertDTOList = new ArrayList<>();
    public boolean saveCoffee(CoffeeDTO coffeeDTO) {
        return coffeeDTOList.add(coffeeDTO);
    }

    public boolean saveTea(TeaDTO teaDTO) {
        return teaDTOList.add(teaDTO);
    }

    public boolean saveDessert(DessertDTO dessertDTO) {
        return dessertDTOList.add(dessertDTO);
    }
}
