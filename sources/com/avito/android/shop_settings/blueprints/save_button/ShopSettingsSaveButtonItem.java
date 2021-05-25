package com.avito.android.shop_settings.blueprints.save_button;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.shop_settings.blueprints.ShopSettingsItem;
import com.jakewharton.rxrelay2.BehaviorRelay;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\r\b\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\u0006¢\u0006\u0004\b4\u00105J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\t\u0010\bJ8\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0004J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0013J \u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eR\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\u0004R\u0019\u0010\r\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b\r\u0010\bR\"\u0010\f\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b$\u0010#\u001a\u0004\b\f\u0010\b\"\u0004\b%\u0010&R\u001c\u0010\n\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b'\u0010 \u001a\u0004\b(\u0010\u0004R(\u00100\u001a\b\u0012\u0004\u0012\u00020\u00060)8\u0016@\u0016X\u0004¢\u0006\u0012\n\u0004\b*\u0010+\u0012\u0004\b.\u0010/\u001a\u0004\b,\u0010-R\"\u00101\u001a\u00020\u00068\u0016@\u0016XD¢\u0006\u0012\n\u0004\b1\u0010#\u0012\u0004\b3\u0010/\u001a\u0004\b2\u0010\b¨\u00066"}, d2 = {"Lcom/avito/android/shop_settings/blueprints/save_button/ShopSettingsSaveButtonItem;", "Lcom/avito/android/shop_settings/blueprints/ShopSettingsItem;", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()Z", "component4", "stringId", "title", "isLoading", "isEnabled", "copy", "(Ljava/lang/String;Ljava/lang/String;ZZ)Lcom/avito/android/shop_settings/blueprints/save_button/ShopSettingsSaveButtonItem;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "c", "Ljava/lang/String;", "getTitle", "e", "Z", "d", "setLoading", "(Z)V", AuthSource.BOOKING_ORDER, "getStringId", "Lcom/jakewharton/rxrelay2/BehaviorRelay;", AuthSource.SEND_ABUSE, "Lcom/jakewharton/rxrelay2/BehaviorRelay;", "getDidChange", "()Lcom/jakewharton/rxrelay2/BehaviorRelay;", "getDidChange$annotations", "()V", "didChange", "shouldScrollTo", "getShouldScrollTo", "getShouldScrollTo$annotations", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZZ)V", "service-subscription_release"}, k = 1, mv = {1, 4, 2})
public final class ShopSettingsSaveButtonItem implements ShopSettingsItem {
    public static final Parcelable.Creator<ShopSettingsSaveButtonItem> CREATOR = new Creator();
    @NotNull
    public final BehaviorRelay<Boolean> a;
    @NotNull
    public final String b;
    @NotNull
    public final String c;
    public boolean d;
    public final boolean e;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<ShopSettingsSaveButtonItem> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ShopSettingsSaveButtonItem createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            boolean z = true;
            boolean z2 = parcel.readInt() != 0;
            if (parcel.readInt() == 0) {
                z = false;
            }
            return new ShopSettingsSaveButtonItem(readString, readString2, z2, z);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ShopSettingsSaveButtonItem[] newArray(int i) {
            return new ShopSettingsSaveButtonItem[i];
        }
    }

    public ShopSettingsSaveButtonItem(@NotNull String str, @NotNull String str2, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(str2, "title");
        this.b = str;
        this.c = str2;
        this.d = z;
        this.e = z2;
        BehaviorRelay<Boolean> createDefault = BehaviorRelay.createDefault(Boolean.FALSE);
        Intrinsics.checkNotNullExpressionValue(createDefault, "BehaviorRelay.createDefault(false)");
        this.a = createDefault;
    }

    public static /* synthetic */ ShopSettingsSaveButtonItem copy$default(ShopSettingsSaveButtonItem shopSettingsSaveButtonItem, String str, String str2, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = shopSettingsSaveButtonItem.getStringId();
        }
        if ((i & 2) != 0) {
            str2 = shopSettingsSaveButtonItem.c;
        }
        if ((i & 4) != 0) {
            z = shopSettingsSaveButtonItem.d;
        }
        if ((i & 8) != 0) {
            z2 = shopSettingsSaveButtonItem.e;
        }
        return shopSettingsSaveButtonItem.copy(str, str2, z, z2);
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

    public final boolean component3() {
        return this.d;
    }

    public final boolean component4() {
        return this.e;
    }

    @NotNull
    public final ShopSettingsSaveButtonItem copy(@NotNull String str, @NotNull String str2, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(str2, "title");
        return new ShopSettingsSaveButtonItem(str, str2, z, z2);
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
        if (!(obj instanceof ShopSettingsSaveButtonItem)) {
            return false;
        }
        ShopSettingsSaveButtonItem shopSettingsSaveButtonItem = (ShopSettingsSaveButtonItem) obj;
        return Intrinsics.areEqual(getStringId(), shopSettingsSaveButtonItem.getStringId()) && Intrinsics.areEqual(this.c, shopSettingsSaveButtonItem.c) && this.d == shopSettingsSaveButtonItem.d && this.e == shopSettingsSaveButtonItem.e;
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
        if (str != null) {
            i = str.hashCode();
        }
        int i2 = (hashCode + i) * 31;
        boolean z = this.d;
        int i3 = 1;
        if (z) {
            z = true;
        }
        int i4 = z ? 1 : 0;
        int i5 = z ? 1 : 0;
        int i6 = z ? 1 : 0;
        int i7 = (i2 + i4) * 31;
        boolean z2 = this.e;
        if (!z2) {
            i3 = z2 ? 1 : 0;
        }
        return i7 + i3;
    }

    public final boolean isEnabled() {
        return this.e;
    }

    public final boolean isLoading() {
        return this.d;
    }

    public final void setLoading(boolean z) {
        this.d = z;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("ShopSettingsSaveButtonItem(stringId=");
        L.append(getStringId());
        L.append(", title=");
        L.append(this.c);
        L.append(", isLoading=");
        L.append(this.d);
        L.append(", isEnabled=");
        return a.B(L, this.e, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeInt(this.d ? 1 : 0);
        parcel.writeInt(this.e ? 1 : 0);
    }
}
