package com.avito.android.publish.objects.di;

import android.content.res.Resources;
import com.avito.android.category_parameters.CategoryParametersElementConverter;
import com.avito.android.item_legacy.details.ItemDetailsSelectResultHandler;
import com.avito.android.publish.objects.ObjectsEditInteractor;
import com.avito.android.publish.objects.ObjectsEditPresenter;
import com.avito.android.publish.view.BasicParameterClickListener;
import com.avito.android.recycler.data_aware.DataAwareAdapterPresenter;
import com.avito.android.remote.model.category_parameters.ObjectsParameter;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.validation.ParametersListPresenter;
import com.avito.konveyor.blueprint.ItemPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Locale;
import java.util.Set;
import javax.inject.Provider;
public final class ObjectsEditModule_ProvidePresenterFactory implements Factory<ObjectsEditPresenter> {
    public final Provider<Resources> a;
    public final Provider<ObjectsParameter> b;
    public final Provider<ObjectsEditInteractor> c;
    public final Provider<BasicParameterClickListener> d;
    public final Provider<DataAwareAdapterPresenter> e;
    public final Provider<ParametersListPresenter> f;
    public final Provider<ItemDetailsSelectResultHandler> g;
    public final Provider<CategoryParametersElementConverter> h;
    public final Provider<SchedulersFactory> i;
    public final Provider<Locale> j;
    public final Provider<Set<ItemPresenter<?, ?>>> k;

    public ObjectsEditModule_ProvidePresenterFactory(Provider<Resources> provider, Provider<ObjectsParameter> provider2, Provider<ObjectsEditInteractor> provider3, Provider<BasicParameterClickListener> provider4, Provider<DataAwareAdapterPresenter> provider5, Provider<ParametersListPresenter> provider6, Provider<ItemDetailsSelectResultHandler> provider7, Provider<CategoryParametersElementConverter> provider8, Provider<SchedulersFactory> provider9, Provider<Locale> provider10, Provider<Set<ItemPresenter<?, ?>>> provider11) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
        this.h = provider8;
        this.i = provider9;
        this.j = provider10;
        this.k = provider11;
    }

    public static ObjectsEditModule_ProvidePresenterFactory create(Provider<Resources> provider, Provider<ObjectsParameter> provider2, Provider<ObjectsEditInteractor> provider3, Provider<BasicParameterClickListener> provider4, Provider<DataAwareAdapterPresenter> provider5, Provider<ParametersListPresenter> provider6, Provider<ItemDetailsSelectResultHandler> provider7, Provider<CategoryParametersElementConverter> provider8, Provider<SchedulersFactory> provider9, Provider<Locale> provider10, Provider<Set<ItemPresenter<?, ?>>> provider11) {
        return new ObjectsEditModule_ProvidePresenterFactory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11);
    }

    public static ObjectsEditPresenter providePresenter(Resources resources, ObjectsParameter objectsParameter, ObjectsEditInteractor objectsEditInteractor, BasicParameterClickListener basicParameterClickListener, DataAwareAdapterPresenter dataAwareAdapterPresenter, ParametersListPresenter parametersListPresenter, ItemDetailsSelectResultHandler itemDetailsSelectResultHandler, CategoryParametersElementConverter categoryParametersElementConverter, SchedulersFactory schedulersFactory, Locale locale, Set<ItemPresenter<?, ?>> set) {
        return (ObjectsEditPresenter) Preconditions.checkNotNullFromProvides(ObjectsEditModule.INSTANCE.providePresenter(resources, objectsParameter, objectsEditInteractor, basicParameterClickListener, dataAwareAdapterPresenter, parametersListPresenter, itemDetailsSelectResultHandler, categoryParametersElementConverter, schedulersFactory, locale, set));
    }

    @Override // javax.inject.Provider
    public ObjectsEditPresenter get() {
        return providePresenter(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get(), this.i.get(), this.j.get(), this.k.get());
    }
}
