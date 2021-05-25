package com.avito.android.service.short_task;

import com.avito.android.Features;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
public final class TimeRequestTask_MembersInjector implements MembersInjector<TimeRequestTask> {
    public final Provider<OkHttpClient> a;
    public final Provider<Features> b;
    public final Provider<CheckCertPinningInterceptor> c;
    public final Provider<TimeDiffAnalyticsInterceptor> d;

    public TimeRequestTask_MembersInjector(Provider<OkHttpClient> provider, Provider<Features> provider2, Provider<CheckCertPinningInterceptor> provider3, Provider<TimeDiffAnalyticsInterceptor> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static MembersInjector<TimeRequestTask> create(Provider<OkHttpClient> provider, Provider<Features> provider2, Provider<CheckCertPinningInterceptor> provider3, Provider<TimeDiffAnalyticsInterceptor> provider4) {
        return new TimeRequestTask_MembersInjector(provider, provider2, provider3, provider4);
    }

    @InjectedFieldSignature("com.avito.android.service.short_task.TimeRequestTask.features")
    public static void injectFeatures(TimeRequestTask timeRequestTask, Features features) {
        timeRequestTask.features = features;
    }

    @InjectedFieldSignature("com.avito.android.service.short_task.TimeRequestTask.httpClient")
    public static void injectHttpClient(TimeRequestTask timeRequestTask, OkHttpClient okHttpClient) {
        timeRequestTask.httpClient = okHttpClient;
    }

    @InjectedFieldSignature("com.avito.android.service.short_task.TimeRequestTask.pinningInterceptor")
    public static void injectPinningInterceptor(TimeRequestTask timeRequestTask, CheckCertPinningInterceptor checkCertPinningInterceptor) {
        timeRequestTask.pinningInterceptor = checkCertPinningInterceptor;
    }

    @InjectedFieldSignature("com.avito.android.service.short_task.TimeRequestTask.timeDiffAnalyticsInterceptor")
    public static void injectTimeDiffAnalyticsInterceptor(TimeRequestTask timeRequestTask, TimeDiffAnalyticsInterceptor timeDiffAnalyticsInterceptor) {
        timeRequestTask.timeDiffAnalyticsInterceptor = timeDiffAnalyticsInterceptor;
    }

    public void injectMembers(TimeRequestTask timeRequestTask) {
        injectHttpClient(timeRequestTask, this.a.get());
        injectFeatures(timeRequestTask, this.b.get());
        injectPinningInterceptor(timeRequestTask, this.c.get());
        injectTimeDiffAnalyticsInterceptor(timeRequestTask, this.d.get());
    }
}
