package com.avito.android.lib.design.picker;

import a2.b.a.a.a;
import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.remote.auth.AuthSource;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\b\b\u0018\u0000 \u001c*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u001cB\u0017\u0012\u0006\u0010\b\u001a\u00028\u0000\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00028\u0000HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J*\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\b\u001a\u00028\u00002\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\f\u0010\u0007J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\b\u001a\u00028\u00008\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u0007¨\u0006\u001d"}, d2 = {"Lcom/avito/android/lib/design/picker/WheelData;", "T", "", "component1", "()Ljava/lang/Object;", "", "component2", "()Ljava/lang/String;", "key", "name", "copy", "(Ljava/lang/Object;Ljava/lang/String;)Lcom/avito/android/lib/design/picker/WheelData;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/Object;", "getKey", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getName", "<init>", "(Ljava/lang/Object;Ljava/lang/String;)V", "Companion", "components_release"}, k = 1, mv = {1, 4, 2})
public final class WheelData<T> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final ArrayList<WheelData<?>> c = CollectionsKt__CollectionsKt.arrayListOf(new WheelData(0, "Января"), new WheelData(1, "Февраля"), new WheelData(2, "Марта"), new WheelData(3, "Апреля"), new WheelData(4, "Мая"), new WheelData(5, "Июня"), new WheelData(6, "Июля"), new WheelData(7, "Августа"), new WheelData(8, "Сентября"), new WheelData(9, "Октября"), new WheelData(10, "Ноября"), new WheelData(11, "Декабря"));
    @NotNull
    public static final ArrayList<WheelData<?>> d = CollectionsKt__CollectionsKt.arrayListOf(new WheelData(0, "января"), new WheelData(1, "февраля"), new WheelData(2, "марта"), new WheelData(3, "апреля"), new WheelData(4, "мая"), new WheelData(5, "июня"), new WheelData(6, "июля"), new WheelData(7, "августа"), new WheelData(8, "сентября"), new WheelData(9, "октября"), new WheelData(10, "ноября"), new WheelData(11, "декабря"));
    @NotNull
    public static final ArrayList<WheelData<?>> e = CollectionsKt__CollectionsKt.arrayListOf(new WheelData(0, "январь"), new WheelData(1, "февраль"), new WheelData(2, "март"), new WheelData(3, "апрель"), new WheelData(4, "май"), new WheelData(5, "июнь"), new WheelData(6, "июль"), new WheelData(7, "август"), new WheelData(8, "сентябрь"), new WheelData(9, "октябрь"), new WheelData(10, "ноябрь"), new WheelData(11, "декабрь"));
    public final T a;
    @NotNull
    public final String b;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0015\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b \u0010!J9\u0010\b\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005j\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006`\u00072\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tJ7\u0010\u000e\u001a\u00020\r2\f\u0010\n\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00062\f\u0010\u000b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00062\f\u0010\f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0006¢\u0006\u0004\b\u000e\u0010\u000fJ)\u0010\u0012\u001a\u00020\r2\f\u0010\u0010\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00062\f\u0010\u0011\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0006¢\u0006\u0004\b\u0012\u0010\u0013R1\u0010\u0014\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005j\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006`\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R+\u0010\u0019\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005j\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006`\u00078F@\u0006¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0017R+\u0010\u001b\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005j\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006`\u00078F@\u0006¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0017R1\u0010\u001c\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005j\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006`\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u0015\u001a\u0004\b\u001d\u0010\u0017R1\u0010\u001e\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005j\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006`\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u0015\u001a\u0004\b\u001f\u0010\u0017¨\u0006\""}, d2 = {"Lcom/avito/android/lib/design/picker/WheelData$Companion;", "", "", "from", "until", "Ljava/util/ArrayList;", "Lcom/avito/android/lib/design/picker/WheelData;", "Lkotlin/collections/ArrayList;", "getYears", "(II)Ljava/util/ArrayList;", "day", "month", "year", "", "checkDateIsValid", "(Lcom/avito/android/lib/design/picker/WheelData;Lcom/avito/android/lib/design/picker/WheelData;Lcom/avito/android/lib/design/picker/WheelData;)Z", InternalConstsKt.FIRST_IMAGE, "second", "checkIntervalIsValid", "(Lcom/avito/android/lib/design/picker/WheelData;Lcom/avito/android/lib/design/picker/WheelData;)Z", "monthsLowerCase", "Ljava/util/ArrayList;", "getMonthsLowerCase", "()Ljava/util/ArrayList;", "getTimeInterval", "timeInterval", "getDates", "dates", "months", "getMonths", "monthNominative", "getMonthNominative", "<init>", "()V", "components_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public static /* synthetic */ ArrayList getYears$default(Companion companion, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = 1980;
            }
            if ((i3 & 2) != 0) {
                i2 = Calendar.getInstance().get(1);
            }
            return companion.getYears(i, i2);
        }

        public final boolean checkDateIsValid(@Nullable WheelData<?> wheelData, @Nullable WheelData<?> wheelData2, @Nullable WheelData<?> wheelData3) {
            if (wheelData == null || wheelData2 == null || wheelData3 == null) {
                return false;
            }
            Object key = wheelData3.getKey();
            Objects.requireNonNull(key, "null cannot be cast to non-null type kotlin.Int");
            int intValue = ((Integer) key).intValue();
            Object key2 = wheelData2.getKey();
            Objects.requireNonNull(key2, "null cannot be cast to non-null type kotlin.Int");
            int actualMaximum = new GregorianCalendar(intValue, ((Integer) key2).intValue(), 1).getActualMaximum(5);
            Object key3 = wheelData.getKey();
            Objects.requireNonNull(key3, "null cannot be cast to non-null type kotlin.Int");
            if (actualMaximum >= ((Integer) key3).intValue()) {
                return true;
            }
            return false;
        }

        public final boolean checkIntervalIsValid(@Nullable WheelData<?> wheelData, @Nullable WheelData<?> wheelData2) {
            if (wheelData == null || wheelData2 == null) {
                return false;
            }
            Object key = wheelData.getKey();
            Objects.requireNonNull(key, "null cannot be cast to non-null type kotlin.Int");
            int intValue = ((Integer) key).intValue();
            Object key2 = wheelData2.getKey();
            Objects.requireNonNull(key2, "null cannot be cast to non-null type kotlin.Int");
            return intValue < ((Integer) key2).intValue();
        }

        @NotNull
        public final ArrayList<WheelData<?>> getDates() {
            ArrayList<WheelData<?>> arrayList = new ArrayList<>();
            for (int i = 1; i <= 31; i++) {
                arrayList.add(new WheelData<>(Integer.valueOf(i), String.valueOf(i)));
            }
            return arrayList;
        }

        @NotNull
        public final ArrayList<WheelData<?>> getMonthNominative() {
            return WheelData.e;
        }

        @NotNull
        public final ArrayList<WheelData<?>> getMonths() {
            return WheelData.c;
        }

        @NotNull
        public final ArrayList<WheelData<?>> getMonthsLowerCase() {
            return WheelData.d;
        }

        @NotNull
        public final ArrayList<WheelData<?>> getTimeInterval() {
            ArrayList<WheelData<?>> arrayList = new ArrayList<>();
            int i = 0;
            for (int i2 = 0; i2 <= 23; i2++) {
                Integer valueOf = Integer.valueOf(i);
                int i3 = i + 1;
                arrayList.add(new WheelData<>(valueOf, i2 + ":00"));
                Integer valueOf2 = Integer.valueOf(i3);
                i = i3 + 1;
                arrayList.add(new WheelData<>(valueOf2, i2 + ":30"));
            }
            return arrayList;
        }

        @NotNull
        public final ArrayList<WheelData<?>> getYears(int i, int i2) {
            ArrayList<WheelData<?>> arrayList = new ArrayList<>();
            if (i <= i2) {
                while (true) {
                    arrayList.add(new WheelData<>(Integer.valueOf(i), String.valueOf(i)));
                    if (i == i2) {
                        break;
                    }
                    i++;
                }
            }
            return arrayList;
        }

        public Companion(j jVar) {
        }
    }

    public WheelData(T t, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        this.a = t;
        this.b = str;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.lib.design.picker.WheelData */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WheelData copy$default(WheelData wheelData, Object obj, String str, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = wheelData.a;
        }
        if ((i & 2) != 0) {
            str = wheelData.b;
        }
        return wheelData.copy(obj, str);
    }

    public final T component1() {
        return this.a;
    }

    @NotNull
    public final String component2() {
        return this.b;
    }

    @NotNull
    public final WheelData<T> copy(T t, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        return new WheelData<>(t, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WheelData)) {
            return false;
        }
        WheelData wheelData = (WheelData) obj;
        return Intrinsics.areEqual(this.a, wheelData.a) && Intrinsics.areEqual(this.b, wheelData.b);
    }

    public final T getKey() {
        return this.a;
    }

    @NotNull
    public final String getName() {
        return this.b;
    }

    public int hashCode() {
        T t = this.a;
        int i = 0;
        int hashCode = (t != null ? t.hashCode() : 0) * 31;
        String str = this.b;
        if (str != null) {
            i = str.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("WheelData(key=");
        L.append((Object) this.a);
        L.append(", name=");
        return a.t(L, this.b, ")");
    }
}
