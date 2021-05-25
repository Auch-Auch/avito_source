package com.avito.android.publish.edit_advert_request.data;

import com.avito.android.Features;
import com.avito.android.remote.PublishApi;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class EditAdvertCloudDataSource_Factory implements Factory<EditAdvertCloudDataSource> {
    public final Provider<PublishApi> a;
    public final Provider<Features> b;

    public EditAdvertCloudDataSource_Factory(Provider<PublishApi> provider, Provider<Features> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static EditAdvertCloudDataSource_Factory create(Provider<PublishApi> provider, Provider<Features> provider2) {
        return new EditAdvertCloudDataSource_Factory(provider, provider2);
    }

    public static EditAdvertCloudDataSource newInstance(PublishApi publishApi, Features features) {
        return new EditAdvertCloudDataSource(publishApi, features);
    }

    @Override // javax.inject.Provider
    public EditAdvertCloudDataSource get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
