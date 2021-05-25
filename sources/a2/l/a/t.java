package a2.l.a;

import android.content.Context;
import com.my.target.cy;
import com.my.target.df;
import com.my.target.im;
import java.util.List;
public class t implements Runnable {
    public final /* synthetic */ List a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ im c;

    public t(im imVar, List list, Context context) {
        this.c = imVar;
        this.a = list;
        this.b = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        df cL = df.cL();
        for (cy cyVar : this.a) {
            im.b(this.c, cyVar);
            String a3 = this.c.a(cyVar.getUrl(), cyVar.cw());
            if (a3 != null) {
                cL.f(a3, this.b);
            }
        }
    }
}
