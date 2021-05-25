package com.avito.android.publish;

import android.net.Uri;
import com.avito.android.Features;
import com.avito.android.photo_picker.legacy.api.UploadConverter;
import com.avito.android.publish.PublishParametersInteractor;
import com.avito.android.publish.drafts.LocalDraft;
import com.avito.android.publish.drafts.PublishDraftRepository;
import com.avito.android.publish.drafts.PublishDraftWiper;
import com.avito.android.remote.PublishApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Draft;
import com.avito.android.remote.model.ItemBrief;
import com.avito.android.remote.model.Navigation;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.model.category_parameters.AttributesTreeConverter;
import com.avito.android.remote.model.category_parameters.CategoryParameters;
import com.avito.android.remote.model.category_parameters.CategoryParametersConverter;
import com.avito.android.remote.model.category_parameters.PhotoParameter;
import com.avito.android.remote.model.category_parameters.base.CategoryParameter;
import com.avito.android.remote.model.sts_recognition.StsRecognitionResult;
import com.avito.android.util.LoadingState;
import com.avito.android.util.MultiStateLoading;
import com.avito.android.util.Singles;
import com.avito.android.util.TypedSingleKt;
import com.avito.android.util.rx3.InteropKt;
import com.avito.http.FileUtils;
import com.facebook.share.internal.ShareConstants;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import java.io.File;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MultipartBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 M2\u00020\u0001:\u0001MBM\u0012\u0006\u0010.\u001a\u00020,\u0012\u0006\u0010J\u001a\u00020G\u0012\f\u0010B\u001a\b\u0012\u0004\u0012\u00020\f0?\u0012\u0006\u00106\u001a\u000203\u0012\u0006\u0010F\u001a\u00020C\u0012\u0006\u00102\u001a\u00020/\u0012\u0006\u0010>\u001a\u00020;\u0012\u0006\u0010:\u001a\u000207¢\u0006\u0004\bK\u0010LJ'\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\tJ'\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J7\u0010\u0016\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u000f0\u000f0\u000e2\u0006\u0010\u0012\u001a\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J-\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00190\u00182\u0006\u0010\u0012\u001a\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ/\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\f2\b\u0010\u001d\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ3\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\"0\u00182\u0006\u0010!\u001a\u00020 2\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0004H\u0016¢\u0006\u0004\b$\u0010%J3\u0010'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00190\u00182\u0006\u0010&\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0004H\u0016¢\u0006\u0004\b'\u0010(J\u001d\u0010*\u001a\b\u0012\u0004\u0012\u00020)0\u000e2\u0006\u0010\u001c\u001a\u00020\fH\u0016¢\u0006\u0004\b*\u0010+R\u0016\u0010.\u001a\u00020,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010>\u001a\u00020;8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\u001c\u0010B\u001a\b\u0012\u0004\u0012\u00020\f0?8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010F\u001a\u00020C8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010J\u001a\u00020G8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bH\u0010I¨\u0006N"}, d2 = {"Lcom/avito/android/publish/PublishParametersInteractorImpl;", "Lcom/avito/android/publish/PublishParametersInteractor;", "Lcom/avito/android/remote/model/Draft;", "remoteDraft", "Lcom/avito/android/remote/model/category_parameters/CategoryParameters;", "params", "Lio/reactivex/Completable;", "kotlin.jvm.PlatformType", AuthSource.SEND_ABUSE, "(Lcom/avito/android/remote/model/Draft;Lcom/avito/android/remote/model/category_parameters/CategoryParameters;)Lio/reactivex/Completable;", "Lcom/avito/android/remote/model/Navigation;", "verticalNavigation", "", "draftId", "Lio/reactivex/Single;", "Lcom/avito/android/publish/PublishParametersInteractor$Data;", "loadParametersAndStepsWithDraft", "(Lcom/avito/android/remote/model/Navigation;Ljava/lang/String;)Lio/reactivex/Single;", "navigation", "categoryParameters", "", "isCategoryChanged", "loadExtraSteps", "(Lcom/avito/android/remote/model/Navigation;Lcom/avito/android/remote/model/category_parameters/CategoryParameters;Z)Lio/reactivex/Single;", "Lio/reactivex/Observable;", "Lcom/avito/android/util/MultiStateLoading;", "loadExtraStepsWithProgress", "(Lcom/avito/android/remote/model/Navigation;Lcom/avito/android/remote/model/category_parameters/CategoryParameters;)Lio/reactivex/Observable;", "itemId", "stepId", "loadSubmissionDataForEdit", "(Lcom/avito/android/remote/model/Navigation;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Single;", "Landroid/net/Uri;", ShareConstants.MEDIA_URI, "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/remote/model/sts_recognition/StsRecognitionResult;", "loadAutoParamsByStsImage", "(Landroid/net/Uri;Lcom/avito/android/remote/model/Navigation;Lcom/avito/android/remote/model/category_parameters/CategoryParameters;)Lio/reactivex/Observable;", "vin", "loadAutoParamsByVin", "(Ljava/lang/String;Lcom/avito/android/remote/model/Navigation;Lcom/avito/android/remote/model/category_parameters/CategoryParameters;)Lio/reactivex/Observable;", "Lcom/avito/android/remote/model/ItemBrief;", "loadItem", "(Ljava/lang/String;)Lio/reactivex/Single;", "Lcom/avito/android/remote/PublishApi;", "Lcom/avito/android/remote/PublishApi;", "publishApi", "Lcom/avito/android/publish/drafts/PublishDraftWiper;", "f", "Lcom/avito/android/publish/drafts/PublishDraftWiper;", "publishDraftWiper", "Lcom/avito/android/photo_picker/legacy/api/UploadConverter;", "d", "Lcom/avito/android/photo_picker/legacy/api/UploadConverter;", "uploadConverter", "Lcom/avito/android/Features;", "h", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/remote/model/category_parameters/AttributesTreeConverter;", a2.g.r.g.a, "Lcom/avito/android/remote/model/category_parameters/AttributesTreeConverter;", "attributesTreeConverter", "Lkotlin/Function0;", "c", "Lkotlin/jvm/functions/Function0;", "sessionIdProvider", "Lcom/avito/android/remote/model/category_parameters/CategoryParametersConverter;", "e", "Lcom/avito/android/remote/model/category_parameters/CategoryParametersConverter;", "converter", "Lcom/avito/android/publish/drafts/PublishDraftRepository;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/publish/drafts/PublishDraftRepository;", "publishDraftRepository", "<init>", "(Lcom/avito/android/remote/PublishApi;Lcom/avito/android/publish/drafts/PublishDraftRepository;Lkotlin/jvm/functions/Function0;Lcom/avito/android/photo_picker/legacy/api/UploadConverter;Lcom/avito/android/remote/model/category_parameters/CategoryParametersConverter;Lcom/avito/android/publish/drafts/PublishDraftWiper;Lcom/avito/android/remote/model/category_parameters/AttributesTreeConverter;Lcom/avito/android/Features;)V", "Companion", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class PublishParametersInteractorImpl implements PublishParametersInteractor {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final String i = "";
    public final PublishApi a;
    public final PublishDraftRepository b;
    public final Function0<String> c;
    public final UploadConverter d;
    public final CategoryParametersConverter e;
    public final PublishDraftWiper f;
    public final AttributesTreeConverter g;
    public final Features h;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/publish/PublishParametersInteractorImpl$Companion;", "", "", "EMPTY_SERIALIZED_PUBLISH_STATE", "Ljava/lang/String;", "<init>", "()V", "publish_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(t6.r.a.j jVar) {
        }
    }

    public static final class a<T, R> implements Function<File, MultipartBody.Part> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public MultipartBody.Part apply(File file) {
            File file2 = file;
            Intrinsics.checkNotNullParameter(file2, "it");
            return FileUtils.convertToImageMultipart$default(file2, null, null, 3, null);
        }
    }

    public static final class b<T, R> implements Function<MultipartBody.Part, ObservableSource<? extends TypedResult<StsRecognitionResult>>> {
        public final /* synthetic */ PublishParametersInteractorImpl a;
        public final /* synthetic */ Navigation b;
        public final /* synthetic */ Map c;

        public b(PublishParametersInteractorImpl publishParametersInteractorImpl, Navigation navigation, Map map) {
            this.a = publishParametersInteractorImpl;
            this.b = navigation;
            this.c = map;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ObservableSource<? extends TypedResult<StsRecognitionResult>> apply(MultipartBody.Part part) {
            MultipartBody.Part part2 = part;
            Intrinsics.checkNotNullParameter(part2, "file");
            return InteropKt.toV2(this.a.a.getPublishParametersByStsV4(part2, (String) this.a.c.invoke(), this.a.e.convertToFieldMap(this.b), this.c));
        }
    }

    public static final class c<T, R> implements Function<TypedResult<StsRecognitionResult>, LoadingState<? super StsRecognitionResult>> {
        public static final c a = new c();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public LoadingState<? super StsRecognitionResult> apply(TypedResult<StsRecognitionResult> typedResult) {
            TypedResult<StsRecognitionResult> typedResult2 = typedResult;
            Intrinsics.checkNotNullParameter(typedResult2, "it");
            if (typedResult2 instanceof TypedResult.OfResult) {
                return new LoadingState.Loaded(((TypedResult.OfResult) typedResult2).getResult());
            }
            if (typedResult2 instanceof TypedResult.OfError) {
                return new LoadingState.Error(((TypedResult.OfError) typedResult2).getError());
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final class d<T, R> implements Function<TypedResult<CategoryParameters>, MultiStateLoading<? super CategoryParameters>> {
        public static final d a = new d();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public MultiStateLoading<? super CategoryParameters> apply(TypedResult<CategoryParameters> typedResult) {
            TypedResult<CategoryParameters> typedResult2 = typedResult;
            Intrinsics.checkNotNullParameter(typedResult2, "it");
            if (typedResult2 instanceof TypedResult.OfResult) {
                return new MultiStateLoading.Loaded(((TypedResult.OfResult) typedResult2).getResult());
            }
            if (typedResult2 instanceof TypedResult.OfError) {
                return new MultiStateLoading.Error(((TypedResult.OfError) typedResult2).getError());
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final class e<T, R> implements Function<Single<TypedResult<CategoryParameters>>, SingleSource<? extends TypedResult<CategoryParameters>>> {
        public static final e a = new e();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public SingleSource<? extends TypedResult<CategoryParameters>> apply(Single<TypedResult<CategoryParameters>> single) {
            Single<TypedResult<CategoryParameters>> single2 = single;
            Intrinsics.checkNotNullParameter(single2, "it");
            return single2;
        }
    }

    public static final class f<T, R> implements Function<CategoryParameters, SingleSource<? extends PublishParametersInteractor.Data>> {
        public final /* synthetic */ PublishParametersInteractorImpl a;

        public f(PublishParametersInteractorImpl publishParametersInteractorImpl) {
            this.a = publishParametersInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public SingleSource<? extends PublishParametersInteractor.Data> apply(CategoryParameters categoryParameters) {
            CategoryParameters categoryParameters2 = categoryParameters;
            Intrinsics.checkNotNullParameter(categoryParameters2, "it");
            return PublishParametersInteractorImpl.access$withPublishState(this.a, categoryParameters2);
        }
    }

    public static final class g<T, R> implements Function<Single<TypedResult<CategoryParameters>>, SingleSource<? extends TypedResult<CategoryParameters>>> {
        public static final g a = new g();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public SingleSource<? extends TypedResult<CategoryParameters>> apply(Single<TypedResult<CategoryParameters>> single) {
            Single<TypedResult<CategoryParameters>> single2 = single;
            Intrinsics.checkNotNullParameter(single2, "it");
            return single2;
        }
    }

    public static final class h<T, R> implements Function<TypedResult<CategoryParameters>, MultiStateLoading<? super CategoryParameters>> {
        public static final h a = new h();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public MultiStateLoading<? super CategoryParameters> apply(TypedResult<CategoryParameters> typedResult) {
            TypedResult<CategoryParameters> typedResult2 = typedResult;
            Intrinsics.checkNotNullParameter(typedResult2, "it");
            if (typedResult2 instanceof TypedResult.OfResult) {
                return new MultiStateLoading.Loaded(((TypedResult.OfResult) typedResult2).getResult());
            }
            if (typedResult2 instanceof TypedResult.OfError) {
                return new MultiStateLoading.Error(((TypedResult.OfError) typedResult2).getError());
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final class i<T, R> implements Function<CategoryParameters, PublishParametersInteractor.Data> {
        public static final i a = new i();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public PublishParametersInteractor.Data apply(CategoryParameters categoryParameters) {
            CategoryParameters categoryParameters2 = categoryParameters;
            Intrinsics.checkNotNullParameter(categoryParameters2, "it");
            return new PublishParametersInteractor.Data(categoryParameters2, null, 2, null);
        }
    }

    public static final class j<T, R> implements Function<PublishParametersInteractor.Data, SingleSource<? extends PublishParametersInteractor.Data>> {
        public final /* synthetic */ PublishParametersInteractorImpl a;

        public j(PublishParametersInteractorImpl publishParametersInteractorImpl) {
            this.a = publishParametersInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public SingleSource<? extends PublishParametersInteractor.Data> apply(PublishParametersInteractor.Data data) {
            Single<R> flatMap;
            PublishParametersInteractor.Data data2 = data;
            Intrinsics.checkNotNullParameter(data2, "remoteData");
            Draft draft = data2.getCategoryParameters().getDraft();
            return (draft == null || (flatMap = this.a.b.getDraft().flatMap(new a2.a.a.e2.h(draft, this, data2))) == null) ? this.a.f.deleteDraftWithPhotos().toSingleDefault(data2) : flatMap;
        }
    }

    public PublishParametersInteractorImpl(@NotNull PublishApi publishApi, @NotNull PublishDraftRepository publishDraftRepository, @NotNull Function0<String> function0, @NotNull UploadConverter uploadConverter, @NotNull CategoryParametersConverter categoryParametersConverter, @NotNull PublishDraftWiper publishDraftWiper, @NotNull AttributesTreeConverter attributesTreeConverter, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(publishApi, "publishApi");
        Intrinsics.checkNotNullParameter(publishDraftRepository, "publishDraftRepository");
        Intrinsics.checkNotNullParameter(function0, "sessionIdProvider");
        Intrinsics.checkNotNullParameter(uploadConverter, "uploadConverter");
        Intrinsics.checkNotNullParameter(categoryParametersConverter, "converter");
        Intrinsics.checkNotNullParameter(publishDraftWiper, "publishDraftWiper");
        Intrinsics.checkNotNullParameter(attributesTreeConverter, "attributesTreeConverter");
        Intrinsics.checkNotNullParameter(features, "features");
        this.a = publishApi;
        this.b = publishDraftRepository;
        this.c = function0;
        this.d = uploadConverter;
        this.e = categoryParametersConverter;
        this.f = publishDraftWiper;
        this.g = attributesTreeConverter;
        this.h = features;
    }

    public static final Single access$applyDraftValues(PublishParametersInteractorImpl publishParametersInteractorImpl, CategoryParameters categoryParameters) {
        Single<R> map = publishParametersInteractorImpl.b.getDraft().map(new a2.a.a.e2.d(categoryParameters));
        Intrinsics.checkNotNullExpressionValue(map, "publishDraftRepository.g… { Data(this) }\n        }");
        return map;
    }

    public static final Completable access$mergeRemoteDraft(PublishParametersInteractorImpl publishParametersInteractorImpl, Draft draft, LocalDraft localDraft, CategoryParameters categoryParameters) {
        Objects.requireNonNull(publishParametersInteractorImpl);
        if (localDraft == null) {
            return publishParametersInteractorImpl.a(draft, categoryParameters);
        }
        if (!Intrinsics.areEqual(localDraft.getServerDraftId(), draft.getDraftId())) {
            return publishParametersInteractorImpl.f.deleteDraftWithPhotos().andThen(publishParametersInteractorImpl.a(draft, categoryParameters));
        }
        if (draft.getVersion() > localDraft.getVersion()) {
            return publishParametersInteractorImpl.a(draft, categoryParameters);
        }
        return Completable.complete();
    }

    public static final CategoryParameters access$patchPhotoParameter(PublishParametersInteractorImpl publishParametersInteractorImpl, CategoryParameters categoryParameters, PhotoParameter photoParameter) {
        PhotoParameter.ImageUploadListWrapper imageUploadListWrapper;
        PhotoParameter photoParameter2;
        Objects.requireNonNull(publishParametersInteractorImpl);
        if (!(photoParameter == null || (imageUploadListWrapper = (PhotoParameter.ImageUploadListWrapper) photoParameter.getValue()) == null || (photoParameter2 = (PhotoParameter) ((CategoryParameter) categoryParameters.getFirstParameterOfType(PhotoParameter.class))) == null || photoParameter2.getValue() != null)) {
            photoParameter2.setValue(imageUploadListWrapper);
        }
        return categoryParameters;
    }

    public static final Single access$toDataWithoutDraft(PublishParametersInteractorImpl publishParametersInteractorImpl, CategoryParameters categoryParameters) {
        Objects.requireNonNull(publishParametersInteractorImpl);
        return Singles.toSingle(new PublishParametersInteractor.Data(categoryParameters, null, 2, null));
    }

    public static final Single access$withPublishState(PublishParametersInteractorImpl publishParametersInteractorImpl, CategoryParameters categoryParameters) {
        Single<R> map = publishParametersInteractorImpl.b.getDraft().map(new a2.a.a.e2.j(categoryParameters));
        Intrinsics.checkNotNullExpressionValue(map, "publishDraftRepository.g…, publishState)\n        }");
        return map;
    }

    public final Completable a(Draft draft, CategoryParameters categoryParameters) {
        return PublishDraftRepository.DefaultImpls.saveDraft$default(this.b, draft.getPublishSessionId(), draft.getDraftId(), categoryParameters, i, false, draft.getDraftId(), Integer.valueOf(draft.getVersion()), categoryParameters.getNavigation(), null, null, false, 1792, null).ignoreElement();
    }

    @Override // com.avito.android.publish.PublishParametersInteractor
    @NotNull
    public Observable<LoadingState<StsRecognitionResult>> loadAutoParamsByStsImage(@NotNull Uri uri, @NotNull Navigation navigation, @NotNull CategoryParameters categoryParameters) {
        Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
        Intrinsics.checkNotNullParameter(navigation, "navigation");
        Intrinsics.checkNotNullParameter(categoryParameters, "categoryParameters");
        Observable<R> startWith = this.d.convertUriToFile(uri).map(a.a).switchMap(new b(this, navigation, this.e.convertToFieldMap(categoryParameters.getParametersExceptOwnedBySlots()))).map(c.a).startWith((Observable<R>) ((R) LoadingState.Loading.INSTANCE));
        Intrinsics.checkNotNullExpressionValue(startWith, "uploadConverter.convertU…ith(LoadingState.Loading)");
        return startWith;
    }

    @Override // com.avito.android.publish.PublishParametersInteractor
    @NotNull
    public Observable<MultiStateLoading<CategoryParameters>> loadAutoParamsByVin(@NotNull String str, @NotNull Navigation navigation, @NotNull CategoryParameters categoryParameters) {
        io.reactivex.rxjava3.core.Observable<TypedResult<CategoryParameters>> observable;
        Intrinsics.checkNotNullParameter(str, "vin");
        Intrinsics.checkNotNullParameter(navigation, "navigation");
        Intrinsics.checkNotNullParameter(categoryParameters, "categoryParameters");
        Map<String, String> convertToFieldMap = this.e.convertToFieldMap(categoryParameters.getParametersExceptOwnedBySlots());
        if (this.h.getSuggestByVinV4().invoke().booleanValue()) {
            observable = this.a.getPublishParametersByVinV4(str, this.c.invoke(), this.e.convertToFieldMap(navigation), convertToFieldMap);
        } else {
            observable = this.a.getPublishParametersByVinV3(str, this.c.invoke(), this.e.convertToFieldMap(navigation), convertToFieldMap);
        }
        Observable<MultiStateLoading<CategoryParameters>> startWith = InteropKt.toV2(observable).map(d.a).startWith((Observable) MultiStateLoading.Loading.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(startWith, "request.toV2()\n         …ultiStateLoading.Loading)");
        return startWith;
    }

    @Override // com.avito.android.publish.PublishParametersInteractor
    @NotNull
    public Single<PublishParametersInteractor.Data> loadExtraSteps(@NotNull Navigation navigation, @Nullable CategoryParameters categoryParameters, boolean z) {
        Intrinsics.checkNotNullParameter(navigation, "navigation");
        Single fromCallable = Single.fromCallable(new a2.a.a.e2.e(this, navigation, categoryParameters, Boolean.valueOf(z)));
        Intrinsics.checkNotNullExpressionValue(fromCallable, "Single.fromCallable {\n  …     request.toV2()\n    }");
        Single flatMap = fromCallable.flatMap(e.a);
        Intrinsics.checkNotNullExpressionValue(flatMap, "getLoadExtraStepsTask(na…          .flatMap { it }");
        Single<PublishParametersInteractor.Data> flatMap2 = TypedSingleKt.toTyped(flatMap).flatMap(new f(this));
        Intrinsics.checkNotNullExpressionValue(flatMap2, "getLoadExtraStepsTask(na…{ it.withPublishState() }");
        return flatMap2;
    }

    @Override // com.avito.android.publish.PublishParametersInteractor
    @NotNull
    public Observable<MultiStateLoading<CategoryParameters>> loadExtraStepsWithProgress(@NotNull Navigation navigation, @Nullable CategoryParameters categoryParameters) {
        Intrinsics.checkNotNullParameter(navigation, "navigation");
        Single fromCallable = Single.fromCallable(new a2.a.a.e2.e(this, navigation, categoryParameters, null));
        Intrinsics.checkNotNullExpressionValue(fromCallable, "Single.fromCallable {\n  …     request.toV2()\n    }");
        Observable<MultiStateLoading<CategoryParameters>> startWith = fromCallable.flatMap(g.a).toObservable().map(h.a).startWith((Observable) MultiStateLoading.Loading.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(startWith, "getLoadExtraStepsTask(na…ultiStateLoading.Loading)");
        return startWith;
    }

    @Override // com.avito.android.publish.PublishParametersInteractor
    @NotNull
    public Single<ItemBrief> loadItem(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        return InteropKt.toV2(PublishApi.DefaultImpls.getItemBriefV2$default(this.a, str, null, this.c.invoke(), 2, null));
    }

    @Override // com.avito.android.publish.PublishParametersInteractor
    @NotNull
    public Single<PublishParametersInteractor.Data> loadParametersAndStepsWithDraft(@NotNull Navigation navigation, @Nullable String str) {
        io.reactivex.rxjava3.core.Single<TypedResult<CategoryParameters>> single;
        Intrinsics.checkNotNullParameter(navigation, "verticalNavigation");
        String str2 = null;
        boolean z = true;
        if (this.h.getHtmlDescriptionOnPublish().invoke().booleanValue()) {
            PublishApi publishApi = this.a;
            String invoke = this.c.invoke();
            if (str != null) {
                z = false;
            }
            if (z) {
                str2 = invoke;
            }
            single = publishApi.getStepsAndParametersWithDraftValuesV6(str2, this.e.convertToFieldMap(navigation), str);
        } else {
            PublishApi publishApi2 = this.a;
            String invoke2 = this.c.invoke();
            if (str != null) {
                z = false;
            }
            if (z) {
                str2 = invoke2;
            }
            single = publishApi2.getStepsAndParametersWithDraftValues(str2, this.e.convertToFieldMap(navigation), str);
        }
        Single<PublishParametersInteractor.Data> flatMap = TypedSingleKt.toTyped(InteropKt.toV2(single)).map(i.a).flatMap(new j(this));
        Intrinsics.checkNotNullExpressionValue(flatMap, "request.toV2().toTyped()…remoteData)\n            }");
        return flatMap;
    }

    @Override // com.avito.android.publish.PublishParametersInteractor
    @NotNull
    public Single<PublishParametersInteractor.Data> loadSubmissionDataForEdit(@NotNull Navigation navigation, @NotNull String str, @Nullable String str2) {
        io.reactivex.rxjava3.core.Single<TypedResult<CategoryParameters>> single;
        Intrinsics.checkNotNullParameter(navigation, "navigation");
        Intrinsics.checkNotNullParameter(str, "itemId");
        if (this.h.getHtmlDescriptionOnPublish().invoke().booleanValue()) {
            single = this.a.getCategoryParametersForEditingWithNavigationV6(str, this.e.convertToFieldMap(navigation), str2, this.c.invoke());
        } else {
            single = this.a.getCategoryParametersForEditingWithNavigation(str, this.e.convertToFieldMap(navigation), str2, this.c.invoke());
        }
        Single<PublishParametersInteractor.Data> flatMap = TypedSingleKt.toTyped(InteropKt.toV2(single)).map(new a2.a.a.e2.f(this, null)).flatMap(new a2.a.a.e2.g(this, false));
        Intrinsics.checkNotNullExpressionValue(flatMap, "toTyped()\n        .map {…it.toDataWithoutDraft() }");
        return flatMap;
    }
}
