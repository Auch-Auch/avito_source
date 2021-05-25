package com.avito.android.remote.model;

import com.avito.android.util.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001d\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a'\u0010\b\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"", "id", Constants.LOCATION_NAME, "Lcom/avito/android/remote/model/Location;", "createLocation", "(Ljava/lang/String;Ljava/lang/String;)Lcom/avito/android/remote/model/Location;", "Lcom/avito/android/remote/model/Coordinates;", "coordinates", "createLocationWithCoordinates", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Coordinates;)Lcom/avito/android/remote/model/Location;", "models_release"}, k = 2, mv = {1, 4, 2})
public final class LocationKt {
    @NotNull
    public static final Location createLocation(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, Constants.LOCATION_NAME);
        CaseText caseText = new CaseText();
        caseText.setName(1, str2);
        return new Location(str, caseText, false, false, false, false, null, false, null, null, 1020, null);
    }

    @NotNull
    public static final Location createLocationWithCoordinates(@NotNull String str, @NotNull String str2, @Nullable Coordinates coordinates) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, Constants.LOCATION_NAME);
        CaseText caseText = new CaseText();
        caseText.setName(1, str2);
        return new Location(str, caseText, false, false, false, false, null, false, coordinates, null, 764, null);
    }
}
