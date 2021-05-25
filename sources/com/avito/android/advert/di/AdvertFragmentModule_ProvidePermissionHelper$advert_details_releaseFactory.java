package com.avito.android.advert.di;

import com.avito.android.advert.item.AdvertDetailsFragmentDelegate;
import com.avito.android.permissions.PermissionHelper;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class AdvertFragmentModule_ProvidePermissionHelper$advert_details_releaseFactory implements Factory<PermissionHelper> {
    public final Provider<AdvertDetailsFragmentDelegate> a;

    public AdvertFragmentModule_ProvidePermissionHelper$advert_details_releaseFactory(Provider<AdvertDetailsFragmentDelegate> provider) {
        this.a = provider;
    }

    public static AdvertFragmentModule_ProvidePermissionHelper$advert_details_releaseFactory create(Provider<AdvertDetailsFragmentDelegate> provider) {
        return new AdvertFragmentModule_ProvidePermissionHelper$advert_details_releaseFactory(provider);
    }

    public static PermissionHelper providePermissionHelper$advert_details_release(AdvertDetailsFragmentDelegate advertDetailsFragmentDelegate) {
        return (PermissionHelper) Preconditions.checkNotNullFromProvides(AdvertFragmentModule.INSTANCE.providePermissionHelper$advert_details_release(advertDetailsFragmentDelegate));
    }

    @Override // javax.inject.Provider
    public PermissionHelper get() {
        return providePermissionHelper$advert_details_release(this.a.get());
    }
}
