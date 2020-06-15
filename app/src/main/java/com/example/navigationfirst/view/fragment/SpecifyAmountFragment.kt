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
import com.example.navigationfirst.model.helper.Money
import kotlinx.android.synthetic.main.fragment_specify_amount.*
import java.math.BigDecimal


class SpecifyAmountFragment : Fragment(), View.OnClickListener {

    private lateinit var navController: NavController
    private var recipient: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        recipient = arguments!!.getString("recipient")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_specify_amount, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        sendButton.setOnClickListener(this)
        cancelButtonFromSpecifyAmountFragment.setOnClickListener(this)

        val message = "Sending money to $recipient"
        recipientTextView.text = message
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.sendButton -> {
                if (!TextUtils.isEmpty(inputAmount.text.toString())) {
                    val amount = Money(BigDecimal(inputAmount.text.toString()))
                    val bundle = bundleOf("recipient" to recipient, "amount" to amount)
                    navController.navigate(R.id.action_specifyAmountFragment_to_confirmationFragment,
                        bundle)
                }
            }

            R.id.cancelButtonFromSpecifyAmountFragment -> activity!!.onBackPressed()
        }
    }
}
