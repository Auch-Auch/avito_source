package ru.avito.component.popup;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.annotation.StringRes;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import com.avito.android.util.ViewTreeObservers;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0004\u001a\u00020\u00002\b\b\u0001\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0004\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u0010\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0012\u0010\u000bR\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0019\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0018¨\u0006\u001e"}, d2 = {"Lru/avito/component/popup/BlackInfoPopup;", "Landroid/widget/PopupWindow;", "", "text", "setText", "(Ljava/lang/CharSequence;)Lru/avito/component/popup/BlackInfoPopup;", "", "textRes", "(I)Lru/avito/component/popup/BlackInfoPopup;", "", "dismiss", "()V", "Landroid/view/View;", "anchor", "", "autoHide", "show", "(Landroid/view/View;Z)Lru/avito/component/popup/BlackInfoPopup;", AuthSource.SEND_ABUSE, "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", AuthSource.BOOKING_ORDER, "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "callback", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "textView", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class BlackInfoPopup extends PopupWindow {
    public final TextView a;
    public ViewTreeObserver.OnGlobalLayoutListener b;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ BlackInfoPopup a;

        public a(BlackInfoPopup blackInfoPopup) {
            this.a = blackInfoPopup;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.dismiss();
        }
    }

    public static final class b implements ViewTreeObserver.OnGlobalLayoutListener {
        public final /* synthetic */ BlackInfoPopup a;
        public final /* synthetic */ View b;
        public final /* synthetic */ View c;
        public final /* synthetic */ boolean d;

        public static final /* synthetic */ class a extends FunctionReferenceImpl implements Function0<Unit> {
            public a(BlackInfoPopup blackInfoPopup) {
                super(0, blackInfoPopup, BlackInfoPopup.class, "dismiss", "dismiss()V", 0);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public Unit invoke() {
                ((BlackInfoPopup) this.receiver).dismiss();
                return Unit.INSTANCE;
            }
        }

        public b(BlackInfoPopup blackInfoPopup, View view, View view2, boolean z) {
            this.a = blackInfoPopup;
            this.b = view;
            this.c = view2;
            this.d = z;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            this.a.a();
            int[] iArr = new int[2];
            this.b.getLocationInWindow(iArr);
            int i = iArr[0];
            int i2 = iArr[1];
            int measuredWidth = this.b.getMeasuredWidth();
            int measuredHeight = this.b.getMeasuredHeight();
            View view = this.c;
            Intrinsics.checkNotNullExpressionValue(view, "bubbleView");
            int measuredWidth2 = view.getMeasuredWidth();
            int dimensionPixelSize = a2.b.a.a.a.u1(this.b, "anchor.context").getDimensionPixelSize(R.dimen.popup_tail_size) / 2;
            int max = Math.max(dimensionPixelSize + (measuredWidth / 2) + (i - measuredWidth2) + a2.b.a.a.a.u1(this.b, "anchor.context").getDimensionPixelSize(R.dimen.popup_tail_padding), 0);
            int max2 = Math.max(((measuredHeight * 2) / 3) + i2, 0);
            Context context = this.a.a.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "textView.context");
            Resources resources = context.getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "textView.context.resources");
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            Intrinsics.checkNotNullExpressionValue(displayMetrics, "textView.context.resources.displayMetrics");
            if (max != 0) {
                max = Math.min(max, displayMetrics.widthPixels - measuredWidth2);
            }
            this.a.update(max, max2, -2, -2);
            if (this.d) {
                this.b.postDelayed(new a7.a.a.f.a(new a(this.a)), 2000);
            }
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ BlackInfoPopup a;
        public final /* synthetic */ View b;

        public c(BlackInfoPopup blackInfoPopup, View view) {
            this.a = blackInfoPopup;
            this.b = view;
        }

        @Override // java.lang.Runnable
        public final void run() {
            BlackInfoPopup blackInfoPopup = this.a;
            ViewParent parent = this.b.getParent();
            Objects.requireNonNull(parent, "null cannot be cast to non-null type android.view.View");
            blackInfoPopup.showAtLocation((View) parent, 0, 0, 0);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BlackInfoPopup(@NotNull Context context) {
        super(LayoutInflater.from(context).inflate(R.layout.popup, (ViewGroup) null), -2, -2);
        Intrinsics.checkNotNullParameter(context, "context");
        setBackgroundDrawable(new ColorDrawable(0));
        setOutsideTouchable(true);
        setClippingEnabled(false);
        setAnimationStyle(com.avito.android.lib.design.R.style.Design_Animation_AppCompat_DropDownUp);
        View contentView = getContentView();
        Objects.requireNonNull(contentView, "null cannot be cast to non-null type android.widget.TextView");
        this.a = (TextView) contentView;
    }

    public static /* synthetic */ BlackInfoPopup show$default(BlackInfoPopup blackInfoPopup, View view, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return blackInfoPopup.show(view, z);
    }

    public final void a() {
        View contentView;
        ViewTreeObserver viewTreeObserver;
        ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = this.b;
        if (!(onGlobalLayoutListener == null || (contentView = getContentView()) == null || (viewTreeObserver = contentView.getViewTreeObserver()) == null)) {
            ViewTreeObservers.removeGlobalLayoutListener(viewTreeObserver, onGlobalLayoutListener);
        }
        this.b = null;
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        super.dismiss();
        a();
    }

    @NotNull
    public final BlackInfoPopup setText(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "text");
        this.a.setText(charSequence);
        return this;
    }

    @NotNull
    public final BlackInfoPopup show(@NotNull View view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "anchor");
        dismiss();
        View contentView = getContentView();
        contentView.setOnClickListener(new a(this));
        a();
        this.b = new b(this, view, contentView, z);
        Intrinsics.checkNotNullExpressionValue(contentView, "bubbleView");
        contentView.getViewTreeObserver().addOnGlobalLayoutListener(this.b);
        view.post(new c(this, view));
        return this;
    }

    @NotNull
    public final BlackInfoPopup setText(@StringRes int i) {
        this.a.setText(i);
        return this;
    }
}
