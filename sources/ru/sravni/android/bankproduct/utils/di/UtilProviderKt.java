package ru.sravni.android.bankproduct.utils.di;

import a7.c.a.a.r.c.b;
import a7.c.a.a.r.c.c;
import a7.c.a.a.r.c.d;
import a7.c.a.a.r.c.e;
import a7.c.a.a.r.c.f;
import a7.c.a.a.r.c.g;
import a7.c.a.a.r.c.h;
import a7.c.a.a.r.c.i;
import a7.c.a.a.r.c.j;
import a7.c.a.a.r.c.k;
import a7.c.a.a.r.c.l;
import a7.c.a.a.r.c.m;
import a7.c.a.a.r.c.n;
import a7.c.a.a.r.c.o;
import a7.c.a.a.r.c.p;
import a7.c.a.a.r.c.q;
import a7.c.a.a.r.c.r;
import a7.c.a.a.r.c.s;
import a7.c.a.a.r.c.t;
import a7.c.a.a.r.c.u;
import a7.c.a.a.r.c.v;
import a7.c.a.a.r.c.w;
import a7.c.a.a.r.c.x;
import a7.c.a.a.r.c.y;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.kodein.di.Kodein;
import org.kodein.di.TypesKt;
import org.kodein.di.bindings.Multiton;
import org.kodein.di.bindings.Provider;
import org.kodein.di.bindings.Singleton;
import ru.sravni.android.bankproduct.analytic.v2.BaseAnalyticKt;
import ru.sravni.android.bankproduct.domain.DomainErrorDescriptionMapper;
import ru.sravni.android.bankproduct.domain.sravnierror.IThrowableErrorDescriptionMapper;
import ru.sravni.android.bankproduct.domain.sravnierror.ThrowableWrapper;
import ru.sravni.android.bankproduct.domain.sravnierror.UnsupportErrorDescriptionMapper;
import ru.sravni.android.bankproduct.network.NetworkErrorDescriptionMapper;
import ru.sravni.android.bankproduct.presentation.auth.phone.PresentationProfilePhoneErrorDescriptionMapper;
import ru.sravni.android.bankproduct.presentation.auth.sms.PresentationProfileSmsErrorDescriptionMapper;
import ru.sravni.android.bankproduct.presentation.bottomnavigation.PresentationBottomNavivationErrorDescriptionMapper;
import ru.sravni.android.bankproduct.presentation.chat.PresentationChatErrorDescriptionMapper;
import ru.sravni.android.bankproduct.presentation.main.PresentationMainErrorDescriptionMapper;
import ru.sravni.android.bankproduct.presentation.offer.PresentationOfferErrorDescriptionMapper;
import ru.sravni.android.bankproduct.presentation.splash.PresentationSplashErrorDescriptionMapper;
import ru.sravni.android.bankproduct.repository.RepositoryErrorDescriptionMapper;
import ru.sravni.android.bankproduct.repository.token.TokenErrorDescriptionMapper;
import ru.sravni.android.bankproduct.storage.StorageErrorDescriptionMapper;
import ru.sravni.android.bankproduct.utils.error.UtilErrorDescriptionMapper;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0015\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004\"\u0019\u0010\n\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"", "key", "Lru/sravni/android/bankproduct/domain/sravnierror/ThrowableWrapper;", "throwableWrapperFactoryMethod", "(Ljava/lang/String;)Lru/sravni/android/bankproduct/domain/sravnierror/ThrowableWrapper;", "Lorg/kodein/di/Kodein$Module;", AuthSource.SEND_ABUSE, "Lorg/kodein/di/Kodein$Module;", "getUtilKodeinModule", "()Lorg/kodein/di/Kodein$Module;", "utilKodeinModule", "sravnichat_release"}, k = 2, mv = {1, 4, 0})
public final class UtilProviderKt {
    @NotNull
    public static final Kodein.Module a = new Kodein.Module("utilKodeinModule", false, null, a.a, 6, null);

    public static final class a extends Lambda implements Function1<Kodein.Builder, Unit> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Kodein.Builder builder) {
            Kodein.Builder builder2 = builder;
            Intrinsics.checkParameterIsNotNull(builder2, "$receiver");
            Kodein.Builder.DefaultImpls.constant$default(builder2, "permissionRequestCode", null, 2, null).With(TypesKt.TT(new UtilProviderKt$utilKodeinModule$1$$special$$inlined$with$1()), 10001);
            builder2.Bind(TypesKt.TT(new UtilProviderKt$utilKodeinModule$1$$special$$inlined$bind$1()), null, null).with(new Singleton(builder2.getScope(), builder2.getContextType(), TypesKt.TT(new UtilProviderKt$utilKodeinModule$1$$special$$inlined$singleton$1()), null, true, k.a));
            builder2.Bind(TypesKt.TT(new UtilProviderKt$utilKodeinModule$1$$special$$inlined$bind$2()), "appRequiredPermission", null).with(new Singleton(builder2.getScope(), builder2.getContextType(), TypesKt.TT(new UtilProviderKt$utilKodeinModule$1$$special$$inlined$singleton$2()), null, true, q.a));
            builder2.Bind(TypesKt.TT(new UtilProviderKt$utilKodeinModule$1$$special$$inlined$bind$3()), null, null).with(new Singleton(builder2.getScope(), builder2.getContextType(), TypesKt.TT(new UtilProviderKt$utilKodeinModule$1$$special$$inlined$singleton$3()), null, true, s.a));
            builder2.Bind(TypesKt.TT(new UtilProviderKt$utilKodeinModule$1$$special$$inlined$bind$4()), null, null).with(new Singleton(builder2.getScope(), builder2.getContextType(), TypesKt.TT(new UtilProviderKt$utilKodeinModule$1$$special$$inlined$singleton$4()), null, true, t.a));
            builder2.Bind(TypesKt.TT(new UtilProviderKt$utilKodeinModule$1$$special$$inlined$bind$5()), null, null).with(new Provider(builder2.getContextType(), TypesKt.TT(new UtilProviderKt$utilKodeinModule$1$$special$$inlined$provider$1()), u.a));
            builder2.Bind(TypesKt.TT(new UtilProviderKt$utilKodeinModule$1$$special$$inlined$bind$6()), null, null).with(new Singleton(builder2.getScope(), builder2.getContextType(), TypesKt.TT(new UtilProviderKt$utilKodeinModule$1$$special$$inlined$singleton$5()), null, true, v.a));
            builder2.Bind(TypesKt.TT(new UtilProviderKt$utilKodeinModule$1$$special$$inlined$bind$7()), null, null).with(new Singleton(builder2.getScope(), builder2.getContextType(), TypesKt.TT(new UtilProviderKt$utilKodeinModule$1$$special$$inlined$singleton$6()), null, true, w.a));
            builder2.Bind(TypesKt.TT(new UtilProviderKt$utilKodeinModule$1$$special$$inlined$bind$8()), null, null).with(new Singleton(builder2.getScope(), builder2.getContextType(), TypesKt.TT(new UtilProviderKt$utilKodeinModule$1$$special$$inlined$singleton$7()), null, true, x.a));
            builder2.Bind(TypesKt.TT(new UtilProviderKt$utilKodeinModule$1$$special$$inlined$bind$9()), null, null).with(new Singleton(builder2.getScope(), builder2.getContextType(), TypesKt.TT(new UtilProviderKt$utilKodeinModule$1$$special$$inlined$singleton$8()), null, true, y.a));
            builder2.Bind(TypesKt.TT(new UtilProviderKt$utilKodeinModule$1$$special$$inlined$bind$10()), null, null).with(new Singleton(builder2.getScope(), builder2.getContextType(), TypesKt.TT(new UtilProviderKt$utilKodeinModule$1$$special$$inlined$singleton$9()), null, true, a7.c.a.a.r.c.a.a));
            builder2.Bind(TypesKt.TT(new UtilProviderKt$utilKodeinModule$1$$special$$inlined$bind$11()), null, null).with(new Multiton(builder2.getScope(), builder2.getContextType(), TypesKt.TT(new UtilProviderKt$utilKodeinModule$1$$special$$inlined$multiton$1()), TypesKt.TT(new UtilProviderKt$utilKodeinModule$1$$special$$inlined$multiton$2()), null, true, b.a));
            builder2.Bind(TypesKt.TT(new UtilProviderKt$utilKodeinModule$1$$special$$inlined$bind$12()), null, null).with(new Provider(builder2.getContextType(), TypesKt.TT(new UtilProviderKt$utilKodeinModule$1$$special$$inlined$provider$2()), c.a));
            builder2.Bind(TypesKt.TT(new UtilProviderKt$utilKodeinModule$1$$special$$inlined$bind$13()), null, null).with(new Provider(builder2.getContextType(), TypesKt.TT(new UtilProviderKt$utilKodeinModule$1$$special$$inlined$provider$3()), d.a));
            builder2.Bind(TypesKt.TT(new UtilProviderKt$utilKodeinModule$1$$special$$inlined$bind$14()), null, null).with(new Provider(builder2.getContextType(), TypesKt.TT(new UtilProviderKt$utilKodeinModule$1$$special$$inlined$provider$4()), e.a));
            builder2.Bind(TypesKt.TT(new UtilProviderKt$utilKodeinModule$1$$special$$inlined$bind$15()), null, null).with(new Provider(builder2.getContextType(), TypesKt.TT(new UtilProviderKt$utilKodeinModule$1$$special$$inlined$provider$5()), f.a));
            builder2.Bind(TypesKt.TT(new UtilProviderKt$utilKodeinModule$1$$special$$inlined$bind$16()), null, null).with(new Provider(builder2.getContextType(), TypesKt.TT(new UtilProviderKt$utilKodeinModule$1$$special$$inlined$provider$6()), g.a));
            builder2.Bind(TypesKt.TT(new UtilProviderKt$utilKodeinModule$1$$special$$inlined$bind$17()), null, null).with(new Provider(builder2.getContextType(), TypesKt.TT(new UtilProviderKt$utilKodeinModule$1$$special$$inlined$provider$7()), h.a));
            builder2.Bind(TypesKt.TT(new UtilProviderKt$utilKodeinModule$1$$special$$inlined$bind$18()), null, null).with(new Provider(builder2.getContextType(), TypesKt.TT(new UtilProviderKt$utilKodeinModule$1$$special$$inlined$provider$8()), i.a));
            builder2.Bind(TypesKt.TT(new UtilProviderKt$utilKodeinModule$1$$special$$inlined$bind$19()), null, null).with(new Provider(builder2.getContextType(), TypesKt.TT(new UtilProviderKt$utilKodeinModule$1$$special$$inlined$provider$9()), j.a));
            builder2.Bind(TypesKt.TT(new UtilProviderKt$utilKodeinModule$1$$special$$inlined$bind$20()), null, null).with(new Provider(builder2.getContextType(), TypesKt.TT(new UtilProviderKt$utilKodeinModule$1$$special$$inlined$provider$10()), l.a));
            builder2.Bind(TypesKt.TT(new UtilProviderKt$utilKodeinModule$1$$special$$inlined$bind$21()), null, null).with(new Singleton(builder2.getScope(), builder2.getContextType(), TypesKt.TT(new UtilProviderKt$utilKodeinModule$1$$special$$inlined$singleton$10()), null, true, m.a));
            builder2.Bind(TypesKt.TT(new UtilProviderKt$utilKodeinModule$1$$special$$inlined$bind$22()), null, null).with(new Provider(builder2.getContextType(), TypesKt.TT(new UtilProviderKt$utilKodeinModule$1$$special$$inlined$provider$11()), n.a));
            builder2.Bind(TypesKt.TT(new UtilProviderKt$utilKodeinModule$1$$special$$inlined$bind$23()), null, null).with(new Provider(builder2.getContextType(), TypesKt.TT(new UtilProviderKt$utilKodeinModule$1$$special$$inlined$provider$12()), o.a));
            builder2.Bind(TypesKt.TT(new UtilProviderKt$utilKodeinModule$1$$special$$inlined$bind$24()), null, null).with(new Provider(builder2.getContextType(), TypesKt.TT(new UtilProviderKt$utilKodeinModule$1$$special$$inlined$provider$13()), y4.b));
            builder2.Bind(TypesKt.TT(new UtilProviderKt$utilKodeinModule$1$$special$$inlined$bind$25()), null, null).with(new Provider(builder2.getContextType(), TypesKt.TT(new UtilProviderKt$utilKodeinModule$1$$special$$inlined$provider$14()), y4.c));
            builder2.Bind(TypesKt.TT(new UtilProviderKt$utilKodeinModule$1$$special$$inlined$bind$26()), null, null).with(new Provider(builder2.getContextType(), TypesKt.TT(new UtilProviderKt$utilKodeinModule$1$$special$$inlined$provider$15()), y4.d));
            builder2.Bind(TypesKt.TT(new UtilProviderKt$utilKodeinModule$1$$special$$inlined$bind$27()), null, null).with(new Provider(builder2.getContextType(), TypesKt.TT(new UtilProviderKt$utilKodeinModule$1$$special$$inlined$provider$16()), y4.e));
            builder2.Bind(TypesKt.TT(new UtilProviderKt$utilKodeinModule$1$$special$$inlined$bind$28()), null, null).with(new Provider(builder2.getContextType(), TypesKt.TT(new UtilProviderKt$utilKodeinModule$1$$special$$inlined$provider$17()), y4.f));
            builder2.Bind(TypesKt.TT(new UtilProviderKt$utilKodeinModule$1$$special$$inlined$bind$29()), null, null).with(new Provider(builder2.getContextType(), TypesKt.TT(new UtilProviderKt$utilKodeinModule$1$$special$$inlined$provider$18()), p.a));
            builder2.Bind(TypesKt.TT(new UtilProviderKt$utilKodeinModule$1$$special$$inlined$bind$30()), null, null).with(new Provider(builder2.getContextType(), TypesKt.TT(new UtilProviderKt$utilKodeinModule$1$$special$$inlined$provider$19()), r.a));
            return Unit.INSTANCE;
        }
    }

    @NotNull
    public static final Kodein.Module getUtilKodeinModule() {
        return a;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @NotNull
    public static final ThrowableWrapper throwableWrapperFactoryMethod(@NotNull String str) {
        IThrowableErrorDescriptionMapper iThrowableErrorDescriptionMapper;
        Intrinsics.checkParameterIsNotNull(str, "key");
        switch (str.hashCode()) {
            case -2002785643:
                if (str.equals("token_refresh")) {
                    iThrowableErrorDescriptionMapper = new TokenErrorDescriptionMapper();
                    break;
                }
                iThrowableErrorDescriptionMapper = new UnsupportErrorDescriptionMapper();
                break;
            case -1884274053:
                if (str.equals("storage")) {
                    iThrowableErrorDescriptionMapper = new StorageErrorDescriptionMapper();
                    break;
                }
                iThrowableErrorDescriptionMapper = new UnsupportErrorDescriptionMapper();
                break;
            case -1326197564:
                if (str.equals("domain")) {
                    iThrowableErrorDescriptionMapper = new DomainErrorDescriptionMapper();
                    break;
                }
                iThrowableErrorDescriptionMapper = new UnsupportErrorDescriptionMapper();
                break;
            case -895866265:
                if (str.equals("splash")) {
                    iThrowableErrorDescriptionMapper = new PresentationSplashErrorDescriptionMapper();
                    break;
                }
                iThrowableErrorDescriptionMapper = new UnsupportErrorDescriptionMapper();
                break;
            case -717715624:
                if (str.equals("profile_phone")) {
                    iThrowableErrorDescriptionMapper = new PresentationProfilePhoneErrorDescriptionMapper();
                    break;
                }
                iThrowableErrorDescriptionMapper = new UnsupportErrorDescriptionMapper();
                break;
            case 3052376:
                if (str.equals("chat")) {
                    iThrowableErrorDescriptionMapper = new PresentationChatErrorDescriptionMapper();
                    break;
                }
                iThrowableErrorDescriptionMapper = new UnsupportErrorDescriptionMapper();
                break;
            case 3343801:
                if (str.equals("main")) {
                    iThrowableErrorDescriptionMapper = new PresentationMainErrorDescriptionMapper();
                    break;
                }
                iThrowableErrorDescriptionMapper = new UnsupportErrorDescriptionMapper();
                break;
            case 3600386:
                if (str.equals("util")) {
                    iThrowableErrorDescriptionMapper = new UtilErrorDescriptionMapper();
                    break;
                }
                iThrowableErrorDescriptionMapper = new UnsupportErrorDescriptionMapper();
                break;
            case 105650780:
                if (str.equals(BaseAnalyticKt.ANALYTIC_MODULE_OFFER)) {
                    iThrowableErrorDescriptionMapper = new PresentationOfferErrorDescriptionMapper();
                    break;
                }
                iThrowableErrorDescriptionMapper = new UnsupportErrorDescriptionMapper();
                break;
            case 178026947:
                if (str.equals("profile_sms")) {
                    iThrowableErrorDescriptionMapper = new PresentationProfileSmsErrorDescriptionMapper();
                    break;
                }
                iThrowableErrorDescriptionMapper = new UnsupportErrorDescriptionMapper();
                break;
            case 1418742534:
                if (str.equals("bottom_navigation_sravni")) {
                    iThrowableErrorDescriptionMapper = new PresentationBottomNavivationErrorDescriptionMapper();
                    break;
                }
                iThrowableErrorDescriptionMapper = new UnsupportErrorDescriptionMapper();
                break;
            case 1843485230:
                if (str.equals("network")) {
                    iThrowableErrorDescriptionMapper = new NetworkErrorDescriptionMapper();
                    break;
                }
                iThrowableErrorDescriptionMapper = new UnsupportErrorDescriptionMapper();
                break;
            case 1950800714:
                if (str.equals("repository")) {
                    iThrowableErrorDescriptionMapper = new RepositoryErrorDescriptionMapper();
                    break;
                }
                iThrowableErrorDescriptionMapper = new UnsupportErrorDescriptionMapper();
                break;
            default:
                iThrowableErrorDescriptionMapper = new UnsupportErrorDescriptionMapper();
                break;
        }
        return new ThrowableWrapper(iThrowableErrorDescriptionMapper);
    }
}
