package com.avito.android.publish.date_picker;

import a2.g.r.g;
import android.view.View;
import com.avito.android.lib.design.picker.Picker;
import com.avito.android.lib.design.picker.WheelData;
import com.avito.android.lib.design.picker.WheelGravity;
import com.avito.android.lib.design.picker.WheelStyle;
import com.avito.android.publish.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.category_parameters.FormattedDateDisplayingType;
import com.avito.android.util.CalendarsKt;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Objects;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010+\u001a\u00020*\u0012\u0006\u0010,\u001a\u00020\u0002\u0012\b\u0010-\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010.\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b/\u00100J\u0017\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\u00108\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0012R.\u0010\u001b\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00170\u0016j\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0017`\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001e\u0010$\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010 8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R.\u0010&\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00170\u0016j\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0017`\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010\u001aR\u0016\u0010)\u001a\u00020'8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010(¨\u00061"}, d2 = {"Lcom/avito/android/publish/date_picker/MonthAndYearPicker;", "Lcom/avito/android/publish/date_picker/DatePicker;", "", "value", "setCurrentValue", "(J)J", "getCurrentValue", "()Ljava/lang/Long;", "Lkotlin/Pair;", "", AuthSource.SEND_ABUSE, "(J)Lkotlin/Pair;", "", "h", "Z", "limitsInstalled", "Ljava/util/Date;", "c", "Ljava/util/Date;", "maxDate", AuthSource.BOOKING_ORDER, "minDate", "Ljava/util/ArrayList;", "Lcom/avito/android/lib/design/picker/WheelData;", "Lkotlin/collections/ArrayList;", "e", "Ljava/util/ArrayList;", "monthNames", "Lcom/avito/android/lib/design/picker/Picker;", "d", "Lcom/avito/android/lib/design/picker/Picker;", "picker", "Lkotlin/Function0;", "", g.a, "Lkotlin/jvm/functions/Function0;", "selectionSingleAction", "f", "years", "Ljava/util/GregorianCalendar;", "Ljava/util/GregorianCalendar;", FormattedDateDisplayingType.TYPE_CALENDAR, "Landroid/view/View;", "view", "currentValue", "minValue", "maxValue", "<init>", "(Landroid/view/View;JLjava/lang/Long;Ljava/lang/Long;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class MonthAndYearPicker implements DatePicker {
    public final GregorianCalendar a;
    public Date b = new Date(-631152000000L);
    public Date c = new Date(System.currentTimeMillis());
    public final Picker d;
    public final ArrayList<WheelData<?>> e;
    public final ArrayList<WheelData<?>> f;
    public Function0<Unit> g;
    public boolean h;

    public static final class a extends Lambda implements Function2<WheelData<?>, WheelData<?>, Unit> {
        public final /* synthetic */ MonthAndYearPicker a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;
        public final /* synthetic */ int e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(MonthAndYearPicker monthAndYearPicker, int i, int i2, int i3, int i4) {
            super(2);
            this.a = monthAndYearPicker;
            this.b = i;
            this.c = i2;
            this.d = i3;
            this.e = i4;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public Unit invoke(WheelData<?> wheelData, WheelData<?> wheelData2) {
            WheelData<?> wheelData3 = wheelData;
            WheelData<?> wheelData4 = wheelData2;
            if (!(wheelData3 == null || wheelData4 == null)) {
                GregorianCalendar gregorianCalendar = this.a.a;
                Object key = wheelData3.getKey();
                Objects.requireNonNull(key, "null cannot be cast to non-null type kotlin.Int");
                gregorianCalendar.set(2, ((Integer) key).intValue());
                GregorianCalendar gregorianCalendar2 = this.a.a;
                Object key2 = wheelData4.getKey();
                Objects.requireNonNull(key2, "null cannot be cast to non-null type kotlin.Int");
                gregorianCalendar2.set(1, ((Integer) key2).intValue());
                CalendarsKt.clearDayOfMonth(this.a.a);
                Function0 function0 = this.a.g;
                if (function0 != null) {
                    Unit unit = (Unit) function0.invoke();
                }
                this.a.g = null;
                if (!this.a.h) {
                    int i = this.b;
                    Object key3 = wheelData3.getKey();
                    if ((key3 instanceof Integer) && i == ((Integer) key3).intValue()) {
                        int i2 = this.c;
                        Object key4 = wheelData4.getKey();
                        if ((key4 instanceof Integer) && i2 == ((Integer) key4).intValue()) {
                            Picker picker = this.a.d;
                            Object obj = this.a.e.get(this.d);
                            Intrinsics.checkNotNullExpressionValue(obj, "monthNames[maxMonth]");
                            Object obj2 = this.a.f.get(this.a.f.size() - 1);
                            Intrinsics.checkNotNullExpressionValue(obj2, "years[years.size - 1]");
                            picker.setUpperLimit((WheelData) obj, (WheelData) obj2, 0, 1);
                            Picker picker2 = this.a.d;
                            Object obj3 = this.a.e.get(this.e);
                            Intrinsics.checkNotNullExpressionValue(obj3, "monthNames[minMonth]");
                            Object obj4 = this.a.f.get(0);
                            Intrinsics.checkNotNullExpressionValue(obj4, "years[0]");
                            picker2.setLowerLimit((WheelData) obj3, (WheelData) obj4, 0, 1);
                            this.a.h = true;
                        }
                    }
                }
            }
            return Unit.INSTANCE;
        }
    }

    public static final class b extends Lambda implements Function0<Unit> {
        public final /* synthetic */ MonthAndYearPicker a;
        public final /* synthetic */ WheelData b;
        public final /* synthetic */ WheelData c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(MonthAndYearPicker monthAndYearPicker, WheelData wheelData, WheelData wheelData2) {
            super(0);
            this.a = monthAndYearPicker;
            this.b = wheelData;
            this.c = wheelData2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.d.setSecondWheelValue(this.b);
            this.a.d.setFirstWheelValue(this.c);
            return Unit.INSTANCE;
        }
    }

    public MonthAndYearPicker(@NotNull View view, long j, @Nullable Long l, @Nullable Long l2) {
        Intrinsics.checkNotNullParameter(view, "view");
        GregorianCalendar gregorianCalendar = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
        this.a = gregorianCalendar;
        View findViewById = view.findViewById(R.id.date_picker);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type com.avito.android.lib.design.picker.Picker");
        Picker picker = (Picker) findViewById;
        this.d = picker;
        WheelData.Companion companion = WheelData.Companion;
        ArrayList<WheelData<?>> monthNominative = companion.getMonthNominative();
        this.e = monthNominative;
        if (l != null) {
            this.b = new Date(l.longValue());
        }
        if (l2 != null) {
            this.c = new Date(l2.longValue());
        }
        Pair<Integer, Integer> a3 = a(this.b.getTime());
        int intValue = a3.component1().intValue();
        int intValue2 = a3.component2().intValue();
        Pair<Integer, Integer> a4 = a(this.c.getTime());
        int intValue3 = a4.component1().intValue();
        ArrayList<WheelData<?>> years = companion.getYears(intValue2, a4.component2().intValue());
        this.f = years;
        picker.addWheel(monthNominative, new WheelStyle(WheelGravity.RIGHT, false, 0, 4, null));
        picker.addWheel(years, new WheelStyle(WheelGravity.LEFT, false, 0, 4, null));
        gregorianCalendar.setTimeInMillis(setCurrentValue(j));
        Pair pair = TuplesKt.to(Integer.valueOf(gregorianCalendar.get(2)), Integer.valueOf(gregorianCalendar.get(1)));
        picker.setOnSelection(new a(this, ((Number) pair.component1()).intValue(), ((Number) pair.component2()).intValue(), intValue3, intValue));
    }

    public final Pair<Integer, Integer> a(long j) {
        this.a.setTimeInMillis(j);
        return TuplesKt.to(Integer.valueOf(this.a.get(2)), Integer.valueOf(this.a.get(1)));
    }

    @Override // com.avito.android.publish.date_picker.DatePicker
    @Nullable
    public Long getCurrentValue() {
        WheelData<?> firstWheelValue = this.d.getFirstWheelValue();
        WheelData<?> secondWheelValue = this.d.getSecondWheelValue();
        if (firstWheelValue == null || secondWheelValue == null) {
            return null;
        }
        GregorianCalendar gregorianCalendar = this.a;
        Object key = firstWheelValue.getKey();
        Objects.requireNonNull(key, "null cannot be cast to non-null type kotlin.Int");
        gregorianCalendar.set(2, ((Integer) key).intValue());
        GregorianCalendar gregorianCalendar2 = this.a;
        Object key2 = secondWheelValue.getKey();
        Objects.requireNonNull(key2, "null cannot be cast to non-null type kotlin.Int");
        gregorianCalendar2.set(1, ((Integer) key2).intValue());
        CalendarsKt.clearDayOfMonth(this.a);
        return Long.valueOf(this.a.getTimeInMillis());
    }

    @Override // com.avito.android.publish.date_picker.DatePicker
    public long setCurrentValue(long j) {
        T t;
        Date date = new Date(j);
        this.a.setTime(this.c);
        int i = this.a.get(2);
        int i2 = this.a.get(1);
        this.a.setTime(date);
        boolean z = false;
        if (this.a.get(1) != i2 ? this.a.get(1) > i2 : this.a.get(2) > i) {
            this.a.setTime(this.c);
        } else {
            this.a.setTime(this.b);
            int i3 = this.a.get(2);
            int i4 = this.a.get(1);
            this.a.setTime(date);
            if (this.a.get(1) != i4 ? this.a.get(1) < i4 : this.a.get(2) < i3) {
                z = true;
            }
            if (z) {
                this.a.setTime(this.b);
            } else {
                this.a.setTime(date);
            }
        }
        long timeInMillis = this.a.getTimeInMillis();
        this.a.setTimeInMillis(timeInMillis);
        WheelData<?> wheelData = this.e.get(this.a.get(2));
        Intrinsics.checkNotNullExpressionValue(wheelData, "monthNames[calendar.get(Calendar.MONTH)]");
        WheelData<?> wheelData2 = wheelData;
        Iterator<T> it = this.f.iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            if (Intrinsics.areEqual(t.getKey(), Integer.valueOf(this.a.get(1)))) {
                break;
            }
        }
        T t2 = t;
        if (this.d.getFirstWheelValue() == null || this.d.getSecondWheelValue() == null) {
            this.g = new b(this, t2, wheelData2);
        } else {
            this.d.setSecondWheelValue(t2);
            this.d.setFirstWheelValue(wheelData2);
        }
        return timeInMillis;
    }
}
