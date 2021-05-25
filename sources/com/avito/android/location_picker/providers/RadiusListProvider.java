package com.avito.android.location_picker.providers;

import com.avito.android.remote.model.location_picker.RadiusListResult;
import io.reactivex.rxjava3.core.Single;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J%\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/avito/android/location_picker/providers/RadiusListProvider;", "", "", "radiusId", "categoryId", "Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/remote/model/location_picker/RadiusListResult;", "getRadiusList", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Single;", "location-picker_release"}, k = 1, mv = {1, 4, 2})
public interface RadiusListProvider {
    @NotNull
    Single<RadiusListResult> getRadiusList(@NotNull String str, @NotNull String str2);
}
