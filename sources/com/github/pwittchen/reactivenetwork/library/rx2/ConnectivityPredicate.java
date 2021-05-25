package com.github.pwittchen.reactivenetwork.library.rx2;

import android.net.NetworkInfo;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Predicate;
public class ConnectivityPredicate {

    public class a implements Predicate<Connectivity> {
        public final /* synthetic */ NetworkInfo.State[] a;

        public a(NetworkInfo.State[] stateArr) {
            this.a = stateArr;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Predicate
        public boolean test(@NonNull Connectivity connectivity) throws Exception {
            Connectivity connectivity2 = connectivity;
            for (NetworkInfo.State state : this.a) {
                if (connectivity2.state() == state) {
                    return true;
                }
            }
            return false;
        }
    }

    public class b implements Predicate<Connectivity> {
        public final /* synthetic */ int[] a;

        public b(int[] iArr) {
            this.a = iArr;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Predicate
        public boolean test(@NonNull Connectivity connectivity) throws Exception {
            Connectivity connectivity2 = connectivity;
            for (int i : this.a) {
                if (connectivity2.type() == i) {
                    return true;
                }
            }
            return false;
        }
    }

    public static int[] appendUnknownNetworkTypeToTypes(int[] iArr) {
        int[] iArr2 = new int[(iArr.length + 1)];
        int i = 0;
        for (int i2 : iArr) {
            iArr2[i] = i2;
            i++;
        }
        iArr2[i] = -1;
        return iArr2;
    }

    public static Predicate<Connectivity> hasState(NetworkInfo.State... stateArr) {
        return new a(stateArr);
    }

    public static Predicate<Connectivity> hasType(int... iArr) {
        return new b(appendUnknownNetworkTypeToTypes(iArr));
    }
}
