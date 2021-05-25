package com.avito.android.rating.publish.buyer_info.di;

import com.avito.android.rating.publish.buyer_info.BuyerInfoPresenter;
import com.avito.android.rating.publish.buyer_info.BuyerInfoPresenterImpl;
import dagger.Binds;
import dagger.Module;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/avito/android/rating/publish/buyer_info/di/BuyerInfoModule;", "", "<init>", "()V", "Declarations", "rating_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class})
public final class BuyerInfoModule {
    @NotNull
    public static final BuyerInfoModule INSTANCE = new BuyerInfoModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/rating/publish/buyer_info/di/BuyerInfoModule$Declarations;", "", "Lcom/avito/android/rating/publish/buyer_info/BuyerInfoPresenterImpl;", "presenter", "Lcom/avito/android/rating/publish/buyer_info/BuyerInfoPresenter;", "bindBuyerInfoPresenter", "(Lcom/avito/android/rating/publish/buyer_info/BuyerInfoPresenterImpl;)Lcom/avito/android/rating/publish/buyer_info/BuyerInfoPresenter;", "rating_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @Binds
        @NotNull
        BuyerInfoPresenter bindBuyerInfoPresenter(@NotNull BuyerInfoPresenterImpl buyerInfoPresenterImpl);
    }
}
