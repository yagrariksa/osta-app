package com.main.osta_unair.ui.calcu

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.main.osta_unair.R
import com.main.osta_unair.databinding.DialogCalcuBinding
import com.main.osta_unair.databinding.DialogResultCalcuBinding

class CalcuBottomSheetDialog(val usia: String, val berat: String, val tinggi: String, private val readmore: () -> Unit) :
    BottomSheetDialogFragment() {

    private lateinit var newbinding: DialogResultCalcuBinding
    private lateinit var ddialog: Dialog

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        ddialog = super.onCreateDialog(savedInstanceState)
        return ddialog
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        newbinding = DialogResultCalcuBinding.inflate(inflater, container, false)

        newbinding.root.setBackgroundColor(resources.getColor(R.color.result_green))

        newbinding.tvResultUsia.text = usia + " tahun"
        newbinding.tvResultBerat.text = berat + " kg"
        newbinding.tvResultTinggi.text = tinggi + " cm"

        newbinding.modalCloseBtn.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                ddialog.dismiss()
            }
        })

        newbinding.btnReadMore.setOnClickListener {
            ddialog.dismiss()
            readmore()
        }
        return newbinding.root
    }


}