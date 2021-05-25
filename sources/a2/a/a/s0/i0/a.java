package a2.a.a.s0.i0;

import com.avito.android.util.Logs;
import io.reactivex.rxjava3.functions.Action;
public final class a implements Action {
    public static final a a = new a();

    @Override // io.reactivex.rxjava3.functions.Action
    public final void run() {
        Logs.info$default("FavoriteSellerInteractor", "Favorite seller updated after muting", null, 4, null);
    }
}
