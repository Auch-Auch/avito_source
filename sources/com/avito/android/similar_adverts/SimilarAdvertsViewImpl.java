package com.avito.android.similar_adverts;

import a2.g.r.g;
import android.content.Intent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.favorite.FavoriteAdvertsPresenter;
import com.avito.android.progress_overlay.LoadingOverlay;
import com.avito.android.progress_overlay.ProgressOverlay;
import com.avito.android.recycler.data_aware.DataAwareAdapterPresenter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.serp.adapter.SerpSpanProvider;
import com.avito.android.serp.adapter.SpannedItem;
import com.avito.android.util.ViewSizeKt;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.avito.konveyor.data_source.ListDataSource;
import com.vk.sdk.api.VKApiConst;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u0012\u0006\u0010 \u001a\u00020\u001d\u0012\u0006\u0010$\u001a\u00020!\u0012\u0006\u00104\u001a\u000201\u0012\u0006\u00100\u001a\u00020-\u0012\u0006\u0010(\u001a\u00020%\u0012\u0006\u00106\u001a\u000205\u0012\u0006\u00108\u001a\u000207\u0012\f\u0010;\u001a\b\u0012\u0004\u0012\u00020:09¢\u0006\u0004\b<\u0010=J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b2\u00103¨\u0006>"}, d2 = {"Lcom/avito/android/similar_adverts/SimilarAdvertsViewImpl;", "Lcom/avito/android/similar_adverts/SimilarAdvertsView;", "Lcom/avito/android/similar_adverts/SimilarAdvertsViewModel;", "viewModel", "", "bindTo", "(Lcom/avito/android/similar_adverts/SimilarAdvertsViewModel;)V", "onDestroyView", "", VKApiConst.POSITION, "notifyItemAtPositionChanged", "(I)V", "onAppend", "()V", "", "canAppend", "()Z", "Landroid/widget/FrameLayout;", AuthSource.SEND_ABUSE, "Landroid/widget/FrameLayout;", "contentHolder", "Lcom/avito/android/progress_overlay/ProgressOverlay;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/progress_overlay/ProgressOverlay;", "progressOverlay", "Landroid/view/View;", "d", "Landroid/view/View;", "view", "Landroidx/lifecycle/LifecycleOwner;", "e", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "f", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "Lcom/avito/android/serp/adapter/SerpSpanProvider;", "i", "Lcom/avito/android/serp/adapter/SerpSpanProvider;", "serpSpanProvider", "Landroidx/recyclerview/widget/RecyclerView;", "c", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lcom/avito/android/favorite/FavoriteAdvertsPresenter;", "h", "Lcom/avito/android/favorite/FavoriteAdvertsPresenter;", "favoriteAdvertsPresenter", "Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;", g.a, "Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;", "adapterPresenter", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "spanSizeLookup", "Lcom/avito/android/similar_adverts/SimilarAdvertsResourceProvider;", "resourceProvider", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "adapter", "<init>", "(Landroid/view/View;Landroidx/lifecycle/LifecycleOwner;Lcom/avito/android/deep_linking/DeepLinkIntentFactory;Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;Lcom/avito/android/favorite/FavoriteAdvertsPresenter;Lcom/avito/android/serp/adapter/SerpSpanProvider;Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;Lcom/avito/android/similar_adverts/SimilarAdvertsResourceProvider;Landroidx/recyclerview/widget/RecyclerView$Adapter;)V", "similar-adverts_release"}, k = 1, mv = {1, 4, 2})
public final class SimilarAdvertsViewImpl implements SimilarAdvertsView {
    public final FrameLayout a;
    public final ProgressOverlay b;
    public final RecyclerView c;
    public final View d;
    public final LifecycleOwner e;
    public final DeepLinkIntentFactory f;
    public final DataAwareAdapterPresenter g;
    public final FavoriteAdvertsPresenter h;
    public final SerpSpanProvider i;

    public static final class a<T> implements Observer<DeepLink> {
        public final /* synthetic */ SimilarAdvertsViewImpl a;

        public a(SimilarAdvertsViewImpl similarAdvertsViewImpl) {
            this.a = similarAdvertsViewImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // androidx.lifecycle.Observer
        public void onChanged(DeepLink deepLink) {
            DeepLink deepLink2 = deepLink;
            DeepLinkIntentFactory deepLinkIntentFactory = this.a.f;
            Intrinsics.checkNotNullExpressionValue(deepLink2, "link");
            Intent intent = deepLinkIntentFactory.getIntent(deepLink2);
            if (intent != null) {
                this.a.d.getContext().startActivity(intent);
            }
        }
    }

    public static final class b<T> implements Observer<Intent> {
        public final /* synthetic */ SimilarAdvertsViewImpl a;

        public b(SimilarAdvertsViewImpl similarAdvertsViewImpl) {
            this.a = similarAdvertsViewImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // androidx.lifecycle.Observer
        public void onChanged(Intent intent) {
            this.a.d.getContext().startActivity(intent);
        }
    }

    public static final class c<T> implements Observer<Unit> {
        public final /* synthetic */ SimilarAdvertsViewImpl a;

        public c(SimilarAdvertsViewImpl similarAdvertsViewImpl) {
            this.a = similarAdvertsViewImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // androidx.lifecycle.Observer
        public void onChanged(Unit unit) {
            if (unit != null) {
                this.a.b.showContent();
            }
        }
    }

    public static final class d<T> implements Observer<Runnable> {
        public final /* synthetic */ SimilarAdvertsViewImpl a;

        public d(SimilarAdvertsViewImpl similarAdvertsViewImpl) {
            this.a = similarAdvertsViewImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // androidx.lifecycle.Observer
        public void onChanged(Runnable runnable) {
            Runnable runnable2 = runnable;
            if (runnable2 != null) {
                LoadingOverlay.DefaultImpls.showLoadingProblem$default(this.a.b, null, 1, null);
                this.a.b.setOnRefreshListener(new a2.a.a.w2.a(runnable2));
            }
        }
    }

    public static final class e<T> implements Observer<ListDataSource<SpannedItem>> {
        public final /* synthetic */ SimilarAdvertsViewImpl a;

        public e(SimilarAdvertsViewImpl similarAdvertsViewImpl) {
            this.a = similarAdvertsViewImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // androidx.lifecycle.Observer
        public void onChanged(ListDataSource<SpannedItem> listDataSource) {
            ListDataSource<SpannedItem> listDataSource2 = listDataSource;
            if (listDataSource2 != null) {
                SimilarAdvertsViewImpl.access$onDataSourceChanged(this.a, listDataSource2);
            }
        }
    }

    public SimilarAdvertsViewImpl(@NotNull View view, @NotNull LifecycleOwner lifecycleOwner, @NotNull DeepLinkIntentFactory deepLinkIntentFactory, @NotNull DataAwareAdapterPresenter dataAwareAdapterPresenter, @NotNull FavoriteAdvertsPresenter favoriteAdvertsPresenter, @NotNull SerpSpanProvider serpSpanProvider, @NotNull GridLayoutManager.SpanSizeLookup spanSizeLookup, @NotNull SimilarAdvertsResourceProvider similarAdvertsResourceProvider, @NotNull RecyclerView.Adapter<BaseViewHolder> adapter) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory, "deepLinkIntentFactory");
        Intrinsics.checkNotNullParameter(dataAwareAdapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(favoriteAdvertsPresenter, "favoriteAdvertsPresenter");
        Intrinsics.checkNotNullParameter(serpSpanProvider, "serpSpanProvider");
        Intrinsics.checkNotNullParameter(spanSizeLookup, "spanSizeLookup");
        Intrinsics.checkNotNullParameter(similarAdvertsResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        this.d = view;
        this.e = lifecycleOwner;
        this.f = deepLinkIntentFactory;
        this.g = dataAwareAdapterPresenter;
        this.h = favoriteAdvertsPresenter;
        this.i = serpSpanProvider;
        View findViewById = view.findViewById(R.id.content_holder);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.FrameLayout");
        FrameLayout frameLayout = (FrameLayout) findViewById;
        this.a = frameLayout;
        int i2 = R.id.similar_list;
        this.b = new ProgressOverlay(frameLayout, i2, null, false, 0, 28, null);
        View findViewById2 = view.findViewById(i2);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        RecyclerView recyclerView = (RecyclerView) findViewById2;
        this.c = recyclerView;
        GridLayoutManager gridLayoutManager = new GridLayoutManager(view.getContext(), similarAdvertsResourceProvider.getSimilarColumns());
        gridLayoutManager.setSpanSizeLookup(spanSizeLookup);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.addItemDecoration(new SimilarAdvertsItemDecoration(ViewSizeKt.getDp(16), ViewSizeKt.getDp(10), similarAdvertsResourceProvider.getSimilarColumns()));
        serpSpanProvider.setAppendingListener(this);
    }

    public static final void access$onDataSourceChanged(SimilarAdvertsViewImpl similarAdvertsViewImpl, ListDataSource listDataSource) {
        similarAdvertsViewImpl.i.onDataSourceChanged(listDataSource);
        similarAdvertsViewImpl.h.onDataSourceChanged(listDataSource);
        similarAdvertsViewImpl.g.onDataSourceChanged(listDataSource);
    }

    @Override // com.avito.android.similar_adverts.SimilarAdvertsView
    public void bindTo(@NotNull SimilarAdvertsViewModel similarAdvertsViewModel) {
        Intrinsics.checkNotNullParameter(similarAdvertsViewModel, "viewModel");
        similarAdvertsViewModel.getDeepLinks().observe(this.e, new a(this));
        similarAdvertsViewModel.getIntents().observe(this.e, new b(this));
        similarAdvertsViewModel.getShowContentChanges().observe(this.e, new c(this));
        similarAdvertsViewModel.getErrorChanges().observe(this.e, new d(this));
        similarAdvertsViewModel.getSimilarAdvertItems().observe(this.e, new e(this));
    }

    @Override // com.avito.android.ui.adapter.AppendingListener
    public boolean canAppend() {
        return false;
    }

    @Override // com.avito.android.favorite.FavoriteAdvertsView, com.avito.android.advert.viewed.ViewedAdvertsView
    public void notifyItemAtPositionChanged(int i2) {
        RecyclerView.Adapter adapter = this.c.getAdapter();
        if (adapter != null) {
            adapter.notifyItemChanged(i2);
        }
    }

    @Override // com.avito.android.ui.adapter.AppendingListener
    public void onAppend() {
    }

    @Override // com.avito.android.similar_adverts.SimilarAdvertsView
    public void onDestroyView(@NotNull SimilarAdvertsViewModel similarAdvertsViewModel) {
        Intrinsics.checkNotNullParameter(similarAdvertsViewModel, "viewModel");
        similarAdvertsViewModel.getDeepLinks().removeObservers(this.e);
        similarAdvertsViewModel.getIntents().removeObservers(this.e);
        similarAdvertsViewModel.getShowContentChanges().removeObservers(this.e);
        similarAdvertsViewModel.getErrorChanges().removeObservers(this.e);
        similarAdvertsViewModel.getSimilarAdvertItems().removeObservers(this.e);
    }
}
