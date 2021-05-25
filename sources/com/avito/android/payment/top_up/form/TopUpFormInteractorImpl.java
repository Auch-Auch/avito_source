package com.avito.android.payment.top_up.form;

import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.payment.caching_interactor.CachingInteractor;
import com.avito.android.payment.caching_interactor.SingleResultCachingInteractor;
import com.avito.android.payment.remote.PaymentApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.PretendResult;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.model.category_parameters.ParametersTree;
import com.avito.android.remote.model.payment.top_up.TopUpForm;
import com.avito.android.util.Kundle;
import com.avito.android.util.LoadingState;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.rx3.InteropKt;
import com.avito.android.validation.LocalPretendInteractor;
import io.reactivex.Observable;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B)\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b \u0010!J\u001b\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00050\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u00042\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ6\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00050\u00042\b\b\u0002\u0010\u000e\u001a\u00020\r2\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014H\u0001¢\u0006\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\""}, d2 = {"Lcom/avito/android/payment/top_up/form/TopUpFormInteractorImpl;", "Lcom/avito/android/payment/top_up/form/TopUpFormInteractor;", "Lcom/avito/android/payment/caching_interactor/CachingInteractor;", "Lcom/avito/android/remote/model/payment/top_up/TopUpForm;", "Lio/reactivex/Observable;", "Lcom/avito/android/util/LoadingState;", "getTopUpForm", "()Lio/reactivex/Observable;", "Lcom/avito/android/remote/model/category_parameters/ParametersTree;", ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT, "Lcom/avito/android/remote/model/PretendResult;", "validateUserInput", "(Lcom/avito/android/remote/model/category_parameters/ParametersTree;)Lio/reactivex/Observable;", "", "forceUpdate", "", "", "nativeMethods", "load", "(ZLjava/util/Set;)Lio/reactivex/Observable;", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "Lcom/avito/android/validation/LocalPretendInteractor;", AuthSource.SEND_ABUSE, "Lcom/avito/android/validation/LocalPretendInteractor;", "localPretendInteractor", "Lcom/avito/android/payment/remote/PaymentApi;", "api", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "state", "<init>", "(Lcom/avito/android/payment/remote/PaymentApi;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/validation/LocalPretendInteractor;Lcom/avito/android/util/Kundle;)V", "payment_release"}, k = 1, mv = {1, 4, 2})
public final class TopUpFormInteractorImpl implements TopUpFormInteractor, CachingInteractor<TopUpForm> {
    public final LocalPretendInteractor a;
    public final /* synthetic */ SingleResultCachingInteractor<TopUpForm> b;

    public static final class a extends Lambda implements Function1<Set<? extends String>, Observable<TypedResult<TopUpForm>>> {
        public final /* synthetic */ PaymentApi a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(PaymentApi paymentApi) {
            super(1);
            this.a = paymentApi;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Observable<TypedResult<TopUpForm>> invoke(Set<? extends String> set) {
            Intrinsics.checkNotNullParameter(set, "it");
            return InteropKt.toV2(this.a.getWalletTopUpForm());
        }
    }

    public TopUpFormInteractorImpl(@NotNull PaymentApi paymentApi, @NotNull SchedulersFactory schedulersFactory, @NotNull LocalPretendInteractor localPretendInteractor, @Nullable Kundle kundle) {
        Intrinsics.checkNotNullParameter(paymentApi, "api");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(localPretendInteractor, "localPretendInteractor");
        this.b = new SingleResultCachingInteractor<>(schedulersFactory, kundle, "WalletTopUPFormInteractor_cached_results", new a(paymentApi));
        this.a = localPretendInteractor;
    }

    @Override // com.avito.android.payment.top_up.form.TopUpFormInteractor
    @NotNull
    public Observable<LoadingState<TopUpForm>> getTopUpForm() {
        return CachingInteractor.DefaultImpls.load$default(this, false, null, 3, null);
    }

    @Override // com.avito.android.payment.caching_interactor.CachingInteractor
    @NotNull
    public Observable<LoadingState<TopUpForm>> load(boolean z, @NotNull Set<String> set) {
        Intrinsics.checkNotNullParameter(set, "nativeMethods");
        return this.b.load(z, set);
    }

    @Override // com.avito.android.payment.top_up.form.TopUpFormInteractor, com.avito.android.payment.caching_interactor.CachingInteractor
    @NotNull
    public Kundle onSaveState() {
        return this.b.onSaveState();
    }

    @Override // com.avito.android.payment.top_up.form.TopUpFormInteractor
    @NotNull
    public Observable<PretendResult> validateUserInput(@NotNull ParametersTree parametersTree) {
        Intrinsics.checkNotNullParameter(parametersTree, ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT);
        return InteropKt.toV2(this.a.pretend(parametersTree));
    }
}
