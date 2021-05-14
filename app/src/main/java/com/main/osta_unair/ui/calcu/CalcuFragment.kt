package com.main.osta_unair.ui.calcu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.main.osta_unair.databinding.FragmentCalcuBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CalcuFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CalcuFragment(val showBottomDialog: (String, String, String) -> Unit) : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null


    private lateinit var calcuBinding: FragmentCalcuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        calcuBinding = FragmentCalcuBinding.inflate(inflater, container, false)
        return calcuBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        calcuBinding.btnCalcu.setOnClickListener {
            val data1 = calcuBinding.inputUsia.text.toString()
            val data2 = calcuBinding.inputBerat.text.toString()
            val data3 = calcuBinding.inputTinggi.text.toString()
            showBottomDialog(data1,data2,data3)
        }

    }

}