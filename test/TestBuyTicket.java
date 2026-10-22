import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestBuyTicket {

    // Remaining Mutants to Kill
    // isMinor : changed conditional boundary → SURVIVED CHECK
    // isMinor : Substituted 18 with 19 → SURVIVED CHECK
    // Substituted 65 with 66 → SURVIVED CHECK
    // isSenior : changed conditional boundary → SURVIVED CHECK
    // calculatePrice : removed conditional - replaced equality check with true → SURVIVED


    @Test 
    public void testWeekInAdvance() {
        int basePrice = 150;
        int daysUntilEvent = 7;
        int customerAge = 28;
        boolean isMember = true;

        double price = BuyTicket.calculatePrice(basePrice, daysUntilEvent, customerAge, isMember); 
        double expectedDiscount = basePrice * .24; //.14 discount for 7 days in advance + .10 discount for member

        assertEquals(basePrice - expectedDiscount, price, 0.0);
    }

    @Test 
    public void testDayOf() {
        int basePrice = 150;
        int daysUntilEvent = 0;
        int customerAge = 31;
        boolean isMember = true;
        
        double price = BuyTicket.calculatePrice(basePrice, daysUntilEvent, customerAge, isMember); 
        double expectedDiscount = basePrice * .10; //.10 discount for membership

        assertEquals(basePrice - expectedDiscount, price, 0.0); 
    }

    @Test
    public void testSeniorDiscount(){
        int basePrice = 150;
        int daysUntilEvent = 0;
        int customerAge = 70;
        boolean isMember = true;

        double price = BuyTicket.calculatePrice(basePrice, daysUntilEvent, customerAge, isMember);
        double expectedDiscount = basePrice * .2; //.20 discount for senior citizen discount 
        
        assertEquals(basePrice - expectedDiscount, price, 0.0);

    }

    @Test
    public void testMinorDiscount(){
        int basePrice = 150;
        int daysUntilEvent = 0;
        int customerAge = 10;
        boolean isMember = true;

        double price = BuyTicket.calculatePrice(basePrice, daysUntilEvent, customerAge, isMember);
        double expectedDiscount = basePrice * .26 ; //.10 for member + .16 for minor
        
        assertEquals(basePrice - expectedDiscount, price, 0.0);


    }

    @Test 
    public void testIsMinor(){
        int customerAge = 18;
        boolean r = BuyTicket.isMinor(customerAge);
        assertEquals(false, r);
    }

    @Test 
    public void testIsSenior(){
        int customerAge = 66;
        boolean r = BuyTicket.isSenior(customerAge);
        assertEquals(true, r);
    }

    @Test 
    public void testIs65(){
        int customerAge = 65;
        boolean r = BuyTicket.isSenior(customerAge);
        assertEquals(false, r);
    }

    @Test
    public void testZeroDiscount(){
        int basePrice = 150;
        int daysUntilEvent = 0;
        int customerAge = 20;
        boolean isMember = false;

        double price = BuyTicket.calculatePrice(basePrice, daysUntilEvent, customerAge, isMember);
        System.out.println(price);
        
        assertEquals(150.0, price, 0.0);


    }

}
