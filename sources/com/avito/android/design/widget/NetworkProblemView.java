package com.avito.android.design.widget;

import android.animation.Animator;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import com.avito.android.util.AnimationUtils;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0003\u0019*\u001cB\u0011\b\u0016\u0012\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b \u0010!B\u001b\b\u0016\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\b\u0010#\u001a\u0004\u0018\u00010\"¢\u0006\u0004\b \u0010$B#\b\u0016\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\b\u0010#\u001a\u0004\u0018\u00010\"\u0012\u0006\u0010&\u001a\u00020%¢\u0006\u0004\b \u0010'B+\b\u0016\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\b\u0010#\u001a\u0004\u0018\u00010\"\u0012\u0006\u0010&\u001a\u00020%\u0012\u0006\u0010(\u001a\u00020%¢\u0006\u0004\b \u0010)J\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\u0004J\u0015\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\f\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\f\u0010\u0010J\r\u0010\u0011\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0004R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\u00128\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u001c\u0010\u0014¨\u0006+"}, d2 = {"Lcom/avito/android/design/widget/NetworkProblemView;", "Landroid/widget/FrameLayout;", "", "onFinishInflate", "()V", "Lcom/avito/android/design/widget/NetworkProblemView$OnRetryListener;", "onRetryListener", "setListener", "(Lcom/avito/android/design/widget/NetworkProblemView$OnRetryListener;)V", "setToolbarPadding", "", "isConnectionAvailable", "showError", "(Z)V", "", "text", "(Ljava/lang/String;)V", "showProgress", "Landroid/view/View;", "c", "Landroid/view/View;", "viewProgress", "d", "Lcom/avito/android/design/widget/NetworkProblemView$OnRetryListener;", "Landroid/widget/TextView;", AuthSource.SEND_ABUSE, "Landroid/widget/TextView;", "errorTextView", AuthSource.BOOKING_ORDER, "viewError", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "OnRetryListener", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class NetworkProblemView extends FrameLayout {
    public TextView a;
    public View b;
    public View c;
    public OnRetryListener d;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/avito/android/design/widget/NetworkProblemView$OnRetryListener;", "", "", "onRetry", "()V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
    public interface OnRetryListener {
        void onRetry();
    }

    public static final class a extends AnimationUtils.SimpleAnimatorListener {
        public final View a;

        public a(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            this.a = view;
        }

        @Override // com.avito.android.util.AnimationUtils.SimpleAnimatorListener, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animation");
            this.a.setVisibility(8);
        }
    }

    public static final class b extends AnimationUtils.SimpleAnimatorListener {
        public final View a;

        public b(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            this.a = view;
        }

        @Override // com.avito.android.util.AnimationUtils.SimpleAnimatorListener, android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animation");
            this.a.setVisibility(0);
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ NetworkProblemView a;

        public c(NetworkProblemView networkProblemView) {
            this.a = networkProblemView;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            OnRetryListener onRetryListener = this.a.d;
            if (onRetryListener != null) {
                onRetryListener.onRetry();
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NetworkProblemView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        if (!isInEditMode()) {
            View findViewById = findViewById(R.id.error_text);
            Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
            this.a = (TextView) findViewById;
            View findViewById2 = findViewById(R.id.error_view);
            Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.view.View");
            this.b = findViewById2;
            View findViewById3 = findViewById(R.id.progress_view);
            Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.view.View");
            this.c = findViewById3;
            View findViewById4 = findViewById(R.id.retry_button);
            Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type android.view.View");
            findViewById4.setOnClickListener(new c(this));
        }
    }

    public final void setListener(@NotNull OnRetryListener onRetryListener) {
        Intrinsics.checkNotNullParameter(onRetryListener, "onRetryListener");
        this.d = onRetryListener;
    }

    public final void setToolbarPadding() {
        setPadding(getPaddingLeft(), getResources().getDimensionPixelSize(androidx.appcompat.R.dimen.abc_action_bar_default_height_material), getPaddingRight(), getPaddingBottom());
    }

    public final void showError(boolean z) {
        Resources resources;
        int i;
        if (z) {
            resources = getResources();
            i = R.string.something_went_wrong;
        } else {
            resources = getResources();
            i = R.string.connection_problem;
        }
        String string = resources.getString(i);
        Intrinsics.checkNotNullExpressionValue(string, "if (isConnectionAvailabl…tring.connection_problem)");
        showError(string);
    }

    public final void showProgress() {
        View view = this.b;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewError");
        }
        a aVar = new a(view);
        View view2 = this.b;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewError");
        }
        view2.animate().alpha(0.0f).setListener(aVar);
        View view3 = this.c;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewProgress");
        }
        b bVar = new b(view3);
        View view4 = this.c;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewProgress");
        }
        view4.animate().alpha(1.0f).setListener(bVar);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NetworkProblemView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NetworkProblemView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void showError(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        TextView textView = this.a;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("errorTextView");
        }
        textView.setText(str);
        View view = this.b;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewError");
        }
        b bVar = new b(view);
        View view2 = this.b;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewError");
        }
        view2.animate().alpha(1.0f).setListener(bVar);
        View view3 = this.c;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewProgress");
        }
        a aVar = new a(view3);
        View view4 = this.c;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewProgress");
        }
        view4.animate().alpha(0.0f).setListener(aVar);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NetworkProblemView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
