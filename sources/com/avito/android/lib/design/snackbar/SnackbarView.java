package com.avito.android.lib.design.snackbar;

import a2.g.r.g;
import android.animation.Animator;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.avito.android.advert_core.analytics.contactbar.PhonePageSourceKt;
import com.avito.android.lib.design.R;
import com.avito.android.lib.design.button.Button;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Views;
import com.vk.sdk.api.VKApiConst;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.h;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b*\u0001f\u0018\u0000 \u00012\u00020\u0001:\u0004\u0001\u0001B9\b\u0007\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\f\b\u0002\u0010\u0001\u001a\u0005\u0018\u00010\u0001\u0012\t\b\u0002\u0010\u0001\u001a\u00020\u0002\u0012\t\b\u0002\u0010\u0001\u001a\u00020\u0002¢\u0006\u0006\b\u0001\u0010\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\t\u0010\u0004J\u000f\u0010\n\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\n\u0010\u0004J\u000f\u0010\u000b\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000b\u0010\u0004J\u000f\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0012\u001a\u00020\u000f¢\u0006\u0004\b\u0012\u0010\u0011J\r\u0010\u0013\u001a\u00020\u000f¢\u0006\u0004\b\u0013\u0010\u0011J\r\u0010\u0014\u001a\u00020\u000f¢\u0006\u0004\b\u0014\u0010\u0011J\r\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0016\u0010\u0017J\r\u0010\u0018\u001a\u00020\u000f¢\u0006\u0004\b\u0018\u0010\u0011J\u000f\u0010\u0019\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0019\u0010\u0011J\u0011\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0002¢\u0006\u0004\b\u001b\u0010\u001cR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\"\u0010(\u001a\u00020!8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u0016\u0010+\u001a\u00020\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010.\u001a\u00020\u00018\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0018\u00101\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00104\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00106\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b5\u00103R\"\u0010=\u001a\u0002078\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0019\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u0016\u0010?\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b>\u00103R\u0016\u0010A\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b@\u00103R\u0016\u0010C\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bB\u00103R\u001e\u0010G\u001a\n\u0012\u0004\u0012\u00020E\u0018\u00010D8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b*\u0010FR*\u0010O\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010H8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bI\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\u0016\u0010Q\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bP\u00103R\u0016\u0010S\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bR\u00103R\u0016\u0010W\u001a\u00020T8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bU\u0010VR\u0016\u0010Y\u001a\u00020\u001d8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bX\u0010\u001fR\u0016\u0010[\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bZ\u00103R\u0016\u0010]\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\\\u00103R\u0016\u0010_\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b^\u00103R\u0016\u0010a\u001a\u00020\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b`\u0010*R\u0016\u0010c\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bb\u00103R\u0016\u0010e\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bd\u00103R\u0016\u0010i\u001a\u00020f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bg\u0010hR$\u0010m\u001a\u0004\u0018\u0001078\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bj\u00108\u001a\u0004\bk\u0010:\"\u0004\bl\u0010<R\u0016\u0010o\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bn\u00103R\"\u0010t\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bp\u00103\u001a\u0004\bq\u0010\u0004\"\u0004\br\u0010sR\u0016\u0010x\u001a\u00020u8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bv\u0010wR%\u0010\u0001\u001a\u0004\u0018\u00010y8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bz\u0010{\u001a\u0004\b|\u0010}\"\u0004\b~\u0010R*\u0010\u0001\u001a\u0004\u0018\u00010E8\u0006@\u0006X\u000e¢\u0006\u0017\n\u0005\b\u001b\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R\u0018\u0010\u0001\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\u0001\u00103R\u0018\u0010\u0001\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\u0001\u00103R\u0018\u0010\u0001\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\u0001\u00103R*\u0010\u0001\u001a\u00030\u00018\u0006@\u0006X\u000e¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001¨\u0006\u0001"}, d2 = {"Lcom/avito/android/lib/design/snackbar/SnackbarView;", "Landroid/widget/LinearLayout;", "", "getTopMargin", "()I", "getStatusBarHeight", "", "getStartYBySnackbarType", "()F", "getDisplayHeight", "getDisplayWidth", "getNavigationBarHeight", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", "", "onDetachedFromWindow", "()V", "show", "closeImmediately", "close", "Landroid/widget/FrameLayout$LayoutParams;", "getNewLayoutParams", "()Landroid/widget/FrameLayout$LayoutParams;", "prepareBeforeShow", AuthSource.BOOKING_ORDER, "Landroid/widget/FrameLayout;", AuthSource.SEND_ABUSE, "()Landroid/widget/FrameLayout;", "", "z", "Z", "isAnimating", "Lcom/avito/android/lib/design/snackbar/SnackbarPosition;", "f", "Lcom/avito/android/lib/design/snackbar/SnackbarPosition;", "getPosition", "()Lcom/avito/android/lib/design/snackbar/SnackbarPosition;", "setPosition", "(Lcom/avito/android/lib/design/snackbar/SnackbarPosition;)V", VKApiConst.POSITION, "x", "F", "startPoint", ExifInterface.LONGITUDE_EAST, "Landroid/widget/LinearLayout;", "snackbarContainer", "G", "Landroid/widget/FrameLayout;", "tempFrameLayout", "o", "I", "buttonMarginBottomSingleLine", "t", "textMarginTop", "", "Ljava/lang/String;", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "text", "u", "textMarginBottom", "n", "buttonMarginTopSingleLine", "w", "marginRight", "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "Ljava/lang/ref/WeakReference;", "anchorViewRef", "Lkotlin/Function0;", "d", "Lkotlin/jvm/functions/Function0;", "getAction", "()Lkotlin/jvm/functions/Function0;", "setAction", "(Lkotlin/jvm/functions/Function0;)V", "action", "r", "snackbarPaddingLeft", "p", "buttonMarginTopMultiLine", "Landroid/widget/TextView;", "C", "Landroid/widget/TextView;", "textView", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "isTablet", "k", "textMarginTopSingleLine", "l", "textMarginBottomSingleLine", AuthSource.OPEN_CHANNEL_LIST, "textMarginRightSingleLine", "y", "endPoint", "i", "marginTop", "s", "snackbarPaddingRight", "com/avito/android/lib/design/snackbar/SnackbarView$activityLifecycleCallback$1", "H", "Lcom/avito/android/lib/design/snackbar/SnackbarView$activityLifecycleCallback$1;", "activityLifecycleCallback", "c", "getActionText", "setActionText", "actionText", VKApiConst.VERSION, "marginLeft", "e", "getDuration", "setDuration", "(I)V", "duration", "Lcom/avito/android/lib/design/button/Button;", "D", "Lcom/avito/android/lib/design/button/Button;", PhonePageSourceKt.PHONE_SOURCE_BUTTON, "Lcom/avito/android/lib/design/snackbar/SnackbarView$OnDismissListener;", "h", "Lcom/avito/android/lib/design/snackbar/SnackbarView$OnDismissListener;", "getDismissListener", "()Lcom/avito/android/lib/design/snackbar/SnackbarView$OnDismissListener;", "setDismissListener", "(Lcom/avito/android/lib/design/snackbar/SnackbarView$OnDismissListener;)V", "dismissListener", "Landroid/view/View;", "getAnchorView", "()Landroid/view/View;", "setAnchorView", "(Landroid/view/View;)V", "anchorView", "j", "increasedMarginTop", "B", "maxWidthForTablets", VKApiConst.Q, "buttonMarginBottomMultiLine", "Lcom/avito/android/lib/design/snackbar/SnackbarType;", g.a, "Lcom/avito/android/lib/design/snackbar/SnackbarType;", "getSnackbarType", "()Lcom/avito/android/lib/design/snackbar/SnackbarType;", "setSnackbarType", "(Lcom/avito/android/lib/design/snackbar/SnackbarType;)V", "snackbarType", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "Companion", "OnDismissListener", "components_release"}, k = 1, mv = {1, 4, 2})
public final class SnackbarView extends LinearLayout {
    public static final long ANIMATION_DURATION = 300;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final LinkedList<WeakReference<SnackbarView>> I = new LinkedList<>();
    public boolean A;
    public int B;
    public TextView C;
    public Button D;
    public LinearLayout E;
    public WeakReference<View> F;
    public FrameLayout G;
    public final SnackbarView$activityLifecycleCallback$1 H;
    @Nullable
    public View a;
    @NotNull
    public String b;
    @Nullable
    public String c;
    @Nullable
    public Function0<Unit> d;
    public int e;
    @NotNull
    public SnackbarPosition f;
    @NotNull
    public SnackbarType g;
    @Nullable
    public OnDismissListener h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public int p;
    public int q;
    public int r;
    public int s;
    public int t;
    public int u;
    public int v;
    public int w;
    public float x;
    public float y;
    public boolean z;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\"\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\t0\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/avito/android/lib/design/snackbar/SnackbarView$Companion;", "", "Lcom/avito/android/lib/design/snackbar/SnackbarView;", AuthSource.SEND_ABUSE, "()Lcom/avito/android/lib/design/snackbar/SnackbarView;", "", "ANIMATION_DURATION", "J", "Ljava/util/LinkedList;", "Ljava/lang/ref/WeakReference;", "queue", "Ljava/util/LinkedList;", "<init>", "()V", "components_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public static final void access$add(Companion companion, SnackbarView snackbarView) {
            Objects.requireNonNull(companion);
            SnackbarView.I.add(new WeakReference(snackbarView));
            SnackbarView a = companion.a();
            if ((!Intrinsics.areEqual(snackbarView, a)) && a != null && !a.z) {
                a.close();
            }
        }

        public static final void access$closeCurrentAndClear(Companion companion) {
            SnackbarView a = companion.a();
            SnackbarView.I.clear();
            if (a != null) {
                a.closeImmediately();
            }
        }

        public static final boolean access$isQueueEmpty(Companion companion) {
            Object obj;
            boolean z;
            Objects.requireNonNull(companion);
            Iterator it = SnackbarView.I.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (((WeakReference) obj).get() != null) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (z) {
                    break;
                }
            }
            if (obj == null) {
                return true;
            }
            return false;
        }

        public static final void access$remove(Companion companion, SnackbarView snackbarView) {
            Objects.requireNonNull(companion);
            h.removeAll((List) SnackbarView.I, (Function1) new a2.a.a.k1.a.j.a(snackbarView));
        }

        public static final void access$showNextSnackbar(Companion companion) {
            SnackbarView a = companion.a();
            if (a != null) {
                a.b();
            }
        }

        public final SnackbarView a() {
            Object obj;
            boolean z;
            if (!(!SnackbarView.I.isEmpty())) {
                return null;
            }
            Iterator it = SnackbarView.I.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (((WeakReference) obj).get() != null) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (z) {
                    break;
                }
            }
            WeakReference weakReference = (WeakReference) obj;
            if (weakReference != null) {
                return (SnackbarView) weakReference.get();
            }
            return null;
        }

        public Companion(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/avito/android/lib/design/snackbar/SnackbarView$OnDismissListener;", "", "", "onDismiss", "()V", "components_release"}, k = 1, mv = {1, 4, 2})
    public interface OnDismissListener {
        void onDismiss();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            SnackbarPosition.values();
            int[] iArr = new int[4];
            $EnumSwitchMapping$0 = iArr;
            iArr[0] = 1;
            iArr[1] = 2;
            iArr[2] = 3;
            iArr[3] = 4;
        }
    }

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ SnackbarView a;

        public a(SnackbarView snackbarView) {
            this.a = snackbarView;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Function0<Unit> action = this.a.getAction();
            if (action != null) {
                action.invoke();
            }
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ SnackbarView a;

        public b(SnackbarView snackbarView) {
            this.a = snackbarView;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.close();
        }
    }

    @JvmOverloads
    public SnackbarView(@NotNull Context context) {
        this(context, null, 0, 0, 14, null);
    }

    @JvmOverloads
    public SnackbarView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
    }

    @JvmOverloads
    public SnackbarView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0, 8, null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SnackbarView(Context context, AttributeSet attributeSet, int i2, int i3, int i4, j jVar) {
        this(context, (i4 & 2) != 0 ? null : attributeSet, (i4 & 4) != 0 ? R.attr.snackbar : i2, (i4 & 8) != 0 ? R.style.Design_Widget_Snackbar_Default : i3);
    }

    /* access modifiers changed from: private */
    public final Activity getActivity() {
        if (getContext() instanceof Activity) {
            Context context = getContext();
            Objects.requireNonNull(context, "null cannot be cast to non-null type android.app.Activity");
            return (Activity) context;
        }
        Context context2 = getContext();
        Objects.requireNonNull(context2, "null cannot be cast to non-null type android.content.ContextWrapper");
        Context baseContext = ((ContextWrapper) context2).getBaseContext();
        Objects.requireNonNull(baseContext, "null cannot be cast to non-null type android.app.Activity");
        return (Activity) baseContext;
    }

    private final int getDisplayHeight() {
        WindowManager windowManager = getActivity().getWindowManager();
        Intrinsics.checkNotNullExpressionValue(windowManager, "getActivity().windowManager");
        Display defaultDisplay = windowManager.getDefaultDisplay();
        Intrinsics.checkNotNullExpressionValue(defaultDisplay, "getActivity().windowManager.defaultDisplay");
        Point point = new Point();
        defaultDisplay.getSize(point);
        return point.y;
    }

    private final int getDisplayWidth() {
        WindowManager windowManager = getActivity().getWindowManager();
        Intrinsics.checkNotNullExpressionValue(windowManager, "getActivity().windowManager");
        Display defaultDisplay = windowManager.getDefaultDisplay();
        Intrinsics.checkNotNullExpressionValue(defaultDisplay, "getActivity().windowManager.defaultDisplay");
        Point point = new Point();
        defaultDisplay.getSize(point);
        return point.x;
    }

    private final int getNavigationBarHeight() {
        WeakReference<View> weakReference = this.F;
        View view = weakReference != null ? weakReference.get() : null;
        if (view == null) {
            return 0;
        }
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parentView.context");
        Resources resources = context.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "parentView.context.resources");
        int identifier = resources.getIdentifier(resources.getConfiguration().orientation == 1 ? "navigation_bar_height" : "navigation_bar_height_landscape", "dimen", "android");
        if (identifier > 0) {
            return resources.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    private final float getStartYBySnackbarType() {
        float displayHeight = (float) getDisplayHeight();
        if (this.y > displayHeight / ((float) 2)) {
            return displayHeight;
        }
        return 0.0f;
    }

    private final int getStatusBarHeight() {
        int identifier = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    private final int getTopMargin() {
        int i2;
        WeakReference<View> weakReference = this.F;
        View view = weakReference != null ? weakReference.get() : null;
        if (view == null) {
            return 0;
        }
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        int i3 = getNewLayoutParams().width;
        if (i3 == -2) {
            i2 = View.MeasureSpec.makeMeasureSpec(view.getWidth(), Integer.MIN_VALUE);
        } else if (i3 != -1) {
            i2 = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
        } else {
            i2 = View.MeasureSpec.makeMeasureSpec(view.getWidth(), 1073741824);
        }
        measure(i2, 0);
        int i4 = iArr[1];
        int statusBarHeight = getStatusBarHeight();
        int ordinal = this.f.ordinal();
        if (ordinal == 0) {
            return Math.max(statusBarHeight + this.j, (i4 - getMeasuredHeight()) - this.i);
        }
        if (ordinal == 1) {
            return Math.min((((getDisplayHeight() + statusBarHeight) - getNavigationBarHeight()) - this.j) - getMeasuredHeight(), view.getHeight() + i4 + this.i);
        }
        if (ordinal == 2) {
            return Math.max(this.j, i4 + this.i);
        }
        if (ordinal != 3) {
            return i4;
        }
        return Math.min((((getDisplayHeight() + statusBarHeight) - getNavigationBarHeight()) - this.j) - getMeasuredHeight(), ((view.getHeight() + i4) - getMeasuredHeight()) - this.i);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0030, code lost:
        if ((r0 instanceof android.widget.FrameLayout) == false) goto L_0x0032;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.widget.FrameLayout a() {
        /*
            r4 = this;
            android.view.View r0 = r4.a
            r1 = 0
            if (r0 == 0) goto L_0x000a
            android.view.ViewParent r0 = r0.getParent()
            goto L_0x000b
        L_0x000a:
            r0 = r1
        L_0x000b:
            if (r0 == 0) goto L_0x0032
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
        L_0x000f:
            android.view.ViewParent r2 = r0.getParent()
            boolean r3 = r2 instanceof android.widget.FrameLayout
            if (r3 == 0) goto L_0x001c
            r3 = r2
            android.widget.FrameLayout r3 = (android.widget.FrameLayout) r3
            r4.G = r3
        L_0x001c:
            boolean r2 = r2 instanceof android.view.ViewGroup
            if (r2 == 0) goto L_0x002c
            android.view.ViewParent r0 = r0.getParent()
            java.lang.String r2 = "null cannot be cast to non-null type android.view.ViewGroup"
            java.util.Objects.requireNonNull(r0, r2)
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            goto L_0x000f
        L_0x002c:
            android.widget.FrameLayout r0 = r4.G
            boolean r2 = r0 instanceof android.widget.FrameLayout
            if (r2 != 0) goto L_0x0033
        L_0x0032:
            r0 = r1
        L_0x0033:
            if (r0 == 0) goto L_0x0036
            return r0
        L_0x0036:
            android.app.Activity r0 = r4.getActivity()
            android.view.Window r0 = r0.getWindow()
            java.lang.String r2 = "getActivity().window"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            android.view.View r0 = r0.getDecorView()
            r2 = 16908290(0x1020002, float:2.3877235E-38)
            android.view.View r0 = r0.findViewById(r2)
            boolean r2 = r0 instanceof android.widget.FrameLayout
            if (r2 != 0) goto L_0x0053
            goto L_0x0054
        L_0x0053:
            r1 = r0
        L_0x0054:
            android.widget.FrameLayout r1 = (android.widget.FrameLayout) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.lib.design.snackbar.SnackbarView.a():android.widget.FrameLayout");
    }

    public final void b() {
        FrameLayout a3 = a();
        if (a3 != null) {
            prepareBeforeShow();
            WeakReference<View> weakReference = this.F;
            if ((weakReference != null ? weakReference.get() : null) == null) {
                Companion companion = Companion;
                Companion.access$remove(companion, this);
                Companion.access$showNextSnackbar(companion);
            }
            setAlpha(0.0f);
            this.y = (float) getTopMargin();
            float startYBySnackbarType = getStartYBySnackbarType();
            this.x = startYBySnackbarType;
            setY(startYBySnackbarType);
            if (getParent() != null) {
                ViewParent parent = getParent();
                Objects.requireNonNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
                ((ViewGroup) parent).removeView(this);
            }
            getActivity().getApplication().registerActivityLifecycleCallbacks(this.H);
            a3.addView(this, getNewLayoutParams());
            boolean z2 = getStartYBySnackbarType() == 0.0f;
            Ref.FloatRef floatRef = new Ref.FloatRef();
            floatRef.element = 0.0f;
            setOnTouchListener(new SnackbarSwipeListener(floatRef, z2) { // from class: com.avito.android.lib.design.snackbar.SnackbarView$setSwipe$1
                public final /* synthetic */ Ref.FloatRef c;
                public final /* synthetic */ boolean d;

                {
                    this.c = r2;
                    this.d = r3;
                }

                @Override // com.avito.android.lib.design.snackbar.SnackbarSwipeListener
                public void onFinish() {
                    SnackbarView.this.close();
                }

                @Override // com.avito.android.lib.design.snackbar.SnackbarSwipeListener
                public void onMove(float f2) {
                    if (this.d) {
                        if (f2 < ((float) 0)) {
                            SnackbarView snackbarView = SnackbarView.this;
                            snackbarView.setY(snackbarView.getY() + f2);
                            SnackbarView snackbarView2 = SnackbarView.this;
                            snackbarView2.setAlpha(snackbarView2.getY() / this.c.element);
                        }
                    } else if (f2 > ((float) 0)) {
                        SnackbarView snackbarView3 = SnackbarView.this;
                        snackbarView3.setY(snackbarView3.getY() + f2);
                        SnackbarView snackbarView4 = SnackbarView.this;
                        float y2 = snackbarView4.getY();
                        float f3 = this.c.element;
                        snackbarView4.setAlpha(((float) 1) - ((y2 - f3) / f3));
                    }
                }

                @Override // com.avito.android.lib.design.snackbar.SnackbarSwipeListener
                public void onStart(float f2) {
                    this.c.element = SnackbarView.this.getY();
                }
            });
            animate().alpha(1.0f).translationY(this.y).setDuration(300).setListener(null);
            postDelayed(new b(this), (long) this.e);
        }
    }

    public final void close() {
        if (!isAttachedToWindow()) {
            closeImmediately();
        } else {
            animate().alpha(0.0f).translationY(this.x).setDuration(300).setListener(new Animator.AnimatorListener(this) { // from class: com.avito.android.lib.design.snackbar.SnackbarView$close$1
                public final /* synthetic */ SnackbarView a;

                /* JADX WARN: Incorrect args count in method signature: ()V */
                {
                    this.a = r1;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(@Nullable Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(@Nullable Animator animator) {
                    this.a.closeImmediately();
                    this.a.z = false;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(@Nullable Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(@Nullable Animator animator) {
                    this.a.z = true;
                }
            });
        }
    }

    public final void closeImmediately() {
        OnDismissListener onDismissListener = this.h;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
        FrameLayout a3 = a();
        if ((a3 != null ? a3.indexOfChild(this) : -1) == -1) {
            Companion companion = Companion;
            Companion.access$remove(companion, this);
            getActivity().getApplication().unregisterActivityLifecycleCallbacks(this.H);
            Companion.access$showNextSnackbar(companion);
        } else if (a3 != null) {
            a3.removeView(this);
        }
    }

    @Nullable
    public final Function0<Unit> getAction() {
        return this.d;
    }

    @Nullable
    public final String getActionText() {
        return this.c;
    }

    @Nullable
    public final View getAnchorView() {
        return this.a;
    }

    @Nullable
    public final OnDismissListener getDismissListener() {
        return this.h;
    }

    public final int getDuration() {
        return this.e;
    }

    @NotNull
    public final FrameLayout.LayoutParams getNewLayoutParams() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.A ? this.B : -1, -2);
        layoutParams.gravity = 1;
        layoutParams.leftMargin = this.v;
        layoutParams.rightMargin = this.w;
        return layoutParams;
    }

    @NotNull
    public final SnackbarPosition getPosition() {
        return this.f;
    }

    @NotNull
    public final SnackbarType getSnackbarType() {
        return this.g;
    }

    @NotNull
    public final String getText() {
        return this.b;
    }

    @Override // android.view.View, android.view.ViewGroup
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Companion companion = Companion;
        Companion.access$remove(companion, this);
        getActivity().getApplication().unregisterActivityLifecycleCallbacks(this.H);
        Companion.access$showNextSnackbar(companion);
    }

    public final void prepareBeforeShow() {
        WeakReference<View> weakReference;
        if (this.a != null) {
            View view = this.a;
            Intrinsics.checkNotNull(view);
            weakReference = new WeakReference<>(view);
        } else {
            weakReference = this.F;
        }
        this.F = weakReference;
        this.C.setText(this.b);
        Button button = this.D;
        String str = this.c;
        if (str == null) {
            str = "";
        }
        button.setText(str);
        this.D.setOnClickListener(new a(this));
        if (this.c == null) {
            Views.hide(this.D);
            return;
        }
        measure(0, 0);
        if (this.D.getMeasuredWidth() + this.C.getMeasuredWidth() + 0 + this.s + this.r < (((getDisplayWidth() - this.v) - this.w) - this.r) - this.s) {
            this.E.setOrientation(0);
            this.E.setWeightSum(1.0f);
            Views.changeMargin(this.D, 0, this.n, 0, this.o);
            Views.changeMargin(this.C, 0, this.k, this.m, this.l);
            ViewGroup.LayoutParams layoutParams = this.C.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
            layoutParams2.weight = 1.0f;
            layoutParams2.gravity = 48;
            ViewGroup.LayoutParams layoutParams3 = this.D.getLayoutParams();
            Objects.requireNonNull(layoutParams3, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            ((LinearLayout.LayoutParams) layoutParams3).gravity = 48;
            return;
        }
        Views.changeMargin$default(this.C, 0, 0, 0, 0, 7, null);
        Views.changeMargin$default(this.D, 0, this.p, 0, this.q, 5, null);
    }

    public final void setAction(@Nullable Function0<Unit> function0) {
        this.d = function0;
    }

    public final void setActionText(@Nullable String str) {
        this.c = str;
    }

    public final void setAnchorView(@Nullable View view) {
        this.a = view;
    }

    public final void setDismissListener(@Nullable OnDismissListener onDismissListener) {
        this.h = onDismissListener;
    }

    public final void setDuration(int i2) {
        this.e = i2;
    }

    public final void setPosition(@NotNull SnackbarPosition snackbarPosition) {
        Intrinsics.checkNotNullParameter(snackbarPosition, "<set-?>");
        this.f = snackbarPosition;
    }

    public final void setSnackbarType(@NotNull SnackbarType snackbarType) {
        Intrinsics.checkNotNullParameter(snackbarType, "<set-?>");
        this.g = snackbarType;
    }

    public final void setText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.b = str;
    }

    public final void show() {
        Companion companion = Companion;
        if (Companion.access$isQueueEmpty(companion)) {
            Companion.access$add(companion, this);
            b();
            return;
        }
        Companion.access$add(companion, this);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SnackbarView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i2, int i3) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.b = "";
        this.e = 2750;
        this.f = SnackbarPosition.OVERLAY_VIEW_BOTTOM;
        this.g = SnackbarType.DEFAULT;
        FrameLayout a3 = a();
        this.F = a3 != null ? new WeakReference<>(a3) : null;
        this.H = new SnackbarView$activityLifecycleCallback$1(this);
        TypedValue typedValue = new TypedValue();
        ContextWrapper contextWrapper = new ContextWrapper(context);
        contextWrapper.setTheme(context.getTheme().resolveAttribute(i2, typedValue, true) ? typedValue.resourceId : i3);
        LayoutInflater.from(contextWrapper).inflate(R.layout.snackbar, (ViewGroup) this, true);
        View findViewById = findViewById(R.id.text);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.text)");
        this.C = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.actionButton);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.actionButton)");
        this.D = (Button) findViewById2;
        View findViewById3 = findViewById(R.id.snackbarContainer);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.snackbarContainer)");
        this.E = (LinearLayout) findViewById3;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.Snackbar, i2, i3);
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        this.A = context2.getResources().getBoolean(R.bool.is_tablet);
        this.t = obtainStyledAttributes.getDimensionPixelSize(R.styleable.Snackbar_snackbar_textMarginTop, this.t);
        this.k = obtainStyledAttributes.getDimensionPixelSize(R.styleable.Snackbar_snackbar_textMarginTopSingleLine, this.k);
        this.u = obtainStyledAttributes.getDimensionPixelSize(R.styleable.Snackbar_snackbar_textMarginBottom, this.u);
        this.l = obtainStyledAttributes.getDimensionPixelSize(R.styleable.Snackbar_snackbar_textMarginBottomSingleLine, this.l);
        this.m = obtainStyledAttributes.getDimensionPixelSize(R.styleable.Snackbar_snackbar_textMarginRightSingleLine, this.m);
        this.p = obtainStyledAttributes.getDimensionPixelSize(R.styleable.Snackbar_snackbar_buttonMarginTopMultiLine, this.p);
        this.n = obtainStyledAttributes.getDimensionPixelSize(R.styleable.Snackbar_snackbar_buttonMarginTopSingleLine, this.n);
        this.o = obtainStyledAttributes.getDimensionPixelSize(R.styleable.Snackbar_snackbar_buttonMarginBottomSingleLine, this.o);
        this.q = obtainStyledAttributes.getDimensionPixelSize(R.styleable.Snackbar_snackbar_buttonMarginBottomMultiLine, this.q);
        this.r = obtainStyledAttributes.getDimensionPixelSize(R.styleable.Snackbar_snackbar_snackbarPaddingLeft, this.r);
        this.s = obtainStyledAttributes.getDimensionPixelSize(R.styleable.Snackbar_snackbar_snackbarPaddingRight, this.s);
        this.i = obtainStyledAttributes.getDimensionPixelSize(R.styleable.Snackbar_snackbar_marginTop, this.i);
        this.j = obtainStyledAttributes.getDimensionPixelSize(R.styleable.Snackbar_snackbar_increasedMarginTop, this.j);
        this.v = obtainStyledAttributes.getDimensionPixelSize(R.styleable.Snackbar_snackbar_marginLeft, this.v);
        this.w = obtainStyledAttributes.getDimensionPixelSize(R.styleable.Snackbar_snackbar_marginRight, this.w);
        this.B = obtainStyledAttributes.getDimensionPixelSize(R.styleable.Snackbar_snackbar_maxWidthForTablets, this.B);
        obtainStyledAttributes.recycle();
    }
}
