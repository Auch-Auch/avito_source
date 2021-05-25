package com.avito.android.publish_limits_info.history;

import android.content.Context;
import android.content.Intent;
import com.avito.android.publish_limits_info.ItemId;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001d\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroid/content/Context;", "context", "Lcom/avito/android/publish_limits_info/ItemId;", "itemId", "Landroid/content/Intent;", "createLimitsHistoryActivityIntent", "(Landroid/content/Context;Lcom/avito/android/publish_limits_info/ItemId;)Landroid/content/Intent;", "publish-limits-info_release"}, k = 2, mv = {1, 4, 2})
public final class PublishLimitsHistoryActivityKt {
    @NotNull
    public static final Intent createLimitsHistoryActivityIntent(@NotNull Context context, @NotNull ItemId itemId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        Intent intent = new Intent(context, PublishLimitsHistoryActivity.class);
        intent.putExtra("history_id", itemId);
        return intent;
    }
}
