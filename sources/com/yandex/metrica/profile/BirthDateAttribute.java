package com.yandex.metrica.profile;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import com.yandex.metrica.impl.ob.adf;
import com.yandex.metrica.impl.ob.adp;
import com.yandex.metrica.impl.ob.ua;
import com.yandex.metrica.impl.ob.uc;
import com.yandex.metrica.impl.ob.uf;
import com.yandex.metrica.impl.ob.ul;
import com.yandex.metrica.impl.ob.um;
import com.yandex.metrica.impl.ob.un;
import com.yandex.metrica.impl.ob.uo;
import com.yandex.metrica.impl.ob.ur;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
public class BirthDateAttribute {
    private static final String DAY_PATTERN = "dd";
    private static final String MONTH_PATTERN = "MM";
    private static final String YEAR_PATTERN = "yyyy";
    private final uf mCustomAttribute = new uf("appmetrica_birth_date", new adp(), new un());

    private Calendar withYear(int i) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(1, i);
        return gregorianCalendar;
    }

    private Calendar withYearAndMonth(int i, int i2) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(1, i);
        gregorianCalendar.set(2, i2 - 1);
        gregorianCalendar.set(5, 1);
        return gregorianCalendar;
    }

    private Calendar withYearMonthAndDay(int i, int i2, int i3) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(1, i);
        gregorianCalendar.set(2, i2 - 1);
        gregorianCalendar.set(5, i3);
        return gregorianCalendar;
    }

    @VisibleForTesting
    @SuppressLint({"SimpleDateFormat"})
    public UserProfileUpdate<? extends ur> createUpdatePatcher(@NonNull Calendar calendar, @NonNull String str, @NonNull ua uaVar) {
        return new UserProfileUpdate<>(new uo(this.mCustomAttribute.a(), new SimpleDateFormat(str).format(calendar.getTime()), new adf(), new adp(), uaVar));
    }

    public UserProfileUpdate<? extends ur> withAge(int i) {
        return createUpdatePatcher(withYear(Calendar.getInstance(Locale.US).get(1) - i), "yyyy", new uc(this.mCustomAttribute.b()));
    }

    public UserProfileUpdate<? extends ur> withAgeIfUndefined(int i) {
        return createUpdatePatcher(withYear(Calendar.getInstance(Locale.US).get(1) - i), "yyyy", new um(this.mCustomAttribute.b()));
    }

    public UserProfileUpdate<? extends ur> withBirthDate(int i) {
        return createUpdatePatcher(withYear(i), "yyyy", new uc(this.mCustomAttribute.b()));
    }

    public UserProfileUpdate<? extends ur> withBirthDateIfUndefined(int i) {
        return createUpdatePatcher(withYear(i), "yyyy", new um(this.mCustomAttribute.b()));
    }

    public UserProfileUpdate<? extends ur> withValueReset() {
        return new UserProfileUpdate<>(new ul(0, this.mCustomAttribute.a(), new adp(), new un()));
    }

    public UserProfileUpdate<? extends ur> withBirthDate(int i, int i2) {
        return createUpdatePatcher(withYearAndMonth(i, i2), "yyyy-MM", new uc(this.mCustomAttribute.b()));
    }

    public UserProfileUpdate<? extends ur> withBirthDateIfUndefined(int i, int i2) {
        return createUpdatePatcher(withYearAndMonth(i, i2), "yyyy-MM", new um(this.mCustomAttribute.b()));
    }

    public UserProfileUpdate<? extends ur> withBirthDate(int i, int i2, int i3) {
        return createUpdatePatcher(withYearMonthAndDay(i, i2, i3), "yyyy-MM-dd", new uc(this.mCustomAttribute.b()));
    }

    public UserProfileUpdate<? extends ur> withBirthDateIfUndefined(int i, int i2, int i3) {
        return createUpdatePatcher(withYearMonthAndDay(i, i2, i3), "yyyy-MM-dd", new um(this.mCustomAttribute.b()));
    }

    public UserProfileUpdate<? extends ur> withBirthDate(@NonNull Calendar calendar) {
        return createUpdatePatcher(calendar, "yyyy-MM-dd", new uc(this.mCustomAttribute.b()));
    }

    public UserProfileUpdate<? extends ur> withBirthDateIfUndefined(@NonNull Calendar calendar) {
        return createUpdatePatcher(calendar, "yyyy-MM-dd", new um(this.mCustomAttribute.b()));
    }
}
