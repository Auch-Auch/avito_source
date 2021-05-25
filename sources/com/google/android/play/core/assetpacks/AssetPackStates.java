package com.google.android.play.core.assetpacks;

import a2.j.b.e.a.b.g0;
import a2.j.b.e.a.b.t0;
import a2.j.b.e.a.b.x;
import a2.j.b.e.a.b.z;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public abstract class AssetPackStates {
    public static AssetPackStates a(long j, Map<String, AssetPackState> map) {
        return new g0(j, map);
    }

    public static AssetPackStates a(Bundle bundle, t0 t0Var) {
        return a(bundle, t0Var, new ArrayList());
    }

    public static AssetPackStates a(Bundle bundle, t0 t0Var, x xVar) {
        return b(bundle, t0Var, new ArrayList(), xVar);
    }

    public static AssetPackStates a(Bundle bundle, t0 t0Var, List<String> list) {
        return b(bundle, t0Var, list, z.a);
    }

    public static AssetPackStates b(Bundle bundle, t0 t0Var, List<String> list, x xVar) {
        ArrayList<String> stringArrayList = bundle.getStringArrayList("pack_names");
        HashMap hashMap = new HashMap();
        int size = stringArrayList.size();
        for (int i = 0; i < size; i++) {
            String str = stringArrayList.get(i);
            hashMap.put(str, AssetPackState.a(bundle, str, t0Var, xVar));
        }
        int size2 = list.size();
        for (int i2 = 0; i2 < size2; i2++) {
            String str2 = list.get(i2);
            hashMap.put(str2, AssetPackState.a(str2, 4, 0, 0, 0, 0.0d));
        }
        return a(bundle.getLong("total_bytes_to_download"), hashMap);
    }

    public abstract Map<String, AssetPackState> packStates();

    public abstract long totalBytes();
}
