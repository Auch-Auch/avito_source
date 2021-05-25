package com.avito.android.util;

import android.text.TextPaint;
import android.text.style.URLSpan;
import android.view.View;
import com.avito.android.deep_linking.links.OnUrlClickListener;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0017"}, d2 = {"Lcom/avito/android/util/UrlSpan;", "Landroid/text/style/URLSpan;", "Landroid/view/View;", "widget", "", "onClick", "(Landroid/view/View;)V", "Landroid/text/TextPaint;", "ds", "updateDrawState", "(Landroid/text/TextPaint;)V", "", AuthSource.BOOKING_ORDER, "Z", "useOldFormatting", "Lcom/avito/android/deep_linking/links/OnUrlClickListener;", AuthSource.SEND_ABUSE, "Lcom/avito/android/deep_linking/links/OnUrlClickListener;", "onClickListener", "", "url", "<init>", "(Ljava/lang/String;Lcom/avito/android/deep_linking/links/OnUrlClickListener;Z)V", "text-formatters_release"}, k = 1, mv = {1, 4, 2})
public final class UrlSpan extends URLSpan {
    public final OnUrlClickListener a;
    public final boolean b;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ UrlSpan(String str, OnUrlClickListener onUrlClickListener, boolean z, int i, j jVar) {
        this(str, (i & 2) != 0 ? null : onUrlClickListener, (i & 4) != 0 ? true : z);
    }

    @Override // android.text.style.URLSpan, android.text.style.ClickableSpan
    public void onClick(@NotNull View view) {
        boolean z;
        Intrinsics.checkNotNullParameter(view, "widget");
        OnUrlClickListener onUrlClickListener = this.a;
        if (onUrlClickListener != null) {
            String url = getURL();
            Intrinsics.checkNotNullExpressionValue(url, "url");
            z = onUrlClickListener.onUrlClick(url);
        } else {
            z = false;
        }
        if (!z) {
            super.onClick(view);
        }
    }

    @Override // android.text.style.CharacterStyle, android.text.style.ClickableSpan
    public void updateDrawState(@NotNull TextPaint textPaint) {
        Intrinsics.checkNotNullParameter(textPaint, "ds");
        if (this.b) {
            textPaint.setColor(textPaint.linkColor);
            textPaint.setUnderlineText(false);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UrlSpan(@NotNull String str, @Nullable OnUrlClickListener onUrlClickListener, boolean z) {
        super(str);
        Intrinsics.checkNotNullParameter(str, "url");
        this.a = onUrlClickListener;
        this.b = z;
    }
}
