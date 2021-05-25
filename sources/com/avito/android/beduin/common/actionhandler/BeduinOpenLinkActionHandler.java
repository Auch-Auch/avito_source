package com.avito.android.beduin.common.actionhandler;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import com.avito.android.beduin.action.BeduinOpenLinkAction;
import com.avito.android.beduin.core.action.BeduinAction;
import com.avito.android.beduin.core.action.BeduinActionHandler;
import com.avito.android.deep_linking.DeepLinkFactory;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.NoMatchLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.IntentsKt;
import com.avito.android.util.Logs;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/avito/android/beduin/common/actionhandler/BeduinOpenLinkActionHandler;", "Lcom/avito/android/beduin/core/action/BeduinActionHandler;", "Lcom/avito/android/beduin/core/action/BeduinAction;", "action", "", "handle", "(Lcom/avito/android/beduin/core/action/BeduinAction;)Z", "Landroid/app/Activity;", "c", "Landroid/app/Activity;", "activity", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", AuthSource.SEND_ABUSE, "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "Lcom/avito/android/deep_linking/DeepLinkFactory;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/deep_linking/DeepLinkFactory;", "deepLinkFactory", "<init>", "(Lcom/avito/android/deep_linking/DeepLinkIntentFactory;Lcom/avito/android/deep_linking/DeepLinkFactory;Landroid/app/Activity;)V", "beduin_release"}, k = 1, mv = {1, 4, 2})
public final class BeduinOpenLinkActionHandler implements BeduinActionHandler {
    public final DeepLinkIntentFactory a;
    public final DeepLinkFactory b;
    public final Activity c;

    public BeduinOpenLinkActionHandler(@NotNull DeepLinkIntentFactory deepLinkIntentFactory, @NotNull DeepLinkFactory deepLinkFactory, @NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory, "deepLinkIntentFactory");
        Intrinsics.checkNotNullParameter(deepLinkFactory, "deepLinkFactory");
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.a = deepLinkIntentFactory;
        this.b = deepLinkFactory;
        this.c = activity;
    }

    @Override // com.avito.android.beduin.core.action.BeduinActionHandler
    public boolean handle(@NotNull BeduinAction beduinAction) {
        Intrinsics.checkNotNullParameter(beduinAction, "action");
        if (!(beduinAction instanceof BeduinOpenLinkAction)) {
            return false;
        }
        BeduinOpenLinkAction beduinOpenLinkAction = (BeduinOpenLinkAction) beduinAction;
        DeepLink createFromUri = this.b.createFromUri(beduinOpenLinkAction.getLink());
        if (!(createFromUri instanceof NoMatchLink)) {
            Intent intent = this.a.getIntent(createFromUri);
            if (intent == null) {
                return false;
            }
            try {
                this.c.startActivity(IntentsKt.makeSafeForExternalApps(intent));
                return true;
            } catch (Exception e) {
                Logs.error(e);
                return true;
            }
        } else {
            Activity activity = this.c;
            Intent intent2 = new Intent("android.intent.action.VIEW");
            intent2.setData(Uri.parse(beduinOpenLinkAction.getLink()));
            try {
                activity.startActivity(IntentsKt.makeSafeForExternalApps(intent2));
                return true;
            } catch (Exception e2) {
                Logs.error(e2);
                return true;
            }
        }
    }
}
