package com.yandex.metrica.impl.interact;

import android.content.Context;
import android.text.TextUtils;
import com.yandex.metrica.impl.ob.dr;
import com.yandex.metrica.impl.ob.zb;
import com.yandex.metrica.impl.ob.zk;
import com.yandex.metrica.impl.ob.zm;
import com.yandex.metrica.impl.ob.zn;
import java.util.HashMap;
import java.util.Map;
public class CellularNetworkInfo {
    public String a = "";

    public class a implements zn {
        public a() {
        }

        @Override // com.yandex.metrica.impl.ob.zn
        public void a(zm zmVar) {
            zb b = zmVar.b();
            if (b != null) {
                String g = b.g();
                String f = b.f();
                Integer c = b.c();
                Integer b2 = b.b();
                Integer e = b.e();
                Integer d = b.d();
                Integer a3 = b.a();
                HashMap hashMap = new HashMap();
                hashMap.put("network_type", g);
                hashMap.put("operator_name", f);
                String str = null;
                hashMap.put("country_code", b2 != null ? String.valueOf(b2) : null);
                hashMap.put("operator_id", c != null ? String.valueOf(c) : null);
                hashMap.put("cell_id", e != null ? String.valueOf(e) : null);
                hashMap.put("lac", d != null ? String.valueOf(d) : null);
                if (a3 != null) {
                    str = String.valueOf(a3);
                }
                hashMap.put("signal_strength", str);
                StringBuilder sb = new StringBuilder();
                String str2 = "";
                for (Map.Entry entry : hashMap.entrySet()) {
                    String str3 = (String) entry.getValue();
                    if (!TextUtils.isEmpty(str3)) {
                        sb.append(str2);
                        a2.b.a.a.a.m1(sb, (String) entry.getKey(), "=", str3);
                        str2 = "&";
                    }
                }
                CellularNetworkInfo.this.a = sb.toString();
            }
        }
    }

    public CellularNetworkInfo(Context context) {
        new zk(context, dr.k().b()).a(new a());
    }

    public String getCelluralInfo() {
        return this.a;
    }
}
