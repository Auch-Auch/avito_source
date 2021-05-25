package com.avito.android.analytics.statsd;

import a2.b.a.a.a;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0002\u0007\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/analytics/statsd/StatsdEventValidator;", "", "Lcom/avito/android/analytics/statsd/StatsdEvent;", "event", "", "validateOrFail", "(Lcom/avito/android/analytics/statsd/StatsdEvent;)V", "Impl", "Stub", "analytics-statsd_release"}, k = 1, mv = {1, 4, 2})
public interface StatsdEventValidator {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/analytics/statsd/StatsdEventValidator$Impl;", "Lcom/avito/android/analytics/statsd/StatsdEventValidator;", "Lcom/avito/android/analytics/statsd/StatsdEvent;", "event", "", "validateOrFail", "(Lcom/avito/android/analytics/statsd/StatsdEvent;)V", "<init>", "()V", "analytics-statsd_release"}, k = 1, mv = {1, 4, 2})
    public static final class Impl implements StatsdEventValidator {
        @Override // com.avito.android.analytics.statsd.StatsdEventValidator
        public void validateOrFail(@NotNull StatsdEvent statsdEvent) {
            String str;
            Intrinsics.checkNotNullParameter(statsdEvent, "event");
            String key = statsdEvent.getKey();
            if (!StatsdEventValidatorKt.getInvalidStatsdSymbols().matches(key)) {
                Iterator it = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"apps.mobile.", "tm.", "c.", "g."}).iterator();
                while (true) {
                    if (!it.hasNext()) {
                        str = null;
                        break;
                    }
                    String str2 = (String) it.next();
                    if (m.startsWith$default(key, str2, false, 2, null)) {
                        str = a.e3("Invalid prefix: ", str2, " is not allowed");
                        break;
                    }
                }
            } else {
                str = "Invalid symbols. Use statdSeriesElement() to replace them.";
            }
            if (str != null) {
                StringBuilder Q = a.Q("Invalid event: ", "id=");
                Q.append(statsdEvent.getKey());
                Q.append(' ');
                Q.append(statsdEvent.getValue());
                Q.append(" \n");
                Q.append("Reason: ");
                throw new FatalValidationError(a.u(Q, str, " \n", "You can disable this validation by statsd_strict_mode feature toggle."));
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/analytics/statsd/StatsdEventValidator$Stub;", "Lcom/avito/android/analytics/statsd/StatsdEventValidator;", "Lcom/avito/android/analytics/statsd/StatsdEvent;", "event", "", "validateOrFail", "(Lcom/avito/android/analytics/statsd/StatsdEvent;)V", "<init>", "()V", "analytics-statsd_release"}, k = 1, mv = {1, 4, 2})
    public static final class Stub implements StatsdEventValidator {
        @Override // com.avito.android.analytics.statsd.StatsdEventValidator
        public void validateOrFail(@NotNull StatsdEvent statsdEvent) {
            Intrinsics.checkNotNullParameter(statsdEvent, "event");
        }
    }

    void validateOrFail(@NotNull StatsdEvent statsdEvent);
}
