package com.facebook.imagepipeline.systrace;

import javax.annotation.Nullable;
public class FrescoSystrace {
    public static final ArgsBuilder NO_OP_ARGS_BUILDER = new b(null);
    @Nullable
    public static volatile Systrace a;

    public interface ArgsBuilder {
        ArgsBuilder arg(String str, double d);

        ArgsBuilder arg(String str, int i);

        ArgsBuilder arg(String str, long j);

        ArgsBuilder arg(String str, Object obj);

        void flush();
    }

    public interface Systrace {
        void beginSection(String str);

        ArgsBuilder beginSectionWithArgs(String str);

        void endSection();

        boolean isTracing();
    }

    public static final class b implements ArgsBuilder {
        public b(a aVar) {
        }

        @Override // com.facebook.imagepipeline.systrace.FrescoSystrace.ArgsBuilder
        public ArgsBuilder arg(String str, double d) {
            return this;
        }

        @Override // com.facebook.imagepipeline.systrace.FrescoSystrace.ArgsBuilder
        public ArgsBuilder arg(String str, int i) {
            return this;
        }

        @Override // com.facebook.imagepipeline.systrace.FrescoSystrace.ArgsBuilder
        public ArgsBuilder arg(String str, long j) {
            return this;
        }

        @Override // com.facebook.imagepipeline.systrace.FrescoSystrace.ArgsBuilder
        public ArgsBuilder arg(String str, Object obj) {
            return this;
        }

        @Override // com.facebook.imagepipeline.systrace.FrescoSystrace.ArgsBuilder
        public void flush() {
        }
    }

    public static Systrace a() {
        if (a == null) {
            synchronized (FrescoSystrace.class) {
                if (a == null) {
                    a = new DefaultFrescoSystrace();
                }
            }
        }
        return a;
    }

    public static void beginSection(String str) {
        a().beginSection(str);
    }

    public static ArgsBuilder beginSectionWithArgs(String str) {
        return a().beginSectionWithArgs(str);
    }

    public static void endSection() {
        a().endSection();
    }

    public static boolean isTracing() {
        return a().isTracing();
    }

    public static void provide(Systrace systrace) {
        a = systrace;
    }
}
