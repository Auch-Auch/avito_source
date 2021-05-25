package com.avito.android.in_app_calls.ui.root;

import android.content.Context;
import android.content.Intent;
import com.avito.android.in_app_calls.data.CallActivityRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001b\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroid/content/Context;", "Lcom/avito/android/in_app_calls/data/CallActivityRequest;", "request", "Landroid/content/Intent;", "createCallActivityIntent", "(Landroid/content/Context;Lcom/avito/android/in_app_calls/data/CallActivityRequest;)Landroid/content/Intent;", "in-app-calls_release"}, k = 2, mv = {1, 4, 2})
public final class InAppCallActivityKt {
    @NotNull
    public static final Intent createCallActivityIntent(@NotNull Context context, @NotNull CallActivityRequest callActivityRequest) {
        Intrinsics.checkNotNullParameter(context, "$this$createCallActivityIntent");
        Intrinsics.checkNotNullParameter(callActivityRequest, "request");
        Intent putExtra = new Intent(context, InAppCallActivity.class).putExtra("request", callActivityRequest);
        Intrinsics.checkNotNullExpressionValue(putExtra, "createActivityIntent<InA…a(EXTRA_REQUEST, request)");
        return putExtra;
    }
}
