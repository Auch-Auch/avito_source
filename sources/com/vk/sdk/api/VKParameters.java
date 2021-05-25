package com.vk.sdk.api;

import com.vk.sdk.util.VKUtil;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
public class VKParameters extends LinkedHashMap<String, Object> implements Serializable {
    private static final long serialVersionUID = -7183150344504033644L;

    public VKParameters() {
    }

    public static VKParameters from(Object... objArr) {
        return VKUtil.paramsFrom(objArr);
    }

    public VKParameters(Map<String, Object> map) {
        super(map);
    }
}
