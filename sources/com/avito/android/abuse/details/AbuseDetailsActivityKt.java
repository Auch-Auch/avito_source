package com.avito.android.abuse.details;

import android.content.Context;
import android.content.Intent;
import com.avito.android.remote.model.Action;
import com.avito.android.util.AvitoCollectionUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aC\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0004\b\u000b\u0010\f\"\u0016\u0010\r\u001a\u00020\u00048\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Landroid/content/Context;", "context", "", "abuseCategoryId", "", "itemId", "src", "", "Lcom/avito/android/remote/model/Action;", "actions", "Landroid/content/Intent;", "createAbuseDetailsActivityIntent", "(Landroid/content/Context;ILjava/lang/String;Ljava/lang/String;Ljava/util/List;)Landroid/content/Intent;", "EXTRA_DEEP_LINK", "Ljava/lang/String;", "abuse_release"}, k = 2, mv = {1, 4, 2})
public final class AbuseDetailsActivityKt {
    @NotNull
    public static final String EXTRA_DEEP_LINK = "deep_link";

    public static final /* synthetic */ int access$getCATEGORY_ID_INVALID$p() {
        return -1;
    }

    public static final /* synthetic */ String access$getKEY_PRESENTER_STATE$p() {
        return "presenterState";
    }

    public static final /* synthetic */ int access$getREQ_AUTH_QUERY$p() {
        return 4;
    }

    @NotNull
    public static final Intent createAbuseDetailsActivityIntent(@NotNull Context context, int i, @NotNull String str, @Nullable String str2, @Nullable List<Action> list) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "itemId");
        Intent putParcelableArrayListExtra = new Intent(context, AbuseDetailsActivity.class).putExtra("categoryId", i).putExtra("itemId", str).putExtra("src", str2).putParcelableArrayListExtra("actions", AvitoCollectionUtils.INSTANCE.asArrayList(list));
        Intrinsics.checkNotNullExpressionValue(putParcelableArrayListExtra, "context.createActivityIn…NS, asArrayList(actions))");
        return putParcelableArrayListExtra;
    }

    public static /* synthetic */ Intent createAbuseDetailsActivityIntent$default(Context context, int i, String str, String str2, List list, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            str2 = null;
        }
        if ((i2 & 16) != 0) {
            list = null;
        }
        return createAbuseDetailsActivityIntent(context, i, str, str2, list);
    }
}
