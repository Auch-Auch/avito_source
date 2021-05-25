package com.avito.android.player.router;

import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.PlayerIntentFactory;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.player.view.PlayerActivity;
import com.avito.android.rec.ScreenSource;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui.fragments.TabBaseFragment;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0017¢\u0006\u0004\b\u001b\u0010\u001cJ;\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/avito/android/player/router/PlayerRouterImpl;", "Lcom/avito/android/player/router/PlayerRouter;", "", "url", "slug", "blockType", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "treeParent", "Lcom/avito/android/rec/ScreenSource;", "screenSource", "", "openPlayer", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;Lcom/avito/android/rec/ScreenSource;)V", "closeScreen", "()V", "Lcom/avito/android/ui/fragments/TabBaseFragment;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/ui/fragments/TabBaseFragment;", "fragment", "Landroidx/fragment/app/FragmentActivity;", AuthSource.SEND_ABUSE, "Landroidx/fragment/app/FragmentActivity;", "activity", "Lcom/avito/android/ActivityIntentFactory;", "c", "Lcom/avito/android/ActivityIntentFactory;", "activityIntentFactory", "<init>", "(Lcom/avito/android/ui/fragments/TabBaseFragment;Lcom/avito/android/ActivityIntentFactory;)V", "player_release"}, k = 1, mv = {1, 4, 2})
public final class PlayerRouterImpl implements PlayerRouter {
    public final FragmentActivity a;
    public final TabBaseFragment b;
    public final ActivityIntentFactory c;

    @Inject
    public PlayerRouterImpl(@NotNull TabBaseFragment tabBaseFragment, @NotNull ActivityIntentFactory activityIntentFactory) {
        Intrinsics.checkNotNullParameter(tabBaseFragment, "fragment");
        Intrinsics.checkNotNullParameter(activityIntentFactory, "activityIntentFactory");
        this.b = tabBaseFragment;
        this.c = activityIntentFactory;
        this.a = tabBaseFragment.getActivity();
    }

    @Override // com.avito.android.player.router.PlayerRouter
    public void closeScreen() {
        FragmentActivity fragmentActivity = this.a;
        if (fragmentActivity == null) {
            return;
        }
        if (!(fragmentActivity instanceof PlayerActivity)) {
            this.b.finish();
        } else {
            fragmentActivity.finish();
        }
    }

    @Override // com.avito.android.player.router.PlayerRouter
    public void openPlayer(@NotNull String str, @Nullable String str2, @Nullable String str3, @NotNull TreeClickStreamParent treeClickStreamParent, @NotNull ScreenSource screenSource) {
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(treeClickStreamParent, "treeParent");
        Intrinsics.checkNotNullParameter(screenSource, "screenSource");
        Intent flags = PlayerIntentFactory.DefaultImpls.playerIntent$default(this.c, str, str2, str3, treeClickStreamParent, screenSource, null, 32, null).setFlags(603979776);
        Intrinsics.checkNotNullExpressionValue(flags, "activityIntentFactory.pl…FLAG_ACTIVITY_SINGLE_TOP)");
        this.b.startActivity(flags);
    }
}
