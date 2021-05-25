package com.avito.android.messenger.service.user_last_activity;

import java.util.Set;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J-\u0010\t\u001a\u00020\b2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0010\u0010\u0007\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00060\u0005H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/messenger/service/user_last_activity/UserLastActivitySyncAgent;", "", "", "Lcom/avito/android/messenger/service/user_last_activity/RequestId;", "requestId", "", "Lcom/avito/android/messenger/service/user_last_activity/UserId;", "userIds", "", "requestUsers", "(Ljava/lang/String;Ljava/util/Set;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface UserLastActivitySyncAgent {
    void requestUsers(@NotNull String str, @NotNull Set<String> set);
}
