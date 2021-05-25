package com.avito.android.publish.details.di;

import com.avito.android.Features;
import com.avito.android.ab_tests.AbTestsConfigProvider;
import com.avito.android.category_parameters.CategoryParametersElementConverter;
import com.avito.android.computer_vision.ComputerVisionInteractor;
import com.avito.android.item_legacy.details.ItemDetailsSelectResultHandler;
import com.avito.android.photo_picker.legacy.UploadingProgressInteractor;
import com.avito.android.publish.PhotoUploadObserver;
import com.avito.android.publish.analytics.PublishEventTracker;
import com.avito.android.publish.analytics.PublishInputsAnalyticTracker;
import com.avito.android.publish.details.ItemPostProcessor;
import com.avito.android.publish.details.PhotoInteractorWrapper;
import com.avito.android.publish.details.PublishDetailsInteractor;
import com.avito.android.publish.details.PublishDetailsPresenter;
import com.avito.android.publish.details.PublishDetailsResourceProvider;
import com.avito.android.publish.details.analytics.PublishDetailsFlowTracker;
import com.avito.android.publish.slots.SlotsFactory;
import com.avito.android.publish.view.ItemDetailsParameterClickListener;
import com.avito.android.util.DeviceMetrics;
import com.avito.android.util.Formatter;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.validation.ParametersListPresenter;
import com.avito.konveyor.blueprint.ItemPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Set;
import javax.inject.Provider;
public final class PublishDetailsModule_ProvideDetailsPresenterFactory implements Factory<PublishDetailsPresenter> {
    public final PublishDetailsModule a;
    public final Provider<PublishDetailsInteractor> b;
    public final Provider<ItemDetailsSelectResultHandler> c;
    public final Provider<PhotoInteractorWrapper> d;
    public final Provider<ItemDetailsParameterClickListener> e;
    public final Provider<CategoryParametersElementConverter> f;
    public final Provider<SchedulersFactory> g;
    public final Provider<ParametersListPresenter> h;
    public final Provider<ParametersListPresenter> i;
    public final Provider<PublishDetailsResourceProvider> j;
    public final Provider<PublishInputsAnalyticTracker> k;
    public final Provider<UploadingProgressInteractor> l;
    public final Provider<PublishEventTracker> m;
    public final Provider<Set<ItemPresenter<?, ?>>> n;
    public final Provider<Features> o;
    public final Provider<Formatter<String>> p;
    public final Provider<SlotsFactory> q;
    public final Provider<DeviceMetrics> r;
    public final Provider<PhotoUploadObserver> s;
    public final Provider<ComputerVisionInteractor> t;
    public final Provider<AbTestsConfigProvider> u;
    public final Provider<ItemPostProcessor> v;
    public final Provider<PublishDetailsFlowTracker> w;

    public PublishDetailsModule_ProvideDetailsPresenterFactory(PublishDetailsModule publishDetailsModule, Provider<PublishDetailsInteractor> provider, Provider<ItemDetailsSelectResultHandler> provider2, Provider<PhotoInteractorWrapper> provider3, Provider<ItemDetailsParameterClickListener> provider4, Provider<CategoryParametersElementConverter> provider5, Provider<SchedulersFactory> provider6, Provider<ParametersListPresenter> provider7, Provider<ParametersListPresenter> provider8, Provider<PublishDetailsResourceProvider> provider9, Provider<PublishInputsAnalyticTracker> provider10, Provider<UploadingProgressInteractor> provider11, Provider<PublishEventTracker> provider12, Provider<Set<ItemPresenter<?, ?>>> provider13, Provider<Features> provider14, Provider<Formatter<String>> provider15, Provider<SlotsFactory> provider16, Provider<DeviceMetrics> provider17, Provider<PhotoUploadObserver> provider18, Provider<ComputerVisionInteractor> provider19, Provider<AbTestsConfigProvider> provider20, Provider<ItemPostProcessor> provider21, Provider<PublishDetailsFlowTracker> provider22) {
        this.a = publishDetailsModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
        this.e = provider4;
        this.f = provider5;
        this.g = provider6;
        this.h = provider7;
        this.i = provider8;
        this.j = provider9;
        this.k = provider10;
        this.l = provider11;
        this.m = provider12;
        this.n = provider13;
        this.o = provider14;
        this.p = provider15;
        this.q = provider16;
        this.r = provider17;
        this.s = provider18;
        this.t = provider19;
        this.u = provider20;
        this.v = provider21;
        this.w = provider22;
    }

    public static PublishDetailsModule_ProvideDetailsPresenterFactory create(PublishDetailsModule publishDetailsModule, Provider<PublishDetailsInteractor> provider, Provider<ItemDetailsSelectResultHandler> provider2, Provider<PhotoInteractorWrapper> provider3, Provider<ItemDetailsParameterClickListener> provider4, Provider<CategoryParametersElementConverter> provider5, Provider<SchedulersFactory> provider6, Provider<ParametersListPresenter> provider7, Provider<ParametersListPresenter> provider8, Provider<PublishDetailsResourceProvider> provider9, Provider<PublishInputsAnalyticTracker> provider10, Provider<UploadingProgressInteractor> provider11, Provider<PublishEventTracker> provider12, Provider<Set<ItemPresenter<?, ?>>> provider13, Provider<Features> provider14, Provider<Formatter<String>> provider15, Provider<SlotsFactory> provider16, Provider<DeviceMetrics> provider17, Provider<PhotoUploadObserver> provider18, Provider<ComputerVisionInteractor> provider19, Provider<AbTestsConfigProvider> provider20, Provider<ItemPostProcessor> provider21, Provider<PublishDetailsFlowTracker> provider22) {
        return new PublishDetailsModule_ProvideDetailsPresenterFactory(publishDetailsModule, provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15, provider16, provider17, provider18, provider19, provider20, provider21, provider22);
    }

    public static PublishDetailsPresenter provideDetailsPresenter(PublishDetailsModule publishDetailsModule, PublishDetailsInteractor publishDetailsInteractor, ItemDetailsSelectResultHandler itemDetailsSelectResultHandler, PhotoInteractorWrapper photoInteractorWrapper, ItemDetailsParameterClickListener itemDetailsParameterClickListener, CategoryParametersElementConverter categoryParametersElementConverter, SchedulersFactory schedulersFactory, ParametersListPresenter parametersListPresenter, ParametersListPresenter parametersListPresenter2, PublishDetailsResourceProvider publishDetailsResourceProvider, PublishInputsAnalyticTracker publishInputsAnalyticTracker, UploadingProgressInteractor uploadingProgressInteractor, PublishEventTracker publishEventTracker, Set<ItemPresenter<?, ?>> set, Features features, Formatter<String> formatter, SlotsFactory slotsFactory, DeviceMetrics deviceMetrics, PhotoUploadObserver photoUploadObserver, ComputerVisionInteractor computerVisionInteractor, AbTestsConfigProvider abTestsConfigProvider, ItemPostProcessor itemPostProcessor, PublishDetailsFlowTracker publishDetailsFlowTracker) {
        return (PublishDetailsPresenter) Preconditions.checkNotNullFromProvides(publishDetailsModule.provideDetailsPresenter(publishDetailsInteractor, itemDetailsSelectResultHandler, photoInteractorWrapper, itemDetailsParameterClickListener, categoryParametersElementConverter, schedulersFactory, parametersListPresenter, parametersListPresenter2, publishDetailsResourceProvider, publishInputsAnalyticTracker, uploadingProgressInteractor, publishEventTracker, set, features, formatter, slotsFactory, deviceMetrics, photoUploadObserver, computerVisionInteractor, abTestsConfigProvider, itemPostProcessor, publishDetailsFlowTracker));
    }

    @Override // javax.inject.Provider
    public PublishDetailsPresenter get() {
        return provideDetailsPresenter(this.a, this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get(), this.i.get(), this.j.get(), this.k.get(), this.l.get(), this.m.get(), this.n.get(), this.o.get(), this.p.get(), this.q.get(), this.r.get(), this.s.get(), this.t.get(), this.u.get(), this.v.get(), this.w.get());
    }
}
