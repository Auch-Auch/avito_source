package com.voximplant.sdk.internal.proto;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Arrays;
public class WSMessage {
    @SerializedName("params")
    public ArrayList params;

    public WSMessage() {
        this.params = new ArrayList();
    }

    public String callId() {
        if (this.params.isEmpty()) {
            return null;
        }
        return (String) this.params.get(0);
    }

    public WSMessage(ArrayList arrayList) {
        this.params = arrayList;
    }

    public WSMessage(String[] strArr) {
        this.params = new ArrayList(Arrays.asList(strArr));
    }
}
