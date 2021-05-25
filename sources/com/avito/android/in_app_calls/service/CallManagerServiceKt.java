package com.avito.android.in_app_calls.service;

import android.content.Context;
import android.content.Intent;
import com.avito.android.in_app_calls.service.CallManagerService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001f\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0000¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroid/content/Context;", "Lcom/avito/android/in_app_calls/service/CallManagerService$StartRequest;", "request", "Landroid/content/Intent;", "createCallManagerServiceIntent", "(Landroid/content/Context;Lcom/avito/android/in_app_calls/service/CallManagerService$StartRequest;)Landroid/content/Intent;", "in-app-calls_release"}, k = 2, mv = {1, 4, 2})
public final class CallManagerServiceKt {
    @NotNull
    public static final Intent createCallManagerServiceIntent(@NotNull Context context, @Nullable CallManagerService.StartRequest startRequest) {
        Intrinsics.checkNotNullParameter(context, "$this$createCallManagerServiceIntent");
        Intent putExtra = new Intent(context, CallManagerService.class).putExtra("start_request", startRequest);
        Intrinsics.checkNotNullExpressionValue(putExtra, "Intent(this, CallManager…A_START_REQUEST, request)");
        return putExtra;
    }

    public static /* synthetic */ Intent createCallManagerServiceIntent$default(Context context, CallManagerService.StartRequest startRequest, int i, Object obj) {
        if ((i & 1) != 0) {
            startRequest = null;
        }
        return createCallManagerServiceIntent(context, startRequest);
    }
}
