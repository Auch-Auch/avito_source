package com.avito.android.user_advert.soa_with_price;

import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.analytics.Analytics;
import com.avito.android.user_advert.soa_with_price.blueprint.CloseReasonItemPresenter;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.BaseViewHolder;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class SoaWithPriceSheetDialogFragment_MembersInjector implements MembersInjector<SoaWithPriceSheetDialogFragment> {
    public final Provider<AdapterPresenter> a;
    public final Provider<RecyclerView.Adapter<BaseViewHolder>> b;
    public final Provider<CloseReasonItemPresenter> c;
    public final Provider<SchedulersFactory> d;
    public final Provider<AttributedTextFormatter> e;
    public final Provider<Analytics> f;
    public final Provider<SoaWithPriceViewModelFactory> g;

    public SoaWithPriceSheetDialogFragment_MembersInjector(Provider<AdapterPresenter> provider, Provider<RecyclerView.Adapter<BaseViewHolder>> provider2, Provider<CloseReasonItemPresenter> provider3, Provider<SchedulersFactory> provider4, Provider<AttributedTextFormatter> provider5, Provider<Analytics> provider6, Provider<SoaWithPriceViewModelFactory> provider7) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
    }

    public static MembersInjector<SoaWithPriceSheetDialogFragment> create(Provider<AdapterPresenter> provider, Provider<RecyclerView.Adapter<BaseViewHolder>> provider2, Provider<CloseReasonItemPresenter> provider3, Provider<SchedulersFactory> provider4, Provider<AttributedTextFormatter> provider5, Provider<Analytics> provider6, Provider<SoaWithPriceViewModelFactory> provider7) {
        return new SoaWithPriceSheetDialogFragment_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    @InjectedFieldSignature("com.avito.android.user_advert.soa_with_price.SoaWithPriceSheetDialogFragment.adapter")
    public static void injectAdapter(SoaWithPriceSheetDialogFragment soaWithPriceSheetDialogFragment, RecyclerView.Adapter<BaseViewHolder> adapter) {
        soaWithPriceSheetDialogFragment.adapter = adapter;
    }

    @InjectedFieldSignature("com.avito.android.user_advert.soa_with_price.SoaWithPriceSheetDialogFragment.adapterPresenter")
    public static void injectAdapterPresenter(SoaWithPriceSheetDialogFragment soaWithPriceSheetDialogFragment, AdapterPresenter adapterPresenter) {
        soaWithPriceSheetDialogFragment.adapterPresenter = adapterPresenter;
    }

    @InjectedFieldSignature("com.avito.android.user_advert.soa_with_price.SoaWithPriceSheetDialogFragment.analytics")
    public static void injectAnalytics(SoaWithPriceSheetDialogFragment soaWithPriceSheetDialogFragment, Analytics analytics) {
        soaWithPriceSheetDialogFragment.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.user_advert.soa_with_price.SoaWithPriceSheetDialogFragment.attributedTextFormatter")
    public static void injectAttributedTextFormatter(SoaWithPriceSheetDialogFragment soaWithPriceSheetDialogFragment, AttributedTextFormatter attributedTextFormatter) {
        soaWithPriceSheetDialogFragment.attributedTextFormatter = attributedTextFormatter;
    }

    @InjectedFieldSignature("com.avito.android.user_advert.soa_with_price.SoaWithPriceSheetDialogFragment.itemPresenter")
    public static void injectItemPresenter(SoaWithPriceSheetDialogFragment soaWithPriceSheetDialogFragment, CloseReasonItemPresenter closeReasonItemPresenter) {
        soaWithPriceSheetDialogFragment.itemPresenter = closeReasonItemPresenter;
    }

    @InjectedFieldSignature("com.avito.android.user_advert.soa_with_price.SoaWithPriceSheetDialogFragment.schedulers")
    public static void injectSchedulers(SoaWithPriceSheetDialogFragment soaWithPriceSheetDialogFragment, SchedulersFactory schedulersFactory) {
        soaWithPriceSheetDialogFragment.schedulers = schedulersFactory;
    }

    @InjectedFieldSignature("com.avito.android.user_advert.soa_with_price.SoaWithPriceSheetDialogFragment.viewModelFactory")
    public static void injectViewModelFactory(SoaWithPriceSheetDialogFragment soaWithPriceSheetDialogFragment, SoaWithPriceViewModelFactory soaWithPriceViewModelFactory) {
        soaWithPriceSheetDialogFragment.viewModelFactory = soaWithPriceViewModelFactory;
    }

    public void injectMembers(SoaWithPriceSheetDialogFragment soaWithPriceSheetDialogFragment) {
        injectAdapterPresenter(soaWithPriceSheetDialogFragment, this.a.get());
        injectAdapter(soaWithPriceSheetDialogFragment, this.b.get());
        injectItemPresenter(soaWithPriceSheetDialogFragment, this.c.get());
        injectSchedulers(soaWithPriceSheetDialogFragment, this.d.get());
        injectAttributedTextFormatter(soaWithPriceSheetDialogFragment, this.e.get());
        injectAnalytics(soaWithPriceSheetDialogFragment, this.f.get());
        injectViewModelFactory(soaWithPriceSheetDialogFragment, this.g.get());
    }
}
