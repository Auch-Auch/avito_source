package a2.a.a.t0;

import android.content.DialogInterface;
import com.avito.android.favorites.FavoritesViewImpl;
import com.avito.android.lastclick.LastClick;
public final class x0 implements DialogInterface.OnClickListener {
    public final /* synthetic */ FavoritesViewImpl a;

    public x0(FavoritesViewImpl favoritesViewImpl) {
        this.a = favoritesViewImpl;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        LastClick.Updater.update();
        this.a.i.onRemoveAllClicked();
    }
}
