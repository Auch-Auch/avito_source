package com.avito.android.advert.closed.di;

import android.content.res.Resources;
import com.avito.android.advert.closed.ClosedAdvertActivity;
import com.avito.android.advert.closed.di.ClosedAdvertModule;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.di.PerActivity;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/advert/closed/di/ClosedAdvertComponent;", "", "Lcom/avito/android/advert/closed/ClosedAdvertActivity;", "activity", "", "inject", "(Lcom/avito/android/advert/closed/ClosedAdvertActivity;)V", "Builder", "advert-details_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {ClosedAdvertDependencies.class}, modules = {ClosedAdvertModule.class})
@PerActivity
public interface ClosedAdvertComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\u0007\u001a\u00020\u00002\b\b\u0001\u0010\u0006\u001a\u00020\u0005H'¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\tH'¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/advert/closed/di/ClosedAdvertComponent$Builder;", "", "Lcom/avito/android/advert/closed/di/ClosedAdvertDependencies;", "closedAdvertDependencies", "(Lcom/avito/android/advert/closed/di/ClosedAdvertDependencies;)Lcom/avito/android/advert/closed/di/ClosedAdvertComponent$Builder;", "", BookingInfoActivity.EXTRA_ITEM_ID, "withAdvertId", "(Ljava/lang/String;)Lcom/avito/android/advert/closed/di/ClosedAdvertComponent$Builder;", "Landroid/content/res/Resources;", "resources", "withResources", "(Landroid/content/res/Resources;)Lcom/avito/android/advert/closed/di/ClosedAdvertComponent$Builder;", "Lcom/avito/android/advert/closed/di/ClosedAdvertComponent;", "build", "()Lcom/avito/android/advert/closed/di/ClosedAdvertComponent;", "advert-details_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        ClosedAdvertComponent build();

        @NotNull
        Builder closedAdvertDependencies(@NotNull ClosedAdvertDependencies closedAdvertDependencies);

        @BindsInstance
        @NotNull
        Builder withAdvertId(@ClosedAdvertModule.AdvertId @NotNull String str);

        @BindsInstance
        @NotNull
        Builder withResources(@NotNull Resources resources);
    }

    void inject(@NotNull ClosedAdvertActivity closedAdvertActivity);
}
