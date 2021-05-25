package com.avito.android.publish.details.di;

import com.avito.android.blueprints.range.cre_range.CreRangePresenter;
import com.avito.android.blueprints.range.cre_range.CreRangePresenterImpl;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PublishDetailsModule_ProvideCRERangeItemPresenterFactory implements Factory<CreRangePresenter> {
    public final PublishDetailsModule a;
    public final Provider<CreRangePresenterImpl> b;

    public PublishDetailsModule_ProvideCRERangeItemPresenterFactory(PublishDetailsModule publishDetailsModule, Provider<CreRangePresenterImpl> provider) {
        this.a = publishDetailsModule;
        this.b = provider;
    }

    public static PublishDetailsModule_ProvideCRERangeItemPresenterFactory create(PublishDetailsModule publishDetailsModule, Provider<CreRangePresenterImpl> provider) {
        return new PublishDetailsModule_ProvideCRERangeItemPresenterFactory(publishDetailsModule, provider);
    }

    public static CreRangePresenter provideCRERangeItemPresenter(PublishDetailsModule publishDetailsModule, CreRangePresenterImpl creRangePresenterImpl) {
        return (CreRangePresenter) Preconditions.checkNotNullFromProvides(publishDetailsModule.provideCRERangeItemPresenter(creRangePresenterImpl));
    }

    @Override // javax.inject.Provider
    public CreRangePresenter get() {
        return provideCRERangeItemPresenter(this.a, this.b.get());
    }
}
