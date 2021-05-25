package com.avito.android.shop_settings.blueprints.moderation_error;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.shop_settings.blueprints.ShopSettingsItem;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.jakewharton.rxrelay2.BehaviorRelay;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b3\u00104J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ.\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0011J \u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dR(\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00140\u001e8\u0016@\u0016X\u0004¢\u0006\u0012\n\u0004\b\u001f\u0010 \u0012\u0004\b#\u0010$\u001a\u0004\b!\u0010\"R\u001c\u0010\t\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010\u0004R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010'\u001a\u0004\b*\u0010\u0004R\u0019\u0010\u000b\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010\bR\"\u0010.\u001a\u00020\u00148\u0016@\u0016XD¢\u0006\u0012\n\u0004\b.\u0010/\u0012\u0004\b2\u0010$\u001a\u0004\b0\u00101¨\u00065"}, d2 = {"Lcom/avito/android/shop_settings/blueprints/moderation_error/ShopSettingsModerationErrorItem;", "Lcom/avito/android/shop_settings/blueprints/ShopSettingsItem;", "", "component1", "()Ljava/lang/String;", "component2", "Lcom/avito/android/remote/model/text/AttributedText;", "component3", "()Lcom/avito/android/remote/model/text/AttributedText;", "stringId", "title", MessengerShareContentUtility.SUBTITLE, "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/text/AttributedText;)Lcom/avito/android/shop_settings/blueprints/moderation_error/ShopSettingsModerationErrorItem;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/jakewharton/rxrelay2/BehaviorRelay;", AuthSource.SEND_ABUSE, "Lcom/jakewharton/rxrelay2/BehaviorRelay;", "getDidChange", "()Lcom/jakewharton/rxrelay2/BehaviorRelay;", "getDidChange$annotations", "()V", "didChange", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getStringId", "c", "getTitle", "d", "Lcom/avito/android/remote/model/text/AttributedText;", "getSubtitle", "shouldScrollTo", "Z", "getShouldScrollTo", "()Z", "getShouldScrollTo$annotations", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/text/AttributedText;)V", "service-subscription_release"}, k = 1, mv = {1, 4, 2})
public final class ShopSettingsModerationErrorItem implements ShopSettingsItem {
    public static final Parcelable.Creator<ShopSettingsModerationErrorItem> CREATOR = new Creator();
    @NotNull
    public final BehaviorRelay<Boolean> a;
    @NotNull
    public final String b;
    @NotNull
    public final String c;
    @NotNull
    public final AttributedText d;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<ShopSettingsModerationErrorItem> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ShopSettingsModerationErrorItem createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new ShopSettingsModerationErrorItem(parcel.readString(), parcel.readString(), (AttributedText) parcel.readParcelable(ShopSettingsModerationErrorItem.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ShopSettingsModerationErrorItem[] newArray(int i) {
            return new ShopSettingsModerationErrorItem[i];
        }
    }

    public ShopSettingsModerationErrorItem(@NotNull String str, @NotNull String str2, @NotNull AttributedText attributedText) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(attributedText, MessengerShareContentUtility.SUBTITLE);
        this.b = str;
        this.c = str2;
        this.d = attributedText;
        BehaviorRelay<Boolean> createDefault = BehaviorRelay.createDefault(Boolean.FALSE);
        Intrinsics.checkNotNullExpressionValue(createDefault, "BehaviorRelay.createDefault(false)");
        this.a = createDefault;
    }

    public static /* synthetic */ ShopSettingsModerationErrorItem copy$default(ShopSettingsModerationErrorItem shopSettingsModerationErrorItem, String str, String str2, AttributedText attributedText, int i, Object obj) {
        if ((i & 1) != 0) {
            str = shopSettingsModerationErrorItem.getStringId();
        }
        if ((i & 2) != 0) {
            str2 = shopSettingsModerationErrorItem.c;
        }
        if ((i & 4) != 0) {
            attributedText = shopSettingsModerationErrorItem.d;
        }
        return shopSettingsModerationErrorItem.copy(str, str2, attributedText);
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
    public final AttributedText component3() {
        return this.d;
    }

    @NotNull
    public final ShopSettingsModerationErrorItem copy(@NotNull String str, @NotNull String str2, @NotNull AttributedText attributedText) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(attributedText, MessengerShareContentUtility.SUBTITLE);
        return new ShopSettingsModerationErrorItem(str, str2, attributedText);
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
        if (!(obj instanceof ShopSettingsModerationErrorItem)) {
            return false;
        }
        ShopSettingsModerationErrorItem shopSettingsModerationErrorItem = (ShopSettingsModerationErrorItem) obj;
        return Intrinsics.areEqual(getStringId(), shopSettingsModerationErrorItem.getStringId()) && Intrinsics.areEqual(this.c, shopSettingsModerationErrorItem.c) && Intrinsics.areEqual(this.d, shopSettingsModerationErrorItem.d);
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
    public final AttributedText getSubtitle() {
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
        AttributedText attributedText = this.d;
        if (attributedText != null) {
            i = attributedText.hashCode();
        }
        return hashCode2 + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("ShopSettingsModerationErrorItem(stringId=");
        L.append(getStringId());
        L.append(", title=");
        L.append(this.c);
        L.append(", subtitle=");
        L.append(this.d);
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeParcelable(this.d, i);
    }
}
