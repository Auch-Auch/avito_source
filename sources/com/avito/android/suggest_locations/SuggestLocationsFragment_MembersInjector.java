package com.avito.android.suggest_locations;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class SuggestLocationsFragment_MembersInjector implements MembersInjector<SuggestLocationsFragment> {
    public final Provider<SuggestLocationsPresenter> a;
    public final Provider<ActivityIntentFactory> b;
    public final Provider<Features> c;

    public SuggestLocationsFragment_MembersInjector(Provider<SuggestLocationsPresenter> provider, Provider<ActivityIntentFactory> provider2, Provider<Features> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static MembersInjector<SuggestLocationsFragment> create(Provider<SuggestLocationsPresenter> provider, Provider<ActivityIntentFactory> provider2, Provider<Features> provider3) {
        return new SuggestLocationsFragment_MembersInjector(provider, provider2, provider3);
    }

    @InjectedFieldSignature("com.avito.android.suggest_locations.SuggestLocationsFragment.activityIntentFactory")
    public static void injectActivityIntentFactory(SuggestLocationsFragment suggestLocationsFragment, ActivityIntentFactory activityIntentFactory) {
        suggestLocationsFragment.activityIntentFactory = activityIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.suggest_locations.SuggestLocationsFragment.features")
    public static void injectFeatures(SuggestLocationsFragment suggestLocationsFragment, Features features) {
        suggestLocationsFragment.features = features;
    }

    @InjectedFieldSignature("com.avito.android.suggest_locations.SuggestLocationsFragment.presenter")
    public static void injectPresenter(SuggestLocationsFragment suggestLocationsFragment, SuggestLocationsPresenter suggestLocationsPresenter) {
        suggestLocationsFragment.presenter = suggestLocationsPresenter;
    }

    public void injectMembers(SuggestLocationsFragment suggestLocationsFragment) {
        injectPresenter(suggestLocationsFragment, this.a.get());
        injectActivityIntentFactory(suggestLocationsFragment, this.b.get());
        injectFeatures(suggestLocationsFragment, this.c.get());
    }
}
