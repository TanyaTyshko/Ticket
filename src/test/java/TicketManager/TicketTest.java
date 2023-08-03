package TicketManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class TicketTest {
    @Test
    public void testSortTicket() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 300, 8, 10);
        Ticket ticket2 = new Ticket("MSK", "SPB", 200, 10, 12);
        Ticket ticket3 = new Ticket("NSK", "SPB", 500, 6, 10);
        Ticket ticket4 = new Ticket("MSK", "LA", 800, 5, 15);
        Ticket ticket5 = new Ticket("MSK", "SPB", 200, 10, 13);
        Ticket ticket6 = new Ticket("TSK", "SPB", 100, 8, 14);
        Ticket ticket7 = new Ticket("MSK", "SPB", 500, 3, 7);
        Ticket ticket8 = new Ticket("MSK", "SPB", 400, 10, 11);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] actual = manager.search("MSK", "SPB");
        Ticket[] expected = {ticket2, ticket5, ticket1, ticket8, ticket7};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortTicketOneTicket() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 300, 8, 10);
        Ticket ticket2 = new Ticket("MSK", "SPB", 200, 10, 12);
        Ticket ticket3 = new Ticket("NSK", "SPB", 500, 6, 10);
        Ticket ticket4 = new Ticket("MSK", "LA", 800, 5, 15);
        Ticket ticket5 = new Ticket("MSK", "SPB", 200, 10, 13);
        Ticket ticket6 = new Ticket("TSK", "SPB", 100, 8, 14);
        Ticket ticket7 = new Ticket("MSK", "SPB", 500, 3, 7);
        Ticket ticket8 = new Ticket("MSK", "SPB", 400, 10, 11);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] actual = manager.search("MSK", "LA");
        Ticket[] expected = {ticket4};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortTicketNotTicket() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 300, 8, 10);
        Ticket ticket2 = new Ticket("MSK", "SPB", 200, 10, 12);
        Ticket ticket3 = new Ticket("NSK", "SPB", 500, 6, 10);
        Ticket ticket4 = new Ticket("MSK", "LA", 800, 5, 15);
        Ticket ticket5 = new Ticket("MSK", "SPB", 200, 10, 13);
        Ticket ticket6 = new Ticket("TSK", "SPB", 100, 8, 14);
        Ticket ticket7 = new Ticket("MSK", "SPB", 500, 3, 7);
        Ticket ticket8 = new Ticket("MSK", "SPB", 400, 10, 11);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] actual = manager.search("NEW", "LA");
        Ticket[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortTicketWithComparator() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 300, 8, 10); // 2
        Ticket ticket2 = new Ticket("MSK", "SPB", 200, 10, 12); //2
        Ticket ticket3 = new Ticket("NSK", "SPB", 500, 6, 10);
        Ticket ticket4 = new Ticket("MSK", "LA", 800, 5, 15);
        Ticket ticket5 = new Ticket("MSK", "SPB", 200, 10, 13); //3
        Ticket ticket6 = new Ticket("TSK", "SPB", 100, 8, 14);
        Ticket ticket7 = new Ticket("MSK", "SPB", 500, 3, 7); //4
        Ticket ticket8 = new Ticket("MSK", "SPB", 400, 10, 11); //1
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = manager.search("MSK", "SPB", comparator);
        Ticket[] expected = {ticket8, ticket1, ticket2, ticket5, ticket7};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortTicketWithComparatorOneTicket() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 300, 8, 10); // 2
        Ticket ticket2 = new Ticket("MSK", "SPB", 200, 10, 12); //2
        Ticket ticket3 = new Ticket("NSK", "SPB", 500, 6, 10);
        Ticket ticket4 = new Ticket("MSK", "LA", 800, 5, 15);
        Ticket ticket5 = new Ticket("MSK", "SPB", 200, 10, 13); //3
        Ticket ticket6 = new Ticket("TSK", "SPB", 100, 8, 14);
        Ticket ticket7 = new Ticket("MSK", "SPB", 500, 3, 7); //4
        Ticket ticket8 = new Ticket("MSK", "SPB", 400, 10, 11); //1
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = manager.search("MSK", "LA", comparator);
        Ticket[] expected = {ticket4};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortTicketWithComparatorNegative() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 300, 8, 10); // 2
        Ticket ticket2 = new Ticket("MSK", "SPB", 200, 10, 12); //2
        Ticket ticket3 = new Ticket("NSK", "SPB", 500, 6, 10);
        Ticket ticket4 = new Ticket("MSK", "LA", 800, 5, 15);
        Ticket ticket5 = new Ticket("MSK", "SPB", 200, 10, 13); //3
        Ticket ticket6 = new Ticket("TSK", "SPB", 100, 8, 14);
        Ticket ticket7 = new Ticket("MSK", "SPB", 500, 3, 7); //4
        Ticket ticket8 = new Ticket("MSK", "SPB", 400, 10, 11); //1
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = manager.search("NEW", "LA", comparator);
        Ticket[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }
}
