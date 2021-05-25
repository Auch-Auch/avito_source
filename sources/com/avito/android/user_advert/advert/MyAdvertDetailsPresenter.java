package com.avito.android.user_advert.advert;

import a2.b.a.a.a;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.OnDeepLinkClickListener;
import com.avito.android.permissions.PermissionState;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.CloseReason;
import com.avito.android.user_advert.advert.switcher_block.UserAdvertSource;
import com.avito.android.util.Kundle;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.analytic.v2.BaseAnalyticKt;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001CJ\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0006H&¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH&¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012H&¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0006H&¢\u0006\u0004\b\u0016\u0010\u000eJ#\u0010\u0019\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u0018\u001a\u00020\u0017H&¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001bH&¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0006H&¢\u0006\u0004\b\u001f\u0010\u000eJ\u0019\u0010 \u001a\u00020\u00062\b\b\u0002\u0010\u0018\u001a\u00020\u0017H&¢\u0006\u0004\b \u0010!J1\u0010(\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\"2\b\u0010%\u001a\u0004\u0018\u00010$2\u0006\u0010&\u001a\u00020\t2\u0006\u0010'\u001a\u00020\tH&¢\u0006\u0004\b(\u0010)J\u0017\u0010+\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u001bH&¢\u0006\u0004\b+\u0010\u001eJ\u0019\u0010,\u001a\u00020\u00062\b\u0010%\u001a\u0004\u0018\u00010$H&¢\u0006\u0004\b,\u0010-J\u000f\u0010.\u001a\u00020\u0006H&¢\u0006\u0004\b.\u0010\u000eJ#\u00101\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\t2\n\b\u0002\u00100\u001a\u0004\u0018\u00010$H&¢\u0006\u0004\b1\u00102J\u0019\u00104\u001a\u00020\u00062\b\u00103\u001a\u0004\u0018\u00010$H&¢\u0006\u0004\b4\u0010-J\u000f\u00105\u001a\u00020\u0006H&¢\u0006\u0004\b5\u0010\u000eJ!\u00109\u001a\u00020\u00062\u0006\u00107\u001a\u0002062\b\u00108\u001a\u0004\u0018\u00010$H&¢\u0006\u0004\b9\u0010:J\u000f\u0010;\u001a\u00020\u0006H&¢\u0006\u0004\b;\u0010\u000eJ\u0017\u0010>\u001a\u00020\u00062\u0006\u0010=\u001a\u00020<H&¢\u0006\u0004\b>\u0010?J\u0017\u0010A\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020@H&¢\u0006\u0004\bA\u0010B¨\u0006D"}, d2 = {"Lcom/avito/android/user_advert/advert/MyAdvertDetailsPresenter;", "Lcom/avito/android/user_advert/advert/MyAdvertDetailsViewPresenter;", "Lcom/avito/android/deep_linking/links/OnDeepLinkClickListener;", "Lcom/avito/android/user_advert/advert/switcher_block/UserAdvertSource;", "Lcom/avito/android/user_advert/advert/MyAdvertDetailsView;", "view", "", "attachView", "(Lcom/avito/android/user_advert/advert/MyAdvertDetailsView;)V", "", "shouldShowAppRater", "init", "(Z)V", "detachView", "()V", "Lcom/avito/android/util/Kundle;", "onSavedState", "()Lcom/avito/android/util/Kundle;", "Lcom/avito/android/user_advert/advert/MyAdvertRouter;", "router", "attachRouter", "(Lcom/avito/android/user_advert/advert/MyAdvertRouter;)V", "detachRouter", "Lcom/avito/android/user_advert/advert/MyAdvertDetailsPresenter$ProcessedAction;", "processedAction", "onInitialize", "(ZLcom/avito/android/user_advert/advert/MyAdvertDetailsPresenter$ProcessedAction;)V", "", "result", "setParentResult", "(I)V", "onLoginFailed", "onReinitialize", "(Lcom/avito/android/user_advert/advert/MyAdvertDetailsPresenter$ProcessedAction;)V", "Lcom/avito/android/user_advert/advert/DetailsId;", "id", "", "statusMessage", "showActivation", "isNewAdvert", "onNewIntent", "(Lcom/avito/android/user_advert/advert/DetailsId;Ljava/lang/String;ZZ)V", VKApiConst.POSITION, "onGalleryResult", "onAdvertStatusChanged", "(Ljava/lang/String;)V", "onActivationError", "needToUpdate", "errorMessage", "onActivateResult", "(ZLjava/lang/String;)V", "postAction", "onEditResult", "onFeesResult", "Lcom/avito/android/remote/model/CloseReason;", "reason", "newPrice", "onCloseReasonChosen", "(Lcom/avito/android/remote/model/CloseReason;Ljava/lang/String;)V", "onBackPressed", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "invokeAction", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "Lcom/avito/android/permissions/PermissionState;", "onCallPermissionResult", "(Lcom/avito/android/permissions/PermissionState;)V", "ProcessedAction", "user-advert_release"}, k = 1, mv = {1, 4, 2})
public interface MyAdvertDetailsPresenter extends MyAdvertDetailsViewPresenter, OnDeepLinkClickListener, UserAdvertSource {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ void onActivateResult$default(MyAdvertDetailsPresenter myAdvertDetailsPresenter, boolean z, String str, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    str = null;
                }
                myAdvertDetailsPresenter.onActivateResult(z, str);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onActivateResult");
        }

        public static /* synthetic */ void onInitialize$default(MyAdvertDetailsPresenter myAdvertDetailsPresenter, boolean z, ProcessedAction processedAction, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    z = false;
                }
                if ((i & 2) != 0) {
                    processedAction = ProcessedAction.Default.INSTANCE;
                }
                myAdvertDetailsPresenter.onInitialize(z, processedAction);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onInitialize");
        }

        public static /* synthetic */ void onReinitialize$default(MyAdvertDetailsPresenter myAdvertDetailsPresenter, ProcessedAction processedAction, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    processedAction = ProcessedAction.Default.INSTANCE;
                }
                myAdvertDetailsPresenter.onReinitialize(processedAction);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onReinitialize");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/avito/android/user_advert/advert/MyAdvertDetailsPresenter$ProcessedAction;", "", "<init>", "()V", "Activation", "Default", BaseAnalyticKt.ANALYTIC_ACTION_EDIT, "Lcom/avito/android/user_advert/advert/MyAdvertDetailsPresenter$ProcessedAction$Edit;", "Lcom/avito/android/user_advert/advert/MyAdvertDetailsPresenter$ProcessedAction$Activation;", "Lcom/avito/android/user_advert/advert/MyAdvertDetailsPresenter$ProcessedAction$Default;", "user-advert_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class ProcessedAction {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/user_advert/advert/MyAdvertDetailsPresenter$ProcessedAction$Activation;", "Lcom/avito/android/user_advert/advert/MyAdvertDetailsPresenter$ProcessedAction;", "<init>", "()V", "user-advert_release"}, k = 1, mv = {1, 4, 2})
        public static final class Activation extends ProcessedAction {
            @NotNull
            public static final Activation INSTANCE = new Activation();

            public Activation() {
                super(null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/user_advert/advert/MyAdvertDetailsPresenter$ProcessedAction$Default;", "Lcom/avito/android/user_advert/advert/MyAdvertDetailsPresenter$ProcessedAction;", "<init>", "()V", "user-advert_release"}, k = 1, mv = {1, 4, 2})
        public static final class Default extends ProcessedAction {
            @NotNull
            public static final Default INSTANCE = new Default();

            public Default() {
                super(null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0006\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004¨\u0006\u0016"}, d2 = {"Lcom/avito/android/user_advert/advert/MyAdvertDetailsPresenter$ProcessedAction$Edit;", "Lcom/avito/android/user_advert/advert/MyAdvertDetailsPresenter$ProcessedAction;", "", "component1", "()Ljava/lang/String;", "postAction", "copy", "(Ljava/lang/String;)Lcom/avito/android/user_advert/advert/MyAdvertDetailsPresenter$ProcessedAction$Edit;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getPostAction", "<init>", "(Ljava/lang/String;)V", "user-advert_release"}, k = 1, mv = {1, 4, 2})
        public static final class Edit extends ProcessedAction {
            @Nullable
            public final String a;

            public Edit(@Nullable String str) {
                super(null);
                this.a = str;
            }

            public static /* synthetic */ Edit copy$default(Edit edit, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = edit.a;
                }
                return edit.copy(str);
            }

            @Nullable
            public final String component1() {
                return this.a;
            }

            @NotNull
            public final Edit copy(@Nullable String str) {
                return new Edit(str);
            }

            public boolean equals(@Nullable Object obj) {
                if (this != obj) {
                    return (obj instanceof Edit) && Intrinsics.areEqual(this.a, ((Edit) obj).a);
                }
                return true;
            }

            @Nullable
            public final String getPostAction() {
                return this.a;
            }

            public int hashCode() {
                String str = this.a;
                if (str != null) {
                    return str.hashCode();
                }
                return 0;
            }

            @NotNull
            public String toString() {
                return a.t(a.L("Edit(postAction="), this.a, ")");
            }
        }

        public ProcessedAction() {
        }

        public ProcessedAction(j jVar) {
        }
    }

    void attachRouter(@NotNull MyAdvertRouter myAdvertRouter);

    void attachView(@NotNull MyAdvertDetailsView myAdvertDetailsView);

    void detachRouter();

    void detachView();

    void init(boolean z);

    void invokeAction(@NotNull DeepLink deepLink);

    void onActivateResult(boolean z, @Nullable String str);

    void onActivationError();

    void onAdvertStatusChanged(@Nullable String str);

    void onBackPressed();

    void onCallPermissionResult(@NotNull PermissionState permissionState);

    void onCloseReasonChosen(@NotNull CloseReason closeReason, @Nullable String str);

    void onEditResult(@Nullable String str);

    void onFeesResult();

    void onGalleryResult(int i);

    void onInitialize(boolean z, @NotNull ProcessedAction processedAction);

    void onLoginFailed();

    void onNewIntent(@NotNull DetailsId detailsId, @Nullable String str, boolean z, boolean z2);

    void onReinitialize(@NotNull ProcessedAction processedAction);

    @NotNull
    Kundle onSavedState();

    void setParentResult(int i);
}
