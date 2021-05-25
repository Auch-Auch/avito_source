package a2.f.a.a.i.a;

import com.evernote.android.job.patched.internal.Job;
import com.evernote.android.job.patched.internal.JobCreator;
import com.evernote.android.job.patched.internal.util.JobCat;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
public class a {
    public static final JobCat b = new JobCat("JobCreatorHolder");
    public final List<JobCreator> a = new CopyOnWriteArrayList();

    public Job a(String str) {
        Job job = null;
        boolean z = false;
        for (JobCreator jobCreator : this.a) {
            z = true;
            job = jobCreator.create(str);
            if (job != null) {
                break;
            }
        }
        if (!z) {
            b.w("no JobCreator added");
        }
        return job;
    }
}
