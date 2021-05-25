package com.my.target;

import androidx.annotation.NonNull;
import com.my.target.en;
import com.my.target.hb;
import java.util.ArrayList;
import java.util.List;
public class ed {
    @NonNull
    public final gs a;
    @NonNull
    public final ArrayList<cb> b = new ArrayList<>();
    public en.b c;

    public class b implements hb.a {
        public b(a aVar) {
        }

        @Override // com.my.target.hb.a
        public void a(@NonNull cb cbVar) {
            ed edVar = ed.this;
            en.b bVar = edVar.c;
            if (bVar != null) {
                bVar.b(cbVar, null, edVar.a.getView().getContext());
            }
        }

        @Override // com.my.target.hb.a
        public void d(@NonNull List<cb> list) {
            for (cb cbVar : list) {
                if (!ed.this.b.contains(cbVar)) {
                    ed.this.b.add(cbVar);
                    im.a(cbVar.getStatHolder().K("playbackStarted"), ed.this.a.getView().getContext());
                    im.a(cbVar.getStatHolder().K("show"), ed.this.a.getView().getContext());
                }
            }
        }
    }

    public ed(@NonNull List<cb> list, @NonNull hb hbVar) {
        this.a = hbVar;
        hbVar.setCarouselListener(new b(null));
        int[] numbersOfCurrentShowingCards = hbVar.getNumbersOfCurrentShowingCards();
        for (int i : numbersOfCurrentShowingCards) {
            if (i < list.size() && i >= 0) {
                cb cbVar = list.get(i);
                this.b.add(cbVar);
                im.a(cbVar.getStatHolder().K("playbackStarted"), hbVar.getView().getContext());
            }
        }
    }

    public static ed a(@NonNull List<cb> list, @NonNull hb hbVar) {
        return new ed(list, hbVar);
    }

    public void a(en.b bVar) {
        this.c = bVar;
    }
}
