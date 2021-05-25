package com.avito.android.user_stats;

import com.avito.android.user_stats.tab.UserStatsTabItem;
import io.reactivex.rxjava3.core.Observable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0005H&¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0005H&¢\u0006\u0004\b\u000e\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\bH&¢\u0006\u0004\b\u0010\u0010\u000bJ\u0017\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0011H&¢\u0006\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u00158&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00110\u00158&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0017R\u001c\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00050\u00158&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0017¨\u0006\u001d"}, d2 = {"Lcom/avito/android/user_stats/UserStatsView;", "", "", "Lcom/avito/android/user_stats/tab/UserStatsTabItem;", "tabs", "", "setTabs", "(Ljava/util/List;)V", "", "text", "setTitle", "(Ljava/lang/String;)V", "showLoading", "()V", "showContent", "error", "showError", "", "tabPosition", "selectTab", "(I)V", "Lio/reactivex/rxjava3/core/Observable;", "getBackClicks", "()Lio/reactivex/rxjava3/core/Observable;", "backClicks", "getTabClicks", "tabClicks", "getRetryClicks", "retryClicks", "user-stats_release"}, k = 1, mv = {1, 4, 2})
public interface UserStatsView {
    @NotNull
    Observable<Unit> getBackClicks();

    @NotNull
    Observable<Unit> getRetryClicks();

    @NotNull
    Observable<Integer> getTabClicks();

    void selectTab(int i);

    void setTabs(@NotNull List<UserStatsTabItem> list);

    void setTitle(@NotNull String str);

    void showContent();

    void showError(@NotNull String str);

    void showLoading();
}
