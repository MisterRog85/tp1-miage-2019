package com.acme.mailreader.domain;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.acme.mailreader.domain.Mail;
import com.acme.mailreader.domain.MailComparator;

public class MailComparatorTest {
	
	private MailComparator comparator;

	@Before
	public void setUp() throws Exception {
		this.comparator = new MailComparator();
	}

	@Test
	public final void egauxSiDeuxMailsNuls() {
		Mail mail1 = null;
		Mail mail2 = null;
		assertThat(comparator.compare(mail1, mail2), is(0));
	}
	
	@Test
	public final void egauxSiUnDesMailsNuls() {
		Mail mail1 = new Mail();
		Mail mail2 = null;
		assertThat(comparator.compare(mail1, mail2), is(0));
	}
	
	//TODO
	//Autres tests unitaires
	@Test
	public final void testTrierParImportance() {
		Mail mail1 = new Mail();
		mail1.setImportant(true);
		Mail mail2 = new Mail();
		assertThat(comparator.compare(mail1, mail2), is(-1));
	}	
	
	
	
}
