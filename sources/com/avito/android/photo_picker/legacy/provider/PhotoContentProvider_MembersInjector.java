package com.avito.android.photo_picker.legacy.provider;

import com.avito.android.util.ContentProviderDelegate;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class PhotoContentProvider_MembersInjector implements MembersInjector<PhotoContentProvider> {
    public final Provider<ContentProviderDelegate> a;

    public PhotoContentProvider_MembersInjector(Provider<ContentProviderDelegate> provider) {
        this.a = provider;
    }

    public static MembersInjector<PhotoContentProvider> create(Provider<ContentProviderDelegate> provider) {
        return new PhotoContentProvider_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.avito.android.photo_picker.legacy.provider.PhotoContentProvider.delegate")
    public static void injectDelegate(PhotoContentProvider photoContentProvider, ContentProviderDelegate contentProviderDelegate) {
        photoContentProvider.delegate = contentProviderDelegate;
    }

    public void injectMembers(PhotoContentProvider photoContentProvider) {
        injectDelegate(photoContentProvider, this.a.get());
    }
}
