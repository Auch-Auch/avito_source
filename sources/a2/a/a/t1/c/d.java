package a2.a.a.t1.c;

import androidx.lifecycle.MutableLiveData;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.NoMatchLink;
import com.avito.android.payment.lib.PaymentMethodsViewModel;
import com.avito.android.remote.error.ErrorResult;
import com.avito.android.remote.error.ErrorWithMessage;
import com.avito.android.remote.error.TypedError;
import com.avito.android.remote.model.payment.PaymentMethod;
import com.avito.android.remote.model.payment.status.PaymentStatusResult;
import com.avito.android.util.LoadingState;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
public final class d<T> implements Consumer<Pair<? extends LoadingState<? super PaymentStatusResult>, ? extends List<? extends PaymentMethod>>> {
    public final /* synthetic */ PaymentMethodsViewModel a;
    public final /* synthetic */ String b;
    public final /* synthetic */ int c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;

    public d(PaymentMethodsViewModel paymentMethodsViewModel, String str, int i, String str2, String str3) {
        this.a = paymentMethodsViewModel;
        this.b = str;
        this.c = i;
        this.d = str2;
        this.e = str3;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r1v9, resolved type: androidx.lifecycle.MutableLiveData */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.functions.Consumer
    public void accept(Pair<? extends LoadingState<? super PaymentStatusResult>, ? extends List<? extends PaymentMethod>> pair) {
        T t;
        int i;
        Pair<? extends LoadingState<? super PaymentStatusResult>, ? extends List<? extends PaymentMethod>> pair2 = pair;
        LoadingState loadingState = (LoadingState) pair2.component1();
        List list = (List) pair2.component2();
        Intrinsics.checkNotNullExpressionValue(list, "paymentMethods");
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            if (Intrinsics.areEqual(t.getSignature(), this.b)) {
                break;
            }
        }
        boolean z = t instanceof PaymentMethod.GooglePay;
        if (loadingState instanceof LoadingState.Loaded) {
            PaymentStatusResult paymentStatusResult = (PaymentStatusResult) ((LoadingState.Loaded) loadingState).getData();
            if (paymentStatusResult instanceof PaymentStatusResult.PaymentStatus) {
                if (!Intrinsics.areEqual(((PaymentStatusResult.PaymentStatus) paymentStatusResult).getState(), "active") || (i = this.c) >= 3) {
                    DeepLink createFromUri = this.a.M.createFromUri(this.e);
                    if (createFromUri instanceof NoMatchLink) {
                        this.a.getUriLiveData().setValue(this.e);
                    } else {
                        this.a.getDeepLinkLiveData().setValue(createFromUri);
                    }
                    this.a.setLoadingIndicatorOnButton(z, false);
                    return;
                }
                PaymentMethodsViewModel.access$getPaymentStatusPolling(this.a, this.b, i + 1, this.d, this.e);
            } else if (paymentStatusResult instanceof PaymentStatusResult.ForbiddenPayment) {
                DeepLink createFromUri2 = this.a.M.createFromUri(this.e);
                if (createFromUri2 instanceof NoMatchLink) {
                    this.a.getUriLiveData().setValue(this.e);
                } else {
                    this.a.getDeepLinkLiveData().setValue(createFromUri2);
                }
                this.a.setLoadingIndicatorOnButton(z, false);
            }
        } else if (loadingState instanceof LoadingState.Error) {
            LoadingState.Error error = (LoadingState.Error) loadingState;
            if (error.getError() instanceof ErrorWithMessage) {
                MutableLiveData mutableLiveData = this.a.d;
                TypedError error2 = error.getError();
                Objects.requireNonNull(error2, "null cannot be cast to non-null type com.avito.android.remote.error.ErrorResult");
                mutableLiveData.setValue(new PaymentMethodsViewModel.ViewState.Error(((ErrorResult) error2).getMessage()));
                this.a.setLoadingIndicatorOnButton(z, false);
            }
        }
    }
}
