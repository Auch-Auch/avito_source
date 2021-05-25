package a2.j.b.b.y0;

import com.google.android.exoplayer2.scheduler.RequirementsWatcher;
public final /* synthetic */ class a implements Runnable {
    public final /* synthetic */ RequirementsWatcher.c a;

    public /* synthetic */ a(RequirementsWatcher.c cVar) {
        this.a = cVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int notMetRequirements;
        RequirementsWatcher requirementsWatcher = RequirementsWatcher.this;
        if (requirementsWatcher.g != null && requirementsWatcher.f != (notMetRequirements = requirementsWatcher.c.getNotMetRequirements(requirementsWatcher.a))) {
            requirementsWatcher.f = notMetRequirements;
            requirementsWatcher.b.onRequirementsStateChanged(requirementsWatcher, notMetRequirements);
        }
    }
}
