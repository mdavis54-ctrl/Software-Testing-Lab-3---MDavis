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
        assertEquals(50.00,
                park.calculateStayPrice(1, 30, false, false),
                0.01);
    }

    // TC02: Below minimum stay
    @Test
    void belowMinimumStay() {
        assertThrows(NightReservationException.class, () ->
                park.calculateStayPrice(0, 30, false, false));
    }

    // TC03: Maximum valid stay
    @Test
    void maximumStay() throws Exception {
        assertEquals(700.00,
                park.calculateStayPrice(14, 30, false, false),
                0.01);
    }

    // TC04: Above maximum stay
    @Test
    void aboveMaximumStay() {
        assertThrows(NightReservationException.class, () ->
                park.calculateStayPrice(15, 30, false, false));
    }

    // TC05: Child age boundary
    @Test
    void childAgeBoundary() throws Exception {
        assertEquals(175.00,
                park.calculateStayPrice(7, 12, false, false),
                0.01);
    }

    // TC06: Adult age boundary
    @Test
    void adultAgeBoundary() throws Exception {
        assertEquals(350.00,
                park.calculateStayPrice(7, 13, false, false),
                0.01);
    }

    // TC07: Senior age boundary
    @Test
    void seniorAgeBoundary() throws Exception {
        assertEquals(280.00,
                park.calculateStayPrice(7, 65, false, false),
                0.01);
    }

    // TC08: Negative age
    @Test
    void negativeAge() {
        assertThrows(GuestAgeReservationException.class, () ->
                park.calculateStayPrice(7, -1, false, false));
    }

    // TC09: Arkansas resident discount
    @Test
    void arkansasResidentDiscount() throws Exception {
        assertEquals(340.00,
                park.calculateStayPrice(7, 30, true, false),
                0.01);
    }

    // TC10: Veteran discount
    @Test
    void veteranDiscount() throws Exception {
        assertEquals(315.00,
                park.calculateStayPrice(7, 30, false, true),
                0.01);
    }

    // TC11: Arkansas resident and veteran discount
    @Test
    void residentAndVeteranDiscount() throws Exception {
        assertEquals(306.00,
                park.calculateStayPrice(7, 30, true, true),
                0.01);
    }

    // TC12: Normal adult stay
    @Test
    void normalAdultStay() throws Exception {
        assertEquals(350.00,
                park.calculateStayPrice(7, 30, false, false),
                0.01);
    }

    // TC13: Age zero is a valid child
    @Test
    void ageZeroIsChild() throws Exception {
        assertEquals(175.00,
                park.calculateStayPrice(7, 0, false, false),
                0.01);
    }
}