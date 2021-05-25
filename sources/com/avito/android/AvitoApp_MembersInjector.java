package com.avito.android;

import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.OrientationTracker;
import com.avito.android.analytics.task.StartupAnalyticsTracker;
import com.avito.android.app.ApplicationDelegate;
import com.avito.android.di.ComponentDependencies;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import java.util.Map;
import javax.inject.Provider;
public final class AvitoApp_MembersInjector implements MembersInjector<AvitoApp> {
    public final Provider<ApplicationDelegate> a;
    public final Provider<StartupAnalyticsTracker> b;
    public final Provider<OrientationTracker> c;
    public final Provider<Analytics> d;
    public final Provider<Map<Class<? extends ComponentDependencies>, ComponentDependencies>> e;

    public AvitoApp_MembersInjector(Provider<ApplicationDelegate> provider, Provider<StartupAnalyticsTracker> provider2, Provider<OrientationTracker> provider3, Provider<Analytics> provider4, Provider<Map<Class<? extends ComponentDependencies>, ComponentDependencies>> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static MembersInjector<AvitoApp> create(Provider<ApplicationDelegate> provider, Provider<StartupAnalyticsTracker> provider2, Provider<OrientationTracker> provider3, Provider<Analytics> provider4, Provider<Map<Class<? extends ComponentDependencies>, ComponentDependencies>> provider5) {
        return new AvitoApp_MembersInjector(provider, provider2, provider3, provider4, provider5);
    }

    @InjectedFieldSignature("com.avito.android.AvitoApp.analytics")
    public static void injectAnalytics(AvitoApp avitoApp, Analytics analytics) {
        avitoApp.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.AvitoApp.delegate")
    public static void injectDelegate(AvitoApp avitoApp, ApplicationDelegate applicationDelegate) {
        avitoApp.delegate = applicationDelegate;
    }

    @InjectedFieldSignature("com.avito.android.AvitoApp.dependencies")
    public static void injectDependencies(AvitoApp avitoApp, Map<Class<? extends ComponentDependencies>, ComponentDependencies> map) {
        avitoApp.dependencies = map;
    }

    @InjectedFieldSignature("com.avito.android.AvitoApp.orientationTracker")
    public static void injectOrientationTracker(AvitoApp avitoApp, OrientationTracker orientationTracker) {
        avitoApp.orientationTracker = orientationTracker;
    }

    @InjectedFieldSignature("com.avito.android.AvitoApp.tracker")
    public static void injectTracker(AvitoApp avitoApp, StartupAnalyticsTracker startupAnalyticsTracker) {
        avitoApp.tracker = startupAnalyticsTracker;
    }

    public void injectMembers(AvitoApp avitoApp) {
        injectDelegate(avitoApp, this.a.get());
        injectTracker(avitoApp, this.b.get());
        injectOrientationTracker(avitoApp, this.c.get());
        injectAnalytics(avitoApp, this.d.get());
        injectDependencies(avitoApp, this.e.get());
    }
}
