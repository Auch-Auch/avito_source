package ru.avito.component.animator;

import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\r\u001a\u00020\b\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lru/avito/component/animator/AnimatorInfo;", "", "Landroidx/core/view/ViewPropertyAnimatorListener;", AuthSource.BOOKING_ORDER, "Landroidx/core/view/ViewPropertyAnimatorListener;", "getAnimationListener", "()Landroidx/core/view/ViewPropertyAnimatorListener;", "animationListener", "Landroidx/core/view/ViewPropertyAnimatorCompat;", AuthSource.SEND_ABUSE, "Landroidx/core/view/ViewPropertyAnimatorCompat;", "getAnimation", "()Landroidx/core/view/ViewPropertyAnimatorCompat;", "animation", "<init>", "(Landroidx/core/view/ViewPropertyAnimatorCompat;Landroidx/core/view/ViewPropertyAnimatorListener;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class AnimatorInfo {
    @NotNull
    public final ViewPropertyAnimatorCompat a;
    @Nullable
    public final ViewPropertyAnimatorListener b;

    public AnimatorInfo(@NotNull ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, @Nullable ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
        Intrinsics.checkNotNullParameter(viewPropertyAnimatorCompat, "animation");
        this.a = viewPropertyAnimatorCompat;
        this.b = viewPropertyAnimatorListener;
    }

    @NotNull
    public final ViewPropertyAnimatorCompat getAnimation() {
        return this.a;
    }

    @Nullable
    public final ViewPropertyAnimatorListener getAnimationListener() {
        return this.b;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AnimatorInfo(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, ViewPropertyAnimatorListener viewPropertyAnimatorListener, int i, j jVar) {
        this(viewPropertyAnimatorCompat, (i & 2) != 0 ? null : viewPropertyAnimatorListener);
    }
}
