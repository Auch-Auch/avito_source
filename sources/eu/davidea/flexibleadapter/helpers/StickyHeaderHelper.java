package eu.davidea.flexibleadapter.helpers;

import android.animation.Animator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import eu.davidea.flexibleadapter.FlexibleAdapter;
import eu.davidea.flexibleadapter.R;
import eu.davidea.flexibleadapter.items.IHeader;
import eu.davidea.flexibleadapter.utils.Log;
import eu.davidea.viewholders.FlexibleViewHolder;
public final class StickyHeaderHelper extends RecyclerView.OnScrollListener {
    public FlexibleAdapter a;
    public RecyclerView b;
    public ViewGroup c;
    public FlexibleViewHolder d;
    public FlexibleAdapter.OnStickyHeaderChangeListener e;
    public int f = -1;
    public boolean g = false;
    public float h;

    public class a implements Animator.AnimatorListener {
        public a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            StickyHeaderHelper stickyHeaderHelper = StickyHeaderHelper.this;
            stickyHeaderHelper.g = true;
            stickyHeaderHelper.c.setAlpha(0.0f);
            StickyHeaderHelper.this.a();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            StickyHeaderHelper.this.f = -1;
        }
    }

    public StickyHeaderHelper(FlexibleAdapter flexibleAdapter, FlexibleAdapter.OnStickyHeaderChangeListener onStickyHeaderChangeListener, ViewGroup viewGroup) {
        this.a = flexibleAdapter;
        this.e = onStickyHeaderChangeListener;
        this.c = viewGroup;
    }

    public final void a() {
        if (this.d != null) {
            Log.d("clearHeader", new Object[0]);
            c(this.d);
            this.c.setAlpha(0.0f);
            this.c.animate().cancel();
            this.c.animate().setListener(null);
            this.d = null;
            d();
            int i = this.f;
            this.f = -1;
            FlexibleAdapter.OnStickyHeaderChangeListener onStickyHeaderChangeListener = this.e;
            if (onStickyHeaderChangeListener != null) {
                onStickyHeaderChangeListener.onStickyHeaderChange(-1, i);
            }
        }
    }

    public void attachToRecyclerView(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.b;
        if (recyclerView2 != null) {
            recyclerView2.removeOnScrollListener(this);
            a();
        }
        if (recyclerView != null) {
            this.b = recyclerView;
            recyclerView.addOnScrollListener(this);
            if (this.c == null) {
                FrameLayout frameLayout = new FrameLayout(this.b.getContext());
                frameLayout.setLayoutParams(new ViewGroup.MarginLayoutParams(-2, -2));
                ((ViewGroup) this.b.getParent()).addView(frameLayout);
                this.c = (ViewGroup) LayoutInflater.from(this.b.getContext()).inflate(R.layout.sticky_header_layout, frameLayout);
                Log.i("Default StickyHolderLayout initialized", new Object[0]);
            } else {
                Log.i("User defined StickyHolderLayout initialized", new Object[0]);
            }
            updateOrClearHeader(false);
            return;
        }
        throw new IllegalStateException("Adapter is not attached to RecyclerView. Enable sticky headers after setting adapter to RecyclerView.");
    }

    public final int b(int i) {
        if (i == -1 && (i = this.a.getFlexibleLayoutManager().findFirstVisibleItemPosition()) == 0) {
            boolean z = false;
            RecyclerView.ViewHolder findViewHolderForAdapterPosition = this.b.findViewHolderForAdapterPosition(0);
            if (findViewHolderForAdapterPosition != null && (findViewHolderForAdapterPosition.itemView.getX() < 0.0f || findViewHolderForAdapterPosition.itemView.getY() < 0.0f)) {
                z = true;
            }
            if (!z) {
                return -1;
            }
        }
        IHeader sectionHeader = this.a.getSectionHeader(i);
        if (sectionHeader == null || (this.a.isExpandable(sectionHeader) && !this.a.isExpanded((FlexibleAdapter) sectionHeader))) {
            return -1;
        }
        return this.a.getGlobalPositionOf(sectionHeader);
    }

    public final void c(FlexibleViewHolder flexibleViewHolder) {
        d();
        View contentView = flexibleViewHolder.getContentView();
        ViewParent parent = contentView.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(contentView);
        }
        contentView.setTranslationX(0.0f);
        contentView.setTranslationY(0.0f);
        if (!flexibleViewHolder.itemView.equals(contentView)) {
            try {
                ((ViewGroup) flexibleViewHolder.itemView).addView(contentView);
            } catch (IllegalStateException unused) {
                Log.wtf("The specified child already has a parent! (but parent was removed!)", new Object[0]);
            }
        }
        flexibleViewHolder.setIsRecyclable(true);
        flexibleViewHolder.itemView.getLayoutParams().width = contentView.getLayoutParams().width;
        flexibleViewHolder.itemView.getLayoutParams().height = contentView.getLayoutParams().height;
    }

    public void clearHeaderWithAnimation() {
        if (this.d != null && this.f != -1) {
            this.c.animate().setListener(new a());
            this.c.animate().alpha(0.0f).start();
        }
    }

    public final void d() {
        if (this.b != null) {
            for (int i = 0; i < this.b.getChildCount(); i++) {
                View childAt = this.b.getChildAt(i);
                int childAdapterPosition = this.b.getChildAdapterPosition(childAt);
                FlexibleAdapter flexibleAdapter = this.a;
                if (flexibleAdapter.isHeader(flexibleAdapter.getItem(childAdapterPosition))) {
                    childAt.setVisibility(0);
                }
            }
        }
    }

    public void detachFromRecyclerView() {
        this.b.removeOnScrollListener(this);
        this.b = null;
        clearHeaderWithAnimation();
        Log.d("StickyHolderLayout detached", new Object[0]);
    }

    public void ensureHeaderParent() {
        View contentView = this.d.getContentView();
        this.d.itemView.getLayoutParams().width = contentView.getMeasuredWidth();
        this.d.itemView.getLayoutParams().height = contentView.getMeasuredHeight();
        this.d.itemView.setVisibility(4);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.c.getLayoutParams();
        marginLayoutParams.width = contentView.getLayoutParams().width;
        marginLayoutParams.height = contentView.getLayoutParams().height;
        if (marginLayoutParams.leftMargin == 0) {
            marginLayoutParams.leftMargin = this.b.getLayoutManager().getLeftDecorationWidth(this.d.itemView);
        }
        if (marginLayoutParams.topMargin == 0) {
            marginLayoutParams.topMargin = this.b.getLayoutManager().getTopDecorationHeight(this.d.itemView);
        }
        if (marginLayoutParams.rightMargin == 0) {
            marginLayoutParams.rightMargin = this.b.getLayoutManager().getRightDecorationWidth(this.d.itemView);
        }
        if (marginLayoutParams.bottomMargin == 0) {
            marginLayoutParams.bottomMargin = this.b.getLayoutManager().getBottomDecorationHeight(this.d.itemView);
        }
        ViewParent parent = contentView.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(contentView);
        }
        try {
            this.c.addView(contentView);
        } catch (IllegalStateException unused) {
            Log.wtf("The specified child already has a parent! (but parent was removed!)", new Object[0]);
        }
        float elevation = ViewCompat.getElevation(this.d.getContentView());
        this.h = elevation;
        if (elevation == 0.0f) {
            this.h = this.b.getContext().getResources().getDisplayMetrics().density * ((float) this.a.getStickyHeaderElevation());
        }
        if (this.h > 0.0f) {
            ViewCompat.setBackground(this.c, this.d.getContentView().getBackground());
        }
    }

    public int getStickyPosition() {
        return this.f;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        this.g = this.b.getScrollState() == 0;
        updateOrClearHeader(false);
    }

    public void updateOrClearHeader(boolean z) {
        int i;
        int i2;
        if (!this.a.areHeadersShown() || this.a.getItemCount() == 0) {
            clearHeaderWithAnimation();
            return;
        }
        int b2 = b(-1);
        if (b2 >= 0) {
            if (this.f != b2) {
                int findFirstVisibleItemPosition = this.a.getFlexibleLayoutManager().findFirstVisibleItemPosition();
                if (!this.g || this.f != -1 || b2 == findFirstVisibleItemPosition) {
                    this.c.setAlpha(1.0f);
                } else {
                    this.g = false;
                    this.c.setAlpha(0.0f);
                    this.c.animate().alpha(1.0f).start();
                }
                int i3 = this.f;
                this.f = b2;
                FlexibleViewHolder flexibleViewHolder = (FlexibleViewHolder) this.b.findViewHolderForAdapterPosition(b2);
                if (flexibleViewHolder == null) {
                    FlexibleAdapter flexibleAdapter = this.a;
                    flexibleViewHolder = (FlexibleViewHolder) flexibleAdapter.createViewHolder(this.b, flexibleAdapter.getItemViewType(b2));
                    this.a.bindViewHolder(flexibleViewHolder, b2);
                    if (this.a.getFlexibleLayoutManager().getOrientation() == 1) {
                        i2 = View.MeasureSpec.makeMeasureSpec(this.b.getWidth(), 1073741824);
                        i = View.MeasureSpec.makeMeasureSpec(this.b.getHeight(), 0);
                    } else {
                        i2 = View.MeasureSpec.makeMeasureSpec(this.b.getWidth(), 0);
                        i = View.MeasureSpec.makeMeasureSpec(this.b.getHeight(), 1073741824);
                    }
                    View contentView = flexibleViewHolder.getContentView();
                    contentView.measure(ViewGroup.getChildMeasureSpec(i2, this.b.getPaddingRight() + this.b.getPaddingLeft(), contentView.getLayoutParams().width), ViewGroup.getChildMeasureSpec(i, this.b.getPaddingBottom() + this.b.getPaddingTop(), contentView.getLayoutParams().height));
                    contentView.layout(0, 0, contentView.getMeasuredWidth(), contentView.getMeasuredHeight());
                }
                flexibleViewHolder.setBackupPosition(b2);
                Log.d("swapHeader newHeaderPosition=%s", Integer.valueOf(this.f));
                FlexibleViewHolder flexibleViewHolder2 = this.d;
                if (flexibleViewHolder2 != null) {
                    c(flexibleViewHolder2);
                }
                this.d = flexibleViewHolder;
                flexibleViewHolder.setIsRecyclable(false);
                ensureHeaderParent();
                int i4 = this.f;
                FlexibleAdapter.OnStickyHeaderChangeListener onStickyHeaderChangeListener = this.e;
                if (onStickyHeaderChangeListener != null) {
                    onStickyHeaderChangeListener.onStickyHeaderChange(i4, i3);
                }
            } else if (z) {
                this.a.onBindViewHolder(this.d, b2);
                ensureHeaderParent();
            }
            float f2 = this.h;
            int i5 = 0;
            int i6 = 0;
            for (int i7 = 0; i7 < this.b.getChildCount(); i7++) {
                View childAt = this.b.getChildAt(i7);
                if (!(childAt == null || this.f == b(this.b.getChildAdapterPosition(childAt)))) {
                    if (this.a.getFlexibleLayoutManager().getOrientation() == 0) {
                        if (childAt.getLeft() > 0) {
                            int left = ((childAt.getLeft() - this.c.getMeasuredWidth()) - this.b.getLayoutManager().getLeftDecorationWidth(childAt)) - this.b.getLayoutManager().getRightDecorationWidth(childAt);
                            i5 = Math.min(left, 0);
                            if (left < 5) {
                                f2 = 0.0f;
                            }
                            if (i5 < 0) {
                                break;
                            }
                        } else {
                            continue;
                        }
                    } else if (childAt.getTop() > 0) {
                        int top = ((childAt.getTop() - this.c.getMeasuredHeight()) - this.b.getLayoutManager().getTopDecorationHeight(childAt)) - this.b.getLayoutManager().getBottomDecorationHeight(childAt);
                        i6 = Math.min(top, 0);
                        if (top < 5) {
                            f2 = 0.0f;
                        }
                        if (i6 < 0) {
                            break;
                        }
                    } else {
                        continue;
                    }
                }
            }
            ViewCompat.setElevation(this.c, f2);
            this.c.setTranslationX((float) i5);
            this.c.setTranslationY((float) i6);
            return;
        }
        a();
    }
}
