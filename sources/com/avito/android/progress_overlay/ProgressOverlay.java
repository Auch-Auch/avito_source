package com.avito.android.progress_overlay;

import a2.g.r.g;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.ColorInt;
import androidx.annotation.DimenRes;
import androidx.annotation.IdRes;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.event.ErrorPageEvent;
import com.avito.android.design.widget.NetworkProblemView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import com.avito.android.util.Contexts;
import com.avito.android.util.ViewUtils;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Cancellable;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000i\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e*\u0001-\b\u0016\u0018\u00002\u00020\u0001B;\b\u0007\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\b\b\u0003\u0010F\u001a\u00020\f\u0012\n\b\u0002\u0010?\u001a\u0004\u0018\u00010<\u0012\b\b\u0002\u0010G\u001a\u00020\u0019\u0012\b\b\u0003\u00108\u001a\u00020\f¢\u0006\u0004\bH\u0010IJ\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\b\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u000e\u001a\u00020\u00032\b\b\u0001\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\b\u001a\u00020\u00032\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u0010H\u0016¢\u0006\u0004\b\b\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0013\u0010\u000bJ\u000f\u0010\u0014\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0014\u0010\u000bJ\u0017\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010 \u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001eH\u0014¢\u0006\u0004\b \u0010!J!\u0010#\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010\"H\u0014¢\u0006\u0004\b#\u0010$J\u0017\u0010&\u001a\n %*\u0004\u0018\u00010\"0\"H\u0002¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\u001eH\u0002¢\u0006\u0004\b(\u0010)J#\u0010+\u001a\u00020\u00032\b\u0010*\u001a\u0004\u0018\u00010\f2\b\u0010\u001f\u001a\u0004\u0018\u00010\"H\u0002¢\u0006\u0004\b+\u0010,R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u0010\u001d\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00104\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u00103R\u001e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00108\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u00108\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b7\u00103R\u001e\u0010;\u001a\n %*\u0004\u0018\u000109098\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010:R\u0018\u0010?\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010A\u001a\u00020\u00198\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b+\u0010@R\u0018\u0010D\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010F\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bE\u00103¨\u0006J"}, d2 = {"Lcom/avito/android/progress_overlay/ProgressOverlay;", "Lcom/avito/android/progress_overlay/LoadingOverlay;", "Lio/reactivex/Observable;", "", "refreshes", "()Lio/reactivex/Observable;", "Lcom/avito/android/progress_overlay/OnRefreshListener;", "onRefreshListener", "setOnRefreshListener", "(Lcom/avito/android/progress_overlay/OnRefreshListener;)V", "setToolbarPadding", "()V", "", "paddingDimenRes", "setBottomPadding", "(I)V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "(Lkotlin/jvm/functions/Function0;)V", "showContent", "showLoading", "", "text", "showLoadingProblem", "(Ljava/lang/String;)V", "", "isContentVisible", "()Z", "Landroid/view/ViewGroup;", "containerView", "Lcom/avito/android/design/widget/NetworkProblemView;", "overlay", "showOverlay", "(Landroid/view/ViewGroup;Lcom/avito/android/design/widget/NetworkProblemView;)V", "Landroid/view/View;", "removeOverlay", "(Landroid/view/ViewGroup;Landroid/view/View;)V", "kotlin.jvm.PlatformType", AuthSource.BOOKING_ORDER, "()Landroid/view/View;", AuthSource.SEND_ABUSE, "()Lcom/avito/android/design/widget/NetworkProblemView;", "paddingRes", "c", "(Ljava/lang/Integer;Landroid/view/View;)V", "com/avito/android/progress_overlay/ProgressOverlay$onRetryListener$1", "f", "Lcom/avito/android/progress_overlay/ProgressOverlay$onRetryListener$1;", "onRetryListener", g.a, "Landroid/view/ViewGroup;", "I", "layoutId", "e", "Lkotlin/jvm/functions/Function0;", "j", "backgroundColor", "Landroid/view/LayoutInflater;", "Landroid/view/LayoutInflater;", "inflater", "Lcom/avito/android/analytics/Analytics;", "i", "Lcom/avito/android/analytics/Analytics;", "analytics", "Z", "hasToolbarPadding", "d", "Ljava/lang/Integer;", "bottomPaddingRes", "h", "contentViewId", "isRedesignedNetworkError", "<init>", "(Landroid/view/ViewGroup;ILcom/avito/android/analytics/Analytics;ZI)V", "progress-overlay_release"}, k = 1, mv = {1, 4, 2})
public class ProgressOverlay implements LoadingOverlay {
    public final LayoutInflater a;
    public final int b;
    public boolean c;
    public Integer d;
    public Function0<Unit> e;
    public final ProgressOverlay$onRetryListener$1 f;
    public final ViewGroup g;
    public final int h;
    public final Analytics i;
    public final int j;

    public static final class a<T> implements ObservableOnSubscribe<Unit> {
        public final /* synthetic */ ProgressOverlay a;

        /* renamed from: com.avito.android.progress_overlay.ProgressOverlay$a$a  reason: collision with other inner class name */
        public static final class C0150a extends Lambda implements Function0<Unit> {
            public final /* synthetic */ ObservableEmitter a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0150a(ObservableEmitter observableEmitter) {
                super(0);
                this.a = observableEmitter;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: io.reactivex.ObservableEmitter */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function0
            public Unit invoke() {
                ObservableEmitter observableEmitter = this.a;
                Unit unit = Unit.INSTANCE;
                observableEmitter.onNext(unit);
                return unit;
            }
        }

        public static final class b implements Cancellable {
            public final /* synthetic */ a a;

            public b(a aVar) {
                this.a = aVar;
            }

            @Override // io.reactivex.functions.Cancellable
            public final void cancel() {
                this.a.a.setOnRefreshListener((OnRefreshListener) null);
            }
        }

        public a(ProgressOverlay progressOverlay) {
            this.a = progressOverlay;
        }

        @Override // io.reactivex.ObservableOnSubscribe
        public final void subscribe(@NotNull ObservableEmitter<Unit> observableEmitter) {
            Intrinsics.checkNotNullParameter(observableEmitter, "it");
            this.a.setOnRefreshListener(new C0150a(observableEmitter));
            observableEmitter.setCancellable(new b(this));
        }
    }

    public static final class b extends Lambda implements Function0<Unit> {
        public final /* synthetic */ OnRefreshListener a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(OnRefreshListener onRefreshListener) {
            super(0);
            this.a = onRefreshListener;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            OnRefreshListener onRefreshListener = this.a;
            if (onRefreshListener != null) {
                onRefreshListener.onRefresh();
            }
            return Unit.INSTANCE;
        }
    }

    @JvmOverloads
    public ProgressOverlay(@NotNull ViewGroup viewGroup) {
        this(viewGroup, 0, null, false, 0, 30, null);
    }

    @JvmOverloads
    public ProgressOverlay(@NotNull ViewGroup viewGroup, @IdRes int i2) {
        this(viewGroup, i2, null, false, 0, 28, null);
    }

    @JvmOverloads
    public ProgressOverlay(@NotNull ViewGroup viewGroup, @IdRes int i2, @Nullable Analytics analytics) {
        this(viewGroup, i2, analytics, false, 0, 24, null);
    }

    @JvmOverloads
    public ProgressOverlay(@NotNull ViewGroup viewGroup, @IdRes int i2, @Nullable Analytics analytics, boolean z) {
        this(viewGroup, i2, analytics, z, 0, 16, null);
    }

    @JvmOverloads
    public ProgressOverlay(@NotNull ViewGroup viewGroup, @IdRes int i2, @Nullable Analytics analytics, boolean z, @ColorInt int i3) {
        Intrinsics.checkNotNullParameter(viewGroup, "containerView");
        this.g = viewGroup;
        this.h = i2;
        this.i = analytics;
        this.j = i3;
        this.a = LayoutInflater.from(viewGroup.getContext());
        this.b = z ? R.layout.rds_network_problem : R.layout.part_network_problem;
        this.f = new ProgressOverlay$onRetryListener$1(this);
    }

    public final NetworkProblemView a() {
        View b2 = b();
        boolean z = b2 instanceof NetworkProblemView;
        View view = b2;
        if (!z) {
            View inflate = this.a.inflate(this.b, this.g, false);
            Objects.requireNonNull(inflate, "null cannot be cast to non-null type com.avito.android.design.widget.NetworkProblemView");
            NetworkProblemView networkProblemView = (NetworkProblemView) inflate;
            networkProblemView.setId(R.id.overlay);
            networkProblemView.setBackgroundColor(this.j);
            if (this.c) {
                networkProblemView.setToolbarPadding();
            }
            c(this.d, networkProblemView);
            this.g.addView(networkProblemView);
            view = networkProblemView;
        }
        NetworkProblemView networkProblemView2 = (NetworkProblemView) view;
        networkProblemView2.setListener(this.f);
        return networkProblemView2;
    }

    public final View b() {
        return this.g.findViewById(R.id.overlay);
    }

    public final void c(Integer num, View view) {
        if (num != null) {
            num.intValue();
            if (view != null) {
                view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), this.g.getResources().getDimensionPixelSize(num.intValue()));
            }
        }
    }

    public final boolean isContentVisible() {
        View findViewById = this.g.findViewById(this.h);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView\n        .f…ById<View>(contentViewId)");
        return findViewById.getVisibility() == 0;
    }

    @Override // com.avito.android.progress_overlay.LoadingOverlay
    @NotNull
    public Observable<Unit> refreshes() {
        Observable<Unit> create = Observable.create(new a(this));
        Intrinsics.checkNotNullExpressionValue(create, "Observable.create {\n    …istener(null) }\n        }");
        return create;
    }

    public void removeOverlay(@NotNull ViewGroup viewGroup, @Nullable View view) {
        Intrinsics.checkNotNullParameter(viewGroup, "containerView");
        viewGroup.removeView(view);
    }

    @Override // com.avito.android.progress_overlay.LoadingOverlay
    public void setBottomPadding(@DimenRes int i2) {
        this.d = Integer.valueOf(i2);
        c(this.d, b());
    }

    @Override // com.avito.android.progress_overlay.LoadingOverlay
    public void setOnRefreshListener(@Nullable OnRefreshListener onRefreshListener) {
        this.e = new b(onRefreshListener);
    }

    @Override // com.avito.android.progress_overlay.LoadingOverlay
    public void setToolbarPadding() {
        this.c = true;
        View b2 = b();
        if (b2 instanceof NetworkProblemView) {
            ((NetworkProblemView) b2).setToolbarPadding();
        }
    }

    @Override // com.avito.android.progress_overlay.LoadingOverlay
    public void showContent() {
        removeOverlay(this.g, b());
        int i2 = this.h;
        if (i2 != -1) {
            ViewUtils.INSTANCE.showView(this.g, i2);
        }
    }

    @Override // com.avito.android.progress_overlay.LoadingOverlay
    public void showLoading() {
        NetworkProblemView a3 = a();
        a3.showProgress();
        showOverlay(this.g, a3);
    }

    @Override // com.avito.android.progress_overlay.LoadingOverlay
    public void showLoadingProblem(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        NetworkProblemView a3 = a();
        if (m.isBlank(str)) {
            Context context = this.g.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "containerView.context");
            a3.showError(Contexts.isConnectionAvailable(context));
        } else {
            a3.showError(str);
        }
        showOverlay(this.g, a3);
        Analytics analytics = this.i;
        if (analytics != null) {
            analytics.track(new ErrorPageEvent());
        }
    }

    public void showOverlay(@NotNull ViewGroup viewGroup, @NotNull NetworkProblemView networkProblemView) {
        Intrinsics.checkNotNullParameter(viewGroup, "containerView");
        Intrinsics.checkNotNullParameter(networkProblemView, "overlay");
        int i2 = this.h;
        if (i2 != -1) {
            ViewUtils.INSTANCE.hideView(this.g, i2);
        }
        ViewUtils.INSTANCE.showView(networkProblemView);
    }

    @Override // com.avito.android.progress_overlay.LoadingOverlay
    public void setOnRefreshListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.e = function0;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ProgressOverlay(android.view.ViewGroup r7, int r8, com.avito.android.analytics.Analytics r9, boolean r10, int r11, int r12, t6.r.a.j r13) {
        /*
            r6 = this;
            r13 = r12 & 2
            if (r13 == 0) goto L_0x0007
            r8 = -1
            r2 = -1
            goto L_0x0008
        L_0x0007:
            r2 = r8
        L_0x0008:
            r8 = r12 & 4
            if (r8 == 0) goto L_0x000d
            r9 = 0
        L_0x000d:
            r3 = r9
            r8 = r12 & 8
            if (r8 == 0) goto L_0x0015
            r10 = 0
            r4 = 0
            goto L_0x0016
        L_0x0015:
            r4 = r10
        L_0x0016:
            r8 = r12 & 16
            if (r8 == 0) goto L_0x0029
            android.content.Context r8 = r7.getContext()
            java.lang.String r9 = "containerView.context"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r9)
            int r9 = com.avito.android.lib.design.R.attr.white
            int r11 = com.avito.android.util.Contexts.getColorByAttr(r8, r9)
        L_0x0029:
            r5 = r11
            r0 = r6
            r1 = r7
            r0.<init>(r1, r2, r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.progress_overlay.ProgressOverlay.<init>(android.view.ViewGroup, int, com.avito.android.analytics.Analytics, boolean, int, int, t6.r.a.j):void");
    }
}
