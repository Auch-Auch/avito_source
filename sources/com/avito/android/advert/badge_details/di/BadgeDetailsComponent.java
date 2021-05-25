package com.avito.android.advert.badge_details.di;

import android.content.res.Resources;
import com.avito.android.advert.badge_details.BadgeDetailsActivity;
import com.avito.android.di.PerActivity;
import com.avito.android.util.Kundle;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/advert/badge_details/di/BadgeDetailsComponent;", "", "Lcom/avito/android/advert/badge_details/BadgeDetailsActivity;", "fragment", "", "inject", "(Lcom/avito/android/advert/badge_details/BadgeDetailsActivity;)V", "Factory", "advert-details_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {BadgeDetailsDependencies.class}, modules = {BadgeDetailsModule.class})
@PerActivity
public interface BadgeDetailsComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001JK\u0010\u000e\u001a\u00020\r2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0006\u001a\u00020\u00042\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u00072\b\b\u0001\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/advert/badge_details/di/BadgeDetailsComponent$Factory;", "", "", "badgeId", "", "itemId", "objectEntity", "Lcom/avito/android/util/Kundle;", "presenterState", "Landroid/content/res/Resources;", "resources", "Lcom/avito/android/advert/badge_details/di/BadgeDetailsDependencies;", "dependencies", "Lcom/avito/android/advert/badge_details/di/BadgeDetailsComponent;", "create", "(ILjava/lang/String;Ljava/lang/String;Lcom/avito/android/util/Kundle;Landroid/content/res/Resources;Lcom/avito/android/advert/badge_details/di/BadgeDetailsDependencies;)Lcom/avito/android/advert/badge_details/di/BadgeDetailsComponent;", "advert-details_release"}, k = 1, mv = {1, 4, 2})
    @Component.Factory
    public interface Factory {
        @NotNull
        BadgeDetailsComponent create(@BadgeId @BindsInstance int i, @ObjectId @BindsInstance @NotNull String str, @ObjectEntity @BindsInstance @NotNull String str2, @BindsInstance @Nullable Kundle kundle, @BindsInstance @NotNull Resources resources, @NotNull BadgeDetailsDependencies badgeDetailsDependencies);
    }

    void inject(@NotNull BadgeDetailsActivity badgeDetailsActivity);
}
