package com.avito.android.feedback_adverts;

import dagger.internal.Factory;
import javax.inject.Provider;
import ru.avito.messenger.MessengerClient;
import ru.avito.messenger.api.AvitoMessengerApi;
public final class FeedbackAdvertsInteractorImpl_Factory implements Factory<FeedbackAdvertsInteractorImpl> {
    public final Provider<MessengerClient<AvitoMessengerApi>> a;

    public FeedbackAdvertsInteractorImpl_Factory(Provider<MessengerClient<AvitoMessengerApi>> provider) {
        this.a = provider;
    }

    public static FeedbackAdvertsInteractorImpl_Factory create(Provider<MessengerClient<AvitoMessengerApi>> provider) {
        return new FeedbackAdvertsInteractorImpl_Factory(provider);
    }

    public static FeedbackAdvertsInteractorImpl newInstance(MessengerClient<AvitoMessengerApi> messengerClient) {
        return new FeedbackAdvertsInteractorImpl(messengerClient);
    }

    @Override // javax.inject.Provider
    public FeedbackAdvertsInteractorImpl get() {
        return newInstance(this.a.get());
    }
}
