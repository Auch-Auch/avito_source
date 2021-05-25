package com.avito.android.publish.slots.contact_info;

import a2.g.r.g;
import com.avito.android.account.AccountStorageInteractor;
import com.avito.android.account.SessionChangeTracker;
import com.avito.android.items.InputItem;
import com.avito.android.publish.ContactsDataSource;
import com.avito.android.publish.ProfileSourceInteractor;
import com.avito.android.publish.analytics.PublishEventTracker;
import com.avito.android.publish.slots.ConsumeValueChangeResult;
import com.avito.android.publish.slots.SlotWrapper;
import com.avito.android.remote.ProfileApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.PhonePretendSpecialErrorCase;
import com.avito.android.remote.error.TypedError;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.remote.model.PretendErrorValue;
import com.avito.android.remote.model.Profile;
import com.avito.android.remote.model.SuccessResult;
import com.avito.android.remote.model.category_parameters.CharParameter;
import com.avito.android.remote.model.category_parameters.EmailParameter;
import com.avito.android.remote.model.category_parameters.PhoneParameter;
import com.avito.android.remote.model.category_parameters.base.EditableParameter;
import com.avito.android.remote.model.category_parameters.base.HasError;
import com.avito.android.remote.model.category_parameters.base.ParameterSlot;
import com.avito.android.remote.model.category_parameters.slot.SlotType;
import com.avito.android.remote.model.category_parameters.slot.anonymous_number.AnonymousNumberSlot;
import com.avito.android.remote.model.category_parameters.slot.anonymous_number.AnonymousNumberSlotValue;
import com.avito.android.remote.model.category_parameters.slot.contact_info.ContactInfoSlot;
import com.avito.android.remote.model.category_parameters.slot.contact_info.ContactInfoSlotConfig;
import com.avito.android.remote.model.category_parameters.slot.contact_info.ContactInfoSlotValue;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.util.Formatter;
import com.avito.android.util.LoadingState;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.rx3.InteropKt;
import com.avito.conveyor_item.Item;
import com.sumsub.sns.R2;
import io.reactivex.functions.Action;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Function;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001PBe\u0012\u0006\u0010'\u001a\u00020\u0002\u0012\u0006\u0010+\u001a\u00020(\u0012\u0006\u0010?\u001a\u00020<\u0012\u0006\u0010C\u001a\u00020@\u0012\u0006\u00103\u001a\u000200\u0012\u0006\u0010#\u001a\u00020 \u0012\f\u0010G\u001a\b\u0012\u0004\u0012\u00020\r0D\u0012\u0006\u0010/\u001a\u00020,\u0012\u0006\u0010K\u001a\u00020H\u0012\u0006\u00107\u001a\u000204\u0012\u0006\u0010M\u001a\u00020L¢\u0006\u0004\bN\u0010OJ\u001b\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\n\u001a\u00020\t*\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ#\u0010\u0010\u001a\u00020\u000f2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00040\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u001b\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0014H\u0016¢\u0006\u0004\b\u0018\u0010\u0017J#\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016¢\u0006\u0004\b\u001e\u0010\u001fR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u001c\u0010'\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0010\u0010$\u001a\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u00108\u001a\u00020,8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010.R\u0016\u0010;\u001a\u0002098\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010:R\u0016\u0010?\u001a\u00020<8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010C\u001a\u00020@8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bA\u0010BR\u001c\u0010G\u001a\b\u0012\u0004\u0012\u00020\r0D8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010K\u001a\u00020H8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bI\u0010J¨\u0006Q"}, d2 = {"Lcom/avito/android/publish/slots/contact_info/ContactInfoSlotWrapper;", "Lcom/avito/android/publish/slots/SlotWrapper;", "Lcom/avito/android/remote/model/category_parameters/slot/contact_info/ContactInfoSlot;", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/remote/model/SuccessResult;", AuthSource.SEND_ABUSE, "()Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/publish/slots/contact_info/ContactsData;", "Lcom/avito/android/remote/model/category_parameters/PhoneParameter;", AuthSource.BOOKING_ORDER, "(Lcom/avito/android/publish/slots/contact_info/ContactsData;)Lcom/avito/android/remote/model/category_parameters/PhoneParameter;", "", "", "errorMap", "Lcom/avito/android/remote/error/TypedError;", "c", "(Ljava/util/Map;)Lcom/avito/android/remote/error/TypedError;", "getId", "()Ljava/lang/String;", "Lio/reactivex/Observable;", "", "prepare", "()Lio/reactivex/Observable;", "checkErrors", "Lcom/avito/conveyor_item/Item;", "element", "Lcom/avito/android/remote/model/category_parameters/base/ParameterSlot;", "param", "Lcom/avito/android/publish/slots/ConsumeValueChangeResult;", "consumeItemValueChange", "(Lcom/avito/conveyor_item/Item;Lcom/avito/android/remote/model/category_parameters/base/ParameterSlot;)Lcom/avito/android/publish/slots/ConsumeValueChangeResult;", "Lcom/avito/android/account/AccountStorageInteractor;", "h", "Lcom/avito/android/account/AccountStorageInteractor;", "accountStorageInteractor", "Lcom/avito/android/remote/model/category_parameters/slot/contact_info/ContactInfoSlot;", "getSlot", "()Lcom/avito/android/remote/model/category_parameters/slot/contact_info/ContactInfoSlot;", "slot", "Lcom/avito/android/publish/ProfileSourceInteractor;", "d", "Lcom/avito/android/publish/ProfileSourceInteractor;", "profileSource", "", "j", "Z", "isEditing", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", g.a, "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "throwableConverter", "Lcom/avito/android/util/SchedulersFactory3;", "l", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "shouldRegisterUser", "Lcom/avito/android/remote/error/PhonePretendSpecialErrorCase;", "Lcom/avito/android/remote/error/PhonePretendSpecialErrorCase;", "specialCase", "Lcom/avito/android/publish/ContactsDataSource;", "e", "Lcom/avito/android/publish/ContactsDataSource;", "contactsDataSource", "Lcom/avito/android/remote/ProfileApi;", "f", "Lcom/avito/android/remote/ProfileApi;", "profileApi", "Lcom/avito/android/util/Formatter;", "i", "Lcom/avito/android/util/Formatter;", "phoneFormatter", "Lcom/avito/android/account/SessionChangeTracker;", "k", "Lcom/avito/android/account/SessionChangeTracker;", "sessionChangeTracker", "Lcom/avito/android/publish/analytics/PublishEventTracker;", "publishEventTracker", "<init>", "(Lcom/avito/android/remote/model/category_parameters/slot/contact_info/ContactInfoSlot;Lcom/avito/android/publish/ProfileSourceInteractor;Lcom/avito/android/publish/ContactsDataSource;Lcom/avito/android/remote/ProfileApi;Lcom/avito/android/remote/error/TypedErrorThrowableConverter;Lcom/avito/android/account/AccountStorageInteractor;Lcom/avito/android/util/Formatter;ZLcom/avito/android/account/SessionChangeTracker;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/publish/analytics/PublishEventTracker;)V", "PhoneVerificationData", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class ContactInfoSlotWrapper implements SlotWrapper<ContactInfoSlot> {
    public boolean a;
    public final PhonePretendSpecialErrorCase b;
    @NotNull
    public final ContactInfoSlot c;
    public final ProfileSourceInteractor d;
    public final ContactsDataSource e;
    public final ProfileApi f;
    public final TypedErrorThrowableConverter g;
    public final AccountStorageInteractor h;
    public final Formatter<String> i;
    public final boolean j;
    public final SessionChangeTracker k;
    public final SchedulersFactory3 l;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u000f\b\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ0\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0013\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R\u001b\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0016\u001a\u0004\b\u0019\u0010\u0004R\u0019\u0010\u000b\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u000b\u0010\b¨\u0006\u001e"}, d2 = {"Lcom/avito/android/publish/slots/contact_info/ContactInfoSlotWrapper$PhoneVerificationData;", "", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()Z", "phone", "manager", "isCompany", "copy", "(Ljava/lang/String;Ljava/lang/String;Z)Lcom/avito/android/publish/slots/contact_info/ContactInfoSlotWrapper$PhoneVerificationData;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getPhone", AuthSource.BOOKING_ORDER, "getManager", "c", "Z", "<init>", "(Ljava/lang/String;Ljava/lang/String;Z)V", "publish_release"}, k = 1, mv = {1, 4, 2})
    public static final class PhoneVerificationData {
        @NotNull
        public final String a;
        @Nullable
        public final String b;
        public final boolean c;

        public PhoneVerificationData(@NotNull String str, @Nullable String str2, boolean z) {
            Intrinsics.checkNotNullParameter(str, "phone");
            this.a = str;
            this.b = str2;
            this.c = z;
        }

        public static /* synthetic */ PhoneVerificationData copy$default(PhoneVerificationData phoneVerificationData, String str, String str2, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                str = phoneVerificationData.a;
            }
            if ((i & 2) != 0) {
                str2 = phoneVerificationData.b;
            }
            if ((i & 4) != 0) {
                z = phoneVerificationData.c;
            }
            return phoneVerificationData.copy(str, str2, z);
        }

        @NotNull
        public final String component1() {
            return this.a;
        }

        @Nullable
        public final String component2() {
            return this.b;
        }

        public final boolean component3() {
            return this.c;
        }

        @NotNull
        public final PhoneVerificationData copy(@NotNull String str, @Nullable String str2, boolean z) {
            Intrinsics.checkNotNullParameter(str, "phone");
            return new PhoneVerificationData(str, str2, z);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PhoneVerificationData)) {
                return false;
            }
            PhoneVerificationData phoneVerificationData = (PhoneVerificationData) obj;
            return Intrinsics.areEqual(this.a, phoneVerificationData.a) && Intrinsics.areEqual(this.b, phoneVerificationData.b) && this.c == phoneVerificationData.c;
        }

        @Nullable
        public final String getManager() {
            return this.b;
        }

        @NotNull
        public final String getPhone() {
            return this.a;
        }

        public int hashCode() {
            String str = this.a;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.b;
            if (str2 != null) {
                i = str2.hashCode();
            }
            int i2 = (hashCode + i) * 31;
            boolean z = this.c;
            if (z) {
                z = true;
            }
            int i3 = z ? 1 : 0;
            int i4 = z ? 1 : 0;
            int i5 = z ? 1 : 0;
            return i2 + i3;
        }

        public final boolean isCompany() {
            return this.c;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("PhoneVerificationData(phone=");
            L.append(this.a);
            L.append(", manager=");
            L.append(this.b);
            L.append(", isCompany=");
            return a2.b.a.a.a.B(L, this.c, ")");
        }
    }

    public static final class a<T, R> implements Function<LoadingState<? super SuccessResult>, LoadingState<? super SuccessResult>> {
        public final /* synthetic */ ContactInfoSlotWrapper a;

        public a(ContactInfoSlotWrapper contactInfoSlotWrapper) {
            this.a = contactInfoSlotWrapper;
        }

        @Override // io.reactivex.rxjava3.functions.Function
        public LoadingState<? super SuccessResult> apply(LoadingState<? super SuccessResult> loadingState) {
            LoadingState<? super SuccessResult> loadingState2 = loadingState;
            return (!(loadingState2 instanceof LoadingState.Loaded) && (loadingState2 instanceof LoadingState.Error)) ? new LoadingState.Error(ContactInfoSlotWrapper.access$relateContactsDataErrors(this.a, ((LoadingState.Error) loadingState2).getError())) : loadingState2;
        }
    }

    public static final class b<T, R> implements Function<SuccessResult, LoadingState<? super SuccessResult>> {
        public static final b a = new b();

        @Override // io.reactivex.rxjava3.functions.Function
        public LoadingState<? super SuccessResult> apply(SuccessResult successResult) {
            return new LoadingState.Loaded(successResult);
        }
    }

    public static final class c<T, R> implements Function<Throwable, LoadingState<? super SuccessResult>> {
        public final /* synthetic */ ContactInfoSlotWrapper a;

        public c(ContactInfoSlotWrapper contactInfoSlotWrapper) {
            this.a = contactInfoSlotWrapper;
        }

        @Override // io.reactivex.rxjava3.functions.Function
        public LoadingState<? super SuccessResult> apply(Throwable th) {
            Throwable th2 = th;
            TypedErrorThrowableConverter typedErrorThrowableConverter = this.a.g;
            Intrinsics.checkNotNullExpressionValue(th2, "it");
            return new LoadingState.Error(typedErrorThrowableConverter.convertWithSpecialErrorCase(th2, this.a.b));
        }
    }

    public static final class d<T, R> implements io.reactivex.functions.Function<Throwable, LoadingState<? super Unit>> {
        public final /* synthetic */ ContactInfoSlotWrapper a;
        public final /* synthetic */ Function1 b;

        public d(ContactInfoSlotWrapper contactInfoSlotWrapper, Function1 function1) {
            this.a = contactInfoSlotWrapper;
            this.b = function1;
        }

        @Override // io.reactivex.functions.Function
        public LoadingState<? super Unit> apply(Throwable th) {
            Intrinsics.checkNotNullParameter(th, "it");
            this.a.e.setContactsData(new ContactsData(null, null, null, null, null, false, false, false, false, null, false, null, null, 8191, null));
            Function1 function1 = this.b;
            ContactsData contactsData = this.a.e.getContactsData();
            Intrinsics.checkNotNull(contactsData);
            function1.invoke(contactsData);
            ContactInfoSlotWrapper.access$fillSlotFields(this.a);
            return new LoadingState.Loaded(Unit.INSTANCE);
        }
    }

    public static final class e implements Action {
        public final /* synthetic */ ContactInfoSlotWrapper a;

        public e(ContactInfoSlotWrapper contactInfoSlotWrapper) {
            this.a = contactInfoSlotWrapper;
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            ContactInfoSlotWrapper contactInfoSlotWrapper = this.a;
            ContactsData contactsData = contactInfoSlotWrapper.e.getContactsData();
            Intrinsics.checkNotNull(contactsData);
            contactInfoSlotWrapper.a = contactsData.isIncomplete();
            ContactInfoSlotWrapper.access$fillSlotFields(this.a);
        }
    }

    public static final class f extends Lambda implements Function1<ContactsData, Unit> {
        public final /* synthetic */ ContactInfoSlotWrapper a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(ContactInfoSlotWrapper contactInfoSlotWrapper) {
            super(1);
            this.a = contactInfoSlotWrapper;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(ContactsData contactsData) {
            ContactsData contactsData2 = contactsData;
            Intrinsics.checkNotNullParameter(contactsData2, "contactsData");
            ContactInfoSlotValue value = this.a.getSlot().getValue();
            if (value != null) {
                contactsData2.setPhone(this.a.i.format(value.getPhone()));
                String manager = value.getManager();
                if (manager != null) {
                    contactsData2.setManager(manager);
                }
            }
            return Unit.INSTANCE;
        }
    }

    public ContactInfoSlotWrapper(@NotNull ContactInfoSlot contactInfoSlot, @NotNull ProfileSourceInteractor profileSourceInteractor, @NotNull ContactsDataSource contactsDataSource, @NotNull ProfileApi profileApi, @NotNull TypedErrorThrowableConverter typedErrorThrowableConverter, @NotNull AccountStorageInteractor accountStorageInteractor, @NotNull Formatter<String> formatter, boolean z, @NotNull SessionChangeTracker sessionChangeTracker, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull PublishEventTracker publishEventTracker) {
        Intrinsics.checkNotNullParameter(contactInfoSlot, "slot");
        Intrinsics.checkNotNullParameter(profileSourceInteractor, "profileSource");
        Intrinsics.checkNotNullParameter(contactsDataSource, "contactsDataSource");
        Intrinsics.checkNotNullParameter(profileApi, "profileApi");
        Intrinsics.checkNotNullParameter(typedErrorThrowableConverter, "throwableConverter");
        Intrinsics.checkNotNullParameter(accountStorageInteractor, "accountStorageInteractor");
        Intrinsics.checkNotNullParameter(formatter, "phoneFormatter");
        Intrinsics.checkNotNullParameter(sessionChangeTracker, "sessionChangeTracker");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(publishEventTracker, "publishEventTracker");
        this.c = contactInfoSlot;
        this.d = profileSourceInteractor;
        this.e = contactsDataSource;
        this.f = profileApi;
        this.g = typedErrorThrowableConverter;
        this.h = accountStorageInteractor;
        this.i = formatter;
        this.j = z;
        this.k = sessionChangeTracker;
        this.l = schedulersFactory3;
        if (!z) {
            publishEventTracker.trackContactsScreenOpened();
        }
        this.b = new PhonePretendSpecialErrorCase(null, 1, null);
    }

    public static final ContactsData access$buildContactsData(ContactInfoSlotWrapper contactInfoSlotWrapper, Profile profile, ContactInfoSlotValue contactInfoSlotValue) {
        String str;
        String str2;
        Objects.requireNonNull(contactInfoSlotWrapper);
        if ((contactInfoSlotValue == null || (str = contactInfoSlotValue.getPhone()) == null) && (str = profile.getPhone()) == null) {
            str = "";
        }
        String name = profile.getName();
        if (contactInfoSlotValue == null || (str2 = contactInfoSlotValue.getManager()) == null) {
            str2 = profile.getManager();
        }
        return new ContactsData(str, name, profile.getEmail(), str2, profile.getAvatar(), profile.isShop(), profile.getType().isCompany(), profile.isIncomplete(), profile.isPro(), null, false, null, null, R2.styleable.MockView_mock_labelBackgroundColor, null);
    }

    public static final String access$cleanFormatting(ContactInfoSlotWrapper contactInfoSlotWrapper, String str) {
        String str2;
        Objects.requireNonNull(contactInfoSlotWrapper);
        if (str != null) {
            StringBuilder sb = new StringBuilder();
            int length = str.length();
            for (int i2 = 0; i2 < length; i2++) {
                char charAt = str.charAt(i2);
                if (charAt == '+' || Character.isDigit(charAt)) {
                    sb.append(charAt);
                }
            }
            str2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(str2, "filterTo(StringBuilder(), predicate).toString()");
        } else {
            str2 = null;
        }
        return str2 != null ? str2 : "";
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x003d: APUT  
      (r2v3 com.avito.android.remote.model.category_parameters.base.ParameterSlot[])
      (0 ??[int, short, byte, char])
      (r7v3 com.avito.android.remote.model.category_parameters.CharParameter)
     */
    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0097: APUT  
      (r2v1 com.avito.android.remote.model.category_parameters.base.ParameterSlot[])
      (0 ??[int, short, byte, char])
      (r3v1 com.avito.android.remote.model.category_parameters.CharParameter)
     */
    public static final void access$fillSlotFields(ContactInfoSlotWrapper contactInfoSlotWrapper) {
        List<? extends ParameterSlot> list;
        String str;
        if (contactInfoSlotWrapper.getSlot().getParameters().isEmpty()) {
            ContactInfoSlot slot = contactInfoSlotWrapper.getSlot();
            ContactsData contactsData = contactInfoSlotWrapper.e.getContactsData();
            Intrinsics.checkNotNull(contactsData);
            CharParameter charParameter = null;
            if (contactsData.isIncomplete()) {
                ParameterSlot[] parameterSlotArr = new ParameterSlot[3];
                CharParameter nameField = ((ContactInfoSlotConfig) a2.b.a.a.a.C1(contactInfoSlotWrapper)).getNameField();
                if (nameField != null) {
                    nameField.setValue(contactsData.getName());
                } else {
                    nameField = null;
                }
                parameterSlotArr[0] = nameField;
                EmailParameter emailField = ((ContactInfoSlotConfig) a2.b.a.a.a.C1(contactInfoSlotWrapper)).getEmailField();
                if (emailField != null) {
                    emailField.setValue(contactsData.getEmail());
                    charParameter = emailField;
                }
                parameterSlotArr[1] = charParameter;
                parameterSlotArr[2] = contactInfoSlotWrapper.b(contactsData);
                list = CollectionsKt__CollectionsKt.listOfNotNull((Object[]) parameterSlotArr);
            } else {
                ParameterSlot[] parameterSlotArr2 = new ParameterSlot[2];
                if (contactsData.isCompany() || contactsData.isShop()) {
                    charParameter = ((ContactInfoSlotConfig) a2.b.a.a.a.C1(contactInfoSlotWrapper)).getManagerField();
                    ContactInfoSlotValue value = contactInfoSlotWrapper.getSlot().getValue();
                    if (value == null || (str = value.getManager()) == null) {
                        str = contactsData.getManager();
                    }
                    charParameter.setValue(str);
                }
                parameterSlotArr2[0] = charParameter;
                parameterSlotArr2[1] = contactInfoSlotWrapper.b(contactsData);
                list = CollectionsKt__CollectionsKt.listOfNotNull((Object[]) parameterSlotArr2);
            }
            slot.setParameters(list);
        }
    }

    public static final TypedError access$relateContactsDataErrors(ContactInfoSlotWrapper contactInfoSlotWrapper, TypedError typedError) {
        if (contactInfoSlotWrapper.getSlot().getParameters().isEmpty()) {
            return typedError;
        }
        if (typedError instanceof TypedError.ErrorMap) {
            return contactInfoSlotWrapper.c(((TypedError.ErrorMap) typedError).getMessages());
        }
        if (!(typedError instanceof TypedError.PretendError)) {
            return typedError;
        }
        Map<String, String> linkedHashMap = new LinkedHashMap<>();
        for (Map.Entry<String, PretendErrorValue> entry : ((TypedError.PretendError) typedError).getPretendResult().getErrors().entrySet()) {
            String singleMessage = entry.getValue().getSingleMessage();
            if (singleMessage != null) {
                linkedHashMap.put(entry.getKey(), singleMessage);
            }
        }
        return contactInfoSlotWrapper.c(linkedHashMap);
    }

    public final Observable<LoadingState<SuccessResult>> a() {
        String str;
        T t;
        ContactsData contactsData = this.e.getContactsData();
        boolean isCompany = contactsData != null ? contactsData.isCompany() : false;
        ProfileApi profileApi = this.f;
        Iterator<T> it = getSlot().getParameters().iterator();
        while (true) {
            str = null;
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            if (t instanceof PhoneParameter) {
                break;
            }
        }
        T t2 = t;
        if (t2 != null) {
            str = (String) t2.getValue();
        }
        if (str == null) {
            str = "";
        }
        Observable<R> onErrorReturn = profileApi.checkPhoneNumber(str, isCompany).map(b.a).onErrorReturn(new c(this));
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "profileApi.checkPhoneNum…rCase(it, specialCase)) }");
        return onErrorReturn;
    }

    public final PhoneParameter b(ContactsData contactsData) {
        String str;
        PhoneParameter phoneField = ((ContactInfoSlotConfig) a2.b.a.a.a.C1(this)).getPhoneField();
        ContactInfoSlotValue value = getSlot().getValue();
        if (value == null || (str = value.getPhone()) == null) {
            str = contactsData.getPhone();
        }
        phoneField.setValue(str);
        return phoneField;
    }

    public final TypedError c(Map<String, String> map) {
        Map mutableMap = r.toMutableMap(map);
        for (ParameterSlot parameterSlot : getSlot().getParameters()) {
            if (map.get(parameterSlot.getId()) != null && (parameterSlot instanceof HasError)) {
                ((HasError) parameterSlot).setError(map.get(parameterSlot.getId()));
                mutableMap.remove(parameterSlot.getId());
            }
        }
        return new TypedError.ErrorMap(mutableMap);
    }

    @Override // com.avito.android.publish.slots.SlotWrapper
    @NotNull
    public io.reactivex.Observable<LoadingState<SuccessResult>> checkErrors() {
        Observable<LoadingState<SuccessResult>> observable;
        if (this.a) {
            observable = this.h.session().firstOrError().flatMapObservable(new a2.a.a.e2.d0.e.d(this)).observeOn(this.l.io()).flatMap(new a2.a.a.e2.d0.e.e(this)).onErrorReturn(new a2.a.a.e2.d0.e.f(this));
            Intrinsics.checkNotNullExpressionValue(observable, "accountStorageInteractor…rt(it))\n                }");
        } else {
            observable = a();
        }
        Observable<R> map = observable.map(new a(this));
        Intrinsics.checkNotNullExpressionValue(map, "buildCheckObservable()\n …          }\n            }");
        return InteropKt.toV2(map);
    }

    @Override // com.avito.android.publish.slots.SlotWrapper
    @NotNull
    public ConsumeValueChangeResult consumeItemValueChange(@Nullable Item item, @Nullable ParameterSlot parameterSlot) {
        T t;
        T t2;
        String str = null;
        AttributedText attributedText = null;
        if (parameterSlot instanceof AnonymousNumberSlot) {
            AnonymousNumberSlotValue value = ((AnonymousNumberSlot) parameterSlot).getValue();
            boolean required = value != null ? value.getRequired() : false;
            Iterator<T> it = getSlot().getParameters().iterator();
            while (true) {
                if (!it.hasNext()) {
                    t2 = null;
                    break;
                }
                t2 = it.next();
                if (t2 instanceof PhoneParameter) {
                    break;
                }
            }
            Objects.requireNonNull(t2, "null cannot be cast to non-null type com.avito.android.remote.model.category_parameters.PhoneParameter");
            T t3 = t2;
            if (required) {
                attributedText = getSlot().getMotivation();
            }
            t3.setMotivation(attributedText);
            return new ConsumeValueChangeResult.NeedViewUpdate(SlotType.CONTACT_INFO);
        } else if (!(item instanceof InputItem)) {
            return ConsumeValueChangeResult.NoChange.INSTANCE;
        } else {
            Iterator<T> it2 = getSlot().getParameters().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    t = null;
                    break;
                }
                t = it2.next();
                if (Intrinsics.areEqual(t.getId(), item.getStringId())) {
                    break;
                }
            }
            if (!(t instanceof EditableParameter)) {
                t = null;
            }
            T t4 = t;
            if (t4 == null) {
                return ConsumeValueChangeResult.NoChange.INSTANCE;
            }
            t4.setError(null);
            String value2 = ((InputItem) item).getValue();
            if (value2 == null) {
                value2 = "";
            }
            String stringId = item.getStringId();
            if (Intrinsics.areEqual(stringId, ((ContactInfoSlotConfig) a2.b.a.a.a.C1(this)).getPhoneField().getId())) {
                String format = this.i.format(value2);
                ContactsData contactsData = this.e.getContactsData();
                if (contactsData != null) {
                    contactsData.setPhone(format);
                }
                t4.setValue(format);
            } else if (Intrinsics.areEqual(stringId, ((ContactInfoSlotConfig) a2.b.a.a.a.C1(this)).getManagerField().getId())) {
                ContactsData contactsData2 = this.e.getContactsData();
                if (contactsData2 != null) {
                    contactsData2.setManager(value2);
                }
                t4.setValue(value2);
            } else {
                EmailParameter emailField = ((ContactInfoSlotConfig) a2.b.a.a.a.C1(this)).getEmailField();
                if (Intrinsics.areEqual(stringId, emailField != null ? emailField.getId() : null)) {
                    ContactsData contactsData3 = this.e.getContactsData();
                    if (contactsData3 != null) {
                        contactsData3.setEmail(value2);
                    }
                    t4.setValue(value2);
                } else {
                    CharParameter nameField = ((ContactInfoSlotConfig) a2.b.a.a.a.C1(this)).getNameField();
                    if (nameField != null) {
                        str = nameField.getId();
                    }
                    if (Intrinsics.areEqual(stringId, str)) {
                        ContactsData contactsData4 = this.e.getContactsData();
                        if (contactsData4 != null) {
                            contactsData4.setName(value2);
                        }
                        t4.setValue(value2);
                    }
                }
            }
            return new ConsumeValueChangeResult.NeedViewUpdate(SlotType.CONTACT_INFO);
        }
    }

    @Override // com.avito.android.category_parameters.SlotElementsProvider
    @NotNull
    public List<Item> getElements() {
        return SlotWrapper.DefaultImpls.getElements(this);
    }

    @Override // com.avito.android.category_parameters.SlotElementsProvider
    @NotNull
    public String getId() {
        return getSlot().getId();
    }

    @Override // com.avito.android.publish.slots.SlotWrapper
    @NotNull
    public io.reactivex.Observable<LoadingState<Unit>> prepare() {
        f fVar = new f(this);
        io.reactivex.Observable<LoadingState<Unit>> doOnComplete = this.e.prepareContactsData(fVar).doOnComplete(new e(this));
        if (this.j && getSlot().getValue() != null) {
            doOnComplete = doOnComplete.onErrorReturn(new d(this, fVar));
        }
        Intrinsics.checkNotNullExpressionValue(doOnComplete, "contactsDataRequest");
        return doOnComplete;
    }

    @Override // com.avito.android.publish.slots.SlotWrapper
    @NotNull
    public ContactInfoSlot getSlot() {
        return this.c;
    }
}
