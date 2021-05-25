package com.avito.android.remote.model.messenger.geo;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.RawJson;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b \u0010!J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u0015\u0010\u000fJ \u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bR\u001c\u0010\b\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0004R\u001c\u0010\t\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010\u001e\u001a\u0004\b\u001f\u0010\u0007¨\u0006\""}, d2 = {"Lcom/avito/android/remote/model/messenger/geo/MarkersRequest;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/RawJson;", "component2", "()Lcom/avito/android/remote/model/RawJson;", "method", "params", "copy", "(Ljava/lang/String;Lcom/avito/android/remote/model/RawJson;)Lcom/avito/android/remote/model/messenger/geo/MarkersRequest;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getMethod", "Lcom/avito/android/remote/model/RawJson;", "getParams", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/RawJson;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class MarkersRequest implements Parcelable {
    public static final Parcelable.Creator<MarkersRequest> CREATOR = new Creator();
    @SerializedName("method")
    @NotNull
    private final String method;
    @SerializedName("params")
    @NotNull
    private final RawJson params;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<MarkersRequest> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final MarkersRequest createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new MarkersRequest(parcel.readString(), RawJson.CREATOR.createFromParcel(parcel));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final MarkersRequest[] newArray(int i) {
            return new MarkersRequest[i];
        }
    }

    public MarkersRequest(@NotNull String str, @NotNull RawJson rawJson) {
        Intrinsics.checkNotNullParameter(str, "method");
        Intrinsics.checkNotNullParameter(rawJson, "params");
        this.method = str;
        this.params = rawJson;
    }

    public static /* synthetic */ MarkersRequest copy$default(MarkersRequest markersRequest, String str, RawJson rawJson, int i, Object obj) {
        if ((i & 1) != 0) {
            str = markersRequest.method;
        }
        if ((i & 2) != 0) {
            rawJson = markersRequest.params;
        }
        return markersRequest.copy(str, rawJson);
    }

    @NotNull
    public final String component1() {
        return this.method;
    }

    @NotNull
    public final RawJson component2() {
        return this.params;
    }

    @NotNull
    public final MarkersRequest copy(@NotNull String str, @NotNull RawJson rawJson) {
        Intrinsics.checkNotNullParameter(str, "method");
        Intrinsics.checkNotNullParameter(rawJson, "params");
        return new MarkersRequest(str, rawJson);
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
        if (!(obj instanceof MarkersRequest)) {
            return false;
        }
        MarkersRequest markersRequest = (MarkersRequest) obj;
        return Intrinsics.areEqual(this.method, markersRequest.method) && Intrinsics.areEqual(this.params, markersRequest.params);
    }

    @NotNull
    public final String getMethod() {
        return this.method;
    }

    @NotNull
    public final RawJson getParams() {
        return this.params;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.method;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        RawJson rawJson = this.params;
        if (rawJson != null) {
            i = rawJson.hashCode();
        }
        return hashCode + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("MarkersRequest(method=");
        L.append(this.method);
        L.append(", params=");
        L.append(this.params);
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.method);
        this.params.writeToParcel(parcel, 0);
    }
}
