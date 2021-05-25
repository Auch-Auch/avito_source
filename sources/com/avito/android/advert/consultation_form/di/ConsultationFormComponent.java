package com.avito.android.advert.consultation_form.di;

import com.avito.android.advert.consultation_form.ConsultationFormActivity;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.di.PerActivity;
import com.avito.android.remote.model.ConsultationFormData;
import dagger.BindsInstance;
import dagger.Component;
import javax.inject.Named;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/advert/consultation_form/di/ConsultationFormComponent;", "", "Lcom/avito/android/advert/consultation_form/ConsultationFormActivity;", "activity", "", "inject", "(Lcom/avito/android/advert/consultation_form/ConsultationFormActivity;)V", "Builder", "advert-details_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {ConsultationFormDependencies.class}, modules = {ConsultationFormModule.class})
@PerActivity
public interface ConsultationFormComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\b\u001a\u00020\u00002\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0006H'¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\u000b\u001a\u00020\u00002\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u0006H'¢\u0006\u0004\b\u000b\u0010\tJ\u0019\u0010\u000e\u001a\u00020\u00002\b\u0010\r\u001a\u0004\u0018\u00010\fH'¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/avito/android/advert/consultation_form/di/ConsultationFormComponent$Builder;", "", "Lcom/avito/android/advert/consultation_form/di/ConsultationFormDependencies;", "dependencies", "consultationFormDependencies", "(Lcom/avito/android/advert/consultation_form/di/ConsultationFormDependencies;)Lcom/avito/android/advert/consultation_form/di/ConsultationFormComponent$Builder;", "", BookingInfoActivity.EXTRA_ITEM_ID, "withAdvertId", "(Ljava/lang/String;)Lcom/avito/android/advert/consultation_form/di/ConsultationFormComponent$Builder;", "developmentId", "withDevelopmentId", "Lcom/avito/android/remote/model/ConsultationFormData;", "form", "withForm", "(Lcom/avito/android/remote/model/ConsultationFormData;)Lcom/avito/android/advert/consultation_form/di/ConsultationFormComponent$Builder;", "Lcom/avito/android/advert/consultation_form/di/ConsultationFormComponent;", "build", "()Lcom/avito/android/advert/consultation_form/di/ConsultationFormComponent;", "advert-details_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        ConsultationFormComponent build();

        @NotNull
        Builder consultationFormDependencies(@NotNull ConsultationFormDependencies consultationFormDependencies);

        @BindsInstance
        @NotNull
        Builder withAdvertId(@Named("advert_id") @Nullable String str);

        @BindsInstance
        @NotNull
        Builder withDevelopmentId(@Named("development_id") @Nullable String str);

        @BindsInstance
        @NotNull
        Builder withForm(@Nullable ConsultationFormData consultationFormData);
    }

    void inject(@NotNull ConsultationFormActivity consultationFormActivity);
}
