package com.google.mlkit.vision.face.internal;

import a2.j.h.b.b.a.d;
import a2.j.h.b.b.a.e;
import android.content.Context;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.mlkit_vision_face.zzaq;
import com.google.android.gms.internal.mlkit_vision_face.zzeh;
import com.google.android.gms.internal.mlkit_vision_face.zzej;
import com.google.android.gms.internal.mlkit_vision_face.zzel;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.mlkit.common.sdkinternal.ExecutorSelector;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.vision.face.internal.FaceDetectorImpl;
import java.util.List;
@KeepForSdk
public class FaceRegistrar implements ComponentRegistrar {
    @Override // com.google.firebase.components.ComponentRegistrar
    public List<Component<?>> getComponents() {
        return zzaq.zza(zzej.zza, zzeh.zza, zzel.zza, Component.builder(zzc.class).add(Dependency.required(MlKitContext.class)).factory(d.a).build(), Component.builder(FaceDetectorImpl.zza.class).add(Dependency.required(Context.class)).add(Dependency.required(zzel.class)).add(Dependency.required(ExecutorSelector.class)).factory(e.a).build());
    }
}
