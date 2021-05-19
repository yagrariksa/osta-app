package com.main.osta_unair.ui.calcu

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.main.osta_unair.R
import com.main.osta_unair.Risiko
import com.main.osta_unair.databinding.DialogCalcuBinding
import com.main.osta_unair.databinding.DialogResultCalcuBinding
import com.main.osta_unair.ui.level.Level

class CalcuBottomSheetDialog(val usia: String, val berat: String, val tinggi: String, val kelamin: String, val level: Level, private val readmore: () -> Unit) :
    BottomSheetDialogFragment() {

    private lateinit var newbinding: DialogResultCalcuBinding
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
        newbinding = DialogResultCalcuBinding.inflate(inflater, container, false)

        newbinding.root.setBackgroundColor(resources.getColor(level.color))

        newbinding.dialogSubtitleResult.text = level.title
        newbinding.tvResultExpl.text = resources.getString(level.expl)
        newbinding.tvResultSaran.text = resources.getString(level.saran)

        newbinding.tvResultUsia.text = usia
        newbinding.tvResultBerat.text = berat + " kg"
        newbinding.tvResultTinggi.text = tinggi + " cm"
        newbinding.tvResultKelamin.text = kelamin

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