package com.ardakaplan.rdalibrary.ui.dialogs

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.ardakaplan.rdalibrary.ui.RDAActivity
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog

/**
 * Created by Arda Kaplan at 23.04.2022 - 00:48
 *
 * ardakaplan101@gmail.com
 */
abstract class RDABottomSheetDialog<W : ViewBinding>(
        activity: RDAActivity<*>
) : BottomSheetDialog(activity) {

    protected val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    protected lateinit var binding: W

    protected fun setViewBinding(viewBinding: W) {

        this.binding = viewBinding

        setContentView(viewBinding.root)
    }

    init {

        setOwnerActivity(activity)
    }

    protected fun adjustHeight(peekHeight: Int) {

        val bottomSheet: View = findViewById(com.google.android.material.R.id.design_bottom_sheet)!!

        BottomSheetBehavior.from(bottomSheet).peekHeight = peekHeight
    }

    override fun setCancelable(flag: Boolean) {
        super.setCancelable(flag)

        setCanceledOnTouchOutside(flag)
    }

    override fun onStart() {
        super.onStart()


        val bottomSheet = findViewById<View>(
                com.google.android.material.R.id.design_bottom_sheet
        )
                ?: return
        bottomSheet.setBackgroundColor(Color.TRANSPARENT)
    }
}