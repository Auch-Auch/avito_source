package a2.a.a.l0.a.c;

import android.view.View;
import com.avito.android.design.widget.search_view.ToolbarSearchViewImpl;
public final class a implements View.OnClickListener {
    public final /* synthetic */ ToolbarSearchViewImpl a;

    public a(ToolbarSearchViewImpl toolbarSearchViewImpl) {
        this.a = toolbarSearchViewImpl;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.a.c.onEditorAction(3);
    }
}
