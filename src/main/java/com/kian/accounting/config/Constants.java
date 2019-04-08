package com.kian.accounting.config;

/**
 * Application constants.
 */
public final class Constants {

    // Regex for acceptable logins
    public static final String LOGIN_REGEX = "^[_'.@A-Za-z0-9-]*$";

    public static final String SYSTEM_ACCOUNT = "system";
    public static final String ANONYMOUS_USER = "anonymoususer";
    public static final String DEFAULT_LANGUAGE = "fa";
    public static final String LEGAL_BUSINESS = "LEGAL";
    public static final String INDIVIDUAL_BUSINESS = "INDIVIDUAL";
    public static final String PARTY_NOTFOUND = "party.notFound";

    public static final Long MAX_QR_ORDER = 99L;

    private Constants() {
    }
}
