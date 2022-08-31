package com.example.clase3_mvc.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.clase3_mvc.R
import com.example.clase3_mvc.fragments.DetailFragmentArgs

class DetailFragment : Fragment() {

    companion object {
        fun newInstance() = DetailFragment()
    }

    lateinit var v: View
    lateinit var name: TextView
    lateinit var image: ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.detail, container, false)
        return v
    }

    override fun onStart() {
        super.onStart()

        val gameName = DetailFragmentArgs.fromBundle(requireArguments()).gameName
        val imageUrl = DetailFragmentArgs.fromBundle(requireArguments()).imageUrl

        name = v.findViewById(R.id.name)
        image = v.findViewById(R.id.gameImage)
        name.text = gameName

        Glide
            .with(v)
            .load(imageUrl)
            .centerCrop()
            .into(image);

    }


}