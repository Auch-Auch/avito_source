package com.avito.android.suggest_locations;

import com.avito.android.remote.model.SuggestLocation;
import com.avito.android.remote.model.SuggestLocationsResponse;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\u0007\u001a\u00020\u00062\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\f¨\u0006\r"}, d2 = {"Lcom/avito/android/suggest_locations/SuggestLocationsItemsConverter;", "", "Lcom/avito/android/remote/model/SuggestLocationsResponse;", "result", "", "query", "Lcom/avito/android/suggest_locations/SuggestLocationsResult;", "convert", "(Lcom/avito/android/remote/model/SuggestLocationsResponse;Ljava/lang/String;)Lcom/avito/android/suggest_locations/SuggestLocationsResult;", "", "Lcom/avito/android/remote/model/SuggestLocation;", "locations", "(Ljava/util/List;Ljava/lang/String;)Lcom/avito/android/suggest_locations/SuggestLocationsResult;", "suggest-locations_release"}, k = 1, mv = {1, 4, 2})
public interface SuggestLocationsItemsConverter {
    @NotNull
    SuggestLocationsResult convert(@NotNull SuggestLocationsResponse suggestLocationsResponse, @NotNull String str);

    @NotNull
    SuggestLocationsResult convert(@Nullable List<SuggestLocation> list, @NotNull String str);
}
