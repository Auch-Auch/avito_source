package hu.akarnokd.rxjava3.functions;

import io.reactivex.rxjava3.functions.BiConsumer;
import io.reactivex.rxjava3.functions.Consumer;
public final class FunctionsEx {

    public enum a implements Consumer, BiConsumer, Consumer3, Consumer4, Consumer5, Consumer6, Consumer7, Consumer8, Consumer9 {
        INSTANCE;

        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Object obj) throws Exception {
        }

        @Override // io.reactivex.rxjava3.functions.BiConsumer
        public void accept(Object obj, Object obj2) throws Exception {
        }

        @Override // hu.akarnokd.rxjava3.functions.Consumer3
        public void accept(Object obj, Object obj2, Object obj3) throws Exception {
        }

        @Override // hu.akarnokd.rxjava3.functions.Consumer4
        public void accept(Object obj, Object obj2, Object obj3, Object obj4) throws Exception {
        }

        @Override // hu.akarnokd.rxjava3.functions.Consumer5
        public void accept(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) throws Exception {
        }

        @Override // hu.akarnokd.rxjava3.functions.Consumer6
        public void accept(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) throws Exception {
        }

        @Override // hu.akarnokd.rxjava3.functions.Consumer7
        public void accept(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7) throws Exception {
        }

        @Override // hu.akarnokd.rxjava3.functions.Consumer8
        public void accept(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8) throws Exception {
        }

        @Override // hu.akarnokd.rxjava3.functions.Consumer9
        public void accept(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9) throws Exception {
        }
    }

    public FunctionsEx() {
        throw new IllegalStateException("No instances!");
    }

    public static <T extends Consumer<Object> & BiConsumer<Object, Object> & Consumer3<Object, Object, Object> & Consumer4<Object, Object, Object, Object> & Consumer5<Object, Object, Object, Object, Object> & Consumer6<Object, Object, Object, Object, Object, Object> & Consumer7<Object, Object, Object, Object, Object, Object, Object> & Consumer8<Object, Object, Object, Object, Object, Object, Object, Object> & Consumer9<Object, Object, Object, Object, Object, Object, Object, Object, Object>> T emptyConsumer() {
        return a.INSTANCE;
    }
}
