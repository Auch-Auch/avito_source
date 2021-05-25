package com.avito.android.location_picker.job;

import com.avito.android.remote.LocationApi;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class JobAssistantInteractorImpl_Factory implements Factory<JobAssistantInteractorImpl> {
    public final Provider<LocationApi> a;

    public JobAssistantInteractorImpl_Factory(Provider<LocationApi> provider) {
        this.a = provider;
    }

    public static JobAssistantInteractorImpl_Factory create(Provider<LocationApi> provider) {
        return new JobAssistantInteractorImpl_Factory(provider);
    }

    public static JobAssistantInteractorImpl newInstance(LocationApi locationApi) {
        return new JobAssistantInteractorImpl(locationApi);
    }

    @Override // javax.inject.Provider
    public JobAssistantInteractorImpl get() {
        return newInstance(this.a.get());
    }
}
