package a2.a.a.m2.m.b;

import com.avito.android.select.new_metro.view.SelectMetroViewImpl;
public final class a implements Runnable {
    public final /* synthetic */ SelectMetroViewImpl a;

    public a(SelectMetroViewImpl selectMetroViewImpl) {
        this.a = selectMetroViewImpl;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SelectMetroViewImpl selectMetroViewImpl = this.a;
        SelectMetroViewImpl.access$hideKeyboard(selectMetroViewImpl, selectMetroViewImpl.f, true);
    }
}
