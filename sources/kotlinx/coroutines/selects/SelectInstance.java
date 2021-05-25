package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.internal.AtomicDesc;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.ok.android.sdk.OkListener;
@InternalCoroutinesApi
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u0002J\u000f\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0004\u0010\u0005J!\u0010\t\u001a\u0004\u0018\u00010\u00022\u000e\u0010\b\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\r\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH&¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0014H&¢\u0006\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0018\u001a\u00020\u00038&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0005R\u001c\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u00198&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, d2 = {"Lkotlinx/coroutines/selects/SelectInstance;", "R", "", "", "trySelect", "()Z", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "Lkotlinx/coroutines/internal/PrepareOp;", "otherOp", "trySelectOther", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;)Ljava/lang/Object;", "Lkotlinx/coroutines/internal/AtomicDesc;", "desc", "performAtomicTrySelect", "(Lkotlinx/coroutines/internal/AtomicDesc;)Ljava/lang/Object;", "", OkListener.KEY_EXCEPTION, "", "resumeSelectWithException", "(Ljava/lang/Throwable;)V", "Lkotlinx/coroutines/DisposableHandle;", "handle", "disposeOnSelect", "(Lkotlinx/coroutines/DisposableHandle;)V", "isSelected", "Lkotlin/coroutines/Continuation;", "getCompletion", "()Lkotlin/coroutines/Continuation;", "completion", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
public interface SelectInstance<R> {
    void disposeOnSelect(@NotNull DisposableHandle disposableHandle);

    @NotNull
    Continuation<R> getCompletion();

    boolean isSelected();

    @Nullable
    Object performAtomicTrySelect(@NotNull AtomicDesc atomicDesc);

    void resumeSelectWithException(@NotNull Throwable th);

    boolean trySelect();

    @Nullable
    Object trySelectOther(@Nullable LockFreeLinkedListNode.PrepareOp prepareOp);
}
