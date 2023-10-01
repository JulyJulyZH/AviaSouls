import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AviaSoulsTest {

    @Test
    public void searchEmpty() {
        AviaSouls aviaSouls = new AviaSouls();
        Ticket ticket1 = new Ticket("SVX", "LED", 1234, 12, 16);
        Ticket ticket2 = new Ticket("SVX", "OMS", 6556, 10, 12);
        Ticket ticket3 = new Ticket("LED", "OMS", 1234, 1, 3);
        Ticket ticket4 = new Ticket("OMS", "SVX", 1234, 0, 9);
        Ticket ticket5 = new Ticket("SVX", "TDF", 1234, 0, 9);
        int actual = aviaSouls.search("TOF", "SVX").length;
        int expected = 0;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void searchOne() {
        AviaSouls aviaSouls = new AviaSouls();
        Ticket ticket1 = new Ticket("SVX", "LED", 1234, 12, 16);
        Ticket ticket2 = new Ticket("SVX", "OMS", 6556, 10, 12);
        Ticket ticket3 = new Ticket("LED", "OMS", 1234, 1, 3);
        Ticket ticket4 = new Ticket("OMS", "SVX", 1234, 0, 9);
        Ticket ticket5 = new Ticket("SVX", "TDF", 1234, 0, 9);
        aviaSouls.add(ticket3);
        Ticket[] actual = aviaSouls.search("LED", "OMS");
        Ticket[] expected = {ticket3};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchSome() {
        AviaSouls aviaSouls = new AviaSouls();
        Ticket ticket1 = new Ticket("SVX", "LED", 1234, 12, 16);
        Ticket ticket2 = new Ticket("SVX", "OMS", 6556, 10, 18);
        Ticket ticket3 = new Ticket("LED", "OMS", 1234, 1, 3);
        Ticket ticket4 = new Ticket("OMS", "SVX", 1234, 0, 9);
        Ticket ticket5 = new Ticket("SVX", "OMS", 14564, 10, 14);
        Ticket ticket6 = new Ticket("OMS", "SVX", 1234, 0, 9);
        Ticket ticket7 = new Ticket("SVX", "OMS", 254, 10, 15);
        Ticket ticket8 = new Ticket("OMS", "SVX", 1234, 0, 9);
        Ticket ticket9 = new Ticket("SVX", "OMS", 145640, 10, 15);
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        aviaSouls.add(ticket6);
        aviaSouls.add(ticket7);
        aviaSouls.add(ticket8);
        aviaSouls.add(ticket9);
        Ticket[] actual = aviaSouls.search("SVX", "OMS");
        Ticket[] expected = {ticket7, ticket2, ticket5, ticket9};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchAndSortEmpty() {
        AviaSouls aviaSouls = new AviaSouls();
        TicketTimeComparator comparator = new TicketTimeComparator();
        Ticket ticket1 = new Ticket("SVX", "LED", 1234, 12, 16);
        Ticket ticket2 = new Ticket("SVX", "OMS", 6556, 10, 12);
        Ticket ticket3 = new Ticket("LED", "OMS", 1234, 1, 3);
        Ticket ticket4 = new Ticket("OMS", "SVX", 1234, 0, 9);
        Ticket ticket5 = new Ticket("SVX", "TDF", 1234, 0, 9);
        int actual = aviaSouls.searchAndSortBy("TOF", "SVX", comparator).length;
        int expected = 0;
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void searchAndSortOne() {
        AviaSouls aviaSouls = new AviaSouls();
        TicketTimeComparator comparator = new TicketTimeComparator();
        Ticket ticket1 = new Ticket("SVX", "LED", 1234, 12, 16);
        Ticket ticket2 = new Ticket("SVX", "OMS", 6556, 10, 12);
        Ticket ticket3 = new Ticket("LED", "OMS", 1234, 1, 3);
        Ticket ticket4 = new Ticket("OMS", "SVX", 1234, 0, 9);
        Ticket ticket5 = new Ticket("SVX", "TDF", 1234, 0, 9);
        aviaSouls.add(ticket3);
        Ticket[] actual = aviaSouls.searchAndSortBy("LED", "OMS", comparator);
        Ticket[] expected = {ticket3};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchAndSortSome() {
        AviaSouls aviaSouls = new AviaSouls();
        TicketTimeComparator comparator = new TicketTimeComparator();
        Ticket ticket1 = new Ticket("SVX", "LED", 1234, 12, 16);
        Ticket ticket2 = new Ticket("SVX", "OMS", 6556, 10, 18);
        Ticket ticket3 = new Ticket("LED", "OMS", 1234, 1, 3);
        Ticket ticket4 = new Ticket("OMS", "SVX", 1234, 0, 9);
        Ticket ticket5 = new Ticket("SVX", "OMS", 14564, 10, 14);
        Ticket ticket6 = new Ticket("OMS", "SVX", 1234, 0, 9);
        Ticket ticket7 = new Ticket("SVX", "OMS", 14564, 10, 15);
        Ticket ticket8 = new Ticket("OMS", "SVX", 1234, 0, 9);
        Ticket ticket9 = new Ticket("SVX", "OMS", 14564, 10, 15);
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        aviaSouls.add(ticket6);
        aviaSouls.add(ticket7);
        aviaSouls.add(ticket8);
        aviaSouls.add(ticket9);
        Ticket[] actual = aviaSouls.searchAndSortBy("SVX", "OMS", comparator);
        Ticket[] expected = {ticket5, ticket7, ticket9, ticket2};
        Assertions.assertArrayEquals(expected, actual);
    }
}