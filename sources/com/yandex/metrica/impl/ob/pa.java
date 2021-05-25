package com.yandex.metrica.impl.ob;

import android.annotation.TargetApi;
import android.content.pm.FeatureInfo;
import android.support.annotation.NonNull;
public abstract class pa {

    public static class a {
        public static pa a() {
            if (dl.a(24)) {
                return new b();
            }
            return new c();
        }
    }

    public static class b extends pa {
        @Override // com.yandex.metrica.impl.ob.pa
        @TargetApi(24)
        public pb a(@NonNull FeatureInfo featureInfo) {
            return new pb(featureInfo.name, featureInfo.version, c(featureInfo));
        }
    }

    public static class c extends pa {
        @Override // com.yandex.metrica.impl.ob.pa
        public pb a(@NonNull FeatureInfo featureInfo) {
            return new pb(featureInfo.name, c(featureInfo));
        }
    }

    public abstract pb a(FeatureInfo featureInfo);

    public pb b(@NonNull FeatureInfo featureInfo) {
        if (featureInfo.name != null) {
            return a(featureInfo);
        }
        int i = featureInfo.reqGlEsVersion;
        if (i == 0) {
            return a(featureInfo);
        }
        return new pb("openGlFeature", i, c(featureInfo));
    }

    public boolean c(FeatureInfo featureInfo) {
        return (featureInfo.flags & 1) != 0;
    }
}
