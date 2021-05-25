package com.avito.android.public_profile;

import androidx.recyclerview.widget.GridLayoutManager;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.ab_tests.AbTestsConfigProvider;
import com.avito.android.advert.viewed.ViewedAdvertsPresenter;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.favorite.FavoriteAdvertsPresenter;
import com.avito.android.public_profile.tracker.PublicProfileAdvertsTracker;
import com.avito.android.recycler.base.DestroyableViewHolderBuilder;
import com.avito.android.serp.adapter.SpannedGridPositionProvider;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class ProfileAdvertsFragment_MembersInjector implements MembersInjector<ProfileAdvertsFragment> {
    public final Provider<ProfileAdvertsPresenter> a;
    public final Provider<ProfileAdvertsInteractor> b;
    public final Provider<AdapterPresenter> c;
    public final Provider<DestroyableViewHolderBuilder> d;
    public final Provider<SpannedGridPositionProvider> e;
    public final Provider<GridLayoutManager.SpanSizeLookup> f;
    public final Provider<ActivityIntentFactory> g;
    public final Provider<FavoriteAdvertsPresenter> h;
    public final Provider<ViewedAdvertsPresenter> i;
    public final Provider<DeepLinkIntentFactory> j;
    public final Provider<AbTestsConfigProvider> k;
    public final Provider<PublicProfileAdvertsTracker> l;

    public ProfileAdvertsFragment_MembersInjector(Provider<ProfileAdvertsPresenter> provider, Provider<ProfileAdvertsInteractor> provider2, Provider<AdapterPresenter> provider3, Provider<DestroyableViewHolderBuilder> provider4, Provider<SpannedGridPositionProvider> provider5, Provider<GridLayoutManager.SpanSizeLookup> provider6, Provider<ActivityIntentFactory> provider7, Provider<FavoriteAdvertsPresenter> provider8, Provider<ViewedAdvertsPresenter> provider9, Provider<DeepLinkIntentFactory> provider10, Provider<AbTestsConfigProvider> provider11, Provider<PublicProfileAdvertsTracker> provider12) {
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
        this.l = provider12;
    }

    public static MembersInjector<ProfileAdvertsFragment> create(Provider<ProfileAdvertsPresenter> provider, Provider<ProfileAdvertsInteractor> provider2, Provider<AdapterPresenter> provider3, Provider<DestroyableViewHolderBuilder> provider4, Provider<SpannedGridPositionProvider> provider5, Provider<GridLayoutManager.SpanSizeLookup> provider6, Provider<ActivityIntentFactory> provider7, Provider<FavoriteAdvertsPresenter> provider8, Provider<ViewedAdvertsPresenter> provider9, Provider<DeepLinkIntentFactory> provider10, Provider<AbTestsConfigProvider> provider11, Provider<PublicProfileAdvertsTracker> provider12) {
        return new ProfileAdvertsFragment_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12);
    }

    @InjectedFieldSignature("com.avito.android.public_profile.ProfileAdvertsFragment.abTestsConfigProvider")
    public static void injectAbTestsConfigProvider(ProfileAdvertsFragment profileAdvertsFragment, AbTestsConfigProvider abTestsConfigProvider) {
        profileAdvertsFragment.abTestsConfigProvider = abTestsConfigProvider;
    }

    @InjectedFieldSignature("com.avito.android.public_profile.ProfileAdvertsFragment.adapterPresenter")
    public static void injectAdapterPresenter(ProfileAdvertsFragment profileAdvertsFragment, AdapterPresenter adapterPresenter) {
        profileAdvertsFragment.adapterPresenter = adapterPresenter;
    }

    @InjectedFieldSignature("com.avito.android.public_profile.ProfileAdvertsFragment.deepLinkIntentFactory")
    public static void injectDeepLinkIntentFactory(ProfileAdvertsFragment profileAdvertsFragment, DeepLinkIntentFactory deepLinkIntentFactory) {
        profileAdvertsFragment.deepLinkIntentFactory = deepLinkIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.public_profile.ProfileAdvertsFragment.favoriteAdvertsPresenter")
    public static void injectFavoriteAdvertsPresenter(ProfileAdvertsFragment profileAdvertsFragment, FavoriteAdvertsPresenter favoriteAdvertsPresenter) {
        profileAdvertsFragment.favoriteAdvertsPresenter = favoriteAdvertsPresenter;
    }

    @InjectedFieldSignature("com.avito.android.public_profile.ProfileAdvertsFragment.gridPositionProvider")
    public static void injectGridPositionProvider(ProfileAdvertsFragment profileAdvertsFragment, SpannedGridPositionProvider spannedGridPositionProvider) {
        profileAdvertsFragment.gridPositionProvider = spannedGridPositionProvider;
    }

    @InjectedFieldSignature("com.avito.android.public_profile.ProfileAdvertsFragment.intentFactory")
    public static void injectIntentFactory(ProfileAdvertsFragment profileAdvertsFragment, ActivityIntentFactory activityIntentFactory) {
        profileAdvertsFragment.intentFactory = activityIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.public_profile.ProfileAdvertsFragment.interactor")
    public static void injectInteractor(ProfileAdvertsFragment profileAdvertsFragment, ProfileAdvertsInteractor profileAdvertsInteractor) {
        profileAdvertsFragment.interactor = profileAdvertsInteractor;
    }

    @InjectedFieldSignature("com.avito.android.public_profile.ProfileAdvertsFragment.presenter")
    public static void injectPresenter(ProfileAdvertsFragment profileAdvertsFragment, ProfileAdvertsPresenter profileAdvertsPresenter) {
        profileAdvertsFragment.presenter = profileAdvertsPresenter;
    }

    @InjectedFieldSignature("com.avito.android.public_profile.ProfileAdvertsFragment.spanSizeLookup")
    public static void injectSpanSizeLookup(ProfileAdvertsFragment profileAdvertsFragment, GridLayoutManager.SpanSizeLookup spanSizeLookup) {
        profileAdvertsFragment.spanSizeLookup = spanSizeLookup;
    }

    @InjectedFieldSignature("com.avito.android.public_profile.ProfileAdvertsFragment.tracker")
    public static void injectTracker(ProfileAdvertsFragment profileAdvertsFragment, PublicProfileAdvertsTracker publicProfileAdvertsTracker) {
        profileAdvertsFragment.tracker = publicProfileAdvertsTracker;
    }

    @InjectedFieldSignature("com.avito.android.public_profile.ProfileAdvertsFragment.viewHolderBuilder")
    public static void injectViewHolderBuilder(ProfileAdvertsFragment profileAdvertsFragment, DestroyableViewHolderBuilder destroyableViewHolderBuilder) {
        profileAdvertsFragment.viewHolderBuilder = destroyableViewHolderBuilder;
    }

    @InjectedFieldSignature("com.avito.android.public_profile.ProfileAdvertsFragment.viewedAdvertsPresenter")
    public static void injectViewedAdvertsPresenter(ProfileAdvertsFragment profileAdvertsFragment, ViewedAdvertsPresenter viewedAdvertsPresenter) {
        profileAdvertsFragment.viewedAdvertsPresenter = viewedAdvertsPresenter;
    }

    public void injectMembers(ProfileAdvertsFragment profileAdvertsFragment) {
        injectPresenter(profileAdvertsFragment, this.a.get());
        injectInteractor(profileAdvertsFragment, this.b.get());
        injectAdapterPresenter(profileAdvertsFragment, this.c.get());
        injectViewHolderBuilder(profileAdvertsFragment, this.d.get());
        injectGridPositionProvider(profileAdvertsFragment, this.e.get());
        injectSpanSizeLookup(profileAdvertsFragment, this.f.get());
        injectIntentFactory(profileAdvertsFragment, this.g.get());
        injectFavoriteAdvertsPresenter(profileAdvertsFragment, this.h.get());
        injectViewedAdvertsPresenter(profileAdvertsFragment, this.i.get());
        injectDeepLinkIntentFactory(profileAdvertsFragment, this.j.get());
        injectAbTestsConfigProvider(profileAdvertsFragment, this.k.get());
        injectTracker(profileAdvertsFragment, this.l.get());
    }
}
