package com.voximplant.sdk.internal.proto;

import com.google.gson.annotations.Expose;
public class WSMessageChat extends WSMessage {
    @Expose
    public Object payload;
    @Expose
    public String request_uuid;
    @Expose
    public final String service = "chat";

    public WSMessageChat() {
        this.params = null;
    }
}
