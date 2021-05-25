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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\b\b\u0018\u00002\u00020\u0001B+\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b'\u0010(J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ:\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0019\u001a\u00020\t2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u001b\u0010\u0016J \u0010 \u001a\u00020\u001f2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b \u0010!R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\"\u001a\u0004\b\u000e\u0010\u000bR\u001e\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010#\u001a\u0004\b$\u0010\u0004R$\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010%\u001a\u0004\b&\u0010\b¨\u0006)"}, d2 = {"Lcom/avito/android/remote/model/Verification;", "Landroid/os/Parcelable;", "Lcom/avito/android/remote/model/VerificationStatus;", "component1", "()Lcom/avito/android/remote/model/VerificationStatus;", "", "Lcom/avito/android/remote/model/VerificationStep;", "component2", "()Ljava/util/List;", "", "component3", "()Ljava/lang/Boolean;", "status", "steps", "isSupportNeeded", "copy", "(Lcom/avito/android/remote/model/VerificationStatus;Ljava/util/List;Ljava/lang/Boolean;)Lcom/avito/android/remote/model/Verification;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/Boolean;", "Lcom/avito/android/remote/model/VerificationStatus;", "getStatus", "Ljava/util/List;", "getSteps", "<init>", "(Lcom/avito/android/remote/model/VerificationStatus;Ljava/util/List;Ljava/lang/Boolean;)V", "api_release"}, k = 1, mv = {1, 4, 2})
public final class Verification implements Parcelable {
    public static final Parcelable.Creator<Verification> CREATOR = new Creator();
    @SerializedName("isNeedSupport")
    @Nullable
    private final Boolean isSupportNeeded;
    @SerializedName("status")
    @Nullable
    private final VerificationStatus status;
    @SerializedName("steps")
    @Nullable
    private final List<VerificationStep> steps;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<Verification> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final Verification createFromParcel(@NotNull Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "in");
            Boolean bool = null;
            VerificationStatus verificationStatus = parcel.readInt() != 0 ? (VerificationStatus) Enum.valueOf(VerificationStatus.class, parcel.readString()) : null;
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList.add(VerificationStep.CREATOR.createFromParcel(parcel));
                    readInt--;
                }
            } else {
                arrayList = null;
            }
            if (parcel.readInt() != 0) {
                bool = Boolean.valueOf(parcel.readInt() != 0);
            }
            return new Verification(verificationStatus, arrayList, bool);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final Verification[] newArray(int i) {
            return new Verification[i];
        }
    }

    public Verification(@Nullable VerificationStatus verificationStatus, @Nullable List<VerificationStep> list, @Nullable Boolean bool) {
        this.status = verificationStatus;
        this.steps = list;
        this.isSupportNeeded = bool;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.remote.model.Verification */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Verification copy$default(Verification verification, VerificationStatus verificationStatus, List list, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            verificationStatus = verification.status;
        }
        if ((i & 2) != 0) {
            list = verification.steps;
        }
        if ((i & 4) != 0) {
            bool = verification.isSupportNeeded;
        }
        return verification.copy(verificationStatus, list, bool);
    }

    @Nullable
    public final VerificationStatus component1() {
        return this.status;
    }

    @Nullable
    public final List<VerificationStep> component2() {
        return this.steps;
    }

    @Nullable
    public final Boolean component3() {
        return this.isSupportNeeded;
    }

    @NotNull
    public final Verification copy(@Nullable VerificationStatus verificationStatus, @Nullable List<VerificationStep> list, @Nullable Boolean bool) {
        return new Verification(verificationStatus, list, bool);
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
        if (!(obj instanceof Verification)) {
            return false;
        }
        Verification verification = (Verification) obj;
        return Intrinsics.areEqual(this.status, verification.status) && Intrinsics.areEqual(this.steps, verification.steps) && Intrinsics.areEqual(this.isSupportNeeded, verification.isSupportNeeded);
    }

    @Nullable
    public final VerificationStatus getStatus() {
        return this.status;
    }

    @Nullable
    public final List<VerificationStep> getSteps() {
        return this.steps;
    }

    @Override // java.lang.Object
    public int hashCode() {
        VerificationStatus verificationStatus = this.status;
        int i = 0;
        int hashCode = (verificationStatus != null ? verificationStatus.hashCode() : 0) * 31;
        List<VerificationStep> list = this.steps;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
        Boolean bool = this.isSupportNeeded;
        if (bool != null) {
            i = bool.hashCode();
        }
        return hashCode2 + i;
    }

    @Nullable
    public final Boolean isSupportNeeded() {
        return this.isSupportNeeded;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("Verification(status=");
        L.append(this.status);
        L.append(", steps=");
        L.append(this.steps);
        L.append(", isSupportNeeded=");
        return a.o(L, this.isSupportNeeded, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        VerificationStatus verificationStatus = this.status;
        if (verificationStatus != null) {
            parcel.writeInt(1);
            parcel.writeString(verificationStatus.name());
        } else {
            parcel.writeInt(0);
        }
        List<VerificationStep> list = this.steps;
        if (list != null) {
            Iterator l0 = a.l0(parcel, 1, list);
            while (l0.hasNext()) {
                ((VerificationStep) l0.next()).writeToParcel(parcel, 0);
            }
        } else {
            parcel.writeInt(0);
        }
        Boolean bool = this.isSupportNeeded;
        if (bool != null) {
            a.G0(parcel, 1, bool);
        } else {
            parcel.writeInt(0);
        }
    }
}
