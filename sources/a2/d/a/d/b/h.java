package a2.d.a.d.b;

import a2.d.a.d.b.i;
import a2.d.a.d.b.m;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.bumptech.glide.GlideContext;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.engine.DataFetcherGenerator;
import com.bumptech.glide.load.engine.DecodePath;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.engine.Initializable;
import com.bumptech.glide.load.engine.LoadPath;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.pool.FactoryPools;
import com.bumptech.glide.util.pool.GlideTrace;
import com.bumptech.glide.util.pool.StateVerifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
public class h<R> implements DataFetcherGenerator.FetcherReadyCallback, Runnable, Comparable<h<?>>, FactoryPools.Poolable {
    public DataSource A;
    public DataFetcher<?> B;
    public volatile DataFetcherGenerator C;
    public volatile boolean D;
    public volatile boolean E;
    public final g<R> a = new g<>();
    public final List<Throwable> b = new ArrayList();
    public final StateVerifier c = StateVerifier.newInstance();
    public final d d;
    public final Pools.Pool<h<?>> e;
    public final c<?> f = new c<>();
    public final e g = new e();
    public GlideContext h;
    public Key i;
    public Priority j;
    public k k;
    public int l;
    public int m;
    public DiskCacheStrategy n;
    public Options o;
    public a<R> p;
    public int q;
    public g r;
    public f s;
    public long t;
    public boolean u;
    public Object v;
    public Thread w;
    public Key x;
    public Key y;
    public Object z;

    public interface a<R> {
    }

    public final class b<Z> implements DecodePath.a<Z> {
        public final DataSource a;

        public b(DataSource dataSource) {
            this.a = dataSource;
        }
    }

    public static class c<Z> {
        public Key a;
        public ResourceEncoder<Z> b;
        public o<Z> c;

        public void a(d dVar, Options options) {
            GlideTrace.beginSection("DecodeJob.encode");
            try {
                ((Engine.c) dVar).a().put(this.a, new f(this.b, this.c, options));
            } finally {
                this.c.b();
                GlideTrace.endSection();
            }
        }
    }

    public interface d {
    }

    public static class e {
        public boolean a;
        public boolean b;
        public boolean c;

        public final boolean a(boolean z) {
            return (this.c || z || this.b) && this.a;
        }
    }

    public enum f {
        INITIALIZE,
        SWITCH_TO_SOURCE_SERVICE,
        DECODE_DATA
    }

    public enum g {
        INITIALIZE,
        RESOURCE_CACHE,
        DATA_CACHE,
        SOURCE,
        ENCODE,
        FINISHED
    }

    public h(d dVar, Pools.Pool<h<?>> pool) {
        this.d = dVar;
        this.e = pool;
    }

    public final <Data> Resource<R> a(DataFetcher<?> dataFetcher, Data data, DataSource dataSource) throws GlideException {
        if (data == null) {
            dataFetcher.cleanup();
            return null;
        }
        try {
            long logTime = LogTime.getLogTime();
            Resource<R> b2 = b(data, dataSource);
            if (Log.isLoggable("DecodeJob", 2)) {
                f("Decoded result " + b2, logTime, null);
            }
            return b2;
        } finally {
            dataFetcher.cleanup();
        }
    }

    public final <Data> Resource<R> b(Data data, DataSource dataSource) throws GlideException {
        g<R> gVar = this.a;
        LoadPath loadPath = gVar.c.getRegistry().getLoadPath(data.getClass(), gVar.g, gVar.k);
        Options options = this.o;
        if (Build.VERSION.SDK_INT >= 26) {
            boolean z2 = dataSource == DataSource.RESOURCE_DISK_CACHE || this.a.r;
            Option<Boolean> option = Downsampler.ALLOW_HARDWARE_CONFIG;
            Boolean bool = (Boolean) options.get(option);
            if (bool == null || (bool.booleanValue() && !z2)) {
                options = new Options();
                options.putAll(this.o);
                options.set(option, Boolean.valueOf(z2));
            }
        }
        DataRewinder<Data> rewinder = this.h.getRegistry().getRewinder(data);
        try {
            return loadPath.load(rewinder, options, this.l, this.m, new b(dataSource));
        } finally {
            rewinder.cleanup();
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:16:0x0069 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX DEBUG: Type inference failed for r1v26. Raw type applied. Possible types: com.bumptech.glide.load.engine.Resource<R> */
    public final void c() {
        Resource resource;
        boolean a3;
        if (Log.isLoggable("DecodeJob", 2)) {
            long j2 = this.t;
            StringBuilder L = a2.b.a.a.a.L("data: ");
            L.append(this.z);
            L.append(", cache key: ");
            L.append(this.x);
            L.append(", fetcher: ");
            L.append(this.B);
            f("Retrieved data", j2, L.toString());
        }
        o oVar = null;
        try {
            resource = (Resource<R>) a(this.B, this.z, this.A);
        } catch (GlideException e2) {
            Key key = this.y;
            DataSource dataSource = this.A;
            e2.b = key;
            e2.c = dataSource;
            e2.d = null;
            this.b.add(e2);
            resource = (Resource<R>) null;
        }
        if (resource != null) {
            DataSource dataSource2 = this.A;
            if (resource instanceof Initializable) {
                ((Initializable) resource).initialize();
            }
            if (this.f.c != null) {
                oVar = o.a(resource);
                resource = oVar;
            }
            k();
            i<?> iVar = (i) this.p;
            synchronized (iVar) {
                iVar.q = resource;
                iVar.r = dataSource2;
            }
            synchronized (iVar) {
                iVar.b.throwIfRecycled();
                if (iVar.x) {
                    iVar.q.recycle();
                    iVar.e();
                } else if (iVar.a.isEmpty()) {
                    throw new IllegalStateException("Received a resource without any callbacks to notify");
                } else if (!iVar.s) {
                    i.c cVar = iVar.e;
                    Resource<?> resource2 = iVar.q;
                    boolean z2 = iVar.m;
                    Key key2 = iVar.l;
                    m.a aVar = iVar.c;
                    Objects.requireNonNull(cVar);
                    iVar.v = new m<>(resource2, z2, true, key2, aVar);
                    iVar.s = true;
                    i.e eVar = iVar.a;
                    Objects.requireNonNull(eVar);
                    ArrayList arrayList = new ArrayList(eVar.a);
                    iVar.c(arrayList.size() + 1);
                    iVar.f.onEngineJobComplete(iVar, iVar.l, iVar.v);
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        i.d dVar = (i.d) it.next();
                        dVar.b.execute(new i.b(dVar.a));
                    }
                    iVar.b();
                } else {
                    throw new IllegalStateException("Already have resource");
                }
            }
            this.r = g.ENCODE;
            try {
                c<?> cVar2 = this.f;
                if (cVar2.c != null) {
                    cVar2.a(this.d, this.o);
                }
                e eVar2 = this.g;
                synchronized (eVar2) {
                    eVar2.b = true;
                    a3 = eVar2.a(false);
                }
                if (a3) {
                    h();
                }
            } finally {
                if (oVar != null) {
                    oVar.b();
                }
            }
        } else {
            i();
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public int compareTo(@NonNull h<?> hVar) {
        h<?> hVar2 = hVar;
        int ordinal = this.j.ordinal() - hVar2.j.ordinal();
        return ordinal == 0 ? this.q - hVar2.q : ordinal;
    }

    public final DataFetcherGenerator d() {
        int ordinal = this.r.ordinal();
        if (ordinal == 1) {
            return new p(this.a, this);
        }
        if (ordinal == 2) {
            return new d(this.a, this);
        }
        if (ordinal == 3) {
            return new t(this.a, this);
        }
        if (ordinal == 5) {
            return null;
        }
        StringBuilder L = a2.b.a.a.a.L("Unrecognized stage: ");
        L.append(this.r);
        throw new IllegalStateException(L.toString());
    }

    public final g e(g gVar) {
        g gVar2 = g.RESOURCE_CACHE;
        g gVar3 = g.DATA_CACHE;
        g gVar4 = g.FINISHED;
        int ordinal = gVar.ordinal();
        if (ordinal == 0) {
            return this.n.decodeCachedResource() ? gVar2 : e(gVar2);
        }
        if (ordinal == 1) {
            return this.n.decodeCachedData() ? gVar3 : e(gVar3);
        }
        if (ordinal == 2) {
            return this.u ? gVar4 : g.SOURCE;
        }
        if (ordinal == 3 || ordinal == 5) {
            return gVar4;
        }
        throw new IllegalArgumentException("Unrecognized stage: " + gVar);
    }

    public final void f(String str, long j2, String str2) {
        StringBuilder Q = a2.b.a.a.a.Q(str, " in ");
        Q.append(LogTime.getElapsedMillis(j2));
        Q.append(", load key: ");
        Q.append(this.k);
        Q.append(str2 != null ? a2.b.a.a.a.c3(", ", str2) : "");
        Q.append(", thread: ");
        Q.append(Thread.currentThread().getName());
        Q.toString();
    }

    public final void g() {
        boolean a3;
        k();
        GlideException glideException = new GlideException("Failed to load resource", new ArrayList(this.b));
        i<?> iVar = (i) this.p;
        synchronized (iVar) {
            iVar.t = glideException;
        }
        synchronized (iVar) {
            iVar.b.throwIfRecycled();
            if (iVar.x) {
                iVar.e();
            } else if (iVar.a.isEmpty()) {
                throw new IllegalStateException("Received an exception without any callbacks to notify");
            } else if (!iVar.u) {
                iVar.u = true;
                Key key = iVar.l;
                i.e eVar = iVar.a;
                Objects.requireNonNull(eVar);
                ArrayList arrayList = new ArrayList(eVar.a);
                iVar.c(arrayList.size() + 1);
                iVar.f.onEngineJobComplete(iVar, key, null);
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    i.d dVar = (i.d) it.next();
                    dVar.b.execute(new i.a(dVar.a));
                }
                iVar.b();
            } else {
                throw new IllegalStateException("Already failed once");
            }
        }
        e eVar2 = this.g;
        synchronized (eVar2) {
            eVar2.c = true;
            a3 = eVar2.a(false);
        }
        if (a3) {
            h();
        }
    }

    @Override // com.bumptech.glide.util.pool.FactoryPools.Poolable
    @NonNull
    public StateVerifier getVerifier() {
        return this.c;
    }

    public final void h() {
        e eVar = this.g;
        synchronized (eVar) {
            eVar.b = false;
            eVar.a = false;
            eVar.c = false;
        }
        c<?> cVar = this.f;
        cVar.a = null;
        cVar.b = null;
        cVar.c = null;
        g<R> gVar = this.a;
        gVar.c = null;
        gVar.d = null;
        gVar.n = null;
        gVar.g = null;
        gVar.k = null;
        gVar.i = null;
        gVar.o = null;
        gVar.j = null;
        gVar.p = null;
        gVar.a.clear();
        gVar.l = false;
        gVar.b.clear();
        gVar.m = false;
        this.D = false;
        this.h = null;
        this.i = null;
        this.o = null;
        this.j = null;
        this.k = null;
        this.p = null;
        this.r = null;
        this.C = null;
        this.w = null;
        this.x = null;
        this.z = null;
        this.A = null;
        this.B = null;
        this.t = 0;
        this.E = false;
        this.v = null;
        this.b.clear();
        this.e.release(this);
    }

    public final void i() {
        this.w = Thread.currentThread();
        this.t = LogTime.getLogTime();
        boolean z2 = false;
        while (!this.E && this.C != null && !(z2 = this.C.a())) {
            this.r = e(this.r);
            this.C = d();
            if (this.r == g.SOURCE) {
                this.s = f.SWITCH_TO_SOURCE_SERVICE;
                ((i) this.p).g(this);
                return;
            }
        }
        if ((this.r == g.FINISHED || this.E) && !z2) {
            g();
        }
    }

    public final void j() {
        int ordinal = this.s.ordinal();
        if (ordinal == 0) {
            this.r = e(g.INITIALIZE);
            this.C = d();
            i();
        } else if (ordinal == 1) {
            i();
        } else if (ordinal == 2) {
            c();
        } else {
            StringBuilder L = a2.b.a.a.a.L("Unrecognized run reason: ");
            L.append(this.s);
            throw new IllegalStateException(L.toString());
        }
    }

    public final void k() {
        this.c.throwIfRecycled();
        if (this.D) {
            throw new IllegalStateException("Already notified", this.b.isEmpty() ? null : (Throwable) a2.b.a.a.a.j2(this.b, 1));
        }
        this.D = true;
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator.FetcherReadyCallback
    public void onDataFetcherFailed(Key key, Exception exc, DataFetcher<?> dataFetcher, DataSource dataSource) {
        dataFetcher.cleanup();
        GlideException glideException = new GlideException("Fetching data failed", exc);
        Class<?> dataClass = dataFetcher.getDataClass();
        glideException.b = key;
        glideException.c = dataSource;
        glideException.d = dataClass;
        this.b.add(glideException);
        if (Thread.currentThread() != this.w) {
            this.s = f.SWITCH_TO_SOURCE_SERVICE;
            ((i) this.p).g(this);
            return;
        }
        i();
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator.FetcherReadyCallback
    public void onDataFetcherReady(Key key, Object obj, DataFetcher<?> dataFetcher, DataSource dataSource, Key key2) {
        this.x = key;
        this.z = obj;
        this.B = dataFetcher;
        this.A = dataSource;
        this.y = key2;
        if (Thread.currentThread() != this.w) {
            this.s = f.DECODE_DATA;
            ((i) this.p).g(this);
            return;
        }
        GlideTrace.beginSection("DecodeJob.decodeFromRetrievedData");
        try {
            c();
        } finally {
            GlideTrace.endSection();
        }
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator.FetcherReadyCallback
    public void reschedule() {
        this.s = f.SWITCH_TO_SOURCE_SERVICE;
        ((i) this.p).g(this);
    }

    @Override // java.lang.Runnable
    public void run() {
        GlideTrace.beginSectionFormat("DecodeJob#run(model=%s)", this.v);
        DataFetcher<?> dataFetcher = this.B;
        try {
            if (this.E) {
                g();
                if (dataFetcher != null) {
                    dataFetcher.cleanup();
                }
                GlideTrace.endSection();
                return;
            }
            j();
            if (dataFetcher != null) {
                dataFetcher.cleanup();
            }
            GlideTrace.endSection();
        } catch (c e2) {
            throw e2;
        } catch (Throwable th) {
            if (dataFetcher != null) {
                dataFetcher.cleanup();
            }
            GlideTrace.endSection();
            throw th;
        }
    }
}
