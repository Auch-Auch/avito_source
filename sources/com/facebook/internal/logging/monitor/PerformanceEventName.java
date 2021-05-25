package com.facebook.internal.logging.monitor;

import androidx.annotation.RestrictTo;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public enum PerformanceEventName {
    EVENT_NAME_FOR_TEST_FIRST("EVENT_NAME_FOR_TEST_FIRST"),
    EVENT_NAME_FOR_TEST_SECOND("EVENT_NAME_FOR_TEST_SECOND"),
    FB_CORE_STARTUP("FB_CORE_STARTUP");
    
    public String a;

    /* access modifiers changed from: public */
    PerformanceEventName(String str) {
        this.a = str;
    }

    @Override // java.lang.Enum, java.lang.Object
    public String toString() {
        return this.a;
    }
}
