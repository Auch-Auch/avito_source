package com.avito.android.select;

import android.content.Context;
import android.content.Intent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u001d\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0019\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\t\u0010\n\"\u0016\u0010\f\u001a\u00020\u000b8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Landroid/content/Context;", "context", "Lcom/avito/android/select/Arguments;", "arguments", "Landroid/content/Intent;", "createSelectActivityIntent", "(Landroid/content/Context;Lcom/avito/android/select/Arguments;)Landroid/content/Intent;", "data", "Lcom/avito/android/select/SelectResult;", "extractSelectResult", "(Landroid/content/Intent;)Lcom/avito/android/select/SelectResult;", "", "EXTRA_SELECT_RESULT", "Ljava/lang/String;", "select_release"}, k = 2, mv = {1, 4, 2})
public final class SelectActivityKt {
    @NotNull
    public static final String EXTRA_SELECT_RESULT = "select_result";

    @NotNull
    public static final Intent createSelectActivityIntent(@NotNull Context context, @NotNull Arguments arguments) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        Intent putExtra = new Intent(context, SelectActivity.class).putExtra("select_arguments", arguments);
        Intrinsics.checkNotNullExpressionValue(putExtra, "context.createActivityIn…ECT_ARGUMENTS, arguments)");
        return putExtra;
    }

    @Nullable
    public static final SelectResult extractSelectResult(@Nullable Intent intent) {
        if (intent != null) {
            return (SelectResult) intent.getParcelableExtra(EXTRA_SELECT_RESULT);
        }
        return null;
    }
}
