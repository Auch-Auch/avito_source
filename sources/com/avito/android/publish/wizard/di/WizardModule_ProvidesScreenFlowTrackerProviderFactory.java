package com.avito.android.publish.wizard.di;

import com.avito.android.analytics.screens.ScreenFlowTrackerProvider;
import com.avito.android.analytics.screens.TimerFactory;
import com.avito.android.analytics.screens.tracker.ScreenTrackerFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class WizardModule_ProvidesScreenFlowTrackerProviderFactory implements Factory<ScreenFlowTrackerProvider> {
    public final WizardModule a;
    public final Provider<ScreenTrackerFactory> b;
    public final Provider<TimerFactory> c;

    public WizardModule_ProvidesScreenFlowTrackerProviderFactory(WizardModule wizardModule, Provider<ScreenTrackerFactory> provider, Provider<TimerFactory> provider2) {
        this.a = wizardModule;
        this.b = provider;
        this.c = provider2;
    }

    public static WizardModule_ProvidesScreenFlowTrackerProviderFactory create(WizardModule wizardModule, Provider<ScreenTrackerFactory> provider, Provider<TimerFactory> provider2) {
        return new WizardModule_ProvidesScreenFlowTrackerProviderFactory(wizardModule, provider, provider2);
    }

    public static ScreenFlowTrackerProvider providesScreenFlowTrackerProvider(WizardModule wizardModule, ScreenTrackerFactory screenTrackerFactory, TimerFactory timerFactory) {
        return (ScreenFlowTrackerProvider) Preconditions.checkNotNullFromProvides(wizardModule.providesScreenFlowTrackerProvider(screenTrackerFactory, timerFactory));
    }

    @Override // javax.inject.Provider
    public ScreenFlowTrackerProvider get() {
        return providesScreenFlowTrackerProvider(this.a, this.b.get(), this.c.get());
    }
}
