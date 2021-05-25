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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\b\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b$\u0010%J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ6\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0004J\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0012J \u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eR\u001c\u0010\n\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\n\u0010\u001f\u001a\u0004\b \u0010\u0004R\"\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010!\u001a\u0004\b\"\u0010\tR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u001f\u001a\u0004\b#\u0010\u0004¨\u0006&"}, d2 = {"Lcom/avito/android/remote/model/VerificationStep;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "component2", "", "Lcom/avito/android/remote/model/VerificationStepType;", "component3", "()Ljava/util/List;", "description", "errorMessage", "types", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)Lcom/avito/android/remote/model/VerificationStep;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getDescription", "Ljava/util/List;", "getTypes", "getErrorMessage", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "api_release"}, k = 1, mv = {1, 4, 2})
public final class VerificationStep implements Parcelable {
    public static final Parcelable.Creator<VerificationStep> CREATOR = new Creator();
    @SerializedName("description")
    @NotNull
    private final String description;
    @SerializedName("errorMessage")
    @Nullable
    private final String errorMessage;
    @SerializedName("types")
    @NotNull
    private final List<VerificationStepType> types;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<VerificationStep> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final VerificationStep createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList.add(VerificationStepType.CREATOR.createFromParcel(parcel));
                readInt--;
            }
            return new VerificationStep(readString, readString2, arrayList);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final VerificationStep[] newArray(int i) {
            return new VerificationStep[i];
        }
    }

    public VerificationStep(@NotNull String str, @Nullable String str2, @NotNull List<VerificationStepType> list) {
        Intrinsics.checkNotNullParameter(str, "description");
        Intrinsics.checkNotNullParameter(list, "types");
        this.description = str;
        this.errorMessage = str2;
        this.types = list;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.remote.model.VerificationStep */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ VerificationStep copy$default(VerificationStep verificationStep, String str, String str2, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = verificationStep.description;
        }
        if ((i & 2) != 0) {
            str2 = verificationStep.errorMessage;
        }
        if ((i & 4) != 0) {
            list = verificationStep.types;
        }
        return verificationStep.copy(str, str2, list);
    }

    @NotNull
    public final String component1() {
        return this.description;
    }

    @Nullable
    public final String component2() {
        return this.errorMessage;
    }

    @NotNull
    public final List<VerificationStepType> component3() {
        return this.types;
    }

    @NotNull
    public final VerificationStep copy(@NotNull String str, @Nullable String str2, @NotNull List<VerificationStepType> list) {
        Intrinsics.checkNotNullParameter(str, "description");
        Intrinsics.checkNotNullParameter(list, "types");
        return new VerificationStep(str, str2, list);
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
        if (!(obj instanceof VerificationStep)) {
            return false;
        }
        VerificationStep verificationStep = (VerificationStep) obj;
        return Intrinsics.areEqual(this.description, verificationStep.description) && Intrinsics.areEqual(this.errorMessage, verificationStep.errorMessage) && Intrinsics.areEqual(this.types, verificationStep.types);
    }

    @NotNull
    public final String getDescription() {
        return this.description;
    }

    @Nullable
    public final String getErrorMessage() {
        return this.errorMessage;
    }

    @NotNull
    public final List<VerificationStepType> getTypes() {
        return this.types;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.description;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.errorMessage;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        List<VerificationStepType> list = this.types;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode2 + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("VerificationStep(description=");
        L.append(this.description);
        L.append(", errorMessage=");
        L.append(this.errorMessage);
        L.append(", types=");
        return a.w(L, this.types, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.description);
        parcel.writeString(this.errorMessage);
        Iterator n0 = a.n0(this.types, parcel);
        while (n0.hasNext()) {
            ((VerificationStepType) n0.next()).writeToParcel(parcel, 0);
        }
    }
}
