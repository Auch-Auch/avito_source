package com.avito.android.messenger.conversation;

import android.content.Context;
import android.content.Intent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroid/content/Context;", "Lcom/avito/android/messenger/conversation/ChannelActivityArguments;", "arguments", "Landroid/content/Intent;", "createChannelActivityIntent", "(Landroid/content/Context;Lcom/avito/android/messenger/conversation/ChannelActivityArguments;)Landroid/content/Intent;", "messenger_release"}, k = 2, mv = {1, 4, 2})
public final class ChannelActivityKt {
    @NotNull
    public static final Intent createChannelActivityIntent(@NotNull Context context, @NotNull ChannelActivityArguments channelActivityArguments) {
        Intrinsics.checkNotNullParameter(context, "$this$createChannelActivityIntent");
        Intrinsics.checkNotNullParameter(channelActivityArguments, "arguments");
        Intent putExtra = new Intent(context, ChannelActivity.class).putExtra("arguments", channelActivityArguments);
        Intrinsics.checkNotNullExpressionValue(putExtra, "createActivityIntent<Cha…KEY_ARGUMENTS, arguments)");
        return putExtra;
    }
}
