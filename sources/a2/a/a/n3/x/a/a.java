package a2.a.a.n3.x.a;

import com.avito.android.util.preferences.db_preferences.DbSharedPreferencesImpl;
import java.util.Set;
public final class a implements Runnable {
    public final /* synthetic */ DbSharedPreferencesImpl.a a;
    public final /* synthetic */ Set b;

    public a(DbSharedPreferencesImpl.a aVar, Set set) {
        this.a = aVar;
        this.b = set;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.b(this.b);
    }
}
