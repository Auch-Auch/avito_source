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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0018\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\"\u0010\u0007\u001a\u00020\u00002\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u0014\u0010\u000eJ \u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aR$\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u001b\u001a\u0004\b\u001c\u0010\u0005¨\u0006\u001f"}, d2 = {"Lcom/avito/android/remote/model/ExtendedProfileResult;", "Landroid/os/Parcelable;", "", "Lcom/avito/android/remote/model/ExtendedProfileElement;", "component1", "()Ljava/util/List;", "blocks", "copy", "(Ljava/util/List;)Lcom/avito/android/remote/model/ExtendedProfileResult;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/util/List;", "getBlocks", "<init>", "(Ljava/util/List;)V", "extended-profile_release"}, k = 1, mv = {1, 4, 2})
public final class ExtendedProfileResult implements Parcelable {
    public static final Parcelable.Creator<ExtendedProfileResult> CREATOR = new Creator();
    @SerializedName("blocks")
    @Nullable
    private final List<ExtendedProfileElement> blocks;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<ExtendedProfileResult> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ExtendedProfileResult createFromParcel(@NotNull Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "in");
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList.add((ExtendedProfileElement) parcel.readParcelable(ExtendedProfileResult.class.getClassLoader()));
                    readInt--;
                }
            } else {
                arrayList = null;
            }
            return new ExtendedProfileResult(arrayList);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ExtendedProfileResult[] newArray(int i) {
            return new ExtendedProfileResult[i];
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.util.List<? extends com.avito.android.remote.model.ExtendedProfileElement> */
    /* JADX WARN: Multi-variable type inference failed */
    public ExtendedProfileResult(@Nullable List<? extends ExtendedProfileElement> list) {
        this.blocks = list;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.remote.model.ExtendedProfileResult */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ExtendedProfileResult copy$default(ExtendedProfileResult extendedProfileResult, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = extendedProfileResult.blocks;
        }
        return extendedProfileResult.copy(list);
    }

    @Nullable
    public final List<ExtendedProfileElement> component1() {
        return this.blocks;
    }

    @NotNull
    public final ExtendedProfileResult copy(@Nullable List<? extends ExtendedProfileElement> list) {
        return new ExtendedProfileResult(list);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            return (obj instanceof ExtendedProfileResult) && Intrinsics.areEqual(this.blocks, ((ExtendedProfileResult) obj).blocks);
        }
        return true;
    }

    @Nullable
    public final List<ExtendedProfileElement> getBlocks() {
        return this.blocks;
    }

    @Override // java.lang.Object
    public int hashCode() {
        List<ExtendedProfileElement> list = this.blocks;
        if (list != null) {
            return list.hashCode();
        }
        return 0;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        return a.w(a.L("ExtendedProfileResult(blocks="), this.blocks, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        List<ExtendedProfileElement> list = this.blocks;
        if (list != null) {
            Iterator l0 = a.l0(parcel, 1, list);
            while (l0.hasNext()) {
                parcel.writeParcelable((ExtendedProfileElement) l0.next(), i);
            }
            return;
        }
        parcel.writeInt(0);
    }
}
