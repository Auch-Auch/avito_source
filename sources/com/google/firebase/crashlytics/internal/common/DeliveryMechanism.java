package com.google.firebase.crashlytics.internal.common;
public enum DeliveryMechanism {
    DEVELOPER(1),
    USER_SIDELOAD(2),
    TEST_DISTRIBUTION(3),
    APP_STORE(4);
    
    public final int a;

    /* access modifiers changed from: public */
    DeliveryMechanism(int i) {
        this.a = i;
    }

    public static DeliveryMechanism determineFrom(String str) {
        return str != null ? APP_STORE : DEVELOPER;
    }

    public int getId() {
        return this.a;
    }

    @Override // java.lang.Enum, java.lang.Object
    public String toString() {
        return Integer.toString(this.a);
    }
}
