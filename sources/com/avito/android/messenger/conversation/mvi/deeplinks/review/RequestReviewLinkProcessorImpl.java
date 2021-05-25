package com.avito.android.messenger.conversation.mvi.deeplinks.review;

import a2.g.r.g;
import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.links.RequestReviewLink;
import com.avito.android.messenger.analytics.ReviewRequestItemClickEvent;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.util.Formatter;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.TypedResultException;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import hu.akarnokd.rxjava2.schedulers.SharedScheduler;
import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.rxkotlin.DisposableKt;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B/\b\u0007\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u0012\u0006\u0010*\u001a\u00020)\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\f\u0010(\u001a\b\u0012\u0004\u0012\u00020%0$¢\u0006\u0004\b+\u0010,J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\"\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\"\u0010#\u001a\b\u0012\u0004\u0012\u00020 0\u000e8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b!\u0010\u0010\u001a\u0004\b\"\u0010\u0012R\u001c\u0010(\u001a\b\u0012\u0004\u0012\u00020%0$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'¨\u0006-"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/deeplinks/review/RequestReviewLinkProcessorImpl;", "Lcom/avito/android/messenger/conversation/mvi/deeplinks/review/RequestReviewLinkProcessor;", "Lcom/avito/android/deep_linking/links/RequestReviewLink;", "deeplink", "", "doProcess", "(Lcom/avito/android/deep_linking/links/RequestReviewLink;)Z", "", "onCleared", "()V", "Lio/reactivex/disposables/CompositeDisposable;", "d", "Lio/reactivex/disposables/CompositeDisposable;", "subscriptions", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "f", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "getReviewRequestedStream", "()Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "reviewRequestedStream", "Lio/reactivex/Scheduler;", "e", "Lio/reactivex/Scheduler;", "scheduler", "Lcom/avito/android/analytics/Analytics;", "i", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/messenger/conversation/mvi/deeplinks/review/RequestReviewInteractor;", "h", "Lcom/avito/android/messenger/conversation/mvi/deeplinks/review/RequestReviewInteractor;", "reviewInteractor", "", g.a, "getErrorMessageStream", "errorMessageStream", "Lcom/avito/android/util/Formatter;", "", "j", "Lcom/avito/android/util/Formatter;", "errorFormatter", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "<init>", "(Lcom/avito/android/messenger/conversation/mvi/deeplinks/review/RequestReviewInteractor;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/util/Formatter;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class RequestReviewLinkProcessorImpl extends RequestReviewLinkProcessor {
    public final CompositeDisposable d;
    public final Scheduler e;
    @NotNull
    public final SingleLiveEvent<Unit> f = new SingleLiveEvent<>();
    @NotNull
    public final SingleLiveEvent<String> g = new SingleLiveEvent<>();
    public final RequestReviewInteractor h;
    public final Analytics i;
    public final Formatter<Throwable> j;

    public static final class a<T> implements Consumer<TypedResult<Unit>> {
        public final /* synthetic */ RequestReviewLinkProcessorImpl a;

        public a(RequestReviewLinkProcessorImpl requestReviewLinkProcessorImpl) {
            this.a = requestReviewLinkProcessorImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.avito.android.util.Formatter */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public void accept(TypedResult<Unit> typedResult) {
            TypedResult<Unit> typedResult2 = typedResult;
            if (typedResult2 instanceof TypedResult.OfResult) {
                this.a.getReviewRequestedStream().postValue(Unit.INSTANCE);
            } else if (typedResult2 instanceof TypedResult.OfError) {
                this.a.getErrorMessageStream().postValue(this.a.j.format(new TypedResultException(((TypedResult.OfError) typedResult2).getError())));
            }
        }
    }

    public static final class b<T> implements Consumer<Throwable> {
        public final /* synthetic */ RequestReviewLinkProcessorImpl a;

        public b(RequestReviewLinkProcessorImpl requestReviewLinkProcessorImpl) {
            this.a = requestReviewLinkProcessorImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.avito.android.util.Formatter */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            this.a.getErrorMessageStream().postValue(this.a.j.format(th));
        }
    }

    @Inject
    public RequestReviewLinkProcessorImpl(@NotNull RequestReviewInteractor requestReviewInteractor, @NotNull SchedulersFactory schedulersFactory, @NotNull Analytics analytics, @NotNull Formatter<Throwable> formatter) {
        Intrinsics.checkNotNullParameter(requestReviewInteractor, "reviewInteractor");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(formatter, "errorFormatter");
        this.h = requestReviewInteractor;
        this.i = analytics;
        this.j = formatter;
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        this.d = compositeDisposable;
        SharedScheduler sharedScheduler = new SharedScheduler(schedulersFactory.io());
        compositeDisposable.add(Disposables.fromAction(new Action() { // from class: com.avito.android.messenger.conversation.mvi.deeplinks.review.RequestReviewLinkProcessorImpl$inlined$sam$i$io_reactivex_functions_Action$0
            @Override // io.reactivex.functions.Action
            public final /* synthetic */ void run() {
                Intrinsics.checkNotNullExpressionValue(Function0.this.invoke(), "invoke(...)");
            }
        }));
        this.e = sharedScheduler;
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        this.d.clear();
    }

    public boolean doProcess(@NotNull RequestReviewLink requestReviewLink) {
        Intrinsics.checkNotNullParameter(requestReviewLink, "deeplink");
        this.i.track(new ReviewRequestItemClickEvent(requestReviewLink.getChatId()));
        CompositeDisposable compositeDisposable = this.d;
        Disposable subscribe = this.h.requestReview(requestReviewLink.getContext()).subscribeOn(this.e).subscribe(new a(this), new b(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "reviewInteractor.request…          }\n            )");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        return true;
    }

    @Override // com.avito.android.messenger.conversation.mvi.deeplinks.review.RequestReviewLinkProcessor
    @NotNull
    public SingleLiveEvent<String> getErrorMessageStream() {
        return this.g;
    }

    @Override // com.avito.android.messenger.conversation.mvi.deeplinks.review.RequestReviewLinkProcessor
    @NotNull
    public SingleLiveEvent<Unit> getReviewRequestedStream() {
        return this.f;
    }
}
