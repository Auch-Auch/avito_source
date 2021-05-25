package com.avito.android.contact_access;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class ContactAccessServiceFragment_MembersInjector implements MembersInjector<ContactAccessServiceFragment> {
    public final Provider<ActivityIntentFactory> a;
    public final Provider<DeepLinkIntentFactory> b;
    public final Provider<ContactAccessServicePresenter> c;
    public final Provider<Analytics> d;

    public ContactAccessServiceFragment_MembersInjector(Provider<ActivityIntentFactory> provider, Provider<DeepLinkIntentFactory> provider2, Provider<ContactAccessServicePresenter> provider3, Provider<Analytics> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static MembersInjector<ContactAccessServiceFragment> create(Provider<ActivityIntentFactory> provider, Provider<DeepLinkIntentFactory> provider2, Provider<ContactAccessServicePresenter> provider3, Provider<Analytics> provider4) {
        return new ContactAccessServiceFragment_MembersInjector(provider, provider2, provider3, provider4);
    }

    @InjectedFieldSignature("com.avito.android.contact_access.ContactAccessServiceFragment.activityIntentFactory")
    public static void injectActivityIntentFactory(ContactAccessServiceFragment contactAccessServiceFragment, ActivityIntentFactory activityIntentFactory) {
        contactAccessServiceFragment.activityIntentFactory = activityIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.contact_access.ContactAccessServiceFragment.analytics")
    public static void injectAnalytics(ContactAccessServiceFragment contactAccessServiceFragment, Analytics analytics) {
        contactAccessServiceFragment.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.contact_access.ContactAccessServiceFragment.deepLinkIntentFactory")
    public static void injectDeepLinkIntentFactory(ContactAccessServiceFragment contactAccessServiceFragment, DeepLinkIntentFactory deepLinkIntentFactory) {
        contactAccessServiceFragment.deepLinkIntentFactory = deepLinkIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.contact_access.ContactAccessServiceFragment.presenter")
    public static void injectPresenter(ContactAccessServiceFragment contactAccessServiceFragment, ContactAccessServicePresenter contactAccessServicePresenter) {
        contactAccessServiceFragment.presenter = contactAccessServicePresenter;
    }

    public void injectMembers(ContactAccessServiceFragment contactAccessServiceFragment) {
        injectActivityIntentFactory(contactAccessServiceFragment, this.a.get());
        injectDeepLinkIntentFactory(contactAccessServiceFragment, this.b.get());
        injectPresenter(contactAccessServiceFragment, this.c.get());
        injectAnalytics(contactAccessServiceFragment, this.d.get());
    }
}
