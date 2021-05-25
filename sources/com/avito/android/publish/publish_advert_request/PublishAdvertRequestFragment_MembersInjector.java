package com.avito.android.publish.publish_advert_request;

import com.avito.android.progress_overlay.LoadingProgressOverlay;
import com.avito.android.publish.SubmissionPresenter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class PublishAdvertRequestFragment_MembersInjector implements MembersInjector<PublishAdvertRequestFragment> {
    public final Provider<PublishAdvertRequestViewModelFactory> a;
    public final Provider<LoadingProgressOverlay> b;
    public final Provider<SubmissionPresenter> c;

    public PublishAdvertRequestFragment_MembersInjector(Provider<PublishAdvertRequestViewModelFactory> provider, Provider<LoadingProgressOverlay> provider2, Provider<SubmissionPresenter> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static MembersInjector<PublishAdvertRequestFragment> create(Provider<PublishAdvertRequestViewModelFactory> provider, Provider<LoadingProgressOverlay> provider2, Provider<SubmissionPresenter> provider3) {
        return new PublishAdvertRequestFragment_MembersInjector(provider, provider2, provider3);
    }

    @InjectedFieldSignature("com.avito.android.publish.publish_advert_request.PublishAdvertRequestFragment.loadingProgress")
    public static void injectLoadingProgress(PublishAdvertRequestFragment publishAdvertRequestFragment, LoadingProgressOverlay loadingProgressOverlay) {
        publishAdvertRequestFragment.loadingProgress = loadingProgressOverlay;
    }

    @InjectedFieldSignature("com.avito.android.publish.publish_advert_request.PublishAdvertRequestFragment.submissionPresenter")
    public static void injectSubmissionPresenter(PublishAdvertRequestFragment publishAdvertRequestFragment, SubmissionPresenter submissionPresenter) {
        publishAdvertRequestFragment.submissionPresenter = submissionPresenter;
    }

    @InjectedFieldSignature("com.avito.android.publish.publish_advert_request.PublishAdvertRequestFragment.viewModelFactory")
    public static void injectViewModelFactory(PublishAdvertRequestFragment publishAdvertRequestFragment, PublishAdvertRequestViewModelFactory publishAdvertRequestViewModelFactory) {
        publishAdvertRequestFragment.viewModelFactory = publishAdvertRequestViewModelFactory;
    }

    public void injectMembers(PublishAdvertRequestFragment publishAdvertRequestFragment) {
        injectViewModelFactory(publishAdvertRequestFragment, this.a.get());
        injectLoadingProgress(publishAdvertRequestFragment, this.b.get());
        injectSubmissionPresenter(publishAdvertRequestFragment, this.c.get());
    }
}
