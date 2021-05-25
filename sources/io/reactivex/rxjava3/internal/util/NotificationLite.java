package io.reactivex.rxjava3.internal.util;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import java.io.Serializable;
import java.util.Objects;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public enum NotificationLite {
    COMPLETE;

    public static final class a implements Serializable {
        private static final long serialVersionUID = -7482590109178395495L;
        public final Disposable a;

        public a(Disposable disposable) {
            this.a = disposable;
        }

        @Override // java.lang.Object
        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("NotificationLite.Disposable[");
            L.append(this.a);
            L.append("]");
            return L.toString();
        }
    }

    public static final class b implements Serializable {
        private static final long serialVersionUID = -8759979445933046293L;
        public final Throwable a;

        public b(Throwable th) {
            this.a = th;
        }

        @Override // java.lang.Object
        public boolean equals(Object obj) {
            if (obj instanceof b) {
                return Objects.equals(this.a, ((b) obj).a);
            }
            return false;
        }

        @Override // java.lang.Object
        public int hashCode() {
            return this.a.hashCode();
        }

        @Override // java.lang.Object
        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("NotificationLite.Error[");
            L.append(this.a);
            L.append("]");
            return L.toString();
        }
    }

    public static final class c implements Serializable {
        private static final long serialVersionUID = -1322257508628817540L;
        public final Subscription a;

        public c(Subscription subscription) {
            this.a = subscription;
        }

        @Override // java.lang.Object
        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("NotificationLite.Subscription[");
            L.append(this.a);
            L.append("]");
            return L.toString();
        }
    }

    public static <T> boolean accept(Object obj, Subscriber<? super T> subscriber) {
        if (obj == COMPLETE) {
            subscriber.onComplete();
            return true;
        } else if (obj instanceof b) {
            subscriber.onError(((b) obj).a);
            return true;
        } else {
            subscriber.onNext(obj);
            return false;
        }
    }

    public static <T> boolean acceptFull(Object obj, Subscriber<? super T> subscriber) {
        if (obj == COMPLETE) {
            subscriber.onComplete();
            return true;
        } else if (obj instanceof b) {
            subscriber.onError(((b) obj).a);
            return true;
        } else if (obj instanceof c) {
            subscriber.onSubscribe(((c) obj).a);
            return false;
        } else {
            subscriber.onNext(obj);
            return false;
        }
    }

    public static Object complete() {
        return COMPLETE;
    }

    public static Object disposable(Disposable disposable) {
        return new a(disposable);
    }

    public static Object error(Throwable th) {
        return new b(th);
    }

    public static Disposable getDisposable(Object obj) {
        return ((a) obj).a;
    }

    public static Throwable getError(Object obj) {
        return ((b) obj).a;
    }

    public static Subscription getSubscription(Object obj) {
        return ((c) obj).a;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T getValue(Object obj) {
        return obj;
    }

    public static boolean isComplete(Object obj) {
        return obj == COMPLETE;
    }

    public static boolean isDisposable(Object obj) {
        return obj instanceof a;
    }

    public static boolean isError(Object obj) {
        return obj instanceof b;
    }

    public static boolean isSubscription(Object obj) {
        return obj instanceof c;
    }

    public static <T> Object next(T t) {
        return t;
    }

    public static Object subscription(Subscription subscription) {
        return new c(subscription);
    }

    @Override // java.lang.Enum, java.lang.Object
    public String toString() {
        return "NotificationLite.Complete";
    }

    public static <T> boolean accept(Object obj, Observer<? super T> observer) {
        if (obj == COMPLETE) {
            observer.onComplete();
            return true;
        } else if (obj instanceof b) {
            observer.onError(((b) obj).a);
            return true;
        } else {
            observer.onNext(obj);
            return false;
        }
    }

    public static <T> boolean acceptFull(Object obj, Observer<? super T> observer) {
        if (obj == COMPLETE) {
            observer.onComplete();
            return true;
        } else if (obj instanceof b) {
            observer.onError(((b) obj).a);
            return true;
        } else if (obj instanceof a) {
            observer.onSubscribe(((a) obj).a);
            return false;
        } else {
            observer.onNext(obj);
            return false;
        }
    }
}
