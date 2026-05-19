package org.sebsy.grasps.services;

import org.sebsy.grasps.Params;
import org.sebsy.grasps.ReservationFactory;
import org.sebsy.grasps.beans.Client;
import org.sebsy.grasps.beans.Reservation;
import org.sebsy.grasps.beans.TypeReservation;
import org.sebsy.grasps.daos.ClientDao;
import org.sebsy.grasps.daos.TypeReservationDao;

/**
 * Service de reservation
 */
public class ReservationService {

    private final ClientDao clientDao;
    private final TypeReservationDao typeReservationDao;

    public ReservationService() {
        this(new ClientDao(), new TypeReservationDao());
    }

    ReservationService(ClientDao clientDao, TypeReservationDao typeReservationDao) {
        this.clientDao = clientDao;
        this.typeReservationDao = typeReservationDao;
    }

    public Reservation creerReservation(Params params) {
        Client client = clientDao.extraireClient(params.getIdentifiantClient());
        TypeReservation type = typeReservationDao.extraireTypeReservation(params.getTypeReservation());

        Reservation reservation = ReservationFactory.getInstance(params);
        client.addReservation(reservation);
        reservation.appliquerTarif(type);

        return reservation;
    }
}
