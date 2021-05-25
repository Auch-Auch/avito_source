package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.Menu;
import android.widget.Button;
import android.widget.PopupMenu;
import com.yandex.mobile.ads.impl.pc;
import com.yandex.mobile.ads.nativeads.ag;
import com.yandex.mobile.ads.nativeads.r;
import java.util.List;
public final class qx {
    @NonNull
    private final fo a;
    @NonNull
    private final cq b;
    @NonNull
    private final ag c;
    @NonNull
    private final qw d = new qw();
    @NonNull
    private final r e;

    public qx(@NonNull fo foVar, @NonNull cq cqVar, @NonNull ag agVar, @NonNull r rVar) {
        this.a = foVar;
        this.b = cqVar;
        this.c = agVar;
        this.e = rVar;
    }

    public final void a(@NonNull Context context, @NonNull pc pcVar) {
        Button h = this.c.d().h();
        if (h != null) {
            List<pc.a> b2 = pcVar.b();
            if (!b2.isEmpty()) {
                try {
                    dg dgVar = new dg(context, this.a);
                    PopupMenu popupMenu = new PopupMenu(context, h, 5);
                    Menu menu = popupMenu.getMenu();
                    for (int i = 0; i < b2.size(); i++) {
                        menu.add(0, i, 0, b2.get(i).a());
                    }
                    popupMenu.setOnMenuItemClickListener(new qy(dgVar, b2, this.b, this.e));
                    popupMenu.show();
                } catch (Exception unused) {
                }
            }
        }
    }
}
