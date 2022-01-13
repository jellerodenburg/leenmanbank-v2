package com.example.intellijprojectleenmanbankjavafx.database.model;

import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class TransactionTest {
    long VALID_ID = 12345;
    String VALID_ACCOUNT = "123456789";
    double VALID_AMOUNT = 19.99;
    long INVALID_ID = -1L;
    double INVALID_AMOUNT = -1.0;

    /**
     * @verifies have current date set on creation
     * @see Transaction#Transaction(long, String, double)
     */

    @Test
    void Transaction_shouldHaveCurrentDateSetOnCreation() throws Exception {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Transaction sut = new Transaction(VALID_ID, VALID_ACCOUNT, VALID_AMOUNT);
        Date date = new Date(System.currentTimeMillis());
        String currentDate = formatter.format(date);
        assertEquals(currentDate, sut.getDate());
    }

    /**
     * @verifies have current time set at creation
     * @see Transaction#Transaction(long, String, double)
     */
    @Test
    void Transaction_shouldHaveCurrentTimeSetAtCreation() throws Exception {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        Transaction sut = new Transaction(VALID_ID, VALID_ACCOUNT, VALID_AMOUNT);
        Date currentDate = new Date(System.currentTimeMillis());
        String currentTime = formatter.format(currentDate);
        assertEquals(currentTime, sut.getTime());
    }

    /**
     * @verifies ThrowIllegalArgumentExceptionWithAmountBelow0
     * @see Transaction#Transaction(long, String, double)
     */
    @Test
    void Transaction_shouldThrowIllegalArgumentExceptionWithAmountBelow0() throws Exception {
        assertThrows(IllegalArgumentException.class, () -> {
            new Transaction(INVALID_ID, VALID_ACCOUNT, VALID_AMOUNT);
        });
    }

    /**
     * @verifies ThrowIllegalArgumentExceptionWithIdBelow0
     * @see Transaction#Transaction(long, String, double)
     */
    @Test
    void Transaction_shouldThrowIllegalArgumentExceptionWithIdBelow0() throws Exception {
        assertThrows(IllegalArgumentException.class, () -> {
            new Transaction(VALID_ID, VALID_ACCOUNT, INVALID_AMOUNT);
        });
    }

    /**
     * @verifies ThrowIllegalArgumentExceptionForNullValues
     * @see Transaction#Transaction(long, String, double)
     */
    @Test
    void Transaction_shouldThrowIllegalArgumentExceptionForNullValues() throws Exception {
        assertThrows(IllegalArgumentException.class, () -> {
            new Transaction(0, VALID_ACCOUNT, VALID_AMOUNT);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Transaction(VALID_ID, null, VALID_AMOUNT);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Transaction(VALID_ID, VALID_ACCOUNT, 0);
        });
    }
}
