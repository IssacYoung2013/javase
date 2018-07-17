package com.feiyangedu.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDateTime;

public interface Clock extends Remote {

	LocalDateTime currentTime() throws RemoteException;

}
