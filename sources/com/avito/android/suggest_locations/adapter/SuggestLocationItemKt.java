package com.avito.android.suggest_locations.adapter;

import com.avito.android.remote.model.Location;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0014\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\b¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/suggest_locations/adapter/SuggestLocationItem;", "Lcom/avito/android/remote/model/Location;", "toLocation", "(Lcom/avito/android/suggest_locations/adapter/SuggestLocationItem;)Lcom/avito/android/remote/model/Location;", "suggest-locations_release"}, k = 2, mv = {1, 4, 2})
public final class SuggestLocationItemKt {
    @NotNull
    public static final Location toLocation(@NotNull SuggestLocationItem suggestLocationItem) {
        Intrinsics.checkNotNullParameter(suggestLocationItem, "$this$toLocation");
        return new Location(suggestLocationItem.getId(), suggestLocationItem.getNames(), false, false, false, false, null, false, null, null, 1020, null);
    }
}
