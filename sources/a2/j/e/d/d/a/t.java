package a2.j.e.d.d.a;

import a2.j.e.d.d.a.u;
import android.os.Build;
import com.google.firebase.crashlytics.internal.proto.CodedOutputStream;
import com.google.firebase.crashlytics.internal.proto.SessionProtobufHelper;
public class t implements u.g {
    public final /* synthetic */ boolean a;

    public t(u uVar, String str, String str2, boolean z) {
        this.a = z;
    }

    @Override // a2.j.e.d.d.a.u.g
    public void a(CodedOutputStream codedOutputStream) throws Exception {
        SessionProtobufHelper.writeSessionOS(codedOutputStream, Build.VERSION.RELEASE, Build.VERSION.CODENAME, this.a);
    }
}
