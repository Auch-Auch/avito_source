package com.avito.android.lib.design.snackbar;

import a2.g.r.g;
import android.content.Context;
import android.view.View;
import com.avito.android.lib.design.R;
import com.avito.android.lib.design.snackbar.SnackbarView;
import com.avito.android.remote.auth.AuthSource;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0018\u0018\u0000 ?2\u00020\u0001:\u0001?B\u0017\u0012\u0006\u0010$\u001a\u00020!\u0012\u0006\u00109\u001a\u00020\u0006¢\u0006\u0004\b=\u0010>J\u0015\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0007\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\u000b\u001a\u00020\u00002\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\r\u0010\u001a\u001a\u00020\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ\r\u0010\u001c\u001a\u00020\n¢\u0006\u0004\b\u001c\u0010\u001dR\u0016\u0010 \u001a\u00020\u00138\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u001e\u0010'\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010+\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010.\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0018\u00101\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0018\u00104\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00107\u001a\u00020\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u00109\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b8\u00100R\u0016\u0010<\u001a\u00020\u00108\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b:\u0010;¨\u0006@"}, d2 = {"Lcom/avito/android/lib/design/snackbar/Snackbar;", "", "Landroid/view/View;", "value", "setAnchorView", "(Landroid/view/View;)Lcom/avito/android/lib/design/snackbar/Snackbar;", "", "setActionText", "(Ljava/lang/String;)Lcom/avito/android/lib/design/snackbar/Snackbar;", "Lkotlin/Function0;", "", "setAction", "(Lkotlin/jvm/functions/Function0;)Lcom/avito/android/lib/design/snackbar/Snackbar;", "", "setDuration", "(I)Lcom/avito/android/lib/design/snackbar/Snackbar;", "Lcom/avito/android/lib/design/snackbar/SnackbarPosition;", "setPosition", "(Lcom/avito/android/lib/design/snackbar/SnackbarPosition;)Lcom/avito/android/lib/design/snackbar/Snackbar;", "Lcom/avito/android/lib/design/snackbar/SnackbarType;", "setType", "(Lcom/avito/android/lib/design/snackbar/SnackbarType;)Lcom/avito/android/lib/design/snackbar/Snackbar;", "Lcom/avito/android/lib/design/snackbar/SnackbarView$OnDismissListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setDismissListener", "(Lcom/avito/android/lib/design/snackbar/SnackbarView$OnDismissListener;)Lcom/avito/android/lib/design/snackbar/Snackbar;", "show", "()Lcom/avito/android/lib/design/snackbar/Snackbar;", "dismiss", "()V", g.a, "Lcom/avito/android/lib/design/snackbar/SnackbarType;", "snackbarType", "Landroid/content/Context;", "i", "Landroid/content/Context;", "context", "c", "Lkotlin/jvm/functions/Function0;", "action", "Lcom/avito/android/lib/design/snackbar/SnackbarView;", "h", "Lcom/avito/android/lib/design/snackbar/SnackbarView;", "snackbarView", "d", "Lcom/avito/android/lib/design/snackbar/SnackbarView$OnDismissListener;", "dismissListener", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "actionText", AuthSource.SEND_ABUSE, "Landroid/view/View;", "anchorView", "e", "I", "duration", "j", "text", "f", "Lcom/avito/android/lib/design/snackbar/SnackbarPosition;", VKApiConst.POSITION, "<init>", "(Landroid/content/Context;Ljava/lang/String;)V", "Companion", "components_release"}, k = 1, mv = {1, 4, 2})
public final class Snackbar {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int LENGTH_LONG = 2750;
    public static final int LENGTH_SHORT = 1500;
    public View a;
    public String b;
    public Function0<Unit> c;
    public SnackbarView.OnDismissListener d;
    public int e = 2750;
    public SnackbarPosition f = SnackbarPosition.OVERLAY_VIEW_BOTTOM;
    public SnackbarType g = SnackbarType.DEFAULT;
    public SnackbarView h;
    public final Context i;
    public final String j;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/avito/android/lib/design/snackbar/Snackbar$Companion;", "", "", "LENGTH_LONG", "I", "LENGTH_SHORT", "<init>", "()V", "components_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public Snackbar(@NotNull Context context, @NotNull String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "text");
        this.i = context;
        this.j = str;
    }

    public final void dismiss() {
        SnackbarView snackbarView = this.h;
        if (snackbarView != null) {
            snackbarView.close();
        }
    }

    @NotNull
    public final Snackbar setAction(@Nullable Function0<Unit> function0) {
        this.c = function0;
        return this;
    }

    @NotNull
    public final Snackbar setActionText(@Nullable String str) {
        this.b = str;
        return this;
    }

    @NotNull
    public final Snackbar setAnchorView(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "value");
        this.a = view;
        return this;
    }

    @NotNull
    public final Snackbar setDismissListener(@NotNull SnackbarView.OnDismissListener onDismissListener) {
        Intrinsics.checkNotNullParameter(onDismissListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.d = onDismissListener;
        return this;
    }

    @NotNull
    public final Snackbar setDuration(int i2) {
        this.e = i2;
        return this;
    }

    @NotNull
    public final Snackbar setPosition(@NotNull SnackbarPosition snackbarPosition) {
        Intrinsics.checkNotNullParameter(snackbarPosition, "value");
        this.f = snackbarPosition;
        return this;
    }

    @NotNull
    public final Snackbar setType(@NotNull SnackbarType snackbarType) {
        Intrinsics.checkNotNullParameter(snackbarType, "value");
        this.g = snackbarType;
        return this;
    }

    @NotNull
    public final Snackbar show() {
        int i2;
        int i3;
        SnackbarView snackbarView = this.h;
        if (snackbarView != null) {
            snackbarView.close();
        }
        this.h = null;
        SnackbarType snackbarType = this.g;
        SnackbarType snackbarType2 = SnackbarType.DEFAULT;
        if (snackbarType == snackbarType2) {
            i2 = R.attr.snackbar;
        } else {
            i2 = R.attr.snackbarError;
        }
        if (snackbarType == snackbarType2) {
            i3 = R.style.Design_Widget_Snackbar_Default;
        } else {
            i3 = R.style.Design_Widget_Snackbar_Error;
        }
        SnackbarView snackbarView2 = new SnackbarView(this.i, null, i2, i3);
        snackbarView2.setText(this.j);
        snackbarView2.setActionText(this.b);
        snackbarView2.setAction(this.c);
        snackbarView2.setAnchorView(this.a);
        snackbarView2.setDuration(this.e);
        snackbarView2.setPosition(this.f);
        snackbarView2.setSnackbarType(this.g);
        snackbarView2.setDismissListener(this.d);
        this.h = snackbarView2;
        snackbarView2.show();
        return this;
    }
}
