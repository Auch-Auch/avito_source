package com.avito.android.inline_filters;

import com.avito.android.component.search.SearchBar;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.inline_filters.dialog.InlineFilterDialogOpener;
import com.avito.android.remote.model.SearchParams;
import com.avito.android.remote.model.search.InlineFilters;
import com.avito.android.util.Kundle;
import com.avito.android.util.UrlParams;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.shortcut_navigation_bar.ShortcutNavigationBar;
import ru.avito.component.shortcut_navigation_bar.adapter.InlineFilterNavigationItem;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\u001b\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H&¢\u0006\u0004\b\u000b\u0010\fJ)\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u000fH&¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0007H&¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0007H&¢\u0006\u0004\b\u0016\u0010\u0014J\u0015\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0007H&¢\u0006\u0004\b\u0018\u0010\u0014J\u000f\u0010\u0019\u001a\u00020\u0004H&¢\u0006\u0004\b\u0019\u0010\fJ'\u0010 \u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001eH&¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u0004H&¢\u0006\u0004\b\"\u0010\fJ\u000f\u0010$\u001a\u00020#H&¢\u0006\u0004\b$\u0010%R\u001e\u0010*\u001a\u0004\u0018\u00010\b8&@&X¦\u000e¢\u0006\f\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)¨\u0006+"}, d2 = {"Lcom/avito/android/inline_filters/InlineFiltersPresenter;", "", "Lcom/avito/android/remote/model/SearchParams;", "searchParams", "", "loadInlineFilters", "(Lcom/avito/android/remote/model/SearchParams;)V", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/search/InlineFilters;", "loadInlineFiltersObservable", "(Lcom/avito/android/remote/model/SearchParams;)Lio/reactivex/rxjava3/core/Observable;", "showInlineFilters", "()V", "Lru/avito/component/shortcut_navigation_bar/adapter/InlineFilterNavigationItem;", "item", "", UrlParams.SIMPLE_MAP, "openInlineFilter", "(Lru/avito/component/shortcut_navigation_bar/adapter/InlineFilterNavigationItem;Lcom/avito/android/remote/model/SearchParams;Z)V", "inlineFiltersLoaded", "()Lio/reactivex/rxjava3/core/Observable;", "", "errors", "Lcom/avito/android/deep_linking/links/DeepLink;", "inlineFilterSelected", "invalidate", "Lru/avito/component/shortcut_navigation_bar/ShortcutNavigationBar;", "shortcutNavigationBar", "Lcom/avito/android/inline_filters/dialog/InlineFilterDialogOpener;", "inlineFilterDialogOpener", "Lcom/avito/android/component/search/SearchBar;", "searchBar", "attachViews", "(Lru/avito/component/shortcut_navigation_bar/ShortcutNavigationBar;Lcom/avito/android/inline_filters/dialog/InlineFilterDialogOpener;Lcom/avito/android/component/search/SearchBar;)V", "detachViews", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "getInlineFilters", "()Lcom/avito/android/remote/model/search/InlineFilters;", "setInlineFilters", "(Lcom/avito/android/remote/model/search/InlineFilters;)V", "inlineFilters", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public interface InlineFiltersPresenter {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ void loadInlineFilters$default(InlineFiltersPresenter inlineFiltersPresenter, SearchParams searchParams, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    searchParams = null;
                }
                inlineFiltersPresenter.loadInlineFilters(searchParams);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadInlineFilters");
        }

        public static /* synthetic */ Observable loadInlineFiltersObservable$default(InlineFiltersPresenter inlineFiltersPresenter, SearchParams searchParams, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    searchParams = null;
                }
                return inlineFiltersPresenter.loadInlineFiltersObservable(searchParams);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadInlineFiltersObservable");
        }

        public static /* synthetic */ void openInlineFilter$default(InlineFiltersPresenter inlineFiltersPresenter, InlineFilterNavigationItem inlineFilterNavigationItem, SearchParams searchParams, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    z = false;
                }
                inlineFiltersPresenter.openInlineFilter(inlineFilterNavigationItem, searchParams, z);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openInlineFilter");
        }
    }

    void attachViews(@NotNull ShortcutNavigationBar shortcutNavigationBar, @NotNull InlineFilterDialogOpener inlineFilterDialogOpener, @NotNull SearchBar searchBar);

    void detachViews();

    @NotNull
    Observable<Throwable> errors();

    @Nullable
    InlineFilters getInlineFilters();

    @NotNull
    Observable<DeepLink> inlineFilterSelected();

    @NotNull
    Observable<Boolean> inlineFiltersLoaded();

    void invalidate();

    void loadInlineFilters(@Nullable SearchParams searchParams);

    @NotNull
    Observable<InlineFilters> loadInlineFiltersObservable(@Nullable SearchParams searchParams);

    @NotNull
    Kundle onSaveState();

    void openInlineFilter(@NotNull InlineFilterNavigationItem inlineFilterNavigationItem, @NotNull SearchParams searchParams, boolean z);

    void setInlineFilters(@Nullable InlineFilters inlineFilters);

    void showInlineFilters();
}
