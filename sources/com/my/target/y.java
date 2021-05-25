package com.my.target;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.my.target.common.models.ImageData;
import java.util.ArrayList;
public class y extends d<ct> {
    @NonNull
    public static y l() {
        return new y();
    }

    @Nullable
    public ct a(@NonNull ct ctVar, @NonNull a aVar, @NonNull Context context) {
        if (aVar.getCachePeriod() > 0 && !ctVar.isCached() && ctVar.ci() != null) {
            hy Z = hy.Z(context);
            int slotId = aVar.getSlotId();
            if (Z != null) {
                Z.a(slotId, ctVar.ci().toString(), false);
            } else {
                ae.a("unable to open disk cache and save data for slotId " + slotId);
            }
        }
        int cachePolicy = aVar.getCachePolicy();
        if (cachePolicy == 0 || cachePolicy == 1) {
            ArrayList arrayList = new ArrayList();
            for (cj cjVar : ctVar.ca()) {
                ImageData statusIcon = cjVar.getStatusIcon();
                ImageData coinsIcon = cjVar.getCoinsIcon();
                ImageData gotoAppIcon = cjVar.getGotoAppIcon();
                ImageData icon = cjVar.getIcon();
                ImageData labelIcon = cjVar.getLabelIcon();
                ImageData bubbleIcon = cjVar.getBubbleIcon();
                ImageData itemHighlightIcon = cjVar.getItemHighlightIcon();
                ImageData crossNotifIcon = cjVar.getCrossNotifIcon();
                if (statusIcon != null) {
                    arrayList.add(statusIcon);
                }
                if (coinsIcon != null) {
                    arrayList.add(coinsIcon);
                }
                if (gotoAppIcon != null) {
                    arrayList.add(gotoAppIcon);
                }
                if (icon != null) {
                    arrayList.add(icon);
                }
                if (labelIcon != null) {
                    arrayList.add(labelIcon);
                }
                if (bubbleIcon != null) {
                    arrayList.add(bubbleIcon);
                }
                if (itemHighlightIcon != null) {
                    arrayList.add(itemHighlightIcon);
                }
                if (crossNotifIcon != null) {
                    arrayList.add(crossNotifIcon);
                }
            }
            if (arrayList.size() > 0) {
                ia.g(arrayList).ab(context);
            }
        }
        return ctVar;
    }
}
