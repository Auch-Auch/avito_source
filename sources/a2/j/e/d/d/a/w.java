package a2.j.e.d.d.a;

import a2.j.e.d.d.a.u;
import com.google.firebase.crashlytics.internal.common.UserMetadata;
import com.google.firebase.crashlytics.internal.proto.CodedOutputStream;
import com.google.firebase.crashlytics.internal.proto.SessionProtobufHelper;
public class w implements u.g {
    public final /* synthetic */ UserMetadata a;

    public w(u uVar, UserMetadata userMetadata) {
        this.a = userMetadata;
    }

    @Override // a2.j.e.d.d.a.u.g
    public void a(CodedOutputStream codedOutputStream) throws Exception {
        SessionProtobufHelper.writeSessionUser(codedOutputStream, this.a.getUserId(), null, null);
    }
}
