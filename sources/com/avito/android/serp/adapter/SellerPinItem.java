package com.avito.android.serp.adapter;

import a2.g.r.g;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.serp.adapter.PersistableSerpItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0016\u001a\u00020\u0011\u0012\u0006\u0010\u001c\u001a\u00020\u0017\u0012\u0006\u00103\u001a\u00020\u0017\u0012\b\u00100\u001a\u0004\u0018\u00010\u0017\u0012\b\u0010-\u001a\u0004\u0018\u00010(\u0012\u0006\u0010'\u001a\u00020\u0002¢\u0006\u0004\b4\u00105J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\"\u0010\f\u001a\u00020\u000b8\u0016@\u0016XD¢\u0006\u0012\n\u0004\b\f\u0010\r\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\f\u0010\u000eR\u001c\u0010\u0016\u001a\u00020\u00118\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u001c\u001a\u00020\u00178\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\"\u0010#\u001a\u00020\u001d8\u0016@\u0016X\u0004¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u0012\u0004\b\"\u0010\u0010\u001a\u0004\b \u0010!R\u001c\u0010'\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010\u0004R\u001b\u0010-\u001a\u0004\u0018\u00010(8\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u001b\u00100\u001a\u0004\u0018\u00010\u00178\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010\u0019\u001a\u0004\b/\u0010\u001bR\u0019\u00103\u001a\u00020\u00178\u0006@\u0006¢\u0006\f\n\u0004\b1\u0010\u0019\u001a\u0004\b2\u0010\u001b¨\u00066"}, d2 = {"Lcom/avito/android/serp/adapter/SellerPinItem;", "Lcom/avito/android/serp/adapter/PersistableSerpItem;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "isExternalAd", "Z", "()Z", "isExternalAd$annotations", "()V", "", AuthSource.BOOKING_ORDER, "J", "getId", "()J", "id", "", "c", "Ljava/lang/String;", "getStringId", "()Ljava/lang/String;", "stringId", "Lcom/avito/android/serp/adapter/SerpViewType;", AuthSource.SEND_ABUSE, "Lcom/avito/android/serp/adapter/SerpViewType;", "getViewType", "()Lcom/avito/android/serp/adapter/SerpViewType;", "getViewType$annotations", "viewType", g.a, "I", "getSpanCount", "spanCount", "Lcom/avito/android/deep_linking/links/DeepLink;", "f", "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeepLink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "e", "getDescription", "description", "d", "getTitle", "title", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;I)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class SellerPinItem implements PersistableSerpItem {
    public static final Parcelable.Creator<SellerPinItem> CREATOR = new Creator();
    @NotNull
    public final SerpViewType a = SerpViewType.SINGLE;
    public final long b;
    @NotNull
    public final String c;
    @NotNull
    public final String d;
    @Nullable
    public final String e;
    @Nullable
    public final DeepLink f;
    public final int g;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<SellerPinItem> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SellerPinItem createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new SellerPinItem(parcel.readLong(), parcel.readString(), parcel.readString(), parcel.readString(), (DeepLink) parcel.readParcelable(SellerPinItem.class.getClassLoader()), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SellerPinItem[] newArray(int i) {
            return new SellerPinItem[i];
        }
    }

    public SellerPinItem(long j, @NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable DeepLink deepLink, int i) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(str2, "title");
        this.b = j;
        this.c = str;
        this.d = str2;
        this.e = str3;
        this.f = deepLink;
        this.g = i;
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
    public final DeepLink getDeepLink() {
        return this.f;
    }

    @Nullable
    public final String getDescription() {
        return this.e;
    }

    @Override // com.avito.android.serp.adapter.PersistableSerpItem
    public boolean getHasStablePosition() {
        return PersistableSerpItem.DefaultImpls.getHasStablePosition(this);
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return this.b;
    }

    @Override // com.avito.android.serp.adapter.SpannedItem
    public int getSpanCount() {
        return this.g;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.c;
    }

    @NotNull
    public final String getTitle() {
        return this.d;
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
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeLong(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeString(this.e);
        parcel.writeParcelable(this.f, i);
        parcel.writeInt(this.g);
    }
}
