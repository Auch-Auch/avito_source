package a2.a.a.l3;

import androidx.lifecycle.Observer;
import com.avito.android.user_stats.UserStatsFragment;
import com.avito.android.user_stats.UserStatsViewModel;
public final class a<T> implements Observer<UserStatsViewModel.State> {
    public final /* synthetic */ UserStatsFragment a;

    public a(UserStatsFragment userStatsFragment) {
        this.a = userStatsFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(UserStatsViewModel.State state) {
        UserStatsViewModel.State state2 = state;
        if (state2 instanceof UserStatsViewModel.State.Loaded) {
            this.a.getUserStatsTracker$user_stats_release().startStatsDraw();
            UserStatsFragment.access$getUserStatsView$p(this.a).showContent();
            UserStatsViewModel.State.Loaded loaded = (UserStatsViewModel.State.Loaded) state2;
            UserStatsFragment.access$getUserStatsView$p(this.a).setTabs(loaded.getTabs());
            UserStatsFragment.access$getUserStatsView$p(this.a).setTitle(loaded.getTitle());
            UserStatsFragment.access$getUserStatsView$p(this.a).selectTab(loaded.getSelectedTabPosition());
            this.a.getUserStatsTracker$user_stats_release().trackStatsDraw();
        } else if (state2 instanceof UserStatsViewModel.State.Loading) {
            UserStatsFragment.access$getUserStatsView$p(this.a).showLoading();
        } else if (state2 instanceof UserStatsViewModel.State.Error) {
            this.a.getUserStatsTracker$user_stats_release().startStatsDraw();
            UserStatsFragment.access$getUserStatsView$p(this.a).showError(((UserStatsViewModel.State.Error) state2).getMessage());
            this.a.getUserStatsTracker$user_stats_release().trackStatsDrawError();
        }
    }
}
