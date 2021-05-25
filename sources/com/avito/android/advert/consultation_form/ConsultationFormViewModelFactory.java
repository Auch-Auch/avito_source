package com.avito.android.advert.consultation_form;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.advert.consultation_form.data.ConsultationFormRepository;
import com.avito.android.analytics.Analytics;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.ConsultationFormData;
import com.avito.android.util.SchedulersFactory3;
import javax.inject.Inject;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001BC\b\u0007\u0012\n\b\u0001\u0010\u0015\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0001\u0010\u0013\u001a\u0004\u0018\u00010\u0010\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u001e\u0010\u001fJ)\u0010\u0006\u001a\u00028\u0000\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0012R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006 "}, d2 = {"Lcom/avito/android/advert/consultation_form/ConsultationFormViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", "create", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/util/SchedulersFactory3;", "d", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/remote/model/ConsultationFormData;", "f", "Lcom/avito/android/remote/model/ConsultationFormData;", "formData", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "developmentId", AuthSource.SEND_ABUSE, BookingInfoActivity.EXTRA_ITEM_ID, "Lcom/avito/android/advert/consultation_form/data/ConsultationFormRepository;", "c", "Lcom/avito/android/advert/consultation_form/data/ConsultationFormRepository;", "repository", "Lcom/avito/android/analytics/Analytics;", "e", "Lcom/avito/android/analytics/Analytics;", "analytics", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/advert/consultation_form/data/ConsultationFormRepository;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/remote/model/ConsultationFormData;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class ConsultationFormViewModelFactory implements ViewModelProvider.Factory {
    public final String a;
    public final String b;
    public final ConsultationFormRepository c;
    public final SchedulersFactory3 d;
    public final Analytics e;
    public final ConsultationFormData f;

    @Inject
    public ConsultationFormViewModelFactory(@Named("advert_id") @Nullable String str, @Named("development_id") @Nullable String str2, @NotNull ConsultationFormRepository consultationFormRepository, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull Analytics analytics, @Nullable ConsultationFormData consultationFormData) {
        Intrinsics.checkNotNullParameter(consultationFormRepository, "repository");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.a = str;
        this.b = str2;
        this.c = consultationFormRepository;
        this.d = schedulersFactory3;
        this.e = analytics;
        this.f = consultationFormData;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(@NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        if (cls.isAssignableFrom(ConsultationFormViewModel.class)) {
            return new ConsultationFormViewModel(this.a, this.b, this.c, this.d, this.e, this.f);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
