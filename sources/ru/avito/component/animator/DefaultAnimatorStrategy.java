package ru.avito.component.animator;

import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0011\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b+\u0010,J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J7\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\bH\u0016¢\u0006\u0004\b\r\u0010\u000eJA\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0016\u0010\u0015J7\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0017\u0010\u0018JA\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0019\u0010\u001aJA\u0010\u001b\u001a\u00020\u00132\b\u0010\u000f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001b\u0010\u001aR\u001c\u0010!\u001a\u00020\u001c8\u0016@\u0016XD¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001c\u0010$\u001a\u00020\u001c8\u0016@\u0016XD¢\u0006\f\n\u0004\b\"\u0010\u001e\u001a\u0004\b#\u0010 R\u001c\u0010'\u001a\u00020\u001c8\u0016@\u0016XD¢\u0006\f\n\u0004\b%\u0010\u001e\u001a\u0004\b&\u0010 R\u001c\u0010*\u001a\u00020\u001c8\u0016@\u0016XD¢\u0006\f\n\u0004\b(\u0010\u001e\u001a\u0004\b)\u0010 ¨\u0006-"}, d2 = {"Lru/avito/component/animator/DefaultAnimatorStrategy;", "Lru/avito/component/animator/AnimatorStrategy;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "holder", "", "preAnimateRemove", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)Z", "preAnimateAdd", "", "fromX", "fromY", "toX", "toY", "preAnimateMove", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;IIII)Z", "oldHolder", "newHolder", "preAnimateChange", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;IIII)Z", "Lru/avito/component/animator/AnimatorInfo;", "animateRemove", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)Lru/avito/component/animator/AnimatorInfo;", "animateAdd", "animateMove", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;IIII)Lru/avito/component/animator/AnimatorInfo;", "animateChangeOld", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;IIII)Lru/avito/component/animator/AnimatorInfo;", "animateChangeNew", "", AuthSource.BOOKING_ORDER, "J", "getAddDurationMs", "()J", "addDurationMs", "c", "getRemoveDurationMs", "removeDurationMs", AuthSource.SEND_ABUSE, "getMoveDurationMs", "moveDurationMs", "d", "getChangeDurationMs", "changeDurationMs", "<init>", "()V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public class DefaultAnimatorStrategy implements AnimatorStrategy {
    public final long a = DefaultAnimatorStrategyKt.access$getDEFAULT_MOVE_DURATION_MS$p();
    public final long b = 120;
    public final long c = DefaultAnimatorStrategyKt.access$getDEFAULT_REMOVE_DURATION_MS$p();
    public final long d = DefaultAnimatorStrategyKt.access$getDEFAULT_CHANGE_DURATION_MS$p();

    @Override // ru.avito.component.animator.AnimatorStrategy
    @NotNull
    public AnimatorInfo animateAdd(@NotNull RecyclerView.ViewHolder viewHolder) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        ViewPropertyAnimatorCompat alpha = ViewCompat.animate(viewHolder.itemView).setDuration(getAddDurationMs()).alpha(1.0f);
        DefaultAnimatorStrategy$animateAdd$animationListener$1 defaultAnimatorStrategy$animateAdd$animationListener$1 = new VpaListenerAdapter() { // from class: ru.avito.component.animator.DefaultAnimatorStrategy$animateAdd$animationListener$1
            @Override // ru.avito.component.animator.VpaListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationCancel(@NotNull View view) {
                Intrinsics.checkNotNullParameter(view, "view");
                view.setAlpha(1.0f);
            }
        };
        Intrinsics.checkNotNullExpressionValue(alpha, "animation");
        return new AnimatorInfo(alpha, defaultAnimatorStrategy$animateAdd$animationListener$1);
    }

    @Override // ru.avito.component.animator.AnimatorStrategy
    @NotNull
    public AnimatorInfo animateChangeNew(@Nullable RecyclerView.ViewHolder viewHolder, @NotNull RecyclerView.ViewHolder viewHolder2, int i, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(viewHolder2, "newHolder");
        ViewPropertyAnimatorCompat alpha = ViewCompat.animate(viewHolder2.itemView).setDuration(getChangeDurationMs()).translationX(0.0f).translationY(0.0f).alpha(1.0f);
        DefaultAnimatorStrategy$animateChangeNew$animationListener$1 defaultAnimatorStrategy$animateChangeNew$animationListener$1 = new VpaListenerAdapter() { // from class: ru.avito.component.animator.DefaultAnimatorStrategy$animateChangeNew$animationListener$1
            @Override // ru.avito.component.animator.VpaListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(@NotNull View view) {
                Intrinsics.checkNotNullParameter(view, "view");
                view.setAlpha(1.0f);
                view.setTranslationX(0.0f);
                view.setTranslationY(0.0f);
            }
        };
        Intrinsics.checkNotNullExpressionValue(alpha, "animation");
        return new AnimatorInfo(alpha, defaultAnimatorStrategy$animateChangeNew$animationListener$1);
    }

    @Override // ru.avito.component.animator.AnimatorStrategy
    @NotNull
    public AnimatorInfo animateChangeOld(@NotNull RecyclerView.ViewHolder viewHolder, @Nullable RecyclerView.ViewHolder viewHolder2, int i, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(viewHolder, "oldHolder");
        ViewPropertyAnimatorCompat alpha = ViewCompat.animate(viewHolder.itemView).setDuration(getChangeDurationMs()).translationX((float) (i3 - i)).translationY((float) (i4 - i2)).alpha(0.0f);
        DefaultAnimatorStrategy$animateChangeOld$animationListener$1 defaultAnimatorStrategy$animateChangeOld$animationListener$1 = new VpaListenerAdapter() { // from class: ru.avito.component.animator.DefaultAnimatorStrategy$animateChangeOld$animationListener$1
            @Override // ru.avito.component.animator.VpaListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(@NotNull View view) {
                Intrinsics.checkNotNullParameter(view, "view");
                view.setAlpha(1.0f);
                view.setTranslationX(0.0f);
                view.setTranslationY(0.0f);
            }
        };
        Intrinsics.checkNotNullExpressionValue(alpha, "animation");
        return new AnimatorInfo(alpha, defaultAnimatorStrategy$animateChangeOld$animationListener$1);
    }

    @Override // ru.avito.component.animator.AnimatorStrategy
    @NotNull
    public AnimatorInfo animateMove(@NotNull RecyclerView.ViewHolder viewHolder, int i, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        View view = viewHolder.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
        int i5 = i3 - i;
        int i6 = i4 - i2;
        if (i5 != 0) {
            ViewCompat.animate(view).translationX(0.0f);
        }
        if (i6 != 0) {
            ViewCompat.animate(view).translationY(0.0f);
        }
        ViewPropertyAnimatorCompat duration = ViewCompat.animate(view).setDuration(getMoveDurationMs());
        DefaultAnimatorStrategy$animateMove$animationListener$1 defaultAnimatorStrategy$animateMove$animationListener$1 = new VpaListenerAdapter(i5, i6) { // from class: ru.avito.component.animator.DefaultAnimatorStrategy$animateMove$animationListener$1
            public final /* synthetic */ int a;
            public final /* synthetic */ int b;

            {
                this.a = r1;
                this.b = r2;
            }

            @Override // ru.avito.component.animator.VpaListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationCancel(@NotNull View view2) {
                Intrinsics.checkNotNullParameter(view2, "view");
                if (this.a != 0) {
                    view2.setTranslationX(0.0f);
                }
                if (this.b != 0) {
                    view2.setTranslationY(0.0f);
                }
            }
        };
        Intrinsics.checkNotNullExpressionValue(duration, "animation");
        return new AnimatorInfo(duration, defaultAnimatorStrategy$animateMove$animationListener$1);
    }

    @Override // ru.avito.component.animator.AnimatorStrategy
    @NotNull
    public AnimatorInfo animateRemove(@NotNull RecyclerView.ViewHolder viewHolder) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        ViewPropertyAnimatorCompat alpha = ViewCompat.animate(viewHolder.itemView).setDuration(getRemoveDurationMs()).alpha(0.0f);
        DefaultAnimatorStrategy$animateRemove$animationListener$1 defaultAnimatorStrategy$animateRemove$animationListener$1 = new VpaListenerAdapter() { // from class: ru.avito.component.animator.DefaultAnimatorStrategy$animateRemove$animationListener$1
            @Override // ru.avito.component.animator.VpaListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(@NotNull View view) {
                Intrinsics.checkNotNullParameter(view, "view");
                view.setAlpha(1.0f);
            }
        };
        Intrinsics.checkNotNullExpressionValue(alpha, "animation");
        return new AnimatorInfo(alpha, defaultAnimatorStrategy$animateRemove$animationListener$1);
    }

    @Override // ru.avito.component.animator.AnimatorStrategy
    public long getAddDurationMs() {
        return this.b;
    }

    @Override // ru.avito.component.animator.AnimatorStrategy
    public long getChangeDurationMs() {
        return this.d;
    }

    @Override // ru.avito.component.animator.AnimatorStrategy
    public long getMoveDurationMs() {
        return this.a;
    }

    @Override // ru.avito.component.animator.AnimatorStrategy
    public long getRemoveDurationMs() {
        return this.c;
    }

    @Override // ru.avito.component.animator.AnimatorStrategy
    public boolean preAnimateAdd(@NotNull RecyclerView.ViewHolder viewHolder) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        View view = viewHolder.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
        view.setAlpha(0.0f);
        return true;
    }

    @Override // ru.avito.component.animator.AnimatorStrategy
    public boolean preAnimateChange(@NotNull RecyclerView.ViewHolder viewHolder, @Nullable RecyclerView.ViewHolder viewHolder2, int i, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(viewHolder, "oldHolder");
        return true;
    }

    @Override // ru.avito.component.animator.AnimatorStrategy
    public boolean preAnimateMove(@NotNull RecyclerView.ViewHolder viewHolder, int i, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        View view = viewHolder.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
        int i5 = i3 - i;
        int i6 = i4 - i2;
        if (i5 == 0 && i6 == 0) {
            return false;
        }
        if (i5 != 0) {
            view.setTranslationX((float) (-i5));
        }
        if (i6 == 0) {
            return true;
        }
        view.setTranslationY((float) (-i6));
        return true;
    }

    @Override // ru.avito.component.animator.AnimatorStrategy
    public boolean preAnimateRemove(@NotNull RecyclerView.ViewHolder viewHolder) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        return true;
    }
}
