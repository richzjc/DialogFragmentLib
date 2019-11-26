package com.richzjc.myapplication

import android.util.Log
import android.view.Gravity
import com.richzjc.dialoglib.anotation.DialogAnnotation
import com.richzjc.dialoglib.base.BaseDialogFragment

@DialogAnnotation(layoutId = R2.layout.medusa_dialog_user_privacy,
    gravity = Gravity.BOTTOM,
    cancelable = false,
    windowAnimations = R2.style.anim_menu_center_scale)
class TestDialog : BaseDialogFragment() {

    override fun doInitData() {
        Log.i("tag", "doInitData")
    }
}