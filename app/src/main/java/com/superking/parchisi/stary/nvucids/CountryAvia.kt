package com.superking.parchisi.stary.nvucids

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.superking.parchisi.stary.R
import com.superking.parchisi.stary.kxizjsu.Hoxiizxjs
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.activityViewModel
import org.koin.core.qualifier.named

class CountryAvia : Fragment() {

    val ckoxkoxkoxcko by activityViewModel<Hoxiizxjs>(named("MainModel"))
    private lateinit var cioxzji: Context


    val pqkosd: SharedPreferences by inject(named("SharedPreferences"))


    lateinit var xczijcxz: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.lodissw, container, false)
    }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        cioxzji = context
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ckoxkoxkoxcko.xcjnc.observe(viewLifecycleOwner) {
            if (it!=null) {
                xczijcxz = it.okcvkocv
                pqkosd.edit().putString("country", xczijcxz).apply()
                findNavController().navigate(R.id.bovkovvds)
            }
        }
    }
}