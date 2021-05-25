package a2.j.e.i;

import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.iid.FirebaseInstanceId;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
public class q implements a {
    public final ExecutorService a;

    public q(ExecutorService executorService) {
        this.a = executorService;
    }

    @Override // a2.j.e.i.a
    public Task<Integer> process(Intent intent) {
        return Tasks.call(this.a, new Callable(intent) { // from class: a2.j.e.i.p
            public final Intent a;

            {
                this.a = r1;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                Intent intent2 = this.a;
                String stringExtra = intent2.getStringExtra("CMD");
                if (stringExtra != null) {
                    if (Log.isLoggable("FirebaseInstanceId", 3)) {
                        String valueOf = String.valueOf(intent2.getExtras());
                        stringExtra.length();
                        valueOf.length();
                    }
                    if ("RST".equals(stringExtra) || "RST_FULL".equals(stringExtra)) {
                        FirebaseInstanceId.getInstance().m();
                    } else if ("SYNC".equals(stringExtra)) {
                        FirebaseInstanceId instance = FirebaseInstanceId.getInstance();
                        i0 i0Var = FirebaseInstanceId.j;
                        String g = instance.g();
                        synchronized (i0Var) {
                            String concat = String.valueOf(g).concat("|T|");
                            SharedPreferences.Editor edit = i0Var.a.edit();
                            for (String str : i0Var.a.getAll().keySet()) {
                                if (str.startsWith(concat)) {
                                    edit.remove(str);
                                }
                            }
                            edit.commit();
                        }
                        instance.o();
                    }
                }
                return -1;
            }
        });
    }
}
