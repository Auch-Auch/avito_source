package com.avito.android.serp.adapter.promo_card;

import a2.g.r.g;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.UniversalColor;
import com.avito.android.serp.adapter.PersistableSerpItem;
import com.avito.android.serp.adapter.SerpViewType;
import com.facebook.share.internal.MessengerShareContentUtility;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0017\u0018\u00002\u00020\u0001B\u0001\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0011\u0012\b\b\u0002\u0010!\u001a\u00020\u001c\u0012\u0006\u0010-\u001a\u00020\u0002\u0012\u0006\u0010)\u001a\u00020\u000b\u0012\u0006\u0010?\u001a\u00020:\u0012\u0006\u0010B\u001a\u00020:\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u00103\u001a\u00020.\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010&\u001a\u00020\u0011¢\u0006\u0004\bC\u0010DJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u0019\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0014\u001a\u00020\u00118\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0018\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\r\u001a\u0004\b\u0017\u0010\u000fR\u001b\u0010\u001b\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\r\u001a\u0004\b\u001a\u0010\u000fR\u001c\u0010!\u001a\u00020\u001c8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\"\u0010&\u001a\u00020\u00118\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u0013\u001a\u0004\b#\u0010\u0015\"\u0004\b$\u0010%R\u001c\u0010)\u001a\u00020\u000b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b'\u0010\r\u001a\u0004\b(\u0010\u000fR\u001c\u0010-\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010\u0004R\u0019\u00103\u001a\u00020.8\u0006@\u0006¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R\u001b\u00106\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b4\u0010\r\u001a\u0004\b5\u0010\u000fR\u001b\u00109\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b7\u0010\r\u001a\u0004\b8\u0010\u000fR\u0019\u0010?\u001a\u00020:8\u0006@\u0006¢\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>R\u0019\u0010B\u001a\u00020:8\u0006@\u0006¢\u0006\f\n\u0004\b@\u0010<\u001a\u0004\bA\u0010>¨\u0006E"}, d2 = {"Lcom/avito/android/serp/adapter/promo_card/PromoCardItem;", "Lcom/avito/android/serp/adapter/PersistableSerpItem;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", g.a, "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "title", "", AuthSource.SEND_ABUSE, "Z", "isExternalAd", "()Z", "l", "getAdvertId", BookingInfoActivity.EXTRA_ITEM_ID, "j", "getSubtitle", MessengerShareContentUtility.SUBTITLE, "Lcom/avito/android/serp/adapter/SerpViewType;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/serp/adapter/SerpViewType;", "getViewType", "()Lcom/avito/android/serp/adapter/SerpViewType;", "viewType", AuthSource.OPEN_CHANNEL_LIST, "getShowedEventSent", "setShowedEventSent", "(Z)V", "showedEventSent", "d", "getStringId", "stringId", "c", "I", "getSpanCount", "spanCount", "Lcom/avito/android/deep_linking/links/DeepLink;", "i", "Lcom/avito/android/deep_linking/links/DeepLink;", "getAction", "()Lcom/avito/android/deep_linking/links/DeepLink;", "action", "h", "getImage", "image", "k", "getActionText", "actionText", "Lcom/avito/android/remote/model/UniversalColor;", "e", "Lcom/avito/android/remote/model/UniversalColor;", "getBackgroundColor", "()Lcom/avito/android/remote/model/UniversalColor;", "backgroundColor", "f", "getHighlightedBackgroundColor", "highlightedBackgroundColor", "<init>", "(ZLcom/avito/android/serp/adapter/SerpViewType;ILjava/lang/String;Lcom/avito/android/remote/model/UniversalColor;Lcom/avito/android/remote/model/UniversalColor;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public class PromoCardItem implements PersistableSerpItem {
    public static final Parcelable.Creator<PromoCardItem> CREATOR = new Creator();
    public final boolean a;
    @NotNull
    public final SerpViewType b;
    public final int c;
    @NotNull
    public final String d;
    @NotNull
    public final UniversalColor e;
    @NotNull
    public final UniversalColor f;
    @NotNull
    public final String g;
    @Nullable
    public final String h;
    @NotNull
    public final DeepLink i;
    @Nullable
    public final String j;
    @Nullable
    public final String k;
    @Nullable
    public final String l;
    public boolean m;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<PromoCardItem> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final PromoCardItem createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new PromoCardItem(parcel.readInt() != 0, (SerpViewType) Enum.valueOf(SerpViewType.class, parcel.readString()), parcel.readInt(), parcel.readString(), (UniversalColor) parcel.readParcelable(PromoCardItem.class.getClassLoader()), (UniversalColor) parcel.readParcelable(PromoCardItem.class.getClassLoader()), parcel.readString(), parcel.readString(), (DeepLink) parcel.readParcelable(PromoCardItem.class.getClassLoader()), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final PromoCardItem[] newArray(int i) {
            return new PromoCardItem[i];
        }
    }

    public PromoCardItem(boolean z, @NotNull SerpViewType serpViewType, int i2, @NotNull String str, @NotNull UniversalColor universalColor, @NotNull UniversalColor universalColor2, @NotNull String str2, @Nullable String str3, @NotNull DeepLink deepLink, @Nullable String str4, @Nullable String str5, @Nullable String str6, boolean z2) {
        Intrinsics.checkNotNullParameter(serpViewType, "viewType");
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(universalColor, "backgroundColor");
        Intrinsics.checkNotNullParameter(universalColor2, "highlightedBackgroundColor");
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(deepLink, "action");
        this.a = z;
        this.b = serpViewType;
        this.c = i2;
        this.d = str;
        this.e = universalColor;
        this.f = universalColor2;
        this.g = str2;
        this.h = str3;
        this.i = deepLink;
        this.j = str4;
        this.k = str5;
        this.l = str6;
        this.m = z2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final DeepLink getAction() {
        return this.i;
    }

    @Nullable
    public final String getActionText() {
        return this.k;
    }

    @Nullable
    public final String getAdvertId() {
        return this.l;
    }

    @NotNull
    public final UniversalColor getBackgroundColor() {
        return this.e;
    }

    @Override // com.avito.android.serp.adapter.PersistableSerpItem
    public boolean getHasStablePosition() {
        return PersistableSerpItem.DefaultImpls.getHasStablePosition(this);
    }

    @NotNull
    public final UniversalColor getHighlightedBackgroundColor() {
        return this.f;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return PersistableSerpItem.DefaultImpls.getId(this);
    }

    @Nullable
    public final String getImage() {
        return this.h;
    }

    public final boolean getShowedEventSent() {
        return this.m;
    }

    @Override // com.avito.android.serp.adapter.SpannedItem
    public int getSpanCount() {
        return this.c;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.d;
    }

    @Nullable
    public final String getSubtitle() {
        return this.j;
    }

    @NotNull
    public final String getTitle() {
        return this.g;
    }

    @Override // com.avito.android.serp.adapter.ViewTypeSerpItem
    @NotNull
    public SerpViewType getViewType() {
        return this.b;
    }

    @Override // com.avito.android.serp.adapter.PersistableSerpItem
    public boolean isExternalAd() {
        return this.a;
    }

    public final void setShowedEventSent(boolean z) {
        this.m = z;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i2) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeInt(this.a ? 1 : 0);
        parcel.writeString(this.b.name());
        parcel.writeInt(this.c);
        parcel.writeString(this.d);
        parcel.writeParcelable(this.e, i2);
        parcel.writeParcelable(this.f, i2);
        parcel.writeString(this.g);
        parcel.writeString(this.h);
        parcel.writeParcelable(this.i, i2);
        parcel.writeString(this.j);
        parcel.writeString(this.k);
        parcel.writeString(this.l);
        parcel.writeInt(this.m ? 1 : 0);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PromoCardItem(boolean z, SerpViewType serpViewType, int i2, String str, UniversalColor universalColor, UniversalColor universalColor2, String str2, String str3, DeepLink deepLink, String str4, String str5, String str6, boolean z2, int i3, j jVar) {
        this((i3 & 1) != 0 ? false : z, (i3 & 2) != 0 ? SerpViewType.SINGLE : serpViewType, i2, str, universalColor, universalColor2, str2, (i3 & 128) != 0 ? null : str3, deepLink, (i3 & 512) != 0 ? null : str4, (i3 & 1024) != 0 ? null : str5, (i3 & 2048) != 0 ? null : str6, (i3 & 4096) != 0 ? false : z2);
    }
}
