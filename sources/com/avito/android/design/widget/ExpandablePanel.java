package com.avito.android.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.avito.android.ui_components.R;
public class ExpandablePanel extends LinearLayoutCompat implements View.OnClickListener, View.OnLongClickListener {
    public boolean A;
    public int mAnimationDuration;
    public final int p;
    public final int q;
    public final int r;
    public View s;
    public TextView t;
    public TextView u;
    public boolean v;
    public int w;
    public OnExpandListener x;
    public OnExpandablePanelTextListener y;
    public int z;

    public static class DefaultOnExpandListener implements OnExpandListener {
        @Override // com.avito.android.design.widget.ExpandablePanel.OnExpandListener
        public void onCollapse(View view, View view2) {
        }

        @Override // com.avito.android.design.widget.ExpandablePanel.OnExpandListener
        public void onExpand(View view, View view2) {
        }

        @Override // com.avito.android.design.widget.ExpandablePanel.OnExpandListener
        public void onExpandExist() {
        }
    }

    public class ExpandAnimation extends Animation {
        public final int a;
        public final int b;

        public ExpandAnimation(int i, int i2) {
            this.a = i;
            this.b = i2 - i;
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f, Transformation transformation) {
            ViewGroup.LayoutParams layoutParams = ExpandablePanel.this.u.getLayoutParams();
            layoutParams.height = (int) ((((float) this.b) * f) + ((float) this.a));
            ExpandablePanel.this.u.setLayoutParams(layoutParams);
        }

        @Override // android.view.animation.Animation
        public boolean willChangeBounds() {
            return true;
        }
    }

    public interface OnExpandListener {
        void onCollapse(View view, View view2);

        void onExpand(View view, View view2);

        void onExpandExist();
    }

    public interface OnExpandablePanelTextListener {
        void onExpandablePanelTextClick();

        void onExpandablePanelTextLongClick();
    }

    public static class b extends View.BaseSavedState implements Parcelable {
        public static final Parcelable.Creator<b> CREATOR = new a();
        public boolean a;
        public boolean b;
        public int c;

        public class a implements Parcelable.Creator<b> {
            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public b createFromParcel(Parcel parcel) {
                return new b(parcel, null);
            }

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public b[] newArray(int i) {
                return new b[i];
            }
        }

        public b(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.View.BaseSavedState, android.os.Parcelable, android.view.AbsSavedState
        public void writeToParcel(@NonNull Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.a ? 1 : 0);
            parcel.writeInt(this.b ? 1 : 0);
            parcel.writeInt(this.c);
        }

        public b(Parcel parcel, a aVar) {
            super(parcel);
            boolean z = false;
            this.a = parcel.readInt() == 1;
            this.b = parcel.readInt() == 1 ? true : z;
            this.c = parcel.readInt();
        }
    }

    public ExpandablePanel(Context context) {
        this(context, null);
    }

    public void collapse() {
        this.u.setMaxLines(this.w);
        this.x.onCollapse(this.t, this.u);
        this.v = false;
    }

    public void expand() {
        expand(true);
    }

    public boolean isExpanded() {
        return this.v;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        OnExpandablePanelTextListener onExpandablePanelTextListener;
        int id = view.getId();
        if (id == this.p || id == this.q) {
            if (!isExpanded()) {
                expand();
            } else if (this.A) {
                collapse();
            }
        }
        if (id == this.q && (onExpandablePanelTextListener = this.y) != null) {
            onExpandablePanelTextListener.onExpandablePanelTextClick();
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        int i = this.r;
        if (i != 0) {
            this.s = findViewById(i);
        }
        TextView textView = (TextView) findViewById(this.p);
        this.t = textView;
        if (textView != null) {
            TextView textView2 = (TextView) findViewById(this.q);
            this.u = textView2;
            if (textView2 != null) {
                this.t.setOnClickListener(this);
                this.u.setOnClickListener(this);
                this.u.setOnLongClickListener(this);
                return;
            }
            throw new IllegalArgumentException("The content attribute must refer to an existing child.");
        }
        throw new IllegalArgumentException("The handle attribute is must refer to an existing child.");
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        OnExpandablePanelTextListener onExpandablePanelTextListener;
        if (view.getId() != this.q || (onExpandablePanelTextListener = this.y) == null) {
            return false;
        }
        onExpandablePanelTextListener.onExpandablePanelTextLongClick();
        return false;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    public void onMeasure(int i, int i2) {
        if (!TextUtils.isEmpty(this.u.getText())) {
            int i3 = this.z;
            if (i3 == 0) {
                i3 = this.u.getLineCount();
                this.z = i3;
            }
            if (i3 <= this.w || isExpanded()) {
                this.u.setMaxLines(Integer.MAX_VALUE);
                this.t.setVisibility(this.A ? 0 : 8);
            } else {
                this.u.setMaxLines(this.w);
                this.t.setVisibility(0);
                OnExpandListener onExpandListener = this.x;
                if (onExpandListener != null) {
                    onExpandListener.onExpandExist();
                }
            }
        }
        this.u.measure(i, 0);
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        b bVar = (b) parcelable;
        super.onRestoreInstanceState(bVar.getSuperState());
        boolean z2 = bVar.a;
        this.v = z2;
        this.A = bVar.b;
        this.z = bVar.c;
        if (z2) {
            expand(false);
        }
    }

    public void onRestoreState(Parcelable parcelable) {
        onRestoreInstanceState(parcelable);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        b bVar = new b(super.onSaveInstanceState());
        bVar.a = isExpanded();
        bVar.b = this.A;
        bVar.c = this.z;
        return bVar;
    }

    public Parcelable onSaveState() {
        return onSaveInstanceState();
    }

    public void setAnimationDuration(int i) {
        this.mAnimationDuration = i;
    }

    public void setCollapsedLinesCount(int i) {
        this.w = i;
    }

    public void setCollapsingEnabled(boolean z2) {
        this.A = z2;
    }

    public void setHandleText(CharSequence charSequence) {
        this.t.setText(charSequence);
    }

    public void setOnExpandListener(OnExpandListener onExpandListener) {
        this.x = onExpandListener;
    }

    public void setOnTextClickListener(OnExpandablePanelTextListener onExpandablePanelTextListener) {
        this.y = onExpandablePanelTextListener;
    }

    public void setText(CharSequence charSequence) {
        this.u.setText(charSequence);
    }

    public void setTextAutoCollapse(CharSequence charSequence) {
        CharSequence text = this.u.getText();
        this.u.setText(charSequence);
        if (!TextUtils.equals(text, this.u.getText())) {
            this.v = false;
        }
    }

    public void showDivider() {
        this.s.setVisibility(0);
    }

    public ExpandablePanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.z = 0;
        this.x = new DefaultOnExpandListener();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandablePanel, 0, 0);
        this.w = obtainStyledAttributes.getInt(R.styleable.ExpandablePanel_collapsedLinesCount, 1);
        this.mAnimationDuration = obtainStyledAttributes.getInteger(R.styleable.ExpandablePanel_animationDuration, 500);
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.ExpandablePanel_handle, 0);
        if (resourceId != 0) {
            int resourceId2 = obtainStyledAttributes.getResourceId(R.styleable.ExpandablePanel_content, 0);
            if (resourceId2 != 0) {
                this.r = obtainStyledAttributes.getResourceId(R.styleable.ExpandablePanel_top_divider, 0);
                obtainStyledAttributes.recycle();
                this.p = resourceId;
                this.q = resourceId2;
                return;
            }
            throw new IllegalArgumentException("The content attribute is required and must refer to a valid child.");
        }
        throw new IllegalArgumentException("The handle attribute is required and must refer to a valid child.");
    }

    public void expand(boolean z2) {
        this.u.setMaxLines(Integer.MAX_VALUE);
        if (z2) {
            this.x.onExpand(this.t, this.u);
        }
        this.v = true;
    }
}
