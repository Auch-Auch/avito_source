package com.avito.android.in_app_calls.workers;

import com.avito.android.analytics.Analytics;
import com.avito.android.in_app_calls.workers.CallAvailabilityComponent;
import dagger.internal.Preconditions;
public final class DaggerCallAvailabilityComponent implements CallAvailabilityComponent {
    public final CallAvailabilityComponentDependencies a;

    public static final class b implements CallAvailabilityComponent.Factory {
        public b(a aVar) {
        }

        @Override // com.avito.android.in_app_calls.workers.CallAvailabilityComponent.Factory
        public CallAvailabilityComponent create(CallAvailabilityComponentDependencies callAvailabilityComponentDependencies) {
            Preconditions.checkNotNull(callAvailabilityComponentDependencies);
            return new DaggerCallAvailabilityComponent(callAvailabilityComponentDependencies, null);
        }
    }

    public DaggerCallAvailabilityComponent(CallAvailabilityComponentDependencies callAvailabilityComponentDependencies, a aVar) {
        this.a = callAvailabilityComponentDependencies;
    }

    public static CallAvailabilityComponent.Factory factory() {
        return new b(null);
    }

    @Override // com.avito.android.in_app_calls.workers.CallAvailabilityComponent
    public void inject(CallAvailabilityWorker callAvailabilityWorker) {
        CallAvailabilityWorker_MembersInjector.injectCallAvailabilityUpdater(callAvailabilityWorker, (CallAvailabilityUpdater) Preconditions.checkNotNullFromComponent(this.a.callAvailabilityUpdater()));
        CallAvailabilityWorker_MembersInjector.injectAnalytics(callAvailabilityWorker, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
    }
}
