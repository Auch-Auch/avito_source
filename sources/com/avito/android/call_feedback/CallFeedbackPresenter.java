package com.avito.android.call_feedback;

import a2.g.r.g;
import com.avito.android.call_feedback.list.item.CallFeedbackListItem;
import com.avito.android.call_feedback.list.title.CallFeedbackListTitle;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorWithMessage;
import com.avito.android.remote.error.TypedError;
import com.avito.android.remote.model.CallFeedbackShow;
import com.avito.android.util.Kundle;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.TypedResultException;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.data_source.ListDataSource;
import com.jakewharton.rxrelay2.Relay;
import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.ArrayList;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b`\u0018\u00002\u00020\u0001:\u0001\u0011J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0004H&¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0004H&¢\u0006\u0004\b\u0010\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/avito/android/call_feedback/CallFeedbackPresenter;", "", "Lcom/avito/android/call_feedback/CallFeedbackView;", "view", "", "attachView", "(Lcom/avito/android/call_feedback/CallFeedbackView;)V", "Lcom/avito/android/call_feedback/CallFeedbackRouter;", "router", "attachRouter", "(Lcom/avito/android/call_feedback/CallFeedbackRouter;)V", "Lcom/avito/android/util/Kundle;", "getState", "()Lcom/avito/android/util/Kundle;", "detachRouter", "()V", "detachView", "Impl", "call-feedback_release"}, k = 1, mv = {1, 4, 2})
public interface CallFeedbackPresenter {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B9\b\u0007\u0012\u0006\u0010\"\u001a\u00020\u001f\u0012\u0006\u0010(\u001a\u00020%\u0012\f\u0010/\u001a\b\u0012\u0004\u0012\u00020,0+\u0012\b\u00103\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u00105\u001a\u000204¢\u0006\u0004\b6\u00107J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0010\u0010\u000fJ\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0015\u0010\u000fR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0019R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u001c\u0010/\u001a\b\u0012\u0004\u0012\u00020,0+8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00102\u001a\u0002008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u00101¨\u00068"}, d2 = {"Lcom/avito/android/call_feedback/CallFeedbackPresenter$Impl;", "Lcom/avito/android/call_feedback/CallFeedbackPresenter;", "Lcom/avito/android/call_feedback/CallFeedbackView;", "view", "", "attachView", "(Lcom/avito/android/call_feedback/CallFeedbackView;)V", "Lcom/avito/android/call_feedback/CallFeedbackRouter;", "router", "attachRouter", "(Lcom/avito/android/call_feedback/CallFeedbackRouter;)V", "Lcom/avito/android/util/Kundle;", "getState", "()Lcom/avito/android/util/Kundle;", "detachRouter", "()V", "detachView", "Lcom/avito/android/remote/model/CallFeedbackShow;", "data", AuthSource.SEND_ABUSE, "(Lcom/avito/android/remote/model/CallFeedbackShow;)V", AuthSource.BOOKING_ORDER, "f", "Lcom/avito/android/call_feedback/CallFeedbackView;", "Lio/reactivex/disposables/CompositeDisposable;", "Lio/reactivex/disposables/CompositeDisposable;", "disposables", "Lio/reactivex/disposables/Disposable;", "d", "Lio/reactivex/disposables/Disposable;", "disposable", "Lcom/avito/konveyor/adapter/AdapterPresenter;", g.a, "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "e", "Lcom/avito/android/call_feedback/CallFeedbackRouter;", "Lcom/avito/android/call_feedback/CallFeedbackInteractor;", "h", "Lcom/avito/android/call_feedback/CallFeedbackInteractor;", "interactor", "c", "Lcom/avito/android/remote/model/CallFeedbackShow;", "Lcom/jakewharton/rxrelay2/Relay;", "", "i", "Lcom/jakewharton/rxrelay2/Relay;", "itemsObservable", "Lio/reactivex/Scheduler;", "Lio/reactivex/Scheduler;", "mainThreadScheduler", "kundle", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "<init>", "(Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/android/call_feedback/CallFeedbackInteractor;Lcom/jakewharton/rxrelay2/Relay;Lcom/avito/android/util/Kundle;Lcom/avito/android/util/SchedulersFactory;)V", "call-feedback_release"}, k = 1, mv = {1, 4, 2})
    public static final class Impl implements CallFeedbackPresenter {
        public final CompositeDisposable a = new CompositeDisposable();
        public final Scheduler b;
        public CallFeedbackShow c;
        public Disposable d;
        public CallFeedbackRouter e;
        public CallFeedbackView f;
        public final AdapterPresenter g;
        public final CallFeedbackInteractor h;
        public final Relay<String> i;

        /* compiled from: java-style lambda group */
        public static final class a<T> implements Consumer<Throwable> {
            public static final a b = new a(0);
            public static final a c = new a(1);
            public static final a d = new a(2);
            public static final a e = new a(3);
            public final /* synthetic */ int a;

            public a(int i) {
                this.a = i;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // io.reactivex.functions.Consumer
            public final void accept(Throwable th) {
                int i = this.a;
                if (i == 0) {
                    Logs.error(th);
                } else if (i == 1) {
                    Logs.error(th);
                } else if (i == 2) {
                    Logs.error(th);
                } else if (i == 3) {
                    Logs.error(th);
                } else {
                    throw null;
                }
            }
        }

        /* compiled from: java-style lambda group */
        public static final class b<T> implements Consumer<Unit> {
            public final /* synthetic */ int a;
            public final /* synthetic */ Object b;

            public b(int i, Object obj) {
                this.a = i;
                this.b = obj;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // io.reactivex.functions.Consumer
            public final void accept(Unit unit) {
                int i = this.a;
                if (i == 0) {
                    Impl.access$disposeRequest((Impl) this.b);
                } else if (i == 1) {
                    CallFeedbackRouter callFeedbackRouter = ((Impl) this.b).e;
                    if (callFeedbackRouter != null) {
                        callFeedbackRouter.close();
                    }
                } else if (i == 2) {
                    ((Impl) this.b).b();
                } else {
                    throw null;
                }
            }
        }

        public static final class c<T> implements Consumer<String> {
            public final /* synthetic */ Impl a;

            public c(Impl impl) {
                this.a = impl;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // io.reactivex.functions.Consumer
            public void accept(String str) {
                String str2 = str;
                Impl impl = this.a;
                Intrinsics.checkNotNullExpressionValue(str2, "it");
                Impl.access$send(impl, str2);
            }
        }

        public static final class d<T> implements Consumer<CallFeedbackShow> {
            public final /* synthetic */ Impl a;

            public d(Impl impl) {
                this.a = impl;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // io.reactivex.functions.Consumer
            public void accept(CallFeedbackShow callFeedbackShow) {
                CallFeedbackShow callFeedbackShow2 = callFeedbackShow;
                this.a.c = callFeedbackShow2;
                Impl impl = this.a;
                Intrinsics.checkNotNullExpressionValue(callFeedbackShow2, "it");
                impl.a(callFeedbackShow2);
                CallFeedbackView callFeedbackView = this.a.f;
                if (callFeedbackView != null) {
                    callFeedbackView.showContent();
                }
            }
        }

        public static final class e<T> implements Consumer<Throwable> {
            public final /* synthetic */ Impl a;

            public e(Impl impl) {
                this.a = impl;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // io.reactivex.functions.Consumer
            public void accept(Throwable th) {
                Throwable th2 = th;
                if (th2 instanceof TypedResultException) {
                    TypedError errorResult = ((TypedResultException) th2).getErrorResult();
                    if (errorResult instanceof ErrorWithMessage) {
                        CallFeedbackView callFeedbackView = this.a.f;
                        if (callFeedbackView != null) {
                            callFeedbackView.showError(((ErrorWithMessage) errorResult).getMessage());
                            return;
                        }
                        return;
                    }
                    CallFeedbackView callFeedbackView2 = this.a.f;
                    if (callFeedbackView2 != null) {
                        callFeedbackView2.showError();
                        return;
                    }
                    return;
                }
                CallFeedbackView callFeedbackView3 = this.a.f;
                if (callFeedbackView3 != null) {
                    callFeedbackView3.showError();
                }
            }
        }

        @Inject
        public Impl(@NotNull AdapterPresenter adapterPresenter, @NotNull CallFeedbackInteractor callFeedbackInteractor, @NotNull Relay<String> relay, @Nullable Kundle kundle, @NotNull SchedulersFactory schedulersFactory) {
            Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
            Intrinsics.checkNotNullParameter(callFeedbackInteractor, "interactor");
            Intrinsics.checkNotNullParameter(relay, "itemsObservable");
            Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
            this.g = adapterPresenter;
            this.h = callFeedbackInteractor;
            this.i = relay;
            this.b = schedulersFactory.mainThread();
            this.c = kundle != null ? (CallFeedbackShow) kundle.getParcelable("key") : null;
        }

        public static final void access$disposeRequest(Impl impl) {
            Disposable disposable = impl.d;
            if (disposable != null) {
                disposable.dispose();
            }
            impl.d = null;
        }

        public static final void access$send(Impl impl, String str) {
            Disposable disposable = impl.d;
            if (disposable != null) {
                disposable.dispose();
            }
            CallFeedbackView callFeedbackView = impl.f;
            if (callFeedbackView != null) {
                callFeedbackView.showDialog();
            }
            impl.d = impl.h.setItem(str).observeOn(impl.b).subscribe(new a2.a.a.y.a(impl), new a2.a.a.y.b(impl));
        }

        public final void a(CallFeedbackShow callFeedbackShow) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new CallFeedbackListTitle("title", callFeedbackShow.getTitle()));
            for (T t : callFeedbackShow.getItems()) {
                arrayList.add(new CallFeedbackListItem(t.getId(), t.getTitle()));
            }
            this.g.onDataSourceChanged(new ListDataSource(arrayList));
            CallFeedbackView callFeedbackView = this.f;
            if (callFeedbackView != null) {
                callFeedbackView.notifyDataChanged();
            }
        }

        @Override // com.avito.android.call_feedback.CallFeedbackPresenter
        public void attachRouter(@NotNull CallFeedbackRouter callFeedbackRouter) {
            Intrinsics.checkNotNullParameter(callFeedbackRouter, "router");
            this.e = callFeedbackRouter;
        }

        @Override // com.avito.android.call_feedback.CallFeedbackPresenter
        public void attachView(@NotNull CallFeedbackView callFeedbackView) {
            Intrinsics.checkNotNullParameter(callFeedbackView, "view");
            this.f = callFeedbackView;
            CompositeDisposable compositeDisposable = this.a;
            Disposable subscribe = callFeedbackView.getCancelDialogCallback().observeOn(this.b).subscribe(new b(0, this), a.b);
            Intrinsics.checkNotNullExpressionValue(subscribe, "view\n                .ge…r(it) }\n                )");
            DisposableKt.plusAssign(compositeDisposable, subscribe);
            CompositeDisposable compositeDisposable2 = this.a;
            Disposable subscribe2 = callFeedbackView.getBackButtonCallbacks().observeOn(this.b).subscribe(new b(1, this), a.c);
            Intrinsics.checkNotNullExpressionValue(subscribe2, "view\n                .ge…r(it) }\n                )");
            DisposableKt.plusAssign(compositeDisposable2, subscribe2);
            CompositeDisposable compositeDisposable3 = this.a;
            Disposable subscribe3 = callFeedbackView.getRetryButtonCallback().observeOn(this.b).subscribe(new b(2, this), a.d);
            Intrinsics.checkNotNullExpressionValue(subscribe3, "view\n                .ge…r(it) }\n                )");
            DisposableKt.plusAssign(compositeDisposable3, subscribe3);
            CompositeDisposable compositeDisposable4 = this.a;
            Disposable subscribe4 = this.i.observeOn(this.b).subscribe(new c(this), a.e);
            Intrinsics.checkNotNullExpressionValue(subscribe4, "itemsObservable\n        …r(it) }\n                )");
            DisposableKt.plusAssign(compositeDisposable4, subscribe4);
            CallFeedbackShow callFeedbackShow = this.c;
            if (callFeedbackShow == null) {
                b();
            } else {
                a(callFeedbackShow);
            }
        }

        public final void b() {
            Disposable disposable = this.d;
            if (disposable != null) {
                disposable.dispose();
            }
            CallFeedbackView callFeedbackView = this.f;
            if (callFeedbackView != null) {
                callFeedbackView.showProgress();
            }
            this.d = this.h.getItems().observeOn(this.b).subscribe(new d(this), new e(this));
        }

        @Override // com.avito.android.call_feedback.CallFeedbackPresenter
        public void detachRouter() {
            this.e = null;
        }

        @Override // com.avito.android.call_feedback.CallFeedbackPresenter
        public void detachView() {
            Disposable disposable = this.d;
            if (disposable != null) {
                disposable.dispose();
            }
            this.d = null;
            this.a.clear();
            this.f = null;
        }

        @Override // com.avito.android.call_feedback.CallFeedbackPresenter
        @NotNull
        public Kundle getState() {
            return new Kundle().putParcelable("key", this.c);
        }
    }

    void attachRouter(@NotNull CallFeedbackRouter callFeedbackRouter);

    void attachView(@NotNull CallFeedbackView callFeedbackView);

    void detachRouter();

    void detachView();

    @NotNull
    Kundle getState();
}
