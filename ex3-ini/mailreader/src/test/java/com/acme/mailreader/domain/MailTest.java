package com.acme.mailreader.domain;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.time.Instant;

import org.junit.Test;

import com.acme.mailreader.domain.Mail.Statut;

public class MailTest {
	
	MailComparator comparator = new MailComparator();
	

	@Test(expected=DateIncorrecteException.class)
	public final void erreurSiDateAvant1970() throws DateIncorrecteException {
		Mail mail = new Mail();
		mail.setDate(Instant.parse("1969-01-01T00:00:00.00Z"));			
	}

	@Test(expected=DateIncorrecteException.class)
	public final void erreurSiDateApres2100() throws DateIncorrecteException {
		Mail mail = new Mail();
		mail.setDate(Instant.parse("2222-01-01T00:00:00.00Z"));
	}
	
	@Test
	public final void premierPlusPetitSiDateNulle() throws DateIncorrecteException  {
		Mail mail1 = new Mail.Builder("uyyuy").important(false).statut(Statut.READ).build();
		Mail mail2 = new Mail.Builder("uyyuy").important(false).statut(Statut.READ).date(Instant.now()).build();
		assertThat(comparator.compare(mail1, mail2),is(1));
				
	}

	@Test
	public final void getDateOk() throws DateIncorrecteException{
		Mail mail = new Mail();
		mail.setDate(Instant.parse("2000-01-01T00:00:00.00Z"));
		assertThat(mail.getDate(), is(Instant.parse("2000-01-01T00:00:00.00Z")));
	}

}
