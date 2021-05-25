package com.google.android.datatransport.runtime;

import a2.j.b.a.c.d;
import a2.j.b.a.c.g;
import a2.j.b.a.c.j;
import a2.j.b.a.c.k;
import android.content.Context;
import androidx.annotation.RestrictTo;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.TransportFactory;
import com.google.android.datatransport.TransportScheduleCallback;
import com.google.android.datatransport.runtime.scheduling.Scheduler;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkInitializer;
import com.google.android.datatransport.runtime.time.Clock;
import com.google.android.datatransport.runtime.time.Monotonic;
import com.google.android.datatransport.runtime.time.WallTime;
import dagger.internal.Preconditions;
import java.util.Collections;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;
@Singleton
public class TransportRuntime implements j {
    public static volatile k e;
    public final Clock a;
    public final Clock b;
    public final Scheduler c;
    public final Uploader d;

    @Inject
    public TransportRuntime(@WallTime Clock clock, @Monotonic Clock clock2, Scheduler scheduler, Uploader uploader, WorkInitializer workInitializer) {
        this.a = clock;
        this.b = clock2;
        this.c = scheduler;
        this.d = uploader;
        workInitializer.ensureContextsScheduled();
    }

    public static Set<Encoding> a(Destination destination) {
        if (destination instanceof EncodedDestination) {
            return Collections.unmodifiableSet(((EncodedDestination) destination).getSupportedEncodings());
        }
        return Collections.singleton(Encoding.of("proto"));
    }

    public static TransportRuntime getInstance() {
        k kVar = e;
        if (kVar != null) {
            return ((d) kVar).l.get();
        }
        throw new IllegalStateException("Not initialized!");
    }

    public static void initialize(Context context) {
        if (e == null) {
            synchronized (TransportRuntime.class) {
                if (e == null) {
                    Context context2 = (Context) Preconditions.checkNotNull(context);
                    Preconditions.checkBuilderRequirement(context2, Context.class);
                    e = new d(context2, null);
                }
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Uploader getUploader() {
        return this.d;
    }

    @Deprecated
    public TransportFactory newFactory(String str) {
        return new g(a(null), TransportContext.builder().setBackendName(str).build(), this);
    }

    @Override // a2.j.b.a.c.j
    public void send(SendRequest sendRequest, TransportScheduleCallback transportScheduleCallback) {
        this.c.schedule(sendRequest.d().withPriority(sendRequest.b().getPriority()), EventInternal.builder().setEventMillis(this.a.getTime()).setUptimeMillis(this.b.getTime()).setTransportName(sendRequest.e()).setEncodedPayload(new EncodedPayload(sendRequest.a(), sendRequest.c().apply(sendRequest.b().getPayload()))).setCode(sendRequest.b().getCode()).build(), transportScheduleCallback);
    }

    public TransportFactory newFactory(Destination destination) {
        return new g(a(destination), TransportContext.builder().setBackendName(destination.getName()).setExtras(destination.getExtras()).build(), this);
    }
}
