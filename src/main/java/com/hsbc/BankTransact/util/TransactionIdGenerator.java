package com.hsbc.BankTransact.util;

import java.security.SecureRandom;

/**
 * @author huyongbing
 * Created on 2025-05-20
 */
public class TransactionIdGenerator {
    private static final SecureRandom random = new SecureRandom();

    public static String generateId() {
        long timestamp = System.currentTimeMillis();
        int randomSuffix = 100000 + random.nextInt(900000);
        return String.valueOf(timestamp) + randomSuffix;
    }
}
