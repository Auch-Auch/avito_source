package l6.b.a;

import android.view.View;
import androidx.appcompat.app.AlertController;
public class b implements Runnable {
    public final /* synthetic */ View a;
    public final /* synthetic */ View b;
    public final /* synthetic */ AlertController c;

    public b(AlertController alertController, View view, View view2) {
        this.c = alertController;
        this.a = view;
        this.b = view2;
    }

    @Override // java.lang.Runnable
    public void run() {
        AlertController.c(this.c.A, this.a, this.b);
    }
}
