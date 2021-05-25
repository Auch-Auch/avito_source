package com.avito.android.in_app_calls.di;

import com.avito.android.analytics.Analytics;
import com.avito.android.calls.remote.CallsApi;
import com.avito.android.communications_common.analytics.ErrorTracker;
import com.avito.android.in_app_calls.di.SendCallLogsComponent;
import com.avito.android.in_app_calls.logging.LogFileProvider;
import com.avito.android.in_app_calls.logging.LogUploader;
import com.avito.android.in_app_calls.logging.SendCallLogsWorker;
import com.avito.android.in_app_calls.logging.SendCallLogsWorker_MembersInjector;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Preconditions;
public final class DaggerSendCallLogsComponent implements SendCallLogsComponent {
    public final SendCallLogsDependencies a;

    public static final class b implements SendCallLogsComponent.Factory {
        public b(a aVar) {
        }

        @Override // com.avito.android.in_app_calls.di.SendCallLogsComponent.Factory
        public SendCallLogsComponent create(SendCallLogsDependencies sendCallLogsDependencies) {
            Preconditions.checkNotNull(sendCallLogsDependencies);
            return new DaggerSendCallLogsComponent(sendCallLogsDependencies, null);
        }
    }

    public DaggerSendCallLogsComponent(SendCallLogsDependencies sendCallLogsDependencies, a aVar) {
        this.a = sendCallLogsDependencies;
    }

    public static SendCallLogsComponent.Factory factory() {
        return new b(null);
    }

    @Override // com.avito.android.in_app_calls.di.SendCallLogsComponent
    public void inject(SendCallLogsWorker sendCallLogsWorker) {
        SendCallLogsWorker_MembersInjector.injectLogUploader(sendCallLogsWorker, new LogUploader((CallsApi) Preconditions.checkNotNullFromComponent(this.a.callsApi()), (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3())));
        SendCallLogsWorker_MembersInjector.injectLogFileProvider(sendCallLogsWorker, (LogFileProvider) Preconditions.checkNotNullFromComponent(this.a.logFileProvider()));
        SendCallLogsWorker_MembersInjector.injectAnalytics(sendCallLogsWorker, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
        SendCallLogsWorker_MembersInjector.injectErrorTracker(sendCallLogsWorker, (ErrorTracker) Preconditions.checkNotNullFromComponent(this.a.errorTracker()));
    }
}
