package ru.avito.component.info_label;

import a2.g.r.g;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.CycleInterpolator;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.animator.AnimatorInfo;
import ru.avito.component.animator.DefaultAnimatorStrategy;
import ru.avito.component.animator.VpaListenerAdapter;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000e\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\"\u0010#J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006JA\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJA\u0010\u0010\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0010\u0010\u000fJ\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0014\u0010\u0015R\u001c\u0010\u001b\u001a\u00020\u00168\u0016@\u0016XD¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001e\u001a\u00020\u00168\u0016@\u0016XD¢\u0006\f\n\u0004\b\u001c\u0010\u0018\u001a\u0004\b\u001d\u0010\u001aR\u001c\u0010!\u001a\u00020\u00168\u0016@\u0016XD¢\u0006\f\n\u0004\b\u001f\u0010\u0018\u001a\u0004\b \u0010\u001a¨\u0006$"}, d2 = {"Lru/avito/component/info_label/InfoLabelAnimatorStrategy;", "Lru/avito/component/animator/DefaultAnimatorStrategy;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "holder", "Lru/avito/component/animator/AnimatorInfo;", "animateAdd", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)Lru/avito/component/animator/AnimatorInfo;", "oldHolder", "newHolder", "", "fromX", "fromY", "toX", "toY", "animateChangeOld", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;IIII)Lru/avito/component/animator/AnimatorInfo;", "animateChangeNew", "Landroid/view/View;", "view", "Landroid/animation/ObjectAnimator;", AuthSource.SEND_ABUSE, "(Landroid/view/View;)Landroid/animation/ObjectAnimator;", "", g.a, "J", "getChangeDurationMs", "()J", "changeDurationMs", "e", "getAddDurationMs", "addDurationMs", "f", "getRemoveDurationMs", "removeDurationMs", "<init>", "()V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class InfoLabelAnimatorStrategy extends DefaultAnimatorStrategy {
    @NotNull
    public static final InfoLabelAnimatorStrategy INSTANCE = new InfoLabelAnimatorStrategy();
    public static final long e = 350;
    public static final long f = 350;
    public static final long g = 600;

    public final ObjectAnimator a(View view) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationX", 0.0f, view.getResources().getDimension(R.dimen.shake_animation_amplitude));
        Intrinsics.checkNotNullExpressionValue(ofFloat, "animator");
        ofFloat.setDuration(350L);
        ofFloat.setInterpolator(new CycleInterpolator(2.0f));
        return ofFloat;
    }

    @Override // ru.avito.component.animator.DefaultAnimatorStrategy, ru.avito.component.animator.AnimatorStrategy
    @NotNull
    public AnimatorInfo animateAdd(@NotNull RecyclerView.ViewHolder viewHolder) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        if ((viewHolder instanceof InfoLabelViewHolder) && ((InfoLabelViewHolder) viewHolder).getShouldAnimateError()) {
            View view = viewHolder.itemView;
            Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
            a(view).start();
        }
        return super.animateAdd(viewHolder);
    }

    @Override // ru.avito.component.animator.DefaultAnimatorStrategy, ru.avito.component.animator.AnimatorStrategy
    @NotNull
    public AnimatorInfo animateChangeNew(@Nullable RecyclerView.ViewHolder viewHolder, @NotNull RecyclerView.ViewHolder viewHolder2, int i, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(viewHolder2, "newHolder");
        if ((viewHolder2 instanceof InfoLabelViewHolder) && ((InfoLabelViewHolder) viewHolder2).getShouldAnimateError()) {
            View view = viewHolder2.itemView;
            Intrinsics.checkNotNullExpressionValue(view, "newHolder.itemView");
            ObjectAnimator a = a(view);
            a.setStartDelay(250);
            a.start();
        }
        ViewPropertyAnimatorCompat alpha = ViewCompat.animate(viewHolder2.itemView).setDuration(350).setStartDelay(250).alpha(1.0f);
        InfoLabelAnimatorStrategy$animateChangeNew$animationListener$1 infoLabelAnimatorStrategy$animateChangeNew$animationListener$1 = new VpaListenerAdapter() { // from class: ru.avito.component.info_label.InfoLabelAnimatorStrategy$animateChangeNew$animationListener$1
            @Override // ru.avito.component.animator.VpaListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(@NotNull View view2) {
                Intrinsics.checkNotNullParameter(view2, "view");
                view2.setAlpha(1.0f);
            }
        };
        Intrinsics.checkNotNullExpressionValue(alpha, "animation");
        return new AnimatorInfo(alpha, infoLabelAnimatorStrategy$animateChangeNew$animationListener$1);
    }

    @Override // ru.avito.component.animator.DefaultAnimatorStrategy, ru.avito.component.animator.AnimatorStrategy
    @NotNull
    public AnimatorInfo animateChangeOld(@NotNull RecyclerView.ViewHolder viewHolder, @Nullable RecyclerView.ViewHolder viewHolder2, int i, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(viewHolder, "oldHolder");
        ViewPropertyAnimatorCompat alpha = ViewCompat.animate(viewHolder.itemView).setDuration(350).alpha(0.0f);
        InfoLabelAnimatorStrategy$animateChangeOld$animationListener$1 infoLabelAnimatorStrategy$animateChangeOld$animationListener$1 = new VpaListenerAdapter() { // from class: ru.avito.component.info_label.InfoLabelAnimatorStrategy$animateChangeOld$animationListener$1
            @Override // ru.avito.component.animator.VpaListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(@NotNull View view) {
                Intrinsics.checkNotNullParameter(view, "view");
                view.setAlpha(1.0f);
            }
        };
        Intrinsics.checkNotNullExpressionValue(alpha, "animation");
        return new AnimatorInfo(alpha, infoLabelAnimatorStrategy$animateChangeOld$animationListener$1);
    }

    @Override // ru.avito.component.animator.DefaultAnimatorStrategy, ru.avito.component.animator.AnimatorStrategy
    public long getAddDurationMs() {
        return e;
    }

    @Override // ru.avito.component.animator.DefaultAnimatorStrategy, ru.avito.component.animator.AnimatorStrategy
    public long getChangeDurationMs() {
        return g;
    }

    @Override // ru.avito.component.animator.DefaultAnimatorStrategy, ru.avito.component.animator.AnimatorStrategy
    public long getRemoveDurationMs() {
        return f;
    }
}
