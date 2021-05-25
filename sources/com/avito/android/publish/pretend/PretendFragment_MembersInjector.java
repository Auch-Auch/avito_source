package com.avito.android.publish.pretend;

import com.avito.android.progress_overlay.LoadingProgressOverlay;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class PretendFragment_MembersInjector implements MembersInjector<PretendFragment> {
    public final Provider<LoadingProgressOverlay> a;
    public final Provider<PretendViewModelFactory> b;

    public PretendFragment_MembersInjector(Provider<LoadingProgressOverlay> provider, Provider<PretendViewModelFactory> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static MembersInjector<PretendFragment> create(Provider<LoadingProgressOverlay> provider, Provider<PretendViewModelFactory> provider2) {
        return new PretendFragment_MembersInjector(provider, provider2);
    }

    @InjectedFieldSignature("com.avito.android.publish.pretend.PretendFragment.loadingProgress")
    public static void injectLoadingProgress(PretendFragment pretendFragment, LoadingProgressOverlay loadingProgressOverlay) {
        pretendFragment.loadingProgress = loadingProgressOverlay;
    }

    @InjectedFieldSignature("com.avito.android.publish.pretend.PretendFragment.viewModelFactory")
    public static void injectViewModelFactory(PretendFragment pretendFragment, PretendViewModelFactory pretendViewModelFactory) {
        pretendFragment.viewModelFactory = pretendViewModelFactory;
    }

    public void injectMembers(PretendFragment pretendFragment) {
        injectLoadingProgress(pretendFragment, this.a.get());
        injectViewModelFactory(pretendFragment, this.b.get());
    }
}
