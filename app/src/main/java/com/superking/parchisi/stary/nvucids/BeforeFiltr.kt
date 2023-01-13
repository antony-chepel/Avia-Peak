package com.superking.parchisi.stary.nvucids
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.superking.parchisi.stary.R

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.superking.parchisi.stary.kxizjsu.Hoxiizxjs


import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.activityViewModel
import org.koin.core.qualifier.named


class BeforeFiltr : Fragment() {
    lateinit var okvbkkcv: String
    private lateinit var sidjsd: Context
    val icvjjicv by activityViewModel<Hoxiizxjs>(named("MainModel"))
    val sodksd: SharedPreferences by inject(named("SharedPreferences"))


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        sidjsd = context
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.gtijdfd, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val pqoksdk = sodksd.getString("apps", null)
        val cvxcjvi = sodksd.getString("appCamp", null)

        if (pqoksdk=="1" &&cvxcjvi == null) {
            icvjjicv.ioggjfjijif(sidjsd)
            icvjjicv.dsijsd.observe(viewLifecycleOwner) {

                if (it != null) {
                    okvbkkcv = it.toString()
                    sodksd.edit().putString("appCamp", okvbkkcv).apply()
                    findNavController().navigate(R.id.action_beeeeforFiiilFragment_to_fiiilttterFragment)
                }
            }
        } else {
            findNavController().navigate(R.id.action_beeeeforFiiilFragment_to_fiiilttterFragment)
        }
    }

}