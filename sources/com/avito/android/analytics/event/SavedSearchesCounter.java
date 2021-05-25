package com.avito.android.analytics.event;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/analytics/event/SavedSearchesCounter;", "", "", AuthSource.SEND_ABUSE, "I", "getUnreadCount", "()I", "unreadCount", "<init>", "(I)V", "analytics_release"}, k = 1, mv = {1, 4, 2})
public final class SavedSearchesCounter {
    public final int a;

    public SavedSearchesCounter(int i) {
        this.a = i;
    }

    public final int getUnreadCount() {
        return this.a;
    }
}
