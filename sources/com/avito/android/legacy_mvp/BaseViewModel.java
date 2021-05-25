package com.avito.android.legacy_mvp;
@Deprecated
public abstract class BaseViewModel<T> implements ViewModel<T> {
    public final T a;
    public boolean b;
    public boolean c;
    public T mSubscriber;

    public BaseViewModel() {
        T emptySubscriber = getEmptySubscriber();
        this.a = emptySubscriber;
        this.mSubscriber = emptySubscriber;
    }

    public abstract T getEmptySubscriber();

    public boolean hasSubscriber() {
        return this.mSubscriber != this.a;
    }

    public void onSubscribe(T t) {
    }

    public void onUnsubscribe(T t) {
    }

    /* JADX INFO: finally extract failed */
    @Override // com.avito.android.legacy_mvp.Presenter
    public final void subscribe(T t) {
        if (!this.b) {
            if (t == null) {
                this.mSubscriber = this.a;
            } else {
                this.mSubscriber = t;
            }
            try {
                this.b = true;
                onSubscribe(this.mSubscriber);
                this.b = false;
            } catch (Throwable th) {
                this.b = false;
                throw th;
            }
        }
    }

    @Override // com.avito.android.legacy_mvp.Presenter
    public final void unsubscribe() {
        if (!this.c) {
            boolean z = false;
            try {
                this.c = true;
                onUnsubscribe(this.mSubscriber);
            } finally {
                this.c = z;
                this.mSubscriber = this.a;
            }
        }
    }
}
