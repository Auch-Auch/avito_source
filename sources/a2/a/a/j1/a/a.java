package a2.a.a.j1.a;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.util.ViewSizeKt;
import org.jetbrains.annotations.NotNull;
public final class a extends RecyclerView.ItemDecoration {
    public final int a = ViewSizeKt.getDp(16);
    public final int b = ViewSizeKt.getDp(10);

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@NotNull Rect rect, @NotNull View view, @NotNull RecyclerView recyclerView, @NotNull RecyclerView.State state) {
        a2.b.a.a.a.F0(rect, "outRect", view, "view", recyclerView, "parent", state, "state");
        int i = this.a;
        rect.left = i;
        rect.right = i;
        rect.bottom = this.b;
    }
}
