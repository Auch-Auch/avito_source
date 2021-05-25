package com.avito.android.call_feedback;

import a2.b.a.a.a;
import android.content.Context;
import android.content.Intent;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroid/content/Context;", "context", "", "callId", "Landroid/content/Intent;", "createCallFeedbackActivityIntent", "(Landroid/content/Context;Ljava/lang/String;)Landroid/content/Intent;", "call-feedback_release"}, k = 2, mv = {1, 4, 2})
public final class CallFeedbackActivityKt {
    @NotNull
    public static final Intent createCallFeedbackActivityIntent(@NotNull Context context, @NotNull String str) {
        return a.j1(context, "context", str, "callId", context, CallFeedbackActivity.class, "key", str, "Intent(context, CallFeed…   .putExtra(KEY, callId)");
    }
}
