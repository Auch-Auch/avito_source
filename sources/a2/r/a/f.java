package a2.r.a;

import a2.b.a.a.a;
import android.text.TextUtils;
import com.tbruyelle.rxpermissions3.Permission;
import com.tbruyelle.rxpermissions3.RxPermissions;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.Objects;
public class f implements Function<Object, Observable<Permission>> {
    public final /* synthetic */ String[] a;
    public final /* synthetic */ RxPermissions b;

    public f(RxPermissions rxPermissions, String[] strArr) {
        this.b = rxPermissions;
        this.a = strArr;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // io.reactivex.rxjava3.functions.Function
    public Observable<Permission> apply(Object obj) throws Throwable {
        RxPermissions rxPermissions = this.b;
        String[] strArr = this.a;
        Object obj2 = RxPermissions.b;
        Objects.requireNonNull(rxPermissions);
        ArrayList arrayList = new ArrayList(strArr.length);
        ArrayList arrayList2 = new ArrayList();
        for (String str : strArr) {
            rxPermissions.a.get().a("Requesting permission " + str);
            if (rxPermissions.isGranted(str)) {
                arrayList.add(Observable.just(new Permission(str, true, false)));
            } else if (rxPermissions.isRevoked(str)) {
                arrayList.add(Observable.just(new Permission(str, false, false)));
            } else {
                PublishSubject<Permission> subjectByPermission = rxPermissions.a.get().getSubjectByPermission(str);
                if (subjectByPermission == null) {
                    arrayList2.add(str);
                    subjectByPermission = PublishSubject.create();
                    rxPermissions.a.get().setSubjectForPermission(str, subjectByPermission);
                }
                arrayList.add(subjectByPermission);
            }
        }
        if (!arrayList2.isEmpty()) {
            String[] strArr2 = (String[]) arrayList2.toArray(new String[arrayList2.size()]);
            StringBuilder L = a.L("requestPermissionsFromFragment ");
            L.append(TextUtils.join(", ", strArr2));
            rxPermissions.a.get().a(L.toString());
            rxPermissions.a.get().requestPermissions(strArr2, 42);
        }
        return Observable.concat(Observable.fromIterable(arrayList));
    }
}
