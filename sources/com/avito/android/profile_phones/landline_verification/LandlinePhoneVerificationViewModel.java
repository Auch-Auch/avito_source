package com.avito.android.profile_phones.landline_verification;

import a2.g.r.g;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.LandlinePhoneVerificationLink;
import com.avito.android.deep_linking.links.ManualPhoneVerificationLink;
import com.avito.android.payment.SberbankOnlineKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorResult;
import com.avito.android.remote.error.TypedError;
import com.avito.android.remote.model.LandlinePhoneVerificationStatusResult;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.model.registration.RequestCodeResult;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.util.Logs;
import com.avito.android.util.TypedResultException;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.android.persistence.messenger.MessageMetaInfo;
import t6.r.a.j;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000s\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u000e*\u00019\u0018\u00002\u00020\u0001:\u0006@ABCDEB\u000f\u0012\u0006\u0010/\u001a\u00020,¢\u0006\u0004\b>\u0010?J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u0013\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0002¢\u0006\u0004\b\t\u0010\u0005J=\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0017\u001a\u00020\u0014¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u0019\u001a\u00020\u0014¢\u0006\u0004\b\u0019\u0010\u0018J\r\u0010\u001a\u001a\u00020\u0014¢\u0006\u0004\b\u001a\u0010\u0018J\r\u0010\u001b\u001a\u00020\u0014¢\u0006\u0004\b\u001b\u0010\u0018J\r\u0010\u001c\u001a\u00020\u0014¢\u0006\u0004\b\u001c\u0010\u0018J\r\u0010\u001d\u001a\u00020\u0014¢\u0006\u0004\b\u001d\u0010\u0018J\r\u0010\u001e\u001a\u00020\u0014¢\u0006\u0004\b\u001e\u0010\u0018J\u000f\u0010\u001f\u001a\u00020\u0014H\u0014¢\u0006\u0004\b\u001f\u0010\u0018J\u001b\u0010\"\u001a\u00020\u00142\n\b\u0002\u0010!\u001a\u0004\u0018\u00010 H\u0002¢\u0006\u0004\b\"\u0010#J\u0017\u0010$\u001a\u00020\u00142\u0006\u0010!\u001a\u00020 H\u0002¢\u0006\u0004\b$\u0010#R(\u0010!\u001a\u0004\u0018\u00010 2\b\u0010%\u001a\u0004\u0018\u00010 8\u0002@BX\u000e¢\u0006\f\n\u0004\b$\u0010&\"\u0004\b'\u0010#R\u001c\u0010+\u001a\b\u0012\u0004\u0012\u00020\b0(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00102\u001a\u0004\u0018\u0001008\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b'\u00101R\u001c\u00104\u001a\b\u0012\u0004\u0012\u00020\u00060(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u0010*R\u001c\u00108\u001a\b\u0012\u0004\u0012\u00020\u0003058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010;\u001a\u0002098\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010:R\u0018\u0010=\u001a\u0004\u0018\u0001008\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b<\u00101¨\u0006F"}, d2 = {"Lcom/avito/android/profile_phones/landline_verification/LandlinePhoneVerificationViewModel;", "Landroidx/lifecycle/ViewModel;", "Landroidx/lifecycle/LiveData;", "Lcom/avito/android/profile_phones/landline_verification/LandlinePhoneVerificationViewModel$ScreenState;", "screenState", "()Landroidx/lifecycle/LiveData;", "Lcom/avito/android/profile_phones/landline_verification/LandlinePhoneVerificationViewModel$RoutingAction;", "navigation", "Lcom/avito/android/profile_phones/landline_verification/LandlinePhoneVerificationViewModel$Event;", "events", "", "callId", "", "title", MessengerShareContentUtility.SUBTITLE, "Lcom/avito/android/remote/model/text/AttributedText;", "description", "phone", "", "isManual", "", "initData", "(ILjava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/text/AttributedText;Ljava/lang/String;Z)V", "onManualCheckCancelClicked", "()V", "onManualCheckAcceptClicked", "onCallOrderClicked", "onOkClicked", "onBackClicked", "onStart", "onStop", "onCleared", "Lcom/avito/android/profile_phones/landline_verification/LandlinePhoneVerificationViewModel$Data;", "data", "c", "(Lcom/avito/android/profile_phones/landline_verification/LandlinePhoneVerificationViewModel$Data;)V", "d", "value", "Lcom/avito/android/profile_phones/landline_verification/LandlinePhoneVerificationViewModel$Data;", "e", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "i", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "eventsData", "Lcom/avito/android/profile_phones/landline_verification/LandlinePhoneVerificationInteractor;", "j", "Lcom/avito/android/profile_phones/landline_verification/LandlinePhoneVerificationInteractor;", "interactor", "Lio/reactivex/rxjava3/disposables/Disposable;", "Lio/reactivex/rxjava3/disposables/Disposable;", "disposable", "h", "navigationData", "Landroidx/lifecycle/MutableLiveData;", g.a, "Landroidx/lifecycle/MutableLiveData;", "screenStateData", "com/avito/android/profile_phones/landline_verification/LandlinePhoneVerificationViewModel$onUrlClickListener$1", "Lcom/avito/android/profile_phones/landline_verification/LandlinePhoneVerificationViewModel$onUrlClickListener$1;", "onUrlClickListener", "f", "pollingDisposable", "<init>", "(Lcom/avito/android/profile_phones/landline_verification/LandlinePhoneVerificationInteractor;)V", "ActionState", "Data", "Event", "ResultStatus", "RoutingAction", "ScreenState", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
public final class LandlinePhoneVerificationViewModel extends ViewModel {
    public final LandlinePhoneVerificationViewModel$onUrlClickListener$1 c = new LandlinePhoneVerificationViewModel$onUrlClickListener$1(this);
    public Data d;
    public Disposable e;
    public Disposable f;
    public final MutableLiveData<ScreenState> g = new MutableLiveData<>();
    public final SingleLiveEvent<RoutingAction> h = new SingleLiveEvent<>();
    public final SingleLiveEvent<Event> i = new SingleLiveEvent<>();
    public final LandlinePhoneVerificationInteractor j;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\f\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/avito/android/profile_phones/landline_verification/LandlinePhoneVerificationViewModel$ActionState;", "", "", AuthSource.SEND_ABUSE, "I", "getIndex", "()I", FirebaseAnalytics.Param.INDEX, "<init>", "(Ljava/lang/String;II)V", "CALL_ORDER", "CALL_ORDERED", "MANUAL", "STATUS", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
    public enum ActionState {
        CALL_ORDER(0),
        CALL_ORDERED(1),
        MANUAL(2),
        STATUS(3);
        
        public final int a;

        /* access modifiers changed from: public */
        ActionState(int i) {
            this.a = i;
        }

        public final int getIndex() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b$\b\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0005\u0012\u0006\u0010\u0013\u001a\u00020\u0005\u0012\u0006\u0010\u0014\u001a\u00020\t\u0012\u0006\u0010\u0015\u001a\u00020\u0005\u0012\u0006\u0010\u0016\u001a\u00020\r\u0012\b\b\u0002\u0010\u0017\u001a\u00020\r¢\u0006\u0004\b/\u00100J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\f\u0010\u0007J\u0010\u0010\u000e\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u000fJV\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\t2\b\b\u0002\u0010\u0015\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\r2\b\b\u0002\u0010\u0017\u001a\u00020\rHÆ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u0007J\u0010\u0010\u001b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001b\u0010\u0004J\u001a\u0010\u001d\u001a\u00020\r2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eR\u0019\u0010\u0011\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\u0004R\u0019\u0010\u0013\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010\u0007R\u0019\u0010\u0016\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b\u0016\u0010\u000fR\u0019\u0010\u0017\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010&\u001a\u0004\b\u0017\u0010\u000fR\u0019\u0010\u0012\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010#\u001a\u0004\b)\u0010\u0007R\u0019\u0010\u0014\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010\u000bR\u0019\u0010\u0015\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010#\u001a\u0004\b.\u0010\u0007¨\u00061"}, d2 = {"Lcom/avito/android/profile_phones/landline_verification/LandlinePhoneVerificationViewModel$Data;", "", "", "component1", "()I", "", "component2", "()Ljava/lang/String;", "component3", "Lcom/avito/android/remote/model/text/AttributedText;", "component4", "()Lcom/avito/android/remote/model/text/AttributedText;", "component5", "", "component6", "()Z", "component7", "callId", "title", MessengerShareContentUtility.SUBTITLE, "description", "phone", "isManual", "isError", "copy", "(ILjava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/text/AttributedText;Ljava/lang/String;ZZ)Lcom/avito/android/profile_phones/landline_verification/LandlinePhoneVerificationViewModel$Data;", "toString", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "I", "getCallId", "c", "Ljava/lang/String;", "getSubtitle", "f", "Z", g.a, AuthSource.BOOKING_ORDER, "getTitle", "d", "Lcom/avito/android/remote/model/text/AttributedText;", "getDescription", "e", "getPhone", "<init>", "(ILjava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/text/AttributedText;Ljava/lang/String;ZZ)V", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
    public static final class Data {
        public final int a;
        @NotNull
        public final String b;
        @NotNull
        public final String c;
        @NotNull
        public final AttributedText d;
        @NotNull
        public final String e;
        public final boolean f;
        public final boolean g;

        public Data(int i, @NotNull String str, @NotNull String str2, @NotNull AttributedText attributedText, @NotNull String str3, boolean z, boolean z2) {
            Intrinsics.checkNotNullParameter(str, "title");
            Intrinsics.checkNotNullParameter(str2, MessengerShareContentUtility.SUBTITLE);
            Intrinsics.checkNotNullParameter(attributedText, "description");
            Intrinsics.checkNotNullParameter(str3, "phone");
            this.a = i;
            this.b = str;
            this.c = str2;
            this.d = attributedText;
            this.e = str3;
            this.f = z;
            this.g = z2;
        }

        public static /* synthetic */ Data copy$default(Data data, int i, String str, String str2, AttributedText attributedText, String str3, boolean z, boolean z2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = data.a;
            }
            if ((i2 & 2) != 0) {
                str = data.b;
            }
            if ((i2 & 4) != 0) {
                str2 = data.c;
            }
            if ((i2 & 8) != 0) {
                attributedText = data.d;
            }
            if ((i2 & 16) != 0) {
                str3 = data.e;
            }
            if ((i2 & 32) != 0) {
                z = data.f;
            }
            if ((i2 & 64) != 0) {
                z2 = data.g;
            }
            return data.copy(i, str, str2, attributedText, str3, z, z2);
        }

        public final int component1() {
            return this.a;
        }

        @NotNull
        public final String component2() {
            return this.b;
        }

        @NotNull
        public final String component3() {
            return this.c;
        }

        @NotNull
        public final AttributedText component4() {
            return this.d;
        }

        @NotNull
        public final String component5() {
            return this.e;
        }

        public final boolean component6() {
            return this.f;
        }

        public final boolean component7() {
            return this.g;
        }

        @NotNull
        public final Data copy(int i, @NotNull String str, @NotNull String str2, @NotNull AttributedText attributedText, @NotNull String str3, boolean z, boolean z2) {
            Intrinsics.checkNotNullParameter(str, "title");
            Intrinsics.checkNotNullParameter(str2, MessengerShareContentUtility.SUBTITLE);
            Intrinsics.checkNotNullParameter(attributedText, "description");
            Intrinsics.checkNotNullParameter(str3, "phone");
            return new Data(i, str, str2, attributedText, str3, z, z2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Data)) {
                return false;
            }
            Data data = (Data) obj;
            return this.a == data.a && Intrinsics.areEqual(this.b, data.b) && Intrinsics.areEqual(this.c, data.c) && Intrinsics.areEqual(this.d, data.d) && Intrinsics.areEqual(this.e, data.e) && this.f == data.f && this.g == data.g;
        }

        public final int getCallId() {
            return this.a;
        }

        @NotNull
        public final AttributedText getDescription() {
            return this.d;
        }

        @NotNull
        public final String getPhone() {
            return this.e;
        }

        @NotNull
        public final String getSubtitle() {
            return this.c;
        }

        @NotNull
        public final String getTitle() {
            return this.b;
        }

        public int hashCode() {
            int i = this.a * 31;
            String str = this.b;
            int i2 = 0;
            int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.c;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            AttributedText attributedText = this.d;
            int hashCode3 = (hashCode2 + (attributedText != null ? attributedText.hashCode() : 0)) * 31;
            String str3 = this.e;
            if (str3 != null) {
                i2 = str3.hashCode();
            }
            int i3 = (hashCode3 + i2) * 31;
            boolean z = this.f;
            int i4 = 1;
            if (z) {
                z = true;
            }
            int i5 = z ? 1 : 0;
            int i6 = z ? 1 : 0;
            int i7 = z ? 1 : 0;
            int i8 = (i3 + i5) * 31;
            boolean z2 = this.g;
            if (!z2) {
                i4 = z2 ? 1 : 0;
            }
            return i8 + i4;
        }

        public final boolean isError() {
            return this.g;
        }

        public final boolean isManual() {
            return this.f;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("Data(callId=");
            L.append(this.a);
            L.append(", title=");
            L.append(this.b);
            L.append(", subtitle=");
            L.append(this.c);
            L.append(", description=");
            L.append(this.d);
            L.append(", phone=");
            L.append(this.e);
            L.append(", isManual=");
            L.append(this.f);
            L.append(", isError=");
            return a2.b.a.a.a.B(L, this.g, ")");
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Data(int i, String str, String str2, AttributedText attributedText, String str3, boolean z, boolean z2, int i2, j jVar) {
            this(i, str, str2, attributedText, str3, z, (i2 & 64) != 0 ? false : z2);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\b\u0010\tR\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/profile_phones/landline_verification/LandlinePhoneVerificationViewModel$Event;", "", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "message", "<init>", "(Ljava/lang/String;)V", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
    public static final class Event {
        @Nullable
        public final String a;

        public Event() {
            this(null, 1, null);
        }

        public Event(@Nullable String str) {
            this.a = str;
        }

        @Nullable
        public final String getMessage() {
            return this.a;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Event(String str, int i, j jVar) {
            this((i & 1) != 0 ? null : str);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/profile_phones/landline_verification/LandlinePhoneVerificationViewModel$ResultStatus;", "", "<init>", "(Ljava/lang/String;I)V", SberbankOnlineKt.RESULT_SUCCESS, "CANCEL", "MANUAL", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
    public enum ResultStatus {
        SUCCESS,
        CANCEL,
        MANUAL
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/avito/android/profile_phones/landline_verification/LandlinePhoneVerificationViewModel$RoutingAction;", "", "<init>", "()V", "GoBack", "GoToHelpCenter", "GoToPhonesList", "Lcom/avito/android/profile_phones/landline_verification/LandlinePhoneVerificationViewModel$RoutingAction$GoBack;", "Lcom/avito/android/profile_phones/landline_verification/LandlinePhoneVerificationViewModel$RoutingAction$GoToPhonesList;", "Lcom/avito/android/profile_phones/landline_verification/LandlinePhoneVerificationViewModel$RoutingAction$GoToHelpCenter;", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class RoutingAction {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/profile_phones/landline_verification/LandlinePhoneVerificationViewModel$RoutingAction$GoBack;", "Lcom/avito/android/profile_phones/landline_verification/LandlinePhoneVerificationViewModel$RoutingAction;", "<init>", "()V", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
        public static final class GoBack extends RoutingAction {
            @NotNull
            public static final GoBack INSTANCE = new GoBack();

            public GoBack() {
                super(null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/profile_phones/landline_verification/LandlinePhoneVerificationViewModel$RoutingAction$GoToHelpCenter;", "Lcom/avito/android/profile_phones/landline_verification/LandlinePhoneVerificationViewModel$RoutingAction;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getPath", "()Ljava/lang/String;", MessageMetaInfo.COLUMN_PATH, "<init>", "(Ljava/lang/String;)V", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
        public static final class GoToHelpCenter extends RoutingAction {
            @NotNull
            public final String a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public GoToHelpCenter(@NotNull String str) {
                super(null);
                Intrinsics.checkNotNullParameter(str, MessageMetaInfo.COLUMN_PATH);
                this.a = str;
            }

            @NotNull
            public final String getPath() {
                return this.a;
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/profile_phones/landline_verification/LandlinePhoneVerificationViewModel$RoutingAction$GoToPhonesList;", "Lcom/avito/android/profile_phones/landline_verification/LandlinePhoneVerificationViewModel$RoutingAction;", "Lcom/avito/android/profile_phones/landline_verification/LandlinePhoneVerificationViewModel$ResultStatus;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/profile_phones/landline_verification/LandlinePhoneVerificationViewModel$ResultStatus;", "getStatus", "()Lcom/avito/android/profile_phones/landline_verification/LandlinePhoneVerificationViewModel$ResultStatus;", "status", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getPhone", "()Ljava/lang/String;", "phone", "<init>", "(Ljava/lang/String;Lcom/avito/android/profile_phones/landline_verification/LandlinePhoneVerificationViewModel$ResultStatus;)V", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
        public static final class GoToPhonesList extends RoutingAction {
            @NotNull
            public final String a;
            @NotNull
            public final ResultStatus b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public GoToPhonesList(@NotNull String str, @NotNull ResultStatus resultStatus) {
                super(null);
                Intrinsics.checkNotNullParameter(str, "phone");
                Intrinsics.checkNotNullParameter(resultStatus, "status");
                this.a = str;
                this.b = resultStatus;
            }

            @NotNull
            public final String getPhone() {
                return this.a;
            }

            @NotNull
            public final ResultStatus getStatus() {
                return this.b;
            }
        }

        public RoutingAction() {
        }

        public RoutingAction(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/profile_phones/landline_verification/LandlinePhoneVerificationViewModel$ScreenState;", "", "<init>", "()V", "Loading", "Ok", "Lcom/avito/android/profile_phones/landline_verification/LandlinePhoneVerificationViewModel$ScreenState$Loading;", "Lcom/avito/android/profile_phones/landline_verification/LandlinePhoneVerificationViewModel$ScreenState$Ok;", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class ScreenState {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/profile_phones/landline_verification/LandlinePhoneVerificationViewModel$ScreenState$Loading;", "Lcom/avito/android/profile_phones/landline_verification/LandlinePhoneVerificationViewModel$ScreenState;", "<init>", "()V", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
        public static final class Loading extends ScreenState {
            @NotNull
            public static final Loading INSTANCE = new Loading();

            public Loading() {
                super(null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u000e¢\u0006\u0004\b\u0017\u0010\u0018R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0013\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0016\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006¨\u0006\u0019"}, d2 = {"Lcom/avito/android/profile_phones/landline_verification/LandlinePhoneVerificationViewModel$ScreenState$Ok;", "Lcom/avito/android/profile_phones/landline_verification/LandlinePhoneVerificationViewModel$ScreenState;", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "title", "Lcom/avito/android/profile_phones/landline_verification/LandlinePhoneVerificationViewModel$ActionState;", AuthSource.SEND_ABUSE, "Lcom/avito/android/profile_phones/landline_verification/LandlinePhoneVerificationViewModel$ActionState;", "getAction", "()Lcom/avito/android/profile_phones/landline_verification/LandlinePhoneVerificationViewModel$ActionState;", "action", "Lcom/avito/android/remote/model/text/AttributedText;", "d", "Lcom/avito/android/remote/model/text/AttributedText;", "getDescription", "()Lcom/avito/android/remote/model/text/AttributedText;", "description", "c", "getSubtitle", MessengerShareContentUtility.SUBTITLE, "<init>", "(Lcom/avito/android/profile_phones/landline_verification/LandlinePhoneVerificationViewModel$ActionState;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/text/AttributedText;)V", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
        public static final class Ok extends ScreenState {
            @NotNull
            public final ActionState a;
            @NotNull
            public final String b;
            @NotNull
            public final String c;
            @NotNull
            public final AttributedText d;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Ok(@NotNull ActionState actionState, @NotNull String str, @NotNull String str2, @NotNull AttributedText attributedText) {
                super(null);
                Intrinsics.checkNotNullParameter(actionState, "action");
                Intrinsics.checkNotNullParameter(str, "title");
                Intrinsics.checkNotNullParameter(str2, MessengerShareContentUtility.SUBTITLE);
                Intrinsics.checkNotNullParameter(attributedText, "description");
                this.a = actionState;
                this.b = str;
                this.c = str2;
                this.d = attributedText;
            }

            @NotNull
            public final ActionState getAction() {
                return this.a;
            }

            @NotNull
            public final AttributedText getDescription() {
                return this.d;
            }

            @NotNull
            public final String getSubtitle() {
                return this.c;
            }

            @NotNull
            public final String getTitle() {
                return this.b;
            }
        }

        public ScreenState() {
        }

        public ScreenState(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            LandlinePhoneVerificationStatusResult.VerificationStatus.values();
            int[] iArr = new int[4];
            $EnumSwitchMapping$0 = iArr;
            LandlinePhoneVerificationStatusResult.VerificationStatus verificationStatus = LandlinePhoneVerificationStatusResult.VerificationStatus.ERROR;
            iArr[0] = 1;
            LandlinePhoneVerificationStatusResult.VerificationStatus verificationStatus2 = LandlinePhoneVerificationStatusResult.VerificationStatus.SUCCESS;
            iArr[1] = 2;
            LandlinePhoneVerificationStatusResult.VerificationStatus verificationStatus3 = LandlinePhoneVerificationStatusResult.VerificationStatus.PROCESSING;
            iArr[2] = 3;
            LandlinePhoneVerificationStatusResult.VerificationStatus verificationStatus4 = LandlinePhoneVerificationStatusResult.VerificationStatus.FAILED;
            iArr[3] = 4;
        }
    }

    public static final class a<T> implements Consumer<LandlinePhoneVerificationStatusResult> {
        public final /* synthetic */ LandlinePhoneVerificationViewModel a;
        public final /* synthetic */ Data b;

        public a(LandlinePhoneVerificationViewModel landlinePhoneVerificationViewModel, Data data) {
            this.a = landlinePhoneVerificationViewModel;
            this.b = data;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r13v9, resolved type: com.avito.android.util.architecture_components.SingleLiveEvent */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(LandlinePhoneVerificationStatusResult landlinePhoneVerificationStatusResult) {
            LandlinePhoneVerificationStatusResult landlinePhoneVerificationStatusResult2 = landlinePhoneVerificationStatusResult;
            LandlinePhoneVerificationStatusResult.VerificationStatus status = landlinePhoneVerificationStatusResult2.getStatus();
            ManualPhoneVerificationLink manualPhoneVerificationLink = null;
            if (status != null) {
                int ordinal = status.ordinal();
                if (ordinal == 0) {
                    Disposable disposable = this.a.f;
                    if (disposable != null) {
                        disposable.dispose();
                    }
                    LandlinePhoneVerificationViewModel.access$refreshData(this.a, Data.copy$default(this.b, 0, null, null, null, null, false, true, 62, null));
                    return;
                } else if (ordinal == 1) {
                    Disposable disposable2 = this.a.f;
                    if (disposable2 != null) {
                        disposable2.dispose();
                    }
                    this.a.h.setValue(new RoutingAction.GoToPhonesList(this.b.getPhone(), ResultStatus.SUCCESS));
                    return;
                } else if (ordinal == 2) {
                    return;
                } else {
                    if (ordinal == 3) {
                        Disposable disposable3 = this.a.f;
                        if (disposable3 != null) {
                            disposable3.dispose();
                        }
                        DeepLink deeplink = landlinePhoneVerificationStatusResult2.getDeeplink();
                        if (deeplink instanceof ManualPhoneVerificationLink) {
                            manualPhoneVerificationLink = deeplink;
                        }
                        ManualPhoneVerificationLink manualPhoneVerificationLink2 = manualPhoneVerificationLink;
                        if (manualPhoneVerificationLink2 != null) {
                            Integer callId = manualPhoneVerificationLink2.getContext().getCallId();
                            LandlinePhoneVerificationViewModel.access$refreshData(this.a, new Data(callId != null ? callId.intValue() : 0, manualPhoneVerificationLink2.getContext().getTitle(), manualPhoneVerificationLink2.getContext().getSubtitle(), manualPhoneVerificationLink2.getContext().getDescription(), this.b.getPhone(), true, false, 64, null));
                            return;
                        }
                        return;
                    }
                }
            }
            Logs.warning$default("verificationStatusPolling", "Failed to VerificationStatusPolling - unknown LandlinePhoneVerificationStatusResult status value", null, 4, null);
        }
    }

    public static final class b<T> implements Consumer<Throwable> {
        public final /* synthetic */ LandlinePhoneVerificationViewModel a;

        public b(LandlinePhoneVerificationViewModel landlinePhoneVerificationViewModel) {
            this.a = landlinePhoneVerificationViewModel;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v6, resolved type: com.avito.android.util.architecture_components.SingleLiveEvent */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Throwable th2 = th;
            if (th2 instanceof TypedResultException) {
                TypedResultException typedResultException = (TypedResultException) th2;
                if (typedResultException.getErrorResult() instanceof ErrorResult.NetworkIOError) {
                    TypedError errorResult = typedResultException.getErrorResult();
                    Objects.requireNonNull(errorResult, "null cannot be cast to non-null type com.avito.android.remote.error.ErrorResult.NetworkIOError");
                    this.a.i.postValue(new Event(((ErrorResult.NetworkIOError) errorResult).getMessage()));
                    return;
                }
            }
            Logs.error("Failed to request VerificationStatusPolling ", th2);
        }
    }

    public static final class c<T> implements Consumer<TypedResult<RequestCodeResult>> {
        public final /* synthetic */ LandlinePhoneVerificationViewModel a;
        public final /* synthetic */ String b;

        public c(LandlinePhoneVerificationViewModel landlinePhoneVerificationViewModel, String str) {
            this.a = landlinePhoneVerificationViewModel;
            this.b = str;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.avito.android.util.architecture_components.SingleLiveEvent */
        /* JADX DEBUG: Multi-variable search result rejected for r0v10, resolved type: com.avito.android.util.architecture_components.SingleLiveEvent */
        /* JADX DEBUG: Multi-variable search result rejected for r0v12, resolved type: com.avito.android.util.architecture_components.SingleLiveEvent */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(TypedResult<RequestCodeResult> typedResult) {
            TypedResult<RequestCodeResult> typedResult2 = typedResult;
            if (typedResult2 instanceof TypedResult.OfResult) {
                RequestCodeResult requestCodeResult = (RequestCodeResult) ((TypedResult.OfResult) typedResult2).getResult();
                if (requestCodeResult instanceof RequestCodeResult.VerifyByCall) {
                    DeepLink deeplink = ((RequestCodeResult.VerifyByCall) requestCodeResult).getDeeplink();
                    if (!(deeplink instanceof LandlinePhoneVerificationLink)) {
                        deeplink = null;
                    }
                    LandlinePhoneVerificationLink landlinePhoneVerificationLink = (LandlinePhoneVerificationLink) deeplink;
                    if (landlinePhoneVerificationLink != null) {
                        Integer callId = landlinePhoneVerificationLink.getContext().getCallId();
                        LandlinePhoneVerificationViewModel.access$refreshData(this.a, new Data(callId != null ? callId.intValue() : 0, landlinePhoneVerificationLink.getContext().getTitle(), landlinePhoneVerificationLink.getContext().getSubtitle(), landlinePhoneVerificationLink.getContext().getDescription(), this.b, false, false, 64, null));
                    }
                } else if (requestCodeResult instanceof RequestCodeResult.Failure) {
                    this.a.i.postValue(new Event(((RequestCodeResult.Failure) requestCodeResult).getMessage()));
                } else if (requestCodeResult instanceof RequestCodeResult.IncorrectData) {
                    SingleLiveEvent singleLiveEvent = this.a.i;
                    String str = (String) CollectionsKt___CollectionsKt.firstOrNull(((RequestCodeResult.IncorrectData) requestCodeResult).getMessages().values());
                    if (str == null) {
                        str = "";
                    }
                    singleLiveEvent.postValue(new Event(str));
                } else {
                    LandlinePhoneVerificationViewModel.access$sendTryAgainErrorEvent(this.a);
                }
            } else if (typedResult2 instanceof TypedResult.OfError) {
                TypedResult.OfError ofError = (TypedResult.OfError) typedResult2;
                if (ofError.getError() instanceof ErrorResult.NetworkIOError) {
                    this.a.i.postValue(new Event(ofError.getError().getMessage()));
                } else {
                    LandlinePhoneVerificationViewModel.access$sendTryAgainErrorEvent(this.a);
                }
            }
        }
    }

    public static final class d<T> implements Consumer<Throwable> {
        public final /* synthetic */ LandlinePhoneVerificationViewModel a;

        public d(LandlinePhoneVerificationViewModel landlinePhoneVerificationViewModel) {
            this.a = landlinePhoneVerificationViewModel;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            LandlinePhoneVerificationViewModel.access$sendTryAgainErrorEvent(this.a);
            Logs.error("Failed to requestVerificationCall", th);
        }
    }

    public static final class e<T> implements Consumer<Unit> {
        public final /* synthetic */ LandlinePhoneVerificationViewModel a;
        public final /* synthetic */ String b;

        public e(LandlinePhoneVerificationViewModel landlinePhoneVerificationViewModel, String str) {
            this.a = landlinePhoneVerificationViewModel;
            this.b = str;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r4v3, resolved type: com.avito.android.util.architecture_components.SingleLiveEvent */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Unit unit) {
            this.a.h.setValue(new RoutingAction.GoToPhonesList(this.b, ResultStatus.MANUAL));
        }
    }

    public static final class f<T> implements Consumer<Throwable> {
        public final /* synthetic */ LandlinePhoneVerificationViewModel a;

        public f(LandlinePhoneVerificationViewModel landlinePhoneVerificationViewModel) {
            this.a = landlinePhoneVerificationViewModel;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v7, resolved type: com.avito.android.util.architecture_components.SingleLiveEvent */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Throwable th2 = th;
            if (th2 instanceof TypedResultException) {
                TypedResultException typedResultException = (TypedResultException) th2;
                if (typedResultException.getErrorResult() instanceof ErrorResult.NetworkIOError) {
                    TypedError errorResult = typedResultException.getErrorResult();
                    Objects.requireNonNull(errorResult, "null cannot be cast to non-null type com.avito.android.remote.error.ErrorResult.NetworkIOError");
                    this.a.i.postValue(new Event(((ErrorResult.NetworkIOError) errorResult).getMessage()));
                    return;
                }
            }
            LandlinePhoneVerificationViewModel.access$sendTryAgainErrorEvent(this.a);
            Logs.error("Failed to requestManualVerificationCall", th2);
        }
    }

    public LandlinePhoneVerificationViewModel(@NotNull LandlinePhoneVerificationInteractor landlinePhoneVerificationInteractor) {
        Intrinsics.checkNotNullParameter(landlinePhoneVerificationInteractor, "interactor");
        this.j = landlinePhoneVerificationInteractor;
    }

    public static final void access$refreshData(LandlinePhoneVerificationViewModel landlinePhoneVerificationViewModel, Data data) {
        if (!Intrinsics.areEqual(landlinePhoneVerificationViewModel.d, data)) {
            landlinePhoneVerificationViewModel.e(data);
            landlinePhoneVerificationViewModel.d(data);
            landlinePhoneVerificationViewModel.c(data);
        }
    }

    public static final void access$sendTryAgainErrorEvent(LandlinePhoneVerificationViewModel landlinePhoneVerificationViewModel) {
        landlinePhoneVerificationViewModel.i.postValue(new Event(""));
    }

    public final void c(Data data) {
        if (data != null) {
            if (data.getCallId() > 0) {
                Disposable disposable = this.f;
                if (disposable == null || disposable.isDisposed()) {
                    this.f = this.j.startVerificationStatusPolling(data.getCallId()).subscribe(new a(this, data), new b(this));
                }
            }
        }
    }

    public final void d(Data data) {
        ActionState actionState;
        if (m.isBlank(data.getPhone())) {
            actionState = ActionState.STATUS;
        } else if (data.isManual()) {
            actionState = ActionState.MANUAL;
        } else {
            if (data.getCallId() > 0) {
                actionState = ActionState.CALL_ORDERED;
            } else {
                actionState = ActionState.CALL_ORDER;
            }
        }
        ScreenState.Ok ok = new ScreenState.Ok(actionState, data.getTitle(), data.getSubtitle(), data.getDescription());
        if (data.isError()) {
            this.i.setValue(new Event(null, 1, null));
        }
        this.g.setValue(ok);
    }

    public final void e(Data data) {
        AttributedText description;
        AttributedText description2;
        Data data2 = this.d;
        if (!(data2 == null || (description2 = data2.getDescription()) == null)) {
            description2.setOnUrlClickListener(null);
        }
        if (!(data == null || (description = data.getDescription()) == null)) {
            description.setOnUrlClickListener(this.c);
        }
        this.d = data;
    }

    @NotNull
    public final LiveData<Event> events() {
        return this.i;
    }

    public final void initData(int i2, @NotNull String str, @NotNull String str2, @NotNull AttributedText attributedText, @NotNull String str3, boolean z) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, MessengerShareContentUtility.SUBTITLE);
        Intrinsics.checkNotNullParameter(attributedText, "description");
        Intrinsics.checkNotNullParameter(str3, "phone");
        if (this.d == null) {
            Data data = new Data(i2, str, str2, attributedText, str3, z, false, 64, null);
            e(data);
            d(data);
            c(data);
        }
    }

    @NotNull
    public final LiveData<RoutingAction> navigation() {
        return this.h;
    }

    public final void onBackClicked() {
        this.h.setValue(RoutingAction.GoBack.INSTANCE);
    }

    public final void onCallOrderClicked() {
        String str;
        this.g.setValue(ScreenState.Loading.INSTANCE);
        Data data = this.d;
        if (data == null || (str = data.getPhone()) == null) {
            str = "";
        }
        Disposable disposable = this.e;
        if (disposable != null) {
            disposable.dispose();
        }
        this.e = this.j.requestBotVerificationCall(str).subscribe(new c(this, str), new d(this));
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        Disposable disposable = this.e;
        if (disposable != null) {
            disposable.dispose();
        }
        Disposable disposable2 = this.f;
        if (disposable2 != null) {
            disposable2.dispose();
        }
        super.onCleared();
    }

    public final void onManualCheckAcceptClicked() {
        String str;
        this.g.setValue(ScreenState.Loading.INSTANCE);
        Data data = this.d;
        if (data == null || (str = data.getPhone()) == null) {
            str = "";
        }
        Disposable disposable = this.e;
        if (disposable != null) {
            disposable.dispose();
        }
        this.e = this.j.requestManualVerificationCall(str).subscribe(new e(this, str), new f(this));
    }

    public final void onManualCheckCancelClicked() {
        String str;
        SingleLiveEvent<RoutingAction> singleLiveEvent = this.h;
        Data data = this.d;
        if (data == null || (str = data.getPhone()) == null) {
            str = "";
        }
        singleLiveEvent.setValue(new RoutingAction.GoToPhonesList(str, ResultStatus.CANCEL));
    }

    public final void onOkClicked() {
        this.h.setValue(RoutingAction.GoBack.INSTANCE);
    }

    public final void onStart() {
        c(this.d);
    }

    public final void onStop() {
        Disposable disposable = this.f;
        if (disposable != null) {
            disposable.dispose();
        }
    }

    @NotNull
    public final LiveData<ScreenState> screenState() {
        return this.g;
    }
}
