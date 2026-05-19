package org.sebsy.grasps.daos;

import org.sebsy.grasps.beans.Client;

import java.util.List;
import java.util.Optional;

public class ClientDao implements IClientDao {

    private static Client[] clients = {new Client("1", true), new Client("2", true), new Client("3", false)};

    @Override
    public Client extraireClient(String id) {

        Optional<Client> opt = List.of(clients).stream().filter(c -> c.getIdentifiantClient().equals(id)).findAny();
        if (opt.isPresent()) {
            return opt.get();
        }
        return null;
    }

}
