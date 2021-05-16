package com.main.osta_unair.ui.news

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.main.osta_unair.databinding.DialogNewsBinding

class NewsBottomSheetDialog(val item: News) : BottomSheetDialogFragment() {

    private lateinit var binding: DialogNewsBinding
    private lateinit var ddialog: Dialog

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        ddialog = super.onCreateDialog(savedInstanceState)

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
        binding = DialogNewsBinding.inflate(inflater, container, false)

        // TODO :: Buat Glide untuk load item.img

        binding.tvDialogTitle.text = item.title
        binding.tvDialogDesc.text = item.long

        binding.btnCloseDialog.setOnClickListener {
            ddialog.dismiss()
        }

        return binding.root
    }
}