package org.umair.hotel_mangement_system_in_spring_boot.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.umair.hotel_mangement_system_in_spring_boot.models.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {



}
