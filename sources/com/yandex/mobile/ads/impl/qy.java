package com.yandex.mobile.ads.impl;

import android.annotation.TargetApi;
import android.support.annotation.NonNull;
import android.view.MenuItem;
import android.widget.PopupMenu;
import com.yandex.mobile.ads.impl.hv;
import com.yandex.mobile.ads.impl.pc;
import com.yandex.mobile.ads.nativeads.r;
import java.util.List;
@TargetApi(11)
public final class qy implements PopupMenu.OnMenuItemClickListener {
    @NonNull
    private final cq a;
    @NonNull
    private final dg b;
    @NonNull
    private final List<pc.a> c;
    @NonNull
    private final r d;

    public qy(@NonNull dg dgVar, @NonNull List<pc.a> list, @NonNull cq cqVar, @NonNull r rVar) {
        this.c = list;
        this.b = dgVar;
        this.a = cqVar;
        this.d = rVar;
    }

    @Override // android.widget.PopupMenu.OnMenuItemClickListener
    public final boolean onMenuItemClick(@NonNull MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId >= this.c.size()) {
            return true;
        }
        this.b.a(this.c.get(itemId).b());
        this.a.a(hv.b.FEEDBACK);
        this.d.h();
        return true;
    }
}
