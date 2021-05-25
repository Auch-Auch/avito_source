package com.avito.android.delivery.map.common.marker.calculator;

import com.avito.android.delivery.map.common.marker.calculator.ClusterRadiusCalculator;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0014\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0007\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\n\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u001c\u0010\r\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\u0010\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001c\u0010\u0013\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006¨\u0006\u0016"}, d2 = {"Lcom/avito/android/delivery/map/common/marker/calculator/ClusterRadiusTestCalculator;", "Lcom/avito/android/delivery/map/common/marker/calculator/ClusterRadiusCalculator;", "", "c", "F", "getMinClusterRadius", "()F", "minClusterRadius", AuthSource.BOOKING_ORDER, "getCoefficient", "coefficient", AuthSource.SEND_ABUSE, "getNormalizationDegree", "normalizationDegree", "d", "getMinZoomLevel", "minZoomLevel", "e", "getMaxZoomLevel", "maxZoomLevel", "<init>", "(FFFFF)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
public final class ClusterRadiusTestCalculator implements ClusterRadiusCalculator {
    public final float a;
    public final float b;
    public final float c;
    public final float d;
    public final float e;

    public ClusterRadiusTestCalculator(float f, float f2, float f3, float f4, float f5) {
        this.a = f;
        this.b = f2;
        this.c = f3;
        this.d = f4;
        this.e = f5;
    }

    @Override // com.avito.android.delivery.map.common.marker.calculator.ClusterRadiusCalculator
    @Nullable
    public Float calculate(int i, double d2, float f) {
        return ClusterRadiusCalculator.DefaultImpls.calculate(this, i, d2, f);
    }

    @Override // com.avito.android.delivery.map.common.marker.calculator.ClusterRadiusCalculator
    public float getCoefficient() {
        return this.b;
    }

    @Override // com.avito.android.delivery.map.common.marker.calculator.ClusterRadiusCalculator
    public float getMaxZoomLevel() {
        return this.e;
    }

    @Override // com.avito.android.delivery.map.common.marker.calculator.ClusterRadiusCalculator
    public float getMinClusterRadius() {
        return this.c;
    }

    @Override // com.avito.android.delivery.map.common.marker.calculator.ClusterRadiusCalculator
    public float getMinZoomLevel() {
        return this.d;
    }

    @Override // com.avito.android.delivery.map.common.marker.calculator.ClusterRadiusCalculator
    public float getNormalizationDegree() {
        return this.a;
    }

    @Override // com.avito.android.delivery.map.common.marker.calculator.ClusterRadiusCalculator
    public float normalize(float f) {
        return ClusterRadiusCalculator.DefaultImpls.normalize(this, f);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ClusterRadiusTestCalculator(float f, float f2, float f3, float f4, float f5, int i, j jVar) {
        this(f, f2, (i & 4) != 0 ? 300.0f : f3, (i & 8) != 0 ? 1.0f : f4, (i & 16) != 0 ? 20.0f : f5);
    }
}
