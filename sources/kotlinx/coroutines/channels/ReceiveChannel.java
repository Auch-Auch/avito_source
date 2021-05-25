package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import com.vk.sdk.api.model.VKAttachments;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.coroutines.Continuation;
import kotlin.internal.LowPriorityInOverloadResolution;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.ObsoleteCoroutinesApi;
import kotlinx.coroutines.selects.SelectClause1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002J\u0013\u0010\u0003\u001a\u00028\u0000H¦@ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\u0004\u0018\u00018\u0000H§@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0004J\u001f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H§@ø\u0001\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0007\u0010\u0004J\u0011\u0010\t\u001a\u0004\u0018\u00018\u0000H&¢\u0006\u0004\b\t\u0010\nJ\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH¦\u0002¢\u0006\u0004\b\f\u0010\rJ!\u0010\u0012\u001a\u00020\u00112\u0010\b\u0002\u0010\u0010\u001a\n\u0018\u00010\u000ej\u0004\u0018\u0001`\u000fH&¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0012\u001a\u00020\u0011H\u0017¢\u0006\u0004\b\u0012\u0010\u0014J\u001b\u0010\u0012\u001a\u00020\u00162\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0015H'¢\u0006\u0004\b\u0012\u0010\u0017R$\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u00188&@'X§\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\u0014\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001d\u001a\u00020\u00168&@'X§\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010\u0014\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\u00188&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u001aR\u001c\u0010\"\u001a\u00020\u00168&@'X§\u0004¢\u0006\f\u0012\u0004\b#\u0010\u0014\u001a\u0004\b\"\u0010\u001eR+\u0010&\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00060\u00188&@'X§\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b%\u0010\u0014\u001a\u0004\b$\u0010\u001a\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006'"}, d2 = {"Lkotlinx/coroutines/channels/ReceiveChannel;", ExifInterface.LONGITUDE_EAST, "", "receive", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "receiveOrNull", "Lkotlinx/coroutines/channels/ValueOrClosed;", "receiveOrClosed-ZYPwvRU", "receiveOrClosed", VKAttachments.TYPE_POLL, "()Ljava/lang/Object;", "Lkotlinx/coroutines/channels/ChannelIterator;", "iterator", "()Lkotlinx/coroutines/channels/ChannelIterator;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "cause", "", "cancel", "(Ljava/util/concurrent/CancellationException;)V", "()V", "", "", "(Ljava/lang/Throwable;)Z", "Lkotlinx/coroutines/selects/SelectClause1;", "getOnReceiveOrNull", "()Lkotlinx/coroutines/selects/SelectClause1;", "getOnReceiveOrNull$annotations", "onReceiveOrNull", "isClosedForReceive", "()Z", "isClosedForReceive$annotations", "getOnReceive", "onReceive", "isEmpty", "isEmpty$annotations", "getOnReceiveOrClosed", "getOnReceiveOrClosed$annotations", "onReceiveOrClosed", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
public interface ReceiveChannel<E> {
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    /* synthetic */ void cancel();

    void cancel(@Nullable CancellationException cancellationException);

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    /* synthetic */ boolean cancel(@Nullable Throwable th);

    @NotNull
    SelectClause1<E> getOnReceive();

    @NotNull
    SelectClause1<ValueOrClosed<E>> getOnReceiveOrClosed();

    @NotNull
    SelectClause1<E> getOnReceiveOrNull();

    boolean isClosedForReceive();

    boolean isEmpty();

    @NotNull
    ChannelIterator<E> iterator();

    @Nullable
    E poll();

    @Nullable
    Object receive(@NotNull Continuation<? super E> continuation);

    @InternalCoroutinesApi
    @Nullable
    /* renamed from: receiveOrClosed-ZYPwvRU */
    Object mo500receiveOrClosedZYPwvRU(@NotNull Continuation<? super ValueOrClosed<? extends E>> continuation);

    @ObsoleteCoroutinesApi
    @Nullable
    @Deprecated(level = DeprecationLevel.WARNING, message = "Deprecated in favor of receiveOrClosed and receiveOrNull extension", replaceWith = @ReplaceWith(expression = "receiveOrNull", imports = {"kotlinx.coroutines.channels.receiveOrNull"}))
    @LowPriorityInOverloadResolution
    Object receiveOrNull(@NotNull Continuation<? super E> continuation);

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
    public static final class DefaultImpls {
        public static /* synthetic */ void cancel$default(ReceiveChannel receiveChannel, CancellationException cancellationException, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    cancellationException = null;
                }
                receiveChannel.cancel(cancellationException);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
        }

        @InternalCoroutinesApi
        public static /* synthetic */ void getOnReceiveOrClosed$annotations() {
        }

        @Deprecated(level = DeprecationLevel.WARNING, message = "Deprecated in favor of onReceiveOrClosed and onReceiveOrNull extension", replaceWith = @ReplaceWith(expression = "onReceiveOrNull", imports = {"kotlinx.coroutines.channels.onReceiveOrNull"}))
        @LowPriorityInOverloadResolution
        @ObsoleteCoroutinesApi
        public static /* synthetic */ void getOnReceiveOrNull$annotations() {
        }

        @ExperimentalCoroutinesApi
        public static /* synthetic */ void isClosedForReceive$annotations() {
        }

        @ExperimentalCoroutinesApi
        public static /* synthetic */ void isEmpty$annotations() {
        }

        public static /* synthetic */ boolean cancel$default(ReceiveChannel receiveChannel, Throwable th, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    th = null;
                }
                return receiveChannel.cancel(th);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
        }
    }
}
