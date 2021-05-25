package com.avito.android.remote.model.messenger.context_actions;

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
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0019\u0012\u0006\u0010\u0019\u001a\u00020\n\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\r\u0010\tJ \u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u00020\n8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/avito/android/remote/model/messenger/context_actions/ItemsRequest;", "Landroid/os/Parcelable;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/RawJson;", "params", "Lcom/avito/android/remote/model/RawJson;", "getParams", "()Lcom/avito/android/remote/model/RawJson;", "method", "Ljava/lang/String;", "getMethod", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/RawJson;)V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
public final class ItemsRequest implements Parcelable {
    public static final Parcelable.Creator<ItemsRequest> CREATOR = new Creator();
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String METHOD = "method";
    @NotNull
    public static final String PARAMS = "params";
    @SerializedName("method")
    @NotNull
    private final String method;
    @SerializedName("params")
    @Nullable
    private final RawJson params;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/messenger/context_actions/ItemsRequest$Companion;", "", "", "METHOD", "Ljava/lang/String;", "PARAMS", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(j jVar) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<ItemsRequest> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ItemsRequest createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new ItemsRequest(parcel.readString(), parcel.readInt() != 0 ? RawJson.CREATOR.createFromParcel(parcel) : null);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ItemsRequest[] newArray(int i) {
            return new ItemsRequest[i];
        }
    }

    public ItemsRequest(@NotNull String str, @Nullable RawJson rawJson) {
        Intrinsics.checkNotNullParameter(str, "method");
        this.method = str;
        this.params = rawJson;
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
        if (!(obj instanceof ItemsRequest)) {
            return false;
        }
        ItemsRequest itemsRequest = (ItemsRequest) obj;
        return !(Intrinsics.areEqual(this.method, itemsRequest.method) ^ true) && !(Intrinsics.areEqual(this.params, itemsRequest.params) ^ true);
    }

    @NotNull
    public final String getMethod() {
        return this.method;
    }

    @Nullable
    public final RawJson getParams() {
        return this.params;
    }

    @Override // java.lang.Object
    public int hashCode() {
        int hashCode = this.method.hashCode() * 31;
        RawJson rawJson = this.params;
        return hashCode + (rawJson != null ? rawJson.hashCode() : 0);
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("ItemsRequest(method='");
        L.append(this.method);
        L.append("', params=");
        L.append(this.params);
        L.append(')');
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.method);
        RawJson rawJson = this.params;
        if (rawJson != null) {
            parcel.writeInt(1);
            rawJson.writeToParcel(parcel, 0);
            return;
        }
        parcel.writeInt(0);
    }
}
