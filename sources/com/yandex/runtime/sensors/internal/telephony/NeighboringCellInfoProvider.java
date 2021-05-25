package com.yandex.runtime.sensors.internal.telephony;

import android.telephony.NeighboringCellInfo;
import android.telephony.TelephonyManager;
import com.yandex.runtime.Runtime;
import java.util.ArrayList;
import java.util.List;
public class NeighboringCellInfoProvider {
    public static List<GsmCellInfo> getNeighboringCellInfoGsm() {
        try {
            List<NeighboringCellInfo> neighboringCellInfo = ((TelephonyManager) Runtime.getApplicationContext().getSystemService("phone")).getNeighboringCellInfo();
            ArrayList arrayList = new ArrayList();
            if (neighboringCellInfo != null) {
                for (NeighboringCellInfo neighboringCellInfo2 : neighboringCellInfo) {
                    String networkTypeString = TelephonyUtils.getNetworkTypeString(neighboringCellInfo2.getNetworkType());
                    if (networkTypeString != null && TelephonyUtils.isKnown(neighboringCellInfo2.getCid()) && TelephonyUtils.isKnown(neighboringCellInfo2.getLac())) {
                        arrayList.add(new GsmCellInfo(neighboringCellInfo2.getCid(), neighboringCellInfo2.getLac(), networkTypeString, neighboringCellInfo2.getRssi()));
                    }
                }
            }
            return arrayList;
        } catch (Exception unused) {
            return new ArrayList();
        }
    }
}
