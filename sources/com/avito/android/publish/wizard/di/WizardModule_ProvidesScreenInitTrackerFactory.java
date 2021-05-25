package com.avito.android.publish.wizard.di;

import com.avito.android.analytics.screens.TimerFactory;
import com.avito.android.analytics.screens.tracker.ScreenInitTracker;
import com.avito.android.analytics.screens.tracker.ScreenTrackerFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class WizardModule_ProvidesScreenInitTrackerFactory implements Factory<ScreenInitTracker> {
    public final WizardModule a;
    public final Provider<ScreenTrackerFactory> b;
    public final Provider<TimerFactory> c;

    public WizardModule_ProvidesScreenInitTrackerFactory(WizardModule wizardModule, Provider<ScreenTrackerFactory> provider, Provider<TimerFactory> provider2) {
        this.a = wizardModule;
        this.b = provider;
        this.c = provider2;
    }

    public static WizardModule_ProvidesScreenInitTrackerFactory create(WizardModule wizardModule, Provider<ScreenTrackerFactory> provider, Provider<TimerFactory> provider2) {
        return new WizardModule_ProvidesScreenInitTrackerFactory(wizardModule, provider, provider2);
    }

    public static ScreenInitTracker providesScreenInitTracker(WizardModule wizardModule, ScreenTrackerFactory screenTrackerFactory, TimerFactory timerFactory) {
        return (ScreenInitTracker) Preconditions.checkNotNullFromProvides(wizardModule.providesScreenInitTracker(screenTrackerFactory, timerFactory));
    }

    @Override // javax.inject.Provider
    public ScreenInitTracker get() {
        return providesScreenInitTracker(this.a, this.b.get(), this.c.get());
    }
}
