package org.umair.hotel_mangement_system_in_spring_boot.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.umair.hotel_mangement_system_in_spring_boot.models.Hotel;

public interface HotelRepository extends JpaRepository<Hotel,Long> {

    Hotel findById(int id);
}
