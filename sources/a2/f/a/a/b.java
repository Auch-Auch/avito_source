package a2.f.a.a;

import androidx.annotation.RestrictTo;
import com.evernote.android.job.Job;
import com.evernote.android.job.JobCreator;
import com.evernote.android.job.util.JobCat;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class b {
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
