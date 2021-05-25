package com.avito.android.analytics.clickstream;

import com.avito.android.account.AccountStateProvider;
import com.avito.android.analytics.clickstream.ClickStreamEventTracker;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Collections;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.q;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/avito/android/analytics/clickstream/ClickStreamEventSaturatorImpl;", "Lcom/avito/android/analytics/clickstream/ClickStreamEventTracker$ClickStreamEventSaturator;", "", "", "environment", "()Ljava/util/Map;", "Lcom/avito/android/account/AccountStateProvider;", AuthSource.SEND_ABUSE, "Lcom/avito/android/account/AccountStateProvider;", "accountState", "<init>", "(Lcom/avito/android/account/AccountStateProvider;)V", "application_release"}, k = 1, mv = {1, 4, 2})
public final class ClickStreamEventSaturatorImpl implements ClickStreamEventTracker.ClickStreamEventSaturator {
    public final AccountStateProvider a;

    public ClickStreamEventSaturatorImpl(@NotNull AccountStateProvider accountStateProvider) {
        Intrinsics.checkNotNullParameter(accountStateProvider, "accountState");
        this.a = accountStateProvider;
    }

    @Override // com.avito.android.analytics.clickstream.ClickStreamEventTracker.ClickStreamEventSaturator
    @NotNull
    public Map<String, String> environment() {
        return Collections.filterValuesNotNull(q.mapOf(TuplesKt.to("uid", this.a.getCurrentUserId())));
    }
}
