package com.avito.android.validation;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.context_actions.PlatformActions;
import com.avito.android.validation.ValidationResult;
import com.avito.conveyor_item.Item;
import io.reactivex.Completable;
import io.reactivex.Single;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u000eJ#\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Lcom/avito/android/validation/SubmissionListener;", "", "", "Lcom/avito/conveyor_item/Item;", PlatformActions.ItemsList.TYPE, "Lio/reactivex/Single;", "Lcom/avito/android/validation/SubmissionListener$SubmissionState;", "onSubmissionRequested", "(Ljava/util/List;)Lio/reactivex/Single;", "", "paramId", "Lio/reactivex/Completable;", "validateParameter", "(Ljava/lang/String;)Lio/reactivex/Completable;", "SubmissionState", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
public interface SubmissionListener {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/validation/SubmissionListener$SubmissionState;", "", "<init>", "()V", "Available", "Unavailable", "Lcom/avito/android/validation/SubmissionListener$SubmissionState$Available;", "Lcom/avito/android/validation/SubmissionListener$SubmissionState$Unavailable;", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class SubmissionState {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/validation/SubmissionListener$SubmissionState$Available;", "Lcom/avito/android/validation/SubmissionListener$SubmissionState;", "<init>", "()V", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
        public static final class Available extends SubmissionState {
            public Available() {
                super(null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0011\u001a\u00020\t\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002¢\u0006\u0004\b\u0012\u0010\u0013R!\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0019\u0010\u000e\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0011\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\r¨\u0006\u0014"}, d2 = {"Lcom/avito/android/validation/SubmissionListener$SubmissionState$Unavailable;", "Lcom/avito/android/validation/SubmissionListener$SubmissionState;", "", "Lcom/avito/android/validation/ValidationResult$Failure;", "c", "Ljava/util/List;", "getFailures", "()Ljava/util/List;", "failures", "", AuthSource.BOOKING_ORDER, "Z", "getHasWarningsOnFlowFinish", "()Z", "hasWarningsOnFlowFinish", AuthSource.SEND_ABUSE, "getHasErrors", "hasErrors", "<init>", "(ZZLjava/util/List;)V", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
        public static final class Unavailable extends SubmissionState {
            public final boolean a;
            public final boolean b;
            @Nullable
            public final List<ValidationResult.Failure> c;

            /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.List<? extends com.avito.android.validation.ValidationResult$Failure> */
            /* JADX WARN: Multi-variable type inference failed */
            public Unavailable(boolean z, boolean z2, @Nullable List<? extends ValidationResult.Failure> list) {
                super(null);
                this.a = z;
                this.b = z2;
                this.c = list;
            }

            @Nullable
            public final List<ValidationResult.Failure> getFailures() {
                return this.c;
            }

            public final boolean getHasErrors() {
                return this.a;
            }

            public final boolean getHasWarningsOnFlowFinish() {
                return this.b;
            }
        }

        public SubmissionState() {
        }

        public SubmissionState(j jVar) {
        }
    }

    @NotNull
    Single<SubmissionState> onSubmissionRequested(@NotNull List<? extends Item> list);

    @NotNull
    Completable validateParameter(@NotNull String str);
}
