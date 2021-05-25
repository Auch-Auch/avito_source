package com.avito.android.messenger.channels.mvi.interactor;

import com.avito.android.ab_tests.groups.MessengerFolderTabsTestGroup;
import com.avito.android.ab_tests.models.ManuallyExposedAbTestGroup;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
import ru.avito.messenger.MessengerClient;
import ru.avito.messenger.api.AvitoMessengerApi;
public final class FoldersInteractorImpl_Factory implements Factory<FoldersInteractorImpl> {
    public final Provider<SchedulersFactory> a;
    public final Provider<ManuallyExposedAbTestGroup<MessengerFolderTabsTestGroup>> b;
    public final Provider<MessengerClient<AvitoMessengerApi>> c;

    public FoldersInteractorImpl_Factory(Provider<SchedulersFactory> provider, Provider<ManuallyExposedAbTestGroup<MessengerFolderTabsTestGroup>> provider2, Provider<MessengerClient<AvitoMessengerApi>> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static FoldersInteractorImpl_Factory create(Provider<SchedulersFactory> provider, Provider<ManuallyExposedAbTestGroup<MessengerFolderTabsTestGroup>> provider2, Provider<MessengerClient<AvitoMessengerApi>> provider3) {
        return new FoldersInteractorImpl_Factory(provider, provider2, provider3);
    }

    public static FoldersInteractorImpl newInstance(SchedulersFactory schedulersFactory, ManuallyExposedAbTestGroup<MessengerFolderTabsTestGroup> manuallyExposedAbTestGroup, MessengerClient<AvitoMessengerApi> messengerClient) {
        return new FoldersInteractorImpl(schedulersFactory, manuallyExposedAbTestGroup, messengerClient);
    }

    @Override // javax.inject.Provider
    public FoldersInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
