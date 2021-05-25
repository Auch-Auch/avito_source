package com.avito.android.stories;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Story;
import com.avito.android.serp.adapter.PersistableSerpItem;
import com.avito.android.serp.adapter.SerpViewType;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B3\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0013\u0012\u0006\u0010\u001e\u001a\u00020\u0002\u0012\f\u00101\u001a\b\u0012\u0004\u0012\u00020,0+\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b2\u00103J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\"\u0010\u0012\u001a\u00020\u000b8\u0016@\u0016XD¢\u0006\u0012\n\u0004\b\f\u0010\r\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0018\u001a\u00020\u00138\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\"\u0010\u0019\u001a\u00020\u000b8\u0016@\u0016XD¢\u0006\u0012\n\u0004\b\u0019\u0010\r\u0012\u0004\b\u001a\u0010\u0011\u001a\u0004\b\u0019\u0010\u000fR\u001c\u0010\u001e\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0004R$\u0010#\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u0015\u001a\u0004\b \u0010\u0017\"\u0004\b!\u0010\"R\"\u0010*\u001a\u00020$8\u0016@\u0016X\u0004¢\u0006\u0012\n\u0004\b%\u0010&\u0012\u0004\b)\u0010\u0011\u001a\u0004\b'\u0010(R\u001f\u00101\u001a\b\u0012\u0004\u0012\u00020,0+8\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100¨\u00064"}, d2 = {"Lcom/avito/android/stories/StoriesItem;", "Lcom/avito/android/serp/adapter/PersistableSerpItem;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", AuthSource.BOOKING_ORDER, "Z", "getHasStablePosition", "()Z", "getHasStablePosition$annotations", "()V", "hasStablePosition", "", "c", "Ljava/lang/String;", "getStringId", "()Ljava/lang/String;", "stringId", "isExternalAd", "isExternalAd$annotations", "d", "I", "getSpanCount", "spanCount", "f", "getCurrentStoryId", "setCurrentStoryId", "(Ljava/lang/String;)V", "currentStoryId", "Lcom/avito/android/serp/adapter/SerpViewType;", AuthSource.SEND_ABUSE, "Lcom/avito/android/serp/adapter/SerpViewType;", "getViewType", "()Lcom/avito/android/serp/adapter/SerpViewType;", "getViewType$annotations", "viewType", "", "Lcom/avito/android/remote/model/Story;", "e", "Ljava/util/List;", "getStories", "()Ljava/util/List;", "stories", "<init>", "(Ljava/lang/String;ILjava/util/List;Ljava/lang/String;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class StoriesItem implements PersistableSerpItem {
    public static final Parcelable.Creator<StoriesItem> CREATOR = new Creator();
    @NotNull
    public final SerpViewType a;
    public final boolean b;
    @NotNull
    public final String c;
    public final int d;
    @NotNull
    public final List<Story> e;
    @Nullable
    public String f;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<StoriesItem> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final StoriesItem createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            int readInt = parcel.readInt();
            int readInt2 = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt2);
            while (readInt2 != 0) {
                arrayList.add((Story) parcel.readParcelable(StoriesItem.class.getClassLoader()));
                readInt2--;
            }
            return new StoriesItem(readString, readInt, arrayList, parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final StoriesItem[] newArray(int i) {
            return new StoriesItem[i];
        }
    }

    public StoriesItem(@NotNull String str, int i, @NotNull List<Story> list, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(list, "stories");
        this.c = str;
        this.d = i;
        this.e = list;
        this.f = str2;
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
    public final String getCurrentStoryId() {
        return this.f;
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

    @NotNull
    public final List<Story> getStories() {
        return this.e;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.c;
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

    public final void setCurrentStoryId(@Nullable String str) {
        this.f = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.c);
        parcel.writeInt(this.d);
        Iterator n0 = a.n0(this.e, parcel);
        while (n0.hasNext()) {
            parcel.writeParcelable((Story) n0.next(), i);
        }
        parcel.writeString(this.f);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ StoriesItem(String str, int i, List list, String str2, int i2, j jVar) {
        this((i2 & 1) != 0 ? "stories_item_id" : str, i, list, (i2 & 8) != 0 ? null : str2);
    }
}
