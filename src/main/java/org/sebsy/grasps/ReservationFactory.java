package org.sebsy.grasps;

import org.sebsy.grasps.beans.Reservation;

/**
 * Factory responsable de la construction d'une Reservation à partir des paramètres reçus.
 */
public class ReservationFactory {

    private ReservationFactory() {
    }

    public static Reservation getInstance(Params params) {
        Reservation reservation = new Reservation(DateUtils.toLocalDateTime(params.getDateReservation()));
        reservation.setNbPlaces(params.getNbPlaces());
        return reservation;
    }
}
