package a2.j.b.d.j;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.R;
import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.internal.TextWatcherAdapter;
import com.google.android.material.textfield.TextInputLayout;
import java.text.DateFormat;
import java.util.Date;
public abstract class c extends TextWatcherAdapter {
    @NonNull
    public final TextInputLayout a;
    public final DateFormat b;
    public final CalendarConstraints c;
    public final String d;
    public final Runnable e;
    public Runnable f;

    public class a implements Runnable {
        public final /* synthetic */ String a;

        public a(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            c cVar = c.this;
            TextInputLayout textInputLayout = cVar.a;
            DateFormat dateFormat = cVar.b;
            Context context = textInputLayout.getContext();
            textInputLayout.setError(a2.b.a.a.a.f(context.getString(R.string.mtrl_picker_invalid_format), "\n", String.format(context.getString(R.string.mtrl_picker_invalid_format_use), this.a), "\n", String.format(context.getString(R.string.mtrl_picker_invalid_format_example), dateFormat.format(new Date(t.h().getTimeInMillis())))));
            c.this.a();
        }
    }

    public c(String str, DateFormat dateFormat, @NonNull TextInputLayout textInputLayout, CalendarConstraints calendarConstraints) {
        this.b = dateFormat;
        this.a = textInputLayout;
        this.c = calendarConstraints;
        this.d = textInputLayout.getContext().getString(R.string.mtrl_picker_out_of_range);
        this.e = new a(str);
    }

    public abstract void a();

    public abstract void b(@Nullable Long l);

    /* JADX WARNING: Removed duplicated region for block: B:14:0x005c A[Catch:{ ParseException -> 0x0075 }] */
    @Override // com.google.android.material.internal.TextWatcherAdapter, android.text.TextWatcher
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onTextChanged(@androidx.annotation.NonNull java.lang.CharSequence r7, int r8, int r9, int r10) {
        /*
            r6 = this;
            com.google.android.material.textfield.TextInputLayout r8 = r6.a
            java.lang.Runnable r9 = r6.e
            r8.removeCallbacks(r9)
            com.google.android.material.textfield.TextInputLayout r8 = r6.a
            java.lang.Runnable r9 = r6.f
            r8.removeCallbacks(r9)
            com.google.android.material.textfield.TextInputLayout r8 = r6.a
            r9 = 0
            r8.setError(r9)
            r6.b(r9)
            boolean r8 = android.text.TextUtils.isEmpty(r7)
            if (r8 == 0) goto L_0x001e
            return
        L_0x001e:
            r0 = 1000(0x3e8, double:4.94E-321)
            java.text.DateFormat r8 = r6.b     // Catch:{ ParseException -> 0x0075 }
            java.lang.String r7 = r7.toString()     // Catch:{ ParseException -> 0x0075 }
            java.util.Date r7 = r8.parse(r7)     // Catch:{ ParseException -> 0x0075 }
            com.google.android.material.textfield.TextInputLayout r8 = r6.a     // Catch:{ ParseException -> 0x0075 }
            r8.setError(r9)     // Catch:{ ParseException -> 0x0075 }
            long r8 = r7.getTime()     // Catch:{ ParseException -> 0x0075 }
            com.google.android.material.datepicker.CalendarConstraints r10 = r6.c     // Catch:{ ParseException -> 0x0075 }
            com.google.android.material.datepicker.CalendarConstraints$DateValidator r10 = r10.getDateValidator()     // Catch:{ ParseException -> 0x0075 }
            boolean r10 = r10.isValid(r8)     // Catch:{ ParseException -> 0x0075 }
            if (r10 == 0) goto L_0x0068
            com.google.android.material.datepicker.CalendarConstraints r10 = r6.c     // Catch:{ ParseException -> 0x0075 }
            a2.j.b.d.j.n r2 = r10.a     // Catch:{ ParseException -> 0x0075 }
            r3 = 1
            long r4 = r2.f(r3)     // Catch:{ ParseException -> 0x0075 }
            int r2 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r2 > 0) goto L_0x0059
            a2.j.b.d.j.n r10 = r10.b     // Catch:{ ParseException -> 0x0075 }
            int r2 = r10.e     // Catch:{ ParseException -> 0x0075 }
            long r4 = r10.f(r2)     // Catch:{ ParseException -> 0x0075 }
            int r10 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r10 > 0) goto L_0x0059
            goto L_0x005a
        L_0x0059:
            r3 = 0
        L_0x005a:
            if (r3 == 0) goto L_0x0068
            long r7 = r7.getTime()     // Catch:{ ParseException -> 0x0075 }
            java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch:{ ParseException -> 0x0075 }
            r6.b(r7)     // Catch:{ ParseException -> 0x0075 }
            return
        L_0x0068:
            a2.j.b.d.j.d r7 = new a2.j.b.d.j.d     // Catch:{ ParseException -> 0x0075 }
            r7.<init>(r6, r8)     // Catch:{ ParseException -> 0x0075 }
            r6.f = r7     // Catch:{ ParseException -> 0x0075 }
            com.google.android.material.textfield.TextInputLayout r8 = r6.a     // Catch:{ ParseException -> 0x0075 }
            r8.postDelayed(r7, r0)     // Catch:{ ParseException -> 0x0075 }
            goto L_0x007c
        L_0x0075:
            com.google.android.material.textfield.TextInputLayout r7 = r6.a
            java.lang.Runnable r8 = r6.e
            r7.postDelayed(r8, r0)
        L_0x007c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a2.j.b.d.j.c.onTextChanged(java.lang.CharSequence, int, int, int):void");
    }
}
