package com.avito.android.search.map;

import android.view.View;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.Features;
import com.avito.android.search.map.view.PinAdvertsView;
import com.avito.android.search.map.view.SerpListView;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J5\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H&¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/avito/android/search/map/SearchMapViewFactory;", "", "Landroid/view/View;", "view", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "Lio/reactivex/rxjava3/core/Observable;", "", "backClickObservable", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/search/map/SearchMapView;", "createView", "(Landroid/view/View;Landroidx/fragment/app/FragmentManager;Lio/reactivex/rxjava3/core/Observable;Lcom/avito/android/Features;)Lcom/avito/android/search/map/SearchMapView;", "Lcom/avito/android/search/map/view/PinAdvertsView;", "createPinAdvertsView", "(Landroid/view/View;)Lcom/avito/android/search/map/view/PinAdvertsView;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "fpsListener", "Lcom/avito/android/search/map/view/SerpListView;", "createSerpListView", "(Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;)Lcom/avito/android/search/map/view/SerpListView;", "map_release"}, k = 1, mv = {1, 4, 2})
public interface SearchMapViewFactory {
    @NotNull
    PinAdvertsView createPinAdvertsView(@NotNull View view);

    @NotNull
    SerpListView createSerpListView(@NotNull View view, @NotNull RecyclerView.OnScrollListener onScrollListener);

    @NotNull
    SearchMapView createView(@NotNull View view, @NotNull FragmentManager fragmentManager, @NotNull Observable<Unit> observable, @NotNull Features features);
}
