package a2.a.a.k2.a;

import com.avito.android.search.filter.FiltersViewImpl;
import com.avito.android.util.ButtonsKt;
public final class b0 implements Runnable {
    public final /* synthetic */ FiltersViewImpl.a a;

    public b0(FiltersViewImpl.a aVar) {
        this.a = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ButtonsKt.show(this.a.a.e);
    }
}
