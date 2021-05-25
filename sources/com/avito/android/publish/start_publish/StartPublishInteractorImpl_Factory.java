package com.avito.android.publish.start_publish;

import com.avito.android.publish.drafts.PublishDraftAvailabilityChecker;
import com.avito.android.publish.drafts.PublishDraftWiper;
import com.avito.android.util.SchedulersFactory3;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import javax.inject.Provider;
import ru.avito.component.floating_add_advert.AddAdvertInteractor;
public final class StartPublishInteractorImpl_Factory implements Factory<StartPublishInteractorImpl> {
    public final Provider<SchedulersFactory3> a;
    public final Provider<PublishDraftAvailabilityChecker> b;
    public final Provider<PublishDraftWiper> c;
    public final Provider<AddAdvertInteractor> d;

    public StartPublishInteractorImpl_Factory(Provider<SchedulersFactory3> provider, Provider<PublishDraftAvailabilityChecker> provider2, Provider<PublishDraftWiper> provider3, Provider<AddAdvertInteractor> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static StartPublishInteractorImpl_Factory create(Provider<SchedulersFactory3> provider, Provider<PublishDraftAvailabilityChecker> provider2, Provider<PublishDraftWiper> provider3, Provider<AddAdvertInteractor> provider4) {
        return new StartPublishInteractorImpl_Factory(provider, provider2, provider3, provider4);
    }

    public static StartPublishInteractorImpl newInstance(SchedulersFactory3 schedulersFactory3, Lazy<PublishDraftAvailabilityChecker> lazy, PublishDraftWiper publishDraftWiper, AddAdvertInteractor addAdvertInteractor) {
        return new StartPublishInteractorImpl(schedulersFactory3, lazy, publishDraftWiper, addAdvertInteractor);
    }

    @Override // javax.inject.Provider
    public StartPublishInteractorImpl get() {
        return newInstance(this.a.get(), DoubleCheck.lazy(this.b), this.c.get(), this.d.get());
    }
}
