package x6.c.b.c;

import org.junit.internal.management.ThreadMXBean;
public final class b implements ThreadMXBean {
    @Override // org.junit.internal.management.ThreadMXBean
    public long getThreadCpuTime(long j) {
        throw new UnsupportedOperationException();
    }

    @Override // org.junit.internal.management.ThreadMXBean
    public boolean isThreadCpuTimeSupported() {
        return false;
    }
}
