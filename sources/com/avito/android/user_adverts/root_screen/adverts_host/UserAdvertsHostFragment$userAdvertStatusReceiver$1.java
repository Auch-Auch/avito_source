package com.avito.android.user_adverts.root_screen.adverts_host;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.avito.android.user_advert.AdvertActionTransferData;
import com.avito.android.user_adverts_common.safety.UserAdvertConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/avito/android/user_adverts/root_screen/adverts_host/UserAdvertsHostFragment$userAdvertStatusReceiver$1", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
public final class UserAdvertsHostFragment$userAdvertStatusReceiver$1 extends BroadcastReceiver {
    public final /* synthetic */ UserAdvertsHostFragment a;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    public UserAdvertsHostFragment$userAdvertStatusReceiver$1(UserAdvertsHostFragment userAdvertsHostFragment) {
        this.a = userAdvertsHostFragment;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(@NotNull Context context, @NotNull Intent intent) {
        String categoryId;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        AdvertActionTransferData advertActionTransferData = (AdvertActionTransferData) intent.getParcelableExtra(UserAdvertConstants.KEY_ADVERT_ACTION);
        String stringExtra = intent.getStringExtra(UserAdvertConstants.KEY_SOA_UPDATE_MESSAGE);
        if (intent.getBooleanExtra(UserAdvertConstants.KEY_SHOULD_SHOW_APPRATER, false)) {
            this.a.getPresenter().onShowAppRater();
        }
        if (advertActionTransferData.getActionType() == AdvertActionTransferData.Type.ACTIVATE && (categoryId = advertActionTransferData.getCategoryId()) != null) {
            this.a.getPresenter().loadSafetyInfo(categoryId);
        }
        this.a.getPresenter().onAdvertStatusBroadcast(advertActionTransferData.getMessage(), stringExtra, advertActionTransferData.getSoaAdvertId());
    }
}
