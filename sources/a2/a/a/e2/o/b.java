package a2.a.a.e2.o;

import androidx.lifecycle.Observer;
import com.avito.android.progress_overlay.LoadingOverlay;
import com.avito.android.progress_overlay.ProgressOverlay;
import com.avito.android.publish.category_suggest.CategoriesSuggestionsFragment;
import com.avito.android.util.loading_state.LoadingProgress;
import com.avito.conveyor_item.Item;
import com.avito.konveyor.util.AdapterPresentersKt;
import java.util.Collection;
import java.util.List;
import t6.n.d;
public final class b<T> implements Observer<LoadingProgress<? super List<? extends Item>>> {
    public final /* synthetic */ CategoriesSuggestionsFragment a;

    public b(CategoriesSuggestionsFragment categoriesSuggestionsFragment) {
        this.a = categoriesSuggestionsFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(LoadingProgress<? super List<? extends Item>> loadingProgress) {
        ProgressOverlay progressOverlay;
        LoadingProgress<? super List<? extends Item>> loadingProgress2 = loadingProgress;
        if (loadingProgress2 instanceof LoadingProgress.Loaded) {
            ProgressOverlay progressOverlay2 = this.a.d;
            if (progressOverlay2 != null) {
                progressOverlay2.showContent();
            }
            LoadingProgress.Loaded loaded = (LoadingProgress.Loaded) loadingProgress2;
            if (!((Collection) loaded.getData()).isEmpty()) {
                AdapterPresentersKt.updateItems(this.a.getAdapterPresenter(), (List) loaded.getData());
                CategoriesSuggestionsFragment.access$addDividerItemDecoration(this.a, d.listOf(Integer.valueOf(((List) loaded.getData()).size() - 2)));
                this.a.getAdapter().notifyDataSetChanged();
            }
        } else if (loadingProgress2 instanceof LoadingProgress.Loading) {
            ProgressOverlay progressOverlay3 = this.a.d;
            if (progressOverlay3 != null) {
                progressOverlay3.showLoading();
            }
        } else if ((loadingProgress2 instanceof LoadingProgress.Error) && (progressOverlay = this.a.d) != null) {
            LoadingOverlay.DefaultImpls.showLoadingProblem$default(progressOverlay, null, 1, null);
        }
    }
}
