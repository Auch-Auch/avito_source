package a2.l.a;

import android.content.Context;
import com.my.target.cy;
import com.my.target.df;
import com.my.target.im;
public class s implements Runnable {
    public final /* synthetic */ cy a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ im c;

    public s(im imVar, cy cyVar, Context context) {
        this.c = imVar;
        this.a = cyVar;
        this.b = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        im.b(this.c, this.a);
        String a3 = this.c.a(this.a.getUrl(), this.a.cw());
        if (a3 != null) {
            df.cL().f(a3, this.b);
        }
    }
}
