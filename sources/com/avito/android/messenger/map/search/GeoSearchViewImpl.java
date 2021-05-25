package com.avito.android.messenger.map.search;

import a2.g.r.g;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.lib.design.input.Input;
import com.avito.android.messenger.channels.mvi.common.v2.Renderer;
import com.avito.android.messenger.connection_indicator.ConnectionErrorIndicatorView;
import com.avito.android.messenger.map.search.GeoSearchView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.BackingField;
import com.avito.android.util.CharSequencesKt;
import com.avito.android.util.Views;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.avito.konveyor.data_source.ListDataSource;
import io.reactivex.Observable;
import io.reactivex.functions.Predicate;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.MutablePropertyReference2Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010@\u001a\u00020 \u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\u0006\u0010\u0017\u001a\u00020\u0014¢\u0006\u0004\bE\u0010FJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J+\u0010\u000b\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\b0\u00072\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR%\u0010\u0013\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\r8B@\u0002X\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\"\u0010.\u001a\b\u0012\u0004\u0012\u00020)0(8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u00101R9\u0010:\u001a\u0004\u0018\u00010\b*\b\u0012\u0004\u0012\u00020\b0\u00072\b\u00103\u001a\u0004\u0018\u00010\b8V@VX\u0002¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u0016\u0010>\u001a\u00020;8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010@\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b?\u0010\"R\u0016\u0010D\u001a\u00020A8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bB\u0010C¨\u0006G"}, d2 = {"Lcom/avito/android/messenger/map/search/GeoSearchViewImpl;", "Lcom/avito/android/messenger/map/search/GeoSearchView;", "", "text", "", "setQuery", "(Ljava/lang/CharSequence;)V", "Lcom/avito/android/messenger/channels/mvi/common/v2/Renderer;", "Lcom/avito/android/messenger/map/search/GeoSearchView$State;", "prevState", "curState", "doRender", "(Lcom/avito/android/messenger/channels/mvi/common/v2/Renderer;Lcom/avito/android/messenger/map/search/GeoSearchView$State;Lcom/avito/android/messenger/map/search/GeoSearchView$State;)V", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "e", "Lkotlin/Lazy;", "getAdapter", "()Landroidx/recyclerview/widget/RecyclerView$Adapter;", "adapter", "Lcom/avito/konveyor/ItemBinder;", "l", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "k", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Landroidx/recyclerview/widget/RecyclerView;", "c", "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "Landroid/view/View;", "f", "Landroid/view/View;", "listPlaceHolder", "Landroidx/recyclerview/widget/LinearLayoutManager;", "d", "Landroidx/recyclerview/widget/LinearLayoutManager;", "layoutManager", "Lio/reactivex/Observable;", "", "h", "Lio/reactivex/Observable;", "getQueryStream", "()Lio/reactivex/Observable;", "queryStream", "Lcom/avito/android/messenger/connection_indicator/ConnectionErrorIndicatorView;", g.a, "Lcom/avito/android/messenger/connection_indicator/ConnectionErrorIndicatorView;", "connectionErrorIndicator", "<set-?>", AuthSource.SEND_ABUSE, "Lkotlin/properties/ReadWriteProperty;", "getLastRenderedState", "(Lcom/avito/android/messenger/channels/mvi/common/v2/Renderer;)Lcom/avito/android/messenger/map/search/GeoSearchView$State;", "setLastRenderedState", "(Lcom/avito/android/messenger/channels/mvi/common/v2/Renderer;Lcom/avito/android/messenger/map/search/GeoSearchView$State;)V", "lastRenderedState", "", "i", "Z", "shouldShowProgress", "j", "view", "Lcom/avito/android/lib/design/input/Input;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/lib/design/input/Input;", "searchField", "<init>", "(Landroid/view/View;Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/konveyor/ItemBinder;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class GeoSearchViewImpl implements GeoSearchView {
    public static final /* synthetic */ KProperty[] m = {Reflection.mutableProperty2(new MutablePropertyReference2Impl(GeoSearchViewImpl.class, "lastRenderedState", "getLastRenderedState(Lcom/avito/android/messenger/channels/mvi/common/v2/Renderer;)Lcom/avito/android/messenger/map/search/GeoSearchView$State;", 0))};
    @Nullable
    public final ReadWriteProperty a = new BackingField(null);
    public final Input b;
    public final RecyclerView c;
    public final LinearLayoutManager d;
    public final Lazy e;
    public final View f;
    public final ConnectionErrorIndicatorView g;
    @NotNull
    public final Observable<String> h;
    public boolean i;
    public final View j;
    public final AdapterPresenter k;
    public final ItemBinder l;

    public static final class a extends Lambda implements Function0<SimpleRecyclerAdapter> {
        public final /* synthetic */ GeoSearchViewImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(GeoSearchViewImpl geoSearchViewImpl) {
            super(0);
            this.a = geoSearchViewImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public SimpleRecyclerAdapter invoke() {
            SimpleRecyclerAdapter simpleRecyclerAdapter = new SimpleRecyclerAdapter(this.a.k, this.a.l);
            this.a.c.setAdapter(simpleRecyclerAdapter);
            return simpleRecyclerAdapter;
        }
    }

    public static final class b<T> implements Predicate<CharSequence> {
        public static final b a = new b();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Predicate
        public boolean test(CharSequence charSequence) {
            CharSequence charSequence2 = charSequence;
            Intrinsics.checkNotNullParameter(charSequence2, "it");
            return (charSequence2.length() == 0) || CharSequencesKt.getTrimmedLength(charSequence2) >= 3;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v5, types: [a2.a.a.o1.e.b.a] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public GeoSearchViewImpl(@org.jetbrains.annotations.NotNull android.view.View r5, @org.jetbrains.annotations.NotNull com.avito.konveyor.adapter.AdapterPresenter r6, @org.jetbrains.annotations.NotNull com.avito.konveyor.ItemBinder r7) {
        /*
            r4 = this;
            java.lang.String r0 = "view"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "adapterPresenter"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "itemBinder"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            r4.<init>()
            r4.j = r5
            r4.k = r6
            r4.l = r7
            com.avito.android.util.BackingField r6 = new com.avito.android.util.BackingField
            r7 = 0
            r6.<init>(r7)
            r4.a = r6
            int r6 = com.avito.android.messenger.R.id.geo_search_field
            android.view.View r6 = r5.findViewById(r6)
            java.lang.String r0 = "view.findViewById(R.id.geo_search_field)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r0)
            com.avito.android.lib.design.input.Input r6 = (com.avito.android.lib.design.input.Input) r6
            r4.b = r6
            int r0 = com.avito.android.messenger.R.id.messenger_geo_search_list
            android.view.View r0 = r5.findViewById(r0)
            java.lang.String r1 = "view.findViewById(R.id.messenger_geo_search_list)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            androidx.recyclerview.widget.RecyclerView r0 = (androidx.recyclerview.widget.RecyclerView) r0
            r4.c = r0
            kotlin.LazyThreadSafetyMode r1 = kotlin.LazyThreadSafetyMode.NONE
            com.avito.android.messenger.map.search.GeoSearchViewImpl$a r2 = new com.avito.android.messenger.map.search.GeoSearchViewImpl$a
            r2.<init>(r4)
            kotlin.Lazy r1 = t6.c.lazy(r1, r2)
            r4.e = r1
            int r1 = com.avito.android.messenger.R.id.messenger_geo_search_list_placeholder
            android.view.View r1 = r5.findViewById(r1)
            java.lang.String r2 = "view.findViewById(R.id.m…_search_list_placeholder)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            r4.f = r1
            com.avito.android.messenger.connection_indicator.ConnectionErrorIndicatorView$Companion r1 = com.avito.android.messenger.connection_indicator.ConnectionErrorIndicatorView.Companion
            int r2 = com.avito.android.messenger.R.id.messenger_geo_search_connection_error_indicator
            android.view.View r5 = r5.findViewById(r2)
            java.lang.String r2 = "view.findViewById(R.id.m…nnection_error_indicator)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r2)
            com.avito.android.messenger.connection_indicator.ConnectionErrorIndicatorView r5 = r1.create(r5)
            r4.g = r5
            com.jakewharton.rxbinding3.InitialValueObservable r5 = com.avito.android.lib.design.input.InputExtensionsKt.textChanges(r6)
            io.reactivex.Observable r5 = r5.skipInitialValue()
            java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.MILLISECONDS
            r2 = 300(0x12c, double:1.48E-321)
            io.reactivex.Observable r5 = r5.debounce(r2, r1)
            com.avito.android.messenger.map.search.GeoSearchViewImpl$b r1 = com.avito.android.messenger.map.search.GeoSearchViewImpl.b.a
            io.reactivex.Observable r5 = r5.filter(r1)
            com.avito.android.messenger.map.search.GeoSearchViewImpl$c r1 = com.avito.android.messenger.map.search.GeoSearchViewImpl.c.a
            if (r1 == 0) goto L_0x008b
            a2.a.a.o1.e.b.a r2 = new a2.a.a.o1.e.b.a
            r2.<init>(r1)
            r1 = r2
        L_0x008b:
            io.reactivex.functions.Function r1 = (io.reactivex.functions.Function) r1
            io.reactivex.Observable r5 = r5.map(r1)
            io.reactivex.Observable r5 = r5.distinctUntilChanged()
            java.lang.String r1 = "searchField.textChanges(…  .distinctUntilChanged()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r1)
            r4.h = r5
            com.avito.android.messenger.map.search.GeoSearchViewImpl$1 r5 = new com.avito.android.messenger.map.search.GeoSearchViewImpl$1
            r5.<init>()
            r6.setOnEditorActionListener(r5)
            androidx.recyclerview.widget.LinearLayoutManager r5 = new androidx.recyclerview.widget.LinearLayoutManager
            android.content.Context r6 = r0.getContext()
            r5.<init>(r6)
            r4.d = r5
            r0.setLayoutManager(r5)
            r0.setItemAnimator(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.messenger.map.search.GeoSearchViewImpl.<init>(android.view.View, com.avito.konveyor.adapter.AdapterPresenter, com.avito.konveyor.ItemBinder):void");
    }

    @Override // com.avito.android.messenger.channels.mvi.common.v2.Renderer
    @Nullable
    public GeoSearchView.State getLastRenderedState(@NotNull Renderer<GeoSearchView.State> renderer) {
        Intrinsics.checkNotNullParameter(renderer, "$this$lastRenderedState");
        return (GeoSearchView.State) this.a.getValue(renderer, m[0]);
    }

    @Override // com.avito.android.messenger.map.search.GeoSearchView
    @NotNull
    public Observable<String> getQueryStream() {
        return this.h;
    }

    public void render(@NotNull GeoSearchView.State state) {
        Intrinsics.checkNotNullParameter(state, "state");
        GeoSearchView.DefaultImpls.render(this, state);
    }

    public void setLastRenderedState(@NotNull Renderer<GeoSearchView.State> renderer, @Nullable GeoSearchView.State state) {
        Intrinsics.checkNotNullParameter(renderer, "$this$lastRenderedState");
        this.a.setValue(renderer, m[0], state);
    }

    @Override // com.avito.android.messenger.map.search.GeoSearchView
    public void setQuery(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "text");
        Input.setText$default(this.b, charSequence, false, 2, null);
        this.b.setSelection(charSequence.length());
        this.b.showKeyboard();
    }

    public void doRender(@NotNull Renderer<GeoSearchView.State> renderer, @Nullable GeoSearchView.State state, @NotNull GeoSearchView.State state2) {
        Intrinsics.checkNotNullParameter(renderer, "$this$doRender");
        Intrinsics.checkNotNullParameter(state2, "curState");
        if (state2.getSearchIsInProgress()) {
            this.i = true;
            this.j.postDelayed(new Runnable() { // from class: com.avito.android.messenger.map.search.GeoSearchViewImpl$showProgress$1
                @Override // java.lang.Runnable
                public final void run() {
                    if (GeoSearchViewImpl.this.i) {
                        GeoSearchViewImpl.this.b.setLoading(true);
                    }
                }
            }, 300);
        } else {
            this.i = false;
            this.b.setLoading(false);
        }
        GeoSearchView.ListState listState = state2.getListState();
        if (Intrinsics.areEqual(listState, GeoSearchView.ListState.Empty.INSTANCE)) {
            Views.hide(this.f);
            Views.show(this.c);
            this.k.onDataSourceChanged(new ListDataSource(CollectionsKt__CollectionsKt.emptyList()));
            ((RecyclerView.Adapter) this.e.getValue()).notifyDataSetChanged();
        } else if (Intrinsics.areEqual(listState, GeoSearchView.ListState.EmptyWithPlaceHolder.INSTANCE)) {
            Views.hide(this.c);
            Views.show(this.f);
        } else if (listState instanceof GeoSearchView.ListState.NonEmpty) {
            Views.hide(this.f);
            Views.show(this.c);
            AdapterPresenter adapterPresenter = this.k;
            GeoSearchView.ListState listState2 = state2.getListState();
            Objects.requireNonNull(listState2, "null cannot be cast to non-null type com.avito.android.messenger.map.search.GeoSearchView.ListState.NonEmpty");
            adapterPresenter.onDataSourceChanged(new ListDataSource(((GeoSearchView.ListState.NonEmpty) listState2).getItems()));
            ((RecyclerView.Adapter) this.e.getValue()).notifyDataSetChanged();
        }
        this.g.render(state != null ? state.getConnectionErrorIndicatorState() : null, state2.getConnectionErrorIndicatorState());
    }
}
