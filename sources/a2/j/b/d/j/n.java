package a2.j.b.d.j;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.format.DateUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;
public final class n implements Comparable<n>, Parcelable {
    public static final Parcelable.Creator<n> CREATOR = new a();
    @NonNull
    public final Calendar a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final long f;
    @Nullable
    public String g;

    public static class a implements Parcelable.Creator<n> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        @NonNull
        public n createFromParcel(@NonNull Parcel parcel) {
            return n.b(parcel.readInt(), parcel.readInt());
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        @NonNull
        public n[] newArray(int i) {
            return new n[i];
        }
    }

    public n(@NonNull Calendar calendar) {
        calendar.set(5, 1);
        Calendar d2 = t.d(calendar);
        this.a = d2;
        this.b = d2.get(2);
        this.c = d2.get(1);
        this.d = d2.getMaximum(7);
        this.e = d2.getActualMaximum(5);
        this.f = d2.getTimeInMillis();
    }

    @NonNull
    public static n b(int i, int i2) {
        Calendar i3 = t.i();
        i3.set(1, i);
        i3.set(2, i2);
        return new n(i3);
    }

    @NonNull
    public static n c(long j) {
        Calendar i = t.i();
        i.setTimeInMillis(j);
        return new n(i);
    }

    @NonNull
    public static n d() {
        return new n(t.h());
    }

    /* renamed from: a */
    public int compareTo(@NonNull n nVar) {
        return this.a.compareTo(nVar.a);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int e() {
        int firstDayOfWeek = this.a.get(7) - this.a.getFirstDayOfWeek();
        return firstDayOfWeek < 0 ? firstDayOfWeek + this.d : firstDayOfWeek;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        if (this.b == nVar.b && this.c == nVar.c) {
            return true;
        }
        return false;
    }

    public long f(int i) {
        Calendar d2 = t.d(this.a);
        d2.set(5, i);
        return d2.getTimeInMillis();
    }

    @NonNull
    public String g(Context context) {
        if (this.g == null) {
            long timeInMillis = this.a.getTimeInMillis();
            this.g = DateUtils.formatDateTime(context, timeInMillis - ((long) TimeZone.getDefault().getOffset(timeInMillis)), 36);
        }
        return this.g;
    }

    @NonNull
    public n h(int i) {
        Calendar d2 = t.d(this.a);
        d2.add(2, i);
        return new n(d2);
    }

    @Override // java.lang.Object
    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.b), Integer.valueOf(this.c)});
    }

    public int i(@NonNull n nVar) {
        if (this.a instanceof GregorianCalendar) {
            return (nVar.b - this.b) + ((nVar.c - this.c) * 12);
        }
        throw new IllegalArgumentException("Only Gregorian calendars are supported.");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeInt(this.c);
        parcel.writeInt(this.b);
    }
}
