package com.avito.android.safedeal.profile_settings;

import com.avito.android.analytics.screens.tracker.BaseScreenPerformanceTracker;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.recycler.data_aware.DataAwareAdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class ProfileDeliverySettingsFragment_MembersInjector implements MembersInjector<ProfileDeliverySettingsFragment> {
    public final Provider<ProfileDeliverySettingsViewModel> a;
    public final Provider<DataAwareAdapterPresenter> b;
    public final Provider<SimpleRecyclerAdapter> c;
    public final Provider<DeepLinkIntentFactory> d;
    public final Provider<BaseScreenPerformanceTracker> e;

    public ProfileDeliverySettingsFragment_MembersInjector(Provider<ProfileDeliverySettingsViewModel> provider, Provider<DataAwareAdapterPresenter> provider2, Provider<SimpleRecyclerAdapter> provider3, Provider<DeepLinkIntentFactory> provider4, Provider<BaseScreenPerformanceTracker> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static MembersInjector<ProfileDeliverySettingsFragment> create(Provider<ProfileDeliverySettingsViewModel> provider, Provider<DataAwareAdapterPresenter> provider2, Provider<SimpleRecyclerAdapter> provider3, Provider<DeepLinkIntentFactory> provider4, Provider<BaseScreenPerformanceTracker> provider5) {
        return new ProfileDeliverySettingsFragment_MembersInjector(provider, provider2, provider3, provider4, provider5);
    }

    @InjectedFieldSignature("com.avito.android.safedeal.profile_settings.ProfileDeliverySettingsFragment.adapterPresenter")
    public static void injectAdapterPresenter(ProfileDeliverySettingsFragment profileDeliverySettingsFragment, DataAwareAdapterPresenter dataAwareAdapterPresenter) {
        profileDeliverySettingsFragment.adapterPresenter = dataAwareAdapterPresenter;
    }

    @InjectedFieldSignature("com.avito.android.safedeal.profile_settings.ProfileDeliverySettingsFragment.deepLinkIntentFactory")
    public static void injectDeepLinkIntentFactory(ProfileDeliverySettingsFragment profileDeliverySettingsFragment, DeepLinkIntentFactory deepLinkIntentFactory) {
        profileDeliverySettingsFragment.deepLinkIntentFactory = deepLinkIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.safedeal.profile_settings.ProfileDeliverySettingsFragment.recyclerViewAdapter")
    public static void injectRecyclerViewAdapter(ProfileDeliverySettingsFragment profileDeliverySettingsFragment, SimpleRecyclerAdapter simpleRecyclerAdapter) {
        profileDeliverySettingsFragment.recyclerViewAdapter = simpleRecyclerAdapter;
    }

    @InjectedFieldSignature("com.avito.android.safedeal.profile_settings.ProfileDeliverySettingsFragment.tracker")
    public static void injectTracker(ProfileDeliverySettingsFragment profileDeliverySettingsFragment, BaseScreenPerformanceTracker baseScreenPerformanceTracker) {
        profileDeliverySettingsFragment.tracker = baseScreenPerformanceTracker;
    }

    @InjectedFieldSignature("com.avito.android.safedeal.profile_settings.ProfileDeliverySettingsFragment.viewModel")
    public static void injectViewModel(ProfileDeliverySettingsFragment profileDeliverySettingsFragment, ProfileDeliverySettingsViewModel profileDeliverySettingsViewModel) {
        profileDeliverySettingsFragment.viewModel = profileDeliverySettingsViewModel;
    }

    public void injectMembers(ProfileDeliverySettingsFragment profileDeliverySettingsFragment) {
        injectViewModel(profileDeliverySettingsFragment, this.a.get());
        injectAdapterPresenter(profileDeliverySettingsFragment, this.b.get());
        injectRecyclerViewAdapter(profileDeliverySettingsFragment, this.c.get());
        injectDeepLinkIntentFactory(profileDeliverySettingsFragment, this.d.get());
        injectTracker(profileDeliverySettingsFragment, this.e.get());
    }
}
