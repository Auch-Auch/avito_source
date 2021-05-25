package v6.a.a;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import net.gotev.uploadservice.UploadServiceConfig;
public final class a extends Lambda implements Function0<String> {
    public static final a a = new a();

    public a() {
        super(0);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public String invoke() {
        StringBuilder L = a2.b.a.a.a.L("Service is about to be stopped because idle timeout of ");
        L.append(UploadServiceConfig.getIdleTimeoutSeconds());
        L.append("s has been reached");
        return L.toString();
    }
}
