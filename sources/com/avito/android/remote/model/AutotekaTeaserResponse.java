package com.avito.android.remote.model;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.teaser.TeaserError;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\"\u0010#J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J(\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0011J \u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dR\u001e\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\b\u0010\u001e\u001a\u0004\b\u001f\u0010\u0004R\u001e\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010 \u001a\u0004\b!\u0010\u0007¨\u0006$"}, d2 = {"Lcom/avito/android/remote/model/AutotekaTeaserResponse;", "Landroid/os/Parcelable;", "Lcom/avito/android/remote/model/AutotekaTeaserResult;", "component1", "()Lcom/avito/android/remote/model/AutotekaTeaserResult;", "Lcom/avito/android/remote/model/teaser/TeaserError;", "component2", "()Lcom/avito/android/remote/model/teaser/TeaserError;", "result", "error", "copy", "(Lcom/avito/android/remote/model/AutotekaTeaserResult;Lcom/avito/android/remote/model/teaser/TeaserError;)Lcom/avito/android/remote/model/AutotekaTeaserResponse;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/AutotekaTeaserResult;", "getResult", "Lcom/avito/android/remote/model/teaser/TeaserError;", "getError", "<init>", "(Lcom/avito/android/remote/model/AutotekaTeaserResult;Lcom/avito/android/remote/model/teaser/TeaserError;)V", "autoteka_release"}, k = 1, mv = {1, 4, 2})
public final class AutotekaTeaserResponse implements Parcelable {
    public static final Parcelable.Creator<AutotekaTeaserResponse> CREATOR = new Creator();
    @SerializedName("error")
    @Nullable
    private final TeaserError error;
    @SerializedName("result")
    @Nullable
    private final AutotekaTeaserResult result;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<AutotekaTeaserResponse> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AutotekaTeaserResponse createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new AutotekaTeaserResponse(parcel.readInt() != 0 ? AutotekaTeaserResult.CREATOR.createFromParcel(parcel) : null, (TeaserError) parcel.readParcelable(AutotekaTeaserResponse.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AutotekaTeaserResponse[] newArray(int i) {
            return new AutotekaTeaserResponse[i];
        }
    }

    public AutotekaTeaserResponse(@Nullable AutotekaTeaserResult autotekaTeaserResult, @Nullable TeaserError teaserError) {
        this.result = autotekaTeaserResult;
        this.error = teaserError;
    }

    public static /* synthetic */ AutotekaTeaserResponse copy$default(AutotekaTeaserResponse autotekaTeaserResponse, AutotekaTeaserResult autotekaTeaserResult, TeaserError teaserError, int i, Object obj) {
        if ((i & 1) != 0) {
            autotekaTeaserResult = autotekaTeaserResponse.result;
        }
        if ((i & 2) != 0) {
            teaserError = autotekaTeaserResponse.error;
        }
        return autotekaTeaserResponse.copy(autotekaTeaserResult, teaserError);
    }

    @Nullable
    public final AutotekaTeaserResult component1() {
        return this.result;
    }

    @Nullable
    public final TeaserError component2() {
        return this.error;
    }

    @NotNull
    public final AutotekaTeaserResponse copy(@Nullable AutotekaTeaserResult autotekaTeaserResult, @Nullable TeaserError teaserError) {
        return new AutotekaTeaserResponse(autotekaTeaserResult, teaserError);
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
        if (!(obj instanceof AutotekaTeaserResponse)) {
            return false;
        }
        AutotekaTeaserResponse autotekaTeaserResponse = (AutotekaTeaserResponse) obj;
        return Intrinsics.areEqual(this.result, autotekaTeaserResponse.result) && Intrinsics.areEqual(this.error, autotekaTeaserResponse.error);
    }

    @Nullable
    public final TeaserError getError() {
        return this.error;
    }

    @Nullable
    public final AutotekaTeaserResult getResult() {
        return this.result;
    }

    @Override // java.lang.Object
    public int hashCode() {
        AutotekaTeaserResult autotekaTeaserResult = this.result;
        int i = 0;
        int hashCode = (autotekaTeaserResult != null ? autotekaTeaserResult.hashCode() : 0) * 31;
        TeaserError teaserError = this.error;
        if (teaserError != null) {
            i = teaserError.hashCode();
        }
        return hashCode + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("AutotekaTeaserResponse(result=");
        L.append(this.result);
        L.append(", error=");
        L.append(this.error);
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        AutotekaTeaserResult autotekaTeaserResult = this.result;
        if (autotekaTeaserResult != null) {
            parcel.writeInt(1);
            autotekaTeaserResult.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeParcelable(this.error, i);
    }
}
