package com.avito.android.passport_verification.di;

import a2.b.a.a.a;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.di.PerActivity;
import com.avito.android.inline_filters.analytics.VerticalFilterCloseDialogEventKt;
import com.avito.android.passport_verification.PassportVerificationInteractor;
import com.avito.android.passport_verification.PassportVerificationInteractorImpl;
import com.avito.android.passport_verification.PassportVerificationModel;
import com.avito.android.passport_verification.PassportVerificationModelImpl;
import com.avito.android.remote.auth.AuthSource;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001eB\u001f\u0012\u0006\u0010\u001b\u001a\u00020\u0006\u0012\u0006\u0010\u0019\u001a\u00020\u0006\u0012\u0006\u0010\u0016\u001a\u00020\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u0005\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\t\u001a\u00020\u0006H\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\u000b\u001a\u00020\u0006H\u0001¢\u0006\u0004\b\n\u0010\bJ#\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u00102\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0019\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001b\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u0018¨\u0006\u001f"}, d2 = {"Lcom/avito/android/passport_verification/di/PassportVerificationModule;", "", "", "provideIsFirstStart$passport_verification_release", "()Z", "provideIsFirstStart", "", "provideUrl$passport_verification_release", "()Ljava/lang/String;", "provideUrl", "provideFlowName$passport_verification_release", "provideFlowName", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "provideAdapter$passport_verification_release", "(Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/konveyor/ItemBinder;)Landroidx/recyclerview/widget/RecyclerView$Adapter;", "provideAdapter", "c", "Z", "isFirstStart", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "sumSubFlowName", AuthSource.SEND_ABUSE, "urlForSumSubSdk", "<init>", "(Ljava/lang/String;Ljava/lang/String;Z)V", "Dependencies", "passport-verification_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Dependencies.class})
public final class PassportVerificationModule {
    public final String a;
    public final String b;
    public final boolean c;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/passport_verification/di/PassportVerificationModule$Dependencies;", "", "Lcom/avito/android/passport_verification/PassportVerificationModelImpl;", VerticalFilterCloseDialogEventKt.MODEL_DIALOG, "Lcom/avito/android/passport_verification/PassportVerificationModel;", "provideVerificationModel", "(Lcom/avito/android/passport_verification/PassportVerificationModelImpl;)Lcom/avito/android/passport_verification/PassportVerificationModel;", "Lcom/avito/android/passport_verification/PassportVerificationInteractorImpl;", "interactor", "Lcom/avito/android/passport_verification/PassportVerificationInteractor;", "providePassportVerificationInteractor", "(Lcom/avito/android/passport_verification/PassportVerificationInteractorImpl;)Lcom/avito/android/passport_verification/PassportVerificationInteractor;", "passport-verification_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Dependencies {
        @PerActivity
        @Binds
        @NotNull
        PassportVerificationInteractor providePassportVerificationInteractor(@NotNull PassportVerificationInteractorImpl passportVerificationInteractorImpl);

        @PerActivity
        @Binds
        @NotNull
        PassportVerificationModel provideVerificationModel(@NotNull PassportVerificationModelImpl passportVerificationModelImpl);
    }

    public PassportVerificationModule(@NotNull String str, @NotNull String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "urlForSumSubSdk");
        Intrinsics.checkNotNullParameter(str2, "sumSubFlowName");
        this.a = str;
        this.b = str2;
        this.c = z;
    }

    @Provides
    @NotNull
    @PerActivity
    public final RecyclerView.Adapter<?> provideAdapter$passport_verification_release(@NotNull AdapterPresenter adapterPresenter, @NotNull ItemBinder itemBinder) {
        return a.E1(adapterPresenter, "adapterPresenter", itemBinder, "itemBinder", adapterPresenter, itemBinder);
    }

    @Provides
    @NotNull
    @PerActivity
    @SumSubFlowName
    public final String provideFlowName$passport_verification_release() {
        return this.b;
    }

    @Provides
    @PerActivity
    @IsFirstStart
    public final boolean provideIsFirstStart$passport_verification_release() {
        return this.c;
    }

    @Provides
    @NotNull
    @UrlForSumSubSdk
    @PerActivity
    public final String provideUrl$passport_verification_release() {
        return this.a;
    }
}
