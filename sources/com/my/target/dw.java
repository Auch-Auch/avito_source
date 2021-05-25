package com.my.target;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.my.target.common.models.ImageData;
import org.json.JSONObject;
public class dw {
    @NonNull
    public final ct a;
    @NonNull
    public final dn b;

    public dw(@NonNull ct ctVar, @NonNull bp bpVar, @NonNull a aVar, @NonNull Context context) {
        this.a = ctVar;
        this.b = dn.c(bpVar, aVar, context);
    }

    public static dw a(@NonNull ct ctVar, @NonNull bp bpVar, @NonNull a aVar, @NonNull Context context) {
        return new dw(ctVar, bpVar, aVar, context);
    }

    public void a(@NonNull JSONObject jSONObject, @NonNull cj cjVar) {
        this.b.a(jSONObject, cjVar);
        cjVar.setHasNotification(jSONObject.optBoolean("hasNotification", cjVar.isHasNotification()));
        cjVar.setBanner(jSONObject.optBoolean("Banner", cjVar.isBanner()));
        cjVar.setRequireCategoryHighlight(jSONObject.optBoolean("RequireCategoryHighlight", cjVar.isRequireCategoryHighlight()));
        cjVar.setItemHighlight(jSONObject.optBoolean("ItemHighlight", cjVar.isItemHighlight()));
        cjVar.setMain(jSONObject.optBoolean("Main", cjVar.isMain()));
        cjVar.setRequireWifi(jSONObject.optBoolean("RequireWifi", cjVar.isRequireWifi()));
        cjVar.setSubItem(jSONObject.optBoolean("subitem", cjVar.isSubItem()));
        cjVar.setBubbleId(jSONObject.optString("bubble_id", cjVar.getBubbleId()));
        cjVar.setLabelType(jSONObject.optString("labelType", cjVar.getLabelType()));
        cjVar.setStatus(jSONObject.optString("status", cjVar.getStatus()));
        cjVar.setMrgsId(jSONObject.optInt("mrgs_id"));
        cjVar.setCoins(jSONObject.optInt("coins"));
        cjVar.setCoinsIconBgColor(dt.a(jSONObject, "coins_icon_bgcolor", cjVar.getCoinsIconBgColor()));
        cjVar.setCoinsIconTextColor(dt.a(jSONObject, "coins_icon_textcolor", cjVar.getCoinsIconTextColor()));
        String optString = jSONObject.optString("icon_hd");
        if (!TextUtils.isEmpty(optString)) {
            cjVar.setIcon(ImageData.newImageData(optString));
        }
        String optString2 = jSONObject.optString("coins_icon_hd");
        if (!TextUtils.isEmpty(optString2)) {
            cjVar.setCoinsIcon(ImageData.newImageData(optString2));
        }
        String optString3 = jSONObject.optString("cross_notif_icon_hd");
        if (!TextUtils.isEmpty(optString3)) {
            cjVar.setCrossNotifIcon(ImageData.newImageData(optString3));
        }
        String cl = this.a.cl();
        if (!TextUtils.isEmpty(cl)) {
            cjVar.setBubbleIcon(ImageData.newImageData(cl));
        }
        String cn = this.a.cn();
        if (!TextUtils.isEmpty(cn)) {
            cjVar.setGotoAppIcon(ImageData.newImageData(cn));
        }
        String cm = this.a.cm();
        if (!TextUtils.isEmpty(cm)) {
            cjVar.setLabelIcon(ImageData.newImageData(cm));
        }
        String status = cjVar.getStatus();
        if (status != null) {
            String G = this.a.G(status);
            if (!TextUtils.isEmpty(G)) {
                cjVar.setStatusIcon(ImageData.newImageData(G));
            }
        }
        String co = this.a.co();
        if (cjVar.isItemHighlight() && !TextUtils.isEmpty(co)) {
            cjVar.setItemHighlightIcon(ImageData.newImageData(co));
        }
    }
}
