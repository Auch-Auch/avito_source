package com.avito.android.in_app_calls.di;

import android.content.res.Resources;
import androidx.fragment.app.FragmentActivity;
import com.avito.android.analytics.Analytics;
import com.avito.android.app.task.ApplicationStartupTasksRegistry;
import com.avito.android.calls.analytics.CallAnalyticsTracker;
import com.avito.android.calls_shared.tracker.events.CallEventTracker;
import com.avito.android.in_app_calls.di.CallActivityComponent;
import com.avito.android.in_app_calls.ui.root.InAppCallActivity;
import com.avito.android.in_app_calls.ui.root.InAppCallActivity_MembersInjector;
import dagger.internal.Preconditions;
public final class DaggerCallActivityComponent implements CallActivityComponent {
    public final FragmentActivity a;
    public final CallActivityComponentDependencies b;

    public static final class b implements CallActivityComponent.CallActivityComponentComponentFactory {
        public b(a aVar) {
        }

        @Override // com.avito.android.in_app_calls.di.CallActivityComponent.CallActivityComponentComponentFactory
        public CallActivityComponent create(FragmentActivity fragmentActivity, Resources resources, CallActivityComponentDependencies callActivityComponentDependencies) {
            Preconditions.checkNotNull(fragmentActivity);
            Preconditions.checkNotNull(resources);
            Preconditions.checkNotNull(callActivityComponentDependencies);
            return new DaggerCallActivityComponent(callActivityComponentDependencies, fragmentActivity, resources);
        }
    }

    public DaggerCallActivityComponent(CallActivityComponentDependencies callActivityComponentDependencies, FragmentActivity fragmentActivity, Resources resources) {
        this.a = fragmentActivity;
        this.b = callActivityComponentDependencies;
    }

    public static CallActivityComponent.CallActivityComponentComponentFactory factory() {
        return new b(null);
    }

    @Override // com.avito.android.in_app_calls.di.CallActivityComponent
    public void inject(InAppCallActivity inAppCallActivity) {
        InAppCallActivity_MembersInjector.injectRouter(inAppCallActivity, CallActivityModule_ProvideInAppCallsRouterFactory.provideInAppCallsRouter(this.a));
        InAppCallActivity_MembersInjector.injectAnalyticsTracker(inAppCallActivity, (CallAnalyticsTracker) Preconditions.checkNotNullFromComponent(this.b.callAnalyticsTracker()));
        InAppCallActivity_MembersInjector.injectCallEventTracker(inAppCallActivity, (CallEventTracker) Preconditions.checkNotNullFromComponent(this.b.callStepTracked()));
        InAppCallActivity_MembersInjector.injectAnalytics(inAppCallActivity, (Analytics) Preconditions.checkNotNullFromComponent(this.b.analytics()));
        InAppCallActivity_MembersInjector.injectStartupTasksRegistry(inAppCallActivity, (ApplicationStartupTasksRegistry) Preconditions.checkNotNullFromComponent(this.b.startupTasksRegistry()));
    }
}
