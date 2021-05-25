package a2.a.a.l0.a.c;

import android.view.View;
import com.avito.android.design.widget.search_view.ToolbarSearchViewImpl;
public final class c implements View.OnFocusChangeListener {
    public final /* synthetic */ ToolbarSearchViewImpl a;

    public c(ToolbarSearchViewImpl toolbarSearchViewImpl) {
        this.a = toolbarSearchViewImpl;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z) {
        ToolbarSearchViewImpl.access$onEditTextFocus(this.a, z);
    }
}
