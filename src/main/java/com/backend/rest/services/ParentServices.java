package com.backend.rest.services;
import java.sql.SQLException;

import com.backend.rest.utils.Connector;

public class ParentServices {
	public ParentServices() throws SQLException{
    	Connector conn = new Connector();
    	conn.doConnect();
	}
}
