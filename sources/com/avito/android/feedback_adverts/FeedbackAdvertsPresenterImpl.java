package com.avito.android.feedback_adverts;

import a2.g.r.g;
import arrow.core.Option;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.feedback.FeedbackAdvertItem;
import com.avito.android.util.SchedulersFactory;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.data_source.ListDataSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001BC\b\u0007\u0012\u0006\u0010:\u001a\u000207\u0012\u0006\u0010>\u001a\u00020;\u0012\u0006\u0010.\u001a\u00020+\u0012\f\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00150C\u0012\b\u0010A\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010I\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\bJ\u0010KJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0019\u0010\fJ\u000f\u0010\u001a\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001a\u0010\fJ\u000f\u0010\u001b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001b\u0010\fJ\u000f\u0010\u001c\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001e\u0010\fR\u001c\u0010#\u001a\b\u0012\u0004\u0012\u00020 0\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010&\u001a\u00020\u00118\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00104\u001a\u00020\u00118\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b3\u0010%R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010>\u001a\u00020;8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010A\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b?\u0010@R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010BR\u001c\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00150C8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010H\u001a\u00020\u00118\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bG\u0010%¨\u0006L"}, d2 = {"Lcom/avito/android/feedback_adverts/FeedbackAdvertsPresenterImpl;", "Lcom/avito/android/feedback_adverts/FeedbackAdvertsPresenter;", "Lcom/avito/android/feedback_adverts/FeedbackAdvertsView;", "view", "", "attachView", "(Lcom/avito/android/feedback_adverts/FeedbackAdvertsView;)V", "Lcom/avito/android/feedback_adverts/FeedbackAdvertsRouter;", "router", "attachRouter", "(Lcom/avito/android/feedback_adverts/FeedbackAdvertsRouter;)V", "detachRouter", "()V", "detachView", "Lcom/avito/android/feedback_adverts/FeedbackAdvertsPresenterState;", "onSaveState", "()Lcom/avito/android/feedback_adverts/FeedbackAdvertsPresenterState;", "", "success", "onLoginComplete", "(Z)V", "", "id", "onAdvertClicked", "(Ljava/lang/String;)V", "onRefresh", "onBackButtonPressed", "onAppend", "canAppend", "()Z", AuthSource.SEND_ABUSE, "", "Lcom/avito/android/remote/feedback/FeedbackAdvertItem;", "d", "Ljava/util/List;", "itemList", g.a, "Z", "isAppending", "Lio/reactivex/disposables/CompositeDisposable;", "h", "Lio/reactivex/disposables/CompositeDisposable;", "subscriptions", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "k", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "", "e", "I", "nextPage", "c", "hasMorePages", AuthSource.BOOKING_ORDER, "Lcom/avito/android/feedback_adverts/FeedbackAdvertsRouter;", "Lcom/avito/android/feedback_adverts/FeedbackAdvertsInteractor;", "i", "Lcom/avito/android/feedback_adverts/FeedbackAdvertsInteractor;", "interactor", "Lcom/avito/android/util/SchedulersFactory;", "j", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", AuthSource.OPEN_CHANNEL_LIST, "Ljava/lang/String;", "toolbarTitle", "Lcom/avito/android/feedback_adverts/FeedbackAdvertsView;", "Larrow/core/Option;", "l", "Larrow/core/Option;", "itemId", "f", "isNetworkProblem", "state", "<init>", "(Lcom/avito/android/feedback_adverts/FeedbackAdvertsInteractor;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/konveyor/adapter/AdapterPresenter;Larrow/core/Option;Ljava/lang/String;Lcom/avito/android/feedback_adverts/FeedbackAdvertsPresenterState;)V", "feedback-adverts_release"}, k = 1, mv = {1, 4, 2})
public final class FeedbackAdvertsPresenterImpl implements FeedbackAdvertsPresenter {
    public FeedbackAdvertsView a;
    public FeedbackAdvertsRouter b;
    public boolean c;
    public final List<FeedbackAdvertItem> d;
    public int e;
    public boolean f;
    public boolean g;
    public final CompositeDisposable h;
    public final FeedbackAdvertsInteractor i;
    public final SchedulersFactory j;
    public final AdapterPresenter k;
    public final Option<String> l;
    public final String m;

    public static final class a<T> implements Consumer<List<? extends FeedbackAdvertItem>> {
        public final /* synthetic */ FeedbackAdvertsPresenterImpl a;

        public a(FeedbackAdvertsPresenterImpl feedbackAdvertsPresenterImpl) {
            this.a = feedbackAdvertsPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(List<? extends FeedbackAdvertItem> list) {
            List<? extends FeedbackAdvertItem> list2 = list;
            FeedbackAdvertsPresenterImpl feedbackAdvertsPresenterImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(list2, "it");
            FeedbackAdvertsPresenterImpl.access$onItemsLoadSuccess(feedbackAdvertsPresenterImpl, list2);
        }
    }

    public static final class b<T> implements Consumer<Throwable> {
        public final /* synthetic */ FeedbackAdvertsPresenterImpl a;

        public b(FeedbackAdvertsPresenterImpl feedbackAdvertsPresenterImpl) {
            this.a = feedbackAdvertsPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            FeedbackAdvertsPresenterImpl.access$onItemsLoadError(this.a);
        }
    }

    @Inject
    public FeedbackAdvertsPresenterImpl(@NotNull FeedbackAdvertsInteractor feedbackAdvertsInteractor, @NotNull SchedulersFactory schedulersFactory, @NotNull AdapterPresenter adapterPresenter, @NotNull Option<String> option, @Nullable String str, @Nullable FeedbackAdvertsPresenterState feedbackAdvertsPresenterState) {
        List<FeedbackAdvertItem> arrayList;
        List<FeedbackAdvertItem> itemList;
        Intrinsics.checkNotNullParameter(feedbackAdvertsInteractor, "interactor");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(option, "itemId");
        this.i = feedbackAdvertsInteractor;
        this.j = schedulersFactory;
        this.k = adapterPresenter;
        this.l = option;
        this.m = str;
        int i2 = 1;
        this.c = feedbackAdvertsPresenterState != null ? feedbackAdvertsPresenterState.getHasMorePages() : true;
        this.d = (feedbackAdvertsPresenterState == null || (itemList = feedbackAdvertsPresenterState.getItemList()) == null || (arrayList = CollectionsKt___CollectionsKt.toMutableList(itemList)) == null) ? new ArrayList<>() : arrayList;
        this.e = feedbackAdvertsPresenterState != null ? feedbackAdvertsPresenterState.getNextPage() : i2;
        this.f = feedbackAdvertsPresenterState != null ? feedbackAdvertsPresenterState.isNetworkProblem() : false;
        this.h = new CompositeDisposable();
    }

    public static final void access$onItemsLoadError(FeedbackAdvertsPresenterImpl feedbackAdvertsPresenterImpl) {
        feedbackAdvertsPresenterImpl.g = false;
        feedbackAdvertsPresenterImpl.f = true;
        FeedbackAdvertsView feedbackAdvertsView = feedbackAdvertsPresenterImpl.a;
        if (feedbackAdvertsView != null) {
            feedbackAdvertsView.hideProgress();
        }
        FeedbackAdvertsView feedbackAdvertsView2 = feedbackAdvertsPresenterImpl.a;
        if (feedbackAdvertsView2 != null) {
            feedbackAdvertsView2.showNetworkProblem();
        }
    }

    public static final void access$onItemsLoadSuccess(FeedbackAdvertsPresenterImpl feedbackAdvertsPresenterImpl, List list) {
        feedbackAdvertsPresenterImpl.g = false;
        feedbackAdvertsPresenterImpl.f = false;
        feedbackAdvertsPresenterImpl.e++;
        FeedbackAdvertsView feedbackAdvertsView = feedbackAdvertsPresenterImpl.a;
        if (feedbackAdvertsView != null) {
            feedbackAdvertsView.hideProgress();
        }
        if (list.size() < 20) {
            feedbackAdvertsPresenterImpl.c = false;
        }
        if (!list.isEmpty()) {
            feedbackAdvertsPresenterImpl.d.addAll(list);
        }
        feedbackAdvertsPresenterImpl.k.onDataSourceChanged(new ListDataSource(feedbackAdvertsPresenterImpl.d));
        FeedbackAdvertsView feedbackAdvertsView2 = feedbackAdvertsPresenterImpl.a;
        if (feedbackAdvertsView2 != null) {
            feedbackAdvertsView2.showData(feedbackAdvertsPresenterImpl);
        }
    }

    public final void a() {
        this.g = true;
        if (this.f || this.d.isEmpty()) {
            this.f = false;
            FeedbackAdvertsView feedbackAdvertsView = this.a;
            if (feedbackAdvertsView != null) {
                feedbackAdvertsView.showProgress();
            }
        }
        Disposable subscribe = this.i.getFeedbackItems(this.l.orNull(), this.e).subscribeOn(this.j.io()).observeOn(this.j.mainThread()).subscribe(new a(this), new b(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "interactor.getFeedbackIt…adError() }\n            )");
        DisposableKt.addTo(subscribe, this.h);
    }

    @Override // com.avito.android.feedback_adverts.FeedbackAdvertsPresenter
    public void attachRouter(@NotNull FeedbackAdvertsRouter feedbackAdvertsRouter) {
        Intrinsics.checkNotNullParameter(feedbackAdvertsRouter, "router");
        this.b = feedbackAdvertsRouter;
    }

    @Override // com.avito.android.feedback_adverts.FeedbackAdvertsPresenter
    public void attachView(@NotNull FeedbackAdvertsView feedbackAdvertsView) {
        Intrinsics.checkNotNullParameter(feedbackAdvertsView, "view");
        this.a = feedbackAdvertsView;
        if (feedbackAdvertsView != null) {
            feedbackAdvertsView.setToolbarBackIcon();
        }
        FeedbackAdvertsView feedbackAdvertsView2 = this.a;
        if (feedbackAdvertsView2 != null) {
            String str = this.m;
            if (str == null) {
                str = "";
            }
            feedbackAdvertsView2.setToolbarTitle(str);
        }
        if (this.f) {
            feedbackAdvertsView.showNetworkProblem();
        } else {
            a();
        }
    }

    @Override // com.avito.android.ui.adapter.AppendingListener
    public boolean canAppend() {
        return this.c;
    }

    @Override // com.avito.android.feedback_adverts.FeedbackAdvertsPresenter
    public void detachRouter() {
        this.b = null;
    }

    @Override // com.avito.android.feedback_adverts.FeedbackAdvertsPresenter
    public void detachView() {
        this.h.clear();
        this.a = null;
    }

    @Override // com.avito.android.feedback_adverts.FeedbackAdvertsItemPresenter.Listener
    public void onAdvertClicked(@NotNull String str) {
        T t;
        Intrinsics.checkNotNullParameter(str, "id");
        Iterator<T> it = this.d.iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            if (Intrinsics.areEqual(t.getStringId(), str)) {
                break;
            }
        }
        T t2 = t;
        FeedbackAdvertsRouter feedbackAdvertsRouter = this.b;
        if (feedbackAdvertsRouter != null) {
            Intrinsics.checkNotNull(t2);
            feedbackAdvertsRouter.onAdvertSelected(t2);
        }
    }

    @Override // com.avito.android.feedback_adverts.FeedbackAdvertsView.Callback, com.avito.android.ui.adapter.AppendingListener
    public void onAppend() {
        if (!this.g) {
            a();
        }
    }

    @Override // com.avito.android.feedback_adverts.FeedbackAdvertsView.Callback
    public void onBackButtonPressed() {
        FeedbackAdvertsRouter feedbackAdvertsRouter = this.b;
        if (feedbackAdvertsRouter != null) {
            feedbackAdvertsRouter.onBackButtonPressed();
        }
    }

    @Override // com.avito.android.feedback_adverts.FeedbackAdvertsPresenter
    public void onLoginComplete(boolean z) {
        if (z) {
            a();
            return;
        }
        FeedbackAdvertsRouter feedbackAdvertsRouter = this.b;
        if (feedbackAdvertsRouter != null) {
            feedbackAdvertsRouter.closeScreen();
        }
    }

    @Override // com.avito.android.feedback_adverts.FeedbackAdvertsView.Callback
    public void onRefresh() {
        a();
    }

    @Override // com.avito.android.feedback_adverts.FeedbackAdvertsPresenter
    @NotNull
    public FeedbackAdvertsPresenterState onSaveState() {
        return new FeedbackAdvertsPresenterState(this.c, this.d, this.e, this.f);
    }
}
