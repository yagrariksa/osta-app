package com.main.osta_unair.ui.calcu

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.main.osta_unair.databinding.FragmentCalcuBinding

class CalcuFragment(val showBottomDialog: (String, String, String) -> Unit) : Fragment() {

    private lateinit var binding: FragmentCalcuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCalcuBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnCalcu.setOnClickListener {
            if (validateData()) {
                val usia = binding.inputUsia.text.toString()
                val berat = binding.inputBerat.text.toString()
                val tinggi = binding.inputTinggi.text.toString()

                Log.d("CALCULATE","data1: ${usia}, data2: ${berat}, data3: ${tinggi}")
                showBottomDialog(usia, berat, tinggi)
            }

        }
    }

    fun validateData(): Boolean {
        var returnal = true

        binding.tvErrorUsia.visibility = View.GONE
        binding.tvErrorBerat.visibility = View.GONE
        binding.tvErrorTinggi.visibility = View.GONE

        if (binding.inputUsia.text.toString() == "") {
            binding.tvErrorUsia.visibility = View.VISIBLE
            binding.tvErrorUsia.text = "WAJIB DI ISI"
            returnal = false
        }

        if (binding.inputBerat.text.toString() == "") {
            binding.tvErrorBerat.visibility = View.VISIBLE
            binding.tvErrorUsia.text = "WAJIB DI ISI"
            returnal = false
        }

        if (binding.inputTinggi.text.toString() == "") {
            binding.tvErrorTinggi.visibility = View.VISIBLE
            binding.tvErrorUsia.text = "WAJIB DI ISI"
            returnal = false
        }

        return returnal
    }

}