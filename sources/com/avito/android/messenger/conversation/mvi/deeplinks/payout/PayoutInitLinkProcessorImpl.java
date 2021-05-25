package com.avito.android.messenger.conversation.mvi.deeplinks.payout;

import a2.g.r.g;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.deep_linking.links.PayoutLink;
import com.avito.android.messenger.R;
import com.avito.android.messenger.conversation.mvi.deeplinks.DeepLinkProcessingListener;
import com.avito.android.payment.WebPaymentResourceProviderImpl;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.TypedError;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.util.LoadingState;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import dagger.Lazy;
import hu.akarnokd.rxjava2.schedulers.SharedScheduler;
import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.rxkotlin.DisposableKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003BK\u0012\f\u00101\u001a\b\u0012\u0004\u0012\u00028\u00000.\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\u0006\u0010;\u001a\u00020:\u0012\u0006\u0010)\u001a\u00020&\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010 \u001a\u00020\u001d\u0012\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\"0!¢\u0006\u0004\b<\u0010=J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0001H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\"\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001c\u0010%\u001a\b\u0012\u0004\u0012\u00020\"0!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u001c\u00101\u001a\b\u0012\u0004\u0012\u00028\u00000.8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u00104R\"\u00109\u001a\b\u0012\u0004\u0012\u0002060\u00168\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b7\u0010\u0019\u001a\u0004\b8\u0010\u001b¨\u0006>"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/deeplinks/payout/PayoutInitLinkProcessorImpl;", "Lcom/avito/android/deep_linking/links/PayoutLink;", "T", "Lcom/avito/android/messenger/conversation/mvi/deeplinks/payout/PayoutInitLinkProcessor;", "deeplink", "", "doProcess", "(Lcom/avito/android/deep_linking/links/PayoutLink;)Z", "", "onCleared", "()V", "", "toString", "()Ljava/lang/String;", "Lcom/avito/android/ActivityIntentFactory;", "k", "Lcom/avito/android/ActivityIntentFactory;", "activityIntentFactory", "Lcom/avito/android/messenger/conversation/mvi/deeplinks/payout/PayoutInteractor;", "i", "Lcom/avito/android/messenger/conversation/mvi/deeplinks/payout/PayoutInteractor;", "payoutInteractor", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "Landroid/content/Intent;", "d", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "getOpenScreenIntentStream", "()Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "openScreenIntentStream", "Landroid/content/res/Resources;", "l", "Landroid/content/res/Resources;", "resources", "Ldagger/Lazy;", "Lcom/avito/android/messenger/conversation/mvi/deeplinks/DeepLinkProcessingListener;", AuthSource.OPEN_CHANNEL_LIST, "Ldagger/Lazy;", "processingListener", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "j", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "throwableConverter", "Lio/reactivex/disposables/CompositeDisposable;", "f", "Lio/reactivex/disposables/CompositeDisposable;", "subscriptions", "Ljava/lang/Class;", "h", "Ljava/lang/Class;", "deepLinkClass", "Lio/reactivex/Scheduler;", g.a, "Lio/reactivex/Scheduler;", "interactorStateListenerScheduler", "Lcom/avito/android/remote/error/TypedError;", "e", "getErrorStream", "errorStream", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "<init>", "(Ljava/lang/Class;Lcom/avito/android/messenger/conversation/mvi/deeplinks/payout/PayoutInteractor;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/remote/error/TypedErrorThrowableConverter;Lcom/avito/android/ActivityIntentFactory;Landroid/content/res/Resources;Ldagger/Lazy;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class PayoutInitLinkProcessorImpl<T extends PayoutLink> extends PayoutInitLinkProcessor {
    @NotNull
    public final SingleLiveEvent<Intent> d = new SingleLiveEvent<>();
    @NotNull
    public final SingleLiveEvent<TypedError> e = new SingleLiveEvent<>();
    public final CompositeDisposable f;
    public final Scheduler g;
    public final Class<T> h;
    public final PayoutInteractor i;
    public final TypedErrorThrowableConverter j;
    public final ActivityIntentFactory k;
    public final Resources l;
    public final Lazy<DeepLinkProcessingListener> m;

    public static final class a<T> implements Consumer<LoadingState<? super Uri>> {
        public final /* synthetic */ PayoutInitLinkProcessorImpl a;

        public a(PayoutInitLinkProcessorImpl payoutInitLinkProcessorImpl) {
            this.a = payoutInitLinkProcessorImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(LoadingState<? super Uri> loadingState) {
            LoadingState<? super Uri> loadingState2 = loadingState;
            if (loadingState2 instanceof LoadingState.Loaded) {
                PayoutInitLinkProcessorImpl.access$onUrlLoaded(this.a, (Uri) ((LoadingState.Loaded) loadingState2).getData());
            } else if (loadingState2 instanceof LoadingState.Loading) {
                PayoutInitLinkProcessorImpl.access$onUrlLoading(this.a);
            } else if (loadingState2 instanceof LoadingState.Error) {
                PayoutInitLinkProcessorImpl.access$onUrlLoadError(this.a, ((LoadingState.Error) loadingState2).getError());
            }
        }
    }

    public static final class b<T> implements Consumer<Throwable> {
        public final /* synthetic */ PayoutInitLinkProcessorImpl a;

        public b(PayoutInitLinkProcessorImpl payoutInitLinkProcessorImpl) {
            this.a = payoutInitLinkProcessorImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Throwable th2 = th;
            PayoutInitLinkProcessorImpl payoutInitLinkProcessorImpl = this.a;
            TypedErrorThrowableConverter typedErrorThrowableConverter = payoutInitLinkProcessorImpl.j;
            Intrinsics.checkNotNullExpressionValue(th2, "throwable");
            PayoutInitLinkProcessorImpl.access$onUrlLoadError(payoutInitLinkProcessorImpl, typedErrorThrowableConverter.convert(th2));
        }
    }

    public PayoutInitLinkProcessorImpl(@NotNull Class<T> cls, @NotNull PayoutInteractor payoutInteractor, @NotNull SchedulersFactory schedulersFactory, @NotNull TypedErrorThrowableConverter typedErrorThrowableConverter, @NotNull ActivityIntentFactory activityIntentFactory, @NotNull Resources resources, @NotNull Lazy<DeepLinkProcessingListener> lazy) {
        Intrinsics.checkNotNullParameter(cls, "deepLinkClass");
        Intrinsics.checkNotNullParameter(payoutInteractor, "payoutInteractor");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(typedErrorThrowableConverter, "throwableConverter");
        Intrinsics.checkNotNullParameter(activityIntentFactory, "activityIntentFactory");
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(lazy, "processingListener");
        this.h = cls;
        this.i = payoutInteractor;
        this.j = typedErrorThrowableConverter;
        this.k = activityIntentFactory;
        this.l = resources;
        this.m = lazy;
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        this.f = compositeDisposable;
        SharedScheduler sharedScheduler = new SharedScheduler(schedulersFactory.io());
        compositeDisposable.add(Disposables.fromAction(new Action() { // from class: com.avito.android.messenger.conversation.mvi.deeplinks.payout.PayoutInitLinkProcessorImpl$inlined$sam$i$io_reactivex_functions_Action$0
            @Override // io.reactivex.functions.Action
            public final /* synthetic */ void run() {
                Intrinsics.checkNotNullExpressionValue(Function0.this.invoke(), "invoke(...)");
            }
        }));
        this.g = sharedScheduler;
    }

    public static final void access$onUrlLoadError(PayoutInitLinkProcessorImpl payoutInitLinkProcessorImpl, TypedError typedError) {
        payoutInitLinkProcessorImpl.m.get().onEndDeepLinkProcessing();
        payoutInitLinkProcessorImpl.getErrorStream().postValue(typedError);
    }

    public static final void access$onUrlLoaded(PayoutInitLinkProcessorImpl payoutInitLinkProcessorImpl, Uri uri) {
        payoutInitLinkProcessorImpl.m.get().onEndDeepLinkProcessing();
        SingleLiveEvent<Intent> openScreenIntentStream = payoutInitLinkProcessorImpl.getOpenScreenIntentStream();
        ActivityIntentFactory activityIntentFactory = payoutInitLinkProcessorImpl.k;
        String uri2 = uri.toString();
        Intrinsics.checkNotNullExpressionValue(uri2, "url.toString()");
        String string = payoutInitLinkProcessorImpl.l.getString(R.string.delivery_seller_pay_out_cancel_confirmation);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…_out_cancel_confirmation)");
        String string2 = payoutInitLinkProcessorImpl.l.getString(com.avito.android.ui_components.R.string.no);
        Intrinsics.checkNotNullExpressionValue(string2, "resources.getString(ui_R.string.no)");
        String string3 = payoutInitLinkProcessorImpl.l.getString(com.avito.android.ui_components.R.string.yes);
        Intrinsics.checkNotNullExpressionValue(string3, "resources.getString(ui_R.string.yes)");
        String string4 = payoutInitLinkProcessorImpl.l.getString(R.string.delivery_seller_pay_out_error_title);
        Intrinsics.checkNotNullExpressionValue(string4, "resources.getString(R.st…ller_pay_out_error_title)");
        String string5 = payoutInitLinkProcessorImpl.l.getString(R.string.delivery_seller_pay_out_error_message);
        Intrinsics.checkNotNullExpressionValue(string5, "resources.getString(R.st…er_pay_out_error_message)");
        String string6 = payoutInitLinkProcessorImpl.l.getString(com.avito.android.ui_components.R.string.ok);
        Intrinsics.checkNotNullExpressionValue(string6, "resources.getString(ui_R.string.ok)");
        String string7 = payoutInitLinkProcessorImpl.l.getString(com.avito.android.ui_components.R.string.connection_problem);
        Intrinsics.checkNotNullExpressionValue(string7, "resources.getString(ui_R…tring.connection_problem)");
        openScreenIntentStream.postValue(activityIntentFactory.webPaymentIntent(uri2, new WebPaymentResourceProviderImpl("", string, string3, string2, string4, string5, string6, string7, com.avito.android.ui_components.R.drawable.ic_close_24_blue)));
    }

    public static final void access$onUrlLoading(PayoutInitLinkProcessorImpl payoutInitLinkProcessorImpl) {
        payoutInitLinkProcessorImpl.m.get().onStartDeepLinkProcessing();
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        this.f.clear();
    }

    @NotNull
    public String toString() {
        return super.toString() + this.h.getSimpleName();
    }

    public boolean doProcess(@NotNull PayoutLink payoutLink) {
        Intrinsics.checkNotNullParameter(payoutLink, "deeplink");
        if (!this.h.isInstance(payoutLink)) {
            return false;
        }
        CompositeDisposable compositeDisposable = this.f;
        Disposable subscribe = this.i.getPayoutUrl(payoutLink.getPurchaseId()).observeOn(this.g).subscribe(new a(this), new b(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "payoutInteractor.getPayo…          }\n            )");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        return true;
    }

    @Override // com.avito.android.messenger.conversation.mvi.deeplinks.payout.PayoutInitLinkProcessor
    @NotNull
    public SingleLiveEvent<TypedError> getErrorStream() {
        return this.e;
    }

    @Override // com.avito.android.messenger.conversation.mvi.deeplinks.payout.PayoutInitLinkProcessor
    @NotNull
    public SingleLiveEvent<Intent> getOpenScreenIntentStream() {
        return this.d;
    }
}
