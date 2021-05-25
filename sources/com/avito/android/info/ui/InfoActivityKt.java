package com.avito.android.info.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.android.persistence.messenger.MessageMetaInfo;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a%\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroid/content/Context;", "context", "", MessageMetaInfo.COLUMN_PATH, "title", "Landroid/content/Intent;", "createInfoIntent", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;", "info_release"}, k = 2, mv = {1, 4, 2})
public final class InfoActivityKt {
    @NotNull
    public static final Intent createInfoIntent(@NotNull Context context, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, MessageMetaInfo.COLUMN_PATH);
        Intrinsics.checkNotNullParameter(str2, "title");
        Bundle bundle = new Bundle();
        bundle.putString(MessageMetaInfo.COLUMN_PATH, str);
        bundle.putString("title", str2);
        Intent putExtras = new Intent(context, InfoActivity.class).putExtras(bundle);
        Intrinsics.checkNotNullExpressionValue(putExtras, "Intent(context, InfoActi…       .putExtras(bundle)");
        return putExtras;
    }
}
