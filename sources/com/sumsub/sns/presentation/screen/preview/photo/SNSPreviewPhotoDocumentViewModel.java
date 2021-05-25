package com.sumsub.sns.presentation.screen.preview.photo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.pdf.PdfRenderer;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.webkit.MimeTypeMap;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModelKt;
import com.avito.android.remote.auth.AuthSource;
import com.google.gson.Gson;
import com.sumsub.sns.core.common.ExtensionsKt;
import com.sumsub.sns.core.data.model.AppConfigKt;
import com.sumsub.sns.core.data.model.Applicant;
import com.sumsub.sns.core.data.model.Document;
import com.sumsub.sns.core.data.model.DocumentPickerResult;
import com.sumsub.sns.core.data.model.Error;
import com.sumsub.sns.core.data.model.IdentitySide;
import com.sumsub.sns.core.data.model.LogType;
import com.sumsub.sns.core.data.model.remote.RemoteIdDoc;
import com.sumsub.sns.core.data.source.common.CommonRepository;
import com.sumsub.sns.core.domain.GetApplicantUseCase;
import com.sumsub.sns.core.domain.GetConfigUseCase;
import com.sumsub.sns.core.domain.SendLogUseCase;
import com.sumsub.sns.core.domain.model.Either;
import com.sumsub.sns.core.presentation.base.ActionLiveData;
import com.sumsub.sns.core.presentation.base.Event;
import com.sumsub.sns.domain.UploadDocumentImagesUseCase;
import com.sumsub.sns.presentation.screen.preview.SNSBaseDocumentPreviewViewModel;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.NonCancellable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.e;
import t6.n.h;
import t6.r.a.j;
import timber.log.Timber;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¾\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u0000 u2\u00020\u0001:\u0003uvwB?\u0012\u0006\u0010l\u001a\u00020k\u0012\u0006\u0010n\u001a\u00020m\u0012\u0006\u0010p\u001a\u00020o\u0012\u0006\u0010r\u001a\u00020q\u0012\u0006\u0010j\u001a\u00020g\u0012\u0006\u0010`\u001a\u00020]\u0012\u0006\u0010d\u001a\u00020a¢\u0006\u0004\bs\u0010tJ#\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\bJ\u000f\u0010\t\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\f\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\f\u0010\nJ\u0017\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\u0015\u0010\nJ\u0019\u0010\u0018\u001a\u00020\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\u001e\u0010\nJ\u0017\u0010 \u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u0002H\u0014¢\u0006\u0004\b \u0010!J-\u0010$\u001a\u00020\u00022\u0014\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\"2\u0006\u0010\u001f\u001a\u00020\u0002H\u0014¢\u0006\u0004\b$\u0010%J\r\u0010&\u001a\u00020\u0007¢\u0006\u0004\b&\u0010\nJ\r\u0010'\u001a\u00020\u0007¢\u0006\u0004\b'\u0010\nJ\u0017\u0010*\u001a\u00020\u00072\u0006\u0010)\u001a\u00020(H\u0004¢\u0006\u0004\b*\u0010+J\u000f\u0010-\u001a\u00020,H\u0014¢\u0006\u0004\b-\u0010.R7\u00107\u001a\b\u0012\u0004\u0012\u00020\u00160/2\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u00160/8D@DX\u0002¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\"\u0010=\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020:09088\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b;\u0010<R'\u0010C\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010@\u0012\u0004\u0012\u00020\u00110?0>8F@\u0006¢\u0006\u0006\u001a\u0004\bA\u0010BR\u001f\u0010J\u001a\b\u0012\u0004\u0012\u00020E0D8\u0006@\u0006¢\u0006\f\n\u0004\bF\u0010G\u001a\u0004\bH\u0010IR+\u0010)\u001a\u00020(2\u0006\u00100\u001a\u00020(8D@DX\u0002¢\u0006\u0012\n\u0004\bK\u00102\u001a\u0004\bL\u0010M\"\u0004\bN\u0010+R*\u0010P\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010@\u0012\u0004\u0012\u00020\u00110?0D8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bO\u0010GR\u001f\u0010R\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,090>8F@\u0006¢\u0006\u0006\u001a\u0004\bQ\u0010BR'\u0010V\u001a\u0010\u0012\f\u0012\n S*\u0004\u0018\u00010\r0\r0D8\u0006@\u0006¢\u0006\f\n\u0004\bT\u0010G\u001a\u0004\bU\u0010IR\"\u0010X\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,09088\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bW\u0010<R\u001f\u0010Z\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020:090>8F@\u0006¢\u0006\u0006\u001a\u0004\bY\u0010BR\"\u0010\\\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,09088\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b[\u0010<R\u0016\u0010`\u001a\u00020]8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b^\u0010_R\u0016\u0010d\u001a\u00020a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bb\u0010cR\u001f\u0010f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,090>8F@\u0006¢\u0006\u0006\u001a\u0004\be\u0010BR\u0016\u0010j\u001a\u00020g8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bh\u0010i¨\u0006x"}, d2 = {"Lcom/sumsub/sns/presentation/screen/preview/photo/SNSPreviewPhotoDocumentViewModel;", "Lcom/sumsub/sns/presentation/screen/preview/SNSBaseDocumentPreviewViewModel;", "", "message", "Ljava/lang/Exception;", "Lkotlin/Exception;", "e", "", "(Ljava/lang/String;Ljava/lang/Exception;)V", "d", "()V", "onLoad", "onTakeAnotherDataClicked", "", "hasBack", "onDocumentSideAnswerClicked", "(Z)V", "", "rotation", "onDataIsReadableClicked", "(I)V", "resolveBackSide", "Lcom/sumsub/sns/core/data/model/DocumentPickerResult;", "result", "onDocumentPicked", "(Lcom/sumsub/sns/core/data/model/DocumentPickerResult;)V", "Lcom/sumsub/sns/core/data/model/Error;", "error", "onHandleError", "(Lcom/sumsub/sns/core/data/model/Error;)V", "onDataLoaded", "sourceKey", "errorsTransformation", "(Ljava/lang/String;)Ljava/lang/String;", "", "map", "mapTransformation", "(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;", "onWarningIgnored", "onWarningAccepted", "Lcom/sumsub/sns/core/data/model/IdentitySide;", "side", "showPicker", "(Lcom/sumsub/sns/core/data/model/IdentitySide;)V", "Lcom/sumsub/sns/presentation/screen/preview/photo/SNSPreviewPhotoDocumentViewModel$PickerRequest;", "preparePickerRequest", "()Lcom/sumsub/sns/presentation/screen/preview/photo/SNSPreviewPhotoDocumentViewModel$PickerRequest;", "", "<set-?>", ExifInterface.LONGITUDE_EAST, "Lcom/sumsub/sns/presentation/screen/preview/SNSBaseDocumentPreviewViewModel$StateHandleDelegate;", "getResults", "()Ljava/util/List;", "setResults", "(Ljava/util/List;)V", "results", "Lcom/sumsub/sns/core/presentation/base/ActionLiveData;", "Lcom/sumsub/sns/core/presentation/base/Event;", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/sumsub/sns/core/presentation/base/ActionLiveData;", "_showAnotherSideAlertActionLiveData", "Landroidx/lifecycle/LiveData;", "Lkotlin/Pair;", "Landroid/graphics/Bitmap;", "getPhoto", "()Landroidx/lifecycle/LiveData;", "photo", "Landroidx/lifecycle/MutableLiveData;", "Lcom/sumsub/sns/presentation/screen/preview/photo/SNSPreviewPhotoDocumentViewModel$WarningResult;", "C", "Landroidx/lifecycle/MutableLiveData;", "getShowWarning", "()Landroidx/lifecycle/MutableLiveData;", "showWarning", "D", "getSide", "()Lcom/sumsub/sns/core/data/model/IdentitySide;", "setSide", "z", "_photoLiveData", "getShowSelfieWithDocumentPicker", "showSelfieWithDocumentPicker", "kotlin.jvm.PlatformType", "B", "getAllowRotate", "allowRotate", "y", "_showSelfieWithDocumentPickerActionLiveData", "getShowAnotherSideAlert", "showAnotherSideAlert", "x", "_showDocumentPhotoPickerActionLiveData", "Lcom/sumsub/sns/core/domain/SendLogUseCase;", "G", "Lcom/sumsub/sns/core/domain/SendLogUseCase;", "sendLogUseCase", "Lcom/google/gson/Gson;", "H", "Lcom/google/gson/Gson;", "gson", "getShowDocumentPhotoPicker", "showDocumentPhotoPicker", "Lcom/sumsub/sns/domain/UploadDocumentImagesUseCase;", "F", "Lcom/sumsub/sns/domain/UploadDocumentImagesUseCase;", "uploadDocumentImagesUseCase", "Lcom/sumsub/sns/core/domain/GetConfigUseCase;", "getConfigUseCase", "Lcom/sumsub/sns/core/domain/GetApplicantUseCase;", "getApplicantUseCase", "Landroidx/lifecycle/SavedStateHandle;", "savedStateHandle", "Lcom/sumsub/sns/core/data/source/common/CommonRepository;", "commonRepository", "<init>", "(Lcom/sumsub/sns/core/domain/GetConfigUseCase;Lcom/sumsub/sns/core/domain/GetApplicantUseCase;Landroidx/lifecycle/SavedStateHandle;Lcom/sumsub/sns/core/data/source/common/CommonRepository;Lcom/sumsub/sns/domain/UploadDocumentImagesUseCase;Lcom/sumsub/sns/core/domain/SendLogUseCase;Lcom/google/gson/Gson;)V", "Companion", "PickerRequest", "WarningResult", "idensic-mobile-sdk_release"}, k = 1, mv = {1, 4, 2})
public abstract class SNSPreviewPhotoDocumentViewModel extends SNSBaseDocumentPreviewViewModel {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final /* synthetic */ KProperty[] I = {a2.b.a.a.a.u0(SNSPreviewPhotoDocumentViewModel.class, "side", "getSide()Lcom/sumsub/sns/core/data/model/IdentitySide;", 0), a2.b.a.a.a.u0(SNSPreviewPhotoDocumentViewModel.class, "results", "getResults()Ljava/util/List;", 0)};
    public final ActionLiveData<Event<Object>> A = new ActionLiveData<>();
    @NotNull
    public final MutableLiveData<Boolean> B = new MutableLiveData<>(Boolean.FALSE);
    @NotNull
    public final MutableLiveData<WarningResult> C = new MutableLiveData<>();
    @NotNull
    public final SNSBaseDocumentPreviewViewModel.StateHandleDelegate D;
    @NotNull
    public final SNSBaseDocumentPreviewViewModel.StateHandleDelegate E;
    public final UploadDocumentImagesUseCase F;
    public final SendLogUseCase G;
    public final Gson H;
    public final ActionLiveData<Event<PickerRequest>> x = new ActionLiveData<>();
    public final ActionLiveData<Event<PickerRequest>> y = new ActionLiveData<>();
    public final MutableLiveData<Pair<Bitmap, Integer>> z = new MutableLiveData<>();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/sumsub/sns/presentation/screen/preview/photo/SNSPreviewPhotoDocumentViewModel$Companion;", "", "", "KEY_IDENTITY_SIDE", "Ljava/lang/String;", "KEY_RESULTS", "<init>", "()V", "idensic-mobile-sdk_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0017\b\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0005\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u0014\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b.\u0010/J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010JF\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u0014\u001a\u00020\u000b2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u000eHÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0010J\u0010\u0010\u001a\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u001d\u001a\u00020\u000b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eR\u0019\u0010\u0012\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\u0007R\u0019\u0010\u0014\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010\rR\u001b\u0010\u0015\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010\u0010R\u0019\u0010\u0011\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010\u0004R\u001b\u0010\u0013\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010\n¨\u00060"}, d2 = {"Lcom/sumsub/sns/presentation/screen/preview/photo/SNSPreviewPhotoDocumentViewModel$PickerRequest;", "", "Lcom/sumsub/sns/core/data/model/Applicant;", "component1", "()Lcom/sumsub/sns/core/data/model/Applicant;", "Lcom/sumsub/sns/core/data/model/Document;", "component2", "()Lcom/sumsub/sns/core/data/model/Document;", "Lcom/sumsub/sns/core/data/model/IdentitySide;", "component3", "()Lcom/sumsub/sns/core/data/model/IdentitySide;", "", "component4", "()Z", "", "component5", "()Ljava/lang/String;", "applicant", "document", "side", "gallery", "identityType", "copy", "(Lcom/sumsub/sns/core/data/model/Applicant;Lcom/sumsub/sns/core/data/model/Document;Lcom/sumsub/sns/core/data/model/IdentitySide;ZLjava/lang/String;)Lcom/sumsub/sns/presentation/screen/preview/photo/SNSPreviewPhotoDocumentViewModel$PickerRequest;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Lcom/sumsub/sns/core/data/model/Document;", "getDocument", "d", "Z", "getGallery", "e", "Ljava/lang/String;", "getIdentityType", AuthSource.SEND_ABUSE, "Lcom/sumsub/sns/core/data/model/Applicant;", "getApplicant", "c", "Lcom/sumsub/sns/core/data/model/IdentitySide;", "getSide", "<init>", "(Lcom/sumsub/sns/core/data/model/Applicant;Lcom/sumsub/sns/core/data/model/Document;Lcom/sumsub/sns/core/data/model/IdentitySide;ZLjava/lang/String;)V", "idensic-mobile-sdk_release"}, k = 1, mv = {1, 4, 2})
    public static final class PickerRequest {
        @NotNull
        public final Applicant a;
        @NotNull
        public final Document b;
        @Nullable
        public final IdentitySide c;
        public final boolean d;
        @Nullable
        public final String e;

        public PickerRequest(@NotNull Applicant applicant, @NotNull Document document, @Nullable IdentitySide identitySide, boolean z, @Nullable String str) {
            Intrinsics.checkNotNullParameter(applicant, "applicant");
            Intrinsics.checkNotNullParameter(document, "document");
            this.a = applicant;
            this.b = document;
            this.c = identitySide;
            this.d = z;
            this.e = str;
        }

        public static /* synthetic */ PickerRequest copy$default(PickerRequest pickerRequest, Applicant applicant, Document document, IdentitySide identitySide, boolean z, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                applicant = pickerRequest.a;
            }
            if ((i & 2) != 0) {
                document = pickerRequest.b;
            }
            if ((i & 4) != 0) {
                identitySide = pickerRequest.c;
            }
            if ((i & 8) != 0) {
                z = pickerRequest.d;
            }
            if ((i & 16) != 0) {
                str = pickerRequest.e;
            }
            return pickerRequest.copy(applicant, document, identitySide, z, str);
        }

        @NotNull
        public final Applicant component1() {
            return this.a;
        }

        @NotNull
        public final Document component2() {
            return this.b;
        }

        @Nullable
        public final IdentitySide component3() {
            return this.c;
        }

        public final boolean component4() {
            return this.d;
        }

        @Nullable
        public final String component5() {
            return this.e;
        }

        @NotNull
        public final PickerRequest copy(@NotNull Applicant applicant, @NotNull Document document, @Nullable IdentitySide identitySide, boolean z, @Nullable String str) {
            Intrinsics.checkNotNullParameter(applicant, "applicant");
            Intrinsics.checkNotNullParameter(document, "document");
            return new PickerRequest(applicant, document, identitySide, z, str);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PickerRequest)) {
                return false;
            }
            PickerRequest pickerRequest = (PickerRequest) obj;
            return Intrinsics.areEqual(this.a, pickerRequest.a) && Intrinsics.areEqual(this.b, pickerRequest.b) && Intrinsics.areEqual(this.c, pickerRequest.c) && this.d == pickerRequest.d && Intrinsics.areEqual(this.e, pickerRequest.e);
        }

        @NotNull
        public final Applicant getApplicant() {
            return this.a;
        }

        @NotNull
        public final Document getDocument() {
            return this.b;
        }

        public final boolean getGallery() {
            return this.d;
        }

        @Nullable
        public final String getIdentityType() {
            return this.e;
        }

        @Nullable
        public final IdentitySide getSide() {
            return this.c;
        }

        public int hashCode() {
            Applicant applicant = this.a;
            int i = 0;
            int hashCode = (applicant != null ? applicant.hashCode() : 0) * 31;
            Document document = this.b;
            int hashCode2 = (hashCode + (document != null ? document.hashCode() : 0)) * 31;
            IdentitySide identitySide = this.c;
            int hashCode3 = (hashCode2 + (identitySide != null ? identitySide.hashCode() : 0)) * 31;
            boolean z = this.d;
            if (z) {
                z = true;
            }
            int i2 = z ? 1 : 0;
            int i3 = z ? 1 : 0;
            int i4 = z ? 1 : 0;
            int i5 = (hashCode3 + i2) * 31;
            String str = this.e;
            if (str != null) {
                i = str.hashCode();
            }
            return i5 + i;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("PickerRequest(applicant=");
            L.append(this.a);
            L.append(", document=");
            L.append(this.b);
            L.append(", side=");
            L.append(this.c);
            L.append(", gallery=");
            L.append(this.d);
            L.append(", identityType=");
            return a2.b.a.a.a.t(L, this.e, ")");
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ PickerRequest(Applicant applicant, Document document, IdentitySide identitySide, boolean z, String str, int i, j jVar) {
            this(applicant, document, identitySide, z, (i & 16) != 0 ? null : str);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0013\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\b\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u000b¢\u0006\u0004\b&\u0010'J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ>\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\b2\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u000bHÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0014\u0010\nJ\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u0019\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR\u0019\u0010\u000f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u000f\u0010\u0007R\u001f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\rR\u0019\u0010\u000e\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010\u0004R\u0019\u0010\u0010\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010\n¨\u0006("}, d2 = {"Lcom/sumsub/sns/presentation/screen/preview/photo/SNSPreviewPhotoDocumentViewModel$WarningResult;", "", "", "component1", "()Ljava/lang/CharSequence;", "", "component2", "()Z", "", "component3", "()Ljava/lang/String;", "", "component4", "()Ljava/util/List;", "message", "isFatal", "idDocType", "availableIdDocs", "copy", "(Ljava/lang/CharSequence;ZLjava/lang/String;Ljava/util/List;)Lcom/sumsub/sns/presentation/screen/preview/photo/SNSPreviewPhotoDocumentViewModel$WarningResult;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Z", "d", "Ljava/util/List;", "getAvailableIdDocs", AuthSource.SEND_ABUSE, "Ljava/lang/CharSequence;", "getMessage", "c", "Ljava/lang/String;", "getIdDocType", "<init>", "(Ljava/lang/CharSequence;ZLjava/lang/String;Ljava/util/List;)V", "idensic-mobile-sdk_release"}, k = 1, mv = {1, 4, 2})
    public static final class WarningResult {
        @NotNull
        public final CharSequence a;
        public final boolean b;
        @NotNull
        public final String c;
        @NotNull
        public final List<String> d;

        public WarningResult(@NotNull CharSequence charSequence, boolean z, @NotNull String str, @NotNull List<String> list) {
            Intrinsics.checkNotNullParameter(charSequence, "message");
            Intrinsics.checkNotNullParameter(str, "idDocType");
            Intrinsics.checkNotNullParameter(list, "availableIdDocs");
            this.a = charSequence;
            this.b = z;
            this.c = str;
            this.d = list;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.sumsub.sns.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$WarningResult */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ WarningResult copy$default(WarningResult warningResult, CharSequence charSequence, boolean z, String str, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                charSequence = warningResult.a;
            }
            if ((i & 2) != 0) {
                z = warningResult.b;
            }
            if ((i & 4) != 0) {
                str = warningResult.c;
            }
            if ((i & 8) != 0) {
                list = warningResult.d;
            }
            return warningResult.copy(charSequence, z, str, list);
        }

        @NotNull
        public final CharSequence component1() {
            return this.a;
        }

        public final boolean component2() {
            return this.b;
        }

        @NotNull
        public final String component3() {
            return this.c;
        }

        @NotNull
        public final List<String> component4() {
            return this.d;
        }

        @NotNull
        public final WarningResult copy(@NotNull CharSequence charSequence, boolean z, @NotNull String str, @NotNull List<String> list) {
            Intrinsics.checkNotNullParameter(charSequence, "message");
            Intrinsics.checkNotNullParameter(str, "idDocType");
            Intrinsics.checkNotNullParameter(list, "availableIdDocs");
            return new WarningResult(charSequence, z, str, list);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof WarningResult)) {
                return false;
            }
            WarningResult warningResult = (WarningResult) obj;
            return Intrinsics.areEqual(this.a, warningResult.a) && this.b == warningResult.b && Intrinsics.areEqual(this.c, warningResult.c) && Intrinsics.areEqual(this.d, warningResult.d);
        }

        @NotNull
        public final List<String> getAvailableIdDocs() {
            return this.d;
        }

        @NotNull
        public final String getIdDocType() {
            return this.c;
        }

        @NotNull
        public final CharSequence getMessage() {
            return this.a;
        }

        public int hashCode() {
            CharSequence charSequence = this.a;
            int i = 0;
            int hashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
            boolean z = this.b;
            if (z) {
                z = true;
            }
            int i2 = z ? 1 : 0;
            int i3 = z ? 1 : 0;
            int i4 = z ? 1 : 0;
            int i5 = (hashCode + i2) * 31;
            String str = this.c;
            int hashCode2 = (i5 + (str != null ? str.hashCode() : 0)) * 31;
            List<String> list = this.d;
            if (list != null) {
                i = list.hashCode();
            }
            return hashCode2 + i;
        }

        public final boolean isFatal() {
            return this.b;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("WarningResult(message=");
            L.append(this.a);
            L.append(", isFatal=");
            L.append(this.b);
            L.append(", idDocType=");
            L.append(this.c);
            L.append(", availableIdDocs=");
            return a2.b.a.a.a.w(L, this.d, ")");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            IdentitySide.values();
            int[] iArr = new int[2];
            $EnumSwitchMapping$0 = iArr;
            IdentitySide identitySide = IdentitySide.Front;
            iArr[0] = 1;
            IdentitySide.values();
            int[] iArr2 = new int[2];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[0] = 1;
            IdentitySide identitySide2 = IdentitySide.Back;
            iArr2[1] = 2;
            IdentitySide.values();
            int[] iArr3 = new int[2];
            $EnumSwitchMapping$2 = iArr3;
            iArr3[1] = 1;
        }
    }

    @DebugMetadata(c = "com.sumsub.sns.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$onDataIsReadableClicked$1", f = "SNSPreviewPhotoDocumentViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public final /* synthetic */ SNSPreviewPhotoDocumentViewModel b;
        public final /* synthetic */ int c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(SNSPreviewPhotoDocumentViewModel sNSPreviewPhotoDocumentViewModel, int i, Continuation continuation) {
            super(2, continuation);
            this.b = sNSPreviewPhotoDocumentViewModel;
            this.c = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            Intrinsics.checkNotNullParameter(continuation, "completion");
            return new a(this.b, this.c, continuation);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            Continuation<? super Unit> continuation2 = continuation;
            Intrinsics.checkNotNullParameter(continuation2, "completion");
            return new a(this.b, this.c, continuation2).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            t6.p.a.a.getCOROUTINE_SUSPENDED();
            ResultKt.throwOnFailure(obj);
            SNSPreviewPhotoDocumentViewModel.access$applyRotation(this.b, this.c);
            Applicant.RequiredIdDocs.DocSetsItem docSetByType = this.b.getApplicant().getDocSetByType(this.b.getDocument().getType());
            if (docSetByType == null || !docSetByType.isSelfieWithDocument()) {
                int ordinal = this.b.getSide().ordinal();
                if (ordinal == 0) {
                    this.b.resolveBackSide();
                } else if (ordinal == 1) {
                    this.b.d();
                }
            } else {
                this.b.d();
            }
            return Unit.INSTANCE;
        }
    }

    public static final class b extends Lambda implements Function1<DocumentPickerResult, Boolean> {
        public final /* synthetic */ DocumentPickerResult a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(DocumentPickerResult documentPickerResult) {
            super(1);
            this.a = documentPickerResult;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Boolean invoke(DocumentPickerResult documentPickerResult) {
            DocumentPickerResult documentPickerResult2 = documentPickerResult;
            Intrinsics.checkNotNullParameter(documentPickerResult2, "it");
            return Boolean.valueOf(documentPickerResult2.getSide() == this.a.getSide());
        }
    }

    @DebugMetadata(c = "com.sumsub.sns.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$onUploadDocuments$3", f = "SNSPreviewPhotoDocumentViewModel.kt", i = {}, l = {274}, m = "invokeSuspend", n = {}, s = {})
    public static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int b;
        public final /* synthetic */ SNSPreviewPhotoDocumentViewModel c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(SNSPreviewPhotoDocumentViewModel sNSPreviewPhotoDocumentViewModel, Continuation continuation) {
            super(2, continuation);
            this.c = sNSPreviewPhotoDocumentViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            Intrinsics.checkNotNullParameter(continuation, "completion");
            return new c(this.c, continuation);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            Continuation<? super Unit> continuation2 = continuation;
            Intrinsics.checkNotNullParameter(continuation2, "completion");
            return new c(this.c, continuation2).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = t6.p.a.a.getCOROUTINE_SUSPENDED();
            int i = this.b;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                UploadDocumentImagesUseCase uploadDocumentImagesUseCase = this.c.F;
                UploadDocumentImagesUseCase.Params params = new UploadDocumentImagesUseCase.Params(this.c.getDocument(), this.c.getCountry(), this.c.getResults());
                this.b = 1;
                obj = uploadDocumentImagesUseCase.run((UploadDocumentImagesUseCase) params, (Continuation<? super Either<? extends Exception, ? extends List<RemoteIdDoc>>>) this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Either either = (Either) obj;
            SNSPreviewPhotoDocumentViewModel sNSPreviewPhotoDocumentViewModel = this.c;
            if (either.isRight()) {
                SNSPreviewPhotoDocumentViewModel.access$onDocumentsUploadedSuccess(sNSPreviewPhotoDocumentViewModel, (List) ((Either.Right) either).getB());
            } else if (either.isLeft()) {
                SNSPreviewPhotoDocumentViewModel.access$onDocumentsUploadedError(sNSPreviewPhotoDocumentViewModel, (Exception) ((Either.Left) either).getA());
            }
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.sumsub.sns.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$sendLog$1", f = "SNSPreviewPhotoDocumentViewModel.kt", i = {}, l = {244}, m = "invokeSuspend", n = {}, s = {})
    public static final class d extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int b;
        public final /* synthetic */ SNSPreviewPhotoDocumentViewModel c;
        public final /* synthetic */ Exception d;
        public final /* synthetic */ String e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(SNSPreviewPhotoDocumentViewModel sNSPreviewPhotoDocumentViewModel, Exception exc, String str, Continuation continuation) {
            super(2, continuation);
            this.c = sNSPreviewPhotoDocumentViewModel;
            this.d = exc;
            this.e = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            Intrinsics.checkNotNullParameter(continuation, "completion");
            return new d(this.c, this.d, this.e, continuation);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            Continuation<? super Unit> continuation2 = continuation;
            Intrinsics.checkNotNullParameter(continuation2, "completion");
            return new d(this.c, this.d, this.e, continuation2).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = t6.p.a.a.getCOROUTINE_SUSPENDED();
            int i = this.b;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                SendLogUseCase sendLogUseCase = this.c.G;
                SendLogUseCase.Params params = new SendLogUseCase.Params(LogType.Error, this.d, this.e);
                this.b = 1;
                if (sendLogUseCase.invoke(params, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SNSPreviewPhotoDocumentViewModel(@NotNull GetConfigUseCase getConfigUseCase, @NotNull GetApplicantUseCase getApplicantUseCase, @NotNull SavedStateHandle savedStateHandle, @NotNull CommonRepository commonRepository, @NotNull UploadDocumentImagesUseCase uploadDocumentImagesUseCase, @NotNull SendLogUseCase sendLogUseCase, @NotNull Gson gson) {
        super(savedStateHandle, getConfigUseCase, getApplicantUseCase, commonRepository);
        Intrinsics.checkNotNullParameter(getConfigUseCase, "getConfigUseCase");
        Intrinsics.checkNotNullParameter(getApplicantUseCase, "getApplicantUseCase");
        Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
        Intrinsics.checkNotNullParameter(commonRepository, "commonRepository");
        Intrinsics.checkNotNullParameter(uploadDocumentImagesUseCase, "uploadDocumentImagesUseCase");
        Intrinsics.checkNotNullParameter(sendLogUseCase, "sendLogUseCase");
        Intrinsics.checkNotNullParameter(gson, "gson");
        this.F = uploadDocumentImagesUseCase;
        this.G = sendLogUseCase;
        this.H = gson;
        this.D = new SNSBaseDocumentPreviewViewModel.StateHandleDelegate(savedStateHandle, "KEY_IDENTITY_SIDE", IdentitySide.Front);
        this.E = new SNSBaseDocumentPreviewViewModel.StateHandleDelegate(savedStateHandle, "KEY_RESULTS", new ArrayList());
    }

    public static final void access$applyRotation(SNSPreviewPhotoDocumentViewModel sNSPreviewPhotoDocumentViewModel, int i) {
        T t;
        boolean z2;
        Objects.requireNonNull(sNSPreviewPhotoDocumentViewModel);
        int i2 = i % 360;
        if (i2 != 0) {
            try {
                Iterator<T> it = sNSPreviewPhotoDocumentViewModel.getResults().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        t = null;
                        break;
                    }
                    t = it.next();
                    if (t.getSide() == sNSPreviewPhotoDocumentViewModel.getSide()) {
                        z2 = true;
                        continue;
                    } else {
                        z2 = false;
                        continue;
                    }
                    if (z2) {
                        break;
                    }
                }
                T t2 = t;
                if (t2 != null) {
                    if (i2 <= 0) {
                        i2 += 360;
                    }
                    File raw = t2.getRaw();
                    Intrinsics.checkNotNull(raw);
                    ExifInterface exifInterface = new ExifInterface(raw);
                    exifInterface.setAttribute(ExifInterface.TAG_ORIENTATION, String.valueOf(ExtensionsKt.resolveOrientation(i2 + exifInterface.getRotationDegrees())));
                    exifInterface.saveAttributes();
                }
            } catch (Exception e) {
                sNSPreviewPhotoDocumentViewModel.e("Can't apply rotation", e);
            }
        }
    }

    public static final Bitmap access$decodeImage(SNSPreviewPhotoDocumentViewModel sNSPreviewPhotoDocumentViewModel, File file) {
        Objects.requireNonNull(sNSPreviewPhotoDocumentViewModel);
        try {
            ExifInterface exifInterface = new ExifInterface(file);
            Bitmap decodeFile = BitmapFactory.decodeFile(file.getAbsolutePath());
            if (exifInterface.getRotationDegrees() == 0) {
                return decodeFile;
            }
            Intrinsics.checkNotNullExpressionValue(decodeFile, "bitmap");
            int width = decodeFile.getWidth();
            int height = decodeFile.getHeight();
            Matrix matrix = new Matrix();
            matrix.setRotate((float) exifInterface.getRotationDegrees());
            return Bitmap.createBitmap(decodeFile, 0, 0, width, height, matrix, true);
        } catch (Exception e) {
            Timber.e(e);
            sNSPreviewPhotoDocumentViewModel.e("Can't decode image", e);
            return null;
        }
    }

    public static final Bitmap access$decodePdf(SNSPreviewPhotoDocumentViewModel sNSPreviewPhotoDocumentViewModel, File file) {
        Objects.requireNonNull(sNSPreviewPhotoDocumentViewModel);
        try {
            PdfRenderer pdfRenderer = new PdfRenderer(ParcelFileDescriptor.open(file, 268435456));
            PdfRenderer.Page openPage = pdfRenderer.openPage(0);
            Intrinsics.checkNotNullExpressionValue(openPage, "page");
            Bitmap createBitmap = Bitmap.createBitmap(openPage.getWidth(), openPage.getHeight(), Bitmap.Config.ARGB_8888);
            openPage.render(createBitmap, null, null, 1);
            openPage.close();
            pdfRenderer.close();
            return createBitmap;
        } catch (Exception e) {
            Timber.e(e);
            sNSPreviewPhotoDocumentViewModel.e("Can't decode PDF", e);
            return null;
        }
    }

    public static final String access$getMimeType(SNSPreviewPhotoDocumentViewModel sNSPreviewPhotoDocumentViewModel, File file) {
        String fileExtensionFromUrl;
        Objects.requireNonNull(sNSPreviewPhotoDocumentViewModel);
        if (file == null || (fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(Uri.fromFile(file).toString())) == null) {
            return null;
        }
        return MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl);
    }

    public static final void access$onDocumentsUploadedError(SNSPreviewPhotoDocumentViewModel sNSPreviewPhotoDocumentViewModel, Exception exc) {
        Objects.requireNonNull(sNSPreviewPhotoDocumentViewModel);
        Timber.e(exc, "Exception while uploading identity photos", new Object[0]);
        sNSPreviewPhotoDocumentViewModel.get_showProgressLiveData().setValue(Boolean.FALSE);
        sNSPreviewPhotoDocumentViewModel.get_throwErrorActionLiveData().setValue(new Event<>(exc));
    }

    /* JADX WARNING: Removed duplicated region for block: B:111:0x025f  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0060 A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void access$onDocumentsUploadedSuccess(com.sumsub.sns.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel r10, java.util.List r11) {
        /*
        // Method dump skipped, instructions count: 624
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.access$onDocumentsUploadedSuccess(com.sumsub.sns.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel, java.util.List):void");
    }

    public final void d() {
        boolean z2;
        get_showProgressLiveData().setValue(Boolean.TRUE);
        boolean z3 = false;
        if (getResults().isEmpty()) {
            onMoveToVerificationScreen(false);
            return;
        }
        if (getResults().size() == 1) {
            List<DocumentPickerResult> results = getResults();
            if (!(results instanceof Collection) || !results.isEmpty()) {
                Iterator<T> it = results.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (it.next().getSide() != null) {
                            z2 = true;
                            continue;
                        } else {
                            z2 = false;
                            continue;
                        }
                        if (z2) {
                            z3 = true;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            if (z3) {
                List<DocumentPickerResult> results2 = getResults();
                ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(results2, 10));
                Iterator<T> it2 = results2.iterator();
                while (it2.hasNext()) {
                    arrayList.add(DocumentPickerResult.copy$default(it2.next(), null, null, null, null, null, 15, null));
                }
                setResults(CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList));
            }
        }
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new c(this, null), 3, null);
    }

    public final void e(String str, Exception exc) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), NonCancellable.INSTANCE, null, new d(this, exc, str, null), 2, null);
    }

    @NotNull
    public String errorsTransformation(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "sourceKey");
        return mapTransformation(AppConfigKt.getErrors(getConfig()), str);
    }

    @NotNull
    public final MutableLiveData<Boolean> getAllowRotate() {
        return this.B;
    }

    @NotNull
    public final LiveData<Pair<Bitmap, Integer>> getPhoto() {
        return this.z;
    }

    @NotNull
    public final List<DocumentPickerResult> getResults() {
        return (List) this.E.getValue(this, I[1]);
    }

    @NotNull
    public final LiveData<Event<Object>> getShowAnotherSideAlert() {
        return this.A;
    }

    @NotNull
    public final LiveData<Event<PickerRequest>> getShowDocumentPhotoPicker() {
        return this.x;
    }

    @NotNull
    public final LiveData<Event<PickerRequest>> getShowSelfieWithDocumentPicker() {
        return this.y;
    }

    @NotNull
    public final MutableLiveData<WarningResult> getShowWarning() {
        return this.C;
    }

    @NotNull
    public final IdentitySide getSide() {
        return (IdentitySide) this.D.getValue(this, I[0]);
    }

    @NotNull
    public String mapTransformation(@Nullable Map<String, String> map, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "sourceKey");
        return (map != null ? map.get(str) : null) != null ? str : "default";
    }

    @Override // com.sumsub.sns.presentation.screen.preview.SNSBaseDocumentPreviewViewModel
    public void onDataIsReadableClicked(int i) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new a(this, i, null), 3, null);
    }

    @Override // com.sumsub.sns.presentation.screen.preview.SNSBaseDocumentPreviewViewModel
    public void onDataLoaded() {
        showPicker(IdentitySide.Front);
    }

    public void onDocumentPicked(@Nullable DocumentPickerResult documentPickerResult) {
        if (documentPickerResult == null) {
            if (getResults().isEmpty()) {
                onMoveToVerificationScreen(true);
            } else if (getSide().ordinal() == 1) {
                setSide(IdentitySide.Front);
            }
            get_showContentLiveData().setValue(Boolean.TRUE);
            get_showProgressLiveData().setValue(Boolean.FALSE);
            return;
        }
        h.removeAll((List) getResults(), (Function1) new b(documentPickerResult));
        if (documentPickerResult.getType() == null) {
            getResults().add(DocumentPickerResult.copy$default(documentPickerResult, null, null, null, getIdDocType(), null, 23, null));
        } else {
            getResults().add(documentPickerResult);
        }
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new a2.q.a.d.a.d.b.c(this, documentPickerResult, null), 3, null);
    }

    public void onDocumentSideAnswerClicked(boolean z2) {
        if (z2) {
            if (getSide().ordinal() == 0) {
                setSide(IdentitySide.Back);
            }
            showPicker(getSide());
            return;
        }
        d();
    }

    @Override // com.sumsub.sns.presentation.screen.base.SNSBaseViewModel, com.sumsub.sns.core.presentation.base.SNSBaseViewModel
    public void onHandleError(@NotNull Error error) {
        Intrinsics.checkNotNullParameter(error, "error");
        Timber.d("Preview photo error handling... " + error, new Object[0]);
        if (error instanceof Error.Network) {
            d();
        }
    }

    @Override // com.sumsub.sns.presentation.screen.preview.SNSBaseDocumentPreviewViewModel, com.sumsub.sns.presentation.screen.base.SNSBaseViewModel
    public void onLoad() {
        if (!getResults().isEmpty()) {
            BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new a2.q.a.d.a.d.b.c(this, (DocumentPickerResult) CollectionsKt___CollectionsKt.last((List<? extends Object>) getResults()), null), 3, null);
        } else {
            super.onLoad();
        }
    }

    @Override // com.sumsub.sns.presentation.screen.preview.SNSBaseDocumentPreviewViewModel
    public void onTakeAnotherDataClicked() {
        showPicker(getSide());
    }

    public final void onWarningAccepted() {
        setSide(IdentitySide.Front);
        getResults().clear();
        showPicker(getSide());
    }

    public final void onWarningIgnored() {
        onDocumentUploaded(getDocument());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x004c, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual(r0 != null ? r0.getVideoRequired() : null, com.sumsub.sns.core.data.model.VideoRequiredType.Companion.m229getDisabledu2aduso()) != false) goto L_0x0052;
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.sumsub.sns.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.PickerRequest preparePickerRequest() {
        /*
            r9 = this;
            com.sumsub.sns.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$PickerRequest r8 = new com.sumsub.sns.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$PickerRequest
            com.sumsub.sns.core.data.model.Applicant r1 = r9.getApplicant()
            com.sumsub.sns.core.data.model.Document r2 = r9.getDocument()
            com.sumsub.sns.core.data.model.IdentitySide r3 = r9.getSide()
            com.sumsub.sns.core.data.model.Document r0 = r9.getDocument()
            com.sumsub.sns.core.data.model.DocumentType r0 = r0.getType()
            boolean r0 = r0.isPOA()
            if (r0 != 0) goto L_0x0052
            com.sumsub.sns.core.data.model.Document r0 = r9.getDocument()
            com.sumsub.sns.core.data.model.DocumentType r0 = r0.getType()
            boolean r0 = r0.isSelfie()
            if (r0 == 0) goto L_0x004f
            com.sumsub.sns.core.data.model.Applicant r0 = r9.getApplicant()
            com.sumsub.sns.core.data.model.Document r4 = r9.getDocument()
            com.sumsub.sns.core.data.model.DocumentType r4 = r4.getType()
            com.sumsub.sns.core.data.model.Applicant$RequiredIdDocs$DocSetsItem r0 = r0.getDocSetByType(r4)
            if (r0 == 0) goto L_0x0041
            java.lang.String r0 = r0.getVideoRequired()
            goto L_0x0042
        L_0x0041:
            r0 = 0
        L_0x0042:
            com.sumsub.sns.core.data.model.VideoRequiredType$Companion r4 = com.sumsub.sns.core.data.model.VideoRequiredType.Companion
            java.lang.String r4 = r4.m229getDisabledu2aduso()
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r4)
            if (r0 == 0) goto L_0x004f
            goto L_0x0052
        L_0x004f:
            r0 = 0
            r4 = 0
            goto L_0x0054
        L_0x0052:
            r0 = 1
            r4 = 1
        L_0x0054:
            r5 = 0
            r6 = 16
            r7 = 0
            r0 = r8
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel.preparePickerRequest():com.sumsub.sns.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel$PickerRequest");
    }

    public void resolveBackSide() {
        this.A.setValue(new Event<>(new Object()));
    }

    public final void setResults(@NotNull List<DocumentPickerResult> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.E.setValue(this, I[1], list);
    }

    public final void setSide(@NotNull IdentitySide identitySide) {
        Intrinsics.checkNotNullParameter(identitySide, "<set-?>");
        this.D.setValue(this, I[0], identitySide);
    }

    public final void showPicker(@NotNull IdentitySide identitySide) {
        Intrinsics.checkNotNullParameter(identitySide, "side");
        PickerRequest preparePickerRequest = preparePickerRequest();
        Applicant.RequiredIdDocs.DocSetsItem docSetByType = getApplicant().getDocSetByType(getDocument().getType());
        if (docSetByType == null || !docSetByType.isSelfieWithDocument()) {
            this.x.setValue(new Event<>(preparePickerRequest));
        } else {
            this.y.setValue(new Event<>(preparePickerRequest));
        }
        get_showProgressLiveData().postValue(Boolean.FALSE);
    }
}
