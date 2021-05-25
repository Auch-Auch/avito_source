package com.voximplant.sdk.internal.proto;
public class M_unregisterPushToken extends WSMessagePush {
    public M_unregisterPushToken(String str, String str2) {
        this.params.add(str);
        this.params.add(str2);
    }

    @Override // com.voximplant.sdk.internal.proto.WSMessagePush
    public String getRequestUUID() {
        if (this.params.size() > 1) {
            return (String) this.params.get(1);
        }
        return null;
    }
}
