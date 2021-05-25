package com.avito.android.profile_phones.phone_management;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.util.DialogRouter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class PhoneManagementActivity_MembersInjector implements MembersInjector<PhoneManagementActivity> {
    public final Provider<ActivityIntentFactory> a;
    public final Provider<DeepLinkIntentFactory> b;
    public final Provider<PhoneManagementPresenter> c;
    public final Provider<DialogRouter> d;

    public PhoneManagementActivity_MembersInjector(Provider<ActivityIntentFactory> provider, Provider<DeepLinkIntentFactory> provider2, Provider<PhoneManagementPresenter> provider3, Provider<DialogRouter> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static MembersInjector<PhoneManagementActivity> create(Provider<ActivityIntentFactory> provider, Provider<DeepLinkIntentFactory> provider2, Provider<PhoneManagementPresenter> provider3, Provider<DialogRouter> provider4) {
        return new PhoneManagementActivity_MembersInjector(provider, provider2, provider3, provider4);
    }

    @InjectedFieldSignature("com.avito.android.profile_phones.phone_management.PhoneManagementActivity.deepLinkIntentFactory")
    public static void injectDeepLinkIntentFactory(PhoneManagementActivity phoneManagementActivity, DeepLinkIntentFactory deepLinkIntentFactory) {
        phoneManagementActivity.deepLinkIntentFactory = deepLinkIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.profile_phones.phone_management.PhoneManagementActivity.dialogRouter")
    public static void injectDialogRouter(PhoneManagementActivity phoneManagementActivity, DialogRouter dialogRouter) {
        phoneManagementActivity.dialogRouter = dialogRouter;
    }

    @InjectedFieldSignature("com.avito.android.profile_phones.phone_management.PhoneManagementActivity.intentFactory")
    public static void injectIntentFactory(PhoneManagementActivity phoneManagementActivity, ActivityIntentFactory activityIntentFactory) {
        phoneManagementActivity.intentFactory = activityIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.profile_phones.phone_management.PhoneManagementActivity.presenter")
    public static void injectPresenter(PhoneManagementActivity phoneManagementActivity, PhoneManagementPresenter phoneManagementPresenter) {
        phoneManagementActivity.presenter = phoneManagementPresenter;
    }

    public void injectMembers(PhoneManagementActivity phoneManagementActivity) {
        injectIntentFactory(phoneManagementActivity, this.a.get());
        injectDeepLinkIntentFactory(phoneManagementActivity, this.b.get());
        injectPresenter(phoneManagementActivity, this.c.get());
        injectDialogRouter(phoneManagementActivity, this.d.get());
    }
}
