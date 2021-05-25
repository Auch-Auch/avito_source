package com.google.mlkit.vision.common.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.firebase.inject.Provider;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
@KeepForSdk
public class MultiFlavorDetectorCreator {
    public final Map<Class<? extends DetectorOptions<?>>, Provider<? extends DetectorCreator<?, ?>>> a = new HashMap();

    @KeepForSdk
    public interface DetectorCreator<ResultT, OptionsT extends DetectorOptions<ResultT>> {
        @KeepForSdk
        MobileVisionBase<ResultT> create(OptionsT optionst);
    }

    @KeepForSdk
    public interface DetectorOptions<ResultT> {
    }

    @KeepForSdk
    public static class Registration {
        public final Class<? extends DetectorOptions<?>> a;
        public final Provider<? extends DetectorCreator<?, ?>> b;
        public final int c;

        @KeepForSdk
        public <ResultT, OptionsT extends DetectorOptions<ResultT>> Registration(Class<? extends OptionsT> cls, Provider<? extends DetectorCreator<ResultT, OptionsT>> provider) {
            this(cls, provider, 100);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Class<? extends OptionsT extends com.google.mlkit.vision.common.internal.MultiFlavorDetectorCreator$DetectorOptions<ResultT>> */
        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.google.firebase.inject.Provider<? extends com.google.mlkit.vision.common.internal.MultiFlavorDetectorCreator$DetectorCreator<ResultT, OptionsT extends com.google.mlkit.vision.common.internal.MultiFlavorDetectorCreator$DetectorOptions<ResultT>>> */
        /* JADX WARN: Multi-variable type inference failed */
        @KeepForSdk
        public <ResultT, OptionsT extends DetectorOptions<ResultT>> Registration(Class<? extends OptionsT> cls, Provider<? extends DetectorCreator<ResultT, OptionsT>> provider, int i) {
            this.a = cls;
            this.b = provider;
            this.c = i;
        }
    }

    public MultiFlavorDetectorCreator(Set<Registration> set) {
        HashMap hashMap = new HashMap();
        for (Registration registration : set) {
            Class<? extends DetectorOptions<?>> cls = registration.a;
            if (!this.a.containsKey(cls) || registration.c >= ((Integer) hashMap.get(cls)).intValue()) {
                this.a.put(cls, registration.b);
                hashMap.put(cls, Integer.valueOf(registration.c));
            }
        }
    }

    @NonNull
    @KeepForSdk
    public static synchronized MultiFlavorDetectorCreator getInstance() {
        MultiFlavorDetectorCreator multiFlavorDetectorCreator;
        synchronized (MultiFlavorDetectorCreator.class) {
            multiFlavorDetectorCreator = (MultiFlavorDetectorCreator) MlKitContext.getInstance().get(MultiFlavorDetectorCreator.class);
        }
        return multiFlavorDetectorCreator;
    }

    @KeepForSdk
    public <ResultT, OptionsT extends DetectorOptions<ResultT>> MobileVisionBase<ResultT> create(OptionsT optionst) {
        return ((DetectorCreator) this.a.get(optionst.getClass()).get()).create(optionst);
    }
}
