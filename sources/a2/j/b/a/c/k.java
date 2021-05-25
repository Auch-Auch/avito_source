package a2.j.b.a.c;

import com.google.android.datatransport.runtime.backends.BackendRegistryModule;
import com.google.android.datatransport.runtime.scheduling.SchedulingConfigModule;
import com.google.android.datatransport.runtime.scheduling.SchedulingModule;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStoreModule;
import com.google.android.datatransport.runtime.time.TimeModule;
import dagger.Component;
import java.io.Closeable;
import java.io.IOException;
import javax.inject.Singleton;
@Component(modules = {BackendRegistryModule.class, EventStoreModule.class, e.class, SchedulingModule.class, SchedulingConfigModule.class, TimeModule.class})
@Singleton
public abstract class k implements Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        ((d) this).f.get().close();
    }
}
