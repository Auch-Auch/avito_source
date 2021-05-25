package com.avito.android.analytics.clickstream;

import com.avito.android.ClickstreamToggles;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Set;
import javax.inject.Provider;
public final class ClickStreamCommonModule_ProvideEventValidatorsFactory implements Factory<Set<EventValidator>> {
    public final Provider<ClickstreamToggles> a;

    public ClickStreamCommonModule_ProvideEventValidatorsFactory(Provider<ClickstreamToggles> provider) {
        this.a = provider;
    }

    public static ClickStreamCommonModule_ProvideEventValidatorsFactory create(Provider<ClickstreamToggles> provider) {
        return new ClickStreamCommonModule_ProvideEventValidatorsFactory(provider);
    }

    public static Set<EventValidator> provideEventValidators(ClickstreamToggles clickstreamToggles) {
        return (Set) Preconditions.checkNotNullFromProvides(ClickStreamCommonModule.provideEventValidators(clickstreamToggles));
    }

    @Override // javax.inject.Provider
    public Set<EventValidator> get() {
        return provideEventValidators(this.a.get());
    }
}
