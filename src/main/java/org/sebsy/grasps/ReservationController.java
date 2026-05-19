package org.sebsy.grasps;

import org.sebsy.grasps.beans.Reservation;
import org.sebsy.grasps.services.ReservationService;

/**
 * Contrôleur : point d'entrée entre le front et le back.
 * Délègue l'exécution du cas d'utilisation au service applicatif.
 */
public class ReservationController {

    private final ReservationService reservationService = new ReservationService();

    /**
     * Crée une réservation pour un client à partir des informations transmises.
     *
     * @param params contient toutes les infos permettant de créer une réservation
     * @return Reservation
     */
    public Reservation creerReservation(Params params) {
        return reservationService.creerReservation(params);
    }
}
