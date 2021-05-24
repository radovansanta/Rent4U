package Client.Networking;

import Client.Model.Vehicle;
import Util.Answer;
import Util.Request;

import java.rmi.RemoteException;
import java.sql.SQLException;

public interface Client
{
    void startClient();
    void newRequest(Request request);
    void newAnswer(Answer answer);
    void addVehicle(Vehicle vehicle) throws SQLException, RemoteException;
}
