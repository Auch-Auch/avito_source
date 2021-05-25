package com.avito.android.deep_linking;

import android.content.Context;
import com.avito.android.Features;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdjustReattributionInteractorImpl_Factory implements Factory<AdjustReattributionInteractorImpl> {
    public final Provider<Context> a;
    public final Provider<Features> b;

    public AdjustReattributionInteractorImpl_Factory(Provider<Context> provider, Provider<Features> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static AdjustReattributionInteractorImpl_Factory create(Provider<Context> provider, Provider<Features> provider2) {
        return new AdjustReattributionInteractorImpl_Factory(provider, provider2);
    }

    public static AdjustReattributionInteractorImpl newInstance(Context context, Features features) {
        return new AdjustReattributionInteractorImpl(context, features);
    }

    @Override // javax.inject.Provider
    public AdjustReattributionInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
