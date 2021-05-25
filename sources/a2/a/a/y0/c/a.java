package a2.a.a.y0.c;

import android.view.View;
import com.avito.android.help_center.help_center_articles.HelpCenterArticlesViewImpl;
import kotlin.Unit;
public final class a implements View.OnClickListener {
    public final /* synthetic */ HelpCenterArticlesViewImpl a;

    public a(HelpCenterArticlesViewImpl helpCenterArticlesViewImpl) {
        this.a = helpCenterArticlesViewImpl;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.a.getNavigationClick().accept(Unit.INSTANCE);
    }
}
