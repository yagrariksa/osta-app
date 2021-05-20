package com.main.osta_unair.ui.calcu

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.main.osta_unair.R
import com.main.osta_unair.data.Risiko
import com.main.osta_unair.databinding.FragmentCalcuBinding
import com.main.osta_unair.model.Level
import java.util.*

class CalcuFragment(
    private val ctx: Context,
    val showBottomDialog: (String, String, String, String, Level) -> Unit
) : Fragment() {

    private lateinit var binding: FragmentCalcuBinding
    private lateinit var bulan: String
    private lateinit var kelamin: String

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
//                val usia = binding.inputUsia.text.toString()
                val usia =
                    "${binding.inputTanggal.text.toString()} ${bulan} ${binding.inputTahun.text.toString()}, umur : " + hitungUmur() + " tahun"
                val berat = binding.inputBerat.text.toString()
                val tinggi = binding.inputTinggi.text.toString()

                val risiko = Risiko()
                val level = risiko.hitung(berat.toInt(), hitungUmur())

                Log.d("CALCULATE", "data1: ${usia}, data2: ${berat}, data3: ${tinggi}")
                showBottomDialog(usia, berat, tinggi, kelamin, level)
            }

        }

        ArrayAdapter.createFromResource(
            ctx,
            R.array.month,
            R.layout.component_spinner
        ).also { adapter ->
            adapter.setDropDownViewResource(R.layout.component_spinner)
            binding.inputBulan.adapter = adapter
        }

        binding.inputBulan.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                Log.d("SPINNER", "BULAN : ${parent?.getItemAtPosition(position)}")
                bulan = parent?.getItemAtPosition(position).toString()
                binding.spinnerDisplay.text = binding.inputBulan.selectedItem.toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        binding.rbLaki.setOnClickListener {
            kelamin = "Laki-Laki"
        }
        binding.rbPerempuan.setOnClickListener {
            kelamin = "Perempuan"
        }
    }

    fun hitungUmur(): Int {
        var returnal = 0

        val c = Calendar.getInstance()
        val y = c.get(Calendar.YEAR)
        val m = c.get(Calendar.MONTH)
        val d = c.get(Calendar.DAY_OF_MONTH)
        Log.d("UMUR", "y : ${y}, m : ${m}, d : ${d}")

        val tanggal = binding.inputTanggal.text.toString().toInt()
        val tahun = binding.inputTahun.text.toString().toInt()

            val umur_tahun = y - tahun

        val umur_bulan = m - binding.inputBulan.selectedItemPosition
        if (umur_bulan < 0) {
            returnal = umur_tahun-1
        }else if (umur_bulan == 0){
            if (d-tanggal > 0) {
                returnal = umur_tahun-1
            }else{
                returnal = umur_tahun
            }
        }else {
            returnal = umur_tahun
        }

        Log.d("RESULT", "${returnal}")

        return returnal
    }

    fun validateData(): Boolean {
        var returnal = true

        binding.tvErrorUsia.visibility = View.GONE
        binding.tvErrorBerat.visibility = View.GONE
        binding.tvErrorTinggi.visibility = View.GONE
        binding.tvErrorKelamin.visibility = View.GONE

        if (binding.inputTanggal.text.toString()
                .isEmpty() || bulan.isEmpty() || binding.inputTahun.text.toString().isEmpty()
        ) {
            binding.tvErrorUsia.visibility = View.VISIBLE
            binding.tvErrorUsia.text = "Wajib di isi"
            returnal = false
        }

        val tanggal = binding.inputTanggal.text.toString().toIntOrNull()

        if (tanggal != null) {
            if (tanggal > 31) {
                binding.tvErrorUsia.visibility = View.VISIBLE
                binding.tvErrorUsia.text = "Range Tanggal adalah 1-31"
                returnal = false
            }
        }

        val tahun = binding.inputTahun.text.toString().toIntOrNull()
        if (tahun != null) {
            if (1900 > tahun) {
                binding.tvErrorUsia.visibility = View.VISIBLE
                binding.tvErrorUsia.text = "Tahun minimal adalah 1900"
                returnal = false
            }
        }


        if (binding.inputBerat.text.toString() == "") {
            binding.tvErrorBerat.visibility = View.VISIBLE
            binding.tvErrorBerat.text = "Wajib di isi"
            returnal = false
        }

        if (binding.inputTinggi.text.toString() == "") {
            binding.tvErrorTinggi.visibility = View.VISIBLE
            binding.tvErrorTinggi.text = "Wajib di isi"
            returnal = false
        }

        val idradio = binding.rgKelamin.checkedRadioButtonId
        if (idradio == -1) {
            binding.tvErrorKelamin.visibility = View.VISIBLE
            binding.tvErrorKelamin.text = "Wajib di isi"
            returnal = false
        }

        return returnal
    }

}