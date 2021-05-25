package com.avito.android.util;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.ClipboardManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroid/content/ClipboardManager;", "", "text", "", "hasText", "(Landroid/content/ClipboardManager;Ljava/lang/CharSequence;)Z", "android_release"}, k = 2, mv = {1, 4, 2})
public final class ClipboardManagersKt {
    public static final boolean hasText(@NotNull ClipboardManager clipboardManager, @NotNull CharSequence charSequence) {
        ClipDescription primaryClipDescription;
        ClipData primaryClip;
        Intrinsics.checkNotNullParameter(clipboardManager, "$this$hasText");
        Intrinsics.checkNotNullParameter(charSequence, "text");
        if (!clipboardManager.hasPrimaryClip() || (primaryClipDescription = clipboardManager.getPrimaryClipDescription()) == null) {
            return false;
        }
        Intrinsics.checkNotNullExpressionValue(primaryClipDescription, "primaryClipDescription ?: return false");
        if (!primaryClipDescription.hasMimeType("text/plain") || (primaryClip = clipboardManager.getPrimaryClip()) == null) {
            return false;
        }
        Intrinsics.checkNotNullExpressionValue(primaryClip, "primaryClip ?: return false");
        ClipData.Item itemAt = primaryClip.getItemAt(0);
        Intrinsics.checkNotNullExpressionValue(itemAt, "item");
        CharSequence text = itemAt.getText();
        if (text != null) {
            return text.equals(charSequence);
        }
        return false;
    }
}
