package com.facebook.network.connectionclass;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nonnull;
public class ConnectionClassManager {
    public a2.g.t.a.b a = new a2.g.t.a.b(0.05d);
    public volatile boolean b = false;
    public AtomicReference<ConnectionQuality> c = new AtomicReference<>(ConnectionQuality.UNKNOWN);
    public AtomicReference<ConnectionQuality> d;
    public ArrayList<ConnectionClassStateChangeListener> e = new ArrayList<>();
    public int f;

    public interface ConnectionClassStateChangeListener {
        void onBandwidthStateChange(ConnectionQuality connectionQuality);
    }

    public static class b {
        public static final ConnectionClassManager a = new ConnectionClassManager(null);
    }

    public ConnectionClassManager() {
    }

    @Nonnull
    public static ConnectionClassManager getInstance() {
        return b.a;
    }

    public synchronized void addBandwidth(long j, long j2) {
        if (j2 != 0) {
            double d2 = ((((double) j) * 1.0d) / ((double) j2)) * 8.0d;
            if (d2 >= 10.0d) {
                this.a.a(d2);
                if (this.b) {
                    this.f++;
                    if (getCurrentBandwidthQuality() != this.d.get()) {
                        this.b = false;
                        this.f = 1;
                    }
                    if (((double) this.f) >= 5.0d) {
                        this.b = false;
                        this.f = 1;
                        this.c.set(this.d.get());
                        int size = this.e.size();
                        for (int i = 0; i < size; i++) {
                            this.e.get(i).onBandwidthStateChange(this.c.get());
                        }
                    }
                    return;
                }
                if (this.c.get() != getCurrentBandwidthQuality()) {
                    this.b = true;
                    this.d = new AtomicReference<>(getCurrentBandwidthQuality());
                }
            }
        }
    }

    public synchronized ConnectionQuality getCurrentBandwidthQuality() {
        ConnectionQuality connectionQuality;
        a2.g.t.a.b bVar = this.a;
        if (bVar == null) {
            return ConnectionQuality.UNKNOWN;
        }
        double d2 = bVar.b;
        if (d2 < 0.0d) {
            connectionQuality = ConnectionQuality.UNKNOWN;
        } else if (d2 < 150.0d) {
            connectionQuality = ConnectionQuality.POOR;
        } else if (d2 < 550.0d) {
            connectionQuality = ConnectionQuality.MODERATE;
        } else if (d2 < 2000.0d) {
            connectionQuality = ConnectionQuality.GOOD;
        } else {
            connectionQuality = ConnectionQuality.EXCELLENT;
        }
        return connectionQuality;
    }

    public synchronized double getDownloadKBitsPerSecond() {
        double d2;
        a2.g.t.a.b bVar = this.a;
        if (bVar == null) {
            d2 = -1.0d;
        } else {
            d2 = bVar.b;
        }
        return d2;
    }

    public ConnectionQuality register(ConnectionClassStateChangeListener connectionClassStateChangeListener) {
        if (connectionClassStateChangeListener != null) {
            this.e.add(connectionClassStateChangeListener);
        }
        return this.c.get();
    }

    public void remove(ConnectionClassStateChangeListener connectionClassStateChangeListener) {
        if (connectionClassStateChangeListener != null) {
            this.e.remove(connectionClassStateChangeListener);
        }
    }

    public void reset() {
        a2.g.t.a.b bVar = this.a;
        if (bVar != null) {
            bVar.b = -1.0d;
            bVar.c = 0;
        }
        this.c.set(ConnectionQuality.UNKNOWN);
    }

    public ConnectionClassManager(a aVar) {
    }
}
