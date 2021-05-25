package a2.a.a.i3.c.a;

import androidx.lifecycle.Observer;
import com.avito.android.user_adverts.root_screen.adverts_host.UserAdvertsHostFragment;
import com.avito.android.user_adverts.root_screen.adverts_host.header.ProfileHeaderViewModel;
import kotlin.jvm.internal.Intrinsics;
public final class d<T> implements Observer<ProfileHeaderViewModel.RouterAction> {
    public final /* synthetic */ UserAdvertsHostFragment a;

    public d(UserAdvertsHostFragment userAdvertsHostFragment) {
        this.a = userAdvertsHostFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(ProfileHeaderViewModel.RouterAction routerAction) {
        ProfileHeaderViewModel.RouterAction routerAction2 = routerAction;
        if (Intrinsics.areEqual(routerAction2, ProfileHeaderViewModel.RouterAction.Profile.INSTANCE)) {
            UserAdvertsHostFragment.access$startUserProfileScreen(this.a);
        } else if (Intrinsics.areEqual(routerAction2, ProfileHeaderViewModel.RouterAction.Notification.INSTANCE)) {
            UserAdvertsHostFragment.access$startNotificationCenterScreen(this.a);
        } else if (Intrinsics.areEqual(routerAction2, ProfileHeaderViewModel.RouterAction.Settings.INSTANCE)) {
            UserAdvertsHostFragment.access$startSettingsScreen(this.a);
        } else if (routerAction2 instanceof ProfileHeaderViewModel.RouterAction.DetailsSheet) {
            UserAdvertsHostFragment userAdvertsHostFragment = this.a;
            ProfileHeaderViewModel.RouterAction.DetailsSheet detailsSheet = (ProfileHeaderViewModel.RouterAction.DetailsSheet) routerAction2;
            userAdvertsHostFragment.startActivity(userAdvertsHostFragment.getActivityIntentFactory().detailsSheetIntent(detailsSheet.getBody(), detailsSheet.getClickEvent()));
        } else if (routerAction2 instanceof ProfileHeaderViewModel.RouterAction.Orders) {
            UserAdvertsHostFragment.access$openDeeplink(this.a, ((ProfileHeaderViewModel.RouterAction.Orders) routerAction2).getDeeplink());
        } else if (routerAction2 instanceof ProfileHeaderViewModel.RouterAction.SmbStats) {
            UserAdvertsHostFragment.access$openDeeplink(this.a, ((ProfileHeaderViewModel.RouterAction.SmbStats) routerAction2).getDeeplink());
        } else if (routerAction2 instanceof ProfileHeaderViewModel.RouterAction.StartPublish) {
            this.a.getPresenter().onAddAdvertClicked();
        }
    }
}
