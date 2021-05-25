package com.avito.android.util.di;

import android.app.Application;
import android.content.ClipboardManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ClipboardModule_ProvideClipboardManager$android_releaseFactory implements Factory<ClipboardManager> {
    public final Provider<Application> a;

    public ClipboardModule_ProvideClipboardManager$android_releaseFactory(Provider<Application> provider) {
        this.a = provider;
    }

    public static ClipboardModule_ProvideClipboardManager$android_releaseFactory create(Provider<Application> provider) {
        return new ClipboardModule_ProvideClipboardManager$android_releaseFactory(provider);
    }

    public static ClipboardManager provideClipboardManager$android_release(Application application) {
        return (ClipboardManager) Preconditions.checkNotNullFromProvides(ClipboardModule.provideClipboardManager$android_release(application));
    }

    @Override // javax.inject.Provider
    public ClipboardManager get() {
        return provideClipboardManager$android_release(this.a.get());
    }
}
