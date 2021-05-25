package com.avito.android.in_app_calls.logging;

import com.avito.android.analytics.Analytics;
import com.avito.android.communications_common.analytics.ErrorTracker;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class SendCallLogsWorker_MembersInjector implements MembersInjector<SendCallLogsWorker> {
    public final Provider<LogUploader> a;
    public final Provider<LogFileProvider> b;
    public final Provider<Analytics> c;
    public final Provider<ErrorTracker> d;

    public SendCallLogsWorker_MembersInjector(Provider<LogUploader> provider, Provider<LogFileProvider> provider2, Provider<Analytics> provider3, Provider<ErrorTracker> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static MembersInjector<SendCallLogsWorker> create(Provider<LogUploader> provider, Provider<LogFileProvider> provider2, Provider<Analytics> provider3, Provider<ErrorTracker> provider4) {
        return new SendCallLogsWorker_MembersInjector(provider, provider2, provider3, provider4);
    }

    @InjectedFieldSignature("com.avito.android.in_app_calls.logging.SendCallLogsWorker.analytics")
    public static void injectAnalytics(SendCallLogsWorker sendCallLogsWorker, Analytics analytics) {
        sendCallLogsWorker.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.in_app_calls.logging.SendCallLogsWorker.errorTracker")
    public static void injectErrorTracker(SendCallLogsWorker sendCallLogsWorker, ErrorTracker errorTracker) {
        sendCallLogsWorker.errorTracker = errorTracker;
    }

    @InjectedFieldSignature("com.avito.android.in_app_calls.logging.SendCallLogsWorker.logFileProvider")
    public static void injectLogFileProvider(SendCallLogsWorker sendCallLogsWorker, LogFileProvider logFileProvider) {
        sendCallLogsWorker.logFileProvider = logFileProvider;
    }

    @InjectedFieldSignature("com.avito.android.in_app_calls.logging.SendCallLogsWorker.logUploader")
    public static void injectLogUploader(SendCallLogsWorker sendCallLogsWorker, LogUploader logUploader) {
        sendCallLogsWorker.logUploader = logUploader;
    }

    public void injectMembers(SendCallLogsWorker sendCallLogsWorker) {
        injectLogUploader(sendCallLogsWorker, this.a.get());
        injectLogFileProvider(sendCallLogsWorker, this.b.get());
        injectAnalytics(sendCallLogsWorker, this.c.get());
        injectErrorTracker(sendCallLogsWorker, this.d.get());
    }
}
