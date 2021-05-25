package com.avito.android.abuse.details;

import a2.g.r.g;
import com.avito.android.abuse.details.adapter.AbuseField;
import com.avito.android.abuse.details.remote.AbuseApi;
import com.avito.android.account.AccountStorageInteractor;
import com.avito.android.remote.abuse.AbuseSendingResult;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Action;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.TypedObservablesKt;
import com.avito.android.util.rx3.InteropKt;
import com.avito.android.util.rx3.Observables;
import io.reactivex.Single;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.inject.Inject;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001BY\b\u0007\u0012\b\b\u0001\u0010!\u001a\u00020\u0013\u0012\b\b\u0001\u0010\u0017\u001a\u00020\u0010\u0012\n\b\u0001\u0010'\u001a\u0004\u0018\u00010\u0010\u0012\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u0002\u0012\u0006\u0010%\u001a\u00020\"\u0012\u0006\u0010/\u001a\u00020,\u0012\u0006\u0010+\u001a\u00020(\u0012\u0006\u0010\u001b\u001a\u00020\u0018¢\u0006\u0004\b0\u00101J)\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0007J\u001b\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u0010*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u0013*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002¢\u0006\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0017\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010!\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010'\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010\u0016R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.¨\u00062"}, d2 = {"Lcom/avito/android/abuse/details/AbuseDetailsInteractorImpl;", "Lcom/avito/android/abuse/details/AbuseDetailsInteractor;", "", "Lcom/avito/android/abuse/details/adapter/AbuseField;", "fields", "Lio/reactivex/rxjava3/core/Observable;", "sendAbuse", "(Ljava/util/List;)Lio/reactivex/rxjava3/core/Observable;", "", "verifyAbuse", "getFields", "()Lio/reactivex/rxjava3/core/Observable;", "Lio/reactivex/Single;", "", "isAuthorized", "()Lio/reactivex/Single;", "", AuthSource.SEND_ABUSE, "(Ljava/util/List;)Ljava/lang/String;", "", AuthSource.BOOKING_ORDER, "(Ljava/util/List;)Ljava/lang/Integer;", "Ljava/lang/String;", "itemId", "Lcom/avito/android/util/SchedulersFactory3;", "h", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/remote/model/Action;", "d", "Ljava/util/List;", "actions", "I", "categoryId", "Lcom/avito/android/abuse/details/remote/AbuseApi;", "e", "Lcom/avito/android/abuse/details/remote/AbuseApi;", "api", "c", "src", "Lcom/avito/android/abuse/details/AbuseDetailsResourceProvider;", g.a, "Lcom/avito/android/abuse/details/AbuseDetailsResourceProvider;", "resourceProvider", "Lcom/avito/android/account/AccountStorageInteractor;", "f", "Lcom/avito/android/account/AccountStorageInteractor;", "accountStorageInteractor", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/avito/android/abuse/details/remote/AbuseApi;Lcom/avito/android/account/AccountStorageInteractor;Lcom/avito/android/abuse/details/AbuseDetailsResourceProvider;Lcom/avito/android/util/SchedulersFactory3;)V", "abuse_release"}, k = 1, mv = {1, 4, 2})
public final class AbuseDetailsInteractorImpl implements AbuseDetailsInteractor {
    public final int a;
    public final String b;
    public final String c;
    public final List<Action> d;
    public final AbuseApi e;
    public final AccountStorageInteractor f;
    public final AbuseDetailsResourceProvider g;
    public final SchedulersFactory3 h;

    public static final class a<T, R> implements Function<TypedResult<AbuseSendingResult>, ObservableSource<? extends AbuseSendingResult>> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public ObservableSource<? extends AbuseSendingResult> apply(TypedResult<AbuseSendingResult> typedResult) {
            TypedResult<AbuseSendingResult> typedResult2 = typedResult;
            Intrinsics.checkNotNullExpressionValue(typedResult2, "it");
            return TypedObservablesKt.toTypedObservable3(typedResult2);
        }
    }

    public static final class b<T, R> implements Function<AbuseSendingResult, ObservableSource<? extends AbuseSendingResult.Success>> {
        public final /* synthetic */ AbuseDetailsInteractorImpl a;

        public b(AbuseDetailsInteractorImpl abuseDetailsInteractorImpl) {
            this.a = abuseDetailsInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public ObservableSource<? extends AbuseSendingResult.Success> apply(AbuseSendingResult abuseSendingResult) {
            AbuseSendingResult abuseSendingResult2 = abuseSendingResult;
            AbuseDetailsInteractorImpl abuseDetailsInteractorImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(abuseSendingResult2, "it");
            return AbuseDetailsInteractorImpl.access$toObservable(abuseDetailsInteractorImpl, abuseSendingResult2);
        }
    }

    public static final class c<T, R> implements Function<AbuseSendingResult.Success, List<? extends AbuseField>> {
        public final /* synthetic */ AbuseDetailsInteractorImpl a;

        public c(AbuseDetailsInteractorImpl abuseDetailsInteractorImpl) {
            this.a = abuseDetailsInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:16:0x005b */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Iterable] */
        /* JADX WARN: Type inference failed for: r1v1, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r1v2, types: [java.util.ArrayList] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // io.reactivex.rxjava3.functions.Function
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.util.List<? extends com.avito.android.abuse.details.adapter.AbuseField> apply(com.avito.android.remote.abuse.AbuseSendingResult.Success r9) {
            /*
                r8 = this;
                com.avito.android.remote.abuse.AbuseSendingResult$Success r9 = (com.avito.android.remote.abuse.AbuseSendingResult.Success) r9
                com.avito.android.abuse.details.AbuseDetailsInteractorImpl r0 = r8.a
                java.util.List r0 = com.avito.android.abuse.details.AbuseDetailsInteractorImpl.access$getActions$p(r0)
                if (r0 == 0) goto L_0x0057
                java.util.ArrayList r1 = new java.util.ArrayList
                r2 = 10
                int r2 = t6.n.e.collectionSizeOrDefault(r0, r2)
                r1.<init>(r2)
                r2 = 0
                java.util.Iterator r0 = r0.iterator()
            L_0x001a:
                boolean r3 = r0.hasNext()
                if (r3 == 0) goto L_0x005b
                java.lang.Object r3 = r0.next()
                int r4 = r2 + 1
                if (r2 >= 0) goto L_0x002b
                kotlin.collections.CollectionsKt__CollectionsKt.throwIndexOverflow()
            L_0x002b:
                com.avito.android.remote.model.Action r3 = (com.avito.android.remote.model.Action) r3
                com.avito.android.deep_linking.links.DeepLink r5 = r3.getDeepLink()
                boolean r5 = r5 instanceof com.avito.android.deep_linking.links.NoMatchLink
                if (r5 == 0) goto L_0x0044
                com.avito.android.abuse.details.adapter.AbuseField$SecondaryButton r5 = new com.avito.android.abuse.details.adapter.AbuseField$SecondaryButton
                long r6 = (long) r2
                java.lang.String r2 = r3.getTitle()
                com.avito.android.deep_linking.links.DeepLink r3 = r3.getDeepLink()
                r5.<init>(r6, r2, r3)
                goto L_0x0052
            L_0x0044:
                com.avito.android.abuse.details.adapter.AbuseField$PrimaryButton r5 = new com.avito.android.abuse.details.adapter.AbuseField$PrimaryButton
                long r6 = (long) r2
                java.lang.String r2 = r3.getTitle()
                com.avito.android.deep_linking.links.DeepLink r3 = r3.getDeepLink()
                r5.<init>(r6, r2, r3)
            L_0x0052:
                r1.add(r5)
                r2 = r4
                goto L_0x001a
            L_0x0057:
                java.util.List r1 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
            L_0x005b:
                com.avito.android.abuse.details.adapter.AbuseField$SendingSuccess r0 = new com.avito.android.abuse.details.adapter.AbuseField$SendingSuccess
                java.lang.String r2 = r9.getTitle()
                java.lang.String r9 = r9.getDescription()
                r0.<init>(r2, r9)
                java.util.List r9 = t6.n.d.listOf(r0)
                java.util.List r9 = kotlin.collections.CollectionsKt___CollectionsKt.plus(r9, r1)
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.avito.android.abuse.details.AbuseDetailsInteractorImpl.c.apply(java.lang.Object):java.lang.Object");
        }
    }

    public static final class d<T, R> implements Function<TypedResult<AbuseSendingResult>, ObservableSource<? extends AbuseSendingResult>> {
        public static final d a = new d();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public ObservableSource<? extends AbuseSendingResult> apply(TypedResult<AbuseSendingResult> typedResult) {
            TypedResult<AbuseSendingResult> typedResult2 = typedResult;
            Intrinsics.checkNotNullExpressionValue(typedResult2, "it");
            return TypedObservablesKt.toTypedObservable3(typedResult2);
        }
    }

    public static final class e<T, R> implements Function<AbuseSendingResult, ObservableSource<? extends AbuseSendingResult.Success>> {
        public final /* synthetic */ AbuseDetailsInteractorImpl a;

        public e(AbuseDetailsInteractorImpl abuseDetailsInteractorImpl) {
            this.a = abuseDetailsInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public ObservableSource<? extends AbuseSendingResult.Success> apply(AbuseSendingResult abuseSendingResult) {
            AbuseSendingResult abuseSendingResult2 = abuseSendingResult;
            AbuseDetailsInteractorImpl abuseDetailsInteractorImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(abuseSendingResult2, "it");
            return AbuseDetailsInteractorImpl.access$toObservable(abuseDetailsInteractorImpl, abuseSendingResult2);
        }
    }

    public static final class f<T, R> implements Function<AbuseSendingResult.Success, Unit> {
        public static final f a = new f();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public Unit apply(AbuseSendingResult.Success success) {
            return Unit.INSTANCE;
        }
    }

    @Inject
    public AbuseDetailsInteractorImpl(@Named("category_id") int i, @Named("item_id") @NotNull String str, @Named("src") @Nullable String str2, @Nullable List<Action> list, @NotNull AbuseApi abuseApi, @NotNull AccountStorageInteractor accountStorageInteractor, @NotNull AbuseDetailsResourceProvider abuseDetailsResourceProvider, @NotNull SchedulersFactory3 schedulersFactory3) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        Intrinsics.checkNotNullParameter(abuseApi, "api");
        Intrinsics.checkNotNullParameter(accountStorageInteractor, "accountStorageInteractor");
        Intrinsics.checkNotNullParameter(abuseDetailsResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        this.a = i;
        this.b = str;
        this.c = str2;
        this.d = list;
        this.e = abuseApi;
        this.f = accountStorageInteractor;
        this.g = abuseDetailsResourceProvider;
        this.h = schedulersFactory3;
    }

    public static final Observable access$toObservable(AbuseDetailsInteractorImpl abuseDetailsInteractorImpl, AbuseSendingResult abuseSendingResult) {
        long j;
        Objects.requireNonNull(abuseDetailsInteractorImpl);
        if (abuseSendingResult instanceof AbuseSendingResult.Success) {
            Observable just = Observable.just(abuseSendingResult);
            Intrinsics.checkNotNullExpressionValue(just, "Observable.just(this)");
            return just;
        } else if (abuseSendingResult instanceof AbuseSendingResult.IncorrectData) {
            Map<String, String> messages = ((AbuseSendingResult.IncorrectData) abuseSendingResult).getMessages();
            ArrayList arrayList = new ArrayList(messages.size());
            for (Map.Entry<String, String> entry : messages.entrySet()) {
                String key = entry.getKey();
                int hashCode = key.hashCode();
                if (hashCode != -1624760229) {
                    if (hashCode == 950398559 && key.equals(AbuseSendingResult.COMMENT)) {
                        j = 0;
                        arrayList.add(TuplesKt.to(Long.valueOf(j), entry.getValue()));
                    }
                } else if (key.equals(AbuseSendingResult.EMOTION)) {
                    j = 1;
                    arrayList.add(TuplesKt.to(Long.valueOf(j), entry.getValue()));
                }
                j = -1;
                arrayList.add(TuplesKt.to(Long.valueOf(j), entry.getValue()));
            }
            return Observables.toObservable(new IncorrectDataException(r.toMap(arrayList)));
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    public final String a(List<? extends AbuseField> list) {
        T t;
        boolean z;
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            if (t.getId() == 0) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                break;
            }
        }
        if (!(t instanceof AbuseField.Comment)) {
            t = null;
        }
        T t2 = t;
        if (t2 != null) {
            return t2.getMessage();
        }
        return null;
    }

    public final Integer b(List<? extends AbuseField> list) {
        T t;
        Integer value;
        boolean z;
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            if (t.getId() == 1) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                break;
            }
        }
        if (!(t instanceof AbuseField.Emotion)) {
            t = null;
        }
        T t2 = t;
        if (t2 == null || (value = t2.getValue()) == null) {
            return null;
        }
        return Integer.valueOf(value.intValue() + 1);
    }

    @Override // com.avito.android.abuse.details.AbuseDetailsInteractor
    @NotNull
    public Observable<List<AbuseField>> getFields() {
        Observable<List<AbuseField>> just = Observable.just(CollectionsKt__CollectionsKt.listOf((Object[]) new AbuseField[]{new AbuseField.Comment(0, null, this.g.getCommentHint(), 2, null), new AbuseField.Emotion(1, null, this.g.getEmotionHint(), 2, null)}));
        Intrinsics.checkNotNullExpressionValue(just, "Observable.just(this)");
        return just;
    }

    @Override // com.avito.android.abuse.details.AbuseDetailsInteractor
    @NotNull
    public Single<Boolean> isAuthorized() {
        return InteropKt.toV2(this.f.currentAuthorized());
    }

    @Override // com.avito.android.abuse.details.AbuseDetailsInteractor
    @NotNull
    public Observable<List<AbuseField>> sendAbuse(@NotNull List<? extends AbuseField> list) {
        Intrinsics.checkNotNullParameter(list, "fields");
        Observable<R> map = this.e.sendAbuse(this.a, this.b, this.c, a(list), b(list), Boolean.FALSE).subscribeOn(this.h.io()).flatMap(a.a).flatMap(new b(this)).map(new c(this));
        Intrinsics.checkNotNullExpressionValue(map, "api.sendAbuse(\n         …) + buttons\n            }");
        return map;
    }

    @Override // com.avito.android.abuse.details.AbuseDetailsInteractor
    @NotNull
    public Observable<Unit> verifyAbuse(@NotNull List<? extends AbuseField> list) {
        Intrinsics.checkNotNullParameter(list, "fields");
        Observable<R> map = this.e.sendAbuse(this.a, this.b, this.c, a(list), b(list), Boolean.TRUE).subscribeOn(this.h.io()).flatMap(d.a).flatMap(new e(this)).map(f.a);
        Intrinsics.checkNotNullExpressionValue(map, "api.sendAbuse(\n         …            .map { Unit }");
        return map;
    }
}
