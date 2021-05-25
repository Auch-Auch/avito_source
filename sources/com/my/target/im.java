package com.my.target;

import a2.b.a.a.a;
import a2.l.a.s;
import a2.l.a.t;
import a2.l.a.u;
import android.content.Context;
import android.text.TextUtils;
import android.webkit.URLUtil;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;
import java.util.Objects;
public class im {
    public static final im a = new im();

    public static void a(@Nullable cy cyVar, @NonNull Context context) {
        im imVar = a;
        if (cyVar != null) {
            af.b(new s(imVar, cyVar, context.getApplicationContext()));
        }
    }

    public static void b(im imVar, cy cyVar) {
        String str;
        StringBuilder sb;
        Objects.requireNonNull(imVar);
        if (cyVar instanceof cx) {
            str = "tracking progress stat value:" + ((cx) cyVar).cu() + " url:" + cyVar.getUrl();
        } else {
            if (cyVar instanceof cw) {
                cw cwVar = (cw) cyVar;
                int cD = cwVar.cD();
                float cu = cwVar.cu();
                boolean ct = cwVar.ct();
                sb = new StringBuilder();
                sb.append("tracking ovv stat percent:");
                sb.append(cD);
                sb.append(" value:");
                sb.append(cu);
                sb.append(" ovv:");
                sb.append(ct);
            } else if (cyVar instanceof cv) {
                cv cvVar = (cv) cyVar;
                int cD2 = cvVar.cD();
                float cu2 = cvVar.cu();
                float duration = cvVar.getDuration();
                sb = new StringBuilder();
                sb.append("tracking mrc stat percent: value:");
                sb.append(cu2);
                sb.append(" percent ");
                sb.append(cD2);
                sb.append(" duration:");
                sb.append(duration);
            } else {
                StringBuilder L = a.L("tracking stat type:");
                L.append(cyVar.getType());
                L.append(" url:");
                L.append(cyVar.getUrl());
                str = L.toString();
            }
            sb.append(" url:");
            sb.append(cyVar.getUrl());
            str = sb.toString();
        }
        ae.a(str);
    }

    public static void o(@Nullable String str, @NonNull Context context) {
        im imVar = a;
        if (!TextUtils.isEmpty(str)) {
            af.b(new u(imVar, str, context.getApplicationContext()));
        }
    }

    @Nullable
    public String a(@NonNull String str, boolean z) {
        if (z) {
            str = ip.decode(str);
        }
        if (URLUtil.isNetworkUrl(str)) {
            return str;
        }
        a.U0("invalid stat url: ", str);
        return null;
    }

    public static void a(@Nullable List<cy> list, @NonNull Context context) {
        im imVar = a;
        if (list != null && list.size() > 0) {
            af.b(new t(imVar, list, context.getApplicationContext()));
        }
    }
}
