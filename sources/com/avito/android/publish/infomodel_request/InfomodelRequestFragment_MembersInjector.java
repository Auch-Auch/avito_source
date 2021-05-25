package com.avito.android.publish.infomodel_request;

import com.avito.android.analytics.screens.tracker.UnknownScreenTracker;
import com.avito.android.progress_overlay.LoadingProgressOverlay;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class InfomodelRequestFragment_MembersInjector implements MembersInjector<InfomodelRequestFragment> {
    public final Provider<InfomodelRequestViewModelFactory> a;
    public final Provider<LoadingProgressOverlay> b;
    public final Provider<UnknownScreenTracker> c;

    public InfomodelRequestFragment_MembersInjector(Provider<InfomodelRequestViewModelFactory> provider, Provider<LoadingProgressOverlay> provider2, Provider<UnknownScreenTracker> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static MembersInjector<InfomodelRequestFragment> create(Provider<InfomodelRequestViewModelFactory> provider, Provider<LoadingProgressOverlay> provider2, Provider<UnknownScreenTracker> provider3) {
        return new InfomodelRequestFragment_MembersInjector(provider, provider2, provider3);
    }

    @InjectedFieldSignature("com.avito.android.publish.infomodel_request.InfomodelRequestFragment.loadingProgress")
    public static void injectLoadingProgress(InfomodelRequestFragment infomodelRequestFragment, LoadingProgressOverlay loadingProgressOverlay) {
        infomodelRequestFragment.loadingProgress = loadingProgressOverlay;
    }

    @InjectedFieldSignature("com.avito.android.publish.infomodel_request.InfomodelRequestFragment.performanceTracker")
    public static void injectPerformanceTracker(InfomodelRequestFragment infomodelRequestFragment, UnknownScreenTracker unknownScreenTracker) {
        infomodelRequestFragment.performanceTracker = unknownScreenTracker;
    }

    @InjectedFieldSignature("com.avito.android.publish.infomodel_request.InfomodelRequestFragment.viewModelFactory")
    public static void injectViewModelFactory(InfomodelRequestFragment infomodelRequestFragment, InfomodelRequestViewModelFactory infomodelRequestViewModelFactory) {
        infomodelRequestFragment.viewModelFactory = infomodelRequestViewModelFactory;
    }

    public void injectMembers(InfomodelRequestFragment infomodelRequestFragment) {
        injectViewModelFactory(infomodelRequestFragment, this.a.get());
        injectLoadingProgress(infomodelRequestFragment, this.b.get());
        injectPerformanceTracker(infomodelRequestFragment, this.c.get());
    }
}
