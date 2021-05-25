package a2.j.e.d.d.a;

import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.google.firebase.crashlytics.internal.common.UserMetadata;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.concurrent.Callable;
public class m implements Callable<Void> {
    public final /* synthetic */ UserMetadata a;
    public final /* synthetic */ u b;

    public m(u uVar, UserMetadata userMetadata) {
        this.b = uVar;
        this.a = userMetadata;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public Void call() throws Exception {
        BufferedWriter bufferedWriter;
        Throwable th;
        Exception e;
        q0 q0Var = this.b.t;
        String str = q0Var.f;
        if (str == null) {
            Logger.getLogger().d("Could not persist user ID; no current session");
        } else {
            String userId = q0Var.e.getUserId();
            if (userId == null) {
                Logger.getLogger().d("Could not persist user ID; no user ID available");
            } else {
                q0Var.b.persistUserIdForSession(userId, str);
            }
        }
        String g = this.b.g();
        m0 m0Var = new m0(this.b.j());
        UserMetadata userMetadata = this.a;
        File b2 = m0Var.b(g);
        BufferedWriter bufferedWriter2 = null;
        try {
            String jSONObject = new l0(userMetadata).toString();
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(b2), m0.b));
            try {
                bufferedWriter.write(jSONObject);
                bufferedWriter.flush();
            } catch (Exception e2) {
                e = e2;
            } catch (Throwable th2) {
                th = th2;
                CommonUtils.closeOrLog(bufferedWriter, "Failed to close user metadata file.");
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            bufferedWriter = null;
            try {
                Logger.getLogger().e("Error serializing user metadata.", e);
                CommonUtils.closeOrLog(bufferedWriter, "Failed to close user metadata file.");
                return null;
            } catch (Throwable th3) {
                th = th3;
                bufferedWriter2 = bufferedWriter;
                bufferedWriter = bufferedWriter2;
                CommonUtils.closeOrLog(bufferedWriter, "Failed to close user metadata file.");
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            bufferedWriter = bufferedWriter2;
            CommonUtils.closeOrLog(bufferedWriter, "Failed to close user metadata file.");
            throw th;
        }
        CommonUtils.closeOrLog(bufferedWriter, "Failed to close user metadata file.");
        return null;
    }
}
