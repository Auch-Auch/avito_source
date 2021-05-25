package com.avito.android.payment.di.module;

import com.avito.android.di.DialogRouterModule;
import com.avito.android.di.PerActivity;
import com.avito.android.payment.SubmitButtonBlueprint;
import com.avito.android.payment.form.PaymentStatusProcessingPresenter;
import com.avito.android.payment.form.PaymentStatusProcessingPresenterImpl;
import com.avito.android.payment.form.status.ActiveStatusWrappingPresenter;
import com.avito.android.payment.form.status.PaymentStatusFormInteractor;
import com.avito.android.payment.form.status.PaymentStatusFormInteractorImpl;
import com.avito.android.payment.form.status.PaymentStatusFormItemConverter;
import com.avito.android.payment.form.status.PaymentStatusFormItemConverterImpl;
import com.avito.android.payment.form.status.PaymentStatusFormPresenter;
import com.avito.android.payment.form.status.PaymentStatusFormPresenterImpl;
import com.avito.android.payment.form.status.StatusFormProcessingPresenter;
import com.avito.android.payment.items.DisclaimerTextBlueprint;
import com.avito.android.payment.items.PaymentInfoTextBlueprint;
import com.avito.android.payment.items.TextItemPresenter;
import com.avito.android.payment.items.TextItemPresenterImpl;
import com.avito.android.payment.remote.PaymentApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.android.util.text.AttributedTextFormatterModule;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import dagger.Lazy;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.button.ButtonItemPresenter;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B#\u0012\b\u0010H\u001a\u0004\u0018\u00010E\u0012\b\u0010N\u001a\u0004\u0018\u00010E\u0012\u0006\u0010L\u001a\u00020I¢\u0006\u0004\bO\u0010PJ\u001f\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\u0010\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0019\u001a\u00020\u0011H\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001aH\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\"\u001a\u00020!2\u0006\u0010 \u001a\u00020\u001fH\u0007¢\u0006\u0004\b\"\u0010#J\u001f\u0010&\u001a\u00020%2\u0006\u0010$\u001a\u00020!2\u0006\u0010 \u001a\u00020\u001fH\u0007¢\u0006\u0004\b&\u0010'J'\u00100\u001a\u00020\u001f2\u0006\u0010)\u001a\u00020(2\u0006\u0010+\u001a\u00020*2\u0006\u0010-\u001a\u00020,H\u0001¢\u0006\u0004\b.\u0010/J\u0017\u00105\u001a\u00020(2\u0006\u00102\u001a\u000201H\u0001¢\u0006\u0004\b3\u00104J\u001d\u0010:\u001a\u0002012\f\u00107\u001a\b\u0012\u0004\u0012\u00020\r06H\u0001¢\u0006\u0004\b8\u00109J\u0017\u0010>\u001a\u00020*2\u0006\u00102\u001a\u00020;H\u0001¢\u0006\u0004\b<\u0010=J\u0017\u0010A\u001a\u00020,2\u0006\u00102\u001a\u00020;H\u0001¢\u0006\u0004\b?\u0010@J\u000f\u0010D\u001a\u00020;H\u0001¢\u0006\u0004\bB\u0010CR\u0018\u0010H\u001a\u0004\u0018\u00010E8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010L\u001a\u00020I8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bJ\u0010KR\u0018\u0010N\u001a\u0004\u0018\u00010E8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bM\u0010G¨\u0006Q"}, d2 = {"Lcom/avito/android/payment/di/module/PaymentStatusFormModule;", "", "Lcom/avito/android/payment/remote/PaymentApi;", "api", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "Lcom/avito/android/payment/form/status/PaymentStatusFormInteractor;", "providePaymentStatusFormInteractor$payment_release", "(Lcom/avito/android/payment/remote/PaymentApi;Lcom/avito/android/util/SchedulersFactory;)Lcom/avito/android/payment/form/status/PaymentStatusFormInteractor;", "providePaymentStatusFormInteractor", "interactor", "Lcom/avito/android/payment/form/status/PaymentStatusFormItemConverter;", "itemConverter", "Lcom/avito/android/payment/form/status/PaymentStatusFormPresenter;", "providePaymentStatusFormPresenter$payment_release", "(Lcom/avito/android/payment/form/status/PaymentStatusFormInteractor;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/payment/form/status/PaymentStatusFormItemConverter;)Lcom/avito/android/payment/form/status/PaymentStatusFormPresenter;", "providePaymentStatusFormPresenter", "Lcom/avito/android/payment/form/PaymentStatusProcessingPresenter;", "delegate", "Lcom/avito/android/payment/form/status/StatusFormProcessingPresenter;", "provideStatusFormProcessingPresenter$payment_release", "(Lcom/avito/android/payment/form/PaymentStatusProcessingPresenter;)Lcom/avito/android/payment/form/status/StatusFormProcessingPresenter;", "provideStatusFormProcessingPresenter", "providePaymentStatusProcessingPresenter$payment_release", "()Lcom/avito/android/payment/form/PaymentStatusProcessingPresenter;", "providePaymentStatusProcessingPresenter", "Lcom/avito/android/util/text/AttributedTextFormatter;", "attributedTextFormatter", "provideItemConverter$payment_release", "(Lcom/avito/android/util/text/AttributedTextFormatter;)Lcom/avito/android/payment/form/status/PaymentStatusFormItemConverter;", "provideItemConverter", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "provideAdapterPresenter", "(Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "provideRecyclerAdapter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "Lcom/avito/android/payment/SubmitButtonBlueprint;", "submitButtonBlueprint", "Lcom/avito/android/payment/items/PaymentInfoTextBlueprint;", "paymentInfoTextBlueprint", "Lcom/avito/android/payment/items/DisclaimerTextBlueprint;", "disclaimerTextBlueprint", "provideItemBinder$payment_release", "(Lcom/avito/android/payment/SubmitButtonBlueprint;Lcom/avito/android/payment/items/PaymentInfoTextBlueprint;Lcom/avito/android/payment/items/DisclaimerTextBlueprint;)Lcom/avito/konveyor/ItemBinder;", "provideItemBinder", "Lru/avito/component/button/ButtonItemPresenter;", "presenter", "provideSubmitButtonBlueprint$payment_release", "(Lru/avito/component/button/ButtonItemPresenter;)Lcom/avito/android/payment/SubmitButtonBlueprint;", "provideSubmitButtonBlueprint", "Ldagger/Lazy;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "provideRaisedButtonItemPresenter$payment_release", "(Ldagger/Lazy;)Lru/avito/component/button/ButtonItemPresenter;", "provideRaisedButtonItemPresenter", "Lcom/avito/android/payment/items/TextItemPresenter;", "providePaymentInfoTextBlueprint$payment_release", "(Lcom/avito/android/payment/items/TextItemPresenter;)Lcom/avito/android/payment/items/PaymentInfoTextBlueprint;", "providePaymentInfoTextBlueprint", "provideDisclaimerTextBlueprint$payment_release", "(Lcom/avito/android/payment/items/TextItemPresenter;)Lcom/avito/android/payment/items/DisclaimerTextBlueprint;", "provideDisclaimerTextBlueprint", "provideTextItemPresenter$payment_release", "()Lcom/avito/android/payment/items/TextItemPresenter;", "provideTextItemPresenter", "Lcom/avito/android/util/Kundle;", AuthSource.SEND_ABUSE, "Lcom/avito/android/util/Kundle;", "interactorState", "", "c", "Ljava/lang/String;", AnalyticFieldsName.orderId, AuthSource.BOOKING_ORDER, "processingPresenterState", "<init>", "(Lcom/avito/android/util/Kundle;Lcom/avito/android/util/Kundle;Ljava/lang/String;)V", "payment_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {DialogRouterModule.class, AttributedTextFormatterModule.class})
public final class PaymentStatusFormModule {
    public final Kundle a;
    public final Kundle b;
    public final String c;

    public static final class a extends Lambda implements Function1<String, Unit> {
        public final /* synthetic */ Lazy a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Lazy lazy) {
            super(1);
            this.a = lazy;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(String str) {
            Intrinsics.checkNotNullParameter(str, "it");
            ((PaymentStatusFormPresenter) this.a.get()).getSubmitButtonListener().invoke();
            return Unit.INSTANCE;
        }
    }

    public PaymentStatusFormModule(@Nullable Kundle kundle, @Nullable Kundle kundle2, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, AnalyticFieldsName.orderId);
        this.a = kundle;
        this.b = kundle2;
        this.c = str;
    }

    @Provides
    @PerActivity
    @NotNull
    public final AdapterPresenter provideAdapterPresenter(@NotNull ItemBinder itemBinder) {
        return a2.b.a.a.a.D1(itemBinder, "itemBinder", itemBinder, itemBinder);
    }

    @Provides
    @PerActivity
    @NotNull
    public final DisclaimerTextBlueprint provideDisclaimerTextBlueprint$payment_release(@NotNull TextItemPresenter textItemPresenter) {
        Intrinsics.checkNotNullParameter(textItemPresenter, "presenter");
        return new DisclaimerTextBlueprint(textItemPresenter);
    }

    @Provides
    @PerActivity
    @NotNull
    public final ItemBinder provideItemBinder$payment_release(@NotNull SubmitButtonBlueprint submitButtonBlueprint, @NotNull PaymentInfoTextBlueprint paymentInfoTextBlueprint, @NotNull DisclaimerTextBlueprint disclaimerTextBlueprint) {
        Intrinsics.checkNotNullParameter(submitButtonBlueprint, "submitButtonBlueprint");
        Intrinsics.checkNotNullParameter(paymentInfoTextBlueprint, "paymentInfoTextBlueprint");
        Intrinsics.checkNotNullParameter(disclaimerTextBlueprint, "disclaimerTextBlueprint");
        return new ItemBinder.Builder().registerItem(submitButtonBlueprint).registerItem(paymentInfoTextBlueprint).registerItem(disclaimerTextBlueprint).build();
    }

    @Provides
    @PerActivity
    @NotNull
    public final PaymentStatusFormItemConverter provideItemConverter$payment_release(@NotNull AttributedTextFormatter attributedTextFormatter) {
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "attributedTextFormatter");
        return new PaymentStatusFormItemConverterImpl(attributedTextFormatter);
    }

    @Provides
    @PerActivity
    @NotNull
    public final PaymentInfoTextBlueprint providePaymentInfoTextBlueprint$payment_release(@NotNull TextItemPresenter textItemPresenter) {
        Intrinsics.checkNotNullParameter(textItemPresenter, "presenter");
        return new PaymentInfoTextBlueprint(textItemPresenter);
    }

    @Provides
    @PerActivity
    @NotNull
    public final PaymentStatusFormInteractor providePaymentStatusFormInteractor$payment_release(@NotNull PaymentApi paymentApi, @NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(paymentApi, "api");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        return new PaymentStatusFormInteractorImpl(paymentApi, this.c, schedulersFactory, this.a);
    }

    @Provides
    @PerActivity
    @NotNull
    public final PaymentStatusFormPresenter providePaymentStatusFormPresenter$payment_release(@NotNull PaymentStatusFormInteractor paymentStatusFormInteractor, @NotNull SchedulersFactory schedulersFactory, @NotNull PaymentStatusFormItemConverter paymentStatusFormItemConverter) {
        Intrinsics.checkNotNullParameter(paymentStatusFormInteractor, "interactor");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        Intrinsics.checkNotNullParameter(paymentStatusFormItemConverter, "itemConverter");
        return new PaymentStatusFormPresenterImpl(paymentStatusFormInteractor, paymentStatusFormItemConverter, schedulersFactory);
    }

    @Provides
    @PerActivity
    @NotNull
    public final PaymentStatusProcessingPresenter providePaymentStatusProcessingPresenter$payment_release() {
        return new PaymentStatusProcessingPresenterImpl();
    }

    @Provides
    @NotNull
    @PerActivity
    public final ButtonItemPresenter provideRaisedButtonItemPresenter$payment_release(@NotNull Lazy<PaymentStatusFormPresenter> lazy) {
        Intrinsics.checkNotNullParameter(lazy, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        return new ButtonItemPresenter(new a(lazy));
    }

    @Provides
    @PerActivity
    @NotNull
    public final SimpleRecyclerAdapter provideRecyclerAdapter(@NotNull AdapterPresenter adapterPresenter, @NotNull ItemBinder itemBinder) {
        return a2.b.a.a.a.E1(adapterPresenter, "adapterPresenter", itemBinder, "itemBinder", adapterPresenter, itemBinder);
    }

    @Provides
    @PerActivity
    @NotNull
    public final StatusFormProcessingPresenter provideStatusFormProcessingPresenter$payment_release(@NotNull PaymentStatusProcessingPresenter paymentStatusProcessingPresenter) {
        Intrinsics.checkNotNullParameter(paymentStatusProcessingPresenter, "delegate");
        return new ActiveStatusWrappingPresenter(paymentStatusProcessingPresenter, this.b);
    }

    @Provides
    @PerActivity
    @NotNull
    public final SubmitButtonBlueprint provideSubmitButtonBlueprint$payment_release(@NotNull ButtonItemPresenter buttonItemPresenter) {
        Intrinsics.checkNotNullParameter(buttonItemPresenter, "presenter");
        return new SubmitButtonBlueprint(buttonItemPresenter);
    }

    @Provides
    @PerActivity
    @NotNull
    public final TextItemPresenter provideTextItemPresenter$payment_release() {
        return new TextItemPresenterImpl();
    }
}
