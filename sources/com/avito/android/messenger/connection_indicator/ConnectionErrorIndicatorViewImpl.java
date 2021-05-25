package com.avito.android.messenger.connection_indicator;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.transition.Slide;
import androidx.transition.TransitionManager;
import com.avito.android.design.widget.circular_progress.CircularProgressBar;
import com.avito.android.messenger.R;
import com.avito.android.messenger.connection_indicator.ConnectionErrorIndicatorView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.TransitionDsl;
import com.avito.android.util.Views;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ!\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0011\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/avito/android/messenger/connection_indicator/ConnectionErrorIndicatorViewImpl;", "Lcom/avito/android/messenger/connection_indicator/ConnectionErrorIndicatorView;", "Lcom/avito/android/messenger/connection_indicator/ConnectionErrorIndicatorView$State;", "prevState", "curState", "", "render", "(Lcom/avito/android/messenger/connection_indicator/ConnectionErrorIndicatorView$State;Lcom/avito/android/messenger/connection_indicator/ConnectionErrorIndicatorView$State;)V", "Landroid/view/ViewGroup;", AuthSource.SEND_ABUSE, "Landroid/view/ViewGroup;", "parent", "Landroid/widget/TextView;", AuthSource.BOOKING_ORDER, "Landroid/widget/TextView;", "actionButton", "c", "messageTextView", "Lcom/avito/android/design/widget/circular_progress/CircularProgressBar;", "d", "Lcom/avito/android/design/widget/circular_progress/CircularProgressBar;", "connectionProgressBar", "Landroid/view/View;", "e", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class ConnectionErrorIndicatorViewImpl implements ConnectionErrorIndicatorView {
    public final ViewGroup a;
    public final TextView b;
    public final TextView c;
    public final CircularProgressBar d;
    public final View e;

    public ConnectionErrorIndicatorViewImpl(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.e = view;
        ViewParent parent = view.getParent();
        this.a = (ViewGroup) (!(parent instanceof ViewGroup) ? null : parent);
        View findViewById = view.findViewById(R.id.connection_error_action);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        this.b = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.connection_error_message);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.c = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.connection_progress);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type com.avito.android.design.widget.circular_progress.CircularProgressBar");
        this.d = (CircularProgressBar) findViewById3;
    }

    public void render(@Nullable ConnectionErrorIndicatorView.State state, @NotNull ConnectionErrorIndicatorView.State state2) {
        Intrinsics.checkNotNullParameter(state2, "curState");
        if (state != null && !(!Intrinsics.areEqual(state2, state))) {
            return;
        }
        if (state2 instanceof ConnectionErrorIndicatorView.State.Hidden) {
            ViewGroup viewGroup = this.a;
            if (viewGroup != null) {
                TransitionDsl transitionDsl = new TransitionDsl(new Slide());
                transitionDsl.addTarget(this.e);
                TransitionManager.beginDelayedTransition(viewGroup, transitionDsl.buildTransition());
            }
            Views.hide(this.e);
        } else if (state2 instanceof ConnectionErrorIndicatorView.State.Shown) {
            this.c.setText(((ConnectionErrorIndicatorView.State.Shown) state2).getMessage());
            if (state2 instanceof ConnectionErrorIndicatorView.State.Shown.Error) {
                ConnectionErrorIndicatorView.State.Shown.Error error = (ConnectionErrorIndicatorView.State.Shown.Error) state2;
                this.b.setText(error.getActionName());
                this.b.setOnClickListener(error.getActionClickListener());
                Views.conceal(this.d);
                Views.show(this.b);
            } else if (state2 instanceof ConnectionErrorIndicatorView.State.Shown.InProgress) {
                Views.conceal(this.b);
                Views.show(this.d);
            }
            ViewGroup viewGroup2 = this.a;
            if (viewGroup2 != null) {
                TransitionDsl transitionDsl2 = new TransitionDsl(new Slide());
                transitionDsl2.addTarget(this.e);
                TransitionManager.beginDelayedTransition(viewGroup2, transitionDsl2.buildTransition());
            }
            Views.show(this.e);
        }
    }
}
