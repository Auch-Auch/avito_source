package com.avito.android.notification_center.push;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u000b\u0010\u0007J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\u0007R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/avito/android/notification_center/push/NcPushClicksImpl;", "Lcom/avito/android/notification_center/push/NcPushClicks;", "", "needsRefresh", "()Z", "", "clear", "()V", "onClick", AuthSource.SEND_ABUSE, "Z", "<init>", "notification-center_release"}, k = 1, mv = {1, 4, 2})
public final class NcPushClicksImpl implements NcPushClicks {
    public boolean a;

    @Override // com.avito.android.notification_center.push.NcPushClicksInteractor
    public void clear() {
        this.a = false;
    }

    @Override // com.avito.android.notification_center.push.NcPushClicksInteractor
    public boolean needsRefresh() {
        return this.a;
    }

    @Override // com.avito.android.notification_center.push.NcPushClicksListener
    public void onClick() {
        this.a = true;
    }
}
