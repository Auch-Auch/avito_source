package com.avito.android.publish.publish_advert_request;

import a2.g.r.g;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.avito.android.analytics.Analytics;
import com.avito.android.photo_picker.UploadingState;
import com.avito.android.photo_picker.legacy.UploadingProgressInteractor;
import com.avito.android.photo_picker.legacy.service.UploadingInteractor;
import com.avito.android.publish.PublishViewModel;
import com.avito.android.publish.PublishedAdvertData;
import com.avito.android.publish.SubmissionPresenter;
import com.avito.android.publish.analytics.events.AddItemEvent;
import com.avito.android.publish.publish_advert_request.data.PublishAdvertRepository;
import com.avito.android.publish.slots.contact_info.ContactsData;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorResult;
import com.avito.android.remote.error.ErrorWithMessage;
import com.avito.android.remote.error.TypedError;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.ImageUploadResult;
import com.avito.android.remote.model.Navigation;
import com.avito.android.remote.model.PretendErrorValue;
import com.avito.android.remote.model.category_parameters.CategoryParameters;
import com.avito.android.remote.model.category_parameters.PhotoParameter;
import com.avito.android.remote.model.category_parameters.base.CategoryParameter;
import com.avito.android.util.LoadingState;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.UnauthorizedException;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.rxkotlin.DisposableKt;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.r;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001=B/\u0012\u0006\u0010-\u001a\u00020*\u0012\u0006\u0010 \u001a\u00020\u001d\u0012\u0006\u0010:\u001a\u000207\u0012\u0006\u00101\u001a\u00020.\u0012\u0006\u0010\u001c\u001a\u00020\u0019¢\u0006\u0004\b;\u0010<J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\nH\u0014¢\u0006\u0004\b\u000f\u0010\u000eJ\r\u0010\u0010\u001a\u00020\n¢\u0006\u0004\b\u0010\u0010\u000eJ\r\u0010\u0011\u001a\u00020\n¢\u0006\u0004\b\u0011\u0010\u000eJ\r\u0010\u0012\u001a\u00020\n¢\u0006\u0004\b\u0012\u0010\u000eJ\u0019\u0010\u0015\u001a\u00020\n2\b\b\u0002\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0017\u0010\u000eJ\u000f\u0010\u0018\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0018\u0010\u000eR\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X.¢\u0006\u0006\n\u0004\b!\u0010\"R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010(\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010'R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010'R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00106\u001a\u0002048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0015\u00105R\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b8\u00109¨\u0006>"}, d2 = {"Lcom/avito/android/publish/publish_advert_request/PublishAdvertRequestViewModel;", "Landroidx/lifecycle/ViewModel;", "Landroidx/lifecycle/LiveData;", "Lcom/avito/android/publish/publish_advert_request/PublishAdvertRequestViewModel$ViewState;", "screenState", "()Landroidx/lifecycle/LiveData;", "Lcom/avito/android/publish/PublishViewModel;", "publishViewModel", "Lcom/avito/android/publish/SubmissionPresenter;", "submissionPresenter", "", "initScreen", "(Lcom/avito/android/publish/PublishViewModel;Lcom/avito/android/publish/SubmissionPresenter;)V", "onRetryClicked", "()V", "onCleared", "goPrevious", "retryPhotoUpload", "skipPhotoUpload", "", "withDelay", "e", "(J)V", "c", "d", "Lcom/avito/android/photo_picker/legacy/UploadingProgressInteractor;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/photo_picker/legacy/UploadingProgressInteractor;", "uploadingProgressInteractor", "Lcom/avito/android/analytics/Analytics;", "j", "Lcom/avito/android/analytics/Analytics;", "analytics", "f", "Lcom/avito/android/publish/PublishViewModel;", "Landroidx/lifecycle/MutableLiveData;", "h", "Landroidx/lifecycle/MutableLiveData;", "Lio/reactivex/disposables/Disposable;", "Lio/reactivex/disposables/Disposable;", "uploadProgressDisposable", "publishProcessDisposable", "Lcom/avito/android/publish/publish_advert_request/data/PublishAdvertRepository;", "i", "Lcom/avito/android/publish/publish_advert_request/data/PublishAdvertRepository;", "repository", "Lcom/avito/android/photo_picker/legacy/service/UploadingInteractor;", "l", "Lcom/avito/android/photo_picker/legacy/service/UploadingInteractor;", "uploadingInteractor", g.a, "Lcom/avito/android/publish/SubmissionPresenter;", "Lio/reactivex/disposables/CompositeDisposable;", "Lio/reactivex/disposables/CompositeDisposable;", "disposables", "Lcom/avito/android/util/SchedulersFactory;", "k", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "<init>", "(Lcom/avito/android/publish/publish_advert_request/data/PublishAdvertRepository;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/photo_picker/legacy/service/UploadingInteractor;Lcom/avito/android/photo_picker/legacy/UploadingProgressInteractor;)V", "ViewState", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class PublishAdvertRequestViewModel extends ViewModel {
    public Disposable c;
    public Disposable d;
    public CompositeDisposable e = new CompositeDisposable();
    public PublishViewModel f;
    public SubmissionPresenter g;
    public final MutableLiveData<ViewState> h = new MutableLiveData<>();
    public final PublishAdvertRepository i;
    public final Analytics j;
    public final SchedulersFactory k;
    public final UploadingInteractor l;
    public final UploadingProgressInteractor m;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0004\u0005\u0006\u0007\bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0005\t\n\u000b\f\r¨\u0006\u000e"}, d2 = {"Lcom/avito/android/publish/publish_advert_request/PublishAdvertRequestViewModel$ViewState;", "", "<init>", "()V", "Error", "Loading", "PhotoUploadError", "PhotosUploaded", "PhotosUploading", "Lcom/avito/android/publish/publish_advert_request/PublishAdvertRequestViewModel$ViewState$Loading;", "Lcom/avito/android/publish/publish_advert_request/PublishAdvertRequestViewModel$ViewState$PhotosUploading;", "Lcom/avito/android/publish/publish_advert_request/PublishAdvertRequestViewModel$ViewState$PhotosUploaded;", "Lcom/avito/android/publish/publish_advert_request/PublishAdvertRequestViewModel$ViewState$Error;", "Lcom/avito/android/publish/publish_advert_request/PublishAdvertRequestViewModel$ViewState$PhotoUploadError;", "publish_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class ViewState {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/publish/publish_advert_request/PublishAdvertRequestViewModel$ViewState$Error;", "Lcom/avito/android/publish/publish_advert_request/PublishAdvertRequestViewModel$ViewState;", "Lcom/avito/android/remote/error/ErrorResult;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/error/ErrorResult;", "getError", "()Lcom/avito/android/remote/error/ErrorResult;", "error", "<init>", "(Lcom/avito/android/remote/error/ErrorResult;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
        public static final class Error extends ViewState {
            @NotNull
            public final ErrorResult a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Error(@NotNull ErrorResult errorResult) {
                super(null);
                Intrinsics.checkNotNullParameter(errorResult, "error");
                this.a = errorResult;
            }

            @NotNull
            public final ErrorResult getError() {
                return this.a;
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/publish/publish_advert_request/PublishAdvertRequestViewModel$ViewState$Loading;", "Lcom/avito/android/publish/publish_advert_request/PublishAdvertRequestViewModel$ViewState;", "<init>", "()V", "publish_release"}, k = 1, mv = {1, 4, 2})
        public static final class Loading extends ViewState {
            @NotNull
            public static final Loading INSTANCE = new Loading();

            public Loading() {
                super(null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/publish/publish_advert_request/PublishAdvertRequestViewModel$ViewState$PhotoUploadError;", "Lcom/avito/android/publish/publish_advert_request/PublishAdvertRequestViewModel$ViewState;", "<init>", "()V", "publish_release"}, k = 1, mv = {1, 4, 2})
        public static final class PhotoUploadError extends ViewState {
            @NotNull
            public static final PhotoUploadError INSTANCE = new PhotoUploadError();

            public PhotoUploadError() {
                super(null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/publish/publish_advert_request/PublishAdvertRequestViewModel$ViewState$PhotosUploaded;", "Lcom/avito/android/publish/publish_advert_request/PublishAdvertRequestViewModel$ViewState;", "<init>", "()V", "publish_release"}, k = 1, mv = {1, 4, 2})
        public static final class PhotosUploaded extends ViewState {
            @NotNull
            public static final PhotosUploaded INSTANCE = new PhotosUploaded();

            public PhotosUploaded() {
                super(null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/avito/android/publish/publish_advert_request/PublishAdvertRequestViewModel$ViewState$PhotosUploading;", "Lcom/avito/android/publish/publish_advert_request/PublishAdvertRequestViewModel$ViewState;", "", AuthSource.BOOKING_ORDER, "I", "getAllPhotosCount", "()I", "allPhotosCount", AuthSource.SEND_ABUSE, "getCurrentLoadedCount", "currentLoadedCount", "<init>", "(II)V", "publish_release"}, k = 1, mv = {1, 4, 2})
        public static final class PhotosUploading extends ViewState {
            public final int a;
            public final int b;

            public PhotosUploading(int i, int i2) {
                super(null);
                this.a = i;
                this.b = i2;
            }

            public final int getAllPhotosCount() {
                return this.b;
            }

            public final int getCurrentLoadedCount() {
                return this.a;
            }
        }

        public ViewState() {
        }

        public ViewState(j jVar) {
        }
    }

    public static final class a<T> implements Consumer<List<? extends String>> {
        public final /* synthetic */ PublishAdvertRequestViewModel a;
        public final /* synthetic */ CategoryParameters b;

        public a(PublishAdvertRequestViewModel publishAdvertRequestViewModel, CategoryParameters categoryParameters) {
            this.a = publishAdvertRequestViewModel;
            this.b = categoryParameters;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(List<? extends String> list) {
            List<? extends String> list2 = list;
            PublishAdvertRequestViewModel publishAdvertRequestViewModel = this.a;
            CategoryParameters categoryParameters = this.b;
            Intrinsics.checkNotNullExpressionValue(list2, "it");
            PublishAdvertRequestViewModel.access$preparePhotoParameter(publishAdvertRequestViewModel, categoryParameters, list2);
            this.a.d();
        }
    }

    public static final class b<T> implements Consumer<Throwable> {
        public final /* synthetic */ PublishAdvertRequestViewModel a;

        public b(PublishAdvertRequestViewModel publishAdvertRequestViewModel) {
            this.a = publishAdvertRequestViewModel;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            PublishAdvertRequestViewModel.access$getPublishViewModel$p(this.a).onUnexpectedErrorOccurred(new RuntimeException("PublishAdvertRequestViewModel:getUploadIds", th));
        }
    }

    public static final class c<T> implements Consumer<LoadingState<? super PublishedAdvertData>> {
        public final /* synthetic */ PublishAdvertRequestViewModel a;

        public c(PublishAdvertRequestViewModel publishAdvertRequestViewModel) {
            this.a = publishAdvertRequestViewModel;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(LoadingState<? super PublishedAdvertData> loadingState) {
            LoadingState<? super PublishedAdvertData> loadingState2 = loadingState;
            if (loadingState2 instanceof LoadingState.Loaded) {
                PublishAdvertRequestViewModel.access$getSubmissionPresenter$p(this.a).onAdvertPublished((PublishedAdvertData) ((LoadingState.Loaded) loadingState2).getData());
                this.a.j.track(new AddItemEvent.FinishPublish());
            } else if (loadingState2 instanceof LoadingState.Error) {
                Disposable disposable = this.a.c;
                if (disposable != null) {
                    disposable.dispose();
                }
                PublishAdvertRequestViewModel.access$onFailedToToPostAdvert(this.a, ((LoadingState.Error) loadingState2).getError());
            }
        }
    }

    public static final class d<T> implements Consumer<Throwable> {
        public final /* synthetic */ PublishAdvertRequestViewModel a;

        public d(PublishAdvertRequestViewModel publishAdvertRequestViewModel) {
            this.a = publishAdvertRequestViewModel;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            ViewState.Error error;
            ViewState.Error error2;
            Throwable th2 = th;
            Disposable disposable = this.a.c;
            if (disposable != null) {
                disposable.dispose();
            }
            Logs.error(th2);
            MutableLiveData mutableLiveData = this.a.h;
            String str = "";
            if (th2 instanceof IOException) {
                error = new ViewState.Error(new ErrorResult.NetworkIOError(str));
            } else {
                if (th2 instanceof UnauthorizedException) {
                    Throwable cause = th2.getCause();
                    String message = cause != null ? cause.getMessage() : null;
                    if (message != null) {
                        str = message;
                    }
                    error2 = new ViewState.Error(new ErrorResult.Unauthorized(str));
                } else if (th2 instanceof RuntimeException) {
                    String message2 = th2.getMessage();
                    Intrinsics.checkNotNull(message2);
                    error2 = new ViewState.Error(new ErrorResult.UnknownError(message2, null, null, 6, null));
                } else {
                    throw new RuntimeException(th2.getMessage());
                }
                error = error2;
            }
            mutableLiveData.setValue(error);
        }
    }

    public static final class e<T> implements Consumer<UploadingState> {
        public final /* synthetic */ PublishAdvertRequestViewModel a;

        public e(PublishAdvertRequestViewModel publishAdvertRequestViewModel) {
            this.a = publishAdvertRequestViewModel;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(UploadingState uploadingState) {
            UploadingState uploadingState2 = uploadingState;
            PublishAdvertRequestViewModel publishAdvertRequestViewModel = this.a;
            Intrinsics.checkNotNullExpressionValue(uploadingState2, "it");
            PublishAdvertRequestViewModel.access$processUploadingEvent(publishAdvertRequestViewModel, uploadingState2);
        }
    }

    public static final class f<T> implements Consumer<Throwable> {
        public final /* synthetic */ PublishAdvertRequestViewModel a;

        public f(PublishAdvertRequestViewModel publishAdvertRequestViewModel) {
            this.a = publishAdvertRequestViewModel;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r9v3, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            this.a.h.setValue(new ViewState.Error(new ErrorResult.UnknownError("", null, null, 6, null)));
            Disposable disposable = this.a.d;
            if (disposable != null) {
                disposable.dispose();
            }
        }
    }

    public PublishAdvertRequestViewModel(@NotNull PublishAdvertRepository publishAdvertRepository, @NotNull Analytics analytics, @NotNull SchedulersFactory schedulersFactory, @NotNull UploadingInteractor uploadingInteractor, @NotNull UploadingProgressInteractor uploadingProgressInteractor) {
        Intrinsics.checkNotNullParameter(publishAdvertRepository, "repository");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(uploadingInteractor, "uploadingInteractor");
        Intrinsics.checkNotNullParameter(uploadingProgressInteractor, "uploadingProgressInteractor");
        this.i = publishAdvertRepository;
        this.j = analytics;
        this.k = schedulersFactory;
        this.l = uploadingInteractor;
        this.m = uploadingProgressInteractor;
    }

    public static final /* synthetic */ PublishViewModel access$getPublishViewModel$p(PublishAdvertRequestViewModel publishAdvertRequestViewModel) {
        PublishViewModel publishViewModel = publishAdvertRequestViewModel.f;
        if (publishViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
        }
        return publishViewModel;
    }

    public static final /* synthetic */ SubmissionPresenter access$getSubmissionPresenter$p(PublishAdvertRequestViewModel publishAdvertRequestViewModel) {
        SubmissionPresenter submissionPresenter = publishAdvertRequestViewModel.g;
        if (submissionPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("submissionPresenter");
        }
        return submissionPresenter;
    }

    public static final void access$onFailedToToPostAdvert(PublishAdvertRequestViewModel publishAdvertRequestViewModel, TypedError typedError) {
        String str;
        Objects.requireNonNull(publishAdvertRequestViewModel);
        if (typedError instanceof TypedError.PretendError) {
            Map<String, PretendErrorValue> errors = ((TypedError.PretendError) typedError).getPretendResult().getErrors();
            PublishViewModel publishViewModel = publishAdvertRequestViewModel.f;
            if (publishViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
            }
            if (!publishViewModel.handleServerValidationErrors(errors)) {
                PretendErrorValue pretendErrorValue = (PretendErrorValue) CollectionsKt___CollectionsKt.firstOrNull(errors.values());
                if (pretendErrorValue == null || (str = pretendErrorValue.getSingleMessage()) == null) {
                    str = "";
                }
                publishAdvertRequestViewModel.h.setValue(new ViewState.Error(new ErrorResult.UnknownError(str, null, null, 6, null)));
            }
        } else if (typedError instanceof ErrorWithMessage.NetworkError) {
            publishAdvertRequestViewModel.h.setValue(new ViewState.Error(new ErrorResult.NetworkIOError(((ErrorWithMessage.NetworkError) typedError).getMessage())));
        } else if (typedError instanceof ErrorWithMessage) {
            publishAdvertRequestViewModel.h.setValue(new ViewState.Error(new ErrorResult.UnknownError(((ErrorWithMessage) typedError).getMessage(), null, null, 6, null)));
        }
    }

    public static final void access$preparePhotoParameter(PublishAdvertRequestViewModel publishAdvertRequestViewModel, CategoryParameters categoryParameters, List list) {
        Objects.requireNonNull(publishAdvertRequestViewModel);
        PhotoParameter photoParameter = (PhotoParameter) ((CategoryParameter) categoryParameters.getFirstParameterOfType(PhotoParameter.class));
        if (photoParameter != null) {
            photoParameter.setValue(new PhotoParameter.ImageUploadListWrapper(null, 1, null));
            PhotoParameter.ImageUploadListWrapper imageUploadListWrapper = (PhotoParameter.ImageUploadListWrapper) photoParameter.getValue();
            if (imageUploadListWrapper != null) {
                List<String> take = CollectionsKt___CollectionsKt.take(list, photoParameter.getMaxCount());
                ArrayList arrayList = new ArrayList(t6.n.e.collectionSizeOrDefault(take, 10));
                for (String str : take) {
                    arrayList.add(new ImageUploadResult(str, new Image(r.emptyMap())));
                }
                imageUploadListWrapper.addAll(arrayList);
            }
        }
    }

    public static final void access$processUploadingEvent(PublishAdvertRequestViewModel publishAdvertRequestViewModel, UploadingState uploadingState) {
        Objects.requireNonNull(publishAdvertRequestViewModel);
        if (uploadingState instanceof UploadingState.Loaded) {
            publishAdvertRequestViewModel.h.setValue(ViewState.PhotosUploaded.INSTANCE);
            publishAdvertRequestViewModel.c();
            Disposable disposable = publishAdvertRequestViewModel.d;
            if (disposable != null) {
                disposable.dispose();
            }
        } else if (uploadingState instanceof UploadingState.Error) {
            publishAdvertRequestViewModel.h.setValue(ViewState.PhotoUploadError.INSTANCE);
            Disposable disposable2 = publishAdvertRequestViewModel.d;
            if (disposable2 != null) {
                disposable2.dispose();
            }
        } else if (uploadingState instanceof UploadingState.Loading) {
            UploadingState.Loading loading = (UploadingState.Loading) uploadingState;
            publishAdvertRequestViewModel.h.setValue(new ViewState.PhotosUploading(loading.getProgressCurrent(), loading.getProgressMax()));
        }
    }

    public final void c() {
        PublishViewModel publishViewModel = this.f;
        if (publishViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
        }
        CategoryParameters categoryParameters = publishViewModel.getCategoryParameters();
        if (categoryParameters != null) {
            CompositeDisposable compositeDisposable = this.e;
            Disposable subscribe = this.m.getUploadIds().subscribeOn(this.k.io()).observeOn(this.k.mainThread()).subscribe(new a(this, categoryParameters), new b(this));
            Intrinsics.checkNotNullExpressionValue(subscribe, "uploadingProgressInterac…         )\n            })");
            DisposableKt.plusAssign(compositeDisposable, subscribe);
        }
    }

    public final void d() {
        Disposable disposable = this.c;
        if (disposable == null || disposable.isDisposed()) {
            PublishViewModel publishViewModel = this.f;
            if (publishViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
            }
            CategoryParameters categoryParameters = publishViewModel.getCategoryParameters();
            PublishViewModel publishViewModel2 = this.f;
            if (publishViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
            }
            ContactsData contactsData = publishViewModel2.getContactsData();
            if (categoryParameters == null) {
                PublishViewModel publishViewModel3 = this.f;
                if (publishViewModel3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
                }
                publishViewModel3.handleErrorOrFail("Cannot create advert because params are null");
            } else if (contactsData == null) {
                PublishViewModel publishViewModel4 = this.f;
                if (publishViewModel4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
                }
                publishViewModel4.handleErrorOrFail("Cannot create advert because contactsData is null");
            } else {
                PublishAdvertRepository publishAdvertRepository = this.i;
                PublishViewModel publishViewModel5 = this.f;
                if (publishViewModel5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
                }
                Navigation navigation = publishViewModel5.getNavigation();
                PublishViewModel publishViewModel6 = this.f;
                if (publishViewModel6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
                }
                this.c = publishAdvertRepository.postAdvert(navigation, categoryParameters, contactsData, publishViewModel6.getDraftId()).subscribeOn(this.k.io()).observeOn(this.k.mainThread()).subscribe(new c(this), new d(this));
            }
        }
    }

    public final void e(long j2) {
        this.h.setValue(ViewState.Loading.INSTANCE);
        this.d = this.m.getUploadProgressObservable().observeOn(this.k.mainThread()).delaySubscription(j2, TimeUnit.MILLISECONDS).subscribe(new e(this), new f(this));
    }

    public final void goPrevious() {
        PublishViewModel publishViewModel = this.f;
        if (publishViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
        }
        publishViewModel.goToPreviousStep();
    }

    public final void initScreen(@NotNull PublishViewModel publishViewModel, @NotNull SubmissionPresenter submissionPresenter) {
        Intrinsics.checkNotNullParameter(publishViewModel, "publishViewModel");
        Intrinsics.checkNotNullParameter(submissionPresenter, "submissionPresenter");
        this.f = publishViewModel;
        this.g = submissionPresenter;
        String advertId = publishViewModel.getAdvertId();
        if (advertId == null || advertId.length() == 0) {
            e(0);
        }
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        Disposable disposable = this.c;
        if (disposable != null) {
            disposable.dispose();
        }
        Disposable disposable2 = this.d;
        if (disposable2 != null) {
            disposable2.dispose();
        }
        this.e.clear();
        super.onCleared();
    }

    public final void onRetryClicked() {
        d();
    }

    public final void retryPhotoUpload() {
        UploadingInteractor.DefaultImpls.startUpload$default(this.l, null, 1, null);
        e(300);
    }

    @NotNull
    public final LiveData<ViewState> screenState() {
        return this.h;
    }

    public final void skipPhotoUpload() {
        this.h.setValue(ViewState.Loading.INSTANCE);
        c();
    }
}
