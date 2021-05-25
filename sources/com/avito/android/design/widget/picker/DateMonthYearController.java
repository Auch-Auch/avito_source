package com.avito.android.design.widget.picker;

import a2.a.a.l0.a.a.a;
import a2.a.a.l0.a.a.b;
import a2.g.r.g;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.category_parameters.FormattedDateDisplayingType;
import com.avito.android.util.LocaleUtils;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u001e\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010#\u001a\u00020 \u0012\b\u00107\u001a\u0004\u0018\u00010 \u0012\u0006\u00105\u001a\u00020\u0016\u0012\b\u0010B\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010?\u001a\u00020\u0003\u0012\u0006\u0010<\u001a\u00020\u0003¢\u0006\u0004\bD\u0010EJ2\u0010\t\u001a\u00020\u00072#\u0010\b\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00070\u0002¢\u0006\u0004\b\t\u0010\nJ!\u0010\u000e\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J!\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00122\b\b\u0002\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J!\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00122\b\b\u0002\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u001a\u0010\u0019R\u0015\u0010\u001d\u001a\u0004\u0018\u00010\u00038F@\u0006¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR5\u0010\b\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R$\u0010\r\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\u000b8\u0006@BX\u000e¢\u0006\f\n\u0004\b\u0018\u0010%\u001a\u0004\b&\u0010'R\u001c\u0010+\u001a\b\u0012\u0004\u0012\u00020\u000b0(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010,R\u0016\u0010.\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010,R\u0016\u00100\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u0010,R\u001c\u00102\u001a\b\u0012\u0004\u0012\u00020\u000b0(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u0010*R\u0016\u00105\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0018\u00107\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b6\u0010\"R\u0019\u0010<\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;R\u0019\u0010?\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b=\u00109\u001a\u0004\b>\u0010;R\u0018\u0010B\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b@\u0010AR$\u0010\f\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\u000b8\u0006@BX\u000e¢\u0006\f\n\u0004\b\u0013\u0010%\u001a\u0004\bC\u0010'¨\u0006F"}, d2 = {"Lcom/avito/android/design/widget/picker/DateMonthYearController;", "", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "milliseconds", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setListener", "(Lkotlin/jvm/functions/Function1;)V", "", "month", "year", "setError", "(II)V", "clearError", "()V", "Ljava/util/Calendar;", AuthSource.SEND_ABUSE, "(J)Ljava/util/Calendar;", FormattedDateDisplayingType.TYPE_CALENDAR, "", "smoothScroll", AuthSource.BOOKING_ORDER, "(Ljava/util/Calendar;Z)V", "c", "getCurrentDate", "()Ljava/lang/Long;", "currentDate", "h", "Lkotlin/jvm/functions/Function1;", "Lcom/avito/android/design/widget/picker/PickerView;", "i", "Lcom/avito/android/design/widget/picker/PickerView;", "yearView", "<set-?>", "I", "getYear", "()I", "Ljava/util/ArrayList;", "f", "Ljava/util/ArrayList;", "monthsInts", "Ljava/util/Calendar;", "d", "calendarMax", "e", "calendarMin", g.a, "yearsInts", "k", "Z", "allowEmpty", "j", "monthView", "n", "J", "getMax", "()J", "max", AuthSource.OPEN_CHANNEL_LIST, "getMin", "min", "l", "Ljava/lang/Long;", "current", "getMonth", "<init>", "(Lcom/avito/android/design/widget/picker/PickerView;Lcom/avito/android/design/widget/picker/PickerView;ZLjava/lang/Long;JJ)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class DateMonthYearController {
    public int a = -1;
    public int b = -1;
    public final Calendar c;
    public final Calendar d;
    public final Calendar e;
    public final ArrayList<Integer> f;
    public final ArrayList<Integer> g;
    public Function1<? super Long, Unit> h;
    public final PickerView i;
    public final PickerView j;
    public final boolean k;
    public final Long l;
    public final long m;
    public final long n;

    public DateMonthYearController(@NotNull PickerView pickerView, @Nullable PickerView pickerView2, boolean z, @Nullable Long l2, long j2, long j3) {
        Intrinsics.checkNotNullParameter(pickerView, "yearView");
        this.i = pickerView;
        this.j = pickerView2;
        this.k = z;
        this.l = l2;
        this.m = j2;
        this.n = j3;
        this.c = a(l2 != null ? l2.longValue() : j2);
        this.d = a(j3);
        this.e = a(j2);
        this.f = new ArrayList<>();
        this.g = new ArrayList<>();
        ArrayList arrayList = new ArrayList();
        String[] months = LocaleUtils.INSTANCE.getDATE_FORMAT_SYMBOLS().getMonths();
        Intrinsics.checkNotNullExpressionValue(months, "months");
        int length = months.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            String str = months[i2];
            this.f.add(Integer.valueOf(i3));
            arrayList.add(str);
            i2++;
            i3++;
        }
        int i4 = this.e.get(1);
        ArrayList arrayList2 = new ArrayList();
        for (int i5 = this.d.get(1); i5 >= i4; i5--) {
            this.g.add(Integer.valueOf(i5));
            arrayList2.add(String.valueOf(i5));
        }
        Calendar calendar = this.c;
        if (this.k) {
            this.f.add(0, -1);
            arrayList.add(0, "—");
        }
        PickerView pickerView3 = this.j;
        if (pickerView3 != null) {
            pickerView3.setValues(arrayList, this.k);
            if (this.l != null || !this.k) {
                b(calendar, false);
            } else {
                pickerView3.scrollToValue(0, false);
            }
            pickerView3.setListener(new a(this));
        }
        Calendar calendar2 = this.c;
        if (this.k) {
            this.g.add(0, -1);
            arrayList2.add(0, "—");
        }
        this.i.setValues(arrayList2, this.k);
        if (this.l != null || !this.k) {
            c(calendar2, false);
        } else {
            this.i.scrollToValue(0, false);
        }
        this.i.setListener(new b(this));
    }

    public static final void access$update(DateMonthYearController dateMonthYearController) {
        if (dateMonthYearController.getCurrentDate() == null) {
            Function1<? super Long, Unit> function1 = dateMonthYearController.h;
            if (function1 != null) {
                function1.invoke(null);
                return;
            }
            return;
        }
        dateMonthYearController.c.set(2, dateMonthYearController.a);
        dateMonthYearController.c.set(1, dateMonthYearController.b);
        Long currentDate = dateMonthYearController.getCurrentDate();
        if (currentDate != null) {
            long longValue = currentDate.longValue();
            if (longValue > dateMonthYearController.d.getTimeInMillis()) {
                dateMonthYearController.b(dateMonthYearController.d, true);
                dateMonthYearController.c(dateMonthYearController.d, true);
                Function1<? super Long, Unit> function12 = dateMonthYearController.h;
                if (function12 != null) {
                    function12.invoke(Long.valueOf(dateMonthYearController.d.getTimeInMillis()));
                }
            } else if (longValue < dateMonthYearController.e.getTimeInMillis()) {
                dateMonthYearController.b(dateMonthYearController.e, true);
                dateMonthYearController.c(dateMonthYearController.e, true);
                Function1<? super Long, Unit> function13 = dateMonthYearController.h;
                if (function13 != null) {
                    function13.invoke(Long.valueOf(dateMonthYearController.e.getTimeInMillis()));
                }
            } else {
                Function1<? super Long, Unit> function14 = dateMonthYearController.h;
                if (function14 != null) {
                    function14.invoke(Long.valueOf(longValue));
                }
            }
        }
    }

    public static /* synthetic */ void setError$default(DateMonthYearController dateMonthYearController, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = dateMonthYearController.a;
        }
        if ((i4 & 2) != 0) {
            i3 = dateMonthYearController.b;
        }
        dateMonthYearController.setError(i2, i3);
    }

    public final Calendar a(long j2) {
        Calendar instance = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        Intrinsics.checkNotNullExpressionValue(instance, FormattedDateDisplayingType.TYPE_CALENDAR);
        instance.setTimeInMillis(j2);
        return instance;
    }

    public final void b(Calendar calendar, boolean z) {
        int i2;
        PickerView pickerView = this.j;
        if (pickerView != null && this.a != (i2 = calendar.get(2))) {
            this.a = i2;
            pickerView.scrollToValue(this.f.indexOf(Integer.valueOf(i2)), z);
        }
    }

    public final void c(Calendar calendar, boolean z) {
        int i2 = calendar.get(1);
        if (this.b != i2) {
            this.b = i2;
            this.i.scrollToValue(this.g.indexOf(Integer.valueOf(i2)), z);
        }
    }

    public final void clearError() {
        this.i.setHighlightedPosition(null);
        PickerView pickerView = this.j;
        if (pickerView != null) {
            pickerView.setHighlightedPosition(null);
        }
    }

    @Nullable
    public final Long getCurrentDate() {
        if ((this.j == null || this.a != -1) && this.b != -1) {
            return Long.valueOf(this.c.getTimeInMillis());
        }
        return null;
    }

    public final long getMax() {
        return this.n;
    }

    public final long getMin() {
        return this.m;
    }

    public final int getMonth() {
        return this.a;
    }

    public final int getYear() {
        return this.b;
    }

    public final void setError(int i2, int i3) {
        int indexOf = this.g.indexOf(Integer.valueOf(i3));
        int indexOf2 = this.f.indexOf(Integer.valueOf(i2));
        this.i.setHighlightedPosition(Integer.valueOf(indexOf));
        PickerView pickerView = this.j;
        if (pickerView != null) {
            pickerView.setHighlightedPosition(Integer.valueOf(indexOf2));
        }
    }

    public final void setListener(@NotNull Function1<? super Long, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.h = function1;
    }
}
