package a2.l.a;

import android.content.Context;
import com.my.target.df;
import com.my.target.im;
public class u implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ im c;

    public u(im imVar, String str, Context context) {
        this.c = imVar;
        this.a = str;
        this.b = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        String a3 = this.c.a(this.a, true);
        if (a3 != null) {
            df.cL().f(a3, this.b);
        }
    }
}
