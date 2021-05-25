package com.facebook.appevents.aam;

import androidx.annotation.RestrictTo;
import com.facebook.internal.instrument.crashshield.AutoHandleExceptions;
import com.vk.sdk.api.VKApiConst;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@AutoHandleExceptions
public final class MetadataRule {
    public static final Set<MetadataRule> d = new HashSet();
    public String a;
    public List<String> b;
    public String c;

    public MetadataRule(String str, List<String> list, String str2) {
        this.a = str;
        this.b = list;
        this.c = str2;
    }

    public static void a(JSONObject jSONObject) {
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            JSONObject optJSONObject = jSONObject.optJSONObject(next);
            if (optJSONObject != null) {
                String optString = optJSONObject.optString("k");
                String optString2 = optJSONObject.optString(VKApiConst.VERSION);
                if (!optString.isEmpty()) {
                    d.add(new MetadataRule(next, Arrays.asList(optString.split(",")), optString2));
                }
            }
        }
    }

    public static Set<String> getEnabledRuleNames() {
        HashSet hashSet = new HashSet();
        for (MetadataRule metadataRule : d) {
            hashSet.add(metadataRule.a);
        }
        return hashSet;
    }
}
