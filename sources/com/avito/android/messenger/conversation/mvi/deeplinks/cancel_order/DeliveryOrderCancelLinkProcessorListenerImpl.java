package com.avito.android.messenger.conversation.mvi.deeplinks.cancel_order;

import a2.a.a.o1.d.a0.c.a.b;
import a2.a.a.o1.d.a0.c.a.c;
import a2.a.a.o1.d.a0.c.a.d;
import a2.a.a.o1.d.a0.c.a.e;
import a2.a.a.o1.d.a0.c.a.f;
import a2.g.r.g;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.avito.android.messenger.R;
import com.avito.android.messenger.conversation.mvi.deeplinks.AbstractDeeplinkProcessorListener;
import com.avito.android.messenger.conversation.mvi.deeplinks.ActivityResult;
import com.avito.android.messenger.conversation.mvi.deeplinks.DeepLinkProcessingListener;
import com.avito.android.remote.DeliveryApi;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.util.DialogRouter;
import com.avito.android.util.DialogRouterImpl;
import com.avito.android.util.LoadingState;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.rx3.InteropKt;
import dagger.Lazy;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 12\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00011B5\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\u0006\u0010*\u001a\u00020'\u0012\u0006\u0010&\u001a\u00020#\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u0012\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e¢\u0006\u0004\b/\u00100JI\u0010\u000e\u001a\u00020\r\"\b\b\u0000\u0010\u0004*\u00020\u0003\"\b\b\u0001\u0010\u0006*\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00028\u00002\u0006\u0010\t\u001a\u00028\u00012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\rH\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001c\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-¨\u00062"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/deeplinks/cancel_order/DeliveryOrderCancelLinkProcessorListenerImpl;", "Lcom/avito/android/messenger/conversation/mvi/deeplinks/AbstractDeeplinkProcessorListener;", "Lcom/avito/android/messenger/conversation/mvi/deeplinks/cancel_order/DeliveryOrderCancelLinkProcessor;", "Landroid/content/Context;", "C", "Landroidx/lifecycle/LifecycleOwner;", "F", "processor", "context", "lifecycleOwner", "Landroidx/lifecycle/LiveData;", "Lcom/avito/android/messenger/conversation/mvi/deeplinks/ActivityResult;", "activityResultStream", "", "doAttach", "(Lcom/avito/android/messenger/conversation/mvi/deeplinks/cancel_order/DeliveryOrderCancelLinkProcessor;Landroid/content/Context;Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/LiveData;)V", "onCleared", "()V", "Lcom/avito/android/util/DialogRouter;", "dialogRouter", "c", "(Lcom/avito/android/util/DialogRouter;)V", "Landroid/content/res/Resources;", "h", "Landroid/content/res/Resources;", "resources", "Lcom/avito/android/remote/DeliveryApi;", "e", "Lcom/avito/android/remote/DeliveryApi;", "deliveryApi", "Ldagger/Lazy;", "Lcom/avito/android/messenger/conversation/mvi/deeplinks/DeepLinkProcessingListener;", "i", "Ldagger/Lazy;", "processingListener", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", g.a, "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "throwableConverter", "Lcom/avito/android/util/SchedulersFactory;", "f", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lio/reactivex/disposables/CompositeDisposable;", "d", "Lio/reactivex/disposables/CompositeDisposable;", "subscriptions", "<init>", "(Lcom/avito/android/remote/DeliveryApi;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/remote/error/TypedErrorThrowableConverter;Landroid/content/res/Resources;Ldagger/Lazy;)V", "Companion", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class DeliveryOrderCancelLinkProcessorListenerImpl extends AbstractDeeplinkProcessorListener<DeliveryOrderCancelLinkProcessor> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int DELIVERY_CANCEL_ORDER_CODE = 7;
    @NotNull
    public static final String TAG = "DeliveryOrderCancelLinkProcessorListener";
    public final CompositeDisposable d = new CompositeDisposable();
    public final DeliveryApi e;
    public final SchedulersFactory f;
    public final TypedErrorThrowableConverter g;
    public final Resources h;
    public final Lazy<DeepLinkProcessingListener> i;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/deeplinks/cancel_order/DeliveryOrderCancelLinkProcessorListenerImpl$Companion;", "", "", "DELIVERY_CANCEL_ORDER_CODE", "I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Ref.ObjectRef a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Ref.ObjectRef objectRef) {
            super(0);
            this.a = objectRef;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            T t = this.a.element;
            if (t != null) {
                t.dismiss();
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeliveryOrderCancelLinkProcessorListenerImpl(@NotNull DeliveryApi deliveryApi, @NotNull SchedulersFactory schedulersFactory, @NotNull TypedErrorThrowableConverter typedErrorThrowableConverter, @NotNull Resources resources, @NotNull Lazy<DeepLinkProcessingListener> lazy) {
        super(DeliveryOrderCancelLinkProcessor.class);
        Intrinsics.checkNotNullParameter(deliveryApi, "deliveryApi");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(typedErrorThrowableConverter, "throwableConverter");
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(lazy, "processingListener");
        this.e = deliveryApi;
        this.f = schedulersFactory;
        this.g = typedErrorThrowableConverter;
        this.h = resources;
        this.i = lazy;
    }

    public static final void access$cancelDeliveryOrder(DeliveryOrderCancelLinkProcessorListenerImpl deliveryOrderCancelLinkProcessorListenerImpl, String str, DialogRouter dialogRouter, Dialog dialog) {
        CompositeDisposable compositeDisposable = deliveryOrderCancelLinkProcessorListenerImpl.d;
        Disposable subscribe = InteropKt.toV2(deliveryOrderCancelLinkProcessorListenerImpl.e.cancelDeliveryOrder(str)).subscribeOn(deliveryOrderCancelLinkProcessorListenerImpl.f.io()).map(a2.a.a.o1.d.a0.c.a.a.a).onErrorReturn(new b(deliveryOrderCancelLinkProcessorListenerImpl)).startWith((Observable) LoadingState.Loading.INSTANCE).observeOn(deliveryOrderCancelLinkProcessorListenerImpl.f.mainThread()).subscribe(new c(deliveryOrderCancelLinkProcessorListenerImpl, dialog, dialogRouter), new d(deliveryOrderCancelLinkProcessorListenerImpl, dialogRouter));
        Intrinsics.checkNotNullExpressionValue(subscribe, "deliveryApi.cancelDelive…          }\n            )");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public static final void access$onOrderCancelError(DeliveryOrderCancelLinkProcessorListenerImpl deliveryOrderCancelLinkProcessorListenerImpl, DialogRouter dialogRouter) {
        deliveryOrderCancelLinkProcessorListenerImpl.i.get().onEndDeepLinkProcessing();
        deliveryOrderCancelLinkProcessorListenerImpl.c(dialogRouter);
    }

    public static final void access$onOrderCancelled(DeliveryOrderCancelLinkProcessorListenerImpl deliveryOrderCancelLinkProcessorListenerImpl, Dialog dialog) {
        deliveryOrderCancelLinkProcessorListenerImpl.i.get().onEndDeepLinkProcessing();
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    public static final void access$onOrderCancelling(DeliveryOrderCancelLinkProcessorListenerImpl deliveryOrderCancelLinkProcessorListenerImpl) {
        deliveryOrderCancelLinkProcessorListenerImpl.i.get().onStartDeepLinkProcessing();
    }

    public static final Dialog access$showOrderCancelConfirmationDialog(DeliveryOrderCancelLinkProcessorListenerImpl deliveryOrderCancelLinkProcessorListenerImpl, DialogRouter dialogRouter, String str) {
        Objects.requireNonNull(deliveryOrderCancelLinkProcessorListenerImpl);
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = null;
        String string = deliveryOrderCancelLinkProcessorListenerImpl.h.getString(R.string.dialog_cancel_delivery_order_message);
        e eVar = new e(deliveryOrderCancelLinkProcessorListenerImpl, str, dialogRouter, objectRef);
        f fVar = new f(objectRef);
        String string2 = deliveryOrderCancelLinkProcessorListenerImpl.h.getString(com.avito.android.ui_components.R.string.yes);
        Intrinsics.checkNotNullExpressionValue(string2, "resources.getString(ui_R.string.yes)");
        String string3 = deliveryOrderCancelLinkProcessorListenerImpl.h.getString(com.avito.android.ui_components.R.string.no);
        Intrinsics.checkNotNullExpressionValue(string3, "resources.getString(ui_R.string.no)");
        T t = (T) DialogRouter.DefaultImpls.showCancelableNotifyingDialog$default(dialogRouter, null, false, string, string3, fVar, string2, eVar, 3, null);
        objectRef.element = t;
        return t;
    }

    public final void c(DialogRouter dialogRouter) {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = null;
        String string = this.h.getString(com.avito.android.ui_components.R.string.unknown_error);
        String string2 = this.h.getString(com.avito.android.ui_components.R.string.ok);
        Intrinsics.checkNotNullExpressionValue(string2, "resources.getString(ui_R.string.ok)");
        objectRef.element = (T) DialogRouter.DefaultImpls.showNotifyingDialog$default(dialogRouter, null, true, string, string2, new a(objectRef), null, null, 97, null);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.avito.android.messenger.conversation.mvi.deeplinks.DeeplinkProcessor, android.content.Context, androidx.lifecycle.LifecycleOwner, androidx.lifecycle.LiveData] */
    @Override // com.avito.android.messenger.conversation.mvi.deeplinks.AbstractDeeplinkProcessorListener
    public /* bridge */ /* synthetic */ void doAttach(DeliveryOrderCancelLinkProcessor deliveryOrderCancelLinkProcessor, Context context, LifecycleOwner lifecycleOwner, LiveData liveData) {
        doAttach(deliveryOrderCancelLinkProcessor, (DeliveryOrderCancelLinkProcessor) context, (Context) lifecycleOwner, (LiveData<ActivityResult>) liveData);
    }

    @Override // com.avito.android.messenger.conversation.mvi.deeplinks.AbstractDeeplinkProcessorListener, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        this.d.clear();
    }

    public <C extends Context, F extends LifecycleOwner> void doAttach(@NotNull DeliveryOrderCancelLinkProcessor deliveryOrderCancelLinkProcessor, @NotNull C c, @NotNull F f2, @NotNull LiveData<ActivityResult> liveData) {
        Intrinsics.checkNotNullParameter(deliveryOrderCancelLinkProcessor, "processor");
        Intrinsics.checkNotNullParameter(c, "context");
        Intrinsics.checkNotNullParameter(f2, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(liveData, "activityResultStream");
        DialogRouterImpl dialogRouterImpl = new DialogRouterImpl((Activity) c);
        deliveryOrderCancelLinkProcessor.getOpenScreenIntentStream().observe(f2, new DeliveryOrderCancelLinkProcessorListenerImpl$doAttach$$inlined$observeNotNull$1(this, f2, dialogRouterImpl));
        liveData.observe(f2, new Observer<T>(this, dialogRouterImpl) { // from class: com.avito.android.messenger.conversation.mvi.deeplinks.cancel_order.DeliveryOrderCancelLinkProcessorListenerImpl$doAttach$$inlined$observeNotNull$2
            public final /* synthetic */ DeliveryOrderCancelLinkProcessorListenerImpl a;
            public final /* synthetic */ DialogRouterImpl b;

            {
                this.a = r1;
                this.b = r2;
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(T t) {
                String stringExtra;
                if (t != null) {
                    T t2 = t;
                    if (t2.getRequestCode() == 7) {
                        if (t2.getResultCode() == 0) {
                            Intent data = t2.getData();
                            if (data == null || (stringExtra = data.getStringExtra("EXTRA_ORDER_ID")) == null || DeliveryOrderCancelLinkProcessorListenerImpl.access$showOrderCancelConfirmationDialog(this.a, this.b, stringExtra) == null) {
                                this.a.c(this.b);
                                Unit unit = Unit.INSTANCE;
                            }
                        } else if (t2.getResultCode() != -1) {
                            this.a.c(this.b);
                        }
                    }
                }
            }
        });
    }
}
