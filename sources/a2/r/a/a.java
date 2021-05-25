package a2.r.a;

import com.tbruyelle.rxpermissions3.Permission;
import io.reactivex.rxjava3.functions.BiConsumer;
public class a implements BiConsumer<StringBuilder, String> {
    public a(Permission permission) {
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.BiConsumer
    public void accept(StringBuilder sb, String str) throws Throwable {
        StringBuilder sb2 = sb;
        String str2 = str;
        if (sb2.length() == 0) {
            sb2.append(str2);
            return;
        }
        sb2.append(", ");
        sb2.append(str2);
    }
}
