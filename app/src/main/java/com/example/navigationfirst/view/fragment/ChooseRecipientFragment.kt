package com.example.navigationfirst.view.fragment


import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.navigationfirst.R
import kotlinx.android.synthetic.main.fragment_choose_recipient.*


class ChooseRecipientFragment : Fragment(), View.OnClickListener {

    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_choose_recipient, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        nextButton.setOnClickListener(this)
        cancelButtonFromChooseRecipientFragment.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.nextButton -> {
                if (!TextUtils.isEmpty(inputRecipient.text.toString())) {
                    val bundle = bundleOf("recipient" to inputRecipient.text.toString())
                    navController.navigate(
                        R.id.action_chooseRecipientFragment_to_specifyAmountFragment,
                        bundle
                    )
                }
            }
            R.id.cancelButtonFromChooseRecipientFragment -> activity!!.onBackPressed()
        }
    }
}
