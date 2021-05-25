package com.sumsub.sns.camera;

import a2.g.r.g;
import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.avito.android.remote.auth.AuthSource;
import com.otaliastudios.cameraview.controls.Flash;
import com.otaliastudios.cameraview.frame.Frame;
import com.otaliastudios.cameraview.video.encoding.TextureMediaEncoder;
import com.sumsub.sns.core.common.ExtensionsKt;
import com.sumsub.sns.core.common.SNSConstants;
import com.sumsub.sns.core.data.model.Applicant;
import com.sumsub.sns.core.data.model.DocumentPickerResult;
import com.sumsub.sns.core.data.model.DocumentType;
import com.sumsub.sns.core.data.model.IdentitySide;
import com.sumsub.sns.core.data.model.IdentityType;
import com.sumsub.sns.core.presentation.base.ActionLiveData;
import com.sumsub.sns.core.presentation.base.Event;
import com.sumsub.sns.core.presentation.base.SNSBaseViewModel;
import com.vk.sdk.api.VKApiConst;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.d;
import t6.r.a.j;
import timber.log.Timber;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0015\b&\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010@\u001a\u00020;\u0012\u0006\u0010F\u001a\u00020A\u0012\b\u0010T\u001a\u0004\u0018\u00010O\u0012\n\b\u0002\u0010_\u001a\u0004\u0018\u00010Z¢\u0006\u0004\bm\u0010nJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\bJ\u0015\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\"\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\n0\u001a8\u0004@\u0004X\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR(\u0010'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0!0 8\u0004@\u0004X\u0004¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u001f\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0!0(8F@\u0006¢\u0006\u0006\u001a\u0004\b)\u0010*R\u0019\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0(8F@\u0006¢\u0006\u0006\u001a\u0004\b,\u0010*R\u0019\u0010/\u001a\b\u0012\u0004\u0012\u00020-0(8F@\u0006¢\u0006\u0006\u001a\u0004\b.\u0010*R\"\u00102\u001a\b\u0012\u0004\u0012\u00020-0\u001a8\u0004@\u0004X\u0004¢\u0006\f\n\u0004\b0\u0010\u001c\u001a\u0004\b1\u0010\u001eR\u001f\u00104\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0!0(8F@\u0006¢\u0006\u0006\u001a\u0004\b3\u0010*R\"\u00108\u001a\b\u0012\u0004\u0012\u0002050 8\u0004@\u0004X\u0004¢\u0006\f\n\u0004\b6\u0010$\u001a\u0004\b7\u0010&R\u0019\u0010:\u001a\b\u0012\u0004\u0012\u0002050(8F@\u0006¢\u0006\u0006\u001a\u0004\b9\u0010*R\u001c\u0010@\u001a\u00020;8\u0004@\u0004X\u0004¢\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?R\u001c\u0010F\u001a\u00020A8\u0004@\u0004X\u0004¢\u0006\f\n\u0004\bB\u0010C\u001a\u0004\bD\u0010ER\u0019\u0010H\u001a\b\u0012\u0004\u0012\u0002050(8F@\u0006¢\u0006\u0006\u001a\u0004\bG\u0010*R(\u0010K\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0!0 8\u0004@\u0004X\u0004¢\u0006\f\n\u0004\bI\u0010$\u001a\u0004\bJ\u0010&R\"\u0010N\u001a\b\u0012\u0004\u0012\u00020-0\u001a8\u0004@\u0004X\u0004¢\u0006\f\n\u0004\bL\u0010\u001c\u001a\u0004\bM\u0010\u001eR\u001e\u0010T\u001a\u0004\u0018\u00010O8\u0004@\u0004X\u0004¢\u0006\f\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010SR\"\u0010V\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160!0 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bU\u0010$R(\u0010Y\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0!0 8\u0004@\u0004X\u0004¢\u0006\f\n\u0004\bW\u0010$\u001a\u0004\bX\u0010&R\u001e\u0010_\u001a\u0004\u0018\u00010Z8\u0004@\u0004X\u0004¢\u0006\f\n\u0004\b[\u0010\\\u001a\u0004\b]\u0010^R\u001f\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160!0(8F@\u0006¢\u0006\u0006\u001a\u0004\b`\u0010*R\"\u0010c\u001a\b\u0012\u0004\u0012\u0002050 8\u0004@\u0004X\u0004¢\u0006\f\n\u0004\ba\u0010$\u001a\u0004\bb\u0010&R\u001f\u0010e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0!0(8F@\u0006¢\u0006\u0006\u001a\u0004\bd\u0010*R\u0019\u0010g\u001a\b\u0012\u0004\u0012\u00020-0(8F@\u0006¢\u0006\u0006\u001a\u0004\bf\u0010*R\u0019\u0010i\u001a\b\u0012\u0004\u0012\u0002050(8F@\u0006¢\u0006\u0006\u001a\u0004\bh\u0010*R\"\u0010l\u001a\b\u0012\u0004\u0012\u0002050 8\u0004@\u0004X\u0004¢\u0006\f\n\u0004\bj\u0010$\u001a\u0004\bk\u0010&¨\u0006o"}, d2 = {"Lcom/sumsub/sns/camera/SNSCameraViewModel;", "Lcom/sumsub/sns/core/presentation/base/SNSBaseViewModel;", "Landroid/content/Context;", "context", "", "initHelper", "(Landroid/content/Context;)V", "onBackClicked", "()V", "onTakePictureClicked", "Lcom/otaliastudios/cameraview/controls/Flash;", "flash", "onToggleFlashClicked", "(Lcom/otaliastudios/cameraview/controls/Flash;)V", "", "data", "onPictureTaken", "([B)V", "Lcom/otaliastudios/cameraview/frame/Frame;", TextureMediaEncoder.FRAME_EVENT, "onHandleVideoFrame", "(Lcom/otaliastudios/cameraview/frame/Frame;)V", "Lcom/sumsub/sns/core/data/model/DocumentPickerResult;", "result", "finishWithResult", "(Lcom/sumsub/sns/core/data/model/DocumentPickerResult;)V", "Landroidx/lifecycle/MutableLiveData;", "i", "Landroidx/lifecycle/MutableLiveData;", "get_flashLiveData", "()Landroidx/lifecycle/MutableLiveData;", "_flashLiveData", "Lcom/sumsub/sns/core/presentation/base/ActionLiveData;", "Lcom/sumsub/sns/core/presentation/base/Event;", "", "j", "Lcom/sumsub/sns/core/presentation/base/ActionLiveData;", "get_startScannerActionLiveData", "()Lcom/sumsub/sns/core/presentation/base/ActionLiveData;", "_startScannerActionLiveData", "Landroidx/lifecycle/LiveData;", "getStopScanner", "()Landroidx/lifecycle/LiveData;", "stopScanner", "getFlash", "", "getShowTakePicture", "showTakePicture", "h", "get_showTakePictureLiveData", "_showTakePictureLiveData", "getTakePicture", "takePicture", "", "n", "get_helperBriefLiveData", "_helperBriefLiveData", "getHelperTitle", "helperTitle", "Lcom/sumsub/sns/core/data/model/Applicant;", VKApiConst.Q, "Lcom/sumsub/sns/core/data/model/Applicant;", "getApplicant", "()Lcom/sumsub/sns/core/data/model/Applicant;", "applicant", "Lcom/sumsub/sns/core/data/model/DocumentType;", "r", "Lcom/sumsub/sns/core/data/model/DocumentType;", "getType", "()Lcom/sumsub/sns/core/data/model/DocumentType;", "type", "getHelperBrief", "helperBrief", "k", "get_stopScannerActionLiveData", "_stopScannerActionLiveData", g.a, "get_showCameraLiveData", "_showCameraLiveData", "", "s", "Ljava/lang/String;", "getIdentityType", "()Ljava/lang/String;", "identityType", "p", "_finishWithResultActionLiveData", "l", "get_takePictureActionLiveData", "_takePictureActionLiveData", "Lcom/sumsub/sns/core/data/model/IdentitySide;", "t", "Lcom/sumsub/sns/core/data/model/IdentitySide;", "getSide", "()Lcom/sumsub/sns/core/data/model/IdentitySide;", "side", "getFinishWithResult", "o", "get_helperDetailsLiveData", "_helperDetailsLiveData", "getStartScanner", "startScanner", "getShowCamera", "showCamera", "getHelperDetails", "helperDetails", AuthSource.OPEN_CHANNEL_LIST, "get_helperTitleLiveData", "_helperTitleLiveData", "<init>", "(Lcom/sumsub/sns/core/data/model/Applicant;Lcom/sumsub/sns/core/data/model/DocumentType;Ljava/lang/String;Lcom/sumsub/sns/core/data/model/IdentitySide;)V", "sns-camera_release"}, k = 1, mv = {1, 4, 2})
public abstract class SNSCameraViewModel extends SNSBaseViewModel {
    @NotNull
    public final MutableLiveData<Boolean> g;
    @NotNull
    public final MutableLiveData<Boolean> h;
    @NotNull
    public final MutableLiveData<Flash> i;
    @NotNull
    public final ActionLiveData<Event<Object>> j;
    @NotNull
    public final ActionLiveData<Event<Object>> k;
    @NotNull
    public final ActionLiveData<Event<Object>> l;
    @NotNull
    public final ActionLiveData<CharSequence> m;
    @NotNull
    public final ActionLiveData<CharSequence> n;
    @NotNull
    public final ActionLiveData<CharSequence> o;
    public final ActionLiveData<Event<DocumentPickerResult>> p;
    @NotNull
    public final Applicant q;
    @NotNull
    public final DocumentType r;
    @Nullable
    public final String s;
    @Nullable
    public final IdentitySide t;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            IdentitySide.values();
            int[] iArr = new int[2];
            $EnumSwitchMapping$0 = iArr;
            IdentitySide identitySide = IdentitySide.Front;
            iArr[0] = 1;
            IdentitySide identitySide2 = IdentitySide.Back;
            iArr[1] = 2;
        }
    }

    /* compiled from: kotlin-style lambda group */
    public static final class a extends Lambda implements Function1<IdentityType, CharSequence> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(int i, Object obj) {
            super(1);
            this.a = i;
            this.b = obj;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public final CharSequence invoke(IdentityType identityType) {
            int i = this.a;
            if (i == 0) {
                String r4 = identityType.m209unboximpl();
                Intrinsics.checkNotNullParameter(r4, "it");
                return IdentityType.m206getTitleimpl(r4, (Context) this.b);
            } else if (i == 1) {
                String r42 = identityType.m209unboximpl();
                Intrinsics.checkNotNullParameter(r42, "it");
                return IdentityType.m206getTitleimpl(r42, (Context) this.b);
            } else {
                throw null;
            }
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SNSCameraViewModel(Applicant applicant, DocumentType documentType, String str, IdentitySide identitySide, int i2, j jVar) {
        this(applicant, documentType, str, (i2 & 8) != 0 ? null : identitySide);
    }

    public void finishWithResult(@NotNull DocumentPickerResult documentPickerResult) {
        Intrinsics.checkNotNullParameter(documentPickerResult, "result");
        this.p.postValue(new Event<>(documentPickerResult));
    }

    @NotNull
    public final Applicant getApplicant() {
        return this.q;
    }

    @NotNull
    public final LiveData<Event<DocumentPickerResult>> getFinishWithResult() {
        return this.p;
    }

    @NotNull
    public final LiveData<Flash> getFlash() {
        return this.i;
    }

    @NotNull
    public final LiveData<CharSequence> getHelperBrief() {
        return this.n;
    }

    @NotNull
    public final LiveData<CharSequence> getHelperDetails() {
        return this.o;
    }

    @NotNull
    public final LiveData<CharSequence> getHelperTitle() {
        return this.m;
    }

    @Nullable
    public final String getIdentityType() {
        return this.s;
    }

    @NotNull
    public final LiveData<Boolean> getShowCamera() {
        return this.g;
    }

    @NotNull
    public final LiveData<Boolean> getShowTakePicture() {
        return this.h;
    }

    @Nullable
    public final IdentitySide getSide() {
        return this.t;
    }

    @NotNull
    public final LiveData<Event<Object>> getStartScanner() {
        return this.j;
    }

    @NotNull
    public final LiveData<Event<Object>> getStopScanner() {
        return this.k;
    }

    @NotNull
    public final LiveData<Event<Object>> getTakePicture() {
        return this.l;
    }

    @NotNull
    public final DocumentType getType() {
        return this.r;
    }

    @NotNull
    public final MutableLiveData<Flash> get_flashLiveData() {
        return this.i;
    }

    @NotNull
    public final ActionLiveData<CharSequence> get_helperBriefLiveData() {
        return this.n;
    }

    @NotNull
    public final ActionLiveData<CharSequence> get_helperDetailsLiveData() {
        return this.o;
    }

    @NotNull
    public final ActionLiveData<CharSequence> get_helperTitleLiveData() {
        return this.m;
    }

    @NotNull
    public final MutableLiveData<Boolean> get_showCameraLiveData() {
        return this.g;
    }

    @NotNull
    public final MutableLiveData<Boolean> get_showTakePictureLiveData() {
        return this.h;
    }

    @NotNull
    public final ActionLiveData<Event<Object>> get_startScannerActionLiveData() {
        return this.j;
    }

    @NotNull
    public final ActionLiveData<Event<Object>> get_stopScannerActionLiveData() {
        return this.k;
    }

    @NotNull
    public final ActionLiveData<Event<Object>> get_takePictureActionLiveData() {
        return this.l;
    }

    public void initHelper(@NotNull Context context) {
        List<IdentityType> list;
        Intrinsics.checkNotNullParameter(context, "context");
        Timber.i("Camera is started. Side - " + this.t, new Object[0]);
        IdentitySide identitySide = this.t;
        if (identitySide != null) {
            int ordinal = identitySide.ordinal();
            if (ordinal == 0) {
                String str = this.s;
                if (str == null || (list = d.listOf(IdentityType.m201boximpl(IdentityType.m202constructorimpl(str)))) == null) {
                    list = this.q.getIdentityList(this.r);
                }
                String joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(list, ExtensionsKt.getTextResource$default(context, R.string.sns_iddoc_listing_join, (String) null, 2, (Object) null), null, null, 0, null, new a(0, context), 30, null);
                String joinToString$default2 = CollectionsKt___CollectionsKt.joinToString$default(list, ExtensionsKt.getTextResource$default(context, R.string.sns_iddoc_listing_join_details, (String) null, 2, (Object) null), null, null, 0, null, new a(1, context), 30, null);
                ActionLiveData<CharSequence> actionLiveData = this.m;
                String H = a2.b.a.a.a.H(new Object[]{this.r.getValue()}, 1, SNSConstants.Resources.Key.SCAN_HELPER_FRONT_SIDE_TITLE, "java.lang.String.format(format, *args)");
                String string = context.getString(R.string.sns_step_defaults_scan_frontSide_title);
                Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri…lts_scan_frontSide_title)");
                actionLiveData.setValue(ExtensionsKt.getStringResource(context, H, string));
                ActionLiveData<CharSequence> actionLiveData2 = this.n;
                String H2 = a2.b.a.a.a.H(new Object[]{this.r.getValue()}, 1, SNSConstants.Resources.Key.SCAN_HELPER_FRONT_SIDE_BRIEF, "java.lang.String.format(format, *args)");
                String string2 = context.getString(R.string.sns_step_defaults_scan_frontSide_brief);
                Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.stri…lts_scan_frontSide_brief)");
                String format = String.format(ExtensionsKt.getStringResource(context, H2, string2), Arrays.copyOf(new Object[]{joinToString$default}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
                actionLiveData2.setValue(format);
                ActionLiveData<CharSequence> actionLiveData3 = this.o;
                String H3 = a2.b.a.a.a.H(new Object[]{this.r.getValue()}, 1, SNSConstants.Resources.Key.SCAN_HELPER_FRONT_SIDE_DETAILS, "java.lang.String.format(format, *args)");
                String string3 = context.getString(R.string.sns_step_defaults_scan_frontSide_details);
                Intrinsics.checkNotNullExpressionValue(string3, "context.getString(R.stri…s_scan_frontSide_details)");
                String format2 = String.format(ExtensionsKt.getStringResource(context, H3, string3), Arrays.copyOf(new Object[]{joinToString$default2}, 1));
                Intrinsics.checkNotNullExpressionValue(format2, "java.lang.String.format(format, *args)");
                actionLiveData3.setValue(format2);
            } else if (ordinal == 1) {
                ActionLiveData<CharSequence> actionLiveData4 = this.m;
                String H4 = a2.b.a.a.a.H(new Object[]{this.r.getValue()}, 1, SNSConstants.Resources.Key.SCAN_HELPER_BACK_SIDE_TITLE, "java.lang.String.format(format, *args)");
                String string4 = context.getString(R.string.sns_step_defaults_scan_backSide_title);
                Intrinsics.checkNotNullExpressionValue(string4, "context.getString(R.stri…ults_scan_backSide_title)");
                actionLiveData4.setValue(ExtensionsKt.getStringResource(context, H4, string4));
                ActionLiveData<CharSequence> actionLiveData5 = this.n;
                String H5 = a2.b.a.a.a.H(new Object[]{this.r.getValue()}, 1, SNSConstants.Resources.Key.SCAN_HELPER_BACK_SIDE_BRIEF, "java.lang.String.format(format, *args)");
                String string5 = context.getString(R.string.sns_step_defaults_scan_backSide_brief);
                Intrinsics.checkNotNullExpressionValue(string5, "context.getString(R.stri…ults_scan_backSide_brief)");
                actionLiveData5.setValue(ExtensionsKt.getStringResource(context, H5, string5));
                ActionLiveData<CharSequence> actionLiveData6 = this.o;
                String H6 = a2.b.a.a.a.H(new Object[]{this.r.getValue()}, 1, SNSConstants.Resources.Key.SCAN_HELPER_BACK_SIDE_DETAILS, "java.lang.String.format(format, *args)");
                String string6 = context.getString(R.string.sns_step_defaults_scan_backSide_details);
                Intrinsics.checkNotNullExpressionValue(string6, "context.getString(R.stri…ts_scan_backSide_details)");
                actionLiveData6.setValue(ExtensionsKt.getStringResource(context, H6, string6));
            }
        }
    }

    @Override // com.sumsub.sns.core.presentation.base.SNSBaseViewModel
    public void onBackClicked() {
        finishWithResult(new DocumentPickerResult(null, null, null, null, null, 31, null));
    }

    public void onHandleVideoFrame(@NotNull Frame frame) {
        Intrinsics.checkNotNullParameter(frame, TextureMediaEncoder.FRAME_EVENT);
        Timber.i("On handle video frame", new Object[0]);
    }

    public void onPictureTaken(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "data");
        get_showProgressLiveData().setValue(Boolean.TRUE);
        this.h.setValue(Boolean.FALSE);
    }

    public final void onTakePictureClicked() {
        Timber.i("On take picture is clicked", new Object[0]);
        this.l.setValue(new Event<>(new Object()));
        get_showProgressLiveData().setValue(Boolean.TRUE);
        this.h.setValue(Boolean.FALSE);
        this.k.setValue(new Event<>(new Object()));
    }

    public final void onToggleFlashClicked(@NotNull Flash flash) {
        Intrinsics.checkNotNullParameter(flash, "flash");
        Timber.i("On Toggle Flash is clicked", new Object[0]);
        MutableLiveData<Flash> mutableLiveData = this.i;
        Flash flash2 = Flash.TORCH;
        if (flash == flash2) {
            flash2 = Flash.OFF;
        }
        mutableLiveData.setValue(flash2);
    }

    public SNSCameraViewModel(@NotNull Applicant applicant, @NotNull DocumentType documentType, @Nullable String str, @Nullable IdentitySide identitySide) {
        Intrinsics.checkNotNullParameter(applicant, "applicant");
        Intrinsics.checkNotNullParameter(documentType, "type");
        this.q = applicant;
        this.r = documentType;
        this.s = str;
        this.t = identitySide;
        this.g = new MutableLiveData<>();
        this.h = new MutableLiveData<>();
        this.i = new MutableLiveData<>();
        this.j = new ActionLiveData<>();
        this.k = new ActionLiveData<>();
        this.l = new ActionLiveData<>();
        this.m = new ActionLiveData<>();
        this.n = new ActionLiveData<>();
        this.o = new ActionLiveData<>();
        this.p = new ActionLiveData<>();
    }
}
