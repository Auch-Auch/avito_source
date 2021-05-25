package a2.r.a;

import com.tbruyelle.rxpermissions3.Permission;
import io.reactivex.rxjava3.functions.Function;
public class b implements Function<Permission, String> {
    public b(Permission permission) {
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public String apply(Permission permission) throws Throwable {
        return permission.name;
    }
}
