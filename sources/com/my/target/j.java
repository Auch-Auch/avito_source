package com.my.target;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.my.target.common.models.AudioData;
import com.yandex.mobile.ads.video.models.vmap.AdBreak;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
public class j extends c<cp> {
    @NonNull
    public static c<cp> f() {
        return new j();
    }

    @Nullable
    public cp a(@NonNull String str, @NonNull bp bpVar, @Nullable cp cpVar, @NonNull a aVar, @NonNull Context context) {
        JSONObject optJSONObject;
        if (c.c(str)) {
            ec a = ec.a(aVar, bpVar);
            a.S(str);
            String bf = bpVar.bf();
            if (bf == null) {
                bf = AdBreak.BreakId.PREROLL;
            }
            if (cpVar == null) {
                cpVar = cp.bU();
            }
            cr<AudioData> w = cpVar.w(bf);
            if (w != null) {
                if (!a.cU().isEmpty()) {
                    int position = bpVar.getPosition();
                    Iterator it = a.cU().iterator();
                    while (it.hasNext()) {
                        cf<AudioData> cfVar = (cf) it.next();
                        float allowCloseDelay = bpVar.getAllowCloseDelay();
                        if (allowCloseDelay >= 0.0f) {
                            cfVar.setAllowCloseDelay(allowCloseDelay);
                        }
                        Boolean bg = bpVar.bg();
                        if (bg != null) {
                            cfVar.setAllowClose(bg.booleanValue());
                        }
                        Boolean bh = bpVar.bh();
                        if (bh != null) {
                            cfVar.setAllowPause(bh.booleanValue());
                        }
                        Boolean bi = bpVar.bi();
                        if (bi != null) {
                            cfVar.setAllowSeek(bi.booleanValue());
                        }
                        Boolean bj = bpVar.bj();
                        if (bj != null) {
                            cfVar.setAllowSkip(bj.booleanValue());
                        }
                        Boolean bk = bpVar.bk();
                        if (bk != null) {
                            cfVar.setAllowTrackChange(bk.booleanValue());
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
                        cfVar.setCloseActionText("Close");
                        float point = bpVar.getPoint();
                        if (point >= 0.0f) {
                            cfVar.setPoint(point);
                        }
                        float pointP = bpVar.getPointP();
                        if (pointP >= 0.0f) {
                            cfVar.setPointP(pointP);
                        }
                        if (position >= 0) {
                            w.a(cfVar, position);
                            position++;
                        } else {
                            w.g(cfVar);
                        }
                    }
                } else {
                    bp cV = a.cV();
                    if (cV != null) {
                        cV.r(w.getName());
                        int position2 = bpVar.getPosition();
                        if (position2 < 0) {
                            position2 = w.getBannersCount();
                        }
                        cV.setPosition(position2);
                        w.c(cV);
                    }
                }
            }
            return cpVar;
        }
        JSONObject a3 = a(str, context);
        if (!(a3 == null || (optJSONObject = a3.optJSONObject(aVar.getFormat())) == null)) {
            if (cpVar == null) {
                cpVar = cp.bU();
            }
            dq.cS().a(optJSONObject, cpVar);
            dl a4 = dl.a(bpVar, aVar, context);
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("sections");
            if (optJSONObject2 != null) {
                String bf2 = bpVar.bf();
                if (bf2 != null) {
                    cr<AudioData> w2 = cpVar.w(bf2);
                    if (w2 != null) {
                        d(optJSONObject2, a4, w2, dm.b(bpVar, aVar, context), bpVar);
                    }
                } else {
                    Iterator<cr<AudioData>> it2 = cpVar.bV().iterator();
                    while (it2.hasNext()) {
                        d(optJSONObject2, a4, it2.next(), dm.b(bpVar, aVar, context), bpVar);
                    }
                }
            }
        }
        return cpVar;
    }

    public final void d(@NonNull JSONObject jSONObject, @NonNull dl dlVar, @NonNull cr<AudioData> crVar, @NonNull dm dmVar, @NonNull bp bpVar) {
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
                        cf<AudioData> newAudioBanner = cf.newAudioBanner();
                        if (dmVar.a(optJSONObject, newAudioBanner)) {
                            if (bpVar.ba()) {
                                newAudioBanner.setPoint(bpVar.getPoint());
                                newAudioBanner.setPointP(bpVar.getPointP());
                            }
                            if (position >= 0) {
                                crVar.a(newAudioBanner, position);
                                position++;
                            } else {
                                crVar.g(newAudioBanner);
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
}
