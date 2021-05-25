package com.avito.android.util;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.OnDeepLinkClickListener;
import com.avito.android.remote.auth.AuthSource;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/avito/android/util/DeepLinkSpan;", "Landroid/text/style/ClickableSpan;", "Landroid/view/View;", "widget", "", "onClick", "(Landroid/view/View;)V", "Landroid/text/TextPaint;", "ds", "updateDrawState", "(Landroid/text/TextPaint;)V", "", "c", "Z", "useOldFormatting", "Lcom/avito/android/deep_linking/links/OnDeepLinkClickListener;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/deep_linking/links/OnDeepLinkClickListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/avito/android/deep_linking/links/DeepLink;", AuthSource.SEND_ABUSE, "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "<init>", "(Lcom/avito/android/deep_linking/links/DeepLink;Lcom/avito/android/deep_linking/links/OnDeepLinkClickListener;Z)V", "text-formatters_release"}, k = 1, mv = {1, 4, 2})
public final class DeepLinkSpan extends ClickableSpan {
    public final DeepLink a;
    public final OnDeepLinkClickListener b;
    public final boolean c;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DeepLinkSpan(DeepLink deepLink, OnDeepLinkClickListener onDeepLinkClickListener, boolean z, int i, j jVar) {
        this(deepLink, onDeepLinkClickListener, (i & 4) != 0 ? true : z);
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "widget");
        OnDeepLinkClickListener onDeepLinkClickListener = this.b;
        if (onDeepLinkClickListener != null) {
            onDeepLinkClickListener.onDeepLinkClick(this.a);
        }
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(@NotNull TextPaint textPaint) {
        Intrinsics.checkNotNullParameter(textPaint, "ds");
        if (this.c) {
            textPaint.setColor(textPaint.linkColor);
            textPaint.setUnderlineText(false);
        }
    }

    public DeepLinkSpan(@NotNull DeepLink deepLink, @Nullable OnDeepLinkClickListener onDeepLinkClickListener, boolean z) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        this.a = deepLink;
        this.b = onDeepLinkClickListener;
        this.c = z;
    }
}
