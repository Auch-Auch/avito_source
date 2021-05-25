package com.avito.android.delivery.map.common.marker.calculator;

import com.avito.android.delivery.utils.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0011\bf\u0018\u00002\u00020\u0001J)\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u000e\u001a\u00020\u00068V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0010\u001a\u00020\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\rR\u0016\u0010\u0014\u001a\u00020\u00068V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\rR\u0016\u0010\u0016\u001a\u00020\u00068V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/avito/android/delivery/map/common/marker/calculator/ClusterRadiusCalculator;", "", "", "clusterMarkerRadius", "", "lat", "", "zoom", "calculate", "(IDF)Ljava/lang/Float;", "normalize", "(F)F", "getMinClusterRadius", "()F", "minClusterRadius", "getCoefficient", "coefficient", "getNormalizationDegree", "normalizationDegree", "getMinZoomLevel", "minZoomLevel", "getMaxZoomLevel", "maxZoomLevel", "delivery_release"}, k = 1, mv = {1, 4, 2})
public interface ClusterRadiusCalculator {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        @Nullable
        public static Float calculate(@NotNull ClusterRadiusCalculator clusterRadiusCalculator, int i, double d, float f) {
            Float valueOf = Float.valueOf((float) Math.pow((double) clusterRadiusCalculator.normalize(f), (double) clusterRadiusCalculator.getNormalizationDegree()));
            if (!(valueOf.floatValue() != 0.0f)) {
                valueOf = null;
            }
            float metersPerPx = (Map.metersPerPx(d, f) * ((float) i)) / (valueOf != null ? valueOf.floatValue() : 1.0E-4f);
            if (metersPerPx > clusterRadiusCalculator.getMinClusterRadius()) {
                return Float.valueOf(metersPerPx);
            }
            return null;
        }

        public static float getMaxZoomLevel(@NotNull ClusterRadiusCalculator clusterRadiusCalculator) {
            return 20.0f;
        }

        public static float getMinClusterRadius(@NotNull ClusterRadiusCalculator clusterRadiusCalculator) {
            return 300.0f;
        }

        public static float getMinZoomLevel(@NotNull ClusterRadiusCalculator clusterRadiusCalculator) {
            return 1.0f;
        }

        public static float normalize(@NotNull ClusterRadiusCalculator clusterRadiusCalculator, float f) {
            float f2 = (float) 1;
            return f2 / (((float) Math.exp((double) ((f - ((clusterRadiusCalculator.getMaxZoomLevel() + clusterRadiusCalculator.getMinZoomLevel()) / ((float) 2))) * clusterRadiusCalculator.getCoefficient()))) + f2);
        }
    }

    @Nullable
    Float calculate(int i, double d, float f);

    float getCoefficient();

    float getMaxZoomLevel();

    float getMinClusterRadius();

    float getMinZoomLevel();

    float getNormalizationDegree();

    float normalize(float f);
}
