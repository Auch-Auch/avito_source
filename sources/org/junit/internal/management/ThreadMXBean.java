package org.junit.internal.management;
public interface ThreadMXBean {
    long getThreadCpuTime(long j);

    boolean isThreadCpuTimeSupported();
}
