package com.superking.parchisi.stary.kxizjsu

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.superking.parchisi.stary.R
import org.koin.androidx.viewmodel.ext.android.activityViewModel
import org.koin.core.qualifier.named

class MainFrag : Fragment() {
    private lateinit var ofkddkoodf: Context

    val bknjivb by activityViewModel<Hoxiizxjs>(named("MainModel"))

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.txuzusa, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        ofkddkoodf=context
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bknjivb.vockcvkobk(ofkddkoodf)

        findNavController().navigate(R.id.okxckoxc)

    }
}