package com.avito.android.advert_core.phone_request;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.util.Formatter;
import com.avito.android.util.PhoneNumberFormatterModule;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class PhoneRequestDeepLinkActivity_MembersInjector implements MembersInjector<PhoneRequestDeepLinkActivity> {
    public final Provider<ActivityIntentFactory> a;
    public final Provider<PhoneRequestPresenter> b;
    public final Provider<Formatter<String>> c;

    public PhoneRequestDeepLinkActivity_MembersInjector(Provider<ActivityIntentFactory> provider, Provider<PhoneRequestPresenter> provider2, Provider<Formatter<String>> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static MembersInjector<PhoneRequestDeepLinkActivity> create(Provider<ActivityIntentFactory> provider, Provider<PhoneRequestPresenter> provider2, Provider<Formatter<String>> provider3) {
        return new PhoneRequestDeepLinkActivity_MembersInjector(provider, provider2, provider3);
    }

    @InjectedFieldSignature("com.avito.android.advert_core.phone_request.PhoneRequestDeepLinkActivity.activityIntentFactory")
    public static void injectActivityIntentFactory(PhoneRequestDeepLinkActivity phoneRequestDeepLinkActivity, ActivityIntentFactory activityIntentFactory) {
        phoneRequestDeepLinkActivity.activityIntentFactory = activityIntentFactory;
    }

    @PhoneNumberFormatterModule.PhoneNumberFormatterWithCountryCode
    @InjectedFieldSignature("com.avito.android.advert_core.phone_request.PhoneRequestDeepLinkActivity.phoneNumberFormatter")
    public static void injectPhoneNumberFormatter(PhoneRequestDeepLinkActivity phoneRequestDeepLinkActivity, Formatter<String> formatter) {
        phoneRequestDeepLinkActivity.phoneNumberFormatter = formatter;
    }

    @InjectedFieldSignature("com.avito.android.advert_core.phone_request.PhoneRequestDeepLinkActivity.presenter")
    public static void injectPresenter(PhoneRequestDeepLinkActivity phoneRequestDeepLinkActivity, PhoneRequestPresenter phoneRequestPresenter) {
        phoneRequestDeepLinkActivity.presenter = phoneRequestPresenter;
    }

    public void injectMembers(PhoneRequestDeepLinkActivity phoneRequestDeepLinkActivity) {
        injectActivityIntentFactory(phoneRequestDeepLinkActivity, this.a.get());
        injectPresenter(phoneRequestDeepLinkActivity, this.b.get());
        injectPhoneNumberFormatter(phoneRequestDeepLinkActivity, this.c.get());
    }
}
