package l6.d0.a.e;

import androidx.work.impl.WorkDatabase;
import androidx.work.impl.foreground.SystemForegroundDispatcher;
import androidx.work.impl.model.WorkSpec;
public class a implements Runnable {
    public final /* synthetic */ WorkDatabase a;
    public final /* synthetic */ String b;
    public final /* synthetic */ SystemForegroundDispatcher c;

    public a(SystemForegroundDispatcher systemForegroundDispatcher, WorkDatabase workDatabase, String str) {
        this.c = systemForegroundDispatcher;
        this.a = workDatabase;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        WorkSpec workSpec = this.a.workSpecDao().getWorkSpec(this.b);
        if (workSpec != null && workSpec.hasConstraints()) {
            synchronized (this.c.d) {
                this.c.h.put(this.b, workSpec);
                this.c.i.add(workSpec);
                SystemForegroundDispatcher systemForegroundDispatcher = this.c;
                systemForegroundDispatcher.j.replace(systemForegroundDispatcher.i);
            }
        }
    }
}
