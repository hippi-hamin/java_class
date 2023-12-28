package chxx_project.repository;

import chxx_project.dto.CoffeeDTO;
import chxx_project.dto.DessertDTO;
import chxx_project.dto.TeaDTO;

import java.util.ArrayList;
import java.util.List;

public class MenuRepository {
    public static List<CoffeeDTO> coffeeDTOList = new ArrayList<>();
    public static List<TeaDTO> teaDTOList = new ArrayList<>();
    public static List<DessertDTO> dessertDTOList = new ArrayList<>();
    public boolean saveCoffee(CoffeeDTO coffeeDTO) {
        return coffeeDTOList.add(coffeeDTO);
    }

    public boolean saveTea(TeaDTO teaDTO) {
        return teaDTOList.add(teaDTO);
    }

    public boolean saveDessert(DessertDTO dessertDTO) {
        return dessertDTOList.add(dessertDTO);
    }

    public boolean coffeeNameCheck(String menuName) {
        boolean result = false;
        for (int i = 0; i < coffeeDTOList.size(); i++) {
            // 해당 커피 이름이 있는 지 찾기.
            if (menuName.equals(coffeeDTOList.get(i).getCoffeeName())) {
                result = true;
            }
        }
        return result;
    }

    public boolean updateCoffeeName(String menuName, String updateCoffeeName) {
        boolean result = false;
        for (int i = 0; i < coffeeDTOList.size(); i++) {
            if (menuName.equals(coffeeDTOList.get(i).getCoffeeName())) {
                coffeeDTOList.get(i).setCoffeeName(updateCoffeeName);
                result = true;
            }
        }
        return result;
    }
    public boolean updateCoffeePrice(String menuName, int updateCoffeePrice) {
        boolean result = false;
        for (int i = 0; i < coffeeDTOList.size(); i++) {
            if (menuName.equals(coffeeDTOList.get(i).getCoffeeName())) {
                coffeeDTOList.get(i).setCoffeePrice(updateCoffeePrice);
                result = true;
            }
        }
        return result;
    }

    public boolean teaNameCheck(String menuName) {
        boolean result = false;
        for (int i = 0; i < teaDTOList.size(); i++) {
            // 해당 차의 이름이 있는 지 찾기
            if (menuName.equals(teaDTOList.get(i).getTeaName())) {
                result = true;
            }
        }
        return result;
    }
    public boolean updateTeaName(String menuName, String updateTeaName) {
        boolean result = false;
        for (int i = 0; i < teaDTOList.size(); i++) {
            if (menuName.equals(teaDTOList.get(i).getTeaName())) {
                teaDTOList.get(i).setTeaName(updateTeaName);
                result = true;
            }
        }
        return result;
    }
    public boolean updateTeaPrice(String menuName, int updateTeaPrice) {
        boolean result = false;
        for (int i = 0; i < teaDTOList.size(); i++) {
            if (menuName.equals(teaDTOList.get(i).getTeaName())) {
                teaDTOList.get(i).setTeaPrice(updateTeaPrice);
                result = true;
            }
        }
        return result;
    }
    public boolean dessertNameCheck(String menuName) {
        boolean result = false;
        for (int i = 0; i < dessertDTOList.size(); i++) {
            // 해당 차의 이름이 있는 지 찾기
            if (menuName.equals(dessertDTOList.get(i).getDessertName())) {
                result = true;
            }
        }
        return result;
    }
    public boolean updateDessertName(String menuName, String updateDessertName) {
        boolean result = false;
        for (int i = 0; i < dessertDTOList.size(); i++) {
            if (menuName.equals(dessertDTOList.get(i).getDessertName())) {
                dessertDTOList.get(i).setDessertName(updateDessertName);
                result = true;
            }
        }
        return result;
    }
    public boolean updateDessertPrice(String menuName, int updateDessertPrice) {
        boolean result = false;
        for (int i = 0; i < dessertDTOList.size(); i++) {
            if (menuName.equals(dessertDTOList.get(i).getDessertName())) {
                dessertDTOList.get(i).setDessertPrice(updateDessertPrice);
                result = true;
            }
        }
        return result;
    }

    public boolean coffeeDelete(String menuName) {
        boolean result = false;
        for (int i = 0; i < coffeeDTOList.size(); i++) {
            if (menuName.equals(coffeeDTOList.get(i).getCoffeeName())) {
                coffeeDTOList.remove(i);
                result = true;
            }
        }
        return result;
    }
    public boolean teaDelete(String menuName) {
        boolean result = false;
        for (int i = 0; i < teaDTOList.size(); i++) {
            if (menuName.equals(teaDTOList.get(i).getTeaName())) {
                teaDTOList.remove(i);
                result = true;
            }
        }
        return result;
    }
    public boolean dessertDelete(String menuName) {
        boolean result = false;
        for (int i = 0; i < dessertDTOList.size(); i++) {
            if (menuName.equals(dessertDTOList.get(i).getDessertName())) {
                dessertDTOList.remove(i);
                result = true;
            }
        }
        return result;
    }
}
