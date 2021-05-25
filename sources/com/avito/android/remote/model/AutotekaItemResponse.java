package com.avito.android.remote.model;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.util.Parcels;
import com.avito.android.util.ParcelsKt;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u000b\b\b\u0018\u0000 #2\u00020\u0001:\u0001#B\u0019\u0012\u0006\u0010\u0011\u001a\u00020\u000b\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b!\u0010\"J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J&\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u000b2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000eHÆ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0004J\u001a\u0010\u001b\u001a\u00020\u000b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cR\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u000e8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u001d\u001a\u0004\b\u001e\u0010\u0010R\u001c\u0010\u0011\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001f\u001a\u0004\b \u0010\r¨\u0006$"}, d2 = {"Lcom/avito/android/remote/model/AutotekaItemResponse;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "dest", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "component1", "()Z", "Lcom/avito/android/remote/model/AutotekaDetailsResponse;", "component2", "()Lcom/avito/android/remote/model/AutotekaDetailsResponse;", "reportAvailable", "report", "copy", "(ZLcom/avito/android/remote/model/AutotekaDetailsResponse;)Lcom/avito/android/remote/model/AutotekaItemResponse;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/avito/android/remote/model/AutotekaDetailsResponse;", "getReport", "Z", "getReportAvailable", "<init>", "(ZLcom/avito/android/remote/model/AutotekaDetailsResponse;)V", "Companion", "autoteka_release"}, k = 1, mv = {1, 4, 2})
public final class AutotekaItemResponse implements Parcelable {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<AutotekaItemResponse> CREATOR = Parcels.creator(AutotekaItemResponse$Companion$CREATOR$1.INSTANCE);
    @NotNull
    public static final Companion Companion = new Companion(null);
    @SerializedName("report")
    @Nullable
    private final AutotekaDetailsResponse report;
    @SerializedName("reportAvailable")
    private final boolean reportAvailable;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/AutotekaItemResponse$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/model/AutotekaItemResponse;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "autoteka_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(j jVar) {
            this();
        }
    }

    public AutotekaItemResponse(boolean z, @Nullable AutotekaDetailsResponse autotekaDetailsResponse) {
        this.reportAvailable = z;
        this.report = autotekaDetailsResponse;
    }

    public static /* synthetic */ AutotekaItemResponse copy$default(AutotekaItemResponse autotekaItemResponse, boolean z, AutotekaDetailsResponse autotekaDetailsResponse, int i, Object obj) {
        if ((i & 1) != 0) {
            z = autotekaItemResponse.reportAvailable;
        }
        if ((i & 2) != 0) {
            autotekaDetailsResponse = autotekaItemResponse.report;
        }
        return autotekaItemResponse.copy(z, autotekaDetailsResponse);
    }

    public final boolean component1() {
        return this.reportAvailable;
    }

    @Nullable
    public final AutotekaDetailsResponse component2() {
        return this.report;
    }

    @NotNull
    public final AutotekaItemResponse copy(boolean z, @Nullable AutotekaDetailsResponse autotekaDetailsResponse) {
        return new AutotekaItemResponse(z, autotekaDetailsResponse);
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
        if (!(obj instanceof AutotekaItemResponse)) {
            return false;
        }
        AutotekaItemResponse autotekaItemResponse = (AutotekaItemResponse) obj;
        return this.reportAvailable == autotekaItemResponse.reportAvailable && Intrinsics.areEqual(this.report, autotekaItemResponse.report);
    }

    @Nullable
    public final AutotekaDetailsResponse getReport() {
        return this.report;
    }

    public final boolean getReportAvailable() {
        return this.reportAvailable;
    }

    @Override // java.lang.Object
    public int hashCode() {
        boolean z = this.reportAvailable;
        if (z) {
            z = true;
        }
        int i = z ? 1 : 0;
        int i2 = z ? 1 : 0;
        int i3 = z ? 1 : 0;
        int i4 = i * 31;
        AutotekaDetailsResponse autotekaDetailsResponse = this.report;
        return i4 + (autotekaDetailsResponse != null ? autotekaDetailsResponse.hashCode() : 0);
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("AutotekaItemResponse(reportAvailable=");
        L.append(this.reportAvailable);
        L.append(", report=");
        L.append(this.report);
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        ParcelsKt.writeBool(parcel, this.reportAvailable);
        parcel.writeParcelable(this.report, i);
    }
}
