package com.avito.android.component.circular_action_progress;

import a2.g.r.g;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import com.avito.android.util.Views;
import io.reactivex.rxjava3.subjects.PublishSubject;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u00104\u001a\u000203¢\u0006\u0004\b5\u00106J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0004J\u0019\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0010\u0010\u000eJ\u000f\u0010\u0011\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0004J\u000f\u0010\u0012\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0012\u0010\u0004J\u000f\u0010\u0013\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0013\u0010\u0004R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\u0016\u0010\u001c\u001a\u00020\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001e\u001a\u00020\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001bR\"\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00020\u001f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\"\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00020\u001f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b-\u0010!\u001a\u0004\b.\u0010#R\u0016\u00102\u001a\u0002008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u00101¨\u00067"}, d2 = {"Lcom/avito/android/component/circular_action_progress/CircularActionProgressImpl;", "Lcom/avito/android/component/circular_action_progress/CircularActionProgress;", "", "startProgress", "()V", "stopProgress", "stopProgressWithError", "Landroid/graphics/drawable/Drawable;", "drawable", "setBackground", "(Landroid/graphics/drawable/Drawable;)V", "", "cancelable", "setCancelable", "(Z)V", "errorEnabled", "setErrorEnabled", "hide", "show", AuthSource.SEND_ABUSE, "Landroid/widget/ImageView;", "c", "Landroid/widget/ImageView;", "cancelButton", "d", "errorButton", g.a, "Z", "isErrorEnabled", "f", "isCancelable", "Lio/reactivex/rxjava3/subjects/PublishSubject;", "i", "Lio/reactivex/rxjava3/subjects/PublishSubject;", "getErrorActionClicks", "()Lio/reactivex/rxjava3/subjects/PublishSubject;", "errorActionClicks", "Landroid/widget/ProgressBar;", AuthSource.BOOKING_ORDER, "Landroid/widget/ProgressBar;", "progressBar", "", "e", "I", "state", "h", "getCancelActionClicks", "cancelActionClicks", "Landroid/widget/FrameLayout;", "Landroid/widget/FrameLayout;", "container", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class CircularActionProgressImpl implements CircularActionProgress {
    public final FrameLayout a;
    public final ProgressBar b;
    public final ImageView c;
    public final ImageView d;
    public int e;
    public boolean f;
    public boolean g;
    @NotNull
    public final PublishSubject<Unit> h;
    @NotNull
    public final PublishSubject<Unit> i;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ CircularActionProgressImpl a;

        public a(CircularActionProgressImpl circularActionProgressImpl) {
            this.a = circularActionProgressImpl;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            int i = this.a.e;
            if (i == 0) {
                this.a.getCancelActionClicks().onNext(Unit.INSTANCE);
            } else if (i == 2) {
                this.a.getErrorActionClicks().onNext(Unit.INSTANCE);
            }
        }
    }

    public CircularActionProgressImpl(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.a = (FrameLayout) view;
        View findViewById = view.findViewById(R.id.progress_bar);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.ProgressBar");
        ProgressBar progressBar = (ProgressBar) findViewById;
        this.b = progressBar;
        View findViewById2 = view.findViewById(R.id.progress_cancel_button);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.ImageView");
        this.c = (ImageView) findViewById2;
        View findViewById3 = view.findViewById(R.id.progress_error_button);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.widget.ImageView");
        this.d = (ImageView) findViewById3;
        PublishSubject<Unit> create = PublishSubject.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishSubject.create()");
        this.h = create;
        PublishSubject<Unit> create2 = PublishSubject.create();
        Intrinsics.checkNotNullExpressionValue(create2, "PublishSubject.create()");
        this.i = create2;
        a();
        progressBar.setOnClickListener(new a(this));
    }

    public final void a() {
        int i2 = this.e;
        if (i2 == 0) {
            Views.hide(this.d);
            if (this.f) {
                Views.show(this.c);
                this.b.setFocusable(true);
            } else {
                Views.hide(this.c);
                this.b.setFocusable(false);
            }
            Views.show(this.b);
        } else if (i2 == 1) {
            Views.hide(this.c);
            Views.hide(this.d);
            this.b.setFocusable(false);
            Views.conceal(this.b);
        } else if (i2 == 2) {
            Views.hide(this.c);
            if (this.g) {
                Views.show(this.d);
                this.b.setFocusable(true);
                Views.conceal(this.b);
                return;
            }
            Views.hide(this.d);
            this.b.setFocusable(false);
        }
    }

    @Override // com.avito.android.component.circular_action_progress.CircularActionProgress
    public void hide() {
        Views.hide(this.a);
    }

    @Override // com.avito.android.component.circular_action_progress.CircularActionProgress
    public void setBackground(@Nullable Drawable drawable) {
        Views.setBackgroundCompat(this.a, drawable);
    }

    @Override // com.avito.android.component.circular_action_progress.CircularActionProgress
    public void setCancelable(boolean z) {
        this.f = z;
        a();
    }

    @Override // com.avito.android.component.circular_action_progress.CircularActionProgress
    public void setErrorEnabled(boolean z) {
        this.g = z;
        a();
    }

    @Override // com.avito.android.component.circular_action_progress.CircularActionProgress
    public void show() {
        Views.show(this.a);
    }

    @Override // com.avito.android.component.circular_action_progress.CircularActionProgress
    public void startProgress() {
        if (this.e != 0) {
            this.e = 0;
            a();
        }
    }

    @Override // com.avito.android.component.circular_action_progress.CircularActionProgress
    public void stopProgress() {
        this.e = 1;
        a();
    }

    @Override // com.avito.android.component.circular_action_progress.CircularActionProgress
    public void stopProgressWithError() {
        if (this.g) {
            this.e = 2;
            a();
            return;
        }
        throw new IllegalStateException("Error is not enabled");
    }

    @Override // com.avito.android.component.circular_action_progress.CircularActionProgress
    @NotNull
    public PublishSubject<Unit> getCancelActionClicks() {
        return this.h;
    }

    @Override // com.avito.android.component.circular_action_progress.CircularActionProgress
    @NotNull
    public PublishSubject<Unit> getErrorActionClicks() {
        return this.i;
    }
}
