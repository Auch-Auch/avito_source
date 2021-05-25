package a2.j.e.d.d.a;

import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.Map;
import java.util.concurrent.Callable;
import org.json.JSONObject;
public class n implements Callable<Void> {
    public final /* synthetic */ Map a;
    public final /* synthetic */ u b;

    public n(u uVar, Map map) {
        this.b = uVar;
        this.a = map;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public Void call() throws Exception {
        BufferedWriter bufferedWriter;
        Throwable th;
        Exception e;
        String g = this.b.g();
        m0 m0Var = new m0(this.b.j());
        Map map = this.a;
        File a3 = m0Var.a(g);
        BufferedWriter bufferedWriter2 = null;
        try {
            String jSONObject = new JSONObject(map).toString();
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(a3), m0.b));
            try {
                bufferedWriter.write(jSONObject);
                bufferedWriter.flush();
            } catch (Exception e2) {
                e = e2;
            } catch (Throwable th2) {
                th = th2;
                CommonUtils.closeOrLog(bufferedWriter, "Failed to close key/value metadata file.");
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            bufferedWriter = null;
            try {
                Logger.getLogger().e("Error serializing key/value metadata.", e);
                CommonUtils.closeOrLog(bufferedWriter, "Failed to close key/value metadata file.");
                return null;
            } catch (Throwable th3) {
                th = th3;
                bufferedWriter2 = bufferedWriter;
                bufferedWriter = bufferedWriter2;
                CommonUtils.closeOrLog(bufferedWriter, "Failed to close key/value metadata file.");
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            bufferedWriter = bufferedWriter2;
            CommonUtils.closeOrLog(bufferedWriter, "Failed to close key/value metadata file.");
            throw th;
        }
        CommonUtils.closeOrLog(bufferedWriter, "Failed to close key/value metadata file.");
        return null;
    }
}
