package com.avito.android.messenger.conversation.mvi.file_upload;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class UploadServiceStarterImpl_Factory implements Factory<UploadServiceStarterImpl> {
    public final Provider<Context> a;
    public final Provider<MessengerFileUploadConfigProvider> b;

    public UploadServiceStarterImpl_Factory(Provider<Context> provider, Provider<MessengerFileUploadConfigProvider> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static UploadServiceStarterImpl_Factory create(Provider<Context> provider, Provider<MessengerFileUploadConfigProvider> provider2) {
        return new UploadServiceStarterImpl_Factory(provider, provider2);
    }

    public static UploadServiceStarterImpl newInstance(Context context, MessengerFileUploadConfigProvider messengerFileUploadConfigProvider) {
        return new UploadServiceStarterImpl(context, messengerFileUploadConfigProvider);
    }

    @Override // javax.inject.Provider
    public UploadServiceStarterImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
