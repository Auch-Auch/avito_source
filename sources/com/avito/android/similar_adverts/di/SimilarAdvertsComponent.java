package com.avito.android.similar_adverts.di;

import android.app.Activity;
import android.content.res.Resources;
import androidx.fragment.app.Fragment;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.di.PerFragment;
import com.avito.android.di.ViewedAdvertsModule;
import com.avito.android.di.module.AbTestGroupModule;
import com.avito.android.di.module.DateTimeFormatterModule;
import com.avito.android.di.module.SerpItemConverterModule;
import com.avito.android.di.module.SpanAdapterModule;
import com.avito.android.rec.ScreenSource;
import com.avito.android.section.di.SectionModule;
import com.avito.android.serp.adapter.onboarding.SerpOnboardingHandler;
import com.avito.android.similar_adverts.SimilarAdvertsDialog;
import com.avito.android.similar_adverts.di.qualifier.ShopFlag;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/similar_adverts/di/SimilarAdvertsComponent;", "", "Lcom/avito/android/similar_adverts/SimilarAdvertsDialog;", "dialog", "", "inject", "(Lcom/avito/android/similar_adverts/SimilarAdvertsDialog;)V", "Factory", "similar-adverts_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {SimilarAdvertsDependencies.class}, modules = {SimilarAdvertsModule.class, SimilarAdvertsBlueprintsModule.class, DateTimeFormatterModule.class, SectionModule.class, ViewedAdvertsModule.class, AbTestGroupModule.class, SerpItemConverterModule.class, SpanAdapterModule.class})
@PerFragment
public interface SimilarAdvertsComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J_\u0010\u0013\u001a\u00020\u00122\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\b2\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\b\u0001\u0010\r\u001a\u00020\f2\b\b\u0001\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/avito/android/similar_adverts/di/SimilarAdvertsComponent$Factory;", "", "Landroid/app/Activity;", "activity", "Landroid/content/res/Resources;", "resources", "Landroidx/fragment/app/Fragment;", "fragment", "", BookingInfoActivity.EXTRA_ITEM_ID, "Lcom/avito/android/serp/adapter/onboarding/SerpOnboardingHandler;", "onboardingHandler", "Lcom/avito/android/rec/ScreenSource;", "screenSource", "", "isShop", "Lcom/avito/android/similar_adverts/di/SimilarAdvertsDependencies;", "dependencies", "Lcom/avito/android/similar_adverts/di/SimilarAdvertsComponent;", "create", "(Landroid/app/Activity;Landroid/content/res/Resources;Landroidx/fragment/app/Fragment;Ljava/lang/String;Lcom/avito/android/serp/adapter/onboarding/SerpOnboardingHandler;Lcom/avito/android/rec/ScreenSource;ZLcom/avito/android/similar_adverts/di/SimilarAdvertsDependencies;)Lcom/avito/android/similar_adverts/di/SimilarAdvertsComponent;", "similar-adverts_release"}, k = 1, mv = {1, 4, 2})
    @Component.Factory
    public interface Factory {
        @NotNull
        SimilarAdvertsComponent create(@BindsInstance @NotNull Activity activity, @BindsInstance @NotNull Resources resources, @BindsInstance @NotNull Fragment fragment, @BindsInstance @NotNull String str, @BindsInstance @Nullable SerpOnboardingHandler serpOnboardingHandler, @BindsInstance @NotNull ScreenSource screenSource, @ShopFlag @BindsInstance boolean z, @NotNull SimilarAdvertsDependencies similarAdvertsDependencies);
    }

    void inject(@NotNull SimilarAdvertsDialog similarAdvertsDialog);
}
