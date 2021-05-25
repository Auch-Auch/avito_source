package com.avito.android.category;

import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.avito.android.category.CategoryItemAnimator;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.Views;
import com.vk.sdk.api.VKApiConst;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001:\u0004\u0010\b\fJB\u000f\u0012\u0006\u0010A\u001a\u00020>¢\u0006\u0004\bH\u0010IJ%\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ!\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0010\u001a\u00020\u00072\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0017\u0010\u0016J7\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ?\u0010!\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u0018H\u0016¢\u0006\u0004\b!\u0010\"J\u0017\u0010#\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\u000bH\u0016¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\u0007H\u0016¢\u0006\u0004\b'\u0010\u0013R\"\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020(0\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\"\u0010-\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010*R\u001c\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00050\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010*R\u001c\u00101\u001a\b\u0012\u0004\u0012\u00020\u00050\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u0010*R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u001c\u00107\u001a\b\u0012\u0004\u0012\u00020\u00050\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b6\u0010*R\u001c\u00109\u001a\b\u0012\u0004\u0012\u00020\u00050\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b8\u0010*R\"\u0010;\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b:\u0010*R\u001c\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00050\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b<\u0010*R\u0016\u0010A\u001a\u00020>8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b?\u0010@R\u001c\u0010C\u001a\b\u0012\u0004\u0012\u00020(0\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bB\u0010*R\u001c\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bD\u0010*R\u001c\u0010G\u001a\b\u0012\u0004\u0012\u00020\u00050\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bF\u0010*¨\u0006K"}, d2 = {"Lcom/avito/android/category/CategoryItemAnimator;", "Landroidx/recyclerview/widget/SimpleItemAnimator;", "", "Lcom/avito/android/category/CategoryItemAnimator$b;", "infoList", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "item", "", "c", "(Ljava/util/List;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)V", "changeInfo", "", "d", "(Lcom/avito/android/category/CategoryItemAnimator$b;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)Z", "", "viewHolders", AuthSource.BOOKING_ORDER, "(Ljava/util/List;)V", "runPendingAnimations", "()V", "holder", "animateRemove", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)Z", "animateAdd", "", "fromX", "fromY", "toX", "toY", "animateMove", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;IIII)Z", "oldHolder", "newHolder", "animateChange", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;IIII)Z", "endAnimation", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)V", "isRunning", "()Z", "endAnimations", "Lcom/avito/android/category/CategoryItemAnimator$e;", AuthSource.OPEN_CHANNEL_LIST, "Ljava/util/List;", "movesList", "n", "changesList", "o", "addAnimations", "r", "changeAnimations", "Landroid/view/animation/Interpolator;", "s", "Landroid/view/animation/Interpolator;", "interpolator", "p", "moveAnimations", "h", "pendingRemovals", "l", "additionsList", VKApiConst.Q, "removeAnimations", "Lcom/avito/android/util/BuildInfo;", "t", "Lcom/avito/android/util/BuildInfo;", "build", "j", "pendingMoves", "k", "pendingChanges", "i", "pendingAdditions", "<init>", "(Lcom/avito/android/util/BuildInfo;)V", "e", "category_release"}, k = 1, mv = {1, 4, 2})
public final class CategoryItemAnimator extends SimpleItemAnimator {
    public final List<RecyclerView.ViewHolder> h = new ArrayList();
    public final List<RecyclerView.ViewHolder> i = new ArrayList();
    public final List<e> j = new ArrayList();
    public final List<b> k = new ArrayList();
    public final List<List<RecyclerView.ViewHolder>> l = new ArrayList();
    public final List<List<e>> m = new ArrayList();
    public final List<List<b>> n = new ArrayList();
    public final List<RecyclerView.ViewHolder> o = new ArrayList();
    public final List<RecyclerView.ViewHolder> p = new ArrayList();
    public final List<RecyclerView.ViewHolder> q = new ArrayList();
    public final List<RecyclerView.ViewHolder> r = new ArrayList();
    public Interpolator s = new LinearInterpolator();
    public final BuildInfo t;

    /* compiled from: java-style lambda group */
    public static final class a implements Runnable {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;
        public final /* synthetic */ Object c;

        public a(int i, Object obj, Object obj2) {
            this.a = i;
            this.b = obj;
            this.c = obj2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            int i = this.a;
            if (i == 0) {
                for (RecyclerView.ViewHolder viewHolder : (List) this.c) {
                    CategoryItemAnimator.access$doAnimateAdd((CategoryItemAnimator) this.b, viewHolder);
                }
                ((List) this.c).clear();
                ((CategoryItemAnimator) this.b).l.remove((List) this.c);
            } else if (i == 1) {
                for (b bVar : (List) this.c) {
                    CategoryItemAnimator.access$animateChangeImpl((CategoryItemAnimator) this.b, bVar);
                }
                ((List) this.c).clear();
                ((CategoryItemAnimator) this.b).n.remove((List) this.c);
            } else if (i == 2) {
                for (e eVar : (List) this.c) {
                    CategoryItemAnimator.access$animateMoveImpl((CategoryItemAnimator) this.b, eVar.a, eVar.b, eVar.c, eVar.d, eVar.e);
                }
                ((List) this.c).clear();
                ((CategoryItemAnimator) this.b).m.remove((List) this.c);
            } else {
                throw null;
            }
        }
    }

    public static final class b {
        public int a;
        public int b;
        public int c;
        public int d;
        @Nullable
        public RecyclerView.ViewHolder e;
        @Nullable
        public RecyclerView.ViewHolder f;

        public b(@NotNull RecyclerView.ViewHolder viewHolder, @NotNull RecyclerView.ViewHolder viewHolder2, int i, int i2, int i3, int i4) {
            Intrinsics.checkNotNullParameter(viewHolder, "oldHolder");
            Intrinsics.checkNotNullParameter(viewHolder2, "newHolder");
            this.e = viewHolder;
            this.f = viewHolder2;
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("ChangeInfo{oldHolder=");
            L.append(this.e);
            L.append(", newHolder=");
            L.append(this.f);
            L.append(", fromX=");
            L.append(this.a);
            L.append(", fromY=");
            L.append(this.b);
            L.append(", toX=");
            L.append(this.c);
            L.append(", toY=");
            return a2.b.a.a.a.i(L, this.d, '}');
        }
    }

    public final class c implements ViewPropertyAnimatorListener {
        @NotNull
        public RecyclerView.ViewHolder a;
        public final /* synthetic */ CategoryItemAnimator b;

        public c(@NotNull CategoryItemAnimator categoryItemAnimator, RecyclerView.ViewHolder viewHolder) {
            Intrinsics.checkNotNullParameter(viewHolder, "mViewHolder");
            this.b = categoryItemAnimator;
            this.a = viewHolder;
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationCancel(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            Views.setDefaultValues(view);
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            Views.setDefaultValues(view);
            this.b.dispatchAddFinished(this.a);
            this.b.o.remove(this.a);
            CategoryItemAnimator.access$dispatchFinishedWhenDone(this.b);
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationStart(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            this.b.dispatchAddStarting(this.a);
        }
    }

    public final class d implements ViewPropertyAnimatorListener {
        @NotNull
        public RecyclerView.ViewHolder a;
        public final /* synthetic */ CategoryItemAnimator b;

        public d(@NotNull CategoryItemAnimator categoryItemAnimator, RecyclerView.ViewHolder viewHolder) {
            Intrinsics.checkNotNullParameter(viewHolder, "mViewHolder");
            this.b = categoryItemAnimator;
            this.a = viewHolder;
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationCancel(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            Views.setDefaultValues(view);
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            Views.setDefaultValues(view);
            this.b.dispatchRemoveFinished(this.a);
            this.b.q.remove(this.a);
            CategoryItemAnimator.access$dispatchFinishedWhenDone(this.b);
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationStart(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            this.b.dispatchRemoveStarting(this.a);
        }
    }

    public static final class e {
        @NotNull
        public RecyclerView.ViewHolder a;
        public int b;
        public int c;
        public int d;
        public int e;

        public e(@NotNull RecyclerView.ViewHolder viewHolder, int i, int i2, int i3, int i4) {
            Intrinsics.checkNotNullParameter(viewHolder, "holder");
            this.a = viewHolder;
            this.b = i;
            this.c = i2;
            this.d = i3;
            this.e = i4;
        }
    }

    public CategoryItemAnimator(@NotNull BuildInfo buildInfo) {
        Intrinsics.checkNotNullParameter(buildInfo, "build");
        this.t = buildInfo;
        setSupportsChangeAnimations(false);
    }

    public static final void access$animateChangeImpl(CategoryItemAnimator categoryItemAnimator, b bVar) {
        Objects.requireNonNull(categoryItemAnimator);
        RecyclerView.ViewHolder viewHolder = bVar.e;
        if (viewHolder != null) {
            View view = viewHolder.itemView;
            Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
            RecyclerView.ViewHolder viewHolder2 = bVar.f;
            View view2 = viewHolder2 != null ? viewHolder2.itemView : null;
            if (view != null) {
                categoryItemAnimator.r.add(viewHolder);
                ViewPropertyAnimatorCompat duration = ViewCompat.animate(view).setDuration(categoryItemAnimator.getChangeDuration());
                duration.translationX((float) (bVar.c - bVar.a));
                duration.translationY((float) (bVar.d - bVar.b));
                duration.alpha(1.0f).setListener(new ViewPropertyAnimatorListener(bVar, duration, viewHolder) { // from class: com.avito.android.category.CategoryItemAnimator$animateChangeImpl$1
                    public final /* synthetic */ CategoryItemAnimator.b b;
                    public final /* synthetic */ ViewPropertyAnimatorCompat c;
                    public final /* synthetic */ RecyclerView.ViewHolder d;

                    {
                        this.b = r2;
                        this.c = r3;
                        this.d = r4;
                    }

                    @Override // androidx.core.view.ViewPropertyAnimatorListener
                    public void onAnimationCancel(@Nullable View view3) {
                    }

                    @Override // androidx.core.view.ViewPropertyAnimatorListener
                    public void onAnimationEnd(@NotNull View view3) {
                        Intrinsics.checkNotNullParameter(view3, "view");
                        this.c.setListener(null);
                        view3.setAlpha(1.0f);
                        view3.setTranslationX(0.0f);
                        view3.setTranslationY(0.0f);
                        CategoryItemAnimator.this.dispatchChangeFinished(this.b.e, true);
                        CategoryItemAnimator.access$getChangeAnimations$p(CategoryItemAnimator.this).remove(this.d);
                        CategoryItemAnimator.access$dispatchFinishedWhenDone(CategoryItemAnimator.this);
                    }

                    @Override // androidx.core.view.ViewPropertyAnimatorListener
                    public void onAnimationStart(@NotNull View view3) {
                        Intrinsics.checkNotNullParameter(view3, "view");
                        CategoryItemAnimator.this.dispatchChangeStarting(this.b.e, true);
                    }
                }).start();
            }
            if (view2 != null) {
                categoryItemAnimator.r.add(viewHolder);
                ViewPropertyAnimatorCompat animate = ViewCompat.animate(view2);
                Intrinsics.checkNotNullExpressionValue(animate, "ViewCompat.animate(newView)");
                animate.translationX(0.0f).translationY(0.0f).setDuration(categoryItemAnimator.getChangeDuration()).alpha(1.0f).setListener(new ViewPropertyAnimatorListener(bVar, animate, view2) { // from class: com.avito.android.category.CategoryItemAnimator$animateChangeImpl$2
                    public final /* synthetic */ CategoryItemAnimator.b b;
                    public final /* synthetic */ ViewPropertyAnimatorCompat c;
                    public final /* synthetic */ View d;

                    {
                        this.b = r2;
                        this.c = r3;
                        this.d = r4;
                    }

                    @Override // androidx.core.view.ViewPropertyAnimatorListener
                    public void onAnimationCancel(@Nullable View view3) {
                    }

                    @Override // androidx.core.view.ViewPropertyAnimatorListener
                    public void onAnimationEnd(@NotNull View view3) {
                        Intrinsics.checkNotNullParameter(view3, "view");
                        this.c.setListener(null);
                        this.d.setAlpha(1.0f);
                        view3.setTranslationX(0.0f);
                        view3.setTranslationY(0.0f);
                        CategoryItemAnimator.this.dispatchChangeFinished(this.b.f, false);
                        RecyclerView.ViewHolder viewHolder3 = this.b.f;
                        List access$getChangeAnimations$p = CategoryItemAnimator.access$getChangeAnimations$p(CategoryItemAnimator.this);
                        Objects.requireNonNull(access$getChangeAnimations$p, "null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
                        TypeIntrinsics.asMutableCollection(access$getChangeAnimations$p).remove(viewHolder3);
                        CategoryItemAnimator.access$dispatchFinishedWhenDone(CategoryItemAnimator.this);
                    }

                    @Override // androidx.core.view.ViewPropertyAnimatorListener
                    public void onAnimationStart(@NotNull View view3) {
                        Intrinsics.checkNotNullParameter(view3, "view");
                        CategoryItemAnimator.this.dispatchChangeStarting(this.b.f, false);
                    }
                }).start();
            }
        }
    }

    public static final void access$animateMoveImpl(CategoryItemAnimator categoryItemAnimator, RecyclerView.ViewHolder viewHolder, int i2, int i3, int i4, int i5) {
        Objects.requireNonNull(categoryItemAnimator);
        View view = viewHolder.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
        int i6 = i4 - i2;
        int i7 = i5 - i3;
        if (i6 != 0) {
            ViewCompat.animate(view).translationX(0.0f);
        }
        if (i7 != 0) {
            ViewCompat.animate(view).translationY(0.0f);
        }
        categoryItemAnimator.p.add(viewHolder);
        ViewPropertyAnimatorCompat animate = ViewCompat.animate(view);
        Intrinsics.checkNotNullExpressionValue(animate, "ViewCompat.animate(view)");
        animate.setDuration(categoryItemAnimator.getMoveDuration()).setListener(new ViewPropertyAnimatorListener(viewHolder, i6, i7, animate) { // from class: com.avito.android.category.CategoryItemAnimator$animateMoveImpl$1
            public final /* synthetic */ RecyclerView.ViewHolder b;
            public final /* synthetic */ int c;
            public final /* synthetic */ int d;
            public final /* synthetic */ ViewPropertyAnimatorCompat e;

            {
                this.b = r2;
                this.c = r3;
                this.d = r4;
                this.e = r5;
            }

            @Override // androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationCancel(@NotNull View view2) {
                Intrinsics.checkNotNullParameter(view2, "view");
                if (this.c != 0) {
                    view2.setTranslationX(0.0f);
                }
                if (this.d != 0) {
                    view2.setTranslationY(0.0f);
                }
            }

            @Override // androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(@NotNull View view2) {
                Intrinsics.checkNotNullParameter(view2, "view");
                this.e.setListener(null);
                CategoryItemAnimator.this.dispatchMoveFinished(this.b);
                CategoryItemAnimator.access$getMoveAnimations$p(CategoryItemAnimator.this).remove(this.b);
                CategoryItemAnimator.access$dispatchFinishedWhenDone(CategoryItemAnimator.this);
            }

            @Override // androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationStart(@NotNull View view2) {
                Intrinsics.checkNotNullParameter(view2, "view");
                CategoryItemAnimator.this.dispatchMoveStarting(this.b);
            }
        }).start();
    }

    public static final void access$dispatchFinishedWhenDone(CategoryItemAnimator categoryItemAnimator) {
        if (!categoryItemAnimator.isRunning()) {
            categoryItemAnimator.dispatchAnimationsFinished();
        }
    }

    public static final void access$doAnimateAdd(CategoryItemAnimator categoryItemAnimator, RecyclerView.ViewHolder viewHolder) {
        Objects.requireNonNull(categoryItemAnimator);
        ViewCompat.animate(viewHolder.itemView).translationY(0.0f).alpha(1.0f).setDuration(categoryItemAnimator.getAddDuration()).setInterpolator(categoryItemAnimator.s).setListener(new c(categoryItemAnimator, viewHolder)).setStartDelay(Math.abs((categoryItemAnimator.getAddDuration() * ((long) viewHolder.getAdapterPosition())) / ((long) 4))).start();
        categoryItemAnimator.o.add(viewHolder);
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    /* renamed from: animateAdd */
    public boolean mo732animateAdd(@NotNull RecyclerView.ViewHolder viewHolder) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        endAnimation(viewHolder);
        View view = viewHolder.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
        Views.setDefaultValues(view);
        this.i.add(viewHolder);
        return true;
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public boolean animateChange(@NotNull RecyclerView.ViewHolder viewHolder, @NotNull RecyclerView.ViewHolder viewHolder2, int i2, int i3, int i4, int i5) {
        Intrinsics.checkNotNullParameter(viewHolder, "oldHolder");
        Intrinsics.checkNotNullParameter(viewHolder2, "newHolder");
        View view = viewHolder.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "oldHolder.itemView");
        float translationX = view.getTranslationX();
        View view2 = viewHolder.itemView;
        Intrinsics.checkNotNullExpressionValue(view2, "oldHolder.itemView");
        float translationY = view2.getTranslationY();
        View view3 = viewHolder.itemView;
        Intrinsics.checkNotNullExpressionValue(view3, "oldHolder.itemView");
        float alpha = view3.getAlpha();
        endAnimation(viewHolder);
        int i6 = (int) ((((float) i4) - ((float) i2)) - translationX);
        int i7 = (int) ((((float) i5) - ((float) i3)) - translationY);
        View view4 = viewHolder.itemView;
        Intrinsics.checkNotNullExpressionValue(view4, "oldHolder.itemView");
        view4.setTranslationX(translationX);
        View view5 = viewHolder.itemView;
        Intrinsics.checkNotNullExpressionValue(view5, "oldHolder.itemView");
        view5.setTranslationY(translationY);
        View view6 = viewHolder.itemView;
        Intrinsics.checkNotNullExpressionValue(view6, "oldHolder.itemView");
        view6.setAlpha(alpha);
        if (viewHolder2.itemView != null) {
            endAnimation(viewHolder2);
            View view7 = viewHolder2.itemView;
            Intrinsics.checkNotNullExpressionValue(view7, "newHolder.itemView");
            view7.setTranslationX((float) (-i6));
            View view8 = viewHolder2.itemView;
            Intrinsics.checkNotNullExpressionValue(view8, "newHolder.itemView");
            view8.setTranslationY((float) (-i7));
            View view9 = viewHolder2.itemView;
            Intrinsics.checkNotNullExpressionValue(view9, "newHolder.itemView");
            view9.setAlpha(1.0f);
        }
        this.k.add(new b(viewHolder, viewHolder2, i2, i3, i4, i5));
        return true;
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    /* renamed from: animateMove */
    public boolean mo733animateMove(@NotNull RecyclerView.ViewHolder viewHolder, int i2, int i3, int i4, int i5) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        View view = viewHolder.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
        View view2 = viewHolder.itemView;
        Intrinsics.checkNotNullExpressionValue(view2, "holder.itemView");
        int translationX = i2 + ((int) view2.getTranslationX());
        View view3 = viewHolder.itemView;
        Intrinsics.checkNotNullExpressionValue(view3, "holder.itemView");
        int translationY = i3 + ((int) view3.getTranslationY());
        endAnimation(viewHolder);
        int i6 = i4 - translationX;
        int i7 = i5 - translationY;
        if (i6 == 0 && i7 == 0) {
            dispatchMoveFinished(viewHolder);
            return false;
        }
        if (i6 != 0) {
            view.setTranslationX((float) (-i6));
        }
        if (i7 != 0) {
            view.setTranslationY((float) (-i7));
        }
        this.j.add(new e(viewHolder, translationX, translationY, i4, i5));
        return true;
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    /* renamed from: animateRemove */
    public boolean mo734animateRemove(@NotNull RecyclerView.ViewHolder viewHolder) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        endAnimation(viewHolder);
        View view = viewHolder.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
        Views.setDefaultValues(view);
        this.h.add(viewHolder);
        return true;
    }

    public final void b(List<? extends RecyclerView.ViewHolder> list) {
        int size = list.size();
        while (true) {
            size--;
            if (size >= 0) {
                ViewCompat.animate(((RecyclerView.ViewHolder) list.get(size)).itemView).cancel();
            } else {
                return;
            }
        }
    }

    public final void c(List<b> list, RecyclerView.ViewHolder viewHolder) {
        int size = list.size();
        while (true) {
            size--;
            if (size >= 0) {
                b bVar = list.get(size);
                if (d(bVar, viewHolder) && bVar.e == null && bVar.f == null) {
                    list.remove(bVar);
                }
            } else {
                return;
            }
        }
    }

    public final boolean d(b bVar, RecyclerView.ViewHolder viewHolder) {
        boolean z = false;
        if (viewHolder != null) {
            if (bVar.f == viewHolder) {
                bVar.f = null;
            } else if (bVar.e == viewHolder) {
                bVar.e = null;
                z = true;
            }
            View view = viewHolder.itemView;
            Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
            view.setAlpha(1.0f);
            View view2 = viewHolder.itemView;
            Intrinsics.checkNotNullExpressionValue(view2, "holder.itemView");
            view2.setTranslationX(0.0f);
            View view3 = viewHolder.itemView;
            Intrinsics.checkNotNullExpressionValue(view3, "holder.itemView");
            view3.setTranslationY(0.0f);
            dispatchChangeFinished(viewHolder, z);
            return true;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public void endAnimation(@NotNull RecyclerView.ViewHolder viewHolder) {
        Intrinsics.checkNotNullParameter(viewHolder, "item");
        View view = viewHolder.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "item.itemView");
        ViewCompat.animate(view).cancel();
        int size = this.j.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            } else if (this.j.get(size).a == viewHolder) {
                view.setTranslationX(0.0f);
                view.setTranslationY(0.0f);
                dispatchMoveFinished(viewHolder);
                this.j.remove(size);
            }
        }
        c(this.k, viewHolder);
        if (this.h.remove(viewHolder)) {
            View view2 = viewHolder.itemView;
            Intrinsics.checkNotNullExpressionValue(view2, "item.itemView");
            Views.setDefaultValues(view2);
            dispatchRemoveFinished(viewHolder);
        }
        if (this.i.remove(viewHolder)) {
            View view3 = viewHolder.itemView;
            Intrinsics.checkNotNullExpressionValue(view3, "item.itemView");
            Views.setDefaultValues(view3);
            dispatchAddFinished(viewHolder);
        }
        int size2 = this.n.size();
        while (true) {
            size2--;
            if (size2 < 0) {
                break;
            }
            List<b> list = this.n.get(size2);
            c(list, viewHolder);
            if (list.isEmpty()) {
                this.n.remove(size2);
            }
        }
        int size3 = this.m.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            List<e> list2 = this.m.get(size3);
            int size4 = list2.size();
            while (true) {
                size4--;
                if (size4 < 0) {
                    break;
                } else if (list2.get(size4).a == viewHolder) {
                    view.setTranslationX(0.0f);
                    view.setTranslationY(0.0f);
                    dispatchMoveFinished(viewHolder);
                    list2.remove(size4);
                    if (list2.isEmpty()) {
                        this.m.remove(size3);
                    }
                }
            }
        }
        int size5 = this.l.size();
        while (true) {
            size5--;
            if (size5 < 0) {
                break;
            }
            List<RecyclerView.ViewHolder> list3 = this.l.get(size5);
            if (list3.remove(viewHolder)) {
                View view4 = viewHolder.itemView;
                Intrinsics.checkNotNullExpressionValue(view4, "item.itemView");
                Views.setDefaultValues(view4);
                dispatchAddFinished(viewHolder);
                if (list3.isEmpty()) {
                    this.l.remove(size5);
                }
            }
        }
        if (this.q.remove(viewHolder) && this.t.isDebug()) {
            throw new IllegalStateException("after animation is cancelled, item should not be in removeAnimations list");
        } else if (this.o.remove(viewHolder) && this.t.isDebug()) {
            throw new IllegalStateException("after animation is cancelled, item should not be in addAnimations list");
        } else if (this.r.remove(viewHolder) && this.t.isDebug()) {
            throw new IllegalStateException("after animation is cancelled, item should not be in changeAnimations list");
        } else if (this.p.remove(viewHolder) && this.t.isDebug()) {
            throw new IllegalStateException("after animation is cancelled, item should not be in moveAnimations list");
        } else if (!isRunning()) {
            dispatchAnimationsFinished();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public void endAnimations() {
        int size = this.j.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            e eVar = this.j.get(size);
            View view = eVar.a.itemView;
            Intrinsics.checkNotNullExpressionValue(view, "item.holder.itemView");
            view.setTranslationX(0.0f);
            view.setTranslationY(0.0f);
            dispatchMoveFinished(eVar.a);
            this.j.remove(size);
        }
        int size2 = this.h.size();
        while (true) {
            size2--;
            if (size2 < 0) {
                break;
            }
            dispatchRemoveFinished(this.h.get(size2));
            this.h.remove(size2);
        }
        int size3 = this.i.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            RecyclerView.ViewHolder viewHolder = this.i.get(size3);
            View view2 = viewHolder.itemView;
            Intrinsics.checkNotNullExpressionValue(view2, "item.itemView");
            Views.setDefaultValues(view2);
            dispatchAddFinished(viewHolder);
            this.i.remove(size3);
        }
        int size4 = this.k.size();
        while (true) {
            size4--;
            if (size4 < 0) {
                break;
            }
            b bVar = this.k.get(size4);
            d(bVar, bVar.e);
            d(bVar, bVar.f);
        }
        this.k.clear();
        if (isRunning()) {
            int size5 = this.m.size();
            while (true) {
                size5--;
                if (size5 < 0) {
                    break;
                }
                List<e> list = this.m.get(size5);
                int size6 = list.size();
                while (true) {
                    size6--;
                    if (size6 >= 0) {
                        e eVar2 = list.get(size6);
                        View view3 = eVar2.a.itemView;
                        Intrinsics.checkNotNullExpressionValue(view3, "item.itemView");
                        view3.setTranslationX(0.0f);
                        view3.setTranslationY(0.0f);
                        dispatchMoveFinished(eVar2.a);
                        list.remove(size6);
                        if (list.isEmpty()) {
                            this.m.remove(list);
                        }
                    }
                }
            }
            int size7 = this.l.size();
            while (true) {
                size7--;
                if (size7 < 0) {
                    break;
                }
                List<RecyclerView.ViewHolder> list2 = this.l.get(size7);
                int size8 = list2.size();
                while (true) {
                    size8--;
                    if (size8 >= 0) {
                        RecyclerView.ViewHolder viewHolder2 = list2.get(size8);
                        View view4 = viewHolder2.itemView;
                        Intrinsics.checkNotNullExpressionValue(view4, "item.itemView");
                        view4.setAlpha(1.0f);
                        dispatchAddFinished(viewHolder2);
                        if (size8 < list2.size()) {
                            list2.remove(size8);
                        }
                        if (list2.isEmpty()) {
                            this.l.remove(list2);
                        }
                    }
                }
            }
            int size9 = this.n.size();
            while (true) {
                size9--;
                if (size9 >= 0) {
                    List<b> list3 = this.n.get(size9);
                    int size10 = list3.size();
                    while (true) {
                        size10--;
                        if (size10 >= 0) {
                            b bVar2 = list3.get(size10);
                            d(bVar2, bVar2.e);
                            d(bVar2, bVar2.f);
                            if (list3.isEmpty()) {
                                this.n.remove(list3);
                            }
                        }
                    }
                } else {
                    b(this.q);
                    b(this.p);
                    b(this.o);
                    b(this.r);
                    dispatchAnimationsFinished();
                    return;
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public boolean isRunning() {
        return !this.i.isEmpty() || !this.k.isEmpty() || !this.j.isEmpty() || !this.h.isEmpty() || !this.p.isEmpty() || !this.q.isEmpty() || !this.o.isEmpty() || !this.r.isEmpty() || !this.m.isEmpty() || !this.l.isEmpty() || !this.n.isEmpty();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public void runPendingAnimations() {
        boolean z = !this.h.isEmpty();
        boolean z2 = !this.j.isEmpty();
        boolean z3 = !this.k.isEmpty();
        boolean z4 = !this.i.isEmpty();
        if (z || z2 || z4 || z3) {
            for (RecyclerView.ViewHolder viewHolder : this.h) {
                ViewCompat.animate(viewHolder.itemView).alpha(0.0f).setDuration(getRemoveDuration()).setInterpolator(this.s).setListener(new d(this, viewHolder)).start();
                this.q.add(viewHolder);
            }
            this.h.clear();
            if (z2) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(this.j);
                this.m.add(arrayList);
                this.j.clear();
                a aVar = new a(2, this, arrayList);
                if (z) {
                    View view = ((e) arrayList.get(0)).a.itemView;
                    Intrinsics.checkNotNullExpressionValue(view, "moves[0].holder.itemView");
                    ViewCompat.postOnAnimationDelayed(view, aVar, getRemoveDuration());
                } else {
                    aVar.run();
                }
            }
            if (z3) {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.addAll(this.k);
                this.n.add(arrayList2);
                this.k.clear();
                a aVar2 = new a(1, this, arrayList2);
                if (z) {
                    RecyclerView.ViewHolder viewHolder2 = ((b) arrayList2.get(0)).e;
                    Intrinsics.checkNotNull(viewHolder2);
                    ViewCompat.postOnAnimationDelayed(viewHolder2.itemView, aVar2, getRemoveDuration());
                } else {
                    aVar2.run();
                }
            }
            if (z4) {
                ArrayList arrayList3 = new ArrayList();
                arrayList3.addAll(this.i);
                this.l.add(arrayList3);
                this.i.clear();
                a aVar3 = new a(0, this, arrayList3);
                if (z || z2 || z3) {
                    long j2 = 0;
                    long removeDuration = z ? getRemoveDuration() : 0;
                    long moveDuration = z2 ? getMoveDuration() : 0;
                    if (z3) {
                        j2 = getChangeDuration();
                    }
                    View view2 = ((RecyclerView.ViewHolder) arrayList3.get(0)).itemView;
                    Intrinsics.checkNotNullExpressionValue(view2, "additions[0].itemView");
                    ViewCompat.postOnAnimationDelayed(view2, aVar3, Math.max(moveDuration, j2) + removeDuration);
                    return;
                }
                aVar3.run();
            }
        }
    }
}
