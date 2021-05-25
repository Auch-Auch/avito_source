package com.facebook.imagepipeline.listener;

import android.os.SystemClock;
import android.util.Pair;
import com.facebook.common.logging.FLog;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
public class RequestLoggingListener implements RequestListener {
    @GuardedBy("this")
    public final Map<Pair<String, String>, Long> a = new HashMap();
    @GuardedBy("this")
    public final Map<String, Long> b = new HashMap();

    public static long a(@Nullable Long l, long j) {
        if (l != null) {
            return j - l.longValue();
        }
        return -1;
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener
    public synchronized void onProducerEvent(String str, String str2, String str3) {
        if (FLog.isLoggable(2)) {
            FLog.v("RequestLoggingListener", "time %d: onProducerEvent: {requestId: %s, stage: %s, eventName: %s; elapsedTime: %d ms}", Long.valueOf(SystemClock.uptimeMillis()), str, str2, str3, Long.valueOf(a(this.a.get(Pair.create(str, str2)), SystemClock.uptimeMillis())));
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener
    public synchronized void onProducerFinishWithCancellation(String str, String str2, @Nullable Map<String, String> map) {
        if (FLog.isLoggable(2)) {
            Pair create = Pair.create(str, str2);
            long uptimeMillis = SystemClock.uptimeMillis();
            FLog.v("RequestLoggingListener", "time %d: onProducerFinishWithCancellation: {requestId: %s, stage: %s, elapsedTime: %d ms, extraMap: %s}", Long.valueOf(uptimeMillis), str, str2, Long.valueOf(a(this.a.remove(create), uptimeMillis)), map);
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener
    public synchronized void onProducerFinishWithFailure(String str, String str2, Throwable th, @Nullable Map<String, String> map) {
        if (FLog.isLoggable(5)) {
            Pair create = Pair.create(str, str2);
            long uptimeMillis = SystemClock.uptimeMillis();
            FLog.w("RequestLoggingListener", th, "time %d: onProducerFinishWithFailure: {requestId: %s, stage: %s, elapsedTime: %d ms, extraMap: %s, throwable: %s}", Long.valueOf(uptimeMillis), str, str2, Long.valueOf(a(this.a.remove(create), uptimeMillis)), map, th.toString());
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener
    public synchronized void onProducerFinishWithSuccess(String str, String str2, @Nullable Map<String, String> map) {
        if (FLog.isLoggable(2)) {
            Pair create = Pair.create(str, str2);
            long uptimeMillis = SystemClock.uptimeMillis();
            FLog.v("RequestLoggingListener", "time %d: onProducerFinishWithSuccess: {requestId: %s, producer: %s, elapsedTime: %d ms, extraMap: %s}", Long.valueOf(uptimeMillis), str, str2, Long.valueOf(a(this.a.remove(create), uptimeMillis)), map);
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener
    public synchronized void onProducerStart(String str, String str2) {
        if (FLog.isLoggable(2)) {
            Pair<String, String> create = Pair.create(str, str2);
            long uptimeMillis = SystemClock.uptimeMillis();
            this.a.put(create, Long.valueOf(uptimeMillis));
            FLog.v("RequestLoggingListener", "time %d: onProducerStart: {requestId: %s, producer: %s}", Long.valueOf(uptimeMillis), str, str2);
        }
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener
    public synchronized void onRequestCancellation(String str) {
        if (FLog.isLoggable(2)) {
            long uptimeMillis = SystemClock.uptimeMillis();
            FLog.v("RequestLoggingListener", "time %d: onRequestCancellation: {requestId: %s, elapsedTime: %d ms}", Long.valueOf(uptimeMillis), str, Long.valueOf(a(this.b.remove(str), uptimeMillis)));
        }
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener
    public synchronized void onRequestFailure(ImageRequest imageRequest, String str, Throwable th, boolean z) {
        if (FLog.isLoggable(5)) {
            long uptimeMillis = SystemClock.uptimeMillis();
            FLog.w("RequestLoggingListener", "time %d: onRequestFailure: {requestId: %s, elapsedTime: %d ms, throwable: %s}", Long.valueOf(uptimeMillis), str, Long.valueOf(a(this.b.remove(str), uptimeMillis)), th.toString());
        }
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener
    public synchronized void onRequestStart(ImageRequest imageRequest, Object obj, String str, boolean z) {
        if (FLog.isLoggable(2)) {
            FLog.v("RequestLoggingListener", "time %d: onRequestSubmit: {requestId: %s, callerContext: %s, isPrefetch: %b}", Long.valueOf(SystemClock.uptimeMillis()), str, obj, Boolean.valueOf(z));
            this.b.put(str, Long.valueOf(SystemClock.uptimeMillis()));
        }
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener
    public synchronized void onRequestSuccess(ImageRequest imageRequest, String str, boolean z) {
        if (FLog.isLoggable(2)) {
            long uptimeMillis = SystemClock.uptimeMillis();
            FLog.v("RequestLoggingListener", "time %d: onRequestSuccess: {requestId: %s, elapsedTime: %d ms}", Long.valueOf(uptimeMillis), str, Long.valueOf(a(this.b.remove(str), uptimeMillis)));
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener
    public synchronized void onUltimateProducerReached(String str, String str2, boolean z) {
        if (FLog.isLoggable(2)) {
            Pair create = Pair.create(str, str2);
            long uptimeMillis = SystemClock.uptimeMillis();
            FLog.v("RequestLoggingListener", "time %d: onUltimateProducerReached: {requestId: %s, producer: %s, elapsedTime: %d ms, success: %b}", Long.valueOf(uptimeMillis), str, str2, Long.valueOf(a(this.a.remove(create), uptimeMillis)), Boolean.valueOf(z));
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener
    public boolean requiresExtraMap(String str) {
        return FLog.isLoggable(2);
    }
}
