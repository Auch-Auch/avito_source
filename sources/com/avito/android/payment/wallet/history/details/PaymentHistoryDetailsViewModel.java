package com.avito.android.payment.wallet.history.details;

import a2.g.r.g;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorResult;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.model.payment.history.PaymentDetails;
import com.avito.android.util.SchedulersFactory;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.rxkotlin.DisposableKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001'B\u0017\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\u0006\u0010$\u001a\u00020!¢\u0006\u0004\b%\u0010&J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\u0006R\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u001f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001aR\u001f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00180\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u000f\u001a\u0004\b\u001f\u0010\u0011R\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006("}, d2 = {"Lcom/avito/android/payment/wallet/history/details/PaymentHistoryDetailsViewModel;", "Landroidx/lifecycle/ViewModel;", "", AnalyticFieldsName.orderId, "", "getOrderDetails", "(Ljava/lang/String;)V", "operationId", "getOperationDetails", "Lio/reactivex/disposables/CompositeDisposable;", "c", "Lio/reactivex/disposables/CompositeDisposable;", "disposables", "Landroidx/lifecycle/LiveData;", g.a, "Landroidx/lifecycle/LiveData;", "getTitle", "()Landroidx/lifecycle/LiveData;", "title", "Lcom/avito/android/util/SchedulersFactory;", "h", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "Landroidx/lifecycle/MutableLiveData;", "Lcom/avito/android/payment/wallet/history/details/PaymentHistoryDetailsViewModel$ViewState;", "d", "Landroidx/lifecycle/MutableLiveData;", "viewStateLiveData", "e", "titleLiveData", "f", "getViewState", "viewState", "Lcom/avito/android/payment/wallet/history/details/PaymentHistoryDetailsInteractor;", "i", "Lcom/avito/android/payment/wallet/history/details/PaymentHistoryDetailsInteractor;", "paymentHistoryDetailsInteractor", "<init>", "(Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/payment/wallet/history/details/PaymentHistoryDetailsInteractor;)V", "ViewState", "payment_release"}, k = 1, mv = {1, 4, 2})
public final class PaymentHistoryDetailsViewModel extends ViewModel {
    public final CompositeDisposable c = new CompositeDisposable();
    public final MutableLiveData<ViewState> d;
    public final MutableLiveData<String> e;
    @NotNull
    public final LiveData<ViewState> f;
    @NotNull
    public final LiveData<String> g;
    public final SchedulersFactory h;
    public final PaymentHistoryDetailsInteractor i;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/avito/android/payment/wallet/history/details/PaymentHistoryDetailsViewModel$ViewState;", "", "<init>", "()V", "Content", "Error", "Loading", "Lcom/avito/android/payment/wallet/history/details/PaymentHistoryDetailsViewModel$ViewState$Content;", "Lcom/avito/android/payment/wallet/history/details/PaymentHistoryDetailsViewModel$ViewState$Loading;", "Lcom/avito/android/payment/wallet/history/details/PaymentHistoryDetailsViewModel$ViewState$Error;", "payment_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class ViewState {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004¨\u0006\u0018"}, d2 = {"Lcom/avito/android/payment/wallet/history/details/PaymentHistoryDetailsViewModel$ViewState$Content;", "Lcom/avito/android/payment/wallet/history/details/PaymentHistoryDetailsViewModel$ViewState;", "Lcom/avito/android/remote/model/payment/history/PaymentDetails;", "component1", "()Lcom/avito/android/remote/model/payment/history/PaymentDetails;", "paymentDetails", "copy", "(Lcom/avito/android/remote/model/payment/history/PaymentDetails;)Lcom/avito/android/payment/wallet/history/details/PaymentHistoryDetailsViewModel$ViewState$Content;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/model/payment/history/PaymentDetails;", "getPaymentDetails", "<init>", "(Lcom/avito/android/remote/model/payment/history/PaymentDetails;)V", "payment_release"}, k = 1, mv = {1, 4, 2})
        public static final class Content extends ViewState {
            @NotNull
            public final PaymentDetails a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Content(@NotNull PaymentDetails paymentDetails) {
                super(null);
                Intrinsics.checkNotNullParameter(paymentDetails, "paymentDetails");
                this.a = paymentDetails;
            }

            public static /* synthetic */ Content copy$default(Content content, PaymentDetails paymentDetails, int i, Object obj) {
                if ((i & 1) != 0) {
                    paymentDetails = content.a;
                }
                return content.copy(paymentDetails);
            }

            @NotNull
            public final PaymentDetails component1() {
                return this.a;
            }

            @NotNull
            public final Content copy(@NotNull PaymentDetails paymentDetails) {
                Intrinsics.checkNotNullParameter(paymentDetails, "paymentDetails");
                return new Content(paymentDetails);
            }

            public boolean equals(@Nullable Object obj) {
                if (this != obj) {
                    return (obj instanceof Content) && Intrinsics.areEqual(this.a, ((Content) obj).a);
                }
                return true;
            }

            @NotNull
            public final PaymentDetails getPaymentDetails() {
                return this.a;
            }

            public int hashCode() {
                PaymentDetails paymentDetails = this.a;
                if (paymentDetails != null) {
                    return paymentDetails.hashCode();
                }
                return 0;
            }

            @NotNull
            public String toString() {
                StringBuilder L = a2.b.a.a.a.L("Content(paymentDetails=");
                L.append(this.a);
                L.append(")");
                return L.toString();
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004¨\u0006\u0018"}, d2 = {"Lcom/avito/android/payment/wallet/history/details/PaymentHistoryDetailsViewModel$ViewState$Error;", "Lcom/avito/android/payment/wallet/history/details/PaymentHistoryDetailsViewModel$ViewState;", "Lcom/avito/android/remote/error/ErrorResult;", "component1", "()Lcom/avito/android/remote/error/ErrorResult;", "errorResult", "copy", "(Lcom/avito/android/remote/error/ErrorResult;)Lcom/avito/android/payment/wallet/history/details/PaymentHistoryDetailsViewModel$ViewState$Error;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/error/ErrorResult;", "getErrorResult", "<init>", "(Lcom/avito/android/remote/error/ErrorResult;)V", "payment_release"}, k = 1, mv = {1, 4, 2})
        public static final class Error extends ViewState {
            @NotNull
            public final ErrorResult a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Error(@NotNull ErrorResult errorResult) {
                super(null);
                Intrinsics.checkNotNullParameter(errorResult, "errorResult");
                this.a = errorResult;
            }

            public static /* synthetic */ Error copy$default(Error error, ErrorResult errorResult, int i, Object obj) {
                if ((i & 1) != 0) {
                    errorResult = error.a;
                }
                return error.copy(errorResult);
            }

            @NotNull
            public final ErrorResult component1() {
                return this.a;
            }

            @NotNull
            public final Error copy(@NotNull ErrorResult errorResult) {
                Intrinsics.checkNotNullParameter(errorResult, "errorResult");
                return new Error(errorResult);
            }

            public boolean equals(@Nullable Object obj) {
                if (this != obj) {
                    return (obj instanceof Error) && Intrinsics.areEqual(this.a, ((Error) obj).a);
                }
                return true;
            }

            @NotNull
            public final ErrorResult getErrorResult() {
                return this.a;
            }

            public int hashCode() {
                ErrorResult errorResult = this.a;
                if (errorResult != null) {
                    return errorResult.hashCode();
                }
                return 0;
            }

            @NotNull
            public String toString() {
                StringBuilder L = a2.b.a.a.a.L("Error(errorResult=");
                L.append(this.a);
                L.append(")");
                return L.toString();
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/payment/wallet/history/details/PaymentHistoryDetailsViewModel$ViewState$Loading;", "Lcom/avito/android/payment/wallet/history/details/PaymentHistoryDetailsViewModel$ViewState;", "<init>", "()V", "payment_release"}, k = 1, mv = {1, 4, 2})
        public static final class Loading extends ViewState {
            @NotNull
            public static final Loading INSTANCE = new Loading();

            public Loading() {
                super(null);
            }
        }

        public ViewState() {
        }

        public ViewState(j jVar) {
        }
    }

    public static final class a<T> implements Consumer<Disposable> {
        public final /* synthetic */ PaymentHistoryDetailsViewModel a;

        public a(PaymentHistoryDetailsViewModel paymentHistoryDetailsViewModel) {
            this.a = paymentHistoryDetailsViewModel;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r2v3, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public void accept(Disposable disposable) {
            this.a.d.setValue(ViewState.Loading.INSTANCE);
        }
    }

    public static final class b<T> implements Consumer<TypedResult<PaymentDetails.OperationDetails>> {
        public final /* synthetic */ PaymentHistoryDetailsViewModel a;

        public b(PaymentHistoryDetailsViewModel paymentHistoryDetailsViewModel) {
            this.a = paymentHistoryDetailsViewModel;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX DEBUG: Multi-variable search result rejected for r0v6, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX DEBUG: Multi-variable search result rejected for r0v8, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public void accept(TypedResult<PaymentDetails.OperationDetails> typedResult) {
            TypedResult<PaymentDetails.OperationDetails> typedResult2 = typedResult;
            Intrinsics.checkNotNullParameter(typedResult2, "typedResult");
            if (typedResult2 instanceof TypedResult.OfResult) {
                TypedResult.OfResult ofResult = (TypedResult.OfResult) typedResult2;
                this.a.d.setValue(new ViewState.Content((PaymentDetails) ofResult.getResult()));
                this.a.e.setValue(((PaymentDetails.OperationDetails) ofResult.getResult()).getOperationId());
            } else if (typedResult2 instanceof TypedResult.OfError) {
                this.a.d.setValue(new ViewState.Error(((TypedResult.OfError) typedResult2).getError()));
            }
        }
    }

    public static final class c<T> implements Consumer<Disposable> {
        public final /* synthetic */ PaymentHistoryDetailsViewModel a;

        public c(PaymentHistoryDetailsViewModel paymentHistoryDetailsViewModel) {
            this.a = paymentHistoryDetailsViewModel;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r2v3, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public void accept(Disposable disposable) {
            this.a.d.setValue(ViewState.Loading.INSTANCE);
        }
    }

    public static final class d<T> implements Consumer<TypedResult<PaymentDetails.OrderDetails>> {
        public final /* synthetic */ PaymentHistoryDetailsViewModel a;

        public d(PaymentHistoryDetailsViewModel paymentHistoryDetailsViewModel) {
            this.a = paymentHistoryDetailsViewModel;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX DEBUG: Multi-variable search result rejected for r0v6, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX DEBUG: Multi-variable search result rejected for r0v8, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public void accept(TypedResult<PaymentDetails.OrderDetails> typedResult) {
            TypedResult<PaymentDetails.OrderDetails> typedResult2 = typedResult;
            Intrinsics.checkNotNullParameter(typedResult2, "typedResult");
            if (typedResult2 instanceof TypedResult.OfResult) {
                TypedResult.OfResult ofResult = (TypedResult.OfResult) typedResult2;
                this.a.d.setValue(new ViewState.Content((PaymentDetails) ofResult.getResult()));
                this.a.e.setValue(((PaymentDetails.OrderDetails) ofResult.getResult()).getOrderId());
            } else if (typedResult2 instanceof TypedResult.OfError) {
                this.a.d.setValue(new ViewState.Error(((TypedResult.OfError) typedResult2).getError()));
            }
        }
    }

    public PaymentHistoryDetailsViewModel(@NotNull SchedulersFactory schedulersFactory, @NotNull PaymentHistoryDetailsInteractor paymentHistoryDetailsInteractor) {
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        Intrinsics.checkNotNullParameter(paymentHistoryDetailsInteractor, "paymentHistoryDetailsInteractor");
        this.h = schedulersFactory;
        this.i = paymentHistoryDetailsInteractor;
        MutableLiveData<ViewState> mutableLiveData = new MutableLiveData<>();
        this.d = mutableLiveData;
        MutableLiveData<String> mutableLiveData2 = new MutableLiveData<>();
        mutableLiveData2.setValue("");
        Unit unit = Unit.INSTANCE;
        this.e = mutableLiveData2;
        this.f = mutableLiveData;
        this.g = mutableLiveData2;
    }

    public final void getOperationDetails(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "operationId");
        CompositeDisposable compositeDisposable = this.c;
        Disposable subscribe = this.i.getOperationDetails(str).subscribeOn(this.h.io()).observeOn(this.h.mainThread()).doOnSubscribe(new a(this)).subscribe(new b(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "paymentHistoryDetailsInt…          }\n            }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public final void getOrderDetails(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, AnalyticFieldsName.orderId);
        CompositeDisposable compositeDisposable = this.c;
        Disposable subscribe = this.i.getOrderDetails(str).subscribeOn(this.h.io()).observeOn(this.h.mainThread()).doOnSubscribe(new c(this)).subscribe(new d(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "paymentHistoryDetailsInt…          }\n            }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    @NotNull
    public final LiveData<String> getTitle() {
        return this.g;
    }

    @NotNull
    public final LiveData<ViewState> getViewState() {
        return this.f;
    }
}
