package com.avito.android.serp.adapter.location_notification;

import a2.b.a.a.a;
import a2.g.r.g;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.serp.adapter.PersistableSerpItem;
import com.avito.android.serp.adapter.SerpViewType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0007\u0018\u00002\u00020\u0001:\u0001:BK\u0012\b\b\u0002\u00103\u001a\u00020\u0017\u0012\u0006\u00107\u001a\u00020\u0002\u0012\b\u0010%\u001a\u0004\u0018\u00010\u0017\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0017\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0017\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b8\u00109J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\"\u0010\u0012\u001a\u00020\u00118\u0016@\u0016XD¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u0012\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0012\u0010\u0014R\u001b\u0010\u001c\u001a\u0004\u0018\u00010\u00178\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010\u001f\u001a\u0004\u0018\u00010\u00178\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u0019\u001a\u0004\b\u001e\u0010\u001bR\u001b\u0010\"\u001a\u0004\u0018\u00010\u00178\u0006@\u0006¢\u0006\f\n\u0004\b \u0010\u0019\u001a\u0004\b!\u0010\u001bR\u001b\u0010%\u001a\u0004\u0018\u00010\u00178\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010\u0019\u001a\u0004\b$\u0010\u001bR\"\u0010,\u001a\u00020&8\u0016@\u0016X\u0004¢\u0006\u0012\n\u0004\b'\u0010(\u0012\u0004\b+\u0010\u0016\u001a\u0004\b)\u0010*R\"\u00100\u001a\u00020\u00118\u0016@\u0016XD¢\u0006\u0012\n\u0004\b-\u0010\u0013\u0012\u0004\b/\u0010\u0016\u001a\u0004\b.\u0010\u0014R\u001c\u00103\u001a\u00020\u00178\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b1\u0010\u0019\u001a\u0004\b2\u0010\u001bR\u001c\u00107\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u0010\u0004¨\u0006;"}, d2 = {"Lcom/avito/android/serp/adapter/location_notification/LocationNotificationItem;", "Lcom/avito/android/serp/adapter/PersistableSerpItem;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/serp/adapter/location_notification/LocationNotificationItem$TooltipType;", "h", "Lcom/avito/android/serp/adapter/location_notification/LocationNotificationItem$TooltipType;", "getTooltipType", "()Lcom/avito/android/serp/adapter/location_notification/LocationNotificationItem$TooltipType;", "tooltipType", "", "isExternalAd", "Z", "()Z", "isExternalAd$annotations", "()V", "", "f", "Ljava/lang/String;", "getConfirmText", "()Ljava/lang/String;", "confirmText", g.a, "getChangeText", "changeText", "i", "getGeoSessionId", "geoSessionId", "e", "getTitle", "title", "Lcom/avito/android/serp/adapter/SerpViewType;", AuthSource.SEND_ABUSE, "Lcom/avito/android/serp/adapter/SerpViewType;", "getViewType", "()Lcom/avito/android/serp/adapter/SerpViewType;", "getViewType$annotations", "viewType", AuthSource.BOOKING_ORDER, "getHasStablePosition", "getHasStablePosition$annotations", "hasStablePosition", "c", "getStringId", "stringId", "d", "I", "getSpanCount", "spanCount", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/serp/adapter/location_notification/LocationNotificationItem$TooltipType;Ljava/lang/String;)V", "TooltipType", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class LocationNotificationItem implements PersistableSerpItem {
    public static final Parcelable.Creator<LocationNotificationItem> CREATOR = new Creator();
    @NotNull
    public final SerpViewType a;
    public final boolean b;
    @NotNull
    public final String c;
    public final int d;
    @Nullable
    public final String e;
    @Nullable
    public final String f;
    @Nullable
    public final String g;
    @Nullable
    public final TooltipType h;
    @Nullable
    public final String i;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<LocationNotificationItem> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final LocationNotificationItem createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new LocationNotificationItem(parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? (TooltipType) Enum.valueOf(TooltipType.class, parcel.readString()) : null, parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final LocationNotificationItem[] newArray(int i) {
            return new LocationNotificationItem[i];
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\n\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/serp/adapter/location_notification/LocationNotificationItem$TooltipType;", "", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "value", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "CHANGE", "REGULAR", "serp-core_release"}, k = 1, mv = {1, 4, 2})
    public enum TooltipType {
        CHANGE("change"),
        REGULAR("regular");
        
        @NotNull
        public final String a;

        /* access modifiers changed from: public */
        TooltipType(String str) {
            this.a = str;
        }

        @NotNull
        public final String getValue() {
            return this.a;
        }
    }

    public LocationNotificationItem(@NotNull String str, int i2, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable TooltipType tooltipType, @Nullable String str5) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        this.c = str;
        this.d = i2;
        this.e = str2;
        this.f = str3;
        this.g = str4;
        this.h = tooltipType;
        this.i = str5;
        this.a = SerpViewType.SINGLE;
        this.b = true;
    }

    public static /* synthetic */ void getHasStablePosition$annotations() {
    }

    public static /* synthetic */ void getViewType$annotations() {
    }

    public static /* synthetic */ void isExternalAd$annotations() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final String getChangeText() {
        return this.g;
    }

    @Nullable
    public final String getConfirmText() {
        return this.f;
    }

    @Nullable
    public final String getGeoSessionId() {
        return this.i;
    }

    @Override // com.avito.android.serp.adapter.PersistableSerpItem
    public boolean getHasStablePosition() {
        return this.b;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return PersistableSerpItem.DefaultImpls.getId(this);
    }

    @Override // com.avito.android.serp.adapter.SpannedItem
    public int getSpanCount() {
        return this.d;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.c;
    }

    @Nullable
    public final String getTitle() {
        return this.e;
    }

    @Nullable
    public final TooltipType getTooltipType() {
        return this.h;
    }

    @Override // com.avito.android.serp.adapter.ViewTypeSerpItem
    @NotNull
    public SerpViewType getViewType() {
        return this.a;
    }

    @Override // com.avito.android.serp.adapter.PersistableSerpItem
    public boolean isExternalAd() {
        return false;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i2) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.c);
        parcel.writeInt(this.d);
        parcel.writeString(this.e);
        parcel.writeString(this.f);
        parcel.writeString(this.g);
        TooltipType tooltipType = this.h;
        if (tooltipType != null) {
            parcel.writeInt(1);
            parcel.writeString(tooltipType.name());
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.i);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LocationNotificationItem(String str, int i2, String str2, String str3, String str4, TooltipType tooltipType, String str5, int i3, j jVar) {
        this((i3 & 1) != 0 ? a.I2("UUID.randomUUID().toString()") : str, i2, str2, str3, str4, tooltipType, str5);
    }
}
