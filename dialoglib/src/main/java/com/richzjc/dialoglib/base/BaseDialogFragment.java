package com.richzjc.dialoglib.base;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;

import com.richzjc.dialoglib.callback.ICreateViewInterface;
import com.richzjc.dialoglib.model.DialogAnnotationModel;

/**
 * Created by Spark on 2016/7/4 16:28.
 */
public abstract class BaseDialogFragment extends DialogFragment implements ICreateViewInterface {

    private DialogAnnotationModel model;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        model = new DialogAnnotationModel(this);
        setStyle(DialogFragment.STYLE_NORMAL, model.getStyle());
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        dialog.getWindow().setGravity(model.getGravity());
        dialog.getWindow().setSoftInputMode(model.getSoftInputMode());

        Window window = dialog.getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.windowAnimations = model.getWindowAnimations();
        window.setAttributes(lp);

        dialog.setCancelable(model.isCancelable());
        dialog.setCanceledOnTouchOutside(model.isCancelable());
        return dialog;
    }

    public int getGravity() {
        return Gravity.BOTTOM;
    }

    @Override
    public void onStart() {
        super.onStart();
        try {
            getDialog().getWindow().setLayout(model.getDialogWidth(), model.getDialogHeight());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        LayoutInflater mInflater = LayoutInflater.from(getContext());
        mInflater = mInflater.cloneInContext(getContext());
        View containerView = mInflater.inflate(model.getLayoutId(), container, false);
        doBefore(savedInstanceState);
        doInitSubViews(containerView);
        return containerView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        doInitData();
        doAfter();
    }


    public int getStyle() {
        return 0;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
        if (onDismissListener != null) {
            onDismissListener.onDismiss(dialog);
        }
    }

    private DialogInterface.OnDismissListener onDismissListener;

    public void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.onDismissListener = onDismissListener;
    }


    @Override
    public void doBefore(Bundle savedInstanceState) {

    }

    @Override
    public ViewGroup doViewGroupRoot() {
        return null;
    }

    @Override
    public int doGetContentViewId() {
        return 0;
    }

    @Override
    public void doInitSubViews(View view) {

    }

    @Override
    public abstract void doInitData();

    @Override
    public void doAfter() {

    }

    public WindowManager.LayoutParams getLayoutParams() {
        return getDialog().getWindow().getAttributes();
    }

    public int getDialogWidth() {
        return WindowManager.LayoutParams.WRAP_CONTENT;
    }

    public int getDialogHeight() {
        return WindowManager.LayoutParams.WRAP_CONTENT;
    }

    @Override
    public void show(FragmentManager manager, String tag) {
        try {
            Context context = getContext();
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (!activity.isDestroyed() && !activity.isFinishing())
                    super.show(manager, tag);
            } else {
                super.show(manager, tag);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}