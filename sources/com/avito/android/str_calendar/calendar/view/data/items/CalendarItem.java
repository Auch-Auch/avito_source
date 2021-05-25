package com.avito.android.str_calendar.calendar.view.data.items;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Sort;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/str_calendar/calendar/view/data/items/CalendarItem;", "", "<init>", "()V", "Empty", "Item", "Lcom/avito/android/str_calendar/calendar/view/data/items/CalendarItem$Item;", "Lcom/avito/android/str_calendar/calendar/view/data/items/CalendarItem$Empty;", "str-calendar_release"}, k = 1, mv = {1, 4, 2})
public abstract class CalendarItem {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/str_calendar/calendar/view/data/items/CalendarItem$Empty;", "Lcom/avito/android/str_calendar/calendar/view/data/items/CalendarItem;", "Ljava/util/Date;", AuthSource.SEND_ABUSE, "Ljava/util/Date;", "getNextDate", "()Ljava/util/Date;", "nextDate", "<init>", "(Ljava/util/Date;)V", "str-calendar_release"}, k = 1, mv = {1, 4, 2})
    public static final class Empty extends CalendarItem {
        @NotNull
        public final Date a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Empty(@NotNull Date date) {
            super(null);
            Intrinsics.checkNotNullParameter(date, "nextDate");
            this.a = date;
        }

        @NotNull
        public final Date getNextDate() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/str_calendar/calendar/view/data/items/CalendarItem$Item;", "Lcom/avito/android/str_calendar/calendar/view/data/items/CalendarItem;", "Ljava/util/Date;", AuthSource.SEND_ABUSE, "Ljava/util/Date;", "getDate", "()Ljava/util/Date;", Sort.DATE, "<init>", "(Ljava/util/Date;)V", "str-calendar_release"}, k = 1, mv = {1, 4, 2})
    public static final class Item extends CalendarItem {
        @NotNull
        public final Date a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Item(@NotNull Date date) {
            super(null);
            Intrinsics.checkNotNullParameter(date, Sort.DATE);
            this.a = date;
        }

        @NotNull
        public final Date getDate() {
            return this.a;
        }
    }

    public CalendarItem() {
    }

    public CalendarItem(j jVar) {
    }
}
