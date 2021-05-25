package com.avito.android.section.title_with_action;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Action;
import com.avito.android.section.action.SectionActionItem;
import com.avito.android.section.title.SectionTitleItem;
import com.avito.android.serp.adapter.SerpViewType;
import com.facebook.share.internal.MessengerShareContentUtility;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B?\u0012\u0006\u0010\u001d\u001a\u00020\f\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010!\u001a\u00020\u0003\u0012\b\u0010'\u001a\u0004\u0018\u00010\"\u0012\b\b\u0002\u0010-\u001a\u00020(¢\u0006\u0004\b.\u0010/J\u0010\u0010\u0004\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u000e\u001a\u0004\b\u0013\u0010\u0010R\"\u0010\u0016\u001a\u00020\u00158\u0016@\u0016XD¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u0012\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0016\u0010\u0018R\u001c\u0010\u001d\u001a\u00020\f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u000e\u001a\u0004\b\u001c\u0010\u0010R\u001c\u0010!\u001a\u00020\u00038\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010\u0005R\u001e\u0010'\u001a\u0004\u0018\u00010\"8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u001c\u0010-\u001a\u00020(8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,¨\u00060"}, d2 = {"Lcom/avito/android/section/title_with_action/SectionTitleWithActionItem;", "Lcom/avito/android/section/title/SectionTitleItem;", "Lcom/avito/android/section/action/SectionActionItem;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "title", "c", "getSubtitle", MessengerShareContentUtility.SUBTITLE, "", "isExternalAd", "Z", "()Z", "isExternalAd$annotations", "()V", AuthSource.SEND_ABUSE, "getStringId", "stringId", "d", "I", "getSpanCount", "spanCount", "Lcom/avito/android/remote/model/Action;", "e", "Lcom/avito/android/remote/model/Action;", "getAction", "()Lcom/avito/android/remote/model/Action;", "action", "Lcom/avito/android/serp/adapter/SerpViewType;", "f", "Lcom/avito/android/serp/adapter/SerpViewType;", "getViewType", "()Lcom/avito/android/serp/adapter/SerpViewType;", "viewType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILcom/avito/android/remote/model/Action;Lcom/avito/android/serp/adapter/SerpViewType;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class SectionTitleWithActionItem implements SectionTitleItem, SectionActionItem {
    public static final Parcelable.Creator<SectionTitleWithActionItem> CREATOR = new Creator();
    @NotNull
    public final String a;
    @Nullable
    public final String b;
    @Nullable
    public final String c;
    public final int d;
    @Nullable
    public final Action e;
    @NotNull
    public final SerpViewType f;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<SectionTitleWithActionItem> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SectionTitleWithActionItem createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new SectionTitleWithActionItem(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), (Action) parcel.readParcelable(SectionTitleWithActionItem.class.getClassLoader()), (SerpViewType) Enum.valueOf(SerpViewType.class, parcel.readString()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SectionTitleWithActionItem[] newArray(int i) {
            return new SectionTitleWithActionItem[i];
        }
    }

    public SectionTitleWithActionItem(@NotNull String str, @Nullable String str2, @Nullable String str3, int i, @Nullable Action action, @NotNull SerpViewType serpViewType) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(serpViewType, "viewType");
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = i;
        this.e = action;
        this.f = serpViewType;
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
        return this.e;
    }

    @Override // com.avito.android.serp.adapter.PersistableSerpItem
    public boolean getHasStablePosition() {
        return SectionTitleItem.DefaultImpls.getHasStablePosition(this);
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return SectionTitleItem.DefaultImpls.getId(this);
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
        return this.f;
    }

    @Override // com.avito.android.serp.adapter.PersistableSerpItem
    public boolean isExternalAd() {
        return false;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeInt(this.d);
        parcel.writeParcelable(this.e, i);
        parcel.writeString(this.f.name());
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SectionTitleWithActionItem(String str, String str2, String str3, int i, Action action, SerpViewType serpViewType, int i2, j jVar) {
        this(str, str2, str3, i, action, (i2 & 32) != 0 ? SerpViewType.SINGLE : serpViewType);
    }
}
