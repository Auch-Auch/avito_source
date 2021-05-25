package com.avito.android.in_app_calls.ui.root;

import com.avito.android.analytics.Analytics;
import com.avito.android.app.task.ApplicationStartupTasksRegistry;
import com.avito.android.calls.analytics.CallAnalyticsTracker;
import com.avito.android.calls_shared.tracker.events.CallEventTracker;
import com.avito.android.in_app_calls.ui.InAppCallsRouter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class InAppCallActivity_MembersInjector implements MembersInjector<InAppCallActivity> {
    public final Provider<InAppCallsRouter> a;
    public final Provider<CallAnalyticsTracker> b;
    public final Provider<CallEventTracker> c;
    public final Provider<Analytics> d;
    public final Provider<ApplicationStartupTasksRegistry> e;

    public InAppCallActivity_MembersInjector(Provider<InAppCallsRouter> provider, Provider<CallAnalyticsTracker> provider2, Provider<CallEventTracker> provider3, Provider<Analytics> provider4, Provider<ApplicationStartupTasksRegistry> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static MembersInjector<InAppCallActivity> create(Provider<InAppCallsRouter> provider, Provider<CallAnalyticsTracker> provider2, Provider<CallEventTracker> provider3, Provider<Analytics> provider4, Provider<ApplicationStartupTasksRegistry> provider5) {
        return new InAppCallActivity_MembersInjector(provider, provider2, provider3, provider4, provider5);
    }

    @InjectedFieldSignature("com.avito.android.in_app_calls.ui.root.InAppCallActivity.analytics")
    public static void injectAnalytics(InAppCallActivity inAppCallActivity, Analytics analytics) {
        inAppCallActivity.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.in_app_calls.ui.root.InAppCallActivity.analyticsTracker")
    public static void injectAnalyticsTracker(InAppCallActivity inAppCallActivity, CallAnalyticsTracker callAnalyticsTracker) {
        inAppCallActivity.analyticsTracker = callAnalyticsTracker;
    }

    @InjectedFieldSignature("com.avito.android.in_app_calls.ui.root.InAppCallActivity.callEventTracker")
    public static void injectCallEventTracker(InAppCallActivity inAppCallActivity, CallEventTracker callEventTracker) {
        inAppCallActivity.callEventTracker = callEventTracker;
    }

    @InjectedFieldSignature("com.avito.android.in_app_calls.ui.root.InAppCallActivity.router")
    public static void injectRouter(InAppCallActivity inAppCallActivity, InAppCallsRouter inAppCallsRouter) {
        inAppCallActivity.router = inAppCallsRouter;
    }

    @InjectedFieldSignature("com.avito.android.in_app_calls.ui.root.InAppCallActivity.startupTasksRegistry")
    public static void injectStartupTasksRegistry(InAppCallActivity inAppCallActivity, ApplicationStartupTasksRegistry applicationStartupTasksRegistry) {
        inAppCallActivity.startupTasksRegistry = applicationStartupTasksRegistry;
    }

    public void injectMembers(InAppCallActivity inAppCallActivity) {
        injectRouter(inAppCallActivity, this.a.get());
        injectAnalyticsTracker(inAppCallActivity, this.b.get());
        injectCallEventTracker(inAppCallActivity, this.c.get());
        injectAnalytics(inAppCallActivity, this.d.get());
        injectStartupTasksRegistry(inAppCallActivity, this.e.get());
    }
}
