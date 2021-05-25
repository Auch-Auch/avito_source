package a2.l.a;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.my.target.by;
import com.my.target.hx;
import com.my.target.ip;
import java.util.WeakHashMap;
public class p implements ip.a {
    public final /* synthetic */ by a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ hx c;

    public p(hx hxVar, by byVar, Context context) {
        this.c = hxVar;
        this.a = byVar;
        this.b = context;
    }

    @Override // com.my.target.ip.a
    public void ac(@Nullable String str) {
        if (!TextUtils.isEmpty(str)) {
            hx hxVar = this.c;
            by byVar = this.a;
            Context context = this.b;
            WeakHashMap<by, Boolean> weakHashMap = hx.a;
            hxVar.b(str, byVar, context);
        }
        hx.a.remove(this.a);
    }
}
