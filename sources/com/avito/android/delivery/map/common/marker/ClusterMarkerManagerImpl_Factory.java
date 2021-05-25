package com.avito.android.delivery.map.common.marker;

import android.content.Context;
import com.avito.android.delivery.map.common.marker.calculator.ClusterRadiusCalculator;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ClusterMarkerManagerImpl_Factory implements Factory<ClusterMarkerManagerImpl> {
    public final Provider<Context> a;
    public final Provider<ClusterRadiusCalculator> b;

    public ClusterMarkerManagerImpl_Factory(Provider<Context> provider, Provider<ClusterRadiusCalculator> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static ClusterMarkerManagerImpl_Factory create(Provider<Context> provider, Provider<ClusterRadiusCalculator> provider2) {
        return new ClusterMarkerManagerImpl_Factory(provider, provider2);
    }

    public static ClusterMarkerManagerImpl newInstance(Context context, ClusterRadiusCalculator clusterRadiusCalculator) {
        return new ClusterMarkerManagerImpl(context, clusterRadiusCalculator);
    }

    @Override // javax.inject.Provider
    public ClusterMarkerManagerImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
