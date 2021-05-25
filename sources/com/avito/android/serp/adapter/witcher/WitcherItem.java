package com.avito.android.serp.adapter.witcher;

import a2.b.a.a.a;
import a2.g.r.g;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.WitcherElement;
import com.avito.android.serp.adapter.PersistableSerpItem;
import com.avito.android.serp.adapter.SerpViewType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001BQ\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u000b\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010&\u001a\u00020!\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u00010/\u0012\u000e\b\u0002\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00010\u001b\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u000b¢\u0006\u0004\b:\u0010;J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u0019\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0014\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004R\u001c\u0010\u0017\u001a\u00020\u000b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\r\u001a\u0004\b\u0016\u0010\u000fR\u0019\u0010\u001a\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\r\u001a\u0004\b\u0019\u0010\u000fR\u001f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00010\u001b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0019\u0010&\u001a\u00020!8\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\"\u0010.\u001a\u00020'8\u0016@\u0016X\u0004¢\u0006\u0012\n\u0004\b(\u0010)\u0012\u0004\b,\u0010-\u001a\u0004\b*\u0010+R\u001b\u00104\u001a\u0004\u0018\u00010/8\u0006@\u0006¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R\"\u00106\u001a\u0002058\u0016@\u0016XD¢\u0006\u0012\n\u0004\b6\u00107\u0012\u0004\b9\u0010-\u001a\u0004\b6\u00108¨\u0006<"}, d2 = {"Lcom/avito/android/serp/adapter/witcher/WitcherItem;", "Lcom/avito/android/serp/adapter/PersistableSerpItem;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", g.a, "Ljava/lang/String;", "getButtonText", "()Ljava/lang/String;", "buttonText", "c", "I", "getSpanCount", "spanCount", AuthSource.BOOKING_ORDER, "getStringId", "stringId", "h", "getTitleText", "titleText", "", "f", "Ljava/util/List;", "getItems", "()Ljava/util/List;", "items", "Lcom/avito/android/remote/model/WitcherElement$SelectionType;", "d", "Lcom/avito/android/remote/model/WitcherElement$SelectionType;", "getSelectionType", "()Lcom/avito/android/remote/model/WitcherElement$SelectionType;", "selectionType", "Lcom/avito/android/serp/adapter/SerpViewType;", AuthSource.SEND_ABUSE, "Lcom/avito/android/serp/adapter/SerpViewType;", "getViewType", "()Lcom/avito/android/serp/adapter/SerpViewType;", "getViewType$annotations", "()V", "viewType", "Lcom/avito/android/deep_linking/links/DeepLink;", "e", "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeepLink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "", "isExternalAd", "Z", "()Z", "isExternalAd$annotations", "<init>", "(Ljava/lang/String;ILcom/avito/android/remote/model/WitcherElement$SelectionType;Lcom/avito/android/deep_linking/links/DeepLink;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class WitcherItem implements PersistableSerpItem {
    public static final Parcelable.Creator<WitcherItem> CREATOR = new Creator();
    @NotNull
    public final SerpViewType a;
    @NotNull
    public final String b;
    public final int c;
    @NotNull
    public final WitcherElement.SelectionType d;
    @Nullable
    public final DeepLink e;
    @NotNull
    public final List<PersistableSerpItem> f;
    @NotNull
    public final String g;
    @NotNull
    public final String h;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<WitcherItem> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final WitcherItem createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            int readInt = parcel.readInt();
            WitcherElement.SelectionType selectionType = (WitcherElement.SelectionType) Enum.valueOf(WitcherElement.SelectionType.class, parcel.readString());
            DeepLink deepLink = (DeepLink) parcel.readParcelable(WitcherItem.class.getClassLoader());
            int readInt2 = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt2);
            while (readInt2 != 0) {
                arrayList.add((PersistableSerpItem) parcel.readParcelable(WitcherItem.class.getClassLoader()));
                readInt2--;
            }
            return new WitcherItem(readString, readInt, selectionType, deepLink, arrayList, parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final WitcherItem[] newArray(int i) {
            return new WitcherItem[i];
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.util.List<? extends com.avito.android.serp.adapter.PersistableSerpItem> */
    /* JADX WARN: Multi-variable type inference failed */
    public WitcherItem(@NotNull String str, int i, @NotNull WitcherElement.SelectionType selectionType, @Nullable DeepLink deepLink, @NotNull List<? extends PersistableSerpItem> list, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(selectionType, "selectionType");
        Intrinsics.checkNotNullParameter(list, "items");
        Intrinsics.checkNotNullParameter(str2, "buttonText");
        Intrinsics.checkNotNullParameter(str3, "titleText");
        this.b = str;
        this.c = i;
        this.d = selectionType;
        this.e = deepLink;
        this.f = list;
        this.g = str2;
        this.h = str3;
        this.a = SerpViewType.SINGLE;
    }

    public static /* synthetic */ void getViewType$annotations() {
    }

    public static /* synthetic */ void isExternalAd$annotations() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final String getButtonText() {
        return this.g;
    }

    @Nullable
    public final DeepLink getDeepLink() {
        return this.e;
    }

    @Override // com.avito.android.serp.adapter.PersistableSerpItem
    public boolean getHasStablePosition() {
        return PersistableSerpItem.DefaultImpls.getHasStablePosition(this);
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return PersistableSerpItem.DefaultImpls.getId(this);
    }

    @NotNull
    public final List<PersistableSerpItem> getItems() {
        return this.f;
    }

    @NotNull
    public final WitcherElement.SelectionType getSelectionType() {
        return this.d;
    }

    @Override // com.avito.android.serp.adapter.SpannedItem
    public int getSpanCount() {
        return this.c;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.b;
    }

    @NotNull
    public final String getTitleText() {
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
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.b);
        parcel.writeInt(this.c);
        parcel.writeString(this.d.name());
        parcel.writeParcelable(this.e, i);
        Iterator n0 = a.n0(this.f, parcel);
        while (n0.hasNext()) {
            parcel.writeParcelable((PersistableSerpItem) n0.next(), i);
        }
        parcel.writeString(this.g);
        parcel.writeString(this.h);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ WitcherItem(String str, int i, WitcherElement.SelectionType selectionType, DeepLink deepLink, List list, String str2, String str3, int i2, j jVar) {
        this((i2 & 1) != 0 ? a.I2("UUID.randomUUID().toString()") : str, i, selectionType, (i2 & 8) != 0 ? null : deepLink, (i2 & 16) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, (i2 & 32) != 0 ? "" : str2, (i2 & 64) != 0 ? "" : str3);
    }
}
