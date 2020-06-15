package com.example.navigationfirst.view.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.navigationfirst.R
import kotlinx.android.synthetic.main.fragment_main.*


class MainFragment : Fragment(), View.OnClickListener {

    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        viewTransactionsButton.setOnClickListener(this)
        sendMoneyButton.setOnClickListener(this)
        viewBalanceButton.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.viewTransactionsButton -> navController.navigate(R.id.action_mainFragment_to_viewTransactionFragment2)
            R.id.sendMoneyButton -> navController.navigate(R.id.action_mainFragment_to_chooseRecipientFragment)
            R.id.viewBalanceButton -> navController.navigate(R.id.action_mainFragment_to_viewBalanceFragment)
        }

    }
}
