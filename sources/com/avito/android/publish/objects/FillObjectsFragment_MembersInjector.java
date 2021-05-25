package com.avito.android.publish.objects;

import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.item_legacy.details.ItemDetailsSelectResultHandler;
import com.avito.android.item_legacy.details.SelectItemBaseFragment_MembersInjector;
import com.avito.android.util.DialogRouter;
import com.avito.android.validation.ParametersListPresenter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class FillObjectsFragment_MembersInjector implements MembersInjector<FillObjectsFragment> {
    public final Provider<ItemDetailsSelectResultHandler> a;
    public final Provider<DeepLinkIntentFactory> b;
    public final Provider<ActivityIntentFactory> c;
    public final Provider<Analytics> d;
    public final Provider<ObjectsEditPresenter> e;
    public final Provider<ObjectsEditInteractor> f;
    public final Provider<ParametersListPresenter> g;
    public final Provider<RecyclerView.Adapter<?>> h;
    public final Provider<Features> i;
    public final Provider<DialogRouter> j;

    public FillObjectsFragment_MembersInjector(Provider<ItemDetailsSelectResultHandler> provider, Provider<DeepLinkIntentFactory> provider2, Provider<ActivityIntentFactory> provider3, Provider<Analytics> provider4, Provider<ObjectsEditPresenter> provider5, Provider<ObjectsEditInteractor> provider6, Provider<ParametersListPresenter> provider7, Provider<RecyclerView.Adapter<?>> provider8, Provider<Features> provider9, Provider<DialogRouter> provider10) {
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
    }

    public static MembersInjector<FillObjectsFragment> create(Provider<ItemDetailsSelectResultHandler> provider, Provider<DeepLinkIntentFactory> provider2, Provider<ActivityIntentFactory> provider3, Provider<Analytics> provider4, Provider<ObjectsEditPresenter> provider5, Provider<ObjectsEditInteractor> provider6, Provider<ParametersListPresenter> provider7, Provider<RecyclerView.Adapter<?>> provider8, Provider<Features> provider9, Provider<DialogRouter> provider10) {
        return new FillObjectsFragment_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10);
    }

    @InjectedFieldSignature("com.avito.android.publish.objects.FillObjectsFragment.activityIntentFactory")
    public static void injectActivityIntentFactory(FillObjectsFragment fillObjectsFragment, ActivityIntentFactory activityIntentFactory) {
        fillObjectsFragment.activityIntentFactory = activityIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.publish.objects.FillObjectsFragment.adapter")
    public static void injectAdapter(FillObjectsFragment fillObjectsFragment, RecyclerView.Adapter<?> adapter) {
        fillObjectsFragment.adapter = adapter;
    }

    @InjectedFieldSignature("com.avito.android.publish.objects.FillObjectsFragment.analytics")
    public static void injectAnalytics(FillObjectsFragment fillObjectsFragment, Analytics analytics) {
        fillObjectsFragment.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.publish.objects.FillObjectsFragment.deepLinkIntentFactory")
    public static void injectDeepLinkIntentFactory(FillObjectsFragment fillObjectsFragment, DeepLinkIntentFactory deepLinkIntentFactory) {
        fillObjectsFragment.deepLinkIntentFactory = deepLinkIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.publish.objects.FillObjectsFragment.dialogRouter")
    public static void injectDialogRouter(FillObjectsFragment fillObjectsFragment, DialogRouter dialogRouter) {
        fillObjectsFragment.dialogRouter = dialogRouter;
    }

    @InjectedFieldSignature("com.avito.android.publish.objects.FillObjectsFragment.features")
    public static void injectFeatures(FillObjectsFragment fillObjectsFragment, Features features) {
        fillObjectsFragment.features = features;
    }

    @InjectedFieldSignature("com.avito.android.publish.objects.FillObjectsFragment.interactor")
    public static void injectInteractor(FillObjectsFragment fillObjectsFragment, ObjectsEditInteractor objectsEditInteractor) {
        fillObjectsFragment.interactor = objectsEditInteractor;
    }

    @InjectedFieldSignature("com.avito.android.publish.objects.FillObjectsFragment.presenter")
    public static void injectPresenter(FillObjectsFragment fillObjectsFragment, ObjectsEditPresenter objectsEditPresenter) {
        fillObjectsFragment.presenter = objectsEditPresenter;
    }

    @InjectedFieldSignature("com.avito.android.publish.objects.FillObjectsFragment.validationPresenter")
    public static void injectValidationPresenter(FillObjectsFragment fillObjectsFragment, ParametersListPresenter parametersListPresenter) {
        fillObjectsFragment.validationPresenter = parametersListPresenter;
    }

    public void injectMembers(FillObjectsFragment fillObjectsFragment) {
        SelectItemBaseFragment_MembersInjector.injectResultHandler(fillObjectsFragment, this.a.get());
        injectDeepLinkIntentFactory(fillObjectsFragment, this.b.get());
        injectActivityIntentFactory(fillObjectsFragment, this.c.get());
        injectAnalytics(fillObjectsFragment, this.d.get());
        injectPresenter(fillObjectsFragment, this.e.get());
        injectInteractor(fillObjectsFragment, this.f.get());
        injectValidationPresenter(fillObjectsFragment, this.g.get());
        injectAdapter(fillObjectsFragment, this.h.get());
        injectFeatures(fillObjectsFragment, this.i.get());
        injectDialogRouter(fillObjectsFragment, this.j.get());
    }
}
