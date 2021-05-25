package com.avito.android.design.widget.add_advert;

import android.animation.ValueAnimator;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.RippleDrawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.Button;
import android.widget.FrameLayout;
import com.avito.android.advert_core.analytics.contactbar.PhonePageSourceKt;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.design.widget.add_advert.AddAdvertView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import com.avito.android.util.Contexts;
import com.avito.android.util.ToastsKt;
import com.avito.android.util.ViewPropertyAnimatorUtilKt;
import com.avito.android.util.Views;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.jakewharton.rxrelay3.PublishRelay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.Observable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.floating_add_advert.AdvertShortcut;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010g\u001a\u00020f¢\u0006\u0004\bh\u0010iB\u001b\b\u0016\u0012\u0006\u0010g\u001a\u00020f\u0012\b\u0010k\u001a\u0004\u0018\u00010j¢\u0006\u0004\bh\u0010lB#\b\u0016\u0012\u0006\u0010g\u001a\u00020f\u0012\b\u0010k\u001a\u0004\u0018\u00010j\u0012\u0006\u0010m\u001a\u00020\u0014¢\u0006\u0004\bh\u0010nB+\b\u0016\u0012\u0006\u0010g\u001a\u00020f\u0012\b\u0010k\u001a\u0004\u0018\u00010j\u0012\u0006\u0010m\u001a\u00020\u0014\u0012\u0006\u0010o\u001a\u00020\u0014¢\u0006\u0004\bh\u0010pJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\n\u0010\u0005J+\u0010\u0011\u001a\n \u0010*\u0004\u0018\u00010\u000f0\u000f*\u00020\u000b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J#\u0010\u0016\u001a\u00020\u000f*\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00030\u0018H\u0016¢\u0006\u0004\b\u001c\u0010\u001bJ\u0015\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u0018H\u0016¢\u0006\u0004\b\u001d\u0010\u001bJ\u0015\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00030\u0018H\u0016¢\u0006\u0004\b\u001e\u0010\u001bJ\u0015\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u0018H\u0016¢\u0006\u0004\b \u0010\u001bJ\u0015\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0\u0018H\u0016¢\u0006\u0004\b\"\u0010\u001bJ\u0015\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00060\u0018H\u0016¢\u0006\u0004\b#\u0010\u001bJ\u000f\u0010$\u001a\u00020\u0019H\u0016¢\u0006\u0004\b$\u0010%J\u0017\u0010'\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u0019H\u0016¢\u0006\u0004\b'\u0010(J\u001d\u0010+\u001a\u00020\u00032\f\u0010*\u001a\b\u0012\u0004\u0012\u00020!0)H\u0016¢\u0006\u0004\b+\u0010,J\u0015\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00030\u0018H\u0016¢\u0006\u0004\b-\u0010\u001bJ\u000f\u0010.\u001a\u00020\u0003H\u0016¢\u0006\u0004\b.\u0010\u0005J\u000f\u0010/\u001a\u00020\u0003H\u0016¢\u0006\u0004\b/\u0010\u0005J\u000f\u00100\u001a\u00020\u0003H\u0016¢\u0006\u0004\b0\u0010\u0005J\u0017\u00101\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b1\u0010\tJ\u0017\u00104\u001a\u00020\u00032\u0006\u00103\u001a\u000202H\u0016¢\u0006\u0004\b4\u00105J\u000f\u00106\u001a\u00020\u0003H\u0016¢\u0006\u0004\b6\u0010\u0005J\r\u00107\u001a\u00020\u0003¢\u0006\u0004\b7\u0010\u0005R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u001c\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00060<8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030<8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b?\u0010>R\u001c\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0<8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b@\u0010>R\u0016\u0010B\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010AR\u0016\u0010E\u001a\u00020\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010G\u001a\u00020\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bF\u0010DR\u001c\u0010J\u001a\b\u0012\u0004\u0012\u00020\u000b0H8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010IR\u0016\u0010&\u001a\u00020\u00198\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010N\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bM\u0010AR\u0016\u0010P\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bO\u0010AR\u0016\u0010Q\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010AR\u001c\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00030<8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bR\u0010>R\u001c\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00030<8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bS\u0010>R\u0016\u0010U\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bT\u0010AR\u001c\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0<8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bV\u0010>R\u0016\u0010X\u001a\u00020\u00198\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bW\u0010LR\u0016\u0010Z\u001a\u00020\u00198\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bY\u0010LR\u0016\u0010\\\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b[\u0010AR\u0016\u0010_\u001a\u00020]8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010^R\u0016\u0010`\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010AR\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190<8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\ba\u0010>R\u0018\u0010e\u001a\u0004\u0018\u00010b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bc\u0010d¨\u0006q"}, d2 = {"Lcom/avito/android/design/widget/add_advert/NewAdvertView;", "Landroid/widget/FrameLayout;", "Lcom/avito/android/design/widget/add_advert/AddAdvertView;", "", "c", "()V", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", AuthSource.BOOKING_ORDER, "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "d", "Landroid/view/View;", "", "duration", "delay", "Landroid/view/ViewPropertyAnimator;", "kotlin.jvm.PlatformType", AuthSource.SEND_ABUSE, "(Landroid/view/View;JJ)Landroid/view/ViewPropertyAnimator;", "view", "", "size", "e", "(Landroid/view/ViewPropertyAnimator;Landroid/view/View;I)Landroid/view/ViewPropertyAnimator;", "Lio/reactivex/rxjava3/core/Observable;", "", "openCallbacks", "()Lio/reactivex/rxjava3/core/Observable;", "aboutToBeOpenedCallbacks", "addClicks", "collapseClicks", "Lcom/avito/android/design/widget/add_advert/AddAdvertView$FinishReason;", "finishCallbacks", "Lru/avito/component/floating_add_advert/AdvertShortcut;", "publishVerticalCallbacks", "advertClicks", "handleBack", "()Z", "resizeButton", "setResizeButton", "(Z)V", "", ScreenPublicConstsKt.CONTENT_TYPE_SHORTCUTS, "initButtons", "(Ljava/util/List;)V", "showProgress", "hideProgress", "handleAdvertShortcutsLoaded", "openButton", "openLink", "", "message", "showError", "(Ljava/lang/String;)V", "showFatalError", "goneCloseButton", "", "p", "F", "translation", "Lcom/jakewharton/rxrelay3/PublishRelay;", VKApiConst.Q, "Lcom/jakewharton/rxrelay3/PublishRelay;", "t", VKApiConst.VERSION, "Landroid/view/View;", "layoutButtonImageOpen", "o", "I", "sizeSmall", "n", "sizeLarge", "Ljava/util/ArrayList;", "Ljava/util/ArrayList;", MessengerShareContentUtility.BUTTONS, AuthSource.OPEN_CHANNEL_LIST, "Z", "i", "viewForeground", "f", "layoutButtonText", "layoutButton", "r", "u", a2.g.r.g.a, "layoutContent", "w", "k", "isAnimate", "l", "isOpen", "h", "viewBackground", "Landroid/view/ViewGroup;", "Landroid/view/ViewGroup;", "layoutButtons", "layoutButtonImageClose", "s", "Landroid/app/Dialog;", "j", "Landroid/app/Dialog;", "dialog", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class NewAdvertView extends FrameLayout implements AddAdvertView {
    public final ArrayList<View> a = new ArrayList<>();
    public final View b;
    public final ViewGroup c;
    public final View d;
    public final View e;
    public final View f;
    public final View g;
    public final View h;
    public final View i;
    public Dialog j;
    public boolean k;
    public boolean l;
    public boolean m = true;
    public int n;
    public int o;
    public float p;
    public final PublishRelay<DeepLink> q;
    public final PublishRelay<Unit> r;
    public final PublishRelay<Boolean> s;
    public final PublishRelay<Unit> t;
    public final PublishRelay<Unit> u;
    public final PublishRelay<AddAdvertView.FinishReason> v;
    public final PublishRelay<AdvertShortcut> w;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ NewAdvertView a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(NewAdvertView newAdvertView) {
            super(0);
            this.a = newAdvertView;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            NewAdvertView newAdvertView = this.a;
            newAdvertView.n = newAdvertView.b.getWidth();
            this.a.c();
            return Unit.INSTANCE;
        }
    }

    public static final class b extends Lambda implements Function0<Unit> {
        public final /* synthetic */ NewAdvertView a;
        public final /* synthetic */ DeepLink b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(NewAdvertView newAdvertView, DeepLink deepLink) {
            super(0);
            this.a = newAdvertView;
            this.b = deepLink;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            if (this.b != null) {
                this.a.q.accept(this.b);
                this.a.v.accept(AddAdvertView.FinishReason.GO_TO_FLOW);
            } else {
                this.a.v.accept(AddAdvertView.FinishReason.GO_BACK);
            }
            return Unit.INSTANCE;
        }
    }

    public static final class c extends Lambda implements Function0<Unit> {
        public final /* synthetic */ NewAdvertView a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(NewAdvertView newAdvertView) {
            super(0);
            this.a = newAdvertView;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.k = false;
            Views.hide(this.a.g);
            this.a.c();
            return Unit.INSTANCE;
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ NewAdvertView a;
        public final /* synthetic */ AdvertShortcut b;

        public d(NewAdvertView newAdvertView, AdvertShortcut advertShortcut, int i) {
            this.a = newAdvertView;
            this.b = advertShortcut;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (!this.a.k) {
                this.a.w.accept(this.b);
                this.a.b(this.b.getDeepLink());
            }
        }
    }

    public static final class e implements View.OnClickListener {
        public final /* synthetic */ NewAdvertView a;

        public e(NewAdvertView newAdvertView) {
            this.a = newAdvertView;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (!this.a.k) {
                Intrinsics.checkNotNullExpressionValue(view, "it");
                int id = view.getId();
                if (id == R.id.layout_button) {
                    if (this.a.l) {
                        this.a.b(null);
                    } else {
                        this.a.t.accept(Unit.INSTANCE);
                    }
                } else if ((id == R.id.layout_buttons || id == R.id.view_background) && this.a.l) {
                    this.a.b(null);
                }
            }
        }
    }

    public static final class f extends Lambda implements Function0<Unit> {
        public final /* synthetic */ NewAdvertView a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(NewAdvertView newAdvertView) {
            super(0);
            this.a = newAdvertView;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.d();
            return Unit.INSTANCE;
        }
    }

    public static final class g extends Lambda implements Function0<Unit> {
        public final /* synthetic */ NewAdvertView a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(NewAdvertView newAdvertView) {
            super(0);
            this.a = newAdvertView;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.k = false;
            return Unit.INSTANCE;
        }
    }

    public static final class h implements DialogInterface.OnCancelListener {
        public final /* synthetic */ NewAdvertView a;
        public final /* synthetic */ PublishRelay b;

        public h(NewAdvertView newAdvertView, PublishRelay publishRelay) {
            this.a = newAdvertView;
            this.b = publishRelay;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface dialogInterface) {
            this.a.j = null;
            this.b.accept(Unit.INSTANCE);
        }
    }

    public static final class i implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ NewAdvertView a;
        public final /* synthetic */ Ref.IntRef b;
        public final /* synthetic */ View c;
        public final /* synthetic */ int d;

        public i(NewAdvertView newAdvertView, Ref.IntRef intRef, View view, int i) {
            this.a = newAdvertView;
            this.b = intRef;
            this.c = view;
            this.d = i;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            Ref.IntRef intRef = this.b;
            if (intRef.element == 0) {
                intRef.element = this.c.getWidth();
            }
            float floatValue = ((Float) a2.b.a.a.a.g2(valueAnimator, "it", "null cannot be cast to non-null type kotlin.Float")).floatValue() * ((float) (this.b.element - this.d));
            this.a.b.getLayoutParams().width = this.b.element - ((int) floatValue);
            this.a.b.requestLayout();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NewAdvertView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        PublishRelay<DeepLink> create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        this.q = create;
        PublishRelay<Unit> create2 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create2, "PublishRelay.create()");
        this.r = create2;
        PublishRelay<Boolean> create3 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create3, "PublishRelay.create()");
        this.s = create3;
        PublishRelay<Unit> create4 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create4, "PublishRelay.create()");
        this.t = create4;
        PublishRelay<Unit> create5 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create5, "PublishRelay.create()");
        this.u = create5;
        PublishRelay<AddAdvertView.FinishReason> create6 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create6, "PublishRelay.create()");
        this.v = create6;
        PublishRelay<AdvertShortcut> create7 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create7, "PublishRelay.create()");
        this.w = create7;
        View.inflate(getContext(), R.layout.new_advert, this);
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        this.o = Math.round(((float) 60) * displayMetrics.density);
        this.p = ((float) 16) * displayMetrics.density;
        e eVar = new e(this);
        View findViewById = findViewById(R.id.layout_button);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.layout_button)");
        this.b = findViewById;
        findViewById.setOnClickListener(eVar);
        View findViewById2 = findViewById(R.id.layout_buttons);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.layout_buttons)");
        ViewGroup viewGroup = (ViewGroup) findViewById2;
        this.c = viewGroup;
        viewGroup.setOnClickListener(eVar);
        View findViewById3 = findViewById(R.id.layout_button_image_open);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.layout_button_image_open)");
        this.d = findViewById3;
        View findViewById4 = findViewById(R.id.layout_button_image_close);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.layout_button_image_close)");
        this.e = findViewById4;
        View findViewById5 = findViewById(R.id.layout_button_text);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.layout_button_text)");
        this.f = findViewById5;
        View findViewById6 = findViewById(R.id.layout_content);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.layout_content)");
        this.g = findViewById6;
        Views.hide(findViewById6);
        View findViewById7 = findViewById(R.id.view_background);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.view_background)");
        this.h = findViewById7;
        findViewById7.setOnClickListener(eVar);
        View findViewById8 = findViewById(R.id.view_foreground);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(R.id.view_foreground)");
        this.i = findViewById8;
        c();
        Views.withPreDrawListener$default(this, false, new a(this), 1, null);
    }

    public final ViewPropertyAnimator a(View view, long j2, long j3) {
        return view.animate().setDuration(j2).setStartDelay(j3);
    }

    @Override // com.avito.android.design.widget.add_advert.AddAdvertView
    @NotNull
    public Observable<Unit> aboutToBeOpenedCallbacks() {
        return this.r;
    }

    @Override // com.avito.android.design.widget.add_advert.AddAdvertView
    @NotNull
    public Observable<Unit> addClicks() {
        return this.t;
    }

    @Override // com.avito.android.design.widget.add_advert.AddAdvertView
    @NotNull
    public Observable<DeepLink> advertClicks() {
        return this.q;
    }

    public final void b(DeepLink deepLink) {
        ViewPropertyAnimator viewPropertyAnimator;
        this.u.accept(Unit.INSTANCE);
        this.k = true;
        this.l = false;
        Views.hide(this.e);
        Iterator<View> it = this.a.iterator();
        while (it.hasNext()) {
            View next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, PhonePageSourceKt.PHONE_SOURCE_BUTTON);
            a(next, 220, 0).alpha(0.0f).translationY(-this.p);
        }
        ViewPropertyAnimator alpha = a(this.i, 220, 0).alpha(0.0f);
        Intrinsics.checkNotNullExpressionValue(alpha, "viewForeground\n         …0)\n            .alpha(0F)");
        ViewPropertyAnimatorUtilKt.withEnd(alpha, new b(this, deepLink));
        if (deepLink != null) {
            viewPropertyAnimator = a(this.h, 220, 660).alpha(0.0f);
            Intrinsics.checkNotNullExpressionValue(viewPropertyAnimator, "viewBackground\n         …               .alpha(0F)");
        } else {
            viewPropertyAnimator = a(this.h, 220, 0).alpha(0.0f);
            Intrinsics.checkNotNullExpressionValue(viewPropertyAnimator, "viewBackground\n         …               .alpha(0F)");
        }
        ViewPropertyAnimatorUtilKt.withEnd(viewPropertyAnimator, new c(this));
        if (deepLink != null || !this.m) {
            a(this.b, 110, 0).scaleX(0.0f).scaleY(0.0f);
        } else {
            ViewPropertyAnimator a3 = a(this.b, 110, 0);
            Intrinsics.checkNotNullExpressionValue(a3, "layoutButton\n                .animate(TIME_5, 0)");
            e(a3, this.b, this.n);
            a(this.d, 66, 0).rotation(0.0f).scaleX(1.0f).scaleY(1.0f);
            a(this.e, 66, 0).scaleX(0.0f).scaleY(0.0f);
            a(this.f, 110, 110).alpha(1.0f);
        }
        this.s.accept(Boolean.FALSE);
    }

    public final void c() {
        Iterator<View> it = this.a.iterator();
        while (it.hasNext()) {
            View next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, PhonePageSourceKt.PHONE_SOURCE_BUTTON);
            next.setAlpha(0.0f);
            next.setTranslationY(this.p);
        }
        this.h.setAlpha(0.0f);
        this.i.setAlpha(0.0f);
        if (!this.m) {
            this.b.getLayoutParams().width = this.o;
            this.b.requestLayout();
            this.b.setScaleX(0.0f);
            this.b.setScaleY(0.0f);
            this.d.setRotation(45.0f);
            this.d.setScaleX(0.0f);
            this.d.setScaleY(0.0f);
            this.e.setScaleX(1.0f);
            this.e.setScaleY(1.0f);
            this.f.setAlpha(0.0f);
        } else if (this.n > 0) {
            this.b.getLayoutParams().width = this.n;
            this.b.requestLayout();
            this.b.setScaleX(1.0f);
            this.b.setScaleY(1.0f);
            this.d.setRotation(0.0f);
            this.d.setScaleX(1.0f);
            this.d.setScaleY(1.0f);
            this.e.setScaleX(0.0f);
            this.e.setScaleY(0.0f);
            this.f.setAlpha(1.0f);
        }
    }

    @Override // com.avito.android.design.widget.add_advert.AddAdvertView
    @NotNull
    public Observable<Unit> collapseClicks() {
        return this.u;
    }

    public final void d() {
        this.s.accept(Boolean.TRUE);
        long j2 = 0;
        long j3 = 660;
        for (View view : t6.n.i.asReversedMutable(this.a)) {
            ViewPropertyAnimator translationY = a(view, j3, j2).alpha(1.0f).translationY(0.0f);
            Intrinsics.checkNotNullExpressionValue(translationY, "button\n                .…        .translationY(0F)");
            ViewPropertyAnimatorUtilKt.withEnd(translationY, new g(this));
            j2 += 110;
            j3 -= 110;
        }
        if (this.m) {
            ViewPropertyAnimator a3 = a(this.b, 220, 66);
            Intrinsics.checkNotNullExpressionValue(a3, "layoutButton\n           ….animate(TIME_10, TIME_3)");
            e(a3, this.b, this.o);
            a(this.d, 110, 66).rotation(45.0f).scaleX(0.0f).scaleY(0.0f);
            a(this.e, 110, 66).scaleX(1.0f).scaleY(1.0f);
            a(this.f, 66, 0).alpha(0.0f);
            return;
        }
        a(this.b, 220, 0).scaleX(1.0f).scaleY(1.0f);
    }

    public final ViewPropertyAnimator e(ViewPropertyAnimator viewPropertyAnimator, View view, int i2) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = 0;
        ofFloat.addUpdateListener(new i(this, intRef, view, i2));
        Intrinsics.checkNotNullExpressionValue(ofFloat, "valueAnimator");
        ofFloat.setDuration(viewPropertyAnimator.getDuration());
        ofFloat.setStartDelay(viewPropertyAnimator.getStartDelay());
        ofFloat.start();
        return viewPropertyAnimator;
    }

    @Override // com.avito.android.design.widget.add_advert.AddAdvertView
    @NotNull
    public Observable<AddAdvertView.FinishReason> finishCallbacks() {
        return this.v;
    }

    public final void goneCloseButton() {
        this.b.setVisibility(8);
    }

    @Override // com.avito.android.design.widget.add_advert.AddAdvertView
    public void handleAdvertShortcutsLoaded() {
        this.r.accept(Unit.INSTANCE);
    }

    @Override // com.avito.android.design.widget.add_advert.AddAdvertView
    public boolean handleBack() {
        if (this.k) {
            return true;
        }
        if (!this.l) {
            return false;
        }
        this.h.callOnClick();
        return true;
    }

    @Override // com.avito.android.design.widget.add_advert.AddAdvertView
    public void hideProgress() {
        Dialog dialog = this.j;
        if (dialog != null) {
            dialog.dismiss();
        }
        this.j = null;
    }

    @Override // com.avito.android.design.widget.add_advert.AddAdvertView
    public void initButtons(@NotNull List<AdvertShortcut> list) {
        Pair pair;
        Intrinsics.checkNotNullParameter(list, ScreenPublicConstsKt.CONTENT_TYPE_SHORTCUTS);
        this.a.clear();
        this.c.removeAllViews();
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.new_advert_button_padding);
        LayoutInflater from = LayoutInflater.from(getContext());
        for (AdvertShortcut advertShortcut : list) {
            View inflate = from.inflate(R.layout.new_advert_button, this.c, false);
            Objects.requireNonNull(inflate, "null cannot be cast to non-null type android.widget.Button");
            Button button = (Button) inflate;
            button.setText(advertShortcut.getTitle());
            button.setOnClickListener(new d(this, advertShortcut, dimensionPixelSize));
            String type = advertShortcut.getType();
            switch (type.hashCode()) {
                case -938632663:
                    if (type.equals("rabota")) {
                        pair = TuplesKt.to(Integer.valueOf(com.avito.android.lib.design.avito.R.color.avito_green), Integer.valueOf(com.avito.android.lib.design.avito.R.color.avito_green_800));
                        continue;
                        int intValue = ((Number) pair.component1()).intValue();
                        int intValue2 = ((Number) pair.component2()).intValue();
                        Context context = button.getContext();
                        Intrinsics.checkNotNullExpressionValue(context, "context");
                        ColorStateList colorStateListCompat = Contexts.getColorStateListCompat(context, intValue2);
                        Intrinsics.checkNotNull(colorStateListCompat);
                        Context context2 = button.getContext();
                        Intrinsics.checkNotNullExpressionValue(context2, "context");
                        button.setBackground(new RippleDrawable(colorStateListCompat, Contexts.getTintedDrawable(context2, R.drawable.bg_btn_fab, intValue), null));
                        button.setPadding(dimensionPixelSize, button.getPaddingTop(), dimensionPixelSize, button.getPaddingBottom());
                        this.a.add(button);
                        this.c.addView(button);
                    }
                    break;
                case -835818551:
                    if (type.equals("uslugi")) {
                        pair = TuplesKt.to(Integer.valueOf(com.avito.android.lib.design.avito.R.color.avito_violet), Integer.valueOf(com.avito.android.lib.design.avito.R.color.avito_blue_900));
                        continue;
                        int intValue = ((Number) pair.component1()).intValue();
                        int intValue2 = ((Number) pair.component2()).intValue();
                        Context context = button.getContext();
                        Intrinsics.checkNotNullExpressionValue(context, "context");
                        ColorStateList colorStateListCompat = Contexts.getColorStateListCompat(context, intValue2);
                        Intrinsics.checkNotNull(colorStateListCompat);
                        Context context2 = button.getContext();
                        Intrinsics.checkNotNullExpressionValue(context2, "context");
                        button.setBackground(new RippleDrawable(colorStateListCompat, Contexts.getTintedDrawable(context2, R.drawable.bg_btn_fab, intValue), null));
                        button.setPadding(dimensionPixelSize, button.getPaddingTop(), dimensionPixelSize, button.getPaddingBottom());
                        this.a.add(button);
                        this.c.addView(button);
                    }
                    break;
                case -80148248:
                    if (type.equals("general")) {
                        pair = TuplesKt.to(Integer.valueOf(com.avito.android.lib.design.avito.R.color.avito_orange), Integer.valueOf(com.avito.android.lib.design.avito.R.color.avito_orange_800));
                        continue;
                        int intValue = ((Number) pair.component1()).intValue();
                        int intValue2 = ((Number) pair.component2()).intValue();
                        Context context = button.getContext();
                        Intrinsics.checkNotNullExpressionValue(context, "context");
                        ColorStateList colorStateListCompat = Contexts.getColorStateListCompat(context, intValue2);
                        Intrinsics.checkNotNull(colorStateListCompat);
                        Context context2 = button.getContext();
                        Intrinsics.checkNotNullExpressionValue(context2, "context");
                        button.setBackground(new RippleDrawable(colorStateListCompat, Contexts.getTintedDrawable(context2, R.drawable.bg_btn_fab, intValue), null));
                        button.setPadding(dimensionPixelSize, button.getPaddingTop(), dimensionPixelSize, button.getPaddingBottom());
                        this.a.add(button);
                        this.c.addView(button);
                    }
                    break;
                case 1052964649:
                    if (type.equals("transport")) {
                        pair = TuplesKt.to(Integer.valueOf(com.avito.android.lib.design.avito.R.color.avito_red), Integer.valueOf(com.avito.android.lib.design.avito.R.color.avito_red_800));
                        continue;
                        int intValue = ((Number) pair.component1()).intValue();
                        int intValue2 = ((Number) pair.component2()).intValue();
                        Context context = button.getContext();
                        Intrinsics.checkNotNullExpressionValue(context, "context");
                        ColorStateList colorStateListCompat = Contexts.getColorStateListCompat(context, intValue2);
                        Intrinsics.checkNotNull(colorStateListCompat);
                        Context context2 = button.getContext();
                        Intrinsics.checkNotNullExpressionValue(context2, "context");
                        button.setBackground(new RippleDrawable(colorStateListCompat, Contexts.getTintedDrawable(context2, R.drawable.bg_btn_fab, intValue), null));
                        button.setPadding(dimensionPixelSize, button.getPaddingTop(), dimensionPixelSize, button.getPaddingBottom());
                        this.a.add(button);
                        this.c.addView(button);
                    }
                    break;
                case 1498510334:
                    if (type.equals("nedvizhimost")) {
                        pair = TuplesKt.to(Integer.valueOf(com.avito.android.lib.design.avito.R.color.avito_blue), Integer.valueOf(com.avito.android.lib.design.avito.R.color.avito_blue_800));
                        continue;
                        int intValue = ((Number) pair.component1()).intValue();
                        int intValue2 = ((Number) pair.component2()).intValue();
                        Context context = button.getContext();
                        Intrinsics.checkNotNullExpressionValue(context, "context");
                        ColorStateList colorStateListCompat = Contexts.getColorStateListCompat(context, intValue2);
                        Intrinsics.checkNotNull(colorStateListCompat);
                        Context context2 = button.getContext();
                        Intrinsics.checkNotNullExpressionValue(context2, "context");
                        button.setBackground(new RippleDrawable(colorStateListCompat, Contexts.getTintedDrawable(context2, R.drawable.bg_btn_fab, intValue), null));
                        button.setPadding(dimensionPixelSize, button.getPaddingTop(), dimensionPixelSize, button.getPaddingBottom());
                        this.a.add(button);
                        this.c.addView(button);
                    }
                    break;
            }
            pair = TuplesKt.to(0, 0);
            int intValue = ((Number) pair.component1()).intValue();
            int intValue2 = ((Number) pair.component2()).intValue();
            Context context = button.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            ColorStateList colorStateListCompat = Contexts.getColorStateListCompat(context, intValue2);
            Intrinsics.checkNotNull(colorStateListCompat);
            Context context2 = button.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            button.setBackground(new RippleDrawable(colorStateListCompat, Contexts.getTintedDrawable(context2, R.drawable.bg_btn_fab, intValue), null));
            button.setPadding(dimensionPixelSize, button.getPaddingTop(), dimensionPixelSize, button.getPaddingBottom());
            this.a.add(button);
            this.c.addView(button);
        }
    }

    @Override // com.avito.android.design.widget.add_advert.AddAdvertView
    public void openButton() {
        this.k = true;
        this.l = true;
        Views.show(this.e);
        Views.show(this.g);
        c();
        if (this.m) {
            a(this.h, 220, 0).alpha(0.88f);
            a(this.i, 220, 0).alpha(1.0f);
            d();
            return;
        }
        ViewPropertyAnimator alpha = a(this.h, 110, 0).alpha(1.0f);
        Intrinsics.checkNotNullExpressionValue(alpha, "viewBackground\n         …               .alpha(1F)");
        ViewPropertyAnimatorUtilKt.withEnd(alpha, new f(this));
    }

    @Override // com.avito.android.design.widget.add_advert.AddAdvertView
    @NotNull
    public Observable<Boolean> openCallbacks() {
        return this.s;
    }

    @Override // com.avito.android.design.widget.add_advert.AddAdvertView
    public void openLink(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        this.q.accept(deepLink);
    }

    @Override // com.avito.android.design.widget.add_advert.AddAdvertView
    @NotNull
    public Observable<AdvertShortcut> publishVerticalCallbacks() {
        return this.w;
    }

    @Override // com.avito.android.design.widget.add_advert.AddAdvertView
    public void setResizeButton(boolean z) {
        this.m = z;
    }

    @Override // com.avito.android.design.widget.add_advert.AddAdvertView
    public void showError(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        this.v.accept(AddAdvertView.FinishReason.GO_BACK);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        ToastsKt.showToast$default(context, str, 0, 2, (Object) null);
    }

    @Override // com.avito.android.design.widget.add_advert.AddAdvertView
    public void showFatalError() {
        this.v.accept(AddAdvertView.FinishReason.GO_BACK);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        ToastsKt.showToast$default(context, R.string.something_went_wrong, 0, 2, (Object) null);
    }

    @Override // com.avito.android.design.widget.add_advert.AddAdvertView
    @NotNull
    public Observable<Unit> showProgress() {
        if (this.j != null) {
            Observable<Unit> never = Observable.never();
            Intrinsics.checkNotNullExpressionValue(never, "Observable.never()");
            return never;
        }
        PublishRelay create = PublishRelay.create();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        ProgressDialog show = ProgressDialog.show(context, null, context.getResources().getString(R.string.wait), true, true);
        Intrinsics.checkNotNullExpressionValue(show, "ProgressDialog.show(this…string.wait), true, true)");
        this.j = show;
        if (show != null) {
            show.setOnCancelListener(new h(this, create));
        }
        Intrinsics.checkNotNullExpressionValue(create, "cancelCallbacks");
        return create;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NewAdvertView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        PublishRelay<DeepLink> create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        this.q = create;
        PublishRelay<Unit> create2 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create2, "PublishRelay.create()");
        this.r = create2;
        PublishRelay<Boolean> create3 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create3, "PublishRelay.create()");
        this.s = create3;
        PublishRelay<Unit> create4 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create4, "PublishRelay.create()");
        this.t = create4;
        PublishRelay<Unit> create5 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create5, "PublishRelay.create()");
        this.u = create5;
        PublishRelay<AddAdvertView.FinishReason> create6 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create6, "PublishRelay.create()");
        this.v = create6;
        PublishRelay<AdvertShortcut> create7 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create7, "PublishRelay.create()");
        this.w = create7;
        View.inflate(getContext(), R.layout.new_advert, this);
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        this.o = Math.round(((float) 60) * displayMetrics.density);
        this.p = ((float) 16) * displayMetrics.density;
        e eVar = new e(this);
        View findViewById = findViewById(R.id.layout_button);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.layout_button)");
        this.b = findViewById;
        findViewById.setOnClickListener(eVar);
        View findViewById2 = findViewById(R.id.layout_buttons);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.layout_buttons)");
        ViewGroup viewGroup = (ViewGroup) findViewById2;
        this.c = viewGroup;
        viewGroup.setOnClickListener(eVar);
        View findViewById3 = findViewById(R.id.layout_button_image_open);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.layout_button_image_open)");
        this.d = findViewById3;
        View findViewById4 = findViewById(R.id.layout_button_image_close);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.layout_button_image_close)");
        this.e = findViewById4;
        View findViewById5 = findViewById(R.id.layout_button_text);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.layout_button_text)");
        this.f = findViewById5;
        View findViewById6 = findViewById(R.id.layout_content);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.layout_content)");
        this.g = findViewById6;
        Views.hide(findViewById6);
        View findViewById7 = findViewById(R.id.view_background);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.view_background)");
        this.h = findViewById7;
        findViewById7.setOnClickListener(eVar);
        View findViewById8 = findViewById(R.id.view_foreground);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(R.id.view_foreground)");
        this.i = findViewById8;
        c();
        Views.withPreDrawListener$default(this, false, new a(this), 1, null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NewAdvertView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        PublishRelay<DeepLink> create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        this.q = create;
        PublishRelay<Unit> create2 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create2, "PublishRelay.create()");
        this.r = create2;
        PublishRelay<Boolean> create3 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create3, "PublishRelay.create()");
        this.s = create3;
        PublishRelay<Unit> create4 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create4, "PublishRelay.create()");
        this.t = create4;
        PublishRelay<Unit> create5 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create5, "PublishRelay.create()");
        this.u = create5;
        PublishRelay<AddAdvertView.FinishReason> create6 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create6, "PublishRelay.create()");
        this.v = create6;
        PublishRelay<AdvertShortcut> create7 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create7, "PublishRelay.create()");
        this.w = create7;
        View.inflate(getContext(), R.layout.new_advert, this);
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        this.o = Math.round(((float) 60) * displayMetrics.density);
        this.p = ((float) 16) * displayMetrics.density;
        e eVar = new e(this);
        View findViewById = findViewById(R.id.layout_button);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.layout_button)");
        this.b = findViewById;
        findViewById.setOnClickListener(eVar);
        View findViewById2 = findViewById(R.id.layout_buttons);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.layout_buttons)");
        ViewGroup viewGroup = (ViewGroup) findViewById2;
        this.c = viewGroup;
        viewGroup.setOnClickListener(eVar);
        View findViewById3 = findViewById(R.id.layout_button_image_open);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.layout_button_image_open)");
        this.d = findViewById3;
        View findViewById4 = findViewById(R.id.layout_button_image_close);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.layout_button_image_close)");
        this.e = findViewById4;
        View findViewById5 = findViewById(R.id.layout_button_text);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.layout_button_text)");
        this.f = findViewById5;
        View findViewById6 = findViewById(R.id.layout_content);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.layout_content)");
        this.g = findViewById6;
        Views.hide(findViewById6);
        View findViewById7 = findViewById(R.id.view_background);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.view_background)");
        this.h = findViewById7;
        findViewById7.setOnClickListener(eVar);
        View findViewById8 = findViewById(R.id.view_foreground);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(R.id.view_foreground)");
        this.i = findViewById8;
        c();
        Views.withPreDrawListener$default(this, false, new a(this), 1, null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NewAdvertView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        PublishRelay<DeepLink> create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        this.q = create;
        PublishRelay<Unit> create2 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create2, "PublishRelay.create()");
        this.r = create2;
        PublishRelay<Boolean> create3 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create3, "PublishRelay.create()");
        this.s = create3;
        PublishRelay<Unit> create4 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create4, "PublishRelay.create()");
        this.t = create4;
        PublishRelay<Unit> create5 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create5, "PublishRelay.create()");
        this.u = create5;
        PublishRelay<AddAdvertView.FinishReason> create6 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create6, "PublishRelay.create()");
        this.v = create6;
        PublishRelay<AdvertShortcut> create7 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create7, "PublishRelay.create()");
        this.w = create7;
        View.inflate(getContext(), R.layout.new_advert, this);
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        this.o = Math.round(((float) 60) * displayMetrics.density);
        this.p = ((float) 16) * displayMetrics.density;
        e eVar = new e(this);
        View findViewById = findViewById(R.id.layout_button);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.layout_button)");
        this.b = findViewById;
        findViewById.setOnClickListener(eVar);
        View findViewById2 = findViewById(R.id.layout_buttons);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.layout_buttons)");
        ViewGroup viewGroup = (ViewGroup) findViewById2;
        this.c = viewGroup;
        viewGroup.setOnClickListener(eVar);
        View findViewById3 = findViewById(R.id.layout_button_image_open);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.layout_button_image_open)");
        this.d = findViewById3;
        View findViewById4 = findViewById(R.id.layout_button_image_close);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.layout_button_image_close)");
        this.e = findViewById4;
        View findViewById5 = findViewById(R.id.layout_button_text);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.layout_button_text)");
        this.f = findViewById5;
        View findViewById6 = findViewById(R.id.layout_content);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.layout_content)");
        this.g = findViewById6;
        Views.hide(findViewById6);
        View findViewById7 = findViewById(R.id.view_background);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.view_background)");
        this.h = findViewById7;
        findViewById7.setOnClickListener(eVar);
        View findViewById8 = findViewById(R.id.view_foreground);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(R.id.view_foreground)");
        this.i = findViewById8;
        c();
        Views.withPreDrawListener$default(this, false, new a(this), 1, null);
    }
}
