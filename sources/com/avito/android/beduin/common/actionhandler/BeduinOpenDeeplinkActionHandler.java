package com.avito.android.beduin.common.actionhandler;

import android.app.Activity;
import android.content.Intent;
import com.avito.android.beduin.action.BeduinOpenDeeplinkAction;
import com.avito.android.beduin.core.action.BeduinAction;
import com.avito.android.beduin.core.action.BeduinActionHandler;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.IntentsKt;
import com.avito.android.util.Logs;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/beduin/common/actionhandler/BeduinOpenDeeplinkActionHandler;", "Lcom/avito/android/beduin/core/action/BeduinActionHandler;", "Lcom/avito/android/beduin/core/action/BeduinAction;", "action", "", "handle", "(Lcom/avito/android/beduin/core/action/BeduinAction;)Z", "Landroid/app/Activity;", AuthSource.BOOKING_ORDER, "Landroid/app/Activity;", "activity", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", AuthSource.SEND_ABUSE, "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "<init>", "(Lcom/avito/android/deep_linking/DeepLinkIntentFactory;Landroid/app/Activity;)V", "beduin_release"}, k = 1, mv = {1, 4, 2})
public final class BeduinOpenDeeplinkActionHandler implements BeduinActionHandler {
    public final DeepLinkIntentFactory a;
    public final Activity b;

    public BeduinOpenDeeplinkActionHandler(@NotNull DeepLinkIntentFactory deepLinkIntentFactory, @NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory, "deepLinkIntentFactory");
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.a = deepLinkIntentFactory;
        this.b = activity;
    }

    @Override // com.avito.android.beduin.core.action.BeduinActionHandler
    public boolean handle(@NotNull BeduinAction beduinAction) {
        Intent intent;
        Intrinsics.checkNotNullParameter(beduinAction, "action");
        if (!(beduinAction instanceof BeduinOpenDeeplinkAction) || (intent = this.a.getIntent(((BeduinOpenDeeplinkAction) beduinAction).getDeeplink())) == null) {
            return false;
        }
        try {
            this.b.startActivity(IntentsKt.makeSafeForExternalApps(intent));
            return true;
        } catch (Exception e) {
            Logs.error(e);
            return true;
        }
    }
}
