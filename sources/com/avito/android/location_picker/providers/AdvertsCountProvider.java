package com.avito.android.location_picker.providers;

import com.avito.android.remote.model.Coordinates;
import com.avito.android.remote.model.location_picker.AdvertsCountResult;
import io.reactivex.rxjava3.core.Single;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J=\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/location_picker/providers/AdvertsCountProvider;", "", "", "", "searchParams", "radiusId", "Lcom/avito/android/remote/model/Coordinates;", "coordinates", "Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/remote/model/location_picker/AdvertsCountResult;", "getAdvertsCount", "(Ljava/util/Map;Ljava/lang/String;Lcom/avito/android/remote/model/Coordinates;)Lio/reactivex/rxjava3/core/Single;", "location-picker_release"}, k = 1, mv = {1, 4, 2})
public interface AdvertsCountProvider {
    @NotNull
    Single<AdvertsCountResult> getAdvertsCount(@NotNull Map<String, String> map, @Nullable String str, @Nullable Coordinates coordinates);
}
