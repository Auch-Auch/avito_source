package com.avito.android.messenger.conversation.create.phone_verification;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.analytics.Analytics;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class MessengerPhoneVerificationActivity_MembersInjector implements MembersInjector<MessengerPhoneVerificationActivity> {
    public final Provider<ActivityIntentFactory> a;
    public final Provider<Analytics> b;

    public MessengerPhoneVerificationActivity_MembersInjector(Provider<ActivityIntentFactory> provider, Provider<Analytics> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static MembersInjector<MessengerPhoneVerificationActivity> create(Provider<ActivityIntentFactory> provider, Provider<Analytics> provider2) {
        return new MessengerPhoneVerificationActivity_MembersInjector(provider, provider2);
    }

    @InjectedFieldSignature("com.avito.android.messenger.conversation.create.phone_verification.MessengerPhoneVerificationActivity.activityIntentFactory")
    public static void injectActivityIntentFactory(MessengerPhoneVerificationActivity messengerPhoneVerificationActivity, ActivityIntentFactory activityIntentFactory) {
        messengerPhoneVerificationActivity.activityIntentFactory = activityIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.messenger.conversation.create.phone_verification.MessengerPhoneVerificationActivity.analytics")
    public static void injectAnalytics(MessengerPhoneVerificationActivity messengerPhoneVerificationActivity, Analytics analytics) {
        messengerPhoneVerificationActivity.analytics = analytics;
    }

    public void injectMembers(MessengerPhoneVerificationActivity messengerPhoneVerificationActivity) {
        injectActivityIntentFactory(messengerPhoneVerificationActivity, this.a.get());
        injectAnalytics(messengerPhoneVerificationActivity, this.b.get());
    }
}
