package com.avito.android.version_conflict;

import android.content.Context;
import android.content.Intent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001d\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroid/content/Context;", "context", "", "validateVersionStatus", "Landroid/content/Intent;", "createResolveAppVersionConflictActivityIntent", "(Landroid/content/Context;I)Landroid/content/Intent;", "version-conflict_release"}, k = 2, mv = {1, 4, 2})
public final class ResolveAppVersionConflictActivityKt {
    @NotNull
    public static final Intent createResolveAppVersionConflictActivityIntent(@NotNull Context context, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intent intent = new Intent(context, ResolveAppVersionConflictActivity.class);
        intent.putExtra("EXTRA_VALIDATE_VERSION_STATUS", i);
        return intent;
    }
}
