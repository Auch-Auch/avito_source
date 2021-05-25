package com.google.android.material.datepicker;

import a2.j.b.d.j.n;
import a2.j.b.d.j.t;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.ObjectsCompat;
import java.util.Arrays;
public final class CalendarConstraints implements Parcelable {
    public static final Parcelable.Creator<CalendarConstraints> CREATOR = new a();
    @NonNull
    public final n a;
    @NonNull
    public final n b;
    @NonNull
    public final DateValidator c;
    @Nullable
    public n d;
    public final int e;
    public final int f;

    public interface DateValidator extends Parcelable {
        boolean isValid(long j);
    }

    public static class a implements Parcelable.Creator<CalendarConstraints> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        @NonNull
        public CalendarConstraints createFromParcel(@NonNull Parcel parcel) {
            return new CalendarConstraints((n) parcel.readParcelable(n.class.getClassLoader()), (n) parcel.readParcelable(n.class.getClassLoader()), (DateValidator) parcel.readParcelable(DateValidator.class.getClassLoader()), (n) parcel.readParcelable(n.class.getClassLoader()), null);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        @NonNull
        public CalendarConstraints[] newArray(int i) {
            return new CalendarConstraints[i];
        }
    }

    public CalendarConstraints(n nVar, n nVar2, DateValidator dateValidator, n nVar3, a aVar) {
        this.a = nVar;
        this.b = nVar2;
        this.d = nVar3;
        this.c = dateValidator;
        if (nVar3 != null && nVar.a.compareTo(nVar3.a) > 0) {
            throw new IllegalArgumentException("start Month cannot be after current Month");
        } else if (nVar3 == null || nVar3.a.compareTo(nVar2.a) <= 0) {
            this.f = nVar.i(nVar2) + 1;
            this.e = (nVar2.c - nVar.c) + 1;
        } else {
            throw new IllegalArgumentException("current Month cannot be after end Month");
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CalendarConstraints)) {
            return false;
        }
        CalendarConstraints calendarConstraints = (CalendarConstraints) obj;
        if (!this.a.equals(calendarConstraints.a) || !this.b.equals(calendarConstraints.b) || !ObjectsCompat.equals(this.d, calendarConstraints.d) || !this.c.equals(calendarConstraints.c)) {
            return false;
        }
        return true;
    }

    public DateValidator getDateValidator() {
        return this.c;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.a, this.b, this.d, this.c});
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.a, 0);
        parcel.writeParcelable(this.b, 0);
        parcel.writeParcelable(this.d, 0);
        parcel.writeParcelable(this.c, 0);
    }

    public static final class Builder {
        public static final long e = t.a(n.b(1900, 0).f);
        public static final long f = t.a(n.b(2100, 11).f);
        public long a = e;
        public long b = f;
        public Long c;
        public DateValidator d = DateValidatorPointForward.from(Long.MIN_VALUE);

        public Builder() {
        }

        @NonNull
        public CalendarConstraints build() {
            n nVar;
            Bundle bundle = new Bundle();
            bundle.putParcelable("DEEP_COPY_VALIDATOR_KEY", this.d);
            n c2 = n.c(this.a);
            n c3 = n.c(this.b);
            DateValidator dateValidator = (DateValidator) bundle.getParcelable("DEEP_COPY_VALIDATOR_KEY");
            Long l = this.c;
            if (l == null) {
                nVar = null;
            } else {
                nVar = n.c(l.longValue());
            }
            return new CalendarConstraints(c2, c3, dateValidator, nVar, null);
        }

        @NonNull
        public Builder setEnd(long j) {
            this.b = j;
            return this;
        }

        @NonNull
        public Builder setOpenAt(long j) {
            this.c = Long.valueOf(j);
            return this;
        }

        @NonNull
        public Builder setStart(long j) {
            this.a = j;
            return this;
        }

        @NonNull
        public Builder setValidator(@NonNull DateValidator dateValidator) {
            this.d = dateValidator;
            return this;
        }

        public Builder(@NonNull CalendarConstraints calendarConstraints) {
            this.a = calendarConstraints.a.f;
            this.b = calendarConstraints.b.f;
            this.c = Long.valueOf(calendarConstraints.d.f);
            this.d = calendarConstraints.c;
        }
    }
}
