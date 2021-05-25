package a2.a.a.b.a;

import com.avito.android.account.Credentials;
import com.avito.android.authorization.event.SmartLockAccountFoundEvent;
import com.avito.android.authorization.smart_lock.SmartLockLoaderImpl;
import com.avito.android.smartlock.R;
import com.avito.android.util.DialogRouter;
import com.google.android.gms.auth.api.credentials.Credential;
import io.reactivex.rxjava3.core.MaybeEmitter;
import io.reactivex.rxjava3.core.MaybeOnSubscribe;
import io.reactivex.rxjava3.functions.Cancellable;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
public final class a<T> implements MaybeOnSubscribe<Credentials.PasswordCredentials> {
    public final /* synthetic */ SmartLockLoaderImpl a;
    public final /* synthetic */ Credential b;

    /* compiled from: kotlin-style lambda group */
    /* renamed from: a2.a.a.b.a.a$a  reason: collision with other inner class name */
    public static final class C0001a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;
        public final /* synthetic */ Object c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0001a(int i, Object obj, Object obj2) {
            super(0);
            this.a = i;
            this.b = obj;
            this.c = obj2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Multi-variable search result rejected for r0v6, resolved type: io.reactivex.rxjava3.core.MaybeEmitter */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            int i = this.a;
            if (i == 0) {
                ((a) this.b).a.c.track(new SmartLockAccountFoundEvent());
                a aVar = (a) this.b;
                ((MaybeEmitter) this.c).onSuccess(aVar.a.b(aVar.b));
                return Unit.INSTANCE;
            } else if (i == 1) {
                T t = ((Ref.ObjectRef) this.b).element;
                if (t != null) {
                    t.hide();
                }
                ((MaybeEmitter) this.c).onComplete();
                return Unit.INSTANCE;
            } else {
                throw null;
            }
        }
    }

    public static final class b implements Cancellable {
        public final /* synthetic */ Ref.ObjectRef a;

        public b(Ref.ObjectRef objectRef) {
            this.a = objectRef;
        }

        @Override // io.reactivex.rxjava3.functions.Cancellable
        public final void cancel() {
            this.a.element.dismiss();
        }
    }

    public a(SmartLockLoaderImpl smartLockLoaderImpl, Credential credential) {
        this.a = smartLockLoaderImpl;
        this.b = credential;
    }

    @Override // io.reactivex.rxjava3.core.MaybeOnSubscribe
    public final void subscribe(MaybeEmitter<Credentials.PasswordCredentials> maybeEmitter) {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = null;
        DialogRouter dialogRouter = this.a.d;
        String string = this.a.e.getString(R.string.sign_in_dialog_title, this.b.getId());
        String string2 = this.a.e.getString(R.string.sign_in_dialog_accept_button);
        Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.stri…_in_dialog_accept_button)");
        C0001a aVar = new C0001a(0, this, maybeEmitter);
        String string3 = this.a.e.getString(com.avito.android.ui_components.R.string.cancel);
        Intrinsics.checkNotNullExpressionValue(string3, "context.getString(ui_R.string.cancel)");
        objectRef.element = (T) DialogRouter.DefaultImpls.showCancelableNotifyingDialog$default(dialogRouter, string, false, null, string3, new C0001a(1, objectRef, maybeEmitter), string2, aVar, 6, null);
        maybeEmitter.setCancellable(new b(objectRef));
    }
}
