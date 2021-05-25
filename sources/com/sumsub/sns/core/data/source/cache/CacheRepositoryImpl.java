package com.sumsub.sns.core.data.source.cache;

import android.content.Context;
import com.avito.android.remote.auth.AuthSource;
import java.io.File;
import java.io.FileOutputStream;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import timber.log.Timber;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010J#\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"Lcom/sumsub/sns/core/data/source/cache/CacheRepositoryImpl;", "Lcom/sumsub/sns/core/data/source/cache/CacheRepository;", "", "name", "", "data", "Ljava/io/File;", "addFileToCache", "(Ljava/lang/String;[BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createNewFile", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroid/content/Context;", AuthSource.SEND_ABUSE, "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
public final class CacheRepositoryImpl implements CacheRepository {
    public final Context a;

    @DebugMetadata(c = "com.sumsub.sns.core.data.source.cache.CacheRepositoryImpl$addFileToCache$2", f = "CacheRepositoryImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super File>, Object> {
        public final /* synthetic */ CacheRepositoryImpl b;
        public final /* synthetic */ String c;
        public final /* synthetic */ byte[] d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(CacheRepositoryImpl cacheRepositoryImpl, String str, byte[] bArr, Continuation continuation) {
            super(2, continuation);
            this.b = cacheRepositoryImpl;
            this.c = str;
            this.d = bArr;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            Intrinsics.checkNotNullParameter(continuation, "completion");
            return new a(this.b, this.c, this.d, continuation);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super File> continuation) {
            Continuation<? super File> continuation2 = continuation;
            Intrinsics.checkNotNullParameter(continuation2, "completion");
            return new a(this.b, this.c, this.d, continuation2).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            t6.p.a.a.getCOROUTINE_SUSPENDED();
            ResultKt.throwOnFailure(obj);
            File file = new File(this.b.a.getCacheDir(), this.c);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                fileOutputStream.write(this.d);
                return file;
            } finally {
                fileOutputStream.flush();
                fileOutputStream.close();
            }
        }
    }

    @DebugMetadata(c = "com.sumsub.sns.core.data.source.cache.CacheRepositoryImpl$createNewFile$2", f = "CacheRepositoryImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super File>, Object> {
        public final /* synthetic */ CacheRepositoryImpl b;
        public final /* synthetic */ String c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(CacheRepositoryImpl cacheRepositoryImpl, String str, Continuation continuation) {
            super(2, continuation);
            this.b = cacheRepositoryImpl;
            this.c = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            Intrinsics.checkNotNullParameter(continuation, "completion");
            return new b(this.b, this.c, continuation);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super File> continuation) {
            Continuation<? super File> continuation2 = continuation;
            Intrinsics.checkNotNullParameter(continuation2, "completion");
            return new b(this.b, this.c, continuation2).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            t6.p.a.a.getCOROUTINE_SUSPENDED();
            ResultKt.throwOnFailure(obj);
            File file = new File(this.b.a.getCacheDir(), this.c);
            try {
                file.createNewFile();
            } catch (Exception e) {
                Timber.e(e);
            }
            return file;
        }
    }

    public CacheRepositoryImpl(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = context;
    }

    @Override // com.sumsub.sns.core.data.source.cache.CacheRepository
    @Nullable
    public Object addFileToCache(@NotNull String str, @NotNull byte[] bArr, @NotNull Continuation<? super File> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new a(this, str, bArr, null), continuation);
    }

    @Override // com.sumsub.sns.core.data.source.cache.CacheRepository
    @Nullable
    public Object createNewFile(@NotNull String str, @NotNull Continuation<? super File> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new b(this, str, null), continuation);
    }
}
