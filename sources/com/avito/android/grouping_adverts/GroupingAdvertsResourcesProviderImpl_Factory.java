package com.avito.android.grouping_adverts;

import android.content.res.Resources;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class GroupingAdvertsResourcesProviderImpl_Factory implements Factory<GroupingAdvertsResourcesProviderImpl> {
    public final Provider<Resources> a;

    public GroupingAdvertsResourcesProviderImpl_Factory(Provider<Resources> provider) {
        this.a = provider;
    }

    public static GroupingAdvertsResourcesProviderImpl_Factory create(Provider<Resources> provider) {
        return new GroupingAdvertsResourcesProviderImpl_Factory(provider);
    }

    public static GroupingAdvertsResourcesProviderImpl newInstance(Resources resources) {
        return new GroupingAdvertsResourcesProviderImpl(resources);
    }

    @Override // javax.inject.Provider
    public GroupingAdvertsResourcesProviderImpl get() {
        return newInstance(this.a.get());
    }
}
