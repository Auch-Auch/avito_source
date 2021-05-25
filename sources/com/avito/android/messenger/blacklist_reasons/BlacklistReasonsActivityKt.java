package com.avito.android.messenger.blacklist_reasons;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a+\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroid/content/Context;", "", ChannelContext.Item.USER_ID, "channelId", "itemId", "Landroid/content/Intent;", "createBlacklistReasonsActivityIntent", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;", "messenger_release"}, k = 2, mv = {1, 4, 2})
public final class BlacklistReasonsActivityKt {
    public static final BlacklistReasonsFragment access$createBlacklistReasonsFragment(String str, String str2, String str3) {
        BlacklistReasonsFragment blacklistReasonsFragment = new BlacklistReasonsFragment();
        Bundle bundle = new Bundle();
        bundle.putString("user_id", str);
        bundle.putString("channel_id", str2);
        bundle.putString("item_id", str3);
        Unit unit = Unit.INSTANCE;
        blacklistReasonsFragment.setArguments(bundle);
        return blacklistReasonsFragment;
    }

    @NotNull
    public static final Intent createBlacklistReasonsActivityIntent(@NotNull Context context, @NotNull String str, @NotNull String str2, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(context, "$this$createBlacklistReasonsActivityIntent");
        Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
        Intrinsics.checkNotNullParameter(str2, "channelId");
        Intent putExtra = new Intent(context, BlacklistReasonsActivity.class).putExtra("user_id", str).putExtra("channel_id", str2).putExtra("item_id", str3);
        Intrinsics.checkNotNullExpressionValue(putExtra, "Intent(this, BlacklistRe…xtra(KEY_ITEM_ID, itemId)");
        return putExtra;
    }
}
