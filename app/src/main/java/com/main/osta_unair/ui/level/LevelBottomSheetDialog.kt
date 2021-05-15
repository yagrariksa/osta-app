package com.main.osta_unair.ui.level

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.main.osta_unair.databinding.DialogLevelBinding

class LevelBottomSheetDialog(val item: Level): BottomSheetDialogFragment() {

    private lateinit var ddialog: Dialog
    private lateinit var binding: DialogLevelBinding

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        ddialog = super.onCreateDialog(savedInstanceState)
        return ddialog
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DialogLevelBinding.inflate(inflater, container, false)

        binding.tvDialogTitle.text = item.title
        binding.tvDialogDesc.text = item.long

        binding.btnCloseDialog.setOnClickListener(object: View.OnClickListener{
            override fun onClick(v: View?) {
                ddialog.dismiss()
            }
        })
        return binding.root
    }


}