package com.avito.android.user_stats.tab;

import com.avito.android.user_stats.tab.view.UserStatsTabDataView;
import com.avito.android.user_stats.tab.view.UserStatsTabEmptyView;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u00012\u00020\u0002J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\b\u0010\tJ'\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\nH&¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u00108&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/avito/android/user_stats/tab/UserStatsTabView;", "Lcom/avito/android/user_stats/tab/view/UserStatsTabEmptyView;", "Lcom/avito/android/user_stats/tab/view/UserStatsTabDataView;", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "adapter", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "", "showStats", "(Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;Lcom/avito/konveyor/adapter/AdapterPresenter;)V", "", "title", "description", "buttonText", "showEmptyScreen", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Lio/reactivex/rxjava3/core/Observable;", "getEmptyScreenActionButtonClicks", "()Lio/reactivex/rxjava3/core/Observable;", "emptyScreenActionButtonClicks", "user-stats_release"}, k = 1, mv = {1, 4, 2})
public interface UserStatsTabView extends UserStatsTabEmptyView, UserStatsTabDataView {
    @NotNull
    Observable<Unit> getEmptyScreenActionButtonClicks();

    void showEmptyScreen(@NotNull String str, @NotNull String str2, @NotNull String str3);

    void showStats(@NotNull SimpleRecyclerAdapter simpleRecyclerAdapter, @NotNull AdapterPresenter adapterPresenter);
}
