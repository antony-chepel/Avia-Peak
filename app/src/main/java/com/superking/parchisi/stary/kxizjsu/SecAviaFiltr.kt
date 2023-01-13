package com.superking.parchisi.stary.kxizjsu

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.superking.parchisi.stary.R
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.activityViewModel
import org.koin.core.qualifier.named


class SecAviaFiltr : Fragment() {
    private lateinit var xcjijzi: Context
    val sdjdsi: SharedPreferences by inject(named("SharedPreferences"))
    lateinit var rokeoslpdl: String
    val ovckvcjicv by activityViewModel<Hoxiizxjs>(named("MainModel"))
    lateinit var rokdfko: String
    lateinit var obkvvbjvbj: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.yodsij, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        xcjijzi = context
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ovckvcjicv.xkccxzji.observe(viewLifecycleOwner) {
            if (it != null) {
                val main = it.toString()
                sdjdsi.edit().putString("mainId", main).apply()
            }
        }

        ovckvcjicv.xicjx.observe(viewLifecycleOwner) {
            if (it != null) {

                rokdfko = it.ofkokovc
                rokeoslpdl = it.ibjvvbokvb
                obkvvbjvbj = it.qosjijid

                sdjdsi.edit().putString("countryDev", rokdfko).apply()
                sdjdsi.edit().putString("apps", rokeoslpdl).apply()
                sdjdsi.edit().putString("wv", obkvvbjvbj).apply()

                findNavController().navigate(R.id.ockvkcovbjiuhsdhusd)
            }
        }
    }
}