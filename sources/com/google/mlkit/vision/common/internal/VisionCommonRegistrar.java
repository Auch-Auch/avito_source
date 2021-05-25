package com.google.mlkit.vision.common.internal;

import a2.j.h.b.a.a.d;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.mlkit_vision_common.zzcm;
import com.google.android.gms.internal.mlkit_vision_common.zzco;
import com.google.android.gms.internal.mlkit_vision_common.zzcq;
import com.google.android.gms.internal.mlkit_vision_common.zzh;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.mlkit.vision.common.internal.MultiFlavorDetectorCreator;
import java.util.List;
@KeepForSdk
public class VisionCommonRegistrar implements ComponentRegistrar {
    @Override // com.google.firebase.components.ComponentRegistrar
    public List<Component<?>> getComponents() {
        return zzh.zza(zzco.zza, zzcm.zza, zzcq.zza, Component.builder(MultiFlavorDetectorCreator.class).add(Dependency.setOf(MultiFlavorDetectorCreator.Registration.class)).factory(d.a).build());
    }
}
