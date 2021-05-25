package ru.avito.messenger.api.entity;

import a2.b.a.a.a;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0007\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u001c\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J&\u0010\b\u001a\u00020\u00002\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R(\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0012\u001a\u0004\b\u0013\u0010\u0006¨\u0006\u0016"}, d2 = {"Lru/avito/messenger/api/entity/FoldersCountersResponse;", "", "", "", "", "component1", "()Ljava/util/Map;", "counters", "copy", "(Ljava/util/Map;)Lru/avito/messenger/api/entity/FoldersCountersResponse;", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/Map;", "getCounters", "<init>", "(Ljava/util/Map;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class FoldersCountersResponse {
    @SerializedName("folders")
    @NotNull
    private final Map<String, Integer> counters;

    public FoldersCountersResponse(@NotNull Map<String, Integer> map) {
        Intrinsics.checkNotNullParameter(map, "counters");
        this.counters = map;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: ru.avito.messenger.api.entity.FoldersCountersResponse */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FoldersCountersResponse copy$default(FoldersCountersResponse foldersCountersResponse, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            map = foldersCountersResponse.counters;
        }
        return foldersCountersResponse.copy(map);
    }

    @NotNull
    public final Map<String, Integer> component1() {
        return this.counters;
    }

    @NotNull
    public final FoldersCountersResponse copy(@NotNull Map<String, Integer> map) {
        Intrinsics.checkNotNullParameter(map, "counters");
        return new FoldersCountersResponse(map);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            return (obj instanceof FoldersCountersResponse) && Intrinsics.areEqual(this.counters, ((FoldersCountersResponse) obj).counters);
        }
        return true;
    }

    @NotNull
    public final Map<String, Integer> getCounters() {
        return this.counters;
    }

    public int hashCode() {
        Map<String, Integer> map = this.counters;
        if (map != null) {
            return map.hashCode();
        }
        return 0;
    }

    @NotNull
    public String toString() {
        return a.x(a.L("FoldersCountersResponse(counters="), this.counters, ")");
    }
}
