package com.avito.android.str_calendar.calendar.view.konveyor.items.month;

import com.avito.android.remote.auth.AuthSource;
import com.avito.konveyor.blueprint.Item;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\r\u001a\u00020\b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/str_calendar/calendar/view/konveyor/items/month/MonthItem;", "Lcom/avito/konveyor/blueprint/Item;", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getText", "()Ljava/lang/String;", "text", "", AuthSource.SEND_ABUSE, "J", "getId", "()J", "id", "<init>", "(JLjava/lang/String;)V", "str-calendar_release"}, k = 1, mv = {1, 4, 2})
public final class MonthItem implements Item {
    public final long a;
    @NotNull
    public final String b;

    public MonthItem(long j, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        this.a = j;
        this.b = str;
    }

    @Override // com.avito.konveyor.blueprint.Item
    public long getId() {
        return this.a;
    }

    @NotNull
    public final String getText() {
        return this.b;
    }
}
