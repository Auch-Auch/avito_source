package androidx.preference;

import android.util.SparseArray;
import android.view.View;
import androidx.annotation.IdRes;
import androidx.annotation.RestrictTo;
import androidx.recyclerview.widget.RecyclerView;
public class PreferenceViewHolder extends RecyclerView.ViewHolder {
    public final SparseArray<View> s;
    public boolean t;
    public boolean u;

    public PreferenceViewHolder(View view) {
        super(view);
        SparseArray<View> sparseArray = new SparseArray<>(4);
        this.s = sparseArray;
        sparseArray.put(16908310, view.findViewById(16908310));
        sparseArray.put(16908304, view.findViewById(16908304));
        sparseArray.put(16908294, view.findViewById(16908294));
        int i = R.id.icon_frame;
        sparseArray.put(i, view.findViewById(i));
        sparseArray.put(AndroidResources.ANDROID_R_ICON_FRAME, view.findViewById(AndroidResources.ANDROID_R_ICON_FRAME));
    }

    @RestrictTo({RestrictTo.Scope.TESTS})
    public static PreferenceViewHolder createInstanceForTests(View view) {
        return new PreferenceViewHolder(view);
    }

    public View findViewById(@IdRes int i) {
        View view = this.s.get(i);
        if (view != null) {
            return view;
        }
        View findViewById = this.itemView.findViewById(i);
        if (findViewById != null) {
            this.s.put(i, findViewById);
        }
        return findViewById;
    }

    public boolean isDividerAllowedAbove() {
        return this.t;
    }

    public boolean isDividerAllowedBelow() {
        return this.u;
    }

    public void setDividerAllowedAbove(boolean z) {
        this.t = z;
    }

    public void setDividerAllowedBelow(boolean z) {
        this.u = z;
    }
}
