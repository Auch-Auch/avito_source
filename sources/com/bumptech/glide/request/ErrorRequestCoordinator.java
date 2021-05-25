package com.bumptech.glide.request;

import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import com.bumptech.glide.request.RequestCoordinator;
public final class ErrorRequestCoordinator implements RequestCoordinator, Request {
    public final Object a;
    @Nullable
    public final RequestCoordinator b;
    public volatile Request c;
    public volatile Request d;
    @GuardedBy("requestLock")
    public RequestCoordinator.RequestState e;
    @GuardedBy("requestLock")
    public RequestCoordinator.RequestState f;

    public ErrorRequestCoordinator(Object obj, @Nullable RequestCoordinator requestCoordinator) {
        RequestCoordinator.RequestState requestState = RequestCoordinator.RequestState.CLEARED;
        this.e = requestState;
        this.f = requestState;
        this.a = obj;
        this.b = requestCoordinator;
    }

    @GuardedBy("requestLock")
    public final boolean a(Request request) {
        return request.equals(this.c) || (this.e == RequestCoordinator.RequestState.FAILED && request.equals(this.d));
    }

    @Override // com.bumptech.glide.request.Request
    public void begin() {
        synchronized (this.a) {
            RequestCoordinator.RequestState requestState = this.e;
            RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.RUNNING;
            if (requestState != requestState2) {
                this.e = requestState2;
                this.c.begin();
            }
        }
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean canNotifyCleared(Request request) {
        boolean z;
        boolean z2;
        synchronized (this.a) {
            RequestCoordinator requestCoordinator = this.b;
            z = false;
            if (requestCoordinator != null) {
                if (!requestCoordinator.canNotifyCleared(this)) {
                    z2 = false;
                    if (z2 && a(request)) {
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
        synchronized (this.a) {
            RequestCoordinator requestCoordinator = this.b;
            z = false;
            if (requestCoordinator != null) {
                if (!requestCoordinator.canNotifyStatusChanged(this)) {
                    z2 = false;
                    if (z2 && a(request)) {
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
        synchronized (this.a) {
            RequestCoordinator requestCoordinator = this.b;
            z = false;
            if (requestCoordinator != null) {
                if (!requestCoordinator.canSetImage(this)) {
                    z2 = false;
                    if (z2 && a(request)) {
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
        synchronized (this.a) {
            RequestCoordinator.RequestState requestState = RequestCoordinator.RequestState.CLEARED;
            this.e = requestState;
            this.c.clear();
            if (this.f != requestState) {
                this.f = requestState;
                this.d.clear();
            }
        }
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public RequestCoordinator getRoot() {
        RequestCoordinator root;
        synchronized (this.a) {
            RequestCoordinator requestCoordinator = this.b;
            root = requestCoordinator != null ? requestCoordinator.getRoot() : this;
        }
        return root;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator, com.bumptech.glide.request.Request
    public boolean isAnyResourceSet() {
        boolean z;
        synchronized (this.a) {
            if (!this.c.isAnyResourceSet()) {
                if (!this.d.isAnyResourceSet()) {
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
        synchronized (this.a) {
            RequestCoordinator.RequestState requestState = this.e;
            RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.CLEARED;
            z = requestState == requestState2 && this.f == requestState2;
        }
        return z;
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isComplete() {
        boolean z;
        synchronized (this.a) {
            RequestCoordinator.RequestState requestState = this.e;
            RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.SUCCESS;
            if (requestState != requestState2) {
                if (this.f != requestState2) {
                    z = false;
                }
            }
            z = true;
        }
        return z;
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isEquivalentTo(Request request) {
        if (!(request instanceof ErrorRequestCoordinator)) {
            return false;
        }
        ErrorRequestCoordinator errorRequestCoordinator = (ErrorRequestCoordinator) request;
        if (!this.c.isEquivalentTo(errorRequestCoordinator.c) || !this.d.isEquivalentTo(errorRequestCoordinator.d)) {
            return false;
        }
        return true;
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isRunning() {
        boolean z;
        synchronized (this.a) {
            RequestCoordinator.RequestState requestState = this.e;
            RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.RUNNING;
            if (requestState != requestState2) {
                if (this.f != requestState2) {
                    z = false;
                }
            }
            z = true;
        }
        return z;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public void onRequestFailed(Request request) {
        synchronized (this.a) {
            if (!request.equals(this.d)) {
                this.e = RequestCoordinator.RequestState.FAILED;
                RequestCoordinator.RequestState requestState = this.f;
                RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.RUNNING;
                if (requestState != requestState2) {
                    this.f = requestState2;
                    this.d.begin();
                }
                return;
            }
            this.f = RequestCoordinator.RequestState.FAILED;
            RequestCoordinator requestCoordinator = this.b;
            if (requestCoordinator != null) {
                requestCoordinator.onRequestFailed(this);
            }
        }
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public void onRequestSuccess(Request request) {
        synchronized (this.a) {
            if (request.equals(this.c)) {
                this.e = RequestCoordinator.RequestState.SUCCESS;
            } else if (request.equals(this.d)) {
                this.f = RequestCoordinator.RequestState.SUCCESS;
            }
            RequestCoordinator requestCoordinator = this.b;
            if (requestCoordinator != null) {
                requestCoordinator.onRequestSuccess(this);
            }
        }
    }

    @Override // com.bumptech.glide.request.Request
    public void pause() {
        synchronized (this.a) {
            RequestCoordinator.RequestState requestState = this.e;
            RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.RUNNING;
            if (requestState == requestState2) {
                this.e = RequestCoordinator.RequestState.PAUSED;
                this.c.pause();
            }
            if (this.f == requestState2) {
                this.f = RequestCoordinator.RequestState.PAUSED;
                this.d.pause();
            }
        }
    }

    public void setRequests(Request request, Request request2) {
        this.c = request;
        this.d = request2;
    }
}
