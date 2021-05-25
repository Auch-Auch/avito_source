package com.google.android.gms.internal.ads;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
public final class zzbbl implements ThreadFactory {
    private final /* synthetic */ String zzeeb;
    private final AtomicInteger zzzm = new AtomicInteger(1);

    public zzbbl(String str) {
        this.zzeeb = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        String str = this.zzeeb;
        int andIncrement = this.zzzm.getAndIncrement();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 23);
        sb.append("AdWorker(");
        sb.append(str);
        sb.append(") #");
        sb.append(andIncrement);
        return new Thread(runnable, sb.toString());
    }
}
