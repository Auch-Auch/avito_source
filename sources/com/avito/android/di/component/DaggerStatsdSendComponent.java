package com.avito.android.di.component;

import com.avito.android.analytics.inhouse_transport.InHouseEventStorage;
import com.avito.android.analytics.provider.statsd.SendStatsdEventsTask;
import com.avito.android.analytics.provider.statsd.SendStatsdEventsTask_MembersInjector;
import com.avito.android.analytics.statsd.SendStatsdEventsTaskDelegate;
import com.avito.android.analytics.statsd.SendStatsdEventsTaskDelegateImpl;
import com.avito.android.analytics.statsd.SendStatsdEventsTaskDelegateImpl_Factory;
import com.avito.android.analytics.statsd.StatsdApi;
import com.avito.android.analytics.statsd.StatsdRecord;
import com.avito.android.analytics.statsd.StatsdSender;
import com.avito.android.analytics.statsd.StatsdSenderImpl;
import com.avito.android.analytics.statsd.StatsdSenderImpl_Factory;
import com.avito.android.di.StatsdSendDependencies;
import com.avito.android.di.component.StatsdSendComponent;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class DaggerStatsdSendComponent implements StatsdSendComponent {
    public Provider<StatsdApi> a;
    public Provider<InHouseEventStorage<StatsdRecord>> b;
    public Provider<SchedulersFactory> c;
    public Provider<StatsdSenderImpl> d;
    public Provider<StatsdSender> e;
    public Provider<SendStatsdEventsTaskDelegateImpl> f;
    public Provider<SendStatsdEventsTaskDelegate> g;

    public static final class b implements StatsdSendComponent.Builder {
        public StatsdSendDependencies a;

        public b(a aVar) {
        }

        @Override // com.avito.android.di.component.StatsdSendComponent.Builder
        public StatsdSendComponent build() {
            Preconditions.checkBuilderRequirement(this.a, StatsdSendDependencies.class);
            return new DaggerStatsdSendComponent(this.a, null);
        }

        @Override // com.avito.android.di.component.StatsdSendComponent.Builder
        public StatsdSendComponent.Builder dependencies(StatsdSendDependencies statsdSendDependencies) {
            this.a = (StatsdSendDependencies) Preconditions.checkNotNull(statsdSendDependencies);
            return this;
        }
    }

    public static class c implements Provider<SchedulersFactory> {
        public final StatsdSendDependencies a;

        public c(StatsdSendDependencies statsdSendDependencies) {
            this.a = statsdSendDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public static class d implements Provider<StatsdApi> {
        public final StatsdSendDependencies a;

        public d(StatsdSendDependencies statsdSendDependencies) {
            this.a = statsdSendDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public StatsdApi get() {
            return (StatsdApi) Preconditions.checkNotNullFromComponent(this.a.statsdApi());
        }
    }

    public static class e implements Provider<InHouseEventStorage<StatsdRecord>> {
        public final StatsdSendDependencies a;

        public e(StatsdSendDependencies statsdSendDependencies) {
            this.a = statsdSendDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public InHouseEventStorage<StatsdRecord> get() {
            return (InHouseEventStorage) Preconditions.checkNotNullFromComponent(this.a.statsdEventStorage());
        }
    }

    public DaggerStatsdSendComponent(StatsdSendDependencies statsdSendDependencies, a aVar) {
        d dVar = new d(statsdSendDependencies);
        this.a = dVar;
        e eVar = new e(statsdSendDependencies);
        this.b = eVar;
        c cVar = new c(statsdSendDependencies);
        this.c = cVar;
        StatsdSenderImpl_Factory create = StatsdSenderImpl_Factory.create(dVar, eVar, cVar);
        this.d = create;
        Provider<StatsdSender> provider = DoubleCheck.provider(create);
        this.e = provider;
        SendStatsdEventsTaskDelegateImpl_Factory create2 = SendStatsdEventsTaskDelegateImpl_Factory.create(provider);
        this.f = create2;
        this.g = DoubleCheck.provider(create2);
    }

    public static StatsdSendComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.di.component.StatsdSendComponent
    public void inject(SendStatsdEventsTask sendStatsdEventsTask) {
        SendStatsdEventsTask_MembersInjector.injectDelegate(sendStatsdEventsTask, this.g.get());
    }
}
