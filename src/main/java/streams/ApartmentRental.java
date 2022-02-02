package streams;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class ApartmentRental {
    private List<Apartment> apartments = new ArrayList<>();

    public void addApartment(Apartment apartment){
        apartments.add(apartment);
    }

    public List<Apartment> findApartmentByLocation(String location){
        return apartments.stream()
                .filter(a -> a.getLocation().equals(location))
                .toList();
    }

    public List<Apartment> findApartmentByExtras(String extras){
        return apartments.stream()
                .filter(a -> a.getExtras().stream().anyMatch(e -> e.contains(extras)))
                .toList();

    }

    public boolean isThereApartmentWithBathroomType(BathRoomType type ){
        return apartments.stream()
                .anyMatch(apartment -> apartment.getBathRoomType().equals(type));
    }

//    public List<Integer> findApartmentsSize(){
//        return apartments.stream()
//                .mapToInt(a -> a.getSize())
//                .distinct();
//    }
}
