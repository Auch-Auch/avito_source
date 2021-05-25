package com.avito.android.remote.model;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.google.gson.annotations.SerializedName;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0004\b#\u0010$J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u001e\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ<\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00022\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0004J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0004J \u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dR\u001c\u0010\n\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\n\u0010\u001e\u001a\u0004\b\u001f\u0010\u0004R\u001c\u0010\u000b\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u001e\u001a\u0004\b \u0010\u0004R*\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010!\u001a\u0004\b\"\u0010\t¨\u0006%"}, d2 = {"Lcom/avito/android/remote/model/ParametrizedEvent;", "Landroid/os/Parcelable;", "", "component1", "()I", "component2", "", "", "component3", "()Ljava/util/Map;", "id", "version", ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT, "copy", "(IILjava/util/Map;)Lcom/avito/android/remote/model/ParametrizedEvent;", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "I", "getId", "getVersion", "Ljava/util/Map;", "getParameters", "<init>", "(IILjava/util/Map;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class ParametrizedEvent implements Parcelable {
    public static final Parcelable.Creator<ParametrizedEvent> CREATOR = new Creator();
    @SerializedName("id")
    private final int id;
    @SerializedName(ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT)
    @Nullable
    private final Map<String, String> parameters;
    @SerializedName("version")
    private final int version;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<ParametrizedEvent> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ParametrizedEvent createFromParcel(@NotNull Parcel parcel) {
            LinkedHashMap linkedHashMap;
            Intrinsics.checkNotNullParameter(parcel, "in");
            int readInt = parcel.readInt();
            int readInt2 = parcel.readInt();
            if (parcel.readInt() != 0) {
                int readInt3 = parcel.readInt();
                linkedHashMap = new LinkedHashMap(readInt3);
                while (readInt3 != 0) {
                    readInt3 = a.U(parcel, linkedHashMap, parcel.readString(), readInt3, -1);
                }
            } else {
                linkedHashMap = null;
            }
            return new ParametrizedEvent(readInt, readInt2, linkedHashMap);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ParametrizedEvent[] newArray(int i) {
            return new ParametrizedEvent[i];
        }
    }

    public ParametrizedEvent(int i, int i2, @Nullable Map<String, String> map) {
        this.id = i;
        this.version = i2;
        this.parameters = map;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.remote.model.ParametrizedEvent */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ParametrizedEvent copy$default(ParametrizedEvent parametrizedEvent, int i, int i2, Map map, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = parametrizedEvent.id;
        }
        if ((i3 & 2) != 0) {
            i2 = parametrizedEvent.version;
        }
        if ((i3 & 4) != 0) {
            map = parametrizedEvent.parameters;
        }
        return parametrizedEvent.copy(i, i2, map);
    }

    public final int component1() {
        return this.id;
    }

    public final int component2() {
        return this.version;
    }

    @Nullable
    public final Map<String, String> component3() {
        return this.parameters;
    }

    @NotNull
    public final ParametrizedEvent copy(int i, int i2, @Nullable Map<String, String> map) {
        return new ParametrizedEvent(i, i2, map);
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
        if (!(obj instanceof ParametrizedEvent)) {
            return false;
        }
        ParametrizedEvent parametrizedEvent = (ParametrizedEvent) obj;
        return this.id == parametrizedEvent.id && this.version == parametrizedEvent.version && Intrinsics.areEqual(this.parameters, parametrizedEvent.parameters);
    }

    public final int getId() {
        return this.id;
    }

    @Nullable
    public final Map<String, String> getParameters() {
        return this.parameters;
    }

    public final int getVersion() {
        return this.version;
    }

    @Override // java.lang.Object
    public int hashCode() {
        int i = ((this.id * 31) + this.version) * 31;
        Map<String, String> map = this.parameters;
        return i + (map != null ? map.hashCode() : 0);
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("ParametrizedEvent(id=");
        L.append(this.id);
        L.append(", version=");
        L.append(this.version);
        L.append(", parameters=");
        return a.x(L, this.parameters, ")");
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.Map$Entry, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // android.os.Parcelable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void writeToParcel(@org.jetbrains.annotations.NotNull android.os.Parcel r3, int r4) {
        /*
            r2 = this;
            java.lang.String r4 = "parcel"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r4)
            int r4 = r2.id
            r3.writeInt(r4)
            int r4 = r2.version
            r3.writeInt(r4)
            java.util.Map<java.lang.String, java.lang.String> r4 = r2.parameters
            if (r4 == 0) goto L_0x0035
            r0 = 1
            java.util.Iterator r4 = a2.b.a.a.a.m0(r3, r0, r4)
        L_0x0018:
            boolean r0 = r4.hasNext()
            if (r0 == 0) goto L_0x0039
            java.lang.Object r0 = r4.next()
            java.lang.Object r1 = r0.getKey()
            java.lang.String r1 = (java.lang.String) r1
            r3.writeString(r1)
            java.lang.Object r0 = r0.getValue()
            java.lang.String r0 = (java.lang.String) r0
            r3.writeString(r0)
            goto L_0x0018
        L_0x0035:
            r4 = 0
            r3.writeInt(r4)
        L_0x0039:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.remote.model.ParametrizedEvent.writeToParcel(android.os.Parcel, int):void");
    }
}
