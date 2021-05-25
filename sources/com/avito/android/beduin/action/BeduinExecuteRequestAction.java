package com.avito.android.beduin.action;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import androidx.browser.trusted.sharing.ShareTarget;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.beduin.core.action.BeduinAction;
import com.avito.android.beduin.core.action.BeduinActionType;
import com.avito.android.beduin.core.common.BeduinApiTypeName;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.android.persistence.messenger.MessageMetaInfo;
import t6.r.a.j;
@Parcelize
@Keep
@BeduinApiTypeName(types = {"executeRequest"})
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\b\b\u0018\u00002\u00020\u0001:\u0001.B7\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\b\u0012\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u000b¢\u0006\u0004\b,\u0010-J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u001e\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJF\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\b2\u0016\b\u0002\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u000bHÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0014\u0010\nJ\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u0017J \u0010\"\u001a\u00020!2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\"\u0010#R\u0019\u0010\u0010\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010$\u001a\u0004\b%\u0010\nR\u0019\u0010\u000f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010&\u001a\u0004\b'\u0010\u0007R\u001c\u0010\u000e\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000e\u0010(\u001a\u0004\b)\u0010\u0004R'\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010*\u001a\u0004\b+\u0010\r¨\u0006/"}, d2 = {"Lcom/avito/android/beduin/action/BeduinExecuteRequestAction;", "Lcom/avito/android/beduin/core/action/BeduinAction;", "Lcom/avito/android/beduin/core/action/BeduinActionType;", "component1", "()Lcom/avito/android/beduin/core/action/BeduinActionType;", "Lcom/avito/android/beduin/action/BeduinExecuteRequestAction$HttpMethod;", "component2", "()Lcom/avito/android/beduin/action/BeduinExecuteRequestAction$HttpMethod;", "", "component3", "()Ljava/lang/String;", "", "component4", "()Ljava/util/Map;", "actionType", "method", MessageMetaInfo.COLUMN_PATH, ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT, "copy", "(Lcom/avito/android/beduin/core/action/BeduinActionType;Lcom/avito/android/beduin/action/BeduinExecuteRequestAction$HttpMethod;Ljava/lang/String;Ljava/util/Map;)Lcom/avito/android/beduin/action/BeduinExecuteRequestAction;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getPath", "Lcom/avito/android/beduin/action/BeduinExecuteRequestAction$HttpMethod;", "getMethod", "Lcom/avito/android/beduin/core/action/BeduinActionType;", "getActionType", "Ljava/util/Map;", "getParameters", "<init>", "(Lcom/avito/android/beduin/core/action/BeduinActionType;Lcom/avito/android/beduin/action/BeduinExecuteRequestAction$HttpMethod;Ljava/lang/String;Ljava/util/Map;)V", "HttpMethod", "beduin_release"}, k = 1, mv = {1, 4, 2})
public final class BeduinExecuteRequestAction implements BeduinAction {
    public static final Parcelable.Creator<BeduinExecuteRequestAction> CREATOR = new Creator();
    @NotNull
    private final BeduinActionType actionType;
    @NotNull
    private final HttpMethod method;
    @Nullable
    private final Map<String, String> parameters;
    @NotNull
    private final String path;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<BeduinExecuteRequestAction> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BeduinExecuteRequestAction createFromParcel(@NotNull Parcel parcel) {
            LinkedHashMap linkedHashMap;
            Intrinsics.checkNotNullParameter(parcel, "in");
            BeduinActionType beduinActionType = (BeduinActionType) Enum.valueOf(BeduinActionType.class, parcel.readString());
            HttpMethod httpMethod = (HttpMethod) Enum.valueOf(HttpMethod.class, parcel.readString());
            String readString = parcel.readString();
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                linkedHashMap = new LinkedHashMap(readInt);
                while (readInt != 0) {
                    readInt = a.U(parcel, linkedHashMap, parcel.readString(), readInt, -1);
                }
            } else {
                linkedHashMap = null;
            }
            return new BeduinExecuteRequestAction(beduinActionType, httpMethod, readString, linkedHashMap);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BeduinExecuteRequestAction[] newArray(int i) {
            return new BeduinExecuteRequestAction[i];
        }
    }

    @Keep
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/beduin/action/BeduinExecuteRequestAction$HttpMethod;", "", "<init>", "(Ljava/lang/String;I)V", ShareTarget.METHOD_POST, ShareTarget.METHOD_GET, "DELETE", "PUT", "beduin_release"}, k = 1, mv = {1, 4, 2})
    public enum HttpMethod {
        POST,
        GET,
        DELETE,
        PUT
    }

    public BeduinExecuteRequestAction(@NotNull BeduinActionType beduinActionType, @NotNull HttpMethod httpMethod, @NotNull String str, @Nullable Map<String, String> map) {
        Intrinsics.checkNotNullParameter(beduinActionType, "actionType");
        Intrinsics.checkNotNullParameter(httpMethod, "method");
        Intrinsics.checkNotNullParameter(str, MessageMetaInfo.COLUMN_PATH);
        this.actionType = beduinActionType;
        this.method = httpMethod;
        this.path = str;
        this.parameters = map;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.beduin.action.BeduinExecuteRequestAction */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BeduinExecuteRequestAction copy$default(BeduinExecuteRequestAction beduinExecuteRequestAction, BeduinActionType beduinActionType, HttpMethod httpMethod, String str, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            beduinActionType = beduinExecuteRequestAction.getActionType();
        }
        if ((i & 2) != 0) {
            httpMethod = beduinExecuteRequestAction.method;
        }
        if ((i & 4) != 0) {
            str = beduinExecuteRequestAction.path;
        }
        if ((i & 8) != 0) {
            map = beduinExecuteRequestAction.parameters;
        }
        return beduinExecuteRequestAction.copy(beduinActionType, httpMethod, str, map);
    }

    @NotNull
    public final BeduinActionType component1() {
        return getActionType();
    }

    @NotNull
    public final HttpMethod component2() {
        return this.method;
    }

    @NotNull
    public final String component3() {
        return this.path;
    }

    @Nullable
    public final Map<String, String> component4() {
        return this.parameters;
    }

    @NotNull
    public final BeduinExecuteRequestAction copy(@NotNull BeduinActionType beduinActionType, @NotNull HttpMethod httpMethod, @NotNull String str, @Nullable Map<String, String> map) {
        Intrinsics.checkNotNullParameter(beduinActionType, "actionType");
        Intrinsics.checkNotNullParameter(httpMethod, "method");
        Intrinsics.checkNotNullParameter(str, MessageMetaInfo.COLUMN_PATH);
        return new BeduinExecuteRequestAction(beduinActionType, httpMethod, str, map);
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
        if (!(obj instanceof BeduinExecuteRequestAction)) {
            return false;
        }
        BeduinExecuteRequestAction beduinExecuteRequestAction = (BeduinExecuteRequestAction) obj;
        return Intrinsics.areEqual(getActionType(), beduinExecuteRequestAction.getActionType()) && Intrinsics.areEqual(this.method, beduinExecuteRequestAction.method) && Intrinsics.areEqual(this.path, beduinExecuteRequestAction.path) && Intrinsics.areEqual(this.parameters, beduinExecuteRequestAction.parameters);
    }

    @Override // com.avito.android.beduin.core.action.BeduinAction
    @NotNull
    public BeduinActionType getActionType() {
        return this.actionType;
    }

    @NotNull
    public final HttpMethod getMethod() {
        return this.method;
    }

    @Nullable
    public final Map<String, String> getParameters() {
        return this.parameters;
    }

    @NotNull
    public final String getPath() {
        return this.path;
    }

    @Override // java.lang.Object
    public int hashCode() {
        BeduinActionType actionType2 = getActionType();
        int i = 0;
        int hashCode = (actionType2 != null ? actionType2.hashCode() : 0) * 31;
        HttpMethod httpMethod = this.method;
        int hashCode2 = (hashCode + (httpMethod != null ? httpMethod.hashCode() : 0)) * 31;
        String str = this.path;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        Map<String, String> map = this.parameters;
        if (map != null) {
            i = map.hashCode();
        }
        return hashCode3 + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("BeduinExecuteRequestAction(actionType=");
        L.append(getActionType());
        L.append(", method=");
        L.append(this.method);
        L.append(", path=");
        L.append(this.path);
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
            com.avito.android.beduin.core.action.BeduinActionType r4 = r2.actionType
            java.lang.String r4 = r4.name()
            r3.writeString(r4)
            com.avito.android.beduin.action.BeduinExecuteRequestAction$HttpMethod r4 = r2.method
            java.lang.String r4 = r4.name()
            r3.writeString(r4)
            java.lang.String r4 = r2.path
            r3.writeString(r4)
            java.util.Map<java.lang.String, java.lang.String> r4 = r2.parameters
            if (r4 == 0) goto L_0x0042
            r0 = 1
            java.util.Iterator r4 = a2.b.a.a.a.m0(r3, r0, r4)
        L_0x0025:
            boolean r0 = r4.hasNext()
            if (r0 == 0) goto L_0x0046
            java.lang.Object r0 = r4.next()
            java.lang.Object r1 = r0.getKey()
            java.lang.String r1 = (java.lang.String) r1
            r3.writeString(r1)
            java.lang.Object r0 = r0.getValue()
            java.lang.String r0 = (java.lang.String) r0
            r3.writeString(r0)
            goto L_0x0025
        L_0x0042:
            r4 = 0
            r3.writeInt(r4)
        L_0x0046:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.beduin.action.BeduinExecuteRequestAction.writeToParcel(android.os.Parcel, int):void");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BeduinExecuteRequestAction(BeduinActionType beduinActionType, HttpMethod httpMethod, String str, Map map, int i, j jVar) {
        this((i & 1) != 0 ? BeduinActionType.ON_CLICK : beduinActionType, httpMethod, str, map);
    }
}
