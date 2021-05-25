package com.avito.android.remote.model.search.map;

import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\u001a\u001f\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004\"\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/remote/model/search/map/Area;", "", "", "toMap", "(Lcom/avito/android/remote/model/search/map/Area;)Ljava/util/Map;", "SEARCH_AREA", "Ljava/lang/String;", "models_release"}, k = 2, mv = {1, 4, 2})
public final class AreaKt {
    private static final String SEARCH_AREA = "searchArea";

    @NotNull
    public static final Map<String, String> toMap(@Nullable Area area) {
        Map<String, String> mapOf;
        return (area == null || (mapOf = r.mapOf(new Pair[]{TuplesKt.to("searchArea[latTop]", String.valueOf(area.getTopLeft().getLatitude())), TuplesKt.to("searchArea[lonLeft]", String.valueOf(area.getTopLeft().getLongitude())), TuplesKt.to("searchArea[latBottom]", String.valueOf(area.getBottomRight().getLatitude())), TuplesKt.to("searchArea[lonRight]", String.valueOf(area.getBottomRight().getLongitude()))})) == null) ? r.emptyMap() : mapOf;
    }
}
