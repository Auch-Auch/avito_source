package com.avito.android.user_adverts.items_search;

import a2.b.a.a.a;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.analytics.Analytics;
import com.avito.android.authorization.event.SocialButtonClickedEventKt;
import com.avito.android.lib.design.input.Input;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.user_adverts.items_search.advert_list.suggests.SuggestItem;
import com.avito.android.user_adverts.items_search.analytics.ProfileItemsSuggestsSelectEvent;
import com.avito.android.util.Keyboards;
import com.avito.android.util.Views;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.disposables.CompositeDisposable;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B'\u0012\u0006\u0010*\u001a\u00020)\u0012\u0006\u0010,\u001a\u00020+\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\u0006\u0010$\u001a\u00020!¢\u0006\u0004\b-\u0010.J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\u000f\u001a\u00020\u00032\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0011\u0010\u0005R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'¨\u0006/"}, d2 = {"Lcom/avito/android/user_adverts/items_search/SearchBarImpl;", "Lcom/avito/android/user_adverts/items_search/SearchBar;", "Lcom/avito/android/user_adverts/items_search/SuggestItemListener;", "", "onDestroyView", "()V", "", SocialButtonClickedEventKt.SUGGEST, "", VKApiConst.POSITION, "onSuggestClicked", "(Ljava/lang/String;I)V", "", "Lcom/avito/android/user_adverts/items_search/advert_list/suggests/SuggestItem;", "items", "showSuggests", "(Ljava/util/List;)V", AuthSource.SEND_ABUSE, "Lcom/avito/android/user_adverts/items_search/SearchBarInteractor;", "e", "Lcom/avito/android/user_adverts/items_search/SearchBarInteractor;", "interactor", "Lcom/avito/android/lib/design/input/Input;", "Lcom/avito/android/lib/design/input/Input;", "searchInput", "Landroidx/recyclerview/widget/RecyclerView;", AuthSource.BOOKING_ORDER, "Landroidx/recyclerview/widget/RecyclerView;", "suggests", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "c", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/android/analytics/Analytics;", "f", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lio/reactivex/disposables/CompositeDisposable;", "d", "Lio/reactivex/disposables/CompositeDisposable;", "subscriptions", "Landroid/view/View;", "rootView", "", "withFocus", "<init>", "(Landroid/view/View;ZLcom/avito/android/user_adverts/items_search/SearchBarInteractor;Lcom/avito/android/analytics/Analytics;)V", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
public final class SearchBarImpl implements SearchBar, SuggestItemListener {
    public final Input a;
    public final RecyclerView b;
    public AdapterPresenter c;
    public final CompositeDisposable d;
    public final SearchBarInteractor e;
    public final Analytics f;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [a2.a.a.i3.b.m] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public SearchBarImpl(@org.jetbrains.annotations.NotNull android.view.View r5, boolean r6, @org.jetbrains.annotations.NotNull com.avito.android.user_adverts.items_search.SearchBarInteractor r7, @org.jetbrains.annotations.NotNull com.avito.android.analytics.Analytics r8) {
        /*
            r4 = this;
            java.lang.String r0 = "rootView"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "interactor"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "analytics"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            r4.<init>()
            r4.e = r7
            r4.f = r8
            int r7 = com.avito.android.user_adverts.R.id.adverts_search
            android.view.View r7 = r5.findViewById(r7)
            java.lang.String r8 = "rootView.findViewById(R.id.adverts_search)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r8)
            com.avito.android.lib.design.input.Input r7 = (com.avito.android.lib.design.input.Input) r7
            r4.a = r7
            int r8 = com.avito.android.user_adverts.R.id.search_adverts_suggests
            android.view.View r5 = r5.findViewById(r8)
            java.lang.String r8 = "rootView.findViewById(R.….search_adverts_suggests)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r8)
            androidx.recyclerview.widget.RecyclerView r5 = (androidx.recyclerview.widget.RecyclerView) r5
            r4.b = r5
            io.reactivex.disposables.CompositeDisposable r8 = new io.reactivex.disposables.CompositeDisposable
            r8.<init>()
            r4.d = r8
            a2.a.a.i3.b.g r0 = new a2.a.a.i3.b.g
            r0.<init>(r4)
            r7.setOnEditorActionListener(r0)
            com.jakewharton.rxbinding3.InitialValueObservable r0 = com.avito.android.lib.design.input.InputExtensionsKt.textChanges(r7)
            io.reactivex.Observable r0 = r0.skipInitialValue()
            java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.MILLISECONDS
            r2 = 500(0x1f4, double:2.47E-321)
            io.reactivex.Observable r0 = r0.debounce(r2, r1)
            a2.a.a.i3.b.k r1 = new a2.a.a.i3.b.k
            r1.<init>(r4)
            io.reactivex.Observable r0 = r0.filter(r1)
            a2.a.a.i3.b.l r1 = a2.a.a.i3.b.l.a
            if (r1 == 0) goto L_0x0066
            a2.a.a.i3.b.m r2 = new a2.a.a.i3.b.m
            r2.<init>(r1)
            r1 = r2
        L_0x0066:
            io.reactivex.functions.Function r1 = (io.reactivex.functions.Function) r1
            io.reactivex.Observable r0 = r0.map(r1)
            java.lang.String r1 = "searchInput.textChanges(…p(CharSequence::toString)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            a2.a.a.i3.b.h r1 = new a2.a.a.i3.b.h
            r1.<init>(r4)
            a2.a.a.i3.b.i r2 = a2.a.a.i3.b.i.a
            io.reactivex.disposables.Disposable r0 = r0.subscribe(r1, r2)
            java.lang.String r1 = "queryStream()\n          …dle search query\", it) })"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            io.reactivex.rxkotlin.DisposableKt.plusAssign(r8, r0)
            a2.a.a.i3.b.j r8 = new a2.a.a.i3.b.j
            r8.<init>(r4)
            r7.setFocusChangeListener(r8)
            if (r6 == 0) goto L_0x0092
            r7.showKeyboard()
            goto L_0x0095
        L_0x0092:
            r4.a()
        L_0x0095:
            androidx.recyclerview.widget.LinearLayoutManager r6 = new androidx.recyclerview.widget.LinearLayoutManager
            android.content.Context r7 = r5.getContext()
            r6.<init>(r7)
            r5.setLayoutManager(r6)
            com.avito.android.user_adverts.items_search.SearchBarImpl$initSuggests$1 r6 = new com.avito.android.user_adverts.items_search.SearchBarImpl$initSuggests$1
            r6.<init>()
            r5.addOnScrollListener(r6)
            com.avito.android.user_adverts.items_search.advert_list.suggests.SuggestItemPresenter r6 = new com.avito.android.user_adverts.items_search.advert_list.suggests.SuggestItemPresenter
            r6.<init>(r4)
            com.avito.android.user_adverts.items_search.advert_list.suggests.SuggestItemBlueprint r7 = new com.avito.android.user_adverts.items_search.advert_list.suggests.SuggestItemBlueprint
            r7.<init>(r6)
            com.avito.konveyor.ItemBinder$Builder r6 = new com.avito.konveyor.ItemBinder$Builder
            r6.<init>()
            com.avito.konveyor.ItemBinder$Builder r6 = r6.registerItem(r7)
            com.avito.konveyor.ItemBinder r6 = r6.build()
            com.avito.konveyor.adapter.SimpleAdapterPresenter r7 = new com.avito.konveyor.adapter.SimpleAdapterPresenter
            r7.<init>(r6, r6)
            r4.c = r7
            com.avito.konveyor.adapter.SimpleRecyclerAdapter r8 = new com.avito.konveyor.adapter.SimpleRecyclerAdapter
            r8.<init>(r7, r6)
            r5.setAdapter(r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.user_adverts.items_search.SearchBarImpl.<init>(android.view.View, boolean, com.avito.android.user_adverts.items_search.SearchBarInteractor, com.avito.android.analytics.Analytics):void");
    }

    public static final void access$initSearch(SearchBarImpl searchBarImpl, String str) {
        searchBarImpl.a();
        searchBarImpl.e.search(str);
    }

    public static final void access$openSearch(SearchBarImpl searchBarImpl) {
        searchBarImpl.a.showKeyboard();
        Views.show(searchBarImpl.b);
    }

    public final void a() {
        Keyboards.hideKeyboard$default(this.a, false, 1, null);
        Views.hide(this.b);
    }

    @Override // com.avito.android.user_adverts.items_search.SearchBar
    public void onDestroyView() {
        this.d.dispose();
        a();
    }

    @Override // com.avito.android.user_adverts.items_search.SuggestItemListener
    public void onSuggestClicked(@NotNull String str, int i) {
        Intrinsics.checkNotNullParameter(str, SocialButtonClickedEventKt.SUGGEST);
        this.f.track(new ProfileItemsSuggestsSelectEvent(i + 1, str, String.valueOf(this.a.m90getText())));
        Input.setText$default(this.a, str, false, 2, null);
        showSuggests(CollectionsKt__CollectionsKt.emptyList());
        a();
        this.e.search(str);
    }

    @Override // com.avito.android.user_adverts.items_search.SearchBar
    public void showSuggests(@NotNull List<SuggestItem> list) {
        Intrinsics.checkNotNullParameter(list, "items");
        AdapterPresenter adapterPresenter = this.c;
        if (adapterPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
        }
        a.s1(list, adapterPresenter);
        RecyclerView.Adapter adapter = this.b.getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }
}
