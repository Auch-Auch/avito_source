package com.my.target;

import android.content.Context;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.my.target.gj;
import com.my.target.gk;
import com.my.target.gn;
import java.util.List;
public class gl extends RecyclerView implements gm {
    @NonNull
    public final c E0;
    @NonNull
    public final gk.c F0;
    @NonNull
    public final gk G0;
    public boolean H0;
    @Nullable
    public gn.a I0;

    public class a implements gj.a {
        public a() {
        }

        @Override // com.my.target.gj.a
        public void ei() {
            gl glVar = gl.this;
            gn.a aVar = glVar.I0;
            if (aVar != null) {
                aVar.b(glVar.getVisibleCardNumbers(), glVar.getContext());
            }
        }
    }

    public class b implements gk.c {
        public b(a aVar) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            View findContainingItemView;
            int position;
            gl glVar = gl.this;
            if (!glVar.H0 && glVar.isClickable() && (findContainingItemView = gl.this.E0.findContainingItemView(view)) != null) {
                gl glVar2 = gl.this;
                if (glVar2.I0 != null && (position = glVar2.E0.getPosition(findContainingItemView)) >= 0) {
                    gl.this.I0.b(findContainingItemView, position);
                }
            }
        }
    }

    public static class c extends LinearLayoutManager {
        @Nullable
        public gj.a I;
        public int J;

        public c(Context context) {
            super(context, 0, false);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
        public void measureChildWithMargins(View view, int i, int i2) {
            int i3;
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            int width = getWidth();
            if (getHeight() > 0 && width > 0) {
                if (getItemViewType(view) == 1) {
                    i3 = this.J;
                } else if (getItemViewType(view) == 2) {
                    ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = this.J;
                    super.measureChildWithMargins(view, i, i2);
                } else {
                    i3 = this.J;
                    ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = i3;
                }
                ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = i3;
                super.measureChildWithMargins(view, i, i2);
            }
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public void onLayoutCompleted(RecyclerView.State state) {
            super.onLayoutCompleted(state);
            gj.a aVar = this.I;
            if (aVar != null) {
                aVar.ei();
            }
        }
    }

    public gl(@NonNull Context context) {
        this(context, null);
    }

    public gl(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public gl(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.F0 = new b(null);
        c cVar = new c(context);
        this.E0 = cVar;
        cVar.J = io.c(4, context);
        this.G0 = new gk(getContext());
        setHasFixedSize(true);
    }

    private void setCardLayoutManager(c cVar) {
        cVar.I = new a();
        super.setLayoutManager(cVar);
    }

    @Override // com.my.target.gn
    public void dispose() {
        gk gkVar = this.G0;
        gkVar.d.clear();
        gkVar.notifyDataSetChanged();
        gkVar.e = null;
    }

    @Override // com.my.target.gn
    public Parcelable getState() {
        return this.E0.onSaveInstanceState();
    }

    @Override // com.my.target.gm
    public View getView() {
        return this;
    }

    @Override // com.my.target.gn
    @NonNull
    public int[] getVisibleCardNumbers() {
        int findFirstVisibleItemPosition = this.E0.findFirstVisibleItemPosition();
        int findLastVisibleItemPosition = this.E0.findLastVisibleItemPosition();
        if (findFirstVisibleItemPosition < 0 || findLastVisibleItemPosition < 0) {
            return new int[0];
        }
        if (iq.l(this.E0.findViewByPosition(findFirstVisibleItemPosition)) < 50.0d) {
            findFirstVisibleItemPosition++;
        }
        if (iq.l(this.E0.findViewByPosition(findLastVisibleItemPosition)) < 50.0d) {
            findLastVisibleItemPosition--;
        }
        if (findFirstVisibleItemPosition > findLastVisibleItemPosition) {
            return new int[0];
        }
        if (findFirstVisibleItemPosition == findLastVisibleItemPosition) {
            return new int[]{findFirstVisibleItemPosition};
        }
        int i = (findLastVisibleItemPosition - findFirstVisibleItemPosition) + 1;
        int[] iArr = new int[i];
        for (int i2 = 0; i2 < i; i2++) {
            iArr[i2] = findFirstVisibleItemPosition;
            findFirstVisibleItemPosition++;
        }
        return iArr;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void onScrollStateChanged(int i) {
        gn.a aVar;
        super.onScrollStateChanged(i);
        boolean z = i != 0;
        this.H0 = z;
        if (!z && (aVar = this.I0) != null) {
            aVar.b(getVisibleCardNumbers(), getContext());
        }
    }

    @Override // com.my.target.gn
    public void restoreState(@NonNull Parcelable parcelable) {
        this.E0.onRestoreInstanceState(parcelable);
    }

    @Override // com.my.target.gn
    public void setPromoCardSliderListener(@Nullable gn.a aVar) {
        this.I0 = aVar;
    }

    @Override // com.my.target.gm
    public void setupCards(@NonNull List<ch> list) {
        this.G0.d.addAll(list);
        if (isClickable()) {
            this.G0.e = this.F0;
        }
        setCardLayoutManager(this.E0);
        swapAdapter(this.G0, true);
    }
}
