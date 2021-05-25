package com.facebook.internal.logging.monitor;

import androidx.annotation.RestrictTo;
import com.facebook.internal.logging.ExternalLog;
import com.facebook.internal.logging.LoggingCache;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class MonitorLoggingQueue implements LoggingCache {
    public static MonitorLoggingQueue b;
    public static final Integer c = 100;
    public Queue<ExternalLog> a = new LinkedList();

    public static synchronized MonitorLoggingQueue getInstance() {
        MonitorLoggingQueue monitorLoggingQueue;
        synchronized (MonitorLoggingQueue.class) {
            if (b == null) {
                b = new MonitorLoggingQueue();
            }
            monitorLoggingQueue = b;
        }
        return monitorLoggingQueue;
    }

    @Override // com.facebook.internal.logging.LoggingCache
    public boolean addLog(ExternalLog externalLog) {
        return addLogs(Arrays.asList(externalLog));
    }

    @Override // com.facebook.internal.logging.LoggingCache
    public boolean addLogs(Collection<? extends ExternalLog> collection) {
        if (collection != null) {
            this.a.addAll(collection);
        }
        return this.a.size() >= c.intValue();
    }

    @Override // com.facebook.internal.logging.LoggingCache
    public Collection<ExternalLog> fetchAllLogs() {
        LinkedList linkedList = new LinkedList(this.a);
        this.a.clear();
        return linkedList;
    }

    @Override // com.facebook.internal.logging.LoggingCache
    public ExternalLog fetchLog() {
        return this.a.poll();
    }

    @Override // com.facebook.internal.logging.LoggingCache
    public boolean isEmpty() {
        return this.a.isEmpty();
    }
}
