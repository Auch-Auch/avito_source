package a2.a.a.j.a;

import com.avito.android.app.task.PublishDraftsSyncTask;
import com.avito.android.publish.drafts.PublishDraftRepository;
import io.reactivex.functions.Function;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
public final class k0<T, R> implements Function<PublishDraftRepository.DraftSyncResult, PublishDraftRepository.DraftSyncResult> {
    public static final k0 a = new k0();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public PublishDraftRepository.DraftSyncResult apply(PublishDraftRepository.DraftSyncResult draftSyncResult) {
        PublishDraftRepository.DraftSyncResult draftSyncResult2 = draftSyncResult;
        Intrinsics.checkNotNullParameter(draftSyncResult2, "it");
        int ordinal = draftSyncResult2.ordinal();
        if (ordinal == 0) {
            return draftSyncResult2;
        }
        if (ordinal != 1) {
            throw new NoWhenBranchMatchedException();
        }
        throw new PublishDraftsSyncTask.a();
    }
}
