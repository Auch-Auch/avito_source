package com.facebook.imagepipeline.request;
public abstract class BaseRepeatedPostProcessor extends BasePostprocessor implements RepeatedPostprocessor {
    public RepeatedPostprocessorRunner b;

    @Override // com.facebook.imagepipeline.request.RepeatedPostprocessor
    public synchronized void setCallback(RepeatedPostprocessorRunner repeatedPostprocessorRunner) {
        this.b = repeatedPostprocessorRunner;
    }

    public void update() {
        RepeatedPostprocessorRunner repeatedPostprocessorRunner;
        synchronized (this) {
            repeatedPostprocessorRunner = this.b;
        }
        if (repeatedPostprocessorRunner != null) {
            repeatedPostprocessorRunner.update();
        }
    }
}
