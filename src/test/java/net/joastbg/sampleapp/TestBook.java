package net.joastbg.sampleapp;

import net.joastbg.sampleapp.entities.Book;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Johan Astborg <joastbg@gmail.com>
 */
public class TestBook {

	@Test
	public void testCreateNewBookWithTitle() {
		Book book = new Book("My Book");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCreateNewBookWithEmptyTitle() {
		new Book("");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCreateNewBookWithNullTitle() {
		new Book(null);
	}
}
