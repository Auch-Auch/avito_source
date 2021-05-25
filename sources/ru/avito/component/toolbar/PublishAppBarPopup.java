package ru.avito.component.toolbar;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.PopupWindow;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import com.avito.android.util.ViewTreeObservers;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010 J\u0015\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0005J\u001f\u0010\u000b\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006!"}, d2 = {"Lru/avito/component/toolbar/PublishAppBarPopup;", "Landroid/widget/PopupWindow;", "", "text", "setTitleText", "(Ljava/lang/CharSequence;)Lru/avito/component/toolbar/PublishAppBarPopup;", "setDescriptionText", "Landroid/view/View;", "anchor", "", "autoHide", "show", "(Landroid/view/View;Z)Lru/avito/component/toolbar/PublishAppBarPopup;", "Lru/avito/component/toolbar/PublishAppBarPopupView;", AuthSource.SEND_ABUSE, "Lru/avito/component/toolbar/PublishAppBarPopupView;", "popupView", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", AuthSource.BOOKING_ORDER, "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "callback", "", "d", "I", "horizontalMargin", "Landroid/view/animation/Animation;", "c", "Landroid/view/animation/Animation;", "fadeInAnimation", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class PublishAppBarPopup extends PopupWindow {
    public final PublishAppBarPopupView a;
    public ViewTreeObserver.OnGlobalLayoutListener b;
    public final Animation c;
    public final int d;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ PublishAppBarPopup a;

        public a(PublishAppBarPopup publishAppBarPopup) {
            this.a = publishAppBarPopup;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.dismiss();
        }
    }

    public static final class b implements PopupWindow.OnDismissListener {
        public final /* synthetic */ PublishAppBarPopup a;
        public final /* synthetic */ View b;

        public b(PublishAppBarPopup publishAppBarPopup, View view) {
            this.a = publishAppBarPopup;
            this.b = view;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public final void onDismiss() {
            PublishAppBarPopup.access$clearCallback(this.a, this.b);
        }
    }

    public static final class c implements ViewTreeObserver.OnGlobalLayoutListener {
        public final /* synthetic */ PublishAppBarPopup a;
        public final /* synthetic */ View b;
        public final /* synthetic */ PublishAppBarPopupView c;
        public final /* synthetic */ boolean d;

        public static final /* synthetic */ class a extends FunctionReferenceImpl implements Function0<Unit> {
            public a(PublishAppBarPopup publishAppBarPopup) {
                super(0, publishAppBarPopup, PublishAppBarPopup.class, "dismiss", "dismiss()V", 0);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public Unit invoke() {
                ((PublishAppBarPopup) this.receiver).dismiss();
                return Unit.INSTANCE;
            }
        }

        public static final class b implements Runnable {
            public final /* synthetic */ c a;
            public final /* synthetic */ int b;
            public final /* synthetic */ int c;

            public b(c cVar, int i, int i2) {
                this.a = cVar;
                this.b = i;
                this.c = i2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                c cVar = this.a;
                PublishAppBarPopup publishAppBarPopup = cVar.a;
                ViewParent parent = cVar.b.getParent();
                Objects.requireNonNull(parent, "null cannot be cast to non-null type android.view.View");
                publishAppBarPopup.showAtLocation((View) parent, 0, this.b, this.c);
            }
        }

        public c(PublishAppBarPopup publishAppBarPopup, View view, PublishAppBarPopupView publishAppBarPopupView, boolean z) {
            this.a = publishAppBarPopup;
            this.b = view;
            this.c = publishAppBarPopupView;
            this.d = z;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            PublishAppBarPopup.access$clearCallback(this.a, this.b);
            Pair access$calculatePopupPosition = PublishAppBarPopup.access$calculatePopupPosition(this.a, this.b, this.c);
            int intValue = ((Number) access$calculatePopupPosition.component1()).intValue();
            int intValue2 = ((Number) access$calculatePopupPosition.component2()).intValue();
            this.c.startAnimation(this.a.c);
            this.c.setVisibility(0);
            if (this.d) {
                this.b.postDelayed(new a7.a.a.i.a(new a(this.a)), 2000);
            }
            this.b.post(new b(this, intValue, intValue2));
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PublishAppBarPopup(@NotNull Context context) {
        super(LayoutInflater.from(context).inflate(R.layout.publish_appbar_popup, (ViewGroup) null), -2, -2);
        Intrinsics.checkNotNullParameter(context, "context");
        Animation loadAnimation = AnimationUtils.loadAnimation(context, com.avito.android.lib.design.R.anim.design_abc_grow_fade_in_from_bottom);
        Intrinsics.checkNotNullExpressionValue(loadAnimation, "loadAnimation(\n        c…fade_in_from_bottom\n    )");
        this.c = loadAnimation;
        this.d = context.getResources().getDimensionPixelSize(R.dimen.publish_appbar_popup_horizontal_margin);
        setBackgroundDrawable(new ColorDrawable(0));
        setOutsideTouchable(true);
        setClippingEnabled(false);
        View contentView = getContentView();
        Objects.requireNonNull(contentView, "null cannot be cast to non-null type ru.avito.component.toolbar.PublishAppBarPopupView");
        this.a = (PublishAppBarPopupView) contentView;
    }

    public static final Pair access$calculatePopupPosition(PublishAppBarPopup publishAppBarPopup, View view, PublishAppBarPopupView publishAppBarPopupView) {
        Objects.requireNonNull(publishAppBarPopup);
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        int width = view.getWidth() - (publishAppBarPopup.d * 2);
        publishAppBarPopup.setWidth(width);
        int i = iArr[0];
        int i2 = iArr[1];
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        return new Pair(Integer.valueOf(Math.max((measuredWidth / 2) + (i - (width / 2)), 0)), Integer.valueOf(Math.max(i2 + measuredHeight, 0)));
    }

    public static final void access$clearCallback(PublishAppBarPopup publishAppBarPopup, View view) {
        ViewTreeObserver viewTreeObserver;
        ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = publishAppBarPopup.b;
        if (!(onGlobalLayoutListener == null || view == null || (viewTreeObserver = view.getViewTreeObserver()) == null)) {
            ViewTreeObservers.removeGlobalLayoutListener(viewTreeObserver, onGlobalLayoutListener);
        }
        publishAppBarPopup.b = null;
    }

    public static /* synthetic */ PublishAppBarPopup show$default(PublishAppBarPopup publishAppBarPopup, View view, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return publishAppBarPopup.show(view, z);
    }

    @NotNull
    public final PublishAppBarPopup setDescriptionText(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "text");
        this.a.getDescriptionTextView().setText(charSequence);
        return this;
    }

    @NotNull
    public final PublishAppBarPopup setTitleText(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "text");
        this.a.getTitleTextView().setText(charSequence);
        return this;
    }

    @NotNull
    public final PublishAppBarPopup show(@NotNull View view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "anchor");
        dismiss();
        View contentView = getContentView();
        Objects.requireNonNull(contentView, "null cannot be cast to non-null type ru.avito.component.toolbar.PublishAppBarPopupView");
        PublishAppBarPopupView publishAppBarPopupView = (PublishAppBarPopupView) contentView;
        publishAppBarPopupView.setOnClickListener(new a(this));
        setOnDismissListener(new b(this, view));
        this.b = new c(this, view, publishAppBarPopupView, z);
        view.getViewTreeObserver().addOnGlobalLayoutListener(this.b);
        view.requestLayout();
        return this;
    }
}
