package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
public class vg extends ads<Void> {
    public vg(@NonNull final vl vlVar) {
        super(new adw<Void>() { // from class: com.yandex.metrica.impl.ob.vg.1
            public adu a(@Nullable Void r1) {
                if (vl.this.c()) {
                    return adu.a(this);
                }
                return adu.a(this, "YandexMetrica isn't initialized. Use YandexMetrica#activate(android.content.Context, String) method to activate.");
            }
        });
    }

    public adu a() {
        return super.a(null);
    }
}
