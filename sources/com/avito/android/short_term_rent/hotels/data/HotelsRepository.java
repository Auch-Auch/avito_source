package com.avito.android.short_term_rent.hotels.data;

import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.model.hotels.HotelsFiltersResult;
import com.avito.android.remote.model.hotels.HotelsSearchResult;
import com.avito.android.remote.model.hotels.HotelsSuggestResult;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J#\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\n\u0010\u000bJ-\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\b0\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/avito/android/short_term_rent/hotels/data/HotelsRepository;", "", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/hotels/HotelsFiltersResult;", "getInitialScreenData", "()Lio/reactivex/rxjava3/core/Observable;", "", "query", "Lcom/avito/android/remote/model/TypedResult;", "Lcom/avito/android/remote/model/hotels/HotelsSuggestResult;", "getHotelsLocationsSuggest", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "marker", "Lcom/avito/android/short_term_rent/hotels/data/FiltersData;", "filtersData", "Lcom/avito/android/remote/model/hotels/HotelsSearchResult;", "submitHotelsSearch", "(Ljava/lang/String;Lcom/avito/android/short_term_rent/hotels/data/FiltersData;)Lio/reactivex/rxjava3/core/Observable;", "short-term-rent_release"}, k = 1, mv = {1, 4, 2})
public interface HotelsRepository {
    @NotNull
    Observable<TypedResult<HotelsSuggestResult>> getHotelsLocationsSuggest(@NotNull String str);

    @NotNull
    Observable<HotelsFiltersResult> getInitialScreenData();

    @NotNull
    Observable<TypedResult<HotelsSearchResult>> submitHotelsSearch(@Nullable String str, @NotNull FiltersData filtersData);
}
