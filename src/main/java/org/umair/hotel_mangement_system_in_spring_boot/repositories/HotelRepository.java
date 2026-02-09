package org.umair.hotel_mangement_system_in_spring_boot.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.umair.hotel_mangement_system_in_spring_boot.models.Hotel;

import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel,Long> {

    Hotel findById(int id);
    List<Hotel> findByName(String name);

    void deleteById(int id);
}
