package ru.sravni.android.bankproduct.utils.filter.entity;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0017\b\b\u0018\u00002\u00020\u0001:\u0001/B7\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\b\u0012\u0006\u0010\u0011\u001a\u00020\b\u0012\u0006\u0010\u0012\u001a\u00020\u0005\u0012\u0006\u0010\u0013\u001a\u00020\u0005¢\u0006\u0004\b-\u0010.J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u000b\u0010\nJ\u0010\u0010\f\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\f\u0010\u0007J\u0010\u0010\r\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\r\u0010\u0007JL\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\b2\b\b\u0002\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0004J\u0010\u0010\u0017\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0007J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u0019\u0010\u000f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u0007R\u0019\u0010\u0012\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u001d\u001a\u0004\b \u0010\u0007R\u0019\u0010\u0013\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\u001d\u001a\u0004\b\"\u0010\u0007R\u0019\u0010\u0011\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010\nR\u0019\u0010\u0010\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010$\u001a\u0004\b'\u0010\nR\u0013\u0010)\u001a\u00020\u00058F@\u0006¢\u0006\u0006\u001a\u0004\b(\u0010\u0007R\u0019\u0010\u000e\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010\u0004¨\u00060"}, d2 = {"Lru/sravni/android/bankproduct/utils/filter/entity/FilterSliderInfo;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()I", "Lru/sravni/android/bankproduct/utils/filter/entity/FilterSliderInfo$SliderParam;", "component3", "()Lru/sravni/android/bankproduct/utils/filter/entity/FilterSliderInfo$SliderParam;", "component4", "component5", "component6", "code", "stepSize", "minSliderParam", "maxSliderParam", "sliderValue", "defaultValue", "copy", "(Ljava/lang/String;ILru/sravni/android/bankproduct/utils/filter/entity/FilterSliderInfo$SliderParam;Lru/sravni/android/bankproduct/utils/filter/entity/FilterSliderInfo$SliderParam;II)Lru/sravni/android/bankproduct/utils/filter/entity/FilterSliderInfo;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "I", "getStepSize", "e", "getSliderValue", "f", "getDefaultValue", "d", "Lru/sravni/android/bankproduct/utils/filter/entity/FilterSliderInfo$SliderParam;", "getMaxSliderParam", "c", "getMinSliderParam", "getProgressPoints", "progressPoints", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getCode", "<init>", "(Ljava/lang/String;ILru/sravni/android/bankproduct/utils/filter/entity/FilterSliderInfo$SliderParam;Lru/sravni/android/bankproduct/utils/filter/entity/FilterSliderInfo$SliderParam;II)V", "SliderParam", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class FilterSliderInfo {
    @NotNull
    public final String a;
    public final int b;
    @NotNull
    public final SliderParam c;
    @NotNull
    public final SliderParam d;
    public final int e;
    public final int f;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\r\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\r\u0010\u0007J\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0007¨\u0006\u001a"}, d2 = {"Lru/sravni/android/bankproduct/utils/filter/entity/FilterSliderInfo$SliderParam;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()I", "valueText", "value", "copy", "(Ljava/lang/String;I)Lru/sravni/android/bankproduct/utils/filter/entity/FilterSliderInfo$SliderParam;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getValueText", AuthSource.BOOKING_ORDER, "I", "getValue", "<init>", "(Ljava/lang/String;I)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
    public static final class SliderParam {
        @NotNull
        public final String a;
        public final int b;

        public SliderParam(@NotNull String str, int i) {
            Intrinsics.checkParameterIsNotNull(str, "valueText");
            this.a = str;
            this.b = i;
        }

        public static /* synthetic */ SliderParam copy$default(SliderParam sliderParam, String str, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = sliderParam.a;
            }
            if ((i2 & 2) != 0) {
                i = sliderParam.b;
            }
            return sliderParam.copy(str, i);
        }

        @NotNull
        public final String component1() {
            return this.a;
        }

        public final int component2() {
            return this.b;
        }

        @NotNull
        public final SliderParam copy(@NotNull String str, int i) {
            Intrinsics.checkParameterIsNotNull(str, "valueText");
            return new SliderParam(str, i);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SliderParam)) {
                return false;
            }
            SliderParam sliderParam = (SliderParam) obj;
            return Intrinsics.areEqual(this.a, sliderParam.a) && this.b == sliderParam.b;
        }

        public final int getValue() {
            return this.b;
        }

        @NotNull
        public final String getValueText() {
            return this.a;
        }

        public int hashCode() {
            String str = this.a;
            return ((str != null ? str.hashCode() : 0) * 31) + this.b;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("SliderParam(valueText=");
            L.append(this.a);
            L.append(", value=");
            return a.j(L, this.b, ")");
        }
    }

    public FilterSliderInfo(@NotNull String str, int i, @NotNull SliderParam sliderParam, @NotNull SliderParam sliderParam2, int i2, int i3) {
        Intrinsics.checkParameterIsNotNull(str, "code");
        Intrinsics.checkParameterIsNotNull(sliderParam, "minSliderParam");
        Intrinsics.checkParameterIsNotNull(sliderParam2, "maxSliderParam");
        this.a = str;
        this.b = i;
        this.c = sliderParam;
        this.d = sliderParam2;
        this.e = i2;
        this.f = i3;
    }

    public static /* synthetic */ FilterSliderInfo copy$default(FilterSliderInfo filterSliderInfo, String str, int i, SliderParam sliderParam, SliderParam sliderParam2, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = filterSliderInfo.a;
        }
        if ((i4 & 2) != 0) {
            i = filterSliderInfo.b;
        }
        if ((i4 & 4) != 0) {
            sliderParam = filterSliderInfo.c;
        }
        if ((i4 & 8) != 0) {
            sliderParam2 = filterSliderInfo.d;
        }
        if ((i4 & 16) != 0) {
            i2 = filterSliderInfo.e;
        }
        if ((i4 & 32) != 0) {
            i3 = filterSliderInfo.f;
        }
        return filterSliderInfo.copy(str, i, sliderParam, sliderParam2, i2, i3);
    }

    @NotNull
    public final String component1() {
        return this.a;
    }

    public final int component2() {
        return this.b;
    }

    @NotNull
    public final SliderParam component3() {
        return this.c;
    }

    @NotNull
    public final SliderParam component4() {
        return this.d;
    }

    public final int component5() {
        return this.e;
    }

    public final int component6() {
        return this.f;
    }

    @NotNull
    public final FilterSliderInfo copy(@NotNull String str, int i, @NotNull SliderParam sliderParam, @NotNull SliderParam sliderParam2, int i2, int i3) {
        Intrinsics.checkParameterIsNotNull(str, "code");
        Intrinsics.checkParameterIsNotNull(sliderParam, "minSliderParam");
        Intrinsics.checkParameterIsNotNull(sliderParam2, "maxSliderParam");
        return new FilterSliderInfo(str, i, sliderParam, sliderParam2, i2, i3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FilterSliderInfo)) {
            return false;
        }
        FilterSliderInfo filterSliderInfo = (FilterSliderInfo) obj;
        return Intrinsics.areEqual(this.a, filterSliderInfo.a) && this.b == filterSliderInfo.b && Intrinsics.areEqual(this.c, filterSliderInfo.c) && Intrinsics.areEqual(this.d, filterSliderInfo.d) && this.e == filterSliderInfo.e && this.f == filterSliderInfo.f;
    }

    @NotNull
    public final String getCode() {
        return this.a;
    }

    public final int getDefaultValue() {
        return this.f;
    }

    @NotNull
    public final SliderParam getMaxSliderParam() {
        return this.d;
    }

    @NotNull
    public final SliderParam getMinSliderParam() {
        return this.c;
    }

    public final int getProgressPoints() {
        return this.d.getValue() / this.b;
    }

    public final int getSliderValue() {
        return this.e;
    }

    public final int getStepSize() {
        return this.b;
    }

    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (((str != null ? str.hashCode() : 0) * 31) + this.b) * 31;
        SliderParam sliderParam = this.c;
        int hashCode2 = (hashCode + (sliderParam != null ? sliderParam.hashCode() : 0)) * 31;
        SliderParam sliderParam2 = this.d;
        if (sliderParam2 != null) {
            i = sliderParam2.hashCode();
        }
        return ((((hashCode2 + i) * 31) + this.e) * 31) + this.f;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("FilterSliderInfo(code=");
        L.append(this.a);
        L.append(", stepSize=");
        L.append(this.b);
        L.append(", minSliderParam=");
        L.append(this.c);
        L.append(", maxSliderParam=");
        L.append(this.d);
        L.append(", sliderValue=");
        L.append(this.e);
        L.append(", defaultValue=");
        return a.j(L, this.f, ")");
    }
}
