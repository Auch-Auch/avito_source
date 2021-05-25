package com.avito.android.profile_phones.phones_list;

import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.profile_phones.phones_list.list_item.PhoneListItem;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import io.reactivex.rxjava3.core.Observable;
import javax.inject.Provider;
public final class PhonesListFragment_MembersInjector implements MembersInjector<PhonesListFragment> {
    public final Provider<Observable<PhoneListItem>> a;
    public final Provider<ViewModelProvider.Factory> b;
    public final Provider<RecyclerView.Adapter<?>> c;
    public final Provider<AdapterPresenter> d;
    public final Provider<ActivityIntentFactory> e;
    public final Provider<DeepLinkIntentFactory> f;
    public final Provider<Analytics> g;

    public PhonesListFragment_MembersInjector(Provider<Observable<PhoneListItem>> provider, Provider<ViewModelProvider.Factory> provider2, Provider<RecyclerView.Adapter<?>> provider3, Provider<AdapterPresenter> provider4, Provider<ActivityIntentFactory> provider5, Provider<DeepLinkIntentFactory> provider6, Provider<Analytics> provider7) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
    }

    public static MembersInjector<PhonesListFragment> create(Provider<Observable<PhoneListItem>> provider, Provider<ViewModelProvider.Factory> provider2, Provider<RecyclerView.Adapter<?>> provider3, Provider<AdapterPresenter> provider4, Provider<ActivityIntentFactory> provider5, Provider<DeepLinkIntentFactory> provider6, Provider<Analytics> provider7) {
        return new PhonesListFragment_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    @InjectedFieldSignature("com.avito.android.profile_phones.phones_list.PhonesListFragment.activityIntentFactory")
    public static void injectActivityIntentFactory(PhonesListFragment phonesListFragment, ActivityIntentFactory activityIntentFactory) {
        phonesListFragment.activityIntentFactory = activityIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.profile_phones.phones_list.PhonesListFragment.adapter")
    public static void injectAdapter(PhonesListFragment phonesListFragment, RecyclerView.Adapter<?> adapter) {
        phonesListFragment.adapter = adapter;
    }

    @InjectedFieldSignature("com.avito.android.profile_phones.phones_list.PhonesListFragment.adapterPresenter")
    public static void injectAdapterPresenter(PhonesListFragment phonesListFragment, AdapterPresenter adapterPresenter) {
        phonesListFragment.adapterPresenter = adapterPresenter;
    }

    @InjectedFieldSignature("com.avito.android.profile_phones.phones_list.PhonesListFragment.analytics")
    public static void injectAnalytics(PhonesListFragment phonesListFragment, Analytics analytics) {
        phonesListFragment.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.profile_phones.phones_list.PhonesListFragment.deepLinkIntentFactory")
    public static void injectDeepLinkIntentFactory(PhonesListFragment phonesListFragment, DeepLinkIntentFactory deepLinkIntentFactory) {
        phonesListFragment.deepLinkIntentFactory = deepLinkIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.profile_phones.phones_list.PhonesListFragment.phoneListItemClickObservable")
    public static void injectPhoneListItemClickObservable(PhonesListFragment phonesListFragment, Observable<PhoneListItem> observable) {
        phonesListFragment.phoneListItemClickObservable = observable;
    }

    @InjectedFieldSignature("com.avito.android.profile_phones.phones_list.PhonesListFragment.phonesListViewModelFactory")
    public static void injectPhonesListViewModelFactory(PhonesListFragment phonesListFragment, ViewModelProvider.Factory factory) {
        phonesListFragment.phonesListViewModelFactory = factory;
    }

    public void injectMembers(PhonesListFragment phonesListFragment) {
        injectPhoneListItemClickObservable(phonesListFragment, this.a.get());
        injectPhonesListViewModelFactory(phonesListFragment, this.b.get());
        injectAdapter(phonesListFragment, this.c.get());
        injectAdapterPresenter(phonesListFragment, this.d.get());
        injectActivityIntentFactory(phonesListFragment, this.e.get());
        injectDeepLinkIntentFactory(phonesListFragment, this.f.get());
        injectAnalytics(phonesListFragment, this.g.get());
    }
}
