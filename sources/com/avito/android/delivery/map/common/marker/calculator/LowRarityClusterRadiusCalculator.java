package com.avito.android.delivery.map.common.marker.calculator;

import com.avito.android.delivery.map.common.marker.calculator.ClusterRadiusCalculator;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\n\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\n\u0010\u000bR\u001c\u0010\u0003\u001a\u00020\u00028\u0016@\u0016XD¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\t\u001a\u00020\u00028\u0016@\u0016XD¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\f"}, d2 = {"Lcom/avito/android/delivery/map/common/marker/calculator/LowRarityClusterRadiusCalculator;", "Lcom/avito/android/delivery/map/common/marker/calculator/ClusterRadiusCalculator;", "", "coefficient", "F", "getCoefficient", "()F", AuthSource.SEND_ABUSE, "getNormalizationDegree", "normalizationDegree", "<init>", "()V", "delivery_release"}, k = 1, mv = {1, 4, 2})
public final class LowRarityClusterRadiusCalculator implements ClusterRadiusCalculator {
    public final float a = 2.05f;

    @Override // com.avito.android.delivery.map.common.marker.calculator.ClusterRadiusCalculator
    @Nullable
    public Float calculate(int i, double d, float f) {
        return ClusterRadiusCalculator.DefaultImpls.calculate(this, i, d, f);
    }

    @Override // com.avito.android.delivery.map.common.marker.calculator.ClusterRadiusCalculator
    public float getCoefficient() {
        return 0.0f;
    }

    @Override // com.avito.android.delivery.map.common.marker.calculator.ClusterRadiusCalculator
    public float getMaxZoomLevel() {
        return ClusterRadiusCalculator.DefaultImpls.getMaxZoomLevel(this);
    }

    @Override // com.avito.android.delivery.map.common.marker.calculator.ClusterRadiusCalculator
    public float getMinClusterRadius() {
        return ClusterRadiusCalculator.DefaultImpls.getMinClusterRadius(this);
    }

    @Override // com.avito.android.delivery.map.common.marker.calculator.ClusterRadiusCalculator
    public float getMinZoomLevel() {
        return ClusterRadiusCalculator.DefaultImpls.getMinZoomLevel(this);
    }

    @Override // com.avito.android.delivery.map.common.marker.calculator.ClusterRadiusCalculator
    public float getNormalizationDegree() {
        return this.a;
    }

    @Override // com.avito.android.delivery.map.common.marker.calculator.ClusterRadiusCalculator
    public float normalize(float f) {
        return ClusterRadiusCalculator.DefaultImpls.normalize(this, f);
    }
}
