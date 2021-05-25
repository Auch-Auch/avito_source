package com.avito.android.payment.wallet.history.details;

import com.avito.android.Features;
import com.avito.android.app.external.ApplicationInfoProvider;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class HistoryDetailsBottomSheetDialogFragment_MembersInjector implements MembersInjector<HistoryDetailsBottomSheetDialogFragment> {
    public final Provider<PaymentHistoryDetailsViewModelFactory> a;
    public final Provider<SimpleRecyclerAdapter> b;
    public final Provider<AdapterPresenter> c;
    public final Provider<Features> d;
    public final Provider<ApplicationInfoProvider> e;

    public HistoryDetailsBottomSheetDialogFragment_MembersInjector(Provider<PaymentHistoryDetailsViewModelFactory> provider, Provider<SimpleRecyclerAdapter> provider2, Provider<AdapterPresenter> provider3, Provider<Features> provider4, Provider<ApplicationInfoProvider> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static MembersInjector<HistoryDetailsBottomSheetDialogFragment> create(Provider<PaymentHistoryDetailsViewModelFactory> provider, Provider<SimpleRecyclerAdapter> provider2, Provider<AdapterPresenter> provider3, Provider<Features> provider4, Provider<ApplicationInfoProvider> provider5) {
        return new HistoryDetailsBottomSheetDialogFragment_MembersInjector(provider, provider2, provider3, provider4, provider5);
    }

    @InjectedFieldSignature("com.avito.android.payment.wallet.history.details.HistoryDetailsBottomSheetDialogFragment.adapter")
    public static void injectAdapter(HistoryDetailsBottomSheetDialogFragment historyDetailsBottomSheetDialogFragment, SimpleRecyclerAdapter simpleRecyclerAdapter) {
        historyDetailsBottomSheetDialogFragment.adapter = simpleRecyclerAdapter;
    }

    @InjectedFieldSignature("com.avito.android.payment.wallet.history.details.HistoryDetailsBottomSheetDialogFragment.adapterPresenter")
    public static void injectAdapterPresenter(HistoryDetailsBottomSheetDialogFragment historyDetailsBottomSheetDialogFragment, AdapterPresenter adapterPresenter) {
        historyDetailsBottomSheetDialogFragment.adapterPresenter = adapterPresenter;
    }

    @InjectedFieldSignature("com.avito.android.payment.wallet.history.details.HistoryDetailsBottomSheetDialogFragment.applicationInfoProvider")
    public static void injectApplicationInfoProvider(HistoryDetailsBottomSheetDialogFragment historyDetailsBottomSheetDialogFragment, ApplicationInfoProvider applicationInfoProvider) {
        historyDetailsBottomSheetDialogFragment.applicationInfoProvider = applicationInfoProvider;
    }

    @InjectedFieldSignature("com.avito.android.payment.wallet.history.details.HistoryDetailsBottomSheetDialogFragment.features")
    public static void injectFeatures(HistoryDetailsBottomSheetDialogFragment historyDetailsBottomSheetDialogFragment, Features features) {
        historyDetailsBottomSheetDialogFragment.features = features;
    }

    @InjectedFieldSignature("com.avito.android.payment.wallet.history.details.HistoryDetailsBottomSheetDialogFragment.paymentHistoryDetailsViewModelFactory")
    public static void injectPaymentHistoryDetailsViewModelFactory(HistoryDetailsBottomSheetDialogFragment historyDetailsBottomSheetDialogFragment, PaymentHistoryDetailsViewModelFactory paymentHistoryDetailsViewModelFactory) {
        historyDetailsBottomSheetDialogFragment.paymentHistoryDetailsViewModelFactory = paymentHistoryDetailsViewModelFactory;
    }

    public void injectMembers(HistoryDetailsBottomSheetDialogFragment historyDetailsBottomSheetDialogFragment) {
        injectPaymentHistoryDetailsViewModelFactory(historyDetailsBottomSheetDialogFragment, this.a.get());
        injectAdapter(historyDetailsBottomSheetDialogFragment, this.b.get());
        injectAdapterPresenter(historyDetailsBottomSheetDialogFragment, this.c.get());
        injectFeatures(historyDetailsBottomSheetDialogFragment, this.d.get());
        injectApplicationInfoProvider(historyDetailsBottomSheetDialogFragment, this.e.get());
    }
}
