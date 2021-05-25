package com.google.firebase.crashlytics.internal.model;

import com.avito.android.inline_filters.analytics.VerticalFilterCloseDialogEventKt;
import com.avito.android.util.preferences.SessionContract;
import com.facebook.appevents.integrity.IntegrityManager;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.config.Configurator;
import com.google.firebase.encoders.config.EncoderConfig;
import java.io.IOException;
import ru.ok.android.sdk.OkListener;
import ru.ok.android.sdk.Shared;
public final class AutoCrashlyticsReportEncoder implements Configurator {
    public static final int CODEGEN_VERSION = 1;
    public static final Configurator CONFIG = new AutoCrashlyticsReportEncoder();

    public static final class a implements ObjectEncoder<CrashlyticsReport.CustomAttribute> {
        public static final a a = new a();

        @Override // com.google.firebase.encoders.ObjectEncoder
        public void encode(Object obj, Object obj2) throws IOException {
            CrashlyticsReport.CustomAttribute customAttribute = (CrashlyticsReport.CustomAttribute) obj;
            ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
            objectEncoderContext.add("key", customAttribute.getKey());
            objectEncoderContext.add("value", customAttribute.getValue());
        }
    }

    public static final class b implements ObjectEncoder<CrashlyticsReport> {
        public static final b a = new b();

        @Override // com.google.firebase.encoders.ObjectEncoder
        public void encode(Object obj, Object obj2) throws IOException {
            CrashlyticsReport crashlyticsReport = (CrashlyticsReport) obj;
            ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
            objectEncoderContext.add("sdkVersion", crashlyticsReport.getSdkVersion());
            objectEncoderContext.add("gmpAppId", crashlyticsReport.getGmpAppId());
            objectEncoderContext.add(Shared.PARAM_PLATFORM, crashlyticsReport.getPlatform());
            objectEncoderContext.add("installationUuid", crashlyticsReport.getInstallationUuid());
            objectEncoderContext.add("buildVersion", crashlyticsReport.getBuildVersion());
            objectEncoderContext.add("displayVersion", crashlyticsReport.getDisplayVersion());
            objectEncoderContext.add(SessionContract.SESSION, crashlyticsReport.getSession());
            objectEncoderContext.add("ndkPayload", crashlyticsReport.getNdkPayload());
        }
    }

    public static final class c implements ObjectEncoder<CrashlyticsReport.FilesPayload> {
        public static final c a = new c();

        @Override // com.google.firebase.encoders.ObjectEncoder
        public void encode(Object obj, Object obj2) throws IOException {
            CrashlyticsReport.FilesPayload filesPayload = (CrashlyticsReport.FilesPayload) obj;
            ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
            objectEncoderContext.add("files", filesPayload.getFiles());
            objectEncoderContext.add("orgId", filesPayload.getOrgId());
        }
    }

    public static final class d implements ObjectEncoder<CrashlyticsReport.FilesPayload.File> {
        public static final d a = new d();

        @Override // com.google.firebase.encoders.ObjectEncoder
        public void encode(Object obj, Object obj2) throws IOException {
            CrashlyticsReport.FilesPayload.File file = (CrashlyticsReport.FilesPayload.File) obj;
            ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
            objectEncoderContext.add("filename", file.getFilename());
            objectEncoderContext.add("contents", file.getContents());
        }
    }

    public static final class e implements ObjectEncoder<CrashlyticsReport.Session.Application> {
        public static final e a = new e();

        @Override // com.google.firebase.encoders.ObjectEncoder
        public void encode(Object obj, Object obj2) throws IOException {
            CrashlyticsReport.Session.Application application = (CrashlyticsReport.Session.Application) obj;
            ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
            objectEncoderContext.add("identifier", application.getIdentifier());
            objectEncoderContext.add("version", application.getVersion());
            objectEncoderContext.add("displayVersion", application.getDisplayVersion());
            objectEncoderContext.add("organization", application.getOrganization());
            objectEncoderContext.add("installationUuid", application.getInstallationUuid());
        }
    }

    public static final class f implements ObjectEncoder<CrashlyticsReport.Session.Application.Organization> {
        public static final f a = new f();

        @Override // com.google.firebase.encoders.ObjectEncoder
        public void encode(Object obj, Object obj2) throws IOException {
            ((ObjectEncoderContext) obj2).add("clsId", ((CrashlyticsReport.Session.Application.Organization) obj).getClsId());
        }
    }

    public static final class g implements ObjectEncoder<CrashlyticsReport.Session.Device> {
        public static final g a = new g();

        @Override // com.google.firebase.encoders.ObjectEncoder
        public void encode(Object obj, Object obj2) throws IOException {
            CrashlyticsReport.Session.Device device = (CrashlyticsReport.Session.Device) obj;
            ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
            objectEncoderContext.add("arch", device.getArch());
            objectEncoderContext.add(VerticalFilterCloseDialogEventKt.MODEL_DIALOG, device.getModel());
            objectEncoderContext.add("cores", device.getCores());
            objectEncoderContext.add("ram", device.getRam());
            objectEncoderContext.add("diskSpace", device.getDiskSpace());
            objectEncoderContext.add("simulator", device.isSimulator());
            objectEncoderContext.add("state", device.getState());
            objectEncoderContext.add("manufacturer", device.getManufacturer());
            objectEncoderContext.add("modelClass", device.getModelClass());
        }
    }

    public static final class h implements ObjectEncoder<CrashlyticsReport.Session> {
        public static final h a = new h();

        @Override // com.google.firebase.encoders.ObjectEncoder
        public void encode(Object obj, Object obj2) throws IOException {
            CrashlyticsReport.Session session = (CrashlyticsReport.Session) obj;
            ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
            objectEncoderContext.add("generator", session.getGenerator());
            objectEncoderContext.add("identifier", session.getIdentifierUtf8Bytes());
            objectEncoderContext.add("startedAt", session.getStartedAt());
            objectEncoderContext.add("endedAt", session.getEndedAt());
            objectEncoderContext.add("crashed", session.isCrashed());
            objectEncoderContext.add("app", session.getApp());
            objectEncoderContext.add("user", session.getUser());
            objectEncoderContext.add("os", session.getOs());
            objectEncoderContext.add("device", session.getDevice());
            objectEncoderContext.add("events", session.getEvents());
            objectEncoderContext.add("generatorType", session.getGeneratorType());
        }
    }

    public static final class i implements ObjectEncoder<CrashlyticsReport.Session.Event.Application> {
        public static final i a = new i();

        @Override // com.google.firebase.encoders.ObjectEncoder
        public void encode(Object obj, Object obj2) throws IOException {
            CrashlyticsReport.Session.Event.Application application = (CrashlyticsReport.Session.Event.Application) obj;
            ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
            objectEncoderContext.add("execution", application.getExecution());
            objectEncoderContext.add("customAttributes", application.getCustomAttributes());
            objectEncoderContext.add("background", application.getBackground());
            objectEncoderContext.add("uiOrientation", application.getUiOrientation());
        }
    }

    public static final class j implements ObjectEncoder<CrashlyticsReport.Session.Event.Application.Execution.BinaryImage> {
        public static final j a = new j();

        @Override // com.google.firebase.encoders.ObjectEncoder
        public void encode(Object obj, Object obj2) throws IOException {
            CrashlyticsReport.Session.Event.Application.Execution.BinaryImage binaryImage = (CrashlyticsReport.Session.Event.Application.Execution.BinaryImage) obj;
            ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
            objectEncoderContext.add("baseAddress", binaryImage.getBaseAddress());
            objectEncoderContext.add("size", binaryImage.getSize());
            objectEncoderContext.add("name", binaryImage.getName());
            objectEncoderContext.add("uuid", binaryImage.getUuidUtf8Bytes());
        }
    }

    public static final class k implements ObjectEncoder<CrashlyticsReport.Session.Event.Application.Execution> {
        public static final k a = new k();

        @Override // com.google.firebase.encoders.ObjectEncoder
        public void encode(Object obj, Object obj2) throws IOException {
            CrashlyticsReport.Session.Event.Application.Execution execution = (CrashlyticsReport.Session.Event.Application.Execution) obj;
            ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
            objectEncoderContext.add("threads", execution.getThreads());
            objectEncoderContext.add(OkListener.KEY_EXCEPTION, execution.getException());
            objectEncoderContext.add("signal", execution.getSignal());
            objectEncoderContext.add("binaries", execution.getBinaries());
        }
    }

    public static final class l implements ObjectEncoder<CrashlyticsReport.Session.Event.Application.Execution.Exception> {
        public static final l a = new l();

        @Override // com.google.firebase.encoders.ObjectEncoder
        public void encode(Object obj, Object obj2) throws IOException {
            CrashlyticsReport.Session.Event.Application.Execution.Exception exception = (CrashlyticsReport.Session.Event.Application.Execution.Exception) obj;
            ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
            objectEncoderContext.add("type", exception.getType());
            objectEncoderContext.add("reason", exception.getReason());
            objectEncoderContext.add("frames", exception.getFrames());
            objectEncoderContext.add("causedBy", exception.getCausedBy());
            objectEncoderContext.add("overflowCount", exception.getOverflowCount());
        }
    }

    public static final class m implements ObjectEncoder<CrashlyticsReport.Session.Event.Application.Execution.Signal> {
        public static final m a = new m();

        @Override // com.google.firebase.encoders.ObjectEncoder
        public void encode(Object obj, Object obj2) throws IOException {
            CrashlyticsReport.Session.Event.Application.Execution.Signal signal = (CrashlyticsReport.Session.Event.Application.Execution.Signal) obj;
            ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
            objectEncoderContext.add("name", signal.getName());
            objectEncoderContext.add("code", signal.getCode());
            objectEncoderContext.add(IntegrityManager.INTEGRITY_TYPE_ADDRESS, signal.getAddress());
        }
    }

    public static final class n implements ObjectEncoder<CrashlyticsReport.Session.Event.Application.Execution.Thread> {
        public static final n a = new n();

        @Override // com.google.firebase.encoders.ObjectEncoder
        public void encode(Object obj, Object obj2) throws IOException {
            CrashlyticsReport.Session.Event.Application.Execution.Thread thread = (CrashlyticsReport.Session.Event.Application.Execution.Thread) obj;
            ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
            objectEncoderContext.add("name", thread.getName());
            objectEncoderContext.add("importance", thread.getImportance());
            objectEncoderContext.add("frames", thread.getFrames());
        }
    }

    public static final class o implements ObjectEncoder<CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame> {
        public static final o a = new o();

        @Override // com.google.firebase.encoders.ObjectEncoder
        public void encode(Object obj, Object obj2) throws IOException {
            CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame frame = (CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame) obj;
            ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
            objectEncoderContext.add("pc", frame.getPc());
            objectEncoderContext.add("symbol", frame.getSymbol());
            objectEncoderContext.add("file", frame.getFile());
            objectEncoderContext.add("offset", frame.getOffset());
            objectEncoderContext.add("importance", frame.getImportance());
        }
    }

    public static final class p implements ObjectEncoder<CrashlyticsReport.Session.Event.Device> {
        public static final p a = new p();

        @Override // com.google.firebase.encoders.ObjectEncoder
        public void encode(Object obj, Object obj2) throws IOException {
            CrashlyticsReport.Session.Event.Device device = (CrashlyticsReport.Session.Event.Device) obj;
            ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
            objectEncoderContext.add("batteryLevel", device.getBatteryLevel());
            objectEncoderContext.add("batteryVelocity", device.getBatteryVelocity());
            objectEncoderContext.add("proximityOn", device.isProximityOn());
            objectEncoderContext.add("orientation", device.getOrientation());
            objectEncoderContext.add("ramUsed", device.getRamUsed());
            objectEncoderContext.add("diskUsed", device.getDiskUsed());
        }
    }

    public static final class q implements ObjectEncoder<CrashlyticsReport.Session.Event> {
        public static final q a = new q();

        @Override // com.google.firebase.encoders.ObjectEncoder
        public void encode(Object obj, Object obj2) throws IOException {
            CrashlyticsReport.Session.Event event = (CrashlyticsReport.Session.Event) obj;
            ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
            objectEncoderContext.add("timestamp", event.getTimestamp());
            objectEncoderContext.add("type", event.getType());
            objectEncoderContext.add("app", event.getApp());
            objectEncoderContext.add("device", event.getDevice());
            objectEncoderContext.add("log", event.getLog());
        }
    }

    public static final class r implements ObjectEncoder<CrashlyticsReport.Session.Event.Log> {
        public static final r a = new r();

        @Override // com.google.firebase.encoders.ObjectEncoder
        public void encode(Object obj, Object obj2) throws IOException {
            ((ObjectEncoderContext) obj2).add("content", ((CrashlyticsReport.Session.Event.Log) obj).getContent());
        }
    }

    public static final class s implements ObjectEncoder<CrashlyticsReport.Session.OperatingSystem> {
        public static final s a = new s();

        @Override // com.google.firebase.encoders.ObjectEncoder
        public void encode(Object obj, Object obj2) throws IOException {
            CrashlyticsReport.Session.OperatingSystem operatingSystem = (CrashlyticsReport.Session.OperatingSystem) obj;
            ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
            objectEncoderContext.add(Shared.PARAM_PLATFORM, operatingSystem.getPlatform());
            objectEncoderContext.add("version", operatingSystem.getVersion());
            objectEncoderContext.add("buildVersion", operatingSystem.getBuildVersion());
            objectEncoderContext.add("jailbroken", operatingSystem.isJailbroken());
        }
    }

    public static final class t implements ObjectEncoder<CrashlyticsReport.Session.User> {
        public static final t a = new t();

        @Override // com.google.firebase.encoders.ObjectEncoder
        public void encode(Object obj, Object obj2) throws IOException {
            ((ObjectEncoderContext) obj2).add("identifier", ((CrashlyticsReport.Session.User) obj).getIdentifier());
        }
    }

    @Override // com.google.firebase.encoders.config.Configurator
    public void configure(EncoderConfig<?> encoderConfig) {
        b bVar = b.a;
        encoderConfig.registerEncoder(CrashlyticsReport.class, bVar);
        encoderConfig.registerEncoder(a2.j.e.d.d.c.a.class, bVar);
        h hVar = h.a;
        encoderConfig.registerEncoder(CrashlyticsReport.Session.class, hVar);
        encoderConfig.registerEncoder(a2.j.e.d.d.c.e.class, hVar);
        e eVar = e.a;
        encoderConfig.registerEncoder(CrashlyticsReport.Session.Application.class, eVar);
        encoderConfig.registerEncoder(a2.j.e.d.d.c.f.class, eVar);
        f fVar = f.a;
        encoderConfig.registerEncoder(CrashlyticsReport.Session.Application.Organization.class, fVar);
        encoderConfig.registerEncoder(a2.j.e.d.d.c.g.class, fVar);
        t tVar = t.a;
        encoderConfig.registerEncoder(CrashlyticsReport.Session.User.class, tVar);
        encoderConfig.registerEncoder(a2.j.e.d.d.c.t.class, tVar);
        s sVar = s.a;
        encoderConfig.registerEncoder(CrashlyticsReport.Session.OperatingSystem.class, sVar);
        encoderConfig.registerEncoder(a2.j.e.d.d.c.s.class, sVar);
        g gVar = g.a;
        encoderConfig.registerEncoder(CrashlyticsReport.Session.Device.class, gVar);
        encoderConfig.registerEncoder(a2.j.e.d.d.c.h.class, gVar);
        q qVar = q.a;
        encoderConfig.registerEncoder(CrashlyticsReport.Session.Event.class, qVar);
        encoderConfig.registerEncoder(a2.j.e.d.d.c.i.class, qVar);
        i iVar = i.a;
        encoderConfig.registerEncoder(CrashlyticsReport.Session.Event.Application.class, iVar);
        encoderConfig.registerEncoder(a2.j.e.d.d.c.j.class, iVar);
        k kVar = k.a;
        encoderConfig.registerEncoder(CrashlyticsReport.Session.Event.Application.Execution.class, kVar);
        encoderConfig.registerEncoder(a2.j.e.d.d.c.k.class, kVar);
        n nVar = n.a;
        encoderConfig.registerEncoder(CrashlyticsReport.Session.Event.Application.Execution.Thread.class, nVar);
        encoderConfig.registerEncoder(a2.j.e.d.d.c.o.class, nVar);
        o oVar = o.a;
        encoderConfig.registerEncoder(CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.class, oVar);
        encoderConfig.registerEncoder(a2.j.e.d.d.c.p.class, oVar);
        l lVar = l.a;
        encoderConfig.registerEncoder(CrashlyticsReport.Session.Event.Application.Execution.Exception.class, lVar);
        encoderConfig.registerEncoder(a2.j.e.d.d.c.m.class, lVar);
        m mVar = m.a;
        encoderConfig.registerEncoder(CrashlyticsReport.Session.Event.Application.Execution.Signal.class, mVar);
        encoderConfig.registerEncoder(a2.j.e.d.d.c.n.class, mVar);
        j jVar = j.a;
        encoderConfig.registerEncoder(CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.class, jVar);
        encoderConfig.registerEncoder(a2.j.e.d.d.c.l.class, jVar);
        a aVar = a.a;
        encoderConfig.registerEncoder(CrashlyticsReport.CustomAttribute.class, aVar);
        encoderConfig.registerEncoder(a2.j.e.d.d.c.b.class, aVar);
        p pVar = p.a;
        encoderConfig.registerEncoder(CrashlyticsReport.Session.Event.Device.class, pVar);
        encoderConfig.registerEncoder(a2.j.e.d.d.c.q.class, pVar);
        r rVar = r.a;
        encoderConfig.registerEncoder(CrashlyticsReport.Session.Event.Log.class, rVar);
        encoderConfig.registerEncoder(a2.j.e.d.d.c.r.class, rVar);
        c cVar = c.a;
        encoderConfig.registerEncoder(CrashlyticsReport.FilesPayload.class, cVar);
        encoderConfig.registerEncoder(a2.j.e.d.d.c.c.class, cVar);
        d dVar = d.a;
        encoderConfig.registerEncoder(CrashlyticsReport.FilesPayload.File.class, dVar);
        encoderConfig.registerEncoder(a2.j.e.d.d.c.d.class, dVar);
    }
}
