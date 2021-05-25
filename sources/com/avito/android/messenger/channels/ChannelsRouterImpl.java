package com.avito.android.messenger.channels;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.AuthIntentFactory;
import com.avito.android.MessengerIntentFactory;
import com.avito.android.messenger.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.AvitoSnackbar;
import com.avito.android.util.FragmentsKt;
import com.avito.android.util.ImplicitIntentFactory;
import com.avito.android.util.Logs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0013\u001a\u00020\u0006\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\u0006\u0010\u001f\u001a\u00020\u001c¢\u0006\u0004\b \u0010!J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u001f\u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\u0004J\u0019\u0010\u000f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0013\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006\""}, d2 = {"Lcom/avito/android/messenger/channels/ChannelsRouterImpl;", "Lcom/avito/android/messenger/channels/ChannelsRouter;", "", "showLoginScreen", "()V", "showBlacklistScreen", "", "channelId", "", "listIndex", "showChannelScreen", "(Ljava/lang/String;I)V", "showSystemNotificationSettings", "Landroid/os/Bundle;", "activityOptions", "showSearchScreen", "(Landroid/os/Bundle;)V", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "TAG", "Landroidx/fragment/app/Fragment;", AuthSource.BOOKING_ORDER, "Landroidx/fragment/app/Fragment;", "fragment", "Lcom/avito/android/ActivityIntentFactory;", "c", "Lcom/avito/android/ActivityIntentFactory;", "activityIntentFactory", "Lcom/avito/android/util/ImplicitIntentFactory;", "d", "Lcom/avito/android/util/ImplicitIntentFactory;", "implicitIntentFactory", "<init>", "(Ljava/lang/String;Landroidx/fragment/app/Fragment;Lcom/avito/android/ActivityIntentFactory;Lcom/avito/android/util/ImplicitIntentFactory;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class ChannelsRouterImpl implements ChannelsRouter {
    public final String a;
    public final Fragment b;
    public final ActivityIntentFactory c;
    public final ImplicitIntentFactory d;

    public static final class a extends Lambda implements Function1<Exception, Unit> {
        public final /* synthetic */ ChannelsRouterImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(ChannelsRouterImpl channelsRouterImpl) {
            super(1);
            this.a = channelsRouterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Exception exc) {
            Window window;
            View decorView;
            Exception exc2 = exc;
            Intrinsics.checkNotNullParameter(exc2, "error");
            Logs.warning(this.a.a, "Couldn't start app settings activity", exc2);
            FragmentActivity activity = this.a.b.getActivity();
            if (!(activity == null || (window = activity.getWindow()) == null || (decorView = window.getDecorView()) == null)) {
                AvitoSnackbar avitoSnackbar = AvitoSnackbar.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(decorView, "view");
                AvitoSnackbar.make$default(avitoSnackbar, decorView, R.string.error_unknown, -1, null, 0, null, null, 0, 0, 504, null).show();
            }
            return Unit.INSTANCE;
        }
    }

    public ChannelsRouterImpl(@NotNull String str, @NotNull Fragment fragment, @NotNull ActivityIntentFactory activityIntentFactory, @NotNull ImplicitIntentFactory implicitIntentFactory) {
        Intrinsics.checkNotNullParameter(str, "TAG");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(activityIntentFactory, "activityIntentFactory");
        Intrinsics.checkNotNullParameter(implicitIntentFactory, "implicitIntentFactory");
        this.a = str;
        this.b = fragment;
        this.c = activityIntentFactory;
        this.d = implicitIntentFactory;
    }

    @Override // com.avito.android.messenger.channels.ChannelsRouter
    public void showBlacklistScreen() {
        this.b.startActivityForResult(this.c.blacklistIntent(), 2);
    }

    @Override // com.avito.android.messenger.channels.ChannelsRouter
    public void showChannelScreen(@NotNull String str, int i) {
        Intrinsics.checkNotNullParameter(str, "channelId");
        this.b.startActivityForResult(MessengerIntentFactory.DefaultImpls.channelIntent$default(this.c, str, Integer.valueOf(i + 1), null, null, false, 28, null), 1);
    }

    @Override // com.avito.android.messenger.channels.ChannelsRouter
    public void showLoginScreen() {
        this.b.startActivityForResult(AuthIntentFactory.DefaultImpls.authIntent$default(this.c, null, AuthSource.OPEN_CHANNEL_LIST, null, 5, null), 0);
    }

    @Override // com.avito.android.messenger.channels.ChannelsRouter
    public void showSearchScreen(@Nullable Bundle bundle) {
        this.b.startActivity(this.c.channelsSearchIntent(), bundle);
    }

    @Override // com.avito.android.messenger.channels.ChannelsRouter
    public void showSystemNotificationSettings() {
        FragmentsKt.startActivitySafely(this.b, this.d.notificationsSettingsIntent(), new a(this));
    }
}
