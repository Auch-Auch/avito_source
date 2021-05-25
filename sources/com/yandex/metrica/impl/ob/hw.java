package com.yandex.metrica.impl.ob;

import android.content.pm.FeatureInfo;
import android.content.pm.PackageInfo;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.text.TextUtils;
import com.yandex.metrica.impl.ob.pa;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
public class hw extends hu {
    @NonNull
    private final ado a;

    public hw(fe feVar) {
        this(feVar, new ado());
    }

    @Override // com.yandex.metrica.impl.ob.hq
    public boolean a(@NonNull aa aaVar) {
        fe a3 = a();
        if (!a3.u().d() || !a3.t()) {
            return false;
        }
        mo y = a3.y();
        HashSet<pb> b = b();
        try {
            ArrayList<pb> c = c();
            if (aav.a(b, c)) {
                a3.m();
                return false;
            }
            JSONArray jSONArray = new JSONArray();
            Iterator<pb> it = c.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().a());
            }
            a3.e().d(aa.a(aaVar, new JSONObject().put("features", jSONArray).toString()));
            y.b(jSONArray.toString());
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    @VisibleForTesting
    @Nullable
    public HashSet<pb> b() {
        String e = a().y().e();
        if (TextUtils.isEmpty(e)) {
            return null;
        }
        try {
            HashSet<pb> hashSet = new HashSet<>();
            JSONArray jSONArray = new JSONArray(e);
            for (int i = 0; i < jSONArray.length(); i++) {
                hashSet.add(new pb(jSONArray.getJSONObject(i)));
            }
            return hashSet;
        } catch (Throwable unused) {
            return null;
        }
    }

    @VisibleForTesting
    @Nullable
    public ArrayList<pb> c() {
        FeatureInfo[] featureInfoArr;
        try {
            fe a3 = a();
            PackageInfo a4 = this.a.a(a3.k(), a3.k().getPackageName(), 16384);
            ArrayList<pb> arrayList = new ArrayList<>();
            pa a5 = pa.a.a();
            if (!(a4 == null || (featureInfoArr = a4.reqFeatures) == null)) {
                for (FeatureInfo featureInfo : featureInfoArr) {
                    arrayList.add(a5.b(featureInfo));
                }
            }
            return arrayList;
        } catch (Throwable unused) {
            return null;
        }
    }

    @VisibleForTesting
    public hw(fe feVar, @NonNull ado ado) {
        super(feVar);
        this.a = ado;
    }
}
