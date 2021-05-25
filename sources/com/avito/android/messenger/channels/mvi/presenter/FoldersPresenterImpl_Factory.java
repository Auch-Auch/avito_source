package com.avito.android.messenger.channels.mvi.presenter;

import com.avito.android.ab_tests.groups.MessengerFolderTabsTestGroup;
import com.avito.android.ab_tests.models.ManuallyExposedAbTestGroup;
import com.avito.android.analytics.Analytics;
import com.avito.android.messenger.channels.mvi.interactor.FoldersInteractor;
import com.avito.android.messenger.folders.FolderOnboardingStatusStorage;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class FoldersPresenterImpl_Factory implements Factory<FoldersPresenterImpl> {
    public final Provider<SchedulersFactory> a;
    public final Provider<FoldersInteractor> b;
    public final Provider<FolderOnboardingStatusStorage> c;
    public final Provider<ManuallyExposedAbTestGroup<MessengerFolderTabsTestGroup>> d;
    public final Provider<Analytics> e;

    public FoldersPresenterImpl_Factory(Provider<SchedulersFactory> provider, Provider<FoldersInteractor> provider2, Provider<FolderOnboardingStatusStorage> provider3, Provider<ManuallyExposedAbTestGroup<MessengerFolderTabsTestGroup>> provider4, Provider<Analytics> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static FoldersPresenterImpl_Factory create(Provider<SchedulersFactory> provider, Provider<FoldersInteractor> provider2, Provider<FolderOnboardingStatusStorage> provider3, Provider<ManuallyExposedAbTestGroup<MessengerFolderTabsTestGroup>> provider4, Provider<Analytics> provider5) {
        return new FoldersPresenterImpl_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static FoldersPresenterImpl newInstance(SchedulersFactory schedulersFactory, FoldersInteractor foldersInteractor, FolderOnboardingStatusStorage folderOnboardingStatusStorage, ManuallyExposedAbTestGroup<MessengerFolderTabsTestGroup> manuallyExposedAbTestGroup, Analytics analytics) {
        return new FoldersPresenterImpl(schedulersFactory, foldersInteractor, folderOnboardingStatusStorage, manuallyExposedAbTestGroup, analytics);
    }

    @Override // javax.inject.Provider
    public FoldersPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
