package com.avito.android.advert.notes;

import com.avito.android.advert_details.remote.AdvertDetailsApi;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class EditAdvertNoteInteractorImpl_Factory implements Factory<EditAdvertNoteInteractorImpl> {
    public final Provider<AdvertDetailsApi> a;
    public final Provider<SchedulersFactory3> b;
    public final Provider<TypedErrorThrowableConverter> c;

    public EditAdvertNoteInteractorImpl_Factory(Provider<AdvertDetailsApi> provider, Provider<SchedulersFactory3> provider2, Provider<TypedErrorThrowableConverter> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static EditAdvertNoteInteractorImpl_Factory create(Provider<AdvertDetailsApi> provider, Provider<SchedulersFactory3> provider2, Provider<TypedErrorThrowableConverter> provider3) {
        return new EditAdvertNoteInteractorImpl_Factory(provider, provider2, provider3);
    }

    public static EditAdvertNoteInteractorImpl newInstance(AdvertDetailsApi advertDetailsApi, SchedulersFactory3 schedulersFactory3, TypedErrorThrowableConverter typedErrorThrowableConverter) {
        return new EditAdvertNoteInteractorImpl(advertDetailsApi, schedulersFactory3, typedErrorThrowableConverter);
    }

    @Override // javax.inject.Provider
    public EditAdvertNoteInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
