package com.app.fragmentsargs

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_first.view.*


class FirstFragment : Fragment() {
    private lateinit var msg: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            msg = it.getString("msg", "")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }


    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (msg.isNotEmpty())
        view.txt_second_msg.text = "First Fragment :Message from  Second Fragment is $msg"
        view.btnSendToSecond.setOnClickListener {
            val msg = view.edt_first.text.toString()
            val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(msg)
            findNavController().navigate(action)
        }
    }

}