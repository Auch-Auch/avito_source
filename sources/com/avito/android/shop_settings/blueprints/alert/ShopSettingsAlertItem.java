package com.avito.android.shop_settings.blueprints.alert;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.shop_settings.blueprints.ShopSettingsItem;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.jakewharton.rxrelay2.BehaviorRelay;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\b\b\u0018\u00002\u00020\u0001:\u00019B)\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\r\u001a\u00020\u0007¢\u0006\u0004\b7\u00108J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ:\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\r\u001a\u00020\u0007HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0004J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u0013J \u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fR(\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00160 8\u0016@\u0016X\u0004¢\u0006\u0012\n\u0004\b!\u0010\"\u0012\u0004\b%\u0010&\u001a\u0004\b#\u0010$R\u0019\u0010\r\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010\tR\u001b\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010\u0004R\u001c\u0010\n\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b.\u0010,\u001a\u0004\b/\u0010\u0004R\"\u00100\u001a\u00020\u00168\u0016@\u0016XD¢\u0006\u0012\n\u0004\b0\u00101\u0012\u0004\b4\u0010&\u001a\u0004\b2\u00103R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b5\u0010,\u001a\u0004\b6\u0010\u0004¨\u0006:"}, d2 = {"Lcom/avito/android/shop_settings/blueprints/alert/ShopSettingsAlertItem;", "Lcom/avito/android/shop_settings/blueprints/ShopSettingsItem;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "Lcom/avito/android/shop_settings/blueprints/alert/ShopSettingsAlertItem$Style;", "component4", "()Lcom/avito/android/shop_settings/blueprints/alert/ShopSettingsAlertItem$Style;", "stringId", "title", MessengerShareContentUtility.SUBTITLE, AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/shop_settings/blueprints/alert/ShopSettingsAlertItem$Style;)Lcom/avito/android/shop_settings/blueprints/alert/ShopSettingsAlertItem;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/jakewharton/rxrelay2/BehaviorRelay;", AuthSource.SEND_ABUSE, "Lcom/jakewharton/rxrelay2/BehaviorRelay;", "getDidChange", "()Lcom/jakewharton/rxrelay2/BehaviorRelay;", "getDidChange$annotations", "()V", "didChange", "e", "Lcom/avito/android/shop_settings/blueprints/alert/ShopSettingsAlertItem$Style;", "getStyle", "d", "Ljava/lang/String;", "getSubtitle", AuthSource.BOOKING_ORDER, "getStringId", "shouldScrollTo", "Z", "getShouldScrollTo", "()Z", "getShouldScrollTo$annotations", "c", "getTitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/shop_settings/blueprints/alert/ShopSettingsAlertItem$Style;)V", "Style", "service-subscription_release"}, k = 1, mv = {1, 4, 2})
public final class ShopSettingsAlertItem implements ShopSettingsItem {
    public static final Parcelable.Creator<ShopSettingsAlertItem> CREATOR = new Creator();
    @NotNull
    public final BehaviorRelay<Boolean> a;
    @NotNull
    public final String b;
    @NotNull
    public final String c;
    @Nullable
    public final String d;
    @NotNull
    public final Style e;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<ShopSettingsAlertItem> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ShopSettingsAlertItem createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new ShopSettingsAlertItem(parcel.readString(), parcel.readString(), parcel.readString(), (Style) Enum.valueOf(Style.class, parcel.readString()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ShopSettingsAlertItem[] newArray(int i) {
            return new ShopSettingsAlertItem[i];
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0004\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/avito/android/shop_settings/blueprints/alert/ShopSettingsAlertItem$Style;", "", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "<init>", "(Ljava/lang/String;I)V", "Alert", "Message", "Confirmation", "service-subscription_release"}, k = 1, mv = {1, 4, 2})
    public enum Style implements Parcelable {
        Alert,
        Message,
        Confirmation;
        
        public static final Parcelable.Creator<Style> CREATOR = new Creator();

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Style> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Style createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return (Style) Enum.valueOf(Style.class, parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Style[] newArray(int i) {
                return new Style[i];
            }
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(name());
        }
    }

    public ShopSettingsAlertItem(@NotNull String str, @NotNull String str2, @Nullable String str3, @NotNull Style style) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(style, AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE);
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = style;
        BehaviorRelay<Boolean> createDefault = BehaviorRelay.createDefault(Boolean.FALSE);
        Intrinsics.checkNotNullExpressionValue(createDefault, "BehaviorRelay.createDefault(false)");
        this.a = createDefault;
    }

    public static /* synthetic */ ShopSettingsAlertItem copy$default(ShopSettingsAlertItem shopSettingsAlertItem, String str, String str2, String str3, Style style, int i, Object obj) {
        if ((i & 1) != 0) {
            str = shopSettingsAlertItem.getStringId();
        }
        if ((i & 2) != 0) {
            str2 = shopSettingsAlertItem.c;
        }
        if ((i & 4) != 0) {
            str3 = shopSettingsAlertItem.d;
        }
        if ((i & 8) != 0) {
            style = shopSettingsAlertItem.e;
        }
        return shopSettingsAlertItem.copy(str, str2, str3, style);
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

    @NotNull
    public final Style component4() {
        return this.e;
    }

    @NotNull
    public final ShopSettingsAlertItem copy(@NotNull String str, @NotNull String str2, @Nullable String str3, @NotNull Style style) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(style, AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE);
        return new ShopSettingsAlertItem(str, str2, str3, style);
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
        if (!(obj instanceof ShopSettingsAlertItem)) {
            return false;
        }
        ShopSettingsAlertItem shopSettingsAlertItem = (ShopSettingsAlertItem) obj;
        return Intrinsics.areEqual(getStringId(), shopSettingsAlertItem.getStringId()) && Intrinsics.areEqual(this.c, shopSettingsAlertItem.c) && Intrinsics.areEqual(this.d, shopSettingsAlertItem.d) && Intrinsics.areEqual(this.e, shopSettingsAlertItem.e);
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
    public final Style getStyle() {
        return this.e;
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
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        Style style = this.e;
        if (style != null) {
            i = style.hashCode();
        }
        return hashCode3 + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("ShopSettingsAlertItem(stringId=");
        L.append(getStringId());
        L.append(", title=");
        L.append(this.c);
        L.append(", subtitle=");
        L.append(this.d);
        L.append(", style=");
        L.append(this.e);
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeString(this.e.name());
    }
}
