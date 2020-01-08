package com.qa.twitter;

import lombok.Getter;

import static com.qa.twitter.utils.Decryptor.decrypt;

@Getter
public enum User {
    USER_PROD(Constants.API_VADYM, Constants.PROD_PASSWORD),
    USER_WITH_WRONG_LOGIN(Constants.API_VADYM + "a", "010901098v@M"),
    USER_WITH_WRONG_PASSWORD(Constants.API_VADYM, "010901098v@D"),
    USER_WITH_EMPTY_PASSWORD(Constants.API_VADYM, "");

    private String login;
    private String password;

    User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    private static class Constants {
        public static final String API_VADYM = "ApiVadym";
        public static final String PROD_PASSWORD = decrypt("SyU1iejM9FePyHzBMM6nTxzZccfObvzw");
    }
}
