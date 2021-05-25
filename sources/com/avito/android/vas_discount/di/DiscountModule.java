package com.avito.android.vas_discount.di;

import com.avito.android.di.PerActivity;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.vas_discount.business.DiscountRepository;
import com.avito.android.vas_discount.business.DiscountRepositoryImpl;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001:\u0001\nB\u0011\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\b\u0010\tJ\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/avito/android/vas_discount/di/DiscountModule;", "", "", "provideDiscountContext", "()Ljava/lang/String;", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "context", "<init>", "(Ljava/lang/String;)V", "Declarations", "vas-discount_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class})
public final class DiscountModule {
    public final String a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/vas_discount/di/DiscountModule$Declarations;", "", "Lcom/avito/android/vas_discount/business/DiscountRepositoryImpl;", "discountRepository", "Lcom/avito/android/vas_discount/business/DiscountRepository;", "provideRepository", "(Lcom/avito/android/vas_discount/business/DiscountRepositoryImpl;)Lcom/avito/android/vas_discount/business/DiscountRepository;", "vas-discount_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @PerActivity
        @Binds
        @NotNull
        DiscountRepository provideRepository(@NotNull DiscountRepositoryImpl discountRepositoryImpl);
    }

    public DiscountModule(@Nullable String str) {
        this.a = str;
    }

    @Provides
    @DiscountContext
    @Nullable
    @PerActivity
    public final String provideDiscountContext() {
        return this.a;
    }
}
