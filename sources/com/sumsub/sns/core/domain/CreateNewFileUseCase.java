package com.sumsub.sns.core.domain;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.sumsub.sns.core.ServiceLocator;
import com.sumsub.sns.core.data.source.cache.CacheRepository;
import com.sumsub.sns.core.domain.base.BaseDirectUseCase;
import java.io.File;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0010B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fB\u0011\b\u0016\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000b\u0010\u000fJ\u001b\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"Lcom/sumsub/sns/core/domain/CreateNewFileUseCase;", "Lcom/sumsub/sns/core/domain/base/BaseDirectUseCase;", "Ljava/io/File;", "Lcom/sumsub/sns/core/domain/CreateNewFileUseCase$Params;", "params", "run", "(Lcom/sumsub/sns/core/domain/CreateNewFileUseCase$Params;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/sumsub/sns/core/data/source/cache/CacheRepository;", AuthSource.SEND_ABUSE, "Lcom/sumsub/sns/core/data/source/cache/CacheRepository;", "repository", "<init>", "(Lcom/sumsub/sns/core/data/source/cache/CacheRepository;)V", "Lcom/sumsub/sns/core/ServiceLocator;", "serviceLocator", "(Lcom/sumsub/sns/core/ServiceLocator;)V", "Params", "sns-core_release"}, k = 1, mv = {1, 4, 2})
public final class CreateNewFileUseCase extends BaseDirectUseCase<File, Params> {
    public final CacheRepository a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004¨\u0006\u0015"}, d2 = {"Lcom/sumsub/sns/core/domain/CreateNewFileUseCase$Params;", "", "", "component1", "()Ljava/lang/String;", "name", "copy", "(Ljava/lang/String;)Lcom/sumsub/sns/core/domain/CreateNewFileUseCase$Params;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getName", "<init>", "(Ljava/lang/String;)V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class Params {
        @NotNull
        public final String a;

        public Params(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "name");
            this.a = str;
        }

        public static /* synthetic */ Params copy$default(Params params, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = params.a;
            }
            return params.copy(str);
        }

        @NotNull
        public final String component1() {
            return this.a;
        }

        @NotNull
        public final Params copy(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "name");
            return new Params(str);
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                return (obj instanceof Params) && Intrinsics.areEqual(this.a, ((Params) obj).a);
            }
            return true;
        }

        @NotNull
        public final String getName() {
            return this.a;
        }

        public int hashCode() {
            String str = this.a;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        @NotNull
        public String toString() {
            return a.t(a.L("Params(name="), this.a, ")");
        }
    }

    public CreateNewFileUseCase(@NotNull CacheRepository cacheRepository) {
        Intrinsics.checkNotNullParameter(cacheRepository, "repository");
        this.a = cacheRepository;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CreateNewFileUseCase(@NotNull ServiceLocator serviceLocator) {
        this(serviceLocator.getCacheRepository());
        Intrinsics.checkNotNullParameter(serviceLocator, "serviceLocator");
    }

    @Nullable
    public Object run(@NotNull Params params, @NotNull Continuation<? super File> continuation) {
        return this.a.createNewFile(params.getName(), continuation);
    }
}
