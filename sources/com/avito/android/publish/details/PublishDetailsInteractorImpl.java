package com.avito.android.publish.details;

import android.net.Uri;
import com.avito.android.publish.PublishParametersInteractor;
import com.avito.android.publish.pretend.PretendInteractor;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.ItemBrief;
import com.avito.android.remote.model.Navigation;
import com.avito.android.remote.model.PretendResult;
import com.avito.android.remote.model.category_parameters.CategoryParameters;
import com.avito.android.remote.model.sts_recognition.StsRecognitionResult;
import com.avito.android.util.LoadingState;
import com.avito.android.util.MultiStateLoading;
import com.facebook.share.internal.ShareConstants;
import io.reactivex.Observable;
import io.reactivex.Single;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0017\u0012\u0006\u0010.\u001a\u00020\u0002\u0012\u0006\u0010+\u001a\u00020\u0003¢\u0006\u0004\b/\u00100J&\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0001¢\u0006\u0004\b\n\u0010\u000bJ4\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0001¢\u0006\u0004\b\u0010\u0010\u0011J4\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00140\b2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0001¢\u0006\u0004\b\u0015\u0010\u0016J0\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0018\u001a\u00020\u0017H\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ.\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00140\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0001¢\u0006\u0004\b\u001d\u0010\u000bJ\u001e\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u00192\u0006\u0010\u001e\u001a\u00020\u0012H\u0001¢\u0006\u0004\b \u0010!J(\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010\"\u001a\u00020\u00042\b\u0010#\u001a\u0004\u0018\u00010\u0012H\u0001¢\u0006\u0004\b$\u0010%J2\u0010'\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u00122\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0012H\u0001¢\u0006\u0004\b'\u0010(R\u0016\u0010+\u001a\u00020\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010.\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-¨\u00061"}, d2 = {"Lcom/avito/android/publish/details/PublishDetailsInteractorImpl;", "Lcom/avito/android/publish/details/PublishDetailsInteractor;", "Lcom/avito/android/publish/pretend/PretendInteractor;", "Lcom/avito/android/publish/PublishParametersInteractor;", "Lcom/avito/android/remote/model/Navigation;", "navigation", "Lcom/avito/android/remote/model/category_parameters/CategoryParameters;", "categoryParameters", "Lio/reactivex/Observable;", "Lcom/avito/android/remote/model/PretendResult;", "validateData", "(Lcom/avito/android/remote/model/Navigation;Lcom/avito/android/remote/model/category_parameters/CategoryParameters;)Lio/reactivex/Observable;", "Landroid/net/Uri;", ShareConstants.MEDIA_URI, "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/remote/model/sts_recognition/StsRecognitionResult;", "loadAutoParamsByStsImage", "(Landroid/net/Uri;Lcom/avito/android/remote/model/Navigation;Lcom/avito/android/remote/model/category_parameters/CategoryParameters;)Lio/reactivex/Observable;", "", "vin", "Lcom/avito/android/util/MultiStateLoading;", "loadAutoParamsByVin", "(Ljava/lang/String;Lcom/avito/android/remote/model/Navigation;Lcom/avito/android/remote/model/category_parameters/CategoryParameters;)Lio/reactivex/Observable;", "", "isCategoryChanged", "Lio/reactivex/Single;", "Lcom/avito/android/publish/PublishParametersInteractor$Data;", "loadExtraSteps", "(Lcom/avito/android/remote/model/Navigation;Lcom/avito/android/remote/model/category_parameters/CategoryParameters;Z)Lio/reactivex/Single;", "loadExtraStepsWithProgress", "itemId", "Lcom/avito/android/remote/model/ItemBrief;", "loadItem", "(Ljava/lang/String;)Lio/reactivex/Single;", "verticalNavigation", "draftId", "loadParametersAndStepsWithDraft", "(Lcom/avito/android/remote/model/Navigation;Ljava/lang/String;)Lio/reactivex/Single;", "stepId", "loadSubmissionDataForEdit", "(Lcom/avito/android/remote/model/Navigation;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Single;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/publish/PublishParametersInteractor;", "publishParametersInteractor", AuthSource.SEND_ABUSE, "Lcom/avito/android/publish/pretend/PretendInteractor;", "pretendInteractor", "<init>", "(Lcom/avito/android/publish/pretend/PretendInteractor;Lcom/avito/android/publish/PublishParametersInteractor;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class PublishDetailsInteractorImpl implements PublishDetailsInteractor, PretendInteractor, PublishParametersInteractor {
    public final PretendInteractor a;
    public final PublishParametersInteractor b;

    public PublishDetailsInteractorImpl(@NotNull PretendInteractor pretendInteractor, @NotNull PublishParametersInteractor publishParametersInteractor) {
        Intrinsics.checkNotNullParameter(pretendInteractor, "pretendInteractor");
        Intrinsics.checkNotNullParameter(publishParametersInteractor, "publishParametersInteractor");
        this.a = pretendInteractor;
        this.b = publishParametersInteractor;
    }

    @Override // com.avito.android.publish.PublishParametersInteractor
    @NotNull
    public Observable<LoadingState<StsRecognitionResult>> loadAutoParamsByStsImage(@NotNull Uri uri, @NotNull Navigation navigation, @NotNull CategoryParameters categoryParameters) {
        Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
        Intrinsics.checkNotNullParameter(navigation, "navigation");
        Intrinsics.checkNotNullParameter(categoryParameters, "categoryParameters");
        return this.b.loadAutoParamsByStsImage(uri, navigation, categoryParameters);
    }

    @Override // com.avito.android.publish.PublishParametersInteractor
    @NotNull
    public Observable<MultiStateLoading<CategoryParameters>> loadAutoParamsByVin(@NotNull String str, @NotNull Navigation navigation, @NotNull CategoryParameters categoryParameters) {
        Intrinsics.checkNotNullParameter(str, "vin");
        Intrinsics.checkNotNullParameter(navigation, "navigation");
        Intrinsics.checkNotNullParameter(categoryParameters, "categoryParameters");
        return this.b.loadAutoParamsByVin(str, navigation, categoryParameters);
    }

    @Override // com.avito.android.publish.PublishParametersInteractor
    @NotNull
    public Single<PublishParametersInteractor.Data> loadExtraSteps(@NotNull Navigation navigation, @Nullable CategoryParameters categoryParameters, boolean z) {
        Intrinsics.checkNotNullParameter(navigation, "navigation");
        return this.b.loadExtraSteps(navigation, categoryParameters, z);
    }

    @Override // com.avito.android.publish.PublishParametersInteractor
    @NotNull
    public Observable<MultiStateLoading<CategoryParameters>> loadExtraStepsWithProgress(@NotNull Navigation navigation, @Nullable CategoryParameters categoryParameters) {
        Intrinsics.checkNotNullParameter(navigation, "navigation");
        return this.b.loadExtraStepsWithProgress(navigation, categoryParameters);
    }

    @Override // com.avito.android.publish.PublishParametersInteractor
    @NotNull
    public Single<ItemBrief> loadItem(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        return this.b.loadItem(str);
    }

    @Override // com.avito.android.publish.PublishParametersInteractor
    @NotNull
    public Single<PublishParametersInteractor.Data> loadParametersAndStepsWithDraft(@NotNull Navigation navigation, @Nullable String str) {
        Intrinsics.checkNotNullParameter(navigation, "verticalNavigation");
        return this.b.loadParametersAndStepsWithDraft(navigation, str);
    }

    @Override // com.avito.android.publish.PublishParametersInteractor
    @NotNull
    public Single<PublishParametersInteractor.Data> loadSubmissionDataForEdit(@NotNull Navigation navigation, @NotNull String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(navigation, "navigation");
        Intrinsics.checkNotNullParameter(str, "itemId");
        return this.b.loadSubmissionDataForEdit(navigation, str, str2);
    }

    @Override // com.avito.android.publish.pretend.PretendInteractor
    @NotNull
    public Observable<PretendResult> validateData(@NotNull Navigation navigation, @NotNull CategoryParameters categoryParameters) {
        Intrinsics.checkNotNullParameter(navigation, "navigation");
        Intrinsics.checkNotNullParameter(categoryParameters, "categoryParameters");
        return this.a.validateData(navigation, categoryParameters);
    }
}
