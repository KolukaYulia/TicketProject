import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TicketManagerTest {
    @Test
    public void testTicketSort() {
        TicketRepository repo = new TicketRepository();
        TicketManager manager = new TicketManager(repo);
        Ticket ticket1 = new Ticket(1,5000, "LED", "DME", 60);
        Ticket ticket2 = new Ticket(2,6000, "DME", "LED", 70);
        Ticket ticket3 = new Ticket(3,1000, "LED", "KGD", 90);
        Ticket ticket4 = new Ticket(4,3000, "LED", "DME", 65);
        Ticket ticket5 = new Ticket(5,20000, "LED", "DME", 130);
        Ticket ticket6 = new Ticket(6,12000, "KGD", "LED", 100);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);

        Ticket[] expected = {ticket4, ticket1, ticket5};
        Ticket[] actual = manager.findAll("LED", "DME");

        Assertions.assertArrayEquals(expected, actual);


    };

    @Test
    public void testTicketSortThenNoTickets() {
        TicketRepository repo = new TicketRepository();
        TicketManager manager = new TicketManager(repo);
        Ticket ticket1 = new Ticket(1,5000, "LED", "DME", 60);
        Ticket ticket2 = new Ticket(2,6000, "DME", "LED", 70);
        Ticket ticket3 = new Ticket(3,1000, "LED", "KGD", 90);
        Ticket ticket4 = new Ticket(4,3000, "LED", "DME", 65);
        Ticket ticket5 = new Ticket(5,20000, "LED", "ASF", 130);
        Ticket ticket6 = new Ticket(6,12000, "KGD", "LED", 100);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);

        Ticket[] expected = {};
        Ticket[] actual = manager.findAll("DME", "KGD");

        Assertions.assertArrayEquals(expected, actual);


    };
    @Test
    public void testTicketSortThenOneTicket() {
        TicketRepository repo = new TicketRepository();
        TicketManager manager = new TicketManager(repo);
        Ticket ticket1 = new Ticket(1,5000, "LED", "DME", 60);
        Ticket ticket2 = new Ticket(2,6000, "DME", "LED", 70);
        Ticket ticket3 = new Ticket(3,1000, "LED", "KGD", 90);
        Ticket ticket4 = new Ticket(4,3000, "LED", "DME", 65);
        Ticket ticket5 = new Ticket(5,20000, "LED", "ASF", 130);
        Ticket ticket6 = new Ticket(6,12000, "KGD", "LED", 100);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);

        Ticket[] expected = {ticket6};
        Ticket[] actual = manager.findAll("KGD", "LED");

        Assertions.assertArrayEquals(expected, actual);


    };


}
