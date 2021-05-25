package com.tbruyelle.rxpermissions3;

import a2.b.a.a.a;
import android.annotation.TargetApi;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import io.reactivex.rxjava3.subjects.PublishSubject;
import java.util.HashMap;
import java.util.Map;
public class RxPermissionsFragment extends Fragment {
    public Map<String, PublishSubject<Permission>> a = new HashMap();
    public boolean b;

    public void a(String str) {
        if (this.b) {
            Object obj = RxPermissions.b;
        }
    }

    public boolean containsByPermission(@NonNull String str) {
        return this.a.containsKey(str);
    }

    public PublishSubject<Permission> getSubjectByPermission(@NonNull String str) {
        return this.a.get(str);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
    }

    @Override // androidx.fragment.app.Fragment
    @TargetApi(23)
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == 42) {
            boolean[] zArr = new boolean[strArr.length];
            for (int i2 = 0; i2 < strArr.length; i2++) {
                zArr[i2] = shouldShowRequestPermissionRationale(strArr[i2]);
            }
            int length = strArr.length;
            for (int i3 = 0; i3 < length; i3++) {
                StringBuilder L = a.L("onRequestPermissionsResult  ");
                L.append(strArr[i3]);
                a(L.toString());
                PublishSubject<Permission> publishSubject = this.a.get(strArr[i3]);
                if (publishSubject == null) {
                    Object obj = RxPermissions.b;
                    return;
                }
                this.a.remove(strArr[i3]);
                publishSubject.onNext(new Permission(strArr[i3], iArr[i3] == 0, zArr[i3]));
                publishSubject.onComplete();
            }
        }
    }

    public void setLogging(boolean z) {
        this.b = z;
    }

    public void setSubjectForPermission(@NonNull String str, @NonNull PublishSubject<Permission> publishSubject) {
        this.a.put(str, publishSubject);
    }
}
