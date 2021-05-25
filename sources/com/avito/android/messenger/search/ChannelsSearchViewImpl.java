package com.avito.android.messenger.search;

import a2.a.a.o1.f.j;
import a2.g.r.g;
import android.content.Context;
import android.content.res.Resources;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.transition.Fade;
import androidx.transition.TransitionManager;
import com.avito.android.lib.design.input.Input;
import com.avito.android.lib.design.input.InputExtensionsKt;
import com.avito.android.messenger.PaginationScrollListener;
import com.avito.android.messenger.R;
import com.avito.android.messenger.channels.mvi.common.v2.RendererWithDiff;
import com.avito.android.messenger.search.ChannelsSearchView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.BackingField;
import com.avito.android.util.Keyboards;
import com.avito.android.util.RecyclerViewsKt;
import com.avito.android.util.ScrollEventWithThreshold;
import com.avito.android.util.TransitionDsl;
import com.avito.android.util.Views;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.google.android.material.snackbar.Snackbar;
import com.jakewharton.rxrelay2.PublishRelay;
import com.jakewharton.rxrelay2.Relay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.MutablePropertyReference2Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000½\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001A\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\u0006\u0010'\u001a\u00020$\u0012\u0006\u0010g\u001a\u00020f\u0012\u0006\u0010i\u001a\u00020h¢\u0006\u0004\bj\u0010kJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0004J5\u0010\u0010\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u000b0\n2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0012\u0010\u0004R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001e\u0010\u001b\u001a\n \u0018*\u0004\u0018\u00010\u00170\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR9\u0010#\u001a\u0004\u0018\u00010\u000b*\b\u0012\u0004\u0012\u00020\u000b0\n2\b\u0010\u001c\u001a\u0004\u0018\u00010\u000b8V@VX\u0002¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u001e\u0010+\u001a\n \u0018*\u0004\u0018\u00010(0(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\"\u00101\u001a\b\u0012\u0004\u0012\u00020\u00020,8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u001e\u00105\u001a\n \u0018*\u0004\u0018\u000102028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u00104R\"\u00108\u001a\b\u0012\u0004\u0012\u00020\u00020,8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b6\u0010.\u001a\u0004\b7\u00100R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010@\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010D\u001a\u00020A8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bB\u0010CR%\u0010J\u001a\n\u0012\u0006\b\u0001\u0012\u00020F0E8B@\u0002X\u0002¢\u0006\f\n\u0004\bG\u0010H\u001a\u0004\b3\u0010IR\u001e\u0010M\u001a\n \u0018*\u0004\u0018\u00010K0K8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010LR\u0016\u0010Q\u001a\u00020N8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bO\u0010PR\u001e\u0010T\u001a\n \u0018*\u0004\u0018\u00010R0R8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010SR\"\u0010W\u001a\b\u0012\u0004\u0012\u00020\u00020,8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bU\u0010.\u001a\u0004\bV\u00100R\u0016\u0010[\u001a\u00020X8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bY\u0010ZR\"\u0010a\u001a\b\u0012\u0004\u0012\u00020\u00050\\8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b]\u0010^\u001a\u0004\b_\u0010`R\u0016\u0010e\u001a\u00020b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bc\u0010d¨\u0006l"}, d2 = {"Lcom/avito/android/messenger/search/ChannelsSearchViewImpl;", "Lcom/avito/android/messenger/search/ChannelsSearchView;", "", AuthSource.BOOKING_ORDER, "()V", "", "errorMessage", "c", "(Ljava/lang/String;)V", "clearQuery", "Lcom/avito/android/messenger/channels/mvi/common/v2/RendererWithDiff;", "Lcom/avito/android/messenger/search/ChannelsSearchView$State;", "prevState", "curState", "Landroidx/recyclerview/widget/DiffUtil$DiffResult;", "diff", "doRender", "(Lcom/avito/android/messenger/channels/mvi/common/v2/RendererWithDiff;Lcom/avito/android/messenger/search/ChannelsSearchView$State;Lcom/avito/android/messenger/search/ChannelsSearchView$State;Landroidx/recyclerview/widget/DiffUtil$DiffResult;)V", "destroy", "Landroid/view/ViewGroup;", "r", "Landroid/view/ViewGroup;", "rootView", "Landroidx/recyclerview/widget/RecyclerView;", "kotlin.jvm.PlatformType", "d", "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "<set-?>", "k", "Lkotlin/properties/ReadWriteProperty;", "getLastRenderedState", "(Lcom/avito/android/messenger/channels/mvi/common/v2/RendererWithDiff;)Lcom/avito/android/messenger/search/ChannelsSearchView$State;", "setLastRenderedState", "(Lcom/avito/android/messenger/channels/mvi/common/v2/RendererWithDiff;Lcom/avito/android/messenger/search/ChannelsSearchView$State;)V", "lastRenderedState", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "s", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "message", "Lcom/jakewharton/rxrelay2/Relay;", "h", "Lcom/jakewharton/rxrelay2/Relay;", "getSearchRequestStream", "()Lcom/jakewharton/rxrelay2/Relay;", "searchRequestStream", "Landroid/content/res/Resources;", AuthSource.SEND_ABUSE, "Landroid/content/res/Resources;", "resources", "j", "getRetryStream", "retryStream", "Ljava/lang/Runnable;", "n", "Ljava/lang/Runnable;", "showProgressRunnable", "Lcom/google/android/material/snackbar/Snackbar;", "f", "Lcom/google/android/material/snackbar/Snackbar;", "snackbar", "com/avito/android/messenger/search/ChannelsSearchViewImpl$editorActionListener$1", "p", "Lcom/avito/android/messenger/search/ChannelsSearchViewImpl$editorActionListener$1;", "editorActionListener", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", AuthSource.OPEN_CHANNEL_LIST, "Lkotlin/Lazy;", "()Landroidx/recyclerview/widget/RecyclerView$Adapter;", "adapter", "Landroid/content/Context;", "Landroid/content/Context;", "context", "Lcom/avito/android/messenger/PaginationScrollListener;", "o", "Lcom/avito/android/messenger/PaginationScrollListener;", "paginationListener", "Lcom/avito/android/lib/design/input/Input;", "Lcom/avito/android/lib/design/input/Input;", "searchField", "i", "getNextPageRequestStream", "nextPageRequestStream", "Landroidx/recyclerview/widget/LinearLayoutManager;", "l", "Landroidx/recyclerview/widget/LinearLayoutManager;", "layoutManager", "Lio/reactivex/Observable;", g.a, "Lio/reactivex/Observable;", "getQueryChangeStream", "()Lio/reactivex/Observable;", "queryChangeStream", "Lio/reactivex/disposables/CompositeDisposable;", VKApiConst.Q, "Lio/reactivex/disposables/CompositeDisposable;", "subscriptions", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "", "forceShowKeyboard", "<init>", "(Landroid/view/ViewGroup;Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/konveyor/ItemBinder;Z)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class ChannelsSearchViewImpl implements ChannelsSearchView {
    public static final /* synthetic */ KProperty[] t = {Reflection.mutableProperty2(new MutablePropertyReference2Impl(ChannelsSearchViewImpl.class, "lastRenderedState", "getLastRenderedState(Lcom/avito/android/messenger/channels/mvi/common/v2/RendererWithDiff;)Lcom/avito/android/messenger/search/ChannelsSearchView$State;", 0))};
    public final Resources a;
    public final Context b;
    public final Input c;
    public final RecyclerView d;
    public final TextView e;
    public Snackbar f;
    @NotNull
    public final Observable<String> g;
    @NotNull
    public final Relay<Unit> h;
    @NotNull
    public final Relay<Unit> i;
    @NotNull
    public final Relay<Unit> j;
    @Nullable
    public final ReadWriteProperty k = new BackingField(null);
    public final LinearLayoutManager l;
    public final Lazy m;
    public final Runnable n;
    public final PaginationScrollListener o;
    public final ChannelsSearchViewImpl$editorActionListener$1 p;
    public final CompositeDisposable q;
    public final ViewGroup r;
    public final AdapterPresenter s;

    /* compiled from: java-style lambda group */
    public static final class a implements Runnable {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public a(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        @Override // java.lang.Runnable
        public final void run() {
            int i = this.a;
            if (i == 0) {
                ((ChannelsSearchViewImpl) this.b).c.showKeyboard();
            } else if (i == 1) {
                ViewGroup viewGroup = ((ChannelsSearchViewImpl) this.b).r;
                TransitionDsl transitionDsl = new TransitionDsl(new Fade());
                TextView textView = ((ChannelsSearchViewImpl) this.b).e;
                Intrinsics.checkNotNullExpressionValue(textView, "message");
                transitionDsl.addTarget(textView);
                TransitionManager.beginDelayedTransition(viewGroup, transitionDsl.buildTransition());
                ((ChannelsSearchViewImpl) this.b).c.setLoading(true);
                Views.hide(((ChannelsSearchViewImpl) this.b).e);
            } else {
                throw null;
            }
        }
    }

    /* compiled from: kotlin-style lambda group */
    public static final class b extends Lambda implements Function0<Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(int i, Object obj) {
            super(0);
            this.a = i;
            this.b = obj;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            int i = this.a;
            if (i == 0) {
                ((ChannelsSearchViewImpl) this.b).f = null;
                Relay<Unit> retryStream = ((ChannelsSearchViewImpl) this.b).getRetryStream();
                Unit unit = Unit.INSTANCE;
                retryStream.accept(unit);
                return unit;
            } else if (i == 1) {
                ((ChannelsSearchViewImpl) this.b).f = null;
                return Unit.INSTANCE;
            } else {
                throw null;
            }
        }
    }

    public static final class c<T> implements Consumer<ScrollEventWithThreshold> {
        public final /* synthetic */ ChannelsSearchViewImpl a;

        public c(ChannelsSearchViewImpl channelsSearchViewImpl) {
            this.a = channelsSearchViewImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(ScrollEventWithThreshold scrollEventWithThreshold) {
            Input input = this.a.c;
            Intrinsics.checkNotNullExpressionValue(input, "searchField");
            Keyboards.hideKeyboard(input, false);
        }
    }

    public static final class d extends Lambda implements Function0<SimpleRecyclerAdapter> {
        public final /* synthetic */ ChannelsSearchViewImpl a;
        public final /* synthetic */ ItemBinder b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(ChannelsSearchViewImpl channelsSearchViewImpl, ItemBinder itemBinder) {
            super(0);
            this.a = channelsSearchViewImpl;
            this.b = itemBinder;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public SimpleRecyclerAdapter invoke() {
            SimpleRecyclerAdapter simpleRecyclerAdapter = new SimpleRecyclerAdapter(this.a.s, this.b);
            RecyclerView recyclerView = this.a.d;
            Intrinsics.checkNotNullExpressionValue(recyclerView, "recycler");
            recyclerView.setAdapter(simpleRecyclerAdapter);
            return simpleRecyclerAdapter;
        }
    }

    public static final class e extends Lambda implements Function0<Unit> {
        public final /* synthetic */ ChannelsSearchViewImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(ChannelsSearchViewImpl channelsSearchViewImpl) {
            super(0);
            this.a = channelsSearchViewImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            Relay<Unit> nextPageRequestStream = this.a.getNextPageRequestStream();
            Unit unit = Unit.INSTANCE;
            nextPageRequestStream.accept(unit);
            return unit;
        }
    }

    public static final class f<T, R> implements Function<CharSequence, String> {
        public static final f a = new f();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public String apply(CharSequence charSequence) {
            CharSequence charSequence2 = charSequence;
            Intrinsics.checkNotNullParameter(charSequence2, "it");
            return charSequence2.toString();
        }
    }

    public ChannelsSearchViewImpl(@NotNull ViewGroup viewGroup, @NotNull AdapterPresenter adapterPresenter, @NotNull ItemBinder itemBinder, boolean z) {
        Intrinsics.checkNotNullParameter(viewGroup, "rootView");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(itemBinder, "itemBinder");
        this.r = viewGroup;
        this.s = adapterPresenter;
        Resources resources = viewGroup.getResources();
        this.a = resources;
        this.b = viewGroup.getContext();
        Input input = (Input) viewGroup.findViewById(R.id.search_field);
        this.c = input;
        RecyclerView recyclerView = (RecyclerView) viewGroup.findViewById(R.id.items);
        this.d = recyclerView;
        this.e = (TextView) viewGroup.findViewById(R.id.message);
        Intrinsics.checkNotNullExpressionValue(input, "searchField");
        Observable<R> map = InputExtensionsKt.textChanges(input).skipInitialValue().map(f.a);
        Intrinsics.checkNotNullExpressionValue(map, "searchField.textChanges(…e().map { it.toString() }");
        this.g = map;
        PublishRelay create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        this.h = create;
        PublishRelay create2 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create2, "PublishRelay.create()");
        this.i = create2;
        PublishRelay create3 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create3, "PublishRelay.create()");
        this.j = create3;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(viewGroup.getContext(), 1, false);
        this.l = linearLayoutManager;
        this.m = t6.c.lazy(LazyThreadSafetyMode.NONE, (Function0) new d(this, itemBinder));
        this.n = new a(1, this);
        PaginationScrollListener paginationScrollListener = new PaginationScrollListener(linearLayoutManager, 3, new e(this));
        this.o = paginationScrollListener;
        ChannelsSearchViewImpl$editorActionListener$1 channelsSearchViewImpl$editorActionListener$1 = new TextView.OnEditorActionListener(this) { // from class: com.avito.android.messenger.search.ChannelsSearchViewImpl$editorActionListener$1
            public final /* synthetic */ ChannelsSearchViewImpl a;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.a = r1;
            }

            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(@Nullable TextView textView, int i2, @Nullable KeyEvent keyEvent) {
                if (i2 != 3) {
                    return false;
                }
                Snackbar snackbar = this.a.f;
                if (snackbar != null) {
                    snackbar.dismiss();
                }
                Input input2 = this.a.c;
                Intrinsics.checkNotNullExpressionValue(input2, "searchField");
                Keyboards.hideKeyboard$default(input2, false, 1, null);
                this.a.getSearchRequestStream().accept(Unit.INSTANCE);
                return true;
            }
        };
        this.p = channelsSearchViewImpl$editorActionListener$1;
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        this.q = compositeDisposable;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "recycler");
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addOnScrollListener(paginationScrollListener);
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        int roundToInt = t6.s.c.roundToInt(((float) 16) * resources.getDisplayMetrics().density);
        Intrinsics.checkNotNullExpressionValue(recyclerView, "recycler");
        Disposable subscribe = RecyclerViewsKt.scrollEventsWithThreshold(recyclerView, roundToInt).throttleFirst(500, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "recycler.scrollEventsWit…ard(clearFocus = false) }");
        DisposableKt.addTo(subscribe, compositeDisposable);
        input.setOnEditorActionListener(channelsSearchViewImpl$editorActionListener$1);
        if (z) {
            viewGroup.post(new a(0, this));
        }
    }

    public final RecyclerView.Adapter<? extends RecyclerView.ViewHolder> a() {
        return (RecyclerView.Adapter) this.m.getValue();
    }

    public final void b() {
        this.r.removeCallbacks(this.n);
        this.c.setLoading(false);
    }

    public final void c(String str) {
        Snackbar snackbar = this.f;
        if (snackbar == null || !snackbar.isShownOrQueued()) {
            this.f = Views.showSnackBar$default(this.r, str, -2, this.b.getString(R.string.retry), 0, new b(0, this), new b(1, this), 0, 72, (Object) null);
            return;
        }
        Snackbar snackbar2 = this.f;
        if (snackbar2 != null) {
            snackbar2.setText(str);
        }
    }

    @Override // com.avito.android.messenger.search.ChannelsSearchView
    public void clearQuery() {
        this.c.setText((Editable) null);
    }

    @Override // com.avito.android.messenger.search.ChannelsSearchView
    public void destroy() {
        this.q.clear();
        this.c.setOnEditorActionListener(null);
        this.d.removeOnScrollListener(this.o);
        this.r.removeCallbacks(this.n);
        Snackbar snackbar = this.f;
        if (snackbar != null) {
            snackbar.dismiss();
        }
    }

    @Override // com.avito.android.messenger.channels.mvi.common.v2.RendererWithDiff
    @Nullable
    public ChannelsSearchView.State getLastRenderedState(@NotNull RendererWithDiff<ChannelsSearchView.State> rendererWithDiff) {
        Intrinsics.checkNotNullParameter(rendererWithDiff, "$this$lastRenderedState");
        return (ChannelsSearchView.State) this.k.getValue(rendererWithDiff, t[0]);
    }

    @Override // com.avito.android.messenger.search.ChannelsSearchView
    @NotNull
    public Observable<String> getQueryChangeStream() {
        return this.g;
    }

    public void render(@NotNull ChannelsSearchView.State state, @Nullable DiffUtil.DiffResult diffResult) {
        Intrinsics.checkNotNullParameter(state, "state");
        ChannelsSearchView.DefaultImpls.render(this, state, diffResult);
    }

    public void setLastRenderedState(@NotNull RendererWithDiff<ChannelsSearchView.State> rendererWithDiff, @Nullable ChannelsSearchView.State state) {
        Intrinsics.checkNotNullParameter(rendererWithDiff, "$this$lastRenderedState");
        this.k.setValue(rendererWithDiff, t[0], state);
    }

    public void doRender(@NotNull RendererWithDiff<ChannelsSearchView.State> rendererWithDiff, @Nullable ChannelsSearchView.State state, @NotNull ChannelsSearchView.State state2, @Nullable DiffUtil.DiffResult diffResult) {
        Intrinsics.checkNotNullParameter(rendererWithDiff, "$this$doRender");
        Intrinsics.checkNotNullParameter(state2, "curState");
        ViewGroup viewGroup = this.r;
        TransitionDsl transitionDsl = new TransitionDsl(new Fade());
        TextView textView = this.e;
        Intrinsics.checkNotNullExpressionValue(textView, "message");
        transitionDsl.addTarget(textView);
        RecyclerView recyclerView = this.d;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "recycler");
        transitionDsl.addTarget(recyclerView);
        TransitionManager.beginDelayedTransition(viewGroup, transitionDsl.buildTransition());
        boolean z = true;
        if (Intrinsics.areEqual(state2, ChannelsSearchView.State.Empty.INSTANCE)) {
            b();
            Views.hide(this.e);
            Snackbar snackbar = this.f;
            if (snackbar != null) {
                snackbar.dismiss();
            }
        } else if (state2 instanceof ChannelsSearchView.State.ShortQuery) {
            b();
            this.e.setText(R.string.messenger_search_query_too_short);
            Views.show(this.e);
            Snackbar snackbar2 = this.f;
            if (snackbar2 != null) {
                snackbar2.dismiss();
            }
        } else if (state2 instanceof ChannelsSearchView.State.Loading) {
            if (!(state instanceof ChannelsSearchView.State.Loading)) {
                if (state != null) {
                    this.r.postDelayed(this.n, 300);
                } else {
                    this.n.run();
                }
            }
        } else if (state2 instanceof ChannelsSearchView.State.Loaded.Empty) {
            b();
            this.e.setText(R.string.messenger_search_nothing_found);
            Views.show(this.e);
            Snackbar snackbar3 = this.f;
            if (snackbar3 != null) {
                snackbar3.dismiss();
            }
        } else if (state2 instanceof ChannelsSearchView.State.Loaded.Results) {
            b();
            Views.hide(this.e);
            ChannelsSearchView.State.Loaded.Results results = (ChannelsSearchView.State.Loaded.Results) state2;
            ChannelsSearchView.State.PaginationState paginationState = results.getPaginationState();
            if (Intrinsics.areEqual(paginationState, ChannelsSearchView.State.PaginationState.Idle.INSTANCE)) {
                if (state != null && (!Intrinsics.areEqual(state2.getResults().getQuery(), state.getResults().getQuery()))) {
                    this.d.post(new j(this));
                }
                Snackbar snackbar4 = this.f;
                if (snackbar4 != null) {
                    snackbar4.dismiss();
                }
            } else if (Intrinsics.areEqual(paginationState, ChannelsSearchView.State.PaginationState.InProgress.INSTANCE)) {
                Snackbar snackbar5 = this.f;
                if (snackbar5 != null) {
                    snackbar5.dismiss();
                }
            } else if (paginationState instanceof ChannelsSearchView.State.PaginationState.Error) {
                c(((ChannelsSearchView.State.PaginationState.Error) results.getPaginationState()).getMessage());
            }
        } else if (state2 instanceof ChannelsSearchView.State.Error) {
            b();
            Views.hide(this.e);
            c(((ChannelsSearchView.State.Error) state2).getMessage());
        }
        a2.b.a.a.a.s1(state2.getResults().getItems(), this.s);
        if (diffResult != null) {
            diffResult.dispatchUpdatesTo(a());
        } else {
            a().notifyDataSetChanged();
        }
        PaginationScrollListener paginationScrollListener = this.o;
        if (!(state2 instanceof ChannelsSearchView.State.Loaded.Results) || !state2.getResults().getHasMorePages() || !Intrinsics.areEqual(((ChannelsSearchView.State.Loaded.Results) state2).getPaginationState(), ChannelsSearchView.State.PaginationState.Idle.INSTANCE)) {
            z = false;
        }
        paginationScrollListener.setPaginationEnabled(z);
    }

    @Override // com.avito.android.messenger.search.ChannelsSearchView
    @NotNull
    public Relay<Unit> getNextPageRequestStream() {
        return this.i;
    }

    @Override // com.avito.android.messenger.search.ChannelsSearchView
    @NotNull
    public Relay<Unit> getRetryStream() {
        return this.j;
    }

    @Override // com.avito.android.messenger.search.ChannelsSearchView
    @NotNull
    public Relay<Unit> getSearchRequestStream() {
        return this.h;
    }
}
