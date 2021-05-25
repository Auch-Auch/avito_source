package q6.a.b;

import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import eu.davidea.flexibleadapter.FlexibleAdapter;
public abstract class a extends RecyclerView.ViewHolder {
    public int s;
    public View t;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(View view, FlexibleAdapter flexibleAdapter, boolean z) {
        super(z ? new FrameLayout(view.getContext()) : view);
        this.s = -1;
        if (z) {
            this.itemView.setLayoutParams(flexibleAdapter.getRecyclerView().getLayoutManager().generateLayoutParams(view.getLayoutParams()));
            ((FrameLayout) this.itemView).addView(view);
            float elevation = ViewCompat.getElevation(view);
            if (elevation > 0.0f) {
                ViewCompat.setBackground(this.itemView, view.getBackground());
                ViewCompat.setElevation(this.itemView, elevation);
            }
            this.t = view;
        }
    }

    public final View getContentView() {
        View view = this.t;
        return view != null ? view : this.itemView;
    }

    public final int getFlexibleAdapterPosition() {
        int adapterPosition = getAdapterPosition();
        return adapterPosition == -1 ? this.s : adapterPosition;
    }

    public final void setBackupPosition(int i) {
        this.s = i;
    }
}
