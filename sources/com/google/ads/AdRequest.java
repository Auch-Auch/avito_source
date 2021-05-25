package com.google.ads;
@Deprecated
public final class AdRequest {
    public static final String LOGTAG = "Ads";
    public static final String TEST_EMULATOR = "B3EEABB8EE11C2BE770B684D95219ECB";
    public static final String VERSION = "0.0.0";

    public enum ErrorCode {
        INVALID_REQUEST("Invalid Ad request."),
        NO_FILL("Ad request successful, but no ad returned due to lack of ad inventory."),
        NETWORK_ERROR("A network error occurred."),
        INTERNAL_ERROR("There was an internal error.");
        
        public final String a;

        /* access modifiers changed from: public */
        ErrorCode(String str) {
            this.a = str;
        }

        @Override // java.lang.Enum, java.lang.Object
        public final String toString() {
            return this.a;
        }
    }

    public enum Gender {
        UNKNOWN,
        MALE,
        FEMALE
    }
}
