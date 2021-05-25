package com.avito.android.remote.model;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.analytics.screens.InternalConstsKt;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0004\b'\u0010(J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0018\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\t\u0010\nJB\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0004J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u0014J \u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u001f\u0010 R$\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000e\u0010!\u001a\u0004\b\"\u0010\nR\u001c\u0010\f\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010#\u001a\u0004\b$\u0010\u0004R\u001c\u0010\u000b\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000b\u0010#\u001a\u0004\b%\u0010\u0004R\u001e\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010#\u001a\u0004\b&\u0010\u0004¨\u0006)"}, d2 = {"Lcom/avito/android/remote/model/ReasonRds;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "", "Lcom/avito/android/remote/model/Option;", "component4", "()Ljava/util/List;", "id", "title", InternalConstsKt.PLACEHOLDER, "options", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)Lcom/avito/android/remote/model/ReasonRds;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/util/List;", "getOptions", "Ljava/lang/String;", "getTitle", "getId", "getPlaceholder", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class ReasonRds implements Parcelable {
    public static final Parcelable.Creator<ReasonRds> CREATOR = new Creator();
    @SerializedName("id")
    @NotNull
    private final String id;
    @SerializedName("options")
    @Nullable
    private final List<Option> options;
    @SerializedName(InternalConstsKt.PLACEHOLDER)
    @Nullable
    private final String placeholder;
    @SerializedName("title")
    @NotNull
    private final String title;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<ReasonRds> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ReasonRds createFromParcel(@NotNull Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList.add(Option.CREATOR.createFromParcel(parcel));
                    readInt--;
                }
            } else {
                arrayList = null;
            }
            return new ReasonRds(readString, readString2, readString3, arrayList);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ReasonRds[] newArray(int i) {
            return new ReasonRds[i];
        }
    }

    public ReasonRds(@NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable List<Option> list) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "title");
        this.id = str;
        this.title = str2;
        this.placeholder = str3;
        this.options = list;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.remote.model.ReasonRds */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ReasonRds copy$default(ReasonRds reasonRds, String str, String str2, String str3, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = reasonRds.id;
        }
        if ((i & 2) != 0) {
            str2 = reasonRds.title;
        }
        if ((i & 4) != 0) {
            str3 = reasonRds.placeholder;
        }
        if ((i & 8) != 0) {
            list = reasonRds.options;
        }
        return reasonRds.copy(str, str2, str3, list);
    }

    @NotNull
    public final String component1() {
        return this.id;
    }

    @NotNull
    public final String component2() {
        return this.title;
    }

    @Nullable
    public final String component3() {
        return this.placeholder;
    }

    @Nullable
    public final List<Option> component4() {
        return this.options;
    }

    @NotNull
    public final ReasonRds copy(@NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable List<Option> list) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "title");
        return new ReasonRds(str, str2, str3, list);
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
        if (!(obj instanceof ReasonRds)) {
            return false;
        }
        ReasonRds reasonRds = (ReasonRds) obj;
        return Intrinsics.areEqual(this.id, reasonRds.id) && Intrinsics.areEqual(this.title, reasonRds.title) && Intrinsics.areEqual(this.placeholder, reasonRds.placeholder) && Intrinsics.areEqual(this.options, reasonRds.options);
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @Nullable
    public final List<Option> getOptions() {
        return this.options;
    }

    @Nullable
    public final String getPlaceholder() {
        return this.placeholder;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.id;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.title;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.placeholder;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        List<Option> list = this.options;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode3 + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("ReasonRds(id=");
        L.append(this.id);
        L.append(", title=");
        L.append(this.title);
        L.append(", placeholder=");
        L.append(this.placeholder);
        L.append(", options=");
        return a.w(L, this.options, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.id);
        parcel.writeString(this.title);
        parcel.writeString(this.placeholder);
        List<Option> list = this.options;
        if (list != null) {
            Iterator l0 = a.l0(parcel, 1, list);
            while (l0.hasNext()) {
                ((Option) l0.next()).writeToParcel(parcel, 0);
            }
            return;
        }
        parcel.writeInt(0);
    }
}
