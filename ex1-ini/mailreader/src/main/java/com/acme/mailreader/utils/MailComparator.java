package com.acme.mailreader.utils;

import java.util.Comparator;

import com.acme.mailreader.model.Mail;

/**
 * Comparateur de mails
 * 
 * Comme on désire afficher les mails les plus importants en premier, l'element le plus grand retourne une valeur négative
 *
 */
public class MailComparator implements Comparator<Mail> {
	
	public static final int EGAUX = 0;
	public static final int MOINSUN = -1;
	public static final int UN = 1;
	
	public int compare(Mail premierMail, Mail deuxiemeMail) {
		if (unDesDeuxNul(premierMail, deuxiemeMail)) {
			return EGAUX;
		}
		if (importanceDifferente(premierMail, deuxiemeMail)) {
			return comparerParImportance(premierMail, deuxiemeMail);
		}
		if (statutDifferent(premierMail, deuxiemeMail)) {
			return trierParStatut(premierMail, deuxiemeMail);
		}
		if (sujetDifferent(premierMail, deuxiemeMail)) {
			return comparerParSujet(premierMail, deuxiemeMail);
		}
		return deuxiemeMail.getDate().compareTo(premierMail.getDate());
	}

	private int comparerParSujet(Mail premierMail, Mail deuxiemeMail) {
		return deuxiemeMail.getSujet().compareTo(premierMail.getSujet());
	}

	private int trierParStatut(Mail premierMail, Mail deuxiemeMail) {
		int comp = premierMail.getStatut().ordinal()
				- deuxiemeMail.getStatut().ordinal();
		return comp > 0 ? MOINSUN : UN;
	}

	private int comparerParImportance(Mail premierMail, Mail deuxiemeMail) {
		if (premierMail.isImportant() && !deuxiemeMail.isImportant()) {
			return MOINSUN;
		} else {
			return UN;
		}
	}

	private boolean sujetDifferent(Mail premierMail, Mail deuxiemeMail) {
		return premierMail.getSujet() != deuxiemeMail.getSujet();
	}

	private boolean statutDifferent(Mail premierMail, Mail deuxiemeMail) {
		return premierMail.getStatut() != deuxiemeMail.getStatut();
	}

	private boolean importanceDifferente(Mail premierMail, Mail deuxiemeMail) {
		return premierMail.isImportant() != deuxiemeMail.isImportant();
	}

	private boolean unDesDeuxNul(Mail premierMail, Mail deuxiemeMail) {
		return premierMail == null || deuxiemeMail == null;
	}
}

