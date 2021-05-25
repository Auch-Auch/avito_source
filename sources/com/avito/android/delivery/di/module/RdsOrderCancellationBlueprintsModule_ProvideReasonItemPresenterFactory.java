package com.avito.android.delivery.di.module;

import com.avito.android.delivery.order_cancellation.RdsOrderCancellationReasonsViewModel;
import com.avito.android.delivery.order_cancellation.konveyor.ReasonItemPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class RdsOrderCancellationBlueprintsModule_ProvideReasonItemPresenterFactory implements Factory<ReasonItemPresenter> {
    public final Provider<RdsOrderCancellationReasonsViewModel> a;

    public RdsOrderCancellationBlueprintsModule_ProvideReasonItemPresenterFactory(Provider<RdsOrderCancellationReasonsViewModel> provider) {
        this.a = provider;
    }

    public static RdsOrderCancellationBlueprintsModule_ProvideReasonItemPresenterFactory create(Provider<RdsOrderCancellationReasonsViewModel> provider) {
        return new RdsOrderCancellationBlueprintsModule_ProvideReasonItemPresenterFactory(provider);
    }

    public static ReasonItemPresenter provideReasonItemPresenter(RdsOrderCancellationReasonsViewModel rdsOrderCancellationReasonsViewModel) {
        return (ReasonItemPresenter) Preconditions.checkNotNullFromProvides(RdsOrderCancellationBlueprintsModule.INSTANCE.provideReasonItemPresenter(rdsOrderCancellationReasonsViewModel));
    }

    @Override // javax.inject.Provider
    public ReasonItemPresenter get() {
        return provideReasonItemPresenter(this.a.get());
    }
}
