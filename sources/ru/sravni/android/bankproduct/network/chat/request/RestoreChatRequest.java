package ru.sravni.android.bankproduct.network.chat.request;

import a2.b.a.a.a;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u001c\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J&\u0010\u0007\u001a\u00020\u00002\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R%\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0013\u0010\u0005¨\u0006\u0016"}, d2 = {"Lru/sravni/android/bankproduct/network/chat/request/RestoreChatRequest;", "", "", "", "component1", "()Ljava/util/Map;", "fields", "copy", "(Ljava/util/Map;)Lru/sravni/android/bankproduct/network/chat/request/RestoreChatRequest;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/Map;", "getFields", "<init>", "(Ljava/util/Map;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class RestoreChatRequest {
    @NotNull
    private final Map<String, String> fields;

    public RestoreChatRequest(@NotNull Map<String, String> map) {
        Intrinsics.checkParameterIsNotNull(map, "fields");
        this.fields = map;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: ru.sravni.android.bankproduct.network.chat.request.RestoreChatRequest */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RestoreChatRequest copy$default(RestoreChatRequest restoreChatRequest, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            map = restoreChatRequest.fields;
        }
        return restoreChatRequest.copy(map);
    }

    @NotNull
    public final Map<String, String> component1() {
        return this.fields;
    }

    @NotNull
    public final RestoreChatRequest copy(@NotNull Map<String, String> map) {
        Intrinsics.checkParameterIsNotNull(map, "fields");
        return new RestoreChatRequest(map);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            return (obj instanceof RestoreChatRequest) && Intrinsics.areEqual(this.fields, ((RestoreChatRequest) obj).fields);
        }
        return true;
    }

    @NotNull
    public final Map<String, String> getFields() {
        return this.fields;
    }

    public int hashCode() {
        Map<String, String> map = this.fields;
        if (map != null) {
            return map.hashCode();
        }
        return 0;
    }

    @NotNull
    public String toString() {
        return a.x(a.L("RestoreChatRequest(fields="), this.fields, ")");
    }
}
