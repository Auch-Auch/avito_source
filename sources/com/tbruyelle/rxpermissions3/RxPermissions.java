package com.tbruyelle.rxpermissions3;

import a2.r.a.e;
import a2.r.a.f;
import android.app.Activity;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.ObservableTransformer;
import io.reactivex.rxjava3.functions.Function;
import java.util.List;
import java.util.Objects;
public class RxPermissions {
    public static final Object b = new Object();
    @VisibleForTesting
    public Lazy<RxPermissionsFragment> a;

    @FunctionalInterface
    public interface Lazy<V> {
        V get();
    }

    public class a implements ObservableTransformer<T, Boolean> {
        public final /* synthetic */ String[] a;

        /* renamed from: com.tbruyelle.rxpermissions3.RxPermissions$a$a  reason: collision with other inner class name */
        public class C0320a implements Function<List<Permission>, ObservableSource<Boolean>> {
            public C0320a(a aVar) {
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // io.reactivex.rxjava3.functions.Function
            public ObservableSource<Boolean> apply(List<Permission> list) throws Throwable {
                List<Permission> list2 = list;
                if (list2.isEmpty()) {
                    return Observable.empty();
                }
                for (Permission permission : list2) {
                    if (!permission.granted) {
                        return Observable.just(Boolean.FALSE);
                    }
                }
                return Observable.just(Boolean.TRUE);
            }
        }

        public a(String[] strArr) {
            this.a = strArr;
        }

        @Override // io.reactivex.rxjava3.core.ObservableTransformer
        public ObservableSource<Boolean> apply(Observable<T> observable) {
            return RxPermissions.a(RxPermissions.this, observable, this.a).buffer(this.a.length).flatMap(new C0320a(this));
        }
    }

    public class b implements ObservableTransformer<T, Permission> {
        public final /* synthetic */ String[] a;

        public b(String[] strArr) {
            this.a = strArr;
        }

        @Override // io.reactivex.rxjava3.core.ObservableTransformer
        public ObservableSource<Permission> apply(Observable<T> observable) {
            return RxPermissions.a(RxPermissions.this, observable, this.a);
        }
    }

    public class c implements ObservableTransformer<T, Permission> {
        public final /* synthetic */ String[] a;

        public class a implements Function<List<Permission>, ObservableSource<Permission>> {
            public a(c cVar) {
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // io.reactivex.rxjava3.functions.Function
            public ObservableSource<Permission> apply(List<Permission> list) throws Throwable {
                List<Permission> list2 = list;
                if (list2.isEmpty()) {
                    return Observable.empty();
                }
                return Observable.just(new Permission(list2));
            }
        }

        public c(String[] strArr) {
            this.a = strArr;
        }

        @Override // io.reactivex.rxjava3.core.ObservableTransformer
        public ObservableSource<Permission> apply(Observable<T> observable) {
            return RxPermissions.a(RxPermissions.this, observable, this.a).buffer(this.a.length).flatMap(new a(this));
        }
    }

    public RxPermissions(@NonNull FragmentActivity fragmentActivity) {
        this.a = new e(this, fragmentActivity.getSupportFragmentManager());
    }

    public static Observable a(RxPermissions rxPermissions, Observable observable, String[] strArr) {
        Observable just;
        Observable observable2;
        Objects.requireNonNull(rxPermissions);
        if (strArr == null || strArr.length == 0) {
            throw new IllegalArgumentException("RxPermissions.request/requestEach requires at least one input permission");
        }
        int length = strArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                just = Observable.just(b);
                break;
            }
            if (!rxPermissions.a.get().containsByPermission(strArr[i])) {
                just = Observable.empty();
                break;
            }
            i++;
        }
        if (observable == null) {
            observable2 = Observable.just(b);
        } else {
            observable2 = Observable.merge(observable, just);
        }
        return observable2.flatMap(new f(rxPermissions, strArr));
    }

    public boolean b() {
        return Build.VERSION.SDK_INT >= 23;
    }

    public <T> ObservableTransformer<T, Boolean> ensure(String... strArr) {
        return new a(strArr);
    }

    public <T> ObservableTransformer<T, Permission> ensureEach(String... strArr) {
        return new b(strArr);
    }

    public <T> ObservableTransformer<T, Permission> ensureEachCombined(String... strArr) {
        return new c(strArr);
    }

    public boolean isGranted(String str) {
        if (b()) {
            FragmentActivity activity = this.a.get().getActivity();
            if (activity != null) {
                if (!(activity.checkSelfPermission(str) == 0)) {
                    return false;
                }
            } else {
                throw new IllegalStateException("This fragment must be attached to an activity.");
            }
        }
        return true;
    }

    public boolean isRevoked(String str) {
        if (b()) {
            RxPermissionsFragment rxPermissionsFragment = this.a.get();
            FragmentActivity activity = rxPermissionsFragment.getActivity();
            if (activity == null) {
                throw new IllegalStateException("This fragment must be attached to an activity.");
            } else if (activity.getPackageManager().isPermissionRevokedByPolicy(str, rxPermissionsFragment.getActivity().getPackageName())) {
                return true;
            }
        }
        return false;
    }

    public Observable<Boolean> request(String... strArr) {
        return Observable.just(b).compose(ensure(strArr));
    }

    public Observable<Permission> requestEach(String... strArr) {
        return Observable.just(b).compose(ensureEach(strArr));
    }

    public Observable<Permission> requestEachCombined(String... strArr) {
        return Observable.just(b).compose(ensureEachCombined(strArr));
    }

    public void setLogging(boolean z) {
        this.a.get().setLogging(z);
    }

    public Observable<Boolean> shouldShowRequestPermissionRationale(Activity activity, String... strArr) {
        if (!b()) {
            return Observable.just(Boolean.FALSE);
        }
        int length = strArr.length;
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= length) {
                z = true;
                break;
            }
            String str = strArr[i];
            if (!isGranted(str) && !activity.shouldShowRequestPermissionRationale(str)) {
                break;
            }
            i++;
        }
        return Observable.just(Boolean.valueOf(z));
    }

    public RxPermissions(@NonNull Fragment fragment) {
        this.a = new e(this, fragment.getChildFragmentManager());
    }
}
