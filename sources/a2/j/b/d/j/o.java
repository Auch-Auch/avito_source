package a2.j.b.d.j;

import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.datepicker.DateSelector;
import com.google.android.material.datepicker.MaterialCalendarGridView;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
public class o extends BaseAdapter {
    public static final int f = t.i().getMaximum(4);
    public final n a;
    public final DateSelector<?> b;
    public Collection<Long> c;
    public b d;
    public final CalendarConstraints e;

    public o(n nVar, DateSelector<?> dateSelector, CalendarConstraints calendarConstraints) {
        this.a = nVar;
        this.b = dateSelector;
        this.e = calendarConstraints;
        this.c = dateSelector.getSelectedDays();
    }

    public int a(int i) {
        return b() + (i - 1);
    }

    public int b() {
        return this.a.e();
    }

    @Nullable
    /* renamed from: c */
    public Long getItem(int i) {
        if (i < this.a.e() || i > d()) {
            return null;
        }
        n nVar = this.a;
        return Long.valueOf(nVar.f((i - nVar.e()) + 1));
    }

    public int d() {
        return (this.a.e() + this.a.e) - 1;
    }

    public final void e(@Nullable TextView textView, long j) {
        a aVar;
        if (textView != null) {
            boolean z = false;
            if (this.e.getDateValidator().isValid(j)) {
                textView.setEnabled(true);
                Iterator<Long> it = this.b.getSelectedDays().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    if (t.a(j) == t.a(it.next().longValue())) {
                        z = true;
                        break;
                    }
                }
                if (z) {
                    aVar = this.d.b;
                } else if (t.h().getTimeInMillis() == j) {
                    aVar = this.d.c;
                } else {
                    aVar = this.d.a;
                }
            } else {
                textView.setEnabled(false);
                aVar = this.d.g;
            }
            aVar.b(textView);
        }
    }

    public final void f(MaterialCalendarGridView materialCalendarGridView, long j) {
        if (n.c(j).equals(this.a)) {
            Calendar d2 = t.d(this.a.a);
            d2.setTimeInMillis(j);
            e((TextView) materialCalendarGridView.getChildAt(materialCalendarGridView.getAdapter().a(d2.get(5)) - materialCalendarGridView.getFirstVisiblePosition()), j);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return b() + this.a.e;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return (long) (i / this.a.d);
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x00e3  */
    @Override // android.widget.Adapter
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View getView(int r7, @androidx.annotation.Nullable android.view.View r8, @androidx.annotation.NonNull android.view.ViewGroup r9) {
        /*
            r6 = this;
            android.content.Context r0 = r9.getContext()
            a2.j.b.d.j.b r1 = r6.d
            if (r1 != 0) goto L_0x000f
            a2.j.b.d.j.b r1 = new a2.j.b.d.j.b
            r1.<init>(r0)
            r6.d = r1
        L_0x000f:
            r0 = r8
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1 = 0
            if (r8 != 0) goto L_0x0026
            android.content.Context r8 = r9.getContext()
            android.view.LayoutInflater r8 = android.view.LayoutInflater.from(r8)
            int r0 = com.google.android.material.R.layout.mtrl_calendar_day
            android.view.View r8 = r8.inflate(r0, r9, r1)
            r0 = r8
            android.widget.TextView r0 = (android.widget.TextView) r0
        L_0x0026:
            int r8 = r6.b()
            int r8 = r7 - r8
            if (r8 < 0) goto L_0x00d4
            a2.j.b.d.j.n r9 = r6.a
            int r2 = r9.e
            if (r8 < r2) goto L_0x0036
            goto L_0x00d4
        L_0x0036:
            r2 = 1
            int r8 = r8 + r2
            r0.setTag(r9)
            android.content.res.Resources r9 = r0.getResources()
            android.content.res.Configuration r9 = r9.getConfiguration()
            java.util.Locale r9 = r9.locale
            java.lang.Object[] r3 = new java.lang.Object[r2]
            java.lang.Integer r4 = java.lang.Integer.valueOf(r8)
            r3[r1] = r4
            java.lang.String r4 = "%d"
            java.lang.String r9 = java.lang.String.format(r9, r4, r3)
            r0.setText(r9)
            a2.j.b.d.j.n r9 = r6.a
            long r8 = r9.f(r8)
            a2.j.b.d.j.n r3 = r6.a
            int r3 = r3.c
            a2.j.b.d.j.n r4 = a2.j.b.d.j.n.d()
            int r4 = r4.c
            r5 = 24
            if (r3 != r4) goto L_0x009c
            java.util.Locale r3 = java.util.Locale.getDefault()
            int r4 = android.os.Build.VERSION.SDK_INT
            if (r4 < r5) goto L_0x0082
            java.lang.String r4 = "MMMEd"
            android.icu.text.DateFormat r3 = a2.j.b.d.j.t.c(r4, r3)
            java.util.Date r4 = new java.util.Date
            r4.<init>(r8)
            java.lang.String r8 = r3.format(r4)
            goto L_0x0098
        L_0x0082:
            java.util.concurrent.atomic.AtomicReference<a2.j.b.d.j.s> r4 = a2.j.b.d.j.t.a
            java.text.DateFormat r3 = java.text.DateFormat.getDateInstance(r1, r3)
            java.util.TimeZone r4 = a2.j.b.d.j.t.g()
            r3.setTimeZone(r4)
            java.util.Date r4 = new java.util.Date
            r4.<init>(r8)
            java.lang.String r8 = r3.format(r4)
        L_0x0098:
            r0.setContentDescription(r8)
            goto L_0x00cd
        L_0x009c:
            java.util.Locale r3 = java.util.Locale.getDefault()
            int r4 = android.os.Build.VERSION.SDK_INT
            if (r4 < r5) goto L_0x00b4
            java.lang.String r4 = "yMMMEd"
            android.icu.text.DateFormat r3 = a2.j.b.d.j.t.c(r4, r3)
            java.util.Date r4 = new java.util.Date
            r4.<init>(r8)
            java.lang.String r8 = r3.format(r4)
            goto L_0x00ca
        L_0x00b4:
            java.util.concurrent.atomic.AtomicReference<a2.j.b.d.j.s> r4 = a2.j.b.d.j.t.a
            java.text.DateFormat r3 = java.text.DateFormat.getDateInstance(r1, r3)
            java.util.TimeZone r4 = a2.j.b.d.j.t.g()
            r3.setTimeZone(r4)
            java.util.Date r4 = new java.util.Date
            r4.<init>(r8)
            java.lang.String r8 = r3.format(r4)
        L_0x00ca:
            r0.setContentDescription(r8)
        L_0x00cd:
            r0.setVisibility(r1)
            r0.setEnabled(r2)
            goto L_0x00dc
        L_0x00d4:
            r8 = 8
            r0.setVisibility(r8)
            r0.setEnabled(r1)
        L_0x00dc:
            java.lang.Long r7 = r6.getItem(r7)
            if (r7 != 0) goto L_0x00e3
            goto L_0x00ea
        L_0x00e3:
            long r7 = r7.longValue()
            r6.e(r0, r7)
        L_0x00ea:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: a2.j.b.d.j.o.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }
}
