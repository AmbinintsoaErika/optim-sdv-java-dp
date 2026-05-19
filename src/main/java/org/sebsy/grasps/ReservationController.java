package org.sebsy.grasps;

import org.sebsy.grasps.beans.Reservation;
import org.sebsy.grasps.daos.ClientDao;
import org.sebsy.grasps.daos.ReservationDao;
import org.sebsy.grasps.daos.TypeReservationDao;
import org.sebsy.grasps.dto.CreateReservationDto;
import org.sebsy.grasps.services.IReservationService;
import org.sebsy.grasps.services.ReservationService;

/**
 * Contrôleur : point d'entrée entre le front et le back.
 * Délègue l'exécution du cas d'utilisation au service applicatif.
 */
public class ReservationController {

    private final IReservationService reservationService;

    public ReservationController() {
        this(new ReservationService(new ClientDao(), new TypeReservationDao(), new ReservationDao()));
    }

    public ReservationController(IReservationService reservationService) {
        this.reservationService = reservationService;
    }

    public Reservation creerReservation(Params params) {
        return creerReservation(new CreateReservationDto(
                params.getIdentifiantClient(),
                params.getNbPlaces(),
                params.getDateReservation(),
                params.getTypeReservation()));
    }

    /**
     * Méthode qui créée une réservation pour un client à partir des informations transmises
     *
     * @param reservationDto contient toutes les infos permettant de créer une réservation
     * @return Reservation
     */
    public Reservation creerReservation(CreateReservationDto reservationDto) {
        return reservationService.creerReservation(reservationDto);
    }
}
