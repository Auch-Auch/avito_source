package net.gotev.uploadservice.network;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.io.Serializable;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0016\b\b\u0018\u0000 42\u00020\u00012\u00020\u0002:\u00014B;\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0006\u0012\"\u0010\u0010\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n`\u000b¢\u0006\u0004\b2\u00103J\u0010\u0010\u0004\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ,\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n`\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJJ\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00062$\b\u0002\u0010\u0010\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n`\u000bHÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0005J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u001b\u0010\u0005J \u0010 \u001a\u00020\u001f2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b \u0010!R\u0019\u0010\u000f\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010\bR\u0019\u0010%\u001a\u00020\u00188F@\u0006¢\u0006\f\u0012\u0004\b'\u0010(\u001a\u0004\b%\u0010&R5\u0010\u0010\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n`\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010\rR\u0019\u0010\u000e\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010\u0005R\u0019\u00101\u001a\u00020\n8F@\u0006¢\u0006\f\u0012\u0004\b0\u0010(\u001a\u0004\b/\u0010\u0014¨\u00065"}, d2 = {"Lnet/gotev/uploadservice/network/ServerResponse;", "Landroid/os/Parcelable;", "Ljava/io/Serializable;", "", "component1", "()I", "", "component2", "()[B", "Ljava/util/LinkedHashMap;", "", "Lkotlin/collections/LinkedHashMap;", "component3", "()Ljava/util/LinkedHashMap;", "code", SDKConstants.PARAM_A2U_BODY, "headers", "copy", "(I[BLjava/util/LinkedHashMap;)Lnet/gotev/uploadservice/network/ServerResponse;", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", AuthSource.BOOKING_ORDER, "[B", "getBody", "isSuccessful", "()Z", "isSuccessful$annotations", "()V", "c", "Ljava/util/LinkedHashMap;", "getHeaders", AuthSource.SEND_ABUSE, "I", "getCode", "getBodyString", "getBodyString$annotations", "bodyString", "<init>", "(I[BLjava/util/LinkedHashMap;)V", "Companion", "uploadservice_release"}, k = 1, mv = {1, 4, 0})
public final class ServerResponse implements Parcelable, Serializable {
    public static final Parcelable.Creator CREATOR = new Creator();
    public static final Companion Companion = new Companion(null);
    public final int a;
    @NotNull
    public final byte[] b;
    @NotNull
    public final LinkedHashMap<String, String> c;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lnet/gotev/uploadservice/network/ServerResponse$Companion;", "", "Lnet/gotev/uploadservice/network/ServerResponse;", "successfulEmpty", "()Lnet/gotev/uploadservice/network/ServerResponse;", "<init>", "()V", "uploadservice_release"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final ServerResponse successfulEmpty() {
            return new ServerResponse(200, new byte[1], new LinkedHashMap());
        }

        public Companion(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
    public static class Creator implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final Object createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            int readInt = parcel.readInt();
            byte[] createByteArray = parcel.createByteArray();
            int readInt2 = parcel.readInt();
            LinkedHashMap linkedHashMap = new LinkedHashMap(readInt2);
            while (readInt2 != 0) {
                readInt2 = a.U(parcel, linkedHashMap, parcel.readString(), readInt2, -1);
            }
            return new ServerResponse(readInt, createByteArray, linkedHashMap);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final Object[] newArray(int i) {
            return new ServerResponse[i];
        }
    }

    public ServerResponse(int i, @NotNull byte[] bArr, @NotNull LinkedHashMap<String, String> linkedHashMap) {
        Intrinsics.checkNotNullParameter(bArr, SDKConstants.PARAM_A2U_BODY);
        Intrinsics.checkNotNullParameter(linkedHashMap, "headers");
        this.a = i;
        this.b = bArr;
        this.c = linkedHashMap;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: net.gotev.uploadservice.network.ServerResponse */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ServerResponse copy$default(ServerResponse serverResponse, int i, byte[] bArr, LinkedHashMap linkedHashMap, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = serverResponse.a;
        }
        if ((i2 & 2) != 0) {
            bArr = serverResponse.b;
        }
        if ((i2 & 4) != 0) {
            linkedHashMap = serverResponse.c;
        }
        return serverResponse.copy(i, bArr, linkedHashMap);
    }

    public static /* synthetic */ void getBodyString$annotations() {
    }

    public static /* synthetic */ void isSuccessful$annotations() {
    }

    public final int component1() {
        return this.a;
    }

    @NotNull
    public final byte[] component2() {
        return this.b;
    }

    @NotNull
    public final LinkedHashMap<String, String> component3() {
        return this.c;
    }

    @NotNull
    public final ServerResponse copy(int i, @NotNull byte[] bArr, @NotNull LinkedHashMap<String, String> linkedHashMap) {
        Intrinsics.checkNotNullParameter(bArr, SDKConstants.PARAM_A2U_BODY);
        Intrinsics.checkNotNullParameter(linkedHashMap, "headers");
        return new ServerResponse(i, bArr, linkedHashMap);
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
        if (!(obj instanceof ServerResponse)) {
            return false;
        }
        ServerResponse serverResponse = (ServerResponse) obj;
        return this.a == serverResponse.a && Intrinsics.areEqual(this.b, serverResponse.b) && Intrinsics.areEqual(this.c, serverResponse.c);
    }

    @NotNull
    public final byte[] getBody() {
        return this.b;
    }

    @NotNull
    public final String getBodyString() {
        return new String(this.b, Charsets.UTF_8);
    }

    public final int getCode() {
        return this.a;
    }

    @NotNull
    public final LinkedHashMap<String, String> getHeaders() {
        return this.c;
    }

    @Override // java.lang.Object
    public int hashCode() {
        int i = this.a * 31;
        byte[] bArr = this.b;
        int i2 = 0;
        int hashCode = (i + (bArr != null ? Arrays.hashCode(bArr) : 0)) * 31;
        LinkedHashMap<String, String> linkedHashMap = this.c;
        if (linkedHashMap != null) {
            i2 = linkedHashMap.hashCode();
        }
        return hashCode + i2;
    }

    public final boolean isSuccessful() {
        int i = this.a;
        return 200 <= i && 399 >= i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("ServerResponse(code=");
        L.append(this.a);
        L.append(", body=");
        L.append(Arrays.toString(this.b));
        L.append(", headers=");
        L.append(this.c);
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeInt(this.a);
        parcel.writeByteArray(this.b);
        LinkedHashMap<String, String> linkedHashMap = this.c;
        parcel.writeInt(linkedHashMap.size());
        for (Map.Entry<String, String> entry : linkedHashMap.entrySet()) {
            parcel.writeString(entry.getKey());
            parcel.writeString(entry.getValue());
        }
    }
}
