package com.avito.android.analytics.provider;

import com.avito.android.remote.auth.AuthSource;
import java.util.Random;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/avito/android/analytics/provider/TreeStateIdGenerator;", "", "", "nextStateId", "()J", "Ljava/util/Random;", AuthSource.SEND_ABUSE, "Ljava/util/Random;", "random", "<init>", "()V", "analytics-core_release"}, k = 1, mv = {1, 4, 2})
public final class TreeStateIdGenerator {
    public final Random a = new Random();

    public final long nextStateId() {
        return Math.abs(this.a.nextLong());
    }
}
