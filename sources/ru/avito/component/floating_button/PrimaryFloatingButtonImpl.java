package ru.avito.component.floating_button;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import com.avito.android.util.Views;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u00104\u001a\u00020#¢\u0006\u0004\b5\u00106J\u001f\u0010\u0005\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\t\u001a\u00020\u00032\b\b\u0001\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\t\u0010\rJ\u0019\u0010\u000f\u001a\u00020\u00032\b\b\u0001\u0010\u000e\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000f\u0010\rJ\u0017\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0018\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u001a\u0010\u0017J\u0017\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u001c\u0010\u0017J\u000f\u0010\u001d\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u001f\u0010\u0017J\u001f\u0010!\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b!\u0010\"R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010)\u001a\u00020'8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010(R\u0016\u0010,\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0019\u00104\u001a\u00020#8\u0006@\u0006¢\u0006\f\n\u0004\b1\u0010%\u001a\u0004\b2\u00103¨\u00067"}, d2 = {"Lru/avito/component/floating_button/PrimaryFloatingButtonImpl;", "Lru/avito/component/floating_button/PrimaryFloatingButton;", "Lkotlin/Function0;", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setClickListener", "(Lkotlin/jvm/functions/Function0;)V", "", "text", "setText", "(Ljava/lang/CharSequence;)V", "", "textId", "(I)V", "drawableRes", "setImageResource", "Landroid/graphics/drawable/Drawable;", "drawable", "setImageDrawable", "(Landroid/graphics/drawable/Drawable;)V", "", "animate", "moveIn", "(Z)V", "moveOut", "visible", "setVisible", "enabled", "setEnabled", "isEnabled", "()Z", "setProgressBarVisible", "yDistance", AuthSource.SEND_ABUSE, "(IZ)V", "Landroid/view/View;", "c", "Landroid/view/View;", "progressBar", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "textView", "d", "I", "displayHeight", "Landroid/widget/ImageView;", AuthSource.BOOKING_ORDER, "Landroid/widget/ImageView;", "imageView", "e", "getView", "()Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class PrimaryFloatingButtonImpl implements PrimaryFloatingButton {
    public final TextView a;
    public final ImageView b;
    public final View c;
    public final int d;
    @NotNull
    public final View e;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ Function0 a;

        public a(Function0 function0) {
            this.a = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.invoke();
        }
    }

    public PrimaryFloatingButtonImpl(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.e = view;
        View findViewById = view.findViewById(R.id.fab_text);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        this.a = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.fab_image);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.ImageView");
        this.b = (ImageView) findViewById2;
        View findViewById3 = view.findViewById(R.id.fab_progress_bar);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.view.View");
        this.c = findViewById3;
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        Resources resources = context.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "view.context.resources");
        this.d = resources.getDisplayMetrics().heightPixels;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
            ((CoordinatorLayout.LayoutParams) layoutParams).setBehavior(new FloatingButtonBehavior());
        }
    }

    public final void a(int i, boolean z) {
        this.e.animate().translationY((float) i).setDuration(z ? 300 : 0).start();
    }

    @NotNull
    public final View getView() {
        return this.e;
    }

    @Override // ru.avito.component.button.Button
    public boolean isEnabled() {
        return this.e.isEnabled();
    }

    @Override // ru.avito.component.floating_button.PrimaryFloatingButton
    public void moveIn(boolean z) {
        a(0, z);
    }

    @Override // ru.avito.component.floating_button.PrimaryFloatingButton
    public void moveOut(boolean z) {
        a(this.d - this.e.getTop(), z);
    }

    @Override // ru.avito.component.button.Button
    public void setClickListener(@Nullable Function0<Unit> function0) {
        if (function0 != null) {
            this.e.setOnClickListener(new a(function0));
        } else {
            this.e.setOnClickListener(null);
        }
    }

    @Override // ru.avito.component.button.Button
    public void setEnabled(boolean z) {
        this.e.setEnabled(z);
    }

    @Override // ru.avito.component.floating_button.PrimaryFloatingButton
    public void setImageDrawable(@NotNull Drawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        this.b.setImageDrawable(drawable);
    }

    @Override // ru.avito.component.floating_button.PrimaryFloatingButton
    public void setImageResource(@DrawableRes int i) {
        this.b.setImageResource(i);
    }

    @Override // ru.avito.component.floating_button.PrimaryFloatingButton
    public void setProgressBarVisible(boolean z) {
        if (z) {
            Views.conceal(this.a);
            Views.conceal(this.b);
            Views.show(this.c);
            return;
        }
        Views.show(this.a);
        Views.show(this.b);
        Views.hide(this.c);
    }

    @Override // ru.avito.component.button.Button
    public void setText(@Nullable CharSequence charSequence) {
        this.a.setText(charSequence);
    }

    @Override // ru.avito.component.button.Button
    public void setVisible(boolean z) {
        Views.setVisible(this.e, z);
    }

    @Override // ru.avito.component.button.Button
    public void setText(@StringRes int i) {
        this.a.setText(i);
    }
}
