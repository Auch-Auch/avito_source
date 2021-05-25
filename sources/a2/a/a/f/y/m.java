package a2.a.a.f.y;

import android.view.MenuItem;
import com.avito.android.advert.notes.EditAdvertNoteScreenNavigation;
import com.avito.android.advert.notes.EditAdvertNoteViewImpl;
public final class m implements MenuItem.OnMenuItemClickListener {
    public final /* synthetic */ EditAdvertNoteViewImpl a;

    public m(EditAdvertNoteViewImpl editAdvertNoteViewImpl) {
        this.a = editAdvertNoteViewImpl;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.a.getNavigationClick().accept(new EditAdvertNoteScreenNavigation.SaveNote());
        return true;
    }
}
