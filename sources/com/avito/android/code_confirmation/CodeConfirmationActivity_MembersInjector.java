package com.avito.android.code_confirmation;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.util.DialogRouter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class CodeConfirmationActivity_MembersInjector implements MembersInjector<CodeConfirmationActivity> {
    public final Provider<CodeConfirmationPresenter> a;
    public final Provider<ActivityIntentFactory> b;
    public final Provider<Analytics> c;
    public final Provider<DeepLinkIntentFactory> d;
    public final Provider<DialogRouter> e;

    public CodeConfirmationActivity_MembersInjector(Provider<CodeConfirmationPresenter> provider, Provider<ActivityIntentFactory> provider2, Provider<Analytics> provider3, Provider<DeepLinkIntentFactory> provider4, Provider<DialogRouter> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static MembersInjector<CodeConfirmationActivity> create(Provider<CodeConfirmationPresenter> provider, Provider<ActivityIntentFactory> provider2, Provider<Analytics> provider3, Provider<DeepLinkIntentFactory> provider4, Provider<DialogRouter> provider5) {
        return new CodeConfirmationActivity_MembersInjector(provider, provider2, provider3, provider4, provider5);
    }

    @InjectedFieldSignature("com.avito.android.code_confirmation.CodeConfirmationActivity.analytics")
    public static void injectAnalytics(CodeConfirmationActivity codeConfirmationActivity, Analytics analytics) {
        codeConfirmationActivity.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.code_confirmation.CodeConfirmationActivity.deepLinkIntentFactory")
    public static void injectDeepLinkIntentFactory(CodeConfirmationActivity codeConfirmationActivity, DeepLinkIntentFactory deepLinkIntentFactory) {
        codeConfirmationActivity.deepLinkIntentFactory = deepLinkIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.code_confirmation.CodeConfirmationActivity.dialogRouter")
    public static void injectDialogRouter(CodeConfirmationActivity codeConfirmationActivity, DialogRouter dialogRouter) {
        codeConfirmationActivity.dialogRouter = dialogRouter;
    }

    @InjectedFieldSignature("com.avito.android.code_confirmation.CodeConfirmationActivity.intentFactory")
    public static void injectIntentFactory(CodeConfirmationActivity codeConfirmationActivity, ActivityIntentFactory activityIntentFactory) {
        codeConfirmationActivity.intentFactory = activityIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.code_confirmation.CodeConfirmationActivity.presenter")
    public static void injectPresenter(CodeConfirmationActivity codeConfirmationActivity, CodeConfirmationPresenter codeConfirmationPresenter) {
        codeConfirmationActivity.presenter = codeConfirmationPresenter;
    }

    public void injectMembers(CodeConfirmationActivity codeConfirmationActivity) {
        injectPresenter(codeConfirmationActivity, this.a.get());
        injectIntentFactory(codeConfirmationActivity, this.b.get());
        injectAnalytics(codeConfirmationActivity, this.c.get());
        injectDeepLinkIntentFactory(codeConfirmationActivity, this.d.get());
        injectDialogRouter(codeConfirmationActivity, this.e.get());
    }
}
