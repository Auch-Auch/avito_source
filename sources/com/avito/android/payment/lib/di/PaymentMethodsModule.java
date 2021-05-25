package com.avito.android.payment.lib.di;

import a2.b.a.a.a;
import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.ListUpdateCallback;
import arrow.core.Function1Kt;
import com.avito.android.Features;
import com.avito.android.deep_linking.DeepLinkFactory;
import com.avito.android.di.DialogRouterModule;
import com.avito.android.di.PerActivity;
import com.avito.android.payment.NativeMethodsInteractor;
import com.avito.android.payment.PaymentMethodsContentsComparator;
import com.avito.android.payment.di.module.NativePaymentMethodsModule;
import com.avito.android.payment.google_pay.GooglePayInteractor;
import com.avito.android.payment.lib.PaymentGenericInteractor;
import com.avito.android.payment.lib.PaymentMethodsViewModel;
import com.avito.android.payment.lib.PaymentMethodsViewModelFactory;
import com.avito.android.payment.lib.PaymentSessionInteractor;
import com.avito.android.payment.lib.PaymentSessionType;
import com.avito.android.payment.processing.PaymentStatusPollingInteractor;
import com.avito.android.payment.processing.PaymentStatusPollingInteractorImpl;
import com.avito.android.payment.remote.PaymentApi;
import com.avito.android.recycler.data_aware.DataAwareAdapterPresenter;
import com.avito.android.recycler.data_aware.DataAwareAdapterPresenterImpl;
import com.avito.android.recycler.data_aware.DiffCalculator;
import com.avito.android.recycler.data_aware.SimpleDiffCalculator;
import com.avito.android.recycler.data_aware.SimpleEqualityComparator;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.util.SchedulersFactory;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import dagger.Lazy;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import ru.avito.component.payments.method.list.MaterialPaymentMethodItem;
import ru.avito.component.payments.method.list.material.HorizontalMaterialPaymentMethodBlueprint;
import ru.avito.component.payments.method.list.material.MaterialPaymentMethodItemPresenter;
import ru.avito.component.payments.method.list.material.PaymentMethodWidthProvider;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001:\u0002\u0015\u0016B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0017"}, d2 = {"Lcom/avito/android/payment/lib/di/PaymentMethodsModule;", "", "Lcom/avito/android/payment/lib/PaymentMethodsViewModelFactory;", "factory", "Landroid/app/Activity;", "activity", "Lcom/avito/android/payment/lib/PaymentMethodsViewModel;", "provideViewModel", "(Lcom/avito/android/payment/lib/PaymentMethodsViewModelFactory;Landroid/app/Activity;)Lcom/avito/android/payment/lib/PaymentMethodsViewModel;", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "provideAdapterPresenter", "(Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/AdapterPresenter;", "Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "provideRecyclerAdapter", "(Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "<init>", "()V", "Declarations", "RecyclerViewDeclarations", "payment-lib_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {NativePaymentMethodsModule.class, DialogRouterModule.class, Declarations.class, RecyclerViewDeclarations.class})
public final class PaymentMethodsModule {
    @NotNull
    public static final PaymentMethodsModule INSTANCE = new PaymentMethodsModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b!\u0010\"JW\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0019H\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010\u001d\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0019H\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u001f\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0017H\u0007¢\u0006\u0004\b\u001f\u0010 ¨\u0006#"}, d2 = {"Lcom/avito/android/payment/lib/di/PaymentMethodsModule$Declarations;", "", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "Lcom/avito/android/payment/lib/PaymentSessionInteractor;", "paymentSessionInteractor", "Lcom/avito/android/payment/NativeMethodsInteractor;", "nativeMethodsInteractor", "Lcom/avito/android/payment/google_pay/GooglePayInteractor;", "googlePayInteractor", "Lcom/avito/android/payment/lib/PaymentGenericInteractor;", "paymentGenericInteractor", "Lcom/avito/android/payment/processing/PaymentStatusPollingInteractor;", "paymentStatusInteractor", "Lcom/avito/android/payment/lib/PaymentSessionType;", "paymentSessionType", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "throwableConverter", "Lcom/avito/android/deep_linking/DeepLinkFactory;", "deepLinkFactory", "Lcom/avito/android/payment/lib/PaymentMethodsViewModelFactory;", "bindViewModuleFactory", "(Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/payment/lib/PaymentSessionInteractor;Lcom/avito/android/payment/NativeMethodsInteractor;Lcom/avito/android/payment/google_pay/GooglePayInteractor;Lcom/avito/android/payment/lib/PaymentGenericInteractor;Lcom/avito/android/payment/processing/PaymentStatusPollingInteractor;Lcom/avito/android/payment/lib/PaymentSessionType;Lcom/avito/android/remote/error/TypedErrorThrowableConverter;Lcom/avito/android/deep_linking/DeepLinkFactory;)Lcom/avito/android/payment/lib/PaymentMethodsViewModelFactory;", "Lcom/avito/android/payment/remote/PaymentApi;", "paymentApi", "Lcom/avito/android/Features;", "features", "providePaymentMethodsInteractor", "(Lcom/avito/android/payment/remote/PaymentApi;Lcom/avito/android/Features;)Lcom/avito/android/payment/lib/PaymentSessionInteractor;", "providePaymentGenericInteractor", "(Lcom/avito/android/payment/remote/PaymentApi;Lcom/avito/android/Features;)Lcom/avito/android/payment/lib/PaymentGenericInteractor;", "providePaymentStatusInteractor", "(Lcom/avito/android/payment/remote/PaymentApi;)Lcom/avito/android/payment/processing/PaymentStatusPollingInteractor;", "<init>", "()V", "payment-lib_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public static final class Declarations {
        @NotNull
        public static final Declarations INSTANCE = new Declarations();

        @Provides
        @JvmStatic
        @NotNull
        @PerActivity
        public static final PaymentMethodsViewModelFactory bindViewModuleFactory(@NotNull SchedulersFactory schedulersFactory, @NotNull PaymentSessionInteractor paymentSessionInteractor, @NotNull NativeMethodsInteractor nativeMethodsInteractor, @NotNull GooglePayInteractor googlePayInteractor, @NotNull PaymentGenericInteractor paymentGenericInteractor, @NotNull PaymentStatusPollingInteractor paymentStatusPollingInteractor, @NotNull PaymentSessionType paymentSessionType, @NotNull TypedErrorThrowableConverter typedErrorThrowableConverter, @NotNull DeepLinkFactory deepLinkFactory) {
            Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
            Intrinsics.checkNotNullParameter(paymentSessionInteractor, "paymentSessionInteractor");
            Intrinsics.checkNotNullParameter(nativeMethodsInteractor, "nativeMethodsInteractor");
            Intrinsics.checkNotNullParameter(googlePayInteractor, "googlePayInteractor");
            Intrinsics.checkNotNullParameter(paymentGenericInteractor, "paymentGenericInteractor");
            Intrinsics.checkNotNullParameter(paymentStatusPollingInteractor, "paymentStatusInteractor");
            Intrinsics.checkNotNullParameter(paymentSessionType, "paymentSessionType");
            Intrinsics.checkNotNullParameter(typedErrorThrowableConverter, "throwableConverter");
            Intrinsics.checkNotNullParameter(deepLinkFactory, "deepLinkFactory");
            return new PaymentMethodsViewModelFactory(schedulersFactory, paymentSessionInteractor, nativeMethodsInteractor, googlePayInteractor, paymentGenericInteractor, paymentStatusPollingInteractor, paymentSessionType, typedErrorThrowableConverter, deepLinkFactory);
        }

        @Provides
        @JvmStatic
        @NotNull
        @PerActivity
        public static final PaymentGenericInteractor providePaymentGenericInteractor(@NotNull PaymentApi paymentApi, @NotNull Features features) {
            Intrinsics.checkNotNullParameter(paymentApi, "paymentApi");
            Intrinsics.checkNotNullParameter(features, "features");
            return new PaymentGenericInteractor(paymentApi, features);
        }

        @Provides
        @JvmStatic
        @NotNull
        @PerActivity
        public static final PaymentSessionInteractor providePaymentMethodsInteractor(@NotNull PaymentApi paymentApi, @NotNull Features features) {
            Intrinsics.checkNotNullParameter(paymentApi, "paymentApi");
            Intrinsics.checkNotNullParameter(features, "features");
            return new PaymentSessionInteractor(paymentApi, features);
        }

        @Provides
        @JvmStatic
        @NotNull
        @PerActivity
        public static final PaymentStatusPollingInteractor providePaymentStatusInteractor(@NotNull PaymentApi paymentApi) {
            Intrinsics.checkNotNullParameter(paymentApi, "paymentApi");
            return new PaymentStatusPollingInteractorImpl(paymentApi);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b1\u00102J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\u000e\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0001¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0001¢\u0006\u0004\b\u0011\u0010\u0012J#\u0010\u001a\u001a\u00020\n2\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u0014H\u0001¢\u0006\u0004\b\u0018\u0010\u0019J-\u0010%\u001a\u00020\"2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020 H\u0001¢\u0006\u0004\b#\u0010$J\u0017\u0010*\u001a\u00020 2\u0006\u0010'\u001a\u00020&H\u0001¢\u0006\u0004\b(\u0010)J\u000f\u0010+\u001a\u00020&H\u0007¢\u0006\u0004\b+\u0010,J\u0017\u0010/\u001a\u00020\u001c2\u0006\u0010.\u001a\u00020-H\u0007¢\u0006\u0004\b/\u00100¨\u00063"}, d2 = {"Lcom/avito/android/payment/lib/di/PaymentMethodsModule$RecyclerViewDeclarations;", "", "Lru/avito/component/payments/method/list/material/HorizontalMaterialPaymentMethodBlueprint;", "paymentMethodBlueprint", "Lcom/avito/konveyor/ItemBinder;", "provideItemBinder$payment_lib_release", "(Lru/avito/component/payments/method/list/material/HorizontalMaterialPaymentMethodBlueprint;)Lcom/avito/konveyor/ItemBinder;", "provideItemBinder", "Lru/avito/component/payments/method/list/material/PaymentMethodWidthProvider;", "paymentMethodWidthProvider", "Lru/avito/component/payments/method/list/material/MaterialPaymentMethodItemPresenter;", "presenter", "provideHorizontalMaterialPaymentMethodBlueprint$payment_lib_release", "(Lru/avito/component/payments/method/list/material/PaymentMethodWidthProvider;Lru/avito/component/payments/method/list/material/MaterialPaymentMethodItemPresenter;)Lru/avito/component/payments/method/list/material/HorizontalMaterialPaymentMethodBlueprint;", "provideHorizontalMaterialPaymentMethodBlueprint", "Landroid/app/Activity;", "activity", "providePaymentMethodWidthProvider$payment_lib_release", "(Landroid/app/Activity;)Lru/avito/component/payments/method/list/material/PaymentMethodWidthProvider;", "providePaymentMethodWidthProvider", "Larrow/core/Function1;", "", "", "onPaymentMethodClickListener", "provideMaterialPaymentMethodItemPresenter$payment_lib_release", "(Larrow/core/Function1;)Lru/avito/component/payments/method/list/material/MaterialPaymentMethodItemPresenter;", "provideMaterialPaymentMethodItemPresenter", "Ldagger/Lazy;", "Landroidx/recyclerview/widget/ListUpdateCallback;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/android/recycler/data_aware/DiffCalculator;", "diffCalculator", "Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;", "provideDataAwareAdapterPresenter$payment_lib_release", "(Ldagger/Lazy;Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/android/recycler/data_aware/DiffCalculator;)Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;", "provideDataAwareAdapterPresenter", "Lcom/avito/android/payment/PaymentMethodsContentsComparator;", "contentsComparator", "provideDiffCalculator$payment_lib_release", "(Lcom/avito/android/payment/PaymentMethodsContentsComparator;)Lcom/avito/android/recycler/data_aware/DiffCalculator;", "provideDiffCalculator", "provideContentsComparator", "()Lcom/avito/android/payment/PaymentMethodsContentsComparator;", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "adapter", "provideListUpdateListener", "(Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;)Landroidx/recyclerview/widget/ListUpdateCallback;", "<init>", "()V", "payment-lib_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public static final class RecyclerViewDeclarations {
        @NotNull
        public static final RecyclerViewDeclarations INSTANCE = new RecyclerViewDeclarations();

        public static final class a extends Lambda implements Function1<MaterialPaymentMethodItem, Unit> {
            public static final a a = new a();

            public a() {
                super(1);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(MaterialPaymentMethodItem materialPaymentMethodItem) {
                Intrinsics.checkNotNullParameter(materialPaymentMethodItem, "paymentMethodItem");
                return Unit.INSTANCE;
            }
        }

        public static final class b extends Lambda implements Function1<Integer, Unit> {
            public final /* synthetic */ arrow.core.Function1 a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public b(arrow.core.Function1 function1) {
                super(1);
                this.a = function1;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(Integer num) {
                Function1Kt.invoke(this.a, Integer.valueOf(num.intValue()));
                return Unit.INSTANCE;
            }
        }

        @Provides
        @JvmStatic
        @NotNull
        @PerActivity
        public static final PaymentMethodsContentsComparator provideContentsComparator() {
            return new PaymentMethodsContentsComparator();
        }

        @Provides
        @JvmStatic
        @NotNull
        @PerActivity
        public static final DataAwareAdapterPresenter provideDataAwareAdapterPresenter$payment_lib_release(@NotNull Lazy<ListUpdateCallback> lazy, @NotNull AdapterPresenter adapterPresenter, @NotNull DiffCalculator diffCalculator) {
            Intrinsics.checkNotNullParameter(lazy, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
            Intrinsics.checkNotNullParameter(diffCalculator, "diffCalculator");
            return new DataAwareAdapterPresenterImpl(lazy, adapterPresenter, diffCalculator);
        }

        @Provides
        @JvmStatic
        @NotNull
        @PerActivity
        public static final DiffCalculator provideDiffCalculator$payment_lib_release(@NotNull PaymentMethodsContentsComparator paymentMethodsContentsComparator) {
            Intrinsics.checkNotNullParameter(paymentMethodsContentsComparator, "contentsComparator");
            return new SimpleDiffCalculator(paymentMethodsContentsComparator, new SimpleEqualityComparator(), true, null, 8, null);
        }

        @Provides
        @JvmStatic
        @NotNull
        @PerActivity
        public static final HorizontalMaterialPaymentMethodBlueprint provideHorizontalMaterialPaymentMethodBlueprint$payment_lib_release(@NotNull PaymentMethodWidthProvider paymentMethodWidthProvider, @NotNull MaterialPaymentMethodItemPresenter materialPaymentMethodItemPresenter) {
            Intrinsics.checkNotNullParameter(paymentMethodWidthProvider, "paymentMethodWidthProvider");
            Intrinsics.checkNotNullParameter(materialPaymentMethodItemPresenter, "presenter");
            return new HorizontalMaterialPaymentMethodBlueprint(materialPaymentMethodItemPresenter, paymentMethodWidthProvider);
        }

        @Provides
        @JvmStatic
        @NotNull
        @PerActivity
        public static final ItemBinder provideItemBinder$payment_lib_release(@NotNull HorizontalMaterialPaymentMethodBlueprint horizontalMaterialPaymentMethodBlueprint) {
            Intrinsics.checkNotNullParameter(horizontalMaterialPaymentMethodBlueprint, "paymentMethodBlueprint");
            return new ItemBinder.Builder().registerItem(horizontalMaterialPaymentMethodBlueprint).build();
        }

        @Provides
        @JvmStatic
        @NotNull
        @PerActivity
        public static final ListUpdateCallback provideListUpdateListener(@NotNull SimpleRecyclerAdapter simpleRecyclerAdapter) {
            Intrinsics.checkNotNullParameter(simpleRecyclerAdapter, "adapter");
            return simpleRecyclerAdapter;
        }

        @Provides
        @JvmStatic
        @NotNull
        @PerActivity
        public static final MaterialPaymentMethodItemPresenter provideMaterialPaymentMethodItemPresenter$payment_lib_release(@NotNull arrow.core.Function1<Integer, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, "onPaymentMethodClickListener");
            return new MaterialPaymentMethodItemPresenter(a.a, new b(function1));
        }

        @Provides
        @JvmStatic
        @NotNull
        @PerActivity
        public static final PaymentMethodWidthProvider providePaymentMethodWidthProvider$payment_lib_release(@NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            return new PaymentMethodWidthProvider(activity);
        }
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final AdapterPresenter provideAdapterPresenter(@NotNull ItemBinder itemBinder) {
        return a.D1(itemBinder, "itemBinder", itemBinder, itemBinder);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final SimpleRecyclerAdapter provideRecyclerAdapter(@NotNull DataAwareAdapterPresenter dataAwareAdapterPresenter, @NotNull ItemBinder itemBinder) {
        Intrinsics.checkNotNullParameter(dataAwareAdapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(itemBinder, "itemBinder");
        return new SimpleRecyclerAdapter(dataAwareAdapterPresenter, itemBinder);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final PaymentMethodsViewModel provideViewModel(@NotNull PaymentMethodsViewModelFactory paymentMethodsViewModelFactory, @NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(paymentMethodsViewModelFactory, "factory");
        Intrinsics.checkNotNullParameter(activity, "activity");
        ViewModel viewModel = ViewModelProviders.of((FragmentActivity) activity, paymentMethodsViewModelFactory).get(PaymentMethodsViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProviders.of(ac…odsViewModel::class.java)");
        return (PaymentMethodsViewModel) viewModel;
    }
}
