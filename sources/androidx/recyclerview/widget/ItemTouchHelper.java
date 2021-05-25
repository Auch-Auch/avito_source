package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.Interpolator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.GestureDetectorCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.R;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import l6.v.a.j;
import l6.v.a.k;
public class ItemTouchHelper extends RecyclerView.ItemDecoration implements RecyclerView.OnChildAttachStateChangeListener {
    public static final int ACTION_STATE_DRAG = 2;
    public static final int ACTION_STATE_IDLE = 0;
    public static final int ACTION_STATE_SWIPE = 1;
    public static final int ANIMATION_TYPE_DRAG = 8;
    public static final int ANIMATION_TYPE_SWIPE_CANCEL = 4;
    public static final int ANIMATION_TYPE_SWIPE_SUCCESS = 2;
    public static final int DOWN = 2;
    public static final int END = 32;
    public static final int LEFT = 4;
    public static final int RIGHT = 8;
    public static final int START = 16;
    public static final int UP = 1;
    public final RecyclerView.OnItemTouchListener A = new b();
    public Rect B;
    public long C;
    public final List<View> a = new ArrayList();
    public final float[] b = new float[2];
    public RecyclerView.ViewHolder c = null;
    public float d;
    public float e;
    public float f;
    public float g;
    public float h;
    public float i;
    public float j;
    public float k;
    public int l = -1;
    @NonNull
    public Callback m;
    public int n = 0;
    public int o;
    public List<e> p = new ArrayList();
    public int q;
    public RecyclerView r;
    public final Runnable s = new a();
    public VelocityTracker t;
    public List<RecyclerView.ViewHolder> u;
    public List<Integer> v;
    public View w = null;
    public int x = -1;
    public GestureDetectorCompat y;
    public d z;

    public static abstract class Callback {
        public static final int DEFAULT_DRAG_ANIMATION_DURATION = 200;
        public static final int DEFAULT_SWIPE_ANIMATION_DURATION = 250;
        public static final Interpolator b = new a();
        public static final Interpolator c = new b();
        public int a = -1;

        public static class a implements Interpolator {
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f) {
                return f * f * f * f * f;
            }
        }

        public static class b implements Interpolator {
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f) {
                float f2 = f - 1.0f;
                return (f2 * f2 * f2 * f2 * f2) + 1.0f;
            }
        }

        public static int convertToRelativeDirection(int i, int i2) {
            int i3;
            int i4 = i & 789516;
            if (i4 == 0) {
                return i;
            }
            int i5 = i & (~i4);
            if (i2 == 0) {
                i3 = i4 << 2;
            } else {
                int i6 = i4 << 1;
                i5 |= -789517 & i6;
                i3 = (i6 & 789516) << 2;
            }
            return i5 | i3;
        }

        @NonNull
        public static ItemTouchUIUtil getDefaultUIUtil() {
            return k.a;
        }

        public static int makeFlag(int i, int i2) {
            return i2 << (i * 8);
        }

        public static int makeMovementFlags(int i, int i2) {
            int makeFlag = makeFlag(0, i2 | i);
            return makeFlag(2, i) | makeFlag(1, i2) | makeFlag;
        }

        public final int a(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            return convertToAbsoluteDirection(getMovementFlags(recyclerView, viewHolder), ViewCompat.getLayoutDirection(recyclerView));
        }

        public boolean b(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            return (convertToAbsoluteDirection(getMovementFlags(recyclerView, viewHolder), ViewCompat.getLayoutDirection(recyclerView)) & 16711680) != 0;
        }

        public boolean canDropOver(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder2) {
            return true;
        }

        public RecyclerView.ViewHolder chooseDropTarget(@NonNull RecyclerView.ViewHolder viewHolder, @NonNull List<RecyclerView.ViewHolder> list, int i, int i2) {
            int bottom;
            int abs;
            int top;
            int abs2;
            int left;
            int abs3;
            int right;
            int abs4;
            int width = viewHolder.itemView.getWidth() + i;
            int height = viewHolder.itemView.getHeight() + i2;
            int left2 = i - viewHolder.itemView.getLeft();
            int top2 = i2 - viewHolder.itemView.getTop();
            int size = list.size();
            RecyclerView.ViewHolder viewHolder2 = null;
            int i3 = -1;
            for (int i4 = 0; i4 < size; i4++) {
                RecyclerView.ViewHolder viewHolder3 = list.get(i4);
                if (left2 > 0 && (right = viewHolder3.itemView.getRight() - width) < 0 && viewHolder3.itemView.getRight() > viewHolder.itemView.getRight() && (abs4 = Math.abs(right)) > i3) {
                    viewHolder2 = viewHolder3;
                    i3 = abs4;
                }
                if (left2 < 0 && (left = viewHolder3.itemView.getLeft() - i) > 0 && viewHolder3.itemView.getLeft() < viewHolder.itemView.getLeft() && (abs3 = Math.abs(left)) > i3) {
                    viewHolder2 = viewHolder3;
                    i3 = abs3;
                }
                if (top2 < 0 && (top = viewHolder3.itemView.getTop() - i2) > 0 && viewHolder3.itemView.getTop() < viewHolder.itemView.getTop() && (abs2 = Math.abs(top)) > i3) {
                    viewHolder2 = viewHolder3;
                    i3 = abs2;
                }
                if (top2 > 0 && (bottom = viewHolder3.itemView.getBottom() - height) < 0 && viewHolder3.itemView.getBottom() > viewHolder.itemView.getBottom() && (abs = Math.abs(bottom)) > i3) {
                    viewHolder2 = viewHolder3;
                    i3 = abs;
                }
            }
            return viewHolder2;
        }

        public void clearView(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
            View view = viewHolder.itemView;
            int i = R.id.item_touch_helper_previous_elevation;
            Object tag = view.getTag(i);
            if (tag instanceof Float) {
                ViewCompat.setElevation(view, ((Float) tag).floatValue());
            }
            view.setTag(i, null);
            view.setTranslationX(0.0f);
            view.setTranslationY(0.0f);
        }

        public int convertToAbsoluteDirection(int i, int i2) {
            int i3;
            int i4 = i & 3158064;
            if (i4 == 0) {
                return i;
            }
            int i5 = i & (~i4);
            if (i2 == 0) {
                i3 = i4 >> 2;
            } else {
                int i6 = i4 >> 1;
                i5 |= -3158065 & i6;
                i3 = (i6 & 3158064) >> 2;
            }
            return i5 | i3;
        }

        public long getAnimationDuration(@NonNull RecyclerView recyclerView, int i, float f, float f2) {
            RecyclerView.ItemAnimator itemAnimator = recyclerView.getItemAnimator();
            if (itemAnimator == null) {
                return i == 8 ? 200 : 250;
            }
            if (i == 8) {
                return itemAnimator.getMoveDuration();
            }
            return itemAnimator.getRemoveDuration();
        }

        public int getBoundingBoxMargin() {
            return 0;
        }

        public float getMoveThreshold(@NonNull RecyclerView.ViewHolder viewHolder) {
            return 0.5f;
        }

        public abstract int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder);

        public float getSwipeEscapeVelocity(float f) {
            return f;
        }

        public float getSwipeThreshold(@NonNull RecyclerView.ViewHolder viewHolder) {
            return 0.5f;
        }

        public float getSwipeVelocityThreshold(float f) {
            return f;
        }

        public int interpolateOutOfBoundsScroll(@NonNull RecyclerView recyclerView, int i, int i2, int i3, long j) {
            if (this.a == -1) {
                this.a = recyclerView.getResources().getDimensionPixelSize(R.dimen.item_touch_helper_max_drag_scroll_per_frame);
            }
            int i4 = this.a;
            float f = 1.0f;
            float min = Math.min(1.0f, (((float) Math.abs(i2)) * 1.0f) / ((float) i)) - 1.0f;
            int signum = (int) (((float) (((int) Math.signum((float) i2)) * i4)) * ((min * min * min * min * min) + 1.0f));
            if (j <= 2000) {
                f = ((float) j) / 2000.0f;
            }
            int i5 = (int) (((float) signum) * f * f * f * f * f);
            if (i5 != 0) {
                return i5;
            }
            if (i2 > 0) {
                return 1;
            }
            return -1;
        }

        public boolean isItemViewSwipeEnabled() {
            return true;
        }

        public boolean isLongPressDragEnabled() {
            return true;
        }

        public void onChildDraw(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, float f, float f2, int i, boolean z) {
            View view = viewHolder.itemView;
            if (z && view.getTag(R.id.item_touch_helper_previous_elevation) == null) {
                Float valueOf = Float.valueOf(ViewCompat.getElevation(view));
                int childCount = recyclerView.getChildCount();
                float f3 = 0.0f;
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = recyclerView.getChildAt(i2);
                    if (childAt != view) {
                        float elevation = ViewCompat.getElevation(childAt);
                        if (elevation > f3) {
                            f3 = elevation;
                        }
                    }
                }
                ViewCompat.setElevation(view, f3 + 1.0f);
                view.setTag(R.id.item_touch_helper_previous_elevation, valueOf);
            }
            view.setTranslationX(f);
            view.setTranslationY(f2);
        }

        public void onChildDrawOver(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float f, float f2, int i, boolean z) {
            View view = viewHolder.itemView;
        }

        public abstract boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder2);

        public void onMoved(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, int i, @NonNull RecyclerView.ViewHolder viewHolder2, int i2, int i3, int i4) {
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof ViewDropHandler) {
                ((ViewDropHandler) layoutManager).prepareForDrop(viewHolder.itemView, viewHolder2.itemView, i3, i4);
                return;
            }
            if (layoutManager.canScrollHorizontally()) {
                if (layoutManager.getDecoratedLeft(viewHolder2.itemView) <= recyclerView.getPaddingLeft()) {
                    recyclerView.scrollToPosition(i2);
                }
                if (layoutManager.getDecoratedRight(viewHolder2.itemView) >= recyclerView.getWidth() - recyclerView.getPaddingRight()) {
                    recyclerView.scrollToPosition(i2);
                }
            }
            if (layoutManager.canScrollVertically()) {
                if (layoutManager.getDecoratedTop(viewHolder2.itemView) <= recyclerView.getPaddingTop()) {
                    recyclerView.scrollToPosition(i2);
                }
                if (layoutManager.getDecoratedBottom(viewHolder2.itemView) >= recyclerView.getHeight() - recyclerView.getPaddingBottom()) {
                    recyclerView.scrollToPosition(i2);
                }
            }
        }

        public void onSelectedChanged(@Nullable RecyclerView.ViewHolder viewHolder, int i) {
        }

        public abstract void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i);
    }

    public static abstract class SimpleCallback extends Callback {
        public int d;
        public int e;

        public SimpleCallback(int i, int i2) {
            this.d = i2;
            this.e = i;
        }

        public int getDragDirs(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
            return this.e;
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
            return Callback.makeMovementFlags(getDragDirs(recyclerView, viewHolder), getSwipeDirs(recyclerView, viewHolder));
        }

        public int getSwipeDirs(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
            return this.d;
        }

        public void setDefaultDragDirs(int i) {
            this.e = i;
        }

        public void setDefaultSwipeDirs(int i) {
            this.d = i;
        }
    }

    public interface ViewDropHandler {
        void prepareForDrop(@NonNull View view, @NonNull View view2, int i, int i2);
    }

    public class a implements Runnable {
        public a() {
        }

        /* JADX WARNING: Removed duplicated region for block: B:25:0x0088  */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x00cb  */
        /* JADX WARNING: Removed duplicated region for block: B:38:0x00e5  */
        /* JADX WARNING: Removed duplicated region for block: B:39:0x0101  */
        /* JADX WARNING: Removed duplicated region for block: B:41:0x0104 A[ADDED_TO_REGION] */
        /* JADX WARNING: Removed duplicated region for block: B:45:0x0110  */
        @Override // java.lang.Runnable
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
            // Method dump skipped, instructions count: 308
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.ItemTouchHelper.a.run():void");
        }
    }

    public class b implements RecyclerView.OnItemTouchListener {
        public b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public boolean onInterceptTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
            int findPointerIndex;
            ItemTouchHelper.this.y.onTouchEvent(motionEvent);
            int actionMasked = motionEvent.getActionMasked();
            e eVar = null;
            if (actionMasked == 0) {
                ItemTouchHelper.this.l = motionEvent.getPointerId(0);
                ItemTouchHelper.this.d = motionEvent.getX();
                ItemTouchHelper.this.e = motionEvent.getY();
                ItemTouchHelper.this.i();
                ItemTouchHelper itemTouchHelper = ItemTouchHelper.this;
                if (itemTouchHelper.c == null) {
                    if (!itemTouchHelper.p.isEmpty()) {
                        View e = itemTouchHelper.e(motionEvent);
                        int size = itemTouchHelper.p.size() - 1;
                        while (true) {
                            if (size < 0) {
                                break;
                            }
                            e eVar2 = itemTouchHelper.p.get(size);
                            if (eVar2.e.itemView == e) {
                                eVar = eVar2;
                                break;
                            }
                            size--;
                        }
                    }
                    if (eVar != null) {
                        ItemTouchHelper itemTouchHelper2 = ItemTouchHelper.this;
                        itemTouchHelper2.d -= eVar.i;
                        itemTouchHelper2.e -= eVar.j;
                        itemTouchHelper2.d(eVar.e, true);
                        if (ItemTouchHelper.this.a.remove(eVar.e.itemView)) {
                            ItemTouchHelper itemTouchHelper3 = ItemTouchHelper.this;
                            itemTouchHelper3.m.clearView(itemTouchHelper3.r, eVar.e);
                        }
                        ItemTouchHelper.this.k(eVar.e, eVar.f);
                        ItemTouchHelper itemTouchHelper4 = ItemTouchHelper.this;
                        itemTouchHelper4.l(motionEvent, itemTouchHelper4.o, 0);
                    }
                }
            } else if (actionMasked == 3 || actionMasked == 1) {
                ItemTouchHelper itemTouchHelper5 = ItemTouchHelper.this;
                itemTouchHelper5.l = -1;
                itemTouchHelper5.k(null, 0);
            } else {
                int i = ItemTouchHelper.this.l;
                if (i != -1 && (findPointerIndex = motionEvent.findPointerIndex(i)) >= 0) {
                    ItemTouchHelper.this.b(actionMasked, motionEvent, findPointerIndex);
                }
            }
            VelocityTracker velocityTracker = ItemTouchHelper.this.t;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
            }
            if (ItemTouchHelper.this.c != null) {
                return true;
            }
            return false;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onRequestDisallowInterceptTouchEvent(boolean z) {
            if (z) {
                ItemTouchHelper.this.k(null, 0);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
            ItemTouchHelper.this.y.onTouchEvent(motionEvent);
            VelocityTracker velocityTracker = ItemTouchHelper.this.t;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
            }
            if (ItemTouchHelper.this.l != -1) {
                int actionMasked = motionEvent.getActionMasked();
                int findPointerIndex = motionEvent.findPointerIndex(ItemTouchHelper.this.l);
                if (findPointerIndex >= 0) {
                    ItemTouchHelper.this.b(actionMasked, motionEvent, findPointerIndex);
                }
                ItemTouchHelper itemTouchHelper = ItemTouchHelper.this;
                RecyclerView.ViewHolder viewHolder = itemTouchHelper.c;
                if (viewHolder != null) {
                    int i = 0;
                    if (actionMasked != 1) {
                        if (actionMasked != 2) {
                            if (actionMasked == 3) {
                                VelocityTracker velocityTracker2 = itemTouchHelper.t;
                                if (velocityTracker2 != null) {
                                    velocityTracker2.clear();
                                }
                            } else if (actionMasked == 6) {
                                int actionIndex = motionEvent.getActionIndex();
                                int pointerId = motionEvent.getPointerId(actionIndex);
                                ItemTouchHelper itemTouchHelper2 = ItemTouchHelper.this;
                                if (pointerId == itemTouchHelper2.l) {
                                    if (actionIndex == 0) {
                                        i = 1;
                                    }
                                    itemTouchHelper2.l = motionEvent.getPointerId(i);
                                    ItemTouchHelper itemTouchHelper3 = ItemTouchHelper.this;
                                    itemTouchHelper3.l(motionEvent, itemTouchHelper3.o, actionIndex);
                                    return;
                                }
                                return;
                            } else {
                                return;
                            }
                        } else if (findPointerIndex >= 0) {
                            itemTouchHelper.l(motionEvent, itemTouchHelper.o, findPointerIndex);
                            ItemTouchHelper.this.h(viewHolder);
                            ItemTouchHelper itemTouchHelper4 = ItemTouchHelper.this;
                            itemTouchHelper4.r.removeCallbacks(itemTouchHelper4.s);
                            ItemTouchHelper.this.s.run();
                            ItemTouchHelper.this.r.invalidate();
                            return;
                        } else {
                            return;
                        }
                    }
                    ItemTouchHelper.this.k(null, 0);
                    ItemTouchHelper.this.l = -1;
                }
            }
        }
    }

    public class c extends e {
        public final /* synthetic */ int n;
        public final /* synthetic */ RecyclerView.ViewHolder o;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(RecyclerView.ViewHolder viewHolder, int i, int i2, float f, float f2, float f3, float f4, int i3, RecyclerView.ViewHolder viewHolder2) {
            super(viewHolder, i, i2, f, f2, f3, f4);
            this.n = i3;
            this.o = viewHolder2;
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.e, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (!this.l) {
                this.e.setIsRecyclable(true);
            }
            this.l = true;
            if (!this.k) {
                if (this.n <= 0) {
                    ItemTouchHelper itemTouchHelper = ItemTouchHelper.this;
                    itemTouchHelper.m.clearView(itemTouchHelper.r, this.o);
                } else {
                    ItemTouchHelper.this.a.add(this.o.itemView);
                    this.h = true;
                    int i = this.n;
                    if (i > 0) {
                        ItemTouchHelper itemTouchHelper2 = ItemTouchHelper.this;
                        itemTouchHelper2.r.post(new j(itemTouchHelper2, this, i));
                    }
                }
                ItemTouchHelper itemTouchHelper3 = ItemTouchHelper.this;
                View view = itemTouchHelper3.w;
                View view2 = this.o.itemView;
                if (view == view2) {
                    itemTouchHelper3.j(view2);
                }
            }
        }
    }

    public class d extends GestureDetector.SimpleOnGestureListener {
        public boolean a = true;

        public d() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            View e;
            RecyclerView.ViewHolder childViewHolder;
            int i;
            if (this.a && (e = ItemTouchHelper.this.e(motionEvent)) != null && (childViewHolder = ItemTouchHelper.this.r.getChildViewHolder(e)) != null) {
                ItemTouchHelper itemTouchHelper = ItemTouchHelper.this;
                if (itemTouchHelper.m.b(itemTouchHelper.r, childViewHolder) && motionEvent.getPointerId(0) == (i = ItemTouchHelper.this.l)) {
                    int findPointerIndex = motionEvent.findPointerIndex(i);
                    float x = motionEvent.getX(findPointerIndex);
                    float y = motionEvent.getY(findPointerIndex);
                    ItemTouchHelper itemTouchHelper2 = ItemTouchHelper.this;
                    itemTouchHelper2.d = x;
                    itemTouchHelper2.e = y;
                    itemTouchHelper2.i = 0.0f;
                    itemTouchHelper2.h = 0.0f;
                    if (itemTouchHelper2.m.isLongPressDragEnabled()) {
                        ItemTouchHelper.this.k(childViewHolder, 2);
                    }
                }
            }
        }
    }

    public static class e implements Animator.AnimatorListener {
        public final float a;
        public final float b;
        public final float c;
        public final float d;
        public final RecyclerView.ViewHolder e;
        public final int f;
        public final ValueAnimator g;
        public boolean h;
        public float i;
        public float j;
        public boolean k = false;
        public boolean l = false;
        public float m;

        public class a implements ValueAnimator.AnimatorUpdateListener {
            public a() {
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                e.this.m = valueAnimator.getAnimatedFraction();
            }
        }

        public e(RecyclerView.ViewHolder viewHolder, int i2, int i3, float f2, float f3, float f4, float f5) {
            this.f = i3;
            this.e = viewHolder;
            this.a = f2;
            this.b = f3;
            this.c = f4;
            this.d = f5;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.g = ofFloat;
            ofFloat.addUpdateListener(new a());
            ofFloat.setTarget(viewHolder.itemView);
            ofFloat.addListener(this);
            this.m = 0.0f;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.m = 1.0f;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (!this.l) {
                this.e.setIsRecyclable(true);
            }
            this.l = true;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    public ItemTouchHelper(@NonNull Callback callback) {
        this.m = callback;
    }

    public static boolean g(View view, float f2, float f3, float f4, float f5) {
        return f2 >= f4 && f2 <= f4 + ((float) view.getWidth()) && f3 >= f5 && f3 <= f5 + ((float) view.getHeight());
    }

    public final int a(RecyclerView.ViewHolder viewHolder, int i2) {
        if ((i2 & 12) == 0) {
            return 0;
        }
        int i3 = 8;
        int i4 = this.h > 0.0f ? 8 : 4;
        VelocityTracker velocityTracker = this.t;
        if (velocityTracker != null && this.l > -1) {
            velocityTracker.computeCurrentVelocity(1000, this.m.getSwipeVelocityThreshold(this.g));
            float xVelocity = this.t.getXVelocity(this.l);
            float yVelocity = this.t.getYVelocity(this.l);
            if (xVelocity <= 0.0f) {
                i3 = 4;
            }
            float abs = Math.abs(xVelocity);
            if ((i3 & i2) != 0 && i4 == i3 && abs >= this.m.getSwipeEscapeVelocity(this.f) && abs > Math.abs(yVelocity)) {
                return i3;
            }
        }
        float swipeThreshold = this.m.getSwipeThreshold(viewHolder) * ((float) this.r.getWidth());
        if ((i2 & i4) == 0 || Math.abs(this.h) <= swipeThreshold) {
            return 0;
        }
        return i4;
    }

    public void attachToRecyclerView(@Nullable RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.r;
        if (recyclerView2 != recyclerView) {
            if (recyclerView2 != null) {
                recyclerView2.removeItemDecoration(this);
                this.r.removeOnItemTouchListener(this.A);
                this.r.removeOnChildAttachStateChangeListener(this);
                for (int size = this.p.size() - 1; size >= 0; size--) {
                    this.m.clearView(this.r, this.p.get(0).e);
                }
                this.p.clear();
                this.w = null;
                this.x = -1;
                VelocityTracker velocityTracker = this.t;
                if (velocityTracker != null) {
                    velocityTracker.recycle();
                    this.t = null;
                }
                d dVar = this.z;
                if (dVar != null) {
                    dVar.a = false;
                    this.z = null;
                }
                if (this.y != null) {
                    this.y = null;
                }
            }
            this.r = recyclerView;
            if (recyclerView != null) {
                Resources resources = recyclerView.getResources();
                this.f = resources.getDimension(R.dimen.item_touch_helper_swipe_escape_velocity);
                this.g = resources.getDimension(R.dimen.item_touch_helper_swipe_escape_max_velocity);
                this.q = ViewConfiguration.get(this.r.getContext()).getScaledTouchSlop();
                this.r.addItemDecoration(this);
                this.r.addOnItemTouchListener(this.A);
                this.r.addOnChildAttachStateChangeListener(this);
                this.z = new d();
                this.y = new GestureDetectorCompat(this.r.getContext(), this.z);
            }
        }
    }

    public void b(int i2, MotionEvent motionEvent, int i3) {
        int a3;
        View e2;
        if (this.c == null && i2 == 2 && this.n != 2 && this.m.isItemViewSwipeEnabled() && this.r.getScrollState() != 1) {
            RecyclerView.LayoutManager layoutManager = this.r.getLayoutManager();
            int i4 = this.l;
            RecyclerView.ViewHolder viewHolder = null;
            if (i4 != -1) {
                int findPointerIndex = motionEvent.findPointerIndex(i4);
                float abs = Math.abs(motionEvent.getX(findPointerIndex) - this.d);
                float abs2 = Math.abs(motionEvent.getY(findPointerIndex) - this.e);
                float f2 = (float) this.q;
                if ((abs >= f2 || abs2 >= f2) && ((abs <= abs2 || !layoutManager.canScrollHorizontally()) && ((abs2 <= abs || !layoutManager.canScrollVertically()) && (e2 = e(motionEvent)) != null))) {
                    viewHolder = this.r.getChildViewHolder(e2);
                }
            }
            if (viewHolder != null && (a3 = (this.m.a(this.r, viewHolder) & 65280) >> 8) != 0) {
                float x2 = motionEvent.getX(i3);
                float y2 = motionEvent.getY(i3);
                float f3 = x2 - this.d;
                float f4 = y2 - this.e;
                float abs3 = Math.abs(f3);
                float abs4 = Math.abs(f4);
                float f5 = (float) this.q;
                if (abs3 >= f5 || abs4 >= f5) {
                    if (abs3 > abs4) {
                        if (f3 < 0.0f && (a3 & 4) == 0) {
                            return;
                        }
                        if (f3 > 0.0f && (a3 & 8) == 0) {
                            return;
                        }
                    } else if (f4 < 0.0f && (a3 & 1) == 0) {
                        return;
                    } else {
                        if (f4 > 0.0f && (a3 & 2) == 0) {
                            return;
                        }
                    }
                    this.i = 0.0f;
                    this.h = 0.0f;
                    this.l = motionEvent.getPointerId(0);
                    k(viewHolder, 1);
                }
            }
        }
    }

    public final int c(RecyclerView.ViewHolder viewHolder, int i2) {
        if ((i2 & 3) == 0) {
            return 0;
        }
        int i3 = 2;
        int i4 = this.i > 0.0f ? 2 : 1;
        VelocityTracker velocityTracker = this.t;
        if (velocityTracker != null && this.l > -1) {
            velocityTracker.computeCurrentVelocity(1000, this.m.getSwipeVelocityThreshold(this.g));
            float xVelocity = this.t.getXVelocity(this.l);
            float yVelocity = this.t.getYVelocity(this.l);
            if (yVelocity <= 0.0f) {
                i3 = 1;
            }
            float abs = Math.abs(yVelocity);
            if ((i3 & i2) != 0 && i3 == i4 && abs >= this.m.getSwipeEscapeVelocity(this.f) && abs > Math.abs(xVelocity)) {
                return i3;
            }
        }
        float swipeThreshold = this.m.getSwipeThreshold(viewHolder) * ((float) this.r.getHeight());
        if ((i2 & i4) == 0 || Math.abs(this.i) <= swipeThreshold) {
            return 0;
        }
        return i4;
    }

    public void d(RecyclerView.ViewHolder viewHolder, boolean z2) {
        for (int size = this.p.size() - 1; size >= 0; size--) {
            e eVar = this.p.get(size);
            if (eVar.e == viewHolder) {
                eVar.k |= z2;
                if (!eVar.l) {
                    eVar.g.cancel();
                }
                this.p.remove(size);
                return;
            }
        }
    }

    public View e(MotionEvent motionEvent) {
        float x2 = motionEvent.getX();
        float y2 = motionEvent.getY();
        RecyclerView.ViewHolder viewHolder = this.c;
        if (viewHolder != null) {
            View view = viewHolder.itemView;
            if (g(view, x2, y2, this.j + this.h, this.k + this.i)) {
                return view;
            }
        }
        for (int size = this.p.size() - 1; size >= 0; size--) {
            e eVar = this.p.get(size);
            View view2 = eVar.e.itemView;
            if (g(view2, x2, y2, eVar.i, eVar.j)) {
                return view2;
            }
        }
        return this.r.findChildViewUnder(x2, y2);
    }

    public final void f(float[] fArr) {
        if ((this.o & 12) != 0) {
            fArr[0] = (this.j + this.h) - ((float) this.c.itemView.getLeft());
        } else {
            fArr[0] = this.c.itemView.getTranslationX();
        }
        if ((this.o & 3) != 0) {
            fArr[1] = (this.k + this.i) - ((float) this.c.itemView.getTop());
        } else {
            fArr[1] = this.c.itemView.getTranslationY();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        rect.setEmpty();
    }

    public void h(RecyclerView.ViewHolder viewHolder) {
        int i2;
        int i3;
        int i4;
        if (!this.r.isLayoutRequested() && this.n == 2) {
            float moveThreshold = this.m.getMoveThreshold(viewHolder);
            int i5 = (int) (this.j + this.h);
            int i6 = (int) (this.k + this.i);
            if (((float) Math.abs(i6 - viewHolder.itemView.getTop())) >= ((float) viewHolder.itemView.getHeight()) * moveThreshold || ((float) Math.abs(i5 - viewHolder.itemView.getLeft())) >= ((float) viewHolder.itemView.getWidth()) * moveThreshold) {
                List<RecyclerView.ViewHolder> list = this.u;
                if (list == null) {
                    this.u = new ArrayList();
                    this.v = new ArrayList();
                } else {
                    list.clear();
                    this.v.clear();
                }
                int boundingBoxMargin = this.m.getBoundingBoxMargin();
                int round = Math.round(this.j + this.h) - boundingBoxMargin;
                int round2 = Math.round(this.k + this.i) - boundingBoxMargin;
                int i7 = boundingBoxMargin * 2;
                int width = viewHolder.itemView.getWidth() + round + i7;
                int height = viewHolder.itemView.getHeight() + round2 + i7;
                int i8 = (round + width) / 2;
                int i9 = (round2 + height) / 2;
                RecyclerView.LayoutManager layoutManager = this.r.getLayoutManager();
                int childCount = layoutManager.getChildCount();
                int i10 = 0;
                while (i10 < childCount) {
                    View childAt = layoutManager.getChildAt(i10);
                    if (childAt != viewHolder.itemView && childAt.getBottom() >= round2 && childAt.getTop() <= height && childAt.getRight() >= round && childAt.getLeft() <= width) {
                        RecyclerView.ViewHolder childViewHolder = this.r.getChildViewHolder(childAt);
                        i4 = round;
                        i3 = round2;
                        if (this.m.canDropOver(this.r, this.c, childViewHolder)) {
                            int abs = Math.abs(i8 - ((childAt.getRight() + childAt.getLeft()) / 2));
                            int abs2 = Math.abs(i9 - ((childAt.getBottom() + childAt.getTop()) / 2));
                            int i11 = (abs2 * abs2) + (abs * abs);
                            int size = this.u.size();
                            int i12 = 0;
                            int i13 = 0;
                            while (true) {
                                i2 = i8;
                                if (i13 >= size || i11 <= this.v.get(i13).intValue()) {
                                    break;
                                }
                                i12++;
                                i13++;
                                i8 = i2;
                            }
                            this.u.add(i12, childViewHolder);
                            this.v.add(i12, Integer.valueOf(i11));
                        } else {
                            i2 = i8;
                        }
                    } else {
                        i2 = i8;
                        i4 = round;
                        i3 = round2;
                    }
                    i10++;
                    round = i4;
                    round2 = i3;
                    i8 = i2;
                }
                List<RecyclerView.ViewHolder> list2 = this.u;
                if (list2.size() != 0) {
                    RecyclerView.ViewHolder chooseDropTarget = this.m.chooseDropTarget(viewHolder, list2, i5, i6);
                    if (chooseDropTarget == null) {
                        this.u.clear();
                        this.v.clear();
                        return;
                    }
                    int adapterPosition = chooseDropTarget.getAdapterPosition();
                    int adapterPosition2 = viewHolder.getAdapterPosition();
                    if (this.m.onMove(this.r, viewHolder, chooseDropTarget)) {
                        this.m.onMoved(this.r, viewHolder, adapterPosition2, chooseDropTarget, adapterPosition, i5, i6);
                    }
                }
            }
        }
    }

    public void i() {
        VelocityTracker velocityTracker = this.t;
        if (velocityTracker != null) {
            velocityTracker.recycle();
        }
        this.t = VelocityTracker.obtain();
    }

    public void j(View view) {
        if (view == this.w) {
            this.w = null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0094, code lost:
        if (r2 > 0) goto L_0x00b3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void k(@androidx.annotation.Nullable androidx.recyclerview.widget.RecyclerView.ViewHolder r24, int r25) {
        /*
        // Method dump skipped, instructions count: 454
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.ItemTouchHelper.k(androidx.recyclerview.widget.RecyclerView$ViewHolder, int):void");
    }

    public void l(MotionEvent motionEvent, int i2, int i3) {
        float x2 = motionEvent.getX(i3);
        float y2 = motionEvent.getY(i3);
        float f2 = x2 - this.d;
        this.h = f2;
        this.i = y2 - this.e;
        if ((i2 & 4) == 0) {
            this.h = Math.max(0.0f, f2);
        }
        if ((i2 & 8) == 0) {
            this.h = Math.min(0.0f, this.h);
        }
        if ((i2 & 1) == 0) {
            this.i = Math.max(0.0f, this.i);
        }
        if ((i2 & 2) == 0) {
            this.i = Math.min(0.0f, this.i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
    public void onChildViewAttachedToWindow(@NonNull View view) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
    public void onChildViewDetachedFromWindow(@NonNull View view) {
        j(view);
        RecyclerView.ViewHolder childViewHolder = this.r.getChildViewHolder(view);
        if (childViewHolder != null) {
            RecyclerView.ViewHolder viewHolder = this.c;
            if (viewHolder == null || childViewHolder != viewHolder) {
                d(childViewHolder, false);
                if (this.a.remove(childViewHolder.itemView)) {
                    this.m.clearView(this.r, childViewHolder);
                    return;
                }
                return;
            }
            k(null, 0);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        float f2;
        float f3;
        this.x = -1;
        if (this.c != null) {
            f(this.b);
            float[] fArr = this.b;
            float f4 = fArr[0];
            f2 = fArr[1];
            f3 = f4;
        } else {
            f3 = 0.0f;
            f2 = 0.0f;
        }
        Callback callback = this.m;
        RecyclerView.ViewHolder viewHolder = this.c;
        List<e> list = this.p;
        int i2 = this.n;
        Objects.requireNonNull(callback);
        int i3 = 0;
        for (int size = list.size(); i3 < size; size = size) {
            e eVar = list.get(i3);
            float f5 = eVar.a;
            float f6 = eVar.c;
            if (f5 == f6) {
                eVar.i = eVar.e.itemView.getTranslationX();
            } else {
                eVar.i = a2.b.a.a.a.b(f6, f5, eVar.m, f5);
            }
            float f7 = eVar.b;
            float f8 = eVar.d;
            if (f7 == f8) {
                eVar.j = eVar.e.itemView.getTranslationY();
            } else {
                eVar.j = a2.b.a.a.a.b(f8, f7, eVar.m, f7);
            }
            int save = canvas.save();
            callback.onChildDraw(canvas, recyclerView, eVar.e, eVar.i, eVar.j, eVar.f, false);
            canvas.restoreToCount(save);
            i3++;
        }
        if (viewHolder != null) {
            int save2 = canvas.save();
            callback.onChildDraw(canvas, recyclerView, viewHolder, f3, f2, i2, true);
            canvas.restoreToCount(save2);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        float f2;
        float f3;
        if (this.c != null) {
            f(this.b);
            float[] fArr = this.b;
            float f4 = fArr[0];
            f2 = fArr[1];
            f3 = f4;
        } else {
            f3 = 0.0f;
            f2 = 0.0f;
        }
        Callback callback = this.m;
        RecyclerView.ViewHolder viewHolder = this.c;
        List<e> list = this.p;
        int i2 = this.n;
        Objects.requireNonNull(callback);
        int size = list.size();
        int i3 = 0;
        while (i3 < size) {
            e eVar = list.get(i3);
            int save = canvas.save();
            callback.onChildDrawOver(canvas, recyclerView, eVar.e, eVar.i, eVar.j, eVar.f, false);
            canvas.restoreToCount(save);
            i3++;
            list = list;
            i2 = i2;
            size = size;
        }
        if (viewHolder != null) {
            int save2 = canvas.save();
            callback.onChildDrawOver(canvas, recyclerView, viewHolder, f3, f2, i2, true);
            canvas.restoreToCount(save2);
        }
        boolean z2 = false;
        for (int i4 = size - 1; i4 >= 0; i4--) {
            e eVar2 = list.get(i4);
            boolean z3 = eVar2.l;
            if (z3 && !eVar2.h) {
                list.remove(i4);
            } else if (!z3) {
                z2 = true;
            }
        }
        if (z2) {
            recyclerView.invalidate();
        }
    }

    public void startDrag(@NonNull RecyclerView.ViewHolder viewHolder) {
        if (this.m.b(this.r, viewHolder) && viewHolder.itemView.getParent() == this.r) {
            i();
            this.i = 0.0f;
            this.h = 0.0f;
            k(viewHolder, 2);
        }
    }

    public void startSwipe(@NonNull RecyclerView.ViewHolder viewHolder) {
        Callback callback = this.m;
        RecyclerView recyclerView = this.r;
        if (((callback.convertToAbsoluteDirection(callback.getMovementFlags(recyclerView, viewHolder), ViewCompat.getLayoutDirection(recyclerView)) & 65280) != 0) && viewHolder.itemView.getParent() == this.r) {
            i();
            this.i = 0.0f;
            this.h = 0.0f;
            k(viewHolder, 1);
        }
    }
}
