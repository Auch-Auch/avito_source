package a2.j.e.d.d.a;

import a2.j.e.d.d.a.u;
import com.google.firebase.crashlytics.internal.proto.CodedOutputStream;
import com.google.firebase.crashlytics.internal.proto.SessionProtobufHelper;
public class s implements u.g {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ int e;
    public final /* synthetic */ u f;

    public s(u uVar, String str, String str2, String str3, String str4, int i) {
        this.f = uVar;
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = i;
    }

    @Override // a2.j.e.d.d.a.u.g
    public void a(CodedOutputStream codedOutputStream) throws Exception {
        SessionProtobufHelper.writeSessionApp(codedOutputStream, this.a, this.b, this.c, this.d, this.e, this.f.r);
    }
}
