package com.avito.android.remote.model;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\b\b\u0018\u00002\u00020\u0001:\u0001#B!\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b!\u0010\"J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ.\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0010J \u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cR$\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\n\u0010\u001d\u001a\u0004\b\u001e\u0010\bR\u001e\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010\u001f\u001a\u0004\b \u0010\u0004¨\u0006$"}, d2 = {"Lcom/avito/android/remote/model/ExtendedProfileTextList;", "Lcom/avito/android/remote/model/ExtendedProfileElement;", "", "component1", "()Ljava/lang/String;", "", "Lcom/avito/android/remote/model/ExtendedProfileTextList$Row;", "component2", "()Ljava/util/List;", "title", "rows", "copy", "(Ljava/lang/String;Ljava/util/List;)Lcom/avito/android/remote/model/ExtendedProfileTextList;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/util/List;", "getRows", "Ljava/lang/String;", "getTitle", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "Row", "extended-profile_release"}, k = 1, mv = {1, 4, 2})
public final class ExtendedProfileTextList implements ExtendedProfileElement {
    public static final Parcelable.Creator<ExtendedProfileTextList> CREATOR = new Creator();
    @SerializedName("list")
    @Nullable
    private final List<Row> rows;
    @SerializedName("title")
    @Nullable
    private final String title;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<ExtendedProfileTextList> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ExtendedProfileTextList createFromParcel(@NotNull Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList.add(Row.CREATOR.createFromParcel(parcel));
                    readInt--;
                }
            } else {
                arrayList = null;
            }
            return new ExtendedProfileTextList(readString, arrayList);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ExtendedProfileTextList[] newArray(int i) {
            return new ExtendedProfileTextList[i];
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0011\u0010\u000bJ \u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0005\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004¨\u0006\u001c"}, d2 = {"Lcom/avito/android/remote/model/ExtendedProfileTextList$Row;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "text", "copy", "(Ljava/lang/String;)Lcom/avito/android/remote/model/ExtendedProfileTextList$Row;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getText", "<init>", "(Ljava/lang/String;)V", "extended-profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class Row implements Parcelable {
        public static final Parcelable.Creator<Row> CREATOR = new Creator();
        @SerializedName("row")
        @NotNull
        private final String text;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Row> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Row createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new Row(parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Row[] newArray(int i) {
                return new Row[i];
            }
        }

        public Row(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "text");
            this.text = str;
        }

        public static /* synthetic */ Row copy$default(Row row, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = row.text;
            }
            return row.copy(str);
        }

        @NotNull
        public final String component1() {
            return this.text;
        }

        @NotNull
        public final Row copy(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "text");
            return new Row(str);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // java.lang.Object
        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                return (obj instanceof Row) && Intrinsics.areEqual(this.text, ((Row) obj).text);
            }
            return true;
        }

        @NotNull
        public final String getText() {
            return this.text;
        }

        @Override // java.lang.Object
        public int hashCode() {
            String str = this.text;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            return a.t(a.L("Row(text="), this.text, ")");
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.text);
        }
    }

    public ExtendedProfileTextList(@Nullable String str, @Nullable List<Row> list) {
        this.title = str;
        this.rows = list;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.remote.model.ExtendedProfileTextList */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ExtendedProfileTextList copy$default(ExtendedProfileTextList extendedProfileTextList, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = extendedProfileTextList.title;
        }
        if ((i & 2) != 0) {
            list = extendedProfileTextList.rows;
        }
        return extendedProfileTextList.copy(str, list);
    }

    @Nullable
    public final String component1() {
        return this.title;
    }

    @Nullable
    public final List<Row> component2() {
        return this.rows;
    }

    @NotNull
    public final ExtendedProfileTextList copy(@Nullable String str, @Nullable List<Row> list) {
        return new ExtendedProfileTextList(str, list);
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
        if (!(obj instanceof ExtendedProfileTextList)) {
            return false;
        }
        ExtendedProfileTextList extendedProfileTextList = (ExtendedProfileTextList) obj;
        return Intrinsics.areEqual(this.title, extendedProfileTextList.title) && Intrinsics.areEqual(this.rows, extendedProfileTextList.rows);
    }

    @Nullable
    public final List<Row> getRows() {
        return this.rows;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.title;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        List<Row> list = this.rows;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("ExtendedProfileTextList(title=");
        L.append(this.title);
        L.append(", rows=");
        return a.w(L, this.rows, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.title);
        List<Row> list = this.rows;
        if (list != null) {
            Iterator l0 = a.l0(parcel, 1, list);
            while (l0.hasNext()) {
                ((Row) l0.next()).writeToParcel(parcel, 0);
            }
            return;
        }
        parcel.writeInt(0);
    }
}
