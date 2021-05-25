package com.avito.android.rating.publish.radio_select;

import a2.g.r.g;
import com.avito.android.rating.publish.RatingPublishViewData;
import com.avito.android.rating.publish.StepListener;
import com.avito.android.rating.publish.radio_select.RadioSelectPresenter;
import com.avito.android.rating.publish.radio_select.adapter.radio_select.RadioSelectItem;
import com.avito.android.ratings.RatingPublishData;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.publish.NextStagePayload;
import com.avito.android.remote.model.publish.Option;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory3;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.util.AdapterPresentersKt;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.e;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001BQ\b\u0007\u0012\u0006\u0010D\u001a\u00020A\u0012\u0006\u0010&\u001a\u00020#\u0012\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u001607\u0012\u0006\u0010@\u001a\u00020=\u0012\u0006\u0010*\u001a\u00020'\u0012\u0006\u00102\u001a\u00020/\u0012\u0006\u0010H\u001a\u00020E\u0012\b\u0010K\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\bL\u0010MJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J#\u0010\u0019\u001a\u0004\u0018\u00010\u0016*\b\u0012\u0004\u0012\u00020\u00160\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001b\u0010\fJ\u000f\u0010\u001c\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001c\u0010\fJ!\u0010\u001e\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u001d\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u001e\u0010\u001fR\u0018\u0010\"\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u001e\u0010-\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00158\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010.R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u001c\u0010:\u001a\b\u0012\u0004\u0012\u00020\u0016078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010;R\u0016\u0010<\u001a\u0002038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u00105R\u0016\u0010@\u001a\u00020=8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010D\u001a\u00020A8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010H\u001a\u00020E8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bF\u0010GR\u0018\u0010J\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bI\u0010!¨\u0006N"}, d2 = {"Lcom/avito/android/rating/publish/radio_select/RadioSelectPresenterImpl;", "Lcom/avito/android/rating/publish/radio_select/RadioSelectPresenter;", "Lcom/avito/android/rating/publish/radio_select/RadioSelectView;", "view", "", "attachView", "(Lcom/avito/android/rating/publish/radio_select/RadioSelectView;)V", "Lcom/avito/android/rating/publish/radio_select/RadioSelectPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/rating/publish/radio_select/RadioSelectPresenter$Router;)V", "detachRouter", "()V", "detachView", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "", "isLoading", "handleLoading", "(Z)V", "", "Lcom/avito/android/rating/publish/radio_select/adapter/radio_select/RadioSelectItem;", "", "itemId", "getItem", "(Ljava/util/List;Ljava/lang/String;)Lcom/avito/android/rating/publish/radio_select/adapter/radio_select/RadioSelectItem;", AuthSource.BOOKING_ORDER, AuthSource.SEND_ABUSE, "checked", "c", "(Ljava/lang/String;Z)V", "f", "Ljava/lang/String;", "selectedOptionId", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "i", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/android/ratings/RatingPublishData;", "l", "Lcom/avito/android/ratings/RatingPublishData;", "ratingData", "e", "Ljava/util/List;", "items", "Lcom/avito/android/rating/publish/radio_select/RadioSelectView;", "Lcom/avito/android/rating/publish/RatingPublishViewData;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/rating/publish/RatingPublishViewData;", "ratingViewData", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "d", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "viewDisposables", "Lio/reactivex/rxjava3/core/Observable;", "j", "Lio/reactivex/rxjava3/core/Observable;", "itemClicks", "Lcom/avito/android/rating/publish/radio_select/RadioSelectPresenter$Router;", "disposables", "Lcom/avito/android/util/SchedulersFactory3;", "k", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/rating/publish/StepListener;", "h", "Lcom/avito/android/rating/publish/StepListener;", "stepListener", "Lcom/avito/android/remote/model/publish/NextStagePayload;", "n", "Lcom/avito/android/remote/model/publish/NextStagePayload;", "payload", g.a, "errorMessage", "state", "<init>", "(Lcom/avito/android/rating/publish/StepListener;Lcom/avito/konveyor/adapter/AdapterPresenter;Lio/reactivex/rxjava3/core/Observable;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/ratings/RatingPublishData;Lcom/avito/android/rating/publish/RatingPublishViewData;Lcom/avito/android/remote/model/publish/NextStagePayload;Lcom/avito/android/util/Kundle;)V", "rating_release"}, k = 1, mv = {1, 4, 2})
public final class RadioSelectPresenterImpl implements RadioSelectPresenter {
    public RadioSelectView a;
    public RadioSelectPresenter.Router b;
    public final CompositeDisposable c = new CompositeDisposable();
    public final CompositeDisposable d = new CompositeDisposable();
    public List<RadioSelectItem> e;
    public String f;
    public String g;
    public final StepListener h;
    public final AdapterPresenter i;
    public final Observable<RadioSelectItem> j;
    public final SchedulersFactory3 k;
    public final RatingPublishData l;
    public final RatingPublishViewData m;
    public final NextStagePayload n;

    /* compiled from: java-style lambda group */
    public static final class a<T> implements Consumer<Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public a(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public final void accept(Unit unit) {
            int i = this.a;
            if (i == 0) {
                RadioSelectPresenter.Router router = ((RadioSelectPresenterImpl) this.b).b;
                if (router != null) {
                    router.onBackPressed();
                }
            } else if (i == 1) {
                ((RadioSelectPresenterImpl) this.b).b();
            } else {
                throw null;
            }
        }
    }

    public static final class b<T> implements Consumer<RadioSelectItem> {
        public final /* synthetic */ RadioSelectPresenterImpl a;

        public b(RadioSelectPresenterImpl radioSelectPresenterImpl) {
            this.a = radioSelectPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(RadioSelectItem radioSelectItem) {
            RadioSelectItem radioSelectItem2 = radioSelectItem;
            if (radioSelectItem2 instanceof RadioSelectItem) {
                RadioSelectPresenterImpl.access$onSelectionChanged(this.a, radioSelectItem2);
            }
        }
    }

    public static final class c implements Action {
        public final /* synthetic */ RadioSelectView a;

        public c(RadioSelectView radioSelectView) {
            this.a = radioSelectView;
        }

        @Override // io.reactivex.rxjava3.functions.Action
        public final void run() {
            this.a.showProgress();
        }
    }

    public static final class d<T> implements Consumer<Unit> {
        public final /* synthetic */ RadioSelectPresenterImpl a;
        public final /* synthetic */ RadioSelectView b;

        public d(RadioSelectPresenterImpl radioSelectPresenterImpl, RadioSelectView radioSelectView) {
            this.a = radioSelectPresenterImpl;
            this.b = radioSelectView;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Unit unit) {
            this.b.hideProgress();
            String str = this.a.f;
            if (str != null) {
                String str2 = this.a.l.getStepId() + '[' + this.a.n.getParamName() + ']';
                StepListener stepListener = this.a.h;
                RatingPublishData ratingPublishData = this.a.l;
                Map<String, String> dynamicParams = ratingPublishData.getDynamicParams();
                if (dynamicParams == null || dynamicParams.put(str2, str) == null) {
                    ratingPublishData.setDynamicParams(r.mutableMapOf(TuplesKt.to(str2, str)));
                }
                RatingPublishViewData ratingPublishViewData = this.a.m;
                Map<String, String> dynamicParams2 = ratingPublishViewData.getDynamicParams();
                if (dynamicParams2 == null || dynamicParams2.put(str2, str) == null) {
                    ratingPublishViewData.setDynamicParams(r.mutableMapOf(TuplesKt.to(str2, str)));
                }
                stepListener.onStepDataProvided(ratingPublishData, ratingPublishViewData, true);
            }
        }
    }

    @Inject
    public RadioSelectPresenterImpl(@NotNull StepListener stepListener, @NotNull AdapterPresenter adapterPresenter, @NotNull Observable<RadioSelectItem> observable, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull RatingPublishData ratingPublishData, @NotNull RatingPublishViewData ratingPublishViewData, @NotNull NextStagePayload nextStagePayload, @Nullable Kundle kundle) {
        Intrinsics.checkNotNullParameter(stepListener, "stepListener");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(observable, "itemClicks");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(ratingPublishData, "ratingData");
        Intrinsics.checkNotNullParameter(ratingPublishViewData, "ratingViewData");
        Intrinsics.checkNotNullParameter(nextStagePayload, "payload");
        this.h = stepListener;
        this.i = adapterPresenter;
        this.j = observable;
        this.k = schedulersFactory3;
        this.l = ratingPublishData;
        this.m = ratingPublishViewData;
        this.n = nextStagePayload;
        String str = null;
        this.e = kundle != null ? kundle.getParcelableList("radio_select_items") : null;
        this.f = kundle != null ? kundle.getString("radio_selected_stage_id") : null;
        this.g = kundle != null ? kundle.getString("radio_select_errorMessage") : str;
    }

    public static final void access$onSelectionChanged(RadioSelectPresenterImpl radioSelectPresenterImpl, RadioSelectItem radioSelectItem) {
        Objects.requireNonNull(radioSelectPresenterImpl);
        radioSelectItem.setChecked(true);
        radioSelectPresenterImpl.c(radioSelectPresenterImpl.f, false);
        radioSelectPresenterImpl.f = radioSelectItem.getStringId();
        radioSelectPresenterImpl.a();
    }

    public final void a() {
        if (this.l.isLastStep()) {
            RadioSelectView radioSelectView = this.a;
            if (radioSelectView != null) {
                radioSelectView.showSendButton();
            }
        } else {
            RadioSelectView radioSelectView2 = this.a;
            if (radioSelectView2 != null) {
                radioSelectView2.showContinueButton();
            }
        }
        boolean z = this.f != null;
        RadioSelectView radioSelectView3 = this.a;
        if (radioSelectView3 != null) {
            radioSelectView3.setButtonEnabled(z);
        }
    }

    @Override // com.avito.android.rating.publish.radio_select.RadioSelectPresenter
    public void attachRouter(@NotNull RadioSelectPresenter.Router router) {
        Intrinsics.checkNotNullParameter(router, "router");
        this.b = router;
        String str = this.g;
        if (str != null) {
            RadioSelectView radioSelectView = this.a;
            if (radioSelectView != null) {
                radioSelectView.showError(str);
                return;
            }
            return;
        }
        b();
    }

    @Override // com.avito.android.rating.publish.radio_select.RadioSelectPresenter
    public void attachView(@NotNull RadioSelectView radioSelectView) {
        Intrinsics.checkNotNullParameter(radioSelectView, "view");
        this.a = radioSelectView;
        radioSelectView.setTitle(this.n.getTitle());
        CompositeDisposable compositeDisposable = this.d;
        Disposable subscribe = this.j.debounce(250, TimeUnit.MILLISECONDS, this.k.computation()).observeOn(this.k.mainThread()).subscribe(new b(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "itemClicks\n            .…          }\n            }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        CompositeDisposable compositeDisposable2 = this.d;
        Disposable subscribe2 = radioSelectView.navigationClicks().subscribe(new a(0, this));
        Intrinsics.checkNotNullExpressionValue(subscribe2, "view.navigationClicks().…onBackPressed()\n        }");
        DisposableKt.plusAssign(compositeDisposable2, subscribe2);
        CompositeDisposable compositeDisposable3 = this.d;
        Disposable subscribe3 = radioSelectView.retryClicks().subscribe(new a(1, this));
        Intrinsics.checkNotNullExpressionValue(subscribe3, "view.retryClicks().subsc…    loadItems()\n        }");
        DisposableKt.plusAssign(compositeDisposable3, subscribe3);
        CompositeDisposable compositeDisposable4 = this.d;
        Disposable subscribe4 = radioSelectView.continueClicks().doOnComplete(new c(radioSelectView)).subscribe(new d(this, radioSelectView));
        Intrinsics.checkNotNullExpressionValue(subscribe4, "view.continueClicks()\n  …          }\n            }");
        DisposableKt.plusAssign(compositeDisposable4, subscribe4);
        a();
    }

    public final void b() {
        List<Option> options = this.n.getOptions();
        if (options != null) {
            ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(options, 10));
            for (T t : options) {
                arrayList.add(new RadioSelectItem(t.getId(), t.getTitle(), t.getDescription(), false));
            }
            this.g = null;
            this.e = arrayList;
            c(this.f, true);
            AdapterPresentersKt.updateItems(this.i, arrayList);
            RadioSelectView radioSelectView = this.a;
            if (radioSelectView != null) {
                radioSelectView.notifyItemsChanged();
            }
            a();
            return;
        }
        throw new IllegalStateException();
    }

    public final void c(String str, boolean z) {
        RadioSelectItem item;
        List<RadioSelectItem> list = this.e;
        if (list != null && (item = getItem(list, str)) != null) {
            item.setChecked(z);
            RadioSelectView radioSelectView = this.a;
            if (radioSelectView != null) {
                radioSelectView.notifyItemChanged(list.indexOf(item));
            }
        }
    }

    @Override // com.avito.android.rating.publish.radio_select.RadioSelectPresenter
    public void detachRouter() {
        this.c.clear();
        this.b = null;
    }

    @Override // com.avito.android.rating.publish.radio_select.RadioSelectPresenter
    public void detachView() {
        this.d.clear();
        this.a = null;
    }

    @Nullable
    public final RadioSelectItem getItem(@NotNull List<RadioSelectItem> list, @Nullable String str) {
        Intrinsics.checkNotNullParameter(list, "$this$getItem");
        T t = null;
        if (str == null) {
            return null;
        }
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            T next = it.next();
            if (Intrinsics.areEqual(next.getStringId(), str)) {
                t = next;
                break;
            }
        }
        return t;
    }

    @Override // com.avito.android.rating.publish.radio_select.RadioSelectPresenter
    public void handleLoading(boolean z) {
        RadioSelectView radioSelectView = this.a;
        if (radioSelectView != null) {
            radioSelectView.showLoadingState(z);
        }
    }

    @Override // com.avito.android.rating.publish.radio_select.RadioSelectPresenter
    @NotNull
    public Kundle onSaveState() {
        return new Kundle().putParcelableList("radio_select_items", this.e).putString("radio_selected_stage_id", this.f).putString("radio_select_errorMessage", this.g);
    }
}
