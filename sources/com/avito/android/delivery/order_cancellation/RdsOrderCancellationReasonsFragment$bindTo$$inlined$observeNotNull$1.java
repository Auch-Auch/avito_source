package com.avito.android.delivery.order_cancellation;

import androidx.lifecycle.Observer;
import com.avito.android.remote.error.ErrorWithMessage;
import com.avito.android.remote.error.TypedError;
import com.avito.android.util.LoadingState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"T", "kotlin.jvm.PlatformType", "it", "", "onChanged", "(Ljava/lang/Object;)V", "com/avito/android/util/architecture_components/LiveDatasKt$observeNotNull$$inlined$observe$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class RdsOrderCancellationReasonsFragment$bindTo$$inlined$observeNotNull$1<T> implements Observer<T> {
    public final /* synthetic */ RdsOrderCancellationReasonsFragment a;
    public final /* synthetic */ RdsOrderCancellationReasonsViewModel b;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ RdsOrderCancellationReasonsFragment$bindTo$$inlined$observeNotNull$1 a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(RdsOrderCancellationReasonsFragment$bindTo$$inlined$observeNotNull$1 rdsOrderCancellationReasonsFragment$bindTo$$inlined$observeNotNull$1) {
            super(0);
            this.a = rdsOrderCancellationReasonsFragment$bindTo$$inlined$observeNotNull$1;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.b.requestReasons(false);
            return Unit.INSTANCE;
        }
    }

    public RdsOrderCancellationReasonsFragment$bindTo$$inlined$observeNotNull$1(RdsOrderCancellationReasonsFragment rdsOrderCancellationReasonsFragment, RdsOrderCancellationReasonsViewModel rdsOrderCancellationReasonsViewModel) {
        this.a = rdsOrderCancellationReasonsFragment;
        this.b = rdsOrderCancellationReasonsViewModel;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(T t) {
        if (t != null) {
            T t2 = t;
            if (t2 instanceof LoadingState.Loading) {
                RdsOrderCancellationReasonsFragment.access$getProgressOverlay$p(this.a).showLoading();
            } else if (t2 instanceof LoadingState.Loaded) {
                RdsOrderCancellationReasonsFragment.access$getProgressOverlay$p(this.a).showContent();
            } else if (t2 instanceof LoadingState.Error) {
                TypedError error = t2.getError();
                RdsOrderCancellationReasonsFragment.access$getProgressOverlay$p(this.a).showLoadingProblem(error instanceof ErrorWithMessage ? ((ErrorWithMessage) error).getMessage() : this.a.getResourceProvider().getErrorOccurred());
                RdsOrderCancellationReasonsFragment.access$getProgressOverlay$p(this.a).setOnRefreshListener(new a(this));
            }
        }
    }
}
