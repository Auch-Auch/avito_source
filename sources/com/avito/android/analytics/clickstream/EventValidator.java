package com.avito.android.analytics.clickstream;

import a2.b.a.a.a;
import com.avito.android.analytics.provider.clickstream.ClickStreamEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0004¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/analytics/clickstream/EventValidator;", "", "Lcom/avito/android/analytics/provider/clickstream/ClickStreamEvent;", "event", "", "validateOrFail", "(Lcom/avito/android/analytics/provider/clickstream/ClickStreamEvent;)V", "", "reason", "throwValidationError", "(Lcom/avito/android/analytics/provider/clickstream/ClickStreamEvent;Ljava/lang/String;)V", "<init>", "()V", "analytics-clickstream_release"}, k = 1, mv = {1, 4, 2})
public abstract class EventValidator {
    public final void throwValidationError(@NotNull ClickStreamEvent clickStreamEvent, @NotNull String str) {
        Intrinsics.checkNotNullParameter(clickStreamEvent, "event");
        Intrinsics.checkNotNullParameter(str, "reason");
        StringBuilder Q = a.Q("Invalid event: ", "id=");
        Q.append(clickStreamEvent.getEventId());
        Q.append(' ');
        Q.append(clickStreamEvent.getParams());
        Q.append(" \n");
        Q.append("Reason: ");
        throw new FatalValidationError(a.u(Q, str, " \n", "You can disable this validation by clickstream_strict_mode feature toggle."));
    }

    public abstract void validateOrFail(@NotNull ClickStreamEvent clickStreamEvent);
}
