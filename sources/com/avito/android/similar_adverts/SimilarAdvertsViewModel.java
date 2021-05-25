package com.avito.android.similar_adverts;

import android.content.Intent;
import androidx.lifecycle.LiveData;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.section.SectionRouter;
import com.avito.android.serp.adapter.AdvertItemListener;
import com.avito.android.serp.adapter.SpannedItem;
import com.avito.konveyor.data_source.ListDataSource;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u00012\u00020\u0002J\u000f\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0004\u0010\u0005R\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\tR\"\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\tR\u001e\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\tR\u001e\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/avito/android/similar_adverts/SimilarAdvertsViewModel;", "Lcom/avito/android/serp/adapter/AdvertItemListener;", "Lcom/avito/android/section/SectionRouter;", "", "updateSimilarAdvertItems", "()V", "Landroidx/lifecycle/LiveData;", "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeepLinks", "()Landroidx/lifecycle/LiveData;", "deepLinks", "Landroid/content/Intent;", "getIntents", "intents", "Lcom/avito/konveyor/data_source/ListDataSource;", "Lcom/avito/android/serp/adapter/SpannedItem;", "getSimilarAdvertItems", "similarAdvertItems", "getShowContentChanges", "showContentChanges", "Ljava/lang/Runnable;", "getErrorChanges", "errorChanges", "similar-adverts_release"}, k = 1, mv = {1, 4, 2})
public interface SimilarAdvertsViewModel extends AdvertItemListener, SectionRouter {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onMoreActionsClicked(@NotNull SimilarAdvertsViewModel similarAdvertsViewModel, @NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "itemId");
            AdvertItemListener.DefaultImpls.onMoreActionsClicked(similarAdvertsViewModel, str);
        }
    }

    @NotNull
    LiveData<DeepLink> getDeepLinks();

    @NotNull
    LiveData<Runnable> getErrorChanges();

    @NotNull
    LiveData<Intent> getIntents();

    @NotNull
    LiveData<Unit> getShowContentChanges();

    @NotNull
    LiveData<ListDataSource<SpannedItem>> getSimilarAdvertItems();

    void updateSimilarAdvertItems();
}
