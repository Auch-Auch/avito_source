package com.avito.android.publish.premoderation.di;

import com.avito.android.di.PerFragment;
import com.avito.android.publish.premoderation.WrongCategoryPresenter;
import com.avito.android.publish.premoderation.WrongCategoryPresenterImpl;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.adverts.AdvertProactiveModerationResult;
import com.avito.android.util.Kundle;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\t\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/avito/android/publish/premoderation/di/WrongCategoryModule;", "", "Lcom/avito/android/publish/premoderation/WrongCategoryPresenter;", "providerWrongCategoryPresenter", "()Lcom/avito/android/publish/premoderation/WrongCategoryPresenter;", "Lcom/avito/android/remote/model/adverts/AdvertProactiveModerationResult$WrongCategorySuggest;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/model/adverts/AdvertProactiveModerationResult$WrongCategorySuggest;", "wrongCategoryData", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "selectedCategorySubtitle", "Lcom/avito/android/util/Kundle;", "c", "Lcom/avito/android/util/Kundle;", "state", "<init>", "(Lcom/avito/android/remote/model/adverts/AdvertProactiveModerationResult$WrongCategorySuggest;Ljava/lang/String;Lcom/avito/android/util/Kundle;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class WrongCategoryModule {
    public final AdvertProactiveModerationResult.WrongCategorySuggest a;
    public final String b;
    public final Kundle c;

    public WrongCategoryModule(@NotNull AdvertProactiveModerationResult.WrongCategorySuggest wrongCategorySuggest, @NotNull String str, @Nullable Kundle kundle) {
        Intrinsics.checkNotNullParameter(wrongCategorySuggest, "wrongCategoryData");
        Intrinsics.checkNotNullParameter(str, "selectedCategorySubtitle");
        this.a = wrongCategorySuggest;
        this.b = str;
        this.c = kundle;
    }

    @Provides
    @PerFragment
    @NotNull
    public final WrongCategoryPresenter providerWrongCategoryPresenter() {
        return new WrongCategoryPresenterImpl(this.a, this.b, this.c);
    }
}
