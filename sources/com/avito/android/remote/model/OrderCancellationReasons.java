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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B+\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b'\u0010(J\u0018\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ:\u0010\u000e\u001a\u00020\u00002\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u001a\u0010\u0014J \u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u001f\u0010 R$\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000b\u0010!\u001a\u0004\b\"\u0010\u0005R\u001e\u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010#\u001a\u0004\b$\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010%\u001a\u0004\b&\u0010\u0007¨\u0006)"}, d2 = {"Lcom/avito/android/remote/model/OrderCancellationReasons;", "Landroid/os/Parcelable;", "", "Lcom/avito/android/remote/model/ReasonRds;", "component1", "()Ljava/util/List;", "component2", "()Lcom/avito/android/remote/model/ReasonRds;", "", "component3", "()Ljava/lang/Integer;", "reasons", "otherReason", "commentMaxLength", "copy", "(Ljava/util/List;Lcom/avito/android/remote/model/ReasonRds;Ljava/lang/Integer;)Lcom/avito/android/remote/model/OrderCancellationReasons;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/util/List;", "getReasons", "Ljava/lang/Integer;", "getCommentMaxLength", "Lcom/avito/android/remote/model/ReasonRds;", "getOtherReason", "<init>", "(Ljava/util/List;Lcom/avito/android/remote/model/ReasonRds;Ljava/lang/Integer;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class OrderCancellationReasons implements Parcelable {
    public static final Parcelable.Creator<OrderCancellationReasons> CREATOR = new Creator();
    @SerializedName("commentMaxLength")
    @Nullable
    private final Integer commentMaxLength;
    @SerializedName("otherReason")
    @Nullable
    private final ReasonRds otherReason;
    @SerializedName("reasons")
    @Nullable
    private final List<ReasonRds> reasons;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<OrderCancellationReasons> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final OrderCancellationReasons createFromParcel(@NotNull Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "in");
            Integer num = null;
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList.add(ReasonRds.CREATOR.createFromParcel(parcel));
                    readInt--;
                }
            } else {
                arrayList = null;
            }
            ReasonRds createFromParcel = parcel.readInt() != 0 ? ReasonRds.CREATOR.createFromParcel(parcel) : null;
            if (parcel.readInt() != 0) {
                num = Integer.valueOf(parcel.readInt());
            }
            return new OrderCancellationReasons(arrayList, createFromParcel, num);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final OrderCancellationReasons[] newArray(int i) {
            return new OrderCancellationReasons[i];
        }
    }

    public OrderCancellationReasons(@Nullable List<ReasonRds> list, @Nullable ReasonRds reasonRds, @Nullable Integer num) {
        this.reasons = list;
        this.otherReason = reasonRds;
        this.commentMaxLength = num;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.remote.model.OrderCancellationReasons */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OrderCancellationReasons copy$default(OrderCancellationReasons orderCancellationReasons, List list, ReasonRds reasonRds, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            list = orderCancellationReasons.reasons;
        }
        if ((i & 2) != 0) {
            reasonRds = orderCancellationReasons.otherReason;
        }
        if ((i & 4) != 0) {
            num = orderCancellationReasons.commentMaxLength;
        }
        return orderCancellationReasons.copy(list, reasonRds, num);
    }

    @Nullable
    public final List<ReasonRds> component1() {
        return this.reasons;
    }

    @Nullable
    public final ReasonRds component2() {
        return this.otherReason;
    }

    @Nullable
    public final Integer component3() {
        return this.commentMaxLength;
    }

    @NotNull
    public final OrderCancellationReasons copy(@Nullable List<ReasonRds> list, @Nullable ReasonRds reasonRds, @Nullable Integer num) {
        return new OrderCancellationReasons(list, reasonRds, num);
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
        if (!(obj instanceof OrderCancellationReasons)) {
            return false;
        }
        OrderCancellationReasons orderCancellationReasons = (OrderCancellationReasons) obj;
        return Intrinsics.areEqual(this.reasons, orderCancellationReasons.reasons) && Intrinsics.areEqual(this.otherReason, orderCancellationReasons.otherReason) && Intrinsics.areEqual(this.commentMaxLength, orderCancellationReasons.commentMaxLength);
    }

    @Nullable
    public final Integer getCommentMaxLength() {
        return this.commentMaxLength;
    }

    @Nullable
    public final ReasonRds getOtherReason() {
        return this.otherReason;
    }

    @Nullable
    public final List<ReasonRds> getReasons() {
        return this.reasons;
    }

    @Override // java.lang.Object
    public int hashCode() {
        List<ReasonRds> list = this.reasons;
        int i = 0;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        ReasonRds reasonRds = this.otherReason;
        int hashCode2 = (hashCode + (reasonRds != null ? reasonRds.hashCode() : 0)) * 31;
        Integer num = this.commentMaxLength;
        if (num != null) {
            i = num.hashCode();
        }
        return hashCode2 + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("OrderCancellationReasons(reasons=");
        L.append(this.reasons);
        L.append(", otherReason=");
        L.append(this.otherReason);
        L.append(", commentMaxLength=");
        return a.p(L, this.commentMaxLength, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        List<ReasonRds> list = this.reasons;
        if (list != null) {
            Iterator l0 = a.l0(parcel, 1, list);
            while (l0.hasNext()) {
                ((ReasonRds) l0.next()).writeToParcel(parcel, 0);
            }
        } else {
            parcel.writeInt(0);
        }
        ReasonRds reasonRds = this.otherReason;
        if (reasonRds != null) {
            parcel.writeInt(1);
            reasonRds.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        Integer num = this.commentMaxLength;
        if (num != null) {
            a.H0(parcel, 1, num);
        } else {
            parcel.writeInt(0);
        }
    }
}
