package com.avito.android.fps;

import android.app.Application;
import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.grafana.GraphitePrefix;
import dagger.internal.Factory;
import io.reactivex.Observable;
import javax.inject.Provider;
public final class FpsReporter_Factory implements Factory<FpsReporter> {
    public final Provider<Application> a;
    public final Provider<Analytics> b;
    public final Provider<Features> c;
    public final Provider<GraphitePrefix> d;
    public final Provider<Observable<Long>> e;

    public FpsReporter_Factory(Provider<Application> provider, Provider<Analytics> provider2, Provider<Features> provider3, Provider<GraphitePrefix> provider4, Provider<Observable<Long>> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static FpsReporter_Factory create(Provider<Application> provider, Provider<Analytics> provider2, Provider<Features> provider3, Provider<GraphitePrefix> provider4, Provider<Observable<Long>> provider5) {
        return new FpsReporter_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static FpsReporter newInstance(Application application, Analytics analytics, Features features, GraphitePrefix graphitePrefix, Observable<Long> observable) {
        return new FpsReporter(application, analytics, features, graphitePrefix, observable);
    }

    @Override // javax.inject.Provider
    public FpsReporter get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
