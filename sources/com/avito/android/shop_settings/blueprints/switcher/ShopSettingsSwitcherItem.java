package com.avito.android.shop_settings.blueprints.switcher;

import a2.b.a.a.a;
import a2.g.r.g;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.shop_settings.blueprints.ShopSettingsItem;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.jakewharton.rxrelay2.BehaviorRelay;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0013\b\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u0007¢\u0006\u0004\b;\u0010<B3\b\u0016\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u00104\u001a\u00020\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u0007¢\u0006\u0004\b;\u0010=J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJN\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u0007HÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0004J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u0015J \u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u001f\u0010 R\u001c\u0010\n\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010\u0004R\u0016\u0010\r\u001a\u00020\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010\"\u001a\u0004\b'\u0010\u0004R\u001b\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010\"\u001a\u0004\b)\u0010\u0004R\u0016\u0010\u000e\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010%R(\u00102\u001a\b\u0012\u0004\u0012\u00020\u00070+8\u0016@\u0016X\u0004¢\u0006\u0012\n\u0004\b,\u0010-\u0012\u0004\b0\u00101\u001a\u0004\b.\u0010/R$\u00104\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u00078F@FX\u000e¢\u0006\f\u001a\u0004\b4\u0010\t\"\u0004\b5\u00106R\u0019\u0010\u000f\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b7\u0010%\u001a\u0004\b\u000f\u0010\tR\"\u00108\u001a\u00020\u00078\u0016@\u0016XD¢\u0006\u0012\n\u0004\b8\u0010%\u0012\u0004\b:\u00101\u001a\u0004\b9\u0010\t¨\u0006>"}, d2 = {"Lcom/avito/android/shop_settings/blueprints/switcher/ShopSettingsSwitcherItem;", "Lcom/avito/android/shop_settings/blueprints/ShopSettingsItem;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "", "component6", "()Z", "stringId", "title", MessengerShareContentUtility.SUBTITLE, "currentIsEnabled", "originalIsEnabled", "isModifiable", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZ)Lcom/avito/android/shop_settings/blueprints/switcher/ShopSettingsSwitcherItem;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getStringId", "e", "Z", "c", "getTitle", "d", "getSubtitle", "f", "Lcom/jakewharton/rxrelay2/BehaviorRelay;", AuthSource.SEND_ABUSE, "Lcom/jakewharton/rxrelay2/BehaviorRelay;", "getDidChange", "()Lcom/jakewharton/rxrelay2/BehaviorRelay;", "getDidChange$annotations", "()V", "didChange", "value", "isEnabled", "setEnabled", "(Z)V", g.a, "shouldScrollTo", "getShouldScrollTo", "getShouldScrollTo$annotations", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZ)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZ)V", "service-subscription_release"}, k = 1, mv = {1, 4, 2})
public final class ShopSettingsSwitcherItem implements ShopSettingsItem {
    public static final Parcelable.Creator<ShopSettingsSwitcherItem> CREATOR = new Creator();
    @NotNull
    public final BehaviorRelay<Boolean> a;
    @NotNull
    public final String b;
    @NotNull
    public final String c;
    @Nullable
    public final String d;
    public boolean e;
    public final boolean f;
    public final boolean g;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<ShopSettingsSwitcherItem> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ShopSettingsSwitcherItem createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new ShopSettingsSwitcherItem(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt() != 0);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ShopSettingsSwitcherItem[] newArray(int i) {
            return new ShopSettingsSwitcherItem[i];
        }
    }

    public ShopSettingsSwitcherItem(@NotNull String str, @NotNull String str2, @Nullable String str3, boolean z, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(str2, "title");
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = z;
        this.f = z2;
        this.g = z3;
        BehaviorRelay<Boolean> createDefault = BehaviorRelay.createDefault(Boolean.valueOf(z != z2));
        Intrinsics.checkNotNullExpressionValue(createDefault, "BehaviorRelay.createDefa…led != originalIsEnabled)");
        this.a = createDefault;
    }

    public static /* synthetic */ ShopSettingsSwitcherItem copy$default(ShopSettingsSwitcherItem shopSettingsSwitcherItem, String str, String str2, String str3, boolean z, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = shopSettingsSwitcherItem.getStringId();
        }
        if ((i & 2) != 0) {
            str2 = shopSettingsSwitcherItem.c;
        }
        if ((i & 4) != 0) {
            str3 = shopSettingsSwitcherItem.d;
        }
        if ((i & 8) != 0) {
            z = shopSettingsSwitcherItem.e;
        }
        if ((i & 16) != 0) {
            z2 = shopSettingsSwitcherItem.f;
        }
        if ((i & 32) != 0) {
            z3 = shopSettingsSwitcherItem.g;
        }
        return shopSettingsSwitcherItem.copy(str, str2, str3, z, z2, z3);
    }

    public static /* synthetic */ void getDidChange$annotations() {
    }

    public static /* synthetic */ void getShouldScrollTo$annotations() {
    }

    @NotNull
    public final String component1() {
        return getStringId();
    }

    @NotNull
    public final String component2() {
        return this.c;
    }

    @Nullable
    public final String component3() {
        return this.d;
    }

    public final boolean component6() {
        return this.g;
    }

    @NotNull
    public final ShopSettingsSwitcherItem copy(@NotNull String str, @NotNull String str2, @Nullable String str3, boolean z, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(str2, "title");
        return new ShopSettingsSwitcherItem(str, str2, str3, z, z2, z3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShopSettingsSwitcherItem)) {
            return false;
        }
        ShopSettingsSwitcherItem shopSettingsSwitcherItem = (ShopSettingsSwitcherItem) obj;
        return Intrinsics.areEqual(getStringId(), shopSettingsSwitcherItem.getStringId()) && Intrinsics.areEqual(this.c, shopSettingsSwitcherItem.c) && Intrinsics.areEqual(this.d, shopSettingsSwitcherItem.d) && this.e == shopSettingsSwitcherItem.e && this.f == shopSettingsSwitcherItem.f && this.g == shopSettingsSwitcherItem.g;
    }

    @Override // com.avito.android.shop_settings.blueprints.ShopSettingsItem
    @NotNull
    public BehaviorRelay<Boolean> getDidChange() {
        return this.a;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return ShopSettingsItem.DefaultImpls.getId(this);
    }

    @Override // com.avito.android.shop_settings.blueprints.ShopSettingsItem
    public boolean getShouldScrollTo() {
        return false;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.b;
    }

    @Nullable
    public final String getSubtitle() {
        return this.d;
    }

    @NotNull
    public final String getTitle() {
        return this.c;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String stringId = getStringId();
        int i = 0;
        int hashCode = (stringId != null ? stringId.hashCode() : 0) * 31;
        String str = this.c;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.d;
        if (str2 != null) {
            i = str2.hashCode();
        }
        int i2 = (hashCode2 + i) * 31;
        boolean z = this.e;
        int i3 = 1;
        if (z) {
            z = true;
        }
        int i4 = z ? 1 : 0;
        int i5 = z ? 1 : 0;
        int i6 = z ? 1 : 0;
        int i7 = (i2 + i4) * 31;
        boolean z2 = this.f;
        if (z2) {
            z2 = true;
        }
        int i8 = z2 ? 1 : 0;
        int i9 = z2 ? 1 : 0;
        int i10 = z2 ? 1 : 0;
        int i11 = (i7 + i8) * 31;
        boolean z3 = this.g;
        if (!z3) {
            i3 = z3 ? 1 : 0;
        }
        return i11 + i3;
    }

    public final boolean isEnabled() {
        return this.e;
    }

    public final boolean isModifiable() {
        return this.g;
    }

    public final void setEnabled(boolean z) {
        this.e = z;
        getDidChange().accept(Boolean.valueOf(this.e != this.f));
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("ShopSettingsSwitcherItem(stringId=");
        L.append(getStringId());
        L.append(", title=");
        L.append(this.c);
        L.append(", subtitle=");
        L.append(this.d);
        L.append(", currentIsEnabled=");
        L.append(this.e);
        L.append(", originalIsEnabled=");
        L.append(this.f);
        L.append(", isModifiable=");
        return a.B(L, this.g, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeInt(this.e ? 1 : 0);
        parcel.writeInt(this.f ? 1 : 0);
        parcel.writeInt(this.g ? 1 : 0);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ShopSettingsSwitcherItem(@NotNull String str, @NotNull String str2, @Nullable String str3, boolean z, boolean z2) {
        this(str, str2, str3, z, z, z2);
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(str2, "title");
    }
}
