package com.avito.android.util;

import arrow.core.Option;
import arrow.core.OptionKt;
import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a)\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"T", "Lcom/google/android/gms/tasks/Task;", "Lio/reactivex/Single;", "Larrow/core/Option;", "toSingle", "(Lcom/google/android/gms/tasks/Task;)Lio/reactivex/Single;", "core_release"}, k = 2, mv = {1, 4, 2})
public final class GmsTasksKt {

    public static final class a<T> implements SingleOnSubscribe<Option<? extends T>> {
        public final /* synthetic */ Task a;

        /* renamed from: com.avito.android.util.GmsTasksKt$a$a  reason: collision with other inner class name */
        public static final class C0166a<TResult> implements OnSuccessListener<T> {
            public final /* synthetic */ SingleEmitter a;

            public C0166a(SingleEmitter singleEmitter) {
                this.a = singleEmitter;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: io.reactivex.SingleEmitter */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(T t) {
                SingleEmitter singleEmitter = this.a;
                Intrinsics.checkNotNullExpressionValue(singleEmitter, "emitter");
                if (!singleEmitter.isDisposed()) {
                    this.a.onSuccess(OptionKt.toOption(t));
                }
            }
        }

        public static final class b implements OnCanceledListener {
            public final /* synthetic */ SingleEmitter a;

            public b(SingleEmitter singleEmitter) {
                this.a = singleEmitter;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: io.reactivex.SingleEmitter */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.android.gms.tasks.OnCanceledListener
            public final void onCanceled() {
                SingleEmitter singleEmitter = this.a;
                Intrinsics.checkNotNullExpressionValue(singleEmitter, "emitter");
                if (!singleEmitter.isDisposed()) {
                    this.a.onSuccess(Option.Companion.empty());
                }
            }
        }

        public static final class c implements OnFailureListener {
            public final /* synthetic */ SingleEmitter a;

            public c(SingleEmitter singleEmitter) {
                this.a = singleEmitter;
            }

            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(@NotNull Exception exc) {
                Intrinsics.checkNotNullParameter(exc, "error");
                SingleEmitter singleEmitter = this.a;
                Intrinsics.checkNotNullExpressionValue(singleEmitter, "emitter");
                if (!singleEmitter.isDisposed()) {
                    this.a.onError(exc);
                }
            }
        }

        public a(Task task) {
            this.a = task;
        }

        @Override // io.reactivex.SingleOnSubscribe
        public final void subscribe(@NotNull SingleEmitter<Option<T>> singleEmitter) {
            Intrinsics.checkNotNullParameter(singleEmitter, "emitter");
            this.a.addOnSuccessListener(new C0166a(singleEmitter));
            this.a.addOnCanceledListener(new b(singleEmitter));
            this.a.addOnFailureListener(new c(singleEmitter));
        }
    }

    @NotNull
    public static final <T> Single<Option<T>> toSingle(@NotNull Task<T> task) {
        Intrinsics.checkNotNullParameter(task, "$this$toSingle");
        Single<Option<T>> create = Single.create(new a(task));
        Intrinsics.checkNotNullExpressionValue(create, "Single.create { emitter …        }\n        }\n    }");
        return create;
    }
}
