package com.sumsub.sns.core.domain;

import com.avito.android.remote.auth.AuthSource;
import com.sumsub.sns.core.ServiceLocator;
import com.sumsub.sns.core.data.source.cache.CacheRepository;
import com.sumsub.sns.core.domain.base.BaseDirectUseCase;
import java.io.File;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0010B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fB\u0011\b\u0016\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000b\u0010\u000fJ\u001b\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"Lcom/sumsub/sns/core/domain/AddDirectFileToCacheUseCase;", "Lcom/sumsub/sns/core/domain/base/BaseDirectUseCase;", "Ljava/io/File;", "Lcom/sumsub/sns/core/domain/AddDirectFileToCacheUseCase$Params;", "params", "run", "(Lcom/sumsub/sns/core/domain/AddDirectFileToCacheUseCase$Params;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/sumsub/sns/core/data/source/cache/CacheRepository;", AuthSource.SEND_ABUSE, "Lcom/sumsub/sns/core/data/source/cache/CacheRepository;", "repository", "<init>", "(Lcom/sumsub/sns/core/data/source/cache/CacheRepository;)V", "Lcom/sumsub/sns/core/ServiceLocator;", "serviceLocator", "(Lcom/sumsub/sns/core/ServiceLocator;)V", "Params", "sns-core_release"}, k = 1, mv = {1, 4, 2})
public final class AddDirectFileToCacheUseCase extends BaseDirectUseCase<File, Params> {
    public final CacheRepository a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/sumsub/sns/core/domain/AddDirectFileToCacheUseCase$Params;", "", "", AuthSource.BOOKING_ORDER, "[B", "getData", "()[B", "data", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "name", "<init>", "(Ljava/lang/String;[B)V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class Params {
        @Nullable
        public final String a;
        @NotNull
        public final byte[] b;

        public Params(@Nullable String str, @NotNull byte[] bArr) {
            Intrinsics.checkNotNullParameter(bArr, "data");
            this.a = str;
            this.b = bArr;
        }

        @NotNull
        public final byte[] getData() {
            return this.b;
        }

        @Nullable
        public final String getName() {
            return this.a;
        }
    }

    public AddDirectFileToCacheUseCase(@NotNull CacheRepository cacheRepository) {
        Intrinsics.checkNotNullParameter(cacheRepository, "repository");
        this.a = cacheRepository;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public AddDirectFileToCacheUseCase(@NotNull ServiceLocator serviceLocator) {
        this(serviceLocator.getCacheRepository());
        Intrinsics.checkNotNullParameter(serviceLocator, "serviceLocator");
    }

    @Nullable
    public Object run(@NotNull Params params, @NotNull Continuation<? super File> continuation) {
        CacheRepository cacheRepository = this.a;
        String name = params.getName();
        if (name == null) {
            name = UUID.randomUUID().toString() + ".jpg";
        }
        return cacheRepository.addFileToCache(name, params.getData(), continuation);
    }
}
