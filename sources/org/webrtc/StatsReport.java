package org.webrtc;

import a2.b.a.a.a;
public class StatsReport {
    public final String id;
    public final double timestamp;
    public final String type;
    public final Value[] values;

    public static class Value {
        public final String name;
        public final String value;

        @CalledByNative("Value")
        public Value(String str, String str2) {
            this.name = str;
            this.value = str2;
        }

        public String toString() {
            StringBuilder L = a.L("[");
            L.append(this.name);
            L.append(": ");
            return a.t(L, this.value, "]");
        }
    }

    @CalledByNative
    public StatsReport(String str, String str2, double d, Value[] valueArr) {
        this.id = str;
        this.type = str2;
        this.timestamp = d;
        this.values = valueArr;
    }

    public String toString() {
        StringBuilder L = a.L("id: ");
        L.append(this.id);
        L.append(", type: ");
        L.append(this.type);
        L.append(", timestamp: ");
        L.append(this.timestamp);
        L.append(", values: ");
        int i = 0;
        while (true) {
            Value[] valueArr = this.values;
            if (i >= valueArr.length) {
                return L.toString();
            }
            L.append(valueArr[i].toString());
            L.append(", ");
            i++;
        }
    }
}
