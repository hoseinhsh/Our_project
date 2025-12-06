import constants.Notifier;
import constants.PaymentMethods;
import models.Customer;
import models.LuxuryRoom;
import models.Room;
import services.Reservation;
import services.ReservationService;

public class Main {
    public static void main(String[] args) {
        Customer client = new Customer("Ali", "ali@example.com", "09124483765", "Paris");
        Room room = new LuxuryRoom("203", 150);
        Reservation reservation = new Reservation(room, client, 2);

        ReservationService service = new ReservationService();
        service.createReservation(reservation, PaymentMethods.PAYPAL, Notifier.EMAIL);
    }
}

