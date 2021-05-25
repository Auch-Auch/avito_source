package com.avito.android.abuse.category.di;

import android.content.res.Resources;
import com.avito.android.abuse.category.AbuseCategoryActivity;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.di.PerActivity;
import com.avito.android.util.Kundle;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/abuse/category/di/AbuseCategoryComponent;", "", "Lcom/avito/android/abuse/category/AbuseCategoryActivity;", "activity", "", "inject", "(Lcom/avito/android/abuse/category/AbuseCategoryActivity;)V", "Builder", "abuse_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {AbuseCategoryDependencies.class}, modules = {AbuseCategoryModule.class})
@PerActivity
public interface AbuseCategoryComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006H'¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\b\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\nH'¢\u0006\u0004\b\b\u0010\fJ\u0019\u0010\b\u001a\u00020\u00002\b\u0010\u000e\u001a\u0004\u0018\u00010\rH'¢\u0006\u0004\b\b\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/avito/android/abuse/category/di/AbuseCategoryComponent$Builder;", "", "Lcom/avito/android/abuse/category/di/AbuseCategoryDependencies;", "dependencies", "dependentOn", "(Lcom/avito/android/abuse/category/di/AbuseCategoryDependencies;)Lcom/avito/android/abuse/category/di/AbuseCategoryComponent$Builder;", "", BookingInfoActivity.EXTRA_ITEM_ID, "with", "(Ljava/lang/String;)Lcom/avito/android/abuse/category/di/AbuseCategoryComponent$Builder;", "Landroid/content/res/Resources;", "resources", "(Landroid/content/res/Resources;)Lcom/avito/android/abuse/category/di/AbuseCategoryComponent$Builder;", "Lcom/avito/android/util/Kundle;", "state", "(Lcom/avito/android/util/Kundle;)Lcom/avito/android/abuse/category/di/AbuseCategoryComponent$Builder;", "Lcom/avito/android/abuse/category/di/AbuseCategoryComponent;", "build", "()Lcom/avito/android/abuse/category/di/AbuseCategoryComponent;", "abuse_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        AbuseCategoryComponent build();

        @NotNull
        Builder dependentOn(@NotNull AbuseCategoryDependencies abuseCategoryDependencies);

        @BindsInstance
        @NotNull
        Builder with(@NotNull Resources resources);

        @BindsInstance
        @NotNull
        Builder with(@Nullable Kundle kundle);

        @BindsInstance
        @NotNull
        Builder with(@NotNull String str);
    }

    void inject(@NotNull AbuseCategoryActivity abuseCategoryActivity);
}
