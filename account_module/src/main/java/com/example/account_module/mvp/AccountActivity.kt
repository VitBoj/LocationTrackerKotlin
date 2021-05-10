package com.example.account_module.mvp

import android.content.Intent
import android.os.Bundle
import android.os.Handler

import com.example.account_module.R
import com.example.account_module.databinding.ActivityAccountBinding

import dagger.android.support.DaggerAppCompatActivity

import javax.inject.Inject

class AccountActivity : DaggerAppCompatActivity(), AccountContract.View {

    @Inject
    lateinit var presenter: AccountPresenter

    private lateinit var binding: ActivityAccountBinding
    private val handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingUI()
        configurationUI()
    }

    override fun bindingUI() {
        binding = ActivityAccountBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun configurationUI() {
        binding.locationTrackingSwitch.isChecked = presenter.getSwitchBtnState()
        binding.locationTrackingSwitch.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                presenter.switchBtnOn()
            } else {
                presenter.switchBtnOff()
            }
        }
        binding.exitBtn.setOnClickListener {
            presenter.onExitBtnClicked()
        }
        binding.clearLocHistoryBtn.setOnClickListener {
            presenter.onClearLocationHistoryBtnClicked()
        }
    }

    override fun moveToLoginPage(intent: Intent) {
        startActivity(intent)
    }

    override fun showDeleteMessage() {
        binding.resMessage.text = getString(R.string.deleted)
        handler?.postDelayed({
            binding.resMessage.text = ""
        }, 2000)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finishAffinity();
    }

    override fun onDestroy() {
        super.onDestroy()
        handler?.removeCallbacksAndMessages(null)
    }


}




