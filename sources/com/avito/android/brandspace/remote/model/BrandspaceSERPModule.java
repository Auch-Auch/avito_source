package com.avito.android.brandspace.remote.model;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.remote.model.Action;
import com.google.gson.annotations.SerializedName;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\r\b\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\b\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b*\u0010+J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u001c\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJH\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\u0014\b\u0002\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0007J\u0010\u0010\u0015\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0004J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001b\u0010\u0004J \u0010 \u001a\u00020\u001f2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b \u0010!R\u001c\u0010\u000e\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\"\u001a\u0004\b#\u0010\u0004R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000f\u0010$\u001a\u0004\b%\u0010\u0007R(\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010&\u001a\u0004\b'\u0010\nR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010(\u001a\u0004\b)\u0010\r¨\u0006,"}, d2 = {"Lcom/avito/android/brandspace/remote/model/BrandspaceSERPModule;", "Lcom/avito/android/brandspace/remote/model/BrandspaceElement;", "", "component1", "()I", "", "component2", "()Ljava/lang/String;", "", "component3", "()Ljava/util/Map;", "Lcom/avito/android/remote/model/Action;", "component4", "()Lcom/avito/android/remote/model/Action;", "version", "title", ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT, "action", "copy", "(ILjava/lang/String;Ljava/util/Map;Lcom/avito/android/remote/model/Action;)Lcom/avito/android/brandspace/remote/model/BrandspaceSERPModule;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "I", "getVersion", "Ljava/lang/String;", "getTitle", "Ljava/util/Map;", "getParameters", "Lcom/avito/android/remote/model/Action;", "getAction", "<init>", "(ILjava/lang/String;Ljava/util/Map;Lcom/avito/android/remote/model/Action;)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public final class BrandspaceSERPModule implements BrandspaceElement {
    public static final Parcelable.Creator<BrandspaceSERPModule> CREATOR = new Creator();
    @SerializedName("action")
    @Nullable
    private final Action action;
    @SerializedName(ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT)
    @NotNull
    private final Map<String, String> parameters;
    @SerializedName("title")
    @Nullable
    private final String title;
    @SerializedName("version")
    private final int version;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<BrandspaceSERPModule> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BrandspaceSERPModule createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            int readInt = parcel.readInt();
            String readString = parcel.readString();
            int readInt2 = parcel.readInt();
            LinkedHashMap linkedHashMap = new LinkedHashMap(readInt2);
            while (readInt2 != 0) {
                readInt2 = a.U(parcel, linkedHashMap, parcel.readString(), readInt2, -1);
            }
            return new BrandspaceSERPModule(readInt, readString, linkedHashMap, (Action) parcel.readParcelable(BrandspaceSERPModule.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BrandspaceSERPModule[] newArray(int i) {
            return new BrandspaceSERPModule[i];
        }
    }

    public BrandspaceSERPModule(int i, @Nullable String str, @NotNull Map<String, String> map, @Nullable Action action2) {
        Intrinsics.checkNotNullParameter(map, ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT);
        this.version = i;
        this.title = str;
        this.parameters = map;
        this.action = action2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.brandspace.remote.model.BrandspaceSERPModule */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BrandspaceSERPModule copy$default(BrandspaceSERPModule brandspaceSERPModule, int i, String str, Map map, Action action2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = brandspaceSERPModule.version;
        }
        if ((i2 & 2) != 0) {
            str = brandspaceSERPModule.title;
        }
        if ((i2 & 4) != 0) {
            map = brandspaceSERPModule.parameters;
        }
        if ((i2 & 8) != 0) {
            action2 = brandspaceSERPModule.action;
        }
        return brandspaceSERPModule.copy(i, str, map, action2);
    }

    public final int component1() {
        return this.version;
    }

    @Nullable
    public final String component2() {
        return this.title;
    }

    @NotNull
    public final Map<String, String> component3() {
        return this.parameters;
    }

    @Nullable
    public final Action component4() {
        return this.action;
    }

    @NotNull
    public final BrandspaceSERPModule copy(int i, @Nullable String str, @NotNull Map<String, String> map, @Nullable Action action2) {
        Intrinsics.checkNotNullParameter(map, ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT);
        return new BrandspaceSERPModule(i, str, map, action2);
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
        if (!(obj instanceof BrandspaceSERPModule)) {
            return false;
        }
        BrandspaceSERPModule brandspaceSERPModule = (BrandspaceSERPModule) obj;
        return this.version == brandspaceSERPModule.version && Intrinsics.areEqual(this.title, brandspaceSERPModule.title) && Intrinsics.areEqual(this.parameters, brandspaceSERPModule.parameters) && Intrinsics.areEqual(this.action, brandspaceSERPModule.action);
    }

    @Nullable
    public final Action getAction() {
        return this.action;
    }

    @NotNull
    public final Map<String, String> getParameters() {
        return this.parameters;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    public final int getVersion() {
        return this.version;
    }

    @Override // java.lang.Object
    public int hashCode() {
        int i = this.version * 31;
        String str = this.title;
        int i2 = 0;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        Map<String, String> map = this.parameters;
        int hashCode2 = (hashCode + (map != null ? map.hashCode() : 0)) * 31;
        Action action2 = this.action;
        if (action2 != null) {
            i2 = action2.hashCode();
        }
        return hashCode2 + i2;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("BrandspaceSERPModule(version=");
        L.append(this.version);
        L.append(", title=");
        L.append(this.title);
        L.append(", parameters=");
        L.append(this.parameters);
        L.append(", action=");
        L.append(this.action);
        L.append(")");
        return L.toString();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Map$Entry, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // android.os.Parcelable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void writeToParcel(@org.jetbrains.annotations.NotNull android.os.Parcel r4, int r5) {
        /*
            r3 = this;
            java.lang.String r0 = "parcel"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            int r0 = r3.version
            r4.writeInt(r0)
            java.lang.String r0 = r3.title
            r4.writeString(r0)
            java.util.Map<java.lang.String, java.lang.String> r0 = r3.parameters
            java.util.Iterator r0 = a2.b.a.a.a.o0(r0, r4)
        L_0x0015:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0032
            java.lang.Object r1 = r0.next()
            java.lang.Object r2 = r1.getKey()
            java.lang.String r2 = (java.lang.String) r2
            r4.writeString(r2)
            java.lang.Object r1 = r1.getValue()
            java.lang.String r1 = (java.lang.String) r1
            r4.writeString(r1)
            goto L_0x0015
        L_0x0032:
            com.avito.android.remote.model.Action r0 = r3.action
            r4.writeParcelable(r0, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.brandspace.remote.model.BrandspaceSERPModule.writeToParcel(android.os.Parcel, int):void");
    }
}
