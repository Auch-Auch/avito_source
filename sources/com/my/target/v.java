package com.my.target;

import android.content.Context;
import androidx.annotation.NonNull;
import com.my.target.e;
import java.util.Map;
public class v extends e.a {
    @NonNull
    public static v k() {
        return new v();
    }

    @Override // com.my.target.e.a
    public int b(@NonNull a aVar, @NonNull Context context) {
        return ij.ad(context).getFlags();
    }

    @Override // com.my.target.e.a
    @NonNull
    public Map<String, String> c(@NonNull a aVar, @NonNull Context context) {
        Map<String, String> c = super.c(aVar, context);
        Map<String, String> snapshot = cs.cf().snapshot();
        if (snapshot != null && snapshot.size() > 0) {
            StringBuilder sb = new StringBuilder();
            boolean z = false;
            for (String str : snapshot.keySet()) {
                if (z) {
                    sb.append(",");
                } else {
                    z = true;
                }
                sb.append(str);
            }
            String sb2 = sb.toString();
            c.put("exb", sb2);
            ae.a("Exclude list: " + sb2);
        }
        return c;
    }
}
