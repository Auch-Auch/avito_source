package com.avito.android.similar_adverts;

import com.avito.android.favorite.FavoriteAdvertsView;
import com.avito.android.ui.adapter.AppendingListener;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b`\u0018\u00002\u00020\u00012\u00020\u0002J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\b\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/avito/android/similar_adverts/SimilarAdvertsView;", "Lcom/avito/android/favorite/FavoriteAdvertsView;", "Lcom/avito/android/ui/adapter/AppendingListener;", "Lcom/avito/android/similar_adverts/SimilarAdvertsViewModel;", "viewModel", "", "bindTo", "(Lcom/avito/android/similar_adverts/SimilarAdvertsViewModel;)V", "onDestroyView", "similar-adverts_release"}, k = 1, mv = {1, 4, 2})
public interface SimilarAdvertsView extends FavoriteAdvertsView, AppendingListener {
    void bindTo(@NotNull SimilarAdvertsViewModel similarAdvertsViewModel);

    void onDestroyView(@NotNull SimilarAdvertsViewModel similarAdvertsViewModel);
}
