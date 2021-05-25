package com.avito.android.messenger.conversation.mvi.platform_actions;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0006\"$\u0010\u0004\u001a\u00060\u0000j\u0002`\u0001*\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u00018Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003*\u000e\u0010\u0005\"\u0002`\u00012\u00060\u0000j\u0002`\u0001*\n\u0010\u0006\"\u00020\u00002\u00020\u0000¨\u0006\u0007"}, d2 = {"", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/ChannelDataId;", "getOrEmpty", "(Ljava/lang/Long;)J", "orEmpty", "CDId", "ChannelDataId", "messenger_release"}, k = 2, mv = {1, 4, 2})
public final class ChannelDataKt {
    public static final long getOrEmpty(@Nullable Long l) {
        if (l != null) {
            return l.longValue();
        }
        return -1;
    }
}
