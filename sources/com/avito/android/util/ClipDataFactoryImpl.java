package com.avito.android.util;

import android.content.ClipData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/util/ClipDataFactoryImpl;", "Lcom/avito/android/util/ClipDataFactory;", "", "text", "Landroid/content/ClipData;", "plainText", "(Ljava/lang/String;)Landroid/content/ClipData;", "<init>", "()V", "android_release"}, k = 1, mv = {1, 4, 2})
public final class ClipDataFactoryImpl implements ClipDataFactory {
    @Override // com.avito.android.util.ClipDataFactory
    @NotNull
    public ClipData plainText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        ClipData newPlainText = ClipData.newPlainText(null, str);
        Intrinsics.checkNotNullExpressionValue(newPlainText, "ClipData.newPlainText(null, text)");
        return newPlainText;
    }
}
