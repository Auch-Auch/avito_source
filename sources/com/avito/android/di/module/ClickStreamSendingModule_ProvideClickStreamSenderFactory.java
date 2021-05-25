package com.avito.android.di.module;

import android.app.Application;
import com.avito.android.analytics.clickstream.ClickStreamApi;
import com.avito.android.analytics.clickstream.ClickStreamSender;
import com.avito.android.analytics.inhouse_transport.InHouseEventStorage;
import com.avito.android.remote.DeviceIdProvider;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import proto.events.apps.EventOuterClass;
public final class ClickStreamSendingModule_ProvideClickStreamSenderFactory implements Factory<ClickStreamSender> {
    public final Provider<ClickStreamApi> a;
    public final Provider<InHouseEventStorage<EventOuterClass.Event>> b;
    public final Provider<DeviceIdProvider> c;
    public final Provider<ClickStreamSender.CommonParametersProvider> d;
    public final Provider<SchedulersFactory> e;
    public final Provider<BuildInfo> f;
    public final Provider<Application> g;

    public ClickStreamSendingModule_ProvideClickStreamSenderFactory(Provider<ClickStreamApi> provider, Provider<InHouseEventStorage<EventOuterClass.Event>> provider2, Provider<DeviceIdProvider> provider3, Provider<ClickStreamSender.CommonParametersProvider> provider4, Provider<SchedulersFactory> provider5, Provider<BuildInfo> provider6, Provider<Application> provider7) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
    }

    public static ClickStreamSendingModule_ProvideClickStreamSenderFactory create(Provider<ClickStreamApi> provider, Provider<InHouseEventStorage<EventOuterClass.Event>> provider2, Provider<DeviceIdProvider> provider3, Provider<ClickStreamSender.CommonParametersProvider> provider4, Provider<SchedulersFactory> provider5, Provider<BuildInfo> provider6, Provider<Application> provider7) {
        return new ClickStreamSendingModule_ProvideClickStreamSenderFactory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static ClickStreamSender provideClickStreamSender(ClickStreamApi clickStreamApi, InHouseEventStorage<EventOuterClass.Event> inHouseEventStorage, DeviceIdProvider deviceIdProvider, ClickStreamSender.CommonParametersProvider commonParametersProvider, SchedulersFactory schedulersFactory, BuildInfo buildInfo, Application application) {
        return (ClickStreamSender) Preconditions.checkNotNullFromProvides(ClickStreamSendingModule.provideClickStreamSender(clickStreamApi, inHouseEventStorage, deviceIdProvider, commonParametersProvider, schedulersFactory, buildInfo, application));
    }

    @Override // javax.inject.Provider
    public ClickStreamSender get() {
        return provideClickStreamSender(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get());
    }
}
