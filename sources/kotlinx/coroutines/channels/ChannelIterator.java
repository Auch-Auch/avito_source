package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.JvmName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002J\u0013\u0010\u0004\u001a\u00020\u0003H¦Bø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\u0007\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0005J\u0010\u0010\u0006\u001a\u00028\u0000H¦\u0002¢\u0006\u0004\b\u0006\u0010\b\u0002\u0004\n\u0002\b\u0019¨\u0006\t"}, d2 = {"Lkotlinx/coroutines/channels/ChannelIterator;", ExifInterface.LONGITUDE_EAST, "", "", "hasNext", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "next", "next0", "()Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
public interface ChannelIterator<E> {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
    public static final class DefaultImpls {

        @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelIterator$DefaultImpls", f = "Channel.kt", i = {0}, l = {458}, m = "next", n = {"$this"}, s = {"L$0"})
        public static final class a extends ContinuationImpl {
            public /* synthetic */ Object a;
            public int b;
            public final /* synthetic */ ChannelIterator c;
            public Object d;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(ChannelIterator channelIterator, Continuation continuation) {
                super(continuation);
                this.c = channelIterator;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                this.a = obj;
                this.b |= Integer.MIN_VALUE;
                return DefaultImpls.next(null, this);
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x004b  */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x0050  */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
        @kotlin.jvm.JvmName(name = "next")
        @org.jetbrains.annotations.Nullable
        @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Since 1.3.0, binary compatibility with versions <= 1.2.x")
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static /* synthetic */ <E> java.lang.Object next(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ChannelIterator<? extends E> r4, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super E> r5) {
            /*
                boolean r0 = r5 instanceof kotlinx.coroutines.channels.ChannelIterator.DefaultImpls.a
                if (r0 == 0) goto L_0x0013
                r0 = r5
                kotlinx.coroutines.channels.ChannelIterator$DefaultImpls$a r0 = (kotlinx.coroutines.channels.ChannelIterator.DefaultImpls.a) r0
                int r1 = r0.b
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L_0x0013
                int r1 = r1 - r2
                r0.b = r1
                goto L_0x0018
            L_0x0013:
                kotlinx.coroutines.channels.ChannelIterator$DefaultImpls$a r0 = new kotlinx.coroutines.channels.ChannelIterator$DefaultImpls$a
                r0.<init>(r4, r5)
            L_0x0018:
                java.lang.Object r5 = r0.a
                java.lang.Object r1 = t6.p.a.a.getCOROUTINE_SUSPENDED()
                int r2 = r0.b
                r3 = 1
                if (r2 == 0) goto L_0x0035
                if (r2 != r3) goto L_0x002d
                java.lang.Object r4 = r0.d
                kotlinx.coroutines.channels.ChannelIterator r4 = (kotlinx.coroutines.channels.ChannelIterator) r4
                kotlin.ResultKt.throwOnFailure(r5)
                goto L_0x0043
            L_0x002d:
                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                r4.<init>(r5)
                throw r4
            L_0x0035:
                kotlin.ResultKt.throwOnFailure(r5)
                r0.d = r4
                r0.b = r3
                java.lang.Object r5 = r4.hasNext(r0)
                if (r5 != r1) goto L_0x0043
                return r1
            L_0x0043:
                java.lang.Boolean r5 = (java.lang.Boolean) r5
                boolean r5 = r5.booleanValue()
                if (r5 == 0) goto L_0x0050
                java.lang.Object r4 = r4.next()
                return r4
            L_0x0050:
                kotlinx.coroutines.channels.ClosedReceiveChannelException r4 = new kotlinx.coroutines.channels.ClosedReceiveChannelException
                java.lang.String r5 = "Channel was closed"
                r4.<init>(r5)
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelIterator.DefaultImpls.next(kotlinx.coroutines.channels.ChannelIterator, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }

    @Nullable
    Object hasNext(@NotNull Continuation<? super Boolean> continuation);

    E next();

    @JvmName(name = "next")
    @Nullable
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.3.0, binary compatibility with versions <= 1.2.x")
    /* synthetic */ Object next(@NotNull Continuation<? super E> continuation);
}
