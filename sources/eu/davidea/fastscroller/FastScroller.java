package eu.davidea.fastscroller;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.IdRes;
import androidx.annotation.IntRange;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import eu.davidea.flexibleadapter.R;
import eu.davidea.flexibleadapter.utils.Log;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
public class FastScroller extends FrameLayout {
    public static final int AUTOHIDE_ANIMATION_DURATION = 300;
    public static final int BUBBLE_ANIMATION_DURATION = 300;
    public static final int DEFAULT_AUTOHIDE_DELAY_IN_MILLIS = 1000;
    public static final boolean DEFAULT_AUTOHIDE_ENABLED = true;
    public static final int TRACK_SNAP_RANGE = 5;
    public long autoHideDelayInMillis;
    public boolean autoHideEnabled;
    public View bar;
    public TextView bubble;
    public int bubbleAndHandleColor;
    public BubbleAnimator bubbleAnimator;
    public boolean bubbleEnabled;
    public int bubblePosition;
    public BubbleTextCreator bubbleTextCreator;
    public ImageView handle;
    public int height;
    public boolean ignoreTouchesOutsideHandle;
    public boolean isInitialized;
    public RecyclerView.LayoutManager layoutManager;
    public int minimumScrollThreshold;
    public RecyclerView.OnScrollListener onScrollListener;
    public RecyclerView recyclerView;
    public List<OnScrollStateChangeListener> scrollStateChangeListeners;
    public ScrollbarAnimator scrollbarAnimator;
    public int width;

    public interface AdapterInterface {
        void setFastScroller(@NonNull FastScroller fastScroller);
    }

    public interface BubbleTextCreator {
        String onCreateBubbleText(int i);
    }

    public static class Delegate {
        public RecyclerView a;
        public FastScroller b;

        public FastScroller getFastScroller() {
            return this.b;
        }

        public boolean isFastScrollerEnabled() {
            FastScroller fastScroller = this.b;
            return fastScroller != null && fastScroller.isEnabled();
        }

        public void onAttachedToRecyclerView(RecyclerView recyclerView) {
            this.a = recyclerView;
        }

        public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
            this.a = null;
        }

        public void setFastScroller(@NonNull FastScroller fastScroller) {
            RecyclerView recyclerView = this.a;
            if (recyclerView == null) {
                throw new IllegalStateException("RecyclerView cannot be null. Setup FastScroller after the Adapter has been added to the RecyclerView.");
            } else if (fastScroller != null) {
                this.b = fastScroller;
                fastScroller.setRecyclerView(recyclerView);
                this.b.setViewsToUse(R.layout.library_fast_scroller_layout, R.id.fast_scroller_bubble, R.id.fast_scroller_handle);
            } else {
                throw new IllegalArgumentException("FastScroller cannot be null. Review the widget ID of the FastScroller.");
            }
        }

        public void toggleFastScroller() {
            FastScroller fastScroller = this.b;
            if (fastScroller != null) {
                fastScroller.toggleFastScroller();
            }
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface FastScrollerBubblePosition {
        public static final int ADJACENT = 0;
        public static final int CENTER = 1;
    }

    public interface OnScrollStateChangeListener {
        void onFastScrollerStateChange(boolean z);
    }

    public class a extends RecyclerView.OnScrollListener {
        public a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            if (FastScroller.this.isEnabled()) {
                FastScroller fastScroller = FastScroller.this;
                if (fastScroller.bubble != null && !fastScroller.handle.isSelected()) {
                    int computeVerticalScrollOffset = recyclerView.computeVerticalScrollOffset();
                    FastScroller fastScroller2 = FastScroller.this;
                    int i3 = fastScroller2.height;
                    fastScroller2.setBubbleAndHandlePosition(((float) i3) * (((float) computeVerticalScrollOffset) / (((float) recyclerView.computeVerticalScrollRange()) - ((float) i3))));
                    if (!(FastScroller.this.minimumScrollThreshold == 0 || i2 == 0)) {
                        int abs = Math.abs(i2);
                        FastScroller fastScroller3 = FastScroller.this;
                        if (abs <= fastScroller3.minimumScrollThreshold && !fastScroller3.scrollbarAnimator.isAnimating()) {
                            return;
                        }
                    }
                    FastScroller.this.showScrollbar();
                    FastScroller.this.b();
                }
            }
        }
    }

    public class b implements View.OnLayoutChangeListener {
        public b() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            FastScroller fastScroller = FastScroller.this;
            fastScroller.layoutManager = fastScroller.recyclerView.getLayoutManager();
        }
    }

    public class c implements ViewTreeObserver.OnPreDrawListener {
        public c() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            FastScroller.this.recyclerView.getViewTreeObserver().removeOnPreDrawListener(this);
            FastScroller fastScroller = FastScroller.this;
            if (fastScroller.bubble != null && !fastScroller.handle.isSelected()) {
                int computeVerticalScrollOffset = FastScroller.this.recyclerView.computeVerticalScrollOffset();
                FastScroller fastScroller2 = FastScroller.this;
                int i = fastScroller2.height;
                fastScroller2.setBubbleAndHandlePosition(((float) i) * (((float) computeVerticalScrollOffset) / (((float) FastScroller.this.computeVerticalScrollRange()) - ((float) i))));
            }
            return true;
        }
    }

    public FastScroller(Context context) {
        super(context);
        this.scrollStateChangeListeners = new ArrayList();
        this.bubbleAndHandleColor = 0;
        this.isInitialized = false;
        init();
    }

    public static int getValueInRange(int i, int i2, int i3) {
        return Math.min(Math.max(i, i3), i2);
    }

    public void addOnScrollStateChangeListener(OnScrollStateChangeListener onScrollStateChangeListener) {
        if (onScrollStateChangeListener != null && !this.scrollStateChangeListeners.contains(onScrollStateChangeListener)) {
            this.scrollStateChangeListeners.add(onScrollStateChangeListener);
        }
    }

    public final void b() {
        if (this.autoHideEnabled) {
            hideScrollbar();
        }
    }

    public long getAutoHideDelayInMillis() {
        return this.autoHideDelayInMillis;
    }

    public int getTargetPos(float f) {
        int itemCount = this.recyclerView.getAdapter().getItemCount();
        float f2 = 0.0f;
        if (this.handle.getY() != 0.0f) {
            float y = this.handle.getY() + ((float) this.handle.getHeight());
            int i = this.height;
            f2 = y >= ((float) (i + -5)) ? 1.0f : f / ((float) i);
        }
        return getValueInRange(0, itemCount - 1, (int) (f2 * ((float) itemCount)));
    }

    public void hideBubble() {
        this.bubbleAnimator.hideBubble();
    }

    public void hideScrollbar() {
        ScrollbarAnimator scrollbarAnimator2 = this.scrollbarAnimator;
        if (scrollbarAnimator2 != null) {
            scrollbarAnimator2.hideScrollbar();
        }
    }

    public void init() {
        if (!this.isInitialized) {
            this.isInitialized = true;
            setClipChildren(false);
            this.onScrollListener = new a();
        }
    }

    public boolean isAutoHideEnabled() {
        return this.autoHideEnabled;
    }

    public boolean isHidden() {
        View view = this.bar;
        return view == null || this.handle == null || view.getVisibility() == 4 || this.handle.getVisibility() == 4;
    }

    public void notifyScrollStateChange(boolean z) {
        for (OnScrollStateChangeListener onScrollStateChangeListener : this.scrollStateChangeListeners) {
            onScrollStateChangeListener.onFastScrollerStateChange(z);
        }
    }

    @Override // android.view.View, android.view.ViewGroup
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        RecyclerView recyclerView2 = this.recyclerView;
        if (recyclerView2 != null) {
            recyclerView2.addOnScrollListener(this.onScrollListener);
        }
    }

    @Override // android.view.View, android.view.ViewGroup
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        RecyclerView recyclerView2 = this.recyclerView;
        if (recyclerView2 != null) {
            recyclerView2.removeOnScrollListener(this.onScrollListener);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.height = i2;
        this.width = i;
    }

    @Override // android.view.View
    public boolean onTouchEvent(@NonNull MotionEvent motionEvent) {
        if (this.recyclerView.computeVerticalScrollRange() <= this.recyclerView.computeVerticalScrollExtent()) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action != 3) {
                        return super.onTouchEvent(motionEvent);
                    }
                }
            }
            this.handle.setSelected(false);
            notifyScrollStateChange(false);
            hideBubble();
            b();
            return true;
        } else if (motionEvent.getX() < this.handle.getX() - ((float) ViewCompat.getPaddingStart(this.handle))) {
            return false;
        } else {
            if (this.ignoreTouchesOutsideHandle && (motionEvent.getY() < this.handle.getY() || motionEvent.getY() > this.handle.getY() + ((float) this.handle.getHeight()))) {
                return false;
            }
            this.handle.setSelected(true);
            notifyScrollStateChange(true);
            showBubble();
            showScrollbar();
        }
        float y = motionEvent.getY();
        setBubbleAndHandlePosition(y);
        setRecyclerViewPosition(y);
        return true;
    }

    public void removeOnScrollStateChangeListener(OnScrollStateChangeListener onScrollStateChangeListener) {
        this.scrollStateChangeListeners.remove(onScrollStateChangeListener);
    }

    public void setAutoHideDelayInMillis(@IntRange(from = 0) long j) {
        this.autoHideDelayInMillis = j;
        ScrollbarAnimator scrollbarAnimator2 = this.scrollbarAnimator;
        if (scrollbarAnimator2 != null) {
            scrollbarAnimator2.setDelayInMillis(j);
        }
    }

    public void setAutoHideEnabled(boolean z) {
        this.autoHideEnabled = z;
    }

    public void setBubbleAndHandleColor(@ColorInt int i) {
        this.bubbleAndHandleColor = i;
        if (this.bubble != null) {
            GradientDrawable gradientDrawable = (GradientDrawable) getResources().getDrawable(R.drawable.fast_scroller_bubble, null);
            gradientDrawable.setColor(i);
            this.bubble.setBackground(gradientDrawable);
        }
        if (this.handle != null) {
            try {
                StateListDrawable stateListDrawable = (StateListDrawable) getResources().getDrawable(R.drawable.fast_scroller_handle, null);
                ((GradientDrawable) StateListDrawable.class.getMethod("getStateDrawable", Integer.TYPE).invoke(stateListDrawable, 0)).setColor(i);
                this.handle.setImageDrawable(stateListDrawable);
            } catch (Exception e) {
                Log.wtf(e, "Exception while setting Bubble and Handle Color", new Object[0]);
            }
        }
    }

    public void setBubbleAndHandlePosition(float f) {
        int height2 = this.handle.getHeight();
        ImageView imageView = this.handle;
        int i = this.height - height2;
        int i2 = height2 / 2;
        imageView.setY((float) getValueInRange(0, i, (int) (f - ((float) i2))));
        TextView textView = this.bubble;
        if (textView != null) {
            int height3 = textView.getHeight();
            if (this.bubblePosition == 0) {
                this.bubble.setY((float) getValueInRange(0, (this.height - height3) - i2, (int) (f - ((float) height3))));
                return;
            }
            TextView textView2 = this.bubble;
            textView2.setY((float) Math.max(0, (this.height - textView2.getHeight()) / 2));
            TextView textView3 = this.bubble;
            textView3.setX((float) Math.max(0, (this.width - textView3.getWidth()) / 2));
        }
    }

    public void setBubbleTextCreator(BubbleTextCreator bubbleTextCreator2) {
        this.bubbleTextCreator = bubbleTextCreator2;
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (z) {
            showScrollbar();
            b();
            return;
        }
        hideScrollbar();
    }

    public void setIgnoreTouchesOutsideHandle(boolean z) {
        this.ignoreTouchesOutsideHandle = z;
    }

    public void setMinimumScrollThreshold(@IntRange(from = 0) int i) {
        this.minimumScrollThreshold = i;
    }

    public void setRecyclerView(RecyclerView recyclerView2) {
        this.recyclerView = recyclerView2;
        RecyclerView.OnScrollListener onScrollListener2 = this.onScrollListener;
        if (onScrollListener2 != null) {
            recyclerView2.removeOnScrollListener(onScrollListener2);
        }
        this.recyclerView.addOnScrollListener(this.onScrollListener);
        this.recyclerView.addOnLayoutChangeListener(new b());
        if (recyclerView2.getAdapter() instanceof BubbleTextCreator) {
            setBubbleTextCreator((BubbleTextCreator) recyclerView2.getAdapter());
        }
        if (recyclerView2.getAdapter() instanceof OnScrollStateChangeListener) {
            addOnScrollStateChangeListener((OnScrollStateChangeListener) recyclerView2.getAdapter());
        }
        this.recyclerView.getViewTreeObserver().addOnPreDrawListener(new c());
    }

    public void setRecyclerViewPosition(float f) {
        if (this.recyclerView != null) {
            int targetPos = getTargetPos(f);
            RecyclerView.LayoutManager layoutManager2 = this.layoutManager;
            if (layoutManager2 instanceof StaggeredGridLayoutManager) {
                ((StaggeredGridLayoutManager) layoutManager2).scrollToPositionWithOffset(targetPos, 0);
            } else {
                ((LinearLayoutManager) layoutManager2).scrollToPositionWithOffset(targetPos, 0);
            }
            updateBubbleText(targetPos);
        }
    }

    public void setViewsToUse(@LayoutRes int i, @IdRes int i2, @IdRes int i3) {
        if (this.bubble == null) {
            LayoutInflater.from(getContext()).inflate(i, (ViewGroup) this, true);
            TextView textView = (TextView) findViewById(i2);
            this.bubble = textView;
            if (textView != null) {
                textView.setVisibility(4);
            }
            this.handle = (ImageView) findViewById(i3);
            this.bar = findViewById(R.id.fast_scroller_bar);
            this.bubbleAnimator = new BubbleAnimator(this.bubble, 300);
            this.scrollbarAnimator = new ScrollbarAnimator(this.bar, this.handle, this.autoHideDelayInMillis, 300);
            int i4 = this.bubbleAndHandleColor;
            if (i4 != 0) {
                setBubbleAndHandleColor(i4);
            }
        }
    }

    public void showBubble() {
        if (this.bubbleEnabled) {
            this.bubbleAnimator.showBubble();
        }
    }

    public void showScrollbar() {
        ScrollbarAnimator scrollbarAnimator2 = this.scrollbarAnimator;
        if (scrollbarAnimator2 != null) {
            scrollbarAnimator2.showScrollbar();
        }
    }

    public void toggleFastScroller() {
        setEnabled(!isEnabled());
    }

    public void updateBubbleText(int i) {
        if (this.bubble != null && this.bubbleEnabled) {
            String onCreateBubbleText = this.bubbleTextCreator.onCreateBubbleText(i);
            if (onCreateBubbleText != null) {
                this.bubble.setVisibility(0);
                this.bubble.setText(onCreateBubbleText);
                return;
            }
            this.bubble.setVisibility(8);
        }
    }

    public FastScroller(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: finally extract failed */
    public FastScroller(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.scrollStateChangeListeners = new ArrayList();
        this.bubbleAndHandleColor = 0;
        this.isInitialized = false;
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.FastScroller, 0, 0);
        try {
            this.autoHideEnabled = obtainStyledAttributes.getBoolean(R.styleable.FastScroller_fastScrollerAutoHideEnabled, true);
            this.autoHideDelayInMillis = (long) obtainStyledAttributes.getInteger(R.styleable.FastScroller_fastScrollerAutoHideDelayInMillis, 1000);
            this.bubbleEnabled = obtainStyledAttributes.getBoolean(R.styleable.FastScroller_fastScrollerBubbleEnabled, true);
            this.bubblePosition = obtainStyledAttributes.getInteger(R.styleable.FastScroller_fastScrollerBubblePosition, 0);
            this.ignoreTouchesOutsideHandle = obtainStyledAttributes.getBoolean(R.styleable.FastScroller_fastScrollerIgnoreTouchesOutsideHandle, false);
            obtainStyledAttributes.recycle();
            init();
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }
}
