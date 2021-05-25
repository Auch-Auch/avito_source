package com.my.target;

import a2.l.a.o;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
public class hp extends RecyclerView.Adapter<o> {
    @NonNull
    public final List<ek> c;
    @NonNull
    public final he d;

    public hp(@NonNull List<ek> list, @NonNull he heVar) {
        this.c = list;
        this.d = heVar;
    }

    /* renamed from: a */
    public void onViewRecycled(@NonNull o oVar) {
        ek ekVar = oVar.t;
        if (ekVar != null) {
            ekVar.a(oVar.s);
        }
        oVar.t = null;
        super.onViewRecycled(oVar);
    }

    /* renamed from: b */
    public boolean onFailedToRecycleView(@NonNull o oVar) {
        ek ekVar = oVar.t;
        if (ekVar != null) {
            ekVar.a(oVar.s);
        }
        oVar.t = null;
        return super.onFailedToRecycleView(oVar);
    }

    @NonNull
    /* renamed from: c */
    public o onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        hq es = this.d.es();
        es.eu().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        return new o(es);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.c.size();
    }

    /* renamed from: a */
    public void onBindViewHolder(@NonNull o oVar, int i) {
        ek ekVar = this.c.get(i);
        oVar.t = ekVar;
        ekVar.a(oVar.s, i);
    }
}
