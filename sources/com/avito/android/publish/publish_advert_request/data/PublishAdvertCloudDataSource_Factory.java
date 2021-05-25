package com.avito.android.publish.publish_advert_request.data;

import com.avito.android.remote.PublishApi;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class PublishAdvertCloudDataSource_Factory implements Factory<PublishAdvertCloudDataSource> {
    public final Provider<PublishApi> a;

    public PublishAdvertCloudDataSource_Factory(Provider<PublishApi> provider) {
        this.a = provider;
    }

    public static PublishAdvertCloudDataSource_Factory create(Provider<PublishApi> provider) {
        return new PublishAdvertCloudDataSource_Factory(provider);
    }

    public static PublishAdvertCloudDataSource newInstance(PublishApi publishApi) {
        return new PublishAdvertCloudDataSource(publishApi);
    }

    @Override // javax.inject.Provider
    public PublishAdvertCloudDataSource get() {
        return newInstance(this.a.get());
    }
}
