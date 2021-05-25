package com.avito.android.messenger.search;

import android.content.res.Resources;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.MessengerIntentFactory;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Keyboards;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u001e\u0010\u001fJ1\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006 "}, d2 = {"Lcom/avito/android/messenger/search/ChannelsSearchRouterImpl;", "Lcom/avito/android/messenger/search/ChannelsSearchRouter;", "", "channelId", "messageId", "query", "", VKApiConst.POSITION, "", "openChannel", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "", "closeScreen", "()Z", "Landroid/os/Bundle;", "outState", "saveState", "(Landroid/os/Bundle;)V", "Lcom/avito/android/ActivityIntentFactory;", "c", "Lcom/avito/android/ActivityIntentFactory;", "activityIntentFactory", AuthSource.SEND_ABUSE, "I", "originalOrientation", "Landroidx/fragment/app/Fragment;", AuthSource.BOOKING_ORDER, "Landroidx/fragment/app/Fragment;", "fragment", "state", "<init>", "(Landroidx/fragment/app/Fragment;Lcom/avito/android/ActivityIntentFactory;Landroid/os/Bundle;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class ChannelsSearchRouterImpl implements ChannelsSearchRouter {
    public final int a;
    public final Fragment b;
    public final ActivityIntentFactory c;

    public ChannelsSearchRouterImpl(@NotNull Fragment fragment, @NotNull ActivityIntentFactory activityIntentFactory, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(activityIntentFactory, "activityIntentFactory");
        this.b = fragment;
        this.c = activityIntentFactory;
        Resources resources = fragment.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        int i = resources.getConfiguration().orientation;
        this.a = bundle != null ? bundle.getInt("original_orientation", i) : i;
    }

    @Override // com.avito.android.messenger.search.ChannelsSearchRouter
    public boolean closeScreen() {
        Keyboards.hideKeyboard(this.b);
        FragmentActivity activity = this.b.getActivity();
        boolean z = false;
        if (activity == null) {
            return false;
        }
        if (this.a != 0) {
            Resources resources = this.b.getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "resources");
            if (resources.getConfiguration().orientation == this.a) {
                z = true;
            }
        }
        if (z) {
            activity.supportFinishAfterTransition();
            return true;
        }
        activity.finish();
        return true;
    }

    @Override // com.avito.android.messenger.search.ChannelsSearchRouter
    public void openChannel(@NotNull String str, @Nullable String str2, @NotNull String str3, int i) {
        Intrinsics.checkNotNullParameter(str, "channelId");
        Intrinsics.checkNotNullParameter(str3, "query");
        this.b.startActivity(MessengerIntentFactory.DefaultImpls.channelIntent$default(this.c, str, Integer.valueOf(i + 1), str2, str3, false, 16, null));
    }

    @Override // com.avito.android.messenger.search.ChannelsSearchRouter
    public void saveState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        bundle.putInt("original_orientation", this.a);
    }
}
