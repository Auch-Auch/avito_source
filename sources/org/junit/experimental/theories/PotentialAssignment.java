package org.junit.experimental.theories;

import com.avito.android.BuildConfig;
public abstract class PotentialAssignment {

    public static class CouldNotGenerateValueException extends Exception {
        private static final long serialVersionUID = 1;

        public CouldNotGenerateValueException() {
        }

        public CouldNotGenerateValueException(Throwable th) {
            super(th);
        }
    }

    public static class a extends PotentialAssignment {
        public final /* synthetic */ Object a;
        public final /* synthetic */ String b;

        public a(Object obj, String str) {
            this.a = obj;
            this.b = str;
        }

        @Override // org.junit.experimental.theories.PotentialAssignment
        public String getDescription() {
            String str;
            Object obj = this.a;
            if (obj == null) {
                str = BuildConfig.ADJUST_DEFAULT_TRACKER;
            } else {
                try {
                    str = String.format("\"%s\"", obj);
                } catch (Throwable th) {
                    str = String.format("[toString() threw %s: %s]", th.getClass().getSimpleName(), th.getMessage());
                }
            }
            return String.format("%s <from %s>", str, this.b);
        }

        @Override // org.junit.experimental.theories.PotentialAssignment
        public Object getValue() {
            return this.a;
        }

        public String toString() {
            return String.format("[%s]", this.a);
        }
    }

    public static PotentialAssignment forValue(String str, Object obj) {
        return new a(obj, str);
    }

    public abstract String getDescription() throws CouldNotGenerateValueException;

    public abstract Object getValue() throws CouldNotGenerateValueException;
}
