package com.avito.android.di;

import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.di.CheckRequestComponent;
import com.avito.android.service.short_task.CheckCertPinningInterceptor;
import com.avito.android.service.short_task.TimeDiffAnalyticsInterceptor;
import com.avito.android.service.short_task.TimeRequestTask;
import com.avito.android.service.short_task.TimeRequestTask_MembersInjector;
import com.google.gson.Gson;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.CertificatePinner;
import okhttp3.OkHttpClient;
public final class DaggerCheckRequestComponent implements CheckRequestComponent {
    public final CheckRequestDependencies a;
    public Provider<Gson> b;
    public Provider<TimeDiffAnalyticsInterceptor> c;

    public static final class b implements CheckRequestComponent.Builder {
        public CheckRequestDependencies a;

        public b(a aVar) {
        }

        @Override // com.avito.android.di.CheckRequestComponent.Builder
        public CheckRequestComponent build() {
            Preconditions.checkBuilderRequirement(this.a, CheckRequestDependencies.class);
            return new DaggerCheckRequestComponent(this.a, null);
        }

        @Override // com.avito.android.di.CheckRequestComponent.Builder
        public CheckRequestComponent.Builder dependencies(CheckRequestDependencies checkRequestDependencies) {
            this.a = (CheckRequestDependencies) Preconditions.checkNotNull(checkRequestDependencies);
            return this;
        }
    }

    public static class c implements Provider<Gson> {
        public final CheckRequestDependencies a;

        public c(CheckRequestDependencies checkRequestDependencies) {
            this.a = checkRequestDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Gson get() {
            return (Gson) Preconditions.checkNotNullFromComponent(this.a.gson());
        }
    }

    public DaggerCheckRequestComponent(CheckRequestDependencies checkRequestDependencies, a aVar) {
        this.a = checkRequestDependencies;
        c cVar = new c(checkRequestDependencies);
        this.b = cVar;
        this.c = DoubleCheck.provider(CheckRequestModule_ProvideTimeDiffAnalyticsInterceptorFactory.create(cVar));
    }

    public static CheckRequestComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.di.CheckRequestComponent
    public void inject(TimeRequestTask timeRequestTask) {
        TimeRequestTask_MembersInjector.injectHttpClient(timeRequestTask, (OkHttpClient) Preconditions.checkNotNullFromComponent(this.a.httpClient()));
        TimeRequestTask_MembersInjector.injectFeatures(timeRequestTask, (Features) Preconditions.checkNotNullFromComponent(this.a.features()));
        TimeRequestTask_MembersInjector.injectPinningInterceptor(timeRequestTask, new CheckCertPinningInterceptor((Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()), (CertificatePinner) Preconditions.checkNotNullFromComponent(this.a.pinner())));
        TimeRequestTask_MembersInjector.injectTimeDiffAnalyticsInterceptor(timeRequestTask, this.c.get());
    }
}
