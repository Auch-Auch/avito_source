package com.google.android.datatransport.cct.a;

import a2.j.b.a.b.a.g;
import com.avito.android.inline_filters.analytics.VerticalFilterCloseDialogEventKt;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.config.Configurator;
import com.google.firebase.encoders.config.EncoderConfig;
import java.io.IOException;
import ru.sravni.android.bankproduct.analytic.v2.BaseAnalyticKt;
public final class zzb implements Configurator {
    public static final Configurator zza = new zzb();

    public static final class a implements ObjectEncoder<zza> {
        public static final a a = new a();

        @Override // com.google.firebase.encoders.ObjectEncoder
        public void encode(Object obj, Object obj2) throws IOException {
            zza zza = (zza) obj;
            ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
            objectEncoderContext.add("sdkVersion", zza.zzi());
            objectEncoderContext.add(VerticalFilterCloseDialogEventKt.MODEL_DIALOG, zza.zzf());
            objectEncoderContext.add("hardware", zza.zzd());
            objectEncoderContext.add("device", zza.zzb());
            objectEncoderContext.add(BaseAnalyticKt.ANALYTIC_MODULE_PRODUCT, zza.zzh());
            objectEncoderContext.add("osBuild", zza.zzg());
            objectEncoderContext.add("manufacturer", zza.zze());
            objectEncoderContext.add("fingerprint", zza.zzc());
        }
    }

    public static final class b implements ObjectEncoder<zzo> {
        public static final b a = new b();

        @Override // com.google.firebase.encoders.ObjectEncoder
        public void encode(Object obj, Object obj2) throws IOException {
            ((ObjectEncoderContext) obj2).add("logRequest", ((zzo) obj).zza());
        }
    }

    public static final class c implements ObjectEncoder<zzp> {
        public static final c a = new c();

        @Override // com.google.firebase.encoders.ObjectEncoder
        public void encode(Object obj, Object obj2) throws IOException {
            zzp zzp = (zzp) obj;
            ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
            objectEncoderContext.add("clientType", zzp.zzc());
            objectEncoderContext.add("androidClientInfo", zzp.zzb());
        }
    }

    public static final class d implements ObjectEncoder<zzq> {
        public static final d a = new d();

        @Override // com.google.firebase.encoders.ObjectEncoder
        public void encode(Object obj, Object obj2) throws IOException {
            zzq zzq = (zzq) obj;
            ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
            objectEncoderContext.add("eventTimeMs", zzq.zzb());
            objectEncoderContext.add("eventCode", zzq.zza());
            objectEncoderContext.add("eventUptimeMs", zzq.zzc());
            objectEncoderContext.add("sourceExtension", zzq.zze());
            objectEncoderContext.add("sourceExtensionJsonProto3", zzq.zzf());
            objectEncoderContext.add("timezoneOffsetSeconds", zzq.zzg());
            objectEncoderContext.add("networkConnectionInfo", zzq.zzd());
        }
    }

    public static final class e implements ObjectEncoder<zzr> {
        public static final e a = new e();

        @Override // com.google.firebase.encoders.ObjectEncoder
        public void encode(Object obj, Object obj2) throws IOException {
            zzr zzr = (zzr) obj;
            ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
            objectEncoderContext.add("requestTimeMs", zzr.zzg());
            objectEncoderContext.add("requestUptimeMs", zzr.zzh());
            objectEncoderContext.add("clientInfo", zzr.zzb());
            objectEncoderContext.add("logSource", zzr.zzd());
            objectEncoderContext.add("logSourceName", zzr.zze());
            objectEncoderContext.add("logEvent", zzr.zzc());
            objectEncoderContext.add("qosTier", zzr.zzf());
        }
    }

    public static final class f implements ObjectEncoder<zzt> {
        public static final f a = new f();

        @Override // com.google.firebase.encoders.ObjectEncoder
        public void encode(Object obj, Object obj2) throws IOException {
            zzt zzt = (zzt) obj;
            ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
            objectEncoderContext.add("networkType", zzt.zzc());
            objectEncoderContext.add("mobileSubtype", zzt.zzb());
        }
    }

    @Override // com.google.firebase.encoders.config.Configurator
    public void configure(EncoderConfig<?> encoderConfig) {
        b bVar = b.a;
        encoderConfig.registerEncoder(zzo.class, bVar);
        encoderConfig.registerEncoder(a2.j.b.a.b.a.b.class, bVar);
        e eVar = e.a;
        encoderConfig.registerEncoder(zzr.class, eVar);
        encoderConfig.registerEncoder(a2.j.b.a.b.a.e.class, eVar);
        c cVar = c.a;
        encoderConfig.registerEncoder(zzp.class, cVar);
        encoderConfig.registerEncoder(a2.j.b.a.b.a.c.class, cVar);
        a aVar = a.a;
        encoderConfig.registerEncoder(zza.class, aVar);
        encoderConfig.registerEncoder(a2.j.b.a.b.a.a.class, aVar);
        d dVar = d.a;
        encoderConfig.registerEncoder(zzq.class, dVar);
        encoderConfig.registerEncoder(a2.j.b.a.b.a.d.class, dVar);
        f fVar = f.a;
        encoderConfig.registerEncoder(zzt.class, fVar);
        encoderConfig.registerEncoder(g.class, fVar);
    }
}
