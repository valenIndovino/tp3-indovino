package com.example.clase3_mvc.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.findNavController
import androidx.navigation.fragment.FragmentNavigatorExtras
import com.example.clase3_mvc.R
import com.example.clase3_mvc.entities.User
import com.example.clase3_mvc.fragments.LoginFragmentDirections
import com.google.android.material.snackbar.Snackbar

class LoginFragment : Fragment() {

    lateinit var btn: Button
    lateinit var v: View
    lateinit var inputName: EditText

    val users: MutableList<User> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        users.add(User("Juan"))
        users.add(User("Valentino"))
        users.add(User("Pedro"))
        users.add(User("Agostina"))
        v = inflater.inflate(R.layout.login, container, false)
        btn = v.findViewById(R.id.button)
        inputName = v.findViewById(R.id.input)
        return v
    }

    override fun onStart() {
        super.onStart()

        btn.setOnClickListener {
            val nameTxt = inputName.getText().toString()
            var i : Int = 0
            var mismo : Boolean = false

            if (nameTxt.isNotEmpty()) {

                while(i < users.size && !mismo){
                    if (users[i].name.equals(nameTxt)) {
                        mismo = true
                        val action = LoginFragmentDirections.actionLoginFragmentToGameFragment()
                        v.findNavController().navigate(action)
                    } else {
                        Snackbar.make(v, "Nombre incorrecto", Snackbar.LENGTH_SHORT).show()
                        i += 1
                    }
                }
            } else {
                Snackbar.make(v, "Debe ingresar su nombre", Snackbar.LENGTH_SHORT).show()
            }
        }
    }

}