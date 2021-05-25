package com.avito.android.code_confirmation;

import a2.a.a.e0.j;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Logs;
import com.google.android.gms.auth.api.phone.SmsRetriever;
import com.google.android.gms.auth.api.phone.SmsRetrieverClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Cancellable;
import io.reactivex.functions.Function;
import io.reactivex.subjects.PublishSubject;
import java.util.Iterator;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.StringsKt___StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B!\b\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u0012\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\f\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\f\u0010\rR\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001e"}, d2 = {"Lcom/avito/android/code_confirmation/CodeReceiverImpl;", "Landroid/content/BroadcastReceiver;", "Lcom/avito/android/code_confirmation/CodeReceiver;", "Lio/reactivex/Observable;", "", "connect", "()Lio/reactivex/Observable;", "Landroid/content/Context;", "restrictedContext", "Landroid/content/Intent;", "incomingIntent", "", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "Lio/reactivex/subjects/PublishSubject;", AuthSource.SEND_ABUSE, "Lio/reactivex/subjects/PublishSubject;", "codeReceived", "Landroid/app/Activity;", AuthSource.BOOKING_ORDER, "Landroid/app/Activity;", "activity", "Landroid/content/IntentFilter;", "c", "Landroid/content/IntentFilter;", "intentFilter", "Lcom/google/android/gms/auth/api/phone/SmsRetrieverClient;", "smsRetrieverClient", "<init>", "(Landroid/app/Activity;Landroid/content/IntentFilter;Lcom/google/android/gms/auth/api/phone/SmsRetrieverClient;)V", "code-confirmation_release"}, k = 1, mv = {1, 4, 2})
public final class CodeReceiverImpl extends BroadcastReceiver implements CodeReceiver {
    public final PublishSubject<String> a;
    public final Activity b;
    public final IntentFilter c;

    public static final class a<TResult> implements OnCompleteListener<Void> {
        public static final a a = new a();

        @Override // com.google.android.gms.tasks.OnCompleteListener
        public final void onComplete(@NotNull Task<Void> task) {
            Intrinsics.checkNotNullParameter(task, "it");
            Logs.info$default("CodeReceiver", "Sms retriever started", null, 4, null);
        }
    }

    public static final class b implements OnFailureListener {
        public static final b a = new b();

        @Override // com.google.android.gms.tasks.OnFailureListener
        public final void onFailure(@NotNull Exception exc) {
            Intrinsics.checkNotNullParameter(exc, "it");
            Logs.error$default("CodeReceiver", "Failed to start sms retriever", null, 4, null);
        }
    }

    public static final class c<T> implements ObservableOnSubscribe<Unit> {
        public final /* synthetic */ CodeReceiverImpl a;

        public static final class a implements Cancellable {
            public final /* synthetic */ c a;

            public a(c cVar) {
                this.a = cVar;
            }

            @Override // io.reactivex.functions.Cancellable
            public final void cancel() {
                CodeReceiverImpl.access$stop(this.a.a);
            }
        }

        public c(CodeReceiverImpl codeReceiverImpl) {
            this.a = codeReceiverImpl;
        }

        @Override // io.reactivex.ObservableOnSubscribe
        public final void subscribe(@NotNull ObservableEmitter<Unit> observableEmitter) {
            Intrinsics.checkNotNullParameter(observableEmitter, "emitter");
            CodeReceiverImpl.access$start(this.a);
            observableEmitter.onNext(Unit.INSTANCE);
            observableEmitter.setCancellable(new a(this));
        }
    }

    public static final class d<T, R> implements Function<Unit, ObservableSource<? extends String>> {
        public final /* synthetic */ CodeReceiverImpl a;

        public d(CodeReceiverImpl codeReceiverImpl) {
            this.a = codeReceiverImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ObservableSource<? extends String> apply(Unit unit) {
            Intrinsics.checkNotNullParameter(unit, "it");
            return this.a.a.filter(j.a);
        }
    }

    @Inject
    public CodeReceiverImpl(@NotNull Activity activity, @NotNull IntentFilter intentFilter, @NotNull SmsRetrieverClient smsRetrieverClient) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(intentFilter, "intentFilter");
        Intrinsics.checkNotNullParameter(smsRetrieverClient, "smsRetrieverClient");
        this.b = activity;
        this.c = intentFilter;
        PublishSubject<String> create = PublishSubject.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishSubject.create()");
        this.a = create;
        smsRetrieverClient.startSmsRetriever().addOnCompleteListener(a.a).addOnFailureListener(b.a);
    }

    public static final void access$start(CodeReceiverImpl codeReceiverImpl) {
        codeReceiverImpl.b.registerReceiver(codeReceiverImpl, codeReceiverImpl.c);
    }

    public static final void access$stop(CodeReceiverImpl codeReceiverImpl) {
        codeReceiverImpl.b.unregisterReceiver(codeReceiverImpl);
    }

    @Override // com.avito.android.code_confirmation.CodeReceiver
    @NotNull
    public Observable<String> connect() {
        Observable<String> flatMap = Observable.create(new c(this)).flatMap(new d(this));
        Intrinsics.checkNotNullExpressionValue(flatMap, "Observable.create { emit…ter { it.isNotEmpty() } }");
        return flatMap;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(@Nullable Context context, @Nullable Intent intent) {
        Object obj;
        if (Intrinsics.areEqual(SmsRetriever.SMS_RETRIEVED_ACTION, intent != null ? intent.getAction() : null)) {
            Bundle extras = intent.getExtras();
            if (extras == null) {
                extras = new Bundle(0);
            }
            Object obj2 = extras.get("com.google.android.gms.auth.api.phone.EXTRA_STATUS");
            Objects.requireNonNull(obj2, "null cannot be cast to non-null type com.google.android.gms.common.api.Status");
            Status status = (Status) obj2;
            int statusCode = status.getStatusCode();
            if (statusCode == 0) {
                Object obj3 = extras.get(SmsRetriever.EXTRA_SMS_MESSAGE);
                Objects.requireNonNull(obj3, "null cannot be cast to non-null type kotlin.String");
                String str = (String) obj3;
                Iterator it = StringsKt__StringsKt.split$default((CharSequence) str, new String[]{" "}, false, 0, 6, (Object) null).iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it.next();
                    if (Character.isDigit(StringsKt___StringsKt.first((String) obj))) {
                        break;
                    }
                }
                String str2 = (String) obj;
                if (str2 != null) {
                    this.a.onNext(str2);
                } else {
                    Logs.error$default("CodeReceiver", a2.b.a.a.a.c3("Unable to get verification code from ", str), null, 4, null);
                }
            } else if (statusCode != 15) {
                Logs.error$default("CodeReceiver", "Unknown status " + status + " while waiting verification code", null, 4, null);
            } else {
                Logs.warning$default("CodeReceiver", "Timed out waiting while waiting verification code", null, 4, null);
            }
        }
    }
}
