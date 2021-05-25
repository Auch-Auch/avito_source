package com.avito.android.util;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/avito/android/util/DateIntervalChangePayload;", "", "Lcom/avito/android/util/DateChange;", AuthSource.SEND_ABUSE, "Lcom/avito/android/util/DateChange;", "getStartDateChange", "()Lcom/avito/android/util/DateChange;", "startDateChange", "", "c", "Ljava/lang/Boolean;", "getTillCurrentTime", "()Ljava/lang/Boolean;", "tillCurrentTime", AuthSource.BOOKING_ORDER, "getEndDateChange", "endDateChange", "<init>", "(Lcom/avito/android/util/DateChange;Lcom/avito/android/util/DateChange;Ljava/lang/Boolean;)V", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
public final class DateIntervalChangePayload {
    @Nullable
    public final DateChange a;
    @Nullable
    public final DateChange b;
    @Nullable
    public final Boolean c;

    public DateIntervalChangePayload(@Nullable DateChange dateChange, @Nullable DateChange dateChange2, @Nullable Boolean bool) {
        this.a = dateChange;
        this.b = dateChange2;
        this.c = bool;
    }

    @Nullable
    public final DateChange getEndDateChange() {
        return this.b;
    }

    @Nullable
    public final DateChange getStartDateChange() {
        return this.a;
    }

    @Nullable
    public final Boolean getTillCurrentTime() {
        return this.c;
    }
}
