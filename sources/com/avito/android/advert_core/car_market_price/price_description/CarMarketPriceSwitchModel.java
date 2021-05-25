package com.avito.android.advert_core.car_market_price.price_description;

import a2.b.a.a.a;
import a2.g.r.g;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.SwitchType;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b*\b\b\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\b\u0012\u0006\u0010\u0016\u001a\u00020\u000b\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u000b¢\u0006\u0004\b6\u00107J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0004J\u0010\u0010\u0012\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\u0012\u0010\rJd\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0013\u001a\u00020\u00022\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\b2\b\b\u0002\u0010\u0016\u001a\u00020\u000b2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0019\u001a\u00020\u000bHÆ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001c\u0010\u0004J\u0010\u0010\u001d\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u001a\u0010 \u001a\u00020\u000b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b \u0010!R!\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010\nR\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010\u0007R\u001b\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010\u0004R\u0019\u0010\u0016\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010\rR\"\u0010\u0019\u001a\u00020\u000b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b.\u0010,\u001a\u0004\b\u0019\u0010\r\"\u0004\b/\u00100R\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u0010\u0010R\u0019\u0010\u0013\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b4\u0010)\u001a\u0004\b5\u0010\u0004¨\u00068"}, d2 = {"Lcom/avito/android/advert_core/car_market_price/price_description/CarMarketPriceSwitchModel;", "", "", "component1", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/SwitchType;", "component2", "()Lcom/avito/android/remote/model/SwitchType;", "", "component3", "()Ljava/util/List;", "", "component4", "()Z", "", "component5", "()Ljava/lang/Integer;", "component6", "component7", "title", "type", "features", "shouldShowStub", "stubIcon", "stubMessage", "isActivated", "copy", "(Ljava/lang/String;Lcom/avito/android/remote/model/SwitchType;Ljava/util/List;ZLjava/lang/Integer;Ljava/lang/String;Z)Lcom/avito/android/advert_core/car_market_price/price_description/CarMarketPriceSwitchModel;", "toString", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "c", "Ljava/util/List;", "getFeatures", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/model/SwitchType;", "getType", "f", "Ljava/lang/String;", "getStubMessage", "d", "Z", "getShouldShowStub", g.a, "setActivated", "(Z)V", "e", "Ljava/lang/Integer;", "getStubIcon", AuthSource.SEND_ABUSE, "getTitle", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/SwitchType;Ljava/util/List;ZLjava/lang/Integer;Ljava/lang/String;Z)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public final class CarMarketPriceSwitchModel {
    @NotNull
    public final String a;
    @Nullable
    public final SwitchType b;
    @Nullable
    public final List<String> c;
    public final boolean d;
    @Nullable
    public final Integer e;
    @Nullable
    public final String f;
    public boolean g;

    public CarMarketPriceSwitchModel(@NotNull String str, @Nullable SwitchType switchType, @Nullable List<String> list, boolean z, @Nullable Integer num, @Nullable String str2, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.a = str;
        this.b = switchType;
        this.c = list;
        this.d = z;
        this.e = num;
        this.f = str2;
        this.g = z2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.avito.android.advert_core.car_market_price.price_description.CarMarketPriceSwitchModel */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CarMarketPriceSwitchModel copy$default(CarMarketPriceSwitchModel carMarketPriceSwitchModel, String str, SwitchType switchType, List list, boolean z, Integer num, String str2, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = carMarketPriceSwitchModel.a;
        }
        if ((i & 2) != 0) {
            switchType = carMarketPriceSwitchModel.b;
        }
        if ((i & 4) != 0) {
            list = carMarketPriceSwitchModel.c;
        }
        if ((i & 8) != 0) {
            z = carMarketPriceSwitchModel.d;
        }
        if ((i & 16) != 0) {
            num = carMarketPriceSwitchModel.e;
        }
        if ((i & 32) != 0) {
            str2 = carMarketPriceSwitchModel.f;
        }
        if ((i & 64) != 0) {
            z2 = carMarketPriceSwitchModel.g;
        }
        return carMarketPriceSwitchModel.copy(str, switchType, list, z, num, str2, z2);
    }

    @NotNull
    public final String component1() {
        return this.a;
    }

    @Nullable
    public final SwitchType component2() {
        return this.b;
    }

    @Nullable
    public final List<String> component3() {
        return this.c;
    }

    public final boolean component4() {
        return this.d;
    }

    @Nullable
    public final Integer component5() {
        return this.e;
    }

    @Nullable
    public final String component6() {
        return this.f;
    }

    public final boolean component7() {
        return this.g;
    }

    @NotNull
    public final CarMarketPriceSwitchModel copy(@NotNull String str, @Nullable SwitchType switchType, @Nullable List<String> list, boolean z, @Nullable Integer num, @Nullable String str2, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "title");
        return new CarMarketPriceSwitchModel(str, switchType, list, z, num, str2, z2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CarMarketPriceSwitchModel)) {
            return false;
        }
        CarMarketPriceSwitchModel carMarketPriceSwitchModel = (CarMarketPriceSwitchModel) obj;
        return Intrinsics.areEqual(this.a, carMarketPriceSwitchModel.a) && Intrinsics.areEqual(this.b, carMarketPriceSwitchModel.b) && Intrinsics.areEqual(this.c, carMarketPriceSwitchModel.c) && this.d == carMarketPriceSwitchModel.d && Intrinsics.areEqual(this.e, carMarketPriceSwitchModel.e) && Intrinsics.areEqual(this.f, carMarketPriceSwitchModel.f) && this.g == carMarketPriceSwitchModel.g;
    }

    @Nullable
    public final List<String> getFeatures() {
        return this.c;
    }

    public final boolean getShouldShowStub() {
        return this.d;
    }

    @Nullable
    public final Integer getStubIcon() {
        return this.e;
    }

    @Nullable
    public final String getStubMessage() {
        return this.f;
    }

    @NotNull
    public final String getTitle() {
        return this.a;
    }

    @Nullable
    public final SwitchType getType() {
        return this.b;
    }

    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        SwitchType switchType = this.b;
        int hashCode2 = (hashCode + (switchType != null ? switchType.hashCode() : 0)) * 31;
        List<String> list = this.c;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 0)) * 31;
        boolean z = this.d;
        int i2 = 1;
        if (z) {
            z = true;
        }
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = z ? 1 : 0;
        int i6 = (hashCode3 + i3) * 31;
        Integer num = this.e;
        int hashCode4 = (i6 + (num != null ? num.hashCode() : 0)) * 31;
        String str2 = this.f;
        if (str2 != null) {
            i = str2.hashCode();
        }
        int i7 = (hashCode4 + i) * 31;
        boolean z2 = this.g;
        if (!z2) {
            i2 = z2 ? 1 : 0;
        }
        return i7 + i2;
    }

    public final boolean isActivated() {
        return this.g;
    }

    public final void setActivated(boolean z) {
        this.g = z;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("CarMarketPriceSwitchModel(title=");
        L.append(this.a);
        L.append(", type=");
        L.append(this.b);
        L.append(", features=");
        L.append(this.c);
        L.append(", shouldShowStub=");
        L.append(this.d);
        L.append(", stubIcon=");
        L.append(this.e);
        L.append(", stubMessage=");
        L.append(this.f);
        L.append(", isActivated=");
        return a.B(L, this.g, ")");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CarMarketPriceSwitchModel(String str, SwitchType switchType, List list, boolean z, Integer num, String str2, boolean z2, int i, j jVar) {
        this(str, switchType, (i & 4) != 0 ? null : list, z, num, (i & 32) != 0 ? null : str2, z2);
    }
}
