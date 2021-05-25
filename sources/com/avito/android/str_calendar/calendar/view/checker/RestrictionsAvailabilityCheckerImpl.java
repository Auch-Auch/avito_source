package com.avito.android.str_calendar.calendar.view.checker;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Sort;
import com.avito.android.str_calendar.booking.model.CalendarBookingRestriction;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import t6.v.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\u0004\b \u0010!J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u0006J\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R2\u0010\u0018\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00110\u0015j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0011`\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0017R2\u0010\u001a\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u0015j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004`\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u0017R2\u0010\u001c\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u0015j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004`\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u0017RJ\u0010\u001f\u001a6\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u001d0\u0015j\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u001d`\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u0017¨\u0006\""}, d2 = {"Lcom/avito/android/str_calendar/calendar/view/checker/RestrictionsAvailabilityCheckerImpl;", "Lcom/avito/android/str_calendar/calendar/view/checker/CalendarAvailabilityChecker;", "Ljava/util/Date;", Sort.DATE, "", "isCheckInAvailable", "(Ljava/util/Date;)Z", "checkInDate", "isCheckOutAvailable", "(Ljava/util/Date;Ljava/util/Date;)Z", "isCheckInOrCheckOutPotentiallyPossible", "startDate", "endDate", "", AuthSource.SEND_ABUSE, "(Ljava/util/Date;Ljava/util/Date;)I", "", "Lcom/avito/android/str_calendar/booking/model/CalendarBookingRestriction;", "e", "Ljava/util/List;", "restrictions", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "restrictionsMap", "d", "checkInOrCheckOutPotentialAvailabilityMap", AuthSource.BOOKING_ORDER, "checkInAvailabilityMap", "", "c", "checkOutAvailabilityMap", "<init>", "(Ljava/util/List;)V", "str-calendar_release"}, k = 1, mv = {1, 4, 2})
public final class RestrictionsAvailabilityCheckerImpl implements CalendarAvailabilityChecker {
    public final HashMap<Date, CalendarBookingRestriction> a = new HashMap<>();
    public final HashMap<Date, Boolean> b = new HashMap<>();
    public final HashMap<Date, Map<Date, Boolean>> c = new HashMap<>();
    public final HashMap<Date, Boolean> d = new HashMap<>();
    public final List<CalendarBookingRestriction> e;

    public RestrictionsAvailabilityCheckerImpl(@NotNull List<CalendarBookingRestriction> list) {
        boolean z;
        boolean z2;
        Intrinsics.checkNotNullParameter(list, "restrictions");
        this.e = list;
        int i = 0;
        for (T t : list) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            T t2 = t;
            Date date = t2.getDate();
            this.a.put(date, t2);
            if (t2.getAvailable()) {
                int min = Math.min(this.e.size() - 1, (t2.getMinimalDuration() + i) - 1);
                HashMap<Date, Boolean> hashMap = this.b;
                List slice = CollectionsKt___CollectionsKt.slice((List) this.e, new IntRange(i2, min));
                if (!(slice instanceof Collection) || !slice.isEmpty()) {
                    Iterator it = slice.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (!((CalendarBookingRestriction) it.next()).getAvailable()) {
                                z2 = false;
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    hashMap.put(date, Boolean.valueOf(z2));
                    this.d.put(date, Boolean.TRUE);
                }
                z2 = true;
                hashMap.put(date, Boolean.valueOf(z2));
                this.d.put(date, Boolean.TRUE);
            } else {
                this.b.put(date, Boolean.FALSE);
                int max = Math.max(0, i - t2.getMinimalDuration());
                HashMap<Date, Boolean> hashMap2 = this.d;
                List slice2 = CollectionsKt___CollectionsKt.slice((List) this.e, e.until(max, i));
                if (!(slice2 instanceof Collection) || !slice2.isEmpty()) {
                    Iterator it2 = slice2.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            if (!((CalendarBookingRestriction) it2.next()).getAvailable()) {
                                z = false;
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    hashMap2.put(date, Boolean.valueOf(z));
                }
                z = true;
                hashMap2.put(date, Boolean.valueOf(z));
            }
            HashMap<Date, Map<Date, Boolean>> hashMap3 = this.c;
            int minimalDuration = t2.getMinimalDuration();
            int maximalDuration = t2.getMaximalDuration();
            HashMap hashMap4 = new HashMap();
            boolean z3 = false;
            for (T t3 : this.e) {
                if (z3 || t3.getDate().compareTo(date) < 0) {
                    hashMap4.put(t3.getDate(), Boolean.FALSE);
                } else if (!t3.getAvailable()) {
                    Date date2 = t3.getDate();
                    int a3 = a(date, t3.getDate());
                    hashMap4.put(date2, Boolean.valueOf(minimalDuration <= a3 && maximalDuration >= a3));
                    z3 = true;
                } else {
                    Date date3 = t3.getDate();
                    int a4 = a(date, t3.getDate());
                    hashMap4.put(date3, Boolean.valueOf(minimalDuration <= a4 && maximalDuration >= a4));
                }
            }
            hashMap3.put(date, hashMap4);
            i = i2;
        }
    }

    public final int a(Date date, Date date2) {
        return (int) TimeUnit.DAYS.convert(date2.getTime() - date.getTime(), TimeUnit.MILLISECONDS);
    }

    @Override // com.avito.android.str_calendar.calendar.view.checker.CalendarAvailabilityChecker
    public boolean isCheckInAvailable(@NotNull Date date) {
        Intrinsics.checkNotNullParameter(date, Sort.DATE);
        Boolean bool = this.b.get(date);
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    @Override // com.avito.android.str_calendar.calendar.view.checker.CalendarAvailabilityChecker
    public boolean isCheckInOrCheckOutPotentiallyPossible(@NotNull Date date) {
        Intrinsics.checkNotNullParameter(date, Sort.DATE);
        Boolean bool = this.d.get(date);
        if (bool != null) {
            return bool.booleanValue();
        }
        throw new IllegalArgumentException("Illegal date " + date);
    }

    @Override // com.avito.android.str_calendar.calendar.view.checker.CalendarAvailabilityChecker
    public boolean isCheckOutAvailable(@NotNull Date date, @NotNull Date date2) {
        Boolean bool;
        Intrinsics.checkNotNullParameter(date, Sort.DATE);
        Intrinsics.checkNotNullParameter(date2, "checkInDate");
        Map<Date, Boolean> map = this.c.get(date2);
        if (map != null && (bool = map.get(date)) != null) {
            return bool.booleanValue();
        }
        throw new IllegalArgumentException("Illegal date " + date);
    }
}
