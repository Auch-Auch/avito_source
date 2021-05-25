package com.avito.android.beduin.core.model;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.avito.android.remote.model.ProfileTab;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B9\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b'\u0010(J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004JL\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u0014J \u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001f\u0010 R\u001b\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010!\u001a\u0004\b\"\u0010\u0004R\u001b\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010!\u001a\u0004\b#\u0010\u0004R\u001b\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010!\u001a\u0004\b$\u0010\u0004R\u001b\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010!\u001a\u0004\b%\u0010\u0004R\u001b\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010!\u001a\u0004\b&\u0010\u0004¨\u0006)"}, d2 = {"Lcom/avito/android/beduin/core/model/BedionContainerIndent;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/Integer;", "component2", "component3", "component4", "component5", "top", "bottom", ViewHierarchyConstants.DIMENSION_LEFT_KEY, "right", ProfileTab.ALL, "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/avito/android/beduin/core/model/BedionContainerIndent;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/Integer;", "getAll", "getRight", "getLeft", "getBottom", "getTop", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "beduin_release"}, k = 1, mv = {1, 4, 2})
public final class BedionContainerIndent implements Parcelable {
    public static final Parcelable.Creator<BedionContainerIndent> CREATOR = new Creator();
    @Nullable
    private final Integer all;
    @Nullable
    private final Integer bottom;
    @Nullable
    private final Integer left;
    @Nullable
    private final Integer right;
    @Nullable
    private final Integer top;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<BedionContainerIndent> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BedionContainerIndent createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new BedionContainerIndent(parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null, parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null, parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null, parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null, parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BedionContainerIndent[] newArray(int i) {
            return new BedionContainerIndent[i];
        }
    }

    public BedionContainerIndent(@Nullable Integer num, @Nullable Integer num2, @Nullable Integer num3, @Nullable Integer num4, @Nullable Integer num5) {
        this.top = num;
        this.bottom = num2;
        this.left = num3;
        this.right = num4;
        this.all = num5;
    }

    public static /* synthetic */ BedionContainerIndent copy$default(BedionContainerIndent bedionContainerIndent, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, int i, Object obj) {
        if ((i & 1) != 0) {
            num = bedionContainerIndent.top;
        }
        if ((i & 2) != 0) {
            num2 = bedionContainerIndent.bottom;
        }
        if ((i & 4) != 0) {
            num3 = bedionContainerIndent.left;
        }
        if ((i & 8) != 0) {
            num4 = bedionContainerIndent.right;
        }
        if ((i & 16) != 0) {
            num5 = bedionContainerIndent.all;
        }
        return bedionContainerIndent.copy(num, num2, num3, num4, num5);
    }

    @Nullable
    public final Integer component1() {
        return this.top;
    }

    @Nullable
    public final Integer component2() {
        return this.bottom;
    }

    @Nullable
    public final Integer component3() {
        return this.left;
    }

    @Nullable
    public final Integer component4() {
        return this.right;
    }

    @Nullable
    public final Integer component5() {
        return this.all;
    }

    @NotNull
    public final BedionContainerIndent copy(@Nullable Integer num, @Nullable Integer num2, @Nullable Integer num3, @Nullable Integer num4, @Nullable Integer num5) {
        return new BedionContainerIndent(num, num2, num3, num4, num5);
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
        if (!(obj instanceof BedionContainerIndent)) {
            return false;
        }
        BedionContainerIndent bedionContainerIndent = (BedionContainerIndent) obj;
        return Intrinsics.areEqual(this.top, bedionContainerIndent.top) && Intrinsics.areEqual(this.bottom, bedionContainerIndent.bottom) && Intrinsics.areEqual(this.left, bedionContainerIndent.left) && Intrinsics.areEqual(this.right, bedionContainerIndent.right) && Intrinsics.areEqual(this.all, bedionContainerIndent.all);
    }

    @Nullable
    public final Integer getAll() {
        return this.all;
    }

    @Nullable
    public final Integer getBottom() {
        return this.bottom;
    }

    @Nullable
    public final Integer getLeft() {
        return this.left;
    }

    @Nullable
    public final Integer getRight() {
        return this.right;
    }

    @Nullable
    public final Integer getTop() {
        return this.top;
    }

    @Override // java.lang.Object
    public int hashCode() {
        Integer num = this.top;
        int i = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 31;
        Integer num2 = this.bottom;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 31;
        Integer num3 = this.left;
        int hashCode3 = (hashCode2 + (num3 != null ? num3.hashCode() : 0)) * 31;
        Integer num4 = this.right;
        int hashCode4 = (hashCode3 + (num4 != null ? num4.hashCode() : 0)) * 31;
        Integer num5 = this.all;
        if (num5 != null) {
            i = num5.hashCode();
        }
        return hashCode4 + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("BedionContainerIndent(top=");
        L.append(this.top);
        L.append(", bottom=");
        L.append(this.bottom);
        L.append(", left=");
        L.append(this.left);
        L.append(", right=");
        L.append(this.right);
        L.append(", all=");
        return a.p(L, this.all, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        Integer num = this.top;
        if (num != null) {
            a.H0(parcel, 1, num);
        } else {
            parcel.writeInt(0);
        }
        Integer num2 = this.bottom;
        if (num2 != null) {
            a.H0(parcel, 1, num2);
        } else {
            parcel.writeInt(0);
        }
        Integer num3 = this.left;
        if (num3 != null) {
            a.H0(parcel, 1, num3);
        } else {
            parcel.writeInt(0);
        }
        Integer num4 = this.right;
        if (num4 != null) {
            a.H0(parcel, 1, num4);
        } else {
            parcel.writeInt(0);
        }
        Integer num5 = this.all;
        if (num5 != null) {
            a.H0(parcel, 1, num5);
        } else {
            parcel.writeInt(0);
        }
    }
}
