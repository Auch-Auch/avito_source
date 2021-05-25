package com.avito.android.abuse.category;

import android.content.Context;
import android.content.Intent;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.remote.model.Action;
import com.avito.android.util.AvitoCollectionUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a;\u0010\t\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Landroid/content/Context;", "context", "", BookingInfoActivity.EXTRA_ITEM_ID, "src", "", "Lcom/avito/android/remote/model/Action;", "actions", "Landroid/content/Intent;", "createAbuseCategoryIntent", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)Landroid/content/Intent;", "abuse_release"}, k = 2, mv = {1, 4, 2})
public final class AbuseCategoryActivityKt {
    @NotNull
    public static final Intent createAbuseCategoryIntent(@NotNull Context context, @NotNull String str, @Nullable String str2, @Nullable List<Action> list) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Intent putParcelableArrayListExtra = new Intent(context, AbuseCategoryActivity.class).putExtra("advert_id_extra", str).putExtra("src_extra", str2).putParcelableArrayListExtra("actions_extra", AvitoCollectionUtils.INSTANCE.asArrayList(list));
        Intrinsics.checkNotNullExpressionValue(putParcelableArrayListExtra, "context.createActivityIn…ils.asArrayList(actions))");
        return putParcelableArrayListExtra;
    }

    public static /* synthetic */ Intent createAbuseCategoryIntent$default(Context context, String str, String str2, List list, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = null;
        }
        if ((i & 8) != 0) {
            list = null;
        }
        return createAbuseCategoryIntent(context, str, str2, list);
    }
}
