package com.avito.android.messenger.channels.mvi.presenter;

import android.content.res.Resources;
import androidx.fragment.app.Fragment;
import com.avito.android.Features;
import com.avito.android.messenger.MessengerEntityConverter;
import com.avito.android.server_time.TimeSource;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ChannelsListDataConverterImpl_Factory implements Factory<ChannelsListDataConverterImpl> {
    public final Provider<Fragment> a;
    public final Provider<MessengerEntityConverter> b;
    public final Provider<Resources> c;
    public final Provider<LocalMessagePreviewProvider> d;
    public final Provider<TimeSource> e;
    public final Provider<Features> f;

    public ChannelsListDataConverterImpl_Factory(Provider<Fragment> provider, Provider<MessengerEntityConverter> provider2, Provider<Resources> provider3, Provider<LocalMessagePreviewProvider> provider4, Provider<TimeSource> provider5, Provider<Features> provider6) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
    }

    public static ChannelsListDataConverterImpl_Factory create(Provider<Fragment> provider, Provider<MessengerEntityConverter> provider2, Provider<Resources> provider3, Provider<LocalMessagePreviewProvider> provider4, Provider<TimeSource> provider5, Provider<Features> provider6) {
        return new ChannelsListDataConverterImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static ChannelsListDataConverterImpl newInstance(Fragment fragment, MessengerEntityConverter messengerEntityConverter, Resources resources, LocalMessagePreviewProvider localMessagePreviewProvider, TimeSource timeSource, Features features) {
        return new ChannelsListDataConverterImpl(fragment, messengerEntityConverter, resources, localMessagePreviewProvider, timeSource, features);
    }

    @Override // javax.inject.Provider
    public ChannelsListDataConverterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get());
    }
}
