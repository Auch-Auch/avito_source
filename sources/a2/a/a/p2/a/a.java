package a2.a.a.p2.a;

import com.avito.android.remote.model.SuccessResult;
import com.avito.android.service_subscription.subscription_new.ServiceSubscriptionPresenterImpl;
import com.avito.android.util.LoadingState;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class a extends Lambda implements Function1<LoadingState<? super SuccessResult>, Unit> {
    public final /* synthetic */ ServiceSubscriptionPresenterImpl a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(ServiceSubscriptionPresenterImpl serviceSubscriptionPresenterImpl) {
        super(1);
        this.a = serviceSubscriptionPresenterImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(LoadingState<? super SuccessResult> loadingState) {
        LoadingState<? super SuccessResult> loadingState2 = loadingState;
        if (loadingState2 instanceof LoadingState.Loaded) {
            ServiceSubscriptionPresenterImpl.access$onOrderCallbackSuccess(this.a, (LoadingState.Loaded) loadingState2);
        } else if (loadingState2 instanceof LoadingState.Error) {
            ServiceSubscriptionPresenterImpl.access$onOrderCallbackError(this.a, (LoadingState.Error) loadingState2);
        }
        return Unit.INSTANCE;
    }
}
