package com.avito.android.lib.design.bottom_sheet;

import a2.g.r.g;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatDialog;
import com.avito.android.lastclick.LastClick;
import com.avito.android.lib.design.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.search.map.view.PanelStateKt;
import com.avito.android.util.Logs;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import com.yandex.mobile.ads.video.tracking.Tracker;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u001b\n\u0002\u0010\u0007\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 \u00012\u00020\u0001:\u0002\u0001B \b\u0016\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\t\b\u0002\u0010\u0001\u001a\u00020\u0007¢\u0006\u0006\b\u0001\u0010\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\rJ\u0019\u0010\u0011\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0013\u0010\rJ\r\u0010\u0014\u001a\u00020\u0004¢\u0006\u0004\b\u0014\u0010\rJ\u001d\u0010\u0016\u001a\u00020\u00042\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\t¢\u0006\u0004\b\u0019\u0010\u001aJ%\u0010\u0016\u001a\u00020\u00042\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00152\u0006\u0010\u001b\u001a\u00020\t¢\u0006\u0004\b\u0016\u0010\u001cJ\u001d\u0010\u001d\u001a\u00020\u00042\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u001d\u0010\u0017J\u001d\u0010\u001e\u001a\u00020\u00042\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u001e\u0010\u0017J\u0017\u0010 \u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u0007H\u0016¢\u0006\u0004\b \u0010!J\u001d\u0010 \u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u0007¢\u0006\u0004\b \u0010#JO\u0010 \u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u00072\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u00040$2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u00040$2\b\b\u0002\u0010(\u001a\u00020\t¢\u0006\u0004\b \u0010)J)\u0010 \u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u00072\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u00040$¢\u0006\u0004\b \u0010*J\u001d\u0010 \u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\t¢\u0006\u0004\b \u0010+J\u001d\u0010 \u001a\u00020\u00042\u0006\u0010,\u001a\u00020%2\u0006\u0010(\u001a\u00020\t¢\u0006\u0004\b \u0010-J\u0017\u0010 \u001a\u00020\u00042\u0006\u0010,\u001a\u00020%H\u0016¢\u0006\u0004\b \u0010.J!\u0010 \u001a\u00020\u00042\u0006\u0010,\u001a\u00020%2\b\u00100\u001a\u0004\u0018\u00010/H\u0016¢\u0006\u0004\b \u00101J1\u0010 \u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\t2\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u00040$¢\u0006\u0004\b \u00102J\u0017\u00104\u001a\u00020\u00042\u0006\u00103\u001a\u00020\u0007H\u0016¢\u0006\u0004\b4\u0010!J\u0019\u00104\u001a\u00020\u00042\b\u00106\u001a\u0004\u0018\u000105H\u0016¢\u0006\u0004\b4\u00107J\u0017\u00109\u001a\u00020\u00042\b\b\u0001\u00108\u001a\u00020\u0007¢\u0006\u0004\b9\u0010!J9\u0010=\u001a\u00020\u00042\n\b\u0002\u00106\u001a\u0004\u0018\u0001052\n\b\u0002\u0010:\u001a\u0004\u0018\u0001052\b\b\u0002\u0010;\u001a\u00020\t2\b\b\u0002\u0010<\u001a\u00020\t¢\u0006\u0004\b=\u0010>J\u0015\u0010?\u001a\u00020\u00042\u0006\u0010,\u001a\u00020%¢\u0006\u0004\b?\u0010.J\u0015\u0010A\u001a\u00020\u00042\u0006\u0010@\u001a\u00020\t¢\u0006\u0004\bA\u0010\u001aJ\u0015\u0010B\u001a\u00020\u00042\u0006\u0010,\u001a\u00020%¢\u0006\u0004\bB\u0010.J\u0015\u0010D\u001a\u00020\u00042\u0006\u0010C\u001a\u00020\u0007¢\u0006\u0004\bD\u0010!J\u0015\u0010F\u001a\u00020\u00042\u0006\u0010E\u001a\u00020\t¢\u0006\u0004\bF\u0010\u001aJ\u0017\u0010H\u001a\u00020\u00042\u0006\u0010G\u001a\u00020\tH\u0016¢\u0006\u0004\bH\u0010\u001aJ\u0017\u0010J\u001a\u00020\u00042\u0006\u0010I\u001a\u00020\tH\u0016¢\u0006\u0004\bJ\u0010\u001aJ\r\u0010K\u001a\u00020\u0004¢\u0006\u0004\bK\u0010\rJ\r\u0010L\u001a\u00020\u0004¢\u0006\u0004\bL\u0010\rJ\u0015\u0010N\u001a\u00020\u00042\u0006\u0010M\u001a\u00020\t¢\u0006\u0004\bN\u0010\u001aJ\u0015\u0010P\u001a\u00020\u00042\u0006\u0010O\u001a\u00020\t¢\u0006\u0004\bP\u0010\u001aJ\u0015\u0010S\u001a\u00020\u00042\u0006\u0010R\u001a\u00020Q¢\u0006\u0004\bS\u0010TJ\u0015\u0010V\u001a\u00020\u00042\u0006\u0010U\u001a\u00020\t¢\u0006\u0004\bV\u0010\u001aJ\u0015\u0010X\u001a\u00020\u00042\u0006\u0010W\u001a\u00020\u0007¢\u0006\u0004\bX\u0010!J\r\u0010Y\u001a\u00020\u0004¢\u0006\u0004\bY\u0010\rJ\u0015\u0010[\u001a\u00020\u00042\u0006\u0010Z\u001a\u00020\t¢\u0006\u0004\b[\u0010\u001aR\u0016\u0010<\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\\\u0010]R\u0016\u0010;\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b^\u0010]R\u0018\u00106\u001a\u0004\u0018\u0001058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b_\u0010`R\u0018\u0010:\u001a\u0004\u0018\u0001058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\ba\u0010`R\u0016\u0010c\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bb\u0010]R\u0018\u0010g\u001a\u0004\u0018\u00010d8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\be\u0010fR\"\u0010l\u001a\u00020\t8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bh\u0010]\u001a\u0004\bi\u0010j\"\u0004\bk\u0010\u001aR\u0016\u0010n\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bm\u0010]R\u0016\u0010p\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bo\u0010]R\u0016\u0010C\u001a\u00020\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bq\u0010rR6\u0010z\u001a\u0016\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0004\u0018\u00010s8\u0004@\u0004X\u000e¢\u0006\u0012\n\u0004\bt\u0010u\u001a\u0004\bv\u0010w\"\u0004\bx\u0010yR6\u0010~\u001a\u0016\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020Q\u0012\u0004\u0012\u00020\u0004\u0018\u00010s8\u0004@\u0004X\u000e¢\u0006\u0012\n\u0004\b{\u0010u\u001a\u0004\b|\u0010w\"\u0004\b}\u0010yR\u0017\u0010\u0001\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0010]R\u001b\u0010\u0001\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u0018\u0010\u0001\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\u0001\u0010]R\u0018\u0010\u0001\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\u0001\u0010]¨\u0006\u0001"}, d2 = {"Lcom/avito/android/lib/design/bottom_sheet/BottomSheetDialog;", "Landroidx/appcompat/app/AppCompatDialog;", "Landroid/content/DialogInterface$OnDismissListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "setOnDismissListener", "(Landroid/content/DialogInterface$OnDismissListener;)V", "", "featureId", "", "supportRequestWindowFeature", "(I)Z", "onAttachedToWindow", "()V", "onDetachedFromWindow", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "onStart", "showBottomSheet", "Lkotlin/Function0;", "setOnCloseListener", "(Lkotlin/jvm/functions/Function0;)V", "manuallyDismiss", "setManualDismissOnCancelClick", "(Z)V", "dismissManually", "(Lkotlin/jvm/functions/Function0;Z)V", "setOnActionClickListener", "setOnClickOutsideViewListener", "layoutResId", "setContentView", "(I)V", "footerLayoutResId", "(II)V", "Lkotlin/Function1;", "Landroid/view/View;", "onInflated", "onFooterInflated", "supportTablets", "(IILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Z)V", "(ILkotlin/jvm/functions/Function1;)V", "(IZ)V", "view", "(Landroid/view/View;Z)V", "(Landroid/view/View;)V", "Landroid/view/ViewGroup$LayoutParams;", "params", "(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V", "(IZLkotlin/jvm/functions/Function1;)V", "titleId", "setTitle", "", "title", "(Ljava/lang/CharSequence;)V", "iconId", "setCloseButtonIcon", "actionTitle", "showCloseButton", "showHeaderThumb", "setHeaderParams", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZ)V", "setCustomHeader", "show", "showActionButton", "setScrimBackgroundView", "peekHeight", "setPeekHeight", "active", "setActionButtonActive", "cancelable", "setCancelable", "cancel", "setCanceledOnTouchOutside", "close", Tracker.Events.CREATIVE_EXPAND, PanelStateKt.PANEL_EXPANDED, "setForceExpandedState", "skipCollapsed", "setSkipCollapsed", "", "elevation", "setElevation", "(F)V", "shouldFit", "setFitContentPeekHeight", "thumbHeight", "setThumbLayoutHeight", "forceShowHeaderThumb", "value", "setInvokeCloseListenerBeforeDismiss", "i", "Z", "h", "f", "Ljava/lang/CharSequence;", g.a, "n", "invokeCloseListenerBeforeDismiss", "Lcom/avito/android/lib/design/bottom_sheet/ModalBottomSheetView;", "o", "Lcom/avito/android/lib/design/bottom_sheet/ModalBottomSheetView;", "bottomSheetView", "r", "getShowOnStart", "()Z", "setShowOnStart", "showOnStart", "c", "isCancelable", "e", "overrideThemeCancelOnTouchOutside", "j", "I", "Lkotlin/Function2;", "p", "Lkotlin/jvm/functions/Function2;", "getOnBottomSheetStateChangedListener", "()Lkotlin/jvm/functions/Function2;", "setOnBottomSheetStateChangedListener", "(Lkotlin/jvm/functions/Function2;)V", "onBottomSheetStateChangedListener", VKApiConst.Q, "getOnBottomSheetSlideListener", "setOnBottomSheetSlideListener", "onBottomSheetSlideListener", AuthSource.OPEN_CHANNEL_LIST, "peekHeightAsContentHeight", "l", "Landroid/view/View;", "customHeader", "d", "isCanceledOnTouchOutside", "k", "isAttachedToWindow", "Landroid/content/Context;", "context", "theme", "<init>", "(Landroid/content/Context;I)V", "Companion", "components_release"}, k = 1, mv = {1, 4, 2})
public class BottomSheetDialog extends AppCompatDialog {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public boolean c;
    public boolean d;
    public boolean e;
    public CharSequence f;
    public CharSequence g;
    public boolean h;
    public boolean i;
    public int j;
    public boolean k;
    public View l;
    public boolean m;
    public boolean n;
    public ModalBottomSheetView o;
    @Nullable
    public Function2<? super View, ? super Integer, Unit> p;
    @Nullable
    public Function2<? super View, ? super Float, Unit> q;
    public boolean r;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/lib/design/bottom_sheet/BottomSheetDialog$Companion;", "", "<init>", "()V", "components_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public static final int access$getThemeResId(Companion companion, Context context, int i) {
            Objects.requireNonNull(companion);
            if (i != 0) {
                return i;
            }
            TypedValue typedValue = new TypedValue();
            if (context.getTheme().resolveAttribute(R.attr.bottomSheetDialog, typedValue, true)) {
                return typedValue.resourceId;
            }
            return R.style.Design_Widget_BottomSheetDialog;
        }

        public Companion(j jVar) {
        }
    }

    public static final class a implements DialogInterface.OnDismissListener {
        public final /* synthetic */ DialogInterface.OnDismissListener a;

        public a(DialogInterface.OnDismissListener onDismissListener) {
            this.a = onDismissListener;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface dialogInterface) {
            LastClick.Updater.update();
            DialogInterface.OnDismissListener onDismissListener = this.a;
            if (onDismissListener != null) {
                onDismissListener.onDismiss(dialogInterface);
            }
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BottomSheetDialog(Context context, int i2, int i3, j jVar) {
        this(context, (i3 & 2) != 0 ? 0 : i2);
    }

    public static final void access$dismissSafely(BottomSheetDialog bottomSheetDialog) {
        Objects.requireNonNull(bottomSheetDialog);
        try {
            if (bottomSheetDialog.k) {
                bottomSheetDialog.dismiss();
            }
        } catch (Exception e2) {
            Logs.debug("BottomSheetDialog", "Error during dismiss", e2);
        }
    }

    /* JADX INFO: finally extract failed */
    public static final boolean access$shouldWindowCloseOnTouchOutside(BottomSheetDialog bottomSheetDialog) {
        if (!bottomSheetDialog.e) {
            TypedArray obtainStyledAttributes = bottomSheetDialog.getContext().obtainStyledAttributes(new int[]{16843611});
            try {
                boolean z = obtainStyledAttributes.getBoolean(0, true);
                obtainStyledAttributes.recycle();
                bottomSheetDialog.d = z;
                bottomSheetDialog.e = true;
            } catch (Throwable th) {
                obtainStyledAttributes.recycle();
                throw th;
            }
        }
        return bottomSheetDialog.d;
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00da  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.view.View b(com.avito.android.lib.design.bottom_sheet.BottomSheetDialog r16, int r17, android.view.View r18, android.view.ViewGroup.LayoutParams r19, int r20, kotlin.jvm.functions.Function1 r21, kotlin.jvm.functions.Function1 r22, boolean r23, int r24, java.lang.Object r25) {
        /*
        // Method dump skipped, instructions count: 311
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.lib.design.bottom_sheet.BottomSheetDialog.b(com.avito.android.lib.design.bottom_sheet.BottomSheetDialog, int, android.view.View, android.view.ViewGroup$LayoutParams, int, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, boolean, int, java.lang.Object):android.view.View");
    }

    public static /* synthetic */ void setContentView$default(BottomSheetDialog bottomSheetDialog, int i2, int i3, Function1 function1, Function1 function12, boolean z, int i4, Object obj) {
        if (obj == null) {
            bottomSheetDialog.setContentView(i2, i3, function1, function12, (i4 & 16) != 0 ? false : z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setContentView");
    }

    public static /* synthetic */ void setHeaderParams$default(BottomSheetDialog bottomSheetDialog, CharSequence charSequence, CharSequence charSequence2, boolean z, boolean z2, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 1) != 0) {
                charSequence = null;
            }
            if ((i2 & 2) != 0) {
                charSequence2 = null;
            }
            if ((i2 & 4) != 0) {
                z = false;
            }
            if ((i2 & 8) != 0) {
                z2 = false;
            }
            bottomSheetDialog.setHeaderParams(charSequence, charSequence2, z, z2);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setHeaderParams");
    }

    public final void close() {
        ModalBottomSheetView modalBottomSheetView = this.o;
        if (modalBottomSheetView != null) {
            modalBottomSheetView.dismiss();
        }
    }

    public final void expand() {
        ModalBottomSheetView modalBottomSheetView = this.o;
        if (modalBottomSheetView != null) {
            modalBottomSheetView.expand();
        }
    }

    public final void forceShowHeaderThumb() {
        ModalBottomSheetView modalBottomSheetView = this.o;
        if (modalBottomSheetView != null) {
            modalBottomSheetView.forceShowHeaderThumb();
        }
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.jvm.functions.Function2<? super android.view.View, ? super java.lang.Float, kotlin.Unit>, kotlin.jvm.functions.Function2<android.view.View, java.lang.Float, kotlin.Unit> */
    @Nullable
    public final Function2<View, Float, Unit> getOnBottomSheetSlideListener() {
        return this.q;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.jvm.functions.Function2<? super android.view.View, ? super java.lang.Integer, kotlin.Unit>, kotlin.jvm.functions.Function2<android.view.View, java.lang.Integer, kotlin.Unit> */
    @Nullable
    public final Function2<View, Integer, Unit> getOnBottomSheetStateChangedListener() {
        return this.p;
    }

    public final boolean getShowOnStart() {
        return this.r;
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.k = true;
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        if (window != null) {
            window.clearFlags(67108864);
            window.addFlags(Integer.MIN_VALUE);
            window.setLayout(-1, -1);
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        this.k = false;
        super.onDetachedFromWindow();
    }

    @Override // android.app.Dialog
    public void onStart() {
        ModalBottomSheetView modalBottomSheetView;
        super.onStart();
        if (this.r && (modalBottomSheetView = this.o) != null) {
            modalBottomSheetView.show();
        }
    }

    public final void setActionButtonActive(boolean z) {
        ModalBottomSheetView modalBottomSheetView = this.o;
        if (modalBottomSheetView != null) {
            modalBottomSheetView.setActionButtonActive(z);
        }
    }

    @Override // android.app.Dialog
    public void setCancelable(boolean z) {
        if (this.c != z) {
            this.c = z;
            ModalBottomSheetView modalBottomSheetView = this.o;
            if (modalBottomSheetView != null) {
                modalBottomSheetView.setHideable(z);
            }
        }
    }

    @Override // android.app.Dialog
    public void setCanceledOnTouchOutside(boolean z) {
        super.setCanceledOnTouchOutside(z);
        if (z && !this.c) {
            this.c = true;
        }
        this.d = z;
        this.e = true;
        ModalBottomSheetView modalBottomSheetView = this.o;
        if (modalBottomSheetView != null) {
            modalBottomSheetView.setCancelOnTouchOutside(z);
        }
    }

    public final void setCloseButtonIcon(@DrawableRes int i2) {
        ModalBottomSheetView modalBottomSheetView = this.o;
        if (modalBottomSheetView != null) {
            modalBottomSheetView.setCloseButtonIcon(i2);
        }
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void setContentView(int i2) {
        super.setContentView(b(this, i2, null, null, 0, null, null, false, 126, null));
    }

    public final void setCustomHeader(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.l = view;
        ModalBottomSheetView modalBottomSheetView = this.o;
        if (modalBottomSheetView != null) {
            modalBottomSheetView.setCustomHeader(view);
        }
    }

    public final void setElevation(float f2) {
        ModalBottomSheetView modalBottomSheetView = this.o;
        if (modalBottomSheetView != null && (modalBottomSheetView instanceof TabletBottomSheetView)) {
            ((TabletBottomSheetView) modalBottomSheetView).setElevation(f2);
        }
    }

    public final void setFitContentPeekHeight(boolean z) {
        if (this.m != z) {
            this.m = z;
            ModalBottomSheetView modalBottomSheetView = this.o;
            if (modalBottomSheetView != null) {
                modalBottomSheetView.setFitContentPeekHeight(z);
            }
            if (!z) {
                setPeekHeight(this.j);
            }
        }
    }

    public final void setForceExpandedState(boolean z) {
        ModalBottomSheetView modalBottomSheetView = this.o;
        if (modalBottomSheetView != null) {
            modalBottomSheetView.setForceExpandedState(z);
        }
    }

    public final void setHeaderParams(@Nullable CharSequence charSequence, @Nullable CharSequence charSequence2, boolean z, boolean z2) {
        this.f = charSequence;
        this.g = charSequence2;
        this.h = z;
        this.i = z2;
        ModalBottomSheetView modalBottomSheetView = this.o;
        if (modalBottomSheetView != null) {
            modalBottomSheetView.setHeaderParams(charSequence, charSequence2, z, z2);
        }
    }

    public final void setInvokeCloseListenerBeforeDismiss(boolean z) {
        this.n = z;
    }

    public final void setManualDismissOnCancelClick(boolean z) {
        ModalBottomSheetView modalBottomSheetView = this.o;
        if (modalBottomSheetView != null) {
            modalBottomSheetView.setManualDismissOnCancelClick(z);
        }
    }

    public final void setOnActionClickListener(@Nullable Function0<Unit> function0) {
        ModalBottomSheetView modalBottomSheetView = this.o;
        if (modalBottomSheetView != null) {
            modalBottomSheetView.setOnActionClickListener(function0);
        }
    }

    public final void setOnBottomSheetSlideListener(@Nullable Function2<? super View, ? super Float, Unit> function2) {
        this.q = function2;
    }

    public final void setOnBottomSheetStateChangedListener(@Nullable Function2<? super View, ? super Integer, Unit> function2) {
        this.p = function2;
    }

    public final void setOnClickOutsideViewListener(@Nullable Function0<Unit> function0) {
        ModalBottomSheetView modalBottomSheetView = this.o;
        if (modalBottomSheetView != null) {
            modalBottomSheetView.setOnClickOutsideViewListener(function0);
        }
    }

    public final void setOnCloseListener(@Nullable Function0<Unit> function0) {
        ModalBottomSheetView modalBottomSheetView = this.o;
        if (modalBottomSheetView != null) {
            modalBottomSheetView.setOnCloseListener(function0);
        }
    }

    @Override // android.app.Dialog
    public final void setOnDismissListener(@Nullable DialogInterface.OnDismissListener onDismissListener) {
        super.setOnDismissListener(new a(onDismissListener));
    }

    public final void setPeekHeight(int i2) {
        this.j = i2;
        ModalBottomSheetView modalBottomSheetView = this.o;
        if (modalBottomSheetView != null) {
            modalBottomSheetView.setPeekHeight(i2);
        }
        setFitContentPeekHeight(false);
    }

    public final void setScrimBackgroundView(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        ModalBottomSheetView modalBottomSheetView = this.o;
        if (modalBottomSheetView != null) {
            modalBottomSheetView.setScrimBackgroundView(view);
        }
    }

    public final void setShowOnStart(boolean z) {
        this.r = z;
    }

    public final void setSkipCollapsed(boolean z) {
        ModalBottomSheetView modalBottomSheetView = this.o;
        if (modalBottomSheetView != null) {
            modalBottomSheetView.setSkipCollapsed(z);
        }
    }

    public final void setThumbLayoutHeight(int i2) {
        ModalBottomSheetView modalBottomSheetView = this.o;
        if (modalBottomSheetView != null) {
            modalBottomSheetView.setThumbLayoutHeight(i2);
        }
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void setTitle(int i2) {
        setHeaderParams$default(this, getContext().getText(i2), null, false, false, 14, null);
    }

    public final void showActionButton(boolean z) {
        ModalBottomSheetView modalBottomSheetView = this.o;
        if (modalBottomSheetView != null) {
            modalBottomSheetView.showActionButton(z);
        }
    }

    public final void showBottomSheet() {
        ModalBottomSheetView modalBottomSheetView = this.o;
        if (modalBottomSheetView != null) {
            modalBottomSheetView.show();
        }
    }

    @Override // androidx.appcompat.app.AppCompatDialog
    public final boolean supportRequestWindowFeature(int i2) {
        return super.supportRequestWindowFeature(i2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BottomSheetDialog(@NotNull Context context, int i2) {
        super(context, Companion.access$getThemeResId(Companion, context, i2));
        Intrinsics.checkNotNullParameter(context, "context");
        this.c = true;
        this.d = true;
        this.j = -1;
        this.r = true;
        setOnDismissListener(null);
        supportRequestWindowFeature(1);
    }

    public final void setContentView(int i2, int i3) {
        super.setContentView(b(this, i2, null, null, i3, null, null, false, 118, null));
    }

    public final void setOnCloseListener(@Nullable Function0<Unit> function0, boolean z) {
        ModalBottomSheetView modalBottomSheetView = this.o;
        if (modalBottomSheetView != null) {
            modalBottomSheetView.setOnCloseListener(function0);
        }
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void setTitle(@Nullable CharSequence charSequence) {
        setHeaderParams$default(this, charSequence, null, false, false, 14, null);
    }

    public final void setContentView(int i2, int i3, @NotNull Function1<? super View, Unit> function1, @NotNull Function1<? super View, Unit> function12, boolean z) {
        Intrinsics.checkNotNullParameter(function1, "onInflated");
        Intrinsics.checkNotNullParameter(function12, "onFooterInflated");
        super.setContentView(b(this, i2, null, null, i3, function1, function12, z, 6, null));
    }

    public final void setContentView(int i2, @NotNull Function1<? super View, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "onInflated");
        super.setContentView(b(this, i2, null, null, 0, function1, null, false, 110, null));
    }

    public final void setContentView(int i2, boolean z) {
        super.setContentView(b(this, i2, null, null, 0, null, null, z, 62, null));
    }

    public final void setContentView(@NotNull View view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.setContentView(b(this, 0, view, null, 0, null, null, z, 61, null));
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void setContentView(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.setContentView(b(this, 0, view, null, 0, null, null, false, 125, null));
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void setContentView(@NotNull View view, @Nullable ViewGroup.LayoutParams layoutParams) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.setContentView(b(this, 0, view, layoutParams, 0, null, null, false, 121, null));
    }

    public final void setContentView(int i2, boolean z, @NotNull Function1<? super View, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "onInflated");
        super.setContentView(b(this, i2, null, null, 0, function1, null, z, 46, null));
    }
}
