package com.avito.android.advert.consultation_form;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class ConsultationFormActivity_MembersInjector implements MembersInjector<ConsultationFormActivity> {
    public final Provider<ConsultationFormViewModelFactory> a;
    public final Provider<ActivityIntentFactory> b;
    public final Provider<DeepLinkIntentFactory> c;

    public ConsultationFormActivity_MembersInjector(Provider<ConsultationFormViewModelFactory> provider, Provider<ActivityIntentFactory> provider2, Provider<DeepLinkIntentFactory> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static MembersInjector<ConsultationFormActivity> create(Provider<ConsultationFormViewModelFactory> provider, Provider<ActivityIntentFactory> provider2, Provider<DeepLinkIntentFactory> provider3) {
        return new ConsultationFormActivity_MembersInjector(provider, provider2, provider3);
    }

    @InjectedFieldSignature("com.avito.android.advert.consultation_form.ConsultationFormActivity.deepLinkIntentFactory")
    public static void injectDeepLinkIntentFactory(ConsultationFormActivity consultationFormActivity, DeepLinkIntentFactory deepLinkIntentFactory) {
        consultationFormActivity.deepLinkIntentFactory = deepLinkIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.advert.consultation_form.ConsultationFormActivity.intentFactory")
    public static void injectIntentFactory(ConsultationFormActivity consultationFormActivity, ActivityIntentFactory activityIntentFactory) {
        consultationFormActivity.intentFactory = activityIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.advert.consultation_form.ConsultationFormActivity.viewModelFactory")
    public static void injectViewModelFactory(ConsultationFormActivity consultationFormActivity, ConsultationFormViewModelFactory consultationFormViewModelFactory) {
        consultationFormActivity.viewModelFactory = consultationFormViewModelFactory;
    }

    public void injectMembers(ConsultationFormActivity consultationFormActivity) {
        injectViewModelFactory(consultationFormActivity, this.a.get());
        injectIntentFactory(consultationFormActivity, this.b.get());
        injectDeepLinkIntentFactory(consultationFormActivity, this.c.get());
    }
}
