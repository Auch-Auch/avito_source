package a2.c.a;

import com.androidadvance.topsnackbar.TSnackbar;
public class c implements Runnable {
    public final /* synthetic */ d a;

    public c(d dVar) {
        this.a = dVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        TSnackbar tSnackbar = this.a.a;
        int i = TSnackbar.LENGTH_INDEFINITE;
        tSnackbar.d(3);
    }
}
