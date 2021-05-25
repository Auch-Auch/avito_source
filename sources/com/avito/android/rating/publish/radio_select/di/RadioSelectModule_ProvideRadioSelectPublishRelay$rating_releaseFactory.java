package com.avito.android.rating.publish.radio_select.di;

import com.avito.android.rating.publish.radio_select.adapter.radio_select.RadioSelectItem;
import com.jakewharton.rxrelay3.PublishRelay;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class RadioSelectModule_ProvideRadioSelectPublishRelay$rating_releaseFactory implements Factory<PublishRelay<RadioSelectItem>> {

    public static final class a {
        public static final RadioSelectModule_ProvideRadioSelectPublishRelay$rating_releaseFactory a = new RadioSelectModule_ProvideRadioSelectPublishRelay$rating_releaseFactory();
    }

    public static RadioSelectModule_ProvideRadioSelectPublishRelay$rating_releaseFactory create() {
        return a.a;
    }

    public static PublishRelay<RadioSelectItem> provideRadioSelectPublishRelay$rating_release() {
        return (PublishRelay) Preconditions.checkNotNullFromProvides(RadioSelectModule.provideRadioSelectPublishRelay$rating_release());
    }

    @Override // javax.inject.Provider
    public PublishRelay<RadioSelectItem> get() {
        return provideRadioSelectPublishRelay$rating_release();
    }
}
