package tn.iit.banque;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class CalculatriceBeans implements CalculatriceLocal, CalculatriceRemote {

	@EJB
	CalculatriceRemote bank;

	@Override
	public double som(double x, double y) {
		// TODO Auto-generated method stub
		return x + y;
	}

	@Override
	public double mult(double x, double y) {
		// TODO Auto-generated method stub
		return x * y;
	}

	@Override
	public double sous(double x, double y) {
		// TODO Auto-generated method stub
		return x - y;
	}

}
