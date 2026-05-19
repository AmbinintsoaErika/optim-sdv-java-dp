package org.sebsy.grasps.daos;

import org.sebsy.grasps.beans.Reservation;
import java.util.ArrayList;
import java.util.List;

public class ReservationDao implements IReservationDao {
    private static List<Reservation> reservations = new ArrayList<>();

    @Override
    public Reservation saveReservation(Reservation reservation) {
        reservations.add(reservation);
        
        return reservation;
    }
}