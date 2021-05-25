package com.bumptech.glide.manager;

import a2.b.a.a.a;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.util.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;
public class RequestTracker {
    public final Set<Request> a = Collections.newSetFromMap(new WeakHashMap());
    public final List<Request> b = new ArrayList();
    public boolean c;

    public boolean clearAndRemove(@Nullable Request request) {
        boolean z = true;
        if (request == null) {
            return true;
        }
        boolean remove = this.a.remove(request);
        if (!this.b.remove(request) && !remove) {
            z = false;
        }
        if (z) {
            request.clear();
        }
        return z;
    }

    public void clearRequests() {
        for (Request request : Util.getSnapshot(this.a)) {
            clearAndRemove(request);
        }
        this.b.clear();
    }

    public boolean isPaused() {
        return this.c;
    }

    public void pauseAllRequests() {
        this.c = true;
        for (Request request : Util.getSnapshot(this.a)) {
            if (request.isRunning() || request.isComplete()) {
                request.clear();
                this.b.add(request);
            }
        }
    }

    public void pauseRequests() {
        this.c = true;
        for (Request request : Util.getSnapshot(this.a)) {
            if (request.isRunning()) {
                request.pause();
                this.b.add(request);
            }
        }
    }

    public void restartRequests() {
        for (Request request : Util.getSnapshot(this.a)) {
            if (!request.isComplete() && !request.isCleared()) {
                request.clear();
                if (!this.c) {
                    request.begin();
                } else {
                    this.b.add(request);
                }
            }
        }
    }

    public void resumeRequests() {
        this.c = false;
        for (Request request : Util.getSnapshot(this.a)) {
            if (!request.isComplete() && !request.isRunning()) {
                request.begin();
            }
        }
        this.b.clear();
    }

    public void runRequest(@NonNull Request request) {
        this.a.add(request);
        if (!this.c) {
            request.begin();
            return;
        }
        request.clear();
        Log.isLoggable("RequestTracker", 2);
        this.b.add(request);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("{numRequests=");
        sb.append(this.a.size());
        sb.append(", isPaused=");
        return a.B(sb, this.c, "}");
    }
}
