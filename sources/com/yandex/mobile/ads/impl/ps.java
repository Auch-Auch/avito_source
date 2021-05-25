package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.support.annotation.NonNull;
import com.avito.android.util.preferences.db_preferences.Types;
import com.yandex.mobile.ads.nativeads.z;
import org.json.JSONException;
import org.json.JSONObject;
public final class ps {
    @NonNull
    private final Context a;
    @NonNull
    private final pu b;

    public ps(@NonNull Context context, @NonNull pu puVar) {
        this.a = context.getApplicationContext();
        this.b = puVar;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @NonNull
    public final oq a(@NonNull JSONObject jSONObject) throws JSONException, z {
        char c;
        boolean z;
        char c2;
        qe qeVar;
        if (pq.a(jSONObject, "name", "type", "clickable", "required", "value")) {
            String a3 = pp.a(jSONObject, "type");
            String a4 = pp.a(jSONObject, "name");
            a4.hashCode();
            switch (a4.hashCode()) {
                case -1074675180:
                    if (a4.equals("favicon")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case -938102371:
                    if (a4.equals("rating")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case -807286424:
                    if (a4.equals("review_count")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case -191501435:
                    if (a4.equals("feedback")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case 3226745:
                    if (a4.equals("icon")) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case 103772132:
                    if (a4.equals("media")) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            switch (c) {
                case 0:
                case 3:
                case 4:
                    z = "image".equals(a3);
                    break;
                case 1:
                case 2:
                    z = "number".equals(a3);
                    break;
                case 5:
                    z = "media".equals(a3);
                    break;
                default:
                    z = Types.STRING.equals(a3);
                    break;
            }
            if (z) {
                JSONObject optJSONObject = jSONObject.optJSONObject("link");
                ou a5 = optJSONObject != null ? this.b.a(optJSONObject) : null;
                Context context = this.a;
                switch (a4.hashCode()) {
                    case -1678958759:
                        if (a4.equals("close_button")) {
                            c2 = 0;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -1074675180:
                        if (a4.equals("favicon")) {
                            c2 = 1;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -938102371:
                        if (a4.equals("rating")) {
                            c2 = 2;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -807286424:
                        if (a4.equals("review_count")) {
                            c2 = 3;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -191501435:
                        if (a4.equals("feedback")) {
                            c2 = 4;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 3226745:
                        if (a4.equals("icon")) {
                            c2 = 5;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 103772132:
                        if (a4.equals("media")) {
                            c2 = 6;
                            break;
                        }
                        c2 = 65535;
                        break;
                    default:
                        c2 = 65535;
                        break;
                }
                switch (c2) {
                    case 0:
                        qeVar = new qf();
                        break;
                    case 1:
                    case 5:
                        qeVar = new qh(context);
                        break;
                    case 2:
                    case 3:
                        qeVar = new qj();
                        break;
                    case 4:
                        qeVar = new qg(new qh(context));
                        break;
                    case 6:
                        qeVar = new qi(context);
                        break;
                    default:
                        qeVar = new ql();
                        break;
                }
                return new oq(a4, a3, qeVar.a(jSONObject), a5, jSONObject.getBoolean("clickable"), jSONObject.getBoolean("required"));
            }
            throw new z("Native Ad json has not required attributes");
        }
        throw new z("Native Ad json has not required attributes");
    }
}
