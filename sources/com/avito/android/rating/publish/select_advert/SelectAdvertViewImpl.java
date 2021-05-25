package com.avito.android.rating.publish.select_advert;

import a2.g.r.g;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.lib.design.input.Input;
import com.avito.android.rating.R;
import com.avito.android.rating.publish.select_advert.SelectAdvertView;
import com.avito.android.recycler.responsive.ResponsiveAdapterPresenter;
import com.avito.android.recycler.responsive.ResponsiveRecyclerAdapter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui.PaddingListDecoration;
import com.avito.android.util.Keyboards;
import com.avito.android.util.Toolbars;
import com.avito.android.util.Views;
import com.avito.konveyor.ItemBinder;
import com.jakewharton.rxbinding4.view.RxView;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.Observable;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u00100\u001a\u00020/\u0012\u0006\u00102\u001a\u000201\u0012\u0006\u00104\u001a\u000203¢\u0006\u0004\b5\u00106J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0005J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0005J\u000f\u0010\t\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0010\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0016\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001c\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u0019R\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010*\u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010\u001fR\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-¨\u00067"}, d2 = {"Lcom/avito/android/rating/publish/select_advert/SelectAdvertViewImpl;", "Lcom/avito/android/rating/publish/select_advert/SelectAdvertView;", "Lio/reactivex/rxjava3/core/Observable;", "", "navigationClicks", "()Lio/reactivex/rxjava3/core/Observable;", "", "queryStream", "searchButtonClicks", "notifyItemsChanged", "()V", "", VKApiConst.POSITION, "scrollToPosition", "(I)V", "query", "setQuery", "(Ljava/lang/String;)V", "", "show", "showSearchInputState", "(Z)V", "showEmptyState", "Lcom/avito/android/lib/design/input/Input;", "e", "Lcom/avito/android/lib/design/input/Input;", "searchInputButton", "d", "searchInput", "Landroid/widget/TextView;", g.a, "Landroid/widget/TextView;", "emptyText", "Landroidx/recyclerview/widget/RecyclerView;", AuthSource.SEND_ABUSE, "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "Landroidx/appcompat/widget/Toolbar;", AuthSource.BOOKING_ORDER, "Landroidx/appcompat/widget/Toolbar;", "toolbar", "f", "title", "Lcom/avito/android/recycler/responsive/ResponsiveRecyclerAdapter;", "c", "Lcom/avito/android/recycler/responsive/ResponsiveRecyclerAdapter;", "adapter", "Landroid/view/View;", "view", "Lcom/avito/android/recycler/responsive/ResponsiveAdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "<init>", "(Landroid/view/View;Lcom/avito/android/recycler/responsive/ResponsiveAdapterPresenter;Lcom/avito/konveyor/ItemBinder;)V", "rating_release"}, k = 1, mv = {1, 4, 2})
public final class SelectAdvertViewImpl implements SelectAdvertView {
    public final RecyclerView a;
    public final Toolbar b;
    public final ResponsiveRecyclerAdapter c;
    public final Input d;
    public final Input e;
    public final TextView f;
    public final TextView g;

    public SelectAdvertViewImpl(@NotNull View view, @NotNull ResponsiveAdapterPresenter responsiveAdapterPresenter, @NotNull ItemBinder itemBinder) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(responsiveAdapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(itemBinder, "itemBinder");
        View findViewById = view.findViewById(R.id.recycler);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        RecyclerView recyclerView = (RecyclerView) findViewById;
        this.a = recyclerView;
        View findViewById2 = view.findViewById(com.avito.android.deprecated_design.R.id.toolbar);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type androidx.appcompat.widget.Toolbar");
        Toolbar toolbar = (Toolbar) findViewById2;
        this.b = toolbar;
        ResponsiveRecyclerAdapter responsiveRecyclerAdapter = new ResponsiveRecyclerAdapter(responsiveAdapterPresenter, itemBinder);
        this.c = responsiveRecyclerAdapter;
        View findViewById3 = view.findViewById(R.id.search_input);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type com.avito.android.lib.design.input.Input");
        this.d = (Input) findViewById3;
        View findViewById4 = view.findViewById(R.id.search_input_button);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type com.avito.android.lib.design.input.Input");
        this.e = (Input) findViewById4;
        View findViewById5 = view.findViewById(R.id.title);
        Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type android.widget.TextView");
        this.f = (TextView) findViewById5;
        View findViewById6 = view.findViewById(R.id.empty_text_view);
        Objects.requireNonNull(findViewById6, "null cannot be cast to non-null type android.widget.TextView");
        this.g = (TextView) findViewById6;
        recyclerView.setAdapter(responsiveRecyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setItemAnimator(null);
        recyclerView.addItemDecoration(new PaddingListDecoration(a2.b.a.a.a.u1(view, "view.context").getDimensionPixelSize(com.avito.android.ui_components.R.dimen.list_top_padding)));
        Toolbars.setCloseIcon(toolbar);
    }

    @Override // com.avito.android.rating.publish.select_advert.SelectAdvertView
    @NotNull
    public Observable<Unit> navigationClicks() {
        return Toolbars.upClicks(this.b);
    }

    @Override // com.avito.android.rating.publish.select_advert.SelectAdvertView
    public void notifyItemsChanged() {
        this.c.notifyDataSetChanged();
    }

    @Override // com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        SelectAdvertView.DefaultImpls.onUnbind(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [a2.a.a.g2.b.l.f] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // com.avito.android.rating.publish.select_advert.SelectAdvertView
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public io.reactivex.rxjava3.core.Observable<java.lang.String> queryStream() {
        /*
            r4 = this;
            com.avito.android.lib.design.input.Input r0 = r4.d
            com.jakewharton.rxbinding3.InitialValueObservable r0 = com.avito.android.lib.design.input.InputExtensionsKt.textChanges(r0)
            io.reactivex.Observable r0 = r0.skipInitialValue()
            java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.MILLISECONDS
            r2 = 300(0x12c, double:1.48E-321)
            io.reactivex.Observable r0 = r0.debounce(r2, r1)
            com.avito.android.rating.publish.select_advert.SelectAdvertViewImpl$a r1 = com.avito.android.rating.publish.select_advert.SelectAdvertViewImpl.a.a
            if (r1 == 0) goto L_0x001c
            a2.a.a.g2.b.l.f r2 = new a2.a.a.g2.b.l.f
            r2.<init>(r1)
            r1 = r2
        L_0x001c:
            io.reactivex.functions.Function r1 = (io.reactivex.functions.Function) r1
            io.reactivex.Observable r0 = r0.map(r1)
            io.reactivex.Observable r0 = r0.distinctUntilChanged()
            java.lang.String r1 = "searchInput.textChanges(…  .distinctUntilChanged()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            io.reactivex.rxjava3.core.Observable r0 = com.avito.android.util.rx3.InteropKt.toV3(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.rating.publish.select_advert.SelectAdvertViewImpl.queryStream():io.reactivex.rxjava3.core.Observable");
    }

    @Override // com.avito.android.rating.publish.select_advert.SelectAdvertView
    public void scrollToPosition(int i) {
        this.a.smoothScrollToPosition(i);
    }

    @Override // com.avito.android.rating.publish.select_advert.SelectAdvertView
    @NotNull
    public Observable<Unit> searchButtonClicks() {
        return RxView.clicks(this.e);
    }

    @Override // com.avito.android.rating.publish.select_advert.SelectAdvertView
    public void setQuery(@Nullable String str) {
        Input.setText$default(this.d, str, false, 2, null);
    }

    @Override // com.avito.android.rating.publish.select_advert.SelectAdvertView
    public void showEmptyState(boolean z) {
        Views.setVisible(this.g, z);
    }

    @Override // com.avito.android.rating.publish.select_advert.SelectAdvertView
    public void showSearchInputState(boolean z) {
        if (z) {
            Views.hide(this.f);
            Views.hide(this.e);
            Toolbars.setBackIconByAttr(this.b, com.avito.android.lib.design.R.attr.blue);
            Views.show(this.d);
            this.d.showKeyboard();
            return;
        }
        Views.hide(this.d);
        Keyboards.hideKeyboard$default(this.d, false, 1, null);
        Toolbars.setCloseIcon(this.b);
        Views.show(this.f);
        Views.show(this.e);
    }
}
