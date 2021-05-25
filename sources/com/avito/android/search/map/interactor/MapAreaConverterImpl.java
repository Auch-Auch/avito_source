package com.avito.android.search.map.interactor;

import com.avito.android.avito_map.AvitoMapBounds;
import com.avito.android.avito_map.AvitoMapKt;
import com.avito.android.avito_map.AvitoMapPoint;
import com.avito.android.remote.auth.AuthSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0005R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/search/map/interactor/MapAreaConverterImpl;", "Lcom/avito/android/search/map/interactor/MapAreaConverter;", "Lcom/avito/android/avito_map/AvitoMapBounds;", "area", "convertBoundsToVisible", "(Lcom/avito/android/avito_map/AvitoMapBounds;)Lcom/avito/android/avito_map/AvitoMapBounds;", "convertBoundsFromVisible", "Lcom/avito/android/search/map/interactor/MapViewPortProvider;", AuthSource.SEND_ABUSE, "Lcom/avito/android/search/map/interactor/MapViewPortProvider;", "mapViewPortProvider", "<init>", "(Lcom/avito/android/search/map/interactor/MapViewPortProvider;)V", "map_release"}, k = 1, mv = {1, 4, 2})
public final class MapAreaConverterImpl implements MapAreaConverter {
    public final MapViewPortProvider a;

    @Inject
    public MapAreaConverterImpl(@NotNull MapViewPortProvider mapViewPortProvider) {
        Intrinsics.checkNotNullParameter(mapViewPortProvider, "mapViewPortProvider");
        this.a = mapViewPortProvider;
    }

    @Override // com.avito.android.search.map.interactor.MapAreaConverter
    @Nullable
    public AvitoMapBounds convertBoundsFromVisible(@Nullable AvitoMapBounds avitoMapBounds) {
        if (avitoMapBounds == null) {
            return null;
        }
        int intValue = this.a.getViewPort().component2().intValue();
        if (intValue == 0) {
            return avitoMapBounds;
        }
        double latitude = avitoMapBounds.getTopLeft().getLatitude();
        double latitude2 = avitoMapBounds.getBottomRight().getLatitude();
        double d = (double) intValue;
        double offsets = ((latitude - latitude2) * d) / ((double) (intValue - this.a.getOffsets()));
        double bottomOffset = latitude2 - ((offsets * ((double) this.a.getBottomOffset())) / d);
        Pair<Double, Double> denormalizeCoordinates = AvitoMapKt.denormalizeCoordinates(avitoMapBounds.getTopLeft().getLongitude(), avitoMapBounds.getBottomRight().getLongitude());
        return avitoMapBounds.copy(new AvitoMapPoint(latitude + ((((double) this.a.getTopOffset()) * offsets) / d), denormalizeCoordinates.getFirst().doubleValue()), new AvitoMapPoint(bottomOffset, denormalizeCoordinates.getSecond().doubleValue()));
    }

    @Override // com.avito.android.search.map.interactor.MapAreaConverter
    @Nullable
    public AvitoMapBounds convertBoundsToVisible(@Nullable AvitoMapBounds avitoMapBounds) {
        if (avitoMapBounds == null) {
            return null;
        }
        int intValue = this.a.getViewPort().component2().intValue();
        if (intValue == 0) {
            return avitoMapBounds;
        }
        double latitude = avitoMapBounds.getTopLeft().getLatitude();
        double latitude2 = avitoMapBounds.getBottomRight().getLatitude();
        double d = latitude - latitude2;
        double d2 = (double) intValue;
        return avitoMapBounds.copy(new AvitoMapPoint(latitude - ((((double) this.a.getTopOffset()) * d) / d2), avitoMapBounds.getTopLeft().getLongitude()), new AvitoMapPoint(latitude2 + ((d * ((double) this.a.getBottomOffset())) / d2), avitoMapBounds.getBottomRight().getLongitude()));
    }
}
