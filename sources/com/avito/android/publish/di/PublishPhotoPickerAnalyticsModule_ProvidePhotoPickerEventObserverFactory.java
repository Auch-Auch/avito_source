package com.avito.android.publish.di;

import com.avito.android.analytics.UnhandledPhotoPickerEvent;
import com.jakewharton.rxrelay3.PublishRelay;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import io.reactivex.rxjava3.functions.Consumer;
import javax.inject.Provider;
public final class PublishPhotoPickerAnalyticsModule_ProvidePhotoPickerEventObserverFactory implements Factory<Consumer<UnhandledPhotoPickerEvent>> {
    public final Provider<PublishRelay<UnhandledPhotoPickerEvent>> a;

    public PublishPhotoPickerAnalyticsModule_ProvidePhotoPickerEventObserverFactory(Provider<PublishRelay<UnhandledPhotoPickerEvent>> provider) {
        this.a = provider;
    }

    public static PublishPhotoPickerAnalyticsModule_ProvidePhotoPickerEventObserverFactory create(Provider<PublishRelay<UnhandledPhotoPickerEvent>> provider) {
        return new PublishPhotoPickerAnalyticsModule_ProvidePhotoPickerEventObserverFactory(provider);
    }

    public static Consumer<UnhandledPhotoPickerEvent> providePhotoPickerEventObserver(PublishRelay<UnhandledPhotoPickerEvent> publishRelay) {
        return (Consumer) Preconditions.checkNotNullFromProvides(PublishPhotoPickerAnalyticsModule.INSTANCE.providePhotoPickerEventObserver(publishRelay));
    }

    @Override // javax.inject.Provider
    public Consumer<UnhandledPhotoPickerEvent> get() {
        return providePhotoPickerEventObserver(this.a.get());
    }
}
