package com.avito.android.remote.model;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.text.AttributedText;
import com.google.gson.annotations.SerializedName;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001:\u0001&B%\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b$\u0010%J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ4\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00022\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0004J\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0012J \u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eR\u001c\u0010\n\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\n\u0010\u001f\u001a\u0004\b \u0010\u0004R\"\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010!\u001a\u0004\b\"\u0010\tR\u001c\u0010\u000b\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u001f\u001a\u0004\b#\u0010\u0004¨\u0006'"}, d2 = {"Lcom/avito/android/remote/model/AdvertsHistory;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "component2", "", "Lcom/avito/android/remote/model/AdvertsHistory$Tab;", "component3", "()Ljava/util/List;", "title", "description", "tabs", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)Lcom/avito/android/remote/model/AdvertsHistory;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getTitle", "Ljava/util/List;", "getTabs", "getDescription", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "Tab", "publish-limits-info_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertsHistory implements Parcelable {
    public static final Parcelable.Creator<AdvertsHistory> CREATOR = new Creator();
    @SerializedName("description")
    @NotNull
    private final String description;
    @SerializedName("tabs")
    @NotNull
    private final List<Tab> tabs;
    @SerializedName("title")
    @NotNull
    private final String title;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<AdvertsHistory> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AdvertsHistory createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList.add(Tab.CREATOR.createFromParcel(parcel));
                readInt--;
            }
            return new AdvertsHistory(readString, readString2, arrayList);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AdvertsHistory[] newArray(int i) {
            return new AdvertsHistory[i];
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\b\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b.\u0010/J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJL\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00052\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\rHÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0004J\u0010\u0010\u0018\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0007J\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u0007J \u0010#\u001a\u00020\"2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b#\u0010$R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0013\u0010%\u001a\u0004\b&\u0010\u0004R\u001c\u0010\u0010\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010%\u001a\u0004\b'\u0010\u0004R\u001c\u0010\u0011\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010(\u001a\u0004\b)\u0010\u0007R\"\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010*\u001a\u0004\b+\u0010\u000bR\u001e\u0010\u0014\u001a\u0004\u0018\u00010\r8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0014\u0010,\u001a\u0004\b-\u0010\u000f¨\u00060"}, d2 = {"Lcom/avito/android/remote/model/AdvertsHistory$Tab;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "", "component2", "()I", "", "Lcom/avito/android/remote/model/AdvertHistoryInfo;", "component3", "()Ljava/util/List;", "component4", "Lcom/avito/android/remote/model/text/AttributedText;", "component5", "()Lcom/avito/android/remote/model/text/AttributedText;", "title", "count", "items", "description", "extra", "copy", "(Ljava/lang/String;ILjava/util/List;Ljava/lang/String;Lcom/avito/android/remote/model/text/AttributedText;)Lcom/avito/android/remote/model/AdvertsHistory$Tab;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getDescription", "getTitle", "I", "getCount", "Ljava/util/List;", "getItems", "Lcom/avito/android/remote/model/text/AttributedText;", "getExtra", "<init>", "(Ljava/lang/String;ILjava/util/List;Ljava/lang/String;Lcom/avito/android/remote/model/text/AttributedText;)V", "publish-limits-info_release"}, k = 1, mv = {1, 4, 2})
    public static final class Tab implements Parcelable {
        public static final Parcelable.Creator<Tab> CREATOR = new Creator();
        @SerializedName("count")
        private final int count;
        @SerializedName("extraDescription")
        @Nullable
        private final String description;
        @SerializedName("extraInfo")
        @Nullable
        private final AttributedText extra;
        @SerializedName("items")
        @NotNull
        private final List<AdvertHistoryInfo> items;
        @SerializedName("title")
        @NotNull
        private final String title;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Tab> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Tab createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                String readString = parcel.readString();
                int readInt = parcel.readInt();
                int readInt2 = parcel.readInt();
                ArrayList arrayList = new ArrayList(readInt2);
                while (readInt2 != 0) {
                    arrayList.add(AdvertHistoryInfo.CREATOR.createFromParcel(parcel));
                    readInt2--;
                }
                return new Tab(readString, readInt, arrayList, parcel.readString(), (AttributedText) parcel.readParcelable(Tab.class.getClassLoader()));
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Tab[] newArray(int i) {
                return new Tab[i];
            }
        }

        public Tab(@NotNull String str, int i, @NotNull List<AdvertHistoryInfo> list, @Nullable String str2, @Nullable AttributedText attributedText) {
            Intrinsics.checkNotNullParameter(str, "title");
            Intrinsics.checkNotNullParameter(list, "items");
            this.title = str;
            this.count = i;
            this.items = list;
            this.description = str2;
            this.extra = attributedText;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.avito.android.remote.model.AdvertsHistory$Tab */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Tab copy$default(Tab tab, String str, int i, List list, String str2, AttributedText attributedText, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = tab.title;
            }
            if ((i2 & 2) != 0) {
                i = tab.count;
            }
            if ((i2 & 4) != 0) {
                list = tab.items;
            }
            if ((i2 & 8) != 0) {
                str2 = tab.description;
            }
            if ((i2 & 16) != 0) {
                attributedText = tab.extra;
            }
            return tab.copy(str, i, list, str2, attributedText);
        }

        @NotNull
        public final String component1() {
            return this.title;
        }

        public final int component2() {
            return this.count;
        }

        @NotNull
        public final List<AdvertHistoryInfo> component3() {
            return this.items;
        }

        @Nullable
        public final String component4() {
            return this.description;
        }

        @Nullable
        public final AttributedText component5() {
            return this.extra;
        }

        @NotNull
        public final Tab copy(@NotNull String str, int i, @NotNull List<AdvertHistoryInfo> list, @Nullable String str2, @Nullable AttributedText attributedText) {
            Intrinsics.checkNotNullParameter(str, "title");
            Intrinsics.checkNotNullParameter(list, "items");
            return new Tab(str, i, list, str2, attributedText);
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
            if (!(obj instanceof Tab)) {
                return false;
            }
            Tab tab = (Tab) obj;
            return Intrinsics.areEqual(this.title, tab.title) && this.count == tab.count && Intrinsics.areEqual(this.items, tab.items) && Intrinsics.areEqual(this.description, tab.description) && Intrinsics.areEqual(this.extra, tab.extra);
        }

        public final int getCount() {
            return this.count;
        }

        @Nullable
        public final String getDescription() {
            return this.description;
        }

        @Nullable
        public final AttributedText getExtra() {
            return this.extra;
        }

        @NotNull
        public final List<AdvertHistoryInfo> getItems() {
            return this.items;
        }

        @NotNull
        public final String getTitle() {
            return this.title;
        }

        @Override // java.lang.Object
        public int hashCode() {
            String str = this.title;
            int i = 0;
            int hashCode = (((str != null ? str.hashCode() : 0) * 31) + this.count) * 31;
            List<AdvertHistoryInfo> list = this.items;
            int hashCode2 = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
            String str2 = this.description;
            int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
            AttributedText attributedText = this.extra;
            if (attributedText != null) {
                i = attributedText.hashCode();
            }
            return hashCode3 + i;
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            StringBuilder L = a.L("Tab(title=");
            L.append(this.title);
            L.append(", count=");
            L.append(this.count);
            L.append(", items=");
            L.append(this.items);
            L.append(", description=");
            L.append(this.description);
            L.append(", extra=");
            L.append(this.extra);
            L.append(")");
            return L.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.title);
            parcel.writeInt(this.count);
            Iterator n0 = a.n0(this.items, parcel);
            while (n0.hasNext()) {
                ((AdvertHistoryInfo) n0.next()).writeToParcel(parcel, 0);
            }
            parcel.writeString(this.description);
            parcel.writeParcelable(this.extra, i);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Tab(String str, int i, List list, String str2, AttributedText attributedText, int i2, j jVar) {
            this(str, i, list, (i2 & 8) != 0 ? null : str2, (i2 & 16) != 0 ? null : attributedText);
        }
    }

    public AdvertsHistory(@NotNull String str, @NotNull String str2, @NotNull List<Tab> list) {
        a.c1(str, "title", str2, "description", list, "tabs");
        this.title = str;
        this.description = str2;
        this.tabs = list;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.remote.model.AdvertsHistory */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AdvertsHistory copy$default(AdvertsHistory advertsHistory, String str, String str2, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = advertsHistory.title;
        }
        if ((i & 2) != 0) {
            str2 = advertsHistory.description;
        }
        if ((i & 4) != 0) {
            list = advertsHistory.tabs;
        }
        return advertsHistory.copy(str, str2, list);
    }

    @NotNull
    public final String component1() {
        return this.title;
    }

    @NotNull
    public final String component2() {
        return this.description;
    }

    @NotNull
    public final List<Tab> component3() {
        return this.tabs;
    }

    @NotNull
    public final AdvertsHistory copy(@NotNull String str, @NotNull String str2, @NotNull List<Tab> list) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "description");
        Intrinsics.checkNotNullParameter(list, "tabs");
        return new AdvertsHistory(str, str2, list);
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
        if (!(obj instanceof AdvertsHistory)) {
            return false;
        }
        AdvertsHistory advertsHistory = (AdvertsHistory) obj;
        return Intrinsics.areEqual(this.title, advertsHistory.title) && Intrinsics.areEqual(this.description, advertsHistory.description) && Intrinsics.areEqual(this.tabs, advertsHistory.tabs);
    }

    @NotNull
    public final String getDescription() {
        return this.description;
    }

    @NotNull
    public final List<Tab> getTabs() {
        return this.tabs;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.title;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.description;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        List<Tab> list = this.tabs;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode2 + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("AdvertsHistory(title=");
        L.append(this.title);
        L.append(", description=");
        L.append(this.description);
        L.append(", tabs=");
        return a.w(L, this.tabs, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.title);
        parcel.writeString(this.description);
        Iterator n0 = a.n0(this.tabs, parcel);
        while (n0.hasNext()) {
            ((Tab) n0.next()).writeToParcel(parcel, 0);
        }
    }
}
