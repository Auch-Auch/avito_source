package com.avito.android.publish.di;

import com.avito.android.analytics.UnhandledPhotoPickerEvent;
import com.jakewharton.rxrelay3.PublishRelay;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class PublishPhotoPickerAnalyticsModule_ProvidePhotoPickerEventStreamFactory implements Factory<PublishRelay<UnhandledPhotoPickerEvent>> {

    public static final class a {
        public static final PublishPhotoPickerAnalyticsModule_ProvidePhotoPickerEventStreamFactory a = new PublishPhotoPickerAnalyticsModule_ProvidePhotoPickerEventStreamFactory();
    }

    public static PublishPhotoPickerAnalyticsModule_ProvidePhotoPickerEventStreamFactory create() {
        return a.a;
    }

    public static PublishRelay<UnhandledPhotoPickerEvent> providePhotoPickerEventStream() {
        return (PublishRelay) Preconditions.checkNotNullFromProvides(PublishPhotoPickerAnalyticsModule.INSTANCE.providePhotoPickerEventStream());
    }

    @Override // javax.inject.Provider
    public PublishRelay<UnhandledPhotoPickerEvent> get() {
        return providePhotoPickerEventStream();
    }
}
