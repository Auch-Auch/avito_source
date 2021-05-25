package com.avito.android.auto_catalog;

import com.avito.android.advert.viewed.ViewedAdvertsView;
import com.avito.android.favorite.FavoriteAdvertsView;
import com.avito.android.serp.adapter.SpannedItem;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u00012\u00020\u0002J\u000f\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H&¢\u0006\u0004\b\u0006\u0010\u0005J\u0017\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bH&¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bH&¢\u0006\u0004\b\u000e\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u0003H&¢\u0006\u0004\b\u000f\u0010\u0005J\u001d\u0010\u0013\u001a\u00020\u00032\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H&¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/avito/android/auto_catalog/AutoCatalogView;", "Lcom/avito/android/favorite/FavoriteAdvertsView;", "Lcom/avito/android/advert/viewed/ViewedAdvertsView;", "", "attach", "()V", "detach", "", "isSharingEnabled", "setupToolbar", "(Z)V", "Lio/reactivex/Observable;", "upButtonClicks", "()Lio/reactivex/Observable;", "shareButtonClicks", "showError", "", "Lcom/avito/android/serp/adapter/SpannedItem;", "items", "bindItems", "(Ljava/util/List;)V", "auto-catalog_release"}, k = 1, mv = {1, 4, 2})
public interface AutoCatalogView extends FavoriteAdvertsView, ViewedAdvertsView {
    void attach();

    void bindItems(@NotNull List<? extends SpannedItem> list);

    void detach();

    void setupToolbar(boolean z);

    @NotNull
    Observable<Unit> shareButtonClicks();

    void showError();

    @NotNull
    Observable<Unit> upButtonClicks();
}
