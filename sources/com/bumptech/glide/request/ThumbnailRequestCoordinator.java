package com.bumptech.glide.request;

import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import com.bumptech.glide.request.RequestCoordinator;
public class ThumbnailRequestCoordinator implements RequestCoordinator, Request {
    @Nullable
    public final RequestCoordinator a;
    public final Object b;
    public volatile Request c;
    public volatile Request d;
    @GuardedBy("requestLock")
    public RequestCoordinator.RequestState e;
    @GuardedBy("requestLock")
    public RequestCoordinator.RequestState f;
    @GuardedBy("requestLock")
    public boolean g;

    public ThumbnailRequestCoordinator(Object obj, @Nullable RequestCoordinator requestCoordinator) {
        RequestCoordinator.RequestState requestState = RequestCoordinator.RequestState.CLEARED;
        this.e = requestState;
        this.f = requestState;
        this.b = obj;
        this.a = requestCoordinator;
    }

    @Override // com.bumptech.glide.request.Request
    public void begin() {
        RequestCoordinator.RequestState requestState;
        RequestCoordinator.RequestState requestState2;
        synchronized (this.b) {
            this.g = true;
            boolean z = false;
            try {
                if (!(this.e == RequestCoordinator.RequestState.SUCCESS || this.f == (requestState2 = RequestCoordinator.RequestState.RUNNING))) {
                    this.f = requestState2;
                    this.d.begin();
                }
                if (this.g && this.e != (requestState = RequestCoordinator.RequestState.RUNNING)) {
                    this.e = requestState;
                    this.c.begin();
                }
            } finally {
                this.g = z;
            }
        }
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean canNotifyCleared(Request request) {
        boolean z;
        boolean z2;
        synchronized (this.b) {
            RequestCoordinator requestCoordinator = this.a;
            z = false;
            if (requestCoordinator != null) {
                if (!requestCoordinator.canNotifyCleared(this)) {
                    z2 = false;
                    if (z2 && request.equals(this.c) && this.e != RequestCoordinator.RequestState.PAUSED) {
                        z = true;
                    }
                }
            }
            z2 = true;
            z = true;
        }
        return z;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean canNotifyStatusChanged(Request request) {
        boolean z;
        boolean z2;
        synchronized (this.b) {
            RequestCoordinator requestCoordinator = this.a;
            z = false;
            if (requestCoordinator != null) {
                if (!requestCoordinator.canNotifyStatusChanged(this)) {
                    z2 = false;
                    if (z2 && request.equals(this.c) && !isAnyResourceSet()) {
                        z = true;
                    }
                }
            }
            z2 = true;
            z = true;
        }
        return z;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean canSetImage(Request request) {
        boolean z;
        boolean z2;
        synchronized (this.b) {
            RequestCoordinator requestCoordinator = this.a;
            z = false;
            if (requestCoordinator != null) {
                if (!requestCoordinator.canSetImage(this)) {
                    z2 = false;
                    if (z2 && (request.equals(this.c) || this.e != RequestCoordinator.RequestState.SUCCESS)) {
                        z = true;
                    }
                }
            }
            z2 = true;
            z = true;
        }
        return z;
    }

    @Override // com.bumptech.glide.request.Request
    public void clear() {
        synchronized (this.b) {
            this.g = false;
            RequestCoordinator.RequestState requestState = RequestCoordinator.RequestState.CLEARED;
            this.e = requestState;
            this.f = requestState;
            this.d.clear();
            this.c.clear();
        }
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public RequestCoordinator getRoot() {
        RequestCoordinator root;
        synchronized (this.b) {
            RequestCoordinator requestCoordinator = this.a;
            root = requestCoordinator != null ? requestCoordinator.getRoot() : this;
        }
        return root;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator, com.bumptech.glide.request.Request
    public boolean isAnyResourceSet() {
        boolean z;
        synchronized (this.b) {
            if (!this.d.isAnyResourceSet()) {
                if (!this.c.isAnyResourceSet()) {
                    z = false;
                }
            }
            z = true;
        }
        return z;
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isCleared() {
        boolean z;
        synchronized (this.b) {
            z = this.e == RequestCoordinator.RequestState.CLEARED;
        }
        return z;
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isComplete() {
        boolean z;
        synchronized (this.b) {
            z = this.e == RequestCoordinator.RequestState.SUCCESS;
        }
        return z;
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isEquivalentTo(Request request) {
        if (!(request instanceof ThumbnailRequestCoordinator)) {
            return false;
        }
        ThumbnailRequestCoordinator thumbnailRequestCoordinator = (ThumbnailRequestCoordinator) request;
        if (this.c == null) {
            if (thumbnailRequestCoordinator.c != null) {
                return false;
            }
        } else if (!this.c.isEquivalentTo(thumbnailRequestCoordinator.c)) {
            return false;
        }
        if (this.d == null) {
            if (thumbnailRequestCoordinator.d != null) {
                return false;
            }
        } else if (!this.d.isEquivalentTo(thumbnailRequestCoordinator.d)) {
            return false;
        }
        return true;
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isRunning() {
        boolean z;
        synchronized (this.b) {
            z = this.e == RequestCoordinator.RequestState.RUNNING;
        }
        return z;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public void onRequestFailed(Request request) {
        synchronized (this.b) {
            if (!request.equals(this.c)) {
                this.f = RequestCoordinator.RequestState.FAILED;
                return;
            }
            this.e = RequestCoordinator.RequestState.FAILED;
            RequestCoordinator requestCoordinator = this.a;
            if (requestCoordinator != null) {
                requestCoordinator.onRequestFailed(this);
            }
        }
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public void onRequestSuccess(Request request) {
        synchronized (this.b) {
            if (request.equals(this.d)) {
                this.f = RequestCoordinator.RequestState.SUCCESS;
                return;
            }
            this.e = RequestCoordinator.RequestState.SUCCESS;
            RequestCoordinator requestCoordinator = this.a;
            if (requestCoordinator != null) {
                requestCoordinator.onRequestSuccess(this);
            }
            if (!this.f.a) {
                this.d.clear();
            }
        }
    }

    @Override // com.bumptech.glide.request.Request
    public void pause() {
        synchronized (this.b) {
            if (!this.f.a) {
                this.f = RequestCoordinator.RequestState.PAUSED;
                this.d.pause();
            }
            if (!this.e.a) {
                this.e = RequestCoordinator.RequestState.PAUSED;
                this.c.pause();
            }
        }
    }

    public void setRequests(Request request, Request request2) {
        this.c = request;
        this.d = request2;
    }
}
