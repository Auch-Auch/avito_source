package com.yandex.runtime.sensors.internal.telephony;

import com.yandex.runtime.bindings.Archive;
import com.yandex.runtime.bindings.Serializable;
public class GsmCellInfo implements Serializable {
    private static final int UNKNOWN_ASU = 99;
    private Integer cid;
    private Integer lac;
    private String networkType;
    private Integer strength;

    public GsmCellInfo(int i, int i2, String str, int i3) {
        Integer num;
        this.cid = getCheckedValue(i);
        this.lac = getCheckedValue(i2);
        this.networkType = str;
        if (99 == i3) {
            num = null;
        } else {
            num = new Integer(asuToDbm(i3));
        }
        this.strength = num;
    }

    private static int asuToDbm(int i) {
        return (i * 2) - 113;
    }

    private static Integer getCheckedValue(int i) {
        return new Integer(i);
    }

    @Override // com.yandex.runtime.bindings.Serializable
    public void serialize(Archive archive) {
        this.cid = archive.add(this.cid, false);
        this.lac = archive.add(this.lac, false);
        this.networkType = archive.add(this.networkType, false);
        this.strength = archive.add(this.strength, true);
    }
}
