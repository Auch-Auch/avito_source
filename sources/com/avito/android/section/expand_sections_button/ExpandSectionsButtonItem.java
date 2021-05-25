package com.avito.android.section.expand_sections_button;

import a2.b.a.a.a;
import a2.g.r.g;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Action;
import com.avito.android.section.action.SectionActionItem;
import com.avito.android.section.title.SectionTitleItem;
import com.avito.android.section.title_with_action.SectionTitleWithActionItem;
import com.avito.android.serp.adapter.PersistableSpannedItem;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0011\b\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B1\u0012\u0006\u0010\u0010\u001a\u00020\u0004\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0007\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\n\u0012\b\b\u0002\u0010\u0013\u001a\u00020\r¢\u0006\u0004\bS\u0010TJ\u0010\u0010\u0005\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ@\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\u00042\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00072\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\n2\b\b\u0002\u0010\u0013\u001a\u00020\rHÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u0016\u0010\tJ\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001c\u001a\u00020\r2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aHÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u0019J \u0010#\u001a\u00020\"2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b#\u0010$R$\u0010*\u001a\u0004\u0018\u00010\u00078\u0016@\u0016X\u0004¢\u0006\u0012\n\u0004\b%\u0010&\u0012\u0004\b(\u0010)\u001a\u0004\b'\u0010\tR\u0019\u0010\u0013\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b\u0013\u0010\u000fR\"\u00100\u001a\u00020\u00078\u0016@\u0016X\u0004¢\u0006\u0012\n\u0004\b-\u0010&\u0012\u0004\b/\u0010)\u001a\u0004\b.\u0010\tR\"\u00107\u001a\u0002018\u0016@\u0016X\u0004¢\u0006\u0012\n\u0004\b2\u00103\u0012\u0004\b6\u0010)\u001a\u0004\b4\u00105R\u0019\u0010\u0010\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010\u0006R$\u0010>\u001a\u0004\u0018\u00010\u00078\u0016@\u0016X\u0004¢\u0006\u0012\n\u0004\b;\u0010&\u0012\u0004\b=\u0010)\u001a\u0004\b<\u0010\tR\"\u0010C\u001a\u00020\u00178\u0016@\u0016X\u0004¢\u0006\u0012\n\u0004\b?\u0010@\u0012\u0004\bB\u0010)\u001a\u0004\bA\u0010\u0019R$\u0010J\u001a\u0004\u0018\u00010D8\u0016@\u0016X\u0004¢\u0006\u0012\n\u0004\bE\u0010F\u0012\u0004\bI\u0010)\u001a\u0004\bG\u0010HR\"\u0010L\u001a\u00020\r8\u0016@\u0016X\u0004¢\u0006\u0012\n\u0004\bK\u0010,\u0012\u0004\bM\u0010)\u001a\u0004\bL\u0010\u000fR\u001f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\bN\u0010O\u001a\u0004\bP\u0010\fR\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u00078\u0006@\u0006¢\u0006\f\n\u0004\bQ\u0010&\u001a\u0004\bR\u0010\t¨\u0006U"}, d2 = {"Lcom/avito/android/section/expand_sections_button/ExpandSectionsButtonItem;", "Lcom/avito/android/section/title/SectionTitleItem;", "Lcom/avito/android/serp/adapter/PersistableSpannedItem;", "Lcom/avito/android/section/action/SectionActionItem;", "Lcom/avito/android/section/title_with_action/SectionTitleWithActionItem;", "component1", "()Lcom/avito/android/section/title_with_action/SectionTitleWithActionItem;", "", "component2", "()Ljava/lang/String;", "", "component3", "()Ljava/util/List;", "", "component4", "()Z", "item", "expandButtonTitle", "collapsedSections", "isExpanded", "copy", "(Lcom/avito/android/section/title_with_action/SectionTitleWithActionItem;Ljava/lang/String;Ljava/util/List;Z)Lcom/avito/android/section/expand_sections_button/ExpandSectionsButtonItem;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "d", "Ljava/lang/String;", "getSubtitle", "getSubtitle$annotations", "()V", MessengerShareContentUtility.SUBTITLE, "k", "Z", AuthSource.BOOKING_ORDER, "getStringId", "getStringId$annotations", "stringId", "Lcom/avito/android/serp/adapter/SerpViewType;", "f", "Lcom/avito/android/serp/adapter/SerpViewType;", "getViewType", "()Lcom/avito/android/serp/adapter/SerpViewType;", "getViewType$annotations", "viewType", "h", "Lcom/avito/android/section/title_with_action/SectionTitleWithActionItem;", "getItem", "c", "getTitle", "getTitle$annotations", "title", AuthSource.SEND_ABUSE, "I", "getSpanCount", "getSpanCount$annotations", "spanCount", "Lcom/avito/android/remote/model/Action;", g.a, "Lcom/avito/android/remote/model/Action;", "getAction", "()Lcom/avito/android/remote/model/Action;", "getAction$annotations", "action", "e", "isExternalAd", "isExternalAd$annotations", "j", "Ljava/util/List;", "getCollapsedSections", "i", "getExpandButtonTitle", "<init>", "(Lcom/avito/android/section/title_with_action/SectionTitleWithActionItem;Ljava/lang/String;Ljava/util/List;Z)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class ExpandSectionsButtonItem implements SectionTitleItem, PersistableSpannedItem, SectionActionItem {
    public static final Parcelable.Creator<ExpandSectionsButtonItem> CREATOR = new Creator();
    public final int a;
    @NotNull
    public final String b;
    @Nullable
    public final String c;
    @Nullable
    public final String d;
    public final boolean e;
    @NotNull
    public final SerpViewType f;
    @Nullable
    public final Action g;
    @NotNull
    public final SectionTitleWithActionItem h;
    @Nullable
    public final String i;
    @NotNull
    public final List<PersistableSpannedItem> j;
    public final boolean k;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<ExpandSectionsButtonItem> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ExpandSectionsButtonItem createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            SectionTitleWithActionItem createFromParcel = SectionTitleWithActionItem.CREATOR.createFromParcel(parcel);
            String readString = parcel.readString();
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList.add((PersistableSpannedItem) parcel.readParcelable(ExpandSectionsButtonItem.class.getClassLoader()));
                readInt--;
            }
            return new ExpandSectionsButtonItem(createFromParcel, readString, arrayList, parcel.readInt() != 0);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ExpandSectionsButtonItem[] newArray(int i) {
            return new ExpandSectionsButtonItem[i];
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.List<? extends com.avito.android.serp.adapter.PersistableSpannedItem> */
    /* JADX WARN: Multi-variable type inference failed */
    public ExpandSectionsButtonItem(@NotNull SectionTitleWithActionItem sectionTitleWithActionItem, @Nullable String str, @NotNull List<? extends PersistableSpannedItem> list, boolean z) {
        Intrinsics.checkNotNullParameter(sectionTitleWithActionItem, "item");
        Intrinsics.checkNotNullParameter(list, "collapsedSections");
        this.h = sectionTitleWithActionItem;
        this.i = str;
        this.j = list;
        this.k = z;
        this.a = sectionTitleWithActionItem.getSpanCount();
        this.b = sectionTitleWithActionItem.getStringId();
        this.c = sectionTitleWithActionItem.getTitle();
        this.d = sectionTitleWithActionItem.getSubtitle();
        this.e = sectionTitleWithActionItem.isExternalAd();
        this.f = sectionTitleWithActionItem.getViewType();
        this.g = sectionTitleWithActionItem.getAction();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.section.expand_sections_button.ExpandSectionsButtonItem */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ExpandSectionsButtonItem copy$default(ExpandSectionsButtonItem expandSectionsButtonItem, SectionTitleWithActionItem sectionTitleWithActionItem, String str, List list, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            sectionTitleWithActionItem = expandSectionsButtonItem.h;
        }
        if ((i2 & 2) != 0) {
            str = expandSectionsButtonItem.i;
        }
        if ((i2 & 4) != 0) {
            list = expandSectionsButtonItem.j;
        }
        if ((i2 & 8) != 0) {
            z = expandSectionsButtonItem.k;
        }
        return expandSectionsButtonItem.copy(sectionTitleWithActionItem, str, list, z);
    }

    public static /* synthetic */ void getAction$annotations() {
    }

    public static /* synthetic */ void getSpanCount$annotations() {
    }

    public static /* synthetic */ void getStringId$annotations() {
    }

    public static /* synthetic */ void getSubtitle$annotations() {
    }

    public static /* synthetic */ void getTitle$annotations() {
    }

    public static /* synthetic */ void getViewType$annotations() {
    }

    public static /* synthetic */ void isExternalAd$annotations() {
    }

    @NotNull
    public final SectionTitleWithActionItem component1() {
        return this.h;
    }

    @Nullable
    public final String component2() {
        return this.i;
    }

    @NotNull
    public final List<PersistableSpannedItem> component3() {
        return this.j;
    }

    public final boolean component4() {
        return this.k;
    }

    @NotNull
    public final ExpandSectionsButtonItem copy(@NotNull SectionTitleWithActionItem sectionTitleWithActionItem, @Nullable String str, @NotNull List<? extends PersistableSpannedItem> list, boolean z) {
        Intrinsics.checkNotNullParameter(sectionTitleWithActionItem, "item");
        Intrinsics.checkNotNullParameter(list, "collapsedSections");
        return new ExpandSectionsButtonItem(sectionTitleWithActionItem, str, list, z);
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
        if (!(obj instanceof ExpandSectionsButtonItem)) {
            return false;
        }
        ExpandSectionsButtonItem expandSectionsButtonItem = (ExpandSectionsButtonItem) obj;
        return Intrinsics.areEqual(this.h, expandSectionsButtonItem.h) && Intrinsics.areEqual(this.i, expandSectionsButtonItem.i) && Intrinsics.areEqual(this.j, expandSectionsButtonItem.j) && this.k == expandSectionsButtonItem.k;
    }

    @Override // com.avito.android.section.action.SectionActionItem
    @Nullable
    public Action getAction() {
        return this.g;
    }

    @NotNull
    public final List<PersistableSpannedItem> getCollapsedSections() {
        return this.j;
    }

    @Nullable
    public final String getExpandButtonTitle() {
        return this.i;
    }

    @Override // com.avito.android.serp.adapter.PersistableSerpItem
    public boolean getHasStablePosition() {
        return SectionTitleItem.DefaultImpls.getHasStablePosition(this);
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return SectionTitleItem.DefaultImpls.getId(this);
    }

    @NotNull
    public final SectionTitleWithActionItem getItem() {
        return this.h;
    }

    @Override // com.avito.android.serp.adapter.SpannedItem
    public int getSpanCount() {
        return this.a;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.b;
    }

    @Override // com.avito.android.section.title.SectionTitleItem
    @Nullable
    public String getSubtitle() {
        return this.d;
    }

    @Override // com.avito.android.section.title.SectionTitleItem
    @Nullable
    public String getTitle() {
        return this.c;
    }

    @Override // com.avito.android.serp.adapter.ViewTypeSerpItem
    @NotNull
    public SerpViewType getViewType() {
        return this.f;
    }

    @Override // java.lang.Object
    public int hashCode() {
        SectionTitleWithActionItem sectionTitleWithActionItem = this.h;
        int i2 = 0;
        int hashCode = (sectionTitleWithActionItem != null ? sectionTitleWithActionItem.hashCode() : 0) * 31;
        String str = this.i;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        List<PersistableSpannedItem> list = this.j;
        if (list != null) {
            i2 = list.hashCode();
        }
        int i3 = (hashCode2 + i2) * 31;
        boolean z = this.k;
        if (z) {
            z = true;
        }
        int i4 = z ? 1 : 0;
        int i5 = z ? 1 : 0;
        int i6 = z ? 1 : 0;
        return i3 + i4;
    }

    public final boolean isExpanded() {
        return this.k;
    }

    @Override // com.avito.android.serp.adapter.PersistableSerpItem
    public boolean isExternalAd() {
        return this.e;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("ExpandSectionsButtonItem(item=");
        L.append(this.h);
        L.append(", expandButtonTitle=");
        L.append(this.i);
        L.append(", collapsedSections=");
        L.append(this.j);
        L.append(", isExpanded=");
        return a.B(L, this.k, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i2) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.h.writeToParcel(parcel, 0);
        parcel.writeString(this.i);
        Iterator n0 = a.n0(this.j, parcel);
        while (n0.hasNext()) {
            parcel.writeParcelable((PersistableSpannedItem) n0.next(), i2);
        }
        parcel.writeInt(this.k ? 1 : 0);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ExpandSectionsButtonItem(SectionTitleWithActionItem sectionTitleWithActionItem, String str, List list, boolean z, int i2, j jVar) {
        this(sectionTitleWithActionItem, str, list, (i2 & 8) != 0 ? str == null : z);
    }
}
