package com.capstone.eratani.profile

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.capstone.eratani.LoginActivity
import com.capstone.eratani.R
import com.capstone.eratani.databinding.FragmentProfileBinding
import com.google.firebase.auth.FirebaseAuth

class ProfileFragment : Fragment() {
    private lateinit var fragmentProfileBinding: FragmentProfileBinding
    private val user = FirebaseAuth.getInstance()
    private val TAG = ProfileFragment::class.java.simpleName

    companion object {
        val EXTRA_STATUS = "extra_status"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        fragmentProfileBinding = FragmentProfileBinding.inflate(layoutInflater, container, false)
        return fragmentProfileBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        val status = arguments?.getString(EXTRA_STATUS)
//        Log.d(TAG, "haha: $status")
        var email: String? = null

        user.currentUser?.let {
            for (profile in it.providerData) {
                email = profile.email
            }

            fragmentProfileBinding.tvEmail.text = email
//            fragmentProfileBinding.tvStatus.text = status
        }


    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.logout_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.logout -> {
                user.signOut()
                val intent = Intent(requireActivity(), LoginActivity::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}