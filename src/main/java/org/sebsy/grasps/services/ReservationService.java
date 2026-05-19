package org.sebsy.grasps.services;

import java.time.LocalDateTime;

import org.sebsy.grasps.DateUtils;
import org.sebsy.grasps.beans.Client;
import org.sebsy.grasps.beans.Reservation;
import org.sebsy.grasps.beans.TypeReservation;
import org.sebsy.grasps.daos.IClientDao;
import org.sebsy.grasps.daos.IReservationDao;
import org.sebsy.grasps.daos.ITypeReservationDao;
import org.sebsy.grasps.dto.CreateReservationDto;

/**
 * Service de reservation
 */
public class ReservationService implements IReservationService {

    private final IClientDao clientDao;
    private final ITypeReservationDao typeReservationDao;
    private final IReservationDao reservationDao;

    public ReservationService(IClientDao clientDao, ITypeReservationDao typeReservationDao, IReservationDao reservationDao) {
        this.clientDao = clientDao;
        this.typeReservationDao = typeReservationDao;
        this.reservationDao = reservationDao;
    }

    @Override
    public Reservation creerReservation(CreateReservationDto reservationDto) {
        LocalDateTime dateReservation = DateUtils.toLocalDateTime(reservationDto.getDateReservation());
        Client client = clientDao.extraireClient(reservationDto.getIdentifiantClient());
        TypeReservation type = typeReservationDao.extraireTypeReservation(reservationDto.getTypeReservation());
        
        Reservation reservation = new Reservation(dateReservation, reservationDto.getNbPlaces());
        reservation.setClient(client);

        calculerMontantTotal(type, client, reservation);

        return reservationDao.saveReservation(reservation);
    }

    /**
     * Calcul du montant total de la réservation
     */
    private void calculerMontantTotal(TypeReservation typeReservation, Client client, Reservation reservation) {
        double totalMontant = typeReservation.getMontant() * reservation.getNbPlaces();
        
        if (client.isPremium()) {
            reservation.setTotal(totalMontant * (1 - typeReservation.getReductionPourcent() / 100.0));
        } else {
            reservation.setTotal(totalMontant);
        }
    }
}
