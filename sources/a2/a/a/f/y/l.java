package a2.a.a.f.y;

import android.view.View;
import com.avito.android.advert.notes.EditAdvertNoteScreenNavigation;
import com.avito.android.advert.notes.EditAdvertNoteViewImpl;
public final class l implements View.OnClickListener {
    public final /* synthetic */ EditAdvertNoteViewImpl a;

    public l(EditAdvertNoteViewImpl editAdvertNoteViewImpl) {
        this.a = editAdvertNoteViewImpl;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.a.getNavigationClick().accept(new EditAdvertNoteScreenNavigation.Back());
    }
}
