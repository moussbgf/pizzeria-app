package fr.pizzeria.dao.api;

import java.util.List;

import fr.pizzeria.dao.api.exception.client.*;
import fr.pizzeria.domain.*;

public interface IClientDao {
	
	List<Client> findAllClients();

	boolean saveNewClient(Client client) throws SaveClientException;

	boolean updateClient(Integer id, Client client) throws UpdateClientException;

	boolean deleteClient(Integer id) throws DeleteClientException;
	
}
