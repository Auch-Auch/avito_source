package a2.a.a.l0.a.c;

import android.view.MenuItem;
import android.view.View;
import com.avito.android.design.widget.search_view.ToolbarSearchViewImpl;
public final class f implements View.OnClickListener {
    public final /* synthetic */ ToolbarSearchViewImpl a;
    public final /* synthetic */ MenuItem b;

    public f(ToolbarSearchViewImpl toolbarSearchViewImpl, MenuItem menuItem) {
        this.a = toolbarSearchViewImpl;
        this.b = menuItem;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.a.onMenuItemClick(this.b);
    }
}
