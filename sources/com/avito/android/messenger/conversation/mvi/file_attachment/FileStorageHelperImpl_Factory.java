package com.avito.android.messenger.conversation.mvi.file_attachment;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class FileStorageHelperImpl_Factory implements Factory<FileStorageHelperImpl> {
    public final Provider<Context> a;

    public FileStorageHelperImpl_Factory(Provider<Context> provider) {
        this.a = provider;
    }

    public static FileStorageHelperImpl_Factory create(Provider<Context> provider) {
        return new FileStorageHelperImpl_Factory(provider);
    }

    public static FileStorageHelperImpl newInstance(Context context) {
        return new FileStorageHelperImpl(context);
    }

    @Override // javax.inject.Provider
    public FileStorageHelperImpl get() {
        return newInstance(this.a.get());
    }
}
