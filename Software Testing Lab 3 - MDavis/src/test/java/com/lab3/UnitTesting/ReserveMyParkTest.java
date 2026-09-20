package com.lab3.UnitTesting;

import com.lab3.Exceptions.GuestAgeReservationException;
import com.lab3.Exceptions.NightReservationException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ReserveMyParkTest {

    private final ReserveMyPark park = new ReserveMyPark();

    // TC01: Minimum valid stay
    @Test
    void minimumStay() throws Exception {
        double result = park.calculateStayPrice(1, 30, false, false);
        System.out.println("TC01 - Minimum valid stay: $" + result);

        assertEquals(50.00, result, 0.01);
    }

    // TC02: Below minimum stay
    @Test
    void belowMinimumStay() {
        assertThrows(NightReservationException.class, () ->
                park.calculateStayPrice(0, 30, false, false));

        System.out.println("TC02 - Below minimum stay: NightReservationException thrown");
    }

    // TC03: Maximum valid stay
    @Test
    void maximumStay() throws Exception {
        double result = park.calculateStayPrice(14, 30, false, false);
        System.out.println("TC03 - Maximum valid stay: $" + result);

        assertEquals(700.00, result, 0.01);
    }

    // TC04: Above maximum stay
    @Test
    void aboveMaximumStay() {
        assertThrows(NightReservationException.class, () ->
                park.calculateStayPrice(15, 30, false, false));

        System.out.println("TC04 - Above maximum stay: NightReservationException thrown");
    }

    // TC05: Child age boundary
    @Test
    void childAgeBoundary() throws Exception {
        double result = park.calculateStayPrice(7, 12, false, false);
        System.out.println("TC05 - Child age boundary: $" + result);

        assertEquals(175.00, result, 0.01);
    }

    // TC06: Adult age boundary
    @Test
    void adultAgeBoundary() throws Exception {
        double result = park.calculateStayPrice(7, 13, false, false);
        System.out.println("TC06 - Adult age boundary: $" + result);

        assertEquals(350.00, result, 0.01);
    }

    // TC07: Senior age boundary
    @Test
    void seniorAgeBoundary() throws Exception {
        double result = park.calculateStayPrice(7, 65, false, false);
        System.out.println("TC07 - Senior age boundary: $" + result);

        assertEquals(280.00, result, 0.01);
    }

    // TC08: Negative age
    @Test
    void negativeAge() {
        assertThrows(GuestAgeReservationException.class, () ->
                park.calculateStayPrice(7, -1, false, false));

        System.out.println("TC08 - Negative age: GuestAgeReservationException thrown");
    }

    // TC09: Arkansas resident discount
    @Test
    void arkansasResidentDiscount() throws Exception {
        double result = park.calculateStayPrice(7, 30, true, false);
        System.out.println("TC09 - Arkansas resident discount: $" + result);

        assertEquals(340.00, result, 0.01);
    }

    // TC10: Veteran discount
    @Test
    void veteranDiscount() throws Exception {
        double result = park.calculateStayPrice(7, 30, false, true);
        System.out.println("TC10 - Veteran discount: $" + result);

        assertEquals(315.00, result, 0.01);
    }

    // TC11: Arkansas resident and veteran discount
    @Test
    void residentAndVeteranDiscount() throws Exception {
        double result = park.calculateStayPrice(7, 30, true, true);
        System.out.println("TC11 - Arkansas resident + veteran discount: $" + result);

        assertEquals(306.00, result, 0.01);
    }

    // TC12: Normal adult stay
    @Test
    void normalAdultStay() throws Exception {
        double result = park.calculateStayPrice(7, 30, false, false);
        System.out.println("TC12 - Normal adult stay: $" + result);

        assertEquals(350.00, result, 0.01);
    }

    // TC13: Age zero is a valid child
    @Test
    void ageZeroIsChild() throws Exception {
        double result = park.calculateStayPrice(7, 0, false, false);
        System.out.println("TC13 - Age zero is a valid child: $" + result);

        assertEquals(175.00, result, 0.01);
    }
}
