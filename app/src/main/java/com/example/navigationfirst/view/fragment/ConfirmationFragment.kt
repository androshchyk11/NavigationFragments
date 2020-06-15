package com.example.navigationfirst.view.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.navigationfirst.R
import com.example.navigationfirst.model.helper.Money
import kotlinx.android.synthetic.main.fragment_confirmation.*


class ConfirmationFragment : Fragment() {

    private var recipient: String? = null
    private var money: Money? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        recipient = arguments!!.getString("recipient")
        money = arguments!!.getParcelable("amount")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_confirmation, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val amount = money!!.amount
        val confirmationMessage = "You have sent $amount to $recipient"
        confirmationMessageTextView.text = confirmationMessage
    }
}
