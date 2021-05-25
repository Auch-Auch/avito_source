package a2.j.e.d.d.a;

import a2.j.e.d.d.a.u;
import android.os.Build;
import com.google.firebase.crashlytics.internal.proto.CodedOutputStream;
import com.google.firebase.crashlytics.internal.proto.SessionProtobufHelper;
public class v implements u.g {
    public final /* synthetic */ int a;
    public final /* synthetic */ int b;
    public final /* synthetic */ long c;
    public final /* synthetic */ long d;
    public final /* synthetic */ boolean e;
    public final /* synthetic */ int f;

    public v(u uVar, int i, String str, int i2, long j, long j2, boolean z, int i3, String str2, String str3) {
        this.a = i;
        this.b = i2;
        this.c = j;
        this.d = j2;
        this.e = z;
        this.f = i3;
    }

    @Override // a2.j.e.d.d.a.u.g
    public void a(CodedOutputStream codedOutputStream) throws Exception {
        SessionProtobufHelper.writeSessionDevice(codedOutputStream, this.a, Build.MODEL, this.b, this.c, this.d, this.e, this.f, Build.MANUFACTURER, Build.PRODUCT);
    }
}
