package com.avito.android.contact_access;

import a2.a.a.h0.c;
import com.avito.android.contact_access.remote.ContactAccessApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.TypedError;
import com.avito.android.remote.model.ContactAccessService;
import com.avito.android.social.incomplete.IncompleteSocialInteractor;
import com.avito.android.util.LoadingState;
import com.avito.android.util.rx3.InteropKt;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u0012\u001a\u00020\u000f¢\u0006\u0004\b\u0013\u0010\u0014J\u001b\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/avito/android/contact_access/ContactAccessServiceInteractorImpl;", "Lcom/avito/android/contact_access/ContactAccessServiceInteractor;", "Lio/reactivex/Observable;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/remote/model/ContactAccessService;", "loadService", "()Lio/reactivex/Observable;", "Lcom/avito/android/social/incomplete/IncompleteSocialInteractor;", AuthSource.SEND_ABUSE, "Lcom/avito/android/social/incomplete/IncompleteSocialInteractor;", "incompleteSocialInteractor", "Lcom/avito/android/contact_access/remote/ContactAccessApi;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/contact_access/remote/ContactAccessApi;", "api", "Lcom/avito/android/contact_access/ContactAccessServiceArguments;", "c", "Lcom/avito/android/contact_access/ContactAccessServiceArguments;", "args", "<init>", "(Lcom/avito/android/social/incomplete/IncompleteSocialInteractor;Lcom/avito/android/contact_access/remote/ContactAccessApi;Lcom/avito/android/contact_access/ContactAccessServiceArguments;)V", "contact-access_release"}, k = 1, mv = {1, 4, 2})
public final class ContactAccessServiceInteractorImpl implements ContactAccessServiceInteractor {
    public final IncompleteSocialInteractor a;
    public final ContactAccessApi b;
    public final ContactAccessServiceArguments c;

    public static final class a<T, R> implements Function<Boolean, ObservableSource<? extends LoadingState<? super ContactAccessService>>> {
        public final /* synthetic */ ContactAccessServiceInteractorImpl a;

        public a(ContactAccessServiceInteractorImpl contactAccessServiceInteractorImpl) {
            this.a = contactAccessServiceInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ObservableSource<? extends LoadingState<? super ContactAccessService>> apply(Boolean bool) {
            Boolean bool2 = bool;
            Intrinsics.checkNotNullParameter(bool2, "isIncomplete");
            if (!bool2.booleanValue()) {
                return InteropKt.toV2(ContactAccessApi.DefaultImpls.getContactAccessService$default(this.a.b, this.a.c.getItemId(), this.a.c.getServiceId(), this.a.c.getExternalId(), false, 8, null)).map(c.a);
            }
            Observable just = Observable.just(new LoadingState.Error(new TypedError.UnauthorizedError()));
            Intrinsics.checkNotNullExpressionValue(just, "Observable.just(this)");
            return just;
        }
    }

    @Inject
    public ContactAccessServiceInteractorImpl(@NotNull IncompleteSocialInteractor incompleteSocialInteractor, @NotNull ContactAccessApi contactAccessApi, @NotNull ContactAccessServiceArguments contactAccessServiceArguments) {
        Intrinsics.checkNotNullParameter(incompleteSocialInteractor, "incompleteSocialInteractor");
        Intrinsics.checkNotNullParameter(contactAccessApi, "api");
        Intrinsics.checkNotNullParameter(contactAccessServiceArguments, "args");
        this.a = incompleteSocialInteractor;
        this.b = contactAccessApi;
        this.c = contactAccessServiceArguments;
    }

    @Override // com.avito.android.contact_access.ContactAccessServiceInteractor
    @NotNull
    public Observable<LoadingState<ContactAccessService>> loadService() {
        Observable<R> flatMap = this.a.checkIncompleteProfile().flatMap(new a(this));
        Intrinsics.checkNotNullExpressionValue(flatMap, "incompleteSocialInteract…          }\n            }");
        return flatMap;
    }
}
