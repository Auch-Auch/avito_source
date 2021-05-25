package com.yandex.mobile.ads;

import java.util.Locale;
public final class AdRequestError {
    private final int a;
    private final String b;

    public static final class Code {
        public static final int INTERNAL_ERROR = 1;
        public static final int INVALID_REQUEST = 2;
        public static final int NETWORK_ERROR = 3;
        public static final int NO_FILL = 4;
        public static final int SYSTEM_ERROR = 5;
        public static final int UNKNOWN_ERROR = 0;
    }

    public AdRequestError(int i, String str) {
        this.a = i;
        this.b = str;
    }

    public final int getCode() {
        return this.a;
    }

    public final String getDescription() {
        return this.b;
    }

    public final String toString() {
        return String.format(Locale.US, "AdRequestError (code: %d, description: %s)", Integer.valueOf(this.a), this.b);
    }
}
