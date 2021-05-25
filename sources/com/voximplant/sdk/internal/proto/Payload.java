package com.voximplant.sdk.internal.proto;

import com.google.gson.JsonElement;
import com.google.gson.annotations.Expose;
public class Payload {
    @Expose
    public Integer code = null;
    @Expose
    public Integer count = null;
    @Expose
    public String description = null;
    @Expose
    public Long from_seq = null;
    @Expose
    public Long initiator = null;
    @Expose
    public JsonElement object = null;
    @Expose
    public String on_incoming_event = null;
    @Expose
    public Long seq = null;
    @Expose
    public Long timestamp = null;
    @Expose
    public Long to_seq = null;
}
