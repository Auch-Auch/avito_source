package a2.j.e.i;

import com.google.firebase.iid.InstanceIdResult;
public final class r implements InstanceIdResult {
    public final String a;
    public final String b;

    public r(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    @Override // com.google.firebase.iid.InstanceIdResult
    public final String getId() {
        return this.a;
    }

    @Override // com.google.firebase.iid.InstanceIdResult
    public final String getToken() {
        return this.b;
    }
}
