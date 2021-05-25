package l6.z;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.transition.R;
import java.util.ArrayList;
@SuppressLint({"ViewConstructor"})
public class d extends FrameLayout {
    public static final /* synthetic */ int c = 0;
    @NonNull
    public ViewGroup a;
    public boolean b = true;

    public d(ViewGroup viewGroup) {
        super(viewGroup.getContext());
        setClipChildren(false);
        this.a = viewGroup;
        viewGroup.setTag(R.id.ghost_view_holder, this);
        this.a.getOverlay().add(this);
    }

    public static void a(View view, ArrayList<View> arrayList) {
        ViewParent parent = view.getParent();
        if (parent instanceof ViewGroup) {
            a((View) parent, arrayList);
        }
        arrayList.add(view);
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        if (this.b) {
            super.onViewAdded(view);
            return;
        }
        throw new IllegalStateException("This GhostViewHolder is detached!");
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        if ((getChildCount() == 1 && getChildAt(0) == view) || getChildCount() == 0) {
            this.a.setTag(R.id.ghost_view_holder, null);
            this.a.getOverlay().remove(this);
            this.b = false;
        }
    }
}
