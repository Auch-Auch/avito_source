package ru.sravni.android.bankproduct.utils.animation;

import android.animation.Animator;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u00002\u00020\u0001B£\u0001\u0012%\b\u0002\u0010\u0017\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0002¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\u00040\n\u0012%\b\u0002\u0010\u001a\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0002¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\u00040\n\u0012%\b\u0002\u0010\u0011\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0002¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\u00040\n\u0012%\b\u0002\u0010\u0014\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0002¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\u00040\n¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0006R6\u0010\u0011\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0002¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\u00040\n8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R6\u0010\u0014\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0002¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\u00040\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u000e\u001a\u0004\b\u0013\u0010\u0010R6\u0010\u0017\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0002¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\u00040\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u000e\u001a\u0004\b\u0016\u0010\u0010R6\u0010\u001a\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0002¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\u00040\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u000e\u001a\u0004\b\u0019\u0010\u0010¨\u0006\u001d"}, d2 = {"Lru/sravni/android/bankproduct/utils/animation/AnimationListenerAdapter;", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "", "onAnimationRepeat", "(Landroid/animation/Animator;)V", "onAnimationEnd", "onAnimationCancel", "onAnimationStart", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "c", "Lkotlin/jvm/functions/Function1;", "getOnCancel", "()Lkotlin/jvm/functions/Function1;", "onCancel", "d", "getOnStart", "onStart", AuthSource.SEND_ABUSE, "getOnRepeat", "onRepeat", AuthSource.BOOKING_ORDER, "getOnEnd", "onEnd", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class AnimationListenerAdapter implements Animator.AnimatorListener {
    @NotNull
    public final Function1<Animator, Unit> a;
    @NotNull
    public final Function1<Animator, Unit> b;
    @NotNull
    public final Function1<Animator, Unit> c;
    @NotNull
    public final Function1<Animator, Unit> d;

    /* compiled from: kotlin-style lambda group */
    public static final class a extends Lambda implements Function1<Animator, Unit> {
        public static final a b = new a(0);
        public static final a c = new a(1);
        public static final a d = new a(2);
        public static final a e = new a(3);
        public final /* synthetic */ int a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(int i) {
            super(1);
            this.a = i;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Animator animator) {
            int i = this.a;
            if (i == 0) {
                return Unit.INSTANCE;
            }
            if (i == 1) {
                return Unit.INSTANCE;
            }
            if (i == 2) {
                return Unit.INSTANCE;
            }
            if (i == 3) {
                return Unit.INSTANCE;
            }
            throw null;
        }
    }

    public AnimationListenerAdapter() {
        this(null, null, null, null, 15, null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.jvm.functions.Function1<? super android.animation.Animator, kotlin.Unit> */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.functions.Function1<? super android.animation.Animator, kotlin.Unit> */
    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.jvm.functions.Function1<? super android.animation.Animator, kotlin.Unit> */
    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: kotlin.jvm.functions.Function1<? super android.animation.Animator, kotlin.Unit> */
    /* JADX WARN: Multi-variable type inference failed */
    public AnimationListenerAdapter(@NotNull Function1<? super Animator, Unit> function1, @NotNull Function1<? super Animator, Unit> function12, @NotNull Function1<? super Animator, Unit> function13, @NotNull Function1<? super Animator, Unit> function14) {
        Intrinsics.checkParameterIsNotNull(function1, "onRepeat");
        Intrinsics.checkParameterIsNotNull(function12, "onEnd");
        Intrinsics.checkParameterIsNotNull(function13, "onCancel");
        Intrinsics.checkParameterIsNotNull(function14, "onStart");
        this.a = function1;
        this.b = function12;
        this.c = function13;
        this.d = function14;
    }

    @NotNull
    public final Function1<Animator, Unit> getOnCancel() {
        return this.c;
    }

    @NotNull
    public final Function1<Animator, Unit> getOnEnd() {
        return this.b;
    }

    @NotNull
    public final Function1<Animator, Unit> getOnRepeat() {
        return this.a;
    }

    @NotNull
    public final Function1<Animator, Unit> getOnStart() {
        return this.d;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(@NotNull Animator animator) {
        Intrinsics.checkParameterIsNotNull(animator, "animation");
        this.c.invoke(animator);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(@NotNull Animator animator) {
        Intrinsics.checkParameterIsNotNull(animator, "animation");
        this.b.invoke(animator);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(@NotNull Animator animator) {
        Intrinsics.checkParameterIsNotNull(animator, "animation");
        this.a.invoke(animator);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(@NotNull Animator animator) {
        Intrinsics.checkParameterIsNotNull(animator, "animation");
        this.d.invoke(animator);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AnimationListenerAdapter(Function1 function1, Function1 function12, Function1 function13, Function1 function14, int i, j jVar) {
        this((i & 1) != 0 ? a.b : function1, (i & 2) != 0 ? a.c : function12, (i & 4) != 0 ? a.d : function13, (i & 8) != 0 ? a.e : function14);
    }
}
