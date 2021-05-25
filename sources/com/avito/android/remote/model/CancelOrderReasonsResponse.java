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
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B+\u0012\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0014\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R$\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00148\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lcom/avito/android/remote/model/CancelOrderReasonsResponse;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/Reason;", "otherReason", "Lcom/avito/android/remote/model/Reason;", "getOtherReason", "()Lcom/avito/android/remote/model/Reason;", "commentMaxLength", "Ljava/lang/Integer;", "getCommentMaxLength", "()Ljava/lang/Integer;", "", "reasons", "Ljava/util/List;", "getReasons", "()Ljava/util/List;", "<init>", "(Ljava/util/List;Lcom/avito/android/remote/model/Reason;Ljava/lang/Integer;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class CancelOrderReasonsResponse implements Parcelable {
    public static final Parcelable.Creator<CancelOrderReasonsResponse> CREATOR = new Creator();
    @SerializedName("commentMaxLength")
    @Nullable
    private final Integer commentMaxLength;
    @SerializedName("otherReason")
    @Nullable
    private final Reason otherReason;
    @SerializedName("reasons")
    @Nullable
    private final List<Reason> reasons;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<CancelOrderReasonsResponse> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final CancelOrderReasonsResponse createFromParcel(@NotNull Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "in");
            Integer num = null;
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList.add(Reason.CREATOR.createFromParcel(parcel));
                    readInt--;
                }
            } else {
                arrayList = null;
            }
            Reason createFromParcel = parcel.readInt() != 0 ? Reason.CREATOR.createFromParcel(parcel) : null;
            if (parcel.readInt() != 0) {
                num = Integer.valueOf(parcel.readInt());
            }
            return new CancelOrderReasonsResponse(arrayList, createFromParcel, num);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final CancelOrderReasonsResponse[] newArray(int i) {
            return new CancelOrderReasonsResponse[i];
        }
    }

    public CancelOrderReasonsResponse(@Nullable List<Reason> list, @Nullable Reason reason, @Nullable Integer num) {
        this.reasons = list;
        this.otherReason = reason;
        this.commentMaxLength = num;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final Integer getCommentMaxLength() {
        return this.commentMaxLength;
    }

    @Nullable
    public final Reason getOtherReason() {
        return this.otherReason;
    }

    @Nullable
    public final List<Reason> getReasons() {
        return this.reasons;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        List<Reason> list = this.reasons;
        if (list != null) {
            Iterator l0 = a.l0(parcel, 1, list);
            while (l0.hasNext()) {
                ((Reason) l0.next()).writeToParcel(parcel, 0);
            }
        } else {
            parcel.writeInt(0);
        }
        Reason reason = this.otherReason;
        if (reason != null) {
            parcel.writeInt(1);
            reason.writeToParcel(parcel, 0);
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
