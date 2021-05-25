package a2.a.a.e2.r;

import com.avito.android.validation.SubmissionListener;
import com.avito.conveyor_item.Item;
import io.reactivex.functions.Function;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
public final class a0<T, R> implements Function<SubmissionListener.SubmissionState, Pair<? extends SubmissionListener.SubmissionState, ? extends List<? extends Item>>> {
    public final /* synthetic */ List a;

    public a0(List list) {
        this.a = list;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public Pair<? extends SubmissionListener.SubmissionState, ? extends List<? extends Item>> apply(SubmissionListener.SubmissionState submissionState) {
        SubmissionListener.SubmissionState submissionState2 = submissionState;
        Intrinsics.checkNotNullParameter(submissionState2, "it");
        return TuplesKt.to(submissionState2, this.a);
    }
}
