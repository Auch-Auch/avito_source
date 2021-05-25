package com.avito.android.public_profile;

import a2.g.r.g;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.serp.adapter.SpannedGridPositionProvider;
import com.avito.android.ui.adapter.AppendingListener;
import com.avito.android.ui.adapter.GridLayoutAppendingAdapter;
import com.avito.android.ui.adapter.GridLayoutNoLoaderAppendingHandler;
import com.avito.android.ui_components.R;
import com.avito.android.util.Views;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.avito.konveyor.blueprint.ViewHolderBuilder;
import com.vk.sdk.api.VKApiConst;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010 \u001a\u00020\u001d\u0012\u0006\u0010$\u001a\u00020!\u0012\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u00100\u001a\u00020/¢\u0006\u0004\b1\u00102J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0013\u0010\rR\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001c\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010*\u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010\u001fR\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-¨\u00063"}, d2 = {"Lcom/avito/android/public_profile/ProfileAdvertsViewImpl;", "Lcom/avito/android/public_profile/ProfileAdvertsView;", "", "showProgress", "()V", "showAdverts", "Lcom/avito/android/ui/adapter/AppendingListener;", "appendingListener", "onDataChanged", "(Lcom/avito/android/ui/adapter/AppendingListener;)V", "", VKApiConst.POSITION, "notifyItemAtPositionChanged", "(I)V", "", "error", "showError", "(Ljava/lang/String;)V", "count", "setColumnsCount", "Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;", g.a, "Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;", "gridPositionProvider", "Lcom/avito/konveyor/blueprint/ViewHolderBuilder;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "f", "Lcom/avito/konveyor/blueprint/ViewHolderBuilder;", "viewHolderBuilder", "Landroid/view/View;", "d", "Landroid/view/View;", "view", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "e", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Landroidx/recyclerview/widget/RecyclerView;", AuthSource.BOOKING_ORDER, "Landroidx/recyclerview/widget/RecyclerView;", "recycler", AuthSource.SEND_ABUSE, "progress", "Landroidx/recyclerview/widget/GridLayoutManager;", "c", "Landroidx/recyclerview/widget/GridLayoutManager;", "layoutManager", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "spanSizeLookup", "<init>", "(Landroid/view/View;Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/konveyor/blueprint/ViewHolderBuilder;Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;)V", "public-profile_release"}, k = 1, mv = {1, 4, 2})
public final class ProfileAdvertsViewImpl implements ProfileAdvertsView {
    public final View a;
    public final RecyclerView b;
    public final GridLayoutManager c;
    public final View d;
    public final AdapterPresenter e;
    public final ViewHolderBuilder<BaseViewHolder> f;
    public final SpannedGridPositionProvider g;

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.avito.konveyor.blueprint.ViewHolderBuilder<? extends com.avito.konveyor.adapter.BaseViewHolder> */
    /* JADX WARN: Multi-variable type inference failed */
    public ProfileAdvertsViewImpl(@NotNull View view, @NotNull AdapterPresenter adapterPresenter, @NotNull ViewHolderBuilder<? extends BaseViewHolder> viewHolderBuilder, @NotNull SpannedGridPositionProvider spannedGridPositionProvider, @NotNull GridLayoutManager.SpanSizeLookup spanSizeLookup) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(viewHolderBuilder, "viewHolderBuilder");
        Intrinsics.checkNotNullParameter(spannedGridPositionProvider, "gridPositionProvider");
        Intrinsics.checkNotNullParameter(spanSizeLookup, "spanSizeLookup");
        this.d = view;
        this.e = adapterPresenter;
        this.f = viewHolderBuilder;
        this.g = spannedGridPositionProvider;
        View findViewById = view.findViewById(R.id.progress_bar);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.View");
        this.a = findViewById;
        View findViewById2 = view.findViewById(R.id.recycler);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        RecyclerView recyclerView = (RecyclerView) findViewById2;
        this.b = recyclerView;
        GridLayoutManager gridLayoutManager = new GridLayoutManager(view.getContext(), view.getResources().getInteger(R.integer.profile_adverts_columns), 1, false);
        this.c = gridLayoutManager;
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setItemAnimator(null);
        gridLayoutManager.setSpanSizeLookup(spanSizeLookup);
    }

    @Override // com.avito.android.favorite.FavoriteAdvertsView, com.avito.android.advert.viewed.ViewedAdvertsView
    public void notifyItemAtPositionChanged(int i) {
        RecyclerView.Adapter adapter = this.b.getAdapter();
        if (adapter != null) {
            adapter.notifyItemChanged(i);
        }
    }

    @Override // com.avito.android.public_profile.ProfileAdvertsView
    public void onDataChanged(@NotNull AppendingListener appendingListener) {
        Intrinsics.checkNotNullParameter(appendingListener, "appendingListener");
        if (this.b.getAdapter() == null) {
            SimpleRecyclerAdapter simpleRecyclerAdapter = new SimpleRecyclerAdapter(this.e, this.f);
            GridLayoutNoLoaderAppendingHandler gridLayoutNoLoaderAppendingHandler = new GridLayoutNoLoaderAppendingHandler(this.g, false, 2, null);
            gridLayoutNoLoaderAppendingHandler.setAppendingListener(appendingListener);
            GridLayoutAppendingAdapter gridLayoutAppendingAdapter = new GridLayoutAppendingAdapter(simpleRecyclerAdapter, gridLayoutNoLoaderAppendingHandler);
            gridLayoutAppendingAdapter.setHasStableIds(true);
            this.b.setAdapter(gridLayoutAppendingAdapter);
            return;
        }
        RecyclerView.Adapter adapter = this.b.getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }

    @Override // com.avito.android.public_profile.ProfileAdvertsView
    public void setColumnsCount(int i) {
        this.c.setSpanCount(i);
    }

    @Override // com.avito.android.public_profile.ProfileAdvertsView
    public void showAdverts() {
        Views.show(this.b);
        Views.hide(this.a);
    }

    @Override // com.avito.android.public_profile.ProfileAdvertsView, com.avito.android.legacy_mvp.ErrorMessageView
    public void showError(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "error");
        Views.showSnackBar$default(this.d, str, 0, (String) null, 0, (Function0) null, (Function0) null, 0, 126, (Object) null);
    }

    @Override // com.avito.android.public_profile.ProfileAdvertsView
    public void showProgress() {
        Views.hide(this.b);
        Views.show(this.a);
    }
}
