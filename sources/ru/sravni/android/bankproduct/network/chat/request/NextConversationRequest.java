package ru.sravni.android.bankproduct.network.chat.request;

import a2.b.a.a.a;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\f\b\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0006\u0012\u0006\u0010\u000f\u001a\u00020\u0006¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u000b\u0010\nJD\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\u0014\b\u0002\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0012\u0010\nJ\u0010\u0010\u0013\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0004J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R%\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u0018\u001a\u0004\b\u0019\u0010\bR\u0019\u0010\u000f\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001a\u001a\u0004\b\u001b\u0010\nR\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001c\u001a\u0004\b\u001d\u0010\u0004R\u0019\u0010\u000e\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001a\u001a\u0004\b\u001e\u0010\n¨\u0006!"}, d2 = {"Lru/sravni/android/bankproduct/network/chat/request/NextConversationRequest;", "", "", "component1", "()I", "", "", "component2", "()Ljava/util/Map;", "component3", "()Ljava/lang/String;", "component4", "currentOrder", "fields", "action", "text", "copy", "(ILjava/util/Map;Ljava/lang/String;Ljava/lang/String;)Lru/sravni/android/bankproduct/network/chat/request/NextConversationRequest;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/Map;", "getFields", "Ljava/lang/String;", "getText", "I", "getCurrentOrder", "getAction", "<init>", "(ILjava/util/Map;Ljava/lang/String;Ljava/lang/String;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class NextConversationRequest {
    @NotNull
    private final String action;
    private final int currentOrder;
    @NotNull
    private final Map<String, String> fields;
    @NotNull
    private final String text;

    public NextConversationRequest(int i, @NotNull Map<String, String> map, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(map, "fields");
        Intrinsics.checkParameterIsNotNull(str, "action");
        Intrinsics.checkParameterIsNotNull(str2, "text");
        this.currentOrder = i;
        this.fields = map;
        this.action = str;
        this.text = str2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: ru.sravni.android.bankproduct.network.chat.request.NextConversationRequest */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ NextConversationRequest copy$default(NextConversationRequest nextConversationRequest, int i, Map map, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = nextConversationRequest.currentOrder;
        }
        if ((i2 & 2) != 0) {
            map = nextConversationRequest.fields;
        }
        if ((i2 & 4) != 0) {
            str = nextConversationRequest.action;
        }
        if ((i2 & 8) != 0) {
            str2 = nextConversationRequest.text;
        }
        return nextConversationRequest.copy(i, map, str, str2);
    }

    public final int component1() {
        return this.currentOrder;
    }

    @NotNull
    public final Map<String, String> component2() {
        return this.fields;
    }

    @NotNull
    public final String component3() {
        return this.action;
    }

    @NotNull
    public final String component4() {
        return this.text;
    }

    @NotNull
    public final NextConversationRequest copy(int i, @NotNull Map<String, String> map, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(map, "fields");
        Intrinsics.checkParameterIsNotNull(str, "action");
        Intrinsics.checkParameterIsNotNull(str2, "text");
        return new NextConversationRequest(i, map, str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NextConversationRequest)) {
            return false;
        }
        NextConversationRequest nextConversationRequest = (NextConversationRequest) obj;
        return this.currentOrder == nextConversationRequest.currentOrder && Intrinsics.areEqual(this.fields, nextConversationRequest.fields) && Intrinsics.areEqual(this.action, nextConversationRequest.action) && Intrinsics.areEqual(this.text, nextConversationRequest.text);
    }

    @NotNull
    public final String getAction() {
        return this.action;
    }

    public final int getCurrentOrder() {
        return this.currentOrder;
    }

    @NotNull
    public final Map<String, String> getFields() {
        return this.fields;
    }

    @NotNull
    public final String getText() {
        return this.text;
    }

    public int hashCode() {
        int i = this.currentOrder * 31;
        Map<String, String> map = this.fields;
        int i2 = 0;
        int hashCode = (i + (map != null ? map.hashCode() : 0)) * 31;
        String str = this.action;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.text;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode2 + i2;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("NextConversationRequest(currentOrder=");
        L.append(this.currentOrder);
        L.append(", fields=");
        L.append(this.fields);
        L.append(", action=");
        L.append(this.action);
        L.append(", text=");
        return a.t(L, this.text, ")");
    }
}
