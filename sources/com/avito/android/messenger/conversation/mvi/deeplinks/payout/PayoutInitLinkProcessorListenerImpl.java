package com.avito.android.messenger.conversation.mvi.deeplinks.payout;

import a2.a.a.o1.d.a0.c.b.a;
import a2.a.a.o1.d.a0.c.b.b;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.messenger.R;
import com.avito.android.messenger.conversation.mvi.deeplinks.AbstractDeeplinkProcessorListener;
import com.avito.android.messenger.conversation.mvi.deeplinks.ActivityResult;
import com.avito.android.payment.processing.PaymentProcessingConstants;
import com.avito.android.util.DialogRouter;
import com.avito.android.util.DialogRouterImpl;
import com.avito.android.util.IntentsKt;
import com.avito.android.util.Logs;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001aB\u0017\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u0010\u0013\u001a\u00020\u0010¢\u0006\u0004\b\u0018\u0010\u0019JI\u0010\u000e\u001a\u00020\r\"\b\b\u0000\u0010\u0004*\u00020\u0003\"\b\b\u0001\u0010\u0006*\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00028\u00002\u0006\u0010\t\u001a\u00028\u00012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0014¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u001b"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/deeplinks/payout/PayoutInitLinkProcessorListenerImpl;", "Lcom/avito/android/messenger/conversation/mvi/deeplinks/AbstractDeeplinkProcessorListener;", "Lcom/avito/android/messenger/conversation/mvi/deeplinks/payout/PayoutInitLinkProcessor;", "Landroid/content/Context;", "C", "Landroidx/lifecycle/LifecycleOwner;", "F", "processor", "context", "lifecycleOwner", "Landroidx/lifecycle/LiveData;", "Lcom/avito/android/messenger/conversation/mvi/deeplinks/ActivityResult;", "activityResultStream", "", "doAttach", "(Lcom/avito/android/messenger/conversation/mvi/deeplinks/payout/PayoutInitLinkProcessor;Landroid/content/Context;Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/LiveData;)V", "", "e", "I", "requestCode", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "d", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "<init>", "(Lcom/avito/android/deep_linking/DeepLinkIntentFactory;I)V", "Companion", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class PayoutInitLinkProcessorListenerImpl extends AbstractDeeplinkProcessorListener<PayoutInitLinkProcessor> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String TAG = "PayoutInitLinkProcessorListenerImpl";
    public final DeepLinkIntentFactory d;
    public final int e;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/deeplinks/payout/PayoutInitLinkProcessorListenerImpl$Companion;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PayoutInitLinkProcessorListenerImpl(@NotNull DeepLinkIntentFactory deepLinkIntentFactory, int i) {
        super(PayoutInitLinkProcessor.class);
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory, "deepLinkIntentFactory");
        this.d = deepLinkIntentFactory;
        this.e = i;
    }

    public static final void access$showPayoutError(PayoutInitLinkProcessorListenerImpl payoutInitLinkProcessorListenerImpl, DialogRouter dialogRouter, Resources resources) {
        Objects.requireNonNull(payoutInitLinkProcessorListenerImpl);
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = null;
        String string = resources.getString(R.string.delivery_seller_pay_out_error_title);
        String string2 = resources.getString(com.avito.android.ui_components.R.string.ok);
        Intrinsics.checkNotNullExpressionValue(string2, "resources.getString(ui_R.string.ok)");
        objectRef.element = (T) DialogRouter.DefaultImpls.showNotifyingDialog$default(dialogRouter, null, true, string, string2, new a(objectRef), null, null, 97, null);
    }

    public static final void access$showUnExpectedError(PayoutInitLinkProcessorListenerImpl payoutInitLinkProcessorListenerImpl, DialogRouter dialogRouter, Resources resources) {
        Objects.requireNonNull(payoutInitLinkProcessorListenerImpl);
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = null;
        String string = resources.getString(com.avito.android.ui_components.R.string.unknown_error);
        String string2 = resources.getString(com.avito.android.ui_components.R.string.ok);
        Intrinsics.checkNotNullExpressionValue(string2, "resources.getString(ui_R.string.ok)");
        objectRef.element = (T) DialogRouter.DefaultImpls.showNotifyingDialog$default(dialogRouter, null, true, string, string2, new b(objectRef), null, null, 97, null);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.avito.android.messenger.conversation.mvi.deeplinks.DeeplinkProcessor, android.content.Context, androidx.lifecycle.LifecycleOwner, androidx.lifecycle.LiveData] */
    @Override // com.avito.android.messenger.conversation.mvi.deeplinks.AbstractDeeplinkProcessorListener
    public /* bridge */ /* synthetic */ void doAttach(PayoutInitLinkProcessor payoutInitLinkProcessor, Context context, LifecycleOwner lifecycleOwner, LiveData liveData) {
        doAttach(payoutInitLinkProcessor, (PayoutInitLinkProcessor) context, (Context) lifecycleOwner, (LiveData<ActivityResult>) liveData);
    }

    public <C extends Context, F extends LifecycleOwner> void doAttach(@NotNull PayoutInitLinkProcessor payoutInitLinkProcessor, @NotNull C c, @NotNull F f, @NotNull LiveData<ActivityResult> liveData) {
        Intrinsics.checkNotNullParameter(payoutInitLinkProcessor, "processor");
        Intrinsics.checkNotNullParameter(c, "context");
        Intrinsics.checkNotNullParameter(f, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(liveData, "activityResultStream");
        DialogRouterImpl dialogRouterImpl = new DialogRouterImpl((Activity) c);
        payoutInitLinkProcessor.getOpenScreenIntentStream().observe(f, new PayoutInitLinkProcessorListenerImpl$doAttach$$inlined$observeNotNull$1(this, f, dialogRouterImpl, c));
        payoutInitLinkProcessor.getErrorStream().observe(f, new Observer<T>(this, dialogRouterImpl, c) { // from class: com.avito.android.messenger.conversation.mvi.deeplinks.payout.PayoutInitLinkProcessorListenerImpl$doAttach$$inlined$observeNotNull$2
            public final /* synthetic */ PayoutInitLinkProcessorListenerImpl a;
            public final /* synthetic */ DialogRouterImpl b;
            public final /* synthetic */ Context c;

            {
                this.a = r1;
                this.b = r2;
                this.c = r3;
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(T t) {
                if (t != null) {
                    PayoutInitLinkProcessorListenerImpl payoutInitLinkProcessorListenerImpl = this.a;
                    DialogRouterImpl dialogRouterImpl2 = this.b;
                    Resources resources = ((Activity) this.c).getResources();
                    Intrinsics.checkNotNullExpressionValue(resources, "context.resources");
                    PayoutInitLinkProcessorListenerImpl.access$showPayoutError(payoutInitLinkProcessorListenerImpl, dialogRouterImpl2, resources);
                }
            }
        });
        liveData.observe(f, new Observer<T>(this, c, dialogRouterImpl) { // from class: com.avito.android.messenger.conversation.mvi.deeplinks.payout.PayoutInitLinkProcessorListenerImpl$doAttach$$inlined$observeNotNull$3
            public final /* synthetic */ PayoutInitLinkProcessorListenerImpl a;
            public final /* synthetic */ Context b;
            public final /* synthetic */ DialogRouterImpl c;

            {
                this.a = r1;
                this.b = r2;
                this.c = r3;
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(T t) {
                Intent intent;
                if (t != null) {
                    T t2 = t;
                    if (t2.getResultCode() == -1 && t2.getRequestCode() == PayoutInitLinkProcessorListenerImpl.access$getRequestCode$p(this.a)) {
                        Intent data = t2.getData();
                        DeepLink deepLink = data != null ? (DeepLink) data.getParcelableExtra(PaymentProcessingConstants.EXTRA_FINAL_DEEPLINK) : null;
                        if (deepLink != null && (intent = PayoutInitLinkProcessorListenerImpl.access$getDeepLinkIntentFactory$p(this.a).getIntent(deepLink)) != null) {
                            try {
                                this.b.startActivity(IntentsKt.makeSafeForExternalApps(intent));
                            } catch (Exception e2) {
                                PayoutInitLinkProcessorListenerImpl payoutInitLinkProcessorListenerImpl = this.a;
                                DialogRouterImpl dialogRouterImpl2 = this.c;
                                Resources resources = ((Activity) this.b).getResources();
                                Intrinsics.checkNotNullExpressionValue(resources, "context.resources");
                                PayoutInitLinkProcessorListenerImpl.access$showUnExpectedError(payoutInitLinkProcessorListenerImpl, dialogRouterImpl2, resources);
                                Logs.error(PayoutInitLinkProcessorListenerImpl.TAG, "", e2);
                            }
                        }
                    }
                }
            }
        });
    }
}
