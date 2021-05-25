package com.avito.android.messenger.conversation.mvi.file_upload;

import android.app.Application;
import com.avito.android.messenger.conversation.mvi.file_attachment.FileStorageHelper;
import com.avito.android.util.BuildInfo;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
public final class FileUploadInitializerImpl_Factory implements Factory<FileUploadInitializerImpl> {
    public final Provider<Application> a;
    public final Provider<OkHttpClient> b;
    public final Provider<BuildInfo> c;
    public final Provider<UploadStatusUpdatesHandler> d;
    public final Provider<FileStorageHelper> e;

    public FileUploadInitializerImpl_Factory(Provider<Application> provider, Provider<OkHttpClient> provider2, Provider<BuildInfo> provider3, Provider<UploadStatusUpdatesHandler> provider4, Provider<FileStorageHelper> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static FileUploadInitializerImpl_Factory create(Provider<Application> provider, Provider<OkHttpClient> provider2, Provider<BuildInfo> provider3, Provider<UploadStatusUpdatesHandler> provider4, Provider<FileStorageHelper> provider5) {
        return new FileUploadInitializerImpl_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static FileUploadInitializerImpl newInstance(Application application, Lazy<OkHttpClient> lazy, BuildInfo buildInfo, UploadStatusUpdatesHandler uploadStatusUpdatesHandler, FileStorageHelper fileStorageHelper) {
        return new FileUploadInitializerImpl(application, lazy, buildInfo, uploadStatusUpdatesHandler, fileStorageHelper);
    }

    @Override // javax.inject.Provider
    public FileUploadInitializerImpl get() {
        return newInstance(this.a.get(), DoubleCheck.lazy(this.b), this.c.get(), this.d.get(), this.e.get());
    }
}
