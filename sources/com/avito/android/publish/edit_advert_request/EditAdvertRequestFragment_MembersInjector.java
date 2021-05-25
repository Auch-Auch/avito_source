package com.avito.android.publish.edit_advert_request;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.progress_overlay.LoadingProgressOverlay;
import com.avito.android.util.DialogRouter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class EditAdvertRequestFragment_MembersInjector implements MembersInjector<EditAdvertRequestFragment> {
    public final Provider<EditAdvertRequestViewModelFactory> a;
    public final Provider<LoadingProgressOverlay> b;
    public final Provider<ActivityIntentFactory> c;
    public final Provider<DeepLinkIntentFactory> d;
    public final Provider<DialogRouter> e;

    public EditAdvertRequestFragment_MembersInjector(Provider<EditAdvertRequestViewModelFactory> provider, Provider<LoadingProgressOverlay> provider2, Provider<ActivityIntentFactory> provider3, Provider<DeepLinkIntentFactory> provider4, Provider<DialogRouter> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static MembersInjector<EditAdvertRequestFragment> create(Provider<EditAdvertRequestViewModelFactory> provider, Provider<LoadingProgressOverlay> provider2, Provider<ActivityIntentFactory> provider3, Provider<DeepLinkIntentFactory> provider4, Provider<DialogRouter> provider5) {
        return new EditAdvertRequestFragment_MembersInjector(provider, provider2, provider3, provider4, provider5);
    }

    @InjectedFieldSignature("com.avito.android.publish.edit_advert_request.EditAdvertRequestFragment.deepLinkIntentFactory")
    public static void injectDeepLinkIntentFactory(EditAdvertRequestFragment editAdvertRequestFragment, DeepLinkIntentFactory deepLinkIntentFactory) {
        editAdvertRequestFragment.deepLinkIntentFactory = deepLinkIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.publish.edit_advert_request.EditAdvertRequestFragment.dialogRouter")
    public static void injectDialogRouter(EditAdvertRequestFragment editAdvertRequestFragment, DialogRouter dialogRouter) {
        editAdvertRequestFragment.dialogRouter = dialogRouter;
    }

    @InjectedFieldSignature("com.avito.android.publish.edit_advert_request.EditAdvertRequestFragment.intentFactory")
    public static void injectIntentFactory(EditAdvertRequestFragment editAdvertRequestFragment, ActivityIntentFactory activityIntentFactory) {
        editAdvertRequestFragment.intentFactory = activityIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.publish.edit_advert_request.EditAdvertRequestFragment.loadingProgress")
    public static void injectLoadingProgress(EditAdvertRequestFragment editAdvertRequestFragment, LoadingProgressOverlay loadingProgressOverlay) {
        editAdvertRequestFragment.loadingProgress = loadingProgressOverlay;
    }

    @InjectedFieldSignature("com.avito.android.publish.edit_advert_request.EditAdvertRequestFragment.viewModelFactory")
    public static void injectViewModelFactory(EditAdvertRequestFragment editAdvertRequestFragment, EditAdvertRequestViewModelFactory editAdvertRequestViewModelFactory) {
        editAdvertRequestFragment.viewModelFactory = editAdvertRequestViewModelFactory;
    }

    public void injectMembers(EditAdvertRequestFragment editAdvertRequestFragment) {
        injectViewModelFactory(editAdvertRequestFragment, this.a.get());
        injectLoadingProgress(editAdvertRequestFragment, this.b.get());
        injectIntentFactory(editAdvertRequestFragment, this.c.get());
        injectDeepLinkIntentFactory(editAdvertRequestFragment, this.d.get());
        injectDialogRouter(editAdvertRequestFragment, this.e.get());
    }
}
