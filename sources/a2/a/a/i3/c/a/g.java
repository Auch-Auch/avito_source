package a2.a.a.i3.c.a;

import com.avito.android.user_adverts.root_screen.adverts_host.UserAdvertsHostFragment;
import com.avito.android.user_adverts.root_screen.adverts_host.header.ProfileHeaderView;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class g<T> implements Consumer<ProfileHeaderView.ClickTarget> {
    public final /* synthetic */ UserAdvertsHostFragment a;

    public g(UserAdvertsHostFragment userAdvertsHostFragment) {
        this.a = userAdvertsHostFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(ProfileHeaderView.ClickTarget clickTarget) {
        ProfileHeaderView.ClickTarget clickTarget2 = clickTarget;
        if (Intrinsics.areEqual(clickTarget2, ProfileHeaderView.ClickTarget.Profile.INSTANCE)) {
            UserAdvertsHostFragment.access$getHeaderViewModel$p(this.a).onClickProfile();
        } else if (Intrinsics.areEqual(clickTarget2, ProfileHeaderView.ClickTarget.Settings.INSTANCE)) {
            UserAdvertsHostFragment.access$getHeaderViewModel$p(this.a).onClickSettings();
        } else if (Intrinsics.areEqual(clickTarget2, ProfileHeaderView.ClickTarget.Notifications.INSTANCE)) {
            UserAdvertsHostFragment.access$getHeaderViewModel$p(this.a).onClickNotifications();
        } else if (Intrinsics.areEqual(clickTarget2, ProfileHeaderView.ClickTarget.SOAInfo.INSTANCE)) {
            UserAdvertsHostFragment.access$getUserAdvertsViewModel$p(this.a).openSoaInfoDialog();
        } else if (clickTarget2 instanceof ProfileHeaderView.ClickTarget.SmbStats) {
            UserAdvertsHostFragment.access$getHeaderViewModel$p(this.a).onClickSmbStats(((ProfileHeaderView.ClickTarget.SmbStats) clickTarget2).getDeepLink());
        } else if (clickTarget2 instanceof ProfileHeaderView.ClickTarget.Orders) {
            UserAdvertsHostFragment.access$getHeaderViewModel$p(this.a).onOrdersInfoClicked(((ProfileHeaderView.ClickTarget.Orders) clickTarget2).getDeepLink());
        } else if (Intrinsics.areEqual(clickTarget2, ProfileHeaderView.ClickTarget.Search.INSTANCE)) {
            UserAdvertsHostFragment.access$showAdvertSearch(this.a);
        } else if (Intrinsics.areEqual(clickTarget2, ProfileHeaderView.ClickTarget.CloseSoaOnboarding.INSTANCE)) {
            UserAdvertsHostFragment.access$getHeaderViewModel$p(this.a).onCloseSoaOnboarding();
        } else if (Intrinsics.areEqual(clickTarget2, ProfileHeaderView.ClickTarget.CloseSmbOnboarding.INSTANCE)) {
            UserAdvertsHostFragment.access$getHeaderViewModel$p(this.a).onCloseSmbStatsOnboarding();
        } else if (Intrinsics.areEqual(clickTarget2, ProfileHeaderView.ClickTarget.StartPublish.INSTANCE)) {
            UserAdvertsHostFragment.access$getHeaderViewModel$p(this.a).onClickStartPublish();
        }
    }
}
