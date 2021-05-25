package com.avito.android.search.map.interactor;

import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a-\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002*\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0000H\u0000¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lkotlin/Pair;", "", "", "", "toMap", "(Lkotlin/Pair;)Ljava/util/Map;", "map_release"}, k = 2, mv = {1, 4, 2})
public final class MapViewPortProviderKt {
    @NotNull
    public static final Map<String, String> toMap(@Nullable Pair<Integer, Integer> pair) {
        Map<String, String> mapOf;
        return (pair == null || (mapOf = r.mapOf(new Pair[]{TuplesKt.to("viewPort[width]", String.valueOf(pair.getFirst().intValue())), TuplesKt.to("viewPort[height]", String.valueOf(pair.getSecond().intValue()))})) == null) ? r.emptyMap() : mapOf;
    }
}
