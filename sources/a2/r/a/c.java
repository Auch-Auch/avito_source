package a2.r.a;

import com.tbruyelle.rxpermissions3.Permission;
import io.reactivex.rxjava3.functions.Predicate;
public class c implements Predicate<Permission> {
    public c(Permission permission) {
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Predicate
    public boolean test(Permission permission) throws Throwable {
        return permission.granted;
    }
}
