package com.avito.android.payment.di.module;

import a2.b.a.a.a;
import com.avito.android.di.PerFragment;
import com.avito.android.payment.remote.PaymentApi;
import com.avito.android.payment.wallet.history.details.PaymentHistoryDetailsInteractor;
import com.avito.android.payment.wallet.history.details.PaymentHistoryDetailsViewModelFactory;
import com.avito.android.payment.wallet.history.details.item.AdvertItemBlueprint;
import com.avito.android.payment.wallet.history.details.item.AdvertItemPresenter;
import com.avito.android.payment.wallet.history.details.item.BaseItemBlueprint;
import com.avito.android.payment.wallet.history.details.item.BaseItemPresenter;
import com.avito.android.payment.wallet.history.details.item.ButtonItemBlueprint;
import com.avito.android.payment.wallet.history.details.item.ButtonItemPresenter;
import com.avito.android.payment.wallet.history.details.item.SimpleItemBlueprint;
import com.avito.android.payment.wallet.history.details.item.SimpleItemPresenter;
import com.avito.android.util.SchedulersFactory;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b8\u00109J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0012\u0010\u0013J/\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001aH\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\"\u001a\u00020\u00142\u0006\u0010!\u001a\u00020 H\u0007¢\u0006\u0004\b\"\u0010#J\u0017\u0010&\u001a\u00020\u00162\u0006\u0010%\u001a\u00020$H\u0007¢\u0006\u0004\b&\u0010'J\u0017\u0010*\u001a\u00020\u00182\u0006\u0010)\u001a\u00020(H\u0007¢\u0006\u0004\b*\u0010+J\u0017\u0010.\u001a\u00020\u001a2\u0006\u0010-\u001a\u00020,H\u0007¢\u0006\u0004\b.\u0010/J\u000f\u00100\u001a\u00020$H\u0007¢\u0006\u0004\b0\u00101J\u000f\u00102\u001a\u00020 H\u0007¢\u0006\u0004\b2\u00103J\u000f\u00104\u001a\u00020(H\u0007¢\u0006\u0004\b4\u00105J\u000f\u00106\u001a\u00020,H\u0007¢\u0006\u0004\b6\u00107¨\u0006:"}, d2 = {"Lcom/avito/android/payment/di/module/HistoryDetailsModule;", "", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/payment/wallet/history/details/PaymentHistoryDetailsInteractor;", "paymentHistoryDetailsInteractor", "Lcom/avito/android/payment/wallet/history/details/PaymentHistoryDetailsViewModelFactory;", "providePaymentHistoryViewModelFactory", "(Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/payment/wallet/history/details/PaymentHistoryDetailsInteractor;)Lcom/avito/android/payment/wallet/history/details/PaymentHistoryDetailsViewModelFactory;", "Lcom/avito/android/payment/remote/PaymentApi;", "paymentApi", "providePaymentHistoryInteractor", "(Lcom/avito/android/payment/remote/PaymentApi;)Lcom/avito/android/payment/wallet/history/details/PaymentHistoryDetailsInteractor;", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "providerSimpleRecyclerAdapter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "Lcom/avito/android/payment/wallet/history/details/item/AdvertItemBlueprint;", "advertItemBlueprint", "Lcom/avito/android/payment/wallet/history/details/item/BaseItemBlueprint;", "baseItemBlueprint", "Lcom/avito/android/payment/wallet/history/details/item/SimpleItemBlueprint;", "simpleItemBlueprint", "Lcom/avito/android/payment/wallet/history/details/item/ButtonItemBlueprint;", "buttonItemBlueprint", "provideItemBinder", "(Lcom/avito/android/payment/wallet/history/details/item/AdvertItemBlueprint;Lcom/avito/android/payment/wallet/history/details/item/BaseItemBlueprint;Lcom/avito/android/payment/wallet/history/details/item/SimpleItemBlueprint;Lcom/avito/android/payment/wallet/history/details/item/ButtonItemBlueprint;)Lcom/avito/konveyor/ItemBinder;", "provideAdapterPresenter", "(Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/AdapterPresenter;", "Lcom/avito/android/payment/wallet/history/details/item/AdvertItemPresenter;", "advertItemPresenter", "provideAdvertItemBlueprint", "(Lcom/avito/android/payment/wallet/history/details/item/AdvertItemPresenter;)Lcom/avito/android/payment/wallet/history/details/item/AdvertItemBlueprint;", "Lcom/avito/android/payment/wallet/history/details/item/BaseItemPresenter;", "baseItemPresenter", "provideBaseItemBlueprint", "(Lcom/avito/android/payment/wallet/history/details/item/BaseItemPresenter;)Lcom/avito/android/payment/wallet/history/details/item/BaseItemBlueprint;", "Lcom/avito/android/payment/wallet/history/details/item/SimpleItemPresenter;", "simpleItemPresenter", "provideSimpleItemBlueprint", "(Lcom/avito/android/payment/wallet/history/details/item/SimpleItemPresenter;)Lcom/avito/android/payment/wallet/history/details/item/SimpleItemBlueprint;", "Lcom/avito/android/payment/wallet/history/details/item/ButtonItemPresenter;", "buttonItemPresenter", "provideButtonItemBlueprint", "(Lcom/avito/android/payment/wallet/history/details/item/ButtonItemPresenter;)Lcom/avito/android/payment/wallet/history/details/item/ButtonItemBlueprint;", "providerBaseItemPresenter", "()Lcom/avito/android/payment/wallet/history/details/item/BaseItemPresenter;", "providerAdvertItemPresenter", "()Lcom/avito/android/payment/wallet/history/details/item/AdvertItemPresenter;", "provideSimpleItemPresenter", "()Lcom/avito/android/payment/wallet/history/details/item/SimpleItemPresenter;", "provideButtonItemPresenter", "()Lcom/avito/android/payment/wallet/history/details/item/ButtonItemPresenter;", "<init>", "()V", "payment_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class HistoryDetailsModule {
    @Provides
    @PerFragment
    @NotNull
    public final AdapterPresenter provideAdapterPresenter(@NotNull ItemBinder itemBinder) {
        return a.D1(itemBinder, "itemBinder", itemBinder, itemBinder);
    }

    @Provides
    @PerFragment
    @NotNull
    public final AdvertItemBlueprint provideAdvertItemBlueprint(@NotNull AdvertItemPresenter advertItemPresenter) {
        Intrinsics.checkNotNullParameter(advertItemPresenter, "advertItemPresenter");
        return new AdvertItemBlueprint(advertItemPresenter);
    }

    @Provides
    @PerFragment
    @NotNull
    public final BaseItemBlueprint provideBaseItemBlueprint(@NotNull BaseItemPresenter baseItemPresenter) {
        Intrinsics.checkNotNullParameter(baseItemPresenter, "baseItemPresenter");
        return new BaseItemBlueprint(baseItemPresenter);
    }

    @Provides
    @PerFragment
    @NotNull
    public final ButtonItemBlueprint provideButtonItemBlueprint(@NotNull ButtonItemPresenter buttonItemPresenter) {
        Intrinsics.checkNotNullParameter(buttonItemPresenter, "buttonItemPresenter");
        return new ButtonItemBlueprint(buttonItemPresenter);
    }

    @Provides
    @PerFragment
    @NotNull
    public final ButtonItemPresenter provideButtonItemPresenter() {
        return new ButtonItemPresenter();
    }

    @Provides
    @PerFragment
    @NotNull
    public final ItemBinder provideItemBinder(@NotNull AdvertItemBlueprint advertItemBlueprint, @NotNull BaseItemBlueprint baseItemBlueprint, @NotNull SimpleItemBlueprint simpleItemBlueprint, @NotNull ButtonItemBlueprint buttonItemBlueprint) {
        Intrinsics.checkNotNullParameter(advertItemBlueprint, "advertItemBlueprint");
        Intrinsics.checkNotNullParameter(baseItemBlueprint, "baseItemBlueprint");
        Intrinsics.checkNotNullParameter(simpleItemBlueprint, "simpleItemBlueprint");
        Intrinsics.checkNotNullParameter(buttonItemBlueprint, "buttonItemBlueprint");
        return new ItemBinder.Builder().registerItem(advertItemBlueprint).registerItem(baseItemBlueprint).registerItem(simpleItemBlueprint).registerItem(buttonItemBlueprint).build();
    }

    @Provides
    @PerFragment
    @NotNull
    public final PaymentHistoryDetailsInteractor providePaymentHistoryInteractor(@NotNull PaymentApi paymentApi) {
        Intrinsics.checkNotNullParameter(paymentApi, "paymentApi");
        return new PaymentHistoryDetailsInteractor(paymentApi);
    }

    @Provides
    @PerFragment
    @NotNull
    public final PaymentHistoryDetailsViewModelFactory providePaymentHistoryViewModelFactory(@NotNull SchedulersFactory schedulersFactory, @NotNull PaymentHistoryDetailsInteractor paymentHistoryDetailsInteractor) {
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(paymentHistoryDetailsInteractor, "paymentHistoryDetailsInteractor");
        return new PaymentHistoryDetailsViewModelFactory(schedulersFactory, paymentHistoryDetailsInteractor);
    }

    @Provides
    @PerFragment
    @NotNull
    public final SimpleItemBlueprint provideSimpleItemBlueprint(@NotNull SimpleItemPresenter simpleItemPresenter) {
        Intrinsics.checkNotNullParameter(simpleItemPresenter, "simpleItemPresenter");
        return new SimpleItemBlueprint(simpleItemPresenter);
    }

    @Provides
    @PerFragment
    @NotNull
    public final SimpleItemPresenter provideSimpleItemPresenter() {
        return new SimpleItemPresenter();
    }

    @Provides
    @PerFragment
    @NotNull
    public final AdvertItemPresenter providerAdvertItemPresenter() {
        return new AdvertItemPresenter();
    }

    @Provides
    @PerFragment
    @NotNull
    public final BaseItemPresenter providerBaseItemPresenter() {
        return new BaseItemPresenter();
    }

    @Provides
    @PerFragment
    @NotNull
    public final SimpleRecyclerAdapter providerSimpleRecyclerAdapter(@NotNull AdapterPresenter adapterPresenter, @NotNull ItemBinder itemBinder) {
        return a.E1(adapterPresenter, "adapterPresenter", itemBinder, "itemBinder", adapterPresenter, itemBinder);
    }
}
