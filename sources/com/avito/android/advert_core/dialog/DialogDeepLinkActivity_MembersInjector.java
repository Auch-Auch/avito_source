package com.avito.android.advert_core.dialog;

import com.avito.android.deep_linking.DeepLinkIntentFactory;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class DialogDeepLinkActivity_MembersInjector implements MembersInjector<DialogDeepLinkActivity> {
    public final Provider<DeepLinkIntentFactory> a;

    public DialogDeepLinkActivity_MembersInjector(Provider<DeepLinkIntentFactory> provider) {
        this.a = provider;
    }

    public static MembersInjector<DialogDeepLinkActivity> create(Provider<DeepLinkIntentFactory> provider) {
        return new DialogDeepLinkActivity_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.avito.android.advert_core.dialog.DialogDeepLinkActivity.intentFactory")
    public static void injectIntentFactory(DialogDeepLinkActivity dialogDeepLinkActivity, DeepLinkIntentFactory deepLinkIntentFactory) {
        dialogDeepLinkActivity.intentFactory = deepLinkIntentFactory;
    }

    public void injectMembers(DialogDeepLinkActivity dialogDeepLinkActivity) {
        injectIntentFactory(dialogDeepLinkActivity, this.a.get());
    }
}
