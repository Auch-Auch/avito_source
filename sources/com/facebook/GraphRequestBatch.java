package com.facebook;

import android.os.Handler;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
public class GraphRequestBatch extends AbstractList<GraphRequest> {
    public static AtomicInteger g = new AtomicInteger();
    public Handler a;
    public List<GraphRequest> b;
    public int c;
    public final String d;
    public List<Callback> e;
    public String f;

    public interface Callback {
        void onBatchCompleted(GraphRequestBatch graphRequestBatch);
    }

    public interface OnProgressCallback extends Callback {
        void onBatchProgress(GraphRequestBatch graphRequestBatch, long j, long j2);
    }

    public GraphRequestBatch() {
        this.b = new ArrayList();
        this.c = 0;
        this.d = Integer.valueOf(g.incrementAndGet()).toString();
        this.e = new ArrayList();
        this.b = new ArrayList();
    }

    public void addCallback(Callback callback) {
        if (!this.e.contains(callback)) {
            this.e.add(callback);
        }
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.List, java.util.Collection
    public final void clear() {
        this.b.clear();
    }

    public final List<GraphResponse> executeAndWait() {
        return GraphRequest.executeBatchAndWait(this);
    }

    public final GraphRequestAsyncTask executeAsync() {
        return GraphRequest.executeBatchAsync(this);
    }

    public final String getBatchApplicationId() {
        return this.f;
    }

    public int getTimeout() {
        return this.c;
    }

    public void removeCallback(Callback callback) {
        this.e.remove(callback);
    }

    public final void setBatchApplicationId(String str) {
        this.f = str;
    }

    public void setTimeout(int i) {
        if (i >= 0) {
            this.c = i;
            return;
        }
        throw new IllegalArgumentException("Argument timeoutInMilliseconds must be >= 0.");
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    public final int size() {
        return this.b.size();
    }

    @Override // java.util.AbstractList, java.util.List
    public final GraphRequest get(int i) {
        return this.b.get(i);
    }

    @Override // java.util.AbstractList, java.util.List
    public final GraphRequest remove(int i) {
        return this.b.remove(i);
    }

    public final GraphRequest set(int i, GraphRequest graphRequest) {
        return this.b.set(i, graphRequest);
    }

    public final boolean add(GraphRequest graphRequest) {
        return this.b.add(graphRequest);
    }

    public final void add(int i, GraphRequest graphRequest) {
        this.b.add(i, graphRequest);
    }

    public GraphRequestBatch(Collection<GraphRequest> collection) {
        this.b = new ArrayList();
        this.c = 0;
        this.d = Integer.valueOf(g.incrementAndGet()).toString();
        this.e = new ArrayList();
        this.b = new ArrayList(collection);
    }

    public GraphRequestBatch(GraphRequest... graphRequestArr) {
        this.b = new ArrayList();
        this.c = 0;
        this.d = Integer.valueOf(g.incrementAndGet()).toString();
        this.e = new ArrayList();
        this.b = Arrays.asList(graphRequestArr);
    }

    public GraphRequestBatch(GraphRequestBatch graphRequestBatch) {
        this.b = new ArrayList();
        this.c = 0;
        this.d = Integer.valueOf(g.incrementAndGet()).toString();
        this.e = new ArrayList();
        this.b = new ArrayList(graphRequestBatch);
        this.a = graphRequestBatch.a;
        this.c = graphRequestBatch.c;
        this.e = new ArrayList(graphRequestBatch.e);
    }
}
