package com.richzjc.test

import android.util.Log
import android.view.Gravity
import android.view.View
import com.richzjc.dialoglib.anotation.DialogAnnotation
import com.richzjc.dialoglib.base.BaseDialogFragment

@DialogAnnotation(layoutName = "medusa_dialog_user_privacy",
    gravity = Gravity.CENTER,
    cancelable = false,
    windowAnimationsName = "R.style.anim_menu_center_scale")
class Test2Dialog : BaseDialogFragment() {

    override fun doInitData() {
        Log.i("tag", "doInitData")
    }

    override fun doInitSubViews(view: View?) {
        super.doInitSubViews(view)
    }
}