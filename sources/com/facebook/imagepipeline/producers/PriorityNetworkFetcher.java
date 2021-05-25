package com.facebook.imagepipeline.producers;

import a2.g.p.e.h;
import com.avito.android.payment.SberbankOnlineKt;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.logging.FLog;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.time.RealtimeSinceBootClock;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.producers.FetchState;
import com.facebook.imagepipeline.producers.NetworkFetcher;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import javax.annotation.Nullable;
public class PriorityNetworkFetcher<FETCH_STATE extends FetchState> implements NetworkFetcher<PriorityFetchState<FETCH_STATE>> {
    public static final String TAG = "PriorityNetworkFetcher";
    public final NetworkFetcher<FETCH_STATE> a;
    public final boolean b;
    public final int c;
    public final int d;
    public final MonotonicClock e;
    public final Object f;
    public final LinkedList<PriorityFetchState<FETCH_STATE>> g;
    public final LinkedList<PriorityFetchState<FETCH_STATE>> h;
    public final HashSet<PriorityFetchState<FETCH_STATE>> i;

    public static class PriorityFetchState<FETCH_STATE extends FetchState> extends FetchState {
        public final FETCH_STATE delegatedState;
        public final long f;
        public final int g;
        public final int h;
        public NetworkFetcher.Callback i;
        public long j;

        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.facebook.imagepipeline.producers.FetchState */
        /* JADX WARN: Multi-variable type inference failed */
        public PriorityFetchState(Consumer consumer, ProducerContext producerContext, FetchState fetchState, long j2, int i2, int i3, a aVar) {
            super(consumer, producerContext);
            this.delegatedState = fetchState;
            this.f = j2;
            this.g = i2;
            this.h = i3;
        }
    }

    public class a extends BaseProducerContextCallbacks {
        public final /* synthetic */ PriorityFetchState a;
        public final /* synthetic */ NetworkFetcher.Callback b;

        public a(PriorityFetchState priorityFetchState, NetworkFetcher.Callback callback) {
            this.a = priorityFetchState;
            this.b = callback;
        }

        @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
        public void onCancellationRequested() {
            PriorityNetworkFetcher.this.c(this.a, "CANCEL");
            this.b.onCancellation();
        }

        @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
        public void onPriorityChanged() {
            LinkedList<PriorityFetchState<FETCH_STATE>> linkedList;
            PriorityNetworkFetcher priorityNetworkFetcher = PriorityNetworkFetcher.this;
            PriorityFetchState<FETCH_STATE> priorityFetchState = this.a;
            boolean z = priorityFetchState.getContext().getPriority() == Priority.HIGH;
            synchronized (priorityNetworkFetcher.f) {
                if (z) {
                    linkedList = priorityNetworkFetcher.h;
                } else {
                    linkedList = priorityNetworkFetcher.g;
                }
                if (linkedList.remove(priorityFetchState)) {
                    FLog.v(PriorityNetworkFetcher.TAG, "change-pri: %s %s", z ? "HIPRI" : "LOWPRI", priorityFetchState.getUri());
                    priorityNetworkFetcher.b(priorityFetchState, z);
                    priorityNetworkFetcher.a();
                }
            }
        }
    }

    public PriorityNetworkFetcher(NetworkFetcher<FETCH_STATE> networkFetcher, boolean z, int i2, int i3) {
        this(networkFetcher, z, i2, i3, RealtimeSinceBootClock.get());
    }

    public final void a() {
        synchronized (this.f) {
            int size = this.i.size();
            PriorityFetchState<FETCH_STATE> pollFirst = size < this.c ? this.g.pollFirst() : null;
            if (pollFirst == null && size < this.d) {
                pollFirst = this.h.pollFirst();
            }
            if (pollFirst != null) {
                pollFirst.j = this.e.now();
                this.i.add(pollFirst);
                FLog.v(TAG, "fetching: %s (concurrent: %s hi-pri queue: %s low-pri queue: %s)", pollFirst.getUri(), Integer.valueOf(size), Integer.valueOf(this.g.size()), Integer.valueOf(this.h.size()));
                try {
                    this.a.fetch(pollFirst.delegatedState, new h(this, pollFirst));
                } catch (Exception unused) {
                    c(pollFirst, "FAIL");
                }
            }
        }
    }

    public final void b(PriorityFetchState<FETCH_STATE> priorityFetchState, boolean z) {
        if (!z) {
            this.h.addLast(priorityFetchState);
        } else if (this.b) {
            this.g.addLast(priorityFetchState);
        } else {
            this.g.addFirst(priorityFetchState);
        }
    }

    public final void c(PriorityFetchState<FETCH_STATE> priorityFetchState, String str) {
        synchronized (this.f) {
            FLog.v(TAG, "remove: %s %s", str, priorityFetchState.getUri());
            this.i.remove(priorityFetchState);
            if (!this.g.remove(priorityFetchState)) {
                this.h.remove(priorityFetchState);
            }
        }
        a();
    }

    @Override // com.facebook.imagepipeline.producers.NetworkFetcher
    public /* bridge */ /* synthetic */ void fetch(FetchState fetchState, NetworkFetcher.Callback callback) {
        fetch((PriorityFetchState) ((PriorityFetchState) fetchState), callback);
    }

    @Override // com.facebook.imagepipeline.producers.NetworkFetcher
    @Nullable
    public /* bridge */ /* synthetic */ Map getExtraMap(FetchState fetchState, int i2) {
        return getExtraMap((PriorityFetchState) ((PriorityFetchState) fetchState), i2);
    }

    @Override // com.facebook.imagepipeline.producers.NetworkFetcher
    public /* bridge */ /* synthetic */ void onFetchCompletion(FetchState fetchState, int i2) {
        onFetchCompletion((PriorityFetchState) ((PriorityFetchState) fetchState), i2);
    }

    @Override // com.facebook.imagepipeline.producers.NetworkFetcher
    public /* bridge */ /* synthetic */ boolean shouldPropagate(FetchState fetchState) {
        return shouldPropagate((PriorityFetchState) ((PriorityFetchState) fetchState));
    }

    @Override // com.facebook.imagepipeline.producers.NetworkFetcher
    public PriorityFetchState<FETCH_STATE> createFetchState(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        return new PriorityFetchState<>(consumer, producerContext, this.a.createFetchState(consumer, producerContext), this.e.now(), this.g.size(), this.h.size(), null);
    }

    public void fetch(PriorityFetchState<FETCH_STATE> priorityFetchState, NetworkFetcher.Callback callback) {
        priorityFetchState.getContext().addCallbacks(new a(priorityFetchState, callback));
        synchronized (this.f) {
            if (this.i.contains(priorityFetchState)) {
                String str = TAG;
                FLog.e(str, "fetch state was enqueued twice: " + priorityFetchState);
                return;
            }
            boolean z = priorityFetchState.getContext().getPriority() == Priority.HIGH;
            FLog.v(TAG, "enqueue: %s %s", z ? "HI-PRI" : "LOW-PRI", priorityFetchState.getUri());
            priorityFetchState.i = callback;
            b(priorityFetchState, z);
            a();
        }
    }

    @Nullable
    public Map<String, String> getExtraMap(PriorityFetchState<FETCH_STATE> priorityFetchState, int i2) {
        HashMap hashMap;
        if (this.a.getExtraMap(priorityFetchState.delegatedState, i2) == null) {
            hashMap = new HashMap();
        }
        StringBuilder L = a2.b.a.a.a.L("");
        L.append(priorityFetchState.j - priorityFetchState.f);
        hashMap.put("pri_queue_time", L.toString());
        hashMap.put("hipri_queue_size", "" + priorityFetchState.g);
        hashMap.put("lowpri_queue_size", "" + priorityFetchState.h);
        return hashMap;
    }

    public void onFetchCompletion(PriorityFetchState<FETCH_STATE> priorityFetchState, int i2) {
        c(priorityFetchState, SberbankOnlineKt.RESULT_SUCCESS);
        this.a.onFetchCompletion(priorityFetchState.delegatedState, i2);
    }

    public boolean shouldPropagate(PriorityFetchState<FETCH_STATE> priorityFetchState) {
        return this.a.shouldPropagate(priorityFetchState.delegatedState);
    }

    @VisibleForTesting
    public PriorityNetworkFetcher(NetworkFetcher<FETCH_STATE> networkFetcher, boolean z, int i2, int i3, MonotonicClock monotonicClock) {
        this.f = new Object();
        this.g = new LinkedList<>();
        this.h = new LinkedList<>();
        this.i = new HashSet<>();
        this.a = networkFetcher;
        this.b = z;
        this.c = i2;
        this.d = i3;
        if (i2 > i3) {
            this.e = monotonicClock;
            return;
        }
        throw new IllegalArgumentException("maxOutstandingHiPri should be > maxOutstandingLowPri");
    }
}
