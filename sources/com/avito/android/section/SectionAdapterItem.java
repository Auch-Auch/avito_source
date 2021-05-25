package com.avito.android.section;

import a2.b.a.a.a;
import a2.g.r.g;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Action;
import com.avito.android.remote.model.section.SectionDisplaying;
import com.avito.android.section.SectionItem;
import com.avito.android.serp.adapter.PersistableSerpItem;
import com.avito.android.serp.adapter.SerpViewType;
import com.facebook.share.internal.MessengerShareContentUtility;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001Ba\u0012\u0006\u0010<\u001a\u00020\u000b\u0012\b\u0010,\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010#\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0015\u0012\b\u0010)\u001a\u0004\u0018\u00010$\u0012\f\u00109\u001a\b\u0012\u0004\u0012\u00020403\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000b\u0012\b\u00102\u001a\u0004\u0018\u00010-¢\u0006\u0004\b=\u0010>J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0014\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004R\u001c\u0010\u001a\u001a\u00020\u00158\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\"\u0010\u001c\u001a\u00020\u001b8\u0016@\u0016XD¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u0012\u0004\b\u001f\u0010 \u001a\u0004\b\u001c\u0010\u001eR\u001e\u0010#\u001a\u0004\u0018\u00010\u000b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b!\u0010\r\u001a\u0004\b\"\u0010\u000fR\u001e\u0010)\u001a\u0004\u0018\u00010$8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u001e\u0010,\u001a\u0004\u0018\u00010\u000b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b*\u0010\r\u001a\u0004\b+\u0010\u000fR\u001e\u00102\u001a\u0004\u0018\u00010-8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\"\u00109\u001a\b\u0012\u0004\u0012\u000204038\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R\u001c\u0010<\u001a\u00020\u000b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b:\u0010\r\u001a\u0004\b;\u0010\u000f¨\u0006?"}, d2 = {"Lcom/avito/android/section/SectionAdapterItem;", "Lcom/avito/android/section/SectionItem;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "h", "Ljava/lang/String;", "getContext", "()Ljava/lang/String;", "context", "d", "I", "getSpanCount", "spanCount", "Lcom/avito/android/serp/adapter/SerpViewType;", "e", "Lcom/avito/android/serp/adapter/SerpViewType;", "getViewType", "()Lcom/avito/android/serp/adapter/SerpViewType;", "viewType", "", "isExternalAd", "Z", "()Z", "isExternalAd$annotations", "()V", "c", "getSubtitle", MessengerShareContentUtility.SUBTITLE, "Lcom/avito/android/remote/model/Action;", "f", "Lcom/avito/android/remote/model/Action;", "getAction", "()Lcom/avito/android/remote/model/Action;", "action", AuthSource.BOOKING_ORDER, "getTitle", "title", "Lcom/avito/android/remote/model/section/SectionDisplaying;", "i", "Lcom/avito/android/remote/model/section/SectionDisplaying;", "getDisplaying", "()Lcom/avito/android/remote/model/section/SectionDisplaying;", "displaying", "", "Lcom/avito/android/serp/adapter/PersistableSerpItem;", g.a, "Ljava/util/List;", "getItems", "()Ljava/util/List;", "items", AuthSource.SEND_ABUSE, "getStringId", "stringId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILcom/avito/android/serp/adapter/SerpViewType;Lcom/avito/android/remote/model/Action;Ljava/util/List;Ljava/lang/String;Lcom/avito/android/remote/model/section/SectionDisplaying;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class SectionAdapterItem implements SectionItem {
    public static final Parcelable.Creator<SectionAdapterItem> CREATOR = new Creator();
    @NotNull
    public final String a;
    @Nullable
    public final String b;
    @Nullable
    public final String c;
    public final int d;
    @NotNull
    public final SerpViewType e;
    @Nullable
    public final Action f;
    @NotNull
    public final List<PersistableSerpItem> g;
    @Nullable
    public final String h;
    @Nullable
    public final SectionDisplaying i;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<SectionAdapterItem> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SectionAdapterItem createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            int readInt = parcel.readInt();
            SerpViewType serpViewType = (SerpViewType) Enum.valueOf(SerpViewType.class, parcel.readString());
            Action action = (Action) parcel.readParcelable(SectionAdapterItem.class.getClassLoader());
            int readInt2 = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt2);
            while (readInt2 != 0) {
                arrayList.add((PersistableSerpItem) parcel.readParcelable(SectionAdapterItem.class.getClassLoader()));
                readInt2--;
            }
            return new SectionAdapterItem(readString, readString2, readString3, readInt, serpViewType, action, arrayList, parcel.readString(), (SectionDisplaying) parcel.readParcelable(SectionAdapterItem.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SectionAdapterItem[] newArray(int i) {
            return new SectionAdapterItem[i];
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: java.util.List<? extends com.avito.android.serp.adapter.PersistableSerpItem> */
    /* JADX WARN: Multi-variable type inference failed */
    public SectionAdapterItem(@NotNull String str, @Nullable String str2, @Nullable String str3, int i2, @NotNull SerpViewType serpViewType, @Nullable Action action, @NotNull List<? extends PersistableSerpItem> list, @Nullable String str4, @Nullable SectionDisplaying sectionDisplaying) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(serpViewType, "viewType");
        Intrinsics.checkNotNullParameter(list, "items");
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = i2;
        this.e = serpViewType;
        this.f = action;
        this.g = list;
        this.h = str4;
        this.i = sectionDisplaying;
    }

    public static /* synthetic */ void isExternalAd$annotations() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.avito.android.section.action.SectionActionItem
    @Nullable
    public Action getAction() {
        return this.f;
    }

    @Override // com.avito.android.section.SectionItem
    @Nullable
    public String getContext() {
        return this.h;
    }

    @Override // com.avito.android.section.SectionItem
    @Nullable
    public SectionDisplaying getDisplaying() {
        return this.i;
    }

    @Override // com.avito.android.serp.adapter.PersistableSerpItem
    public boolean getHasStablePosition() {
        return SectionItem.DefaultImpls.getHasStablePosition(this);
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return SectionItem.DefaultImpls.getId(this);
    }

    @Override // com.avito.android.section.SectionItem
    @NotNull
    public List<PersistableSerpItem> getItems() {
        return this.g;
    }

    @Override // com.avito.android.serp.adapter.SpannedItem
    public int getSpanCount() {
        return this.d;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.a;
    }

    @Override // com.avito.android.section.title.SectionTitleItem
    @Nullable
    public String getSubtitle() {
        return this.c;
    }

    @Override // com.avito.android.section.title.SectionTitleItem
    @Nullable
    public String getTitle() {
        return this.b;
    }

    @Override // com.avito.android.serp.adapter.ViewTypeSerpItem
    @NotNull
    public SerpViewType getViewType() {
        return this.e;
    }

    @Override // com.avito.android.serp.adapter.PersistableSerpItem
    public boolean isExternalAd() {
        return false;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i2) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeInt(this.d);
        parcel.writeString(this.e.name());
        parcel.writeParcelable(this.f, i2);
        Iterator n0 = a.n0(this.g, parcel);
        while (n0.hasNext()) {
            parcel.writeParcelable((PersistableSerpItem) n0.next(), i2);
        }
        parcel.writeString(this.h);
        parcel.writeParcelable(this.i, i2);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SectionAdapterItem(String str, String str2, String str3, int i2, SerpViewType serpViewType, Action action, List list, String str4, SectionDisplaying sectionDisplaying, int i3, j jVar) {
        this(str, str2, str3, i2, (i3 & 16) != 0 ? SerpViewType.SINGLE : serpViewType, action, list, str4, sectionDisplaying);
    }
}
