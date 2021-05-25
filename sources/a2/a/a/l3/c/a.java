package a2.a.a.l3.c;

import androidx.lifecycle.Observer;
import com.avito.android.user_stats.tab.UserStatsTabFragment;
import com.avito.android.user_stats.tab.UserStatsTabViewModel;
public final class a<T> implements Observer<UserStatsTabViewModel.TabState> {
    public final /* synthetic */ UserStatsTabFragment a;

    public a(UserStatsTabFragment userStatsTabFragment) {
        this.a = userStatsTabFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(UserStatsTabViewModel.TabState tabState) {
        UserStatsTabViewModel.TabState tabState2 = tabState;
        if (tabState2 instanceof UserStatsTabViewModel.TabState.Content) {
            UserStatsTabFragment.access$getUserStatsTabView$p(this.a).showStats(this.a.getAdapter$user_stats_release(), this.a.getAdapterPresenter$user_stats_release());
            UserStatsTabFragment.access$getUserStatsTabView$p(this.a).updateItems(((UserStatsTabViewModel.TabState.Content) tabState2).getItems());
        } else if (tabState2 instanceof UserStatsTabViewModel.TabState.Empty) {
            UserStatsTabViewModel.TabState.Empty empty = (UserStatsTabViewModel.TabState.Empty) tabState2;
            UserStatsTabFragment.access$getUserStatsTabView$p(this.a).showEmptyScreen(empty.getTitle(), empty.getDescription(), empty.getButtonText());
        }
    }
}
