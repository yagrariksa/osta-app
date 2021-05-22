package com.main.osta_unair.ui.level

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.main.osta_unair.databinding.DialogLevelBinding
import com.main.osta_unair.model.Level

class LevelBottomSheetDialog(val item: Level): BottomSheetDialogFragment() {

    private lateinit var ddialog: Dialog
    private lateinit var binding: DialogLevelBinding

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        ddialog = super.onCreateDialog(savedInstanceState)

        /*
        ddialog.setOnShowListener {

            val bottomSheetDialog = it as BottomSheetDialog
            val parentLayout =
                bottomSheetDialog.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet)
            parentLayout?.let { it ->
                val behaviour = BottomSheetBehavior.from(it)
                setupFullHeight(it)
                behaviour.state = BottomSheetBehavior.STATE_EXPANDED
            }
        }

         */

        return ddialog
    }

    private fun setupFullHeight(bottomSheet: View) {
        val layoutParams = bottomSheet.layoutParams
        layoutParams.height = WindowManager.LayoutParams.MATCH_PARENT
        bottomSheet.layoutParams = layoutParams
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DialogLevelBinding.inflate(inflater, container, false)

        binding.tvDialogTitle.text = item.title
        binding.tvDialogDesc.text = resources.getString(item.long)

        binding.btnCloseDialog.setOnClickListener(object: View.OnClickListener{
            override fun onClick(v: View?) {
                ddialog.dismiss()
            }
        })
        return binding.root
    }


}