package com.my.target;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.GravityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.my.target.hd;
import com.my.target.ht;
import com.my.target.hu;
public class hv extends FrameLayout implements hd.a, ht.a, hu {
    @NonNull
    public final hd a;
    @NonNull
    public final LinearLayoutManager b;
    @NonNull
    public final hc c;
    @Nullable
    public hu.a d;

    public hv(@NonNull Context context) {
        super(context);
        hd hdVar = new hd(context);
        this.a = hdVar;
        ht htVar = new ht(context);
        htVar.I = this;
        hdVar.setLayoutManager(htVar);
        this.b = htVar;
        hc hcVar = new hc(17);
        this.c = hcVar;
        hcVar.attachToRecyclerView(hdVar);
        hdVar.setHasFixedSize(true);
        hdVar.setMoveStopListener(this);
        addView(hdVar, new FrameLayout.LayoutParams(-1, -1));
    }

    @Override // com.my.target.hu
    public boolean H(int i) {
        return i >= this.b.findFirstCompletelyVisibleItemPosition() && i <= this.b.findLastCompletelyVisibleItemPosition();
    }

    @Override // com.my.target.hu
    public void I(int i) {
        this.c.smoothScrollToPosition(i);
    }

    public final void a() {
        int[] iArr;
        if (this.d != null) {
            int findFirstVisibleItemPosition = this.b.findFirstVisibleItemPosition();
            int findLastVisibleItemPosition = this.b.findLastVisibleItemPosition();
            if (findFirstVisibleItemPosition >= 0 && findLastVisibleItemPosition >= 0) {
                if (iq.l(this.b.findViewByPosition(findFirstVisibleItemPosition)) < 50.0d) {
                    findFirstVisibleItemPosition++;
                }
                if (iq.l(this.b.findViewByPosition(findLastVisibleItemPosition)) < 50.0d) {
                    findLastVisibleItemPosition--;
                }
                if (findFirstVisibleItemPosition <= findLastVisibleItemPosition) {
                    if (findFirstVisibleItemPosition == findLastVisibleItemPosition) {
                        iArr = new int[]{findFirstVisibleItemPosition};
                    } else {
                        int i = (findLastVisibleItemPosition - findFirstVisibleItemPosition) + 1;
                        int[] iArr2 = new int[i];
                        for (int i2 = 0; i2 < i; i2++) {
                            iArr2[i2] = findFirstVisibleItemPosition;
                            findFirstVisibleItemPosition++;
                        }
                        iArr = iArr2;
                    }
                    this.d.a(iArr);
                }
            }
        }
    }

    @Override // com.my.target.ht.a
    public void eA() {
        int i;
        hc hcVar;
        int findFirstCompletelyVisibleItemPosition = this.b.findFirstCompletelyVisibleItemPosition();
        View findViewByPosition = findFirstCompletelyVisibleItemPosition >= 0 ? this.b.findViewByPosition(findFirstCompletelyVisibleItemPosition) : null;
        if (this.a.getChildCount() == 0 || findViewByPosition == null || ((double) getWidth()) > ((double) findViewByPosition.getWidth()) * 1.7d) {
            hcVar = this.c;
            i = GravityCompat.START;
        } else {
            hcVar = this.c;
            i = 17;
        }
        hcVar.setGravity(i);
        a();
    }

    @Override // com.my.target.hd.a
    public void eo() {
        a();
    }

    public void setAdapter(@NonNull hp hpVar) {
        this.a.setAdapter(hpVar);
    }

    @Override // com.my.target.hu
    public void setListener(@NonNull hu.a aVar) {
        this.d = aVar;
    }
}
