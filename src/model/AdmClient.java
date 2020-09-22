package model;

import java.util.ArrayList;
import java.util.List;

public class AdmClient {
	private List<Client> lstClient = new ArrayList();

	public List<Client> getLstClient() {
		return lstClient;
	}

	public void setLstClient(List<Client> lstClient) {
		this.lstClient = lstClient;
	}

	public AdmClient() {
		super();
		this.lstClient = lstClient;
	}
	
}
