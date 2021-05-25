package l6.d.a;

import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
@RequiresApi(21)
public class a implements c {
    public final d a(b bVar) {
        return (d) ((CardView.a) bVar).a;
    }

    public void b(b bVar, float f) {
        d a = a(bVar);
        CardView.a aVar = (CardView.a) bVar;
        boolean useCompatPadding = CardView.this.getUseCompatPadding();
        boolean a3 = aVar.a();
        if (!(f == a.e && a.f == useCompatPadding && a.g == a3)) {
            a.e = f;
            a.f = useCompatPadding;
            a.g = a3;
            a.c(null);
            a.invalidateSelf();
        }
        c(bVar);
    }

    public void c(b bVar) {
        CardView.a aVar = (CardView.a) bVar;
        if (!CardView.this.getUseCompatPadding()) {
            aVar.b(0, 0, 0, 0);
            return;
        }
        float f = a(bVar).e;
        float f2 = a(bVar).a;
        int ceil = (int) Math.ceil((double) e.a(f, f2, aVar.a()));
        int ceil2 = (int) Math.ceil((double) e.b(f, f2, aVar.a()));
        aVar.b(ceil, ceil2, ceil, ceil2);
    }
}
