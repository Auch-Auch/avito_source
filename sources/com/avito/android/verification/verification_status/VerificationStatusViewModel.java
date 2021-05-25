package com.avito.android.verification.verification_status;

import a2.g.r.g;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorWithMessage;
import com.avito.android.remote.error.TypedError;
import com.avito.android.remote.model.VerificationStatusResult;
import com.avito.android.util.LoadingState;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import com.avito.android.verification.VerificationResourceProvider;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0003CDEB'\u0012\u0006\u0010%\u001a\u00020\"\u0012\u0006\u0010+\u001a\u00020(\u0012\u0006\u0010@\u001a\u00020=\u0012\u0006\u0010<\u001a\u000209¢\u0006\u0004\bA\u0010BJ!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0002¢\u0006\u0004\b\u0010\u0010\nJ\u0015\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0004¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0014\u0010\u0015R\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u001f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u001b8\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010\u001e\u001a\u0004\b'\u0010 R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u001c\u0010/\u001a\b\u0012\u0004\u0012\u00020\u001c0,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u001f\u00102\u001a\b\u0012\u0004\u0012\u00020\u00170\u001b8\u0006@\u0006¢\u0006\f\n\u0004\b0\u0010\u001e\u001a\u0004\b1\u0010 R\u001c\u00104\u001a\b\u0012\u0004\u0012\u00020\u00040\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u0010\u0019R\u0018\u00108\u001a\u0004\u0018\u0001058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010@\u001a\u00020=8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b>\u0010?¨\u0006F"}, d2 = {"Lcom/avito/android/verification/verification_status/VerificationStatusViewModel;", "Landroidx/lifecycle/ViewModel;", "", "type", "Lcom/avito/android/verification/verification_status/VerificationStatusViewModel$Message;", "messageAfterLoad", "", "loadVerificationStatus", "(Ljava/lang/String;Lcom/avito/android/verification/verification_status/VerificationStatusViewModel$Message;)V", "refreshVerificationStatus", "(Ljava/lang/String;)V", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "onDeepLinkClicked", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "url", "onUrlClicked", "message", "showMessage", "(Lcom/avito/android/verification/verification_status/VerificationStatusViewModel$Message;)V", "onCleared", "()V", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "Lcom/avito/android/verification/verification_status/VerificationStatusViewModel$RouterAction;", "e", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "routerActionLiveData", "Landroidx/lifecycle/LiveData;", "Lcom/avito/android/verification/verification_status/VerificationStatusViewModel$State;", g.a, "Landroidx/lifecycle/LiveData;", "getScreenState", "()Landroidx/lifecycle/LiveData;", "screenState", "Lcom/avito/android/verification/verification_status/VerificationStatusInteractor;", "j", "Lcom/avito/android/verification/verification_status/VerificationStatusInteractor;", "interactor", "i", "getMessage", "Lcom/avito/android/util/SchedulersFactory3;", "k", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Landroidx/lifecycle/MutableLiveData;", "d", "Landroidx/lifecycle/MutableLiveData;", "screenStateLiveData", "h", "getRouterAction", "routerAction", "f", "messageLiveData", "Lio/reactivex/rxjava3/disposables/Disposable;", "c", "Lio/reactivex/rxjava3/disposables/Disposable;", "statusDisposable", "Lcom/avito/android/verification/verification_status/VerificationStatusConverter;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/verification/verification_status/VerificationStatusConverter;", "screenDataConverter", "Lcom/avito/android/verification/VerificationResourceProvider;", "l", "Lcom/avito/android/verification/VerificationResourceProvider;", "resourceProvider", "<init>", "(Lcom/avito/android/verification/verification_status/VerificationStatusInteractor;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/verification/VerificationResourceProvider;Lcom/avito/android/verification/verification_status/VerificationStatusConverter;)V", "Message", "RouterAction", "State", "verification_release"}, k = 1, mv = {1, 4, 2})
public final class VerificationStatusViewModel extends ViewModel {
    public Disposable c;
    public final MutableLiveData<State> d;
    public final SingleLiveEvent<RouterAction> e;
    public final SingleLiveEvent<Message> f;
    @NotNull
    public final LiveData<State> g;
    @NotNull
    public final LiveData<RouterAction> h;
    @NotNull
    public final LiveData<Message> i;
    public final VerificationStatusInteractor j;
    public final SchedulersFactory3 k;
    public final VerificationResourceProvider l;
    public final VerificationStatusConverter m;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0010\b\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ0\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0007J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0015\u001a\u00020\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0019\u0010\f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u0007R\u001b\u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\nR\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u000b\u0010\u0004¨\u0006!"}, d2 = {"Lcom/avito/android/verification/verification_status/VerificationStatusViewModel$Message;", "", "", "component1", "()Z", "", "component2", "()Ljava/lang/String;", "Lcom/avito/android/deep_linking/links/DeepLink;", "component3", "()Lcom/avito/android/deep_linking/links/DeepLink;", "isError", "message", "action", "copy", "(ZLjava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;)Lcom/avito/android/verification/verification_status/VerificationStatusViewModel$Message;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getMessage", "c", "Lcom/avito/android/deep_linking/links/DeepLink;", "getAction", AuthSource.SEND_ABUSE, "Z", "<init>", "(ZLjava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;)V", "verification_release"}, k = 1, mv = {1, 4, 2})
    public static final class Message {
        public final boolean a;
        @NotNull
        public final String b;
        @Nullable
        public final DeepLink c;

        public Message(boolean z, @NotNull String str, @Nullable DeepLink deepLink) {
            Intrinsics.checkNotNullParameter(str, "message");
            this.a = z;
            this.b = str;
            this.c = deepLink;
        }

        public static /* synthetic */ Message copy$default(Message message, boolean z, String str, DeepLink deepLink, int i, Object obj) {
            if ((i & 1) != 0) {
                z = message.a;
            }
            if ((i & 2) != 0) {
                str = message.b;
            }
            if ((i & 4) != 0) {
                deepLink = message.c;
            }
            return message.copy(z, str, deepLink);
        }

        public final boolean component1() {
            return this.a;
        }

        @NotNull
        public final String component2() {
            return this.b;
        }

        @Nullable
        public final DeepLink component3() {
            return this.c;
        }

        @NotNull
        public final Message copy(boolean z, @NotNull String str, @Nullable DeepLink deepLink) {
            Intrinsics.checkNotNullParameter(str, "message");
            return new Message(z, str, deepLink);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Message)) {
                return false;
            }
            Message message = (Message) obj;
            return this.a == message.a && Intrinsics.areEqual(this.b, message.b) && Intrinsics.areEqual(this.c, message.c);
        }

        @Nullable
        public final DeepLink getAction() {
            return this.c;
        }

        @NotNull
        public final String getMessage() {
            return this.b;
        }

        public int hashCode() {
            boolean z = this.a;
            if (z) {
                z = true;
            }
            int i = z ? 1 : 0;
            int i2 = z ? 1 : 0;
            int i3 = z ? 1 : 0;
            int i4 = i * 31;
            String str = this.b;
            int i5 = 0;
            int hashCode = (i4 + (str != null ? str.hashCode() : 0)) * 31;
            DeepLink deepLink = this.c;
            if (deepLink != null) {
                i5 = deepLink.hashCode();
            }
            return hashCode + i5;
        }

        public final boolean isError() {
            return this.a;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("Message(isError=");
            L.append(this.a);
            L.append(", message=");
            L.append(this.b);
            L.append(", action=");
            return a2.b.a.a.a.m(L, this.c, ")");
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Message(boolean z, String str, DeepLink deepLink, int i, j jVar) {
            this(z, str, (i & 4) != 0 ? null : deepLink);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/verification/verification_status/VerificationStatusViewModel$RouterAction;", "", "<init>", "()V", "DeepLinkAction", "UrlLinkAction", "Lcom/avito/android/verification/verification_status/VerificationStatusViewModel$RouterAction$DeepLinkAction;", "Lcom/avito/android/verification/verification_status/VerificationStatusViewModel$RouterAction$UrlLinkAction;", "verification_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class RouterAction {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004¨\u0006\u0018"}, d2 = {"Lcom/avito/android/verification/verification_status/VerificationStatusViewModel$RouterAction$DeepLinkAction;", "Lcom/avito/android/verification/verification_status/VerificationStatusViewModel$RouterAction;", "Lcom/avito/android/deep_linking/links/DeepLink;", "component1", "()Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "copy", "(Lcom/avito/android/deep_linking/links/DeepLink;)Lcom/avito/android/verification/verification_status/VerificationStatusViewModel$RouterAction$DeepLinkAction;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeepLink", "<init>", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "verification_release"}, k = 1, mv = {1, 4, 2})
        public static final class DeepLinkAction extends RouterAction {
            @NotNull
            public final DeepLink a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public DeepLinkAction(@NotNull DeepLink deepLink) {
                super(null);
                Intrinsics.checkNotNullParameter(deepLink, "deepLink");
                this.a = deepLink;
            }

            public static /* synthetic */ DeepLinkAction copy$default(DeepLinkAction deepLinkAction, DeepLink deepLink, int i, Object obj) {
                if ((i & 1) != 0) {
                    deepLink = deepLinkAction.a;
                }
                return deepLinkAction.copy(deepLink);
            }

            @NotNull
            public final DeepLink component1() {
                return this.a;
            }

            @NotNull
            public final DeepLinkAction copy(@NotNull DeepLink deepLink) {
                Intrinsics.checkNotNullParameter(deepLink, "deepLink");
                return new DeepLinkAction(deepLink);
            }

            public boolean equals(@Nullable Object obj) {
                if (this != obj) {
                    return (obj instanceof DeepLinkAction) && Intrinsics.areEqual(this.a, ((DeepLinkAction) obj).a);
                }
                return true;
            }

            @NotNull
            public final DeepLink getDeepLink() {
                return this.a;
            }

            public int hashCode() {
                DeepLink deepLink = this.a;
                if (deepLink != null) {
                    return deepLink.hashCode();
                }
                return 0;
            }

            @NotNull
            public String toString() {
                return a2.b.a.a.a.m(a2.b.a.a.a.L("DeepLinkAction(deepLink="), this.a, ")");
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004¨\u0006\u0016"}, d2 = {"Lcom/avito/android/verification/verification_status/VerificationStatusViewModel$RouterAction$UrlLinkAction;", "Lcom/avito/android/verification/verification_status/VerificationStatusViewModel$RouterAction;", "", "component1", "()Ljava/lang/String;", "url", "copy", "(Ljava/lang/String;)Lcom/avito/android/verification/verification_status/VerificationStatusViewModel$RouterAction$UrlLinkAction;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getUrl", "<init>", "(Ljava/lang/String;)V", "verification_release"}, k = 1, mv = {1, 4, 2})
        public static final class UrlLinkAction extends RouterAction {
            @NotNull
            public final String a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public UrlLinkAction(@NotNull String str) {
                super(null);
                Intrinsics.checkNotNullParameter(str, "url");
                this.a = str;
            }

            public static /* synthetic */ UrlLinkAction copy$default(UrlLinkAction urlLinkAction, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = urlLinkAction.a;
                }
                return urlLinkAction.copy(str);
            }

            @NotNull
            public final String component1() {
                return this.a;
            }

            @NotNull
            public final UrlLinkAction copy(@NotNull String str) {
                Intrinsics.checkNotNullParameter(str, "url");
                return new UrlLinkAction(str);
            }

            public boolean equals(@Nullable Object obj) {
                if (this != obj) {
                    return (obj instanceof UrlLinkAction) && Intrinsics.areEqual(this.a, ((UrlLinkAction) obj).a);
                }
                return true;
            }

            @NotNull
            public final String getUrl() {
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
                return a2.b.a.a.a.t(a2.b.a.a.a.L("UrlLinkAction(url="), this.a, ")");
            }
        }

        public RouterAction() {
        }

        public RouterAction(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/avito/android/verification/verification_status/VerificationStatusViewModel$State;", "", "<init>", "()V", "Error", "Loaded", "Loading", "Lcom/avito/android/verification/verification_status/VerificationStatusViewModel$State$Loaded;", "Lcom/avito/android/verification/verification_status/VerificationStatusViewModel$State$Loading;", "Lcom/avito/android/verification/verification_status/VerificationStatusViewModel$State$Error;", "verification_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class State {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004¨\u0006\u0016"}, d2 = {"Lcom/avito/android/verification/verification_status/VerificationStatusViewModel$State$Error;", "Lcom/avito/android/verification/verification_status/VerificationStatusViewModel$State;", "", "component1", "()Ljava/lang/String;", "message", "copy", "(Ljava/lang/String;)Lcom/avito/android/verification/verification_status/VerificationStatusViewModel$State$Error;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getMessage", "<init>", "(Ljava/lang/String;)V", "verification_release"}, k = 1, mv = {1, 4, 2})
        public static final class Error extends State {
            @NotNull
            public final String a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Error(@NotNull String str) {
                super(null);
                Intrinsics.checkNotNullParameter(str, "message");
                this.a = str;
            }

            public static /* synthetic */ Error copy$default(Error error, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = error.a;
                }
                return error.copy(str);
            }

            @NotNull
            public final String component1() {
                return this.a;
            }

            @NotNull
            public final Error copy(@NotNull String str) {
                Intrinsics.checkNotNullParameter(str, "message");
                return new Error(str);
            }

            public boolean equals(@Nullable Object obj) {
                if (this != obj) {
                    return (obj instanceof Error) && Intrinsics.areEqual(this.a, ((Error) obj).a);
                }
                return true;
            }

            @NotNull
            public final String getMessage() {
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
                return a2.b.a.a.a.t(a2.b.a.a.a.L("Error(message="), this.a, ")");
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004¨\u0006\u0018"}, d2 = {"Lcom/avito/android/verification/verification_status/VerificationStatusViewModel$State$Loaded;", "Lcom/avito/android/verification/verification_status/VerificationStatusViewModel$State;", "Lcom/avito/android/verification/verification_status/VerificationStatusScreenData;", "component1", "()Lcom/avito/android/verification/verification_status/VerificationStatusScreenData;", "screenData", "copy", "(Lcom/avito/android/verification/verification_status/VerificationStatusScreenData;)Lcom/avito/android/verification/verification_status/VerificationStatusViewModel$State$Loaded;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Lcom/avito/android/verification/verification_status/VerificationStatusScreenData;", "getScreenData", "<init>", "(Lcom/avito/android/verification/verification_status/VerificationStatusScreenData;)V", "verification_release"}, k = 1, mv = {1, 4, 2})
        public static final class Loaded extends State {
            @NotNull
            public final VerificationStatusScreenData a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Loaded(@NotNull VerificationStatusScreenData verificationStatusScreenData) {
                super(null);
                Intrinsics.checkNotNullParameter(verificationStatusScreenData, "screenData");
                this.a = verificationStatusScreenData;
            }

            public static /* synthetic */ Loaded copy$default(Loaded loaded, VerificationStatusScreenData verificationStatusScreenData, int i, Object obj) {
                if ((i & 1) != 0) {
                    verificationStatusScreenData = loaded.a;
                }
                return loaded.copy(verificationStatusScreenData);
            }

            @NotNull
            public final VerificationStatusScreenData component1() {
                return this.a;
            }

            @NotNull
            public final Loaded copy(@NotNull VerificationStatusScreenData verificationStatusScreenData) {
                Intrinsics.checkNotNullParameter(verificationStatusScreenData, "screenData");
                return new Loaded(verificationStatusScreenData);
            }

            public boolean equals(@Nullable Object obj) {
                if (this != obj) {
                    return (obj instanceof Loaded) && Intrinsics.areEqual(this.a, ((Loaded) obj).a);
                }
                return true;
            }

            @NotNull
            public final VerificationStatusScreenData getScreenData() {
                return this.a;
            }

            public int hashCode() {
                VerificationStatusScreenData verificationStatusScreenData = this.a;
                if (verificationStatusScreenData != null) {
                    return verificationStatusScreenData.hashCode();
                }
                return 0;
            }

            @NotNull
            public String toString() {
                StringBuilder L = a2.b.a.a.a.L("Loaded(screenData=");
                L.append(this.a);
                L.append(")");
                return L.toString();
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/verification/verification_status/VerificationStatusViewModel$State$Loading;", "Lcom/avito/android/verification/verification_status/VerificationStatusViewModel$State;", "<init>", "()V", "verification_release"}, k = 1, mv = {1, 4, 2})
        public static final class Loading extends State {
            @NotNull
            public static final Loading INSTANCE = new Loading();

            public Loading() {
                super(null);
            }
        }

        public State() {
        }

        public State(j jVar) {
        }
    }

    public static final class a<T> implements Consumer<LoadingState<? super VerificationStatusResult>> {
        public final /* synthetic */ VerificationStatusViewModel a;
        public final /* synthetic */ Message b;

        public a(VerificationStatusViewModel verificationStatusViewModel, Message message) {
            this.a = verificationStatusViewModel;
            this.b = message;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX DEBUG: Multi-variable search result rejected for r4v5, resolved type: com.avito.android.util.architecture_components.SingleLiveEvent */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(LoadingState<? super VerificationStatusResult> loadingState) {
            LoadingState<? super VerificationStatusResult> loadingState2 = loadingState;
            MutableLiveData mutableLiveData = this.a.d;
            VerificationStatusViewModel verificationStatusViewModel = this.a;
            Intrinsics.checkNotNullExpressionValue(loadingState2, "it");
            mutableLiveData.setValue(VerificationStatusViewModel.access$toScreenState(verificationStatusViewModel, loadingState2));
            if ((loadingState2 instanceof LoadingState.Loaded) && this.b != null) {
                this.a.f.setValue(this.b);
            }
        }
    }

    public static final class b<T> implements Consumer<LoadingState<? super VerificationStatusResult>> {
        public final /* synthetic */ VerificationStatusViewModel a;

        public b(VerificationStatusViewModel verificationStatusViewModel) {
            this.a = verificationStatusViewModel;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(LoadingState<? super VerificationStatusResult> loadingState) {
            LoadingState<? super VerificationStatusResult> loadingState2 = loadingState;
            MutableLiveData mutableLiveData = this.a.d;
            VerificationStatusViewModel verificationStatusViewModel = this.a;
            Intrinsics.checkNotNullExpressionValue(loadingState2, "it");
            mutableLiveData.setValue(VerificationStatusViewModel.access$toScreenState(verificationStatusViewModel, loadingState2));
        }
    }

    public static final class c<T> implements Consumer<Throwable> {
        public final /* synthetic */ VerificationStatusViewModel a;

        public c(VerificationStatusViewModel verificationStatusViewModel) {
            this.a = verificationStatusViewModel;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v3, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            this.a.d.setValue(new State.Error(this.a.l.getDefaultVerificationsListErrorMessage()));
        }
    }

    public VerificationStatusViewModel(@NotNull VerificationStatusInteractor verificationStatusInteractor, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull VerificationResourceProvider verificationResourceProvider, @NotNull VerificationStatusConverter verificationStatusConverter) {
        Intrinsics.checkNotNullParameter(verificationStatusInteractor, "interactor");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(verificationResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(verificationStatusConverter, "screenDataConverter");
        this.j = verificationStatusInteractor;
        this.k = schedulersFactory3;
        this.l = verificationResourceProvider;
        this.m = verificationStatusConverter;
        MutableLiveData<State> mutableLiveData = new MutableLiveData<>();
        this.d = mutableLiveData;
        SingleLiveEvent<RouterAction> singleLiveEvent = new SingleLiveEvent<>();
        this.e = singleLiveEvent;
        SingleLiveEvent<Message> singleLiveEvent2 = new SingleLiveEvent<>();
        this.f = singleLiveEvent2;
        this.g = mutableLiveData;
        this.h = singleLiveEvent;
        this.i = singleLiveEvent2;
    }

    public static final State access$toScreenState(VerificationStatusViewModel verificationStatusViewModel, LoadingState loadingState) {
        State error;
        String str;
        Objects.requireNonNull(verificationStatusViewModel);
        if (loadingState instanceof LoadingState.Loading) {
            return State.Loading.INSTANCE;
        }
        if (loadingState instanceof LoadingState.Loaded) {
            error = new State.Loaded(verificationStatusViewModel.m.convert((VerificationStatusResult) ((LoadingState.Loaded) loadingState).getData()));
        } else if (loadingState instanceof LoadingState.Error) {
            TypedError error2 = ((LoadingState.Error) loadingState).getError();
            if (error2 instanceof ErrorWithMessage.NetworkError) {
                str = verificationStatusViewModel.l.getNetworkErrorMessage();
            } else if (error2 instanceof ErrorWithMessage.Unknown) {
                str = ((ErrorWithMessage.Unknown) error2).getMessage();
            } else {
                str = verificationStatusViewModel.l.getDefaultVerificationErrorMessage();
            }
            error = new State.Error(str);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return error;
    }

    public static /* synthetic */ void loadVerificationStatus$default(VerificationStatusViewModel verificationStatusViewModel, String str, Message message, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            message = null;
        }
        verificationStatusViewModel.loadVerificationStatus(str, message);
    }

    @NotNull
    public final LiveData<Message> getMessage() {
        return this.i;
    }

    @NotNull
    public final LiveData<RouterAction> getRouterAction() {
        return this.h;
    }

    @NotNull
    public final LiveData<State> getScreenState() {
        return this.g;
    }

    public final void loadVerificationStatus(@NotNull String str, @Nullable Message message) {
        Intrinsics.checkNotNullParameter(str, "type");
        Disposable disposable = this.c;
        if (disposable != null) {
            disposable.dispose();
        }
        this.c = this.j.getVerificationStatus(str).startWith(Observable.just(LoadingState.Loading.INSTANCE)).observeOn(this.k.mainThread()).subscribe(new a(this, message));
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        Disposable disposable = this.c;
        if (disposable != null) {
            disposable.dispose();
        }
    }

    public final void onDeepLinkClicked(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        this.e.setValue(new RouterAction.DeepLinkAction(deepLink));
    }

    public final void onUrlClicked(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "url");
        this.e.setValue(new RouterAction.UrlLinkAction(str));
    }

    public final void refreshVerificationStatus(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "type");
        Disposable disposable = this.c;
        if (disposable != null) {
            disposable.dispose();
        }
        this.c = this.j.getVerificationStatus(str).observeOn(this.k.mainThread()).subscribe(new b(this), new c(this));
    }

    public final void showMessage(@NotNull Message message) {
        Intrinsics.checkNotNullParameter(message, "message");
        this.f.setValue(message);
    }
}
