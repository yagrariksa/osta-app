package com.main.osta_unair.ui.calcu

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.main.osta_unair.databinding.DialogCalcuBinding
import com.main.osta_unair.databinding.DialogResultCalcuBinding

class CalcuBottomSheetDialog(val data1: String, val data2: String, val data3: String) :
    Fragment() {

    private lateinit var binding: DialogCalcuBinding
    private lateinit var newbinding: DialogResultCalcuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DialogCalcuBinding.inflate(inflater, container, false)
        newbinding = DialogResultCalcuBinding.inflate(inflater, container, false)
        /*
        binding.tvUmur.text = data1
        binding.tvBerat.text = data2
        binding.tvTinggi.text = data3


        binding.include.btnCloseDialog.setOnClickListener {
            onStop()
        }

        return binding.root

         */
        return newbinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }


}