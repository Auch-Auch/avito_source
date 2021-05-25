package com.avito.android.vas_performance.di.applied_services;

import com.avito.android.conveyor_shared_item.bottom_sheet.title.TitlePresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class AppliedServicesModule_ProvideTitlePresenterFactory implements Factory<TitlePresenter> {
    public final AppliedServicesModule a;

    public AppliedServicesModule_ProvideTitlePresenterFactory(AppliedServicesModule appliedServicesModule) {
        this.a = appliedServicesModule;
    }

    public static AppliedServicesModule_ProvideTitlePresenterFactory create(AppliedServicesModule appliedServicesModule) {
        return new AppliedServicesModule_ProvideTitlePresenterFactory(appliedServicesModule);
    }

    public static TitlePresenter provideTitlePresenter(AppliedServicesModule appliedServicesModule) {
        return (TitlePresenter) Preconditions.checkNotNullFromProvides(appliedServicesModule.provideTitlePresenter());
    }

    @Override // javax.inject.Provider
    public TitlePresenter get() {
        return provideTitlePresenter(this.a);
    }
}
