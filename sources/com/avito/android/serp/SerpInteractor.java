package com.avito.android.serp;

import com.avito.android.remote.model.SerpDisplayType;
import com.avito.android.search.SearchViewInteractor;
import com.avito.android.serp.adapter.ViewTypeSerpItem;
import com.avito.android.serp.adapter.warning.SerpWarningItem;
import com.avito.android.util.Kundle;
import com.avito.android.util.LoadingState;
import io.reactivex.rxjava3.core.Observable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001JE\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH&¢\u0006\u0004\b\u000e\u0010\u000fJ1\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\bH&¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0013H&¢\u0006\u0004\b\u0016\u0010\u0017J+\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\t0\u000b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u001aH&¢\u0006\u0004\b\u001b\u0010\u001cJ\u0019\u0010\u001e\u001a\u00020\u00152\b\u0010\u001d\u001a\u0004\u0018\u00010\u001aH&¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0015H&¢\u0006\u0004\b \u0010!J-\u0010&\u001a\u00020\u00152\u0006\u0010#\u001a\u00020\"2\u0014\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\"\u0018\u00010$H&¢\u0006\u0004\b&\u0010'J-\u0010(\u001a\u00020\u00152\u0006\u0010#\u001a\u00020\"2\u0014\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\"\u0018\u00010$H&¢\u0006\u0004\b(\u0010'J-\u0010)\u001a\u00020\u00152\u0006\u0010#\u001a\u00020\"2\u0014\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\"\u0018\u00010$H&¢\u0006\u0004\b)\u0010'J-\u0010*\u001a\u00020\u00152\u0006\u0010#\u001a\u00020\"2\u0014\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\"\u0018\u00010$H&¢\u0006\u0004\b*\u0010'J\u000f\u0010,\u001a\u00020+H&¢\u0006\u0004\b,\u0010-R\u0016\u00101\u001a\u00020.8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b/\u00100¨\u00062"}, d2 = {"Lcom/avito/android/serp/SerpInteractor;", "Lcom/avito/android/search/SearchViewInteractor;", "Lcom/avito/android/serp/SerpParameters;", "serpParameters", "Lcom/avito/android/serp/SerpPageParams;", "pageParams", "Lcom/avito/android/remote/model/SerpDisplayType;", "displayType", "", "Lcom/avito/android/serp/adapter/ViewTypeSerpItem;", "notSortedItems", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/serp/Serp;", "loadSerp", "(Lcom/avito/android/serp/SerpParameters;Lcom/avito/android/serp/SerpPageParams;Lcom/avito/android/remote/model/SerpDisplayType;Ljava/util/List;)Lio/reactivex/rxjava3/core/Observable;", "items", "restoreSerp", "(Lcom/avito/android/remote/model/SerpDisplayType;Ljava/util/List;)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/serp/adapter/warning/SerpWarningItem;", "warning", "", "closeWarning", "(Lcom/avito/android/serp/adapter/warning/SerpWarningItem;)V", "loadAds", "(Ljava/util/List;Lcom/avito/android/remote/model/SerpDisplayType;)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "state", "restoreState", "(Lcom/avito/android/util/Kundle;)V", "invalidate", "()V", "", "id", "", "analytics", "sendSnippetActionClick", "(Ljava/lang/String;Ljava/util/Map;)V", "sendSnippetActionClose", "sendSnippetActionShow", "sendSnippetActionHide", "", "isEmptySearch", "()Z", "", "getPage", "()I", "page", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public interface SerpInteractor extends SearchViewInteractor {
    void closeWarning(@NotNull SerpWarningItem serpWarningItem);

    int getPage();

    void invalidate();

    boolean isEmptySearch();

    @NotNull
    Observable<ViewTypeSerpItem> loadAds(@NotNull List<? extends ViewTypeSerpItem> list, @NotNull SerpDisplayType serpDisplayType);

    @NotNull
    Observable<LoadingState<Serp>> loadSerp(@Nullable SerpParameters serpParameters, @NotNull SerpPageParams serpPageParams, @Nullable SerpDisplayType serpDisplayType, @NotNull List<? extends ViewTypeSerpItem> list);

    @NotNull
    Kundle onSaveState();

    @NotNull
    Observable<List<ViewTypeSerpItem>> restoreSerp(@NotNull SerpDisplayType serpDisplayType, @NotNull List<? extends ViewTypeSerpItem> list);

    void restoreState(@Nullable Kundle kundle);

    void sendSnippetActionClick(@NotNull String str, @Nullable Map<String, String> map);

    void sendSnippetActionClose(@NotNull String str, @Nullable Map<String, String> map);

    void sendSnippetActionHide(@NotNull String str, @Nullable Map<String, String> map);

    void sendSnippetActionShow(@NotNull String str, @Nullable Map<String, String> map);
}
