package tn.iit.banque;

import javax.ejb.Local;

@Local
public interface CalculatriceLocal {

	double som(double x, double y);

	double mult(double x, double y);

	double sous(double x, double y);

}
