package com.avito.android.shop_settings.blueprints.section_title;

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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b,\u0010-J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J$\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0013\u0010\rJ \u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019R\"\u0010\u001a\u001a\u00020\u00108\u0016@\u0016XD¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u0012\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001c\u0010\u001dR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010\u0004R(\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00100#8\u0016@\u0016X\u0004¢\u0006\u0012\n\u0004\b$\u0010%\u0012\u0004\b(\u0010\u001f\u001a\u0004\b&\u0010'R\u001c\u0010\u0006\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b*\u0010!\u001a\u0004\b+\u0010\u0004¨\u0006."}, d2 = {"Lcom/avito/android/shop_settings/blueprints/section_title/ShopSettingsSectionTitleItem;", "Lcom/avito/android/shop_settings/blueprints/ShopSettingsItem;", "", "component1", "()Ljava/lang/String;", "component2", "stringId", "title", "copy", "(Ljava/lang/String;Ljava/lang/String;)Lcom/avito/android/shop_settings/blueprints/section_title/ShopSettingsSectionTitleItem;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "shouldScrollTo", "Z", "getShouldScrollTo", "()Z", "getShouldScrollTo$annotations", "()V", "c", "Ljava/lang/String;", "getTitle", "Lcom/jakewharton/rxrelay2/BehaviorRelay;", AuthSource.SEND_ABUSE, "Lcom/jakewharton/rxrelay2/BehaviorRelay;", "getDidChange", "()Lcom/jakewharton/rxrelay2/BehaviorRelay;", "getDidChange$annotations", "didChange", AuthSource.BOOKING_ORDER, "getStringId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "service-subscription_release"}, k = 1, mv = {1, 4, 2})
public final class ShopSettingsSectionTitleItem implements ShopSettingsItem {
    public static final Parcelable.Creator<ShopSettingsSectionTitleItem> CREATOR = new Creator();
    @NotNull
    public final BehaviorRelay<Boolean> a;
    @NotNull
    public final String b;
    @NotNull
    public final String c;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<ShopSettingsSectionTitleItem> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ShopSettingsSectionTitleItem createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new ShopSettingsSectionTitleItem(parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ShopSettingsSectionTitleItem[] newArray(int i) {
            return new ShopSettingsSectionTitleItem[i];
        }
    }

    public ShopSettingsSectionTitleItem(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(str2, "title");
        this.b = str;
        this.c = str2;
        BehaviorRelay<Boolean> createDefault = BehaviorRelay.createDefault(Boolean.FALSE);
        Intrinsics.checkNotNullExpressionValue(createDefault, "BehaviorRelay.createDefault(false)");
        this.a = createDefault;
    }

    public static /* synthetic */ ShopSettingsSectionTitleItem copy$default(ShopSettingsSectionTitleItem shopSettingsSectionTitleItem, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = shopSettingsSectionTitleItem.getStringId();
        }
        if ((i & 2) != 0) {
            str2 = shopSettingsSectionTitleItem.c;
        }
        return shopSettingsSectionTitleItem.copy(str, str2);
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

    @NotNull
    public final ShopSettingsSectionTitleItem copy(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(str2, "title");
        return new ShopSettingsSectionTitleItem(str, str2);
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
        if (!(obj instanceof ShopSettingsSectionTitleItem)) {
            return false;
        }
        ShopSettingsSectionTitleItem shopSettingsSectionTitleItem = (ShopSettingsSectionTitleItem) obj;
        return Intrinsics.areEqual(getStringId(), shopSettingsSectionTitleItem.getStringId()) && Intrinsics.areEqual(this.c, shopSettingsSectionTitleItem.c);
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
        return hashCode + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("ShopSettingsSectionTitleItem(stringId=");
        L.append(getStringId());
        L.append(", title=");
        return a.t(L, this.c, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.b);
        parcel.writeString(this.c);
    }
}
