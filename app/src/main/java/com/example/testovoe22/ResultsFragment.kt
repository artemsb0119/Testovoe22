package com.example.testovoe22

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class ResultsFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null

    private lateinit var textViewProc: TextView
    var kolvo = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_results, container, false)
        textViewProc = view.findViewById(R.id.textViewProc)
        val sharedPreferences = requireActivity().getSharedPreferences("my_preferences", Context.MODE_PRIVATE)
        for (i in 0..105) {
            if (sharedPreferences.getBoolean("$i", false)==true) {
                kolvo+=1
            }
        }
        val proc = (kolvo.toDouble() / 29.0) * 100.0
        val formattedProc = String.format("%.2f", proc)
        textViewProc.text = formattedProc+" %"
        return view
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ResultsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}