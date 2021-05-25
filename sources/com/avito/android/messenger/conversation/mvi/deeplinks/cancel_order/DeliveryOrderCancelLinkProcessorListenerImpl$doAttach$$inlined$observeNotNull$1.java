package com.avito.android.messenger.conversation.mvi.deeplinks.cancel_order;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.avito.android.util.DialogRouterImpl;
import com.avito.android.util.FragmentsKt;
import com.avito.android.util.Logs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.ok.android.sdk.OkListener;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"T", "kotlin.jvm.PlatformType", "it", "", "onChanged", "(Ljava/lang/Object;)V", "com/avito/android/util/architecture_components/LiveDatasKt$observeNotNull$$inlined$observe$2", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class DeliveryOrderCancelLinkProcessorListenerImpl$doAttach$$inlined$observeNotNull$1<T> implements Observer<T> {
    public final /* synthetic */ DeliveryOrderCancelLinkProcessorListenerImpl a;
    public final /* synthetic */ LifecycleOwner b;
    public final /* synthetic */ DialogRouterImpl c;

    public static final class a extends Lambda implements Function1<Exception, Unit> {
        public final /* synthetic */ DeliveryOrderCancelLinkProcessorListenerImpl$doAttach$$inlined$observeNotNull$1 a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(DeliveryOrderCancelLinkProcessorListenerImpl$doAttach$$inlined$observeNotNull$1 deliveryOrderCancelLinkProcessorListenerImpl$doAttach$$inlined$observeNotNull$1) {
            super(1);
            this.a = deliveryOrderCancelLinkProcessorListenerImpl$doAttach$$inlined$observeNotNull$1;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Exception exc) {
            Exception exc2 = exc;
            Intrinsics.checkNotNullParameter(exc2, OkListener.KEY_EXCEPTION);
            DeliveryOrderCancelLinkProcessorListenerImpl$doAttach$$inlined$observeNotNull$1 deliveryOrderCancelLinkProcessorListenerImpl$doAttach$$inlined$observeNotNull$1 = this.a;
            deliveryOrderCancelLinkProcessorListenerImpl$doAttach$$inlined$observeNotNull$1.a.c(deliveryOrderCancelLinkProcessorListenerImpl$doAttach$$inlined$observeNotNull$1.c);
            Logs.error(DeliveryOrderCancelLinkProcessorListenerImpl.TAG, "", exc2);
            return Unit.INSTANCE;
        }
    }

    public DeliveryOrderCancelLinkProcessorListenerImpl$doAttach$$inlined$observeNotNull$1(DeliveryOrderCancelLinkProcessorListenerImpl deliveryOrderCancelLinkProcessorListenerImpl, LifecycleOwner lifecycleOwner, DialogRouterImpl dialogRouterImpl) {
        this.a = deliveryOrderCancelLinkProcessorListenerImpl;
        this.b = lifecycleOwner;
        this.c = dialogRouterImpl;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(T t) {
        if (t != null) {
            T t2 = t;
            LifecycleOwner lifecycleOwner = this.b;
            if (!(lifecycleOwner instanceof Fragment)) {
                lifecycleOwner = null;
            }
            Fragment fragment = (Fragment) lifecycleOwner;
            if (fragment != null) {
                FragmentsKt.startActivityForResultSafely(fragment, t2, 7, new a(this));
            } else {
                this.a.c(this.c);
            }
        }
    }
}
