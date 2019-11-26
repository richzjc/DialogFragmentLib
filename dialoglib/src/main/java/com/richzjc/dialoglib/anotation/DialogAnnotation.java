package com.richzjc.dialoglib.anotation;

import android.view.Gravity;
import android.view.WindowManager;

import com.richzjc.dialoglib.R2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface DialogAnnotation {
    int style() default R2.style.BaseDefaultDialog;
    int gravity() default Gravity.CENTER;
    boolean cancelable() default true;
    int softInputMode() default WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE | WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN;
    int dialogWidth() default WindowManager.LayoutParams.WRAP_CONTENT;
    int dialogHeight() default WindowManager.LayoutParams.WRAP_CONTENT;
    int layoutId() default 0;
    int windowAnimations() default 0;
}
