package com.my.target;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.my.target.common.models.VideoData;
import com.yandex.mobile.ads.video.models.vmap.AdBreak;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
public class g extends c<co> {
    @NonNull
    public static c<co> f() {
        return new g();
    }

    @Nullable
    public co a(@NonNull String str, @NonNull bp bpVar, @Nullable co coVar, @NonNull a aVar, @NonNull Context context) {
        JSONObject optJSONObject;
        if (c.c(str)) {
            return e(str, bpVar, coVar, aVar);
        }
        JSONObject a = a(str, context);
        if (!(a == null || (optJSONObject = a.optJSONObject(aVar.getFormat())) == null)) {
            if (coVar == null) {
                coVar = co.bR();
            }
            dp.cR().a(optJSONObject, coVar);
            dl a3 = dl.a(bpVar, aVar, context);
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("sections");
            if (optJSONObject2 != null) {
                String bf = bpVar.bf();
                if (bf != null) {
                    cr<VideoData> v = coVar.v(bf);
                    if (v != null) {
                        d(optJSONObject2, a3, v, Cdo.d(bpVar, aVar, context), bpVar);
                    }
                } else {
                    Iterator<cr<VideoData>> it = coVar.bS().iterator();
                    while (it.hasNext()) {
                        d(optJSONObject2, a3, it.next(), Cdo.d(bpVar, aVar, context), bpVar);
                    }
                }
            }
        }
        return coVar;
    }

    public final void d(@NonNull JSONObject jSONObject, @NonNull dl dlVar, @NonNull cr<VideoData> crVar, @NonNull Cdo doVar, @NonNull bp bpVar) {
        JSONArray optJSONArray = jSONObject.optJSONArray(crVar.getName());
        if (optJSONArray != null) {
            int position = bpVar.getPosition();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    if ("additionalData".equals(optJSONObject.optString("type"))) {
                        bp d = dlVar.d(optJSONObject);
                        if (d != null) {
                            d.r(crVar.getName());
                            if (d.aZ() != -1) {
                                arrayList.add(d);
                            } else {
                                arrayList2.add(d);
                                if (!d.ba() && !d.aY()) {
                                    bpVar.b(d);
                                    int position2 = bpVar.getPosition();
                                    if (position2 < 0) {
                                        position2 = crVar.getBannersCount();
                                    }
                                    d.setPosition(position2);
                                }
                                crVar.c(d);
                            }
                        }
                    } else {
                        cf<VideoData> newVideoBanner = cf.newVideoBanner();
                        if (doVar.a(optJSONObject, newVideoBanner)) {
                            float point = bpVar.getPoint();
                            if (point >= 0.0f) {
                                newVideoBanner.setPoint(point);
                            }
                            float pointP = bpVar.getPointP();
                            if (pointP >= 0.0f) {
                                newVideoBanner.setPointP(pointP);
                            }
                            if (position >= 0) {
                                crVar.a(newVideoBanner, position);
                                position++;
                            } else {
                                crVar.g(newVideoBanner);
                            }
                        }
                    }
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                bp bpVar2 = (bp) it.next();
                Iterator it2 = arrayList2.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    bp bpVar3 = (bp) it2.next();
                    if (bpVar2.aZ() == bpVar3.getId()) {
                        bpVar3.a(bpVar2);
                        break;
                    }
                }
            }
        }
    }

    @NonNull
    public final co e(@NonNull String str, @NonNull bp bpVar, @Nullable co coVar, @NonNull a aVar) {
        ec a = ec.a(aVar, bpVar);
        a.S(str);
        String bf = bpVar.bf();
        if (bf == null) {
            bf = AdBreak.BreakId.PREROLL;
        }
        if (coVar == null) {
            coVar = co.bR();
        }
        cr<VideoData> v = coVar.v(bf);
        if (v == null) {
            return coVar;
        }
        if (!a.cU().isEmpty()) {
            int position = bpVar.getPosition();
            Iterator it = a.cU().iterator();
            while (it.hasNext()) {
                cf<VideoData> cfVar = (cf) it.next();
                Boolean bg = bpVar.bg();
                if (bg != null) {
                    cfVar.setAllowClose(bg.booleanValue());
                }
                Boolean bh = bpVar.bh();
                if (bh != null) {
                    cfVar.setAllowPause(bh.booleanValue());
                }
                Boolean bm = bpVar.bm();
                if (bm != null) {
                    cfVar.setDirectLink(bm.booleanValue());
                }
                Boolean bn = bpVar.bn();
                if (bn != null) {
                    cfVar.setOpenInBrowser(bn.booleanValue());
                }
                Boolean bo = bpVar.bo();
                if (bo != null) {
                    cfVar.setAllowReplay(bo.booleanValue());
                }
                float allowCloseDelay = bpVar.getAllowCloseDelay();
                if (allowCloseDelay >= 0.0f) {
                    cfVar.setAllowCloseDelay(allowCloseDelay);
                }
                cfVar.setCloseActionText("Close");
                cfVar.setPoint(bpVar.getPoint());
                cfVar.setPointP(bpVar.getPointP());
                if (position >= 0) {
                    v.a(cfVar, position);
                    position++;
                } else {
                    v.g(cfVar);
                }
            }
        } else {
            bp cV = a.cV();
            if (cV != null) {
                cV.r(v.getName());
                int position2 = bpVar.getPosition();
                if (position2 < 0) {
                    position2 = v.getBannersCount();
                }
                cV.setPosition(position2);
                v.c(cV);
            }
        }
        return coVar;
    }
}
