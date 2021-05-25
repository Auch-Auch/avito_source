package com.avito.android.publish;

import a2.b.a.a.a;
import android.net.Uri;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.ItemBrief;
import com.avito.android.remote.model.Navigation;
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
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001%J'\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\b\u0010\tJ/\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\n\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u000f\u0010\u0010J-\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00120\u00112\u0006\u0010\n\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000bH&¢\u0006\u0004\b\u0013\u0010\u0014J1\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00042\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u0017\u0010\u0018J3\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u001b0\u00112\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\u001d\u0010\u001eJ3\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00120\u00112\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b \u0010!J\u001d\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0\u00062\u0006\u0010\u0015\u001a\u00020\u0004H&¢\u0006\u0004\b#\u0010$¨\u0006&"}, d2 = {"Lcom/avito/android/publish/PublishParametersInteractor;", "", "Lcom/avito/android/remote/model/Navigation;", "verticalNavigation", "", "draftId", "Lio/reactivex/Single;", "Lcom/avito/android/publish/PublishParametersInteractor$Data;", "loadParametersAndStepsWithDraft", "(Lcom/avito/android/remote/model/Navigation;Ljava/lang/String;)Lio/reactivex/Single;", "navigation", "Lcom/avito/android/remote/model/category_parameters/CategoryParameters;", "categoryParameters", "", "isCategoryChanged", "loadExtraSteps", "(Lcom/avito/android/remote/model/Navigation;Lcom/avito/android/remote/model/category_parameters/CategoryParameters;Z)Lio/reactivex/Single;", "Lio/reactivex/Observable;", "Lcom/avito/android/util/MultiStateLoading;", "loadExtraStepsWithProgress", "(Lcom/avito/android/remote/model/Navigation;Lcom/avito/android/remote/model/category_parameters/CategoryParameters;)Lio/reactivex/Observable;", "itemId", "stepId", "loadSubmissionDataForEdit", "(Lcom/avito/android/remote/model/Navigation;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Single;", "Landroid/net/Uri;", ShareConstants.MEDIA_URI, "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/remote/model/sts_recognition/StsRecognitionResult;", "loadAutoParamsByStsImage", "(Landroid/net/Uri;Lcom/avito/android/remote/model/Navigation;Lcom/avito/android/remote/model/category_parameters/CategoryParameters;)Lio/reactivex/Observable;", "vin", "loadAutoParamsByVin", "(Ljava/lang/String;Lcom/avito/android/remote/model/Navigation;Lcom/avito/android/remote/model/category_parameters/CategoryParameters;)Lio/reactivex/Observable;", "Lcom/avito/android/remote/model/ItemBrief;", "loadItem", "(Ljava/lang/String;)Lio/reactivex/Single;", "Data", "publish_release"}, k = 1, mv = {1, 4, 2})
public interface PublishParametersInteractor {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\f\u0010\u0007J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004R\u001b\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u0007¨\u0006\u001c"}, d2 = {"Lcom/avito/android/publish/PublishParametersInteractor$Data;", "", "Lcom/avito/android/remote/model/category_parameters/CategoryParameters;", "component1", "()Lcom/avito/android/remote/model/category_parameters/CategoryParameters;", "", "component2", "()Ljava/lang/String;", "categoryParameters", "serializedPublishState", "copy", "(Lcom/avito/android/remote/model/category_parameters/CategoryParameters;Ljava/lang/String;)Lcom/avito/android/publish/PublishParametersInteractor$Data;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/model/category_parameters/CategoryParameters;", "getCategoryParameters", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getSerializedPublishState", "<init>", "(Lcom/avito/android/remote/model/category_parameters/CategoryParameters;Ljava/lang/String;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
    public static final class Data {
        @NotNull
        public final CategoryParameters a;
        @Nullable
        public final String b;

        public Data(@NotNull CategoryParameters categoryParameters, @Nullable String str) {
            Intrinsics.checkNotNullParameter(categoryParameters, "categoryParameters");
            this.a = categoryParameters;
            this.b = str;
        }

        public static /* synthetic */ Data copy$default(Data data, CategoryParameters categoryParameters, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                categoryParameters = data.a;
            }
            if ((i & 2) != 0) {
                str = data.b;
            }
            return data.copy(categoryParameters, str);
        }

        @NotNull
        public final CategoryParameters component1() {
            return this.a;
        }

        @Nullable
        public final String component2() {
            return this.b;
        }

        @NotNull
        public final Data copy(@NotNull CategoryParameters categoryParameters, @Nullable String str) {
            Intrinsics.checkNotNullParameter(categoryParameters, "categoryParameters");
            return new Data(categoryParameters, str);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Data)) {
                return false;
            }
            Data data = (Data) obj;
            return Intrinsics.areEqual(this.a, data.a) && Intrinsics.areEqual(this.b, data.b);
        }

        @NotNull
        public final CategoryParameters getCategoryParameters() {
            return this.a;
        }

        @Nullable
        public final String getSerializedPublishState() {
            return this.b;
        }

        public int hashCode() {
            CategoryParameters categoryParameters = this.a;
            int i = 0;
            int hashCode = (categoryParameters != null ? categoryParameters.hashCode() : 0) * 31;
            String str = this.b;
            if (str != null) {
                i = str.hashCode();
            }
            return hashCode + i;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("Data(categoryParameters=");
            L.append(this.a);
            L.append(", serializedPublishState=");
            return a.t(L, this.b, ")");
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Data(CategoryParameters categoryParameters, String str, int i, j jVar) {
            this(categoryParameters, (i & 2) != 0 ? null : str);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ Single loadSubmissionDataForEdit$default(PublishParametersInteractor publishParametersInteractor, Navigation navigation, String str, String str2, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    str2 = null;
                }
                return publishParametersInteractor.loadSubmissionDataForEdit(navigation, str, str2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadSubmissionDataForEdit");
        }
    }

    @NotNull
    Observable<LoadingState<StsRecognitionResult>> loadAutoParamsByStsImage(@NotNull Uri uri, @NotNull Navigation navigation, @NotNull CategoryParameters categoryParameters);

    @NotNull
    Observable<MultiStateLoading<CategoryParameters>> loadAutoParamsByVin(@NotNull String str, @NotNull Navigation navigation, @NotNull CategoryParameters categoryParameters);

    @NotNull
    Single<Data> loadExtraSteps(@NotNull Navigation navigation, @Nullable CategoryParameters categoryParameters, boolean z);

    @NotNull
    Observable<MultiStateLoading<CategoryParameters>> loadExtraStepsWithProgress(@NotNull Navigation navigation, @Nullable CategoryParameters categoryParameters);

    @NotNull
    Single<ItemBrief> loadItem(@NotNull String str);

    @NotNull
    Single<Data> loadParametersAndStepsWithDraft(@NotNull Navigation navigation, @Nullable String str);

    @NotNull
    Single<Data> loadSubmissionDataForEdit(@NotNull Navigation navigation, @NotNull String str, @Nullable String str2);
}
