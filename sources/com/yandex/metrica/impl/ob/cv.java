package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.util.Pair;
import com.yandex.metrica.Revenue;
import com.yandex.metrica.impl.ob.ux;
public class cv {
    @NonNull
    private final Revenue a;
    private final adn<String> b;
    private final adn<String> c;
    private final adn<String> d;
    @NonNull
    private final abl e;

    public cv(@NonNull Revenue revenue, @NonNull abl abl) {
        this.e = abl;
        this.a = revenue;
        this.b = new adk(30720, "revenue payload", abl);
        this.c = new adm(new adk(184320, "receipt data", abl), "<truncated data was not sent, see METRIKALIB-4568>");
        this.d = new adm(new adl(1000, "receipt signature", abl), "<truncated data was not sent, see METRIKALIB-4568>");
    }

    @NonNull
    public Pair<byte[], Integer> a() {
        ux uxVar = new ux();
        uxVar.d = this.a.currency.getCurrencyCode().getBytes();
        if (dl.a(this.a.price)) {
            uxVar.c = this.a.price.doubleValue();
        }
        if (dl.a(this.a.priceMicros)) {
            uxVar.h = this.a.priceMicros.longValue();
        }
        uxVar.e = dh.d(new adl(200, "revenue productID", this.e).a(this.a.productID));
        uxVar.b = ((Integer) abw.b(this.a.quantity, 1)).intValue();
        uxVar.f = dh.d(this.b.a(this.a.payload));
        int i = 0;
        if (dl.a(this.a.receipt)) {
            ux.a aVar = new ux.a();
            String a3 = this.c.a(this.a.receipt.data);
            if (adg.a(this.a.receipt.data, a3)) {
                i = this.a.receipt.data.length() + 0;
            }
            aVar.b = dh.d(a3);
            aVar.c = dh.d(this.d.a(this.a.receipt.signature));
            uxVar.g = aVar;
        }
        return new Pair<>(e.a(uxVar), Integer.valueOf(i));
    }
}
