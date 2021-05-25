package a2.j.e.d.d.a;

import a2.j.e.d.d.a.u;
import com.google.firebase.crashlytics.internal.proto.CodedOutputStream;
import com.google.firebase.crashlytics.internal.proto.SessionProtobufHelper;
public class r implements u.g {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ long c;

    public r(u uVar, String str, String str2, long j) {
        this.a = str;
        this.b = str2;
        this.c = j;
    }

    @Override // a2.j.e.d.d.a.u.g
    public void a(CodedOutputStream codedOutputStream) throws Exception {
        SessionProtobufHelper.writeBeginSession(codedOutputStream, this.a, this.b, this.c);
    }
}
