package com.avito.android.authorization;

import android.content.Intent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0019\u0010\u0005\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0001¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroid/content/Intent;", "", "getResult", "(Landroid/content/Intent;)I", "result", "withResult", "(Landroid/content/Intent;I)Landroid/content/Intent;", "authorization_release"}, k = 2, mv = {1, 4, 2})
public final class IntentsKt {
    public static final int getResult(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "$this$getResult");
        return intent.getIntExtra("result", 0);
    }

    @NotNull
    public static final Intent withResult(@NotNull Intent intent, int i) {
        Intrinsics.checkNotNullParameter(intent, "$this$withResult");
        Intent putExtra = intent.putExtra("result", i);
        Intrinsics.checkNotNullExpressionValue(putExtra, "putExtra(EXTRA_RESULT, result)");
        return putExtra;
    }
}
