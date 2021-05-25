package com.avito.android.str_calendar.calendar.view.konveyor.items.day.seller;

import androidx.annotation.DrawableRes;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000b\u0010\fR\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/avito/android/str_calendar/calendar/view/konveyor/items/day/seller/Background;", "", "", AuthSource.SEND_ABUSE, "Ljava/lang/Integer;", "getPrimaryBackgroundRes", "()Ljava/lang/Integer;", "primaryBackgroundRes", AuthSource.BOOKING_ORDER, "getSecondaryBackgroundRes", "secondaryBackgroundRes", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "str-calendar_release"}, k = 1, mv = {1, 4, 2})
public final class Background {
    @Nullable
    public final Integer a;
    @Nullable
    public final Integer b;

    public Background() {
        this(null, null, 3, null);
    }

    public Background(@DrawableRes @Nullable Integer num, @DrawableRes @Nullable Integer num2) {
        this.a = num;
        this.b = num2;
    }

    @Nullable
    public final Integer getPrimaryBackgroundRes() {
        return this.a;
    }

    @Nullable
    public final Integer getSecondaryBackgroundRes() {
        return this.b;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Background(Integer num, Integer num2, int i, j jVar) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2);
    }
}
